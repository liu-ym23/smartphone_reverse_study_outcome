package com.uxsense.core;

import C7.r;
import S7.k;
import S7.n;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.uxsense.base.metadata.User;
import com.uxsense.file.FileResult;
import j9.t;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a>\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010\u001a>\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\rH\u0086@¢\u0006\u0004\b\u0012\u0010\u0010\u001a2\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016\u001a2\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0018\u0010\u0019\u001a2\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001c\u0010\u001d\u001a2\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@¢\u0006\u0004\b \u0010!\u001a(\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", "appName", "Lcom/uxsense/base/metadata/User;", BffConstant.Role.User, "Lcom/uxsense/file/FileResult;", "LC7/r;", "saveUser", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Lcom/uxsense/base/metadata/User;LH7/c;)Ljava/lang/Object;", "", "userId", "loadUser", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "transform", "updateUser", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLS7/k;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/base/metadata/UserStats;", "updateUserStats", "Lcom/uxsense/base/metadata/FollowingUser;", "newFollowing", "addFollowingUser", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLcom/uxsense/base/metadata/FollowingUser;LH7/c;)Ljava/lang/Object;", "targetUserId", "removeFollowingUser", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJLH7/c;)Ljava/lang/Object;", "Lcom/uxsense/base/metadata/FollowerUser;", "newFollower", "addFollowerUser", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLcom/uxsense/base/metadata/FollowerUser;LH7/c;)Ljava/lang/Object;", "", "hours", "getFollowersGainedInLastHours", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JILH7/c;)Ljava/lang/Object;", "", "getAllUsers", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UserExtensionsKt {

    @J7.c(c = "com.uxsense.core.UserExtensionsKt", f = "UserExtensions.kt", l = {147, 151}, m = "addFollowerUser")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.UserExtensionsKt$addFollowerUser$1, reason: invalid class name */
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
            return UserExtensionsKt.addFollowerUser(null, null, 0L, null, this);
        }
    }

    @J7.c(c = "com.uxsense.core.UserExtensionsKt", f = "UserExtensions.kt", l = {147, 152}, m = "addFollowingUser")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.UserExtensionsKt$addFollowingUser$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C12591(H7.c<? super C12591> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserExtensionsKt.addFollowingUser(null, null, 0L, null, this);
        }
    }

    @J7.c(c = "com.uxsense.core.UserExtensionsKt$getAllUsers$2", f = "UserExtensions.kt", l = {128}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "Lcom/uxsense/base/metadata/User;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.UserExtensionsKt$getAllUsers$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ ApexMetadataFileManager $this_getAllUsers;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_getAllUsers = apexMetadataFileManager;
            this.$appName = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(Path path) {
            return Files.isRegularFile(path, new LinkOption[0]) && t.W(path.toString(), ".json", false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$1(k kVar, Object obj) {
            return ((Boolean) kVar.invoke(obj)).booleanValue();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_getAllUsers, this.$appName, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00a4 A[Catch: Exception -> 0x0012, TryCatch #1 {Exception -> 0x0012, blocks: (B:6:0x000d, B:27:0x0093, B:28:0x009e, B:30:0x00a4, B:32:0x00ae, B:33:0x00b8, B:35:0x00bc, B:36:0x00e8, B:37:0x00ed, B:38:0x00ee), top: B:43:0x000d }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 255
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.UserExtensionsKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<? extends List<User>>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.UserExtensionsKt", f = "UserExtensions.kt", l = {145}, m = "getFollowersGainedInLastHours")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.UserExtensionsKt$getFollowersGainedInLastHours$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12601 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public C12601(H7.c<? super C12601> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserExtensionsKt.getFollowersGainedInLastHours(null, null, 0L, 0, this);
        }
    }

    @J7.c(c = "com.uxsense.core.UserExtensionsKt", f = "UserExtensions.kt", l = {147, 154}, m = "removeFollowingUser")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.UserExtensionsKt$removeFollowingUser$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12611 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C12611(H7.c<? super C12611> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserExtensionsKt.removeFollowingUser(null, null, 0L, 0L, this);
        }
    }

    @J7.c(c = "com.uxsense.core.UserExtensionsKt", f = "UserExtensions.kt", l = {147, 151}, m = "updateUser")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.UserExtensionsKt$updateUser$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C12621(H7.c<? super C12621> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserExtensionsKt.updateUser(null, null, 0L, null, this);
        }
    }

    @J7.c(c = "com.uxsense.core.UserExtensionsKt", f = "UserExtensions.kt", l = {147, 151}, m = "updateUserStats")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.core.UserExtensionsKt$updateUserStats$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12631 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C12631(H7.c<? super C12631> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserExtensionsKt.updateUserStats(null, null, 0L, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object addFollowerUser(com.uxsense.core.ApexMetadataFileManager r26, java.lang.String r27, long r28, com.uxsense.base.metadata.FollowerUser r30, H7.c<? super com.uxsense.file.FileResult<C7.r>> r31) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.UserExtensionsKt.addFollowerUser(com.uxsense.core.ApexMetadataFileManager, java.lang.String, long, com.uxsense.base.metadata.FollowerUser, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object addFollowingUser(com.uxsense.core.ApexMetadataFileManager r20, java.lang.String r21, long r22, com.uxsense.base.metadata.FollowingUser r24, H7.c<? super com.uxsense.file.FileResult<C7.r>> r25) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.UserExtensionsKt.addFollowingUser(com.uxsense.core.ApexMetadataFileManager, java.lang.String, long, com.uxsense.base.metadata.FollowingUser, H7.c):java.lang.Object");
    }

    public static final Object getAllUsers(ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super FileResult<? extends List<User>>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(apexMetadataFileManager, str, null), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object getFollowersGainedInLastHours(com.uxsense.core.ApexMetadataFileManager r4, java.lang.String r5, long r6, int r8, H7.c<? super com.uxsense.file.FileResult<java.lang.Long>> r9) {
        /*
            boolean r0 = r9 instanceof com.uxsense.core.UserExtensionsKt.C12601
            if (r0 == 0) goto L13
            r0 = r9
            com.uxsense.core.UserExtensionsKt$getFollowersGainedInLastHours$1 r0 = (com.uxsense.core.UserExtensionsKt.C12601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.core.UserExtensionsKt$getFollowersGainedInLastHours$1 r0 = new com.uxsense.core.UserExtensionsKt$getFollowersGainedInLastHours$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            int r8 = r0.I$0
            kotlin.b.b(r9)
            goto L4f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.b.b(r9)
            com.uxsense.file.FileStorageManager r9 = r4.getStorage_$uxsense_release()
            java.nio.file.Path r4 = r4.getUserFilePath(r5, r6)
            com.uxsense.base.metadata.User$Companion r5 = com.uxsense.base.metadata.User.INSTANCE
            x9.b r5 = r5.serializer()
            x9.a r5 = (x9.InterfaceC2123a) r5
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = r9.readJson(r4, r5, r0)
            if (r9 != r1) goto L4f
            return r1
        L4f:
            com.uxsense.file.FileResult r9 = (com.uxsense.file.FileResult) r9
            boolean r4 = r9 instanceof com.uxsense.file.FileResult.Success
            if (r4 == 0) goto L70
            com.uxsense.file.FileResult$Success r4 = new com.uxsense.file.FileResult$Success
            com.uxsense.file.FileResult$Success r9 = (com.uxsense.file.FileResult.Success) r9
            java.lang.Object r5 = r9.getData()
            com.uxsense.base.metadata.User r5 = (com.uxsense.base.metadata.User) r5
            com.uxsense.base.metadata.UserStats r5 = r5.getUserStats()
            long r5 = r5.followersGainedInLastHours(r8)
            java.lang.Long r7 = new java.lang.Long
            r7.<init>(r5)
            r4.<init>(r7)
            return r4
        L70:
            boolean r4 = r9 instanceof com.uxsense.file.FileResult.Error
            if (r4 == 0) goto L80
            com.uxsense.file.FileResult$Error r4 = new com.uxsense.file.FileResult$Error
            com.uxsense.file.FileResult$Error r9 = (com.uxsense.file.FileResult.Error) r9
            com.uxsense.file.FileException r5 = r9.getException()
            r4.<init>(r5)
            return r4
        L80:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.UserExtensionsKt.getFollowersGainedInLastHours(com.uxsense.core.ApexMetadataFileManager, java.lang.String, long, int, H7.c):java.lang.Object");
    }

    public static final Object loadUser(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, H7.c<? super FileResult<User>> cVar) {
        return apexMetadataFileManager.getStorage_$uxsense_release().readJson(apexMetadataFileManager.getUserFilePath(str, j5), User.INSTANCE.serializer(), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object removeFollowingUser(com.uxsense.core.ApexMetadataFileManager r21, java.lang.String r22, long r23, long r25, H7.c<? super com.uxsense.file.FileResult<C7.r>> r27) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.UserExtensionsKt.removeFollowingUser(com.uxsense.core.ApexMetadataFileManager, java.lang.String, long, long, H7.c):java.lang.Object");
    }

    public static final Object saveUser(ApexMetadataFileManager apexMetadataFileManager, String str, User user, H7.c<? super FileResult<r>> cVar) {
        return apexMetadataFileManager.getStorage_$uxsense_release().writeJson(apexMetadataFileManager.getUserFilePath(str, user.getUserId()), user, User.INSTANCE.serializer(), cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0094, code lost:
    
        if (r11 == r1) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object updateUser(com.uxsense.core.ApexMetadataFileManager r6, java.lang.String r7, long r8, S7.k r10, H7.c<? super com.uxsense.file.FileResult<C7.r>> r11) {
        /*
            boolean r0 = r11 instanceof com.uxsense.core.UserExtensionsKt.C12621
            if (r0 == 0) goto L13
            r0 = r11
            com.uxsense.core.UserExtensionsKt$updateUser$1 r0 = (com.uxsense.core.UserExtensionsKt.C12621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.uxsense.core.UserExtensionsKt$updateUser$1 r0 = new com.uxsense.core.UserExtensionsKt$updateUser$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$0
            java.nio.file.Path r6 = (java.nio.file.Path) r6
            kotlin.b.b(r11)     // Catch: java.lang.Exception -> L2e
            goto L97
        L2e:
            r7 = move-exception
            goto La5
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            java.lang.Object r6 = r0.L$2
            java.nio.file.Path r6 = (java.nio.file.Path) r6
            java.lang.Object r7 = r0.L$1
            com.uxsense.file.FileStorageManager r7 = (com.uxsense.file.FileStorageManager) r7
            java.lang.Object r8 = r0.L$0
            r10 = r8
            S7.k r10 = (S7.k) r10
            kotlin.b.b(r11)     // Catch: java.lang.Exception -> L2e
            goto L6f
        L4a:
            kotlin.b.b(r11)
            com.uxsense.file.FileStorageManager r11 = r6.getStorage_$uxsense_release()
            java.nio.file.Path r6 = r6.getUserFilePath(r7, r8)
            com.uxsense.base.metadata.User$Companion r7 = com.uxsense.base.metadata.User.INSTANCE     // Catch: java.lang.Exception -> L2e
            x9.b r7 = r7.serializer()     // Catch: java.lang.Exception -> L2e
            x9.a r7 = (x9.InterfaceC2123a) r7     // Catch: java.lang.Exception -> L2e
            r0.L$0 = r10     // Catch: java.lang.Exception -> L2e
            r0.L$1 = r11     // Catch: java.lang.Exception -> L2e
            r0.L$2 = r6     // Catch: java.lang.Exception -> L2e
            r0.label = r4     // Catch: java.lang.Exception -> L2e
            java.lang.Object r7 = r11.readJson(r6, r7, r0)     // Catch: java.lang.Exception -> L2e
            if (r7 != r1) goto L6c
            goto L96
        L6c:
            r5 = r11
            r11 = r7
            r7 = r5
        L6f:
            com.uxsense.file.FileResult r11 = (com.uxsense.file.FileResult) r11     // Catch: java.lang.Exception -> L2e
            boolean r8 = r11 instanceof com.uxsense.file.FileResult.Success     // Catch: java.lang.Exception -> L2e
            if (r8 == 0) goto L9a
            com.uxsense.file.FileResult$Success r11 = (com.uxsense.file.FileResult.Success) r11     // Catch: java.lang.Exception -> L2e
            java.lang.Object r8 = r11.getData()     // Catch: java.lang.Exception -> L2e
            java.lang.Object r8 = r10.invoke(r8)     // Catch: java.lang.Exception -> L2e
            com.uxsense.base.metadata.User$Companion r9 = com.uxsense.base.metadata.User.INSTANCE     // Catch: java.lang.Exception -> L2e
            x9.b r9 = r9.serializer()     // Catch: java.lang.Exception -> L2e
            x9.f r9 = (x9.f) r9     // Catch: java.lang.Exception -> L2e
            r0.L$0 = r6     // Catch: java.lang.Exception -> L2e
            r10 = 0
            r0.L$1 = r10     // Catch: java.lang.Exception -> L2e
            r0.L$2 = r10     // Catch: java.lang.Exception -> L2e
            r0.label = r3     // Catch: java.lang.Exception -> L2e
            java.lang.Object r11 = r7.writeJson(r6, r8, r9, r0)     // Catch: java.lang.Exception -> L2e
            if (r11 != r1) goto L97
        L96:
            return r1
        L97:
            com.uxsense.file.FileResult r11 = (com.uxsense.file.FileResult) r11     // Catch: java.lang.Exception -> L2e
            return r11
        L9a:
            boolean r7 = r11 instanceof com.uxsense.file.FileResult.Error     // Catch: java.lang.Exception -> L2e
            if (r7 == 0) goto L9f
            return r11
        L9f:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Exception -> L2e
            r7.<init>()     // Catch: java.lang.Exception -> L2e
            throw r7     // Catch: java.lang.Exception -> L2e
        La5:
            com.uxsense.file.FileResult$Error r8 = new com.uxsense.file.FileResult$Error
            com.uxsense.file.FileException$WriteError r9 = new com.uxsense.file.FileException$WriteError
            r9.<init>(r6, r7)
            r8.<init>(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.UserExtensionsKt.updateUser(com.uxsense.core.ApexMetadataFileManager, java.lang.String, long, S7.k, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object updateUserStats(com.uxsense.core.ApexMetadataFileManager r20, java.lang.String r21, long r22, S7.k r24, H7.c<? super com.uxsense.file.FileResult<C7.r>> r25) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.UserExtensionsKt.updateUserStats(com.uxsense.core.ApexMetadataFileManager, java.lang.String, long, S7.k, H7.c):java.lang.Object");
    }
}
