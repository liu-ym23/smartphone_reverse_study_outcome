package com.bytedance.android.live.openplatform.api.utils.image;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/utils/image/ImageTag;", "", "", "tagInt", "I", "getTagInt", "()I", "UNKNOWN", "SNOW_FLAKE", "SPREAD_FLOWERS", "SMALL_CARD_OUT", "SMALL_CARD_IN", "EXPLAIN_CARD_COVER", "SMALL_CARD_OUT_V2", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ImageTag extends Enum<ImageTag> {
    public static final ImageTag EXPLAIN_CARD_COVER = null;
    public static final ImageTag SMALL_CARD_IN = null;
    public static final ImageTag SMALL_CARD_OUT = null;
    public static final ImageTag SMALL_CARD_OUT_V2 = null;
    public static final ImageTag SNOW_FLAKE = null;
    public static final ImageTag SPREAD_FLOWERS = null;
    public static final ImageTag UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageTag[] f84006a = null;
    private final int tagInt;

    static {
        ImageTag r100 = new ImageTag("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ImageTag r101 = new ImageTag("SNOW_FLAKE", 1, 1);
        SNOW_FLAKE = r101;
        ImageTag r102 = new ImageTag("SPREAD_FLOWERS", 2, 2);
        SPREAD_FLOWERS = r102;
        ImageTag r103 = new ImageTag("SMALL_CARD_OUT", 3, 3);
        SMALL_CARD_OUT = r103;
        ImageTag r104 = new ImageTag("SMALL_CARD_IN", 4, 4);
        SMALL_CARD_IN = r104;
        ImageTag r105 = new ImageTag("EXPLAIN_CARD_COVER", 5, 5);
        EXPLAIN_CARD_COVER = r105;
        ImageTag r106 = new ImageTag("SMALL_CARD_OUT_V2", 6, 6);
        SMALL_CARD_OUT_V2 = r106;
        f84006a = new ImageTag[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static ImageTag valueOf(String r100) {
        return (ImageTag) a.a(ImageTag.class, r100);
    }

    public static ImageTag[] values() {
        return (ImageTag[]) f84006a.clone();
    }

    public final int getTagInt() {
        return this.tagInt;
    }

    public ImageTag(String r100, int r101, int r102) {
        super(r100, r101);
        this.tagInt = r102;
    }
}
