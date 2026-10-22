package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/model/ImageType;", "", "BitMap", "ImageModel", "DynamicImage", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ImageType extends Enum<ImageType> {
    public static final ImageType BitMap = null;
    public static final ImageType DynamicImage = null;
    public static final ImageType ImageModel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageType[] f127491a = null;

    static {
        ImageType r100 = new ImageType("BitMap", 0);
        BitMap = r100;
        ImageType r101 = new ImageType("ImageModel", 1);
        ImageModel = r101;
        ImageType r102 = new ImageType("DynamicImage", 2);
        DynamicImage = r102;
        f127491a = new ImageType[]{r100, r101, r102};
    }

    public static ImageType valueOf(String r100) {
        return (ImageType) a.a(ImageType.class, r100);
    }

    public static ImageType[] values() {
        return (ImageType[]) f127491a.clone();
    }

    public ImageType(String r100, int r101) {
        super(r100, r101);
    }
}
