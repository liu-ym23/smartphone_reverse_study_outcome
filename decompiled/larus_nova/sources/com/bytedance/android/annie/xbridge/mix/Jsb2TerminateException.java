package com.bytedance.android.annie.xbridge.mix;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u000b2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\tR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/Jsb2TerminateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie_release"}, k = 1, mv = {1, 4, 3})
public final class Jsb2TerminateException extends Exception {
    public static final int CODE_FAILED = 0;
    public static final a Companion = null;
    private int code;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    public Jsb2TerminateException(int r100) {
        this.code = r100;
    }

    public final void setCode(int r100) {
        this.code = r100;
    }
}
