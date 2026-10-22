package com.bytedance.android.livesdk.performance;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Window;
import com.bytedance.android.livesdk.config.fg;
import com.bytedance.android.livesdkapi.model.WindowFpsConfig;
import com.bytedance.common.jato.views.fps.WindowFPSManager;
import com.bytedance.common.jato.views.fps.WindowState;
import com.bytedance.common.jato.views.fps.WindowStateListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes11.dex */
public final class j0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static j0 f154665g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowFPSManager f154666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Integer> f154667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, WindowState> f154668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f154669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f154670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f154671f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0 f154672a;

        @Override // java.lang.Runnable
        public final void run() {
            j0 r100 = this.f154672a;     // Catch: Throwable -> L7
            int r101 = r100.f(r100.f154670e);     // Catch: Throwable -> L7
            j0 r102 = this.f154672a;     // Catch: Throwable -> L7
            WindowState r103 = r102.f154668c.get(Integer.valueOf(r102.f154669d));     // Catch: Throwable -> L7
            j0 r104 = this.f154672a;     // Catch: Throwable -> L7
            r104.f154669d = -1;     // Catch: Throwable -> L7
            r104.f154670e = null;     // Catch: Throwable -> L7
            if (r101 <= 0) goto L10;
            if (r103 == null) goto L14;
            r103.setTargetFPSSelfWindow(r101);     // Catch: Throwable -> L7
            return;
        L14:
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(j0 r100) {
            this.f154672a = r100;
        }
    }

    public class b implements WindowStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f154673a;

        public b(Function2 r100) {
            this.f154673a = r100;
        }

        public final void a(WindowState r100, boolean r101, int r102) {
            Function2 r103 = this.f154673a;
            if (r103 == null) goto L6;
            r103.invoke(Boolean.valueOf(r101), Integer.valueOf(r102));
            return;
        }
    }

    public static boolean e() {
        return fg.f120200a.getValue().mEnable;
    }

    public static j0 g() {
        if (f154665g != null) goto L15;
        monitor-enter(j0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f154665g != null) goto L9;
        f154665g = new j0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j0.class);     // Catch: Throwable -> L11
    L15:
        return f154665g;
    }

    public j0() {
        this.f154668c = new HashMap();
        this.f154669d = -1;
        this.f154670e = null;
        this.f154671f = new a(this);
        this.f154666a = WindowFPSManager.getInstance();
        HashMap<String, Integer> r100 = new HashMap();
        WindowFpsConfig r101 = fg.f120200a.getValue();
        r100.put("com.bytedance.android.livesdk.livecommerce.iron.ui.IronPromotionListFragment", Integer.valueOf(r101.mCommerceHalfFps));
        r100.put("com.bytedance.android.livesdk.livecommerce.promotionlist.LivePromotionListFragment", Integer.valueOf(r101.mCommerceHalfFps));
        r100.put("com.bytedance.android.shopping.anchorv4.containers.AnchorV4Fragment", Integer.valueOf(r101.mCommerceHalfFps));
        r100.put("com.ss.android.ugc.aweme.live.goodsshelves.ui.GoodsShelvesDialogFragment", Integer.valueOf(r101.mLocalLifeHalfFps));
        r100.put("com.ss.android.ugc.aweme.trade.goods.view.GoodsDetailDialogFragment", Integer.valueOf(r101.mLocalLifeHalfFps));
        r100.put("live.LivePlayActivity", Integer.valueOf(r101.mActivityFps));
        r100.put("live.LivePlayActivityV2", Integer.valueOf(r101.mActivityFps));
        r100.put("detail.ui.DetailActivity", Integer.valueOf(r101.mActivityFps));
        this.f154667b = r100;
    }

    public final void a(Activity r100) {
        if (e() == false) goto L13;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getWindow() == null) goto L15;
        WindowState r101 = this.f154666a.attachWindow(r100, r100.getLocalClassName(), r100.getWindow(), null);
        if (r101 != null) goto L11;
        return;
    L11:
        h(r100, true);
        this.f154668c.put(Integer.valueOf(r100.getWindow().hashCode()), r101);
        return;
    L15:
        return;
    }

    public final void c(Activity r100) {
        if (e() == false) goto L12;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getWindow() == null) goto L15;
        WindowState r101 = this.f154668c.remove(Integer.valueOf(r100.getWindow().hashCode()));
        if (r101 == null) goto L14;
        r101.setTargetFPSSelfWindow(-1);
        this.f154666a.detachWindow(r100, r101);
        return;
    L14:
        return;
    L15:
        return;
    }

    public final int f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return -1;
    L5:
        Integer r101 = this.f154667b.get(r100);
        if (r101 != null) goto L8;
    L11:
        return -1;
    L8:
        if (r101.intValue() <= 0) goto L11;
        return r101.intValue();
    }

    public final void h(Activity r100, boolean r101) {
        if (e() == false) goto L19;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getWindow() != null) goto L9;
        return;
    L9:
        if (f(r100.getLocalClassName()) >= 0) goto L11;
        return;
    L11:
        this.f154669d = -1;
        this.f154670e = null;
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(this.f154671f);
        if (r101 == false) goto L14;
        long r102 = fg.f120200a.getValue().mDurationEnterRoomDelay;
    L16:
        if (r102 <= 0) goto L21;
        this.f154669d = r100.getWindow().hashCode();
        this.f154670e = r100.getLocalClassName();
        com.bytedance.android.live.core.utils.i0.c().postDelayed(this.f154671f, r102);
        return;
    L21:
        return;
    L14:
        r102 = fg.f120200a.getValue().mDurationAnimDelay;
        goto L16
    }

    public final void d(Activity r100, String r101, Window r102) {
        if (e() == false) goto L13;
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r102 == null) goto L17;
        WindowState r103 = this.f154668c.remove(Integer.valueOf(r102.hashCode()));
        if (r103 == null) goto L16;
        r103.setStateListener(null);
        this.f154666a.detachWindow(r100, r103);
        return;
    L16:
        return;
    L17:
        return;
    L15:
        return;
    }

    public final void i(Activity r100, String r101, Window r102) {
        if (e() == false) goto L15;
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L17;
        if (r102 == null) goto L20;
        WindowState r103 = this.f154668c.get(Integer.valueOf(r102.hashCode()));
        if (r103 != null) goto L12;
        return;
    L12:
        if (fg.f120200a.getValue().mEnableFullDisableDraw == false) goto L19;
        r103.setStopBackgroundFrame(true);
        return;
    L19:
        return;
    L20:
        return;
    L17:
        return;
    }

    public final void j(Activity r100, String r101, Window r102) {
        if (e() == false) goto L13;
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r102 == null) goto L17;
        WindowState r103 = this.f154668c.get(Integer.valueOf(r102.hashCode()));
        if (r103 == null) goto L16;
        r103.setStopBackgroundFrame(false);
        return;
    L16:
        return;
    L17:
        return;
    L15:
        return;
    }

    public final void b(Activity r100, String r101, Window r102, Function2<Boolean, Integer, Unit> r103) {
        if (e() == false) goto L17;
        if (r100 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (r102 == null) goto L20;
        int r104 = f(r101);
        if (r104 >= 0) goto L12;
        return;
    L12:
        WindowState r105 = this.f154666a.attachWindow(r100, r101, r102, null);
        if (r105 != null) goto L15;
        return;
    L15:
        r105.setOtherBgMinInterval(r104);
        r105.setStateListener(new b(r103));
        this.f154668c.put(Integer.valueOf(r102.hashCode()), r105);
        return;
    L20:
        return;
    L19:
        return;
    }
}
