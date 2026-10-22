package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.layer;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends z53.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ItemMediaLayer f169693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f169694g;

    @Override // z53.a
    public final void b(String r100, ImageInfo r101) {
        this.f169693f.y();
        ItemMediaLayer.g(this.f169693f, this.f169694g, r101, true, 0, 8);
    }

    @Override // z53.a, com.facebook.drawee.controller.ControllerListener
    public final /* bridge */ /* synthetic */ void onIntermediateImageSet(String r100, ImageInfo r101) {
        b(r100, r101);
    }

    @Override // z53.a
    public final void a(String r100, ImageInfo r101, Animatable r102) {
        this.f169693f.y();
        ItemMediaLayer.g(this.f169693f, this.f169694g, r101, true, 0, 8);
    }

    @Override // z53.a, com.facebook.drawee.controller.ControllerListener
    public final /* bridge */ /* synthetic */ void onFinalImageSet(String r100, ImageInfo r101, Animatable r102) {
        a(r100, r101, r102);
    }

    public h(ItemMediaLayer r100, int r101, List r102, String r110) {
        this.f169693f = r100;
        this.f169694g = r101;
        super(r102, r110, null, false, 12);
    }
}
