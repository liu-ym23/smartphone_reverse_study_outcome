package com.bytedance.android.livesdk.interactivity.pin.business.im;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.OperateInfo;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PictureTextStyle;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.PinCommon;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import g42.c;
import g42.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l92.a;
import l92.b;
import l92.d;
import l92.f;
import l92.g;
import l92.h;
import l92.i;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/im/PinImHighlightPageItemView;", "Landroid/widget/FrameLayout;", "Lg42/e;", "", "getContentHeight", "getMinHeight", "Landroid/view/View;", "b", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PinImHighlightPageItemView extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f138699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PinImHighlightPageItemView f138700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f138701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f138702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f138703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LottieAnimationView f138704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConstraintLayout f138705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f138706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Button f138707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinearLayout f138708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RelativeLayout f138709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HSImageView f138710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f138711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f138712n;

    public PinImHighlightPageItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinImHighlightPageItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // g42.e
    public int getMinHeight() {
        return UtilityKotlinExtentionsKt.i(52);
    }

    @Override // g42.e
    public int getContentHeight() {
        return ((LinearLayout) d(R.id.content_layout)).getHeight();
    }

    @Override // g42.e
    public View getView() {
        return this.f138700b;
    }

    @Override // g42.e
    public final void a(HighlightItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }

    public final View d(int r100) {
        if (this.f138699a != null) goto L5;
        this.f138699a = new LinkedHashMap();
    L5:
        View r101 = this.f138699a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f138699a.put(Integer.valueOf(r100), r102);
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

    public PinImHighlightPageItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f138699a = new LinkedHashMap();
        this.f138700b = this;
        FrameLayout.inflate(r100, R.layout.ttlive_layout_pin_im_highlight_pager_item, this);
        this.f138701c = (TextView) d(R.id.tv_title);
        this.f138702d = (TextView) d(R.id.tv_content);
        this.f138703e = (LinearLayout) d(R.id.review_layout);
        this.f138704f = (LottieAnimationView) d(R.id.waiting);
        this.f138708j = (LinearLayout) d(R.id.content_layout);
        this.f138705g = (ConstraintLayout) d(R.id.pin_common);
        this.f138706h = (TextView) d(R.id.common_creator);
        this.f138707i = (Button) d(R.id.common_cancel);
        this.f138709k = (RelativeLayout) d(R.id.style_imgtext);
        this.f138710l = (HSImageView) d(R.id.iv_img);
        this.f138711m = (TextView) d(R.id.tv_text);
        this.f138712n = (TextView) d(R.id.tv_sub_text);
    }

    @Override // g42.e
    public final void c(DataCenter r100, c r101, HighlightItem r102) {
        Intrinsics.checkNotNullParameter(r101, "pinContainer");
        Intrinsics.checkNotNullParameter(r102, "highlightItem");
        boolean r103 = z.e(r101.getDataCenter(), false);
        OperateInfo r104 = null;
        if (r102 == null) goto L5;
        HighlightItem.d r105 = r102.getImData();
    L6:
        if (r105 != null) goto L8;
        this.f138701c.setText("");
        this.f138702d.setText("");
        this.f138708j.setClickable(false);
        setOnLongClickListener(null);
        setClickable(false);
        return;
    L8:
        this.f138701c.setText(String.valueOf(r105.d()));
        if (r105.isReviewing() == false) goto L11;
        UtilityKotlinExtentionsKt.t(this.f138702d);
        UtilityKotlinExtentionsKt.w(this.f138703e);
        this.f138704f.playAnimation();
        setOnLongClickListener(null);
        setOnClickListener(null);
        setClickable(false);
    L31:
        PinCommon r106 = r105.a();
        if (r106 == null) goto L36;
        Text r107 = r106.getTitle();
        if (r107 == null) goto L36;
        qb2.c.a(r107, new l92.e(this));
    L36:
        if (r106 == null) goto L38;
        r104 = r106.getOperateInfo();
    L38:
        if (r104 == null) goto L50;
        UtilityKotlinExtentionsKt.w(this.f138705g);
        Text r108 = r104.getCreatorText();
        if (r108 == null) goto L42;
        qb2.c.a(r108, new f(this));
    L42:
        if (r103 == true) goto L49;
        String r109 = r104.getCreator();
        if (r109 != null) goto L46;
    L48:
        this.f138707i.setOnClickListener(h.f508104a);
        this.f138707i.setAlpha(0.34f);
        return;
    L46:
        if (r109.equals(r101.getCurrentUserId()) != true) goto L48;
    L49:
        this.f138707i.setOnClickListener(new g(r103, r105));
        this.f138707i.setAlpha(1.0f);
        return;
    L50:
        UtilityKotlinExtentionsKt.t(this.f138705g);
        return;
    L11:
        UtilityKotlinExtentionsKt.w(this.f138702d);
        UtilityKotlinExtentionsKt.t(this.f138703e);
        this.f138704f.pauseAnimation();
        setClickable(true);
        PictureTextStyle r110 = r105.c();
        if (r110 == null) goto L26;
        ImageModel r111 = r110.getPicture();
        if (r111 == null) goto L16;
        ImageLoader.bindImage(this.f138710l, r111);
    L16:
        Text r112 = r110.getText();
        if (r112 == null) goto L19;
        qb2.c.a(r112, new a(this));
    L19:
        Text r113 = r110.getSubText();
        if (r113 == null) goto L22;
        qb2.c.a(r113, new b(this));
    L22:
        String r114 = r110.getSchema();
        if (r114 == null) goto L25;
        setOnClickListener(new l92.c(r114, this));
    L25:
        UtilityKotlinExtentionsKt.w(this.f138709k);
        UtilityKotlinExtentionsKt.t(this.f138702d);
    L29:
        if (r103 == false) goto L31;
        setOnLongClickListener(new i(r105));
        goto L31
    L26:
        Text r115 = r105.b();
        if (r115 == null) goto L29;
        qb2.c.a(r115, new d(this));
        UtilityKotlinExtentionsKt.t(this.f138709k);
        UtilityKotlinExtentionsKt.w(this.f138702d);
        goto L29
    L5:
        r105 = null;
        goto L6
    }

    public /* synthetic */ PinImHighlightPageItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
