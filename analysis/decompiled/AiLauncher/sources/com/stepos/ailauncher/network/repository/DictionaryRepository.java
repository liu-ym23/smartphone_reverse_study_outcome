package com.stepos.ailauncher.network.repository;

import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.network.RetrofitProvider;
import com.stepos.ailauncher.network.api.DictionaryApi;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/network/repository/DictionaryRepository;", "", "Lcom/stepos/ailauncher/network/api/DictionaryApi;", "api", "<init>", "(Lcom/stepos/ailauncher/network/api/DictionaryApi;)V", "", "pkgName", "appVersion", "key", "Lcom/stepos/ailauncher/network/model/DictionaryItem;", "queryByKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/network/api/DictionaryApi;", "Companion", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DictionaryRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DictionaryApi api;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/network/repository/DictionaryRepository$Companion;", "", "<init>", "()V", "create", "Lcom/stepos/ailauncher/network/repository/DictionaryRepository;", "isDebug", "", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ DictionaryRepository create$default(Companion companion, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = true;
            }
            return companion.create(z10);
        }

        public final DictionaryRepository create(boolean isDebug) throws SecurityException {
            Object objC = RetrofitProvider.newRetrofit$default(H5.a.INSTANCE.a(C3197a.INSTANCE.a()).r(), null, false, false, false, 30, null).c(DictionaryApi.class);
            p.h(objC, "create(...)");
            return new DictionaryRepository((DictionaryApi) objC);
        }

        private Companion() {
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.network.repository.DictionaryRepository", f = "DictionaryRepository.kt", l = {32}, m = "queryByKey", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.network.repository.DictionaryRepository$queryByKey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryRepository.this.queryByKey(null, null, null, this);
        }
    }

    public DictionaryRepository(DictionaryApi api) {
        p.i(api, "api");
        this.api = api;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryByKey(java.lang.String r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super com.stepos.ailauncher.network.model.DictionaryItem> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.stepos.ailauncher.network.repository.DictionaryRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.stepos.ailauncher.network.repository.DictionaryRepository$queryByKey$1 r0 = (com.stepos.ailauncher.network.repository.DictionaryRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.network.repository.DictionaryRepository$queryByKey$1 r0 = new com.stepos.ailauncher.network.repository.DictionaryRepository$queryByKey$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 != r4) goto L3b
            java.lang.Object r10 = r0.L$2
            r13 = r10
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r10 = r0.L$0
            java.lang.String r10 = (java.lang.String) r10
            kotlin.C4849c.b(r14)     // Catch: java.lang.Exception -> L37
            goto L64
        L37:
            r0 = move-exception
            r10 = r0
            r6 = r10
            goto L74
        L3b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L43:
            kotlin.C4849c.b(r14)
            com.stepos.ailauncher.network.api.DictionaryApi r10 = r10.api     // Catch: java.lang.Exception -> L37
            com.stepos.ailauncher.network.model.DictionaryRequest r14 = new com.stepos.ailauncher.network.model.DictionaryRequest     // Catch: java.lang.Exception -> L37
            r14.<init>(r11, r12, r13)     // Catch: java.lang.Exception -> L37
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Exception -> L37
            r0.L$0 = r11     // Catch: java.lang.Exception -> L37
            java.lang.Object r11 = g9.h.a(r12)     // Catch: java.lang.Exception -> L37
            r0.L$1 = r11     // Catch: java.lang.Exception -> L37
            r0.L$2 = r13     // Catch: java.lang.Exception -> L37
            r0.label = r4     // Catch: java.lang.Exception -> L37
            java.lang.Object r14 = r10.queryByKey(r14, r0)     // Catch: java.lang.Exception -> L37
            if (r14 != r1) goto L64
            return r1
        L64:
            com.stepos.ailauncher.network.ApiResponse r14 = (com.stepos.ailauncher.network.ApiResponse) r14     // Catch: java.lang.Exception -> L37
            boolean r10 = r14.isSuccess()     // Catch: java.lang.Exception -> L37
            if (r10 == 0) goto L73
            java.lang.Object r10 = r14.getData()     // Catch: java.lang.Exception -> L37
            com.stepos.ailauncher.network.model.DictionaryItem r10 = (com.stepos.ailauncher.network.model.DictionaryItem) r10     // Catch: java.lang.Exception -> L37
            return r10
        L73:
            return r3
        L74:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "queryByKey failed: key="
            r10.append(r11)
            r10.append(r13)
            java.lang.String r5 = r10.toString()
            r8 = 8
            r9 = 0
            java.lang.String r4 = "DictionaryRepository"
            r7 = 0
            h8.C4148a.t(r4, r5, r6, r7, r8, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.network.repository.DictionaryRepository.queryByKey(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }
}
