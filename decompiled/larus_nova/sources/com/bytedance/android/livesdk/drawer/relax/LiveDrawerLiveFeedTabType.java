package com.bytedance.android.livesdk.drawer.relax;

import com.ss.android.ugc.effectmanager.common.EffectTypeConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerLiveFeedTabType;", "", "", "value", "J", "getValue", "()J", "Recommend", "Follow", "City", "Goods", "Selected", "Sold", EffectTypeConstants.TYPE_GAME, "Chat", "Voice", "Music", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerLiveFeedTabType extends Enum<LiveDrawerLiveFeedTabType> {
    public static final LiveDrawerLiveFeedTabType Chat = null;
    public static final LiveDrawerLiveFeedTabType City = null;
    public static final LiveDrawerLiveFeedTabType Follow = null;
    public static final LiveDrawerLiveFeedTabType Game = null;
    public static final LiveDrawerLiveFeedTabType Goods = null;
    public static final LiveDrawerLiveFeedTabType Music = null;
    public static final LiveDrawerLiveFeedTabType Recommend = null;
    public static final LiveDrawerLiveFeedTabType Selected = null;
    public static final LiveDrawerLiveFeedTabType Sold = null;
    public static final LiveDrawerLiveFeedTabType Voice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDrawerLiveFeedTabType[] f122499a = null;
    private final long value;

    public static LiveDrawerLiveFeedTabType valueOf(String r100) {
        return (LiveDrawerLiveFeedTabType) r27.a.a(LiveDrawerLiveFeedTabType.class, r100);
    }

    public static LiveDrawerLiveFeedTabType[] values() {
        return (LiveDrawerLiveFeedTabType[]) f122499a.clone();
    }

    static {
        LiveDrawerLiveFeedTabType r100 = new LiveDrawerLiveFeedTabType("Recommend", 0, 1);
        Recommend = r100;
        LiveDrawerLiveFeedTabType r101 = new LiveDrawerLiveFeedTabType("Follow", 1, 2);
        Follow = r101;
        LiveDrawerLiveFeedTabType r102 = new LiveDrawerLiveFeedTabType("City", 2, 3);
        City = r102;
        LiveDrawerLiveFeedTabType r103 = new LiveDrawerLiveFeedTabType("Goods", 3, 4);
        Goods = r103;
        LiveDrawerLiveFeedTabType r104 = new LiveDrawerLiveFeedTabType("Selected", 4, 5);
        Selected = r104;
        LiveDrawerLiveFeedTabType r105 = new LiveDrawerLiveFeedTabType("Sold", 5, 11);
        Sold = r105;
        LiveDrawerLiveFeedTabType r106 = new LiveDrawerLiveFeedTabType(EffectTypeConstants.TYPE_GAME, 6, 12);
        Game = r106;
        LiveDrawerLiveFeedTabType r107 = new LiveDrawerLiveFeedTabType("Chat", 7, 13);
        Chat = r107;
        LiveDrawerLiveFeedTabType r108 = new LiveDrawerLiveFeedTabType("Voice", 8, 14);
        Voice = r108;
        LiveDrawerLiveFeedTabType r109 = new LiveDrawerLiveFeedTabType("Music", 9, 15);
        Music = r109;
        f122499a = new LiveDrawerLiveFeedTabType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerLiveFeedTabType(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
