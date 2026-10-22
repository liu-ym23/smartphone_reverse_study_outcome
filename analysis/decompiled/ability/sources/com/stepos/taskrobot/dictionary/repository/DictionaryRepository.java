package com.stepos.taskrobot.dictionary.repository;

import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.dictionary.DictionaryHttpClient;
import com.stepos.taskrobot.dictionary.api.DictionaryApi;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\b\u0017\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/taskrobot/dictionary/repository/DictionaryRepository;", "", "Lcom/stepos/taskrobot/dictionary/api/DictionaryApi;", "api", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/dictionary/api/DictionaryApi;)V", "", "pkgName", "appVersion", "key", "Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;", "getKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "type", "", "pageIndex", "pageSize", "Lcom/stepos/taskrobot/dictionary/model/PagedResult;", "pullKeys", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILH7/c;)Ljava/lang/Object;", "appId", "", "Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryItem;", "queryLegacy", "Lcom/stepos/taskrobot/dictionary/api/DictionaryApi;", "Companion", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DictionaryRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "DictRepo";
    private final DictionaryApi api;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/taskrobot/dictionary/repository/DictionaryRepository$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "create", "Lcom/stepos/taskrobot/dictionary/repository/DictionaryRepository;", "baseUrl", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final DictionaryRepository create(String baseUrl) {
            k.f(baseUrl, "baseUrl");
            DictionaryApi dictionaryApi = (DictionaryApi) DictionaryHttpClient.INSTANCE.newRetrofit(baseUrl).b(DictionaryApi.class);
            k.c(dictionaryApi);
            return new DictionaryRepository(dictionaryApi, null);
        }

        private Companion() {
        }
    }

    @c(c = "com.stepos.taskrobot.dictionary.repository.DictionaryRepository", f = "DictionaryRepository.kt", l = {26}, m = "getKey", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.dictionary.repository.DictionaryRepository$getKey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryRepository.this.getKey(null, null, null, this);
        }
    }

    @c(c = "com.stepos.taskrobot.dictionary.repository.DictionaryRepository", f = "DictionaryRepository.kt", l = {42}, m = "pullKeys", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.dictionary.repository.DictionaryRepository$pullKeys$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11481 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11481(H7.c<? super C11481> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryRepository.this.pullKeys(null, null, null, 0, 0, this);
        }
    }

    @c(c = "com.stepos.taskrobot.dictionary.repository.DictionaryRepository", f = "DictionaryRepository.kt", l = {56}, m = "queryLegacy", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.dictionary.repository.DictionaryRepository$queryLegacy$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C11491(H7.c<? super C11491> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryRepository.this.queryLegacy(null, null, null, this);
        }
    }

    public /* synthetic */ DictionaryRepository(DictionaryApi dictionaryApi, e eVar) {
        this(dictionaryApi);
    }

    public static /* synthetic */ Object pullKeys$default(DictionaryRepository dictionaryRepository, String str, String str2, String str3, int i, int i6, H7.c cVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        String str4 = str3;
        if ((i10 & 8) != 0) {
            i = 1;
        }
        int i11 = i;
        if ((i10 & 16) != 0) {
            i6 = 50;
        }
        return dictionaryRepository.pullKeys(str, str2, str4, i11, i6, cVar);
    }

    public static /* synthetic */ Object queryLegacy$default(DictionaryRepository dictionaryRepository, String str, String str2, String str3, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return dictionaryRepository.queryLegacy(str, str2, str3, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getKey(java.lang.String r6, java.lang.String r7, java.lang.String r8, H7.c<? super com.stepos.taskrobot.dictionary.model.DictionaryItem> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.taskrobot.dictionary.repository.DictionaryRepository.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.taskrobot.dictionary.repository.DictionaryRepository$getKey$1 r0 = (com.stepos.taskrobot.dictionary.repository.DictionaryRepository.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.dictionary.repository.DictionaryRepository$getKey$1 r0 = new com.stepos.taskrobot.dictionary.repository.DictionaryRepository$getKey$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L34
            goto L57
        L34:
            r5 = move-exception
            goto L67
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.b.b(r9)
            com.stepos.taskrobot.dictionary.api.DictionaryApi r5 = r5.api     // Catch: java.lang.Exception -> L34
            com.stepos.taskrobot.dictionary.model.GetKeyRequest r9 = new com.stepos.taskrobot.dictionary.model.GetKeyRequest     // Catch: java.lang.Exception -> L34
            r9.<init>(r6, r7, r8)     // Catch: java.lang.Exception -> L34
            r0.L$0 = r4     // Catch: java.lang.Exception -> L34
            r0.L$1 = r4     // Catch: java.lang.Exception -> L34
            r0.L$2 = r4     // Catch: java.lang.Exception -> L34
            r0.label = r3     // Catch: java.lang.Exception -> L34
            java.lang.Object r9 = r5.getKey(r9, r0)     // Catch: java.lang.Exception -> L34
            if (r9 != r1) goto L57
            return r1
        L57:
            com.stepos.taskrobot.dictionary.ApiResponse r9 = (com.stepos.taskrobot.dictionary.ApiResponse) r9     // Catch: java.lang.Exception -> L34
            boolean r5 = r9.isSuccess()     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L66
            java.lang.Object r5 = r9.getData()     // Catch: java.lang.Exception -> L34
            com.stepos.taskrobot.dictionary.model.DictionaryItem r5 = (com.stepos.taskrobot.dictionary.model.DictionaryItem) r5     // Catch: java.lang.Exception -> L34
            return r5
        L66:
            return r4
        L67:
            java.lang.String r6 = "DictRepo"
            java.lang.String r7 = "getKey failed"
            f6.AbstractC1436a.c(r6, r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.dictionary.repository.DictionaryRepository.getKey(java.lang.String, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object pullKeys(java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9, int r10, H7.c<? super com.stepos.taskrobot.dictionary.model.PagedResult<com.stepos.taskrobot.dictionary.model.DictionaryItem>> r11) {
        /*
            r5 = this;
            boolean r0 = r11 instanceof com.stepos.taskrobot.dictionary.repository.DictionaryRepository.C11481
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.taskrobot.dictionary.repository.DictionaryRepository$pullKeys$1 r0 = (com.stepos.taskrobot.dictionary.repository.DictionaryRepository.C11481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.dictionary.repository.DictionaryRepository$pullKeys$1 r0 = new com.stepos.taskrobot.dictionary.repository.DictionaryRepository$pullKeys$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r11)     // Catch: java.lang.Exception -> L34
            goto L61
        L34:
            r0 = move-exception
            r5 = r0
            goto L71
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.b.b(r11)
            com.stepos.taskrobot.dictionary.api.DictionaryApi r5 = r5.api     // Catch: java.lang.Exception -> L34
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            com.stepos.taskrobot.dictionary.model.PullKeysRequest r6 = new com.stepos.taskrobot.dictionary.model.PullKeysRequest     // Catch: java.lang.Exception -> L34
            r6.<init>(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L34
            r0.L$0 = r4     // Catch: java.lang.Exception -> L34
            r0.L$1 = r4     // Catch: java.lang.Exception -> L34
            r0.L$2 = r4     // Catch: java.lang.Exception -> L34
            r0.I$0 = r10     // Catch: java.lang.Exception -> L34
            r0.I$1 = r11     // Catch: java.lang.Exception -> L34
            r0.label = r3     // Catch: java.lang.Exception -> L34
            java.lang.Object r11 = r5.pullKeys(r6, r0)     // Catch: java.lang.Exception -> L34
            if (r11 != r1) goto L61
            return r1
        L61:
            com.stepos.taskrobot.dictionary.ApiResponse r11 = (com.stepos.taskrobot.dictionary.ApiResponse) r11     // Catch: java.lang.Exception -> L34
            boolean r5 = r11.isSuccess()     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L70
            java.lang.Object r5 = r11.getData()     // Catch: java.lang.Exception -> L34
            com.stepos.taskrobot.dictionary.model.PagedResult r5 = (com.stepos.taskrobot.dictionary.model.PagedResult) r5     // Catch: java.lang.Exception -> L34
            return r5
        L70:
            return r4
        L71:
            java.lang.String r6 = "DictRepo"
            java.lang.String r7 = "pullKeys failed"
            f6.AbstractC1436a.c(r6, r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.dictionary.repository.DictionaryRepository.pullKeys(java.lang.String, java.lang.String, java.lang.String, int, int, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object queryLegacy(java.lang.String r6, java.lang.String r7, java.lang.String r8, H7.c<? super java.util.List<com.stepos.taskrobot.dictionary.model.LegacyDictionaryItem>> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.taskrobot.dictionary.repository.DictionaryRepository.C11491
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.taskrobot.dictionary.repository.DictionaryRepository$queryLegacy$1 r0 = (com.stepos.taskrobot.dictionary.repository.DictionaryRepository.C11491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.dictionary.repository.DictionaryRepository$queryLegacy$1 r0 = new com.stepos.taskrobot.dictionary.repository.DictionaryRepository$queryLegacy$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L34
            goto L57
        L34:
            r5 = move-exception
            goto L67
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.b.b(r9)
            com.stepos.taskrobot.dictionary.api.DictionaryApi r5 = r5.api     // Catch: java.lang.Exception -> L34
            com.stepos.taskrobot.dictionary.model.LegacyDictionaryRequest r9 = new com.stepos.taskrobot.dictionary.model.LegacyDictionaryRequest     // Catch: java.lang.Exception -> L34
            r9.<init>(r6, r7, r8)     // Catch: java.lang.Exception -> L34
            r0.L$0 = r4     // Catch: java.lang.Exception -> L34
            r0.L$1 = r4     // Catch: java.lang.Exception -> L34
            r0.L$2 = r4     // Catch: java.lang.Exception -> L34
            r0.label = r3     // Catch: java.lang.Exception -> L34
            java.lang.Object r9 = r5.queryLegacy(r9, r0)     // Catch: java.lang.Exception -> L34
            if (r9 != r1) goto L57
            return r1
        L57:
            com.stepos.taskrobot.dictionary.ApiResponse r9 = (com.stepos.taskrobot.dictionary.ApiResponse) r9     // Catch: java.lang.Exception -> L34
            boolean r5 = r9.isSuccess()     // Catch: java.lang.Exception -> L34
            if (r5 == 0) goto L66
            java.lang.Object r5 = r9.getData()     // Catch: java.lang.Exception -> L34
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L34
            return r5
        L66:
            return r4
        L67:
            java.lang.String r6 = "DictRepo"
            java.lang.String r7 = "queryLegacy failed"
            f6.AbstractC1436a.c(r6, r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.dictionary.repository.DictionaryRepository.queryLegacy(java.lang.String, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    private DictionaryRepository(DictionaryApi dictionaryApi) {
        this.api = dictionaryApi;
    }
}
