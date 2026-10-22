package com.stepos.ailauncher.homegesture;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.sheet.SheetLaunchOptions;
import h8.C4148a;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ\u001f\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00150\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0015`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/homegesture/H;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;", "coordinator", "<init>", "(Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;)V", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "", "reason", Const.INTENT_KEY_PKGNAME, "(Landroid/app/Activity;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ids", "Ljava/util/HashMap;", "Companion", Const.INTENT_KEY_APIKEY, "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class H implements Application.ActivityLifecycleCallbacks {
    private static final long DESKTOP_SHEET_COVER_CONFIRM_MS = 120;
    private static final String TAG = "LiteSheetHomeTracker";
    private final HomeGestureCoordinatorImpl coordinator;
    private final HashMap<Integer, String> ids;

    public H(HomeGestureCoordinatorImpl coordinator) {
        kotlin.jvm.internal.p.i(coordinator, "coordinator");
        this.coordinator = coordinator;
        this.ids = new HashMap<>();
    }

    public static final void c(com.stepos.ailauncher.sheet.O o10, H h10, String str) {
        if (o10.isFinishing() || o10.isDestroyed()) {
            return;
        }
        h10.coordinator.notifyTopologyChanged(str + "-confirm");
    }

    public final void b(Activity activity, String reason) {
        HomeRootToken homeRootTokenFromWire;
        View decorView;
        final com.stepos.ailauncher.sheet.O o10 = activity instanceof com.stepos.ailauncher.sheet.O ? (com.stepos.ailauncher.sheet.O) activity : null;
        if (o10 == null) {
            return;
        }
        SheetLaunchOptions.Companion companion = SheetLaunchOptions.INSTANCE;
        if (companion.b(o10.getIntent()) || (homeRootTokenFromWire = HomeRootToken.INSTANCE.fromWire(companion.c(o10.getIntent()))) == null) {
            return;
        }
        HomeRootToken homeRootToken = HomeRootToken.DESKTOP;
        if (homeRootTokenFromWire == homeRootToken || homeRootTokenFromWire == HomeRootToken.MINUS_ONE) {
            if (homeRootTokenFromWire == HomeRootToken.MINUS_ONE) {
                if (La.D.K(reason, "resume", false, 2, null)) {
                    J j10 = J.INSTANCE;
                    j10.k();
                    j10.n("sheet-resume", true);
                } else if (La.D.K(reason, "pause", false, 2, null)) {
                    J.INSTANCE.i();
                }
            } else if (homeRootTokenFromWire == homeRootToken && La.D.K(reason, "resume", false, 2, null)) {
                J.INSTANCE.n("desktop-sheet-resume", true);
            }
            final String str = homeRootTokenFromWire.getWire() + O6.l.DATE_SEPARATOR + reason;
            this.coordinator.notifyTopologyChanged(str);
            Window window = o10.getWindow();
            if (window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            decorView.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.homegesture.G
                @Override // java.lang.Runnable
                public final void run() {
                    H.c(o10, this, str);
                }
            }, 120L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        HomeRootToken homeRootTokenFromWire;
        kotlin.jvm.internal.p.i(activity, "activity");
        com.stepos.ailauncher.sheet.O o10 = activity instanceof com.stepos.ailauncher.sheet.O ? (com.stepos.ailauncher.sheet.O) activity : null;
        if (o10 == null) {
            return;
        }
        SheetLaunchOptions.Companion companion = SheetLaunchOptions.INSTANCE;
        if (companion.b(o10.getIntent()) || (homeRootTokenFromWire = HomeRootToken.INSTANCE.fromWire(companion.c(o10.getIntent()))) == null) {
            return;
        }
        F f10 = new F(o10, homeRootTokenFromWire);
        this.ids.put(Integer.valueOf(System.identityHashCode(o10)), f10.getLayerId());
        this.coordinator.registerSheet(f10);
        if (homeRootTokenFromWire == HomeRootToken.MINUS_ONE) {
            J.INSTANCE.j();
        }
        C4148a.d(TAG, "sheet created " + f10.getLayerId() + " token=" + homeRootTokenFromWire.getWire(), false, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        com.stepos.ailauncher.sheet.O o10 = activity instanceof com.stepos.ailauncher.sheet.O ? (com.stepos.ailauncher.sheet.O) activity : null;
        HomeRootToken homeRootTokenFromWire = o10 != null ? HomeRootToken.INSTANCE.fromWire(SheetLaunchOptions.INSTANCE.c(o10.getIntent())) : null;
        String strRemove = this.ids.remove(Integer.valueOf(System.identityHashCode(activity)));
        if (strRemove == null) {
            return;
        }
        this.coordinator.unregisterSheet(strRemove);
        if (homeRootTokenFromWire == HomeRootToken.MINUS_ONE) {
            J.INSTANCE.l();
        }
        C4148a.d(TAG, "sheet destroyed " + strRemove, false, 4, null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        b(activity, "desktop-sheet-pause");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        b(activity, "desktop-sheet-resume");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        kotlin.jvm.internal.p.i(activity, "activity");
        kotlin.jvm.internal.p.i(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
    }
}
