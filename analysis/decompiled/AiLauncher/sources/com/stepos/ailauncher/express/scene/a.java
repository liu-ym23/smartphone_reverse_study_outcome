package com.stepos.ailauncher.express.scene;

import K5.ExpressApp;
import W3.MonitorRule;
import W3.ScreenOpsEvent;
import W3.e;
import W3.f;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.screenops.TriggerType;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.manager.U0;
import com.stepos.ailauncher.express.scene.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.p;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001\u001a\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB=\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/express/scene/a;", "", "Lkotlin/Function2;", "", "LY8/t;", "onEnter", "Lcom/stepos/ability/screenops/TriggerType;", "onLeave", "<init>", "(Lp9/p;Lp9/p;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "", "prereq", "f", "(Z)V", "", "LW3/c;", Const.INTENT_KEY_UMID, "(Z)Ljava/util/List;", "Lp9/p;", "Landroid/os/Handler;", "main", "Landroid/os/Handler;", "registeredPkgs", "Ljava/util/List;", "com/stepos/ailauncher/express/scene/a$b", "listener", "Lcom/stepos/ailauncher/express/scene/a$b;", "Companion", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    private static final String TAG = "ExpressSceneMonitor";
    private final b listener;
    private final Handler main;
    private final p<String, String, t> onEnter;
    private final p<String, TriggerType, t> onLeave;
    private List<String> registeredPkgs;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/express/scene/a$b", "LW3/e;", "LW3/d;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LW3/d;)V", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements e {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.express.scene.a$b$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0307a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TriggerType.values().length];
                try {
                    iArr[TriggerType.ON_RESUME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TriggerType.ON_TOP_RESUMED_GAINED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TriggerType.FIRST_TRAVERSALS.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TriggerType.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[TriggerType.ON_STOP.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[TriggerType.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[TriggerType.ON_TOP_RESUMED_LOST.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public b() {
        }

        public static final void d(String str, ScreenOpsEvent screenOpsEvent, TriggerType triggerType, a aVar) {
            Log.d(a.TAG, "dispatch enter: pkg=" + str + " activity=" + screenOpsEvent.getActivityName() + " triggerType=" + triggerType);
            aVar.onEnter.invoke(str, screenOpsEvent.getActivityName());
        }

        public static final void e(String str, TriggerType triggerType, a aVar) {
            Log.d(a.TAG, "dispatch leave: pkg=" + str + " triggerType=" + triggerType);
            aVar.onLeave.invoke(str, triggerType);
        }

        @Override // W3.e
        public void a(final ScreenOpsEvent event) {
            kotlin.jvm.internal.p.i(event, "event");
            final String packageName = event.getRule().getPackageName();
            final TriggerType triggerType = event.getTriggerType();
            Log.i(a.TAG, "onEvent: rule=" + event.getRule().getRuleName() + ", pkg=" + packageName + ", triggerType=" + triggerType + ", activity=" + event.getActivityName() + ", thread=" + Thread.currentThread().getName());
            switch (C0307a.$EnumSwitchMapping$0[triggerType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    Handler handler = a.this.main;
                    final a aVar = a.this;
                    handler.post(new Runnable() { // from class: com.stepos.ailauncher.express.scene.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.b.d(packageName, event, triggerType, aVar);
                        }
                    });
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    Handler handler2 = a.this.main;
                    final a aVar2 = a.this;
                    handler2.post(new Runnable() { // from class: com.stepos.ailauncher.express.scene.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.b.e(packageName, triggerType, aVar2);
                        }
                    });
                    break;
                default:
                    Log.d(a.TAG, "ignore event: pkg=" + packageName + " triggerType=" + triggerType);
                    break;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(p<? super String, ? super String, t> onEnter, p<? super String, ? super TriggerType, t> onLeave) {
        kotlin.jvm.internal.p.i(onEnter, "onEnter");
        kotlin.jvm.internal.p.i(onLeave, "onLeave");
        this.onEnter = onEnter;
        this.onLeave = onLeave;
        this.main = new Handler(Looper.getMainLooper());
        this.registeredPkgs = C1173v.m();
        this.listener = new b();
    }

    public static /* synthetic */ List e(a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = AuthManager.INSTANCE.S();
        }
        return aVar.d(z10);
    }

    public final List<MonitorRule> d(boolean prereq) {
        if (!prereq) {
            Log.i(TAG, "buildRules: express prereq not met, no rules");
            return C1173v.m();
        }
        List<ExpressApp> listA = K5.b.INSTANCE.a();
        ArrayList<ExpressApp> arrayList = new ArrayList();
        for (Object obj : listA) {
            if (U0.INSTANCE.n(((ExpressApp) obj).getPkg())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        for (ExpressApp expressApp : arrayList) {
            arrayList2.add(new MonitorRule(expressApp.getRuleName(), expressApp.getPkg()));
        }
        return arrayList2;
    }

    public final void f(boolean prereq) {
        List<MonitorRule> listD = d(prereq);
        List<MonitorRule> list = listD;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MonitorRule) it.next()).getPackageName());
        }
        Log.i(TAG, "reload: oldPkgs=" + this.registeredPkgs + " newPkgs=" + arrayList + " prereq=" + prereq);
        if (kotlin.jvm.internal.p.d(arrayList, this.registeredPkgs)) {
            Log.d(TAG, "reload: unchanged, skip");
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            f.f6652a.e(this.listener);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        Log.i(TAG, "reload: rules=" + arrayList);
        this.registeredPkgs = arrayList;
        if (listD.isEmpty()) {
            return;
        }
        f.f6652a.c(listD, this.listener);
    }

    public final void g() {
        List<MonitorRule> listE = e(this, false, 1, null);
        List<MonitorRule> list = listE;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (MonitorRule monitorRule : list) {
            arrayList.add(monitorRule.getRuleName() + "@" + monitorRule.getPackageName());
        }
        Log.i(TAG, "start: rules=" + arrayList);
        if (listE.isEmpty()) {
            Log.i(TAG, "start: no enabled pkg, skip register");
            return;
        }
        f.f6652a.c(listE, this.listener);
        List<MonitorRule> list2 = listE;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList2.add(((MonitorRule) it.next()).getPackageName());
        }
        this.registeredPkgs = arrayList2;
        Log.i(TAG, "start: registerListener done (" + listE.size() + " rules)");
    }
}
