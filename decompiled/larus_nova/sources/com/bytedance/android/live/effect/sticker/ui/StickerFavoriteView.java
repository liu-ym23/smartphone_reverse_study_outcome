package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\r\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0016R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00063"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMIconIV", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteImageView;", "mIconIV", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "b", "getMTipTV", "()Landroid/widget/TextView;", "mTipTV", "Landroid/view/View;", "c", "getClickProxy", "()Landroid/view/View;", "clickProxy", "", "d", "getMTipTextNormal", "()Ljava/lang/String;", "mTipTextNormal", "e", "getMTipTextSelected", "mTipTextSelected", "Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;", RXScreenCaptureService.KEY_INDEX, "Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;", "getFavoriteStatusListener", "()Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;", "setFavoriteStatusListener", "(Lcom/bytedance/android/live/effect/sticker/ui/StickerFavoriteView$a;)V", "favoriteStatusListener", "", ce.f26395j, "Z", "getShowEnable", "()Z", "setShowEnable", "(Z)V", "showEnable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerFavoriteView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f68461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f68462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f68463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f68464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Sticker f68465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f68466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f68467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f68468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Sticker f68469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f68470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f68471m;

    public interface a {
        void a(Sticker r100, boolean r101);
    }

    public StickerFavoriteView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StickerFavoriteView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getClickProxy() {
        return (View) this.f68461c.getValue();
    }

    private final StickerFavoriteImageView getMIconIV() {
        return (StickerFavoriteImageView) this.f68459a.getValue();
    }

    private final TextView getMTipTV() {
        return (TextView) this.f68460b.getValue();
    }

    private final String getMTipTextNormal() {
        return (String) this.f68462d.getValue();
    }

    private final String getMTipTextSelected() {
        return (String) this.f68463e.getValue();
    }

    public final a getFavoriteStatusListener() {
        return this.f68467i;
    }

    public final boolean getShowEnable() {
        return this.f68468j;
    }

    public static final /* synthetic */ StickerFavoriteImageView a(StickerFavoriteView r100) {
        return r100.getMIconIV();
    }

    public static final /* synthetic */ TextView b(StickerFavoriteView r100) {
        return r100.getMTipTV();
    }

    public static final /* synthetic */ String c(StickerFavoriteView r100) {
        return r100.getMTipTextNormal();
    }

    public static final /* synthetic */ String d(StickerFavoriteView r100) {
        return r100.getMTipTextSelected();
    }

    public final void setFavoriteStatusListener(a r100) {
        this.f68467i = r100;
    }

    public final void setShowEnable(boolean r100) {
        this.f68468j = r100;
    }

    public final void e(Sticker r100, boolean r101) {
        if (this.f68466h == true) goto L5;
        this.f68469k = r100;
        this.f68470l = r101;
        this.f68471m = true;
        return;
    L5:
        f(r100, r101, new StickerFavoriteView$refresh$1(this));
    }

    public StickerFavoriteView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f68459a = LazyKt.lazy(new StickerFavoriteView$mIconIV$2(this));
        this.f68460b = LazyKt.lazy(new StickerFavoriteView$mTipTV$2(this));
        this.f68461c = LazyKt.lazy(new StickerFavoriteView$clickProxy$2(this));
        this.f68462d = LazyKt.lazy(new StickerFavoriteView$mTipTextNormal$2(r100));
        this.f68463e = LazyKt.lazy(new StickerFavoriteView$mTipTextSelected$2(r100));
        this.f68466h = true;
        this.f68468j = true;
        this.f68470l = true;
        LinearLayout.inflate(r100, R.layout.ttlive_effect_dialog_favorite_layout, this);
        View.OnClickListener r103 = new StickerFavoriteView$bindClickListener$listener$1(this);
        setOnClickListener(r103);
        getClickProxy().setOnClickListener(r103);
        r3.e(getClickProxy(), new StickerFavoriteView$bindClickListener$1(this));
        getMIconIV().setOnStateChangeListener(new n(this));
    }

    public final void f(Sticker r100, boolean r101, Function0<Unit> r102) {
        if (this.f68468j == true) goto L6;
        setVisibility(8);
        return;
    L6:
        if (r100 != null) goto L9;
        setVisibility(4);
        return;
    L9:
        setVisibility(0);
        this.f68465g = r100;
        this.f68464f = r101;
        r102.invoke();
    }

    public /* synthetic */ StickerFavoriteView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
