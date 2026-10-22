package com.bytedance.ai.resource.core.db;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AIPackageDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f37335a;

    public abstract Object A(Continuation<? super List<Applet>> r100);

    public abstract Object B(String r100, Continuation<? super List<Applet>> r101);

    public abstract Object C(String r100, long r101, ContinuationImpl r102);

    public abstract Object D(Continuation<? super List<? extends Widget>> r100);

    public abstract Object E(String r100, Continuation<? super List<? extends Widget>> r101);

    public abstract Object I(String r100, String r101, String r102, long r103, Continuation<? super Widget> r104);

    public abstract Object J(String r100, String r101, String r102, ContinuationImpl r103);

    public abstract Object K(String r100, String r101, Continuation<? super List<? extends Widget>> r102);

    public abstract Object L(Continuation<? super List<? extends Widget>> r100);

    public abstract Object N(Applet[] r100, ContinuationImpl r101);

    public abstract Object O(Widget[] r100, ContinuationImpl r101);

    public abstract Object b(Applet r100, Continuation<? super Unit> r101);

    public abstract Object c(String r100, String r101, Continuation<? super Unit> r102);

    public abstract Object d(List r100, ContinuationImpl r101);

    public abstract Object e(Widget r100, Continuation<? super Unit> r101);

    public abstract Object f(String r100, String r101, Continuation<? super Unit> r102);

    public abstract Object g(List r100, ContinuationImpl r101);

    public abstract Object h(Applet r100, ContinuationImpl r101);

    public abstract Object l(Widget r100, ContinuationImpl r101);

    public abstract Object m(String r100, String r101, Continuation<? super Unit> r102);

    public abstract Object n(String r100, String r101, Continuation<? super Unit> r102);

    public abstract Object o(Continuation<? super List<Applet>> r100);

    public abstract Object p(Continuation<? super List<? extends Widget>> r100);

    public abstract Object q(Continuation r100);

    public abstract Object r(String r100, String r101, String r102, long r103, Continuation<? super Applet> r104);

    public abstract Object s(String r100, String r101, String r102, ContinuationImpl r103);

    public abstract Object t(String r100, String r101, Continuation<? super List<Applet>> r102);

    public abstract Object u(Continuation<? super List<Applet>> r100);

    public abstract Object v(String r100, Continuation<? super List<Applet>> r101);

    public abstract Object w(Continuation<? super List<Applet>> r100);

    public abstract Object x(String r100, Continuation<? super List<? extends Widget>> r101);

    public abstract Object y(Continuation<? super List<? extends Widget>> r100);

    public abstract Object z(String r100, long r101, ContinuationImpl r102);

    public AIPackageDao() {
        this.f37335a = "AIPackageDao";
    }

    public Object i(Applet r100, Continuation<? super Unit> r101) {
        Object r102 = j(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object j(AIPackage r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof AIPackageDao$insertInactivePackage$1) == false) goto L7;
        AIPackageDao$insertInactivePackage$1 r100 = (AIPackageDao$insertInactivePackage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r103 = true;
        switch(r100.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r112);
    L71:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r112);
    L66:
        return Unit.INSTANCE;
    L14:
        Iterator r113 = (Iterator) r100.L$2;
        AIPackage.AIPackageType r104 = (AIPackage.AIPackageType) r100.L$1;
        AIPackage r105 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L15:
        AIPackage.AIPackageType r114 = r104;
        AIPackage r106 = r105;
    L53:
        if (r113.hasNext() == false) goto L59;
        AIPackage r107 = (AIPackage) r113.next();
        if (Intrinsics.areEqual(r107.f36907n, r106.f36907n) == true) goto L53;
        long r108 = r107.f36896c;
        String r109 = r107.a();
        String r115 = r107.f36895b;
        String r116 = r107.f36907n;
        r100.L$0 = r106;
        r100.L$1 = r114;
        r100.L$2 = r113;
        r100.label = 5;
        if (a(r108, r109, r115, r116, r100) != r102) goto L53;
        return r102;
    L59:
        AIPackage.AIPackageType r117 = r114;
        AIPackage r118 = r106;
    L61:
        if (r117 != AIPackage.AIPackageType.APPLET) goto L67;
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 6;
        if (h((Applet) r118, r100) != r102) goto L66;
        return r102;
    L67:
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 7;
        if (l((Widget) r118, r100) != r102) goto L71;
        return r102;
    L16:
        List r119 = (List) r100.L$2;
        r104 = (AIPackage.AIPackageType) r100.L$1;
        r105 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L51:
        r113 = r119.iterator();
        goto L15
    L17:
        r117 = (AIPackage.AIPackageType) r100.L$1;
        r118 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L34:
        List r120 = (List) r112;
    L35:
        List r121 = r120;
        if (r121 != null) goto L38;
    L41:
        if (r103 == true) goto L61;
        if (r117 != AIPackage.AIPackageType.APPLET) goto L47;
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ai.model.objects.Applet>");
        r100.L$0 = r118;
        r100.L$1 = r117;
        r100.L$2 = r120;
        r100.label = 3;
        if (d(r120, r100) != r102) goto L50;
        return r102;
    L50:
        r105 = r118;
        r104 = r117;
        r119 = r120;
        goto L51
    L47:
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ai.model.objects.Widget>");
        r100.L$0 = r118;
        r100.L$1 = r117;
        r100.L$2 = r120;
        r100.label = 4;
        if (g(r120, r100) != r102) goto L50;
        return r102;
    L38:
        if (r121.isEmpty() == true) goto L41;
        r103 = false;
        goto L41
    L18:
        r117 = (AIPackage.AIPackageType) r100.L$1;
        r118 = (AIPackage) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L29:
        r120 = (List) r112;
        goto L35
    L19:
        ResultKt.throwOnFailure(r112);
        if (Intrinsics.areEqual(r110.f36915v, "inactive") == true) goto L23;
        com.bytedance.ai.utils.g.f37637a.e(this.f37335a, "insert inactive package failed! package status isn't inactive, unique id: " + r110.d());
        return Unit.INSTANCE;
    L23:
        AIPackage.AIPackageType r122 = r110.c();
        if (r122 != AIPackage.AIPackageType.APPLET) goto L30;
        String r123 = r110.a();
        String r124 = r110.f36895b;
        r100.L$0 = r110;
        r100.L$1 = r122;
        r100.label = 1;
        Object r125 = s(r123, r124, "inactive", r100);
        if (r125 != r102) goto L28;
        return r102;
    L28:
        r118 = r110;
        r117 = r122;
        r112 = r125;
        goto L29
    L30:
        String r126 = r110.a();
        String r127 = r110.f36895b;
        r100.L$0 = r110;
        r100.L$1 = r122;
        r100.label = 2;
        Object r128 = J(r126, r127, "inactive", r100);
        if (r128 != r102) goto L33;
        return r102;
    L33:
        r118 = r110;
        r117 = r122;
        r112 = r128;
        goto L34
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new AIPackageDao$insertInactivePackage$1(this, r111);
        goto L8
    }

    public Object k(Widget r100, Continuation<? super Unit> r101) {
        Object r102 = j(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public Object G(String r100, String r101, long r110, Continuation<? super Applet> r111) {
        Object r102 = F(r100, r101, AIPackage.AIPackageType.APPLET, r110, r111);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return (Applet) r102;
    }

    public Object H(String r100, String r101, long r110, Continuation<? super Widget> r111) {
        Object r102 = F(r100, r101, AIPackage.AIPackageType.WIDGET, r110, r111);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return (Widget) r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object F(String r110, String r111, AIPackage.AIPackageType r112, long r210, Continuation<? super AIPackage> r211) {
        AIPackage.AIPackageType r100 = r112;
        if ((r211 instanceof AIPackageDao$queryOrActiveAIPackage$1) == false) goto L7;
        AIPackageDao$queryOrActiveAIPackage$1 r101 = (AIPackageDao$queryOrActiveAIPackage$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r101.label) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r105 = r101.J$0;
        List r106 = (List) r101.L$3;
        AIPackage r107 = (AIPackage) r101.L$2;
        List r108 = (List) r101.L$1;
        AIPackage r109 = (AIPackage) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L149:
        long r113 = r105;
        List r114 = r108;
        AIPackage r115 = r109;
        AIPackage r116 = r107;
    L150:
        r116.f36906m = r113;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36600a), null, null, new AIPackageDao$queryOrActiveAIPackage$4(r115, r116, r114, this, null), 3, null);
        return r116;
    L13:
        long r117 = r101.J$1;
        long r118 = r101.J$0;
        r116 = (AIPackage) r101.L$3;
        r114 = (List) r101.L$2;
        r115 = (AIPackage) r101.L$1;
        AIPackage.AIPackageType r119 = (AIPackage.AIPackageType) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L124:
        r113 = r117;
    L129:
        r116.f36906m = r118;
        ArrayList r120 = new ArrayList();
        Iterator r121 = r114.iterator();
    L131:
        if (r121.hasNext() == false) goto L139;
        Object r122 = r121.next();
        if (((AIPackage) r122).f36906m == r113) goto L135;
        boolean r123 = true;
    L136:
        if (r123 == false) goto L131;
        r120.add(r122);
        goto L131
    L135:
        r123 = false;
        goto L136
    L139:
        if ((!r120.isEmpty()) == false) goto L150;
        if (r119 != AIPackage.AIPackageType.APPLET) goto L145;
        r101.L$0 = r115;
        r101.L$1 = r114;
        r101.L$2 = r116;
        r101.L$3 = r120;
        r101.J$0 = r113;
        r101.label = 5;
        if (d(r120, r101) != r104) goto L148;
        return r104;
    L148:
        r107 = r116;
        r108 = r114;
        r109 = r115;
        r105 = r113;
        goto L149
    L145:
        r101.L$0 = r115;
        r101.L$1 = r114;
        r101.L$2 = r116;
        r101.L$3 = r120;
        r101.J$0 = r113;
        r101.label = 6;
        if (g(r120, r101) != r104) goto L148;
        return r104;
    L14:
        long r124 = r101.J$0;
        r100 = (AIPackage.AIPackageType) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L31:
        List r125 = (List) r103;
    L26:
        r119 = r100;
        if (r124 != 0) goto L54;
        if (r125 == null) goto L72;
        Iterator r126 = r125.iterator();
    L37:
        if (r126.hasNext() == false) goto L52;
        Object r127 = r126.next();
        AIPackage r128 = (AIPackage) r127;
        if (Intrinsics.areEqual(r128.f36915v, "installed") == false) goto L41;
    L42:
        Integer r129 = r128.f36916w;
        if (r129 != null) goto L46;
    L48:
        boolean r130 = false;
    L49:
        if (r130 == false) goto L37;
    L53:
        AIPackage r131 = (AIPackage) r127;
    L71:
        r115 = r131;
    L74:
        if (r124 != 0) goto L90;
        if (r125 == null) goto L103;
        ArrayList r132 = new ArrayList();
        Iterator r133 = r125.iterator();
    L78:
        if (r133.hasNext() == false) goto L104;
        Object r134 = r133.next();
        AIPackage r135 = (AIPackage) r134;
        if (Intrinsics.areEqual(r135.f36915v, "inactive") == false) goto L87;
        Integer r136 = r135.f36916w;
        if (r136 == null) goto L87;
        if (r136.intValue() != 0) goto L87;
        boolean r137 = true;
    L88:
        if (r137 == false) goto L78;
        r132.add(r134);
    L87:
        r137 = false;
    L104:
        if (r132 != null) goto L106;
    L109:
        boolean r138 = true;
    L110:
        if (r138 == true) goto L152;
        r116 = (AIPackage) CollectionsKt.first(r132);
        r118 = r116.f36906m;
        if (r115 == null) goto L114;
        long r139 = r115.f36906m;
    L115:
        com.bytedance.ai.utils.g r140 = com.bytedance.ai.utils.g.f37637a;
        String r141 = this.f37335a;
        StringBuilder r142 = new StringBuilder("find inactive package: ");
        r142.append(r116.f36895b);
        r142.append(", appId: ");
        r142.append(r116.a());
        r142.append(", version code: ");
        long r143 = r139;
        r142.append(r116.f36896c);
        r142.append(" ===> update as installed package");
        r140.d(r141, r142.toString());
        if (r115 == null) goto L118;
        r116.f36906m = r115.f36906m;
    L118:
        Intrinsics.checkNotNullParameter("installed", "<set-?>");
        r116.f36915v = "installed";
        if (r119 != AIPackage.AIPackageType.APPLET) goto L125;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");
        Applet[] r144 = {r116};
        r101.L$0 = r119;
        r101.L$1 = r115;
        r101.L$2 = r132;
        r101.L$3 = r116;
        r101.J$0 = r118;
        r101.J$1 = r143;
        r101.label = 3;
        if (N(r144, r101) != r104) goto L123;
        return r104;
    L123:
        r114 = r132;
        r117 = r143;
        goto L124
    L125:
        r113 = r143;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");
        Widget[] r145 = {r116};
        r101.L$0 = r119;
        r101.L$1 = r115;
        r101.L$2 = r132;
        r101.L$3 = r116;
        r101.J$0 = r118;
        r101.J$1 = r113;
        r101.label = 4;
        if (O(r145, r101) != r104) goto L128;
        return r104;
    L128:
        r114 = r132;
        goto L129
    L114:
        r139 = r118;
        goto L115
    L152:
        return r115;
    L106:
        if (r132.isEmpty() == true) goto L109;
        r138 = false;
    L103:
        r132 = null;
        goto L104
    L90:
        if (r125 == null) goto L103;
        ArrayList r146 = new ArrayList();
        Iterator r147 = r125.iterator();
    L93:
        if (r147.hasNext() == false) goto L102;
        Object r148 = r147.next();
        AIPackage r149 = (AIPackage) r148;
        if (Intrinsics.areEqual(r149.f36915v, "inactive") == true) goto L97;
    L99:
        boolean r150 = false;
    L100:
        if (r150 == false) goto L93;
        r146.add(r148);
        goto L93
    L97:
        if (r149.f36896c != r124) goto L99;
        r150 = true;
        goto L100
    L102:
        r132 = r146;
        goto L104
    L46:
        if (r129.intValue() != 0) goto L48;
        r130 = true;
        goto L49
    L41:
        if (Intrinsics.areEqual(r128.f36915v, "") == false) goto L48;
    L52:
        r127 = null;
    L72:
        r115 = null;
        goto L74
    L54:
        if (r125 == null) goto L72;
        Iterator r151 = r125.iterator();
    L57:
        if (r151.hasNext() == false) goto L69;
        Object r152 = r151.next();
        AIPackage r153 = (AIPackage) r152;
        if (Intrinsics.areEqual(r153.f36915v, "installed") == true) goto L63;
        if (Intrinsics.areEqual(r153.f36915v, "") == true) goto L63;
    L65:
        boolean r154 = false;
    L66:
        if (r154 == false) goto L57;
    L70:
        r131 = (AIPackage) r152;
    L63:
        if (r153.f36896c != r124) goto L65;
        r154 = true;
        goto L66
    L69:
        r152 = null;
        goto L70
    L15:
        r124 = r101.J$0;
        r100 = (AIPackage.AIPackageType) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L25:
        r125 = (List) r103;
        goto L26
    L16:
        ResultKt.throwOnFailure(r103);
        if (r100 != AIPackage.AIPackageType.UNKNOWN) goto L20;
        return null;
    L20:
        if (r100 != AIPackage.AIPackageType.APPLET) goto L27;
        r101.L$0 = r100;
        r101.J$0 = r210;
        r101.label = 1;
        r103 = t(r110, r111, r101);
        if (r103 != r104) goto L24;
        return r104;
    L24:
        r124 = r210;
        goto L25
    L27:
        r101.L$0 = r100;
        r101.J$0 = r210;
        r101.label = 2;
        r103 = K(r110, r111, r101);
        if (r103 != r104) goto L30;
        return r104;
    L30:
        r124 = r210;
        goto L31
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r101 = new AIPackageDao$queryOrActiveAIPackage$1(this, r211);
        goto L8
    }

    public final Object M(long r310, String r311, String r312, String r313, Continuation<? super List<String>> r314) {
        AIPackageDao r100 = this;
        long r110 = r310;
        if ((r314 instanceof AIPackageDao$renameOutdatedFile$1) == false) goto L7;
        AIPackageDao$renameOutdatedFile$1 r101 = (AIPackageDao$renameOutdatedFile$1) r314;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AIPackageDao$renameOutdatedFile$1 r111 = r101;
        Object r103 = r111.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r111.label;
        boolean r113 = false;
        String r105 = ": ";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r106 = r111.J$0;
        List r107 = (List) r111.L$3;
        AIPackageDeployment.AIPackageDeploymentItem r108 = (AIPackageDeployment.AIPackageDeploymentItem) r111.L$2;
        String r109 = (String) r111.L$1;
        String r114 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
        String r115 = r109;
        AIPackageDeployment.AIPackageDeploymentItem r116 = r108;
    L34:
        List r117 = (List) r103;
        Object r118 = null;
        if (r117 == null) goto L43;
        Iterator r119 = r117.iterator();
    L38:
        if (r119.hasNext() == false) goto L42;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((Widget) r120).K, r114) == false) goto L38;
        r118 = r120;
    L42:
        r118 = (Widget) r118;
    L43:
        if (r118 == null) goto L46;
        com.bytedance.ai.utils.g.f37637a.w(r100.f37335a, r115 + r105 + r114 + r105 + r106 + ": the same version is installed again. skip removing files");
        return r107;
    L46:
        List r121 = r117;
        if (r121 != null) goto L49;
    L50:
        r113 = true;
    L52:
        if (r113 == false) goto L59;
        String r122 = com.bytedance.ai.resource.core.a.b(r116);
        Intrinsics.checkNotNullParameter(r116, "deploymentInfo");
        String r123 = com.bytedance.ai.resource.core.a.f37325a + '/' + r116.getPackageName() + "/base_" + r116.getVersionCode() + "_delete.zip";
        if (com.bytedance.ai.utils.f.i(r122, r123) == false) goto L56;
        com.bytedance.ai.utils.g.f37637a.d(r100.f37335a, "add " + r123 + " into the delete list");
        r107.add(r123);
    L56:
        String r124 = com.bytedance.ai.resource.core.a.a(r116);
        Intrinsics.checkNotNullParameter(r116, "deploymentInfo");
        String r125 = com.bytedance.ai.resource.core.a.f37325a + '/' + r116.getPackageName() + "/base_" + r116.getVersionCode() + "_delete";
        if (com.bytedance.ai.utils.f.i(r124, r125) == false) goto L59;
        com.bytedance.ai.utils.g.f37637a.d(r100.f37335a, "add " + r125 + " into the delete list");
        r107.add(r125);
    L59:
        String r126 = com.bytedance.ai.resource.core.a.f(r116);
        Intrinsics.checkNotNullParameter(r116, "deploymentInfo");
        String r127 = com.bytedance.ai.resource.core.a.f(r116) + "_delete";
        if (com.bytedance.ai.utils.f.i(r126, r127) == false) goto L62;
        com.bytedance.ai.utils.g.f37637a.d(r100.f37335a, "add " + r127 + " into the delete list");
        r107.add(r127);
    L62:
        String r128 = com.bytedance.ai.resource.core.a.e(r116);
        Intrinsics.checkNotNullParameter(r116, "deploymentInfo");
        String r129 = com.bytedance.ai.resource.core.a.e(r116) + "_delete";
        if (com.bytedance.ai.utils.f.i(r128, r129) == false) goto L65;
        com.bytedance.ai.utils.g.f37637a.d(r100.f37335a, "add " + r129 + " into the delete list");
        r107.add(r129);
    L65:
        return r107;
    L49:
        if (r121.isEmpty() == false) goto L52;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r130 = r111.J$0;
        r107 = (List) r111.L$3;
        AIPackageDeployment.AIPackageDeploymentItem r131 = (AIPackageDeployment.AIPackageDeploymentItem) r111.L$2;
        String r132 = (String) r111.L$1;
        String r133 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
        r110 = r130;
        AIPackageDeployment.AIPackageDeploymentItem r134 = r131;
        Object r135 = r112;
        AIPackageDao$renameOutdatedFile$1 r136 = r111;
    L20:
        List r137 = (List) r103;
        if (r137 != null) goto L23;
    L26:
        boolean r138 = true;
    L27:
        if (r138 == true) goto L30;
        com.bytedance.ai.utils.g.f37637a.w(r100.f37335a, r132 + ": " + r133 + ": " + r110 + ": the same version is installed again. skip removing files");
        return r107;
    L30:
        r105 = r105;
        r136.L$0 = r133;
        r136.L$1 = r132;
        r136.L$2 = r134;
        r136.L$3 = r107;
        r136.J$0 = r110;
        r136.label = 2;
        r103 = r100.C(r132, r110, r136);
        if (r103 != r135) goto L33;
        return r135;
    L33:
        r115 = r132;
        r114 = r133;
        r116 = r134;
        r106 = r110;
        goto L34
    L23:
        if (r137.isEmpty() == true) goto L26;
        r138 = false;
        goto L27
    L16:
        ResultKt.throwOnFailure(r103);
        AIPackageDeployment.AIPackageDeploymentItem r139 = new AIPackageDeployment.AIPackageDeploymentItem(r311, r312, r310, null, r313, null, false, null, null, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_MC_REUSE, null);
        ArrayList r140 = new ArrayList();
        r136 = r111;
        r136.L$0 = r311;
        r136.L$1 = r312;
        r136.L$2 = r139;
        r136.L$3 = r140;
        r136.J$0 = r110;
        r136.label = 1;
        r132 = r312;
        r100 = this;
        Object r141 = r100.z(r132, r110, r136);
        r135 = r112;
        if (r141 != r135) goto L19;
        return r135;
    L19:
        r133 = r311;
        r134 = r139;
        r107 = r140;
        r103 = r141;
    L7:
        r101 = new AIPackageDao$renameOutdatedFile$1(r100, r314);
        goto L8
    }

    public final Object a(long r310, String r311, String r312, String r313, Continuation<? super Unit> r314) {
        AIPackageDao r100 = this;
        long r110 = r310;
        if ((r314 instanceof AIPackageDao$cleanOutdatedFile$1) == false) goto L7;
        AIPackageDao$cleanOutdatedFile$1 r101 = (AIPackageDao$cleanOutdatedFile$1) r314;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AIPackageDao$cleanOutdatedFile$1 r111 = r101;
        Object r103 = r111.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r111.label;
        boolean r113 = false;
        String r105 = ", digest: ";
        String r106 = ", version code: ";
        String r107 = ", packageName: ";
        String r108 = ", appId: ";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r109 = r111.J$0;
        AIPackageDeployment.AIPackageDeploymentItem r114 = (AIPackageDeployment.AIPackageDeploymentItem) r111.L$3;
        String r115 = (String) r111.L$2;
        String r116 = (String) r111.L$1;
        String r117 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
        r108 = ", appId: ";
        AIPackageDeployment.AIPackageDeploymentItem r118 = r114;
        r107 = ", packageName: ";
        r106 = ", version code: ";
        r105 = ", digest: ";
    L32:
        Collection r119 = (Collection) r103;
        if (r119 != null) goto L35;
    L36:
        r113 = true;
    L37:
        if (r113 == false) goto L39;
        boolean r120 = com.bytedance.ai.utils.f.d(com.bytedance.ai.resource.core.a.b(r118));
        com.bytedance.ai.utils.g r121 = com.bytedance.ai.utils.g.f37637a;
        String r122 = r100.f37335a;
        StringBuilder r123 = new StringBuilder("cleaning base zip. result: ");
        r123.append(r120);
        String r124 = r108;
        r123.append(r124);
        r123.append(r117);
        String r125 = r107;
        r123.append(r125);
        r123.append(r116);
        String r126 = r106;
        r123.append(r126);
        r123.append(r109);
        String r127 = r105;
        r123.append(r127);
        r123.append(r115);
        r121.d(r122, r123.toString());
        boolean r128 = com.bytedance.ai.utils.f.c(com.bytedance.ai.resource.core.a.a(r118));
        r121.d(r100.f37335a, "cleaning base dir. result: " + r128 + r124 + r117 + r125 + r116 + r126 + r109 + r127 + r115);
    L40:
        r110 = r109;
        String r129 = r116;
        String r130 = r127;
        String r131 = r126;
        String r132 = r115;
        String r133 = r117;
    L42:
        boolean r134 = com.bytedance.ai.utils.f.d(com.bytedance.ai.resource.core.a.f(r118));
        com.bytedance.ai.utils.g r135 = com.bytedance.ai.utils.g.f37637a;
        r135.d(r100.f37335a, "cleaning package zip, result: " + r134 + r124 + r133 + r125 + r129 + r131 + r110 + r130 + r132);
        boolean r136 = com.bytedance.ai.utils.f.c(com.bytedance.ai.resource.core.a.e(r118));
        r135.d(r100.f37335a, "cleaning package dir, result: " + r136 + r124 + r133 + r125 + r129 + r131 + r110 + r130 + r132);
        return Unit.INSTANCE;
    L39:
        r124 = r108;
        r125 = r107;
        r126 = r106;
        r127 = r105;
        goto L40
    L35:
        if (r119.isEmpty() == false) goto L37;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r137 = r111.J$0;
        AIPackageDeployment.AIPackageDeploymentItem r138 = (AIPackageDeployment.AIPackageDeploymentItem) r111.L$3;
        r132 = (String) r111.L$2;
        String r139 = (String) r111.L$1;
        String r140 = (String) r111.L$0;
        ResultKt.throwOnFailure(r103);
        r118 = r138;
        Object r141 = r112;
        r129 = r139;
        Object r142 = r103;
        r133 = r140;
        r110 = r137;
        AIPackageDao$cleanOutdatedFile$1 r143 = r111;
    L20:
        Collection r144 = (Collection) r142;
        if (r144 != null) goto L23;
    L26:
        boolean r145 = true;
    L27:
        if (r145 == false) goto L41;
        r143.L$0 = r133;
        r143.L$1 = r129;
        r143.L$2 = r132;
        r143.L$3 = r118;
        r143.J$0 = r110;
        r143.label = 2;
        Object r146 = r100.C(r129, r110, r143);
        if (r146 != r141) goto L31;
        return r141;
    L31:
        r117 = r133;
        r103 = r146;
        r116 = r129;
        r115 = r132;
        r109 = r110;
        goto L32
    L41:
        r124 = r108;
        r125 = r107;
        r131 = r106;
        r130 = r105;
        goto L42
    L23:
        if (r144.isEmpty() == true) goto L26;
        r145 = false;
        goto L27
    L16:
        ResultKt.throwOnFailure(r103);
        AIPackageDeployment.AIPackageDeploymentItem r147 = new AIPackageDeployment.AIPackageDeploymentItem(r311, r312, r310, null, r313, null, false, null, null, TTVideoEngineInterface.PLAYER_OPTION_DISABLE_MC_REUSE, null);
        r133 = r311;
        r143 = r111;
        r143.L$0 = r133;
        r143.L$1 = r312;
        r143.L$2 = r313;
        r118 = r147;
        r143.L$3 = r118;
        r143.J$0 = r110;
        r143.label = 1;
        r129 = r312;
        r100 = this;
        r142 = r100.z(r129, r110, r143);
        r141 = r112;
        if (r142 != r141) goto L19;
        return r141;
    L19:
        r132 = r313;
    L7:
        r101 = new AIPackageDao$cleanOutdatedFile$1(r100, r314);
        goto L8
    }
}
