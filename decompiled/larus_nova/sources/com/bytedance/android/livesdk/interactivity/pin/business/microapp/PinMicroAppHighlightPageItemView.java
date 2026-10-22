package com.bytedance.android.livesdk.interactivity.pin.business.microapp;

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
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.ui.artist.ArtistTextView;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.android.livesdk.interactivity.p;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import g42.c;
import g42.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m92.a;
import m92.b;
import m92.d;
import m92.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/microapp/PinMicroAppHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", "", "getContentHeight", "getMinHeight", "Landroid/view/View;", "m", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinMicroAppHighlightPageItemView extends FrameLayout implements e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f138715n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f138716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArtistTextView f138717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f138718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f138719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f138720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieAnimationView f138721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f138722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f138723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f138724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConstraintLayout f138725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f138726k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Button f138727l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PinMicroAppHighlightPageItemView f138728m;

    public PinMicroAppHighlightPageItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinMicroAppHighlightPageItemView(Context r100, AttributeSet r101) {
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
        return this.f138728m;
    }

    @Override // g42.e
    public final void a(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }

    public final View d(int r100) {
        if (this.f138716a != null) goto L5;
        this.f138716a = new LinkedHashMap();
    L5:
        View r101 = this.f138716a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f138716a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // g42.e
    public final void b(c r100, HighlightItem r101) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        e.a.a(r100, r101);
    }

    @Override // g42.e
    public void update(c r100, HighlightItem r101) {
        Intrinsics.checkNotNullParameter(r100, "pinContainer");
        Intrinsics.checkNotNullParameter(r101, "highlightItem");
        e.a.update(this, r100, r101);
    }

    public PinMicroAppHighlightPageItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f138716a = new LinkedHashMap();
        FrameLayout.inflate(r100, R.layout.ttlive_layout_pin_micro_app_highlight_pager_item, this);
        ArtistTextView r103 = (ArtistTextView) d(R.id.tv_title);
        this.f138717b = r103;
        this.f138718c = (TextView) d(R.id.tv_title_rendertext);
        this.f138720e = d(R.id.review_layout);
        this.f138721f = (LottieAnimationView) d(R.id.waiting);
        this.f138719d = d(R.id.micro_app_layout);
        this.f138722g = (HSImageView) d(R.id.iv_micro_app_cover);
        this.f138723h = (TextView) d(R.id.tv_micro_app_title);
        this.f138724i = (TextView) d(R.id.tv_micro_app_desc);
        this.f138725j = (ConstraintLayout) d(R.id.pin_common);
        this.f138726k = (TextView) d(R.id.common_creator);
        this.f138727l = (Button) d(R.id.common_cancel);
        r103.setTextSize(s1.e(11.0f));
        r103.setTextColor(ColorProtector.parseColor("#99161823"));
        r103.setIncludeFontPadding(false);
        r103.setMaxLines(1);
        r103.setEllipsis("…");
        this.f138728m = this;
    }

    @Override // g42.e
    public final void c(DataCenter r110, c r111, HighlightItem r112) {
        Intrinsics.checkNotNullParameter(r111, "pinContainer");
        Intrinsics.checkNotNullParameter(r112, "highlightItem");
        boolean r113 = z.e(r111.getDataCenter(), false);
        OperateInfo r100 = null;
        if (r112 == null) goto L5;
        HighlightItem.e r114 = r112.getMicroAppData();
    L6:
        if (r114 != null) goto L8;
        this.f138717b.setText("");
        UtilityKotlinExtentionsKt.t(this.f138719d);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.f138717b.setText("@" + r114.e() + " 分享小程序");
        if (r114.isReviewing() == false) goto L11;
        UtilityKotlinExtentionsKt.t(this.f138719d);
        UtilityKotlinExtentionsKt.w(this.f138720e);
        this.f138721f.playAnimation();
        setOnLongClickListener(null);
        setOnClickListener(null);
        setClickable(false);
    L34:
        PinCommon r101 = r114.a();
        if (r101 == null) goto L39;
        Text r102 = r101.getTitle();
        if (r102 == null) goto L39;
        qb2.c.a(r102, new a(this));
    L39:
        if (r101 == null) goto L41;
        r100 = r101.getOperateInfo();
    L41:
        if (r100 == null) goto L53;
        UtilityKotlinExtentionsKt.w(this.f138725j);
        Text r103 = r100.getCreatorText();
        if (r103 == null) goto L45;
        qb2.c.a(r103, new b(this));
    L45:
        if (r113 == true) goto L52;
        String r104 = r100.getCreator();
        if (r104 != null) goto L49;
    L51:
        this.f138727l.setOnClickListener(f.f512589a);
        this.f138727l.setAlpha(0.34f);
        return;
    L49:
        if (r104.equals(r111.getCurrentUserId()) != true) goto L51;
    L52:
        this.f138727l.setOnClickListener(new m92.e(r113, r114));
        this.f138727l.setAlpha(1.0f);
        return;
    L53:
        UtilityKotlinExtentionsKt.t(this.f138725j);
        return;
    L11:
        UtilityKotlinExtentionsKt.t(this.f138720e);
        this.f138721f.pauseAnimation();
        UtilityKotlinExtentionsKt.w(this.f138719d);
        this.f138723h.setText(r114.d());
        this.f138724i.setText(r114.getCommentContent());
        ImageLoader.bindImage(this.f138722g, r114.b());
        if (r113 == false) goto L14;
        setOnLongClickListener(new m92.c(r114));
    L14:
        String r105 = r114.f();
        setOnClickListener(new d(this, r105));
        com.bytedance.android.livesdk.interactivity.api.f r106 = o.b();
        if (r106 == null) goto L21;
        j<i42.b> r107 = r106.getMiniAppPreloader();
        if (r107 == null) goto L21;
        i42.b r108 = r107.getValue();
        if (r108 == null) goto L21;
        r108.a(r105);
    L21:
        if (r105 == null) goto L34;
        RoomContext r109 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r109 == null) goto L30;
        i<Boolean> r115 = r109.isAnchor();
        if (r115 == null) goto L30;
        Boolean r116 = r115.getValue();
        if (r116 == null) goto L30;
        r116.booleanValue();
    L30:
        Pair r117 = p.b(r105, "live_other", g4.d(), "comment_pin", "comment_pin", LaunchParamConstant$Scene.f83957c);
        if (r117 == null) goto L34;
        u.l().h(BdpAppEventConstant.EVENT_MP_SHOW, (Map) r117.getSecond(), new Object[]{Room.class});
        TTLiveSDK.hostService().hostOpenPlatform().preloadMiniApp((String) r117.getFirst());
        goto L34
    L5:
        r114 = null;
        goto L6
    }

    public /* synthetic */ PinMicroAppHighlightPageItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
