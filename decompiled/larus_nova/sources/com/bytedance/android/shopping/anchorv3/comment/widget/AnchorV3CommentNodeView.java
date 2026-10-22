package com.bytedance.android.shopping.anchorv3.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.viewholder.CommentItemVideoVH;
import com.bytedance.android.ui.base.widget.round.RoundLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/widget/AnchorV3CommentNodeView;", "Landroid/widget/LinearLayout;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "dy", "", "listener", "setRvScrollListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3CommentNodeView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentHeaderView f164564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentReplyView f164565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f164566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f164567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f164568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f164569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CommentInteractiveView f164570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f164571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECDraweeView f164572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<CommentItemVideoVH> f164573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f164574k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<CommentAppendLayout> f164575l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f164576m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv3.commentv2.model.c f164577n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv3.comment.a f164578o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Integer, Unit> f164579p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RoundLinearLayout f164580q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f164581r;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV3CommentNodeView f164582a;

        public a(AnchorV3CommentNodeView r100) {
            this.f164582a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorV3CommentNodeView r100 = this.f164582a;     // Catch: Throwable -> L4
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L4
            r101.width = -1;     // Catch: Throwable -> L4
            r101.height = -2;     // Catch: Throwable -> L4
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L4
            r100.setLayoutParams(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV3CommentNodeView f164583a;

        public c(AnchorV3CommentNodeView r100) {
            this.f164583a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv3.comment.widget.l
        public final void a(CommentItemVideoVH r100) {
            Intrinsics.checkNotNullParameter(r100, "videoViewHolder");
            if (((ArrayList) this.f164583a.f164573j).contains(r100) == true) goto L6;
            ((ArrayList) this.f164583a.f164573j).add(r100);
            return;
        }
    }

    public AnchorV3CommentNodeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3CommentNodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    static {
        new ArrayList();
    }

    public final boolean a() {
        if (((ArrayList) this.f164573j).isEmpty() == false) goto L5;
        return false;
    L5:
        List r100 = CollectionsKt.mutableListOf(new Integer[]{null});
        List<CommentAppendLayout> r101 = this.f164575l;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(Integer.valueOf(((CommentAppendLayout) r103.next()).getViewTopInScreen()));
        goto L7
    L9:
        r100.addAll(r102);
        long r104 = getContext().getResources().getDimensionPixelOffset(R.dimen.commerce_comment_titlebar_height);
        com.bytedance.android.shopping.anchorv3.commentv2.model.c r105 = this.f164577n;
        if (r105 == null) goto L12;
        r105.e();
    L12:
        long r106 = r104 + 0;
        int r107 = k1.j(getContext());
        com.bytedance.android.shopping.anchorv3.commentv2.model.c r108 = this.f164577n;
        if (r108 == null) goto L17;
        CommentParams r109 = r108.a();
        if (r109 == null) goto L17;
        int r110 = r109.getMarginBottom();
    L18:
        int r111 = r107 - r110;
        Iterator r112 = r100.iterator();
        int r113 = 0;
        boolean r114 = false;
    L20:
        if (r112.hasNext() == false) goto L46;
        Integer r115 = (Integer) r112.next();
        if (r115 == null) goto L24;
        int r116 = r115.intValue();
    L26:
        if (r116 <= r106) goto L32;
        if (r115 == null) goto L29;
        int r117 = r115.intValue();
    L30:
        if (r117 >= r111) goto L32;
        boolean r118 = true;
    L33:
        if (r118 == true) goto L35;
    L37:
        r114 = false;
    L38:
        if (r114 == true) goto L40;
        r113 = r113 + 1;
        goto L20
    L40:
        if (this.f164574k == r113) goto L42;
    L44:
        c();
        ((CommentItemVideoVH) ListProtector.get(this.f164573j, r113)).f164561a.b(false);
        this.f164574k = r113;
        goto L46
    L42:
        if (((CommentItemVideoVH) ListProtector.get(this.f164573j, r113)).f164561a.isPlaying() == false) goto L44;
        return true;
    L35:
        if (r113 >= ((ArrayList) this.f164573j).size()) goto L37;
        r114 = true;
        goto L38
    L29:
        r117 = 0;
    L32:
        r118 = false;
        goto L33
    L24:
        r116 = 0;
    L46:
        if (r114 == true) goto L48;
        c();
    L48:
        return r114;
    L17:
        r110 = 0;
        goto L18
    }

    public final void c() {
        int r100 = this.f164574k;
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 < ((ArrayList) this.f164573j).size()) goto L7;
        return;
    L7:
        if (((CommentItemVideoVH) ListProtector.get(this.f164573j, this.f164574k)).f164561a.isPlaying() == false) goto L13;
        ((CommentItemVideoVH) ListProtector.get(this.f164573j, this.f164574k)).f164561a.pause();
        this.f164574k = -1;
        return;
    }

    public final void setRvScrollListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f164579p = r100;
    }

    public AnchorV3CommentNodeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f164573j = new ArrayList();
        this.f164574k = -1;
        this.f164575l = new ArrayList();
        this.f164576m = -1;
        this.f164581r = new c(this);
        th.a.c(r100, R.layout.ec_commerce_anchor_v3_item_comment, this, true);
        this.f164564a = (CommentHeaderView) findViewById(R.id.comment_header_view);
        this.f164565b = (CommentReplyView) findViewById(R.id.comment_reply_view);
        this.f164566c = (ViewGroup) findViewById(R.id.append_container);
        this.f164567d = (TextView) findViewById(R.id.comment_content);
        this.f164568e = (TextView) findViewById(R.id.comment_time);
        this.f164569f = (FrameLayout) findViewById(R.id.comment_meaningless_fl);
        LinearLayout r103 = (LinearLayout) findViewById(R.id.comment_meaningless_ll);
        TextView r104 = (TextView) findViewById(R.id.comment_meaningless_tv);
        this.f164571h = findViewById(R.id.comment_content_container);
        this.f164570g = (CommentInteractiveView) findViewById(R.id.comment_bottom_interactive_view);
        this.f164572i = (ECDraweeView) findViewById(R.id.comment_iv_tip_icon);
        this.f164580q = (RoundLinearLayout) findViewById(R.id.ec_commerce_anchor_v3_item_comment_container);
        post(new a(this));
    }

    public /* synthetic */ AnchorV3CommentNodeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v6 android.text.SpannableString, still in use, count: 6, list:
          (r7v6 android.text.SpannableString) from 0x0504: MOVE (r42v0 android.text.SpannableString) = (r7v6 android.text.SpannableString) (LINE:83887364)
          (r7v6 android.text.SpannableString) from 0x051d: MOVE (r42v8 android.text.SpannableString) = (r7v6 android.text.SpannableString) (LINE:83887389)
          (r7v6 android.text.SpannableString) from 0x0512: MOVE (r42v9 android.text.SpannableString) = (r7v6 android.text.SpannableString) (LINE:83887378)
          (r7v6 android.text.SpannableString) from 0x045f: MOVE (r42v10 android.text.SpannableString) = (r7v6 android.text.SpannableString) (LINE:83887199)
          (r7v6 android.text.SpannableString) from 0x0458: MOVE (r42v11 android.text.SpannableString) = (r7v6 android.text.SpannableString) (LINE:83887192)
          (r7v6 android.text.SpannableString) from 0x0467: MOVE (r42v12 android.text.SpannableString) = (r7v6 android.text.SpannableString) (LINE:83887207)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    public final void b(final com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO r54, final com.bytedance.android.shopping.anchorv3.comment.CommentViewModel r55, final kotlin.jvm.functions.Function2 r56, final kotlin.jvm.functions.Function0 r57, com.bytedance.android.shopping.anchorv3.comment.a r58) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x04b9: NOP  (LINE:83887289) in method: com.bytedance.android.shopping.anchorv3.comment.widget.AnchorV3CommentNodeView.b(com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO, com.bytedance.android.shopping.anchorv3.comment.CommentViewModel, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, com.bytedance.android.shopping.anchorv3.comment.a):void, file: classes12.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Unknown instruction: NOP in method: com.bytedance.android.shopping.anchorv3.comment.widget.AnchorV3CommentNodeView.b(com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO, com.bytedance.android.shopping.anchorv3.comment.CommentViewModel, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, com.bytedance.android.shopping.anchorv3.comment.a):void, file: classes12.dex
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:649)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.android.shopping.anchorv3.comment.widget.AnchorV3CommentNodeView.b(com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO, com.bytedance.android.shopping.anchorv3.comment.CommentViewModel, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, com.bytedance.android.shopping.anchorv3.comment.a):void");
    }
}
