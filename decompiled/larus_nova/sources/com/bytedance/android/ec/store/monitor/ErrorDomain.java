package com.bytedance.android.ec.store.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/monitor/ErrorDomain;", "", "", "code", "I", "getCode", "()I", "NET", "CONTAINER", "NATIVE", "HYBRID_DATA_CHECK", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorDomain extends Enum<ErrorDomain> {
    public static final ErrorDomain CONTAINER = null;
    public static final ErrorDomain HYBRID_DATA_CHECK = null;
    public static final ErrorDomain NATIVE = null;
    public static final ErrorDomain NET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorDomain[] f48260a = null;
    private final int code;

    static {
        ErrorDomain r100 = new ErrorDomain("NET", 0, 100);
        NET = r100;
        ErrorDomain r101 = new ErrorDomain("CONTAINER", 1, 200);
        CONTAINER = r101;
        ErrorDomain r102 = new ErrorDomain("NATIVE", 2, 300);
        NATIVE = r102;
        ErrorDomain r103 = new ErrorDomain("HYBRID_DATA_CHECK", 3, 400);
        HYBRID_DATA_CHECK = r103;
        f48260a = new ErrorDomain[]{r100, r101, r102, r103};
    }

    public static ErrorDomain valueOf(String r100) {
        return (ErrorDomain) a.a(ErrorDomain.class, r100);
    }

    public static ErrorDomain[] values() {
        return (ErrorDomain[]) f48260a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public ErrorDomain(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
