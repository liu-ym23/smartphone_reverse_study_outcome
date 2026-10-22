package com.bytedance.android.live.room.util;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/room/util/AudienceViewInfo;", "", "Lzo2/a;", "", "getResId", "()I", "resId", "", "getTag", "()Ljava/lang/String;", "tag", "getCount", "count", "getType", "type", "TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE", "TTLIVE_VIEW_AUDIENCE_LIST_ITEM", "TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudienceViewInfo extends Enum<AudienceViewInfo> implements zo2.a {
    public static final AudienceViewInfo TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW = null;
    public static final AudienceViewInfo TTLIVE_VIEW_AUDIENCE_LIST_ITEM = null;
    public static final AudienceViewInfo TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudienceViewInfo[] f100382a = null;

    static {
        AudienceViewInfo r100 = new AudienceViewInfo("TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE", 0);
        TTLIVE_VIEW_AUDIENCE_LIST_ITEM_NEW_STYLE = r100;
        AudienceViewInfo r101 = new AudienceViewInfo("TTLIVE_VIEW_AUDIENCE_LIST_ITEM", 1);
        TTLIVE_VIEW_AUDIENCE_LIST_ITEM = r101;
        AudienceViewInfo r102 = new AudienceViewInfo("TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW", 2);
        TTLIVE_LAYOUT_DOUYIN_LOADING_VIEW = r102;
        f100382a = new AudienceViewInfo[]{r100, r101, r102};
    }

    public static AudienceViewInfo valueOf(String r100) {
        return (AudienceViewInfo) r27.a.a(AudienceViewInfo.class, r100);
    }

    public static AudienceViewInfo[] values() {
        return (AudienceViewInfo[]) f100382a.clone();
    }

    @Override // zo2.a
    public int getType() {
        return 0;
    }

    @Override // zo2.a
    public int getCount() {
        int r100 = d.f100390b[ordinal()];
        if (r100 != 1) goto L5;
        return 3;
    L5:
        if (r100 == 2) goto L10;
        if (r100 == 3) goto L10;
        throw new NoWhenBranchMatchedException();
    L10:
        return 1;
    }

    @Override // zo2.a
    public int getResId() {
        int r100 = d.f100389a[ordinal()];
        if (r100 != 1) goto L5;
        return R.layout.ttlive_view_audience_list_item_new_style_exp;
    L5:
        if (r100 != 2) goto L7;
        return R.layout.ttlive_view_audience_list_item_exp;
    L7:
        if (r100 != 3) goto L10;
        return R.layout.ttlive_layout_douyin_loading_view;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // zo2.a
    public String getTag() {
        return name();
    }

    public AudienceViewInfo(String r100, int r101) {
        super(r100, r101);
    }
}
