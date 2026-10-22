package com.bytedance.android.live.base.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f58926a;

    @SerializedName("accessible_name")
    public String accessibleName;

    @SerializedName("animation_quota")
    public int animationShowTimes;

    @SerializedName("animation_type")
    public int animationType;

    @SerializedName("sub_item_list")
    public List<String> businessList;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    public int containerType;

    @SerializedName("short_touch_fallback_url")
    public String fallbackUrl;

    @SerializedName("height")
    public int height;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    public String imageUrl;

    @SerializedName("img_layers")
    public a imgLayers;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("short_touch_url")
    public String loadUrl;

    @SerializedName("show_animation")
    public int showAnimation;

    @SerializedName("width")
    public int width;

    public static class a {

        @SerializedName("base_height")
        public int baseHeight;

        @SerializedName("base_width")
        public int baseWidth;

        @SerializedName(GXTemplateKey.GAIAX_LAYERS)
        public List<C0939a> layers;

        /* JADX INFO: renamed from: com.bytedance.android.live.base.model.q$a$a, reason: collision with other inner class name */
        public static class C0939a {

            @SerializedName("height")
            public int height;

            @SerializedName("radius")
            public int radius;

            @SerializedName("url")
            public String url;

            @SerializedName("width")
            public int width;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            @SerializedName("x")
            public int f58927x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            @SerializedName("y")
            public int f58928y;

            public C0939a() {
                this.url = "";
            }
        }

        public a() {
        }
    }

    public q() {
        this.f58926a = true;
    }
}
