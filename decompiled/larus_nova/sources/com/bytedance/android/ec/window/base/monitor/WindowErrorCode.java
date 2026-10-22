package com.bytedance.android.ec.window.base.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/window/base/monitor/WindowErrorCode;", "", "", "code", "I", "getCode", "()I", "ERROR_CODE_LOAD_SCHEMA", "NATIVE_COMMON", "HYBRID_BUNDLE_URL_EMPTY", "HYBRID_DATA_EMPTY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowErrorCode extends Enum<WindowErrorCode> {
    public static final WindowErrorCode ERROR_CODE_LOAD_SCHEMA = null;
    public static final WindowErrorCode HYBRID_BUNDLE_URL_EMPTY = null;
    public static final WindowErrorCode HYBRID_DATA_EMPTY = null;
    public static final WindowErrorCode NATIVE_COMMON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowErrorCode[] f49338a = null;
    private final int code;

    static {
        WindowErrorCode r100 = new WindowErrorCode("ERROR_CODE_LOAD_SCHEMA", 0, 201);
        ERROR_CODE_LOAD_SCHEMA = r100;
        WindowErrorCode r101 = new WindowErrorCode("NATIVE_COMMON", 1, 301);
        NATIVE_COMMON = r101;
        WindowErrorCode r102 = new WindowErrorCode("HYBRID_BUNDLE_URL_EMPTY", 2, 401);
        HYBRID_BUNDLE_URL_EMPTY = r102;
        WindowErrorCode r103 = new WindowErrorCode("HYBRID_DATA_EMPTY", 3, 402);
        HYBRID_DATA_EMPTY = r103;
        f49338a = new WindowErrorCode[]{r100, r101, r102, r103};
    }

    public static WindowErrorCode valueOf(String r100) {
        return (WindowErrorCode) a.a(WindowErrorCode.class, r100);
    }

    public static WindowErrorCode[] values() {
        return (WindowErrorCode[]) f49338a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public WindowErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
