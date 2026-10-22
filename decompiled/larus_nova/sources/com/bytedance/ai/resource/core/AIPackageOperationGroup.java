package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.core.operations.BaseAIPackageHelper;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageOperationGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, AbsAIPackageOperation> f37314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Deferred<AbsAIPackageOperation.a>> f37315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> f37316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, AIPackageManifestBean> f37317d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AIPackageDeployment.AIPackageDeploymentItem f37318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AIPackage.PackageStatus f37319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AIPackageManager.b f37320c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f37321d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f37318a, r101.f37318a) == true) goto L12;
            return false;
        L12:
            if (this.f37319b == r101.f37319b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37320c, r101.f37320c) == true) goto L18;
            return false;
        L18:
            if (this.f37321d == r101.f37321d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f37318a.hashCode() * 31) + this.f37319b.hashCode()) * 31;
            AIPackageManager.b r101 = this.f37320c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f37321d == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Action(deploymentInfo=" + this.f37318a + ", type=" + this.f37319b + ", listener=" + this.f37320c + ", onlyInMemory=" + this.f37321d + ')';
        }

        public final AIPackage.PackageStatus getType() {
            return this.f37319b;
        }

        public a(AIPackageDeployment.AIPackageDeploymentItem r100, AIPackage.PackageStatus r101, AIPackageManager.b r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f37318a = r100;
            this.f37319b = r101;
            this.f37320c = r102;
            this.f37321d = r103;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37322a = null;

        static {
            int[] r100 = new int[AIPackage.PackageStatus.values().length];
            r100[AIPackage.PackageStatus.INSTALLING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AIPackage.PackageStatus.UPDATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AIPackage.PackageStatus.DELETING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f37322a = r100;
        }
    }

    public AIPackageOperationGroup() {
        this.f37314a = new ConcurrentHashMap();
        this.f37315b = new ConcurrentHashMap();
        this.f37316c = new ConcurrentHashMap();
        this.f37317d = new ConcurrentHashMap();
    }

    public static String f(String r100, long r101) {
        return r100 + '_' + r101;
    }

    public final Object i(AIPackageDeployment.AIPackageDeploymentItem r100, Continuation<? super AbsAIPackageOperation.a> r101) {
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.f36600a, new AIPackageOperationGroup$loadAppletBasePackage$2(r100, this, null), r101);
    }

    public final Object j(AIPackageDeployment.AIPackageDeploymentItem r110, Continuation<? super AbsAIPackageOperation.a> r111) {
        if ((r111 instanceof AIPackageOperationGroup$loadManifestBean$1) == false) goto L7;
        AIPackageOperationGroup$loadManifestBean$1 r100 = (AIPackageOperationGroup$loadManifestBean$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (AIPackageDeployment.AIPackageDeploymentItem) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L23:
        AbsAIPackageOperation.a r113 = (AbsAIPackageOperation.a) r112;
        if (Intrinsics.areEqual(r113.f37468c, r110.getAppId()) == true) goto L27;
        String r104 = r110.getAppId();
        AIPackage r105 = r113.f37466a;
        String r106 = r113.f37467b;
        AIPackage.AIPackageType r107 = r113.f37469d;
        int r108 = r113.f37470e;
        String r109 = r113.f37471f;
        Intrinsics.checkNotNullParameter(r106, "packageName");
        Intrinsics.checkNotNullParameter(r104, "appId");
        Intrinsics.checkNotNullParameter(r107, "packageType");
        return new AbsAIPackageOperation.a(r105, r106, r104, r107, r108, r109);
    L27:
        return r113;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        final String r114 = f(r110.getPackageName(), r110.getVersionCode());
        BaseAIPackageHelper r115 = new BaseAIPackageHelper(r110);
        ConcurrentHashMap<String, Deferred<AbsAIPackageOperation.a>> r116 = this.f37315b;
        final Deferred<AbsAIPackageOperation.a> r117 = r116.get(r114);
        if (r117 != null) goto L20;
        r117 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, CoroutineStart.LAZY, new AIPackageOperationGroup$loadManifestBean$job$1$1(r115, this, r110, null), 1, null);
        r117.invokeOnCompletion(new c(this, r114, r117));
        Deferred<AbsAIPackageOperation.a> r118 = r116.putIfAbsent(r114, r117);
        if (r118 == null) goto L20;
        r117 = r118;
    L20:
        r100.L$0 = r110;
        r100.label = 1;
        r112 = r117.await(r100);
        if (r112 != r102) goto L23;
        return r102;
    L7:
        r100 = new AIPackageOperationGroup$loadManifestBean$1(this, r111);
        goto L8
    }

    public final Object k(AbsAIPackageOperation.a r110, Continuation<? super Unit> r111) {
        g r100 = g.f37637a;
        StringBuilder r101 = new StringBuilder("operationEnd ===> packageName: ");
        r101.append(r110.f37467b);
        r101.append(", appId: ");
        r101.append(r110.f37468c);
        r101.append(", code: ");
        r101.append(r110.f37470e);
        r101.append(", msg: ");
        String r102 = r110.f37471f;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.append(r102);
        r100.i("AIPackageManager", r101.toString());
        AbsAIPackageOperation r103 = this.f37314a.remove(r110.f37468c);
        if (r103 == null) goto L15;
        Intrinsics.checkNotNullParameter(r110, "result");
        r103.f37463e = r110;
        r103.f37462d.set(true);
        Iterator<Continuation<AbsAIPackageOperation.a>> r104 = r103.f37465g.iterator();
    L9:
        if (r104.hasNext() == false) goto L11;
        Continuation<AbsAIPackageOperation.a> r105 = r104.next();
        Intrinsics.checkNotNull(r105);
        r105.resumeWith(Result.m9449constructorimpl(r110));
        goto L9
    L11:
        Iterator<AIPackageManager.b> r106 = r103.f37464f.iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        r106.next().a(r110.f37466a, r110.f37467b, r110.f37468c, r110.f37469d, r110.f37470e, r110.f37471f);
        g.f37637a.d("AIPackageManager", "packageName: " + r110.f37467b + ", appId: " + r110.f37468c + " ===> installAIPackage notify listener");
    L15:
        ConcurrentLinkedQueue<a> r112 = this.f37316c.get(r110.f37468c);
        if (r112 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
        Object r113 = Unit.INSTANCE;
    L52:
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L55;
        return r113;
    L55:
        return Unit.INSTANCE;
    L24:
        a r114 = r112.poll();
        if (r114 == null) goto L50;
        int r108 = b.f37322a[r114.getType().ordinal()];
        if (r108 == 1) goto L42;
        if (r108 != 2) goto L31;
        r113 = m(r114.f37318a, r114.f37320c, r111);
        if (r113 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L52;
        r113 = Unit.INSTANCE;
        goto L52
    L31:
        if (r108 != 3) goto L50;
        r113 = l(r114.f37318a, r114.f37320c, r111);
        if (r113 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L52;
        r113 = Unit.INSTANCE;
        goto L52
    L42:
        if (r114.f37321d == false) goto L46;
        r113 = h(this, r114.f37318a, r114.f37320c, r111);
        if (r113 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L52;
    L49:
        r113 = Unit.INSTANCE;
        goto L52
    L46:
        r113 = g(this, r114.f37318a, r114.f37320c, r111);
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
    L50:
        r113 = Unit.INSTANCE;
        goto L52
    L18:
        if (r112.isEmpty() == true) goto L21;
        r107 = false;
        goto L22
    }

    public final Object l(AIPackageDeployment.AIPackageDeploymentItem r100, AIPackageManager.b r101, Continuation<? super Unit> r102) {
        Object r103 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.f36600a, new AIPackageOperationGroup$uninstallAIPackage$2(r100, r101, this, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final Object m(AIPackageDeployment.AIPackageDeploymentItem r100, AIPackageManager.b r101, Continuation<? super Unit> r102) {
        Object r103 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.f36600a, new AIPackageOperationGroup$updateAIPackage$2(r100, r101, this, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object a(AIPackageOperationGroup r110, AIPackageDeployment.AIPackageDeploymentItem r111, AbsAIPackageOperation r112, Continuation r210) {
        AbsAIPackageOperation r100 = r112;
        r110.getClass();
        if ((r210 instanceof AIPackageOperationGroup$downloadAIPackage$1) == false) goto L7;
        AIPackageOperationGroup$downloadAIPackage$1 r101 = (AIPackageOperationGroup$downloadAIPackage$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r107 = r101.I$0;
        AbsAIPackageOperation r108 = (AbsAIPackageOperation) r101.L$1;
        AIPackageDeployment.AIPackageDeploymentItem r109 = (AIPackageDeployment.AIPackageDeploymentItem) r101.L$0;
        ResultKt.throwOnFailure(r103);
        int r113 = r107;
        r100 = r108;
        Object r114 = r103;
        AIPackageDeployment.AIPackageDeploymentItem r115 = r109;
    L19:
        if (((Boolean) r114).booleanValue() == true) goto L21;
        g.f37637a.e("AIPackageManager", "packageName: " + r115.getPackageName() + ", appId: " + r115.getAppId() + " ===> download failed");
        int r116 = 2;
    L23:
        if (r100.f37459a == null) goto L25;
        r106 = true;
    L25:
        if (r106 == false) goto L27;
        AIPackage r117 = r100.e();
    L28:
        r104 = new AbsAIPackageOperation.a(r117, r115.getPackageName(), r115.getAppId(), AIPackage.AIPackageType.UNKNOWN, r116, 32);
    L29:
        return r104;
    L27:
        r117 = null;
        goto L28
    L21:
        g.f37637a.i("AIPackageManager", "packageName: " + r115.getPackageName() + ", appId: " + r115.getAppId() + " ===> download successful");
        r116 = r113;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r115 = r111;
        r101.L$0 = r115;
        r101.L$1 = r100;
        r101.I$0 = 0;
        r101.label = 1;
        Object r118 = r100.c(r101);
        if (r118 == r104) goto L29;
        r114 = r118;
        r113 = 0;
    L7:
        r101 = new AIPackageOperationGroup$downloadAIPackage$1(r110, r210);
        goto L8
    }

    public static final Object b(AIPackageOperationGroup r110, AbsAIPackageOperation r111, AIPackageDeployment.AIPackageDeploymentItem r112, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof AIPackageOperationGroup$operationRun$1) == false) goto L7;
        AIPackageOperationGroup$operationRun$1 r100 = (AIPackageOperationGroup$operationRun$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r102);
    L36:
        return r102;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AbsAIPackageOperation r105 = (AbsAIPackageOperation) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L25:
        Iterator r106 = ((Iterable) r102).iterator();
    L27:
        if (r106.hasNext() == false) goto L32;
        AbsAIPackageOperation.a r107 = (AbsAIPackageOperation.a) r106.next();
        if (r107.f37470e == 0) goto L27;
        return r107;
    L32:
        r100.L$0 = null;
        r100.label = 2;
        r102 = r105.g(r100);
        if (r102 != r103) goto L36;
        return r103;
    L16:
        ResultKt.throwOnFailure(r102);
        r111.h(r112);
        if (r112.getVersionCode() != (-1)) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == true) goto L31;
        ArrayList r109 = new ArrayList();
        com.bytedance.ai.infra.thread_pool.a r113 = com.bytedance.ai.infra.thread_pool.b.f36600a;
        r109.add(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(r113), null, null, new AIPackageOperationGroup$operationRun$2(r110, r112, r111, null), 3, null));
        r109.add(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(r113), null, null, new AIPackageOperationGroup$operationRun$3(r110, r112, r111, null), 3, null));
        r100.L$0 = r111;
        r100.label = 1;
        r102 = AwaitKt.a(r109, r100);
        if (r102 == r103) goto L41;
        r105 = r111;
        goto L25
    L41:
        return r103;
    L31:
        r105 = r111;
        goto L32
    L19:
        r108 = false;
    L7:
        r100 = new AIPackageOperationGroup$operationRun$1(r110, r210);
        goto L8
    }

    public static final Object c(AIPackageOperationGroup r110, AIPackageDeployment.AIPackageDeploymentItem r111, AbsAIPackageOperation r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof AIPackageOperationGroup$setManifestData$1) == false) goto L7;
        AIPackageOperationGroup$setManifestData$1 r100 = (AIPackageOperationGroup$setManifestData$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r112 = (AbsAIPackageOperation) r100.L$1;
        r111 = (AIPackageDeployment.AIPackageDeploymentItem) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L21:
        AbsAIPackageOperation.a r105 = (AbsAIPackageOperation.a) r114;
        int r115 = r105.f37470e;
        Object r106 = r105;
        if (r115 != 0) goto L43;
        AIPackageManifestBean r116 = r110.f37317d.get(f(r111.getPackageName(), r111.getVersionCode()));
    L25:
        r112.getClass();
        if (r116 == null) goto L29;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r112.f37460b = r116;
    L29:
        if (r112.f37460b == null) goto L31;
        boolean r117 = true;
    L32:
        if (r117 == true) goto L34;
        g.f37637a.e("AIPackageManager", "packageName: " + r111.getPackageName() + ", appId: " + r111.getAppId() + " ===> read base_" + r111.getVersionCode() + " error");
        int r107 = 6;
    L36:
        if (r112.f37459a != null) goto L39;
        r104 = false;
    L39:
        if (r104 == false) goto L41;
        AIPackage r118 = r112.e();
    L42:
        r106 = new AbsAIPackageOperation.a(r118, r111.getPackageName(), r111.getAppId(), AIPackage.AIPackageType.UNKNOWN, r107, 32);
        goto L43
    L41:
        r118 = null;
        goto L42
    L34:
        r107 = 0;
        goto L36
    L31:
        r117 = false;
    L43:
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        r116 = r110.f37317d.get(f(r111.getPackageName(), r111.getVersionCode()));
        if (r116 != null) goto L17;
    L18:
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.label = 1;
        r114 = r110.j(r111, r100);
        r106 = r102;
        if (r114 != r102) goto L21;
    L17:
        if (f.a(com.bytedance.ai.resource.core.a.d(r111)) == true) goto L25;
    L7:
        r100 = new AIPackageOperationGroup$setManifestData$1(r110, r113);
        goto L8
    }

    public static Object g(AIPackageOperationGroup r100, AIPackageDeployment.AIPackageDeploymentItem r101, AIPackageManager.b r110, Continuation r111) {
        r100.getClass();
        Object r102 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.f36600a, new AIPackageOperationGroup$installAIPackage$2(r101, "installed", r100, r110, null), r111);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static Object h(AIPackageOperationGroup r100, AIPackageDeployment.AIPackageDeploymentItem r101, AIPackageManager.b r110, Continuation r111) {
        r100.getClass();
        Object r102 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.f36600a, new AIPackageOperationGroup$installAIPackageInMemory$2(r101, "installed", r100, r110, null), r111);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final void d(AIPackageDeployment.AIPackageDeploymentItem r100, AIPackage.PackageStatus r110, AIPackageManager.b r111, boolean r112) {
        boolean r101 = true;
        if (r100.getVersionCode() != 0) goto L5;
        boolean r102 = true;
    L6:
        AIPackage.PackageStatus r103 = null;
        if (r102 == false) goto L19;
        AbsAIPackageOperation r104 = this.f37314a.get(r100.getAppId());
        if (r104 == null) goto L11;
        AIPackage.PackageStatus r105 = r104.j();
    L12:
        AIPackage.PackageStatus r106 = AIPackage.PackageStatus.INSTALLING;
        if (r105 != r106) goto L19;
        if (r110 != r106) goto L19;
        if (r111 == null) goto L40;
        AbsAIPackageOperation r107 = this.f37314a.get(r100.getAppId());
        if (r107 == null) goto L41;
        r107.f(r111);
        return;
    L41:
        return;
    L40:
        return;
    L11:
        r105 = null;
    L19:
        AbsAIPackageOperation r108 = this.f37314a.get(r100.getAppId());
        if (r108 == null) goto L26;
        AIPackageDeployment.AIPackageDeploymentItem r109 = r108.d();
        if (r109 == null) goto L26;
        if (r100.getVersionCode() != r109.getVersionCode()) goto L26;
    L27:
        if (r101 == false) goto L36;
        AbsAIPackageOperation r113 = this.f37314a.get(r100.getAppId());
        if (r113 == null) goto L31;
        r103 = r113.j();
    L31:
        if (r110 != r103) goto L36;
        if (r111 == null) goto L43;
        AbsAIPackageOperation r114 = this.f37314a.get(r100.getAppId());
        if (r114 == null) goto L44;
        r114.f(r111);
        return;
    L44:
        return;
    L43:
        return;
    L36:
        this.f37316c.putIfAbsent(r100.getAppId(), new ConcurrentLinkedQueue());
        ConcurrentLinkedQueue<a> r115 = this.f37316c.get(r100.getAppId());
        if (r115 == null) goto L46;
        r115.offer(new a(r100, r110, r111, r112));
        return;
    L46:
        return;
    L26:
        r101 = false;
        goto L27
    L5:
        r102 = false;
        goto L6
    }

    public final Object e(AIPackage r110, AIPackageDeployment.AIPackageDeploymentItem r111, boolean r112, Continuation<? super Boolean> r113) {
        if ((r113 instanceof AIPackageOperationGroup$checkOldPackageVersion$1) == false) goto L7;
        AIPackageOperationGroup$checkOldPackageVersion$1 r100 = (AIPackageOperationGroup$checkOldPackageVersion$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AIPackageOperationGroup$checkOldPackageVersion$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L31:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (r111.getVersionCode() != 0) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == false) goto L20;
    L27:
        g.f37637a.i("AIPackageManager", "packageName: " + r111.getPackageName() + ", appId: " + r111.getAppId() + " ===> AIPackage installs the same version");
        AbsAIPackageOperation.a r114 = new AbsAIPackageOperation.a(r110, r110.f36895b, r110.a(), r110.c(), 0, 32);
        r102.label = 1;
        if (k(r114, r102) != r104) goto L31;
        return r104;
    L20:
        if (r110.f36896c == r111.getVersionCode()) goto L27;
        if (r112 == false) goto L26;
        if (r110.f36896c > r111.getVersionCode()) goto L27;
    L26:
        return Boxing.boxBoolean(true);
    L17:
        r106 = false;
    L7:
        r100 = new AIPackageOperationGroup$checkOldPackageVersion$1(this, r113);
        goto L8
    }
}
