package com.stepos.ability.screenops.internal;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import W3.MonitorRule;
import W3.ScreenOpsEvent;
import W3.e;
import X3.a;
import Z8.C1174w;
import Z8.F;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ability.screenops.TriggerType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\u001b\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/stepos/ability/screenops/internal/EventBroadcastManager;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "LW3/c;", "rules", "LW3/e;", "listener", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;LW3/e;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LW3/e;)V", "e", "()V", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/content/Intent;", "intent", "LW3/d;", "f", "(Landroid/content/Intent;)LW3/d;", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "LUa/M;", Const.INTENT_KEY_PKGNAME, "LUa/M;", "scope", "", "Lcom/stepos/ability/screenops/internal/EventBroadcastManager$b;", "c", "Ljava/util/Map;", "registered", "Landroid/content/BroadcastReceiver;", Const.INTENT_KEY_UMID, "Landroid/content/BroadcastReceiver;", "serverReadyReceiver", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EventBroadcastManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<e, b> registered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public BroadcastReceiver serverReadyReceiver;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\f\u0010\u0011R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/ability/screenops/internal/EventBroadcastManager$b;", "", "Landroid/content/BroadcastReceiver;", "receiver", "", "", "activeRules", "", "LW3/c;", "rules", "<init>", "(Landroid/content/BroadcastReceiver;Ljava/util/Set;Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "Landroid/content/BroadcastReceiver;", Const.INTENT_KEY_PKGNAME, "()Landroid/content/BroadcastReceiver;", "Ljava/util/Set;", "()Ljava/util/Set;", "c", "Ljava/util/List;", "()Ljava/util/List;", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final BroadcastReceiver receiver;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Set<String> activeRules;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<MonitorRule> rules;

        public b(BroadcastReceiver receiver, Set<String> activeRules, List<MonitorRule> rules) {
            p.i(receiver, "receiver");
            p.i(activeRules, "activeRules");
            p.i(rules, "rules");
            this.receiver = receiver;
            this.activeRules = activeRules;
            this.rules = rules;
        }

        public final Set<String> a() {
            return this.activeRules;
        }

        /* renamed from: b, reason: from getter */
        public final BroadcastReceiver getReceiver() {
            return this.receiver;
        }

        public final List<MonitorRule> c() {
            return this.rules;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ability/screenops/internal/EventBroadcastManager$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            p.i(context, "context");
            p.i(intent, "intent");
            Log.i("EventBroadcastMgr", "SERVER_READY received, re-registering " + EventBroadcastManager.this.registered.size() + " listeners");
            Iterator it = EventBroadcastManager.this.registered.entrySet().iterator();
            while (it.hasNext()) {
                EventBroadcastManager.this.h(((b) ((Map.Entry) it.next()).getValue()).c());
            }
        }
    }

    public EventBroadcastManager(Context context) {
        p.i(context, "context");
        this.context = context;
        this.scope = d.a(L0.b(null, 1, null).plus(Y.c()));
        this.registered = new LinkedHashMap();
    }

    public final void e() {
        if (this.serverReadyReceiver != null) {
            return;
        }
        c cVar = new c();
        this.context.registerReceiver(cVar, new IntentFilter("com.screenops.action.SERVER_READY"), 2);
        this.serverReadyReceiver = cVar;
    }

    public final ScreenOpsEvent f(Intent intent) {
        String stringExtra = intent.getStringExtra("rule_name");
        if (stringExtra == null) {
            stringExtra = "";
        }
        int intExtra = intent.getIntExtra("trigger_type", -1);
        TriggerType triggerTypeA = TriggerType.INSTANCE.a(intExtra);
        if (triggerTypeA == null) {
            Log.w("EventBroadcastMgr", "Unknown trigger type: " + intExtra);
            return null;
        }
        String stringExtra2 = intent.getStringExtra("package_name");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        String stringExtra3 = intent.getStringExtra("activity_name");
        return new ScreenOpsEvent(new MonitorRule(stringExtra, stringExtra2), triggerTypeA, stringExtra3 != null ? stringExtra3 : "");
    }

    public final void g(List<MonitorRule> rules, final e listener) {
        p.i(rules, "rules");
        p.i(listener, "listener");
        if (rules.isEmpty()) {
            return;
        }
        b bVar = this.registered.get(listener);
        if (bVar == null) {
            List<MonitorRule> list = rules;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((MonitorRule) it.next()).getRuleName());
            }
            final Set setQ1 = F.q1(arrayList);
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.stepos.ability.screenops.internal.EventBroadcastManager$register$receiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    p.i(context, "context");
                    p.i(intent, "intent");
                    ScreenOpsEvent screenOpsEventF = this.f22065a.f(intent);
                    if (screenOpsEventF != null && setQ1.contains(screenOpsEventF.getRule().getRuleName())) {
                        C1060i.d(this.f22065a.scope, null, null, new EventBroadcastManager$register$receiver$1$onReceive$1(listener, screenOpsEventF, null), 3, null);
                    }
                }
            };
            this.context.registerReceiver(broadcastReceiver, new IntentFilter("com.screenops.action.SCREEN_OPS_EVENT"), 2);
            this.registered.put(listener, new b(broadcastReceiver, setQ1, F.p1(rules)));
            e();
            h(rules);
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((MonitorRule) it2.next()).getRuleName());
            }
            Log.i("EventBroadcastMgr", "Registered listener for rules=" + arrayList2);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : rules) {
            if (!bVar.a().contains(((MonitorRule) obj).getRuleName())) {
                arrayList3.add(obj);
            }
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        Set<String> setA = bVar.a();
        ArrayList arrayList4 = new ArrayList(C1174w.x(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((MonitorRule) it3.next()).getRuleName());
        }
        setA.addAll(arrayList4);
        bVar.c().addAll(arrayList3);
        h(arrayList3);
        ArrayList arrayList5 = new ArrayList(C1174w.x(arrayList3, 10));
        Iterator it4 = arrayList3.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((MonitorRule) it4.next()).getRuleName());
        }
        Log.i("EventBroadcastMgr", "Added rules=" + arrayList5 + " to existing listener");
    }

    public final void h(List<MonitorRule> rules) {
        Intent intent = new Intent("com.screenops.action.REGISTER_RULE");
        intent.setPackage("com.stepos.ability");
        intent.putExtra("client_package", this.context.getPackageName());
        intent.putExtra("rules_json", a.f6855a.e(rules));
        this.context.sendBroadcast(intent);
    }

    public final void i(List<MonitorRule> rules) {
        Intent intent = new Intent("com.screenops.action.UNREGISTER_RULE");
        intent.setPackage("com.stepos.ability");
        intent.putExtra("client_package", this.context.getPackageName());
        intent.putExtra("rules_json", a.f6855a.e(rules));
        this.context.sendBroadcast(intent);
    }

    public final void j(e listener) {
        p.i(listener, "listener");
        b bVarRemove = this.registered.remove(listener);
        if (bVarRemove == null) {
            return;
        }
        try {
            this.context.unregisterReceiver(bVarRemove.getReceiver());
        } catch (Exception e10) {
            Log.w("EventBroadcastMgr", "unregisterReceiver failed", e10);
        }
        i(bVarRemove.c());
        if (this.registered.isEmpty()) {
            k();
        }
        Log.i("EventBroadcastMgr", "Unregistered listener (all rules)");
    }

    public final void k() {
        BroadcastReceiver broadcastReceiver = this.serverReadyReceiver;
        if (broadcastReceiver != null) {
            try {
                this.context.unregisterReceiver(broadcastReceiver);
            } catch (Exception e10) {
                Log.w("EventBroadcastMgr", "unregister serverReadyReceiver failed", e10);
            }
            this.serverReadyReceiver = null;
        }
    }
}
