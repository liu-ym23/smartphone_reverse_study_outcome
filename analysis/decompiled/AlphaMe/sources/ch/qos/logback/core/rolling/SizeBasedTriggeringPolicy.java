package ch.qos.logback.core.rolling;

import ch.qos.logback.core.util.FileSize;
import ch.qos.logback.core.util.InvocationGate;
import java.io.File;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes.dex */
public class SizeBasedTriggeringPolicy<E> extends TriggeringPolicyBase<E> {
    public static final long DEFAULT_MAX_FILE_SIZE = 10485760;
    public static final String SEE_SIZE_FORMAT = "http://logback.qos.ch/codes.html#sbtp_size_format";
    FileSize maxFileSize;
    String maxFileSizeAsString = Long.toString(DEFAULT_MAX_FILE_SIZE);
    private InvocationGate invocationGate = new InvocationGate();

    public SizeBasedTriggeringPolicy() {
    }

    public String getMaxFileSize() {
        return this.maxFileSizeAsString;
    }

    @Override // ch.qos.logback.core.rolling.TriggeringPolicy
    public boolean isTriggeringEvent(File file, E e4) {
        if (this.invocationGate.skipFurtherWork()) {
            return false;
        }
        this.invocationGate.updateMaskIfNecessary(System.currentTimeMillis());
        return file.length() >= this.maxFileSize.getSize();
    }

    public void setMaxFileSize(String str) {
        this.maxFileSizeAsString = str;
        this.maxFileSize = FileSize.valueOf(str);
    }

    public long toFileSize(String str) {
        long j4;
        if (str == null) {
            return DEFAULT_MAX_FILE_SIZE;
        }
        String upperCase = str.trim().toUpperCase();
        int iIndexOf = upperCase.indexOf("KB");
        if (iIndexOf != -1) {
            upperCase = upperCase.substring(0, iIndexOf);
            j4 = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        } else {
            int iIndexOf2 = upperCase.indexOf("MB");
            if (iIndexOf2 != -1) {
                upperCase = upperCase.substring(0, iIndexOf2);
                j4 = 1048576;
            } else {
                int iIndexOf3 = upperCase.indexOf("GB");
                if (iIndexOf3 != -1) {
                    upperCase = upperCase.substring(0, iIndexOf3);
                    j4 = 1073741824;
                } else {
                    j4 = 1;
                }
            }
        }
        if (upperCase != null) {
            try {
                return Long.valueOf(upperCase).longValue() * j4;
            } catch (NumberFormatException e4) {
                this.addError("[" + upperCase + "] is not in proper int format. Please refer to http://logback.qos.ch/codes.html#sbtp_size_format");
                this.addError("[" + str + "] not in expected format.", e4);
            }
        }
        return DEFAULT_MAX_FILE_SIZE;
    }

    public SizeBasedTriggeringPolicy(String str) {
        setMaxFileSize(str);
    }
}
