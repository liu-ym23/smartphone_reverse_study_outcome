package com.android.ttcjpaysdk.facelive.utils;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.caijing.sdk.infra.base.api.fresco.FrescoGifService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vd4.a;
import vd4.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\u0010J\u001e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u001fR\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceGifController;", "", "Landroid/widget/ImageView;", "view", "setView", "", "url", "setGif", "Lvd4/a;", "listener", "setListener", "", "loopCount", "setLoopCount", "Landroid/graphics/drawable/Drawable;", "res", "", "setPlaceholderDrawable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "startGif", "stopGif", "imageUrl", "Lvd4/b;", "loadImage", "gifView", "Landroid/widget/ImageView;", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "Lvd4/a;", "I", "currentCount", "Landroid/graphics/drawable/Animatable;", "anim", "Landroid/graphics/drawable/Animatable;", "placeholderDrawable", "Landroid/graphics/drawable/Drawable;", "<init>", "()V", "Companion", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0})
public final class CJPayFaceGifController {
    public static final Companion Companion = null;
    private static final Lazy<FrescoGifService> imgService$delegate = null;
    private Animatable anim;
    private int currentCount;
    private ImageView gifView;
    private a listener;
    private int loopCount;
    private Drawable placeholderDrawable;
    private Uri uri;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceGifController$Companion;", "", "()V", "imgService", "Lcom/bytedance/caijing/sdk/infra/base/api/fresco/FrescoGifService;", "getImgService", "()Lcom/bytedance/caijing/sdk/infra/base/api/fresco/FrescoGifService;", "imgService$delegate", "Lkotlin/Lazy;", "getImageFromCache", "Landroid/graphics/Bitmap;", "url", "", "preLoad", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final FrescoGifService getImgService() {
            return (FrescoGifService) CJPayFaceGifController.access$getImgService$delegate$cp().getValue();
        }

        public static final /* synthetic */ FrescoGifService access$getImgService(Companion r100) {
            return r100.getImgService();
        }

        public final Bitmap getImageFromCache(String r100) {
            FrescoGifService r101 = getImgService();
            Application r102 = CJEnv.a();
            if (r100 != null) goto L6;
            r100 = "";
        L6:
            return r101.getCacheImageWithUrl(r102, r100);
        }

        public final void preLoad(Context r100, String r101) {
            getImgService().preLoad(r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
        imgService$delegate = LazyKt.lazy(CJPayFaceGifController$Companion$imgService$2.INSTANCE);
    }

    public final void stopGif() {
        Animatable r100 = this.anim;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    public CJPayFaceGifController() {
        this.loopCount = 1;
    }

    public static final /* synthetic */ Lazy access$getImgService$delegate$cp() {
        return imgService$delegate;
    }

    public static final /* synthetic */ Animatable access$getAnim$p(CJPayFaceGifController r100) {
        return r100.anim;
    }

    public static final /* synthetic */ int access$getCurrentCount$p(CJPayFaceGifController r100) {
        return r100.currentCount;
    }

    public static final /* synthetic */ a access$getListener$p(CJPayFaceGifController r100) {
        return r100.listener;
    }

    public final CJPayFaceGifController setGif(String r100) {
        if (r100 != null) goto L4;
    L9:
        return this;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L9;
        this.uri = UriProtector.parse(r100);
        goto L9
    }

    public final CJPayFaceGifController setListener(a r100) {
        this.listener = r100;
        return this;
    }

    public final CJPayFaceGifController setLoopCount(int r100) {
        if (r100 <= 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == false) goto L7;
        CJPayFaceGifController r102 = this;
    L8:
        if (r102 == null) goto L10;
        this.loopCount = r100;
    L10:
        return this;
    L7:
        r102 = null;
        goto L8
    L4:
        r101 = false;
        goto L5
    }

    public final void setPlaceholderDrawable(Drawable r100) {
        this.placeholderDrawable = r100;
    }

    public final CJPayFaceGifController setView(ImageView r100) {
        if (r100 == null) goto L4;
        this.gifView = r100;
    L4:
        return this;
    }

    public final void startGif(Context r100) {
        ve4.a.f554342a.getClass();
        FrescoGifService r101 = (FrescoGifService) ve4.a.a(FrescoGifService.class);
        if (r101 == null) goto L6;
        r101.startGif(r100, this.gifView, this.uri, this.placeholderDrawable, this.loopCount, new AnonymousClass1(this));
        return;
    }

    public static final /* synthetic */ void access$setAnim$p(CJPayFaceGifController r100, Animatable r101) {
        r100.anim = r101;
    }

    public static final /* synthetic */ void access$setCurrentCount$p(CJPayFaceGifController r100, int r101) {
        r100.currentCount = r101;
    }

    public final void loadImage(ImageView r100, String r101, b r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageUrl");
        Intrinsics.checkNotNullParameter(r102, "listener");
        Companion.access$getImgService(Companion).loadImage(r100, r101, r102);
    }
}
