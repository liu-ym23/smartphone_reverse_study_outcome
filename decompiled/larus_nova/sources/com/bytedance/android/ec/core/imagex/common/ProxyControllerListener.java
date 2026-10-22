package com.bytedance.android.ec.core.imagex.common;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class ProxyControllerListener extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w<ControllerListener<? super ImageInfo>> f44622a;

    public static final class a {
    }

    static {
    }

    public final void b(Function1<? super ControllerListener<? super ImageInfo>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f44622a.a(r100);
    }

    public ProxyControllerListener(ControllerListener<? super ImageInfo> r100) {
        this.f44622a = new w(r100);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onRelease(final String r100) {
        b(new C98291(r100));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void onControllerStart(final ImageRequest r100, final long r101) {
        b(new ProxyControllerListener$onControllerStart$$inlined$withEachType$1(r100, r101));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public void onFailure(final String r100, final Throwable r101) {
        b(new AnonymousClass1(r100, r101));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(final String r100, final Throwable r101) {
        b(new C98271(r100, r101));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(final String r100, Object r101) {
        final ImageInfo r102 = (ImageInfo) r101;
        b(new C98281(r100, r102));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public void onRelease(final String r100, final ImageRequest r101) {
        b(new ProxyControllerListener$onRelease$$inlined$withEachType$1(r100, r101));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(final String r100, final Object r101) {
        b(new C98301(r100, r101));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public void onFailure(final String r100, final ImageRequest r101, final Throwable r102) {
        b(new ProxyControllerListener$onFailure$$inlined$withEachType$1(r100, r101, r102));
    }

    public void onFinalImageSet(final String r100, final ImageInfo r101, final Animatable r102) {
        b(new C98261(r100, r101, r102));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public final void onIntermediateImageSet(final String r100, ImageInfo r101, final Animatable r102) {
        final ImageInfo r103 = r101;
        b(new ProxyControllerListener$onIntermediateImageSet$$inlined$withEachType$1(r100, r103, r102));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String r100, Object r101, Animatable r102) {
        onFinalImageSet(r100, (ImageInfo) r101, r102);
    }

    public void a(final String r100, final ImageInfo r101, final Animatable r110, final ImageRequest r111, final Map<Object, Object> r112) {
        b(new ProxyControllerListener$onFinalImageSet$$inlined$withEachType$1(r100, r101, r110, r111, r112));
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener
    public /* bridge */ /* synthetic */ void onFinalImageSet(String r100, ImageInfo r101, Animatable r102, ImageRequest r103, Map r104) {
        a(r100, r101, r102, r103, r104);
    }
}
