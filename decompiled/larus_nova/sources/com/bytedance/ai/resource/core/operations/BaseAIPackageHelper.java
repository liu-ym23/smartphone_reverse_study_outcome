package com.bytedance.ai.resource.core.operations;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.security.c;
import com.bytedance.ai.resource.security.e;
import com.bytedance.ai.resource.security.h;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes43.dex */
public final class BaseAIPackageHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AIPackageDeployment.AIPackageDeploymentItem f37472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageManifestBean f37473b;

    public final boolean b() {
        h2.a r100 = f2.b.f475099c;
        if (r100 == null) goto L34;
        Context r101 = r100.f483562a;
        if (r101 == null) goto L34;
        long r102 = this.f37472a.getVersionCode();
        c r103 = c.f37518a;
        String r104 = this.f37472a.getPackageName();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "packageName");
        Object r105 = null;
        String r106 = ((Keva) c.f37519b.getValue()).getString(c.b(r104, r102), null);
        if (r106 != null) goto L10;
    L13:
        boolean r107 = true;
    L15:
        if ((!r107) == true) goto L17;
    L19:
        String r108 = com.bytedance.ai.resource.core.a.c(this.f37472a);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L22
        Object r110 = Result.m9449constructorimpl(FilesKt.readBytes(new PolarisFileWrapper(r108)));     // Catch: Throwable -> L22
    L25:
        if (Result.m9455isFailureimpl(r110) == true) goto L28;
        r105 = r110;
    L28:
        byte[] r111 = (byte[]) r105;
        if (r111 != null) goto L32;
        g.f37637a.e("AIPackageManager", "BundleStore is NULL");
        return false;
    L32:
        e r112 = e.f37520a;
        String r113 = this.f37472a.getPackageName();
        r112.getClass();
        return e.a(r101, r113, r102, r111);
    L22:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L17:
        if (c.c(r101, this.f37472a.getPackageName(), r102) == null) goto L19;
        return true;
    L10:
        if (r106.length() == 0) goto L13;
        r107 = false;
    L34:
        return false;
    }

    public BaseAIPackageHelper(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "deploymentInfo");
        this.f37472a = r100;
    }

    public final Object c(Continuation<? super AbsAIPackageOperation.a> r100) {
        if ((r100 instanceof BaseAIPackageHelper$fetchManifest$1) == false) goto L7;
        BaseAIPackageHelper$fetchManifest$1 r101 = (BaseAIPackageHelper$fetchManifest$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        int r106 = 1;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L34
    L28:
        String r107 = (String) r103;     // Catch: Exception -> L34
        if (f(r107) == false) goto L33;
        String r108 = com.bytedance.ai.resource.core.a.f37325a;     // Catch: Exception -> L34
        boolean r109 = new PolarisFileWrapper(com.bytedance.ai.resource.core.a.c(this.f37472a)).exists();     // Catch: Exception -> L34
        if (r109 == true) goto L39;
    L42:
        AIPackageManifestBean r110 = AIPackageManifestBean.Companion.parseManifestJson(r107);     // Catch: Exception -> L34
        this.f37473b = r110;     // Catch: Exception -> L34
        if (r110 == null) goto L48;
        if (r109 == false) goto L46;
        int r111 = 1;
    L47:
        r110.setHasKeyStore(r111);     // Catch: Exception -> L34
        goto L48
    L46:
        r111 = 0;
    L48:
        AIPackageManifestBean r112 = this.f37473b;     // Catch: Exception -> L34
        if (r112 == null) goto L56;
        if (Intrinsics.areEqual(this.f37472a.getVerifySignature(), Boxing.boxBoolean(true)) == true) goto L54;
        r106 = 0;
    L54:
        r112.setVerifySignature(r106);     // Catch: Exception -> L34
    L56:
        if (this.f37473b == null) goto L58;
        g.f37637a.d("AIPackageManager", "packageName: " + this.f37472a.getPackageName() + ", appId: " + this.f37472a.getAppId() + " ===> Parsing the Manifest succeeds");     // Catch: Exception -> L34
        return a(0, "");
    L58:
        g.f37637a.e("AIPackageManager", "packageName: " + this.f37472a.getPackageName() + ", appId: " + this.f37472a.getAppId() + " ===> Failed to parse Manifest");     // Catch: Exception -> L34
        return a(6, "");
    L39:
        if (b() == true) goto L42;
        return a(15, "");
    L33:
        return a(14, "");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L34
    L22:
        AbsAIPackageOperation.a r113 = (AbsAIPackageOperation.a) r103;     // Catch: Exception -> L34
        if (r113.f37470e == 0) goto L25;
        return r113;
    L25:
        r101.label = 2;     // Catch: Exception -> L34
        r103 = e(r101);     // Catch: Exception -> L34
        if (r103 != r104) goto L28;
        return r104;
    L18:
        ResultKt.throwOnFailure(r103);
        AIPackageDeployment.AIPackageDeploymentItem r114 = this.f37472a;     // Catch: Exception -> L34
        r101.label = 1;     // Catch: Exception -> L34
        r103 = d(r114, r101);     // Catch: Exception -> L34
        if (r103 != r104) goto L22;
        return r104;
    L34:
        e = move-exception;
        g.f37637a.e("AIPackageManager", "packageName: " + this.f37472a.getPackageName() + ", appId: " + this.f37472a.getAppId() + " ===> base_" + this.f37472a.getVersionCode() + ".zip failed : " + ExceptionsKt.stackTraceToString(e));
        return a(1000, ExceptionsKt.stackTraceToString(e));
    L7:
        r101 = new BaseAIPackageHelper$fetchManifest$1(this, r100);
        goto L8
    }

    public final Object e(Continuation<? super String> r110) {
        AIPackageDeployment.AIPackageDeploymentItem r100 = this.f37472a;
        j r101 = new j(IntrinsicsKt.intercepted(r110), 1);
        r101.C();
        AtomicReference r102 = new AtomicReference(r101);
        r101.i(new b(r102));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r101.getContext()), com.bytedance.ai.infra.thread_pool.b.f36600a, null, new BaseAIPackageHelper$readManifestData$3$2(r100, r102, this, null), 2, null);
        Object r103 = r101.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r110);
    L5:
        return r103;
    }

    public final boolean f(String r110) {
        Boolean r100 = this.f37472a.getVerifySignature();
        Boolean r101 = Boolean.TRUE;
        if (Intrinsics.areEqual(r100, r101) == false) goto L16;
        String r102 = com.bytedance.ai.resource.core.a.f37325a;
        AIPackageDeployment.AIPackageDeploymentItem r103 = this.f37472a;
        Intrinsics.checkNotNullParameter(r103, "deploymentInfo");
        PolarisFileWrapper r104 = new PolarisFileWrapper(com.bytedance.ai.resource.core.a.f37325a + '/' + r103.getPackageName() + "/base_" + r103.getVersionCode() + "/base/manifest.sign");
        if (r104.exists() == false) goto L14;
        h r105 = h.f37525a;
        String r106 = this.f37472a.getPackageName();
        long r107 = this.f37472a.getVersionCode();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "packageName");
        if (Intrinsics.areEqual(h.f37526b.get(r106 + '_' + r107), r101) == false) goto L17;
        return true;
    L17:
        e r108 = e.f37520a;     // Catch: Exception -> L11
        String r109 = this.f37472a.getPackageName();     // Catch: Exception -> L11
        byte[] r111 = FilesKt.readBytes(r104);     // Catch: Exception -> L11
        long r112 = this.f37472a.getVersionCode();     // Catch: Exception -> L11
        r108.getClass();     // Catch: Exception -> L11
        return e.f(r109, r110, r111, r112);
    L11:
        e = move-exception;
        g.f37637a.e("AIPackageManager", "read signFile error: " + e);
        return false;
    L14:
        g.f37637a.e("AIPackageManager", "manifest.sign is NOT existed");
        return false;
    L16:
        return true;
    }

    public final AbsAIPackageOperation.a a(int r100, String r110) {
        return new AbsAIPackageOperation.a(null, this.f37472a.getPackageName(), this.f37472a.getAppId(), AIPackage.AIPackageType.UNKNOWN, r100, r110);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0262 -> B:61:0x026a). Please report as a decompilation issue!!! */
    public final Object d(AIPackageDeployment.AIPackageDeploymentItem r210, Continuation<? super AbsAIPackageOperation.a> r211) {
        if ((r211 instanceof BaseAIPackageHelper$installBasePackage$1) == false) goto L7;
        BaseAIPackageHelper$installBasePackage$1 r100 = (BaseAIPackageHelper$installBasePackage$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "";
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Iterator r106 = (Iterator) r100.L$1;
        String r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Iterator r107 = r106;
        String r111 = "";
        Object r108 = r103;
        BaseAIPackageHelper$installBasePackage$1 r109 = r100;
        BaseAIPackageHelper r112 = this;
    L61:
        boolean r113 = ((Boolean) r102).booleanValue();
        if (r113 == false) goto L64;
        boolean r114 = r113;
        BaseAIPackageHelper r115 = r112;
    L65:
        if (r114 == true) goto L68;
        g.f37637a.e("AIPackageManager", "packageName: " + r115.f37472a.getPackageName() + ", appId: " + r115.f37472a.getAppId() + " ===> Failed to download " + r110);
        return r115.a(2, r111);
    L68:
        String r116 = r111;
        String r117 = com.bytedance.ai.resource.core.a.f37325a;
        if (com.bytedance.ai.resource.core.e.b(r110, com.bytedance.ai.resource.core.a.a(r115.f37472a)) == true) goto L74;
        g.f37637a.e("AIPackageManager", "packageName: " + r115.f37472a.getPackageName() + ", appId: " + r115.f37472a.getAppId() + " ===> Failed to unzip " + r110);
        return r115.a(11, r116);
    L74:
        return r115.a(0, r116);
    L64:
        Iterator r212 = r107;
        r114 = r113;
        r115 = r112;
        r100 = r109;
        r103 = r108;
        Iterator r118 = r212;
    L38:
        if (r118.hasNext() == false) goto L65;
        String r119 = (String) r118.next();
        r100.L$0 = r110;
        r100.L$1 = r118;
        r100.label = 1;
        if (r119.length() != 0) goto L42;
        boolean r120 = true;
    L43:
        if (r120 == false) goto L45;
    L57:
        g.f37637a.e("AIPackageManager", "packageName: " + r115.f37472a.getPackageName() + ", appId: " + r115.f37472a.getAppId() + " ===> The download url and destination file are empty");
        Object r121 = Boxing.boxBoolean(false);
    L58:
        if (r121 != r103) goto L60;
        return r103;
    L60:
        BaseAIPackageHelper$installBasePackage$1 r213 = r100;
        r112 = r115;
        r102 = r121;
        r107 = r118;
        r108 = r103;
        r109 = r213;
        goto L61
    L45:
        if (r110.length() != 0) goto L47;
        boolean r122 = true;
    L48:
        if (r122 == true) goto L57;
        g r123 = g.f37637a;
        r123.i("AIPackageManager", "packageName: " + r115.f37472a.getPackageName() + ", appId: " + r115.f37472a.getAppId() + " ===> Start downloading " + r110);
        String r124 = com.bytedance.ai.resource.core.a.f37325a;
        String r125 = r115.f37472a.getPackageName();
        Intrinsics.checkNotNullParameter(r125, "packageName");
        String r126 = com.bytedance.ai.resource.core.a.f37325a + '/' + r125;
        f.h(r126);
        if (f.a(r110) == false) goto L53;
    L56:
        r123.d("AIPackageManager", "packageName: " + r115.f37472a.getPackageName() + ", appId: " + r115.f37472a.getAppId() + " ===> The " + r110 + " already exists");
        r121 = Boxing.boxBoolean(true);
        goto L58
    L53:
        if (f.l(r110, r115.f37472a.getPackageName()) == true) goto L56;
        r121 = com.bytedance.ai.resource.a.a(r119, r126, r100);
        goto L58
    L47:
        r122 = false;
        goto L48
    L42:
        r120 = false;
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r127 = com.bytedance.ai.resource.core.a.d(r210);
        if (f.a(r127) == true) goto L72;
        g.f37637a.d("AIPackageManager", "packageName: " + this.f37472a.getPackageName() + ", appId: " + this.f37472a.getAppId() + " ===> " + r127 + " does not exist");
        AppletResourceTool r128 = AppletResourceTool.f37276a;
        AIPackageDeployment.AIPackageDeploymentItem r129 = this.f37472a;
        r128.getClass();
        Intrinsics.checkNotNullParameter(r129, "<this>");
        ArrayList r130 = new ArrayList();
        List<String> r131 = r129.getResourceUrls();
        List<String> r132 = r131;
        if (r132 != null) goto L19;
    L22:
        boolean r133 = true;
    L24:
        if (r133 == true) goto L30;
        Iterator<T> r134 = r131.iterator();
    L27:
        if (r134.hasNext() == false) goto L29;
        String r135 = (String) r134.next();
        ListProtector.add(r130, 0, r135.substring(0, StringsKt.lastIndexOf$default(r135, HTTP.URL_DEFAULT, 0, false, 6, null)) + "/base_" + r129.getVersionCode() + ".zip");
        r105 = r105;
        goto L27
    L29:
        r111 = r105;
    L36:
        String r136 = com.bytedance.ai.resource.core.a.f37325a;
        r110 = com.bytedance.ai.resource.core.a.b(this.f37472a);
        r114 = false;
        r118 = r130.iterator();
        r115 = this;
        goto L38
    L30:
        r111 = "";
        if (r129.getResourceUrl().length() <= 0) goto L33;
        boolean r137 = true;
    L34:
        if (r137 == false) goto L36;
        int r138 = com.bytedance.ai.utils.a.f37625a;
        r130.add(com.bytedance.ai.utils.a.C0714a.a() + '/' + r129.getResourceUrl().substring(0, StringsKt.lastIndexOf$default(r129.getResourceUrl(), HTTP.URL_DEFAULT, 0, false, 6, null)) + "/base_" + r129.getVersionCode() + ".zip");
        goto L36
    L33:
        r137 = false;
        goto L34
    L19:
        if (r132.isEmpty() == true) goto L22;
        r133 = false;
        goto L24
    L72:
        r116 = "";
        r115 = this;
    L7:
        r100 = new BaseAIPackageHelper$installBasePackage$1(this, r211);
        goto L8
    }
}
