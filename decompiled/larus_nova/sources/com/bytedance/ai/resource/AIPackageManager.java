package com.bytedance.ai.resource;

import android.content.Context;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.AIPackageOperationGroup;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoItem;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoList;
import com.bytedance.ai.resource.core.bean.AIPackageGeckoInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.resource.core.bean.PackageRequestItem;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AIPackageManager f37254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.ai.resource.core.d f37255b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AIPackageOperationGroup> f37256c = null;

    public static class a {
        private String appId;
        private String packageName;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public int hashCode() {
            return (this.appId.hashCode() * 31) + this.packageName.hashCode();
        }

        public final String getAppId() {
            return this.appId;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            Class<?> r101 = getClass();
            if (r100 == null) goto L8;
            Class<?> r102 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(r101, r102) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ai.resource.AIPackageManager.AIPackageItem");
            a r103 = (a) r100;
            if (Intrinsics.areEqual(this.appId, r103.appId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.packageName, r103.packageName) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r102 = null;
            goto L10
        }

        public final void setAppId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.appId = r100;
        }

        public final void setPackageName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.packageName = r100;
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r101, "packageName");
            this.appId = r100;
            this.packageName = r101;
        }

        public /* synthetic */ a(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    public interface b {
        void a(AIPackage r100, String r101, String r102, AIPackage.AIPackageType r103, int r104, String r105);
    }

    public AIPackageManager() {
    }

    static {
        f37254a = new AIPackageManager();
        f37255b = new com.bytedance.ai.resource.core.d();
        f37256c = new ConcurrentHashMap();
    }

    public static AIPackageAppList g(List r100) {
        Intrinsics.checkNotNullParameter(r100, "appRequestList");
        AIPackageNetworkRequest r101 = new AIPackageNetworkRequest(r100, null, null, 6, null);
        Lazy r102 = o5.b.f522025a;
        Intrinsics.checkNotNullParameter(r101, "request");
        AIPackageNetworkResponse<AIPackageAppList> r103 = o5.b.a().requestUpdateInfo(r101);
        if (r103.getCode() != 0) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == true) goto L10;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "Failed to obtain the update list : code = " + r103.getCode() + ", msg = " + r103.getMsg());
        return null;
    L10:
        AIPackageAppList r105 = r103.getData();
        com.bytedance.ai.utils.g.f37637a.i("AIPackageManager", "Succeeded to obtain the update list : " + r105);
        return r105;
    L5:
        r104 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0085 -> B:21:0x0086). Please report as a decompilation issue!!! */
    public final Object e(Continuation<? super List<d0>> r100) {
        if ((r100 instanceof AIPackageManager$getAllInstalledPackageListFromGecko$1) == false) goto L7;
        AIPackageManager$getAllInstalledPackageListFromGecko$1 r101 = (AIPackageManager$getAllInstalledPackageListFromGecko$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        List r106 = (List) r101.L$3;
        Iterator r107 = (Iterator) r101.L$2;
        List r108 = (List) r101.L$1;
        List r109 = (List) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L21:
        r106.add(r103);
        r106 = r108;
    L16:
        if (r107.hasNext() == false) goto L22;
        String r110 = (String) r107.next();
        AIPackageManager r111 = f37254a;
        r101.L$0 = r109;
        r101.L$1 = r106;
        r101.L$2 = r107;
        r101.L$3 = r106;
        r101.label = 1;
        r103 = r111.l(r110, r101);
        if (r103 != r104) goto L20;
        return r104;
    L20:
        r108 = r106;
        goto L21
    L22:
        Iterator r112 = r106.iterator();
    L24:
        if (r112.hasNext() == false) goto L28;
        d0 r113 = (d0) ((Pair) r112.next()).getFirst();
        if (r113 == null) goto L24;
        r109.add(r113);
        goto L24
    L28:
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ArrayList r114 = new ArrayList();
        r106 = new ArrayList();
        AppletResourceTool.f37276a.getClass();
        r107 = AppletResourceTool.i().getAll().keySet().iterator();
        r109 = r114;
    L7:
        r101 = new AIPackageManager$getAllInstalledPackageListFromGecko$1(this, r100);
        goto L8
    }

    public static final String b(AIPackageManager r100, String r101) {
        r100.getClass();
        AppletResourceTool.f37276a.getClass();
        String r102 = AppletResourceTool.h(r101);
        boolean r103 = false;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L32;
        com.bytedance.ai.utils.g r105 = com.bytedance.ai.utils.g.f37637a;
        r105.i("AIPackageManager", "try to get baseUrl from remote. packageName: ".concat(r101));
        Lazy r106 = o5.b.f522025a;
        AIPackageGeckoInfoRequest r107 = new AIPackageGeckoInfoRequest(CollectionsKt.listOf(new PackageRequestItem(r101, null, 2, null)), null, 2, null);
        Intrinsics.checkNotNullParameter(r107, "request");
        AIPackageNetworkResponse<AIPackageGeckoInfoList> r108 = o5.b.a().requestGeckoInfo(r107);
        if (r108.getCode() != 0) goto L13;
        boolean r109 = true;
    L14:
        if (r109 == false) goto L24;
        AIPackageGeckoInfoList r110 = r108.getData();
        if (r110 == null) goto L25;
        List<AIPackageGeckoInfoItem> r111 = r110.getAppList();
        if (r111 == null) goto L25;
        AIPackageGeckoInfoItem r112 = (AIPackageGeckoInfoItem) CollectionsKt.firstOrNull(r111);
        if (r112 == null) goto L25;
        List<String> r113 = r112.getBaseUrls();
        if (r113 == null) goto L25;
        r102 = (String) CollectionsKt.firstOrNull(r113);
    L26:
        if (r102 != null) goto L28;
    L29:
        r103 = true;
    L30:
        if (r103 == true) goto L32;
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "baseUrl");
        AppletResourceTool.f37277b.put(r101, r102);
        AppletResourceTool.i().storeString(r101, r102);
        goto L32
    L28:
        if (r102.length() != 0) goto L30;
    L25:
        r102 = null;
        goto L26
    L24:
        r105.e("AIPackageManager", "failed to get remote baseUrl. packageName: ".concat(r101));
        goto L25
    L13:
        r109 = false;
    L32:
        return r102;
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0102 -> B:36:0x0103). Please report as a decompilation issue!!! */
    public final Object f(List<? extends AIPackage> r110, Continuation<? super List<String>> r111) {
        if ((r111 instanceof AIPackageManager$getFileListToRemoved$1) == false) goto L7;
        AIPackageManager$getFileListToRemoved$1 r100 = (AIPackageManager$getFileListToRemoved$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        Iterator r105 = (Iterator) r100.L$1;
        List r106 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L36:
        Boxing.boxBoolean(r106.addAll((List) r102));
        List r107 = r106;
    L20:
        if (r105.hasNext() == false) goto L38;
        AIPackage r112 = (AIPackage) r105.next();
        AIPackageStorage r108 = AIPackageStorage.f37323a;
        a r113 = new a(r112.a(), r112.f36895b);
        AIPackage.AIPackageType r114 = r112.c();
        long r115 = r112.f36896c;
        r100.L$0 = r107;
        r100.L$1 = r105;
        r100.L$2 = r112;
        r100.L$3 = null;
        r100.label = 1;
        Object r109 = r108.k(r113, r114, false, r115, r100);
        if (r109 != r103) goto L24;
        return r103;
    L24:
        List r116 = r107;
        Iterator r117 = r105;
        r102 = r109;
        AIPackage r118 = r112;
    L25:
        AIPackage r119 = (AIPackage) r102;
        AIPackageStorage r120 = AIPackageStorage.f37323a;
        a r121 = new a(r118.a(), r118.f36895b);
        AIPackage.AIPackageType r122 = r118.c();
        long r123 = r118.f36896c;
        r100.L$0 = r116;
        r100.L$1 = r117;
        r100.L$2 = r118;
        r100.L$3 = r119;
        r100.label = 2;
        List r124 = r116;
        Object r125 = r120.h(r121, r122, r123, r100);
        if (r125 != r103) goto L28;
        return r103;
    L28:
        AIPackage r126 = r118;
        AIPackage r127 = r119;
        r102 = r125;
        r106 = r124;
    L29:
        AIPackage r128 = (AIPackage) r102;
        if (r127 != null) goto L37;
        if (r128 != null) goto L37;
        AIPackageStorage r129 = AIPackageStorage.f37323a;
        r100.L$0 = r106;
        r100.L$1 = r117;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.label = 3;
        r102 = r129.c(r126, r100);
        if (r102 != r103) goto L35;
        return r103;
    L35:
        r105 = r117;
        goto L36
    L37:
        com.bytedance.ai.utils.g.f37637a.w("AIPackageManager", "current package is installed in local. ignore to remove it: packageName: " + r126.f36895b + ", versionCode: " + r126.f36896c);
        r107 = r106;
        r105 = r117;
        goto L20
    L39:
        com.bytedance.ai.utils.g.f37637a.w("AIPackageManager", "current package is installed in local. ignore to remove it: packageName: " + r126.f36895b + ", versionCode: " + r126.f36896c);
        r107 = r106;
        r105 = r117;
        goto L20
    L38:
        return r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r127 = (AIPackage) r100.L$3;
        AIPackage r130 = (AIPackage) r100.L$2;
        Iterator r131 = (Iterator) r100.L$1;
        List r132 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r117 = r131;
        r126 = r130;
        r106 = r132;
        goto L29
    L17:
        r118 = (AIPackage) r100.L$2;
        Iterator r133 = (Iterator) r100.L$1;
        List r134 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r117 = r133;
        r116 = r134;
        goto L25
    L18:
        ResultKt.throwOnFailure(r102);
        r107 = new ArrayList();
        r105 = r110.iterator();
    L7:
        r100 = new AIPackageManager$getFileListToRemoved$1(this, r111);
        goto L8
    }

    public final Object l(String r100, Continuation<? super Pair<d0, String>> r101) {
        if ((r101 instanceof AIPackageManager$installPackageFromGecko$1) == false) goto L7;
        AIPackageManager$installPackageFromGecko$1 r102 = (AIPackageManager$installPackageFromGecko$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        String r107 = null;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        Object r108 = Result.m9449constructorimpl((d0) r104);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r108) == false) goto L26;
        Object r109 = null;
    L27:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r108);
        if (r110 == null) goto L31;
        r107 = r110.getMessage();
    L31:
        return TuplesKt.to(r109, r107);
    L26:
        r109 = r108;
        goto L27
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r104 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.f36600a, new AIPackageManager$getInstallPackageFromGeckoJob$2(r100, null), r102);     // Catch: Throwable -> L21
        if (r104 != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new AIPackageManager$installPackageFromGecko$1(this, r101);
        goto L8
    }

    public final Object n(List<? extends AIPackage> r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1) == false) goto L7;
        AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1 r100 = (AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        List r113 = (List) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L26:
        return r112;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
    L19:
        List r114 = (List) r112;
        if ((!r114.isEmpty()) == false) goto L28;
        r100.L$0 = r114;
        r100.label = 2;
        kotlinx.coroutines.j r115 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r115.C();
        Ref.BooleanRef r104 = new Ref.BooleanRef();
        r104.element = true;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$2$1(r114, r115, r104, null), 3, null);
        r112 = r115.B();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L24:
        if (r112 != r102) goto L26;
        return r102;
    L28:
        return Boxing.boxBoolean(true);
    L16:
        ResultKt.throwOnFailure(r112);
        r100.label = 1;
        r112 = f(r110, r100);
        if (r112 != r102) goto L19;
        return r102;
    L7:
        r100 = new AIPackageManager$uninstallAIPackagesWithVersionCodeInMemory$1(this, r111);
        goto L8
    }

    public static final Object c(AIPackageManager r110, Context r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof AIPackageManager$loadBuiltInAIPackages$1) == false) goto L7;
        AIPackageManager$loadBuiltInAIPackages$1 r100 = (AIPackageManager$loadBuiltInAIPackages$1) r112;
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
    L110:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        List r105 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L57:
        List r106 = (List) r102;
        ArrayList r107 = new ArrayList();
        Iterator r108 = r105.iterator();
    L59:
        if (r108.hasNext() == false) goto L81;
        Object r109 = r108.next();
        AIPackageDeployment.AIPackageDeploymentItem r113 = (AIPackageDeployment.AIPackageDeploymentItem) r109;
        List r114 = r106;
        if ((r114 instanceof Collection) == true) goto L63;
    L65:
        Iterator r115 = r114.iterator();
    L67:
        if (r115.hasNext() == false) goto L78;
        AIPackage r116 = (AIPackage) r115.next();
        boolean r117 = false;
        if (Intrinsics.areEqual(r116.f36895b, r113.getPackageName()) == true) goto L71;
    L75:
        boolean r118 = false;
    L76:
        if (r118 == false) goto L67;
    L79:
        if (r117 == false) goto L59;
        r107.add(r109);
        goto L59
    L71:
        if (Intrinsics.areEqual(r116.a(), r113.getAppId()) == false) goto L75;
        if (r116.f36896c < r113.getVersionCode()) goto L75;
        r118 = true;
    L78:
        r117 = true;
        goto L79
    L63:
        if (r114.isEmpty() == false) goto L65;
    L81:
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r120 = r107.iterator();
    L83:
        if (r120.hasNext() == false) goto L85;
        AIPackageDeployment.AIPackageDeploymentItem r121 = (AIPackageDeployment.AIPackageDeploymentItem) r120.next();
        r121.setResourceUrl("local://urlPlaceHolder/");
        r119.add(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new AIPackageManager$loadBuiltInAIPackages$3$1(r121, null), 3, null));
        goto L83
    L85:
        r100.L$0 = null;
        r100.label = 2;
        if (AwaitKt.a(r119, r100) != r103) goto L110;
        return r103;
    L16:
        ResultKt.throwOnFailure(r102);
        InputStream r122 = r111.getAssets().open("pre-install_info.json");     // Catch: Exception -> L45
        Intrinsics.checkNotNull(r122);     // Catch: Throwable -> L38
        Reader r123 = new InputStreamReader(r122, Charsets.UTF_8);     // Catch: Throwable -> L38
        if ((r123 instanceof BufferedReader) == false) goto L22;
        BufferedReader r124 = (BufferedReader) r123;     // Catch: Throwable -> L38
    L95:
        String r125 = TextStreamsKt.readText(r124);     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r124, null);     // Catch: Throwable -> L38
        List r126 = (List) new Gson().fromJson(r125, new h().getType());     // Catch: Throwable -> L38
        if (r126 == null) goto L28;
        com.bytedance.ai.utils.g.f37637a.d("AIPackageManager", "Loaded local pre-install list: " + r126 + " items");     // Catch: Throwable -> L38
    L29:
        CloseableKt.closeFinally(r122, null);     // Catch: Exception -> L45
    L47:
        if (r126 == null) goto L90;
        if ((!r126.isEmpty()) == false) goto L51;
        r105 = r126;
    L52:
        if (r105 == null) goto L90;
        AIPackageStorage r127 = AIPackageStorage.f37323a;
        r100.L$0 = r105;
        r100.label = 1;
        r102 = r127.o(AIPackage.AIPackageType.UNKNOWN, r100);
        if (r102 != r103) goto L57;
        return r103;
    L51:
        r105 = null;
    L90:
        return Unit.INSTANCE;
    L28:
        r126 = null;
        goto L29
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r124, th);     // Catch: Throwable -> L38
        throw th;     // Catch: Throwable -> L38
    L22:
        r124 = new BufferedReader(r123, 8192);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r122, th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L45:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("AIPackageManager", "Failed to load local pre-install list: " + e.getMessage());
        r126 = null;
    L7:
        r100 = new AIPackageManager$loadBuiltInAIPackages$1(r110, r112);
        goto L8
    }

    public static final String d(AIPackageManager r100, int r101, List r102) {
        r100.getClass();
        if (r101 != IAISDKDebugService.DebugMode.SCAN_PREVIEW.getValue()) goto L11;
        if (r102 == null) goto L8;
        boolean r103 = true;
        if ((!r102.isEmpty()) != true) goto L8;
    L9:
        if (r103 == false) goto L11;
        return "scan";
    L8:
        r103 = false;
    L11:
        return "normal";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object k(List r110, AIManager$loadPermanentAIPackages$1.a r111, Continuation r112) {
        if ((r112 instanceof AIPackageManager$installAIPackages$1) == false) goto L7;
        AIPackageManager$installAIPackages$1 r100 = (AIPackageManager$installAIPackages$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Iterator r114 = (Iterator) r100.L$1;
        b r115 = (b) r100.L$0;
        ResultKt.throwOnFailure(r113);
        b r116 = r115;
    L18:
        if (r114.hasNext() == false) goto L35;
        a r104 = (a) r114.next();
        if (Intrinsics.areEqual(r104.getPackageName(), "db_YzR3DO") == true) goto L21;
        AIPackageManager r105 = f37254a;
        r100.L$0 = r116;
        r100.L$1 = r114;
        r100.label = 2;
        if (r105.h(r104, 0, r116, r100) != r102) goto L18;
        return r102;
    L21:
        AIPackageManager r106 = f37254a;
        if ((r104 instanceof AIPackageDeployment.AIPackageDeploymentItem) == false) goto L24;
        AIPackageDeployment.AIPackageDeploymentItem r117 = (AIPackageDeployment.AIPackageDeploymentItem) r104;
    L25:
        if (r117 == null) goto L27;
        long r107 = r117.getVersionCode();
    L28:
        r100.L$0 = r116;
        r100.L$1 = r114;
        r100.label = 1;
        if (r106.h(r104, r107, r116, r100) != r102) goto L18;
        return r102;
    L27:
        r107 = 0;
        goto L28
    L24:
        r117 = null;
        goto L25
    L35:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r113);
        r114 = r110.iterator();
        r116 = r111;
    L7:
        r100 = new AIPackageManager$installAIPackages$1(this, r112);
        goto L8
    }

    public final Object m(AIPackageAppList r110, b r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof AIPackageManager$onUpdateAIPackages$1) == false) goto L7;
        AIPackageManager$onUpdateAIPackages$1 r100 = (AIPackageManager$onUpdateAIPackages$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        AIPackageDeployment.AIPackageDeploymentItem r114 = (AIPackageDeployment.AIPackageDeploymentItem) r100.L$2;
        Iterator<AIPackageResponseItem> r115 = (Iterator) r100.L$1;
        r111 = (b) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L18:
        if (r115.hasNext() == false) goto L46;
        AIPackageDeployment.AIPackageDeploymentItem r116 = AIPackageDeployment.c(r115.next());
        if (r116 == null) goto L18;
        AIPackageManager r104 = f37254a;
        r100.L$0 = r111;
        r100.L$1 = r115;
        r100.L$2 = r116;
        r100.label = 1;
        r104.getClass();
        String r105 = r116.getPackageName();
        com.bytedance.ai.utils.g.f37637a.d("AIPackageManager", "packageName: " + r116.getPackageName() + ", appId: " + r116.getAppId() + " ===> updateAIPackage start");
        if (r116.getVersionCode() != (-1)) goto L33;
        ConcurrentHashMap<String, AIPackageOperationGroup> r106 = f37256c;
        AIPackageOperationGroup r107 = r106.get(r105);
        if (r107 != null) goto L29;
        r107 = new AIPackageOperationGroup();
        AIPackageOperationGroup r108 = r106.putIfAbsent(r105, r107);
        if (r108 == null) goto L29;
        r107 = r108;
    L29:
        Object r117 = r107.l(r116, r111, r100);
        if (r117 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        r117 = Unit.INSTANCE;
    L43:
        if (r117 != r102) goto L18;
        return r102;
    L33:
        ConcurrentHashMap<String, AIPackageOperationGroup> r109 = f37256c;
        AIPackageOperationGroup r118 = r109.get(r105);
        if (r118 != null) goto L39;
        r118 = new AIPackageOperationGroup();
        AIPackageOperationGroup r119 = r109.putIfAbsent(r105, r118);
        if (r119 == null) goto L39;
        r118 = r119;
    L39:
        r117 = r118.m(r116, r111, r100);
        if (r117 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        r117 = Unit.INSTANCE;
    L46:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 == null) goto L46;
        r115 = r110.getAppList().iterator();
    L7:
        r100 = new AIPackageManager$onUpdateAIPackages$1(this, r112);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b7 -> B:30:0x00bb). Please report as a decompilation issue!!! */
    public static final Object a(AIPackageManager r110, CompletableDeferred r111, Set r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof AIPackageManager$cleanPackagesToDelete$1) == false) goto L7;
        AIPackageManager$cleanPackagesToDelete$1 r100 = (AIPackageManager$cleanPackagesToDelete$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        if (r102 == 0) goto L18;
        if (r102 == 1) goto L17;
        if (r102 == 2) goto L16;
        if (r102 != 3) goto L15;
        List r116 = (List) r100.L$2;
        List r117 = (List) r100.L$1;
        CompletableDeferred r118 = (CompletableDeferred) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L37:
        Boxing.boxBoolean(r116.addAll((Collection) r114));
        List r103 = r117;
    L38:
        r118.complete(Boxing.boxBoolean(true));
        if ((!r103.isEmpty()) == false) goto L42;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new AIPackageManager$cleanPackagesToDelete$4(r103, null), 3, null);
    L42:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Iterator r119 = (Iterator) r100.L$3;
        List r120 = (List) r100.L$2;
        Set r104 = (Set) r100.L$1;
        CompletableDeferred r105 = (CompletableDeferred) r100.L$0;
        ResultKt.throwOnFailure(r114);
        r103 = r120;
        r112 = r104;
    L30:
        r103.addAll((List) r114);
        Object r121 = r115;
        r118 = r105;
    L23:
        if (r119.hasNext() == false) goto L31;
        AIPackage r106 = (AIPackage) r119.next();
        if (r112.contains(r106.f36895b) == true) goto L23;
        AIPackageStorage r107 = AIPackageStorage.f37323a;
        r100.L$0 = r118;
        r100.L$1 = r112;
        r100.L$2 = r103;
        r100.L$3 = r119;
        r100.label = 2;
        Object r108 = r107.a(r106, r100);
        if (r108 == r121) goto L47;
        CompletableDeferred r109 = r118;
        r115 = r121;
        r114 = r108;
        r105 = r109;
    L47:
        return r121;
    L31:
        List<AIPackage> r122 = IAISDKDebugService.f36186a.a();
        if (r122 == null) goto L38;
        AIPackageManager r123 = f37254a;
        r100.L$0 = r118;
        r100.L$1 = r103;
        r100.L$2 = r103;
        r100.L$3 = null;
        r100.label = 3;
        Object r124 = r123.f(r122, r100);
        if (r124 == r121) goto L47;
        r114 = r124;
        r116 = r103;
        r117 = r116;
        goto L37
    L17:
        r112 = (Set) r100.L$1;
        r111 = (CompletableDeferred) r100.L$0;
        ResultKt.throwOnFailure(r114);
    L21:
        r103 = new ArrayList();
        CompletableDeferred r125 = r111;
        r119 = ((List) r114).iterator();
        r121 = r115;
        r118 = r125;
        goto L23
    L18:
        ResultKt.throwOnFailure(r114);
        AIPackageStorage r126 = AIPackageStorage.f37323a;
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.label = 1;
        r114 = r126.p(r100);
        if (r114 != r115) goto L21;
        return r115;
    L7:
        r100 = new AIPackageManager$cleanPackagesToDelete$1(r110, r113);
        goto L8
    }

    public final Object h(a r100, long r101, b r110, Continuation<? super Unit> r111) {
        Object r102 = i(r100, r101, r110, false, r111);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static Object i(a r110, long r210, b r211, boolean r212, Continuation r213) {
        String r100 = r110.getPackageName();
        com.bytedance.ai.utils.g.f37637a.i("AIPackageManager", "packageName: " + r110.getPackageName() + ", appId: " + r110.getAppId() + ", onlyInMemory: " + r212 + " ===> installAIPackage start");
        if ((r110 instanceof AIPackageDeployment.AIPackageDeploymentItem) == false) goto L5;
        AIPackageDeployment.AIPackageDeploymentItem r101 = (AIPackageDeployment.AIPackageDeploymentItem) r110;
    L6:
        if (r101 != null) goto L8;
        r101 = new AIPackageDeployment.AIPackageDeploymentItem(r110.getAppId(), r110.getPackageName(), r210, null, null, null, false, null, null, 504, null);
    L8:
        if (r212 == false) goto L20;
        ConcurrentHashMap<String, AIPackageOperationGroup> r102 = f37256c;
        AIPackageOperationGroup r103 = r102.get(r100);
        if (r103 != null) goto L15;
        r103 = new AIPackageOperationGroup();
        AIPackageOperationGroup r104 = r102.putIfAbsent(r100, r103);
        if (r104 == null) goto L15;
        r103 = r104;
    L15:
        Object r105 = AIPackageOperationGroup.h(r103, r101, r211, r213);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r105;
    L19:
        return Unit.INSTANCE;
    L20:
        ConcurrentHashMap<String, AIPackageOperationGroup> r106 = f37256c;
        AIPackageOperationGroup r107 = r106.get(r100);
        if (r107 != null) goto L26;
        r107 = new AIPackageOperationGroup();
        AIPackageOperationGroup r108 = r106.putIfAbsent(r100, r107);
        if (r108 == null) goto L26;
        r107 = r108;
    L26:
        Object r109 = AIPackageOperationGroup.g(r107, r101, r211, r213);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        return r109;
    L30:
        return Unit.INSTANCE;
    L5:
        r101 = null;
        goto L6
    }

    public static /* synthetic */ Object j(AIPackageManager r100, a r101, long r102, b r110, Continuation r111) {
        r100.getClass();
        return i(r101, r102, r110, false, r111);
    }
}
