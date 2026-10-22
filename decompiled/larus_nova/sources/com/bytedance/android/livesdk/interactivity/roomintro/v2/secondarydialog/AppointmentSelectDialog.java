package com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.interactivity.api.settings.config.o;
import com.bytedance.android.livesdk.interactivity.roomintro.v2.RoomIntroDataSource;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.service.com.bytedance.android.livesdkapi.message.AppointmentInfo;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomintro/v2/secondarydialog/AppointmentSelectDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentSelectDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f140643l = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoomIntroDataSource f140644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f140645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f140646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveSwitchButton f140647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f140648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f140649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HSImageView f140650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f140651k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppointmentSelectDialog f140652a;

        public b(AppointmentSelectDialog r100) {
            this.f140652a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f140652a.dismiss();     // Catch: Exception -> L5
        L9:
            AppointmentSelectDialog r101 = this.f140652a;
            int r102 = AppointmentSelectDialog.f140643l;
            r101.getClass();
            g r103 = u.l();
            Pair[] r104 = new Pair[4];
            RoomIntroDataSource r105 = r101.f140644d;
            String r106 = "";
            if (r105 == null) goto L14;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r107 = r105.f140588n;
            if (r107 == null) goto L14;
            String r108 = r107.c();
        L15:
            r104[0] = TuplesKt.to("live_type", r108);
            RoomIntroDataSource r109 = r101.f140644d;
            if (r109 == null) goto L22;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r110 = r109.f140588n;
            if (r110 == null) goto L22;
            String r111 = r110.a();
            if (r111 == null) goto L22;
            r106 = r111;
        L22:
            r104[1] = TuplesKt.to("anchor_id", r106);
            LiveSwitchButton r112 = r101.f140647g;
            if (r112 != null) goto L25;
        L27:
            String r113 = "close";
        L28:
            r104[2] = TuplesKt.to("status", r113);
            RoomIntroDataSource r114 = r101.f140644d;
            Long r115 = null;
            if (r114 == null) goto L33;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r116 = r114.f140588n;
            if (r116 == null) goto L33;
            Long r117 = r116.d();
        L34:
            if (r117 == null) goto L45;
            RoomIntroDataSource r118 = r101.f140644d;
            if (r118 == null) goto L40;
            com.bytedance.android.livesdk.interactivity.roomintro.v2.c r119 = r118.f140588n;
            if (r119 == null) goto L40;
            r115 = r119.d();
        L40:
            if (r115 != null) goto L43;
        L44:
            String r120 = "live_take_detail";
        L46:
            r104[3] = TuplesKt.to(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r120);
            r103.sendLog("livesdk_live_room_detail_announce_info_popup_back", MapsKt.mutableMapOf(r104), new Object[0]);
            return;
        L43:
            if (r115.longValue() != 0) goto L44;
        L45:
            r120 = "live_take_page";
        L33:
            r117 = null;
            goto L34
        L25:
            if (r112.isChecked() != true) goto L27;
            r113 = "open";
        L14:
            r108 = "";
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r121 = DialogFragmentLancet.sLastShowStack;
            if (r121 == null) goto L9;
            d.d(r121, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    static {
    }

    public AppointmentSelectDialog() {
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog);
        setShouldUseNewPanel(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f140646f;
        if (r102 == null) goto L9;
        Integer r103 = this.f140645e;
        if (r103 == null) goto L7;
        int r104 = r103.intValue();
    L8:
        a1.k(r102, Math.max(MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE, r104));
        goto L9
    L7:
        r104 = 0;
    L9:
        LiveSwitchButton r105 = this.f140647g;
        if (r105 == null) goto L12;
        r105.setOnCheckedChangeListener(new com.bytedance.android.livesdk.interactivity.roomintro.v2.secondarydialog.a(this));
    L12:
        RoomIntroDataSource r106 = this.f140644d;
        if (r106 == null) goto L19;
        PropertyOwner r107 = r106.f140586l;
        if (r107 == null) goto L19;
        Boolean r108 = (Boolean) r107.f64752a;
        if (r108 == null) goto L19;
        boolean r109 = r108.booleanValue();
    L20:
        LiveSwitchButton r110 = this.f140647g;
        if (r110 == null) goto L23;
        boolean r111 = r110.isChecked();
    L24:
        if (r109 == r111) goto L28;
        LiveSwitchButton r112 = this.f140647g;
        if (r112 == null) goto L28;
        r112.f(false, false);
    L28:
        int r113 = s1.y() - UtilityKotlinExtentionsKt.i(40);
        RoomIntroDataSource r114 = this.f140644d;
        if (r114 == null) goto L31;
        double r115 = ((double) ((o) r114.f140576b.getValue()).b()) / ((double) ((o) r114.f140576b.getValue()).d());
    L32:
        int r116 = (int) (r115 * ((double) r113));
        HSImageView r117 = this.f140650j;
        if (r117 == null) goto L35;
        a1.k(r117, r116);
    L35:
        HSImageView r118 = this.f140650j;
        if (r118 == null) goto L38;
        a1.p(r118, r113);
    L38:
        HSImageView r119 = this.f140650j;
        RoomIntroDataSource r120 = this.f140644d;
        String r121 = null;
        if (r120 == null) goto L43;
        String r122 = ((o) r120.f140576b.getValue()).c();
        if (r122 != null) goto L44;
        r122 = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/webcast/webcast_room_intro_appointment_preview.png";
    L44:
        ImageLoader.bindImage(r119, r122);
        TextView r123 = this.f140649i;
        if (r123 == null) goto L53;
        RoomIntroDataSource r124 = this.f140644d;
        if (r124 == null) goto L51;
        String r125 = ((o) r124.f140576b.getValue()).e();
        if (r125 != null) goto L52;
        r125 = "开启后，当前设置的预告会展示在直播间介绍，观众可点击预约你的直播";
    L52:
        r123.setText(r125);
        goto L53
    L51:
        r125 = null;
    L53:
        TextView r126 = this.f140648h;
        if (r126 == null) goto L63;
        RoomIntroDataSource r127 = this.f140644d;
        if (r127 == null) goto L62;
        AppointmentInfo r128 = r127.f140589o.b();
        if (r128 == null) goto L61;
        r121 = r128.getScheduledTimeText();
        if (r121 != null) goto L62;
    L61:
        r121 = "";
    L62:
        r126.setText(r121);
    L63:
        View r129 = this.f140651k;
        if (r129 == null) goto L67;
        r129.setOnClickListener(new b(this));
        return;
    L67:
        return;
    L43:
        r122 = null;
        goto L44
    L31:
        r115 = 0.5283582089552239d;
        goto L32
    L23:
        r111 = false;
    L19:
        r109 = false;
        goto L20
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_dialog_appointment_select, r101, false);
        this.f140646f = r103;
        this.f140647g = (LiveSwitchButton) r103.findViewById(R.id.appointment_select_switch_button);
        this.f140648h = (TextView) r103.findViewById(R.id.appointment_scheduled_time_text);
        this.f140649i = (TextView) r103.findViewById(R.id.appointment_select_intro_text);
        this.f140650j = (HSImageView) r103.findViewById(R.id.appointment_select_intro_image);
        this.f140651k = r103.findViewById(R.id.appointment_select_back);
        return r103;
    }
}
