package com.bytedance.android.gamecp.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/base/Result;", "", "", "value", "I", "getValue", "()I", "SUCCESS", "FAIL", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Result extends Enum<Result> {
    public static final Result FAIL = null;
    public static final Result SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Result[] f51373a = null;
    private final int value;

    static {
        Result r100 = new Result("SUCCESS", 0, 1);
        SUCCESS = r100;
        Result r101 = new Result("FAIL", 1, 0);
        FAIL = r101;
        f51373a = new Result[]{r100, r101};
    }

    public static Result valueOf(String r100) {
        return (Result) a.a(Result.class, r100);
    }

    public static Result[] values() {
        return (Result[]) f51373a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public Result(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
