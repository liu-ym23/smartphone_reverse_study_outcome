package com.bytedance.android.live.revlink.impl.pk.feedview.entrance;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/feedview/entrance/PkFeedEntrance;", "", "ImCardLive", "SearchCard", "FullCard", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkFeedEntrance extends Enum<PkFeedEntrance> {
    public static final PkFeedEntrance FullCard = null;
    public static final PkFeedEntrance ImCardLive = null;
    public static final PkFeedEntrance SearchCard = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkFeedEntrance[] f96478a = null;

    static {
        PkFeedEntrance r100 = new PkFeedEntrance("ImCardLive", 0);
        ImCardLive = r100;
        PkFeedEntrance r101 = new PkFeedEntrance("SearchCard", 1);
        SearchCard = r101;
        PkFeedEntrance r102 = new PkFeedEntrance("FullCard", 2);
        FullCard = r102;
        f96478a = new PkFeedEntrance[]{r100, r101, r102};
    }

    public static PkFeedEntrance valueOf(String r100) {
        return (PkFeedEntrance) a.a(PkFeedEntrance.class, r100);
    }

    public static PkFeedEntrance[] values() {
        return (PkFeedEntrance[]) f96478a.clone();
    }

    public PkFeedEntrance(String r100, int r101) {
        super(r100, r101);
    }
}
