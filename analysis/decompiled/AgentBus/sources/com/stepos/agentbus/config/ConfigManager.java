package com.stepos.agentbus.config;

import c5.b;
import c7.r;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import d5.g;
import d5.l;
import d5.m;
import d7.a0;
import g7.d;
import i7.c;
import i7.e;
import i7.i;
import ia.b0;
import ia.d0;
import ia.f1;
import ia.x1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import k5.a;
import k5.q;
import k5.s;
import k5.t;
import kotlin.Metadata;
import la.j;
import la.k;
import p7.n;
import q7.f;
import w7.e0;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u0001:\u0001EB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b!\u0010\"J%\u0010$\u001a\u00020\u001e2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010 H\u0002¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0012¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0012¢\u0006\u0004\b(\u0010'J \u0010,\u001a\u00020\u00122\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b,\u0010-JG\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010 2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010 2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010 ¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0016¢\u0006\u0004\b1\u00102R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00104R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00105R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00106R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00107R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010\u0019\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010=R\u0014\u0010\u0017\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010?Rp\u0010B\u001a^\u0012(\u0012&\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001 A*\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010 0  A*.\u0012(\u0012&\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001 A*\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010 0 \u0018\u00010@0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR8\u0010D\u001a&\u0012\f\u0012\n A*\u0004\u0018\u00010\u001e0\u001e A*\u0012\u0012\f\u0012\n A*\u0004\u0018\u00010\u001e0\u001e\u0018\u00010@0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010C¨\u0006F"}, d2 = {"Lcom/stepos/agentbus/config/ConfigManager;", "", "Lcom/stepos/agentbus/config/ConfigProvider;", "provider", "Ld5/l;", "pool", "Lcom/squareup/moshi/Moshi;", "moshi", "Lk5/a;", "dispatchers", "Lk5/t;", "logger", "Lk5/q;", "internalBus", "<init>", "(Lcom/stepos/agentbus/config/ConfigProvider;Ld5/l;Lcom/squareup/moshi/Moshi;Lk5/a;Lk5/t;Lk5/q;)V", "Ld5/e;", "connection", "Lc7/r;", "attach", "(Ld5/e;)V", "target", "", "version", "", "scope", "", "ok", "sendApplied", "(Ld5/e;JLjava/lang/String;ZLg7/d;)Ljava/lang/Object;", "Lcom/stepos/agentbus/config/AgentBusConfig;", "c", "", "toMap", "(Lcom/stepos/agentbus/config/AgentBusConfig;)Ljava/util/Map;", "m", "fromMap", "(Ljava/util/Map;)Lcom/stepos/agentbus/config/AgentBusConfig;", "start", "()V", "stop", "Lc5/b;", "frame", "source", "handleUpdate", "(Lc5/b;Ld5/e;Lg7/d;)Ljava/lang/Object;", "patch", "mergePatch", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "currentVersion", "()J", "Lcom/stepos/agentbus/config/ConfigProvider;", "Ld5/l;", "Lcom/squareup/moshi/Moshi;", "Lk5/a;", "Lk5/t;", "Lk5/q;", "Lia/t;", "supervisor", "Lia/t;", "Lia/b0;", "Lia/b0;", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "Lcom/squareup/moshi/JsonAdapter;", "kotlin.jvm.PlatformType", "mapAdapter", "Lcom/squareup/moshi/JsonAdapter;", "configAdapter", "Companion", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConfigManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ConfigManager";
    private static final Moshi defaultMoshi;
    private final JsonAdapter<AgentBusConfig> configAdapter;
    private final a dispatchers;
    private final q internalBus;
    private final t logger;
    private final JsonAdapter<Map<String, Object>> mapAdapter;
    private final Moshi moshi;
    private final l pool;
    private final ConfigProvider provider;
    private final b0 scope;
    private final ia.t supervisor;
    private final AtomicLong version;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentbus/config/ConfigManager$Companion;", "", "<init>", "()V", "TAG", "", "defaultMoshi", "Lcom/squareup/moshi/Moshi;", "getDefaultMoshi", "()Lcom/squareup/moshi/Moshi;", "domain_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Moshi getDefaultMoshi() {
            return ConfigManager.defaultMoshi;
        }

        private Companion() {
        }
    }

    @e(c = "com.stepos.agentbus.config.ConfigManager$attach$1", f = "ConfigManager.kt", l = {71}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lia/b0;", "Lc7/r;", "<anonymous>", "(Lia/b0;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.stepos.agentbus.config.ConfigManager$attach$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements n {
        final /* synthetic */ d5.e $connection;
        int label;
        final /* synthetic */ ConfigManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(d5.e eVar, ConfigManager configManager, d dVar) {
            super(2, dVar);
            this.$connection = eVar;
            this.this$0 = configManager;
        }

        @Override // i7.a
        public final d create(Object obj, d dVar) {
            return new AnonymousClass1(this.$connection, this.this$0, dVar);
        }

        @Override // p7.n
        public final Object invoke(b0 b0Var, d dVar) {
            return ((AnonymousClass1) create(b0Var, dVar)).invokeSuspend(r.f1986a);
        }

        @Override // i7.a
        public final Object invokeSuspend(Object obj) {
            h7.a aVar = h7.a.f4212f;
            int i2 = this.label;
            if (i2 == 0) {
                e0.N(obj);
                j jVarA = this.$connection.a();
                final ConfigManager configManager = this.this$0;
                final d5.e eVar = this.$connection;
                k kVar = new k() { // from class: com.stepos.agentbus.config.ConfigManager.attach.1.1
                    @Override // la.k
                    public final Object emit(b bVar, d dVar) {
                        Object objHandleUpdate;
                        return (q7.k.a(bVar.e(), "stepclaw.config.update") && (objHandleUpdate = configManager.handleUpdate(bVar, eVar, dVar)) == h7.a.f4212f) ? objHandleUpdate : r.f1986a;
                    }
                };
                this.label = 1;
                if (jVarA.x(kVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e0.N(obj);
            }
            return r.f1986a;
        }
    }

    @e(c = "com.stepos.agentbus.config.ConfigManager", f = "ConfigManager.kt", l = {130}, m = "sendApplied")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.config.ConfigManager$sendApplied$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00021 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00021(d dVar) {
            super(dVar);
        }

        @Override // i7.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConfigManager.this.sendApplied(null, 0L, null, false, this);
        }
    }

    @e(c = "com.stepos.agentbus.config.ConfigManager$start$1", f = "ConfigManager.kt", l = {56}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lia/b0;", "Lc7/r;", "<anonymous>", "(Lia/b0;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.stepos.agentbus.config.ConfigManager$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00031 extends i implements n {
        int label;

        public C00031(d dVar) {
            super(2, dVar);
        }

        @Override // i7.a
        public final d create(Object obj, d dVar) {
            return ConfigManager.this.new C00031(dVar);
        }

        @Override // p7.n
        public final Object invoke(b0 b0Var, d dVar) {
            return ((C00031) create(b0Var, dVar)).invokeSuspend(r.f1986a);
        }

        @Override // i7.a
        public final Object invokeSuspend(Object obj) {
            h7.a aVar = h7.a.f4212f;
            int i2 = this.label;
            if (i2 == 0) {
                e0.N(obj);
                la.e0 e0Var = ConfigManager.this.pool.f2890d;
                final ConfigManager configManager = ConfigManager.this;
                k kVar = new k() { // from class: com.stepos.agentbus.config.ConfigManager.start.1.1
                    @Override // la.k
                    public final Object emit(d5.i iVar, d dVar) {
                        if (iVar instanceof g) {
                            d5.e eVar = ((g) iVar).f2876a;
                            if (eVar.f() == m.GATEWAY) {
                                configManager.attach(eVar);
                            }
                        }
                        return r.f1986a;
                    }
                };
                this.label = 1;
                if (e0Var.f5914f.x(kVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e0.N(obj);
            }
            return r.f1986a;
        }
    }

    static {
        Moshi moshiBuild = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        q7.k.d(moshiBuild, "build(...)");
        defaultMoshi = moshiBuild;
    }

    public ConfigManager(ConfigProvider configProvider, l lVar, Moshi moshi, a aVar, t tVar, q qVar) {
        q7.k.e(configProvider, "provider");
        q7.k.e(lVar, "pool");
        q7.k.e(moshi, "moshi");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        q7.k.e(qVar, "internalBus");
        this.provider = configProvider;
        this.pool = lVar;
        this.moshi = moshi;
        this.dispatchers = aVar;
        this.logger = tVar;
        this.internalBus = qVar;
        x1 x1VarC = d0.c();
        this.supervisor = x1VarC;
        this.scope = d0.b(f1.plus(x1VarC, aVar.f5617b));
        this.version = new AtomicLong(0L);
        this.mapAdapter = moshi.adapter(Types.newParameterizedType(Map.class, String.class, Object.class)).serializeNulls();
        this.configAdapter = moshi.adapter(AgentBusConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attach(d5.e connection) {
        d0.s(this.scope, null, null, new AnonymousClass1(connection, this, null), 3);
    }

    private final AgentBusConfig fromMap(Map<String, ? extends Object> m6) {
        AgentBusConfig agentBusConfigFromJson = this.configAdapter.fromJson(this.mapAdapter.toJson(m6));
        if (agentBusConfigFromJson != null) {
            return agentBusConfigFromJson;
        }
        return new AgentBusConfig(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AgentBusConfig handleUpdate$lambda$2$lambda$1(AgentBusConfig agentBusConfig, AgentBusConfig agentBusConfig2) {
        q7.k.e(agentBusConfig2, "it");
        return agentBusConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendApplied(d5.e r12, long r13, java.lang.String r15, boolean r16, g7.d r17) {
        /*
            r11 = this;
            r0 = r17
            boolean r1 = r0 instanceof com.stepos.agentbus.config.ConfigManager.C00021
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.agentbus.config.ConfigManager$sendApplied$1 r1 = (com.stepos.agentbus.config.ConfigManager.C00021) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.stepos.agentbus.config.ConfigManager$sendApplied$1 r1 = new com.stepos.agentbus.config.ConfigManager$sendApplied$1
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.result
            h7.a r2 = h7.a.f4212f
            int r3 = r1.label
            c7.r r4 = c7.r.f1986a
            r5 = 1
            if (r3 == 0) goto L3a
            if (r3 != r5) goto L32
            java.lang.Object r11 = r1.L$0
            com.stepos.agentbus.config.ConfigManager r11 = (com.stepos.agentbus.config.ConfigManager) r11
            w7.e0.N(r0)     // Catch: java.lang.Throwable -> L2f
            goto L84
        L2f:
            r0 = move-exception
            r12 = r0
            goto L86
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3a:
            w7.e0.N(r0)
            java.lang.Long r0 = new java.lang.Long
            r0.<init>(r13)
            c7.j r13 = new c7.j
            java.lang.String r14 = "version"
            r13.<init>(r14, r0)
            c7.j r14 = new c7.j
            java.lang.String r0 = "scope"
            r14.<init>(r0, r15)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r16)
            c7.j r0 = new c7.j
            java.lang.String r3 = "ok"
            r0.<init>(r3, r15)
            long r6 = java.lang.System.currentTimeMillis()
            java.lang.Long r15 = new java.lang.Long
            r15.<init>(r6)
            c7.j r3 = new c7.j
            java.lang.String r6 = "timestamp"
            r3.<init>(r6, r15)
            c7.j[] r13 = new c7.j[]{r13, r14, r0, r3}
            java.util.Map r13 = d7.e0.U(r13)
            java.lang.String r14 = "stepclaw.config.applied"
            c5.b r13 = s9.d.p(r14, r13)
            r1.L$0 = r11     // Catch: java.lang.Throwable -> L2f
            r1.label = r5     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r12 = r12.i(r13, r1)     // Catch: java.lang.Throwable -> L2f
            if (r12 != r2) goto L84
            return r2
        L84:
            r12 = r4
            goto L8a
        L86:
            c7.l r12 = w7.e0.n(r12)
        L8a:
            java.lang.Throwable r12 = c7.m.a(r12)
            if (r12 == 0) goto La4
            k5.t r5 = r11.logger
            java.lang.String r11 = r12.getMessage()
            java.lang.String r12 = "config.applied send failed: "
            java.lang.String r7 = a1.a.w(r12, r11)
            r9 = 4
            r10 = 0
            java.lang.String r6 = "ConfigManager"
            r8 = 0
            k5.s.warn$default(r5, r6, r7, r8, r9, r10)
        La4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.config.ConfigManager.sendApplied(d5.e, long, java.lang.String, boolean, g7.d):java.lang.Object");
    }

    private final Map<String, Object> toMap(AgentBusConfig c10) {
        Map<String, Object> mapFromJson = this.mapAdapter.fromJson(this.configAdapter.toJson(c10));
        return mapFromJson == null ? a0.f2944f : mapFromJson;
    }

    public final long currentVersion() {
        return this.version.get();
    }

    public final Object handleUpdate(b bVar, d5.e eVar, d dVar) {
        Object objN;
        Map mapG = bVar.g();
        Object obj = mapG != null ? mapG.get("payload") : null;
        Map map = obj instanceof Map ? (Map) obj : null;
        r rVar = r.f1986a;
        if (map == null) {
            s.warn$default(this.logger, TAG, "config.update missing payload", null, 4, null);
            return rVar;
        }
        Object obj2 = map.get("version");
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        long jLongValue = number != null ? number.longValue() : 0L;
        if (jLongValue <= this.version.get()) {
            s.info$default(this.logger, TAG, "config.update version " + jLongValue + " not newer than " + this.version.get() + ", skip", null, 4, null);
            return rVar;
        }
        Object obj3 = map.get("scope");
        String str = obj3 instanceof String ? (String) obj3 : null;
        if (str == null) {
            str = "agentbus";
        }
        Object obj4 = map.get("patch");
        Map<String, ? extends Object> map2 = obj4 instanceof Map ? (Map) obj4 : null;
        if (map2 == null) {
            s.warn$default(this.logger, TAG, "config.update missing patch", null, 4, null);
            return rVar;
        }
        try {
            this.provider.update(new a5.a(6, fromMap(mergePatch(toMap((AgentBusConfig) this.provider.getCurrent().getValue()), map2))));
            this.version.set(jLongValue);
            objN = Boolean.TRUE;
        } catch (Throwable th) {
            objN = e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            ((k5.g) this.logger).a(TAG, "config.update apply failed", thA);
            ((a7.d) this.internalBus).C(new k5.m("STEPCLAW_INVALID_FRAME", a1.a.w("config.update apply failed: ", thA.getMessage()), k5.n.ERROR, null, 24));
        }
        Boolean bool = Boolean.FALSE;
        if (objN instanceof c7.l) {
            objN = bool;
        }
        Object objSendApplied = sendApplied(eVar, jLongValue, str, ((Boolean) objN).booleanValue(), dVar);
        return objSendApplied == h7.a.f4212f ? objSendApplied : rVar;
    }

    public final Map<String, Object> mergePatch(Map<String, ? extends Object> target, Map<String, ? extends Object> patch) {
        q7.k.e(target, "target");
        q7.k.e(patch, "patch");
        LinkedHashMap linkedHashMapB0 = d7.e0.b0(target);
        for (Map.Entry<String, ? extends Object> entry : patch.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                linkedHashMapB0.remove(key);
            } else if ((value instanceof Map) && (linkedHashMapB0.get(key) instanceof Map)) {
                Object obj = linkedHashMapB0.get(key);
                q7.k.c(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                linkedHashMapB0.put(key, mergePatch((Map) obj, (Map) value));
            } else {
                linkedHashMapB0.put(key, value);
            }
        }
        return linkedHashMapB0;
    }

    public final void start() {
        d0.s(this.scope, null, null, new C00031(null), 3);
        Iterator it = this.pool.a(m.GATEWAY).iterator();
        while (it.hasNext()) {
            attach((d5.e) it.next());
        }
    }

    public final void stop() {
        d0.e(this.scope, null);
    }

    public /* synthetic */ ConfigManager(ConfigProvider configProvider, l lVar, Moshi moshi, a aVar, t tVar, q qVar, int i2, f fVar) {
        this(configProvider, lVar, (i2 & 4) != 0 ? defaultMoshi : moshi, aVar, tVar, qVar);
    }
}
