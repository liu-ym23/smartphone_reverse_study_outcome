package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageUpdateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AIPackageUpdateManager f37273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CoroutineScope f37274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f37275c = null;

    public AIPackageUpdateManager() {
    }

    static {
        f37273a = new AIPackageUpdateManager();
        f37275c = LazyKt.lazy(new i());
    }

    public final Object a(Continuation<? super Unit> r110) {
        if ((r110 instanceof AIPackageUpdateManager$checkUpdateAllAIPackages$1) == false) goto L7;
        AIPackageUpdateManager$checkUpdateAllAIPackages$1 r100 = (AIPackageUpdateManager$checkUpdateAllAIPackages$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L25;
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L18;
        if (r103 != 4) goto L17;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L70
    L73:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        List r104 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L70
    L37:
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L70
        Iterator r112 = ((List) r111).iterator();     // Catch: Exception -> L70
    L39:
        if (r112.hasNext() == false) goto L58;
        AIPackage r106 = (AIPackage) r112.next();     // Catch: Exception -> L70
        Iterator r107 = r104.iterator();     // Catch: Exception -> L70
    L42:
        if (r107.hasNext() == false) goto L51;
        Object r113 = r107.next();     // Catch: Exception -> L70
        AIPackage r114 = (AIPackage) r113;     // Catch: Exception -> L70
        if (Intrinsics.areEqual(r114.a(), r106.a()) == true) goto L46;
    L48:
        boolean r115 = false;
    L49:
        if (r115 == false) goto L42;
    L52:
        AIPackage r116 = (AIPackage) r113;     // Catch: Exception -> L70
        if (r116 == null) goto L55;
        r104.remove(r116);     // Catch: Exception -> L70
        AppRequestItem r108 = new AppRequestItem(r116.a(), r116.f36895b, String.valueOf(r116.f36896c));     // Catch: Exception -> L70
    L56:
        n5.a.C6891a r109 = n5.a.f517985a;     // Catch: Exception -> L70
        r108.getPackageName();     // Catch: Exception -> L70
        r109.getClass();     // Catch: Exception -> L70
        r105.add(r108);     // Catch: Exception -> L70
        goto L39
    L55:
        r108 = new AppRequestItem(r106.a(), r106.f36895b, String.valueOf(r106.f36896c));     // Catch: Exception -> L70
        goto L56
    L46:
        if (Intrinsics.areEqual(r114.f36895b, r106.f36895b) == false) goto L48;
        r115 = true;
        goto L49
    L51:
        r113 = null;
        goto L52
    L58:
        if (r104.isEmpty() == true) goto L63;
        Iterator r117 = r104.iterator();     // Catch: Exception -> L70
    L61:
        if (r117.hasNext() == false) goto L63;
        AIPackage r118 = (AIPackage) r117.next();     // Catch: Exception -> L70
        n5.a.C6891a r119 = n5.a.f517985a;     // Catch: Exception -> L70
        r118.getClass();     // Catch: Exception -> L70
        r119.getClass();     // Catch: Exception -> L70
        r105.add(new AppRequestItem(r118.a(), r118.f36895b, String.valueOf(r118.f36896c)));     // Catch: Exception -> L70
    L63:
        com.bytedance.ai.utils.g r120 = com.bytedance.ai.utils.g.f37637a;     // Catch: Exception -> L70
        r120.i("AIPackageUpdateManager", "Start requesting the server to get the update list");     // Catch: Exception -> L70
        r120.d("AIPackageUpdateManager", "the installed list is : " + r105);     // Catch: Exception -> L70
        if (r105.isEmpty() == true) goto L66;
        AIPackageManager r121 = AIPackageManager.f37254a;     // Catch: Exception -> L70
        r121.getClass();     // Catch: Exception -> L70
        AIPackageAppList r122 = AIPackageManager.g(r105);     // Catch: Exception -> L70
        r100.L$0 = null;     // Catch: Exception -> L70
        r100.label = 4;     // Catch: Exception -> L70
        if (r121.m(r122, null, r100) != r102) goto L73;
        return r102;
    L66:
        return Unit.INSTANCE;
    L21:
        List r123 = (List) r100.L$1;
        List r124 = (List) r100.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L70
    L33:
        r123.addAll((Collection) r111);     // Catch: Exception -> L70
        AIPackageStorage r125 = AIPackageStorage.f37323a;     // Catch: Exception -> L70
        r100.L$0 = r124;     // Catch: Exception -> L70
        r100.L$1 = null;     // Catch: Exception -> L70
        r100.label = 3;     // Catch: Exception -> L70
        r111 = r125.o(AIPackage.AIPackageType.UNKNOWN, r100);     // Catch: Exception -> L70
        if (r111 != r102) goto L36;
        return r102;
    L36:
        r104 = r124;
        goto L37
    L23:
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L70
    L29:
        r123 = new ArrayList();     // Catch: Exception -> L70
        AIPackageStorage r126 = AIPackageStorage.f37323a;     // Catch: Exception -> L70
        r100.L$0 = r123;     // Catch: Exception -> L70
        r100.L$1 = r123;     // Catch: Exception -> L70
        r100.label = 2;     // Catch: Exception -> L70
        r111 = r126.i(r100);     // Catch: Exception -> L70
        if (r111 != r102) goto L32;
        return r102;
    L32:
        r124 = r123;
        goto L33
    L25:
        ResultKt.throwOnFailure(r111);
        com.bytedance.ai.debug.f.f36213a.getClass();     // Catch: Exception -> L70
        AIManager r127 = AIManager.f37211a;     // Catch: Exception -> L70
        r100.label = 1;     // Catch: Exception -> L70
        if (r127.i(r100) != r102) goto L29;
        return r102;
    L70:
        e = move-exception;
        com.bytedance.ai.utils.g r128 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r129 = new StringBuilder("Check update exception : ");
        e.printStackTrace();
        r129.append(Unit.INSTANCE);
        r128.e("AIPackageUpdateManager", r129.toString());
    L7:
        r100 = new AIPackageUpdateManager$checkUpdateAllAIPackages$1(this, r110);
        goto L8
    }
}
