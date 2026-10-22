package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.GiftTabTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTabItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ScrollGuideState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.TopicLabelStatus;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftTabViewHolder extends BaseMVIListItem<GiftTabItem, GiftAction> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f127778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TopicLabelStatus f127779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ScrollGuideState f127780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f127781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f127782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f127783q;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftTabViewHolder f127784a;

        public a(GiftTabViewHolder r100) {
            this.f127784a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            GiftTabViewHolder r101 = this.f127784a;
            r101.o(new ClickTabItem(r101.p(), 0, false, 6, null));
            ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).sendEventToAllJsBridges("giftPanelTabChanged", new LinkedHashMap());
        }
    }

    public static final class b {
    }

    static {
    }

    public final GiftTabTextView q() {
        return (GiftTabTextView) this.f127778l.getValue();
    }

    public final void r() {
        StringBuilder r100 = new StringBuilder();
        r100.append(q().getText());
        r100.append("按钮");
        if (this.f127783q == false) goto L5;
        int r101 = this.f127781o;
    L7:
        if (this.f127782p == false) goto L19;
        r100.append(", ");
        Map<Integer, Integer> r102 = tz1.a.f548041a;
        if (r101 != 0) goto L11;
        String r103 = "默认排序";
    L18:
        r100.append(r103);
        goto L19
    L11:
        if (r101 != 1) goto L13;
        r103 = "按价格从低到高排序";
        goto L18
    L13:
        if (r101 == 2) goto L15;
        r103 = "";
        goto L18
    L15:
        r103 = "按价格从高到低排序";
    L19:
        String r104 = r100.toString();
        r3.d(this.f41534j, r104, this.f127783q, false);
        return;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        GiftTabTextView r100 = q();
        ObjectAnimator r101 = r100.f126611f;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRunning() == false) goto L9;
        r100.f126611f.cancel();
        return;
    }

    public GiftTabViewHolder(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "inflateView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super(r100, new GiftTabItem());
        this.f127778l = LazyKt.lazy(new GiftTabViewHolder$giftTabTextView$2(this));
        this.f127779m = TopicLabelStatus.ARROW_GONE;
        this.f127780n = new ScrollGuideState(null, null, null, 7, null);
        q().setGravity(48);
        q().setTextSize(14.0f);
        this.f41534j.setOnClickListener(new a(this));
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
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v41 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r12, com.bytedance.android.anya.MVIState r13) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v41 boolean
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
            Method dump skipped, instruction units count: 968
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.GiftTabViewHolder.b(com.bytedance.android.anya.k, com.bytedance.android.anya.MVIState):void");
    }
}
