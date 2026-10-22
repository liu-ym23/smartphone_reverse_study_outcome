package com.bytedance.android.gamecp.business.gamedetail.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.base.gamedetail.b0;
import com.bytedance.android.gamecp.business.download.DownloadView;
import com.bytedance.android.gamecp.common.setting.config.s0;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wu.a1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\f\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0012J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\""}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/DetailDownLoadViewV2;", "Lcom/bytedance/android/gamecp/business/download/DownloadView;", "", "text", "", "setDownloadingTextPrefix", "setDownloadSubtitle", "Lcom/bytedance/android/gamecp/base/gamedetail/b0;", "style", "setUIStyle", "Landroid/graphics/drawable/Drawable;", "getDownloadingProgressDrawable", "getUnSupportBackgroundDrawable", "Landroid/widget/TextView;", "getUnSupportTextView", "", "singleBtn", "setSingleBtn", "", "res", "setDownloadBtnReadyText", "setDownloadBtnInstalledText", "setDownloadPauseText", "ids", "setDownloadedTxt", "getLayoutId", "setUnsupportedDownloadButtonText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailDownLoadViewV2 extends DownloadView {
    public AnimatorSet G1;
    public boolean H0;
    public final ImageView L0;
    public final View P0;
    public final View V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final TextView f55649b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public String f55650g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public b0 f55651h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f55652k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f55653p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f55654p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f55655v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public Runnable f55656x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public ObjectAnimator f55657y1;

    public DetailDownLoadViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DetailDownLoadViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView
    public int getLayoutId() {
        return R.layout.gamecp_game_detail_download_view;
    }

    public final void C6() {
        this.V0.setTranslationY(0.0f);
        this.V0.setAlpha(1.0f);
        this.V0.setVisibility(0);
        this.P0.setTranslationY(0.0f);
        this.P0.setAlpha(1.0f);
        this.P0.setVisibility(8);
    }

    public final void H6() {
        TextView r100 = this.f55649b1;
        if (r100 == null) goto L16;
        CharSequence r101 = r100.getText();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L17;
        TextView r103 = this.f55649b1;
        if (r103 == null) goto L18;
        r103.setVisibility(0);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    public final Drawable getDownloadingProgressDrawable() {
        ProgressBar r100 = getDownloadPb();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getProgressDrawable();
    }

    public final Drawable getUnSupportBackgroundDrawable() {
        View r100 = getDownloadBg();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBackground();
    }

    public final TextView getUnSupportTextView() {
        return getDownloadTv();
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onCancel() {
        super.onCancel();
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(8);
    L5:
        this.f55655v1 = true;
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onReady() {
        super.onReady();
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(8);
    L5:
        this.f55655v1 = true;
        H6();
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onUpdate() {
        super.onUpdate();
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(8);
    L5:
        this.f55655v1 = true;
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onDownloaded(String r100) {
        super.onDownloaded(r100);
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(0);
    L5:
        this.f55655v1 = false;
        TextView r101 = getDownloadTv();
        if (r101 == null) goto L12;
        b0 r102 = this.f55651h1;
        if (r102 == null) goto L10;
        int r103 = r102.f51551e;
    L11:
        r101.setTextColor(y0.c(r103));
        goto L12
    L10:
        r103 = R.color.white;
    L12:
        H6();
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onError(int r100) {
        super.onError(r100);
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(0);
    L5:
        this.f55655v1 = false;
        TextView r101 = getDownloadTv();
        if (r101 == null) goto L13;
        b0 r102 = this.f55651h1;
        if (r102 == null) goto L10;
        int r103 = r102.f51551e;
    L11:
        r101.setTextColor(y0.c(r103));
        return;
    L10:
        r103 = R.color.white;
        goto L11
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onPause(x r110) {
        Intrinsics.checkNotNullParameter(r110, "progressData");
        super.onPause(r110);
        TextView r100 = getDownloadTv();
        if (r100 == null) goto L5;
        r100.setTextColor(this.f55652k1);
    L5:
        s0 r101 = a1.f561277a.getValue();
        com.bytedance.android.gamecp.business.download.p r102 = getMDownloadInfo();
        Long r103 = null;
        if (r102 == null) goto L8;
        String r104 = r102.f52866p0;
    L9:
        boolean r105 = UtilsKt.c(r104);
        if (r101.b() != 1) goto L12;
    L15:
        boolean r106 = true;
    L16:
        boolean r107 = Intrinsics.areEqual(ms.i.f515457b, "promote_detail");
        if ((System.currentTimeMillis() - ms.i.f515458c) > r101.e()) goto L19;
        boolean r108 = true;
    L20:
        yr.c.e("download_pause_dialog", "detail_download_view onPause config taskGroupCondition=" + r105 + ",hitV1OrV2=" + r106 + ",isFromDetail=" + r107 + ",clickInterval=" + r108);
        if (this.f55653p0 == false) goto L61;
        if (r105 == false) goto L61;
        if (r106 == false) goto L61;
        if (r107 == false) goto L61;
        if (r108 == false) goto L61;
        StringBuilder r109 = new StringBuilder("gamecp.key.DOWNLOAD_PAUSE_TEXT_SHOW_");
        com.bytedance.android.gamecp.business.download.p r111 = getMDownloadInfo();
        if (r111 == null) goto L29;
        String r112 = r111.f52866p0;
    L30:
        r109.append(r112);
        String r113 = r109.toString();
        if (com.bytedance.android.gamecp.common.utils.a1.b().getInt(r113, 0) != 0) goto L33;
        boolean r114 = true;
    L34:
        yr.c.e("download_pause_dialog", "detail_download_view key =" + r113 + ", needShow=" + r114);
        if (com.bytedance.android.gamecp.host_api.a.b().getHostContext().isLocalTest() == true) goto L37;
    L39:
        boolean r115 = false;
    L40:
        if (r114 == true) goto L42;
        if (r115 == false) goto L61;
    L42:
        TextView r116 = getDownloadTv();
        if (r116 == null) goto L48;
        CharSequence r117 = r116.getText();
        if (r117 == null) goto L48;
        String r118 = r117.toString();
        if (r118 == null) goto L48;
    L49:
        com.bytedance.android.gamecp.business.download.p r119 = getMDownloadInfo();
        if (r119 == null) goto L54;
        com.bytedance.android.gamecp.business.download.s r120 = r119.G0;
        if (r120 == null) goto L54;
        r103 = Long.valueOf(r120.f52929m);
    L54:
        String r121 = ms.i.b(r103, r110, false);
        if (r121.length() != 0) goto L57;
        boolean r122 = true;
    L58:
        if (r122 == false) goto L60;
        r121 = y0.i(R.string.gamecp_download_pause_card_default);
    L60:
        setText(r118 + 65288 + r121 + 65289);
        com.bytedance.android.gamecp.common.utils.a1.a().putInt(r113, 1).apply();
        goto L61
    L57:
        r122 = false;
    L48:
        r118 = "";
        goto L49
    L37:
        if (r101.f() == false) goto L39;
        r115 = true;
        goto L40
    L33:
        r114 = false;
        goto L34
    L29:
        r112 = null;
    L61:
        boolean r123 = this.H0;
        if (r123 == false) goto L81;
        if (r123 == false) goto L65;
        this.L0.setVisibility(0);
    L65:
        this.f55655v1 = false;
        ObjectAnimator r124 = this.f55657y1;
        if (r124 != null) goto L68;
    L70:
        Runnable r125 = this.f55656x1;
        if (r125 == null) goto L75;
        removeCallbacks(r125);
        Runnable r126 = this.f55656x1;
        if (r126 == null) goto L81;
        r126.run();
        goto L81
    L75:
        AnimatorSet r127 = this.G1;
        if (r127 != null) goto L78;
    L80:
        C6();
        goto L81
    L78:
        if (r127.isRunning() != true) goto L80;
    L68:
        if (r124.isRunning() != true) goto L70;
        ObjectAnimator r128 = this.f55657y1;
        Intrinsics.checkNotNull(r128);
        r128.cancel();
    L81:
        H6();
        return;
    L19:
        r108 = false;
        goto L20
    L12:
        if (r101.b() == 2) goto L15;
        r106 = false;
        goto L16
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onProgress(x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        super.onProgress(r100);
        TextView r101 = getDownloadTv();
        if (r101 == null) goto L5;
        r101.setTextColor(this.f55652k1);
    L5:
        setText(this.f55650g1 + ' ' + getCurrentProgress() + '%');
        boolean r102 = this.H0;
        if (r102 == true) goto L8;
    L18:
        TextView r103 = this.f55649b1;
        if (r103 == null) goto L22;
        r103.setVisibility(8);
        return;
    L22:
        return;
    L8:
        if (r102 == false) goto L11;
        this.L0.setVisibility(0);
    L11:
        if (this.f55655v1 == false) goto L18;
        this.f55655v1 = false;
        this.P0.setAlpha(0.3f);
        this.P0.setVisibility(0);
        this.V0.setVisibility(8);
        ObjectAnimator r104 = this.f55657y1;
        if (r104 != null) goto L15;
    L17:
        ObjectAnimator r105 = ObjectAnimator.ofFloat(this.P0, "alpha", new float[]{0.3f, 1.0f});
        this.f55657y1 = r105;
        r105.setDuration(250);
        r105.start();
        d r106 = new d(this);
        this.f55656x1 = r106;
        postDelayed(r106, 2000);
        goto L18
    L15:
        if (r104.isRunning() != true) goto L17;
        ObjectAnimator r107 = this.f55657y1;
        Intrinsics.checkNotNull(r107);
        r107.cancel();
        C6();
        goto L17
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void passThrough(int r100) {
        super.passThrough(r100);
        if (this.f55654p1 == true) goto L6;
        this.f55654p1 = true;
        return;
    }

    public final void setDownloadBtnInstalledText(int r100) {
        setInstalledText(r100);
    }

    public final void setDownloadBtnReadyText(int r100) {
        setReadyText(r100);
    }

    public final void setDownloadPauseText(int r100) {
        setPauseText(r100);
    }

    public final void setDownloadSubtitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f55649b1;
        if (r101 == null) goto L5;
        r101.setText(r100);
    L5:
        H6();
    }

    public final void setDownloadedTxt(int r100) {
        setDownloadedText(r100);
    }

    public final void setDownloadingTextPrefix(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f55650g1 = r100;
    }

    public final void setSingleBtn(boolean r100) {
        this.f55653p0 = r100;
    }

    public final void setUIStyle(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f55651h1 = r100;
        setReadyBg(r100.f51547a);
        setDownloadingBg(r100.f51548b);
        ProgressBar r101 = getDownloadPb();
        if (r101 == null) goto L5;
        r101.setProgressDrawable(y0.e(r100.f51549c));
    L5:
        TextView r102 = getDownloadTv();
        if (r102 == null) goto L8;
        r102.setTextColor(y0.c(r100.f51551e));
    L8:
        TextView r103 = getDownloadTv();
        if (r103 == null) goto L11;
        r103.setTypeface(Typeface.defaultFromStyle(r100.f51553g));
    L11:
        View r104 = getDownloadBg();
        if (r104 == null) goto L14;
        r104.setBackgroundResource(getReadyBg());
    L14:
        setUnSupportBg(r100.f51550d);
        setUnSupportColor(y0.c(r100.f51552f));
    }

    public final void setUnsupportedDownloadButtonText(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        setUnSupportText(r100);
        return;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public DetailDownLoadViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setInstalledText(R.string.ttlive_audience_game_promote_detail_start_game);
        setDownloadedText(R.string.ttlive_audience_game_promote_detail_install);
        setReadyText(R.string.game_detail_ttlive_download);
        setReadyBg(R.drawable.gamecp_shape_game_detail_title_download_radius_8);
        setDownloadingBg(R.drawable.gamecp_shape_game_detail_title_downloading);
        ProgressBar r103 = getDownloadPb();
        if (r103 == null) goto L5;
        r103.setProgressDrawable(y0.e(R.drawable.gamecp_game_detail_title_pb_radius_8));
    L5:
        TextView r104 = getDownloadTv();
        if (r104 == null) goto L8;
        r104.setTextColor(y0.c(R.color.white));
    L8:
        setUnSupportBg(R.drawable.gamecp_bg_download_unsupport_btn_radius_8);
        setUnSupportText(y0.i(R.string.game_detail_ttlive_download));
        ProgressBar r105 = getDownloadPb();
        if (r105 == null) goto L11;
        r105.setVisibility(8);
    L11:
        setDownloadBg(findViewById(R.id.download_bg));
        this.f55649b1 = (TextView) findViewById(R.id.tv_download_subtitle);
        this.L0 = (ImageView) findViewById(R.id.iv_safe_icon);
        this.P0 = findViewById(R.id.ll_safe_tip);
        this.V0 = findViewById(R.id.ll_download_info);
        this.f55650g1 = r100.getResources().getString(R.string.gamecp_downloading_text);
        this.f55652k1 = y0.c(R.color.gamecp_game_FFFFFF);
    }

    public /* synthetic */ DetailDownLoadViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
