package com.obric.agent.a;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.Block;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.search.EntityChangeResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.aa;
import d.h.b.o;
import d.k;
import d.l.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AlarmCardSyncManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "AlarmCardSyncManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f14218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14219b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, com.obric.agent.a.a> f14220c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c f14221d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final e f14222e = null;
    private static final C0285b f = null;
    private static boolean g;
    private static final d h = null;

    /* JADX INFO: compiled from: AlarmCardSyncManager.kt */
    private interface a {

        /* JADX INFO: renamed from: com.obric.agent.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AlarmCardSyncManager.kt */
        public static final class C0283a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f14223a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f14224b;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0283a.class) == true) goto L8;
                return false;
            L8:
                C0283a r6 = (C0283a) ZeusTransformUtils.preCheckCast(r5, C0283a.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14223a, r6.f14223a) == true) goto L12;
                return false;
            L12:
                if (o.a(this.f14224b, r6.f14224b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f14223a.hashCode() * 31) + this.f14224b.hashCode();
            }

            public String toString() {
                return "Legacy(localMessageId=" + this.f14223a + ", content=" + this.f14224b + ')';
            }

            public C0283a(String r2, String r3) {
                o.e(r2, "localMessageId");
                o.e(r3, "content");
                this.f14223a = r2;
                this.f14224b = r3;
            }

            public final String a() {
                return this.f14223a;
            }

            public final String b() {
                return this.f14224b;
            }
        }

        /* JADX INFO: renamed from: com.obric.agent.a.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AlarmCardSyncManager.kt */
        public static final class C0284b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f14225a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f14226b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final String f14227c;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0284b.class) == true) goto L8;
                return false;
            L8:
                C0284b r6 = (C0284b) ZeusTransformUtils.preCheckCast(r5, C0284b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f14225a, r6.f14225a) == true) goto L12;
                return false;
            L12:
                if (o.a(this.f14226b, r6.f14226b) == true) goto L15;
                return false;
            L15:
                if (o.a(this.f14227c, r6.f14227c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public int hashCode() {
                return (((this.f14225a.hashCode() * 31) + this.f14226b.hashCode()) * 31) + this.f14227c.hashCode();
            }

            public String toString() {
                return "Widget(localMessageId=" + this.f14225a + ", blockId=" + this.f14226b + ", renderData=" + this.f14227c + ')';
            }

            public C0284b(String r2, String r3, String r4) {
                o.e(r2, "localMessageId");
                o.e(r3, "blockId");
                o.e(r4, "renderData");
                this.f14225a = r2;
                this.f14226b = r3;
                this.f14227c = r4;
            }

            public final String a() {
                return this.f14225a;
            }

            public final String b() {
                return this.f14226b;
            }

            public final String c() {
                return this.f14227c;
            }
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlarmCardSyncManager.kt */
    public static final class C0285b extends LinkedHashSet<String> {
        C0285b() {
        }

        public int a() {
            return super.size();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* synthetic */ boolean add(Object r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        public boolean b(String r1) {
            return super.contains(r1);
        }

        public boolean c(String r1) {
            return super.remove(r1);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return a();
        }

        public boolean a(String r3) {
            o.e(r3, "element");
            boolean r4 = super.add(r3);
            if (size() <= 50) goto L5;
            Iterator r2 = iterator();
            r2.next();
            r2.remove();
        L5:
            return r4;
        }
    }

    /* JADX INFO: compiled from: AlarmCardSyncManager.kt */
    public static final class c extends LinkedHashSet<String> {
        c() {
        }

        public int a() {
            return super.size();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* synthetic */ boolean add(Object r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        public boolean b(String r1) {
            return super.contains(r1);
        }

        public boolean c(String r1) {
            return super.remove(r1);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return a();
        }

        public boolean a(String r3) {
            o.e(r3, "element");
            boolean r4 = super.add(r3);
            if (size() <= 50) goto L5;
            Iterator r2 = iterator();
            r2.next();
            r2.remove();
        L5:
            return r4;
        }
    }

    /* JADX INFO: compiled from: AlarmCardSyncManager.kt */
    public static final class d implements com.obric.agent.im.d {
        @Override // com.obric.agent.im.d
        public void onReceiveMessage(IMMessage r1) {
            o.e(r1, "message");
        }

        @Override // com.obric.agent.im.d
        public void onRegenMessage(IMMessage r1) {
            o.e(r1, "message");
        }

        @Override // com.obric.agent.im.d
        public void onUpdateMessage(IMMessage r1) {
            o.e(r1, "message");
        }

        d() {
        }

        @Override // com.obric.agent.im.d
        public void onInsertMessageList(List<IMMessage> r3) {
            com.obric.agent.im.d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.obric.agent.im.d
        public void onSendMessage(IMMessage r3) {
            o.e(r3, "message");
            boolean r0 = true;
            if (r3.getUserType() == 1) goto L5;
            return;
        L5:
            if (r3.getMessageStatusLocal() != 11) goto L16;
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.agent.im.b.a(r3), CharSequence.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L9;
        L12:
            if (r0 == true) goto L17;
            b.f14218a.b();
            return;
        L17:
            return;
        L9:
            if (d.o.o.d(r2) == true) goto L12;
            r0 = false;
            goto L12
        }
    }

    /* JADX INFO: compiled from: AlarmCardSyncManager.kt */
    public static final class e extends LinkedHashMap<String, AlarmEntity> {
        e() {
            super(16, 0.75f, true);
        }

        public AlarmEntity a(String r2) {
            return (AlarmEntity) ZeusTransformUtils.preCheckCast(super.get(r2), AlarmEntity.class, "com.obric.aiagent.plugin");
        }

        public AlarmEntity a(String r1, AlarmEntity r2) {
            return (AlarmEntity) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), AlarmEntity.class, "com.obric.aiagent.plugin");
        }

        public Collection<AlarmEntity> a() {
            return super.values();
        }

        public boolean a(AlarmEntity r1) {
            return super.containsValue(r1);
        }

        public int b() {
            return super.size();
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public boolean b(String r1, AlarmEntity r2) {
            return super.remove(r1, r2);
        }

        public AlarmEntity c(String r2) {
            return (AlarmEntity) ZeusTransformUtils.preCheckCast(super.remove(r2), AlarmEntity.class, "com.obric.aiagent.plugin");
        }

        public Set<Map.Entry<String, AlarmEntity>> c() {
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
            if (ZeusTransformUtils.instanceOf(r3, AlarmEntity.class) == true) goto L7;
            return false;
        L7:
            return a((AlarmEntity) ZeusTransformUtils.preCheckCast(r3, AlarmEntity.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, AlarmEntity>> entrySet() {
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
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (AlarmEntity) ZeusTransformUtils.preCheckCast(r4, AlarmEntity.class, "com.obric.aiagent.plugin"));
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
            if (ZeusTransformUtils.instanceOf(r4, AlarmEntity.class) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (AlarmEntity) ZeusTransformUtils.preCheckCast(r4, AlarmEntity.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<AlarmEntity> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, AlarmEntity> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= 50) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: lambda$ADGXQDQCWab02ZWb-Fp4F_YBzRA, reason: not valid java name */
    public static /* synthetic */ CharSequence m64lambda$ADGXQDQCWab02ZWbFp4F_YBzRA(AlarmEntity r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$Akk5eB2vHaICTi-I-8-k-oYcOLI, reason: not valid java name */
    public static /* synthetic */ CharSequence m65lambda$Akk5eB2vHaICTiI8koYcOLI(AlarmEntity r0) {
        return b(r0);
    }

    public static /* synthetic */ CharSequence lambda$I46I_WdOv0taBtV6aSUSxx4xDsA(AlarmEntity r0) {
        return d(r0);
    }

    public static /* synthetic */ CharSequence lambda$srPwX99VpmWA8PqLJCrMFSV1X5g(AlarmEntity r0) {
        return c(r0);
    }

    private b() {
    }

    static {
        f14218a = new b();
        f14219b = new Object();
        f14220c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        f14221d = new c();
        f14222e = new e();
        f = new C0285b();
        h = new d();
    }

    public final void a() {
        com.obric.agent.entitysync.b.f14469a.a();
    }

    public static /* synthetic */ void a(b r1, String r2, String r3, List r4, int r5, Object r6) {
        List<Block> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        r1.a(r2, r3, r7);
    }

    public final void a(String r19, String r20, List<Block> r21) {
        List<Block> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.aiagent.plugin");
        o.e(r19, "localMessageId");
        o.e(r20, "content");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return;
    L5:
        com.obric.agent.a.d.a r4 = com.obric.agent.a.d.f14231a.a(r3);
        if (r4 == null) goto L9;
        com.obric.agent.a.c r2 = (com.obric.agent.a.c) ZeusTransformUtils.preCheckCast(new com.obric.agent.a.c.b(r4.a(), r4.b()), com.obric.agent.a.c.class, "com.obric.aiagent.plugin");
        List<AlarmEntity> r5 = r4.c();
    L27:
        Object r6 = f14219b;
        monitor-enter(r6);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L59
    L31:
        if (r9.hasNext() == false) goto L33;
        r8.add(((AlarmEntity) ZeusTransformUtils.preCheckCast(r9.next(), AlarmEntity.class, "com.obric.aiagent.plugin")).getId());     // Catch: Throwable -> L59
        goto L31
    L33:
        Set r10 = p.q((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L59
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(n.c(ao.a(p.a(r11, 10)), 16)), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L59
    L35:
        if (r13.hasNext() == false) goto L37;
        Object r14 = r13.next();     // Catch: Throwable -> L59
        r12.put(((AlarmEntity) ZeusTransformUtils.preCheckCast(r14, AlarmEntity.class, "com.obric.aiagent.plugin")).getId(), r14);     // Catch: Throwable -> L59
        goto L35
    L37:
        Map r15 = ao.e(r12);     // Catch: Throwable -> L59
        Iterator r16 = ((Map) ZeusTransformUtils.preCheckCast(f14222e, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Throwable -> L59
    L39:
        if (r16.hasNext() == false) goto L43;
        Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        String r18 = (String) ZeusTransformUtils.preCheckCast(r17.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        AlarmEntity r22 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r17.getValue(), AlarmEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        if (r10.contains(r18) == false) goto L39;
        r15.put(r18, r22);     // Catch: Throwable -> L59
        goto L39
    L43:
        f.removeAll((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L59
        f14220c.put(r19, new com.obric.agent.a.a(r19, r10, r15, r2));     // Catch: Throwable -> L59
        ILogDepend.Companion r23 = ILogDepend.Companion;     // Catch: Throwable -> L59
        StringBuilder r1 = new StringBuilder().append("onAlarmCardMessageAdded context created, localMessageId=").append(r19).append(", payload=").append(r2.getClass().getSimpleName()).append(", alarmIds=").append(p.a((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$b$ADGXQDQCWab02ZWbFp4F_YBzRA.INSTANCE, 31, null)).append(", deletedIds=");     // Catch: Throwable -> L59
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(f14221d, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Iterator r26 = r24.iterator();     // Catch: Throwable -> L59
    L45:
        if (r26.hasNext() == false) goto L49;
        Object r27 = r26.next();     // Catch: Throwable -> L59
        if (r10.contains((String) ZeusTransformUtils.preCheckCast(r27, String.class, "com.obric.aiagent.plugin")) == false) goto L45;
        r25.add(r27);     // Catch: Throwable -> L59
        goto L45
    L49:
        StringBuilder r28 = r1.append(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null)).append(", refreshedIds=");     // Catch: Throwable -> L59
        Set<String> r29 = f14222e.keySet();     // Catch: Throwable -> L59
        o.c(r29, "<get-keys>(...)");     // Catch: Throwable -> L59
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Collection r31 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Iterator r32 = r30.iterator();     // Catch: Throwable -> L59
    L51:
        if (r32.hasNext() == false) goto L55;
        Object r33 = r32.next();     // Catch: Throwable -> L59
        if (r10.contains((String) ZeusTransformUtils.preCheckCast(r33, String.class, "com.obric.aiagent.plugin")) == false) goto L51;
        r31.add(r33);     // Catch: Throwable -> L59
        goto L51
    L55:
        r23.i(TAG, r28.append(p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r31, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null)).append(", activeCount=").append(f14220c.size()).toString());     // Catch: Throwable -> L59
        x r34 = x.f38692a;     // Catch: Throwable -> L59
        monitor-exit(r6);
        c();
        return;
    L59:
        th = move-exception;
        throw th;
    L9:
        if (c(r20) == false) goto L12;
        ILogDepend.Companion.i(TAG, "onAlarmCardMessageAdded ignored: local mock intent, localMessageId=" + r19);
        return;
    L12:
        String r35 = b(r20);
        CharSequence r36 = (CharSequence) ZeusTransformUtils.preCheckCast(r35, CharSequence.class, "com.obric.aiagent.plugin");
        if (r36 != null) goto L15;
    L18:
        boolean r37 = true;
    L19:
        if (r37 == false) goto L22;
        ILogDepend.Companion.d(TAG, "onAlarmCardMessageAdded ignored: unsupported payload, localMessageId=" + r19);
        return;
    L22:
        List<AlarmEntity> r38 = a(r20);
        if (r38.isEmpty() == false) goto L26;
        ILogDepend.Companion.e(TAG, "onAlarmCardMessageAdded ignored: parse alarm entities failed, localMessageId=" + r19 + ", intentName=" + r35);
        return;
    L26:
        com.obric.agent.a.c r39 = (com.obric.agent.a.c) ZeusTransformUtils.preCheckCast(new com.obric.agent.a.c.a(r35), com.obric.agent.a.c.class, "com.obric.aiagent.plugin");
        r5 = r38;
        r2 = r39;
        goto L27
    L15:
        if (d.o.o.d(r36) == true) goto L18;
        r37 = false;
        goto L19
    }

    private static final CharSequence a(AlarmEntity r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.getId(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final void b() {
        Object r14 = f14219b;
        monitor-enter(r14);
        ILogDepend.Companion r0 = ILogDepend.Companion;     // Catch: Throwable -> L7
        StringBuilder r2 = new StringBuilder().append("onNewQuery clear activeContexts, count=");     // Catch: Throwable -> L7
        Map<String, com.obric.agent.a.a> r3 = f14220c;     // Catch: Throwable -> L7
        r0.i(TAG, r2.append(r3.size()).append(", ids=").append(p.a((Iterable) ZeusTransformUtils.preCheckCast(r3.keySet(), Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null)).toString());     // Catch: Throwable -> L7
        r3.clear();     // Catch: Throwable -> L7
        f.clear();     // Catch: Throwable -> L7
        f14221d.clear();     // Catch: Throwable -> L7
        f14222e.clear();     // Catch: Throwable -> L7
        x r1 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r14);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(EntityChangeResult r23) {
        o.e(r23, "result");
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Object r2 = f14219b;
        monitor-enter(r2);
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r23.getEntities(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L68
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r6 = r5.next();     // Catch: Throwable -> L68
        if (ZeusTransformUtils.instanceOf(r6, AlarmEntity.class) == false) goto L6;
        r4.add(r6);     // Catch: Throwable -> L68
        goto L6
    L10:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        if (r7.isEmpty() == false) goto L15;
        ILogDepend.Companion.d(TAG, "onEntityChanged ignored: no AlarmEntity found, changeType=" + r23.getChangeType());     // Catch: Throwable -> L68
        monitor-exit(r2);
        return;
    L15:
        int r8 = r23.getChangeType();     // Catch: Throwable -> L68
        if (r8 == 2) goto L23;
        if (r8 != 3) goto L27;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L68
    L21:
        if (r9.hasNext() == false) goto L27;
        f14221d.a(((AlarmEntity) ZeusTransformUtils.preCheckCast(r9.next(), AlarmEntity.class, "com.obric.aiagent.plugin")).getId());     // Catch: Throwable -> L68
    L27:
        ILogDepend.Companion.i(TAG, "onEntityChanged buffered, changeType=" + r23.getChangeType() + ", ids=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$b$Akk5eB2vHaICTiI8koYcOLI.INSTANCE, 31, null) + ", deletedCount=" + f14221d.size() + ", refreshedCount=" + f14222e.size());     // Catch: Throwable -> L68
        Map<String, com.obric.agent.a.a> r10 = f14220c;     // Catch: Throwable -> L68
        if (r10.isEmpty() == false) goto L31;
        monitor-exit(r2);
        return;
    L31:
        Iterator<com.obric.agent.a.a> r11 = r10.values().iterator();     // Catch: Throwable -> L68
    L33:
        if (r11.hasNext() == false) goto L50;
        com.obric.agent.a.a r12 = (com.obric.agent.a.a) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.agent.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        Iterator r15 = r13.iterator();     // Catch: Throwable -> L68
    L36:
        if (r15.hasNext() == false) goto L40;
        Object r16 = r15.next();     // Catch: Throwable -> L68
        if (r12.b().contains(((AlarmEntity) ZeusTransformUtils.preCheckCast(r16, AlarmEntity.class, "com.obric.aiagent.plugin")).getId()) == false) goto L36;
        r14.add(r16);     // Catch: Throwable -> L68
        goto L36
    L40:
        List<AlarmEntity> r17 = (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        if (r17.isEmpty() == true) goto L33;
        ILogDepend.Companion.i(TAG, "onEntityChanged hit card, changeType=" + r23.getChangeType() + ", localMessageId=" + r12.a() + ", hitIds=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$b$srPwX99VpmWA8PqLJCrMFSV1X5g.INSTANCE, 31, null));     // Catch: Throwable -> L68
        int r18 = r23.getChangeType();     // Catch: Throwable -> L68
        if (r18 == 2) goto L47;
        if (r18 == 3) goto L46;
        a r19 = null;
    L48:
        if (r19 == null) goto L33;
        r0.add(r19);     // Catch: Throwable -> L68
        goto L33
    L46:
        r19 = f14218a.a(r12, r17);     // Catch: Throwable -> L68
        goto L48
    L47:
        r19 = f14218a.b(r12, r17);     // Catch: Throwable -> L68
        goto L48
    L50:
        x r1 = x.f38692a;     // Catch: Throwable -> L68
        monitor-exit(r2);
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L54:
        if (r20.hasNext() == false) goto L67;
        a r21 = (a) ZeusTransformUtils.preCheckCast(r20.next(), a.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r21, a.C0283a.class) == true) goto L57;
        if (ZeusTransformUtils.instanceOf(r21, a.C0284b.class) == false) goto L66;
        ILogDepend.Companion.i(TAG, "refresh alarm widget, localMessageId=" + ((a.C0284b) ZeusTransformUtils.preCheckCast(r21, a.C0284b.class, "com.obric.aiagent.plugin")).a() + ", blockId=" + ((a.C0284b) ZeusTransformUtils.preCheckCast(r21, a.C0284b.class, "com.obric.aiagent.plugin")).b() + ", length=" + ((a.C0284b) ZeusTransformUtils.preCheckCast(r21, a.C0284b.class, "com.obric.aiagent.plugin")).c().length());
        IFlowMessageIDL r22 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r22 == null) goto L54;
        r22.updateMutableWidgetRenderData(((a.C0284b) ZeusTransformUtils.preCheckCast(r21, a.C0284b.class, "com.obric.aiagent.plugin")).a(), ((a.C0284b) ZeusTransformUtils.preCheckCast(r21, a.C0284b.class, "com.obric.aiagent.plugin")).b(), ((a.C0284b) ZeusTransformUtils.preCheckCast(r21, a.C0284b.class, "com.obric.aiagent.plugin")).c());
        goto L54
    L66:
        throw new k();
    L57:
        ILogDepend.Companion.i(TAG, "refresh legacy alarm card, localMessageId=" + ((a.C0283a) ZeusTransformUtils.preCheckCast(r21, a.C0283a.class, "com.obric.aiagent.plugin")).a() + ", length=" + ((a.C0283a) ZeusTransformUtils.preCheckCast(r21, a.C0283a.class, "com.obric.aiagent.plugin")).b().length());
        IFlowMessageIDL r24 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r24 == null) goto L54;
        r24.updateMutableMessageContent(((a.C0283a) ZeusTransformUtils.preCheckCast(r21, a.C0283a.class, "com.obric.aiagent.plugin")).a(), ((a.C0283a) ZeusTransformUtils.preCheckCast(r21, a.C0283a.class, "com.obric.aiagent.plugin")).b());
        goto L54
    L67:
        return;
    L23:
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L68
    L25:
        if (r25.hasNext() == false) goto L27;
        AlarmEntity r26 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r25.next(), AlarmEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L68
        ((Map) ZeusTransformUtils.preCheckCast(f14222e, Map.class, "com.obric.aiagent.plugin")).put(r26.getId(), r26);     // Catch: Throwable -> L68
    L68:
        th = move-exception;
        throw th;
    }

    private static final CharSequence b(AlarmEntity r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.getId(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private static final CharSequence c(AlarmEntity r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.getId(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final a a(com.obric.agent.a.a r14, List<AlarmEntity> r15) {
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r17 = r16.iterator();
    L4:
        if (r17.hasNext() == false) goto L8;
        Object r2 = r17.next();
        if (r14.b().contains(((AlarmEntity) ZeusTransformUtils.preCheckCast(r2, AlarmEntity.class, "com.obric.aiagent.plugin")).getId()) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        List r18 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        if (r18.isEmpty() == false) goto L12;
        ILogDepend.Companion.d(TAG, "handleAlarmDelete skipped: no deleted entity in current card");
        return null;
    L12:
        ILogDepend.Companion.i(TAG, "handleAlarmDelete marked deleted, localMessageId=" + r14.a() + ", deletedIds=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, $$Lambda$b$I46I_WdOv0taBtV6aSUSxx4xDsA.INSTANCE, 31, null));
        return a(r14);
    }

    private static final CharSequence d(AlarmEntity r2) {
        o.e(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.getId(), CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final a b(com.obric.agent.a.a r17, List<AlarmEntity> r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r4 = false;
    L4:
        if (r1.hasNext() == false) goto L19;
        AlarmEntity r5 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r1.next(), AlarmEntity.class, "com.obric.aiagent.plugin");
        AlarmEntity r7 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r17.c().get(r5.getId()), AlarmEntity.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L4;
        ILogDepend.Companion.i(TAG, "old: " + r7);
        ILogDepend.Companion.i(TAG, "changed: " + r5);
        if (r7.isEnabled() == r5.isEnabled()) goto L11;
        boolean r6 = true;
    L12:
        boolean r8 = f14218a.a(r7, r5);
        if (r6 == true) goto L15;
        if (r8 == false) goto L4;
    L15:
        r2.add(r5.getId());
        r17.c().put(r5.getId(), r5);
        if (r8 == false) goto L18;
        f.a(r5.getId());
    L18:
        r4 = true;
        goto L4
    L11:
        r6 = false;
        goto L12
    L19:
        ILogDepend.Companion.i(TAG, "handleAlarmUpdate processed, localMessageId=" + r17.a() + ", updatedIds=" + p.a((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null));
        if (r4 == true) goto L32;
        return null;
    L32:
        return a(r17);
    }

    private final boolean a(AlarmEntity r2, AlarmEntity r3) {
        if (o.a(r2.getStartTime(), r3.getStartTime()) == true) goto L5;
    L12:
        return true;
    L5:
        if (o.a(r2.getName(), r3.getName()) == false) goto L12;
        if (o.a(r2.getRepeatDayOfWeek(), r3.getRepeatDayOfWeek()) == false) goto L12;
        if (r2.getCloseInHoliday() != r3.getCloseInHoliday()) goto L12;
        return false;
    }

    private final a a(com.obric.agent.a.a r7) {
        com.obric.agent.a.c r0 = r7.d();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.agent.a.c.a.class) == false) goto L6;
        return (a) ZeusTransformUtils.preCheckCast(new a.C0283a(r7.a(), a(r7, ((com.obric.agent.a.c.a) ZeusTransformUtils.preCheckCast(r0, com.obric.agent.a.c.a.class, "com.obric.aiagent.plugin")).a())), a.class, "com.obric.aiagent.plugin");
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.agent.a.c.b.class) == false) goto L13;
        String r6 = com.obric.agent.a.d.f14231a.a(((com.obric.agent.a.c.b) ZeusTransformUtils.preCheckCast(r0, com.obric.agent.a.c.b.class, "com.obric.aiagent.plugin")).b(), r7.c(), (Set) ZeusTransformUtils.preCheckCast(f14221d, Set.class, "com.obric.aiagent.plugin"));
        a.C0284b r1 = null;
        if (r6 == null) goto L11;
        r7.a((com.obric.agent.a.c) ZeusTransformUtils.preCheckCast(com.obric.agent.a.c.b.a((com.obric.agent.a.c.b) ZeusTransformUtils.preCheckCast(r0, com.obric.agent.a.c.b.class, "com.obric.aiagent.plugin"), null, r6, 1, null), com.obric.agent.a.c.class, "com.obric.aiagent.plugin"));
        r1 = new a.C0284b(r7.a(), ((com.obric.agent.a.c.b) ZeusTransformUtils.preCheckCast(r0, com.obric.agent.a.c.b.class, "com.obric.aiagent.plugin")).a(), r6);
    L11:
        return (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
    L13:
        throw new k();
    }

    private final String a(com.obric.agent.a.a r14, String r15) {
        List<AppIntentCardData> r9 = b(r14);
        AppIntentMessage r13 = new AppIntentMessage(new DataSource("Clock", r15, null, 4, null), false, false, null, null, false, false, null, r9, null, 766, null);
        String r16 = EntityExtKt.a().toJson(r13);
        o.c(r16, "toJson(...)");
        return r16;
    }

    private final List<AppIntentCardData> b(com.obric.agent.a.a r18) {
        List r0 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r18.c().values(), Iterable.class, "com.obric.aiagent.plugin"));
        ILogDepend.Companion.i(TAG, "alarmEntities size " + r0.size());
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        AlarmEntity r4 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r3.next(), AlarmEntity.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion r5 = ILogDepend.Companion;
        StringBuilder r6 = new StringBuilder().append("buildAlarmCard alarmEntity startTime: ").append(r4.getStartTime()).append(" isEnable: ").append(r4.isEnabled()).append(" isDeleted: ");
        c r7 = f14221d;
        StringBuilder r8 = r6.append(r7.contains(r4.getId())).append(" isRefreshed: ");
        C0285b r9 = f;
        r5.i(TAG, r8.append(r9.contains(r4.getId())).toString());
        r2.add(new AppIntentCardData(0, (AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.aiagent.plugin"), null, r7.contains(r4.getId()), r9.contains(r4.getId()), 4, null));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
    }

    private final List<AlarmEntity> a(String r6) {
        JsonArray r7 = JsonParser.parseString(r6).getAsJsonObject().getAsJsonArray("dataV2");     // Catch: Exception -> L32
        if (r7 == null) goto L6;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L32
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L32
        Iterator r9 = r8.iterator();     // Catch: Exception -> L32
    L9:
        if (r9.hasNext() == false) goto L42;
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L32
        Object r2 = null;
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L21
        JsonObject r4 = r1.getAsJsonObject().getAsJsonObject("appEntity");     // Catch: Throwable -> L21
        if (r4 == null) goto L28;
        AlarmEntity r5 = (AlarmEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"), AlarmEntity.class), AlarmEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5.getId(), CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L19;
        r5 = null;
    L19:
        Object r10 = d.n.f(r5);     // Catch: Throwable -> L21
    L24:
        if (d.n.b(r10) == true) goto L27;
        r2 = r10;
    L27:
        r2 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r2, AlarmEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L32
    L28:
        if (r2 == null) goto L9;
        r0.add(r2);     // Catch: Exception -> L32
    L21:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;     // Catch: Exception -> L32
        r10 = d.n.f(d.o.a(th));     // Catch: Exception -> L32
        goto L24
    L42:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L6:
        return p.b();
    L33:
        return p.b();
    }

    private final String b(String r2) {
        JsonObject r3 = JsonParser.parseString(r2).getAsJsonObject().getAsJsonObject("dataSource");     // Catch: Exception -> L10
        if (r3 != null) goto L6;
        return null;
    L6:
        JsonElement r4 = r3.get("intentName");     // Catch: Exception -> L10
        if (r4 == null) goto L13;
        return r4.getAsString();
    L13:
        return null;
    L14:
        return null;
    }

    private final boolean c(String r6) {
        JsonObject r7 = JsonParser.parseString(r6).getAsJsonObject().getAsJsonObject("ext");     // Catch: Exception -> L12
        if (r7 != null) goto L6;
        return false;
    L6:
        ILogDepend.Companion.i(TAG, "to_server: " + r7.get("to_server"));     // Catch: Exception -> L12
        JsonElement r5 = r7.get("to_server");     // Catch: Exception -> L12
        if (r5 == null) goto L9;
        String r8 = r5.getAsString();     // Catch: Exception -> L12
    L10:
        return o.a(r8, "false");
    L9:
        r8 = null;
    L15:
        return false;
    }

    private final void c() {
        if (g == false) goto L6;
        ILogDepend.Companion.d(TAG, "registerQuerySendObserverIfNeeded skipped: observer already registered");
        return;
    L6:
        g = true;
        ILogDepend.Companion.i(TAG, "registerQuerySendObserverIfNeeded register query send observer");
        com.obric.agent.k.f15191a.a((com.obric.agent.im.d) ZeusTransformUtils.preCheckCast(h, com.obric.agent.im.d.class, "com.obric.aiagent.plugin"));
    }
}
