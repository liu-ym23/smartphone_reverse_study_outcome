package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.content.Context;
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

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/comment/PinCommentHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", "", "getContentHeight", "getMinHeight", "Landroid/view/View;", ce.f26395j, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinCommentHighlightPageItemView extends FrameLayout implements g42.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f138635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArtistTextView f138636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f138637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f138638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f138639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieAnimationView f138640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f138641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f138642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Button f138643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PinCommentHighlightPageItemView f138644j;

    public PinCommentHighlightPageItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinCommentHighlightPageItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(54);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(R.id.content_layout)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.f138644j;
    }

    @Override // g42.e
    public final void a(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }

    public final View d(int r100) {
        if (this.f138635a != null) goto L5;
        this.f138635a = new LinkedHashMap();
    L5:
        View r101 = this.f138635a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f138635a.put(Integer.valueOf(r100), r102);
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

    public PinCommentHighlightPageItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f138635a = new LinkedHashMap();
        FrameLayout.inflate(r100, R.layout.ttlive_layout_pin_comment_highlight_pager_item, this);
        ArtistTextView r103 = (ArtistTextView) d(R.id.tv_title);
        this.f138636b = r103;
        this.f138638d = (TextView) d(R.id.tv_comment);
        this.f138637c = (TextView) d(R.id.tv_title_rendertext);
        this.f138639e = d(R.id.review_layout);
        this.f138640f = (LottieAnimationView) d(R.id.waiting);
        this.f138641g = (ConstraintLayout) d(R.id.pin_common);
        this.f138642h = (TextView) d(R.id.common_creator);
        this.f138643i = (Button) d(R.id.common_cancel);
        r103.setTextSize(s1.e(11.0f));
        r103.setTextColor(ColorProtector.parseColor("#99161823"));
        r103.setIncludeFontPadding(false);
        r103.setMaxLines(1);
        r103.setEllipsis("…");
        this.f138644j = this;
    }

    @Override // g42.e
    public final void c(DataCenter r100, g42.c r101, HighlightItem r102) {
        Intrinsics.checkNotNullParameter(r101, "pinContainer");
        Intrinsics.checkNotNullParameter(r102, "highlightItem");
        boolean r103 = z.e(r101.getDataCenter(), false);
        OperateInfo r104 = null;
        if (r102 == null) goto L5;
        HighlightItem.c r105 = r102.getCommentData();
    L6:
        if (r105 != null) goto L8;
        this.f138636b.setText("");
        this.f138638d.setText("");
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.f138636b.setText("@" + r105.e());
        if (r105.f162529b == false) goto L11;
        UtilityKotlinExtentionsKt.t(this.f138638d);
        UtilityKotlinExtentionsKt.w(this.f138639e);
        this.f138640f.playAnimation();
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L11:
        UtilityKotlinExtentionsKt.t(this.f138639e);
        this.f138640f.pauseAnimation();
        UtilityKotlinExtentionsKt.w(this.f138638d);
        TextView r106 = this.f138638d;
        String r107 = r105.d();
        if (r107 == null) goto L14;
        CharSequence r108 = com.bytedance.android.livesdk.interactivity.common.utils.g.a(r107, 14);
    L15:
        r106.setText(r108);
        if (r103 == false) goto L18;
        setOnLongClickListener(new c(r105));
    L18:
        PinCommon r109 = r105.c();
        if (r109 == null) goto L23;
        Text r110 = r109.getTitle();
        if (r110 == null) goto L23;
        qb2.c.a(r110, new a(this));
    L23:
        if (r109 == null) goto L25;
        r104 = r109.getOperateInfo();
    L25:
        if (r104 == null) goto L37;
        UtilityKotlinExtentionsKt.w(this.f138641g);
        Text r111 = r104.getCreatorText();
        if (r111 == null) goto L29;
        qb2.c.a(r111, new b(this));
    L29:
        if (r103 == true) goto L36;
        String r112 = r104.getCreator();
        if (r112 != null) goto L33;
    L35:
        this.f138643i.setOnClickListener(e.f138672a);
        this.f138643i.setAlpha(0.34f);
        return;
    L33:
        if (r112.equals(r101.getCurrentUserId()) != true) goto L35;
    L36:
        this.f138643i.setOnClickListener(new d(r103, r105));
        this.f138643i.setAlpha(1.0f);
        return;
    L37:
        UtilityKotlinExtentionsKt.t(this.f138641g);
        return;
    L14:
        r108 = null;
        goto L15
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ PinCommentHighlightPageItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
