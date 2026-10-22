package com.bytedance.android.live.effect.sticker.ui.aigc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.r3;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020-¢\u0006\u0004\bW\u0010XJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0016R\u001d\u0010\"\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001d\u0010%\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011R\u001d\u0010(\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b'\u0010\u0016R\u001b\u0010,\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000f\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000f\u001a\u0004\b3\u0010+R\u001b\u00107\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000f\u001a\u0004\b6\u00100R\u001b\u0010:\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010+R\u001b\u0010=\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u000f\u001a\u0004\b<\u00100R\u001b\u0010@\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000f\u001a\u0004\b?\u0010+R\u001b\u0010C\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\u000f\u001a\u0004\bB\u00100R\u001b\u0010F\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u000f\u001a\u0004\bE\u00100R\u001b\u0010I\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000f\u001a\u0004\bH\u00100R\"\u0010Q\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006Y"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/aigc/AigcTaskPanel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "percent", "", "setProgressPercent", "", "", "list", "setKeywordList", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/b;", "listener", "setListener", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getKeywordTitleTextview", "()Landroid/widget/TextView;", "keywordTitleTextview", "Landroid/view/View;", "b", "getKeywordSelectorContainerView", "()Landroid/view/View;", "keywordSelectorContainerView", "Lcom/bytedance/android/live/effect/sticker/ui/aigc/HorizontalScrollItemSelector;", "c", "getKeywordSelectorContentView", "()Lcom/bytedance/android/live/effect/sticker/ui/aigc/HorizontalScrollItemSelector;", "keywordSelectorContentView", "d", "getButtonContainerView", "buttonContainerView", "e", "getWhiteButtonView", "whiteButtonView", "f", "getBlueButtonView", "blueButtonView", ce.f26391f, "getProgressView", "progressView", "h", "getCommitTaskButtonText", "()Ljava/lang/String;", "commitTaskButtonText", "", RXScreenCaptureService.KEY_INDEX, "getCommitTaskButtonWidth", "()I", "commitTaskButtonWidth", ce.f26395j, "getReCommitTaskButtonText", "reCommitTaskButtonText", ce.f26396k, "getReCommitTaskButtonWidth", "reCommitTaskButtonWidth", "l", "getApplyBackgroundButtonText", "applyBackgroundButtonText", "m", "getApplyBackgroundButtonWidth", "applyBackgroundButtonWidth", OfficeSDKRequestTag.KEY_NEW_USER, "getReSelectKeywordButtonText", "reSelectKeywordButtonText", "o", "getReSelectKeywordButtonWidth", "reSelectKeywordButtonWidth", "p", "getRunningKeywordTitleTopMargin", "runningKeywordTitleTopMargin", "q", "getDoneKeywordTitleTopMargin", "doneKeywordTitleTopMargin", "", BaseSwitches.V, "J", "getCurrentEffectID", "()J", "setCurrentEffectID", "(J)V", "currentEffectID", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AigcTaskPanel extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f68496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f68497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f68498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f68499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f68500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f68501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f68502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f68503j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f68504k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f68505l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f68506m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f68507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f68508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f68509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f68510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AigcTaskPanelStatus f68511r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<String> f68512s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.android.live.effect.sticker.ui.aigc.b f68513t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ValueAnimator f68514u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f68515v;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AigcTaskPanel f68516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f68517b;

        public b(AigcTaskPanel r100, String r101) {
            this.f68516a = r100;
            this.f68517b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            HorizontalScrollItemSelector r101 = AigcTaskPanel.R5(this.f68516a);
            if (r101 == null) goto L5;
            r101.c();
        L5:
            this.f68516a.U5(false);
            com.bytedance.android.live.effect.sticker.ui.aigc.b r102 = this.f68516a.f68513t;
            if (r102 == null) goto L9;
            r102.a(this.f68517b);
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AigcTaskPanel f68518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f68519b;

        public c(AigcTaskPanel r100, String r101) {
            this.f68518a = r100;
            this.f68519b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.live.effect.sticker.ui.aigc.b r101 = this.f68518a.f68513t;
            if (r101 == null) goto L6;
            r101.c(this.f68519b, AigcTaskPanelClickType.ReGenerate);
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AigcTaskPanel f68520a;

        public d(AigcTaskPanel r100) {
            this.f68520a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.android.live.effect.sticker.ui.aigc.b r101 = this.f68520a.f68513t;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public static final class e implements com.bytedance.android.live.effect.sticker.ui.aigc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f68521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AigcTaskPanel f68522b;

        @Override // com.bytedance.android.live.effect.sticker.ui.aigc.c
        public final void a() {
            TextView r100 = this.f68521a;
            HorizontalScrollItemSelector r101 = AigcTaskPanel.R5(this.f68522b);
            if (r101 == null) goto L5;
            int r102 = r101.getCurrentSelectItemIndex();
        L6:
            if (r102 < 0) goto L8;
            boolean r103 = true;
        L9:
            r100.setActivated(r103);
            TextView r104 = this.f68521a;
            r104.setEnabled(r104.isActivated());
            return;
        L8:
            r103 = false;
            goto L9
        L5:
            r102 = -1;
            goto L6
        }

        public e(TextView r100, AigcTaskPanel r101) {
            this.f68521a = r100;
            this.f68522b = r101;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AigcTaskPanel f68523a;

        public f(AigcTaskPanel r100) {
            this.f68523a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            HorizontalScrollItemSelector r101 = AigcTaskPanel.R5(this.f68523a);
            if (r101 == null) goto L6;
            String r102 = r101.getCurrentSelectKeyword();
            if (r102 == null) goto L6;
        L8:
            if (r102.length() <= 0) goto L10;
            boolean r103 = true;
        L11:
            if (r103 == false) goto L16;
            com.bytedance.android.live.effect.sticker.ui.aigc.b r104 = this.f68523a.f68513t;
            if (r104 == null) goto L17;
            r104.c(r102, AigcTaskPanelClickType.Generate);
            return;
        L17:
            return;
        L16:
            return;
        L10:
            r103 = false;
        L6:
            r102 = "";
            goto L8
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AigcTaskPanel f68524a;

        public g(AigcTaskPanel r100) {
            this.f68524a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AigcTaskPanel.S5(this.f68524a, 0.9f);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public AigcTaskPanel(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AigcTaskPanel(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final String getApplyBackgroundButtonText() {
        return (String) this.f68505l.getValue();
    }

    private final int getApplyBackgroundButtonWidth() {
        return ((Number) this.f68506m.getValue()).intValue();
    }

    private final TextView getBlueButtonView() {
        return (TextView) this.f68499f.getValue();
    }

    private final View getButtonContainerView() {
        return (View) this.f68497d.getValue();
    }

    private final String getCommitTaskButtonText() {
        return (String) this.f68501h.getValue();
    }

    private final int getCommitTaskButtonWidth() {
        return ((Number) this.f68502i.getValue()).intValue();
    }

    private final int getDoneKeywordTitleTopMargin() {
        return ((Number) this.f68510q.getValue()).intValue();
    }

    private final View getKeywordSelectorContainerView() {
        return (View) this.f68495b.getValue();
    }

    private final HorizontalScrollItemSelector getKeywordSelectorContentView() {
        return (HorizontalScrollItemSelector) this.f68496c.getValue();
    }

    private final TextView getKeywordTitleTextview() {
        return (TextView) this.f68494a.getValue();
    }

    private final View getProgressView() {
        return (View) this.f68500g.getValue();
    }

    private final String getReCommitTaskButtonText() {
        return (String) this.f68503j.getValue();
    }

    private final int getReCommitTaskButtonWidth() {
        return ((Number) this.f68504k.getValue()).intValue();
    }

    private final String getReSelectKeywordButtonText() {
        return (String) this.f68507n.getValue();
    }

    private final int getReSelectKeywordButtonWidth() {
        return ((Number) this.f68508o.getValue()).intValue();
    }

    private final int getRunningKeywordTitleTopMargin() {
        return ((Number) this.f68509p.getValue()).intValue();
    }

    private final TextView getWhiteButtonView() {
        return (TextView) this.f68498e.getValue();
    }

    public final void reset() {
        this.f68511r = AigcTaskPanelStatus.Default;
        ((ArrayList) this.f68512s).clear();
        this.f68515v = 0;
        HorizontalScrollItemSelector r100 = getKeywordSelectorContentView();
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public final long getCurrentEffectID() {
        return this.f68515v;
    }

    public static final /* synthetic */ HorizontalScrollItemSelector R5(AigcTaskPanel r100) {
        return r100.getKeywordSelectorContentView();
    }

    private final void setProgressPercent(float r100) {
        View r101 = getProgressView();
        if (r101 == null) goto L12;
        View r102 = getProgressView();
        if (r102 == null) goto L9;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L9;
        r103.width = (int) (getWidth() * r100);
        Unit r104 = Unit.INSTANCE;
    L10:
        r101.setLayoutParams(r103);
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final void T5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        AigcTaskPanelStatus r101 = this.f68511r;
        if (r101 != AigcTaskPanelStatus.Running) goto L5;
    L8:
        this.f68511r = AigcTaskPanelStatus.Done;
        TextView r102 = getKeywordTitleTextview();
        if (r102 == null) goto L11;
        r102.setText(r100);
        r102.setVisibility(0);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        a1.o(r102, getDoneKeywordTitleTopMargin());
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
    L11:
        View r105 = getKeywordSelectorContainerView();
        if (r105 == null) goto L14;
        r105.setVisibility(8);
    L14:
        ValueAnimator r106 = this.f68514u;
        if (r106 == null) goto L17;
        r106.cancel();
    L17:
        View r107 = getProgressView();
        if (r107 == null) goto L20;
        r107.setVisibility(8);
    L20:
        View r108 = getButtonContainerView();
        if (r108 == null) goto L23;
        r108.setVisibility(0);
    L23:
        TextView r109 = getWhiteButtonView();
        if (r109 == null) goto L26;
        r109.setVisibility(0);
        r109.setText(getReSelectKeywordButtonText());
        r109.setWidth(getReSelectKeywordButtonWidth());
        r109.setOnClickListener(new b(this, r100));
    L26:
        TextView r110 = getBlueButtonView();
        if (r110 == null) goto L29;
        r110.setVisibility(0);
        r110.setActivated(true);
        r110.setText(getReCommitTaskButtonText());
        r110.setWidth(getReCommitTaskButtonWidth());
        r110.setOnClickListener(new c(this, r100));
    L29:
        com.bytedance.android.live.effect.sticker.ui.aigc.b r111 = this.f68513t;
        if (r111 == null) goto L34;
        r111.d(this.f68511r);
        return;
    L34:
        return;
    L5:
        if (r101 == AigcTaskPanelStatus.Default) goto L8;
        ALogger.e("ttlive_anchor_effect_AigcTaskPanekl", this.f68511r.name() + " cannot convert to done");
    }

    public final void U5(boolean r100) {
        AigcTaskPanelStatus r101 = this.f68511r;
        if (r101 != AigcTaskPanelStatus.Done) goto L5;
    L10:
        this.f68511r = AigcTaskPanelStatus.Ready;
        TextView r102 = getKeywordTitleTextview();
        int r103 = 8;
        if (r102 == null) goto L13;
        r102.setVisibility(8);
    L13:
        View r104 = getKeywordSelectorContainerView();
        boolean r105 = false;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
    L16:
        ValueAnimator r106 = this.f68514u;
        if (r106 == null) goto L19;
        r106.cancel();
    L19:
        View r107 = getProgressView();
        if (r107 == null) goto L22;
        r107.setVisibility(8);
    L22:
        View r108 = getButtonContainerView();
        if (r108 == null) goto L25;
        r108.setVisibility(0);
    L25:
        TextView r109 = getWhiteButtonView();
        if (r109 == null) goto L31;
        r109.setText(getApplyBackgroundButtonText());
        r109.setWidth(getApplyBackgroundButtonWidth());
        if (r100 == false) goto L30;
        r103 = 0;
    L30:
        r109.setVisibility(r103);
        r109.setOnClickListener(new d(this));
    L31:
        TextView r110 = getBlueButtonView();
        if (r110 == null) goto L43;
        r110.setVisibility(0);
        r110.setText(getCommitTaskButtonText());
        r110.setWidth(getCommitTaskButtonWidth());
        HorizontalScrollItemSelector r111 = getKeywordSelectorContentView();
        if (r111 == null) goto L36;
        int r112 = r111.getCurrentSelectItemIndex();
    L37:
        if (r112 < 0) goto L39;
        r105 = true;
    L39:
        r110.setActivated(r105);
        r110.setEnabled(r110.isActivated());
        r3.e(r110, new AigcTaskPanel$onStatusReady$2$1());
        HorizontalScrollItemSelector r113 = getKeywordSelectorContentView();
        if (r113 == null) goto L42;
        r113.setItemSelectListener(new e(r110, this));
    L42:
        r110.setOnClickListener(new f(this));
        goto L43
    L36:
        r112 = -1;
    L43:
        com.bytedance.android.live.effect.sticker.ui.aigc.b r114 = this.f68513t;
        if (r114 == null) goto L48;
        r114.d(this.f68511r);
        return;
    L48:
        return;
    L5:
        if (r101 == AigcTaskPanelStatus.Default) goto L10;
        if (r101 == AigcTaskPanelStatus.Running) goto L10;
        ALogger.e("ttlive_anchor_effect_AigcTaskPanekl", this.f68511r.name() + " cannot convert to ready");
    }

    public final void setCurrentEffectID(long r100) {
        this.f68515v = r100;
    }

    public final void setKeywordList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        ((ArrayList) this.f68512s).clear();
        ArrayList r101 = (ArrayList) this.f68512s;
        r101.addAll(r100);
        HorizontalScrollItemSelector r102 = getKeywordSelectorContentView();
        if (r102 == null) goto L6;
        r102.setKeywordList(r100);
        return;
    }

    public final void setListener(com.bytedance.android.live.effect.sticker.ui.aigc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f68513t = r100;
    }

    public static final /* synthetic */ void S5(AigcTaskPanel r100, float r101) {
        r100.setProgressPercent(r101);
    }

    public final void V5(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        AigcTaskPanelStatus r102 = this.f68511r;
        AigcTaskPanelStatus r103 = AigcTaskPanelStatus.Running;
        if (r102 == r103) goto L30;
        this.f68511r = r103;
        TextView r104 = getKeywordTitleTextview();
        if (r104 == null) goto L7;
        r104.setText(r100);
        r104.setVisibility(0);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        a1.o(r104, getRunningKeywordTitleTopMargin());
        Unit r106 = Unit.INSTANCE;
        r104.setLayoutParams(r105);
    L7:
        View r107 = getKeywordSelectorContainerView();
        if (r107 == null) goto L10;
        r107.setVisibility(8);
    L10:
        if (r101 == false) goto L20;
        setProgressPercent(0.0f);
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 0.9f}).setDuration(3000);
        this.f68514u = r108;
        if (r108 == null) goto L14;
        r108.setInterpolator(new LinearInterpolator());
    L14:
        ValueAnimator r109 = this.f68514u;
        if (r109 == null) goto L17;
        r109.addUpdateListener(new com.bytedance.android.live.effect.sticker.ui.aigc.a(this));
    L17:
        ValueAnimator r110 = this.f68514u;
        if (r110 == null) goto L21;
        r110.start();
    L21:
        View r111 = getProgressView();
        if (r111 == null) goto L24;
        r111.setVisibility(0);
    L24:
        View r112 = getButtonContainerView();
        if (r112 == null) goto L27;
        r112.setVisibility(8);
    L27:
        com.bytedance.android.live.effect.sticker.ui.aigc.b r113 = this.f68513t;
        if (r113 == null) goto L32;
        r113.d(this.f68511r);
        return;
    L32:
        return;
    L20:
        post(new g(this));
        goto L21
    L30:
        ALogger.e("ttlive_anchor_effect_AigcTaskPanekl", this.f68511r.name() + " cannot convert to running");
    }

    public AigcTaskPanel(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f68494a = LazyKt.lazy(new AigcTaskPanel$keywordTitleTextview$2(this));
        this.f68495b = LazyKt.lazy(new AigcTaskPanel$keywordSelectorContainerView$2(this));
        this.f68496c = LazyKt.lazy(new AigcTaskPanel$keywordSelectorContentView$2(this));
        this.f68497d = LazyKt.lazy(new AigcTaskPanel$buttonContainerView$2(this));
        this.f68498e = LazyKt.lazy(new AigcTaskPanel$whiteButtonView$2(this));
        this.f68499f = LazyKt.lazy(new AigcTaskPanel$blueButtonView$2(this));
        this.f68500g = LazyKt.lazy(new AigcTaskPanel$progressView$2(this));
        this.f68501h = LazyKt.lazy(AigcTaskPanel$commitTaskButtonText$2.INSTANCE);
        this.f68502i = LazyKt.lazy(AigcTaskPanel$commitTaskButtonWidth$2.INSTANCE);
        this.f68503j = LazyKt.lazy(AigcTaskPanel$reCommitTaskButtonText$2.INSTANCE);
        this.f68504k = LazyKt.lazy(AigcTaskPanel$reCommitTaskButtonWidth$2.INSTANCE);
        this.f68505l = LazyKt.lazy(AigcTaskPanel$applyBackgroundButtonText$2.INSTANCE);
        this.f68506m = LazyKt.lazy(AigcTaskPanel$applyBackgroundButtonWidth$2.INSTANCE);
        this.f68507n = LazyKt.lazy(AigcTaskPanel$reSelectKeywordButtonText$2.INSTANCE);
        this.f68508o = LazyKt.lazy(AigcTaskPanel$reSelectKeywordButtonWidth$2.INSTANCE);
        this.f68509p = LazyKt.lazy(AigcTaskPanel$runningKeywordTitleTopMargin$2.INSTANCE);
        this.f68510q = LazyKt.lazy(AigcTaskPanel$doneKeywordTitleTopMargin$2.INSTANCE);
        this.f68511r = AigcTaskPanelStatus.Default;
        this.f68512s = new ArrayList();
        ViewGroup.inflate(r100, R.layout.ttlive_effect_aigc_task_panel, this);
    }

    public /* synthetic */ AigcTaskPanel(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
