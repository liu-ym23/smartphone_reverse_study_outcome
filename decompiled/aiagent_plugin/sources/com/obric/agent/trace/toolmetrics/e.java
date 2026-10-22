package com.obric.agent.trace.toolmetrics;

import android.os.SystemClock;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: OmniClientIntentPendingTrace.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f15877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f15879c = null;

    /* JADX INFO: compiled from: OmniClientIntentPendingTrace.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f15881b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f15880a, r6.f15880a) == true) goto L12;
            return false;
        L12:
            if (this.f15881b == r6.f15881b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f15880a.hashCode() * 31) + Boolean.hashCode(this.f15881b);
        }

        public String toString() {
            return "OmniTaskObservation(taskState=" + this.f15880a + ", isTaskActive=" + this.f15881b + ')';
        }

        public a(String r2, boolean r3) {
            d.h.b.o.e(r2, "taskState");
            this.f15880a = r2;
            this.f15881b = r3;
        }

        public final String a() {
            return this.f15880a;
        }

        public final boolean b() {
            return this.f15881b;
        }
    }

    /* JADX INFO: compiled from: OmniClientIntentPendingTrace.kt */
    public static final class b extends LinkedHashMap<String, d> {
        b() {
            super(64, 0.75f, true);
        }

        public d a(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(super.get(r2), d.class, "com.obric.aiagent.plugin");
        }

        public d a(String r1, d r2) {
            return (d) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), d.class, "com.obric.aiagent.plugin");
        }

        public Collection<d> a() {
            return super.values();
        }

        public boolean a(d r1) {
            return super.containsValue(r1);
        }

        public int b() {
            return super.size();
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public boolean b(String r1, d r2) {
            return super.remove(r1, r2);
        }

        public d c(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(super.remove(r2), d.class, "com.obric.aiagent.plugin");
        }

        public Set<Map.Entry<String, d>> c() {
            return super.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L7;
            return false;
        L7:
            return a((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, d>> entrySet() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, d.class) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<d> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, d> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= 64) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private e() {
    }

    static {
        f15877a = new e();
        f15878b = new Object();
        f15879c = new b();
    }

    public final d a(IntentAppAction r9) {
        d.h.b.o.e(r9, "action");
        long r2 = SystemClock.elapsedRealtime();
        long r4 = System.currentTimeMillis();
        ConcurrentHashMap<String, String> r0 = r9.getExt();
        if (r0 != null) goto L5;
        return null;
    L5:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
    L28:
        return null;
    L8:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L28;
        a r8 = b(r1);
        if (r8 == null) goto L16;
        String r6 = r8.a();
    L17:
        if (r8 == null) goto L19;
        Boolean r7 = Boolean.valueOf(r8.b());
    L20:
        d r3 = new d(r2, r4, r6, r7);
        Object r10 = f15878b;
        monitor-enter(r10);
        ((Map) ZeusTransformUtils.preCheckCast(f15879c, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r9.getMessageId()), r3);     // Catch: Throwable -> L25
        d.x r11 = d.x.f38692a;     // Catch: Throwable -> L25
        monitor-exit(r10);
        return r3;
    L25:
        th = move-exception;
        throw th;
    L19:
        r7 = null;
        goto L20
    L16:
        r6 = null;
        goto L17
    }

    public final d a(String r3) {
        d.h.b.o.e(r3, "messageId");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return null;
    L6:
        Object r2 = f15878b;
        monitor-enter(r2);
        d r4 = (d) ZeusTransformUtils.preCheckCast(f15879c.get(r3), d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        monitor-exit(r2);
        return r4;
    L11:
        th = move-exception;
        throw th;
    }

    private final a b(String r8) {
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L9
        e r7 = (e) ZeusTransformUtils.preCheckCast(this, e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        IDialogStateManager r9 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r9 == null) goto L6;
        DMState r10 = r9.getCurrentDMState();     // Catch: Throwable -> L9
    L7:
        Object r11 = d.n.f(r10);     // Catch: Throwable -> L9
    L12:
        if (d.n.b(r11) == false) goto L14;
        r11 = null;
    L14:
        DMState r12 = (DMState) ZeusTransformUtils.preCheckCast(r11, DMState.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L17;
        return null;
    L17:
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r12.getActiveTasks(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L19:
        if (r5.hasNext() == false) goto L23;
        Object r6 = r5.next();
        if (((State) ZeusTransformUtils.preCheckCast(r6, State.class, "com.obric.aiagent.plugin")).isCompletedOrCanceled() == true) goto L19;
        r4.add(r6);
        goto L19
    L23:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L25:
        if (r14.hasNext() == false) goto L40;
        Object r15 = r14.next();
        State r16 = (State) ZeusTransformUtils.preCheckCast(r15, State.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r16, TaskState.class) == false) goto L29;
        TaskState r17 = (TaskState) ZeusTransformUtils.preCheckCast(r16, TaskState.class, "com.obric.aiagent.plugin");
    L30:
        if (r17 == null) goto L36;
        TaskInfo r18 = r17.getTaskInfo();
        if (r18 == null) goto L36;
        Map<String, String> r19 = r18.getExt();
        if (r19 == null) goto L36;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L38:
        if (d.h.b.o.a(r20, r8) == false) goto L25;
        r1 = r15;
    L36:
        r20 = null;
        goto L38
    L29:
        r17 = null;
    L40:
        State r21 = (State) ZeusTransformUtils.preCheckCast(r1, State.class, "com.obric.aiagent.plugin");
        if (r21 != null) goto L43;
        State r0 = (State) ZeusTransformUtils.preCheckCast(d.a.p.l(r13), State.class, "com.obric.aiagent.plugin");
    L44:
        if (r0 == null) goto L48;
        String r22 = r0.getStateName();
        if (r22 == null) goto L48;
    L54:
        if (r21 == null) goto L56;
        boolean r23 = true;
    L58:
        return new a(r22, r23);
    L56:
        r23 = false;
    L48:
        if (r12.isQuerying() == false) goto L51;
        r22 = "querying";
        goto L54
    L51:
        if (r12.isIdle() == false) goto L53;
        r22 = "idle";
        goto L54
    L53:
        r22 = "no_active_task";
        goto L54
    L43:
        r0 = r21;
        goto L44
    L6:
        r10 = null;
    L9:
        th = move-exception;
        d.n.a r24 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L12
    }
}
