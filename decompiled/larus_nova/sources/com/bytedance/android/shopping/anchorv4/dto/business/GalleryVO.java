package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\"B7\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryVO;", "Ljava/io/Serializable;", "", "hasSkuPreview$delegate", "Lkotlin/Lazy;", "getHasSkuPreview", "()Z", "hasSkuPreview", "hasBottomButton$delegate", "getHasBottomButton", "hasBottomButton", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryBottom;", "bottom", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryBottom;", "getBottom", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryBottom;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryPendants;", "pendants", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryPendants;", "getPendants", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryPendants;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;", "config", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;", "getConfig", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/b;", "meta", "Lcom/bytedance/android/shopping/anchorv4/dto/business/b;", "getMeta", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/b;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryBottom;Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryPendants;Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;Lcom/bytedance/android/shopping/anchorv4/dto/business/b;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryVO implements Serializable {
    public static final a Companion = null;
    public static final String SLICE_ID_BOTTOM_DEAL_BUTTON = "gallery_bottom_bar";
    public static final String SLICE_ID_SKU_PREVIEW = "gallery_sku_preview";

    @SerializedName("bottom")
    private final GalleryBottom bottom;

    @SerializedName("config")
    private final GalleryConfig config;
    private final Lazy hasBottomButton$delegate;
    private final Lazy hasSkuPreview$delegate;

    @SerializedName("meta")
    private final b meta;

    @SerializedName("pendants")
    private final GalleryPendants pendants;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GalleryVO() {
        this(null, null, null, null, 15, null);
    }

    public final boolean getHasBottomButton() {
        return ((Boolean) this.hasBottomButton$delegate.getValue()).booleanValue();
    }

    public final boolean getHasSkuPreview() {
        return ((Boolean) this.hasSkuPreview$delegate.getValue()).booleanValue();
    }

    public final GalleryBottom getBottom() {
        return this.bottom;
    }

    public final GalleryConfig getConfig() {
        return this.config;
    }

    public final b getMeta() {
        return this.meta;
    }

    public final GalleryPendants getPendants() {
        return this.pendants;
    }

    public GalleryVO(GalleryBottom r100, GalleryPendants r101, GalleryConfig r102, b r103) {
        this.bottom = r100;
        this.pendants = r101;
        this.config = r102;
        this.meta = r103;
        this.hasSkuPreview$delegate = LazyKt.lazy(new GalleryVO$hasSkuPreview$2(this));
        this.hasBottomButton$delegate = LazyKt.lazy(new GalleryVO$hasBottomButton$2(this));
    }

    public /* synthetic */ GalleryVO(GalleryBottom r100, GalleryPendants r101, GalleryConfig r102, b r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
