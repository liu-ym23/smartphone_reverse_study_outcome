package com.bytedance.android.ec.local.api;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/local/api/ErrorType;", "", "", "value", "I", "getValue", "()I", "ERROR", "WARING", HTTP.NOTIFY, "DEFAULT", "ec-local-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorType extends Enum<ErrorType> {
    public static final ErrorType DEFAULT = null;
    public static final ErrorType ERROR = null;
    public static final ErrorType NOTIFY = null;
    public static final ErrorType WARING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorType[] f47844a = null;
    private final int value;

    static {
        ErrorType r100 = new ErrorType("ERROR", 0, 2);
        ERROR = r100;
        ErrorType r101 = new ErrorType("WARING", 1, 1);
        WARING = r101;
        ErrorType r102 = new ErrorType(HTTP.NOTIFY, 2, 0);
        NOTIFY = r102;
        ErrorType r103 = new ErrorType("DEFAULT", 3, -1);
        DEFAULT = r103;
        f47844a = new ErrorType[]{r100, r101, r102, r103};
    }

    public static ErrorType valueOf(String r100) {
        return (ErrorType) a.a(ErrorType.class, r100);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) f47844a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ErrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
