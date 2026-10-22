package com.bytedance.ai.resource.core.operations;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.e;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AbsAIPackageOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AIPackage f37459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AIPackageManifestBean f37460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AIPackageDeployment.AIPackageDeploymentItem f37461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f37462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile a f37463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<AIPackageManager.b> f37464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet<Continuation<a>> f37465g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AIPackage f37466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AIPackage.AIPackageType f37469d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f37470e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f37471f;

        public a() {
            this(null, null, null, null, 0, 63);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f37466a, r101.f37466a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37467b, r101.f37467b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37468c, r101.f37468c) == true) goto L18;
            return false;
        L18:
            if (this.f37469d == r101.f37469d) goto L21;
            return false;
        L21:
            if (this.f37470e == r101.f37470e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f37471f, r101.f37471f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            AIPackage r100 = this.f37466a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((((((((r102 * 31) + this.f37467b.hashCode()) * 31) + this.f37468c.hashCode()) * 31) + this.f37469d.hashCode()) * 31) + this.f37470e) * 31;
            String r104 = this.f37471f;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(info=" + this.f37466a + ", packageName=" + this.f37467b + ", appId=" + this.f37468c + ", packageType=" + this.f37469d + ", errorCode=" + this.f37470e + ", errorMsg=" + this.f37471f + ')';
        }

        public /* synthetic */ a(AIPackage r100, String r101, String r110, AIPackage.AIPackageType r111, int r112, int r113) {
            if ((r113 & 1) == 0) goto L5;
            r100 = null;
        L5:
            AIPackage r102 = r100;
            if ((r113 & 2) == 0) goto L8;
            String r103 = "";
        L10:
            if ((r113 & 4) == 0) goto L12;
            String r104 = "";
        L14:
            if ((r113 & 8) == 0) goto L16;
            r111 = AIPackage.AIPackageType.UNKNOWN;
        L16:
            AIPackage.AIPackageType r105 = r111;
            if ((r113 & 16) == 0) goto L19;
            int r106 = 1000;
        L20:
            this(r102, r103, r104, r105, r106, null);
            return;
        L19:
            r106 = r112;
            goto L20
        L12:
            r104 = r110;
            goto L14
        L8:
            r103 = r101;
            goto L10
        }

        public a(AIPackage r100, String r101, String r102, AIPackage.AIPackageType r103, int r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "packageName");
            Intrinsics.checkNotNullParameter(r102, "appId");
            Intrinsics.checkNotNullParameter(r103, "packageType");
            this.f37466a = r100;
            this.f37467b = r101;
            this.f37468c = r102;
            this.f37469d = r103;
            this.f37470e = r104;
            this.f37471f = r105;
        }
    }

    public final AIPackageDeployment.AIPackageDeploymentItem d() {
        AIPackageDeployment.AIPackageDeploymentItem r100 = this.f37461c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("deploymentInfo");
        return null;
    }

    public final AIPackage e() {
        AIPackage r100 = this.f37459a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("oldAIPackage");
        return null;
    }

    public final boolean k() {
        String r100 = com.bytedance.ai.resource.core.a.f37325a;
        return e.b(com.bytedance.ai.resource.core.a.f(d()), com.bytedance.ai.resource.core.a.e(d()));
    }

    public AbsAIPackageOperation() {
        this.f37462d = new AtomicBoolean(false);
        this.f37464f = new CopyOnWriteArraySet();
        this.f37465g = new CopyOnWriteArraySet();
    }

    public AIPackage.PackageStatus j() {
        return AIPackage.PackageStatus.READY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0146 -> B:49:0x0149). Please report as a decompilation issue!!! */
    public final Object c(Continuation<? super Boolean> r110) {
        if ((r110 instanceof AbsAIPackageOperation$download$1) == false) goto L7;
        AbsAIPackageOperation$download$1 r100 = (AbsAIPackageOperation$download$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        Iterator r105 = (Iterator) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L49:
        boolean r112 = ((Boolean) r111).booleanValue();
        if (r112 == false) goto L52;
        r104 = r112;
    L57:
        return Boxing.boxBoolean(r104);
    L52:
        String r113 = r106;
        boolean r107 = r112;
    L53:
        String r114 = r113;
        if (r105.hasNext() == false) goto L54;
        String r108 = (String) r105.next();
        int r109 = com.bytedance.ai.resource.a.f37290a;
        r100.L$0 = r114;
        r100.L$1 = r105;
        r100.label = 1;
        Object r115 = com.bytedance.ai.resource.a.a(r108, r114, r100);
        if (r115 != r102) goto L48;
        return r102;
    L48:
        r106 = r114;
        r111 = r115;
        goto L49
    L54:
        r104 = r107;
        goto L57
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        ?? r116 = d().getResourceUrls();
        r107 = false;
        if (r116 != 0) goto L29;
        r116 = new ArrayList();
        AppletResourceTool r117 = AppletResourceTool.f37276a;
        AIPackageDeployment.AIPackageDeploymentItem r118 = d();
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "<this>");
        if (r118.getResourceUrl().length() <= 0) goto L19;
        boolean r119 = true;
    L20:
        if (r119 == false) goto L22;
        int r120 = com.bytedance.ai.utils.a.f37625a;
        String r121 = com.bytedance.ai.utils.a.C0714a.a() + '/' + r118.getResourceUrl();
    L24:
        if (r121.length() <= 0) goto L26;
        boolean r122 = true;
    L27:
        if (r122 == false) goto L29;
        r116.add(r121);
        goto L29
    L26:
        r122 = false;
        goto L27
    L22:
        r121 = "";
        goto L24
    L19:
        r119 = false;
    L29:
        String r123 = com.bytedance.ai.resource.core.a.f37325a;
        String r124 = com.bytedance.ai.resource.core.a.f(d());
        if (r116.isEmpty() == false) goto L32;
    L58:
        g.f37637a.e("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> The download url and destination file are empty");
        return Boxing.boxBoolean(false);
    L32:
        if (r124.length() != 0) goto L34;
        boolean r125 = true;
    L35:
        if (r125 == true) goto L58;
        g r126 = g.f37637a;
        r126.i("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> Start downloading " + r124);
        String r127 = d().getPackageName();
        Intrinsics.checkNotNullParameter(r127, "packageName");
        String r128 = com.bytedance.ai.resource.core.a.f37325a + '/' + r127;
        f.h(r128);
        if (f.a(r124) == false) goto L40;
    L55:
        r126.d("AIPackageManager", "packageName: " + d().getPackageName() + ", appId: " + d().getAppId() + " ===> The " + r124 + " already exists");
        goto L57
    L40:
        if (f.l(r124, d().getPackageName()) == true) goto L55;
        r113 = r128;
        r105 = r116.iterator();
        goto L53
    L34:
        r125 = false;
    L7:
        r100 = new AbsAIPackageOperation$download$1(this, r110);
        goto L8
    }

    public final void f(AIPackageManager.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f37462d.get() == false) goto L7;
        a r101 = this.f37463e;
        if (r101 == null) goto L9;
        r100.a(r101.f37466a, r101.f37467b, r101.f37468c, r101.f37469d, r101.f37470e, r101.f37471f);
        return;
    L9:
        return;
    L7:
        this.f37464f.add(r100);
    }

    public Object g(Continuation<? super a> r100) {
        return new a(null, null, null, null, 0, 63);
    }

    public final void h(AIPackageDeployment.AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f37461c = r100;
    }

    public final void i(AIPackage r100) {
        Intrinsics.checkNotNullParameter(r100, "oldPackage");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f37459a = r100;
    }

    public final AIPackage a(AIPackageManifestBean r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manifestBean");
        Intrinsics.checkNotNullParameter(r101, ForwardDependency$ForwardLocation.FLAG);
        Applet r102 = com.bytedance.ai.resource.core.bean.a.a(r100);
        if (r102 == null) goto L12;
        AIPackageManifestBean.AppletBean r103 = r100.getApplet();
        if (r103 == null) goto L7;
        String r104 = r103.getAppletId();
    L9:
        if (Intrinsics.areEqual(r104, d().getAppId()) == false) goto L12;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f36915v = r101;
        r102.D = r100.getHasKeyStore();
        r102.E = r100.getVerifySignature();
        return r102;
    L7:
        r104 = null;
    L12:
        List<Widget> r105 = com.bytedance.ai.resource.core.bean.a.b(r100);
        if (r105 == null) goto L21;
        Iterator r106 = ((ArrayList) r105).iterator();
    L16:
        if (r106.hasNext() == false) goto L21;
        Widget r107 = (Widget) r106.next();
        if (Intrinsics.areEqual(r107.K, d().getAppId()) == false) goto L16;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r107.f36915v = r101;
        r107.D = r100.getHasKeyStore();
        r107.E = r100.getVerifySignature();
        return r107;
    L21:
        return null;
    }

    public static a b(AbsAIPackageOperation r100, AIPackage r101, int r110) {
        r100.getClass();
        String r102 = r100.d().getPackageName();
        String r103 = r100.d().getAppId();
        if (r101 == null) goto L6;
        AIPackage.AIPackageType r104 = r101.c();
        if (r104 == null) goto L6;
    L8:
        return new a(r101, r102, r103, r104, r110, null);
    L6:
        r104 = AIPackage.AIPackageType.UNKNOWN;
        goto L8
    }
}
