package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfMonitorDialog;", "Lcom/bytedance/android/live/room/discovery/IAnchorPerMonitorDialog;", "Landroid/view/View$OnClickListener;", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfMonitorDialog extends IAnchorPerMonitorDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f99186m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f99187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f99188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f99189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f99190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends CharSequence> f99191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Room f99192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f99193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayAdapter<String> f99194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnchorPerfMonitorDialogDetail f99195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<Integer, Drawable> f99196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f99197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.live.room.discovery.c f99198l;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorPerfMonitorDialog f99199a;

        public a(AnchorPerfMonitorDialog r100) {
            this.f99199a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AnchorPerfMonitorDialog r101 = this.f99199a;
            if (r101.f99195i != null) goto L5;
            r101.f99195i = new AnchorPerfMonitorDialogDetail(this.f99199a.getContext(), this.f99199a.f99191e);
        L5:
            AnchorPerfMonitorDialogDetail r102 = this.f99199a.f99195i;
            if (r102 != null) goto L8;
        L12:
            LinkedHashMap r103 = new LinkedHashMap();
            Room r104 = this.f99199a.f99192f;
            if (r104 == null) goto L15;
            r103.put("room_id", String.valueOf(r104.f162599id));
            r103.put("anchor_id", r104.getOwnerUserIdString());
        L15:
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_log_show", r103, new Object[0]);
            return;
        L8:
            if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L18;
            DialogLancet.handleBlockedDialogShow(r102);
            goto L12
        L18:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
        L11:
            DialogLancet.beforeDialogShow(r102);
            r102.show();
            DialogLancet.afterDialogShow(r102);
            goto L12
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorPerfMonitorDialog f99200a;

        public b(AnchorPerfMonitorDialog r100) {
            this.f99200a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AnchorPerfMonitorDialog r101 = this.f99200a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static final class c implements AdjustPercentBar.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorPerfMonitorDialog f99201a;

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void b() {
        }

        public c(AnchorPerfMonitorDialog r100) {
            this.f99201a = r100;
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void a(int r100) {
            AnchorPerfMonitorDialog r101 = this.f99201a;
            int r102 = AnchorPerfMonitorDialog.f99186m;
            r101.getClass();
            com.bytedance.android.live.pushstream.d r103 = null;
            RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r104 == null) goto L7;
            com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r105 = r104.getLiveStream();
            if (r105 == null) goto L7;
            r103 = r105.getValue();
        L7:
            if (r103 == null) goto L9;
            r103.p1(r100 / 100.0f);
        L9:
            LinkedHashMap r106 = new LinkedHashMap();
            Room r107 = this.f99201a.f99192f;
            if (r107 == null) goto L12;
            r106.put("room_id", String.valueOf(r107.f162599id));
            r106.put("anchor_id", r107.getOwnerUserIdString());
        L12:
            r106.put("status", String.valueOf(r100));
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_sound_click", r106, new Object[0]);
        }

        @Override // com.bytedance.android.live.effect.base.AdjustPercentBar.d
        public final void onChanged(int r100) {
            TextView r101 = (TextView) this.f99201a.findViewById(R.id.index);
            if (r101 == null) goto L6;
            r101.setText(String.valueOf(r100));
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_anchor_apm_monitor;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
    }

    public final void R0() {
        if (this.f99197k == false) goto L5;
        return;
    L5:
        ILinkServiceExternal r100 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r100 == null) goto L10;
        lc0.d r101 = r100.getPkService();
        if (r101 == null) goto L10;
        Long r102 = Long.valueOf(r101.A());
    L11:
        if (r102 == null) goto L19;
        long r103 = r102.longValue();
        if (r103 <= 0) goto L20;
        com.bytedance.android.live.room.discovery.c r104 = this.f99198l;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        com.bytedance.android.live.room.discovery.c r105 = new com.bytedance.android.live.room.discovery.c(this, r103 * ((long) 1000));
        this.f99198l = r105;
        r105.start();
        this.f99197k = true;
        return;
    L20:
        return;
    L19:
        return;
    L10:
        r102 = null;
        goto L11
    }

    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void Q0() {
        if (isShowing() == true) goto L6;
        return;
    L6:
        if ((!this.f99190d.isEmpty()) == false) goto L25;
        UtilityKotlinExtentionsKt.w(findViewById(R.id.ll_records));
        ArrayAdapter<String> r100 = this.f99194h;
        if (r100 == null) goto L10;
        r100.clear();
    L10:
        ArrayAdapter<String> r101 = this.f99194h;
        if (r101 != null) goto L13;
    L17:
        ArrayAdapter<String> r102 = this.f99194h;
        if (r102 == null) goto L20;
        r102.notifyDataSetChanged();
    L20:
        AnchorPerfMonitorDialogDetail r103 = this.f99195i;
        if (r103 == null) goto L27;
        ArrayAdapter<CharSequence> r104 = r103.f99202a;
        if (r104 == null) goto L28;
        r104.notifyDataSetChanged();
        return;
    L28:
        return;
    L27:
        return;
    L13:
        if (this.f99190d.size() <= 1) goto L15;
        List<String> r105 = this.f99190d.subList(0, 2);
    L16:
        r101.addAll(r105);
        goto L17
    L15:
        r105 = this.f99190d.subList(0, 1);
        goto L16
    L25:
        UtilityKotlinExtentionsKt.t(findViewById(R.id.ll_records));
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.live.room.discovery.c r101 = this.f99198l;
        if (r101 == null) goto L20;
        r101.cancel();
    L20:
        this.f99197k = false;
        AnchorPerfMonitorDialogDetail r102 = this.f99195i;
        if (r102 == null) goto L39;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L25;
    L27:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L30 Exception -> L32
    L36:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L30:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L32:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L30
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L30
        if (r104 == null) goto L36;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L30
        goto L36
    L25:
        if (Looper.myLooper() == r103.getLooper()) goto L27;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    L39:
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r105 == null) goto L16;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        R0();
        Q0();
        M0(this.f99189c, true);
        N0(this.f99188b);
        P0(this.f99187a);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public AnchorPerfMonitorDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f99187a = -1;
        this.f99188b = -1;
        this.f99189c = -1;
        this.f99190d = new ArrayList();
        this.f99191e = new ArrayList();
        this.f99196j = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void N0(int r100) {
        this.f99188b = r100;
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        ImageView r101 = (ImageView) findViewById(R.id.ic_net);
        if (r101 == null) goto L44;
        S0(r101, R.drawable.ttlive_ic_net_good_detail);
    L44:
        TextView r102 = (TextView) findViewById(R.id.tv_net);
        if (r102 == null) goto L47;
        r102.setText("Wi-Fi/移动网络良好");
    L47:
        TextView r103 = (TextView) findViewById(R.id.tv_net_desc);
        if (r103 == null) goto L57;
        r103.setText("建议不要频繁切换网络");
        return;
    L57:
        return;
    L8:
        if (r100 != 2) goto L10;
        ImageView r104 = (ImageView) findViewById(R.id.ic_net);
        if (r104 == null) goto L35;
        S0(r104, R.drawable.ttlive_ic_net_shaking_detail);
    L35:
        TextView r105 = (TextView) findViewById(R.id.tv_net);
        if (r105 == null) goto L38;
        r105.setText("Wi-Fi/移动网络波动");
    L38:
        TextView r106 = (TextView) findViewById(R.id.tv_net_desc);
        if (r106 == null) goto L55;
        r106.setText("可能影响开播，请检查网络状态");
        return;
    L55:
        return;
    L10:
        if (r100 != 3) goto L12;
        ImageView r107 = (ImageView) findViewById(R.id.ic_net);
        if (r107 == null) goto L26;
        S0(r107, R.drawable.ttlive_ic_net_stuck_detail);
    L26:
        TextView r108 = (TextView) findViewById(R.id.tv_net);
        if (r108 == null) goto L29;
        r108.setText("Wi-Fi/移动网络不佳");
    L29:
        TextView r109 = (TextView) findViewById(R.id.tv_net_desc);
        if (r109 == null) goto L53;
        r109.setText("建议切换网络");
        return;
    L53:
        return;
    L12:
        if (r100 != 4) goto L58;
        ImageView r110 = (ImageView) findViewById(R.id.ic_net);
        if (r110 == null) goto L17;
        S0(r110, R.drawable.ttlive_ic_net_error_detail);
    L17:
        TextView r111 = (TextView) findViewById(R.id.tv_net);
        if (r111 == null) goto L20;
        r111.setText("当前未连接网络");
    L20:
        TextView r112 = (TextView) findViewById(R.id.tv_net_desc);
        if (r112 == null) goto L51;
        r112.setText("请检查网络状态");
        return;
    L51:
        return;
    }

    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void P0(int r100) {
        this.f99187a = r100;
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        ImageView r101 = (ImageView) findViewById(R.id.ic_temp);
        if (r101 == null) goto L33;
        S0(r101, R.drawable.ttlive_ic_temp_regular_detail);
    L33:
        TextView r102 = (TextView) findViewById(R.id.tv_temp);
        if (r102 == null) goto L36;
        r102.setText("设备温度正常");
    L36:
        TextView r103 = (TextView) findViewById(R.id.tv_temp_desc);
        if (r103 == null) goto L44;
        r103.setText("建议适时检查，保障流畅开播");
        return;
    L44:
        return;
    L8:
        if (r100 != 2) goto L10;
        ImageView r104 = (ImageView) findViewById(R.id.ic_temp);
        if (r104 == null) goto L24;
        S0(r104, R.drawable.ttlive_ic_temp_warm_detail);
    L24:
        TextView r105 = (TextView) findViewById(R.id.tv_temp);
        if (r105 == null) goto L27;
        r105.setText("设备发热明显");
    L27:
        TextView r106 = (TextView) findViewById(R.id.tv_temp_desc);
        if (r106 == null) goto L42;
        r106.setText("设备发热，可能影响开播，建议采取降温措施");
        return;
    L42:
        return;
    L10:
        if (r100 != 3) goto L45;
        ImageView r107 = (ImageView) findViewById(R.id.ic_temp);
        if (r107 == null) goto L15;
        S0(r107, R.drawable.ttlive_ic_temp_hot_detail);
    L15:
        TextView r108 = (TextView) findViewById(R.id.tv_temp);
        if (r108 == null) goto L18;
        r108.setText("设备发热严重");
    L18:
        TextView r109 = (TextView) findViewById(R.id.tv_temp_desc);
        if (r109 == null) goto L40;
        r109.setText("设备发热严重，建议采取降温措施");
        return;
    L40:
        return;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        int r101 = b1.f158888a;
        b1.b(true, new AnchorPerfMonitorDialog$initDialogUI$1(this));
        TextView r102 = (TextView) findViewById(R.id.tv_record_title);
        if (r102 == null) goto L5;
        r102.setOnClickListener(new a(this));
    L5:
        ImageView r103 = (ImageView) findViewById(R.id.exit);
        if (r103 == null) goto L8;
        r103.setOnClickListener(new b(this));
    L8:
        AdjustPercentBar r104 = (AdjustPercentBar) findViewById(R.id.bar);
        if (r104 == null) goto L11;
        r104.c(s1.h(R.color.ttlive_color_80_161823), s1.h(R.color.ttlive_color_1F_161823), s1.h(R.color.ttlive_color_80_161823));
    L11:
        AdjustPercentBar r105 = (AdjustPercentBar) findViewById(R.id.bar);
        if (r105 == null) goto L14;
        r105.b();
    L14:
        AdjustPercentBar r106 = (AdjustPercentBar) findViewById(R.id.bar);
        if (r106 == null) goto L17;
        r106.e(100, 1, 100, true);
    L17:
        AdjustPercentBar r107 = (AdjustPercentBar) findViewById(R.id.bar);
        Integer r108 = null;
        if (r107 == null) goto L29;
        RoomContext r109 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r109 == null) goto L24;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r110 = r109.getLiveStream();
        if (r110 == null) goto L24;
        com.bytedance.android.live.pushstream.d r111 = r110.getValue();
    L25:
        if (r111 == null) goto L27;
        r111.N0();
        float r112 = 0.0f;
    L28:
        r107.setPercent((int) (r112 * 100));
        goto L29
    L27:
        r112 = 0.01f;
    L24:
        r111 = null;
    L29:
        TextView r113 = (TextView) findViewById(R.id.index);
        if (r113 == null) goto L35;
        AdjustPercentBar r114 = (AdjustPercentBar) findViewById(R.id.bar);
        if (r114 == null) goto L34;
        r108 = Integer.valueOf(r114.getPercent());
    L34:
        r113.setText(String.valueOf(r108.intValue()));
    L35:
        AdjustPercentBar r115 = (AdjustPercentBar) findViewById(R.id.bar);
        if (r115 == null) goto L38;
        r115.setOnLevelChangeListener(new c(this));
    L38:
        this.f99194h = new ArrayAdapter(getContext(), R.layout.ttlive_anchor_apm_monitor_item);
        ListView r116 = (ListView) findViewById(R.id.list);
        if (r116 == null) goto L41;
        r116.setAdapter(this.f99194h);
    L41:
        RelativeLayout r117 = (RelativeLayout) findViewById(R.id.rl_mic);
        int r118 = 8;
        if (r117 != null) goto L44;
    L48:
        LinearLayout r119 = (LinearLayout) findViewById(R.id.ll_bar);
        if (r119 != null) goto L51;
        return;
    L51:
        if (this.f99193g == false) goto L53;
        r118 = 0;
    L53:
        r119.setVisibility(r118);
        return;
    L44:
        if (this.f99193g == false) goto L46;
        int r120 = 0;
    L47:
        r117.setVisibility(r120);
        goto L48
    L46:
        r120 = 8;
        goto L47
    }

    @Override // com.bytedance.android.live.room.discovery.IAnchorPerMonitorDialog
    public final void M0(int r100, boolean r101) {
        this.f99189c = r100;
        if (isShowing() == true) goto L6;
        return;
    L6:
        if (r100 != 5) goto L8;
        ImageView r102 = (ImageView) findViewById(R.id.ic_mic);
        if (r102 == null) goto L58;
        S0(r102, R.drawable.ttlive_ic_mic_mute_detail);
    L58:
        TextView r103 = (TextView) findViewById(R.id.tv_mic);
        if (r103 == null) goto L61;
        r103.setText("已设置静音");
    L61:
        TextView r104 = (TextView) findViewById(R.id.tv_mic_desc);
        if (r104 == null) goto L64;
        r104.setText("请前往连线设置取消静音");
    L64:
        RelativeLayout r105 = (RelativeLayout) findViewById(R.id.rl_mic);
        if (r105 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r105);
    L67:
        LinearLayout r106 = (LinearLayout) findViewById(R.id.ll_bar);
        if (r106 == null) goto L70;
        UtilityKotlinExtentionsKt.t(r106);
    L70:
        ILinkServiceExternal r107 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r107 == null) goto L75;
        lc0.d r108 = r107.getPkService();
        if (r108 == null) goto L75;
        long r109 = r108.A();
    L77:
        if (r109 <= 0) goto L93;
        R0();
        ImageView r110 = (ImageView) findViewById(R.id.ic_mic);
        if (r110 == null) goto L81;
        S0(r110, R.drawable.ttlive_ic_mic_mute_punish);
    L81:
        TextView r111 = (TextView) findViewById(R.id.tv_mic);
        if (r111 == null) goto L94;
        r111.setText("已被系统静音");
        return;
    L94:
        return;
    L93:
        return;
    L75:
        r109 = 0;
        goto L77
    L8:
        if (r100 != 6) goto L10;
        ImageView r112 = (ImageView) findViewById(R.id.ic_mic);
        if (r112 == null) goto L46;
        S0(r112, R.drawable.ttlive_ic_mic_loud_detail);
    L46:
        TextView r113 = (TextView) findViewById(R.id.tv_mic);
        if (r113 == null) goto L49;
        r113.setText("音频音量过大");
    L49:
        TextView r114 = (TextView) findViewById(R.id.tv_mic_desc);
        if (r114 == null) goto L52;
        r114.setText("建议调低音量或调整麦克风距离");
    L52:
        LinearLayout r115 = (LinearLayout) findViewById(R.id.ll_bar);
        if (r115 == null) goto L91;
        UtilityKotlinExtentionsKt.w(r115);
        return;
    L91:
        return;
    L10:
        if (r100 != 7) goto L12;
        ImageView r116 = (ImageView) findViewById(R.id.ic_mic);
        if (r116 == null) goto L34;
        S0(r116, R.drawable.ttlive_ic_mic_error_detail);
    L34:
        TextView r117 = (TextView) findViewById(R.id.tv_mic);
        if (r117 == null) goto L37;
        r117.setText("无声音输出");
    L37:
        TextView r118 = (TextView) findViewById(R.id.tv_mic_desc);
        if (r118 == null) goto L40;
        r118.setText("建议检查音频设置");
    L40:
        LinearLayout r119 = (LinearLayout) findViewById(R.id.ll_bar);
        if (r119 == null) goto L89;
        UtilityKotlinExtentionsKt.t(r119);
        return;
    L89:
        return;
    L12:
        if (r100 != 8) goto L14;
        RelativeLayout r120 = (RelativeLayout) findViewById(R.id.rl_mic);
        if (r120 == null) goto L87;
        UtilityKotlinExtentionsKt.t(r120);
        return;
    L87:
        return;
    L14:
        if (this.f99193g == true) goto L16;
        return;
    L16:
        ImageView r121 = (ImageView) findViewById(R.id.ic_mic);
        if (r121 == null) goto L19;
        S0(r121, R.drawable.ttlive_ic_mic_regular_detail);
    L19:
        TextView r122 = (TextView) findViewById(R.id.tv_mic);
        if (r122 == null) goto L22;
        r122.setText("音频状态正常");
    L22:
        TextView r123 = (TextView) findViewById(R.id.tv_mic_desc);
        if (r123 == null) goto L25;
        r123.setText("适当的音量可以保障观众观看体验");
    L25:
        LinearLayout r124 = (LinearLayout) findViewById(R.id.ll_bar);
        if (r124 == null) goto L85;
        UtilityKotlinExtentionsKt.w(r124);
        return;
    }

    public final void S0(ImageView r100, int r101) {
        if (this.f99196j.containsKey(Integer.valueOf(r101)) == true) goto L5;
        this.f99196j.put(Integer.valueOf(r101), s1.m(r101));
    L5:
        Map<Integer, Drawable> r102 = this.f99196j;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        r100.setImageDrawable((Drawable) r103.get(Integer.valueOf(r101)));
    }
}
