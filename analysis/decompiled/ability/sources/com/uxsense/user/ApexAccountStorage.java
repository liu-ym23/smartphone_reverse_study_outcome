package com.uxsense.user;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.runtime.ComposerKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.file.FileResult;
import com.uxsense.file.FileStorageManager;
import com.uxsense.utils.LockFreeSnowflakeGenerator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0011H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001b\u0010\u0017J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001c\u0010\u0017J?\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0004\b\u001f\u0010 J#\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u001b\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00182\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J#\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b%\u0010\"J#\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b&\u0010\"R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/uxsense/user/ApexAccountStorage;", "", AppAgent.CONSTRUCT, "()V", "", "appName", "", "androidUserId", "", "userId", "uuid", "nickname", "", "fullMatchNickname", "Lcom/uxsense/user/AccountEntry;", "findAccountOrCreate", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZLH7/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "transform", "Lcom/uxsense/file/FileResult;", "updateUser", "(Ljava/lang/String;JLS7/k;LH7/c;)Ljava/lang/Object;", "deleteUser", "(Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "", "getAllUsers", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "markLogin", "markLogout", "getCurrentAccountOrCreateSync", "(Ljava/lang/String;ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/uxsense/user/AccountEntry;", "updateUserSync", "(Ljava/lang/String;JLS7/k;)Lcom/uxsense/file/FileResult;", "deleteUserSync", "(Ljava/lang/String;J)Lcom/uxsense/file/FileResult;", "getAllUsersSync", "(Ljava/lang/String;)Ljava/util/List;", "markLoginSync", "markLogoutSync", "Lcom/uxsense/file/FileStorageManager;", "storage_", "Lcom/uxsense/file/FileStorageManager;", "Lcom/uxsense/utils/LockFreeSnowflakeGenerator;", "idGenerator_", "Lcom/uxsense/utils/LockFreeSnowflakeGenerator;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexAccountStorage {
    public static final ApexAccountStorage INSTANCE = new ApexAccountStorage();
    private static final LockFreeSnowflakeGenerator idGenerator_;
    private static final FileStorageManager storage_;

    @c(c = "com.uxsense.user.ApexAccountStorage", f = "ApexAccountStorage.kt", l = {193, 200}, m = "deleteUser")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountStorage$deleteUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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
            return ApexAccountStorage.this.deleteUser(null, 0L, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage$deleteUserSync$1", f = "ApexAccountStorage.kt", l = {175}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountStorage$deleteUserSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13601 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13601(String str, long j5, H7.c<? super C13601> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13601(this.$appName, this.$userId, cVar);
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
            ApexAccountStorage apexAccountStorage = ApexAccountStorage.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            this.label = 1;
            Object objDeleteUser = apexAccountStorage.deleteUser(str, j5, this);
            return objDeleteUser == coroutineSingletons ? coroutineSingletons : objDeleteUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Boolean>> cVar) {
            return ((C13601) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage", f = "ApexAccountStorage.kt", l = {191, 193}, m = "findAccountOrCreate")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountStorage$findAccountOrCreate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13611 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C13611(H7.c<? super C13611> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountStorage.this.findAccountOrCreate(null, 0, null, null, null, false, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage", f = "ApexAccountStorage.kt", l = {191}, m = "getAllUsers")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountStorage$getAllUsers$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13621 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C13621(H7.c<? super C13621> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountStorage.this.getAllUsers(null, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage$getAllUsersSync$1", f = "ApexAccountStorage.kt", l = {179}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/user/AccountEntry;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountStorage$getAllUsersSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13631 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13631(String str, H7.c<? super C13631> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13631(this.$appName, cVar);
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
            ApexAccountStorage apexAccountStorage = ApexAccountStorage.INSTANCE;
            String str = this.$appName;
            this.label = 1;
            Object allUsers = apexAccountStorage.getAllUsers(str, this);
            return allUsers == coroutineSingletons ? coroutineSingletons : allUsers;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<AccountEntry>> cVar) {
            return ((C13631) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage$getCurrentAccountOrCreateSync$1", f = "ApexAccountStorage.kt", l = {163}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/user/AccountEntry;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/user/AccountEntry;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountStorage$getCurrentAccountOrCreateSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13641 extends SuspendLambda implements n {
        final /* synthetic */ int $androidUserId;
        final /* synthetic */ String $appName;
        final /* synthetic */ String $nickname;
        final /* synthetic */ Long $userId;
        final /* synthetic */ String $uuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13641(String str, int i, Long l, String str2, String str3, H7.c<? super C13641> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$androidUserId = i;
            this.$userId = l;
            this.$uuid = str2;
            this.$nickname = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13641(this.$appName, this.$androidUserId, this.$userId, this.$uuid, this.$nickname, cVar);
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
            ApexAccountStorage apexAccountStorage = ApexAccountStorage.INSTANCE;
            String str = this.$appName;
            int i6 = this.$androidUserId;
            Long l = this.$userId;
            String str2 = this.$uuid;
            String str3 = this.$nickname;
            this.label = 1;
            Object objFindAccountOrCreate$default = ApexAccountStorage.findAccountOrCreate$default(apexAccountStorage, str, i6, l, str2, str3, false, this, 32, null);
            return objFindAccountOrCreate$default == coroutineSingletons ? coroutineSingletons : objFindAccountOrCreate$default;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super AccountEntry> cVar) {
            return ((C13641) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage", f = "ApexAccountStorage.kt", l = {193, ComposerKt.reuseKey}, m = "markLogin")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountStorage$markLogin$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13651 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13651(H7.c<? super C13651> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountStorage.this.markLogin(null, 0L, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage$markLoginSync$1", f = "ApexAccountStorage.kt", l = {183}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountStorage$markLoginSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13661 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13661(String str, long j5, H7.c<? super C13661> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13661(this.$appName, this.$userId, cVar);
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
            ApexAccountStorage apexAccountStorage = ApexAccountStorage.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            this.label = 1;
            Object objMarkLogin = apexAccountStorage.markLogin(str, j5, this);
            return objMarkLogin == coroutineSingletons ? coroutineSingletons : objMarkLogin;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Integer>> cVar) {
            return ((C13661) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage", f = "ApexAccountStorage.kt", l = {193, ComposerKt.reuseKey}, m = "markLogout")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountStorage$markLogout$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13671 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C13671(H7.c<? super C13671> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountStorage.this.markLogout(null, 0L, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage$markLogoutSync$1", f = "ApexAccountStorage.kt", l = {187}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountStorage$markLogoutSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13681 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13681(String str, long j5, H7.c<? super C13681> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13681(this.$appName, this.$userId, cVar);
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
            ApexAccountStorage apexAccountStorage = ApexAccountStorage.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            this.label = 1;
            Object objMarkLogout = apexAccountStorage.markLogout(str, j5, this);
            return objMarkLogout == coroutineSingletons ? coroutineSingletons : objMarkLogout;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Integer>> cVar) {
            return ((C13681) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage", f = "ApexAccountStorage.kt", l = {193, ComposerKt.reuseKey}, m = "updateUser")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.user.ApexAccountStorage$updateUser$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13691 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C13691(H7.c<? super C13691> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexAccountStorage.this.updateUser(null, 0L, null, this);
        }
    }

    @c(c = "com.uxsense.user.ApexAccountStorage$updateUserSync$1", f = "ApexAccountStorage.kt", l = {171}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.user.ApexAccountStorage$updateUserSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13701 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ k $transform;
        final /* synthetic */ long $userId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13701(String str, long j5, k kVar, H7.c<? super C13701> cVar) {
            super(2, cVar);
            this.$appName = str;
            this.$userId = j5;
            this.$transform = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C13701(this.$appName, this.$userId, this.$transform, cVar);
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
            ApexAccountStorage apexAccountStorage = ApexAccountStorage.INSTANCE;
            String str = this.$appName;
            long j5 = this.$userId;
            k kVar = this.$transform;
            this.label = 1;
            Object objUpdateUser = apexAccountStorage.updateUser(str, j5, kVar, this);
            return objUpdateUser == coroutineSingletons ? coroutineSingletons : objUpdateUser;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Integer>> cVar) {
            return ((C13701) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    static {
        ApexMetadataFileManager apexMetadataFileManager = ApexMetadataFileManager.INSTANCE;
        storage_ = apexMetadataFileManager.getStorage_$uxsense_release();
        idGenerator_ = apexMetadataFileManager.getIdGenerator_$uxsense_release();
    }

    private ApexAccountStorage() {
    }

    public static /* synthetic */ Object findAccountOrCreate$default(ApexAccountStorage apexAccountStorage, String str, int i, Long l, String str2, String str3, boolean z10, H7.c cVar, int i6, Object obj) {
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
        return apexAccountStorage.findAccountOrCreate(str, i, l, str2, str3, z10, cVar);
    }

    public static /* synthetic */ AccountEntry getCurrentAccountOrCreateSync$default(ApexAccountStorage apexAccountStorage, String str, int i, Long l, String str2, String str3, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            l = null;
        }
        if ((i6 & 8) != 0) {
            str2 = null;
        }
        if ((i6 & 16) != 0) {
            str3 = "";
        }
        return apexAccountStorage.getCurrentAccountOrCreateSync(str, i, l, str2, str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b5 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:13:0x002a, B:37:0x00af, B:39:0x00b5, B:41:0x00bd, B:43:0x00c1, B:45:0x00cd, B:46:0x00d2, B:25:0x0057), top: B:57:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:13:0x002a, B:37:0x00af, B:39:0x00b5, B:41:0x00bd, B:43:0x00c1, B:45:0x00cd, B:46:0x00d2, B:25:0x0057), top: B:57:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object deleteUser(java.lang.String r6, final long r7, H7.c<? super com.uxsense.file.FileResult<java.lang.Boolean>> r9) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountStorage.deleteUser(java.lang.String, long, H7.c):java.lang.Object");
    }

    public final FileResult<Boolean> deleteUserSync(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13601(appName, userId, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object findAccountOrCreate(java.lang.String r21, int r22, java.lang.Long r23, java.lang.String r24, java.lang.String r25, boolean r26, H7.c<? super com.uxsense.user.AccountEntry> r27) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountStorage.findAccountOrCreate(java.lang.String, int, java.lang.Long, java.lang.String, java.lang.String, boolean, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAllUsers(java.lang.String r5, H7.c<? super java.util.List<com.uxsense.user.AccountEntry>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.uxsense.user.ApexAccountStorage.C13621
            if (r0 == 0) goto L13
            r0 = r6
            com.uxsense.user.ApexAccountStorage$getAllUsers$1 r0 = (com.uxsense.user.ApexAccountStorage.C13621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.user.ApexAccountStorage$getAllUsers$1 r0 = new com.uxsense.user.ApexAccountStorage$getAllUsers$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L4d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            com.uxsense.core.ApexMetadataFileManager r4 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
            java.nio.file.Path r4 = r4.getAccountFile(r5)
            com.uxsense.file.FileStorageManager r5 = com.uxsense.user.ApexAccountStorage.storage_
            com.uxsense.user.AccountEntry$Companion r1 = com.uxsense.user.AccountEntry.INSTANCE
            x9.b r1 = r1.serializer()
            B9.d r1 = g1.AbstractC1451a.d(r1)
            r0.label = r2
            java.lang.Object r4 = r5.readJson(r4, r1, r0)
            if (r4 != r6) goto L4d
            return r6
        L4d:
            com.uxsense.file.FileResult r4 = (com.uxsense.file.FileResult) r4
            boolean r5 = r4 instanceof com.uxsense.file.FileResult.Success
            if (r5 == 0) goto L5c
            com.uxsense.file.FileResult$Success r4 = (com.uxsense.file.FileResult.Success) r4
            java.lang.Object r4 = r4.getData()
            java.util.List r4 = (java.util.List) r4
            return r4
        L5c:
            boolean r4 = r4 instanceof com.uxsense.file.FileResult.Error
            if (r4 == 0) goto L63
            kotlin.collections.EmptyList r4 = kotlin.collections.EmptyList.f4893a
            return r4
        L63:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountStorage.getAllUsers(java.lang.String, H7.c):java.lang.Object");
    }

    public final List<AccountEntry> getAllUsersSync(String appName) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (List) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13631(appName, null));
    }

    public final AccountEntry getCurrentAccountOrCreateSync(String appName, int androidUserId, Long userId, String uuid, String nickname) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(nickname, "nickname");
        return (AccountEntry) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13641(appName, androidUserId, userId, uuid, nickname, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[Catch: Exception -> 0x00d4, TryCatch #1 {Exception -> 0x00d4, blocks: (B:29:0x0086, B:31:0x008c, B:33:0x00a1, B:35:0x00af, B:38:0x00d7, B:40:0x00dc, B:54:0x011f, B:56:0x012a, B:58:0x012e, B:60:0x013a, B:61:0x013f, B:25:0x0064), top: B:65:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fe A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:13:0x0030, B:44:0x00f8, B:46:0x00fe, B:48:0x0109, B:50:0x010d, B:52:0x0119, B:53:0x011e), top: B:64:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0109 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:13:0x0030, B:44:0x00f8, B:46:0x00fe, B:48:0x0109, B:50:0x010d, B:52:0x0119, B:53:0x011e), top: B:64:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a A[Catch: Exception -> 0x00d4, TryCatch #1 {Exception -> 0x00d4, blocks: (B:29:0x0086, B:31:0x008c, B:33:0x00a1, B:35:0x00af, B:38:0x00d7, B:40:0x00dc, B:54:0x011f, B:56:0x012a, B:58:0x012e, B:60:0x013a, B:61:0x013f, B:25:0x0064), top: B:65:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object markLogin(java.lang.String r28, long r29, H7.c<? super com.uxsense.file.FileResult<java.lang.Integer>> r31) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountStorage.markLogin(java.lang.String, long, H7.c):java.lang.Object");
    }

    public final FileResult<Integer> markLoginSync(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13661(appName, userId, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[Catch: Exception -> 0x00d2, TryCatch #2 {Exception -> 0x00d2, blocks: (B:29:0x0086, B:31:0x008c, B:33:0x00a1, B:35:0x00af, B:38:0x00d5, B:40:0x00da, B:54:0x011d, B:56:0x0128, B:58:0x012c, B:60:0x0138, B:61:0x013d, B:25:0x0064), top: B:67:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:13:0x0030, B:44:0x00f6, B:46:0x00fc, B:48:0x0107, B:50:0x010b, B:52:0x0117, B:53:0x011c), top: B:64:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107 A[Catch: Exception -> 0x0035, TryCatch #0 {Exception -> 0x0035, blocks: (B:13:0x0030, B:44:0x00f6, B:46:0x00fc, B:48:0x0107, B:50:0x010b, B:52:0x0117, B:53:0x011c), top: B:64:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128 A[Catch: Exception -> 0x00d2, TryCatch #2 {Exception -> 0x00d2, blocks: (B:29:0x0086, B:31:0x008c, B:33:0x00a1, B:35:0x00af, B:38:0x00d5, B:40:0x00da, B:54:0x011d, B:56:0x0128, B:58:0x012c, B:60:0x0138, B:61:0x013d, B:25:0x0064), top: B:67:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object markLogout(java.lang.String r28, long r29, H7.c<? super com.uxsense.file.FileResult<java.lang.Integer>> r31) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountStorage.markLogout(java.lang.String, long, H7.c):java.lang.Object");
    }

    public final FileResult<Integer> markLogoutSync(String appName, long userId) {
        kotlin.jvm.internal.k.f(appName, "appName");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13681(appName, userId, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0082 A[Catch: Exception -> 0x004e, TryCatch #0 {Exception -> 0x004e, blocks: (B:20:0x004a, B:29:0x007c, B:31:0x0082, B:33:0x0097, B:35:0x00a5, B:36:0x00b2, B:38:0x00b7, B:52:0x00fc, B:54:0x0107, B:56:0x010b, B:58:0x0117, B:59:0x011c), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[Catch: Exception -> 0x0031, TryCatch #2 {Exception -> 0x0031, blocks: (B:13:0x002c, B:42:0x00d5, B:44:0x00db, B:46:0x00e6, B:48:0x00ea, B:50:0x00f6, B:51:0x00fb), top: B:67:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e6 A[Catch: Exception -> 0x0031, TryCatch #2 {Exception -> 0x0031, blocks: (B:13:0x002c, B:42:0x00d5, B:44:0x00db, B:46:0x00e6, B:48:0x00ea, B:50:0x00f6, B:51:0x00fb), top: B:67:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107 A[Catch: Exception -> 0x004e, TryCatch #0 {Exception -> 0x004e, blocks: (B:20:0x004a, B:29:0x007c, B:31:0x0082, B:33:0x0097, B:35:0x00a5, B:36:0x00b2, B:38:0x00b7, B:52:0x00fc, B:54:0x0107, B:56:0x010b, B:58:0x0117, B:59:0x011c), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateUser(java.lang.String r11, long r12, S7.k r14, H7.c<? super com.uxsense.file.FileResult<java.lang.Integer>> r15) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.user.ApexAccountStorage.updateUser(java.lang.String, long, S7.k, H7.c):java.lang.Object");
    }

    public final FileResult<Integer> updateUserSync(String appName, long userId, k transform) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(transform, "transform");
        return (FileResult) AbstractC1683A.r(EmptyCoroutineContext.f4908a, new C13701(appName, userId, transform, null));
    }
}
