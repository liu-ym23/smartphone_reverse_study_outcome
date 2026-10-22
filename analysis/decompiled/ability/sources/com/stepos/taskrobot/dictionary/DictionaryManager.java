package com.stepos.taskrobot.dictionary;

import J7.c;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.taskrobot.dictionary.model.DictionaryItem;
import com.stepos.taskrobot.dictionary.model.LegacyDictionaryItem;
import com.stepos.taskrobot.dictionary.model.PagedResult;
import com.stepos.taskrobot.dictionary.model.WhitelistData;
import com.stepos.taskrobot.dictionary.repository.DictionaryRepository;
import com.tencent.mmkv.MMKV;
import f6.AbstractC1436a;
import j9.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b\u001d\u0010\u001fJ8\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010$2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!H\u0086@¢\u0006\u0004\b%\u0010&JH\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!H\u0086@¢\u0006\u0004\b%\u0010'J8\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0006\u0010(\u001a\u00020\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0004\b+\u0010\u001fJ\u0010\u0010-\u001a\u00020,H\u0086@¢\u0006\u0004\b-\u0010.J \u0010-\u001a\u00020,2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b-\u0010/R\u0014\u00100\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u00101R\u0014\u00103\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u00101R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105R\u0016\u00109\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00101R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00101¨\u0006;"}, d2 = {"Lcom/stepos/taskrobot/dictionary/DictionaryManager;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/taskrobot/dictionary/repository/DictionaryRepository;", "repo", "()Lcom/stepos/taskrobot/dictionary/repository/DictionaryRepository;", "", "baseUrl", "()Ljava/lang/String;", "value", "Lcom/stepos/taskrobot/dictionary/model/WhitelistData;", "parseWhitelistData", "(Ljava/lang/String;)Lcom/stepos/taskrobot/dictionary/model/WhitelistData;", "", "isInitialized", "()Z", "Landroid/content/Context;", "context", "isDebug", "LC7/r;", "init", "(Landroid/content/Context;Z)V", "pkgName", "appVersion", "setConfig", "(Ljava/lang/String;Ljava/lang/String;)V", "key", "Lcom/stepos/taskrobot/dictionary/model/DictionaryItem;", "getKey", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "type", "", "pageIndex", "pageSize", "Lcom/stepos/taskrobot/dictionary/model/PagedResult;", "pullKeys", "(Ljava/lang/String;IILH7/c;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILH7/c;)Ljava/lang/Object;", "appId", "", "Lcom/stepos/taskrobot/dictionary/model/LegacyDictionaryItem;", "queryLegacy", "Lcom/stepos/taskrobot/dictionary/WhitelistResult;", "getWhitelist", "(LH7/c;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "BASE_URL_TEST", "BASE_URL_PROD", "_initialized", "Z", "_repository", "Lcom/stepos/taskrobot/dictionary/repository/DictionaryRepository;", "_isDebug", "_pkgName", "_appVersion", "dictionary_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DictionaryManager {
    public static final String BASE_URL_PROD = "https://biz-gw.stepaos.com/dictionary/";
    public static final String BASE_URL_TEST = "https://biz-gw.stepaos.com/dictionary/";
    private static final String TAG = "DictionaryManager";
    private static boolean _initialized;
    private static boolean _isDebug;
    private static DictionaryRepository _repository;
    public static final DictionaryManager INSTANCE = new DictionaryManager();
    private static String _pkgName = "com.stepos.ability";
    private static String _appVersion = "1.0.10";

    @c(c = "com.stepos.taskrobot.dictionary.DictionaryManager", f = "DictionaryManager.kt", l = {94}, m = "getWhitelist", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryManager.this.getWhitelist(this);
        }
    }

    @c(c = "com.stepos.taskrobot.dictionary.DictionaryManager", f = "DictionaryManager.kt", l = {100}, m = "getWhitelist", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$2, reason: invalid class name */
    public static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryManager.this.getWhitelist(null, null, this);
        }
    }

    private DictionaryManager() {
    }

    private final String baseUrl() {
        return "https://biz-gw.stepaos.com/dictionary/";
    }

    public static /* synthetic */ void init$default(DictionaryManager dictionaryManager, Context context, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        dictionaryManager.init(context, z10);
    }

    private final WhitelistData parseWhitelistData(String value) {
        if (value == null || m.s0(value)) {
            return new WhitelistData(null, null, 3, null);
        }
        try {
            WhitelistData whitelistData = (WhitelistData) new Gson().fromJson(value, WhitelistData.class);
            return whitelistData == null ? new WhitelistData(null, null, 3, null) : whitelistData;
        } catch (Exception e) {
            AbstractC1436a.c(TAG, "parseWhitelistData failed", e);
            return new WhitelistData(null, null, 3, null);
        }
    }

    public static /* synthetic */ Object pullKeys$default(DictionaryManager dictionaryManager, String str, int i, int i6, H7.c cVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            i = 1;
        }
        if ((i10 & 4) != 0) {
            i6 = 50;
        }
        return dictionaryManager.pullKeys(str, i, i6, cVar);
    }

    public static /* synthetic */ Object queryLegacy$default(DictionaryManager dictionaryManager, String str, String str2, String str3, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return dictionaryManager.queryLegacy(str, str2, str3, cVar);
    }

    private final DictionaryRepository repo() {
        if (!_initialized) {
            throw new IllegalStateException("DictionaryManager.init() must be called first");
        }
        DictionaryRepository dictionaryRepository = _repository;
        if (dictionaryRepository != null) {
            return dictionaryRepository;
        }
        DictionaryRepository dictionaryRepositoryCreate = DictionaryRepository.INSTANCE.create(baseUrl());
        _repository = dictionaryRepositoryCreate;
        return dictionaryRepositoryCreate;
    }

    public final Object getKey(String str, H7.c<? super DictionaryItem> cVar) {
        return repo().getKey(_pkgName, _appVersion, str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getWhitelist(H7.c<? super com.stepos.taskrobot.dictionary.WhitelistResult> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.taskrobot.dictionary.DictionaryManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$1 r0 = (com.stepos.taskrobot.dictionary.DictionaryManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$1 r0 = new com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r5)
            r0.label = r3
            java.lang.String r5 = "whitelist"
            java.lang.Object r5 = r4.getKey(r5, r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            com.stepos.taskrobot.dictionary.model.DictionaryItem r5 = (com.stepos.taskrobot.dictionary.model.DictionaryItem) r5
            if (r5 != 0) goto L4a
            com.stepos.taskrobot.dictionary.WhitelistResult r4 = new com.stepos.taskrobot.dictionary.WhitelistResult
            r5 = 0
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.f4893a
            r4.<init>(r5, r0, r0)
            return r4
        L4a:
            java.lang.String r0 = r5.getValue()
            com.stepos.taskrobot.dictionary.model.WhitelistData r4 = r4.parseWhitelistData(r0)
            com.stepos.taskrobot.dictionary.WhitelistResult r0 = new com.stepos.taskrobot.dictionary.WhitelistResult
            java.util.List r1 = r4.getApps()
            java.util.List r4 = r4.getRedirectGroups()
            r0.<init>(r5, r1, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.dictionary.DictionaryManager.getWhitelist(H7.c):java.lang.Object");
    }

    public final void init(Context context, boolean isDebug) {
        k.f(context, "context");
        if (_initialized) {
            return;
        }
        MMKV.initialize(context);
        DictionaryHttpClient.INSTANCE.init(context);
        _isDebug = isDebug;
        _initialized = true;
        String str = _pkgName;
        String str2 = _appVersion;
        StringBuilder sb = new StringBuilder("init: isDebug=");
        sb.append(isDebug);
        sb.append(", pkgName=");
        sb.append(str);
        sb.append(", appVersion=");
        com.stepos.statsrpk.service.c.r(sb, str2, TAG, true);
    }

    public final boolean isInitialized() {
        return _initialized;
    }

    public final Object pullKeys(String str, int i, int i6, H7.c<? super PagedResult<DictionaryItem>> cVar) {
        return repo().pullKeys(_pkgName, _appVersion, str, i, i6, cVar);
    }

    public final Object queryLegacy(String str, String str2, String str3, H7.c<? super List<LegacyDictionaryItem>> cVar) {
        return repo().queryLegacy(str, str2, str3, cVar);
    }

    public final void setConfig(String pkgName, String appVersion) {
        k.f(pkgName, "pkgName");
        k.f(appVersion, "appVersion");
        _pkgName = pkgName;
        _appVersion = appVersion;
    }

    public static /* synthetic */ Object pullKeys$default(DictionaryManager dictionaryManager, String str, String str2, String str3, int i, int i6, H7.c cVar, int i10, Object obj) {
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
        return dictionaryManager.pullKeys(str, str2, str4, i11, i6, cVar);
    }

    public final Object getKey(String str, String str2, String str3, H7.c<? super DictionaryItem> cVar) {
        return repo().getKey(str, str2, str3, cVar);
    }

    public final Object pullKeys(String str, String str2, String str3, int i, int i6, H7.c<? super PagedResult<DictionaryItem>> cVar) {
        return repo().pullKeys(str, str2, str3, i, i6, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getWhitelist(java.lang.String r6, java.lang.String r7, H7.c<? super com.stepos.taskrobot.dictionary.WhitelistResult> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stepos.taskrobot.dictionary.DictionaryManager.AnonymousClass2
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$2 r0 = (com.stepos.taskrobot.dictionary.DictionaryManager.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$2 r0 = new com.stepos.taskrobot.dictionary.DictionaryManager$getWhitelist$2
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r8)
            goto L4a
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.b.b(r8)
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.String r8 = "whitelist"
            java.lang.Object r8 = r5.getKey(r6, r7, r8, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            com.stepos.taskrobot.dictionary.model.DictionaryItem r8 = (com.stepos.taskrobot.dictionary.model.DictionaryItem) r8
            if (r8 != 0) goto L56
            com.stepos.taskrobot.dictionary.WhitelistResult r5 = new com.stepos.taskrobot.dictionary.WhitelistResult
            kotlin.collections.EmptyList r6 = kotlin.collections.EmptyList.f4893a
            r5.<init>(r4, r6, r6)
            return r5
        L56:
            java.lang.String r6 = r8.getValue()
            com.stepos.taskrobot.dictionary.model.WhitelistData r5 = r5.parseWhitelistData(r6)
            com.stepos.taskrobot.dictionary.WhitelistResult r6 = new com.stepos.taskrobot.dictionary.WhitelistResult
            java.util.List r7 = r5.getApps()
            java.util.List r5 = r5.getRedirectGroups()
            r6.<init>(r8, r7, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.dictionary.DictionaryManager.getWhitelist(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }
}
