package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.db.AIPackageDao;
import com.bytedance.ai.resource.core.db.AIPackageDatabase;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AIPackageStorage f37323a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37324a = null;

        static {
            int[] r100 = new int[AIPackage.AIPackageType.values().length];
            r100[AIPackage.AIPackageType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AIPackage.AIPackageType.APPLET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f37324a = r100;
        }
    }

    static {
        f37323a = new AIPackageStorage();
    }

    public AIPackageStorage() {
    }

    public final Object i(Continuation<? super List<? extends AIPackage>> r100) {
        if ((r100 instanceof AIPackageStorage$queryInactiveAIPackages$1) == false) goto L7;
        AIPackageStorage$queryInactiveAIPackages$1 r101 = (AIPackageStorage$queryInactiveAIPackages$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L24;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        List r106 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L15
    L36:
        List r107 = (List) r103;     // Catch: Exception -> L15
        if (r107 == null) goto L43;
        r106.addAll(r107);     // Catch: Exception -> L15
    L43:
        return r106;
    L15:
        Exception e100 = e;
    L42:
        g.f37637a.e("AIPackageStorage", "query all inactive AIPackage info database error : " + ExceptionsKt.stackTraceToString(e100));
        goto L43
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        List r108 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L22
    L29:
        List r109 = (List) r103;     // Catch: Exception -> L22
        if (r109 == null) goto L32;
        r108.addAll(r109);     // Catch: Exception -> L22
    L32:
        AIPackageDao r110 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L22
        r101.L$0 = r108;     // Catch: Exception -> L22
        r101.label = 2;     // Catch: Exception -> L22
        r103 = r110.w(r101);     // Catch: Exception -> L22
        if (r103 != r104) goto L35;
        return r104;
    L35:
        r106 = r108;
    L22:
        e100 = e;
        r106 = r108;
        goto L42
    L24:
        ResultKt.throwOnFailure(r103);
        ArrayList r111 = new ArrayList();
        AIPackageDao r112 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L40
        r101.L$0 = r111;     // Catch: Exception -> L40
        r101.label = 1;     // Catch: Exception -> L40
        Object r113 = r112.y(r101);     // Catch: Exception -> L40
        if (r113 != r104) goto L28;
        return r104;
    L28:
        r108 = r111;
        r103 = r113;
    L40:
        e = move-exception;
        r106 = r111;
        e100 = e;
    L7:
        r101 = new AIPackageStorage$queryInactiveAIPackages$1(this, r100);
        goto L8
    }

    public final Object p(Continuation<? super List<? extends AIPackage>> r100) {
        if ((r100 instanceof AIPackageStorage$queryPackagesToDelete$1) == false) goto L7;
        AIPackageStorage$queryPackagesToDelete$1 r101 = (AIPackageStorage$queryPackagesToDelete$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L24;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        List r106 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L15
    L36:
        List r107 = (List) r103;     // Catch: Exception -> L15
        if (r107 == null) goto L43;
        r106.addAll(r107);     // Catch: Exception -> L15
    L43:
        return r106;
    L15:
        Exception e100 = e;
    L42:
        g.f37637a.e("AIPackageStorage", "query all AIPackage to delete database error : " + ExceptionsKt.stackTraceToString(e100));
        goto L43
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        List r108 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L22
    L29:
        List r109 = (List) r103;     // Catch: Exception -> L22
        if (r109 == null) goto L32;
        r108.addAll(r109);     // Catch: Exception -> L22
    L32:
        AIPackageDao r110 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L22
        r101.L$0 = r108;     // Catch: Exception -> L22
        r101.label = 2;     // Catch: Exception -> L22
        r103 = r110.L(r101);     // Catch: Exception -> L22
        if (r103 != r104) goto L35;
        return r104;
    L35:
        r106 = r108;
    L22:
        e100 = e;
        r106 = r108;
        goto L42
    L24:
        ResultKt.throwOnFailure(r103);
        ArrayList r111 = new ArrayList();
        AIPackageDao r112 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L40
        r101.L$0 = r111;     // Catch: Exception -> L40
        r101.label = 1;     // Catch: Exception -> L40
        Object r113 = r112.u(r101);     // Catch: Exception -> L40
        if (r113 != r104) goto L28;
        return r104;
    L28:
        r108 = r111;
        r103 = r113;
    L40:
        e = move-exception;
        r106 = r111;
        e100 = e;
    L7:
        r101 = new AIPackageStorage$queryPackagesToDelete$1(this, r100);
        goto L8
    }

    public final Object a(AIPackage r110, Continuation<? super List<String>> r111) {
        if ((r111 instanceof AIPackageStorage$cleanPackageToDelete$1) == false) goto L7;
        AIPackageStorage$cleanPackageToDelete$1 r100 = (AIPackageStorage$cleanPackageToDelete$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L18;
        if (r103 != 3) goto L17;
        AIPackage r113 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L35
    L34:
        return r112;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r110 = (AIPackage) r100.L$0;
    L19:
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L35
    L31:
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> end delete database");     // Catch: Exception -> L35
        r100.L$0 = r110;     // Catch: Exception -> L35
        r100.label = 3;     // Catch: Exception -> L35
        r112 = c(r110, r100);     // Catch: Exception -> L35
        if (r112 != r102) goto L34;
        return r102;
    L21:
        r110 = (AIPackage) r100.L$0;
        goto L19
    L22:
        ResultKt.throwOnFailure(r112);
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> start delete database");     // Catch: Exception -> L35
        if (r110.c() != AIPackage.AIPackageType.WIDGET) goto L28;
        AIPackageDao r114 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L35
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L35
        r100.L$0 = r110;     // Catch: Exception -> L35
        r100.label = 1;     // Catch: Exception -> L35
        if (r114.e((Widget) r110, r100) != r102) goto L31;
        return r102;
    L28:
        AIPackageDao r115 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L35
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L35
        r100.L$0 = r110;     // Catch: Exception -> L35
        r100.label = 2;     // Catch: Exception -> L35
        if (r115.b((Applet) r110, r100) != r102) goto L31;
        return r102;
    L35:
        e = move-exception;
        g.f37637a.e("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> cleanPackageToDelete error : " + ExceptionsKt.stackTraceToString(e));
        return CollectionsKt.emptyList();
    L7:
        r100 = new AIPackageStorage$cleanPackageToDelete$1(this, r111);
        goto L8
    }

    public final Object c(AIPackage r100, Continuation<? super List<String>> r110) {
        if ((r110 instanceof AIPackageStorage$getFileListToRemoved$1) == false) goto L7;
        AIPackageStorage$getFileListToRemoved$1 r101 = (AIPackageStorage$getFileListToRemoved$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$getFileListToRemoved$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (AIPackage) r103.L$0;
        ResultKt.throwOnFailure(r111);
    L17:
        List r112 = (List) r111;
        g.f37637a.d("AIPackageStorage", "packageName: " + r100.f36895b + ", appId: " + r100.a() + " ===> rename outdated file");
        return r112;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        AIPackageDao r106 = AIPackageDatabase.f37336a.b().c();
        long r107 = r100.f36896c;
        String r113 = r100.a();
        String r108 = r100.f36895b;
        String r109 = r100.f36907n;
        r103.L$0 = r100;
        r103.label = 1;
        r111 = r106.M(r107, r113, r108, r109, r103);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r101 = new AIPackageStorage$getFileListToRemoved$1(this, r110);
        goto L8
    }

    public final Object d(AIPackage r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof AIPackageStorage$insertAIPackage$1) == false) goto L7;
        AIPackageStorage$insertAIPackage$1 r100 = (AIPackageStorage$insertAIPackage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L15;
        if (r103 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L29
    L27:
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> end insert installed database");     // Catch: Exception -> L29
    L32:
        return Boxing.boxBoolean(r104);
    L18:
        ResultKt.throwOnFailure(r112);
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> start insert installed database");     // Catch: Exception -> L29
        if (r110.c() != AIPackage.AIPackageType.WIDGET) goto L24;
        AIPackageDao r113 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L29
        r100.L$0 = r110;     // Catch: Exception -> L29
        r100.label = 1;     // Catch: Exception -> L29
        if (r113.l((Widget) r110, r100) != r102) goto L27;
        return r102;
    L24:
        AIPackageDao r114 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L29
        r100.L$0 = r110;     // Catch: Exception -> L29
        r100.label = 2;     // Catch: Exception -> L29
        if (r114.h((Applet) r110, r100) != r102) goto L27;
        return r102;
    L29:
        e = move-exception;
        g.f37637a.e("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> insert database error : " + ExceptionsKt.stackTraceToString(e));
        r104 = false;
    L7:
        r100 = new AIPackageStorage$insertAIPackage$1(this, r111);
        goto L8
    }

    public final Object e(AIPackage r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof AIPackageStorage$insertInactiveAIPackage$1) == false) goto L7;
        AIPackageStorage$insertInactiveAIPackage$1 r100 = (AIPackageStorage$insertInactiveAIPackage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        r110 = (AIPackage) r100.L$0;
    L13:
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L29
    L27:
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> end insert inactive database");     // Catch: Exception -> L29
    L32:
        return Boxing.boxBoolean(r104);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r110 = (AIPackage) r100.L$0;
        goto L13
    L18:
        ResultKt.throwOnFailure(r112);
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> start insert inactive database");     // Catch: Exception -> L29
        if (r110.c() != AIPackage.AIPackageType.WIDGET) goto L24;
        AIPackageDao r113 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L29
        r100.L$0 = r110;     // Catch: Exception -> L29
        r100.label = 1;     // Catch: Exception -> L29
        if (r113.k((Widget) r110, r100) != r102) goto L27;
        return r102;
    L24:
        AIPackageDao r114 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L29
        r100.L$0 = r110;     // Catch: Exception -> L29
        r100.label = 2;     // Catch: Exception -> L29
        if (r114.i((Applet) r110, r100) != r102) goto L27;
        return r102;
    L29:
        e = move-exception;
        g.f37637a.e("AIPackageStorage", "packageName: " + r110.f36895b + ", appId: " + r110.a() + " ===> insert database error : " + ExceptionsKt.stackTraceToString(e));
        r104 = false;
    L7:
        r100 = new AIPackageStorage$insertInactiveAIPackage$1(this, r111);
        goto L8
    }

    public final Object l(AIPackageDeployment.AIPackageDeploymentItem r110, Continuation r111) {
        if ((r111 instanceof AIPackageStorage$queryInstallOrInactiveAIPackageById$1) == false) goto L7;
        AIPackageStorage$queryInstallOrInactiveAIPackageById$1 r100 = (AIPackageStorage$queryInstallOrInactiveAIPackageById$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$queryInstallOrInactiveAIPackageById$1 r102 = r100;
        Object r112 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L25:
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackageManager.a r113 = (AIPackageManager.a) r102.L$0;
        ResultKt.throwOnFailure(r112);
        AIPackageManager.a r114 = r113;
    L19:
        AIPackageManager.a r105 = r114;
        AIPackage r115 = (AIPackage) r112;
        if (r115 == null) goto L22;
        return r115;
    L22:
        r102.L$0 = null;
        r102.label = 2;
        r112 = k(r105, AIPackage.AIPackageType.UNKNOWN, false, 0, r102);
        if (r112 != r103) goto L25;
        return r103;
    L16:
        ResultKt.throwOnFailure(r112);
        AIPackage.AIPackageType r106 = AIPackage.AIPackageType.UNKNOWN;
        r102.L$0 = r110;
        r102.label = 1;
        r112 = h(r110, r106, 0, r102);
        r114 = r110;
        if (r112 != r103) goto L19;
        return r103;
    L7:
        r100 = new AIPackageStorage$queryInstallOrInactiveAIPackageById$1(this, r111);
        goto L8
    }

    public final Object n(String r100, Continuation<? super List<? extends AIPackage>> r101) {
        if ((r101 instanceof AIPackageStorage$queryInstalledAIPackagesByPackageName$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByPackageName$1 r102 = (AIPackageStorage$queryInstalledAIPackagesByPackageName$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L24;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        List r107 = (List) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L15
    L36:
        List r109 = (List) r104;     // Catch: Exception -> L15
        if (r109 == null) goto L49;
        r107.addAll(r109);     // Catch: Exception -> L15
        return r107;
    L49:
        return r107;
    L15:
        e = move-exception;
        List r110 = r107;
        r100 = r108;
        e = e;
    L41:
        g.f37637a.e("AIPackageStorage", "query " + r100 + " info database error : " + ExceptionsKt.stackTraceToString(e));
        return r110;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r107 = (List) r102.L$1;
        String r111 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L22
    L29:
        List r112 = (List) r104;     // Catch: Exception -> L22
        if (r112 == null) goto L32;
        r107.addAll(r112);     // Catch: Exception -> L22
    L32:
        AIPackageDao r113 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L22
        r102.L$0 = r111;     // Catch: Exception -> L22
        r102.L$1 = r107;     // Catch: Exception -> L22
        r102.label = 2;     // Catch: Exception -> L22
        r104 = r113.B(r111, r102);     // Catch: Exception -> L22
        if (r104 != r105) goto L35;
        return r105;
    L35:
        r108 = r111;
    L22:
        e = move-exception;
        e = e;
        r110 = r107;
        r100 = r111;
        goto L41
    L24:
        ResultKt.throwOnFailure(r104);
        r110 = new ArrayList();
        AIPackageDao r114 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L40
        r102.L$0 = r100;     // Catch: Exception -> L40
        r102.L$1 = r110;     // Catch: Exception -> L40
        r102.label = 1;     // Catch: Exception -> L40
        Object r115 = r114.E(r100, r102);     // Catch: Exception -> L40
        if (r115 != r105) goto L28;
        return r105;
    L28:
        r111 = r100;
        r107 = r110;
        r104 = r115;
    L40:
        e = e;
    L7:
        r102 = new AIPackageStorage$queryInstalledAIPackagesByPackageName$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.ai.model.objects.AIPackage$AIPackageType, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [com.bytedance.ai.model.objects.AIPackage$AIPackageType] */
    /* JADX WARN: Type inference failed for: r2v19 */
    public final Object o(AIPackage.AIPackageType r110, Continuation<? super List<? extends AIPackage>> r111) {
        if ((r111 instanceof AIPackageStorage$queryInstalledAIPackagesByType$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByType$1 r100 = (AIPackageStorage$queryInstalledAIPackagesByType$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L32;
        if (r103 == 1) goto L27;
        if (r103 == 2) goto L24;
        if (r103 == 3) goto L19;
        if (r103 != 4) goto L18;
        List r113 = (List) r100.L$1;
        AIPackage.AIPackageType r104 = (AIPackage.AIPackageType) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L30
        ?? r114 = r113;
    L47:
        List r115 = (List) r112;     // Catch: Exception -> L30
        if (r115 == null) goto L74;
        r114.addAll(r115);     // Catch: Exception -> L30
        return r114;
    L74:
        return r114;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ?? r116 = (List) r100.L$1;
        ?? r105 = (AIPackage.AIPackageType) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L22
        r105 = r105;
        r116 = r116;
    L40:
        List r117 = (List) r112;     // Catch: Exception -> L22
        if (r117 == null) goto L43;
        r116.addAll(r117);     // Catch: Exception -> L22
    L43:
        AIPackageDao r118 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L22
        r100.L$0 = r105;     // Catch: Exception -> L22
        r100.L$1 = r116;     // Catch: Exception -> L22
        r100.label = 4;     // Catch: Exception -> L22
        r112 = r118.D(r100);     // Catch: Exception -> L22
        if (r112 != r102) goto L46;
        return r102;
    L46:
        r114 = r116;
    L22:
        e = move-exception;
        Exception e100 = e;
        ?? r119 = r116;
        r110 = r105;
    L68:
        g.f37637a.e("AIPackageStorage", "query all " + r110 + " AIPackage info database error : " + ExceptionsKt.stackTraceToString(e100));
        return r119;
    L24:
        List r120 = (List) r100.L$1;
        AIPackage.AIPackageType r106 = (AIPackage.AIPackageType) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L30
        ?? r121 = r120;
    L63:
        List r122 = (List) r112;     // Catch: Exception -> L30
        if (r122 == null) goto L76;
        r121.addAll(r122);     // Catch: Exception -> L30
        return r121;
    L76:
        return r121;
    L27:
        List r123 = (List) r100.L$1;
        AIPackage.AIPackageType r107 = (AIPackage.AIPackageType) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L30
        ?? r124 = r123;
    L55:
        List r125 = (List) r112;     // Catch: Exception -> L30
        if (r125 == null) goto L75;
        r124.addAll(r125);     // Catch: Exception -> L30
        return r124;
    L75:
        return r124;
    L32:
        ResultKt.throwOnFailure(r112);
        r119 = new ArrayList();
        int r108 = a.f37324a[r110.ordinal()];     // Catch: Exception -> L67
        if (r108 == 1) goto L59;
        if (r108 == 2) goto L51;
        AIPackageDao r109 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L67
        r100.L$0 = r110;     // Catch: Exception -> L67
        r100.L$1 = r119;     // Catch: Exception -> L67
        r100.label = 3;     // Catch: Exception -> L67
        Object r126 = r109.A(r100);     // Catch: Exception -> L67
        if (r126 != r102) goto L39;
        return r102;
    L39:
        r105 = r110;
        r116 = r119;
        r112 = r126;
        goto L40
    L51:
        AIPackageDao r127 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L67
        r100.L$0 = r110;     // Catch: Exception -> L67
        r100.L$1 = r119;     // Catch: Exception -> L67
        r100.label = 1;     // Catch: Exception -> L67
        Object r128 = r127.A(r100);     // Catch: Exception -> L67
        if (r128 != r102) goto L54;
        return r102;
    L54:
        r124 = r119;
        r112 = r128;
        goto L55
    L59:
        AIPackageDao r129 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L67
        r100.L$0 = r110;     // Catch: Exception -> L67
        r100.L$1 = r119;     // Catch: Exception -> L67
        r100.label = 2;     // Catch: Exception -> L67
        Object r130 = r129.D(r100);     // Catch: Exception -> L67
        if (r130 != r102) goto L62;
        return r102;
    L62:
        r121 = r119;
        r112 = r130;
    L67:
        e100 = e;
    L30:
        e = move-exception;
        r119 = r110;
        r110 = r100;
        e100 = e;
    L7:
        r100 = new AIPackageStorage$queryInstalledAIPackagesByType$1(this, r111);
        goto L8
    }

    public final Object b(AIPackageManager.a r110, AIPackage.AIPackageType r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof AIPackageStorage$deleteAIPackageById$1) == false) goto L7;
        AIPackageStorage$deleteAIPackageById$1 r100 = (AIPackageStorage$deleteAIPackageById$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L15;
        if (r103 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (AIPackageManager.a) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L29
    L27:
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.getPackageName() + ", appId: " + r110.getAppId() + " ===> end delete database");     // Catch: Exception -> L29
    L32:
        return Boxing.boxBoolean(r104);
    L18:
        ResultKt.throwOnFailure(r113);
        g.f37637a.d("AIPackageStorage", "packageName: " + r110.getPackageName() + ", appId: " + r110.getAppId() + " ===> start delete database");     // Catch: Exception -> L29
        if (r111 != AIPackage.AIPackageType.WIDGET) goto L24;
        AIPackageDao r114 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        String r115 = r110.getAppId();     // Catch: Exception -> L29
        String r105 = r110.getPackageName();     // Catch: Exception -> L29
        r100.L$0 = r110;     // Catch: Exception -> L29
        r100.label = 1;     // Catch: Exception -> L29
        if (r114.f(r115, r105, r100) != r102) goto L27;
        return r102;
    L24:
        AIPackageDao r116 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        String r117 = r110.getAppId();     // Catch: Exception -> L29
        String r106 = r110.getPackageName();     // Catch: Exception -> L29
        r100.L$0 = r110;     // Catch: Exception -> L29
        r100.label = 2;     // Catch: Exception -> L29
        if (r116.c(r117, r106, r100) != r102) goto L27;
        return r102;
    L29:
        e = move-exception;
        g.f37637a.e("AIPackageStorage", "packageName: " + r110.getPackageName() + ", appId: " + r110.getAppId() + " ===> delete database error :  " + ExceptionsKt.stackTraceToString(e));
        r104 = false;
    L7:
        r100 = new AIPackageStorage$deleteAIPackageById$1(this, r112);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(AIPackageManager.a r100, AIPackage.AIPackageType r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof AIPackageStorage$markPackageAsDeleted$1) == false) goto L7;
        AIPackageStorage$markPackageAsDeleted$1 r103 = (AIPackageStorage$markPackageAsDeleted$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L18;
        if (r107 == 1) goto L15;
        if (r107 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackageManager.a r109 = (AIPackageManager.a) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Exception -> L29
        r100 = r109;
    L33:
    L32:
        return Boxing.boxBoolean(r108);
    L18:
        ResultKt.throwOnFailure(r105);
        int r110 = a.f37324a[r101.ordinal()];     // Catch: Exception -> L29
        if (r110 == 1) goto L26;
        if (r110 == 2) goto L23;
        r100 = r100;
        goto L33
    L23:
        AIPackageDao r111 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        String r112 = r100.getAppId();     // Catch: Exception -> L29
        String r113 = r100.getPackageName();     // Catch: Exception -> L29
        r103.L$0 = r100;     // Catch: Exception -> L29
        r103.label = 2;     // Catch: Exception -> L29
        Object r114 = r111.m(r112, r113, r103);     // Catch: Exception -> L29
        r100 = r114;
        if (r114 != r106) goto L33;
        return r106;
    L26:
        AIPackageDao r115 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L29
        String r116 = r100.getAppId();     // Catch: Exception -> L29
        String r117 = r100.getPackageName();     // Catch: Exception -> L29
        r103.L$0 = r100;     // Catch: Exception -> L29
        r103.label = 1;     // Catch: Exception -> L29
        Object r118 = r115.n(r116, r117, r103);     // Catch: Exception -> L29
        r100 = r118;
        if (r118 != r106) goto L33;
        return r106;
    L29:
        e = move-exception;
        g.f37637a.e("AIPackageStorage", "Failed to markPackageAsDeleted. packageName: " + r100.getPackageName() + ", appId: " + r100.getAppId() + ",  error: " + ExceptionsKt.stackTraceToString(e));
        r108 = false;
    L7:
        r103 = new AIPackageStorage$markPackageAsDeleted$1(this, r102);
        goto L8
    }

    public final Object j(String r100, AIPackage.AIPackageType r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof AIPackageStorage$queryInactiveVersion$1) == false) goto L7;
        AIPackageStorage$queryInactiveVersion$1 r101 = (AIPackageStorage$queryInactiveVersion$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L28;
        if (r104 == 1) goto L25;
        if (r104 == 2) goto L22;
        if (r104 == 3) goto L19;
        if (r104 != 4) goto L18;
        String r106 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L89
    L77:
        List r113 = (List) r112;     // Catch: Exception -> L89
        if (r113 != null) goto L80;
    L83:
        boolean r114 = true;
    L84:
        if (r114 == false) goto L88;
        r105 = false;
    L88:
        return Boxing.boxBoolean(r105);
    L80:
        if (r113.isEmpty() == true) goto L83;
        r114 = false;
        goto L84
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r100 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L89
    L66:
        List r115 = (List) r112;     // Catch: Exception -> L89
        if (r115 != null) goto L69;
    L72:
        boolean r116 = true;
    L73:
        if (r116 == false) goto L88;
        AIPackageDao r117 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L89
        r101.L$0 = r100;     // Catch: Exception -> L89
        r101.label = 4;     // Catch: Exception -> L89
        r112 = r117.x(r100, r101);     // Catch: Exception -> L89
        if (r112 != r103) goto L77;
        return r103;
    L69:
        if (r115.isEmpty() == true) goto L72;
        r116 = false;
        goto L73
    L22:
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L89
    L51:
        List r118 = (List) r112;     // Catch: Exception -> L89
        if (r118 != null) goto L54;
    L57:
        boolean r119 = true;
    L58:
        if (r119 == false) goto L62;
        r105 = false;
    L62:
        return Boxing.boxBoolean(r105);
    L54:
        if (r118.isEmpty() == true) goto L57;
        r119 = false;
        goto L58
    L25:
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L89
    L34:
        List r120 = (List) r112;     // Catch: Exception -> L89
        if (r120 != null) goto L37;
    L40:
        boolean r121 = true;
    L41:
        if (r121 == false) goto L45;
        r105 = false;
    L45:
        return Boxing.boxBoolean(r105);
    L37:
        if (r120.isEmpty() == true) goto L40;
        r121 = false;
        goto L41
    L28:
        ResultKt.throwOnFailure(r112);
        if (r110 != AIPackage.AIPackageType.APPLET) goto L47;
        AIPackageDao r122 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L89
        r101.L$0 = r100;     // Catch: Exception -> L89
        r101.label = 1;     // Catch: Exception -> L89
        r112 = r122.v(r100, r101);     // Catch: Exception -> L89
        if (r112 != r103) goto L34;
        return r103;
    L47:
        if (r110 != AIPackage.AIPackageType.WIDGET) goto L63;
        AIPackageDao r123 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L89
        r101.L$0 = r100;     // Catch: Exception -> L89
        r101.label = 2;     // Catch: Exception -> L89
        r112 = r123.x(r100, r101);     // Catch: Exception -> L89
        if (r112 != r103) goto L51;
        return r103;
    L63:
        AIPackageDao r124 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L89
        r101.L$0 = r100;     // Catch: Exception -> L89
        r101.label = 3;     // Catch: Exception -> L89
        r112 = r124.v(r100, r101);     // Catch: Exception -> L89
        if (r112 != r103) goto L66;
        return r103;
    L89:
        e = move-exception;
        g.f37637a.e("AIPackageStorage", "query inactive version of " + r100 + " error : " + ExceptionsKt.stackTraceToString(e));
        return Boxing.boxBoolean(false);
    L7:
        r101 = new AIPackageStorage$queryInactiveVersion$1(this, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0085 -> B:14:0x0039). Please report as a decompilation issue!!! */
    public final Object m(List<? extends AIPackageManager.a> r110, boolean r111, Continuation<? super List<? extends AIPackage>> r112) {
        if ((r112 instanceof AIPackageStorage$queryInstalledAIPackagesByIds$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByIds$1 r100 = (AIPackageStorage$queryInstalledAIPackagesByIds$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L19;
        if (r103 != 1) goto L18;
        boolean r114 = r100.Z$0;
        Iterator r115 = (Iterator) r100.L$2;
        List r104 = (List) r100.L$1;
        List<? extends AIPackageManager.a> r105 = (List) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L15
        AIPackageStorage$queryInstalledAIPackagesByIds$1 r116 = r100;
        boolean r106 = r114;
        r110 = r105;
    L14:
        List r107 = r104;
        Object r108 = r102;
        AIPackageStorage$queryInstalledAIPackagesByIds$1 r109 = r116;
        AIPackage r117 = (AIPackage) r113;     // Catch: Exception -> L35
        if (r117 == null) goto L34;
        r107.add(r117);     // Catch: Exception -> L35
    L34:
        boolean r118 = r106;
        r100 = r109;
        r102 = r108;
        r104 = r107;
    L21:
        if (r115.hasNext() == false) goto L39;
        AIPackageManager.a r119 = (AIPackageManager.a) r115.next();     // Catch: Exception -> L37
        AIPackageStorage r120 = f37323a;     // Catch: Exception -> L37
        AIPackage.AIPackageType r121 = AIPackage.AIPackageType.UNKNOWN;     // Catch: Exception -> L37
        if (r118 == false) goto L26;
        boolean r122 = true;
    L27:
        r100.L$0 = r110;     // Catch: Exception -> L37
        r100.L$1 = r104;     // Catch: Exception -> L37
        r100.L$2 = r115;     // Catch: Exception -> L37
        r100.Z$0 = r118;     // Catch: Exception -> L37
        r100.label = 1;     // Catch: Exception -> L37
        Object r123 = r120.k(r119, r121, r122, 0, r100);     // Catch: Exception -> L37
        if (r123 != r102) goto L30;
        return r102;
    L30:
        r116 = r100;
        r106 = r118;
        r113 = r123;
        goto L14
    L26:
        r122 = false;
    L39:
        return r104;
    L37:
        Exception e100 = e;
    L38:
        g.f37637a.e("AIPackageStorage", "query packages(size=" + r110.size() + ") info database error : " + ExceptionsKt.stackTraceToString(e100));
    L35:
        e100 = e;
        r104 = r107;
    L15:
        e = move-exception;
        e100 = e;
        r110 = r105;
        goto L38
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r113);
        r104 = new ArrayList();
        r118 = r111;
        r115 = r110.iterator();     // Catch: Exception -> L37
    L7:
        r100 = new AIPackageStorage$queryInstalledAIPackagesByIds$1(this, r112);
        goto L8
    }

    public final Object h(AIPackageManager.a r110, AIPackage.AIPackageType r111, long r112, Continuation<? super AIPackage> r113) {
        if ((r113 instanceof AIPackageStorage$queryInactiveAIPackageById$1) == false) goto L7;
        AIPackageStorage$queryInactiveAIPackageById$1 r100 = (AIPackageStorage$queryInactiveAIPackageById$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$queryInactiveAIPackageById$1 r102 = r100;
        Object r114 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r114);
    L17:
        AIPackage r115 = (AIPackage) r114;
        if (r115 != null) goto L20;
        return null;
    L20:
        if (Intrinsics.areEqual(r115.f36915v, "inactive") == false) goto L28;
        Integer r116 = r115.f36916w;
        if (r116 != null) goto L25;
        return r115;
    L25:
        if (r116.intValue() == 1) goto L28;
        return r115;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        r102.label = 1;
        r114 = g(r110, r111, "inactive", false, r112, r102);
        if (r114 != r103) goto L17;
        return r103;
    L7:
        r100 = new AIPackageStorage$queryInactiveAIPackageById$1(this, r113);
        goto L8
    }

    public final Object k(AIPackageManager.a r110, AIPackage.AIPackageType r111, boolean r112, long r113, Continuation<? super AIPackage> r114) {
        if ((r114 instanceof AIPackageStorage$queryInstallAIPackageById$2) == false) goto L7;
        AIPackageStorage$queryInstallAIPackageById$2 r100 = (AIPackageStorage$queryInstallAIPackageById$2) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$queryInstallAIPackageById$2 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        AIPackage r106 = (AIPackage) r103;
        if (r106 != null) goto L20;
        return null;
    L20:
        if (Intrinsics.areEqual(r106.f36915v, "installed") == false) goto L28;
        Integer r107 = r106.f36916w;
        if (r107 != null) goto L25;
        return r106;
    L25:
        if (r107.intValue() == 1) goto L28;
        return r106;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r102.label = 1;
        r103 = g(r110, r111, "installed", r112, r113, r102);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r100 = new AIPackageStorage$queryInstallAIPackageById$2(this, r114);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.ai.resource.AIPackageManager$a] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public final Object g(AIPackageManager.a r110, AIPackage.AIPackageType r111, String r210, boolean r211, long r212, Continuation<? super AIPackage> r213) {
        AIPackageManager.a r100 = r110;
        String r101 = r210;
        long r102 = r212;
        if ((r213 instanceof AIPackageStorage$queryAIPackageById$1) == false) goto L7;
        AIPackageStorage$queryAIPackageById$1 r103 = (AIPackageStorage$queryAIPackageById$1) r213;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        int r105 = r104 - Integer.MIN_VALUE;
        r103.label = r105;
        AIPackageStorage r112 = this;
        int r106 = r105;
    L8:
        AIPackageStorage$queryAIPackageById$1 r113 = r103;
        Object r107 = r113.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r112 = null;
        switch(r113.label) {
            case 0: goto L50;
            case 1: goto L47;
            case 2: goto L44;
            case 3: goto L41;
            case 4: goto L38;
            case 5: goto L35;
            case 6: goto L32;
            case 7: goto L27;
            case 8: goto L24;
            case 9: goto L21;
            case 10: goto L18;
            case 11: goto L15;
            case 12: goto L12;
            default: goto L11;
        };
    L12:
        AIPackageManager.a r108 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L101:
        Object r109 = (AIPackage) r107;     // Catch: Exception -> L117
    L150:
        return r109;
    L15:
        long r115 = r113.J$0;
        String r116 = (String) r113.L$1;
        AIPackageManager.a r117 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L30
        r102 = r115;
        r101 = r116;
        AIPackageManager.a r118 = r117;
    L95:
        r109 = (Applet) r107;     // Catch: Exception -> L117
        if (r109 != null) goto L150;
        AIPackageDao r119 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L117
        String r120 = r118.getAppId();     // Catch: Exception -> L117
        String r121 = r118.getPackageName();     // Catch: Exception -> L117
        r113.L$0 = r118;     // Catch: Exception -> L117
        r113.L$1 = 0;     // Catch: Exception -> L117
        r113.label = 12;     // Catch: Exception -> L117
        r107 = r119.I(r120, r121, r101, r102, r113);     // Catch: Exception -> L117
        if (r107 != r114) goto L101;
        return r114;
    L18:
        AIPackageManager.a r122 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L86:
        List r123 = (List) r107;     // Catch: Exception -> L71
        if (r123 != null) goto L149;
        r112 = null;
    L147:
        return r112;
    L149:
        return (Widget) CollectionsKt.firstOrNull(r123);
    L21:
        r101 = (String) r113.L$1;
        AIPackageManager.a r124 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
        AIPackageManager.a r125 = r124;
    L78:
        List r126 = (List) r107;     // Catch: Exception -> L71
        if (r126 == null) goto L83;
        r109 = (Applet) CollectionsKt.firstOrNull(r126);     // Catch: Exception -> L71
        if (r109 != null) goto L150;
    L83:
        AIPackageDao r127 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L71
        String r128 = r125.getAppId();     // Catch: Exception -> L71
        String r129 = r125.getPackageName();     // Catch: Exception -> L71
        r113.L$0 = r125;     // Catch: Exception -> L71
        r113.L$1 = null;     // Catch: Exception -> L71
        r113.label = 10;     // Catch: Exception -> L71
        r107 = r127.J(r128, r129, r101, r113);     // Catch: Exception -> L71
        if (r107 != r114) goto L86;
        return r114;
    L24:
        AIPackageManager.a r130 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L70:
        r109 = (AIPackage) r107;     // Catch: Exception -> L71
        goto L150
    L27:
        long r131 = r113.J$0;
        AIPackageManager.a r132 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L30
        r102 = r131;
        AIPackageManager.a r133 = r132;
    L64:
        r109 = (Applet) r107;     // Catch: Exception -> L71
        if (r109 != null) goto L150;
        AIPackageDao r134 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L71
        String r135 = r133.getAppId();     // Catch: Exception -> L71
        String r136 = r133.getPackageName();     // Catch: Exception -> L71
        r113.L$0 = r133;     // Catch: Exception -> L71
        r113.label = 8;     // Catch: Exception -> L71
        r107 = r134.H(r135, r136, r102, r113);     // Catch: Exception -> L71
        if (r107 != r114) goto L70;
        return r114;
    L32:
        AIPackageManager.a r137 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L153:
        return (Applet) r107;
    L35:
        AIPackageManager.a r138 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L114:
        List r139 = (List) r107;     // Catch: Exception -> L117
        if (r139 == null) goto L147;
        return (Applet) CollectionsKt.firstOrNull(r139);
    L38:
        AIPackageManager.a r140 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L151:
        return (Applet) r107;
    L41:
        AIPackageManager.a r141 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L156:
        return (Widget) r107;
    L44:
        AIPackageManager.a r142 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L134:
        List r143 = (List) r107;     // Catch: Exception -> L117
        if (r143 == null) goto L147;
        return (Widget) CollectionsKt.firstOrNull(r143);
    L47:
        AIPackageManager.a r144 = (AIPackageManager.a) r113.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L142
    L154:
        return (Widget) r107;
    L50:
        ResultKt.throwOnFailure(r107);
        g r145 = g.f37637a;     // Catch: Exception -> L142
        StringBuilder r146 = new StringBuilder("packageName: ");     // Catch: Exception -> L142
        r146.append(r110.getPackageName());     // Catch: Exception -> L142
        r146.append(", appId: ");     // Catch: Exception -> L142
        r146.append(r110.getAppId());     // Catch: Exception -> L142
        r146.append(", versionCode: ");     // Catch: Exception -> L142
        r146.append(r102);     // Catch: Exception -> L142
        r146.append(", tryActive ");     // Catch: Exception -> L142
        if (r211 == false) goto L54;
        boolean r147 = true;
    L55:
        r146.append(r147);     // Catch: Exception -> L142
        r146.append(" ===> query AIPackage info database");     // Catch: Exception -> L142
        r145.d("AIPackageStorage", r146.toString());     // Catch: Exception -> L142
        int r148 = a.f37324a[r111.ordinal()];     // Catch: Exception -> L142
        if (r148 == 1) goto L124;
        if (r148 == 2) goto L104;
        if (r211 == false) goto L74;
        AIPackageDao r149 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L142
        String r150 = r110.getAppId();     // Catch: Exception -> L142
        String r151 = r110.getPackageName();     // Catch: Exception -> L142
        r113.L$0 = r100;     // Catch: Exception -> L142
        r113.J$0 = r102;     // Catch: Exception -> L142
        r113.label = 7;     // Catch: Exception -> L142
        r107 = r149.G(r150, r151, r212, r113);     // Catch: Exception -> L71
        r133 = r100;
        if (r107 != r114) goto L64;
        return r114;
    L74:
        if (r102 != 0) goto L90;
        AIPackageDao r152 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L71
        String r153 = r110.getAppId();     // Catch: Exception -> L71
        String r154 = r110.getPackageName();     // Catch: Exception -> L71
        r113.L$0 = r100;     // Catch: Exception -> L71
        r113.L$1 = r101;     // Catch: Exception -> L71
        r113.label = 9;     // Catch: Exception -> L71
        r107 = r152.s(r153, r154, r101, r113);     // Catch: Exception -> L71
        r125 = r100;
        if (r107 != r114) goto L78;
        return r114;
    L90:
        AIPackageDao r155 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L71
        String r156 = r110.getAppId();     // Catch: Exception -> L71
        String r157 = r110.getPackageName();     // Catch: Exception -> L71
        r113.L$0 = r100;     // Catch: Exception -> L71
        r113.L$1 = r101;     // Catch: Exception -> L71
        r113.J$0 = r102;     // Catch: Exception -> L71
        r113.label = 11;     // Catch: Exception -> L71
        r107 = r155.r(r156, r157, r210, r212, r113);     // Catch: Exception -> L117
        r118 = r100;
        if (r107 != r114) goto L95;
        return r114;
    L104:
        if (r211 == false) goto L110;
        AIPackageDao r158 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L117
        String r159 = r110.getAppId();     // Catch: Exception -> L117
        String r160 = r110.getPackageName();     // Catch: Exception -> L117
        r113.L$0 = r100;     // Catch: Exception -> L117
        r113.label = 4;     // Catch: Exception -> L117
        r107 = r158.G(r159, r160, r212, r113);     // Catch: Exception -> L117
        if (r107 != r114) goto L151;
        return r114;
    L110:
        if (r102 != 0) goto L119;
        AIPackageDao r161 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L117
        String r162 = r110.getAppId();     // Catch: Exception -> L117
        String r163 = r110.getPackageName();     // Catch: Exception -> L117
        r113.L$0 = r100;     // Catch: Exception -> L117
        r113.label = 5;     // Catch: Exception -> L117
        r107 = r161.s(r162, r163, r101, r113);     // Catch: Exception -> L117
        if (r107 != r114) goto L114;
        return r114;
    L119:
        AIPackageDao r164 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L117
        String r165 = r110.getAppId();     // Catch: Exception -> L117
        String r166 = r110.getPackageName();     // Catch: Exception -> L117
        r113.L$0 = r100;     // Catch: Exception -> L117
        r113.label = 6;     // Catch: Exception -> L117
        r107 = r164.r(r165, r166, r210, r212, r113);     // Catch: Exception -> L117
        if (r107 != r114) goto L153;
        return r114;
    L124:
        if (r211 == false) goto L130;
        AIPackageDao r167 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L117
        String r168 = r110.getAppId();     // Catch: Exception -> L117
        String r169 = r110.getPackageName();     // Catch: Exception -> L117
        r113.L$0 = r100;     // Catch: Exception -> L117
        r113.label = 1;     // Catch: Exception -> L117
        r107 = r167.H(r168, r169, r212, r113);     // Catch: Exception -> L117
        if (r107 != r114) goto L154;
        return r114;
    L130:
        if (r102 != 0) goto L137;
        AIPackageDao r170 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L117
        String r171 = r110.getAppId();     // Catch: Exception -> L117
        String r172 = r110.getPackageName();     // Catch: Exception -> L117
        r113.L$0 = r100;     // Catch: Exception -> L117
        r113.label = 2;     // Catch: Exception -> L117
        r107 = r170.J(r171, r172, r101, r113);     // Catch: Exception -> L117
        if (r107 != r114) goto L134;
        return r114;
    L137:
        AIPackageDao r173 = AIPackageDatabase.f37336a.b().c();     // Catch: Exception -> L117
        String r174 = r110.getAppId();     // Catch: Exception -> L117
        String r175 = r110.getPackageName();     // Catch: Exception -> L117
        r113.L$0 = r100;     // Catch: Exception -> L117
        r113.label = 3;     // Catch: Exception -> L117
        r107 = r173.I(r174, r175, r210, r212, r113);     // Catch: Exception -> L117
        if (r107 != r114) goto L156;
        return r114;
    L54:
        r147 = false;
        goto L55
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L142:
        e = e;
        ?? r176 = r100;
    L144:
        ?? r177 = r176;
    L145:
        g.f37637a.e("AIPackageStorage", "packageName: " + r177.getPackageName() + ", appId: " + r177.getAppId() + " ===> qyery AIPackage info database error : " + ExceptionsKt.stackTraceToString(e));
    L30:
        e = e;
        r176 = r106;
    L117:
        e = e;
        r177 = r100;
    L71:
        e = e;
        r112 = null;
        r177 = r100;
    L7:
        r112 = this;
        r103 = new AIPackageStorage$queryAIPackageById$1(r112, r213);
        r106 = r104;
        goto L8
    }
}
