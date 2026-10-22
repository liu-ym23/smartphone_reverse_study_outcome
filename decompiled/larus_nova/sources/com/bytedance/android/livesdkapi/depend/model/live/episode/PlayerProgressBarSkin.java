package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/PlayerProgressBarSkin;", "", "", "barColor", "Ljava/lang/String;", "Lpy/k;", "sliderStaticIcon", "Lpy/k;", "sliderDynamicIcon", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerProgressBarSkin implements h {

    @SerializedName("bar_color")
    public String barColor;

    @SerializedName("slider_dynamic_icon")
    public k sliderDynamicIcon;

    @SerializedName("slider_static_icon")
    public k sliderStaticIcon;

    public PlayerProgressBarSkin() {
        this.barColor = "";
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public PlayerProgressBarSkin(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.barColor = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.sliderStaticIcon = f.a(r100, k.class);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.sliderDynamicIcon = f.a(r100, k.class);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.barColor != null) goto L31;
        this.barColor = "";
        return;
    }
}
