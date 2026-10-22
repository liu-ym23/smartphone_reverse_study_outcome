package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftMVITopView extends com.bytedance.android.anya.e<GiftPanelState, GiftTopViewState, GiftAction> {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final q1 f127631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f127632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f127633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f127634n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f127635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public AnimatorSet f127636p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AnimatorSet f127637q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f127638r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Set<GiftTopViewState.Mode> f127639s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f127640t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f127641u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<GiftTopViewState.Mode, Pair<ViewGroup, BaseGiftMVIViewChildNode<GiftTopViewState, ?, ?>>> f127642v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f127643w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ViewGroup f127644x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ViewGroup f127645y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DataCenter f127646z;

    public static final class a {
    }

    static {
    }

    public final View s() {
        return (View) this.f127641u.getValue();
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        AnimatorSet r100 = this.f127637q;
        if (r100 != null) goto L5;
    L19:
        q1 r101 = this.f127631k;
        if (com.bytedance.android.scope.l.b(r101) == true) goto L23;
        r101 = null;
    L23:
        if (r101 == null) goto L31;
        com.bytedance.android.scope.l.c(r101);
        return;
    L31:
        return;
    L5:
        if (r100.isRunning() != true) goto L19;
        AnimatorSet r102 = this.f127637q;
        if (r102 == null) goto L9;
        r102.end();
    L9:
        AnimatorSet r103 = this.f127637q;
        if (r103 == null) goto L19;
        ArrayList<Animator> r104 = r103.getChildAnimations();
        if (r104 == null) goto L19;
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        Animator r106 = (Animator) r105.next();
        if ((r106 instanceof ValueAnimator) == false) goto L15;
        r106.removeAllListeners();
        goto L15
    }

    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final Collection<com.bytedance.android.anya.z<GiftTopViewState, ?, ?>> p() {
        final ArrayList r100 = new ArrayList();
        com.bytedance.android.scope.m r101 = com.bytedance.android.scope.m.f163449e;
        q1 r102 = this.f127631k;
        Function1<Sequence<? extends com.bytedance.android.scope.o>, Unit> r103 = new GiftMVITopView$childNodes$$inlined$apply$lambda$1(r100, this);
        r101.getClass();
        com.bytedance.android.scope.m.f(r102, r103);
        return r100;
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void g() {
        s().setVisibility(0);
        this.f127633m = s().findViewById(R.id.close_btn_view);
        this.f127635o = s().findViewById(R.id.close_btn_img);
        this.f127634n = s().findViewById(R.id.top_gift_divider);
        this.f127640t = this.f127644x.findViewById(R.id.top_gift_divider_top);
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == false) goto L10;
        View r100 = s();
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.preview.view.s.a(r100, com.bytedance.android.live.revenue.common.i.b(58));
    L7:
        View r101 = this.f127640t;
        if (r101 == null) goto L10;
        r101.setVisibility(0);
    L10:
        DataCenter r102 = this.f127646z;
        Boolean r103 = Boolean.TRUE;
        Boolean r104 = (Boolean) r102.get("data_is_portrait", r103);
        if (r104 == null) goto L13;
        boolean r105 = r104.booleanValue();
    L14:
        int r106 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        if ((!r105) == false) goto L25;
        View r107 = this.f127633m;
        if (r107 == null) goto L19;
        r107.setBackground(null);
    L19:
        View r108 = this.f127633m;
        if (r108 == null) goto L22;
        r108.setBackgroundColor(s1.h(R.color.ttlive_transparent));
    L22:
        View r109 = this.f127634n;
        if (r109 == null) goto L25;
        r109.setBackground(s1.m(R.drawable.ttlive_bg_gift_panel_divider));
    L25:
        Boolean r110 = (Boolean) this.f127646z.get("data_is_portrait", r103);
        if (r110 == null) goto L28;
        boolean r111 = r110.booleanValue();
    L30:
        if (r111 == false) goto L34;
        View r112 = this.f127634n;
        if (r112 == null) goto L37;
        r112.setVisibility(8);
    L37:
        View r113 = this.f127633m;
        if (r113 == null) goto L40;
        r113.setOnClickListener(new c1(this));
    L40:
        View r114 = this.f127633m;
        if (r114 == null) goto L43;
        r114.setVisibility(8);
    L43:
        View r115 = this.f127635o;
        if (r115 == null) goto L46;
        r115.setVisibility(8);
    L46:
        r3.a(this.f127633m, s1.B(R.string.ttlive_a11y_close));
        return;
    L34:
        View r116 = this.f127634n;
        if (r116 == null) goto L37;
        r116.setVisibility(0);
        goto L37
    L28:
        r111 = false;
        goto L30
    L13:
        r105 = false;
        goto L14
    }

    @Override // com.bytedance.android.anya.z
    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindToParent");
        GiftMVITopView$bindToParent$1 r101 = GiftMVITopView$bindToParent$1.INSTANCE;
        Collection r102 = r100.f41595a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new com.bytedance.android.anya.dsl.j(this, r101));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v33 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.bytedance.android.anya.BaseMVIComposableView
    public final void q(com.bytedance.android.anya.k r21, com.bytedance.android.anya.MVIState r22, kotlin.jvm.functions.Function1 r23) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r4v33 boolean
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            Method dump skipped, instruction units count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.GiftMVITopView.q(com.bytedance.android.anya.k, com.bytedance.android.anya.MVIState, kotlin.jvm.functions.Function1):void");
    }

    public GiftMVITopView(Context r100, ViewGroup r101, ViewGroup r102, DataCenter r103) {
        Intrinsics.checkNotNullParameter(r100, "currentContext");
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r103, "dataCenter");
        this.f127643w = r100;
        this.f127644x = r101;
        this.f127645y = r102;
        this.f127646z = r103;
        com.bytedance.android.scope.m.f163449e.getClass();
        q1 r104 = new q1(com.bytedance.android.scope.m.f163448d);
        Intrinsics.checkNotNullParameter(r104, "scope");
        Intrinsics.checkNotNullParameter(r100, "value");
        r104.f127969e = r100;
        if (r100 != e33.k.f470908a) goto L5;
        String r105 = PerfLog.PARAM_KEY_CONTEXT_ID;
    L6:
        if (r105 != null) goto L10;
        com.bytedance.android.scope.l.a(r104);
        Unit r106 = Unit.INSTANCE;
        this.f127631k = r104;
        this.f127639s = new LinkedHashSet();
        this.f127641u = LazyKt.lazy(new GiftMVITopView$contentView$2(this));
        this.f127642v = new LinkedHashMap();
        return;
    L10:
        throw new UninitializedPropertyAccessException(r105);
    L5:
        r105 = null;
        goto L6
    }
}
