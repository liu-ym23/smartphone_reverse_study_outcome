package com.uxsense.core;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.parse.MetadataType;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\r\u0010\fJ2\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011JB\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0017\u0010\fJ\r\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/uxsense/core/ApexRuleManager;", "", AppAgent.CONSTRUCT, "()V", "", "packageName", "Lcom/uxsense/core/ApexRuleManager$RulesCache;", "getCache", "(Ljava/lang/String;)Lcom/uxsense/core/ApexRuleManager$RulesCache;", "", "Lcom/uxsense/base/parse/ParseRule;", "loadRules", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "getRules", "activityClass", "windowTitle", "findRule", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/parse/MetadataType;", "type", "findRules", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/parse/MetadataType;LH7/c;)Ljava/lang/Object;", "LC7/r;", "refreshRules", "clearAllCache", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "rulesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "RulesCache", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexRuleManager {
    private static final String TAG = "ApexRuleManager";
    public static final ApexRuleManager INSTANCE = new ApexRuleManager();
    private static final ConcurrentHashMap<String, RulesCache> rulesMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/uxsense/core/ApexRuleManager$RulesCache;", "", "", "Lcom/uxsense/base/parse/ParseRule;", "rules", "Lw9/a;", "mutex", AppAgent.CONSTRUCT, "(Ljava/util/List;Lw9/a;)V", "component1", "()Ljava/util/List;", "component2", "()Lw9/a;", "copy", "(Ljava/util/List;Lw9/a;)Lcom/uxsense/core/ApexRuleManager$RulesCache;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getRules", "Lw9/a;", "getMutex", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class RulesCache {
        private final InterfaceC2108a mutex;
        private final List<ParseRule> rules;

        public RulesCache() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RulesCache copy$default(RulesCache rulesCache, List list, InterfaceC2108a interfaceC2108a, int i, Object obj) {
            if ((i & 1) != 0) {
                list = rulesCache.rules;
            }
            if ((i & 2) != 0) {
                interfaceC2108a = rulesCache.mutex;
            }
            return rulesCache.copy(list, interfaceC2108a);
        }

        public final List<ParseRule> component1() {
            return this.rules;
        }

        /* renamed from: component2, reason: from getter */
        public final InterfaceC2108a getMutex() {
            return this.mutex;
        }

        public final RulesCache copy(List<ParseRule> rules, InterfaceC2108a mutex) {
            k.f(rules, "rules");
            k.f(mutex, "mutex");
            return new RulesCache(rules, mutex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RulesCache)) {
                return false;
            }
            RulesCache rulesCache = (RulesCache) other;
            return k.b(this.rules, rulesCache.rules) && k.b(this.mutex, rulesCache.mutex);
        }

        public final InterfaceC2108a getMutex() {
            return this.mutex;
        }

        public final List<ParseRule> getRules() {
            return this.rules;
        }

        public int hashCode() {
            return this.mutex.hashCode() + (this.rules.hashCode() * 31);
        }

        public String toString() {
            return "RulesCache(rules=" + this.rules + ", mutex=" + this.mutex + ')';
        }

        public RulesCache(List<ParseRule> rules, InterfaceC2108a mutex) {
            k.f(rules, "rules");
            k.f(mutex, "mutex");
            this.rules = rules;
            this.mutex = mutex;
        }

        public RulesCache(List list, InterfaceC2108a interfaceC2108a, int i, kotlin.jvm.internal.e eVar) {
            this((i & 1) != 0 ? EmptyList.f4893a : list, (i & 2) != 0 ? new kotlinx.coroutines.sync.a() : interfaceC2108a);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexRuleManager", f = "ApexRuleManager.kt", l = {71}, m = "findRule")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.ApexRuleManager$findRule$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleManager.this.findRule(null, null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexRuleManager", f = "ApexRuleManager.kt", l = {86}, m = "findRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.ApexRuleManager$findRules$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C12431(H7.c<? super C12431> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleManager.this.findRules(null, null, null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexRuleManager", f = "ApexRuleManager.kt", l = {119, 40}, m = "getRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.ApexRuleManager$getRules$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C12441(H7.c<? super C12441> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleManager.this.getRules(null, this);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexRuleManager", f = "ApexRuleManager.kt", l = {50}, m = "loadRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.ApexRuleManager$loadRules$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12451 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12451(H7.c<? super C12451> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleManager.this.loadRules(null, this);
        }
    }

    @J7.c(c = "com.uxsense.core.ApexRuleManager", f = "ApexRuleManager.kt", l = {119, LocationRequestCompat.QUALITY_LOW_POWER}, m = "refreshRules")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.ApexRuleManager$refreshRules$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C12461(H7.c<? super C12461> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexRuleManager.this.refreshRules(null, this);
        }
    }

    private ApexRuleManager() {
    }

    public static /* synthetic */ Object findRule$default(ApexRuleManager apexRuleManager, String str, String str2, String str3, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return apexRuleManager.findRule(str, str2, str3, cVar);
    }

    public static /* synthetic */ Object findRules$default(ApexRuleManager apexRuleManager, String str, String str2, String str3, MetadataType metadataType, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            metadataType = null;
        }
        return apexRuleManager.findRules(str, str2, str3, metadataType, cVar);
    }

    private final RulesCache getCache(String packageName) {
        ConcurrentHashMap<String, RulesCache> concurrentHashMap = rulesMap;
        final d dVar = new d(1);
        RulesCache rulesCacheComputeIfAbsent = concurrentHashMap.computeIfAbsent(packageName, new Function() { // from class: com.uxsense.core.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ApexRuleManager.getCache$lambda$1(dVar, obj);
            }
        });
        k.e(rulesCacheComputeIfAbsent, "computeIfAbsent(...)");
        return rulesCacheComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RulesCache getCache$lambda$0(String it) {
        k.f(it, "it");
        return new RulesCache(null, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RulesCache getCache$lambda$1(S7.k kVar, Object obj) {
        return (RulesCache) kVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadRules(java.lang.String r9, H7.c<? super java.util.List<com.uxsense.base.parse.ParseRule>> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "loadRules failed: "
            boolean r1 = r10 instanceof com.uxsense.core.ApexRuleManager.C12451
            if (r1 == 0) goto L15
            r1 = r10
            com.uxsense.core.ApexRuleManager$loadRules$1 r1 = (com.uxsense.core.ApexRuleManager.C12451) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.uxsense.core.ApexRuleManager$loadRules$1 r1 = new com.uxsense.core.ApexRuleManager$loadRules$1
            r1.<init>(r10)
        L1a:
            java.lang.Object r8 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r1.label
            r3 = 4
            java.lang.String r4 = " for "
            java.lang.String r5 = "ApexRuleManager"
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L3d
            if (r2 != r6) goto L35
            java.lang.Object r9 = r1.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.b.b(r8)     // Catch: java.lang.Exception -> L33
            goto L4d
        L33:
            r8 = move-exception
            goto L88
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.b.b(r8)
            com.uxsense.core.ApexMetadataFileManager r8 = com.uxsense.core.ApexMetadataFileManager.INSTANCE     // Catch: java.lang.Exception -> L33
            r1.L$0 = r9     // Catch: java.lang.Exception -> L33
            r1.label = r6     // Catch: java.lang.Exception -> L33
            java.lang.Object r8 = com.uxsense.core.ParseRuleExtensionsKt.loadRules(r8, r9, r1)     // Catch: java.lang.Exception -> L33
            if (r8 != r10) goto L4d
            return r10
        L4d:
            com.uxsense.file.FileResult r8 = (com.uxsense.file.FileResult) r8     // Catch: java.lang.Exception -> L33
            boolean r10 = r8 instanceof com.uxsense.file.FileResult.Success     // Catch: java.lang.Exception -> L33
            if (r10 == 0) goto L60
            com.uxsense.file.FileResult$Success r8 = (com.uxsense.file.FileResult.Success) r8     // Catch: java.lang.Exception -> L33
            java.lang.Object r8 = r8.getData()     // Catch: java.lang.Exception -> L33
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch: java.lang.Exception -> L33
            java.util.List r8 = D7.v.f1(r8)     // Catch: java.lang.Exception -> L33
            return r8
        L60:
            boolean r10 = r8 instanceof com.uxsense.file.FileResult.Error     // Catch: java.lang.Exception -> L33
            if (r10 == 0) goto L82
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L33
            r10.<init>(r0)     // Catch: java.lang.Exception -> L33
            com.uxsense.file.FileResult$Error r8 = (com.uxsense.file.FileResult.Error) r8     // Catch: java.lang.Exception -> L33
            com.uxsense.file.FileException r8 = r8.getException()     // Catch: java.lang.Exception -> L33
            r10.append(r8)     // Catch: java.lang.Exception -> L33
            r10.append(r4)     // Catch: java.lang.Exception -> L33
            r10.append(r9)     // Catch: java.lang.Exception -> L33
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Exception -> L33
            com.uxsense.utils.ALog.e$default(r5, r8, r7, r3, r7)     // Catch: java.lang.Exception -> L33
            kotlin.collections.EmptyList r8 = kotlin.collections.EmptyList.f4893a     // Catch: java.lang.Exception -> L33
            return r8
        L82:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Exception -> L33
            r8.<init>()     // Catch: java.lang.Exception -> L33
            throw r8     // Catch: java.lang.Exception -> L33
        L88:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "loadRules exception: "
            r10.<init>(r0)
            r10.append(r8)
            r10.append(r4)
            r10.append(r9)
            java.lang.String r8 = r10.toString()
            com.uxsense.utils.ALog.e$default(r5, r8, r7, r3, r7)
            kotlin.collections.EmptyList r8 = kotlin.collections.EmptyList.f4893a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ApexRuleManager.loadRules(java.lang.String, H7.c):java.lang.Object");
    }

    public final void clearAllCache() {
        rulesMap.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findRule(java.lang.String r6, java.lang.String r7, java.lang.String r8, H7.c<? super com.uxsense.base.parse.ParseRule> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.uxsense.core.ApexRuleManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            com.uxsense.core.ApexRuleManager$findRule$1 r0 = (com.uxsense.core.ApexRuleManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.core.ApexRuleManager$findRule$1 r0 = new com.uxsense.core.ApexRuleManager$findRule$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r5 = r0.L$1
            r8 = r5
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r5 = r0.L$0
            r7 = r5
            java.lang.String r7 = (java.lang.String) r7
            kotlin.b.b(r9)
            goto L4f
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.b.b(r9)
            if (r7 != 0) goto L42
            if (r8 != 0) goto L42
            return r3
        L42:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.getRules(r6, r0)
            if (r9 != r1) goto L4f
            return r1
        L4f:
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r5 = r9.iterator()
        L55:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L84
            java.lang.Object r6 = r5.next()
            r9 = r6
            com.uxsense.base.parse.ParseRule r9 = (com.uxsense.base.parse.ParseRule) r9
            if (r7 == 0) goto L6d
            java.lang.String r0 = r9.getActivityClass()
            boolean r0 = r7.equals(r0)
            goto L6e
        L6d:
            r0 = r4
        L6e:
            if (r0 == 0) goto L80
            if (r8 == 0) goto L7b
            java.lang.String r9 = r9.getWindowTitle()
            boolean r9 = r8.equals(r9)
            goto L7c
        L7b:
            r9 = r4
        L7c:
            if (r9 == 0) goto L80
            r9 = r4
            goto L81
        L80:
            r9 = 0
        L81:
            if (r9 == 0) goto L55
            return r6
        L84:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ApexRuleManager.findRule(java.lang.String, java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findRules(java.lang.String r7, java.lang.String r8, java.lang.String r9, com.uxsense.parse.MetadataType r10, H7.c<? super java.util.List<com.uxsense.base.parse.ParseRule>> r11) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ApexRuleManager.findRules(java.lang.String, java.lang.String, java.lang.String, com.uxsense.parse.MetadataType, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getRules(java.lang.String r7, H7.c<? super java.util.List<com.uxsense.base.parse.ParseRule>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.uxsense.core.ApexRuleManager.C12441
            if (r0 == 0) goto L13
            r0 = r8
            com.uxsense.core.ApexRuleManager$getRules$1 r0 = (com.uxsense.core.ApexRuleManager.C12441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.core.ApexRuleManager$getRules$1 r0 = new com.uxsense.core.ApexRuleManager$getRules$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L52
            if (r2 == r3) goto L42
            if (r2 != r4) goto L3a
            java.lang.Object r6 = r0.L$2
            w9.a r6 = (w9.InterfaceC2108a) r6
            java.lang.Object r7 = r0.L$1
            com.uxsense.core.ApexRuleManager$RulesCache r7 = (com.uxsense.core.ApexRuleManager.RulesCache) r7
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L37
            goto La1
        L37:
            r7 = move-exception
            goto Lb0
        L3a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L42:
            java.lang.Object r6 = r0.L$2
            w9.a r6 = (w9.InterfaceC2108a) r6
            java.lang.Object r7 = r0.L$1
            com.uxsense.core.ApexRuleManager$RulesCache r7 = (com.uxsense.core.ApexRuleManager.RulesCache) r7
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.b.b(r8)
            goto L7b
        L52:
            kotlin.b.b(r8)
            com.uxsense.core.ApexRuleManager$RulesCache r6 = r6.getCache(r7)
            java.util.List r8 = r6.getRules()
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r2 = r8.isEmpty()
            if (r2 == 0) goto Lb4
            w9.a r8 = r6.getMutex()
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L78
            goto L9f
        L78:
            r2 = r7
            r7 = r6
            r6 = r8
        L7b:
            java.util.List r8 = r7.getRules()     // Catch: java.lang.Throwable -> L37
            java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L37
            boolean r8 = r8.isEmpty()     // Catch: java.lang.Throwable -> L37
            if (r8 != 0) goto L8f
            java.util.List r7 = r7.getRules()     // Catch: java.lang.Throwable -> L37
            r6.unlock(r5)
            return r7
        L8f:
            com.uxsense.core.ApexRuleManager r8 = com.uxsense.core.ApexRuleManager.INSTANCE     // Catch: java.lang.Throwable -> L37
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L37
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L37
            r0.L$2 = r6     // Catch: java.lang.Throwable -> L37
            r0.label = r4     // Catch: java.lang.Throwable -> L37
            java.lang.Object r8 = r8.loadRules(r2, r0)     // Catch: java.lang.Throwable -> L37
            if (r8 != r1) goto La0
        L9f:
            return r1
        La0:
            r0 = r2
        La1:
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L37
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.uxsense.core.ApexRuleManager$RulesCache> r1 = com.uxsense.core.ApexRuleManager.rulesMap     // Catch: java.lang.Throwable -> L37
            com.uxsense.core.ApexRuleManager$RulesCache r7 = com.uxsense.core.ApexRuleManager.RulesCache.copy$default(r7, r8, r5, r4, r5)     // Catch: java.lang.Throwable -> L37
            r1.put(r0, r7)     // Catch: java.lang.Throwable -> L37
            r6.unlock(r5)
            return r8
        Lb0:
            r6.unlock(r5)
            throw r7
        Lb4:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ApexRuleManager.getRules(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.uxsense.core.ApexRuleManager] */
    /* JADX WARN: Type inference failed for: r7v1, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v5, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshRules(java.lang.String r8, H7.c<? super C7.r> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.uxsense.core.ApexRuleManager.C12461
            if (r0 == 0) goto L13
            r0 = r9
            com.uxsense.core.ApexRuleManager$refreshRules$1 r0 = (com.uxsense.core.ApexRuleManager.C12461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.core.ApexRuleManager$refreshRules$1 r0 = new com.uxsense.core.ApexRuleManager$refreshRules$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L53
            if (r2 == r3) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r7 = r0.L$2
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r8 = r0.L$1
            com.uxsense.core.ApexRuleManager$RulesCache r8 = (com.uxsense.core.ApexRuleManager.RulesCache) r8
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L37
            goto L85
        L37:
            r8 = move-exception
            goto L96
        L39:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L41:
            java.lang.Object r7 = r0.L$2
            w9.a r7 = (w9.InterfaceC2108a) r7
            java.lang.Object r8 = r0.L$1
            com.uxsense.core.ApexRuleManager$RulesCache r8 = (com.uxsense.core.ApexRuleManager.RulesCache) r8
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.b.b(r9)
            r9 = r8
            r8 = r2
            goto L70
        L53:
            kotlin.b.b(r9)
            com.uxsense.core.ApexRuleManager$RulesCache r7 = r7.getCache(r8)
            w9.a r9 = r7.getMutex()
            r0.L$0 = r8
            r0.L$1 = r7
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r2 = r9.lock(r5, r0)
            if (r2 != r1) goto L6d
            goto L80
        L6d:
            r6 = r9
            r9 = r7
            r7 = r6
        L70:
            com.uxsense.core.ApexRuleManager r2 = com.uxsense.core.ApexRuleManager.INSTANCE     // Catch: java.lang.Throwable -> L37
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L37
            r0.L$1 = r9     // Catch: java.lang.Throwable -> L37
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L37
            r0.label = r4     // Catch: java.lang.Throwable -> L37
            java.lang.Object r0 = r2.loadRules(r8, r0)     // Catch: java.lang.Throwable -> L37
            if (r0 != r1) goto L81
        L80:
            return r1
        L81:
            r6 = r0
            r0 = r8
            r8 = r9
            r9 = r6
        L85:
            java.util.List r9 = (java.util.List) r9     // Catch: java.lang.Throwable -> L37
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.uxsense.core.ApexRuleManager$RulesCache> r1 = com.uxsense.core.ApexRuleManager.rulesMap     // Catch: java.lang.Throwable -> L37
            com.uxsense.core.ApexRuleManager$RulesCache r8 = com.uxsense.core.ApexRuleManager.RulesCache.copy$default(r8, r9, r5, r4, r5)     // Catch: java.lang.Throwable -> L37
            r1.put(r0, r8)     // Catch: java.lang.Throwable -> L37
            r7.unlock(r5)
            C7.r r7 = C7.r.f317a
            return r7
        L96:
            r7.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.ApexRuleManager.refreshRules(java.lang.String, H7.c):java.lang.Object");
    }
}
