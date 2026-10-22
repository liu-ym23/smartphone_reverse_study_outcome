package com.bytedance.android.shopping.feed.event;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;

/* JADX INFO: loaded from: classes13.dex */
public final class g1 extends com.bytedance.android.ec.core.event.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f174729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f174730b;

    public static final class a {
    }

    static {
    }

    public g1() {
        super("ec_inner_feed_card_not_show");
    }

    @Override // com.bytedance.android.ec.core.event.a
    public final void buildParams() {
        Integer r100 = this.f174730b;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();
        com.bytedance.android.ec.core.event.a.b.C0794a.C0795a r103 = com.bytedance.android.ec.core.event.a.b.C0794a.f44003a;
        appendParam(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r102, r103);
        Integer r104 = this.f174729a;
        if (r104 == null) goto L9;
        r101 = String.valueOf(r104.intValue());
    L9:
        appendParam(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION, r101, r103);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
