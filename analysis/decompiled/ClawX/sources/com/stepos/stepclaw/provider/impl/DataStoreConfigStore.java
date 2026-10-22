package com.stepos.stepclaw.provider.impl;

import a6.f0;
import a6.i0;
import a6.r0;
import android.content.Context;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.config.JsonConfigStore;
import com.stepos.stepclaw.config.OpenClawConfig;
import com.stepos.stepclaw.provider.backend.ConfigData;
import com.stepos.stepclaw.provider.backend.IConfigStore;
import d6.b;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import h6.d;
import kotlin.Metadata;
import org.bouncycastle.asn1.BERTags;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0006*\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/stepclaw/provider/impl/DataStoreConfigStore;", "Lcom/stepos/stepclaw/provider/backend/IConfigStore;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/stepclaw/config/OpenClawConfig;", "Lcom/stepos/stepclaw/provider/backend/ConfigData;", "toConfigData", "(Lcom/stepos/stepclaw/config/OpenClawConfig;)Lcom/stepos/stepclaw/provider/backend/ConfigData;", "toOpenClawConfig", "(Lcom/stepos/stepclaw/provider/backend/ConfigData;)Lcom/stepos/stepclaw/config/OpenClawConfig;", "config", "Lb5/a0;", "save", "(Lcom/stepos/stepclaw/provider/backend/ConfigData;Lf5/c;)Ljava/lang/Object;", "syncToRootfs", "(Lcom/stepos/stepclaw/provider/backend/ConfigData;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "restoreFromBackup", "(Lf5/c;)Ljava/lang/Object;", "restoreWorkspaceFiles", "Lcom/stepos/stepclaw/config/JsonConfigStore;", "jsonStore", "Lcom/stepos/stepclaw/config/JsonConfigStore;", "Ld6/b;", "configFlow", "Ld6/b;", "getConfigFlow", "()Ld6/b;", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DataStoreConfigStore implements IConfigStore {
    private final b configFlow;
    private final JsonConfigStore jsonStore;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/config/OpenClawConfig;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/config/OpenClawConfig;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.provider.impl.DataStoreConfigStore$1", f = "DataStoreConfigStore.kt", l = {BERTags.IA5_STRING}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.provider.impl.DataStoreConfigStore$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        int label;

        public AnonymousClass1(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return DataStoreConfigStore.this.new AnonymousClass1(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f2984a;
            int i8 = this.label;
            if (i8 != 0) {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
                return obj;
            }
            a.a.c0(obj);
            JsonConfigStore jsonConfigStore = DataStoreConfigStore.this.jsonStore;
            this.label = 1;
            Object config = jsonConfigStore.readConfig(this);
            return config == aVar ? aVar : config;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataStoreConfigStore(Context context) throws Throwable {
        kotlin.jvm.internal.p.e(context, "context");
        JsonConfigStore jsonConfigStore = new JsonConfigStore(context, null, 2, 0 == true ? 1 : 0);
        this.jsonStore = jsonConfigStore;
        h6.e eVar = r0.f210a;
        i0.u(d.f3059c, new AnonymousClass1(null));
        final b configFlow = jsonConfigStore.getConfigFlow();
        this.configFlow = new b() { // from class: com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1

            /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements d6.c {
                final /* synthetic */ d6.c $this_unsafeFlow;
                final /* synthetic */ DataStoreConfigStore this$0;

                @e(c = "com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1$2", f = "DataStoreConfigStore.kt", l = {50}, m = "emit", v = 1)
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends h5.c {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // h5.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(d6.c cVar, DataStoreConfigStore dataStoreConfigStore) {
                    this.$this_unsafeFlow = cVar;
                    this.this$0 = dataStoreConfigStore;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // d6.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, f5.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1$2$1 r0 = (com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1$2$1 r0 = new com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        g5.a r1 = g5.a.f2984a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L37
                        if (r2 != r3) goto L2f
                        java.lang.Object r4 = r0.L$3
                        d6.c r4 = (d6.c) r4
                        java.lang.Object r4 = r0.L$1
                        com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1$2$1 r4 = (com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r4
                        a.a.c0(r6)
                        goto L59
                    L2f:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L37:
                        a.a.c0(r6)
                        d6.c r6 = r4.$this_unsafeFlow
                        com.stepos.stepclaw.config.OpenClawConfig r5 = (com.stepos.stepclaw.config.OpenClawConfig) r5
                        com.stepos.stepclaw.provider.impl.DataStoreConfigStore r4 = r4.this$0
                        com.stepos.stepclaw.provider.backend.ConfigData r4 = com.stepos.stepclaw.provider.impl.DataStoreConfigStore.access$toConfigData(r4, r5)
                        r5 = 0
                        r0.L$0 = r5
                        r0.L$1 = r5
                        r0.L$2 = r5
                        r0.L$3 = r5
                        r5 = 0
                        r0.I$0 = r5
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L59
                        return r1
                    L59:
                        b5.a0 r4 = b5.a0.f883a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.impl.DataStoreConfigStore$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, f5.c):java.lang.Object");
                }
            }

            @Override // d6.b
            public Object collect(d6.c cVar, c cVar2) {
                Object objCollect = configFlow.collect(new AnonymousClass2(cVar, this), cVar2);
                return objCollect == a.f2984a ? objCollect : a0.f883a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConfigData toConfigData(OpenClawConfig openClawConfig) {
        return new ConfigData(openClawConfig.getProvider(), openClawConfig.getModel(), openClawConfig.getBaseUrl(), openClawConfig.getApiKey(), openClawConfig.getImageInput(), openClawConfig.getApi());
    }

    private final OpenClawConfig toOpenClawConfig(ConfigData configData) {
        String provider = configData.getProvider();
        return new OpenClawConfig(configData.getApiKey(), configData.getModel(), provider, configData.getBaseUrl(), 0, configData.getImageInput(), configData.getApi(), 16, null);
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public b getConfigFlow() {
        return this.configFlow;
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public Object restoreFromBackup(c cVar) {
        return this.jsonStore.restoreFromBackup(cVar);
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public Object restoreWorkspaceFiles(c cVar) {
        return this.jsonStore.restoreWorkspaceFiles(cVar);
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public Object save(ConfigData configData, c cVar) {
        Object objSave = this.jsonStore.save(toOpenClawConfig(configData), cVar);
        return objSave == a.f2984a ? objSave : a0.f883a;
    }

    @Override // com.stepos.stepclaw.provider.backend.IConfigStore
    public void syncToRootfs(ConfigData config) {
        kotlin.jvm.internal.p.e(config, "config");
    }
}
