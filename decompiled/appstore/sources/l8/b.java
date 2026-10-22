package l8;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.DateUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.PlayVideoDesActivity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.dismiss();
        }
    }

    /* JADX INFO: renamed from: l8.b$b, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0304b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f21919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f21920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AppInfo f21921c;

        public DialogInterfaceOnClickListenerC0304b(CheckBox r10, Activity r11, AppInfo r12) {
            this.f21919a = r10;
            this.f21920b = r11;
            this.f21921c = r12;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.dismiss();
            if (this.f21919a.isChecked() == false) goto L5;
            b0.n().F("play_today", System.currentTimeMillis(), null, BaseApplication.c());
        L5:
            b.a(this.f21920b, this.f21921c);
        }
    }

    public static /* synthetic */ void a(Activity r10, AppInfo r11) {
        c(r10, r11);
    }

    public static void b(Activity r10, AppInfo r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r12 = e.A();
        if (r12 != 0) goto L8;
        e0.e(R$string.retry_connection);
        return;
    L8:
        if (r12 != 2) goto L11;
        c(r10, r11);
        return;
    L11:
        if (r12 == 1) goto L13;
        return;
    L13:
        if (DateUtils.isToday(b0.n().p("play_today", null, BaseApplication.c())) == false) goto L16;
        c(r10, r11);
        return;
    L16:
        View r13 = LayoutInflater.from(r10).inflate(R$layout.dialog_mobile_tip, null);
        ((TextView) r13.findViewById(R$id.total_flow)).setText(r10.getString(R$string.alert_dataflow_videomessage));
        CheckBox r14 = (CheckBox) r13.findViewById(R$id.check_record);
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R$style.AppStoreDialogTheme)).setTitle(R$string.alert_dataflow_title).setView(r13).setPositiveButton(R$string.alert_dataflow_continue_play, new DialogInterfaceOnClickListenerC0304b(r14, r10, r11)).setNegativeButton(R$string.alert_different_signatures_cancel, new a()).create().show();
    }

    public static void c(Activity r10, AppInfo r11) {
        Intent r12 = new Intent(r10, PlayVideoDesActivity.class);
        r12.putExtra(SlardarSettingsConsts.SETTING_IMAGE, r11.mAppVideoImage);
        r12.putExtra("url", r11.mAppVideoUrl);
        r12.putExtra("type", r11.mAppVideoType);
        r12.putExtra("name", r11.appName);
        r10.startActivity(r12);
        d9.a.e().S(true, r11.appPackageName);
    }
}
