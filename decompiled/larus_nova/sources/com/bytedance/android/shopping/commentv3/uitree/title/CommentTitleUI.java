package com.bytedance.android.shopping.commentv3.uitree.title;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentParams;
import com.bytedance.android.shopping.anchorv3.comment.view.AnchorV3CommentActivity;
import com.bytedance.android.shopping.anchorv4.containers.h;
import com.bytedance.android.shopping.commentv3.base.BaseCommentUI;
import com.bytedance.android.shopping.commentv3.base.BaseUI;
import com.bytedance.android.shopping.commentv3.data.interfaces.SubTitle;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.List;
import jd3.q0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/title/CommentTitleUI;", "Lcom/bytedance/android/shopping/commentv3/base/BaseCommentUI;", "Lcom/bytedance/android/shopping/commentv3/uitree/title/a;", "Lcom/bytedance/android/shopping/commentv3/uitree/title/CommentTitleLogic;", "Lcom/bytedance/android/shopping/commentv3/uitree/title/f;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentTitleUI extends BaseCommentUI<com.bytedance.android.shopping.commentv3.uitree.title.a, CommentTitleLogic> implements com.bytedance.android.shopping.commentv3.uitree.title.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f172883v = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f172884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f172885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f172886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f172887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f172888m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f172889n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f172890o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f172891p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f172892q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LinearLayout f172893r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ECDraweeView f172894s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f172895t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ImageView f172896u;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentTitleUI f172897a;

        public b(CommentTitleUI r100) {
            this.f172897a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CommentTitleUI.o(this.f172897a);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentTitleUI f172898a;

        public c(CommentTitleUI r100) {
            this.f172898a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            TextView r102 = this.f172898a.f172884i;
            if (r102 == null) goto L9;
            if (r101 != null) goto L7;
            r101 = "";
        L7:
            r102.setText(r101);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentTitleUI f172899a;

        public d(CommentTitleUI r100) {
            this.f172899a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            View r111 = (View) r110;
            CommentTitleUI r100 = this.f172899a;
            int r101 = CommentTitleUI.f172883v;
            r100.getClass();
            int r102 = ECSdk.f48106a;
            IECHostService r103 = (IECHostService) ECSdk.a(IECHostService.class);
            Object r104 = null;
            if (r103 == null) goto L68;
            IECAIHostService r105 = r103.getECHostAIService();
            if (r105 == null) goto L68;
            if (r105.isInApplet() != true) goto L68;
            Context r106 = r100.getContext();
            if (r106 != null) goto L14;
            View r107 = r100.f172662c;
            if (r107 == null) goto L13;
            r106 = r107.getContext();
            goto L14
        L13:
            r106 = null;
        L14:
            if (r106 == null) goto L57;
            IECHostService r108 = (IECHostService) ECSdk.a(IECHostService.class);
            if (r108 == null) goto L57;
            IECAIHostService r109 = r108.getECHostAIService();
            if (r109 == null) goto L57;
            CapsuleComponent r112 = r109.createCapsuleComponent(r106);
            if (r112 == null) goto L57;
            r112.setScene(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE);
            r112.setOnClickCloseListener(new com.bytedance.android.shopping.commentv3.uitree.title.c(r109));
            r112.setOnClickMenuListener(new com.bytedance.android.shopping.commentv3.uitree.title.d(r100, r111, r109, r106));
            if (r111 == null) goto L32;
            ViewParent r113 = r111.getParent();
            if ((r113 instanceof ViewGroup) == true) goto L29;
            r113 = null;
        L29:
            ViewGroup r114 = (ViewGroup) r113;
            if (r114 == null) goto L32;
            r114.removeView(r111);
        L32:
            r100.f172887l = r111;
            View r115 = r112.getView();
            FrameLayout r116 = r100.f172886k;
            if (r116 == null) goto L56;
            ViewParent r117 = r115.getParent();
            if ((r117 instanceof ViewGroup) == true) goto L38;
            r117 = null;
        L38:
            ViewGroup r118 = (ViewGroup) r117;
            if (r118 == null) goto L41;
            r118.removeView(r115);
        L41:
            View r119 = r100.f172889n;
            if (r119 == null) goto L49;
            ViewParent r120 = r119.getParent();
            if ((r120 instanceof ViewGroup) == true) goto L46;
            r120 = null;
        L46:
            ViewGroup r121 = (ViewGroup) r120;
            if (r121 == null) goto L49;
            r121.removeView(r119);
        L49:
            r100.f172889n = r115;
            r116.removeAllViews();
            ViewGroup.LayoutParams r122 = r116.getLayoutParams();
            if ((r122 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
            r122 = null;
        L52:
            ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
            if (r123 == null) goto L55;
            r123.width = com.bytedance.android.shopping.extensions.b.b(108);
            r123.height = com.bytedance.android.shopping.extensions.b.b(60);
            r123.setMarginEnd(0);
            r123.rightMargin = 0;
            r116.setLayoutParams(r123);
        L55:
            r116.setClipChildren(false);
            r116.setClipToPadding(false);
            r116.setPadding(0, 0, 0, 0);
            r116.addView(r115, new FrameLayout.LayoutParams(-1, -1));
            r116.setVisibility(0);
            r115.setVisibility(0);
        L56:
            boolean r124 = true;
        L58:
            if (r124 == false) goto L68;
            LinearLayout r125 = r100.f172890o;
            if (r125 == null) goto L118;
            ViewGroup.LayoutParams r126 = r125.getLayoutParams();
            if ((r126 instanceof ViewGroup.MarginLayoutParams) == false) goto L65;
            r104 = r126;
        L65:
            ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r104;
            if (r127 == null) goto L119;
            r127.setMarginEnd(0);
            r125.setLayoutParams(r127);
            return;
        L119:
            return;
        L118:
            return;
        L57:
            r124 = false;
        L68:
            View r128 = r100.f172889n;
            if (r128 == null) goto L76;
            ViewParent r129 = r128.getParent();
            if ((r129 instanceof ViewGroup) == true) goto L73;
            r129 = null;
        L73:
            ViewGroup r130 = (ViewGroup) r129;
            if (r130 == null) goto L76;
            r130.removeView(r128);
        L76:
            r100.f172889n = null;
            FrameLayout r131 = r100.f172886k;
            if (r131 == null) goto L79;
            nc3.b.c(r131, CollectionsKt.arrayListOf(new Integer[]{0, 0, 0, 9}), new CommentTitleUI$setInjectView$3(r100));
        L79:
            if (r111 != null) goto L92;
            FrameLayout r132 = r100.f172886k;
            if (r132 == null) goto L83;
            r132.setVisibility(8);
        L83:
            LinearLayout r133 = r100.f172890o;
            if (r133 == null) goto L121;
            ViewGroup.LayoutParams r134 = r133.getLayoutParams();
            if ((r134 instanceof ViewGroup.MarginLayoutParams) == false) goto L89;
            r104 = r134;
        L89:
            ViewGroup.MarginLayoutParams r135 = (ViewGroup.MarginLayoutParams) r104;
            if (r135 == null) goto L122;
            r135.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(16));
            r133.setLayoutParams(r135);
            return;
        L122:
            return;
        L121:
            return;
        L92:
            LinearLayout r136 = r100.f172890o;
            if (r136 == null) goto L100;
            ViewGroup.LayoutParams r137 = r136.getLayoutParams();
            if ((r137 instanceof ViewGroup.MarginLayoutParams) == true) goto L97;
            r137 = null;
        L97:
            ViewGroup.MarginLayoutParams r138 = (ViewGroup.MarginLayoutParams) r137;
            if (r138 == null) goto L100;
            r138.setMarginEnd(0);
            r136.setLayoutParams(r138);
        L100:
            r100.f172887l = r111;
            ViewParent r139 = r111.getParent();
            if ((r139 instanceof ViewGroup) == false) goto L104;
            r104 = r139;
        L104:
            ViewGroup r140 = (ViewGroup) r104;
            if (r140 == null) goto L107;
            r140.removeView(r111);
        L107:
            FrameLayout r141 = r100.f172886k;
            if (r141 == null) goto L110;
            r141.removeAllViews();
        L110:
            FrameLayout r142 = r100.f172886k;
            if (r142 == null) goto L113;
            r142.addView(r111);
        L113:
            FrameLayout r143 = r100.f172886k;
            if (r143 == null) goto L116;
            r143.setVisibility(0);
        L116:
            r111.setVisibility(0);
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentTitleUI f172900a;

        public e(CommentTitleUI r100) {
            this.f172900a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            final p53.e r101 = (p53.e) r100;
            final CommentTitleUI r102 = this.f172900a;
            int r103 = CommentTitleUI.f172883v;
            if (((CommentTitleLogic) r102.f172668a) != null) goto L5;
        L24:
            LinearLayout r104 = r102.f172890o;
            if (r104 == null) goto L36;
            r104.setVisibility(8);
            return;
        L36:
            return;
        L5:
            if (r101 == null) goto L15;
            Iterator<T> r105 = r101.f527774a.iterator();
        L9:
            if (r105.hasNext() == false) goto L15;
            List<String> r106 = ((PromotionProductSkuStruct) r105.next()).getSpecNameList();
            if (r106 == null) goto L9;
            if (r106.size() <= 1) goto L9;
            boolean r107 = true;
        L16:
            if (r107 != true) goto L24;
            LinearLayout r108 = r102.f172890o;
            if (r108 == null) goto L21;
            r108.setVisibility(0);
        L21:
            LinearLayout r109 = r102.f172890o;
            if (r109 == null) goto L34;
            r109.setOnClickListener(new CommentTitleUI$updateSkuEntranceListener$1(r102, r101));
            return;
        L34:
            return;
        L15:
            r107 = false;
            goto L16
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentTitleUI f172901a;

        public f(CommentTitleUI r100) {
            this.f172901a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            SubTitle r100 = (SubTitle) r110;
            CommentTitleUI r101 = this.f172901a;
            if (r100 != null) goto L7;
            LinearLayout r102 = r101.f172893r;
            if (r102 == null) goto L22;
            r102.setVisibility(8);
            return;
        L22:
            return;
        L7:
            LinearLayout r103 = r101.f172893r;
            if (r103 == null) goto L10;
            r103.setVisibility(0);
        L10:
            TextView r104 = r101.f172895t;
            if (r104 == null) goto L13;
            r104.setText(r100.getText());
        L13:
            String r105 = r100.getIcon();
            if (r105 == null) goto L18;
            ECDraweeView r106 = r101.f172894s;
            if (r106 == null) goto L18;
            ImageExtensionsKt.w(r106, r105, null, null, null, null, null, null, null, false, null, null, 4094);
        L18:
            LinearLayout r107 = r101.f172893r;
            if (r107 == null) goto L24;
            r107.setOnClickListener(new com.bytedance.android.shopping.commentv3.uitree.title.e(r101, r100));
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "titleText", "getTitleText()Ljava/lang/String;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r100).f172904a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass4 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "injectView", "getInjectView()Landroid/view/View;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r100).f172905b;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$6, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass6 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "commentSkuV0", "getCommentSkuV0()Lcom/bytedance/android/shopping/anchorv3/comment/model/CommentSkuVO;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r100).f172906c;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.title.CommentTitleUI$onCreate$8, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass8 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass8();
        }

        public AnonymousClass8() {
            super(com.bytedance.android.shopping.commentv3.uitree.title.a.class, "subTitle", "getSubTitle()Lcom/bytedance/android/shopping/commentv3/data/interfaces/SubTitle;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((com.bytedance.android.shopping.commentv3.uitree.title.a) r100).f172907d;
        }
    }

    static {
    }

    public final com.bytedance.android.shopping.commentv3.base.b p() {
        return new com.bytedance.android.shopping.commentv3.uitree.title.a("", null, null, null);
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseCommentUI, com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onCreate() {
        super.onCreate();
        View r100 = this.f172662c;
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        TextView r102 = (TextView) r100.findViewById(R.id.title_tv);
    L6:
        this.f172884i = r102;
        View r103 = this.f172662c;
        if (r103 == null) goto L9;
        LinearLayout r104 = (LinearLayout) r103.findViewById(R.id.sku_entrance_ll);
    L10:
        this.f172890o = r104;
        View r105 = this.f172662c;
        if (r105 == null) goto L13;
        ImageView r106 = (ImageView) r105.findViewById(R.id.sku_select_entrance_icon);
    L14:
        this.f172891p = r106;
        View r107 = this.f172662c;
        if (r107 == null) goto L17;
        TextView r108 = (TextView) r107.findViewById(R.id.sku_select_entrance_tv);
    L18:
        this.f172892q = r108;
        View r109 = this.f172662c;
        if (r109 == null) goto L21;
        LinearLayout r110 = (LinearLayout) r109.findViewById(R.id.sub_title_ll);
    L22:
        this.f172893r = r110;
        View r111 = this.f172662c;
        if (r111 == null) goto L25;
        ECDraweeView r112 = (ECDraweeView) r111.findViewById(R.id.sub_title_icon);
    L26:
        this.f172894s = r112;
        View r113 = this.f172662c;
        if (r113 == null) goto L29;
        TextView r114 = (TextView) r113.findViewById(R.id.sub_title_tv);
    L30:
        this.f172895t = r114;
        View r115 = this.f172662c;
        if (r115 == null) goto L33;
        FrameLayout r116 = (FrameLayout) r115.findViewById(R.id.title_right_container);
    L34:
        this.f172886k = r116;
        View r117 = this.f172662c;
        if (r117 == null) goto L37;
        FrameLayout r118 = (FrameLayout) r117.findViewById(R.id.title_back_container);
    L38:
        this.f172885j = r118;
        View r119 = this.f172662c;
        if (r119 == null) goto L41;
        ImageView r120 = (ImageView) r119.findViewById(R.id.title_back_arrow);
    L42:
        this.f172896u = r120;
        r("");
        View r121 = this.f172662c;
        if (r121 == null) goto L45;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L47:
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == true) goto L49;
        r122 = null;
    L49:
        ViewGroup.MarginLayoutParams r123 = (ViewGroup.MarginLayoutParams) r122;
        if (r123 == null) goto L54;
        r123.height = l(44);
        View r124 = this.f172662c;
        if (r124 == null) goto L54;
        r124.setLayoutParams(r123);
    L54:
        ImageView r125 = this.f172896u;
        if (r125 == null) goto L57;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
    L59:
        if ((r126 instanceof ViewGroup.MarginLayoutParams) == true) goto L61;
        r126 = null;
    L61:
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r126;
        if (r127 == null) goto L66;
        r127.width = l(24);
        r127.height = l(24);
        r127.setMarginStart(l(16));
        ImageView r128 = this.f172896u;
        if (r128 == null) goto L66;
        r128.setLayoutParams(r127);
    L66:
        TextView r129 = this.f172884i;
        if (r129 == null) goto L69;
        r129.setTextSize(m(17));
    L69:
        TextView r130 = this.f172884i;
        if (r130 == null) goto L72;
        nc3.b.b(r130, CollectionsKt.arrayListOf(new Integer[]{0, 0, 0, 8}), new CommentTitleUI$initViews$3(this));
    L72:
        LinearLayout r131 = this.f172890o;
        if (r131 == null) goto L75;
        ViewGroup.LayoutParams r132 = r131.getLayoutParams();
    L77:
        if ((r132 instanceof ViewGroup.MarginLayoutParams) == true) goto L79;
        r132 = null;
    L79:
        ViewGroup.MarginLayoutParams r133 = (ViewGroup.MarginLayoutParams) r132;
        if (r133 == null) goto L84;
        r133.height = l(24);
        LinearLayout r134 = this.f172890o;
        if (r134 == null) goto L84;
        r134.setLayoutParams(r133);
    L84:
        LinearLayout r135 = this.f172890o;
        if (r135 == null) goto L87;
        nc3.b.c(r135, CollectionsKt.arrayListOf(new Integer[]{0, 12, 0, 12}), new CommentTitleUI$initViews$5(this));
    L87:
        ImageView r136 = this.f172891p;
        if (r136 == null) goto L90;
        ViewGroup.LayoutParams r137 = r136.getLayoutParams();
    L92:
        if ((r137 instanceof ViewGroup.MarginLayoutParams) == true) goto L94;
        r137 = null;
    L94:
        ViewGroup.MarginLayoutParams r138 = (ViewGroup.MarginLayoutParams) r137;
        if (r138 == null) goto L99;
        r138.width = l(10);
        r138.height = l(10);
        ImageView r139 = this.f172891p;
        if (r139 == null) goto L99;
        r139.setLayoutParams(r138);
    L99:
        TextView r140 = this.f172892q;
        if (r140 == null) goto L102;
        ViewGroup.LayoutParams r141 = r140.getLayoutParams();
    L104:
        if ((r141 instanceof ViewGroup.MarginLayoutParams) == true) goto L106;
        r141 = null;
    L106:
        ViewGroup.MarginLayoutParams r142 = (ViewGroup.MarginLayoutParams) r141;
        if (r142 == null) goto L111;
        r142.height = l(24);
        r142.setMarginStart(l(4));
        TextView r143 = this.f172892q;
        if (r143 == null) goto L111;
        r143.setLayoutParams(r142);
    L111:
        TextView r144 = this.f172892q;
        if (r144 == null) goto L114;
        r144.setTextSize(m(12));
    L114:
        FrameLayout r145 = this.f172886k;
        if (r145 == null) goto L117;
        ViewGroup.LayoutParams r146 = r145.getLayoutParams();
    L119:
        if ((r146 instanceof ViewGroup.MarginLayoutParams) == true) goto L121;
        r146 = null;
    L121:
        ViewGroup.MarginLayoutParams r147 = (ViewGroup.MarginLayoutParams) r146;
        if (r147 == null) goto L126;
        r147.height = l(44);
        r147.setMarginEnd(l(8));
        FrameLayout r148 = this.f172886k;
        if (r148 == null) goto L126;
        r148.setLayoutParams(r147);
    L126:
        FrameLayout r149 = this.f172886k;
        if (r149 == null) goto L129;
        nc3.b.c(r149, CollectionsKt.arrayListOf(new Integer[]{0, 0, 0, 9}), new CommentTitleUI$initViews$9(this));
    L129:
        ImageView r150 = this.f172896u;
        if (r150 == null) goto L132;
        r150.setOnClickListener(new b(this));
    L132:
        int r151 = ECSdk.f48106a;
        IECHostService r152 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r152 == null) goto L135;
        IECAIHostService r153 = r152.getECHostAIService();
    L136:
        if (r153 != null) goto L138;
    L191:
        BaseUI.f(this.f172669b, AnonymousClass2.INSTANCE).observe(this, new c(this));
        BaseUI.f(this.f172669b, AnonymousClass4.INSTANCE).observe(this, new d(this));
        BaseUI.f(this.f172669b, AnonymousClass6.INSTANCE).observe(this, new e(this));
        BaseUI.f(this.f172669b, AnonymousClass8.INSTANCE).observe(this, new f(this));
        return;
    L138:
        if (r153.isInApplet() != true) goto L191;
        Context r154 = getContext();
        if (r154 != null) goto L146;
        View r155 = this.f172662c;
        if (r155 == null) goto L145;
        r154 = r155.getContext();
        goto L146
    L145:
        r154 = null;
    L146:
        if (r154 == null) goto L191;
        View r156 = this.f172662c;
        if (r156 == null) goto L153;
        ViewGroup.LayoutParams r157 = r156.getLayoutParams();
        if (r157 == null) goto L153;
        r157.height = com.bytedance.android.shopping.extensions.b.b(60);
    L153:
        BackComponent r158 = r153.createBackComponent(r154);
        if (r158 == null) goto L191;
        r158.setScene(com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_MODULE);
        r158.setOnClickListener(new com.bytedance.android.shopping.commentv3.uitree.title.b(this));
        View r159 = r158.getView();
        FrameLayout r160 = this.f172885j;
        if (r160 == null) goto L191;
        ViewGroup.LayoutParams r161 = r160.getLayoutParams();
        if ((r161 instanceof ViewGroup.MarginLayoutParams) == true) goto L162;
        r161 = null;
    L162:
        ViewGroup.MarginLayoutParams r162 = (ViewGroup.MarginLayoutParams) r161;
        if (r162 == null) goto L165;
        r162.width = com.bytedance.android.shopping.extensions.b.b(60);
        r162.height = com.bytedance.android.shopping.extensions.b.b(60);
        r162.setMarginStart(0);
        r160.setLayoutParams(r162);
    L165:
        r160.setClipChildren(false);
        r160.setClipToPadding(false);
        ViewParent r163 = r159.getParent();
        if ((r163 instanceof ViewGroup) == true) goto L168;
        r163 = null;
    L168:
        ViewGroup r164 = (ViewGroup) r163;
        if (r164 == null) goto L171;
        r164.removeView(r159);
    L171:
        View r165 = this.f172888m;
        if (r165 == null) goto L179;
        ViewParent r166 = r165.getParent();
        if ((r166 instanceof ViewGroup) == true) goto L176;
        r166 = null;
    L176:
        ViewGroup r167 = (ViewGroup) r166;
        if (r167 == null) goto L179;
        r167.removeView(r165);
    L179:
        this.f172888m = r159;
        r160.removeAllViews();
        TextView r168 = this.f172884i;
        if (r168 == null) goto L188;
        ViewGroup.LayoutParams r169 = r168.getLayoutParams();
        if ((r169 instanceof ViewGroup.MarginLayoutParams) == false) goto L185;
        r101 = r169;
    L185:
        ViewGroup.MarginLayoutParams r170 = (ViewGroup.MarginLayoutParams) r101;
        if (r170 == null) goto L188;
        r170.setMarginStart(0);
        r170.leftMargin = 0;
        r168.setLayoutParams(r170);
    L188:
        r160.addView(r159, new FrameLayout.LayoutParams(-1, -1));
        r160.setVisibility(0);
        ImageView r171 = this.f172896u;
        if (r171 == null) goto L191;
        r171.setVisibility(8);
        goto L191
    L135:
        r153 = null;
        goto L136
    L117:
        r146 = null;
        goto L119
    L102:
        r141 = null;
        goto L104
    L90:
        r137 = null;
        goto L92
    L75:
        r132 = null;
        goto L77
    L57:
        r126 = null;
        goto L59
    L45:
        r122 = null;
        goto L47
    L41:
        r120 = null;
        goto L42
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r112 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.commentv3.base.BaseUI, com.bytedance.android.shopping.commentv3.base.LifecycleUI
    public final void onDestroy() {
        super.onDestroy();
        View r100 = this.f172887l;
        if (r100 == null) goto L7;
        FrameLayout r101 = this.f172886k;
        if (r101 == null) goto L7;
        r101.removeView(r100);
    L7:
        this.f172887l = null;
    }

    public CommentTitleUI() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.fragment.app.Fragment] */
    public static final void o(CommentTitleUI r100) {
        com.bytedance.android.shopping.commentv3.base.c r101 = r100.f172666g;
        FragmentManager r102 = null;
        if (r101 == null) goto L7;
        Fragment r103 = r101.f172675b;
        if (r103 == null) goto L7;
        ?? r104 = r103.getActivity();
    L8:
        com.bytedance.android.shopping.commentv3.data.b r105 = r100.f172664e;
        if (r105 == null) goto L15;
        CommentParams r106 = r105.f172736a;
        if (r106 == null) goto L15;
        boolean r107 = true;
        if (r106.isFromProductDetail() != true) goto L15;
    L16:
        if (r107 == false) goto L40;
        com.bytedance.android.shopping.commentv3.base.c r108 = r100.f172666g;
        if (r108 == null) goto L20;
        Fragment r109 = r108.f172675b;
    L21:
        if (r109 == null) goto L23;
        ?? r110 = r109.getParentFragment();
    L25:
        if ((r104 instanceof h) == false) goto L28;
        ((h) r104).J1();
        return;
    L28:
        if ((r104 instanceof AnchorV3CommentActivity) == false) goto L31;
        r104.finish();
        return;
    L31:
        if ((r110 instanceof h) == false) goto L33;
        ((h) r110).J1();
        return;
    L33:
        int r111 = com.bytedance.android.shopping.commentv3.a.f172590a;
        if (r110 == 0) goto L36;
        r102 = r110.getChildFragmentManager();
    L36:
        if (r102 == null) goto L46;
        Fragment r112 = r102.findFragmentByTag("PRODUCT_COMMENT");
        if (r112 == null) goto L47;
        r102.beginTransaction().remove(r112).commitAllowingStateLoss();
        s0.a(new q0(false));
        return;
    L47:
        return;
    L46:
        return;
    L23:
        r110 = 0;
        goto L25
    L20:
        r109 = null;
        goto L21
    L40:
        if (r104 == 0) goto L49;
        r104.finish();
        return;
    L49:
        return;
    L15:
        r107 = false;
    L7:
        r104 = 0;
        goto L8
    }

    public final void r(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L16;
        ImageView r102 = this.f172891p;
        if (r102 == null) goto L10;
        r102.setImageResource(R.drawable.ec_comment_sku_entrance_icon_unselected);
    L10:
        TextView r103 = this.f172892q;
        if (r103 == null) goto L13;
        r103.setText(R.string.ec_comment_sku_select_entrance_text);
        int r104 = g1.f45599a;
        r103.setTextColor(g1.a.a(r103.getContext(), R.color.commerce_color_161823));
    L13:
        LinearLayout r105 = this.f172890o;
        if (r105 == null) goto L26;
        r105.setSelected(false);
        return;
    L26:
        return;
    L16:
        ImageView r106 = this.f172891p;
        if (r106 == null) goto L19;
        r106.setImageResource(R.drawable.ec_comment_sku_entrance_icon_selected);
    L19:
        LinearLayout r107 = this.f172890o;
        if (r107 == null) goto L22;
        r107.setSelected(true);
    L22:
        TextView r108 = this.f172892q;
        if (r108 == null) goto L28;
        r108.setText(r100);
        int r109 = g1.f45599a;
        r108.setTextColor(g1.a.a(r108.getContext(), R.color.commerce_color_FF3B52));
        return;
    L28:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
