package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.ss.android.ugc.aweme.discover.model.BackgroundConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/HeadViewType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "VIDEO", BackgroundConfig.BackgroundType.TYPE_PICTURE, "SIMPLE_LINK", "COMBINATION", "COMMENT", "SHOW", "GOOD_COMMENT", "FIND_SAME", "SIZE", "SKU", "PIONEER", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HeadViewType extends Enum<HeadViewType> {
    public static final HeadViewType COMBINATION = null;
    public static final HeadViewType COMMENT = null;
    public static final HeadViewType FIND_SAME = null;
    public static final HeadViewType GOOD_COMMENT = null;
    public static final HeadViewType PICTURE = null;
    public static final HeadViewType PIONEER = null;
    public static final HeadViewType SHOW = null;
    public static final HeadViewType SIMPLE_LINK = null;
    public static final HeadViewType SIZE = null;
    public static final HeadViewType SKU = null;
    public static final HeadViewType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HeadViewType[] f168507a = null;
    private final String type;

    public static HeadViewType valueOf(String r100) {
        return (HeadViewType) r27.a.a(HeadViewType.class, r100);
    }

    public static HeadViewType[] values() {
        return (HeadViewType[]) f168507a.clone();
    }

    static {
        HeadViewType r100 = new HeadViewType("VIDEO", 0, "video");
        VIDEO = r100;
        HeadViewType r101 = new HeadViewType(BackgroundConfig.BackgroundType.TYPE_PICTURE, 1, "image");
        PICTURE = r101;
        HeadViewType r102 = new HeadViewType("SIMPLE_LINK", 2, "simple_link");
        SIMPLE_LINK = r102;
        HeadViewType r103 = new HeadViewType("COMBINATION", 3, "combination");
        COMBINATION = r103;
        HeadViewType r104 = new HeadViewType("COMMENT", 4, "comment");
        COMMENT = r104;
        HeadViewType r105 = new HeadViewType("SHOW", 5, "show");
        SHOW = r105;
        HeadViewType r106 = new HeadViewType("GOOD_COMMENT", 6, "good_comment");
        GOOD_COMMENT = r106;
        HeadViewType r107 = new HeadViewType("FIND_SAME", 7, "find_same");
        FIND_SAME = r107;
        HeadViewType r108 = new HeadViewType("SIZE", 8, "size");
        SIZE = r108;
        HeadViewType r109 = new HeadViewType("SKU", 9, ECPromotion.SKU);
        SKU = r109;
        HeadViewType r110 = new HeadViewType("PIONEER", 10, "pioneer_test");
        PIONEER = r110;
        f168507a = new HeadViewType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getType() {
        return this.type;
    }

    public HeadViewType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
