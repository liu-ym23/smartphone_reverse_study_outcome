package com.bytedance.android.ec.window.base.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/window/base/monitor/WindowErrorDomain;", "", "", "code", "I", "getCode", "()I", "NET", "CONTAINER", "NATIVE", "HYBRID_DATA_CHECK", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowErrorDomain extends Enum<WindowErrorDomain> {
    public static final WindowErrorDomain CONTAINER = null;
    public static final WindowErrorDomain HYBRID_DATA_CHECK = null;
    public static final WindowErrorDomain NATIVE = null;
    public static final WindowErrorDomain NET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowErrorDomain[] f49339a = null;
    private final int code;

    static {
        WindowErrorDomain r100 = new WindowErrorDomain("NET", 0, 100);
        NET = r100;
        WindowErrorDomain r101 = new WindowErrorDomain("CONTAINER", 1, 200);
        CONTAINER = r101;
        WindowErrorDomain r102 = new WindowErrorDomain("NATIVE", 2, 300);
        NATIVE = r102;
        WindowErrorDomain r103 = new WindowErrorDomain("HYBRID_DATA_CHECK", 3, 400);
        HYBRID_DATA_CHECK = r103;
        f49339a = new WindowErrorDomain[]{r100, r101, r102, r103};
    }

    public static WindowErrorDomain valueOf(String r100) {
        return (WindowErrorDomain) a.a(WindowErrorDomain.class, r100);
    }

    public static WindowErrorDomain[] values() {
        return (WindowErrorDomain[]) f49339a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public WindowErrorDomain(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
