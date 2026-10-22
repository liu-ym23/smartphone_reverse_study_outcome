package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.gamecp.base.gamedetail.c0;
import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.android.gamecp.base.gamedetail.f0;
import com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget;
import com.bytedance.android.gamecp.business.gamedetail.component.GameCpViewWrapper;
import com.bytedance.android.gamecp.business.gamedetail.view.DetailDownLoadViewV2;
import com.bytedance.ies.sve_core.p;
import com.bytedance.ies.sve_core.r;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.huawei.hms.android.SystemUtils;
import com.larus.nova.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wu.u4;
import wu.v4;
import wu.w;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/GameDownloadButtonItemWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/BaseGameDownloadButtonWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/e;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDownloadButtonItemWidget extends BaseGameDownloadButtonWidget<e> {
    public View A;
    public TextView B;
    public View C;
    public TextView D;
    public FrameLayout E;
    public GameCpViewWrapper F;
    public GameCpViewWrapper G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public DownloadButtonAnimation f54274J;
    public LinearLayout K;
    public LinearLayout L;
    public TextView M;
    public final c0 N;
    public final Function1<? super RecyclerViewItemWidget<e>, ? extends Object> O;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ConstraintLayout f54275y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public FrameLayout f54276z;

    public GameDownloadButtonItemWidget() {
        throw null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.gamecp_game_detail_download_bar_merge;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget
    public final void dr() {
        this.f53512o = (DetailDownLoadViewV2) this.contentView.findViewById(R.id.btn_download);
        this.f53513p = (ConstraintLayout) this.contentView.findViewById(R.id.cl_download_template_container);
        DetailDownLoadViewV2 r100 = this.f53512o;
        if (r100 == null) goto L17;
        Integer r101 = w.f561407a.getValue();
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.intValue() != 1) goto L10;
    L11:
        r100.H0 = r102;
        if (r102 == false) goto L14;
        int r103 = R.string.ttlive_promote_list_download_finish;
    L15:
        r100.setDownloadedText(r103);
        return;
    L14:
        r103 = R.string.ttlive_audience_game_promote_detail_install;
    L10:
        r102 = false;
        goto L11
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget, com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Fq() {
        super.Fq();
        Context r100 = this.context;
        if (r100 == null) goto L80;
        String r101 = Build.MANUFACTURER;
        if (StringsKt.equals(SystemUtils.PRODUCT_HUAWEI, r101, true) == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L80;
        if (StringsKt.equals(SystemUtils.PRODUCT_HUAWEI, r101, true) == false) goto L22;
        String r103 = Build.DEVICE;
        if (StringsKt.equals("HWTAH ", r103, true) == false) goto L16;
    L21:
        boolean r104 = true;
    L23:
        if (r104 == true) goto L80;
        if (StringsKt.equals(SystemUtils.PRODUCT_HUAWEI, r101, true) == false) goto L43;
        String r105 = Build.MODEL;
        if (StringsKt.equals("TAH-AN00", r105, true) == false) goto L29;
    L42:
        boolean r106 = true;
    L44:
        if (r106 == true) goto L80;
        if (StringsKt.equals("OPPO", r101, true) == false) goto L54;
        String r107 = Build.DEVICE;
        if (StringsKt.equals("OP4E75L1", r107, true) == false) goto L50;
    L53:
        boolean r108 = true;
    L55:
        if (r108 == true) goto L80;
        List r109 = CollectionsKt.mutableListOf(new String[]{"V2178A", "V2229A", "V2226A", "V2266A"});
        if (StringsKt.equals("VIVO", r101, true) == false) goto L72;
        List r110 = r109;
        if ((r110 instanceof Collection) == true) goto L61;
    L63:
        Iterator r111 = r110.iterator();
    L65:
        if (r111.hasNext() == false) goto L69;
        if (StringsKt.equals((String) r111.next(), Build.MODEL, true) == false) goto L65;
        boolean r112 = true;
    L70:
        if (r112 == false) goto L72;
        boolean r113 = true;
    L73:
        if (r113 == true) goto L80;
        if (StringsKt.equals("Xiaomi", Build.MANUFACTURER, true) == false) goto L80;
        if (StringsKt.equals("M2011J18C", Build.MODEL, true) == false) goto L80;
    L69:
        r112 = false;
        goto L70
    L61:
        if (r110.isEmpty() == false) goto L63;
    L72:
        r113 = false;
        goto L73
    L50:
        if (StringsKt.equals("OP55F1L1", r107, true) == true) goto L53;
        if (StringsKt.equals("PHN110", Build.MODEL, true) == true) goto L53;
    L54:
        r108 = false;
        goto L55
    L29:
        if (StringsKt.equals("TAH-N29", r105, true) == true) goto L42;
        if (StringsKt.equals("TAH-AN00m", r105, true) == true) goto L42;
        if (StringsKt.equals("TAH-N29m", r105, true) == true) goto L42;
        if (StringsKt.equals("RLI-AN00", r105, true) == true) goto L42;
        if (StringsKt.equals("RLI-N29", r105, true) == true) goto L42;
        if (StringsKt.equals("RHA-AN00m", r105, true) == true) goto L42;
        if (StringsKt.equals("RHA-N29m", r105, true) == true) goto L42;
    L43:
        r106 = false;
        goto L44
    L16:
        if (StringsKt.equals("HWTAH-C", r103, true) == true) goto L21;
        if (StringsKt.equals("unknownRLI", r103, true) == true) goto L21;
        if (StringsKt.equals("unknownRHA", r103, true) == true) goto L21;
    L22:
        r104 = false;
        goto L23
    L7:
        if (r100.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L9;
        r102 = true;
    L80:
        View r114 = this.contentView;
        if (r114 == null) goto L102;
        ConstraintLayout r115 = (ConstraintLayout) r114;
        this.f54275y = r115;
        ViewParent r116 = r115.getParent();
        View r117 = null;
        if (r116 == null) goto L85;
        ViewParent r118 = r116.getParent();
    L87:
        if ((r118 instanceof LinearLayout) == true) goto L89;
        r118 = null;
    L89:
        LinearLayout r119 = (LinearLayout) r118;
        if (r119 == null) goto L92;
        View r120 = r119.findViewById(R.id.left_button_container);
    L94:
        if ((r120 instanceof FrameLayout) == false) goto L97;
        r117 = r120;
    L97:
        this.f54276z = (FrameLayout) r117;
        return;
    L92:
        r120 = null;
        goto L94
    L85:
        r118 = null;
        goto L87
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget, com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.ies.sve_list.RecyclerViewItemWidget, com.bytedance.ies.sve_core.PureWidget
    public final void Gq() {
        super.Gq();
        DownloadButtonAnimation r100 = this.f54274J;
        if (r100 == null) goto L16;
        yr.b.b(3, "DownloadButtonAnimation", "clear");
        if (r100.f54256k == false) goto L17;
        r100.f54247b.removeCallbacksAndMessages(null);
        a r101 = r100.f54248c;
        if (r101 == null) goto L9;
        r101.a();
    L9:
        a r102 = r100.f54249d;
        if (r102 == null) goto L12;
        r102.a();
    L12:
        a r103 = r100.f54250e;
        if (r103 == null) goto L18;
        r103.a();
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget, com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget
    public final /* bridge */ /* synthetic */ void Wq(com.bytedance.ies.sve_list.a r100) {
        jr((e) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget, com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final /* bridge */ /* synthetic */ void br(d0 r100) {
        jr((e) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget
    public final /* bridge */ /* synthetic */ void fr(com.bytedance.android.gamecp.business.gamedetail.component.c r100) {
        jr((e) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget
    public final void gr(boolean r100) {
        if (r100 == false) goto L7;
        DetailDownLoadViewV2 r101 = this.f53512o;
        if (r101 == null) goto L8;
        r101.setDownloadBtnReadyText(R.string.game_detail_per_download);
        return;
    L8:
        return;
    }

    public final boolean hr(dt.b r100) {
        if (this.I == false) goto L7;
        if (this.f54276z == null) goto L7;
    L12:
        return true;
    L7:
        if (u4.f561400a.getValue().contains(r100.F) == true) goto L9;
    L13:
        return false;
    L9:
        if (r100.P != 0) goto L13;
        if (v4.f561406a.getValue().booleanValue() == false) goto L13;
        goto L12
    }

    public final void jr(final e r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        super.fr(r100);
        r.a.c(this, r100, GameDownloadButtonItemWidget$onUpdate$1.INSTANCE, new GameDownloadButtonItemWidget$onUpdate$2(this, r100));
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDownloadButtonWidget, com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget, com.bytedance.android.gamecp.business.monitor.widget.BaseMonitorRecyclerItemWidget, com.bytedance.ies.sve_core.q
    public final /* bridge */ /* synthetic */ void wj(p r100) {
        jr((e) r100);
    }

    @Override // com.bytedance.android.gamecp.business.gamedetail.component.BaseGameDetailWidget
    public final void cr(boolean r100, d0 r101) {
        Intrinsics.checkNotNullParameter((e) r101, "data");
    }

    public GameDownloadButtonItemWidget(f0 r100, com.bytedance.android.gamecp.business.gamedetail.base.model.h r101, c0 r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "uiStyle");
        Intrinsics.checkNotNullParameter(r110, "itemLayoutStyle");
        super(r100, r101, r110, r111, null);
        this.N = r110;
        this.O = null;
        new AtomicBoolean(false);
    }
}
