package com.stepos.stepclaw.config;

import android.content.Context;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import d6.b;
import g5.a;
import h5.e;
import h5.i;
import kotlin.Metadata;
import m0.c;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/config/OpenClawConfigDataStore;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/stepclaw/config/OpenClawConfig;", "config", "Lb5/a0;", "save", "(Lcom/stepos/stepclaw/config/OpenClawConfig;Lf5/c;)Ljava/lang/Object;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hasApiKey", "(Lf5/c;)Ljava/lang/Object;", "Landroid/content/Context;", "Ld6/b;", "configFlow", "Ld6/b;", "getConfigFlow", "()Ld6/b;", "Keys", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OpenClawConfigDataStore {
    private final b configFlow;
    private final Context context;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/stepclaw/config/OpenClawConfigDataStore$Keys;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lm0/c;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "API_KEY", "Lm0/c;", "getAPI_KEY", "()Lm0/c;", "MODEL", "getMODEL", "PROVIDER", "getPROVIDER", "BASE_URL", "getBASE_URL", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "PORT", "getPORT", "IMAGE_INPUT", "getIMAGE_INPUT", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Keys {
        public static final Keys INSTANCE = new Keys();
        private static final c API_KEY = new c("api_key");
        private static final c MODEL = new c(ConfigIpcContract.KEY_MODEL);
        private static final c PROVIDER = new c(ConfigIpcContract.KEY_PROVIDER);
        private static final c BASE_URL = new c("base_url");
        private static final c PORT = new c(ConfigIpcContract.KEY_PORT);
        private static final c IMAGE_INPUT = new c("image_input");

        private Keys() {
        }

        public final c getAPI_KEY() {
            return API_KEY;
        }

        public final c getBASE_URL() {
            return BASE_URL;
        }

        public final c getIMAGE_INPUT() {
            return IMAGE_INPUT;
        }

        public final c getMODEL() {
            return MODEL;
        }

        public final c getPORT() {
            return PORT;
        }

        public final c getPROVIDER() {
            return PROVIDER;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.config.OpenClawConfigDataStore", f = "OpenClawConfigDataStore.kt", l = {68}, m = "hasApiKey", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.config.OpenClawConfigDataStore$hasApiKey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OpenClawConfigDataStore.this.hasApiKey(this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm0/b;", "prefs", "Lb5/a0;", "<anonymous>", "(Lm0/b;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.OpenClawConfigDataStore$save$2", f = "OpenClawConfigDataStore.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.OpenClawConfigDataStore$save$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00172 extends i implements p {
        final /* synthetic */ OpenClawConfig $config;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00172(OpenClawConfig openClawConfig, f5.c cVar) {
            super(2, cVar);
            this.$config = openClawConfig;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            C00172 c00172 = new C00172(this.$config, cVar);
            c00172.L$0 = obj;
            return c00172;
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            m0.b bVar = (m0.b) this.L$0;
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            Keys keys = Keys.INSTANCE;
            bVar.d(keys.getAPI_KEY(), this.$config.getApiKey());
            bVar.d(keys.getMODEL(), this.$config.getModel());
            bVar.d(keys.getPROVIDER(), this.$config.getProvider());
            bVar.d(keys.getBASE_URL(), this.$config.getBaseUrl());
            bVar.d(keys.getPORT(), new Integer(this.$config.getPort()));
            if (this.$config.getImageInput() != null) {
                bVar.d(keys.getIMAGE_INPUT(), String.valueOf(this.$config.getImageInput().booleanValue()));
            } else {
                c key = keys.getIMAGE_INPUT();
                kotlin.jvm.internal.p.e(key, "key");
                bVar.c();
                bVar.f3889a.remove(key);
            }
            return a0.f883a;
        }

        @Override // p5.p
        public final Object invoke(m0.b bVar, f5.c cVar) {
            return ((C00172) create(bVar, cVar)).invokeSuspend(a0.f883a);
        }
    }

    public OpenClawConfigDataStore(Context context) {
        kotlin.jvm.internal.p.e(context, "context");
        this.context = context;
        final b bVarK = OpenClawConfigDataStoreKt.getDataStore(context).k();
        this.configFlow = new b() { // from class: com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1

            /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements d6.c {
                final /* synthetic */ d6.c $this_unsafeFlow;

                @e(c = "com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1$2", f = "OpenClawConfigDataStore.kt", l = {50}, m = "emit", v = 1)
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends h5.c {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(f5.c cVar) {
                        super(cVar);
                    }

                    @Override // h5.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(d6.c cVar) {
                    this.$this_unsafeFlow = cVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
                @Override // d6.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r17, f5.c r18) {
                    /*
                        r16 = this;
                        r0 = r16
                        r1 = r18
                        boolean r2 = r1 instanceof com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1$2$1 r2 = (com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1$2$1 r2 = new com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        g5.a r3 = g5.a.f2984a
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L3c
                        if (r4 != r5) goto L34
                        java.lang.Object r0 = r2.L$3
                        d6.c r0 = (d6.c) r0
                        java.lang.Object r0 = r2.L$1
                        com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1$2$1 r0 = (com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        a.a.c0(r1)
                        goto Ld6
                    L34:
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                        r0.<init>(r1)
                        throw r0
                    L3c:
                        a.a.c0(r1)
                        d6.c r0 = r0.$this_unsafeFlow
                        r1 = r17
                        m0.e r1 = (m0.e) r1
                        com.stepos.stepclaw.config.OpenClawConfig r6 = new com.stepos.stepclaw.config.OpenClawConfig
                        com.stepos.stepclaw.config.OpenClawConfigDataStore$Keys r4 = com.stepos.stepclaw.config.OpenClawConfigDataStore.Keys.INSTANCE
                        m0.c r7 = r4.getAPI_KEY()
                        java.lang.Object r7 = r1.b(r7)
                        java.lang.String r7 = (java.lang.String) r7
                        if (r7 != 0) goto L57
                        java.lang.String r7 = ""
                    L57:
                        m0.c r8 = r4.getMODEL()
                        java.lang.Object r8 = r1.b(r8)
                        java.lang.String r8 = (java.lang.String) r8
                        if (r8 != 0) goto L65
                        java.lang.String r8 = "qwen/qwen3.5-397b-a17b"
                    L65:
                        m0.c r9 = r4.getPROVIDER()
                        java.lang.Object r9 = r1.b(r9)
                        java.lang.String r9 = (java.lang.String) r9
                        if (r9 != 0) goto L73
                        java.lang.String r9 = "openrouter"
                    L73:
                        m0.c r10 = r4.getBASE_URL()
                        java.lang.Object r10 = r1.b(r10)
                        java.lang.String r10 = (java.lang.String) r10
                        if (r10 != 0) goto L81
                        java.lang.String r10 = "https://openrouter.ai/api/v1"
                    L81:
                        m0.c r11 = r4.getPORT()
                        java.lang.Object r11 = r1.b(r11)
                        java.lang.Integer r11 = (java.lang.Integer) r11
                        if (r11 == 0) goto L92
                        int r11 = r11.intValue()
                        goto L94
                    L92:
                        r11 = 18789(0x4965, float:2.6329E-41)
                    L94:
                        m0.c r4 = r4.getIMAGE_INPUT()
                        java.lang.Object r1 = r1.b(r4)
                        java.lang.String r1 = (java.lang.String) r1
                        r4 = 0
                        if (r1 == 0) goto Lba
                        java.lang.String r12 = "true"
                        boolean r12 = r1.equals(r12)
                        if (r12 == 0) goto Lac
                        java.lang.Boolean r1 = java.lang.Boolean.TRUE
                        goto Lb8
                    Lac:
                        java.lang.String r12 = "false"
                        boolean r1 = r1.equals(r12)
                        if (r1 == 0) goto Lb7
                        java.lang.Boolean r1 = java.lang.Boolean.FALSE
                        goto Lb8
                    Lb7:
                        r1 = r4
                    Lb8:
                        r12 = r1
                        goto Lbb
                    Lba:
                        r12 = r4
                    Lbb:
                        r14 = 64
                        r15 = 0
                        r13 = 0
                        r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15)
                        r2.L$0 = r4
                        r2.L$1 = r4
                        r2.L$2 = r4
                        r2.L$3 = r4
                        r1 = 0
                        r2.I$0 = r1
                        r2.label = r5
                        java.lang.Object r0 = r0.emit(r6, r2)
                        if (r0 != r3) goto Ld6
                        return r3
                    Ld6:
                        b5.a0 r0 = b5.a0.f883a
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.config.OpenClawConfigDataStore$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, f5.c):java.lang.Object");
                }
            }

            @Override // d6.b
            public Object collect(d6.c cVar, f5.c cVar2) {
                Object objCollect = bVarK.collect(new AnonymousClass2(cVar), cVar2);
                return objCollect == a.f2984a ? objCollect : a0.f883a;
            }
        };
    }

    public final b getConfigFlow() {
        return this.configFlow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object hasApiKey(f5.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.stepclaw.config.OpenClawConfigDataStore.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.stepclaw.config.OpenClawConfigDataStore$hasApiKey$1 r0 = (com.stepos.stepclaw.config.OpenClawConfigDataStore.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.config.OpenClawConfigDataStore$hasApiKey$1 r0 = new com.stepos.stepclaw.config.OpenClawConfigDataStore$hasApiKey$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            kotlin.jvm.internal.v r4 = (kotlin.jvm.internal.v) r4
            a.a.c0(r5)
            goto L56
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.a.c0(r5)
            kotlin.jvm.internal.v r5 = new kotlin.jvm.internal.v
            r5.<init>()
            android.content.Context r4 = r4.context
            j0.f r4 = com.stepos.stepclaw.config.OpenClawConfigDataStoreKt.access$getDataStore(r4)
            d6.b r4 = r4.k()
            com.stepos.stepclaw.config.OpenClawConfigDataStore$hasApiKey$2 r2 = new com.stepos.stepclaw.config.OpenClawConfigDataStore$hasApiKey$2
            r2.<init>()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            r4 = r5
        L56:
            boolean r4 = r4.f3683a
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.config.OpenClawConfigDataStore.hasApiKey(f5.c):java.lang.Object");
    }

    public final Object save(OpenClawConfig openClawConfig, f5.c cVar) {
        Object objD = OpenClawConfigDataStoreKt.getDataStore(this.context).d(new c4.c(new C00172(openClawConfig, null), 7, (f5.c) null), cVar);
        return objD == a.f2984a ? objD : a0.f883a;
    }
}
