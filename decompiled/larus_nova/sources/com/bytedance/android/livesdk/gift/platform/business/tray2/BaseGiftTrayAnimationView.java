package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.tray.RelativeEnterAnimPos;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.ui.MeasureOptFrameLayout;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0004J\b\u0010\u000b\u001a\u00020\tH\u0004R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/tray2/BaseGiftTrayAnimationView;", "Lcom/bytedance/android/live/revenue/common/ui/MeasureOptFrameLayout;", "Lh02/a;", "dialog", "", "setAboveDialog", "", "blockState", "setBlockingState", "", "getPublicScreenHeight", "getPublicScreenMarginBottom", "Ls02/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ls02/d;", "getOnGiftTrayIdleStateListener", "()Ls02/d;", "setOnGiftTrayIdleStateListener", "(Ls02/d;)V", "onGiftTrayIdleStateListener", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "b", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "setDataCenter", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "dataCenter", "c", "Z", "isContainerVisible", "()Z", "setContainerVisible", "(Z)V", "isPortrait", "setPortrait", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseGiftTrayAnimationView extends MeasureOptFrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f130284d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s02.d f130285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f130286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f130287c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseGiftTrayAnimationView f130288a;

        public a(BaseGiftTrayAnimationView r100) {
            this.f130288a = r100;
        }

        public final void a() {
            BaseGiftTrayAnimationView r100 = this.f130288a;
            int r101 = BaseGiftTrayAnimationView.f130284d;
            r100.getClass();
            if (r100.getLocalVisibleRect(new Rect()) == false) goto L48;
            Iterator<View> r102 = ViewUtilsKt.a(this.f130288a).iterator();
            View r103 = null;
            int r104 = 0;
            View r105 = null;
            int r106 = 0;
            int r107 = 0;
        L6:
            if (r102.hasNext() == false) goto L16;
            View r108 = r102.next();
            if (r108.getVisibility() != 0) goto L6;
            if (r106 != 0) goto L11;
        L12:
            r106 = r108.getTop();
            r103 = r108;
        L14:
            if (r108.getBottom() <= r107) goto L6;
            r107 = r108.getBottom();
            r105 = r108;
            goto L6
        L11:
            if (r106 <= r108.getTop()) goto L14;
        L16:
            int[] r109 = {0, 0};
            if (r103 == null) goto L19;
            r103.getLocationOnScreen(r109);
        L19:
            int r110 = r109[1];
            if ((!Intrinsics.areEqual(r105, r103)) == false) goto L23;
            if (r105 == null) goto L23;
            r105.getLocationOnScreen(r109);
        L23:
            int r111 = r109[1];
            if (r105 == null) goto L26;
            int r112 = r105.getMeasuredHeight();
        L27:
            int r113 = r111 + r112;
            int r114 = this.f130288a.getPublicScreenHeight();
            int r115 = (s1.w() - r114) - this.f130288a.getPublicScreenMarginBottom();
            if (r113 > r115) goto L31;
        L29:
            int r116 = 0;
        L34:
            if (r116 < 0) goto L49;
            if (r116 <= 0) goto L37;
            r104 = r116 + s1.f(18.0f);
        L37:
            com.bytedance.android.livesdk.revenue.service.interactivity.a r117 = (com.bytedance.android.livesdk.revenue.service.interactivity.a) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class));
            if (r117 == null) goto L50;
            r117.oe(r104);
            return;
        L50:
            return;
        L49:
            return;
        L31:
            if (r110 >= (r114 + r115)) goto L29;
            r116 = r113 - Math.max(r115, r110);
            goto L34
        L26:
            r112 = 0;
            goto L27
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public BaseGiftTrayAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseGiftTrayAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void b();

    public abstract void c();

    public void d() {
    }

    public abstract boolean e();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j(int r100, boolean r101, boolean r102, User r103);

    public abstract void k(GiftTrayWidget.c r100, GiftTrayWidget.b r101);

    public abstract void l(boolean r100);

    public void setAboveDialog(h02.a r100) {
    }

    public void setBlockingState(boolean r100) {
    }

    public void setPortrait(boolean r100) {
    }

    public static boolean f() {
        ia0.b r100 = (ia0.b) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), ia0.b.class);
        if (r100 == null) goto L7;
        Pair<Integer, RelativeEnterAnimPos> r101 = r100.Y5();
        if (r101 == null) goto L7;
        RelativeEnterAnimPos r102 = r101.getSecond();
    L9:
        if (r102 != RelativeEnterAnimPos.DOWN) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public final int getPublicScreenHeight() {
        Integer r100 = ((com.bytedance.android.livesdk.revenue.service.interactivity.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class)).B();
        if (r100 == null) goto L6;
        return r100.intValue();
    L6:
        return s1.f(197.0f);
    }

    public final int getPublicScreenMarginBottom() {
        Integer r100 = ((com.bytedance.android.livesdk.revenue.service.interactivity.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class)).mj();
        if (r100 == null) goto L6;
        return r100.intValue();
    L6:
        return s1.f(64.0f);
    }

    public DataCenter getDataCenter() {
        return this.f130286b;
    }

    public s02.d getOnGiftTrayIdleStateListener() {
        return this.f130285a;
    }

    public void setContainerVisible(boolean r100) {
        this.f130287c = r100;
    }

    public void setDataCenter(DataCenter r100) {
        this.f130286b = r100;
    }

    public void setOnGiftTrayIdleStateListener(s02.d r100) {
        this.f130285a = r100;
    }

    public final void m(long r100, boolean r101) {
        if (r101 == false) goto L7;
        com.bytedance.android.livesdk.revenue.service.interactivity.a r102 = (com.bytedance.android.livesdk.revenue.service.interactivity.a) ((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class));
        if (r102 == null) goto L14;
        r102.oe(0.0f);
        return;
    L14:
        return;
    L7:
        n01.a r103 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r103 == null) goto L10;
        boolean r104 = r103.Q0(null);
    L11:
        if (r104 == false) goto L15;
        postDelayed(new a(this), r100);
        return;
    L15:
        return;
    L10:
        r104 = false;
        goto L11
    }

    public BaseGiftTrayAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f130287c = true;
    }

    public /* synthetic */ BaseGiftTrayAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static /* synthetic */ void n(BaseGiftTrayAnimationView r100, long r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        r100.m(r101, r102);
    }
}
