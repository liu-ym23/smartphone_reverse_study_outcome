package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/utils/GiftNitaViewInfo;", "", "Lzo2/a;", "", "getResId", "()I", "resId", "", "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_VIEW_GIFT_FAST_V3", "TTLIVE_VIEW_GIFT_NORMAL_V3", "TTLIVE_VIEW_GIFT_NORMAL_V3_PK", "TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GiftNitaViewInfo extends Enum<GiftNitaViewInfo> implements zo2.a {
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_FAST_V3 = null;
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT = null;
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_NORMAL_V3 = null;
    public static final GiftNitaViewInfo TTLIVE_VIEW_GIFT_NORMAL_V3_PK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GiftNitaViewInfo[] f132016a = null;

    static {
        GiftNitaViewInfo r100 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_FAST_V3", 0);
        TTLIVE_VIEW_GIFT_FAST_V3 = r100;
        GiftNitaViewInfo r101 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_NORMAL_V3", 1);
        TTLIVE_VIEW_GIFT_NORMAL_V3 = r101;
        GiftNitaViewInfo r102 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_NORMAL_V3_PK", 2);
        TTLIVE_VIEW_GIFT_NORMAL_V3_PK = r102;
        GiftNitaViewInfo r103 = new GiftNitaViewInfo("TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT", 3);
        TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT = r103;
        f132016a = new GiftNitaViewInfo[]{r100, r101, r102, r103};
    }

    public static GiftNitaViewInfo valueOf(String r100) {
        return (GiftNitaViewInfo) r27.a.a(GiftNitaViewInfo.class, r100);
    }

    public static GiftNitaViewInfo[] values() {
        return (GiftNitaViewInfo[]) f132016a.clone();
    }

    @Override // zo2.a
    public int getType() {
        return 0;
    }

    @Override // zo2.a
    public int getCount() {
        int r100 = n.f132055b[ordinal()];
        if (r100 != 1) goto L5;
        return 1;
    L5:
        if (r100 != 2) goto L7;
    L13:
        return 2;
    L7:
        if (r100 == 3) goto L13;
        if (r100 != 4) goto L12;
        return 1;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // zo2.a
    public int getResId() {
        int r100 = n.f132054a[ordinal()];
        if (r100 != 1) goto L5;
        return R.layout.ttlive_view_fast_gift_v3;
    L5:
        if (r100 != 2) goto L7;
        return R.layout.ttlive_view_gift_normal_v3;
    L7:
        if (r100 != 3) goto L9;
        return R.layout.ttlive_view_gift_normal_v3_pk;
    L9:
        if (r100 != 4) goto L12;
        return R.layout.ttlive_view_gift_normal_v2_landscape_spilt;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // zo2.a
    public String getTag() {
        return name();
    }

    public GiftNitaViewInfo(String r100, int r101) {
        super(r100, r101);
    }
}
