package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import j40.o3;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0017\tB'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/common/AnchorPauseTipsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getLeaveViewRadiusPx", "getLayoutResource", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Lcom/bytedance/android/live/core/widget/HSImageView;", "b", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getWebpAnimView", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setWebpAnimView", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "webpAnimView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorPauseTipsView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f119652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f119653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f119654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f119655d;

    public static final class a {
    }

    public static final class b extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f119656a;

        public b(float r100) {
            this.f119656a = r100;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(new Rect(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getWidth() - r100.getPaddingRight(), r100.getHeight() - r100.getPaddingBottom()), this.f119656a);
        }
    }

    static {
    }

    public AnchorPauseTipsView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorPauseTipsView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getLayoutResource() {
        return R.layout.ttlive_anchor_pause_tips_view;
    }

    private final int getLeaveViewRadiusPx() {
        int r100 = this.f119655d;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        return getMeasuredWidth() / 2;
    }

    public final void R5() {
        ((TextView) _$_findCachedViewById(R.id.title_tv)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R.id.content_tv)).setVisibility(8);
    }

    public final HSImageView getWebpAnimView() {
        return this.f119653b;
    }

    public final void S5(boolean r100) {
        ((TextView) _$_findCachedViewById(R.id.title_tv)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.content_tv)).setVisibility(0);
        if (r100 == false) goto L5;
        String r101 = s1.B(R.string.ttlive_live_interact_anchor_enter_background);
    L6:
        ((TextView) _$_findCachedViewById(R.id.title_tv)).setText(r101);
        return;
    L5:
        r101 = s1.B(R.string.ttlive_live_interact_enlarge_guest_enter_background);
        goto L6
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f119652a != null) goto L5;
        this.f119652a = new LinkedHashMap();
    L5:
        View r101 = this.f119652a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f119652a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L48;
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        if (r101 != null) goto L7;
        return;
    L7:
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r104 >= r102) goto L13;
        if (Intrinsics.areEqual(r101[r104].getMethodName(), "setVisibility") == true) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        r103 = r104;
    L13:
        int r105 = r103 + 8;
    L15:
        if (r105 < r101.length) goto L17;
        r105 = r105 - 1;
        goto L15
    L17:
        int r106 = r101.length;
        if (r105 < 0) goto L52;
        if (r106 <= r105) goto L49;
        int r107 = r101.length;
        if (r103 < 0) goto L50;
        if (r107 <= r103) goto L53;
        StringBuilder r108 = new StringBuilder("anchor pause: ");
        if (r105 < r103) goto L37;
    L27:
        int r109 = r101.length;
        if (r105 < 0) goto L36;
        if (r109 <= r105) goto L47;
        r108.append(r101[r105].getFileName() + '.' + r101[r105].getMethodName());
        if (r105 == r103) goto L34;
        r108.append("-");
    L34:
        if (r105 == r103) goto L37;
        r105 = r105 - 1;
        goto L27
    L47:
        return;
    L36:
        return;
    L37:
        String r110 = r108.toString();
        if (r110 == null) goto L51;
        ALogger.d("AnchorPauseTipsView", r110);
        return;
    L51:
        return;
    L53:
        return;
    L50:
        return;
    L49:
        return;
    L52:
        return;
    }

    public final void setWebpAnimView(HSImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f119653b = r100;
    }

    public static /* synthetic */ void U5(AnchorPauseTipsView r100, float r101) {
        r100.T5(R.drawable.ttlive_icon_talk_room_anchor_pause_large, r101, true);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f119654c == false) goto L6;
        setOutlineProvider(new b(getLeaveViewRadiusPx()));
        setClipToOutline(true);
        return;
    }

    public AnchorPauseTipsView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f119652a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(getLayoutResource(), this, true);
        this.f119653b = (HSImageView) findViewById(R.id.anchor_leave_tips_iv);
        AbstractDraweeController r103 = Fresco.newDraweeControllerBuilder().setUri(o3.f497276a.getValue().f119878a).setAutoPlayAnimations(true).build();
        this.f119653b.setController(r103);
        setClipToPadding(false);
    }

    public void T5(int r100, float r101, boolean r102) {
        this.f119653b.setActualImageResource(r100);
        int r103 = (int) UIUtils.dip2Px(getContext(), r101);
        this.f119653b.setPadding(r103, r103, r103, r103);
        if (r102 == false) goto L6;
        setBackgroundColor(ColorProtector.parseColor("#7F000000"));
        return;
    }

    public /* synthetic */ AnchorPauseTipsView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
