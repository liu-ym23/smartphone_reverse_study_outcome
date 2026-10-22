package w6;

import com.stepos.cloud.securedata.SecureDataEnvironment;

/* loaded from: classes.dex */
public abstract /* synthetic */ class n {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[SecureDataEnvironment.values().length];
        try {
            iArr[SecureDataEnvironment.TEST.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[SecureDataEnvironment.PROD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
