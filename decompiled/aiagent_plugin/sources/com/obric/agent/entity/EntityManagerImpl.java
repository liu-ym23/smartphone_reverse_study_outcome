package com.obric.agent.entity;

import android.net.Uri;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.keva.Keva;
import com.google.android.material.timepicker.TimeModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.agent.IEntityManager;
import com.obric.agent.o;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.a.p;
import d.c.b.a.l;
import d.g;
import d.h.a.m;
import d.h.b.ac;
import d.h.b.ae;
import d.h.b.h;
import d.n;
import d.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;
import kotlinx.coroutines.bs;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: EntityManagerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EntityManagerImpl implements IEntityManager {
    private static final String CACHED_DELETE_ENTITY = "cached_delete_entity";
    private static final String CACHED_ECA_ENTITY_MAP = "cached_eca_entity_map";
    private static final String CACHED_ENTITY_MAP = "cached_entity_map";
    private static final String CACHED_LOCAL_ENTITY = "cached_local_entity";
    private static final String CACHED_VIRTUAL_ENTITY_MAP = "cached_virtual_entity_map";
    private static final Set<String> CLOCK_INTENTS = null;
    public static final a Companion = null;
    private static final String ENTITY_PREFIX = "$E_";
    private static final String LOCAL_PREFIX = "$NE_";
    private static final int MAX_COUNT_ENTITY = 100;
    private static final int MAX_LOCAL_ENTITY = 100;
    private static final int MAX_VIRTUAL_ENTITY = 10;
    private static final Set<String> MEMORY_INTENTS = null;
    private static final String TAG = "EntityManagerImpl";
    private static final String VIRTUAL_ENTITY_PREFIX = "$E_A";
    private final c cachedDeleteEntities;
    private final d.f gson$delegate;
    private final Object idLock;
    private final Keva keva;
    private final o<String, AppEntity> mCachedDeleteEntityMap;
    private final o<String, AppEntity> mCachedEcaEntityMap;
    private final o<String, AppEntity> mCachedEntityMap;
    private final o<String, AppEntity> mCachedLocalEntityMap;
    private final o<String, List<String>> mCachedVirtualEntityMap;
    private String mCurActionId;
    private String mCurActionName;
    private List<String> noChangeForECAid;
    private final bp persistDispatcher;

    /* JADX INFO: compiled from: EntityManagerImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: EntityManagerImpl.kt */
    @d.c.b.a.f(b = "EntityManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.entity.EntityManagerImpl$addVirtualEntitiesInternal$1$3")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EntityManagerImpl f14448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14450d;

        b(EntityManagerImpl r3, String r4, String r5, d.c.d<? super b> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14448b = r3;
            this.f14449c = r4;
            this.f14450d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f14448b, this.f14449c, this.f14450d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f14447a != 0) goto L7;
            d.o.a(r3);
            EntityManagerImpl.access$getKeva$p(this.f14448b).storeString(EntityManagerImpl.CACHED_VIRTUAL_ENTITY_MAP, this.f14449c);
            EntityManagerImpl.access$getKeva$p(this.f14448b).storeString(EntityManagerImpl.CACHED_LOCAL_ENTITY, this.f14450d);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EntityManagerImpl.kt */
    public static final class c extends LinkedHashMap<String, List<AppEntity>> {
        c() {
            super(10, 0.75f, true);
        }

        public Collection<List<AppEntity>> a() {
            return super.values();
        }

        public List<AppEntity> a(String r2) {
            return (List) ZeusTransformUtils.preCheckCast(super.get(r2), List.class, "com.obric.aiagent.plugin");
        }

        public List<AppEntity> a(String r3, List<AppEntity> r4) {
            return (List) ZeusTransformUtils.preCheckCast(super.getOrDefault(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin")), List.class, "com.obric.aiagent.plugin");
        }

        public boolean a(List<AppEntity> r3) {
            return super.containsValue((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        public int b() {
            return super.size();
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public boolean b(String r3, List<AppEntity> r4) {
            return super.remove(r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
        }

        public List<AppEntity> c(String r2) {
            return (List) ZeusTransformUtils.preCheckCast(super.remove(r2), List.class, "com.obric.aiagent.plugin");
        }

        public Set<Map.Entry<String, List<AppEntity>>> c() {
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
            if (r3 != null) goto L4;
            boolean r0 = true;
        L5:
            if (r0 == true) goto L9;
            return false;
        L9:
            return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"));
        L4:
            r0 = ae.e(r3);
            goto L5
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, List<AppEntity>>> entrySet() {
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
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
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
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L5;
            return false;
        L5:
            if (r4 != null) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == true) goto L11;
            return false;
        L11:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"));
        L7:
            r0 = ae.e(r4);
            goto L8
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<List<AppEntity>> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, List<AppEntity>> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= 10) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: EntityManagerImpl.kt */
    @d.c.b.a.f(b = "EntityManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.entity.EntityManagerImpl$init$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EntityManagerImpl f14452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f14453c;

        d(EntityManagerImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14452b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f14452b, r5);
            r0.f14453c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f14451a != 0) goto L107;
            d.o.a(r9);
            am r10 = (am) ZeusTransformUtils.preCheckCast(this.f14453c, am.class, "com.obric.aiagent.plugin");
            Object r11 = EntityManagerImpl.access$getIdLock$p(this.f14452b);
            EntityManagerImpl r8 = this.f14452b;
            monitor-enter(r11);
            Object r2 = null;
            String r0 = EntityManagerImpl.access$getKeva$p(r8).getString(EntityManagerImpl.CACHED_ENTITY_MAP, null);     // Catch: Throwable -> L103
            boolean r1 = false;
            if (r0 != null) goto L108;
        L28:
            String r3 = EntityManagerImpl.access$getKeva$p(r8).getString(EntityManagerImpl.CACHED_ECA_ENTITY_MAP, null);     // Catch: Throwable -> L103
            if (r3 != null) goto L110;
        L46:
            String r4 = EntityManagerImpl.access$getKeva$p(r8).getString(EntityManagerImpl.CACHED_DELETE_ENTITY, null);     // Catch: Throwable -> L103
            if (r4 != null) goto L114;
        L64:
            String r5 = EntityManagerImpl.access$getKeva$p(r8).getString(EntityManagerImpl.CACHED_VIRTUAL_ENTITY_MAP, null);     // Catch: Throwable -> L103
            if (r5 != null) goto L116;
        L82:
            String r6 = EntityManagerImpl.access$getKeva$p(r8).getString(EntityManagerImpl.CACHED_LOCAL_ENTITY, null);     // Catch: Throwable -> L103
            if (r6 != null) goto L118;
        L99:
            x r12 = x.f38692a;     // Catch: Throwable -> L103
            monitor-exit(r11);
            return x.f38692a;
        L118:
            n.a r7 = n.f38560a;     // Catch: Throwable -> L86
            Object r13 = n.f((LinkedHashMap) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r6, new EntityManagerImpl$init$1$1$5$cachedLocalEntityMap$1$1().getType()), LinkedHashMap.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L86
        L89:
            if (n.b(r13) == true) goto L92;
            r2 = r13;
        L92:
            LinkedHashMap r14 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r2, LinkedHashMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            Map r15 = (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            if (r15 != null) goto L95;
        L96:
            r1 = true;
        L97:
            if (r1 == true) goto L99;
            EntityManagerImpl.access$getMCachedLocalEntityMap$p(r8).putAll((Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L103
            goto L99
        L95:
            if (r15.isEmpty() == false) goto L97;
        L86:
            th = move-exception;
            n.a r16 = n.f38560a;     // Catch: Throwable -> L103
            r13 = n.f(d.o.a(th));     // Catch: Throwable -> L103
            goto L89
        L116:
            n.a r17 = n.f38560a;     // Catch: Throwable -> L68
            Object r18 = n.f((LinkedHashMap) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r5, new EntityManagerImpl$init$1$1$4$cachedVirtualEntityMap$1$1().getType()), LinkedHashMap.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L68
        L71:
            if (n.b(r18) == false) goto L73;
            r18 = null;
        L73:
            LinkedHashMap r19 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r18, LinkedHashMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            Map r20 = (Map) ZeusTransformUtils.preCheckCast(r19, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            if (r20 != null) goto L76;
        L79:
            boolean r21 = true;
        L80:
            if (r21 == true) goto L82;
            EntityManagerImpl.access$getMCachedVirtualEntityMap$p(r8).putAll((Map) ZeusTransformUtils.preCheckCast(r19, Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L103
            goto L82
        L76:
            if (r20.isEmpty() == true) goto L79;
            r21 = false;
        L68:
            th = move-exception;
            n.a r22 = n.f38560a;     // Catch: Throwable -> L103
            r18 = n.f(d.o.a(th));     // Catch: Throwable -> L103
            goto L71
        L114:
            n.a r23 = n.f38560a;     // Catch: Throwable -> L50
            Object r24 = n.f((LinkedHashMap) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r4, new EntityManagerImpl$init$1$1$3$cachedDeleteEntityMap$1$1().getType()), LinkedHashMap.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L50
        L53:
            if (n.b(r24) == false) goto L55;
            r24 = null;
        L55:
            LinkedHashMap r25 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r24, LinkedHashMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            Map r26 = (Map) ZeusTransformUtils.preCheckCast(r25, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            if (r26 != null) goto L58;
        L61:
            boolean r27 = true;
        L62:
            if (r27 == true) goto L64;
            EntityManagerImpl.access$getMCachedDeleteEntityMap$p(r8).putAll((Map) ZeusTransformUtils.preCheckCast(r25, Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L103
            goto L64
        L58:
            if (r26.isEmpty() == true) goto L61;
            r27 = false;
        L50:
            th = move-exception;
            n.a r28 = n.f38560a;     // Catch: Throwable -> L103
            r24 = n.f(d.o.a(th));     // Catch: Throwable -> L103
            goto L53
        L110:
            n.a r29 = n.f38560a;     // Catch: Throwable -> L32
            Object r30 = n.f((LinkedHashMap) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r3, new EntityManagerImpl$init$1$1$2$cachedEcaEntityMap$1$1().getType()), LinkedHashMap.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L32
        L35:
            if (n.b(r30) == false) goto L37;
            r30 = null;
        L37:
            LinkedHashMap r31 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r30, LinkedHashMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            Map r32 = (Map) ZeusTransformUtils.preCheckCast(r31, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            if (r32 != null) goto L40;
        L43:
            boolean r33 = true;
        L44:
            if (r33 == true) goto L46;
            EntityManagerImpl.access$getMCachedEcaEntityMap$p(r8).putAll((Map) ZeusTransformUtils.preCheckCast(r31, Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L103
            goto L46
        L40:
            if (r32.isEmpty() == true) goto L43;
            r33 = false;
        L32:
            th = move-exception;
            n.a r34 = n.f38560a;     // Catch: Throwable -> L103
            r30 = n.f(d.o.a(th));     // Catch: Throwable -> L103
            goto L35
        L108:
            n.a r35 = n.f38560a;     // Catch: Throwable -> L11
            Object r36 = n.f((LinkedHashMap) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r0, new EntityManagerImpl$init$1$1$1$cachedEntityMap$1$1().getType()), LinkedHashMap.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        L14:
            if (n.b(r36) == false) goto L16;
            r36 = null;
        L16:
            LinkedHashMap r37 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r36, LinkedHashMap.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            Map r38 = (Map) ZeusTransformUtils.preCheckCast(r37, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            if (r38 != null) goto L19;
        L22:
            boolean r39 = true;
        L23:
            if (r39 == true) goto L28;
            Collection r40 = r37.values();     // Catch: Throwable -> L103
            d.h.b.o.c(r40, "<get-values>(...)");     // Catch: Throwable -> L103
            Iterator r41 = ((Iterable) ZeusTransformUtils.preCheckCast(r40, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L103
        L26:
            if (r41.hasNext() == false) goto L28;
            AppEntity r42 = (AppEntity) ZeusTransformUtils.preCheckCast(r41.next(), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            Map r43 = (Map) ZeusTransformUtils.preCheckCast(EntityManagerImpl.access$getMCachedEntityMap$p(r8), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L103
            d.h.b.o.a(r42);     // Catch: Throwable -> L103
            r43.put(EntityManagerImpl.access$entityCacheKey(r8, r42), r42);     // Catch: Throwable -> L103
            goto L26
        L19:
            if (r38.isEmpty() == true) goto L22;
            r39 = false;
        L11:
            th = move-exception;
            n.a r44 = n.f38560a;     // Catch: Throwable -> L103
            r36 = n.f(d.o.a(th));     // Catch: Throwable -> L103
        L103:
            th = move-exception;
            throw th;
        L107:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EntityManagerImpl.kt */
    @d.c.b.a.f(b = "EntityManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.entity.EntityManagerImpl$persistEntityCaches$1")
    static final class e extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EntityManagerImpl f14455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14456c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14457d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f14458e;

        e(EntityManagerImpl r3, String r4, String r5, String r6, d.c.d<? super e> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14455b = r3;
            this.f14456c = r4;
            this.f14457d = r5;
            this.f14458e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f14455b, this.f14456c, this.f14457d, this.f14458e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f14454a != 0) goto L10;
            d.o.a(r3);
            EntityManagerImpl.access$getKeva$p(this.f14455b).storeString(EntityManagerImpl.CACHED_ENTITY_MAP, this.f14456c);
            EntityManagerImpl.access$getKeva$p(this.f14455b).storeString(EntityManagerImpl.CACHED_ECA_ENTITY_MAP, this.f14457d);
            String r4 = this.f14458e;
            if (r4 == null) goto L8;
            EntityManagerImpl.access$getKeva$p(this.f14455b).storeString(EntityManagerImpl.CACHED_DELETE_ENTITY, r4);
        L8:
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: EntityManagerImpl.kt */
    @d.c.b.a.f(b = "EntityManagerImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.entity.EntityManagerImpl$removeEntities$1$2")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ EntityManagerImpl f14460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14461c;

        f(EntityManagerImpl r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14460b = r3;
            this.f14461c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f14460b, this.f14461c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f14459a != 0) goto L7;
            d.o.a(r2);
            EntityManagerImpl.access$getKeva$p(this.f14460b).storeString(EntityManagerImpl.CACHED_DELETE_ENTITY, this.f14461c);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Gson lambda$ilOwPT0qUqYzkxAwvTHULU_7MRo() {
        return gson_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$lIL4BCMHYQpL0--GlNvRNN3xJvU, reason: not valid java name */
    public static /* synthetic */ boolean m72lambda$lIL4BCMHYQpL0GlNvRNN3xJvU(List r0, JsonElement r1) {
        return traverseJsonObject$lambda$35(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$nOZkHR8Z32mAeUAS-2TgPHBs2nk, reason: not valid java name */
    public static /* synthetic */ Thread m73lambda$nOZkHR8Z32mAeUAS2TgPHBs2nk(Runnable r0) {
        return persistDispatcher$lambda$1(r0);
    }

    public EntityManagerImpl() {
        this.gson$delegate = g.a($$Lambda$EntityManagerImpl$ilOwPT0qUqYzkxAwvTHULU_7MRo.INSTANCE);
        this.idLock = new Object();
        this.mCurActionId = "";
        this.mCurActionName = "";
        ac r0 = new ac(3);
        r0.a(com.obric.agent.dm.g.a());
        r0.b("System_QAWithSearch");
        r0.b("System_UserConfirm");
        this.noChangeForECAid = p.b(r0.a(new String[r0.a()]));
        this.keva = Keva.getRepo("entities", 0);
        ExecutorService r1 = Executors.newSingleThreadExecutor($$Lambda$EntityManagerImpl$nOZkHR8Z32mAeUAS2TgPHBs2nk.INSTANCE);
        d.h.b.o.c(r1, "newSingleThreadExecutor(...)");
        this.persistDispatcher = br.a(r1);
        this.mCachedEntityMap = new o(100, false, 2, null);
        this.mCachedEcaEntityMap = new o(100, false, 2, null);
        this.mCachedDeleteEntityMap = new o(100, false, 2, null);
        this.mCachedVirtualEntityMap = new o(10, false, 2, null);
        this.mCachedLocalEntityMap = new o(100, false, 2, null);
        this.cachedDeleteEntities = new c();
    }

    public static final /* synthetic */ String access$entityCacheKey(EntityManagerImpl r0, AppEntity r1) {
        return r0.entityCacheKey(r1);
    }

    public static final /* synthetic */ Object access$getIdLock$p(EntityManagerImpl r0) {
        return r0.idLock;
    }

    public static final /* synthetic */ Keva access$getKeva$p(EntityManagerImpl r0) {
        return r0.keva;
    }

    public static final /* synthetic */ o access$getMCachedDeleteEntityMap$p(EntityManagerImpl r0) {
        return r0.mCachedDeleteEntityMap;
    }

    public static final /* synthetic */ o access$getMCachedEcaEntityMap$p(EntityManagerImpl r0) {
        return r0.mCachedEcaEntityMap;
    }

    public static final /* synthetic */ o access$getMCachedEntityMap$p(EntityManagerImpl r0) {
        return r0.mCachedEntityMap;
    }

    public static final /* synthetic */ o access$getMCachedLocalEntityMap$p(EntityManagerImpl r0) {
        return r0.mCachedLocalEntityMap;
    }

    public static final /* synthetic */ o access$getMCachedVirtualEntityMap$p(EntityManagerImpl r0) {
        return r0.mCachedVirtualEntityMap;
    }

    static {
        Companion = new a(null);
        CLOCK_INTENTS = ax.a(new String[]{"Clock_TurnOnAlarm", "Clock_DeleteAlarm", "Clock_TurnOffAlarm", "Clock_StartCountdown", "Clock_PauseCountdown", "Clock_DeleteCountdown"});
        MEMORY_INTENTS = ax.a(new String[]{"Memory_Produce", "Memory_Delete"});
    }

    private final Gson getGson() {
        return (Gson) ZeusTransformUtils.preCheckCast(this.gson$delegate.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).create();
    }

    private static final Thread persistDispatcher$lambda$1(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "EntityManagerPersist");
    }

    @Override // com.obric.agent.IEntityManager
    public void init() {
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(this.persistDispatcher, d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new d(this, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    @Override // com.obric.agent.IEntityManager
    public List<AppEntity> getEntityByEcaId(String r6) {
        d.h.b.o.e(r6, DbHelper.COL_ID);
        Object r0 = this.idLock;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (d.o.o.b(r6, VIRTUAL_ENTITY_PREFIX, false, 2, null) == true) goto L11;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap.get(r6), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r1 == null) goto L11;
        this.mCachedEntityMap.get(entityCacheKey(r1));     // Catch: Throwable -> L25
        List<AppEntity> r5 = p.a(r1);     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r5;
    L11:
        List r7 = (List) ZeusTransformUtils.preCheckCast(this.mCachedVirtualEntityMap.get(r6), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r7 == null) goto L22;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L25
    L15:
        if (r9.hasNext() == false) goto L19;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedLocalEntityMap.get(r3), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r4 == null) goto L15;
        r2.add(r4);     // Catch: Throwable -> L25
        goto L15
    L19:
        List<AppEntity> r10 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r10;
    L22:
        List<AppEntity> r11 = p.b();     // Catch: Throwable -> L25
        monitor-exit(r0);
        return r11;
    }

    @Override // com.obric.agent.IEntityManager
    public void addEntity(AppEntity r2) {
        d.h.b.o.e(r2, "entity");
        Object r0 = this.idLock;
        monitor-enter(r0);
        addEntitiesInternal(p.a(r2));     // Catch: Throwable -> L7
        x r1 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IEntityManager
    public void addEntities(List<? extends AppEntity> r3) {
        List<? extends AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "entities");
        Object r0 = this.idLock;
        monitor-enter(r0);
        addEntitiesInternal(r4);     // Catch: Throwable -> L7
        x r2 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IEntityManager
    public String replaceEntity(String r8, AppEntity r9) {
        d.h.b.o.e(r8, "previousEcaId");
        d.h.b.o.e(r9, "entity");
        Object r0 = this.idLock;
        monitor-enter(r0);
        String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L27
        String r4 = null;
        if (d.o.o.b(r10, ENTITY_PREFIX, false, 2, null) == true) goto L8;
        monitor-exit(r0);
        return null;
    L8:
        this.mCachedEcaEntityMap.get(r10);     // Catch: Throwable -> L27
        com.obric.agent.entity.c r1 = com.obric.agent.entity.c.f14464a;     // Catch: Throwable -> L27
        Set<String> r2 = this.mCachedEcaEntityMap.keySet();     // Catch: Throwable -> L27
        d.h.b.o.c(r2, "<get-keys>(...)");     // Catch: Throwable -> L27
        String r3 = r1.a((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"), r10, 100);     // Catch: Throwable -> L27
        if (r3 != null) goto L12;
        monitor-exit(r0);
        return null;
    L12:
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap.remove(r3), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r5 == null) goto L21;
        String r6 = entityCacheKey(r5);     // Catch: Throwable -> L27
        AppEntity r7 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedEntityMap.get(r6), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r7 == null) goto L17;
        String r11 = r7.getEcaId();     // Catch: Throwable -> L27
    L19:
        if (d.h.b.o.a(r11, r3) == false) goto L21;
        this.mCachedEntityMap.remove(r6);     // Catch: Throwable -> L27
        goto L21
    L17:
        r11 = null;
    L21:
        r9.setEcaId(r3);     // Catch: Throwable -> L27
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedEntityMap, Map.class, "com.obric.aiagent.plugin")).put(entityCacheKey(r9), r9);     // Catch: Throwable -> L27
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r3, r9);     // Catch: Throwable -> L27
        if (this.mCachedDeleteEntityMap.remove(r9.getId() + r9.getType()) == null) goto L24;
        r4 = EntityExtKt.a().toJson(this.mCachedDeleteEntityMap);     // Catch: Throwable -> L27
    L24:
        persistEntityCaches(r4);     // Catch: Throwable -> L27
        ILogDepend.Companion.i(TAG, "replaceEntity, previous=" + r10 + ", replacement=" + r3 + ", type=" + r9.getType());     // Catch: Throwable -> L27
        monitor-exit(r0);
        return r3;
    L27:
        th = move-exception;
        throw th;
    }

    private final String entityCacheKey(AppEntity r2) {
        String r0 = com.obric.agent.entity.a.a(r2);
        String r1 = scheduleEventServerId(r2);
        if (r1 != null) goto L6;
        return r0;
    L6:
        return r0 + "_event_" + r1;
    }

    private final String scheduleEventServerId(AppEntity r4) {
        Object r1 = null;
        if (ZeusTransformUtils.instanceOf(r4, ScheduleEntity.class) == true) goto L5;
        return null;
    L5:
        ExtraEntity r5 = r4.getExtraEntity("extra1");
        if (r5 == null) goto L8;
        Object r6 = r5.getValue();
    L10:
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L12;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");
    L13:
        if (r7 != null) goto L50;
        return null;
    L50:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L42
        EntityManagerImpl r3 = (EntityManagerImpl) ZeusTransformUtils.preCheckCast(this, EntityManagerImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        JsonElement r8 = JsonParserExt.INSTANCE.parseString(r7);     // Catch: Throwable -> L42
        if (r8.isJsonObject() == true) goto L19;
        r8 = null;
    L19:
        if (r8 == null) goto L39;
        JsonObject r9 = r8.getAsJsonObject();     // Catch: Throwable -> L42
        if (r9 == null) goto L39;
        JsonElement r10 = r9.get("eventServerId");     // Catch: Throwable -> L42
        if (r10 == null) goto L39;
        if (r10.isJsonPrimitive() == true) goto L28;
        r10 = null;
    L28:
        if (r10 == null) goto L39;
        String r11 = r10.getAsString();     // Catch: Throwable -> L42
        if (r11 == null) goto L39;
        String r12 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L42
        if (r12 == null) goto L39;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == false) goto L39;
    L40:
        Object r14 = n.f(r12);     // Catch: Throwable -> L42
    L45:
        if (n.b(r14) == true) goto L49;
        r1 = r14;
    L49:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L36:
        r13 = false;
    L39:
        r12 = null;
    L42:
        th = move-exception;
        n.a r15 = n.f38560a;
        r14 = n.f(d.o.a(th));
        goto L45
    L12:
        r7 = null;
        goto L13
    L8:
        r6 = null;
        goto L10
    }

    @Override // com.obric.agent.IEntityManager
    public void removeEntities(List<? extends AppEntity> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "entities");
        Object r0 = this.idLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r10.isEmpty() == false) goto L8;
        monitor-exit(r0);
        return;
    L8:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L15
    L10:
        if (r11.hasNext() == false) goto L12;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r11.next(), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedDeleteEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r1.getId() + r1.getType(), r1);     // Catch: Throwable -> L15
        ILogDepend.Companion.d(TAG, "mCachedDeleteEntityMap add " + r1.getId());     // Catch: Throwable -> L15
        goto L10
    L12:
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(this.persistDispatcher, d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new f(this, EntityExtKt.a().toJson(this.mCachedDeleteEntityMap), null), m.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Throwable -> L15
        monitor-exit(r0);
    }

    private final void addEntitiesInternal(List<? extends AppEntity> r11) {
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        boolean r2 = false;
    L3:
        String r4 = null;
        if (r12.hasNext() == false) goto L29;
        AppEntity r3 = (AppEntity) ZeusTransformUtils.preCheckCast(r12.next(), AppEntity.class, "com.obric.aiagent.plugin");
        String r5 = r3.getEcaId();
        if (r5 != null) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == true) goto L3;
        if (this.mCachedDeleteEntityMap.remove(r3.getId() + r3.getType()) == null) goto L16;
        ILogDepend.Companion.d(TAG, "mCachedDeleteEntityMap remove " + r3.getId());
        r2 = true;
    L16:
        String r7 = entityCacheKey(r3);
        if (((Map) ZeusTransformUtils.preCheckCast(this.mCachedEntityMap, Map.class, "com.obric.aiagent.plugin")).containsKey(r7) == false) goto L18;
        AppEntity r8 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedEntityMap.get(r7), AppEntity.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L27;
        r4 = r8.getEcaId();
    L27:
        if (r4 == null) goto L3;
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r7, r3);
        r3.setEcaId(r4);
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r4, r3);
        goto L3
    L18:
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r7, r3);
        if (this.mCachedEcaEntityMap.a() != null) goto L21;
        StringBuilder r9 = new StringBuilder().append(ENTITY_PREFIX);
        String r10 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(this.mCachedEcaEntityMap.size())}, 1));
        d.h.b.o.c(r10, "format(...)");
        String r13 = r9.append(r10).toString();
    L22:
        if (r13 == null) goto L3;
        r3.setEcaId(r13);
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r13, r3);
        goto L3
    L21:
        r13 = (String) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap.a(), String.class, "com.obric.aiagent.plugin");
        goto L22
    L8:
        if (d.o.o.b(r5, ENTITY_PREFIX, false, 2, null) == true) goto L10;
        r6 = true;
        goto L11
    L29:
        if (r2 == false) goto L31;
        r4 = EntityExtKt.a().toJson(this.mCachedDeleteEntityMap);
    L31:
        persistEntityCaches(r4);
    }

    static /* synthetic */ void persistEntityCaches$default(EntityManagerImpl r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.persistEntityCaches(r1);
    }

    private final void persistEntityCaches(String r14) {
        String r2 = EntityExtKt.a().toJson(this.mCachedEntityMap);
        String r3 = EntityExtKt.a().toJson(this.mCachedEcaEntityMap);
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(this.persistDispatcher, d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new e(this, r2, r3, r14, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    @Override // com.obric.agent.IEntityManager
    public com.obric.agent.entity.b entityNlg(AppEntity r4, boolean r5) {
        d.h.b.o.e(r4, "entity");
        if (r4.getType() == 401) goto L5;
        return null;
    L5:
        return new com.obric.agent.entity.b(true, new com.obric.agent.entity.d().a((ScheduleEntity) ZeusTransformUtils.preCheckCast(r4, ScheduleEntity.class, "com.obric.aiagent.plugin"), 0));
    }

    @Override // com.obric.agent.IEntityManager
    public com.obric.agent.entity.b entityNlg(List<? extends AppEntity> r5, boolean r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "entities");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L3:
        ScheduleEntity r2 = null;
        if (r9.hasNext() == false) goto L10;
        AppEntity r1 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ScheduleEntity.class) == false) goto L8;
        r2 = (ScheduleEntity) ZeusTransformUtils.preCheckCast(r1, ScheduleEntity.class, "com.obric.aiagent.plugin");
    L8:
        if (r2 == null) goto L3;
        r8.add(r2);
        goto L3
    L10:
        List<ScheduleEntity> r10 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L13;
        return null;
    L13:
        return new com.obric.agent.entity.d().a(r10, r6);
    }

    @Override // com.obric.agent.IEntityManager
    public List<AppEntity> checkDeletedEntitie(String r1, long r2) {
        Object r3 = this.idLock;
        monitor-enter(r3);
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.cachedDeleteEntities.get(String.valueOf(r2)), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        List<AppEntity> r4 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(r3);
        return r4;
    L8:
        r4 = null;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IEntityManager
    public List<AppEntity> checkDeletedEntitie(List<? extends AppEntity> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "entities");
        Object r0 = this.idLock;
        monitor-enter(r0);
        List<AppEntity> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L13
    L6:
        if (r9.hasNext() == false) goto L11;
        AppEntity r2 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (((Map) ZeusTransformUtils.preCheckCast(this.mCachedDeleteEntityMap, Map.class, "com.obric.aiagent.plugin")).containsKey(r2.getId() + r2.getType()) == false) goto L6;
        r1.add(r2);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r0);
        return r1;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.agent.IEntityManager
    public String replaceECAIdToEntity(String r9, long r10) {
        if (r9 != null) goto L5;
        return null;
    L5:
        ISecureLogDepend.Companion.i(TAG, "before replaceECAIdToEntity: " + r10 + " content " + r9);
        this.mCurActionName = "";
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap, Map.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L8;
    L17:
        ISecureLogDepend.Companion.i(TAG, "after replaceECAIdToEntity: " + r10 + " result " + r9);
        return r9;
    L8:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ENTITY_PREFIX, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L17;
        JsonObject r11 = JsonParserExt.INSTANCE.parseString(r9).getAsJsonObject();
        Object r7 = this.idLock;
        monitor-enter(r7);
        d.h.b.o.a(r11);     // Catch: Throwable -> L14
        traverseJsonObject$default(this, r11, r10, null, 4, null);     // Catch: Throwable -> L14
        x r8 = x.f38692a;     // Catch: Throwable -> L14
        monitor-exit(r7);
        r9 = r11.toString();
        d.h.b.o.c(r9, "toString(...)");
    L14:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void traverseJsonObject$default(EntityManagerImpl r0, JsonObject r1, long r2, String r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = "";
    L5:
        r0.traverseJsonObject(r1, r2, r4);
    }

    private final void traverseJsonObject(JsonObject r21, long r22, String r24) {
        JsonObject r1 = r21;
        Iterator<Map.Entry<String, JsonElement>> r4 = r21.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L125;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r5);
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r7 = (JsonElement) ZeusTransformUtils.preCheckCast(r5.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r6, "actionName") == false) goto L13;
        if (r7.isJsonPrimitive() == false) goto L13;
        if (r7.getAsJsonPrimitive().isString() == false) goto L13;
        String r8 = r7.getAsString();
        d.h.b.o.c(r8, "getAsString(...)");
        this.mCurActionName = r8;
    L19:
        String r9 = "getAsJsonObject(...)";
        if (r7.isJsonObject() == true) goto L21;
        String r14 = "null cannot be cast to non-null type com.google.gson.JsonObject";
        if (r7.isJsonPrimitive() == false) goto L64;
        if (r7.getAsJsonPrimitive().isString() == false) goto L64;
        JsonElement r10 = JsonParserExt.INSTANCE.parseString(r7.getAsString());     // Catch: Exception -> L28
        d.h.b.o.a(r10, "null cannot be cast to non-null type com.google.gson.JsonObject");     // Catch: Exception -> L28
        JsonObject r11 = (JsonObject) ZeusTransformUtils.preCheckCast(r10, JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        d.h.b.o.a(r6);     // Catch: Exception -> L28
        traverseJsonObject(r11, r22, r6);     // Catch: Exception -> L28
        r1.addProperty(r6, getGson().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r11, JsonElement.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L28
    L28:
        AppEntity r12 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap.get(r7.getAsString()), AppEntity.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L48;
        this.mCachedEntityMap.get(entityCacheKey(r12));
        if (this.noChangeForECAid.contains(this.mCurActionName) == true) goto L40;
        if (d.h.b.o.a(this.mCurActionName, "Office_SendMessage") == false) goto L38;
        if (d.h.b.o.a(r24, "targetId") == false) goto L38;
        r1.add(r6, (JsonElement) ZeusTransformUtils.preCheckCast(new JsonPrimitive(r12.getId()), JsonElement.class, "com.obric.aiagent.plugin"));
    L38:
        r1.add(r6, getGson().toJsonTree(r12));
    L40:
        AppEntity r13 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedDeleteEntityMap.get(r12.getId() + r12.getType()), AppEntity.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L48;
        List r15 = (List) ZeusTransformUtils.preCheckCast(this.cachedDeleteEntities.get(String.valueOf(r22)), List.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L45;
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L45:
        r15.add(r13);
        ((Map) ZeusTransformUtils.preCheckCast(this.cachedDeleteEntities, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r22), r15);
        ILogDepend.Companion.d(TAG, "DeleteEntity for questionId:" + r22 + " entity:{" + r13.getId() + '}');
    L48:
        if (this.noChangeForECAid.contains(this.mCurActionName) == true) goto L4;
        List r16 = (List) ZeusTransformUtils.preCheckCast(this.mCachedVirtualEntityMap.get(r7.getAsString()), List.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L4;
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r19 = r17.iterator();
    L53:
        if (r19.hasNext() == false) goto L57;
        AppEntity r20 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedLocalEntityMap.get((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.aiagent.plugin")), AppEntity.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L53;
        r18.add(r20);
        goto L53
    L57:
        List r23 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L4;
        Iterator r25 = ((Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L61:
        if (r25.hasNext() == false) goto L4;
        r1.add(r6, getGson().toJsonTree((AppEntity) ZeusTransformUtils.preCheckCast(r25.next(), AppEntity.class, "com.obric.aiagent.plugin")));
    L64:
        if (r7.isJsonArray() == false) goto L4;
        final List r26 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<Map.Entry<String, JsonElement>> r110 = r4;
        List r27 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator<JsonElement> r111 = r7.getAsJsonArray().iterator();
        d.h.b.o.c(r111, "iterator(...)");
    L67:
        if (r111.hasNext() == false) goto L116;
        r111 = r111;
        JsonElement r112 = (JsonElement) ZeusTransformUtils.preCheckCast(r111.next(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r112.isJsonObject() == true) goto L70;
        if (r112.isJsonPrimitive() == false) goto L67;
        if (r112.getAsJsonPrimitive().isString() == false) goto L67;
        String r113 = r9;
        JsonElement r28 = JsonParserExt.INSTANCE.parseString(r112.getAsString());     // Catch: Exception -> L127
        d.h.b.o.a(r28, r14);     // Catch: Exception -> L127
        JsonObject r29 = (JsonObject) ZeusTransformUtils.preCheckCast(r28, JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L127
        d.h.b.o.a(r6);     // Catch: Exception -> L127
        traverseJsonObject(r29, r22, r6);     // Catch: Exception -> L127
        d.h.b.o.a(r112);     // Catch: Exception -> L127
        r26.add(r112);     // Catch: Exception -> L127
        String r114 = r14;
        r27.add(new JsonPrimitive(getGson().toJson((JsonElement) ZeusTransformUtils.preCheckCast(r29, JsonElement.class, "com.obric.aiagent.plugin"))));     // Catch: Exception -> L126
    L113:
        r9 = r113;
        r14 = r114;
    L83:
        AppEntity r2 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedEcaEntityMap.get(r112.getAsString()), AppEntity.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L96;
        this.mCachedEntityMap.get(entityCacheKey(r2));
        if (this.noChangeForECAid.contains(this.mCurActionName) == true) goto L88;
        d.h.b.o.a(r112);
        r26.add(r112);
        JsonElement r30 = getGson().toJsonTree(r2);
        d.h.b.o.c(r30, "toJsonTree(...)");
        r27.add(r30);
    L88:
        AppEntity r3 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedDeleteEntityMap.get(r2.getId() + r2.getType()), AppEntity.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L96;
        List r31 = (List) ZeusTransformUtils.preCheckCast(this.cachedDeleteEntities.get(String.valueOf(r22)), List.class, "com.obric.aiagent.plugin");
        if (r31 != null) goto L93;
        r31 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L93:
        r31.add(r3);
        ((Map) ZeusTransformUtils.preCheckCast(this.cachedDeleteEntities, Map.class, "com.obric.aiagent.plugin")).put(String.valueOf(r22), r31);
        ILogDepend.Companion.d(TAG, "DeleteEntity for questionId:" + r22 + " entity:{" + r3.getId() + '}');
    L96:
        if (this.noChangeForECAid.contains(this.mCurActionName) == true) goto L113;
        List r32 = (List) ZeusTransformUtils.preCheckCast(this.mCachedVirtualEntityMap.get(r112.getAsString()), List.class, "com.obric.aiagent.plugin");
        if (r32 == null) goto L113;
        Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.aiagent.plugin");
        Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r35 = r33.iterator();
    L101:
        if (r35.hasNext() == false) goto L106;
        AppEntity r115 = (AppEntity) ZeusTransformUtils.preCheckCast(this.mCachedLocalEntityMap.get((String) ZeusTransformUtils.preCheckCast(r35.next(), String.class, "com.obric.aiagent.plugin")), AppEntity.class, "com.obric.aiagent.plugin");
        if (r115 == null) goto L101;
        r34.add(r115);
        goto L101
    L106:
        List r36 = (List) ZeusTransformUtils.preCheckCast(r34, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r36, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L113;
        d.h.b.o.a(r112);
        r26.add(r112);
        Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.aiagent.plugin");
        Collection r38 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r37, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r39 = r37.iterator();
    L110:
        if (r39.hasNext() == false) goto L112;
        r38.add(getGson().toJsonTree((AppEntity) ZeusTransformUtils.preCheckCast(r39.next(), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L110
    L112:
        r27.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r38, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
    L82:
        r114 = r14;
    L81:
        r113 = r9;
        goto L82
    L70:
        JsonObject r116 = r112.getAsJsonObject();
        d.h.b.o.c(r116, r9);
        d.h.b.o.a(r6);
        traverseJsonObject(r116, r22, r6);
        goto L67
    L116:
        JsonArray r40 = r7.getAsJsonArray();
        d.h.b.o.c(r40, "getAsJsonArray(...)");
        p.a((Iterable) ZeusTransformUtils.preCheckCast(r40, Iterable.class, "com.obric.aiagent.plugin"), new $$Lambda$EntityManagerImpl$lIL4BCMHYQpL0GlNvRNN3xJvU(r26));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r27, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L123;
        Iterator r41 = r27.iterator();
    L120:
        if (r41.hasNext() == false) goto L122;
        r7.getAsJsonArray().add((JsonElement) ZeusTransformUtils.preCheckCast(r41.next(), JsonElement.class, "com.obric.aiagent.plugin"));
        goto L120
    L122:
        r21.add(r6, r7);
        r1 = r21;
    L124:
        r4 = r110;
        goto L4
    L123:
        r1 = r21;
        goto L124
    L21:
        JsonObject r42 = r7.getAsJsonObject();
        d.h.b.o.c(r42, "getAsJsonObject(...)");
        d.h.b.o.a(r6);
        traverseJsonObject(r42, r22, r6);
    L13:
        if (d.h.b.o.a(r6, DbHelper.COL_ID) == false) goto L19;
        if (r7.isJsonPrimitive() == false) goto L19;
        if (r7.getAsJsonPrimitive().isString() == false) goto L19;
        String r43 = r7.getAsString();
        d.h.b.o.c(r43, "getAsString(...)");
        this.mCurActionId = r43;
        goto L19
    }

    private static final boolean traverseJsonObject$lambda$35(List r2, JsonElement r3) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin")).contains(r3);
    }

    @Override // com.obric.agent.IEntityManager
    public List<AppEntity> addVirtualEntities(List<? extends AppEntity> r5, String r6) {
        List<AppEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "entities");
        if (d.h.b.o.a(r6, "Phone_Delete") == true) goto L27;
        if (d.h.b.o.a(r6, "Messages_Delete") == true) goto L27;
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(CLOCK_INTENTS, Iterable.class, "com.obric.aiagent.plugin"), r6) == false) goto L15;
        if (r7.size() <= 50) goto L12;
        r7 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), 50);
    L12:
        addEntities(r7);
        return r7;
    L15:
        if (p.a((Iterable) ZeusTransformUtils.preCheckCast(MEMORY_INTENTS, Iterable.class, "com.obric.aiagent.plugin"), r6) == false) goto L22;
        if (r7.size() <= 50) goto L19;
        r7 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), 50);
    L19:
        addEntities(r7);
        return r7;
    L22:
        if (r7.size() <= 5) goto L24;
        r7 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), 5);
    L24:
        addEntities(r7);
        return r7;
    L27:
        return addVirtualEntitiesInternal(r7);
    }

    private final List<AppEntity> addVirtualEntitiesInternal(List<? extends AppEntity> r13) {
        List<AppEntity> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(TAG, "addVirtualEntitiesInternal: size " + r14.size() + " entities " + r14);
        ILogDepend.Companion.d(TAG, "addVirtualEntitiesInternal before mCachedEcaEntityMap " + this.mCachedEcaEntityMap + " \n mCachedVirtualEntityMap " + this.mCachedVirtualEntityMap + " \n mCachedLocalEntityMap " + this.mCachedLocalEntityMap);
        Object r0 = this.idLock;
        monitor-enter(r0);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (r14.size() <= 5) goto L7;
        d.m r1 = new d.m(p.c((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), 5), p.b((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), 5));     // Catch: Throwable -> L33
    L8:
        List<? extends AppEntity> r2 = (List) ZeusTransformUtils.preCheckCast(r1.c(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1.d(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        addEntities(r2);     // Catch: Throwable -> L33
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L26;
        AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(p.k(r3), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        if (this.mCachedVirtualEntityMap.a() != null) goto L13;
        StringBuilder r5 = new StringBuilder().append(VIRTUAL_ENTITY_PREFIX);     // Catch: Throwable -> L33
        String r6 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(this.mCachedVirtualEntityMap.size())}, 1));     // Catch: Throwable -> L33
        d.h.b.o.c(r6, "format(...)");     // Catch: Throwable -> L33
        String r7 = r5.append(r6).toString();     // Catch: Throwable -> L33
    L14:
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L33
    L16:
        if (r9.hasNext() == false) goto L23;
        AppEntity r10 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        if (this.mCachedLocalEntityMap.a() != null) goto L20;
        StringBuilder r11 = new StringBuilder().append(LOCAL_PREFIX);     // Catch: Throwable -> L33
        String r12 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(this.mCachedLocalEntityMap.size())}, 1));     // Catch: Throwable -> L33
        d.h.b.o.c(r12, "format(...)");     // Catch: Throwable -> L33
        String r15 = r11.append(r12).toString();     // Catch: Throwable -> L33
    L21:
        if (r15 == null) goto L16;
        r10.setEcaId(r15);     // Catch: Throwable -> L33
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedLocalEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r15, r10);     // Catch: Throwable -> L33
        r8.add(r15);     // Catch: Throwable -> L33
        goto L16
    L20:
        r15 = (String) ZeusTransformUtils.preCheckCast(this.mCachedLocalEntityMap.a(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
        goto L21
    L23:
        r4.setEcaId(r7);     // Catch: Throwable -> L33
        if (r7 == null) goto L26;
        ((Map) ZeusTransformUtils.preCheckCast(this.mCachedVirtualEntityMap, Map.class, "com.obric.aiagent.plugin")).put(r7, r8);     // Catch: Throwable -> L33
        goto L26
    L13:
        r7 = (String) ZeusTransformUtils.preCheckCast(this.mCachedVirtualEntityMap.a(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L33
    L26:
        i.a((am) ZeusTransformUtils.preCheckCast(bs.f39169a, am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(this.persistDispatcher, d.c.g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new b(this, EntityExtKt.a().toJson(this.mCachedVirtualEntityMap), EntityExtKt.a().toJson(this.mCachedLocalEntityMap), null), m.class, "com.obric.aiagent.plugin"), 2, null);     // Catch: Throwable -> L33
        monitor-exit(r0);
        if (r14.size() < 6) goto L31;
        r14 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin"), 6);
    L31:
        ILogDepend.Companion.d(TAG, "addVirtualEntitiesInternal after mCachedEcaEntityMap " + this.mCachedEcaEntityMap + " \n mCachedVirtualEntityMap " + this.mCachedVirtualEntityMap + " \n mCachedLocalEntityMap " + this.mCachedLocalEntityMap + " \n resultEntities " + r14);
        return r14;
    L7:
        r1 = new d.m(r14, p.b());     // Catch: Throwable -> L33
        goto L8
    }
}
