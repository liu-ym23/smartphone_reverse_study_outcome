package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/d;", "", "", "introMaxLength", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setIntroMaxLength", "(I)V", "", "textViewPlaceHolder", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setTextViewPlaceHolder", "(Ljava/lang/String;)V", "poiSelectIntroImageUrl", "c", "setPoiSelectIntroImageUrl", "poiSelectIntroImageHeight", "b", "setPoiSelectIntroImageHeight", "poiSelectIntroImageWidth", "d", "setPoiSelectIntroImageWidth", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("intro_max_length")
    private int introMaxLength;

    @SerializedName("poi_intro_image_height")
    private int poiSelectIntroImageHeight;

    @SerializedName("poi_intro_image_url")
    private String poiSelectIntroImageUrl;

    @SerializedName("poi_intro_image_width")
    private int poiSelectIntroImageWidth;

    @SerializedName("text_view_placeholder")
    private String textViewPlaceHolder;

    public d() {
        this.introMaxLength = 40;
        this.textViewPlaceHolder = "填写介绍更容易留住进房观众...";
        this.poiSelectIntroImageUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/webcast_room_intro_poi_preview.png";
        this.poiSelectIntroImageHeight = 534;
        this.poiSelectIntroImageWidth = 1005;
    }

    public final int a() {
        return this.introMaxLength;
    }

    public final int b() {
        return this.poiSelectIntroImageHeight;
    }

    public final String c() {
        return this.poiSelectIntroImageUrl;
    }

    public final int d() {
        return this.poiSelectIntroImageWidth;
    }

    public final String e() {
        return this.textViewPlaceHolder;
    }
}
