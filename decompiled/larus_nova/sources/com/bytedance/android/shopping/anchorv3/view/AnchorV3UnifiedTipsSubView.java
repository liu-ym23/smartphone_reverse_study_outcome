package com.bytedance.android.shopping.anchorv3.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3UnifiedTipsSubView;", "Landroid/widget/LinearLayout;", "", BitableAnalytic.LinkSceneClickType.EXPAND, "", "setExpandedStatus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "NoUnderlineSpan", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3UnifiedTipsSubView extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f165469g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f165470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f165471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f165472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f165473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f165474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f165475f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/view/AnchorV3UnifiedTipsSubView$NoUnderlineSpan;", "Landroid/text/style/UnderlineSpan;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NoUnderlineSpan extends UnderlineSpan {
        public NoUnderlineSpan() {
        }

        @Override // android.text.style.UnderlineSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            super.updateDrawState(r100);
            r100.setUnderlineText(false);
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV3UnifiedTipsSubView f165476a;

        public a(AnchorV3UnifiedTipsSubView r100) {
            this.f165476a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AnchorV3UnifiedTipsSubView r101 = this.f165476a;
            int r102 = AnchorV3UnifiedTipsSubView.f165469g;
            r101.b();
        }
    }

    public static final class b {
    }

    static {
    }

    public AnchorV3UnifiedTipsSubView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3UnifiedTipsSubView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void b() {
        if (this.f165474e == true) goto L5;
        this.f165471b.setVisibility(0);
        setExpandedStatus(true);
        this.f165473d.setImageResource(R.drawable.icon_anchor_v3_consult_arrow_up);
        return;
    L5:
        this.f165471b.setVisibility(8);
        setExpandedStatus(false);
        if (this.f165475f == false) goto L8;
        this.f165473d.setImageResource(R.drawable.icon_anchor_v4_consult_arrow_down);
        return;
    L8:
        this.f165473d.setImageResource(R.drawable.icon_anchor_v3_consult_arrow_down);
    }

    private final void setExpandedStatus(boolean r100) {
        this.f165474e = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v20, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public final void a(d63.u r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, MapController.ITEM_LAYER_TAG);
        this.f165470a.setText(r210.d());
        this.f165475f = r211;
        this.f165472c.setContentDescription(Intrinsics.stringPlus(r210.d(), "按钮"));
        List<String> r100 = r210.a();
        int r101 = 2;
        ViewGroup.LayoutParams r102 = null;
        if (r100 == null) goto L42;
        Iterator r103 = r100.iterator();
        ?? r104 = 0;
    L6:
        if (r103.hasNext() == false) goto L44;
        ?? r105 = (String) r103.next();
        TextView r110 = new TextView(getContext());
        r110.setTextColor(ag4.a.b(R.color.TextReverse3));
        r110.setTextSize(r101, 12.0f);
        r110.setLineSpacing(2.0f, 1.3f);
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r111 = r102;
    L10:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        if (r112 != null) goto L13;
        r112 = new ViewGroup.MarginLayoutParams(-2, -2);
    L13:
        r112.bottomMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r112.topMargin = com.bytedance.android.shopping.extensions.b.b(4);
        Unit r113 = Unit.INSTANCE;
        r110.setLayoutParams(r112);
        HashMap<String, String> r114 = r210.c();
        if (r114 != null) goto L16;
    L19:
        boolean r115 = true;
    L20:
        if (r115 == true) goto L38;
        if (r105 != 0) goto L23;
    L26:
        boolean r116 = true;
    L27:
        if (r116 == true) goto L38;
        SpannableString r117 = new SpannableString(r105);
        Iterator<Map.Entry<String, String>> r118 = r114.entrySet().iterator();
    L31:
        if (r118.hasNext() == false) goto L37;
        Map.Entry<String, String> r119 = r118.next();
        if (StringsKt.contains$default(r105, r119.getKey(), false, r101, r102) == false) goto L35;
        SpannableString r106 = r117;
        int r120 = StringsKt.indexOf$default(r105, r119.getKey(), 0, false, 6, null);
        int r121 = r119.getKey().length() + r120;
        r106.setSpan(new w(r119, this), r120, r121, 33);
        int r122 = g1.f45599a;
        r106.setSpan(new ForegroundColorSpan(g1.a.a(getContext(), R.color.primary)), r120, r121, 33);
        r106.setSpan(new NoUnderlineSpan(), r120, r121, 33);
    L36:
        r117 = r106;
        r110 = r110;
        r101 = 2;
        r102 = null;
        goto L31
    L35:
        r106 = r117;
        goto L36
    L37:
        ?? r107 = r110;
    L39:
        if (r117 == null) goto L41;
        r105 = r117;
    L41:
        r107.setText(r105);
        r107.setMovementMethod(LinkMovementMethod.getInstance());
        this.f165471b.addView(r107);
        r104 = r107;
        r101 = 2;
        r102 = null;
        goto L6
    L23:
        if (r105.length() == 0) goto L26;
        r116 = false;
    L38:
        r107 = r110;
        r117 = null;
        goto L39
    L16:
        if (r114.isEmpty() == true) goto L19;
        r115 = false;
    L44:
        if (r104 == 0) goto L53;
        ViewGroup.LayoutParams r108 = r104.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L48;
        r108 = null;
    L48:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        if (r109 != null) goto L51;
        r109 = new ViewGroup.MarginLayoutParams(-2, -2);
    L51:
        r109.bottomMargin = com.bytedance.android.shopping.extensions.b.b(12);
        Unit r123 = Unit.INSTANCE;
        r104.setLayoutParams(r109);
    L53:
        if (Intrinsics.areEqual(r210.b(), Boolean.TRUE) == false) goto L56;
        b();
    L56:
        if (r210.getType() != 1) goto L58;
        this.f165471b.setVisibility(0);
        setExpandedStatus(true);
        this.f165473d.setVisibility(8);
        this.f165472c.setOnClickListener(null);
    L58:
        this.f165472c.setPadding(0, com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12));
        if (r211 == false) goto L61;
        this.f165472c.setPadding(0, com.bytedance.android.shopping.extensions.b.b(16), 0, com.bytedance.android.shopping.extensions.b.b(16));
    L61:
        if (r211 == false) goto L63;
        this.f165470a.setTextSize(2, 14.0f);
        return;
    L63:
        this.f165470a.setTextSize(2, 15.0f);
        return;
    L42:
        r104 = 0;
        goto L44
    }

    public AnchorV3UnifiedTipsSubView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_anchor_v3_unified_tips_sub_view, this);
        this.f165470a = (TextView) findViewById(R.id.anchor_v3_unified_tips_title);
        this.f165471b = (LinearLayout) findViewById(R.id.anchor_v3_unified_tips_answer_container);
        View r103 = findViewById(R.id.anchor_v3_unified_tips_content_root);
        this.f165472c = r103;
        this.f165473d = (ImageView) findViewById(R.id.anchor_v3_unified_tips_arrow);
        r103.setOnClickListener(new a(this));
    }

    public /* synthetic */ AnchorV3UnifiedTipsSubView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
