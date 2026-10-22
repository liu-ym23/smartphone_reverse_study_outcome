package com.bytedance.android.live.ktv.common.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/KtvMode;", "", "", "Mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "SOLO_KTV", "LIVE_KTV", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvMode extends Enum<KtvMode> {
    public static final KtvMode LIVE_KTV = null;
    public static final KtvMode SOLO_KTV = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KtvMode[] f69981a = null;
    private final String Mode;

    static {
        KtvMode r100 = new KtvMode("SOLO_KTV", 0, "SoloKtv");
        SOLO_KTV = r100;
        KtvMode r101 = new KtvMode("LIVE_KTV", 1, "LiveKtv");
        LIVE_KTV = r101;
        f69981a = new KtvMode[]{r100, r101};
    }

    public static KtvMode valueOf(String r100) {
        return (KtvMode) a.a(KtvMode.class, r100);
    }

    public static KtvMode[] values() {
        return (KtvMode[]) f69981a.clone();
    }

    public final String getMode() {
        return this.Mode;
    }

    public KtvMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.Mode = r102;
    }
}
