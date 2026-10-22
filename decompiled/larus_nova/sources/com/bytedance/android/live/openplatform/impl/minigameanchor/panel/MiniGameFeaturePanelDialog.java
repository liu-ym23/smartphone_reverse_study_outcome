package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.live.profit.lottery.LotteryState;
import com.bytedance.android.live.profit.lottery.i;
import com.bytedance.android.live.profit.lottery.l;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/panel/MiniGameFeaturePanelDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniGameFeaturePanelDialog extends LiveDialogFragment implements View.OnClickListener, Observer<KVData> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f85260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OpenPlatformContext f85261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OpenPlatformMgInfoModel f85262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveMiniGameFeaturePanelViewModel f85263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vo0.a f85264h;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniGameFeaturePanelDialog f85265a;

        public b(MiniGameFeaturePanelDialog r100) {
            this.f85265a = r100;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.k
        public final void a(boolean r100) {
            if (r100 == false) goto L19;
            OpenPlatformContext r101 = this.f85265a.f85261e;
            if (r101 == null) goto L20;
            AnchorMiniGameAppLogContextService r102 = (AnchorMiniGameAppLogContextService) r101.getService(AnchorMiniGameAppLogContextService.class);
            if (r102 == null) goto L21;
            HashMap<String, String> r103 = new HashMap();
            r103.put("screen_split_rate", "0.3");
            r103.put("click_type", "others");
            LiveMiniGameFeaturePanelViewModel r104 = this.f85265a.f85263g;
            if (r104 == null) goto L12;
            LiveData<Boolean> r105 = r104.getExplainStatus();
            if (r105 == null) goto L12;
            Boolean r106 = r105.getValue();
        L14:
            if (Intrinsics.areEqual(r106, Boolean.TRUE) == false) goto L16;
            r103.put("landingpage_type", "explain");
        L17:
            Unit r107 = Unit.INSTANCE;
            r102.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r103);
            return;
        L16:
            r103.put("landingpage_type", "unexplained");
        L12:
            r106 = null;
            goto L14
        L21:
            return;
        L20:
            return;
        }
    }

    static {
    }

    public MiniGameFeaturePanelDialog() {
        this.f85260d = new LinkedHashMap();
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r100 = AnchorMiniGameDataContext.a.a();
        if (r100 == null) goto L7;
        n<OpenPlatformMgInfoModel> r101 = r100.getOpenPlatformMg();
        if (r101 == null) goto L7;
        OpenPlatformMgInfoModel r102 = r101.getValue();
    L8:
        this.f85262f = r102;
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f85260d.clear();
    }

    public static void S90(MiniGameFeaturePanelDialog r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final View T90(int r100) {
        if (this.f85260d != null) goto L5;
        this.f85260d = new LinkedHashMap();
    L5:
        View r101 = this.f85260d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f85260d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L13;
        String r102 = r101.getKey();
        if (r102.hashCode() == (-1677062600)) goto L9;
        return;
    L9:
        if (r102.equals("cmd_anchor_broadcast_end") == false) goto L12;
        S90(this);
        return;
    L12:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        Boolean r100 = null;
        if (r110 == null) goto L5;
        Integer r111 = Integer.valueOf(r110.getId());
    L7:
        if (r111 == null) goto L26;
        if (r111.intValue() != R.id.close_dialog_ic) goto L26;
        S90(this);
        OpenPlatformContext r112 = this.f85261e;
        if (r112 == null) goto L128;
        AnchorMiniGameAppLogContextService r113 = (AnchorMiniGameAppLogContextService) r112.getService(AnchorMiniGameAppLogContextService.class);
        if (r113 == null) goto L129;
        HashMap<String, String> r101 = new HashMap();
        r101.put("screen_split_rate", "0.3");
        r101.put("click_type", "close");
        LiveMiniGameFeaturePanelViewModel r102 = this.f85263g;
        if (r102 == null) goto L21;
        LiveData<Boolean> r103 = r102.getExplainStatus();
        if (r103 == null) goto L21;
        r100 = r103.getValue();
    L21:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L23;
        r101.put("landingpage_type", "explain");
    L24:
        Unit r104 = Unit.INSTANCE;
        r113.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r101);
        return;
    L23:
        r101.put("landingpage_type", "unexplained");
        goto L24
    L129:
        return;
    L128:
        return;
    L26:
        if (r111 != null) goto L29;
    L49:
        if (r111 != null) goto L52;
    L76:
        if (r111 != null) goto L79;
        return;
    L79:
        if (r111.intValue() != R.id.lottery_btn) goto L140;
        LiveMiniGameFeaturePanelViewModel r114 = this.f85263g;
        if (r114 == null) goto L113;
        LiveData<yq0.e> r115 = r114.getLotteryConfig();
        if (r115 == null) goto L113;
        yq0.e r116 = r115.getValue();
        if (r116 == null) goto L113;
        String r117 = r116.d();
        if (r117 == null) goto L113;
        i r118 = yt0.c.f();
        if (r118 == null) goto L95;
        n<? extends com.bytedance.android.live.profit.lottery.g> r119 = r118.getCurrentLottery();
        if (r119 == null) goto L95;
        com.bytedance.android.live.profit.lottery.g r120 = r119.getValue();
        if (r120 == null) goto L95;
        LotteryState r121 = r120.getState();
    L96:
        if (r121 != null) goto L98;
    L105:
        ILiveService r122 = TTLiveService.getLiveService();
        if (r122 == null) goto L108;
        Boolean r123 = Boolean.valueOf(r122.handleSchema(getContext(), UriProtector.parse(r117)));
    L110:
        if ((!Intrinsics.areEqual(r123, Boolean.TRUE)) == false) goto L112;
        x8.a.d("MiniGameFeaturePanelDialog", "open minigame lottery failed", false);
    L112:
        S90(this);
        goto L113
    L108:
        r123 = null;
        goto L110
    L98:
        if (l.b(r121) == true) goto L105;
        i r124 = yt0.c.f();
        if (r124 == null) goto L112;
        k<Unit> r125 = r124.getOnToolbarButtonClick();
        if (r125 == null) goto L112;
        r125.post(Unit.INSTANCE);
    L95:
        r121 = null;
    L113:
        OpenPlatformContext r126 = this.f85261e;
        if (r126 == null) goto L141;
        AnchorMiniGameAppLogContextService r127 = (AnchorMiniGameAppLogContextService) r126.getService(AnchorMiniGameAppLogContextService.class);
        if (r127 == null) goto L142;
        HashMap<String, String> r105 = new HashMap();
        r105.put("screen_split_rate", "0.3");
        r105.put("click_type", "lottery");
        LiveMiniGameFeaturePanelViewModel r106 = this.f85263g;
        if (r106 == null) goto L123;
        LiveData<Boolean> r107 = r106.getExplainStatus();
        if (r107 == null) goto L123;
        r100 = r107.getValue();
    L123:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L125;
        r105.put("landingpage_type", "explain");
    L126:
        Unit r108 = Unit.INSTANCE;
        r127.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r105);
        return;
    L125:
        r105.put("landingpage_type", "unexplained");
        goto L126
    L142:
        return;
    L141:
        return;
    L140:
        return;
    L52:
        if (r111.intValue() != R.id.speak_card_btn) goto L76;
        LiveMiniGameFeaturePanelViewModel r128 = this.f85263g;
        if (r128 == null) goto L59;
        LiveData<Boolean> r129 = r128.getExplainStatus();
        if (r129 == null) goto L59;
        r100 = r129.getValue();
    L59:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L68;
        LiveMiniGameFeaturePanelViewModel r130 = this.f85263g;
        if (r130 == null) goto L63;
        r130.deleteExplainCard();
    L63:
        OpenPlatformContext r131 = this.f85261e;
        if (r131 == null) goto L134;
        AnchorMiniGameAppLogContextService r132 = (AnchorMiniGameAppLogContextService) r131.getService(AnchorMiniGameAppLogContextService.class);
        if (r132 == null) goto L135;
        HashMap<String, String> r109 = new HashMap();
        r109.put("screen_split_rate", "0.3");
        r109.put("click_type", "live_card");
        r109.put("landingpage_type", "explain");
        Unit r133 = Unit.INSTANCE;
        r132.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r109);
        return;
    L135:
        return;
    L134:
        return;
    L68:
        LiveMiniGameFeaturePanelViewModel r134 = this.f85263g;
        if (r134 == null) goto L71;
        r134.setExplainCard();
    L71:
        OpenPlatformContext r135 = this.f85261e;
        if (r135 == null) goto L137;
        AnchorMiniGameAppLogContextService r136 = (AnchorMiniGameAppLogContextService) r135.getService(AnchorMiniGameAppLogContextService.class);
        if (r136 == null) goto L138;
        HashMap<String, String> r137 = new HashMap();
        r137.put("screen_split_rate", "0.3");
        r137.put("click_type", "live_card");
        r137.put("landingpage_type", "unexplained");
        Unit r138 = Unit.INSTANCE;
        r136.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r137);
        return;
    L138:
        return;
    L137:
        return;
    L29:
        if (r111.intValue() != R.id.exit_mount) goto L49;
        x0.b r139 = new x0.b(getContext(), 4);
        x0.d r140 = r139.f162238a;
        r140.f162252k = false;
        r140.f162253l = false;
        r139.m(R.string.ttlive_open_platform_mg_exit_mount_title);
        r139.l(R.string.ttlive_open_platform_mg_live_exit_mount_content);
        r139.i(0, R.string.ttlive_open_platform_mg_exit_mount_exit, new f(this));
        r139.i(1, R.string.ttlive_open_platform_mg_exit_mount_cancel, new g(this));
        r139.k(0, true);
        r139.n();
        OpenPlatformContext r141 = this.f85261e;
        if (r141 == null) goto L35;
        AnchorMiniGameAppLogContextService r142 = (AnchorMiniGameAppLogContextService) r141.getService(AnchorMiniGameAppLogContextService.class);
        if (r142 == null) goto L35;
        HashMap<String, String> r143 = new HashMap();
        r143.put("screen_split_rate", "0.3");
        Unit r144 = Unit.INSTANCE;
        r142.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_show", r143);
    L35:
        OpenPlatformContext r145 = this.f85261e;
        if (r145 == null) goto L131;
        AnchorMiniGameAppLogContextService r146 = (AnchorMiniGameAppLogContextService) r145.getService(AnchorMiniGameAppLogContextService.class);
        if (r146 == null) goto L132;
        HashMap<String, String> r147 = new HashMap();
        r147.put("screen_split_rate", "0.3");
        r147.put("click_type", "remove");
        LiveMiniGameFeaturePanelViewModel r148 = this.f85263g;
        if (r148 == null) goto L45;
        LiveData<Boolean> r149 = r148.getExplainStatus();
        if (r149 == null) goto L45;
        r100 = r149.getValue();
    L45:
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L47;
        r147.put("landingpage_type", "explain");
    L48:
        Unit r150 = Unit.INSTANCE;
        r146.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_click", r147);
        return;
    L47:
        r147.put("landingpage_type", "unexplained");
        goto L48
    L132:
        return;
    L131:
        return;
    L5:
        r111 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_open_feature_dialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Context r101 = getContext();
        if (r101 == null) goto L13;
        LiveBottomSheetDialog r102 = new LiveBottomSheetDialog(r101, getTheme());
        Window r103 = r102.getWindow();
        if (r103 == null) goto L7;
        r103.setGravity(80);
    L7:
        Window r104 = r102.getWindow();
        if (r104 == null) goto L10;
        r104.setDimAmount(0.0f);
    L10:
        r102.setCanceledOnTouchOutside(true);
        r102.setNeedHookBottomSheetInterceptEvent(true);
        r102.setLiveBottomSheetOutsideListener(new b(this));
        return r102;
    L13:
        return super.onCreateDialog(r100);
    }

    public static final String U90(MiniGameFeaturePanelDialog r100, long r110) {
        r100.getClass();
        long r101 = 1000;
        if (r110 < r101) goto L13;
        long r102 = 10000;
        if (r110 >= r102) goto L9;
        return new StringBuilder(String.valueOf(r110)).insert(1, ",").toString();
    L9:
        if ((r110 % r102) >= r101) goto L11;
        StringBuilder r103 = new StringBuilder();
        r103.append((int) (r110 / r102));
        r103.append(Permission.WRITE);
        return r103.toString();
    L11:
        StringBuilder r104 = new StringBuilder();
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r104.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r110 / 10000)}, 1)));
        r104.append(Permission.WRITE);
        return r104.toString();
    L13:
        return String.valueOf(r110);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ImageView r102 = (ImageView) T90(R.id.close_dialog_ic);
        if (r102 == null) goto L5;
        r102.setOnClickListener(this);
    L5:
        TextView r103 = (TextView) T90(R.id.exit_mount);
        if (r103 == null) goto L8;
        r103.setOnClickListener(this);
    L8:
        Button r104 = (Button) T90(R.id.speak_card_btn);
        if (r104 == null) goto L11;
        r104.setOnClickListener(this);
    L11:
        Button r105 = (Button) T90(R.id.lottery_btn);
        if (r105 == null) goto L14;
        r105.setOnClickListener(this);
    L14:
        HSImageView r106 = (HSImageView) T90(R.id.game_info_icon);
        Boolean r107 = null;
        if (r106 == null) goto L21;
        OpenPlatformMgInfoModel r108 = this.f85262f;
        if (r108 == null) goto L19;
        String r109 = r108.getAppIcon();
    L20:
        r106.setImageURI(r109);
        goto L21
    L19:
        r109 = null;
    L21:
        TextView r110 = (TextView) T90(R.id.game_info_name);
        if (r110 == null) goto L28;
        OpenPlatformMgInfoModel r111 = this.f85262f;
        if (r111 == null) goto L26;
        String r112 = r111.getAppName();
    L27:
        r110.setText(r112);
        goto L28
    L26:
        r112 = null;
    L28:
        TextView r113 = (TextView) T90(R.id.game_info_summary);
        if (r113 == null) goto L35;
        OpenPlatformMgInfoModel r114 = this.f85262f;
        if (r114 == null) goto L33;
        String r115 = r114.getGameSummary();
    L34:
        r113.setText(r115);
        goto L35
    L33:
        r115 = null;
    L35:
        OpenPlatformMgAnchorServiceImpl.Companion.getClass();
        po0.a.b r116 = (po0.a.b) OpenPlatformMgAnchorServiceImpl.access$getDiComponent$cp();
        r116.getClass();
        vo0.a r117 = r116.f530020a.f530024e.get();
        this.f85264h = r117;
        if (r117 == null) goto L38;
        OpenPlatformContext r118 = r117.a();
    L39:
        this.f85261e = r118;
        if (this.f85263g == null) goto L42;
    L50:
        LiveMiniGameFeaturePanelViewModel r119 = this.f85263g;
        if (r119 == null) goto L55;
        LiveData<Boolean> r120 = r119.getEnableExplain();
        if (r120 == null) goto L55;
        r120.observe(this, new com.bytedance.android.live.openplatform.impl.minigameanchor.panel.a(this));
    L55:
        LiveMiniGameFeaturePanelViewModel r121 = this.f85263g;
        if (r121 == null) goto L60;
        LiveData<Boolean> r122 = r121.getExplainStatus();
        if (r122 == null) goto L60;
        r122.observe(this, new com.bytedance.android.live.openplatform.impl.minigameanchor.panel.b(this));
    L60:
        LiveMiniGameFeaturePanelViewModel r123 = this.f85263g;
        if (r123 == null) goto L65;
        LiveData<yq0.e> r124 = r123.getLotteryConfig();
        if (r124 == null) goto L65;
        r124.observe(this, new c(this));
    L65:
        LiveMiniGameFeaturePanelViewModel r125 = this.f85263g;
        if (r125 == null) goto L70;
        LiveData<Boolean> r126 = r125.getExitMountStatus();
        if (r126 == null) goto L70;
        r126.observe(this, new d(this));
    L70:
        LiveMiniGameFeaturePanelViewModel r127 = this.f85263g;
        if (r127 == null) goto L75;
        LiveData<yq0.d> r128 = r127.getRealTimeData();
        if (r128 == null) goto L75;
        r128.observe(this, new e(this));
    L75:
        OpenPlatformContext r129 = this.f85261e;
        if (r129 == null) goto L80;
        DataCenter r130 = r129.getDataCenter();
        if (r130 == null) goto L80;
        r130.observe("cmd_anchor_broadcast_end", this);
    L80:
        OpenPlatformContext r131 = this.f85261e;
        if (r131 == null) goto L85;
        LiveMiniGameFeaturePanelViewModel r132 = this.f85263g;
        if (r132 == null) goto L85;
        r132.initData(r131);
    L85:
        OpenPlatformContext r133 = this.f85261e;
        if (r133 == null) goto L100;
        AnchorMiniGameAppLogContextService r134 = (AnchorMiniGameAppLogContextService) r133.getService(AnchorMiniGameAppLogContextService.class);
        if (r134 == null) goto L101;
        HashMap<String, String> r135 = new HashMap();
        r135.put("screen_split_rate", "0.3");
        LiveMiniGameFeaturePanelViewModel r136 = this.f85263g;
        if (r136 == null) goto L95;
        LiveData<Boolean> r137 = r136.getExplainStatus();
        if (r137 == null) goto L95;
        r107 = r137.getValue();
    L95:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L97;
        r135.put("landingpage_type", "explain");
    L98:
        Unit r138 = Unit.INSTANCE;
        r134.reportLiveRoomMgAppLog("livesdk_anchor_mg_landingpage_show", r135);
        return;
    L97:
        r135.put("landingpage_type", "unexplained");
        goto L98
    L101:
        return;
    L100:
        return;
    L42:
        if ((getActivity() instanceof FragmentActivity) == false) goto L48;
        FragmentActivity r139 = getActivity();
        if (r139 == null) goto L47;
        LiveMiniGameFeaturePanelViewModel r140 = (LiveMiniGameFeaturePanelViewModel) ViewModelProviders.of(r139).get(LiveMiniGameFeaturePanelViewModel.class);
    L49:
        this.f85263g = r140;
        goto L50
    L47:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L48:
        r140 = (LiveMiniGameFeaturePanelViewModel) ViewModelProviders.of(this).get(LiveMiniGameFeaturePanelViewModel.class);
        goto L49
    L38:
        r118 = null;
        goto L39
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_open_platform_mg_panel_layout, r101, false);
    }
}
