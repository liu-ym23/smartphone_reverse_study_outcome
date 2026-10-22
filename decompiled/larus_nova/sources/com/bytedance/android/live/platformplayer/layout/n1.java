package com.bytedance.android.live.platformplayer.layout;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdkapi.model.DisplayRatio;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n1 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f85674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f85675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f85676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f85677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f85678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f85679f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f85680g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f85681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f85682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f85683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f85684k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f85685l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DisplayRatio f85686m;

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final boolean e() {
        return false;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void requestLayout(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int d() {
        return this.f85684k;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getBottom() {
        return this.f85678e;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final DisplayRatio getDisplayRatio() {
        return this.f85686m;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getHeight() {
        return this.f85675b;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getLeft() {
        return this.f85677d;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getRight() {
        return this.f85679f;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getScaleType() {
        return this.f85685l;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getScaleX() {
        return this.f85682i;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getScaleY() {
        return this.f85683j;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getTop() {
        return this.f85676c;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getTranslationX() {
        return this.f85680g;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final float getTranslationY() {
        return this.f85681h;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final int getWidth() {
        return this.f85674a;
    }

    public n1(JsonObject r100) {
        this.f85674a = r100.get("width").getAsInt();
        this.f85675b = r100.get("height").getAsInt();
        this.f85676c = r100.get("top").getAsInt();
        this.f85677d = r100.get("left").getAsInt();
        this.f85678e = r100.get("bottom").getAsInt();
        this.f85679f = r100.get("right").getAsInt();
        this.f85680g = r100.get(LiveDegradeFpsAnimator.TRANSLATION_X).getAsFloat();
        this.f85681h = r100.get(LiveDegradeFpsAnimator.TRANSLATION_Y).getAsFloat();
        this.f85682i = r100.get(LiveDegradeFpsAnimator.SCALE_X).getAsFloat();
        this.f85683j = r100.get(LiveDegradeFpsAnimator.SCALE_Y).getAsFloat();
        this.f85684k = r100.get(GXTemplateKey.GAIAX_LAYER_GRAVITY).getAsInt();
        this.f85685l = r100.get("scaleType").getAsInt();
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void a(int r100) {
        this.f85679f = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void b(int r100) {
        this.f85677d = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void c(int r100) {
        this.f85678e = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void f(int r100) {
        this.f85676c = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setDisplayRatio(DisplayRatio r100) {
        this.f85686m = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setGravity(int r100) {
        this.f85684k = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setHeight(int r100) {
        this.f85675b = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleType(int r100) {
        this.f85685l = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleX(float r100) {
        this.f85682i = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setScaleY(float r100) {
        this.f85683j = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setTranslationX(float r100) {
        this.f85680g = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setTranslationY(float r100) {
        this.f85681h = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.c
    public final void setWidth(int r100) {
        this.f85674a = r100;
    }
}
