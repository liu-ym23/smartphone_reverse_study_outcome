package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.anchorv3.guessulike.model.FeedbackItem;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackResponseDTO;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemStyle;
import com.bytedance.android.shopping.anchorv3.guessulike.model.NegFeedbackStyle;
import com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH;
import com.bytedance.android.shopping.widget.CustomDividerItemDecoration;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3GuessULikeFeedbackView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3GuessULikeFeedbackView extends ConstraintLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f165391w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f165392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView.Adapter<?> f165393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f165394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<String> f165395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f165396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j63.c f165397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f165398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.voavhs.guess.f f165399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f165400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f165401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f165402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f165403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RecyclerView f165404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f165405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FrameLayout f165406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f165407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<FeedbackItem> f165408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<FeedbackItem> f165409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final GestureDetectorCompat f165410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AnchorV3GuessULikeFeedbackView$scrollListener$1 f165411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AnchorV3GuessULikeFeedbackView$itemTouchListener$1 f165412u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f165413v;

    public static final class a {
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV3GuessULikeFeedbackView f165414a;

        public b(AnchorV3GuessULikeFeedbackView r100) {
            this.f165414a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            this.f165414a.f165402k = true;
        }
    }

    static {
    }

    public AnchorV3GuessULikeFeedbackView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3GuessULikeFeedbackView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void S5() {
        TextView r100 = this.f165405n;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        RecyclerView r101 = this.f165404m;
        RecyclerView.Adapter r102 = null;
        if (r101 == null) goto L8;
        RecyclerView.Adapter r103 = r101.getAdapter();
    L10:
        if ((r103 instanceof FeedBackAdapter) == false) goto L13;
        r102 = r103;
    L13:
        FeedBackAdapter r104 = (FeedBackAdapter) r102;
        if (r104 == null) goto L17;
        List<FeedbackItem> r105 = this.f165409r;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f165512b = r105;
        r104.notifyDataSetChanged();
        return;
    L17:
        return;
    L8:
        r103 = null;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeFeedbackView$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeFeedbackView$itemTouchListener$1] */
    public AnchorV3GuessULikeFeedbackView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_anchor_v3_recommend_feedback_layout, this);
        this.f165394c = -1;
        this.f165396e = "product";
        this.f165404m = (RecyclerView) findViewById(R.id.feedback_recyclerview);
        this.f165405n = (TextView) findViewById(R.id.feedback_back);
        this.f165406o = (FrameLayout) findViewById(R.id.search_same_style_product);
        this.f165407p = (ImageView) findViewById(R.id.feedback_exit);
        this.f165408q = new ArrayList();
        this.f165409r = new ArrayList();
        this.f165410s = new GestureDetectorCompat(r100, new b(this));
        this.f165411t = new AnchorV3GuessULikeFeedbackView$scrollListener$1(this);
        this.f165412u = new AnchorV3GuessULikeFeedbackView$itemTouchListener$1(this);
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
    public final void T5(boolean r100, View r101, String r102) {
        int r103 = 0;
        if (r100 == false) goto L5;
        int r104 = 0;
    L6:
        setVisibility(r104);
        String r105 = "";
        String r106 = null;
        ConstraintLayout r107 = null;
        r106 = null;
        if (r100 == false) goto L97;
        j63.c r108 = this.f165397f;
        if (r108 == null) goto L15;
        ItemCardProductStruct r109 = r108.d();
        if (r109 == null) goto L15;
        ItemCardProductStruct.ProductExtra r110 = r109.getExtra();
        if (r110 == null) goto L15;
        String r111 = r110.getSimilarLink();
    L17:
        if (ih3.a.f489799a.b() == false) goto L24;
        if (r111 == null) goto L24;
        boolean r112 = true;
        if ((!StringsKt.isBlank(r111)) != true) goto L24;
        if (this.f165398g == false) goto L24;
    L25:
        if (r112 == false) goto L49;
        com.bytedance.android.shopping.anchorv4.voavhs.guess.f r113 = this.f165399h;
        if (r113 == null) goto L49;
        getContext();
        String r114 = this.f165396e;
        Function0<String> r115 = this.f165395d;
        if (r115 == null) goto L31;
        String r116 = r115.invoke();
    L32:
        if (r116 != null) goto L34;
        r116 = "";
    L34:
        j63.c r117 = this.f165397f;
        if (r117 == null) goto L39;
        ItemCardProductStruct r118 = r117.d();
        if (r118 == null) goto L39;
        String r119 = r118.getProductId();
    L40:
        if (r119 != null) goto L42;
        r119 = "";
    L42:
        j63.c r120 = this.f165397f;
        if (r120 == null) goto L47;
        ItemCardProductStruct r121 = r120.d();
        if (r121 == null) goto L47;
        String r122 = r121.getCommodityType();
    L48:
        r113.s(r114, r116, r119, r122);
    L47:
        r122 = null;
    L39:
        r119 = null;
        goto L40
    L31:
        r116 = null;
    L49:
        com.bytedance.android.shopping.anchorv4.voavhs.guess.f r123 = this.f165399h;
        if (r123 == null) goto L71;
        String r124 = this.f165396e;
        Function0<String> r125 = this.f165395d;
        if (r125 == null) goto L54;
        String r126 = r125.invoke();
    L55:
        if (r126 == null) goto L58;
        r105 = r126;
    L58:
        j63.c r127 = this.f165397f;
        if (r127 == null) goto L63;
        ItemCardProductStruct r128 = r127.d();
        if (r128 == null) goto L63;
        String r129 = r128.getCommodityType();
    L64:
        j63.c r130 = this.f165397f;
        if (r130 == null) goto L69;
        ItemCardProductStruct r131 = r130.d();
        if (r131 == null) goto L69;
        String r132 = r131.getProductId();
    L70:
        getContext();
        r123.t(r124, r105, r129, r132);
    L69:
        r132 = null;
    L63:
        r129 = null;
        goto L64
    L54:
        r126 = null;
    L71:
        if (r101 == null) goto L96;
        this.f165394c = -1;
        RecyclerView r133 = this.f165392a;
        if (r133 == null) goto L75;
        this.f165394c = r133.getChildAdapterPosition(r101);
    L75:
        int r134 = l63.a.f507662b;
        RecyclerView r135 = this.f165392a;
        if (r135 == null) goto L80;
        RecyclerView.LayoutManager r136 = r135.getLayoutManager();
        if (r136 == null) goto L80;
        View r137 = r136.findViewByPosition(r134);
    L81:
        if (r137 == null) goto L84;
        r107 = (ConstraintLayout) r137.findViewById(R.id.anchor_v3_recommend_feedback_view);
    L84:
        if (r134 == this.f165394c) goto L96;
        if (r134 <= 0) goto L96;
        RecyclerView.Adapter<?> r138 = this.f165393b;
        if (r138 == null) goto L89;
        r103 = r138.getItemCount();
    L89:
        if (r134 >= r103) goto L96;
        if (r107 == null) goto L96;
        if (r107.getVisibility() != 0) goto L96;
        RecyclerView.Adapter<?> r139 = this.f165393b;
        if (r139 == null) goto L96;
        r139.notifyItemChanged(r134, "hide_feedback");
    L80:
        r137 = null;
    L96:
        HashSet<String> r140 = l63.a.f507661a;
        l63.a.f507662b = this.f165394c;
        S5();
        return;
    L24:
        r112 = false;
    L15:
        r111 = null;
        goto L17
    L97:
        com.bytedance.android.shopping.anchorv4.voavhs.guess.f r141 = this.f165399h;
        if (r141 == null) goto L119;
        String r142 = this.f165396e;
        Function0<String> r143 = this.f165395d;
        if (r143 == null) goto L102;
        String r144 = r143.invoke();
    L103:
        if (r144 != null) goto L105;
        r144 = "";
    L105:
        j63.c r145 = this.f165397f;
        if (r145 == null) goto L110;
        ItemCardProductStruct r146 = r145.d();
        if (r146 == null) goto L110;
        String r147 = r146.getCommodityType();
    L111:
        j63.c r148 = this.f165397f;
        if (r148 == null) goto L116;
        ItemCardProductStruct r149 = r148.d();
        if (r149 == null) goto L116;
        r106 = r149.getProductId();
    L116:
        getContext();
        r141.r(r142, r144, r147, r106, r102);
        return;
    L110:
        r147 = null;
        goto L111
    L102:
        r144 = null;
        goto L103
    L119:
        return;
    L5:
        r104 = 8;
        goto L6
    }

    public /* synthetic */ AnchorV3GuessULikeFeedbackView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static /* synthetic */ void U5(AnchorV3GuessULikeFeedbackView r100, boolean r101, View r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.T5(r101, r102, r103);
    }

    public final void R5(j63.c r210, Function0 r211, RecyclerView r212, RecyclerView.Adapter r213, boolean r214, AnchorV4GuessBaseVH.a r215, Function0 r216) {
        Intrinsics.checkNotNullParameter(r210, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r211, "enterMethod");
        Intrinsics.checkNotNullParameter(r212, "recyclerView");
        Intrinsics.checkNotNullParameter(r213, "adapter");
        this.f165399h = r215;
        this.f165392a = r212;
        this.f165393b = r213;
        this.f165395d = r211;
        this.f165397f = r210;
        this.f165398g = r214;
        this.f165400i = r216;
        setVisibility(8);
        ItemCardProductStruct r100 = r210.d();
        ArrayList r101 = null;
        if (r100 == null) goto L7;
        ItemCardProductStruct.ProductExtra r102 = r100.getExtra();
        if (r102 == null) goto L7;
        String r103 = r102.getSimilarLink();
    L8:
        int r104 = 0;
        if (ih3.a.f489799a.b() == false) goto L16;
        if (r103 == null) goto L16;
        if ((!StringsKt.isBlank(r103)) != true) goto L16;
        if (this.f165398g == false) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L21;
        FrameLayout r106 = this.f165406o;
        if (r106 == null) goto L24;
        r106.setVisibility(0);
    L24:
        FrameLayout r107 = this.f165406o;
        if (r107 == null) goto L28;
        r107.setOnClickListener(new c(this, r210));
    L28:
        if (this.f165403l == true) goto L36;
        Function3<String, Integer, String, Unit> r108 = new AnchorV3GuessULikeFeedbackView$initFeedbackRV$itemClickCB$1(this);
        RecyclerView r109 = this.f165404m;
        if (r109 == null) goto L35;
        r109.setLayoutManager(new LinearLayoutManager(r109.getContext(), 1, false));
        r109.setAdapter(new FeedBackAdapter(r109.getContext(), this.f165409r, r108));
        CustomDividerItemDecoration r110 = new CustomDividerItemDecoration(r109.getContext());
        int r111 = g1.f45599a;
        Drawable r112 = g1.a.b(r110.getContext(), R.drawable.ec_commerce_gul_feedback_divider);
        if (r112 == null) goto L34;
        Intrinsics.checkNotNullParameter(r112, "drawable");
        r110.f187219a = r112;
    L34:
        Unit r113 = Unit.INSTANCE;
        r109.addItemDecoration(r110);
    L35:
        this.f165403l = true;
    L36:
        GULFeedbackResponseDTO r114 = l63.a.f507663c;
        if (r114 == null) goto L45;
        Map<String, NegFeedbackStyle> r115 = r114.getNegFeedbackStyles();
        if (r115 == null) goto L45;
        Integer r116 = r210.getType();
        if (r116 == null) goto L43;
        String r117 = String.valueOf(r116.intValue());
    L44:
        NegFeedbackStyle r118 = r115.get(r117);
    L46:
        if (r118 == null) goto L50;
        Integer r119 = r118.getFirstPageLimit();
        if (r119 == null) goto L50;
        int r120 = r119.intValue();
    L51:
        ((ArrayList) this.f165409r).clear();
        ((ArrayList) this.f165408q).clear();
        if (r118 == null) goto L66;
        List<FeedbackItem> r121 = r118.getItems();
        if (r121 == null) goto L66;
        Iterator<T> r122 = r121.iterator();
    L57:
        if (r122.hasNext() == false) goto L66;
        Object r123 = r122.next();
        int r124 = r104 + 1;
        if (r104 >= 0) goto L61;
        CollectionsKt.throwIndexOverflow();
    L61:
        FeedbackItem r125 = (FeedbackItem) r123;
        if (r104 >= r120) goto L64;
        List<FeedbackItem> r126 = this.f165409r;
        r125.setItemStyle(ItemStyle.NORMAL);
        Unit r127 = Unit.INSTANCE;
        ((ArrayList) r126).add(r125);
    L65:
        r104 = r124;
        goto L57
    L64:
        List<FeedbackItem> r128 = this.f165408q;
        r125.setItemStyle(ItemStyle.SUB);
        Unit r129 = Unit.INSTANCE;
        ((ArrayList) r128).add(r125);
    L66:
        ArrayList r130 = (ArrayList) this.f165408q;
        if ((!r130.isEmpty()) == false) goto L69;
        r101 = r130;
    L69:
        if (r101 == null) goto L75;
        List<FeedbackItem> r131 = this.f165409r;
        ArrayList r132 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r133 = r101.iterator();
    L72:
        if (r133.hasNext() == false) goto L74;
        r132.add(((FeedbackItem) r133.next()).getAbbr());
        goto L72
    L74:
        FeedbackItem r134 = new FeedbackItem(CollectionsKt.joinToString$default(r132, "、", null, null, 0, null, null, 62, null), null, 0, null, 14, null);
        r134.setItemStyle(ItemStyle.MORE);
        Unit r135 = Unit.INSTANCE;
        ((ArrayList) r131).add(r134);
    L75:
        RecyclerView r136 = this.f165404m;
        if (r136 == null) goto L80;
        RecyclerView.Adapter r137 = r136.getAdapter();
        if (r137 == null) goto L80;
        r137.notifyDataSetChanged();
    L80:
        TextView r138 = this.f165405n;
        if (r138 == null) goto L83;
        r138.setOnClickListener(new com.bytedance.android.shopping.anchorv3.view.a(this, r215, r210));
    L83:
        ImageView r139 = this.f165407p;
        if (r139 == null) goto L91;
        r139.setOnClickListener(new com.bytedance.android.shopping.anchorv3.view.b(this));
        return;
    L91:
        return;
    L50:
        r120 = 0;
        goto L51
    L43:
        r117 = null;
    L45:
        r118 = null;
        goto L46
    L21:
        FrameLayout r140 = this.f165406o;
        if (r140 == null) goto L24;
        r140.setVisibility(8);
    L16:
        r105 = false;
    L7:
        r103 = null;
        goto L8
    }
}
