package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/ne1;", "", "", "urlLandscape", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setUrlLandscape", "(Ljava/lang/String;)V", "urlPortrait", "b", "setUrlPortrait", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ne1 {

    @SerializedName("url_landscape")
    private String urlLandscape;

    @SerializedName("url_portrait")
    private String urlPortrait;

    public ne1() {
        this.urlLandscape = "https://p1-webcast-dycdn.byteimg.com/obj/webcast/ttlive_privilege_clarity_animation_landscape.webp";
        this.urlPortrait = "https://p1-webcast-dycdn.byteimg.com/obj/webcast/ttlive_privilege_clarity_animation_portrati.webp";
    }

    public final String a() {
        return this.urlLandscape;
    }

    public final String b() {
        return this.urlPortrait;
    }
}
