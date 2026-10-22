package com.bytedance.android.gamecp.business.gamedetail.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.gamecp.base.core.service.depend.v;
import com.bytedance.android.gamecp.base.core.service.depend.x;
import com.bytedance.android.gamecp.base.gamedetail.s0;
import com.bytedance.android.gamecp.base.gamedetail.v0;
import com.bytedance.android.gamecp.business.compress.AirCompressManager;
import com.bytedance.android.gamecp.business.download.DownloadView;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wu.a1;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0016\u001a\u00020\u0011H\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/NewBottomDetailDownloadView;", "Lcom/bytedance/android/gamecp/business/download/DownloadView;", "Lcom/bytedance/android/gamecp/base/core/service/depend/m;", "Lcom/bytedance/android/gamecp/base/core/service/depend/o;", "listener", "", "setDownloadStartListener", "", "text", "setDownloadingTextPrefix", "setDownloadSubtitle", "Lcom/bytedance/android/gamecp/base/gamedetail/v0;", "config", "setUIConfig", "", "singleBtn", "setSingleBtn", "", "res", "setDownloadBtnInstalledText", "ids", "setDownloadedTxt", "getLayoutId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewBottomDetailDownloadView extends DownloadView implements com.bytedance.android.gamecp.base.core.service.depend.m {

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public static final /* synthetic */ int f55707x2 = 0;
    public String G1;
    public boolean H0;
    public Drawable H1;
    public final ImageView L0;
    public Drawable L1;
    public Drawable M1;
    public final View P0;
    public Drawable P1;
    public String Q1;
    public v0 S1;
    public boolean T1;
    public final View V0;
    public boolean V1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final TextView f55708b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public com.bytedance.android.gamecp.base.core.service.depend.o f55709b2;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public String f55710g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public boolean f55711g2;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public String f55712h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public Runnable f55713h2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public String f55714k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f55715p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public String f55716p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public ObjectAnimator f55717p2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f55718v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public AnimatorSet f55719v2;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public int f55720x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public String f55721y1;

    public static final class a implements com.bytedance.android.gamecp.base.core.service.depend.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewBottomDetailDownloadView f55722a;

        @Override // com.bytedance.android.gamecp.base.core.service.depend.b
        public final void onAirCompressFailed() {
            this.f55722a.setCurrentProgress(0);
            this.f55722a.onError(0);
        }

        public a(NewBottomDetailDownloadView r100) {
            this.f55722a = r100;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.b
        public final void onAirCompressSuccess(int r100) {
            NewBottomDetailDownloadView r101 = this.f55722a;
            int r102 = NewBottomDetailDownloadView.f55707x2;
            r101.N6();
        }
    }

    public NewBottomDetailDownloadView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NewBottomDetailDownloadView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView
    public int getLayoutId() {
        return R.layout.gamecp_game_detail_new_bottom_download_view;
    }

    public final void H6() {
        this.V0.setTranslationY(0.0f);
        this.V0.setAlpha(1.0f);
        this.V0.setVisibility(0);
        this.P0.setTranslationY(0.0f);
        this.P0.setAlpha(1.0f);
        this.P0.setVisibility(8);
    }

    public final void N6() {
        if (DownloadView.k6(this.f55712h1) == false) goto L6;
        setText(this.f55712h1);
        return;
    L6:
        if (this.T1 == false) goto L8;
        setText(y0.i(R.string.gamecp_beta_test_install));
        return;
    L8:
        setText(y0.i(getDownloadedText()));
    }

    public final void V6() {
        TextView r100 = this.f55708b1;
        if (r100 == null) goto L16;
        CharSequence r101 = r100.getText();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L17;
        TextView r103 = this.f55708b1;
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

    @Override // com.bytedance.android.gamecp.base.core.service.depend.m
    public final void onDownloadStart() {
        com.bytedance.android.gamecp.base.core.service.depend.o r100 = this.f55709b2;
        if (r100 == null) goto L6;
        r100.onDownloadStart();
        return;
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onCancel() {
        super.onCancel();
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(8);
    L5:
        this.f55711g2 = true;
        setText(this.G1);
        View r100 = getDownloadBg();
        if (r100 == null) goto L9;
        r100.setBackground(this.H1);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onReady() {
        super.onReady();
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(8);
    L5:
        this.f55711g2 = true;
        setText(this.G1);
        TextView r100 = getDownloadTv();
        if (r100 == null) goto L8;
        r100.setTextColor(this.f55718v1);
    L8:
        TextView r101 = this.f55708b1;
        if (r101 == null) goto L11;
        r101.setTextColor(this.f55720x1);
    L11:
        setDownloadSubtitle(this.f55721y1);
        V6();
        View r102 = getDownloadBg();
        if (r102 == null) goto L15;
        r102.setBackground(this.H1);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onUpdate() {
        super.onUpdate();
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(8);
    L5:
        this.f55711g2 = true;
        if (DownloadView.k6(this.f55716p1) == false) goto L8;
        setText(this.f55716p1);
    L9:
        v0 r100 = this.S1;
        Integer r101 = null;
        if (r100 == null) goto L14;
        s0 r102 = r100.f51670g;
        if (r102 == null) goto L14;
        String r103 = r102.e(getContext());
    L16:
        if (DownloadView.k6(r103) == false) goto L24;
        v0 r104 = this.S1;
        if (r104 == null) goto L25;
        s0 r105 = r104.f51670g;
        if (r105 == null) goto L25;
        String r106 = r105.e(getContext());
        if (r106 == null) goto L25;
        setDownloadSubtitle(r106);
    L25:
        v0 r107 = this.S1;
        if (r107 == null) goto L30;
        s0 r108 = r107.f51670g;
        if (r108 == null) goto L30;
        Integer r109 = Integer.valueOf(r108.c(getContext()));
    L32:
        if (C6(r109) == false) goto L40;
        v0 r110 = this.S1;
        if (r110 == null) goto L43;
        s0 r111 = r110.f51670g;
        if (r111 == null) goto L43;
        int r112 = r111.c(getContext());
        TextView r113 = getDownloadTv();
        if (r113 == null) goto L43;
        r113.setTextColor(r112);
    L43:
        v0 r114 = this.S1;
        if (r114 == null) goto L49;
        s0 r115 = r114.f51670g;
        if (r115 == null) goto L49;
        r101 = Integer.valueOf(r115.f(getContext()));
    L49:
        if (C6(r101) == false) goto L57;
        v0 r116 = this.S1;
        if (r116 == null) goto L60;
        s0 r117 = r116.f51670g;
        if (r117 == null) goto L60;
        int r118 = r117.f(getContext());
        TextView r119 = this.f55708b1;
        if (r119 == null) goto L60;
        r119.setTextColor(r118);
    L60:
        View r120 = getDownloadBg();
        if (r120 == null) goto L64;
        r120.setBackground(this.P1);
        return;
    L64:
        return;
    L57:
        TextView r121 = this.f55708b1;
        if (r121 == null) goto L60;
        r121.setTextColor(this.f55718v1);
        goto L60
    L40:
        TextView r122 = getDownloadTv();
        if (r122 == null) goto L43;
        r122.setTextColor(this.f55718v1);
    L30:
        r109 = null;
        goto L32
    L24:
        setDownloadSubtitle(this.f55721y1);
    L14:
        r103 = null;
        goto L16
    L8:
        setText(y0.i(getUpdateText()));
        goto L9
    }

    public static boolean C6(Integer r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.intValue() == 0) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onDownloaded(String r100) {
        super.onDownloaded(r100);
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(0);
    L5:
        this.f55711g2 = false;
        v0 r101 = this.S1;
        Integer r102 = null;
        if (r101 == null) goto L10;
        s0 r103 = r101.f51668e;
        if (r103 == null) goto L10;
        Integer r104 = Integer.valueOf(r103.c(getContext()));
    L12:
        if (C6(r104) == false) goto L20;
        v0 r105 = this.S1;
        if (r105 == null) goto L23;
        s0 r106 = r105.f51668e;
        if (r106 == null) goto L23;
        int r107 = r106.c(getContext());
        TextView r108 = getDownloadTv();
        if (r108 == null) goto L23;
        r108.setTextColor(r107);
    L23:
        boolean r109 = AirCompressManager.f52225a;
        if (AirCompressManager.t(r100, null) == false) goto L30;
        com.bytedance.android.gamecp.business.download.p r110 = getMDownloadInfo();
        if (r110 == null) goto L28;
        String r111 = r110.f52855k;
    L29:
        AirCompressManager.y(r111, new a(this));
    L31:
        v0 r112 = this.S1;
        if (r112 == null) goto L36;
        s0 r113 = r112.f51668e;
        if (r113 == null) goto L36;
        String r114 = r113.e(getContext());
    L38:
        if (DownloadView.k6(r114) == false) goto L46;
        v0 r115 = this.S1;
        if (r115 == null) goto L47;
        s0 r116 = r115.f51668e;
        if (r116 == null) goto L47;
        String r117 = r116.e(getContext());
        if (r117 == null) goto L47;
        setDownloadSubtitle(r117);
    L47:
        V6();
        v0 r118 = this.S1;
        if (r118 == null) goto L53;
        s0 r119 = r118.f51668e;
        if (r119 == null) goto L53;
        r102 = Integer.valueOf(r119.f(getContext()));
    L53:
        if (C6(r102) == false) goto L61;
        v0 r120 = this.S1;
        if (r120 == null) goto L64;
        s0 r121 = r120.f51668e;
        if (r121 == null) goto L64;
        int r122 = r121.f(getContext());
        TextView r123 = this.f55708b1;
        if (r123 == null) goto L64;
        r123.setTextColor(r122);
    L64:
        View r124 = getDownloadBg();
        if (r124 == null) goto L68;
        r124.setBackground(this.L1);
        return;
    L68:
        return;
    L61:
        TextView r125 = this.f55708b1;
        if (r125 == null) goto L64;
        r125.setTextColor(this.f55718v1);
        goto L64
    L46:
        setDownloadSubtitle(this.f55721y1);
    L36:
        r114 = null;
        goto L38
    L28:
        r111 = null;
        goto L29
    L30:
        N6();
        goto L31
    L20:
        TextView r126 = getDownloadTv();
        if (r126 == null) goto L23;
        r126.setTextColor(this.f55718v1);
    L10:
        r104 = null;
        goto L12
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onError(int r100) {
        super.onError(r100);
        if (this.H0 == false) goto L5;
        this.L0.setVisibility(0);
    L5:
        this.f55711g2 = false;
        TextView r101 = getDownloadTv();
        if (r101 == null) goto L9;
        r101.setTextColor(this.f55718v1);
        return;
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onInstalled(v r100) {
        Intrinsics.checkNotNullParameter(r100, "installedFinishData");
        super.onInstalled(r100);
        if (this.H0 == false) goto L6;
        this.L0.setVisibility(8);
    L6:
        if (DownloadView.k6(this.f55714k1) == false) goto L9;
        setText(this.f55714k1);
    L12:
        v0 r101 = this.S1;
        String r102 = null;
        if (r101 == null) goto L17;
        s0 r103 = r101.f51669f;
        if (r103 == null) goto L17;
        Integer r104 = Integer.valueOf(r103.c(getContext()));
    L19:
        if (C6(r104) == false) goto L27;
        v0 r105 = this.S1;
        if (r105 == null) goto L30;
        s0 r106 = r105.f51669f;
        if (r106 == null) goto L30;
        int r107 = r106.c(getContext());
        TextView r108 = getDownloadTv();
        if (r108 == null) goto L30;
        r108.setTextColor(r107);
    L30:
        v0 r109 = this.S1;
        if (r109 == null) goto L36;
        s0 r110 = r109.f51669f;
        if (r110 == null) goto L36;
        r102 = r110.e(getContext());
    L36:
        if (DownloadView.k6(r102) == false) goto L44;
        v0 r111 = this.S1;
        if (r111 == null) goto L45;
        s0 r112 = r111.f51669f;
        if (r112 == null) goto L45;
        String r113 = r112.e(getContext());
        if (r113 == null) goto L45;
        setDownloadSubtitle(r113);
    L45:
        V6();
        View r114 = getDownloadBg();
        if (r114 == null) goto L49;
        r114.setBackground(this.M1);
        return;
    L49:
        return;
    L44:
        setDownloadSubtitle(this.f55721y1);
        goto L45
    L27:
        TextView r115 = getDownloadTv();
        if (r115 == null) goto L30;
        r115.setTextColor(this.f55718v1);
    L17:
        r104 = null;
        goto L19
    L9:
        if (this.T1 == false) goto L11;
        setText(y0.i(getInstalledText()));
        goto L12
    L11:
        setText(y0.i(R.string.gamecp_beta_test_download_start_game));
        goto L12
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onPause(x r110) {
        Intrinsics.checkNotNullParameter(r110, "progressData");
        super.onPause(r110);
        if (DownloadView.k6(this.f55710g1) == false) goto L5;
        setText(this.f55710g1);
    L6:
        v0 r100 = this.S1;
        Long r101 = null;
        if (r100 == null) goto L11;
        s0 r102 = r100.f51667d;
        if (r102 == null) goto L11;
        String r103 = r102.e(getContext());
    L13:
        if (DownloadView.k6(r103) == false) goto L21;
        v0 r104 = this.S1;
        if (r104 == null) goto L22;
        s0 r105 = r104.f51667d;
        if (r105 == null) goto L22;
        String r106 = r105.e(getContext());
        if (r106 == null) goto L22;
        setDownloadSubtitle(r106);
    L22:
        V6();
        v0 r107 = this.S1;
        if (r107 == null) goto L27;
        s0 r108 = r107.f51667d;
        if (r108 == null) goto L27;
        Integer r109 = Integer.valueOf(r108.c(getContext()));
    L29:
        if (C6(r109) == false) goto L37;
        v0 r111 = this.S1;
        if (r111 == null) goto L40;
        s0 r112 = r111.f51667d;
        if (r112 == null) goto L40;
        int r113 = r112.c(getContext());
        TextView r114 = getDownloadTv();
        if (r114 == null) goto L40;
        r114.setTextColor(r113);
    L40:
        v0 r115 = this.S1;
        if (r115 == null) goto L45;
        s0 r116 = r115.f51667d;
        if (r116 == null) goto L45;
        Integer r117 = Integer.valueOf(r116.f(getContext()));
    L47:
        if (C6(r117) == false) goto L55;
        v0 r118 = this.S1;
        if (r118 == null) goto L58;
        s0 r119 = r118.f51667d;
        if (r119 == null) goto L58;
        int r120 = r119.f(getContext());
        TextView r121 = this.f55708b1;
        if (r121 == null) goto L58;
        r121.setTextColor(r120);
    L58:
        com.bytedance.android.gamecp.common.setting.config.s0 r122 = a1.f561277a.getValue();
        com.bytedance.android.gamecp.business.download.p r123 = getMDownloadInfo();
        if (r123 == null) goto L61;
        String r124 = r123.f52866p0;
    L62:
        boolean r125 = UtilsKt.c(r124);
        if (r122.b() != 1) goto L65;
    L68:
        boolean r126 = true;
    L69:
        boolean r127 = Intrinsics.areEqual(ms.i.f515457b, "promote_detail");
        if ((System.currentTimeMillis() - ms.i.f515458c) > r122.e()) goto L72;
        boolean r128 = true;
    L73:
        yr.c.e("download_pause_dialog", "detail_download_view onPause config taskGroupCondition=" + r125 + ",hitV1OrV2=" + r126 + ",isFromDetail=" + r127 + ",clickInterval=" + r128);
        if (this.f55715p0 == false) goto L114;
        if (r125 == false) goto L114;
        if (r126 == false) goto L114;
        if (r127 == false) goto L114;
        if (r128 == false) goto L114;
        StringBuilder r129 = new StringBuilder("gamecp.key.DOWNLOAD_PAUSE_TEXT_SHOW_");
        com.bytedance.android.gamecp.business.download.p r130 = getMDownloadInfo();
        if (r130 == null) goto L82;
        String r131 = r130.f52866p0;
    L83:
        r129.append(r131);
        String r132 = r129.toString();
        if (com.bytedance.android.gamecp.common.utils.a1.b().getInt(r132, 0) != 0) goto L86;
        boolean r133 = true;
    L87:
        yr.c.e("download_pause_dialog", "detail_download_view key =" + r132 + ", needShow=" + r133);
        if (com.bytedance.android.gamecp.host_api.a.b().getHostContext().isLocalTest() == true) goto L90;
    L92:
        boolean r134 = false;
    L93:
        if (r133 == true) goto L95;
        if (r134 == false) goto L114;
    L95:
        TextView r135 = getDownloadTv();
        if (r135 == null) goto L101;
        CharSequence r136 = r135.getText();
        if (r136 == null) goto L101;
        String r137 = r136.toString();
        if (r137 == null) goto L101;
    L102:
        com.bytedance.android.gamecp.business.download.p r138 = getMDownloadInfo();
        if (r138 == null) goto L107;
        com.bytedance.android.gamecp.business.download.s r139 = r138.G0;
        if (r139 == null) goto L107;
        r101 = Long.valueOf(r139.f52929m);
    L107:
        String r140 = ms.i.b(r101, r110, false);
        if (r140.length() != 0) goto L110;
        boolean r141 = true;
    L111:
        if (r141 == false) goto L113;
        r140 = y0.i(R.string.gamecp_download_pause_card_default);
    L113:
        setText(r137 + 65288 + r140 + 65289);
        com.bytedance.android.gamecp.common.utils.a1.a().putInt(r132, 1).apply();
        goto L114
    L110:
        r141 = false;
    L101:
        r137 = "";
        goto L102
    L90:
        if (r122.f() == false) goto L92;
        r134 = true;
        goto L93
    L86:
        r133 = false;
        goto L87
    L82:
        r131 = null;
    L114:
        boolean r142 = this.H0;
        if (r142 == false) goto L135;
        if (r142 == false) goto L118;
        this.L0.setVisibility(0);
    L118:
        this.f55711g2 = false;
        ObjectAnimator r143 = this.f55717p2;
        if (r143 != null) goto L121;
    L123:
        Runnable r144 = this.f55713h2;
        if (r144 == null) goto L128;
        removeCallbacks(r144);
        Runnable r145 = this.f55713h2;
        if (r145 == null) goto L136;
        r145.run();
        return;
    L136:
        return;
    L128:
        AnimatorSet r146 = this.f55719v2;
        if (r146 != null) goto L131;
    L133:
        H6();
        return;
    L131:
        if (r146.isRunning() != true) goto L133;
        return;
    L121:
        if (r143.isRunning() != true) goto L123;
        ObjectAnimator r147 = this.f55717p2;
        Intrinsics.checkNotNull(r147);
        r147.cancel();
        goto L123
    L135:
        return;
    L72:
        r128 = false;
        goto L73
    L65:
        if (r122.b() == 2) goto L68;
        r126 = false;
        goto L69
    L61:
        r124 = null;
        goto L62
    L55:
        TextView r148 = this.f55708b1;
        if (r148 == null) goto L58;
        r148.setTextColor(this.f55718v1);
    L45:
        r117 = null;
        goto L47
    L37:
        TextView r149 = getDownloadTv();
        if (r149 == null) goto L40;
        r149.setTextColor(this.f55718v1);
    L27:
        r109 = null;
        goto L29
    L21:
        setDownloadSubtitle(this.f55721y1);
    L11:
        r103 = null;
        goto L13
    L5:
        setText(y0.i(getPauseText()));
        goto L6
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void onProgress(x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        super.onProgress(r100);
        v0 r101 = this.S1;
        Integer r102 = null;
        if (r101 == null) goto L7;
        s0 r103 = r101.f51666c;
        if (r103 == null) goto L7;
        Integer r104 = Integer.valueOf(r103.c(getContext()));
    L9:
        if (C6(r104) == false) goto L17;
        v0 r105 = this.S1;
        if (r105 == null) goto L21;
        s0 r106 = r105.f51666c;
        if (r106 == null) goto L21;
        int r107 = r106.c(getContext());
        TextView r108 = getDownloadTv();
        if (r108 == null) goto L21;
        r108.setTextColor(r107);
    L21:
        if (DownloadView.k6(this.Q1) == true) goto L23;
        this.Q1 = y0.i(R.string.gamecp_downloading_text);
    L23:
        setText(this.Q1 + ' ' + getCurrentProgress() + '%');
        boolean r109 = this.H0;
        if (r109 == true) goto L26;
    L36:
        v0 r110 = this.S1;
        if (r110 == null) goto L41;
        s0 r111 = r110.f51666c;
        if (r111 == null) goto L41;
        String r112 = r111.e(getContext());
    L43:
        if (DownloadView.k6(r112) == false) goto L51;
        v0 r113 = this.S1;
        if (r113 == null) goto L52;
        s0 r114 = r113.f51666c;
        if (r114 == null) goto L52;
        String r115 = r114.e(getContext());
        if (r115 == null) goto L52;
        setDownloadSubtitle(r115);
    L52:
        TextView r116 = this.f55708b1;
        if (r116 == null) goto L55;
        r116.setVisibility(8);
    L55:
        v0 r117 = this.S1;
        if (r117 == null) goto L61;
        s0 r118 = r117.f51666c;
        if (r118 == null) goto L61;
        r102 = Integer.valueOf(r118.f(getContext()));
    L61:
        if (C6(r102) == false) goto L69;
        v0 r119 = this.S1;
        if (r119 == null) goto L73;
        s0 r120 = r119.f51666c;
        if (r120 == null) goto L74;
        int r121 = r120.f(getContext());
        TextView r122 = this.f55708b1;
        if (r122 == null) goto L75;
        r122.setTextColor(r121);
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L69:
        TextView r123 = this.f55708b1;
        if (r123 == null) goto L77;
        r123.setTextColor(this.f55718v1);
        return;
    L77:
        return;
    L51:
        setDownloadSubtitle(this.f55721y1);
    L41:
        r112 = null;
        goto L43
    L26:
        if (r109 == false) goto L29;
        this.L0.setVisibility(0);
    L29:
        if (this.f55711g2 == false) goto L36;
        this.f55711g2 = false;
        this.P0.setAlpha(0.3f);
        this.P0.setVisibility(0);
        this.V0.setVisibility(8);
        ObjectAnimator r124 = this.f55717p2;
        if (r124 != null) goto L33;
    L35:
        ObjectAnimator r125 = ObjectAnimator.ofFloat(this.P0, "alpha", new float[]{0.3f, 1.0f});
        this.f55717p2 = r125;
        r125.setDuration(250);
        r125.start();
        k r126 = new k(this);
        this.f55713h2 = r126;
        postDelayed(r126, 2000);
        goto L36
    L33:
        if (r124.isRunning() != true) goto L35;
        ObjectAnimator r127 = this.f55717p2;
        Intrinsics.checkNotNull(r127);
        r127.cancel();
        H6();
        goto L35
    L17:
        TextView r128 = getDownloadTv();
        if (r128 == null) goto L21;
        r128.setTextColor(this.f55718v1);
    L7:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.android.gamecp.business.download.DownloadView, com.bytedance.android.gamecp.base.core.service.depend.n
    public final void passThrough(int r100) {
        super.passThrough(r100);
        if (this.V1 == true) goto L6;
        this.V1 = true;
        return;
    }

    public final void setDownloadBtnInstalledText(int r100) {
        setInstalledText(r100);
    }

    public final void setDownloadStartListener(com.bytedance.android.gamecp.base.core.service.depend.o r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f55709b2 = r100;
    }

    public final void setDownloadSubtitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f55708b1;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setDownloadedTxt(int r100) {
        setDownloadedText(r100);
    }

    public final void setDownloadingTextPrefix(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.Q1 = r100;
    }

    public final void setSingleBtn(boolean r100) {
        this.f55715p0 = r100;
    }

    public final void setUIConfig(v0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.S1 = r100;
        this.T1 = r100.f51674k;
        if (DownloadView.k6(r100.f51665b.d(getContext())) == false) goto L6;
        this.G1 = r100.f51665b.d(getContext());
    L9:
        if (DownloadView.k6(r100.f51665b.e(getContext())) == false) goto L12;
        this.f55721y1 = r100.f51665b.e(getContext());
    L12:
        if (C6(Integer.valueOf(r100.f51665b.c(getContext()))) == false) goto L15;
        this.f55718v1 = r100.f51665b.c(getContext());
    L15:
        if (C6(Integer.valueOf(r100.f51665b.f(getContext()))) == false) goto L17;
        this.f55720x1 = r100.f51665b.f(getContext());
    L17:
        setUnSupportText(r100.f51673j.d(getContext()));
        setUnSupportColor(r100.f51673j.c(getContext()));
        s0 r101 = r100.f51668e;
        Integer r102 = null;
        if (r101 == null) goto L20;
        String r103 = r101.d(getContext());
    L21:
        this.f55712h1 = String.valueOf(r103);
        s0 r104 = r100.f51670g;
        if (r104 == null) goto L24;
        String r105 = r104.d(getContext());
    L25:
        this.f55716p1 = String.valueOf(r105);
        s0 r106 = r100.f51669f;
        if (r106 == null) goto L28;
        String r107 = r106.d(getContext());
    L29:
        this.f55714k1 = String.valueOf(r107);
        s0 r108 = r100.f51667d;
        if (r108 == null) goto L32;
        String r109 = r108.d(getContext());
    L33:
        this.f55710g1 = String.valueOf(r109);
        s0 r110 = r100.f51666c;
        if (r110 == null) goto L36;
        String r111 = r110.d(getContext());
    L37:
        this.Q1 = String.valueOf(r111);
        s0 r112 = r100.f51671h;
        if (r112 == null) goto L40;
        String r113 = r112.d(getContext());
    L41:
        setErrorTextFromServer(String.valueOf(r113));
        s0 r114 = r100.f51672i;
        if (r114 == null) goto L44;
        String r115 = r114.d(getContext());
    L45:
        setWaitWifiTextFromServer(String.valueOf(r115));
        TextView r116 = getDownloadTv();
        if (r116 == null) goto L48;
        r116.setTextColor(this.f55718v1);
    L48:
        TextView r117 = this.f55708b1;
        if (r117 == null) goto L51;
        r117.setTextColor(this.f55720x1);
    L51:
        TextView r118 = getDownloadTv();
        if (r118 == null) goto L54;
        yt.o.a(r118, 500);
    L54:
        ProgressBar r119 = getDownloadPb();
        if (r119 == null) goto L57;
        r119.setProgressDrawable(r100.f51664a);
    L57:
        s0 r120 = r100.f51665b;
        if (r120 == null) goto L60;
        Integer r121 = Integer.valueOf(r120.a(getContext()));
    L61:
        int r122 = r121.intValue();
        if (C6(Integer.valueOf(r122)) == false) goto L68;
        Drawable r123 = getContext().getResources().getDrawable(getReadyBg()).mutate();
        if (r123 == null) goto L67;
        GradientDrawable r124 = (GradientDrawable) r123;
        r124.setColor(r122);
        this.H1 = r124;
        goto L68
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L68:
        Drawable r125 = this.H1;
        this.L1 = r125;
        this.M1 = r125;
        this.P1 = r125;
        s0 r126 = r100.f51668e;
        if (r126 == null) goto L77;
        int r127 = r126.a(getContext());
        if (C6(Integer.valueOf(r127)) == false) goto L77;
        Drawable r128 = getContext().getResources().getDrawable(getReadyBg()).mutate();
        if (r128 == null) goto L76;
        GradientDrawable r129 = (GradientDrawable) r128;
        r129.setColor(r127);
        this.L1 = r129;
        goto L77
    L76:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L77:
        s0 r130 = r100.f51669f;
        if (r130 == null) goto L86;
        int r131 = r130.a(getContext());
        if (C6(Integer.valueOf(r131)) == false) goto L86;
        Drawable r132 = getContext().getResources().getDrawable(getReadyBg()).mutate();
        if (r132 == null) goto L85;
        GradientDrawable r133 = (GradientDrawable) r132;
        r133.setColor(r131);
        this.M1 = r133;
        goto L86
    L85:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L86:
        s0 r134 = r100.f51670g;
        if (r134 == null) goto L95;
        int r135 = r134.a(getContext());
        if (C6(Integer.valueOf(r135)) == false) goto L95;
        Drawable r136 = getContext().getResources().getDrawable(getReadyBg()).mutate();
        if (r136 == null) goto L94;
        GradientDrawable r137 = (GradientDrawable) r136;
        r137.setColor(r135);
        this.P1 = r137;
        goto L95
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L95:
        s0 r138 = r100.f51673j;
        if (r138 == null) goto L98;
        r102 = Integer.valueOf(r138.a(getContext()));
    L98:
        int r139 = r102.intValue();
        if (C6(Integer.valueOf(r139)) == false) goto L105;
        Drawable r140 = getContext().getResources().getDrawable(getUnSupportBg()).mutate();
        if (r140 == null) goto L104;
        GradientDrawable r141 = (GradientDrawable) r140;
        r141.setColor(r139);
        setUnSupportBgFromServer(r141);
        return;
    L104:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
    L105:
        return;
    L60:
        r121 = null;
        goto L61
    L44:
        r115 = null;
        goto L45
    L40:
        r113 = null;
        goto L41
    L36:
        r111 = null;
        goto L37
    L32:
        r109 = null;
        goto L33
    L28:
        r107 = null;
        goto L29
    L24:
        r105 = null;
        goto L25
    L20:
        r103 = null;
        goto L21
    L6:
        if (this.T1 == false) goto L9;
        this.G1 = y0.i(R.string.gamecp_beta_test_download);
        goto L9
    }

    public NewBottomDetailDownloadView(Context r100, AttributeSet r101, int r102) {
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
        this.f55708b1 = (TextView) findViewById(R.id.tv_download_subtitle);
        this.L0 = (ImageView) findViewById(R.id.iv_safe_icon);
        this.P0 = findViewById(R.id.ll_safe_tip);
        this.V0 = findViewById(R.id.ll_download_info);
        this.f55710g1 = "";
        this.f55712h1 = "";
        this.f55714k1 = "";
        this.f55716p1 = "";
        this.f55718v1 = y0.c(R.color.white);
        this.f55720x1 = y0.c(R.color.white);
        this.f55721y1 = "";
        this.G1 = y0.i(R.string.game_detail_ttlive_download);
        Drawable r106 = y0.e(R.drawable.gamecp_shape_game_detail_title_download_radius_8);
        this.H1 = r106;
        this.L1 = r106;
        this.M1 = r106;
        this.P1 = r106;
        this.Q1 = r100.getResources().getString(R.string.gamecp_downloading_text);
    }

    public /* synthetic */ NewBottomDetailDownloadView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
