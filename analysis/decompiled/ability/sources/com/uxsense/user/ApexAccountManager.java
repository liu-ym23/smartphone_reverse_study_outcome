package com.uxsense.user;

import C7.r;
import J7.c;
import R3.f;
import S7.k;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.utils.ALog;
import j9.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJP\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013JX\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u001d\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010\u0003JK\u0010#\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0007¢\u0006\u0004\b%\u0010&J'\u0010'\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0007¢\u0006\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R0\u0010/\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00110-j\b\u0012\u0004\u0012\u00020\u0011`.0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100¨\u00062"}, d2 = {"Lcom/uxsense/user/ApexAccountManager;", "", AppAgent.CONSTRUCT, "()V", "", "appName", "Lw9/a;", "getMutex", "(Ljava/lang/String;)Lw9/a;", "", "androidUserId", "", "userId", "uuid", "nickname", "", "fullMatchNickname", "Lcom/uxsense/user/AccountEntry;", "findLoginAccount", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLH7/c;)Ljava/lang/Object;", "forceRefresh", "findAccountOrCreate", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZZLH7/c;)Ljava/lang/Object;", "account", "LC7/r;", "notifyAccountLogin", "(Ljava/lang/String;Lcom/uxsense/user/AccountEntry;LH7/c;)Ljava/lang/Object;", "notifyAccountLogout", "(Ljava/lang/String;JILH7/c;)Ljava/lang/Object;", "notifyAccountUpdated", "invalidateCache", "(Ljava/lang/String;J)V", "invalidateAppCache", "(Ljava/lang/String;)V", "clearAllCache", "getCurrentAccountSync", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Z)Lcom/uxsense/user/AccountEntry;", "notifyAccountLoginSync", "(Ljava/lang/String;Lcom/uxsense/user/AccountEntry;)V", "notifyAccountLogoutSync", "(Ljava/lang/String;JI)V", "notifyAccountUpdatedSync", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "accountCache", "Ljava/util/concurrent/ConcurrentHashMap;", "mutexMap", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexAccountManager {
    private static final String TAG = "ApexAccountManager";
    public static final ApexAccountManager INSTANCE = new ApexAccountManager();
    private static final ConcurrentHashMap<String, HashSet<AccountEntry>> accountCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, InterfaceC2108a> mutexMap = new ConcurrentHashMap<>();

    @c(c = "com.uxsense.user.ApexAccountManager", f = "ApexAccountManager.kt", l = {167, 385, 218}, m = "findAccountOrCreate")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountManager$findAccountOrCreate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountManager.this.findAccountOrCreate(null, 0, null, null, null, false, false, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager", f = "ApexAccountManager.kt", l = {106}, m = "findLoginAccount")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountManager$findLoginAccount$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13521 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13521(H7.c<? super C13521> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountManager.this.findLoginAccount(null, 0, null, null, null, false, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager$getCurrentAccountSync$1", f = "ApexAccountManager.kt", l = {361}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/user/AccountEntry;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/user/AccountEntry;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountManager$getCurrentAccountSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13531 extends SuspendLambda implements n {
        final /* synthetic */ int $androidUserId;
        final /* synthetic */ String $appName;
        final /* synthetic */ boolean $forceRefresh;
        final /* synthetic */ String $nickname;
        final /* synthetic */ Long $userId;
        final /* synthetic */ String $uuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13531(String str, int i, Long l, String str2, String str3, boolean z10, H7.c<? super C13531> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$androidUserId = i;
            this.$userId = l;
            this.$uuid = str2;
            this.$nickname = str3;
            this.$forceRefresh = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13531(this.$appName, this.$androidUserId, this.$userId, this.$uuid, this.$nickname, this.$forceRefresh, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            ApexAccountManager apexAccountManager = ApexAccountManager.INSTANCE;
            String str = this.$appName;
            int i6 = this.$androidUserId;
            Long l = this.$userId;
            String str2 = this.$uuid;
            String str3 = this.$nickname;
            boolean z10 = this.$forceRefresh;
            this.label = 1;
            Object objFindAccountOrCreate$default = ApexAccountManager.findAccountOrCreate$default(apexAccountManager, str, i6, l, str2, str3, z10, false, this, 64, null);
            return objFindAccountOrCreate$default == coroutineSingletons ? coroutineSingletons : objFindAccountOrCreate$default;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super AccountEntry> cVar) {
            return ((C13531) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager", f = "ApexAccountManager.kt", l = {386, 251}, m = "notifyAccountLogin")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountManager$notifyAccountLogin$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13541 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13541(H7.c<? super C13541> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountManager.this.notifyAccountLogin(null, null, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager$notifyAccountLoginSync$1", f = "ApexAccountManager.kt", l = {366}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountManager$notifyAccountLoginSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13551 extends SuspendLambda implements n {
        final /* synthetic */ AccountEntry $account;
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13551(String str, AccountEntry accountEntry, H7.c<? super C13551> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$account = accountEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13551(this.$appName, this.$account, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                ApexAccountManager apexAccountManager = ApexAccountManager.INSTANCE;
                String str = this.$appName;
                AccountEntry accountEntry = this.$account;
                this.label = 1;
                if (apexAccountManager.notifyAccountLogin(str, accountEntry, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C13551) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager", f = "ApexAccountManager.kt", l = {385, 282}, m = "notifyAccountLogout")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountManager$notifyAccountLogout$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13561 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13561(H7.c<? super C13561> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountManager.this.notifyAccountLogout(null, 0L, 0, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager$notifyAccountLogoutSync$1", f = "ApexAccountManager.kt", l = {371}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountManager$notifyAccountLogoutSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13571 extends SuspendLambda implements n {
        final /* synthetic */ int $androidUserId;
        final /* synthetic */ String $appName;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13571(String str, long j5, int i, H7.c<? super C13571> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$androidUserId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13571(this.$appName, this.$userId, this.$androidUserId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                ApexAccountManager apexAccountManager = ApexAccountManager.INSTANCE;
                String str = this.$appName;
                long j5 = this.$userId;
                int i6 = this.$androidUserId;
                this.label = 1;
                if (apexAccountManager.notifyAccountLogout(str, j5, i6, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C13571) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager", f = "ApexAccountManager.kt", l = {385, 311}, m = "notifyAccountUpdated")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountManager$notifyAccountUpdated$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13581(H7.c<? super C13581> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountManager.this.notifyAccountUpdated(null, null, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountManager$notifyAccountUpdatedSync$1", f = "ApexAccountManager.kt", l = {376}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountManager$notifyAccountUpdatedSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13591 extends SuspendLambda implements n {
        final /* synthetic */ AccountEntry $account;
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13591(String str, AccountEntry accountEntry, H7.c<? super C13591> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$account = accountEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13591(this.$appName, this.$account, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                ApexAccountManager apexAccountManager = ApexAccountManager.INSTANCE;
                String str = this.$appName;
                AccountEntry accountEntry = this.$account;
                this.label = 1;
                if (apexAccountManager.notifyAccountUpdated(str, accountEntry, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C13591) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    private ApexAccountManager() {
    }

    public static /* synthetic */ Object findAccountOrCreate$default(ApexAccountManager apexAccountManager, String str, int i, Long l, String str2, String str3, boolean z10, boolean z11, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        if ((i6 & 8) != 0) {
            str2 = null;
        }
        if ((i6 & 16) != 0) {
            str3 = null;
        }
        if ((i6 & 32) != 0) {
            z10 = false;
        }
        if ((i6 & 64) != 0) {
            z11 = true;
        }
        return apexAccountManager.findAccountOrCreate(str, i, l, str2, str3, z10, z11, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0065 A[EDGE_INSN: B:50:0x0065->B:31:0x0065 BREAK  A[LOOP:0: B:5:0x000f->B:53:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:0: B:5:0x000f->B:53:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.uxsense.user.AccountEntry findAccountOrCreate$lambda$7(java.lang.String r10, int r11, java.lang.Long r12, java.lang.String r13, java.lang.String r14, boolean r15) {
        /*
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.HashSet<com.uxsense.user.AccountEntry>> r0 = com.uxsense.user.ApexAccountManager.accountCache
            java.lang.Object r10 = r0.get(r10)
            java.util.HashSet r10 = (java.util.HashSet) r10
            r0 = 0
            if (r10 == 0) goto L95
            java.util.Iterator r1 = r10.iterator()
        Lf:
            boolean r2 = r1.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L64
            java.lang.Object r2 = r1.next()
            r5 = r2
            com.uxsense.user.AccountEntry r5 = (com.uxsense.user.AccountEntry) r5
            if (r12 == 0) goto L2c
            long r6 = r5.getUserId()
            long r8 = r12.longValue()
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L5e
        L2c:
            if (r13 == 0) goto L3f
            int r6 = r13.length()
            if (r6 != 0) goto L35
            goto L3f
        L35:
            java.lang.String r6 = r5.getUuid()
            boolean r6 = kotlin.jvm.internal.k.b(r6, r13)
            if (r6 == 0) goto L5e
        L3f:
            if (r14 == 0) goto L60
            int r6 = r14.length()
            if (r6 != 0) goto L48
            goto L60
        L48:
            if (r15 == 0) goto L53
            java.lang.String r5 = r5.getNickname()
            boolean r5 = kotlin.jvm.internal.k.b(r5, r14)
            goto L5b
        L53:
            java.lang.String r5 = r5.getNickname()
            boolean r5 = j9.m.h0(r5, r14, r4)
        L5b:
            if (r5 == 0) goto L5e
            goto L60
        L5e:
            r5 = r4
            goto L61
        L60:
            r5 = r3
        L61:
            if (r5 == 0) goto Lf
            goto L65
        L64:
            r2 = r0
        L65:
            com.uxsense.user.AccountEntry r2 = (com.uxsense.user.AccountEntry) r2
            if (r2 != 0) goto L8f
            java.util.Iterator r10 = r10.iterator()
        L6d:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L8c
            java.lang.Object r12 = r10.next()
            r13 = r12
            com.uxsense.user.AccountEntry r13 = (com.uxsense.user.AccountEntry) r13
            boolean r14 = r13.getMarkTemp()
            if (r14 == 0) goto L88
            int r13 = r13.getAndroidUserId()
            if (r13 != r11) goto L88
            r13 = r3
            goto L89
        L88:
            r13 = r4
        L89:
            if (r13 == 0) goto L6d
            r0 = r12
        L8c:
            r2 = r0
            com.uxsense.user.AccountEntry r2 = (com.uxsense.user.AccountEntry) r2
        L8f:
            if (r2 == 0) goto L94
            r2.setAndroidUserId(r11)
        L94:
            return r2
        L95:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountManager.findAccountOrCreate$lambda$7(java.lang.String, int, java.lang.Long, java.lang.String, java.lang.String, boolean):com.uxsense.user.AccountEntry");
    }

    public static /* synthetic */ Object findLoginAccount$default(ApexAccountManager apexAccountManager, String str, int i, Long l, String str2, String str3, boolean z10, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        if ((i6 & 8) != 0) {
            str2 = null;
        }
        if ((i6 & 16) != 0) {
            str3 = null;
        }
        if ((i6 & 32) != 0) {
            z10 = true;
        }
        return apexAccountManager.findLoginAccount(str, i, l, str2, str3, z10, cVar);
    }

    public static /* synthetic */ AccountEntry getCurrentAccountSync$default(ApexAccountManager apexAccountManager, String str, int i, Long l, String str2, String str3, boolean z10, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        if ((i6 & 8) != 0) {
            str2 = null;
        }
        if ((i6 & 16) != 0) {
            str3 = "";
        }
        if ((i6 & 32) != 0) {
            z10 = false;
        }
        return apexAccountManager.getCurrentAccountSync(str, i, l, str2, str3, z10);
    }

    private final InterfaceC2108a getMutex(String appName) {
        InterfaceC2108a interfaceC2108aPutIfAbsent;
        ConcurrentHashMap<String, InterfaceC2108a> concurrentHashMap = mutexMap;
        InterfaceC2108a aVar = concurrentHashMap.get(appName);
        if (aVar == null && (interfaceC2108aPutIfAbsent = concurrentHashMap.putIfAbsent(appName, (aVar = new kotlinx.coroutines.sync.a()))) != null) {
            aVar = interfaceC2108aPutIfAbsent;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invalidateCache$lambda$22(long j5, AccountEntry accountEntry) {
        return accountEntry.getUserId() == j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invalidateCache$lambda$23(k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountEntry notifyAccountLogin$lambda$13$lambda$12(AccountEntry accountEntry, AccountEntry it) {
        kotlin.jvm.internal.k.f(it, "it");
        return AccountEntry.copy$default(accountEntry, 0L, 0, null, null, System.currentTimeMillis(), true, false, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountEntry notifyAccountUpdated$lambda$21$lambda$20(AccountEntry accountEntry, AccountEntry it) {
        kotlin.jvm.internal.k.f(it, "it");
        return accountEntry;
    }

    public final void clearAllCache() {
        ConcurrentHashMap<String, HashSet<AccountEntry>> concurrentHashMap = accountCache;
        int size = concurrentHashMap.size();
        concurrentHashMap.clear();
        ALog.d$default(TAG, "All cache cleared, count=" + size, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findAccountOrCreate(java.lang.String r17, int r18, java.lang.Long r19, java.lang.String r20, java.lang.String r21, boolean r22, boolean r23, H7.c<? super com.uxsense.user.AccountEntry> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountManager.findAccountOrCreate(java.lang.String, int, java.lang.Long, java.lang.String, java.lang.String, boolean, boolean, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findLoginAccount(java.lang.String r7, int r8, java.lang.Long r9, java.lang.String r10, java.lang.String r11, boolean r12, H7.c<? super com.uxsense.user.AccountEntry> r13) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountManager.findLoginAccount(java.lang.String, int, java.lang.Long, java.lang.String, java.lang.String, boolean, H7.c):java.lang.Object");
    }

    public final AccountEntry getCurrentAccountSync(String appName, int androidUserId, Long userId, String uuid, String nickname, boolean forceRefresh) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(nickname, "nickname");
        return (AccountEntry) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13531(appName, androidUserId, userId, uuid, nickname, forceRefresh, null));
    }

    public final void invalidateAppCache(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        Set<String> setKeySet = accountCache.keySet();
        kotlin.jvm.internal.k.e(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String str = (String) obj;
            kotlin.jvm.internal.k.c(str);
            if (t.e0(str, appName.concat("_"), false)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            accountCache.remove((String) it.next());
        }
        StringBuilder sbV = B7.a.v("Cache invalidated for app: ", appName, ", count=");
        sbV.append(arrayList.size());
        ALog.d$default(TAG, sbV.toString(), null, 4, null);
    }

    public final void invalidateCache(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        HashSet<AccountEntry> hashSet = accountCache.get(appName);
        if (hashSet != null) {
            hashSet.removeIf(new androidx.window.embedding.b(new f(userId, 4), 4));
        }
        ALog.d$default(TAG, "Cache invalidated for " + appName + ": " + userId, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.uxsense.user.ApexAccountManager] */
    /* JADX WARN: Type inference failed for: r9v1, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v5, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object notifyAccountLogin(java.lang.String r10, com.uxsense.user.AccountEntry r11, H7.c<? super C7.r> r12) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountManager.notifyAccountLogin(java.lang.String, com.uxsense.user.AccountEntry, H7.c):java.lang.Object");
    }

    public final void notifyAccountLoginSync(String appName, AccountEntry account) throws Throwable {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(account, "account");
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13551(appName, account, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object notifyAccountLogout(java.lang.String r10, long r11, int r13, H7.c<? super C7.r> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountManager.notifyAccountLogout(java.lang.String, long, int, H7.c):java.lang.Object");
    }

    public final void notifyAccountLogoutSync(String appName, long userId, int androidUserId) throws Throwable {
        kotlin.jvm.internal.k.f(appName, "appName");
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13571(appName, userId, androidUserId, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.uxsense.user.ApexAccountManager] */
    /* JADX WARN: Type inference failed for: r10v1, types: [w9.a] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v4, types: [w9.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object notifyAccountUpdated(java.lang.String r11, com.uxsense.user.AccountEntry r12, H7.c<? super C7.r> r13) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountManager.notifyAccountUpdated(java.lang.String, com.uxsense.user.AccountEntry, H7.c):java.lang.Object");
    }

    public final void notifyAccountUpdatedSync(String appName, AccountEntry account) throws Throwable {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(account, "account");
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13591(appName, account, null));
    }
}
