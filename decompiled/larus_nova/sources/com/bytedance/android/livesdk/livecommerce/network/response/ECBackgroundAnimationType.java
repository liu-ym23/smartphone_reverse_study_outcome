package com.bytedance.android.livesdk.livecommerce.network.response;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECBackgroundAnimationType;", "", "", "type", "I", "getType", "()I", "NUMBER", "INFINITE", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECBackgroundAnimationType extends Enum<ECBackgroundAnimationType> {
    public static final ECBackgroundAnimationType INFINITE = null;
    public static final ECBackgroundAnimationType NUMBER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECBackgroundAnimationType[] f149499a = null;
    private final int type;

    static {
        ECBackgroundAnimationType r100 = new ECBackgroundAnimationType("NUMBER", 0, 1);
        NUMBER = r100;
        ECBackgroundAnimationType r101 = new ECBackgroundAnimationType("INFINITE", 1, 2);
        INFINITE = r101;
        f149499a = new ECBackgroundAnimationType[]{r100, r101};
    }

    public static ECBackgroundAnimationType valueOf(String r100) {
        return (ECBackgroundAnimationType) a.a(ECBackgroundAnimationType.class, r100);
    }

    public static ECBackgroundAnimationType[] values() {
        return (ECBackgroundAnimationType[]) f149499a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ECBackgroundAnimationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
