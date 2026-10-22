package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/GalleryFromType;", "", "Head", "MoreVideo", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GalleryFromType extends Enum<GalleryFromType> {
    public static final GalleryFromType Head = null;
    public static final GalleryFromType MoreVideo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GalleryFromType[] f169245a = null;

    static {
        GalleryFromType r100 = new GalleryFromType("Head", 0);
        Head = r100;
        GalleryFromType r101 = new GalleryFromType("MoreVideo", 1);
        MoreVideo = r101;
        f169245a = new GalleryFromType[]{r100, r101};
    }

    public static GalleryFromType valueOf(String r100) {
        return (GalleryFromType) r27.a.a(GalleryFromType.class, r100);
    }

    public static GalleryFromType[] values() {
        return (GalleryFromType[]) f169245a.clone();
    }

    public GalleryFromType(String r100, int r101) {
        super(r100, r101);
    }
}
