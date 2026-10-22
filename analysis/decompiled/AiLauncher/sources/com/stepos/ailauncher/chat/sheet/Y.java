package com.stepos.ailauncher.chat.sheet;

import Z8.C1173v;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.activity.ChatActivity;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import v9.C5685n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001.B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\bJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010$¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/chat/sheet/Y;", "", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "activity", "<init>", "(Lcom/stepos/ailauncher/chat/activity/ChatActivity;)V", "LY8/t;", Const.INTENT_KEY_UMID, "()V", "f", "", x5.d.EXTRA_ENABLED, "m", "(Z)V", "Landroid/view/MotionEvent;", "event", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/MotionEvent;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "l", "()I", "e", "()Z", "", "n", "()Ljava/util/List;", "Lcom/stepos/ailauncher/chat/activity/ChatActivity;", "Landroid/view/WindowManager;", "wm", "Landroid/view/WindowManager;", "Landroid/view/View;", "strip", "Landroid/view/View;", "attached", "Z", "", "downY", "F", "downX", "", "downAt", "J", "tracking", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Y {
    private static final float MIN_HOME_DP = 48.0f;
    private static final float RECENTS_SCREEN_RATIO = 0.22f;
    private static final String TAG = "DesktopNavGesture";
    private final ChatActivity activity;
    private boolean attached;
    private long downAt;
    private float downX;
    private float downY;
    private View strip;
    private boolean tracking;
    private final WindowManager wm;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/sheet/Y$b", "Landroid/view/View;", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends View {
        public b(ChatActivity chatActivity) {
            super(chatActivity);
        }

        @Override // android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent event) {
            kotlin.jvm.internal.p.i(event, "event");
            return Y.this.g(event);
        }
    }

    public Y(ChatActivity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        this.activity = activity;
        Object systemService = activity.getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.wm = (WindowManager) systemService;
    }

    public static final void i(Y y10) throws Resources.NotFoundException {
        if (y10.activity.isFinishing() || y10.activity.isDestroyed()) {
            return;
        }
        y10.activity.g1();
    }

    public static final void k(Y y10) throws Resources.NotFoundException {
        DesktopChatResidentController.F2();
        if (C2740k.INSTANCE.c(y10.activity, "desktop_chat_nav_gesture")) {
            return;
        }
        C4148a.u(TAG, "Launcher Overview request not delivered → restore panel", false, 4, null);
        DesktopChatResidentController.u2();
    }

    public final void d() {
        if (this.attached) {
            return;
        }
        int iL = l();
        b bVar = new b(this.activity);
        Iterator<Integer> it = n().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (iIntValue != 2038 || e()) {
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, iL, iIntValue, 776, -3);
                layoutParams.gravity = 80;
                layoutParams.setTitle("DesktopChatNavGesture");
                try {
                    this.wm.addView(bVar, layoutParams);
                    this.strip = bVar;
                    this.attached = true;
                    C4148a.k(TAG, "attached stripH=" + iL + " type=" + iIntValue, false, 4, null);
                    return;
                } catch (Throwable th) {
                    C4148a.u(TAG, "addView type=" + iIntValue + " failed: " + th.getMessage(), false, 4, null);
                }
            }
        }
        C4148a.h(TAG, "attach failed: no usable window type", false, 4, null);
    }

    public final boolean e() {
        return Settings.canDrawOverlays(this.activity);
    }

    public final void f() {
        Object objB;
        View view = this.strip;
        if (view == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.wm.removeViewImmediate(view);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "removeView failed: " + thE.getMessage(), false, 4, null);
        }
        this.strip = null;
        this.attached = false;
        this.tracking = false;
    }

    public final boolean g(MotionEvent event) {
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.downX = event.getRawX();
            this.downY = event.getRawY();
            this.downAt = SystemClock.uptimeMillis();
            this.tracking = true;
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                return this.tracking;
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        if (!this.tracking) {
            return false;
        }
        this.tracking = false;
        if (event.getActionMasked() == 3) {
            return true;
        }
        float rawY = event.getRawY() - this.downY;
        float rawX = event.getRawX() - this.downX;
        float fG = (rawY / C5685n.g(SystemClock.uptimeMillis() - this.downAt, 1L)) * 1000.0f;
        float f10 = this.activity.getResources().getDisplayMetrics().density * 48.0f;
        int scaledTouchSlop = ViewConfiguration.get(this.activity).getScaledTouchSlop();
        float f11 = this.activity.getResources().getDisplayMetrics().heightPixels * RECENTS_SCREEN_RATIO;
        if (rawY >= (-scaledTouchSlop) || Math.abs(rawY) < Math.abs(rawX)) {
            C4148a.d(TAG, "ignore dy=" + rawY + " dx=" + rawX, false, 4, null);
            return true;
        }
        float f12 = -rawY;
        C4148a.k(TAG, "upDist=" + f12 + " vy=" + fG + " homeMin=" + f10 + " recents=" + f11, false, 4, null);
        if (f12 >= f11 || (f12 >= f10 && fG < -1800.0f && f12 >= f10 * 2)) {
            j();
        } else if (f12 >= f10 || fG < -1200.0f) {
            h();
        } else {
            C4148a.d(TAG, "below threshold", false, 4, null);
        }
        return true;
    }

    public final void h() {
        C4148a.k(TAG, "HOME → dismissSheet", false, 4, null);
        this.activity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.X
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                Y.i(this.f25650a);
            }
        });
    }

    public final void j() {
        C4148a.k(TAG, "RECENTS → hide + request Launcher Overview", false, 4, null);
        this.activity.runOnUiThread(new Runnable() { // from class: com.stepos.ailauncher.chat.sheet.W
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                Y.k(this.f25649a);
            }
        });
    }

    public final int l() {
        t0.e eVarF;
        t0.e eVarF2;
        t0.e eVarF3;
        View decorView;
        Window window = this.activity.getWindow();
        androidx.core.view.a0 a0VarB = (window == null || (decorView = window.getDecorView()) == null) ? null : androidx.core.view.N.B(decorView);
        int i10 = 0;
        int i11 = (a0VarB == null || (eVarF3 = a0VarB.f(a0.o.h())) == null) ? 0 : eVarF3.f41980d;
        int i12 = (a0VarB == null || (eVarF2 = a0VarB.f(a0.o.d())) == null) ? 0 : eVarF2.f41980d;
        if (a0VarB != null && (eVarF = a0VarB.f(a0.o.e())) != null) {
            i10 = eVarF.f41980d;
        }
        return Math.max(Math.max(Math.max(i11, i12), i10), (int) (this.activity.getResources().getDisplayMetrics().density * 48.0f));
    }

    public final void m(boolean enabled) {
        View view = this.strip;
        if (view != null) {
            view.setVisibility(enabled ? 0 : 8);
        }
    }

    public final List<Integer> n() {
        List listP = C1173v.p("TYPE_NAVIGATION_BAR_PANEL", "TYPE_STATUS_BAR_ADDITIONAL", "TYPE_SYSTEM_ERROR", "TYPE_SYSTEM_ALERT");
        ArrayList arrayList = new ArrayList();
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Integer.valueOf(WindowManager.LayoutParams.class.getField((String) it.next()).getInt(null)));
            } catch (Throwable unused) {
            }
        }
        arrayList.add(2038);
        return arrayList;
    }
}
