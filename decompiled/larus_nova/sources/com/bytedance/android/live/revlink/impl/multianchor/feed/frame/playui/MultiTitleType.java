package com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/feed/frame/playui/MultiTitleType;", "", "VOTE", "PK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiTitleType extends Enum<MultiTitleType> {
    public static final MultiTitleType PK = null;
    public static final MultiTitleType VOTE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiTitleType[] f94187a = null;

    static {
        MultiTitleType r100 = new MultiTitleType("VOTE", 0);
        VOTE = r100;
        MultiTitleType r101 = new MultiTitleType("PK", 1);
        PK = r101;
        f94187a = new MultiTitleType[]{r100, r101};
    }

    public static MultiTitleType valueOf(String r100) {
        return (MultiTitleType) r27.a.a(MultiTitleType.class, r100);
    }

    public static MultiTitleType[] values() {
        return (MultiTitleType[]) f94187a.clone();
    }

    public MultiTitleType(String r100, int r101) {
        super(r100, r101);
    }
}
