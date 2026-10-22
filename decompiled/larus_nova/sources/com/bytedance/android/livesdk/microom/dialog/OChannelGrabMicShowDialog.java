package com.bytedance.android.livesdk.microom.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.rg;
import com.bytedance.android.livesdk.microom.api.GrabOnOffStatus;
import com.bytedance.android.livesdk.microom.api.MicOfficialChannelApi;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerImageView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.GregorianCalendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.c;
import py.k;
import rm2.b;
import rm2.d;
import rm2.e;
import rm2.f;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/microom/dialog/OChannelGrabMicShowDialog;", "Landroidx/appcompat/app/AppCompatDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OChannelGrabMicShowDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f153815d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GrabOnOffStatus f153816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rg f153817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f153818c;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L58;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        this.f153816a = GrabOnOffStatus.OPEN_ON_OFF;
        ImageView r100 = (ImageView) findViewById(R.id.mic_room_never_notice);
        if (r100 == null) goto L10;
        r100.setBackground(s1.m(R.drawable.ttlive_bg_official_channel_grab_mic_show_never_notice_unselected));
    L10:
        rg r101 = this.f153817b;
        Map<String, String> r102 = null;
        if (r101 == null) goto L51;
        TextView r103 = (TextView) findViewById(R.id.mic_room_info_nickname);
        if (r103 == null) goto L21;
        User r104 = r101.E();
        if (r104 == null) goto L19;
        String r105 = r104.getNickName();
        if (r105 == null) goto L19;
    L20:
        r103.setText(r105);
    L19:
        r105 = "未命名";
    L21:
        RoundCornerImageView r106 = (RoundCornerImageView) findViewById(R.id.mic_room_avatar_thumb);
        if (r106 == null) goto L28;
        User r107 = r101.E();
        if (r107 == null) goto L26;
        ImageModel r108 = r107.getAvatarThumb();
    L27:
        a1.x(r106, r108, -1, -1, R.drawable.ttlive_ic_withdraw_default_avatar);
        goto L28
    L26:
        r108 = null;
    L28:
        TextView r109 = (TextView) findViewById(R.id.mic_room_info_content);
        if (r109 == null) goto L31;
        r109.setText(r101.getText());
    L31:
        User r110 = r101.E();
        if (r110 == null) goto L36;
        c r111 = r110.getMAuthenticationInfo();
        if (r111 == null) goto L36;
        k r112 = r111.getAuthenticationBadge();
    L38:
        if (r112 == null) goto L48;
        HSImageView r113 = (HSImageView) findViewById(R.id.mic_room_info_auth);
        if (r113 == null) goto L51;
        r113.setVisibility(0);
        User r114 = r101.E();
        if (r114 == null) goto L46;
        c r115 = r114.getMAuthenticationInfo();
        if (r115 == null) goto L46;
        k r116 = r115.getAuthenticationBadge();
    L47:
        ImageUtil.loadImage(r113, r116, 0);
    L46:
        r116 = null;
        goto L47
    L48:
        HSImageView r117 = (HSImageView) findViewById(R.id.mic_room_info_auth);
        if (r117 == null) goto L51;
        r117.setVisibility(4);
    L36:
        r112 = null;
    L51:
        rg r118 = this.f153817b;
        if (r118 == null) goto L54;
        r102 = sm2.a.a(r118);
    L55:
        u.l().sendLog("carousel_grasp_microphone_show", r102, new Object[]{Room.class});
        return;
    L54:
        int r119 = sm2.a.f542568a;
        goto L55
    L58:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L57
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public static final void I0(OChannelGrabMicShowDialog r100) {
        if (r100.f153816a != GrabOnOffStatus.CLOSE_ON_OFF) goto L9;
        rg r101 = r100.f153817b;
        if (r101 == null) goto L7;
        Map<String, String> r102 = sm2.a.a(r101);
    L8:
        u.l().sendLog("carousel_grasp_microphone_not_prompt_select", r102, new Object[]{Room.class});
        goto L9
    L7:
        int r103 = sm2.a.f542568a;
        r102 = null;
    L9:
        MicOfficialChannelApi r104 = (MicOfficialChannelApi) com.bytedance.android.live.network.c.b().e(MicOfficialChannelApi.class);
        long r105 = r100.f153816a.getStatus();
        rg r106 = r100.f153817b;
        if (r106 == null) goto L15;
        User r107 = r106.E();
        if (r107 == null) goto L15;
        String r108 = r107.getIdStr();
        if (r108 == null) goto L15;
    L16:
        r100.f153818c.add(r104.modifyGrabMicSwitchRequest(r105, r108).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r100), f.f538533a));
        return;
    L15:
        r108 = "0";
        goto L16
    }

    public static String J0(long r100) {
        GregorianCalendar r101 = new GregorianCalendar();
        r101.setTimeInMillis(r100 * ((long) 1000));
        int r102 = r101.get(11);
        int r103 = r101.get(12);
        StringBuilder r104 = new StringBuilder();
        if (r102 >= 10) goto L5;
        String r105 = "0" + r102;
    L6:
        r104.append(r105);
        r104.append(":");
        if (r103 >= 10) goto L9;
        String r106 = "0" + r103;
    L10:
        r104.append(r106);
        return r104.toString();
    L9:
        r106 = String.valueOf(r103);
        goto L10
    L5:
        r105 = String.valueOf(r102);
        goto L6
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_official_channel_grab_mic_show);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setGravity(80);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L10;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        if (r103 == null) goto L10;
        r103.width = -1;
    L10:
        HSImageView r104 = (HSImageView) findViewById(R.id.mic_room_info_auth);
        if (r104 == null) goto L13;
        r104.setVisibility(4);
    L13:
        TextView r105 = (TextView) findViewById(R.id.mic_room_button_grab_refuse);
        if (r105 == null) goto L16;
        r105.setOnClickListener(new b(this));
    L16:
        TextView r106 = (TextView) findViewById(R.id.mic_room_button_grab_confirm);
        if (r106 == null) goto L19;
        r106.setOnClickListener(new rm2.c(this));
    L19:
        ImageView r107 = (ImageView) findViewById(R.id.mic_room_never_notice);
        if (r107 == null) goto L23;
        r107.setOnClickListener(new d(this));
        return;
    }

    public OChannelGrabMicShowDialog(Context r100, CompositeDisposable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "subscriptions");
        super(r100, R.style.ttlive_official_channel_grab_mic_show_dialog);
        this.f153818c = r101;
        this.f153816a = GrabOnOffStatus.OPEN_ON_OFF;
    }
}
