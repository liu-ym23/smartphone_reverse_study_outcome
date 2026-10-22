package f0;

import B0.g;
import L2.c;
import T2.d;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.fragment.app.C0284f;
import androidx.preference.y;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.airbnb.lottie.h;
import com.google.android.gms.common.api.internal.s;
import com.google.android.material.internal.m;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.e;
import com.stepos.statsapp.v3.lib.plugin.net.NetResponse;
import com.stepos.statsrpk.RpkInfo;
import f1.AbstractC0557a;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONException;
import stepos.support.v7.widget.O;
import stepos.support.v7.widget.P;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.W;
import stepos.support.v7.widget.c0;
import stepos.support.v7.widget.l0;
import stepos.support.v7.widget.n0;
import t0.J;

/* renamed from: f0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerC0555a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12509a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12510b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerC0555a(Object obj, Looper looper, int i4) {
        super(looper);
        this.f12509a = i4;
        this.f12510b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        e eVar;
        int iN;
        long time = 0;
        NetResponse netResponseB = null;
        int i4 = 1;
        char c4 = 1;
        switch (this.f12509a) {
            case 0:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                C0556b c0556b = (C0556b) this.f12510b;
                while (true) {
                    synchronized (c0556b.f12514b) {
                        try {
                            int size = c0556b.f12516d.size();
                            if (size <= 0) {
                                return;
                            }
                            B0.e[] eVarArr = new B0.e[size];
                            c0556b.f12516d.toArray(eVarArr);
                            c0556b.f12516d.clear();
                            for (int i5 = 0; i5 < size; i5++) {
                                B0.e eVar2 = eVarArr[i5];
                                if (((ArrayList) eVar2.f143c).size() > 0) {
                                    g.y(((ArrayList) eVar2.f143c).get(0));
                                    throw null;
                                }
                            }
                        } finally {
                        }
                    }
                }
            case 1:
                if (message.what != 1) {
                    return;
                }
                ((y) this.f12510b).bindPreferences();
                return;
            case 2:
                if (message.what == 1) {
                    d.a("ActivityLifecycleCallback", "msg.what: ONCE_USE");
                    N2.a aVar = (N2.a) this.f12510b;
                    if (aVar.f1482c == 0) {
                        C0284f c0284f = aVar.f1487h;
                        c0284f.getClass();
                        d.a("SessionController", "onForeground");
                        ((Handler) c0284f.f3746c).removeCallbacksAndMessages(null);
                        aVar.f1482c = aVar.f1480a;
                        aVar.f1484e = aVar.f1481b;
                    }
                    C0284f c0284f2 = aVar.f1487h;
                    c0284f2.getClass();
                    d.a("SessionController", "onBackground");
                    ((Handler) c0284f2.f3746c).removeCallbacksAndMessages(null);
                    ((Handler) c0284f2.f3746c).sendEmptyMessageDelayed(1, 30000L);
                    long j4 = aVar.f1483d - aVar.f1482c;
                    long j5 = aVar.f1485f - aVar.f1484e;
                    d.a("ActivityLifecycleCallback", "onOnceUse, startTime:" + aVar.f1482c + ", endTime:" + aVar.f1483d + ", duration:" + j4);
                    if (aVar.f1482c > 0 && aVar.f1483d > 0 && j4 > 0) {
                        HashMap map = new HashMap();
                        map.put("startTime", String.valueOf(aVar.f1482c));
                        map.put("endTime", String.valueOf(aVar.f1483d));
                        map.put("duration", String.valueOf(j4));
                        map.put("duration2", String.valueOf(j5));
                        c cVar = L2.b.f1231a;
                        cVar.f1239h.a(cVar.f1232a, "_onceuse_", null, map, 0);
                    }
                    aVar.f1485f = 0L;
                    aVar.f1484e = 0L;
                    aVar.f1483d = 0L;
                    aVar.f1482c = 0L;
                    return;
                }
                return;
            case 3:
                d.a("SessionController", "session timeout");
                C0284f c0284f3 = (C0284f) this.f12510b;
                if (((String) c0284f3.f3744a) != null) {
                    synchronized (c0284f3) {
                        d.a("SessionController", "end a session id: " + ((String) c0284f3.f3744a));
                        c0284f3.f3744a = null;
                        c0284f3.f3745b = null;
                        c0284f3.f3748e = null;
                    }
                }
                d.a("SessionController", "flush events when session end");
                s sVar = L2.b.f1231a.f1236e;
                if (sVar == null || (eVar = (e) sVar.f9680b) == null) {
                    return;
                }
                d.a("V3OfflineEmitter", "flush");
                S2.a aVar2 = eVar.f12331f;
                if (aVar2 == null || aVar2.f1791a.getAll().size() <= 0) {
                    return;
                }
                d.a("V3OfflineEmitter", "flush sp data");
                eVar.f12330e.execute(new m(i4, eVar, c4 == true ? 1 : 0));
                return;
            case 4:
                synchronized (((Q2.b) this.f12510b)) {
                    try {
                        Object obj = this.f12510b;
                        if (!((Q2.b) obj).f1646c) {
                            int i6 = message.what;
                            if (i6 == -1) {
                                ((Q2.b) obj).f1645b = SystemClock.elapsedRealtime() + ((Q2.b) this.f12510b).f1644a;
                            } else if (i6 == 1) {
                                long jElapsedRealtime = ((Q2.b) obj).f1645b - SystemClock.elapsedRealtime();
                                if (jElapsedRealtime <= 0) {
                                    ((Q2.b) this.f12510b).b();
                                    Object obj2 = this.f12510b;
                                    Q2.b bVar = (Q2.b) obj2;
                                    bVar.f1645b = (bVar.f1645b + ((Q2.b) obj2).f1644a) - jElapsedRealtime;
                                    sendMessageDelayed(obtainMessage(1), ((Q2.b) this.f12510b).f1644a);
                                } else if (jElapsedRealtime <= ((Q2.b) this.f12510b).f1644a) {
                                    sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                                }
                            }
                        }
                    } finally {
                    }
                }
                return;
            case 5:
                Object obj3 = this.f12510b;
                if (message.what == 1) {
                    try {
                        time = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(((S2.a) ((P2.b) obj3).f1580e).f1791a.getString("getTime", "")).getTime();
                    } catch (ParseException unused) {
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    P2.b bVar2 = (P2.b) obj3;
                    bVar2.getClass();
                    if (jCurrentTimeMillis - time > (new Random().nextInt(1441) + 1440) * CoreConstants.MILLIS_IN_ONE_MINUTE) {
                        d.a("RpkConfigController", "getConfigFromServer, now: " + System.currentTimeMillis() + ", last get time: " + ((S2.a) bVar2.f1580e).f1791a.getString("getTime", ""));
                        if (!h.v(bVar2.f1576a)) {
                            d.a("RpkConfigController", "getConfigFromServer, network unavailable");
                            return;
                        }
                        HashMap map2 = new HashMap();
                        map2.put("If-Modified-Since", ((S2.a) bVar2.f1580e).f1791a.getString("lastModified", ""));
                        map2.put("If-None-Match", ((S2.a) bVar2.f1580e).f1791a.getString("ETag", ""));
                        String string = Uri.parse(com.stepos.statsrpk.c.f12361d + "rpk/" + ((RpkInfo) bVar2.f1578c).f12349a).buildUpon().toString();
                        d.a("RpkConfigController", "try local... cdn url: " + string + ", header: " + map2);
                        if (AbstractC0557a.F(bVar2.f1576a)) {
                            try {
                                netResponseB = I2.b.a(bVar2.f1576a).b(string, map2);
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            } catch (RuntimeException e5) {
                                e5.printStackTrace();
                            }
                            d.a("RpkConfigController", "getConfigFromServer response: " + netResponseB);
                            if (netResponseB == null || netResponseB.f12341a != 200) {
                                if (netResponseB == null || netResponseB.f12341a != 304) {
                                    return;
                                }
                                d.a("RpkConfigController", "config in server has no change");
                                return;
                            }
                            String str = netResponseB.f12342b;
                            if (str != null) {
                                try {
                                    J.b(bVar2.f1576a, str, (RpkInfo) bVar2.f1578c);
                                    J.e(bVar2.f1576a, str, (RpkInfo) bVar2.f1578c);
                                    return;
                                } catch (JSONException e6) {
                                    d.b("RpkConfigController", e6.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                int i7 = message.what;
                Object obj4 = this.f12510b;
                if (i7 == 1) {
                    P p4 = (P) obj4;
                    O o4 = p4.f14843e;
                    MotionEvent motionEvent = p4.f14846h;
                    c0 c0Var = (c0) o4;
                    StepOSRecyclerView stepOSRecyclerView = c0Var.f15076c;
                    if (stepOSRecyclerView.f14936a == 3 || stepOSRecyclerView.f14965t0.j()) {
                        return;
                    }
                    View view = c0Var.f15074a;
                    if (view != null && !stepOSRecyclerView.f14952n) {
                        int iN2 = stepOSRecyclerView.n(view);
                        boolean zIsEnabled = stepOSRecyclerView.getAdapter() instanceof l0 ? ((l0) stepOSRecyclerView.getAdapter()).isEnabled(iN2) : true;
                        if (iN2 >= 0 && zIsEnabled) {
                            stepOSRecyclerView.setPressed(true);
                            c0Var.f15074a.setPressed(true);
                            stepOSRecyclerView.s(stepOSRecyclerView.getChildLayoutPosition(c0Var.f15074a), c0Var.f15074a);
                            Drawable drawable = stepOSRecyclerView.f14922I;
                            if (drawable != null) {
                                drawable.setHotspot(motionEvent.getX(), motionEvent.getY());
                            }
                        }
                    }
                    c0Var.f15075b = false;
                    stepOSRecyclerView.f14936a = 0;
                    stepOSRecyclerView.f14931R = true;
                    return;
                }
                if (i7 != 2) {
                    throw new RuntimeException("Unknown message " + message);
                }
                P p5 = (P) obj4;
                p5.f14844f = true;
                MotionEvent motionEvent2 = p5.f14846h;
                c0 c0Var2 = (c0) p5.f14843e;
                c0Var2.f15075b = false;
                StepOSRecyclerView stepOSRecyclerView2 = c0Var2.f15076c;
                if ((!stepOSRecyclerView2.f14965t0.j() || Math.abs(stepOSRecyclerView2.getTranslationY()) <= ViewConfiguration.get(stepOSRecyclerView2.getContext()).getScaledTouchSlop()) && stepOSRecyclerView2.f14936a != 3) {
                    if (!stepOSRecyclerView2.isLongClickable() || stepOSRecyclerView2.f14936a != 0) {
                        stepOSRecyclerView2.f14936a = 2;
                        return;
                    }
                    stepOSRecyclerView2.f14936a = 2;
                    View view2 = c0Var2.f15074a;
                    if (view2 != null && (iN = stepOSRecyclerView2.n(view2)) >= 0) {
                        stepOSRecyclerView2.getAdapter().getItemId(iN);
                        if ((!(stepOSRecyclerView2.getAdapter() instanceof l0) || ((l0) stepOSRecyclerView2.getAdapter()).isEnabled(iN)) && !n0.c(stepOSRecyclerView2)) {
                            if (!stepOSRecyclerView2.v(iN)) {
                                int i8 = stepOSRecyclerView2.f14937b;
                                if ((i8 == 4 || i8 == 5) && (!(stepOSRecyclerView2.getAdapter() instanceof l0) || ((l0) stepOSRecyclerView2.getAdapter()).isSelectable(iN))) {
                                    StepOSRecyclerView.MultiChoiceModeWrapper multiChoiceModeWrapper = stepOSRecyclerView2.f14939d;
                                    if (multiChoiceModeWrapper != null && stepOSRecyclerView2.f14938c == null) {
                                        ActionMode actionModeStartActionMode = stepOSRecyclerView2.startActionMode(multiChoiceModeWrapper);
                                        stepOSRecyclerView2.f14938c = actionModeStartActionMode;
                                        if (actionModeStartActionMode != null) {
                                            stepOSRecyclerView2.u(iN, true);
                                            stepOSRecyclerView2.performHapticFeedback(0);
                                            View view3 = c0Var2.f15074a;
                                            if (stepOSRecyclerView2.f14967u0) {
                                                RecyclerView.LayoutManager layoutManager = stepOSRecyclerView2.getLayoutManager();
                                                RecyclerView.Adapter adapter = stepOSRecyclerView2.getAdapter();
                                                if (adapter != null && layoutManager != null && layoutManager.canScrollVertically()) {
                                                    if (layoutManager.getChildCount() >= adapter.getItemCount()) {
                                                        Log.i("StepOSRecyclerView", "item view do not fill screen.");
                                                    } else {
                                                        int[] iArr = new int[2];
                                                        view3.getLocationOnScreen(iArr);
                                                        WindowManager windowManager = (WindowManager) stepOSRecyclerView2.getContext().getSystemService("window");
                                                        Point point = new Point();
                                                        windowManager.getDefaultDisplay().getRealSize(point);
                                                        if (point.y - (view3.getMeasuredHeight() + iArr[1]) < ((int) TypedValue.applyDimension(1, 64.0f, stepOSRecyclerView2.getContext().getResources().getDisplayMetrics()))) {
                                                            stepOSRecyclerView2.smoothScrollBy(0, (int) TypedValue.applyDimension(1, 84.0f, stepOSRecyclerView2.getContext().getResources().getDisplayMetrics()));
                                                        }
                                                    }
                                                }
                                            }
                                            if (!StepOSRecyclerView.f14911C0) {
                                                stepOSRecyclerView2.post(new W(stepOSRecyclerView2, false));
                                            }
                                        }
                                    }
                                } else if (stepOSRecyclerView2.f14954o) {
                                    stepOSRecyclerView2.f14912A = iN;
                                }
                            }
                            stepOSRecyclerView2.setPressed(false);
                            c0Var2.f15074a.setPressed(false);
                            c0Var2.f15074a = null;
                            stepOSRecyclerView2.f14923J.setEmpty();
                            stepOSRecyclerView2.f14936a = -1;
                            int i9 = stepOSRecyclerView2.f14937b;
                            if (i9 == 4 || i9 == 5) {
                                int y4 = (int) motionEvent2.getY();
                                int x4 = (int) motionEvent2.getX();
                                Rect rect = stepOSRecyclerView2.f14946k;
                                if ((stepOSRecyclerView2.f14938c != null || stepOSRecyclerView2.f14949l0) && stepOSRecyclerView2.f14954o && !stepOSRecyclerView2.f14956p && stepOSRecyclerView2.getScrollState() == 0 && c0Var2.a(x4, y4, rect, motionEvent2) && stepOSRecyclerView2.r(x4, y4)) {
                                    stepOSRecyclerView2.f14968v = y4;
                                    stepOSRecyclerView2.f14957p0 = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    stepOSRecyclerView2.f14936a = 2;
                    return;
                }
                return;
        }
    }

    public HandlerC0555a(P p4) {
        this.f12509a = 6;
        this.f12510b = p4;
    }
}
