package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/vh/DeepFeedProductBannerImageVH;", "Lcom/bytedance/android/shopping/deepfeed/ui/vh/AbstractDeepFeedBannerVH;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedProductBannerImageVH extends AbstractDeepFeedBannerVH {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f173801k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f173802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f173803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SimpleDraweeView f173804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f173805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f173806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f173807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f173808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f173809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f173810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.ec.core.imagex.r f173811j;

    public static final class a {
    }

    static {
    }

    public final Bitmap V3() {
        Drawable r100 = this.f173802a.getDrawable();
        if (r100 != null) goto L8;
        GenericDraweeHierarchy r101 = this.f173802a.getHierarchy();
        if (r101 == null) goto L7;
        r100 = r101.getTopLevelDrawable();
        goto L8
    L7:
        r100 = null;
    L8:
        if (r100 != null) goto L11;
        return null;
    L11:
        return X3(r100, this.f173802a.getWidth(), this.f173802a.getHeight());
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void T3(int r100) {
        ViewGroup.LayoutParams r101 = this.f173802a.getLayoutParams();
        if ((r101 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r101 = null;
    L5:
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        if (r102 == null) goto L17;
        int r103 = r102.topMargin + (r100 / 3);
        int r104 = -com.bytedance.android.shopping.extensions.b.b(8);
        int r105 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.f173805d));
        if (r104 > r103) goto L12;
        if (r105 < r103) goto L12;
        Y3(r103);
        return;
    L12:
        EventBus r106 = EventBus.getDefault();
        boolean r107 = false;
        if (r103 > com.bytedance.android.shopping.extensions.b.b(0)) goto L15;
        r107 = true;
    L15:
        r106.post(new ge3.a(r107));
        return;
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.vh.AbstractDeepFeedBannerVH
    public final void U3(int r100) {
        if (r100 != 0) goto L4;
        Y3(-com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L4:
        Y3(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.f173805d)));
    }

    public final void W3(boolean r100) {
        if (r100 == false) goto L4;
        Y3(-com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L4:
        Y3(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(this.f173805d)));
    }

    public final void Y3(int r100) {
        ViewGroup.LayoutParams r101 = this.f173802a.getLayoutParams();
        if ((r101 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r101 = null;
    L5:
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        if (r102 != null) goto L8;
    L10:
        if (r102 == null) goto L13;
        r102.topMargin = r100;
        this.f173802a.setLayoutParams(r102);
        return;
    L13:
        return;
    L8:
        if (r102.topMargin != r100) goto L10;
    }

    public DeepFeedProductBannerImageVH(View r100, com.bytedance.android.ec.core.imagex.r r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f173811j = r101;
        this.f173802a = (SimpleDraweeView) r100.findViewById(R.id.content_iv);
        this.f173803b = (SimpleDraweeView) r100.findViewById(R.id.blur_iv);
        this.f173804c = (SimpleDraweeView) r100.findViewById(R.id.blur_iv_black);
        this.f173805d = 150;
    }

    public static Bitmap X3(Drawable r100, int r101, int r102) {
        if ((r100 instanceof BitmapDrawable) == false) goto L11;
        Bitmap r103 = ((BitmapDrawable) r100).getBitmap();
        if (r103 == null) goto L11;
        Bitmap.Config r104 = r103.getConfig();
        if (r104 != null) goto L10;
        r104 = Bitmap.Config.ARGB_8888;
    L10:
        return r103.copy(r104, false);
    L11:
        Integer r105 = Integer.valueOf(r101);
        boolean r106 = true;
        if (r105.intValue() <= 0) goto L14;
        boolean r107 = true;
    L15:
        Object r108 = null;
        if (r107 == true) goto L19;
        r105 = null;
    L19:
        if (r105 != null) goto L27;
        r105 = Integer.valueOf(r100.getIntrinsicWidth());
        if (r105.intValue() <= 0) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == true) goto L27;
        r105 = null;
        goto L27
    L23:
        r109 = false;
    L27:
        if (r105 == null) goto L57;
        int r110 = r105.intValue();
        Integer r111 = Integer.valueOf(r102);
        if (r111.intValue() <= 0) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == true) goto L35;
        r111 = null;
    L35:
        if (r111 != null) goto L43;
        r111 = Integer.valueOf(r100.getIntrinsicHeight());
        if (r111.intValue() > 0) goto L40;
        r106 = false;
    L40:
        if (r106 == true) goto L43;
        r111 = null;
    L43:
        if (r111 == null) goto L58;
        int r113 = r111.intValue();
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L47
        Bitmap r115 = Bitmap.createBitmap(r110, r113, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L47
        Canvas r116 = new Canvas(r115);     // Catch: Throwable -> L47
        r100.setBounds(0, 0, r116.getWidth(), r116.getHeight());     // Catch: Throwable -> L47
        r100.draw(r116);     // Catch: Throwable -> L47
        Object r117 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L47
    L50:
        if (Result.m9455isFailureimpl(r117) == true) goto L54;
        r108 = r117;
    L54:
        return (Bitmap) r108;
    L47:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L58:
        return null;
    L31:
        r112 = false;
        goto L32
    L57:
        return null;
    L14:
        r107 = false;
        goto L15
    }
}
