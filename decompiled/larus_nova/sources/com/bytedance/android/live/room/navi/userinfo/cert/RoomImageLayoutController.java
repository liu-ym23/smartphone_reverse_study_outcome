package com.bytedance.android.live.room.navi.userinfo.cert;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class RoomImageLayoutController extends d<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f99779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f99780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f99781c;

    public interface a {
        void a();

        void b(Bitmap r100, ImageView r101, k r102);

        ViewGroup getContainer();

        void onShow();

        void onUnload();
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void b() {
        this.f99779a = false;
        ViewGroup r100 = this.f99781c.getContainer();
        if (r100 == null) goto L5;
        r100.removeAllViews();
        r100.setVisibility(8);
    L5:
        this.f99781c.onUnload();
    }

    public final ImageView c() {
        return (ImageView) this.f99780b.getValue();
    }

    public final void d() {
        ViewGroup r100 = this.f99781c.getContainer();
        if (r100 == null) goto L13;
        this.f99781c.a();
        r100.setVisibility(8);
        ViewParent r101 = null;
        c().setImageBitmap(null);
        ViewParent r102 = c().getParent();
        if ((r102 instanceof ViewGroup) == false) goto L8;
        r101 = r102;
    L8:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L11;
        r103.removeView(c());
    L11:
        r100.addView(c());
        this.f99779a = false;
        return;
    }

    public RoomImageLayoutController(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f99781c = r100;
        this.f99780b = LazyKt.lazy(new RoomImageLayoutController$certImg$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final /* bridge */ /* synthetic */ void a(AnchorTabLabel r100) {
        e((k) r100);
    }

    public final void e(k r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f99779a == false) goto L5;
        return;
    L5:
        ViewGroup r101 = this.f99781c.getContainer();
        if (r101 == null) goto L17;
        this.f99779a = true;
        ImageView r102 = c();
        int r103 = r100.getWidth();
        if (r103 > 0) goto L11;
        r103 = 64;
    L11:
        int r104 = (int) UtilityKotlinExtentionsKt.h(r103);
        int r105 = r100.getHeight();
        if (r105 > 0) goto L15;
        r105 = 12;
    L15:
        r102.setLayoutParams(new FrameLayout.LayoutParams(r104, (int) UtilityKotlinExtentionsKt.h(r105)));
        r101.setVisibility(0);
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r100, new c(this, r100));
        return;
    }
}
