package com.bytedance.android.shopping.infeed.data.idl;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/infeed/data/idl/HeaderBannerItemType;", "", "Image", "Comment", "LivePlayback", "CoverVideo", "Skeleton", "VideoAndImage", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HeaderBannerItemType extends Enum<HeaderBannerItemType> {
    public static final HeaderBannerItemType Comment = null;
    public static final HeaderBannerItemType CoverVideo = null;
    public static final HeaderBannerItemType Image = null;
    public static final HeaderBannerItemType LivePlayback = null;
    public static final HeaderBannerItemType Skeleton = null;
    public static final HeaderBannerItemType VideoAndImage = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeaderBannerItemType[] f176228a = null;

    static {
        HeaderBannerItemType r100 = new HeaderBannerItemType("Image", 0);
        Image = r100;
        HeaderBannerItemType r101 = new HeaderBannerItemType("Comment", 1);
        Comment = r101;
        HeaderBannerItemType r102 = new HeaderBannerItemType("LivePlayback", 2);
        LivePlayback = r102;
        HeaderBannerItemType r103 = new HeaderBannerItemType("CoverVideo", 3);
        CoverVideo = r103;
        HeaderBannerItemType r104 = new HeaderBannerItemType("Skeleton", 4);
        Skeleton = r104;
        HeaderBannerItemType r105 = new HeaderBannerItemType("VideoAndImage", 5);
        VideoAndImage = r105;
        f176228a = new HeaderBannerItemType[]{r100, r101, r102, r103, r104, r105};
    }

    public static HeaderBannerItemType valueOf(String r100) {
        return (HeaderBannerItemType) a.a(HeaderBannerItemType.class, r100);
    }

    public static HeaderBannerItemType[] values() {
        return (HeaderBannerItemType[]) f176228a.clone();
    }

    public HeaderBannerItemType(String r100, int r101) {
        super(r100, r101);
    }
}
