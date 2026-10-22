package com.bytedance.android.ec.core.cart;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/core/cart/a;", "", "", "readCacheOpt", "Z", "f", "()Z", "", "", "cartUseFragmentOpen", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "preloadLayout", "d", "frescoFadeAnimation", "b", "preloadProductCover", "e", "setStatusBarBackground", "getSetStatusBarBackground", "sliceElementReuse", ce.f26391f, "", "textPoolSize", "I", "h", "()I", "imagePoolSize", "c", "viewPoolSize", RXScreenCaptureService.KEY_INDEX, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("use_fragment_open")
    private final List<String> cartUseFragmentOpen;

    @SerializedName("fresco_fade_animation")
    private final boolean frescoFadeAnimation;

    @SerializedName("image_pool_size")
    private final int imagePoolSize;

    @SerializedName("opt_preload_layout")
    private final boolean preloadLayout;

    @SerializedName("preload_product_cover")
    private final boolean preloadProductCover;

    @SerializedName("read_cache_optimize")
    private final boolean readCacheOpt;

    @SerializedName("status_bar_background")
    private final boolean setStatusBarBackground;

    @SerializedName("slice_element_reuse")
    private final boolean sliceElementReuse;

    @SerializedName("text_pool_size")
    private final int textPoolSize;

    @SerializedName("view_pool_size")
    private final int viewPoolSize;

    public a() {
        this(null);
    }

    public final List<String> a() {
        return this.cartUseFragmentOpen;
    }

    public final boolean b() {
        return this.frescoFadeAnimation;
    }

    public final int c() {
        return this.imagePoolSize;
    }

    public final boolean d() {
        return this.preloadLayout;
    }

    public final boolean e() {
        return this.preloadProductCover;
    }

    public final boolean f() {
        return this.readCacheOpt;
    }

    public final boolean g() {
        return this.sliceElementReuse;
    }

    public final int h() {
        return this.textPoolSize;
    }

    public final int i() {
        return this.viewPoolSize;
    }

    public a(Object r100) {
        this.readCacheOpt = false;
        this.cartUseFragmentOpen = null;
        this.preloadLayout = false;
        this.frescoFadeAnimation = true;
        this.preloadProductCover = false;
        this.setStatusBarBackground = false;
        this.sliceElementReuse = false;
        this.textPoolSize = 200;
        this.imagePoolSize = 200;
        this.viewPoolSize = 200;
    }
}
