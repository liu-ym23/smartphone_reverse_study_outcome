package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.shopping.buynow.data.model.RequestErrorType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveSearchErrorType;", "", "", "value", "J", "getValue", "()J", "None", "NoLogin", "ResultEmpty", RequestErrorType.NETWORK_ERROR, "HitLimit", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveSearchErrorType extends Enum<LiveSearchErrorType> {
    public static final LiveSearchErrorType HitLimit = null;
    public static final LiveSearchErrorType NetworkError = null;
    public static final LiveSearchErrorType NoLogin = null;
    public static final LiveSearchErrorType None = null;
    public static final LiveSearchErrorType ResultEmpty = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveSearchErrorType[] f122539a = null;
    private final long value;

    static {
        LiveSearchErrorType r100 = new LiveSearchErrorType("None", 0, 0);
        None = r100;
        LiveSearchErrorType r101 = new LiveSearchErrorType("NoLogin", 1, 1);
        NoLogin = r101;
        LiveSearchErrorType r102 = new LiveSearchErrorType("ResultEmpty", 2, 2);
        ResultEmpty = r102;
        LiveSearchErrorType r103 = new LiveSearchErrorType(RequestErrorType.NETWORK_ERROR, 3, 3);
        NetworkError = r103;
        LiveSearchErrorType r104 = new LiveSearchErrorType("HitLimit", 4, 4);
        HitLimit = r104;
        f122539a = new LiveSearchErrorType[]{r100, r101, r102, r103, r104};
    }

    public static LiveSearchErrorType valueOf(String r100) {
        return (LiveSearchErrorType) r27.a.a(LiveSearchErrorType.class, r100);
    }

    public static LiveSearchErrorType[] values() {
        return (LiveSearchErrorType[]) f122539a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public LiveSearchErrorType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
