package com.bytedance.android.livesdk.interactivity.pin.business.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ui.artist.ArtistTextView;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.interactivity.pin.utils.PinAppLogger;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import g42.e;
import hd0.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n92.a;
import n92.b;
import n92.d;
import n92.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/video/PinVideoHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", "", "getContentHeight", "getMinHeight", "Landroid/view/View;", "m", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinVideoHighlightPageItemView extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f138766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArtistTextView f138767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f138768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f138769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f138770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieAnimationView f138771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f138772g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f138773h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f138774i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConstraintLayout f138775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f138776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Button f138777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PinVideoHighlightPageItemView f138778m;

    public PinVideoHighlightPageItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinVideoHighlightPageItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(74);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(R.id.content_layout)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.f138778m;
    }

    @Override // g42.e
    public final void a(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        HighlightItem.f r101 = r100.getVideoData();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isReviewing() == true) goto L20;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L14;
        i<Boolean> r103 = r102.isAnchor();
        if (r103 == null) goto L14;
        if (r103.getValue().booleanValue() != true) goto L14;
        String r104 = "anchor";
    L17:
        PinAppLogger.g(String.valueOf(r100.getItemId()), r104);
        return;
    L14:
        if (c.f().h() == false) goto L16;
        r104 = "guest";
        goto L17
    L16:
        r104 = SourceType.DEFAULT;
        goto L17
    }

    public final View d(int r100) {
        if (this.f138766a != null) goto L5;
        this.f138766a = new LinkedHashMap();
    L5:
        View r101 = this.f138766a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f138766a.put(Integer.valueOf(r100), r102);
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
        e.a.a(r100, r101);
    }

    @Override // g42.e
    public void update(g42.c r100, HighlightItem r101) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r101, "highlightItem");
        e.a.update(this, r100, r101);
    }

    public PinVideoHighlightPageItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f138766a = new LinkedHashMap();
        FrameLayout.inflate(r100, R.layout.ttlive_layout_pin_video_highlight_pager_item, this);
        ArtistTextView r103 = (ArtistTextView) d(R.id.video_title);
        this.f138767b = r103;
        this.f138768c = (TextView) d(R.id.tv_title_rendertext);
        this.f138769d = (TextView) d(R.id.video_content);
        this.f138770e = d(R.id.review_layout);
        this.f138771f = (LottieAnimationView) d(R.id.waiting);
        this.f138772g = (HSImageView) d(R.id.video_cover);
        this.f138774i = (LinearLayout) d(R.id.content_layout);
        this.f138773h = (FrameLayout) d(R.id.video_cover_container);
        this.f138775j = (ConstraintLayout) d(R.id.pin_common);
        this.f138776k = (TextView) d(R.id.common_creator);
        this.f138777l = (Button) d(R.id.common_cancel);
        r103.setTextSize(s1.e(11.0f));
        r103.setTextColor(ColorProtector.parseColor("#99161823"));
        r103.setIncludeFontPadding(false);
        r103.setMaxLines(1);
        r103.setEllipsis("…");
        this.f138778m = this;
    }

    @Override // g42.e
    public final void c(DataCenter r100, g42.c r101, HighlightItem r110) {
        Intrinsics.checkNotNullParameter(r101, "pinContainer");
        Intrinsics.checkNotNullParameter(r110, "highlightItem");
        boolean r102 = false;
        boolean r103 = z.e(r101.getDataCenter(), false);
        OperateInfo r104 = null;
        if (r110 == null) goto L5;
        HighlightItem.f r111 = r110.getVideoData();
    L6:
        if (r111 != null) goto L8;
        this.f138767b.setText("");
        this.f138769d.setText("");
        this.f138774i.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.f138767b.setEllipsis("… 分享视频");
        this.f138767b.setText("@" + r111.c() + " 分享视频");
        ImageModel r105 = new ImageModel();
        ArrayList r106 = new ArrayList();
        String r107 = r111.f();
        if (r107 == null) goto L11;
        r106.add(r107);
    L11:
        r105.setUrls(r106);
        ImageUtil.loadImage(this.f138772g, r105, 0);
        if (r111.isReviewing() == false) goto L14;
        UtilityKotlinExtentionsKt.w(this.f138770e);
        this.f138771f.playAnimation();
        this.f138769d.setMaxLines(1);
        this.f138769d.setAlpha(0.34f);
        this.f138773h.setAlpha(0.34f);
        setOnLongClickListener(null);
        setOnClickListener(null);
        setClickable(false);
    L18:
        String r108 = r111.e();
        if (r108 != null) goto L21;
    L22:
        r102 = true;
    L23:
        if (r102 == false) goto L25;
        r108 = s1.B(R.string.ttlive_pin_video_title_default);
    L25:
        this.f138769d.setText(r108);
        PinCommon r109 = r111.a();
        if (r109 == null) goto L30;
        Text r112 = r109.getTitle();
        if (r112 == null) goto L30;
        qb2.c.a(r112, new a(this));
    L30:
        if (r109 == null) goto L32;
        r104 = r109.getOperateInfo();
    L32:
        if (r104 == null) goto L44;
        UtilityKotlinExtentionsKt.w(this.f138775j);
        Text r113 = r104.getCreatorText();
        if (r113 == null) goto L36;
        qb2.c.a(r113, new b(this));
    L36:
        if (r103 == true) goto L43;
        String r114 = r104.getCreator();
        if (r114 != null) goto L40;
    L42:
        this.f138777l.setOnClickListener(d.f518391a);
        this.f138777l.setAlpha(0.34f);
        return;
    L40:
        if (r114.equals(r101.getCurrentUserId()) != true) goto L42;
    L43:
        this.f138777l.setOnClickListener(new n92.c(r103, r111));
        this.f138777l.setAlpha(1.0f);
        return;
    L44:
        UtilityKotlinExtentionsKt.t(this.f138775j);
        return;
    L21:
        if (r108.length() != 0) goto L23;
    L14:
        UtilityKotlinExtentionsKt.t(this.f138770e);
        this.f138769d.setMaxLines(2);
        this.f138769d.setAlpha(1.0f);
        this.f138773h.setAlpha(1.0f);
        this.f138771f.pauseAnimation();
        setClickable(true);
        if (r103 == false) goto L17;
        setOnLongClickListener(new f(r111));
    L17:
        setOnClickListener(new n92.e(r111));
        goto L18
    L5:
        r111 = null;
        goto L6
    }

    public /* synthetic */ PinVideoHighlightPageItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
