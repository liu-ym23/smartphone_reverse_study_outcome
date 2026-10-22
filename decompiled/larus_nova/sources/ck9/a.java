package ck9;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.larus.account.base.model.PhoneOneKeyPlatform;
import com.larus.login.impl.loginfragment.e0;
import com.larus.login.impl.loginfragment.f0;
import com.larus.login.impl.view.PhoneLoginButtonView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n38.c0;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f24065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Boolean, Unit> f24066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PhoneLoginButtonView f24068d;

    public final void a(c0 r110, boolean r111) {
        FLogger r100 = FLogger.f375446a;
        r100.i(this.f24067c, "render, animate=" + r111);
        PhoneLoginButtonView r101 = this.f24068d;
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = r101.f358358f;
        long r103 = SystemClock.elapsedRealtime();
        if (r110 == null) goto L8;
        String r104 = r110.f516995a;
    L9:
        if (r110 == null) goto L11;
        PhoneOneKeyPlatform r105 = r110.f516996b;
    L13:
        if (o0.d(r104) == false) goto L16;
        if (r105 == null) goto L16;
        boolean r112 = true;
    L18:
        if (r112 == true) goto L21;
        r100.i("PhoneLoginButtonView", "renderCarrier shouldShow is false");
        r101.f358361i = r103;
        r101.a();
    L64:
        boolean r106 = r101.f358358f;
        if (r102 == r106) goto L70;
        this.f24066b.invoke(Boolean.valueOf(r106));
        return;
    L70:
        return;
    L21:
        if (r101.f358358f == false) goto L28;
        if (Intrinsics.areEqual(r101.f358359g, r104) == false) goto L28;
        if (r101.f358360h != r105) goto L28;
        r100.i("PhoneLoginButtonView", "renderCarrier same phone, skip");
        r101.f358361i = r103;
    L28:
        if (r111 == true) goto L30;
    L34:
        boolean r113 = false;
    L35:
        r100.i("PhoneLoginButtonView", "renderCarrier animate=" + r111 + " shouldAnimate=" + r113);
        if (r104 == null) goto L64;
        r101.f358361i = r103;
        r101.f358358f = true;
        r101.f358359g = r104;
        r101.f358360h = r105;
        if (r113 == false) goto L63;
        r101.f358356d.setText(r104);
        long r107 = SystemClock.elapsedRealtime();
        if ((r107 - r101.f358363k) > 500) goto L42;
        r101.b(r104);
        goto L64
    L42:
        r101.f358363k = r107;
        final LinearLayout r108 = r101.f358355c;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L64;
        r109.height = 0;
        r108.setLayoutParams(r109);
        r108.setVisibility(0);
        int r114 = r101.f358364l;
        if (r114 <= 0) goto L64;
        ViewParent r115 = r101.getParent();
    L50:
        if ((r115 instanceof ViewGroup) == false) goto L55;
        ViewGroup r116 = (ViewGroup) r115;
        if (r116.getId() == R.id.login_items) goto L53;
        r115 = r116.getParent();
        goto L50
    L53:
        final ViewGroup r117 = r116;
    L56:
        if (r117 == null) goto L58;
        final int r118 = r117.getPaddingBottom();
    L59:
        ValueAnimator r119 = r101.f358362j;
        if (r119 == null) goto L62;
        r119.cancel();
    L62:
        ValueAnimator r120 = ValueAnimator.ofInt(new int[]{0, r114});
        r120.setDuration(300);
        r120.setInterpolator(PhoneLoginButtonView.f358352m);
        r120.addUpdateListener(new d(r108, r117, r118));
        r120.start();
        r101.f358362j = r120;
        d2a.b.a(new e(r108));
        goto L64
    L58:
        r118 = 0;
        goto L59
    L55:
        r117 = null;
        goto L56
    L63:
        r101.b(r104);
        goto L64
    L30:
        if (r101.f358358f == true) goto L34;
        if ((r103 - r101.f358361i) <= 500) goto L34;
        r113 = true;
    L16:
        r112 = false;
        goto L18
    L11:
        r105 = null;
        goto L13
    L8:
        r104 = null;
        goto L9
    }

    public a(Context r100, e0 r101, f0 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "onEditClick");
        Intrinsics.checkNotNullParameter(r102, "onVisibleChanged");
        this.f24065a = r101;
        this.f24066b = r102;
        this.f24067c = "CarrierPhoneEntryDelegate";
    }
}
