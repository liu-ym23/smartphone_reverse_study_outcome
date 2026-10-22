package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.ui.artist.ArtistTextView;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/qa/PinAnswerHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", "", "getContentHeight", "getMinHeight", "Landroid/view/View;", ce.f26396k, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinAnswerHighlightPageItemView extends FrameLayout implements g42.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f138731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArtistTextView f138732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f138733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArtistTextView f138734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f138735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f138736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LottieAnimationView f138737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConstraintLayout f138738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f138739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Button f138740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PinAnswerHighlightPageItemView f138741k;

    public PinAnswerHighlightPageItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinAnswerHighlightPageItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(72);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(R.id.content_layout)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.f138741k;
    }

    @Override // g42.e
    public final void a(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }

    public final View d(int r100) {
        if (this.f138731a != null) goto L5;
        this.f138731a = new LinkedHashMap();
    L5:
        View r101 = this.f138731a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f138731a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // g42.e
    public final void b(g42.c r100, HighlightItem r101) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        g42.e.a.a(r100, r101);
    }

    @Override // g42.e
    public void update(g42.c r100, HighlightItem r101) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r101, "highlightItem");
        g42.e.a.update(this, r100, r101);
    }

    public PinAnswerHighlightPageItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f138731a = new LinkedHashMap();
        FrameLayout.inflate(r100, R.layout.ttlive_layout_qa_highlight_pager_item, this);
        ArtistTextView r103 = (ArtistTextView) d(R.id.tv_title);
        this.f138732b = r103;
        this.f138733c = (TextView) d(R.id.tv_title_rendertext);
        ArtistTextView r104 = (ArtistTextView) d(R.id.tv_question);
        this.f138734d = r104;
        this.f138735e = (TextView) d(R.id.tv_answer);
        this.f138736f = d(R.id.review_layout);
        this.f138737g = (LottieAnimationView) d(R.id.waiting);
        this.f138738h = (ConstraintLayout) d(R.id.pin_common);
        this.f138739i = (TextView) d(R.id.common_creator);
        this.f138740j = (Button) d(R.id.common_cancel);
        r103.setTextSize(s1.e(11.0f));
        r103.setTextColor(ColorProtector.parseColor("#99161823"));
        r103.setIncludeFontPadding(true);
        r103.setMaxLines(1);
        r103.setEllipsis("…");
        r104.setTextSize(s1.e(11.0f));
        r104.setTextColor(ColorProtector.parseColor("#99161823"));
        r104.setIncludeFontPadding(false);
        r104.setMaxLines(1);
        r104.setEllipsis("…”");
        this.f138741k = this;
    }

    @Override // g42.e
    public final void c(DataCenter r110, g42.c r111, HighlightItem r112) {
        Intrinsics.checkNotNullParameter(r111, "pinContainer");
        Intrinsics.checkNotNullParameter(r112, "highlightItem");
        boolean r113 = z.e(r111.getDataCenter(), false);
        if (r112 == null) goto L5;
        final HighlightItem.a r114 = r112.getAnswerData();
    L6:
        if (r114 != null) goto L9;
        this.f138732b.setText("");
        this.f138734d.setText("");
        this.f138735e.setText("");
        this.f138735e.setOnClickListener(null);
        this.f138735e.setOnLongClickListener(null);
        this.f138735e.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L9:
        if (r114.d() <= 1) goto L21;
        String r100 = r114.e();
        if (r100 != null) goto L13;
    L16:
        boolean r101 = true;
    L17:
        if (r101 == true) goto L19;
        String r102 = r114.e();
    L20:
        this.f138732b.setEllipsis("…等" + r102 + "人问");
        this.f138732b.setText("@" + r114.h() + 31561 + r102 + "人问");
    L22:
        SpannableStringBuilder r103 = new SpannableStringBuilder().append("“");
        String r104 = r114.i();
        if (r104 == null) goto L25;
        CharSequence r105 = com.bytedance.android.livesdk.interactivity.common.utils.g.a(r104, 11);
    L26:
        this.f138734d.setText(r103.append(r105).append("”"));
        if (r114.f162527b == false) goto L29;
        UtilityKotlinExtentionsKt.t(this.f138735e);
        UtilityKotlinExtentionsKt.w(this.f138736f);
        this.f138737g.playAnimation();
        this.f138735e.setOnClickListener(null);
        this.f138735e.setOnLongClickListener(null);
        this.f138735e.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
    L36:
        PinCommon r106 = r114.g();
        if (r106 == null) goto L41;
        Text r107 = r106.getTitle();
        if (r107 == null) goto L41;
        qb2.c.a(r107, new a(this));
    L41:
        if (r106 == null) goto L43;
        OperateInfo r108 = r106.getOperateInfo();
    L44:
        if (r108 == null) goto L60;
        UtilityKotlinExtentionsKt.w(this.f138738h);
        Text r109 = r108.getCreatorText();
        if (r109 == null) goto L48;
        qb2.c.a(r109, new b(this));
    L48:
        if (r113 == true) goto L55;
        String r115 = r108.getCreator();
        if (r115 != null) goto L52;
    L54:
        this.f138740j.setOnClickListener(d.f138752a);
        this.f138740j.setAlpha(0.34f);
        return;
    L52:
        if (r115.equals(r111.getCurrentUserId()) != true) goto L54;
    L55:
        this.f138740j.setOnClickListener(new c(r113, r114));
        this.f138740j.setAlpha(1.0f);
        this.f138735e.setOnClickListener(null);
        String r116 = r108.getCreator();
        if (r116 != null) goto L58;
        return;
    L58:
        if (r116.equals(r111.getCurrentUserId()) != true) goto L65;
        this.f138735e.setOnClickListener(x0.a(new PinAnswerHighlightPageItemView$doBindView$5(r114)));
        return;
    L65:
        return;
    L60:
        UtilityKotlinExtentionsKt.t(this.f138738h);
        return;
    L43:
        r108 = null;
        goto L44
    L29:
        UtilityKotlinExtentionsKt.t(this.f138736f);
        this.f138737g.pauseAnimation();
        UtilityKotlinExtentionsKt.w(this.f138735e);
        TextView r117 = this.f138735e;
        String r118 = r114.a();
        if (r118 == null) goto L32;
        CharSequence r119 = com.bytedance.android.livesdk.interactivity.common.utils.g.a(r118, 14);
    L33:
        r117.setText(r119);
        if (r113 == false) goto L36;
        this.f138735e.setOnClickListener(x0.a(new PinAnswerHighlightPageItemView$doBindView$1(r114)));
        e r120 = new e(r114);
        this.f138735e.setOnLongClickListener(r120);
        setOnLongClickListener(r120);
        goto L36
    L32:
        r119 = null;
        goto L33
    L25:
        r105 = null;
        goto L26
    L19:
        r102 = String.valueOf(r114.d());
        goto L20
    L13:
        if (StringsKt.isBlank(r100) == true) goto L16;
        r101 = false;
        goto L17
    L21:
        this.f138732b.setEllipsis("… 问");
        this.f138732b.setText("@" + r114.h() + " 问");
        goto L22
    L5:
        r114 = null;
        goto L6
    }

    public /* synthetic */ PinAnswerHighlightPageItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
