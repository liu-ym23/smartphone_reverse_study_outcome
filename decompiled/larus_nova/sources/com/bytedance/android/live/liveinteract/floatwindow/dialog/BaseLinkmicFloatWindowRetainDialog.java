package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import am2.x;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xe0.k;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/dialog/BaseLinkmicFloatWindowRetainDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BaseLinkmicFloatWindowRetainDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f73307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IRoom f73308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f73309c;

    public String I0() {
        return null;
    }

    public int J0() {
        return 0;
    }

    public int L0() {
        return 0;
    }

    public void M0() {
        O0(((AppCompatRadioButton) findViewById(R.id.rb)).isChecked(), false);
        boolean r100 = k.f563345a;
        k.a(((AppCompatRadioButton) findViewById(R.id.rb)).isChecked(), "refuse");
        k.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void N0() {
        O0(((AppCompatRadioButton) findViewById(R.id.rb)).isChecked(), true);
        boolean r100 = k.f563345a;
        k.a(((AppCompatRadioButton) findViewById(R.id.rb)).isChecked(), "open");
        HashMap r101 = new HashMap();
        if (((AppCompatRadioButton) findViewById(R.id.rb)).isChecked() == false) goto L5;
        String r102 = "on";
    L6:
        r101.put("auto_open", r102);
        HashMap r103 = new HashMap();
        if (k.f563345a == false) goto L9;
        String r104 = "1";
    L10:
        r103.put("is_song_order", r104);
        Integer r105 = (Integer) hd0.c.f().f481009b;
        if (r105 != null) goto L14;
    L16:
        if (r105 != null) goto L19;
    L21:
        String r106 = "other";
    L22:
        r103.put("link_status", r106);
        r103.putAll(r101);
        j0.l().sendLog("livesdk_audience_apply_reserve_open", r103, new Object[]{IRoom.class, x.class});
        return;
    L19:
        if (r105.intValue() != 1) goto L21;
        r106 = e1.REPLY_ACTION_APPLY;
        goto L22
    L14:
        if (r105.intValue() != 2) goto L16;
        r106 = "link";
        goto L22
    L9:
        r104 = "0";
        goto L10
    L5:
        r102 = "off";
        goto L6
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f73307a.dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_dialog_linkmic_float_window_retain);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-2, -2);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setGravity(17);
    L8:
        Window r103 = getWindow();
        if (r103 == null) goto L11;
        r103.setBackgroundDrawable(new ColorDrawable(0));
    L11:
        ((LinearLayout) findViewById(R.id.rb_container)).setOnClickListener(new a(this));
        ((ConstraintLayout) findViewById(R.id.cancel_btn)).setOnClickListener(new b(this));
        ((ConstraintLayout) findViewById(R.id.confirm_btn)).setOnClickListener(new c(this));
        setOnCancelListener(d.f73334a);
        if (L0() == 0) goto L15;
        ((TextView) findViewById(R.id.title)).setText(L0());
    L15:
        if (J0() == 0) goto L17;
        ((TextView) findViewById(R.id.message_content)).setText(J0());
    L17:
        ImageLoader.bindImage((HSImageView) findViewById(R.id.head), I0());
        boolean r104 = k.f563345a;
        HashMap r105 = new HashMap();
        r105.put("trigger_scene", WsConstants.KEY_CONNECTION);
        j0.l().sendLog("livesdk_mini_window_popup_show", r105, new Object[]{IRoom.class, x.class});
        HashMap r106 = new HashMap();
        if (k.f563345a == false) goto L20;
        String r107 = "1";
    L21:
        r106.put("is_song_order", r107);
        Integer r108 = (Integer) hd0.c.f().f481009b;
        if (r108 != null) goto L25;
    L27:
        if (r108 != null) goto L30;
    L32:
        String r109 = "other";
    L33:
        r106.put("link_status", r109);
        j0.l().sendLog("livesdk_audience_apply_reserve_popup_show", r106, new Object[]{IRoom.class, x.class});
        return;
    L30:
        if (r108.intValue() != 1) goto L32;
        r109 = e1.REPLY_ACTION_APPLY;
        goto L33
    L25:
        if (r108.intValue() != 2) goto L27;
        r109 = "link";
        goto L33
    L20:
        r107 = "0";
        goto L21
    }

    public static void O0(boolean r100, boolean r101) {
        if (r100 == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = b6.f65240j;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, 1);
        return;
    L5:
        if (r101 == false) goto L7;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = b6.f65265z;
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, 0);
        return;
    L7:
        com.bytedance.android.livesdk.sharedpref.e<Integer> r104 = b6.f65265z;
        com.bytedance.android.livesdk.sharedpref.f.d(r104, Integer.valueOf(r104.getValue().intValue() + 1));
        com.bytedance.android.livesdk.sharedpref.e<Integer> r105 = b6.f65240j;
        r105.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r105, 2);
    }

    public BaseLinkmicFloatWindowRetainDialog(Context r100, IRoom r101, Runnable r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "room");
        super(r100);
        this.f73308b = r101;
        this.f73309c = r102;
        this.f73307a = new CompositeDisposable();
    }
}
