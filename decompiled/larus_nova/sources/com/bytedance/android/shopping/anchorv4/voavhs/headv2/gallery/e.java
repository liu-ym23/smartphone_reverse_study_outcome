package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopupWindow f169293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f169294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f169295c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f169296a;

        public a(e r100) {
            this.f169296a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PopupWindow r100 = this.f169296a.f169293a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            PopupWindowLancet.handleDismissBeforeOrigin(r100);     // Catch: Throwable -> L6
            r100.dismiss();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void a() {
        View r100 = this.f169294b;
        if (r100 == null) goto L5;
        r100.removeCallbacks(this.f169295c);
    L5:
        PopupWindow r101 = this.f169293a;
        if (r101 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        return;
    }

    public e() {
        this.f169295c = new a(this);
    }

    public final boolean b(View r110, Activity r111, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.f r112, Function0<Unit> r113) {
        Intrinsics.checkNotNullParameter(r113, SendEventContainerMethodParamModel.EventKinds.onClick);
        if (r110 == null) goto L41;
        if (r111 == null) goto L41;
        int r100 = pi3.a.f529323a;
        com.bytedance.android.ec.sdk.helper.q r101 = com.bytedance.android.ec.sdk.helper.q.f48131a;
        long r102 = r101.getLong("anchor_v4_find_similar_bubble_last_show_time", -1);
        long r103 = System.currentTimeMillis() / ((long) 1000);
        if (r102 <= 0) goto L12;
        long r104 = r103 - r102;
        int r105 = i.f169316a;
        if (r104 >= 7776000) goto L12;
        return false;
    L12:
        if (r112 != null) goto L14;
    L16:
        r101.e("anchor_v4_find_similar_bubble_last_show_time", r103);
        this.f169294b = LayoutInflater.from(r111).inflate(R.layout.ec_commerce_anchor_v4_gallery_find_similar_bubble_layout, null);
        PopupWindow r114 = new PopupWindow(this.f169294b, -2, -2, true);
        this.f169293a = r114;
        r114.setTouchable(true);
        PopupWindow r115 = this.f169293a;
        if (r115 == null) goto L19;
        r115.setFocusable(false);
    L19:
        PopupWindow r116 = this.f169293a;
        if (r116 == null) goto L22;
        r116.setBackgroundDrawable(new ColorDrawable(0));
    L22:
        PopupWindow r117 = this.f169293a;
        if (r117 == null) goto L28;
        int r118 = -com.bytedance.android.shopping.extensions.b.a(79);
        OverlaySource r106 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r117, r110, r106) == true) goto L28;
        r117.showAsDropDown(r110, r118, 0);
        PopupWindowLancet.trackAfterShow(r117, r106, r110);
    L28:
        PopupWindow r119 = this.f169293a;
        if (r119 == null) goto L31;
        r119.setOutsideTouchable(true);
    L31:
        PopupWindow r120 = this.f169293a;
        if (r120 == null) goto L34;
        r120.setOnDismissListener(new f(this));
    L34:
        View r121 = this.f169294b;
        if (r121 == null) goto L37;
        r121.postDelayed(this.f169295c, 3000);
    L37:
        View r122 = this.f169294b;
        if (r122 == null) goto L40;
        r122.setOnClickListener(new g(this, r113));
    L40:
        return true;
    L14:
        if (r112.ey(com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget.d.f169478y) != true) goto L16;
        return false;
    L41:
        return false;
    }
}
