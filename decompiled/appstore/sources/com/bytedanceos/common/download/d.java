package com.bytedanceos.common.download;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Environment;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.ReflectTool;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f9818a;

        /* JADX INFO: renamed from: com.bytedanceos.common.download.d$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0129a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f9819a;

            public DialogInterfaceOnClickListenerC0129a(a r10) {
                this.f9819a = r10;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface r10, int r11) {
                ReflectTool.goToCleanerSafely(this.f9819a.f9818a, true);
            }
        }

        public a(Activity r10) {
            this.f9818a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f9818a.isFinishing() == false) goto L5;
            return;
        L5:
            OAlertDialogBuilder r10 = new OAlertDialogBuilder(this.f9818a).O(this.f9818a.getString(R$string.dialog_short_of_storage_title), false).s().H(this.f9818a.getString(R$string.dialog_short_of_storage_content), new DialogInterfaceOnClickListenerC0129a(this));
            r10.b(true);
            OAlertDialog r11 = (OAlertDialog) r10.a();
            c.a(this.f9818a, r11);
            r11.show();
        }
    }

    public static boolean a(Activity r10, long r11) {
        long r12 = e.I();
        if ((r12 - r11) > 0) goto L5;
    L8:
        j.n("SpacePrecondition device space:" + r12 + "/ size needed:" + r11);
        g(r10);
        return false;
    L5:
        if (e((long) (r11 * 2.5f)) == false) goto L8;
        return true;
    }

    public static boolean b(Activity r10, AppInfo r11) {
        long r12 = e.I();
        if ((r12 - r11.appBytes) > 0) goto L5;
    L8:
        j.n("SpacePrecondition" + r11.appPackageName + " | device space:" + r12 + "/app size:" + r11.appBytes);
        g(r10);
        return false;
    L5:
        if (f(r11) == false) goto L8;
        return true;
    }

    public static boolean c(long r10) {
        long r11 = e.I();
        if ((r11 - r10) > 0) goto L5;
    L8:
        j.n("SpacePrecondition device space:" + r11 + "/ size needed:" + r10);
        return false;
    L5:
        if (e((long) (r10 * 2.5f)) == false) goto L8;
        return true;
    }

    public static boolean d(Activity r10, List r11) {
        Iterator r12 = r11.iterator();
        long r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L16;
        AppInfo r14 = (AppInfo) r12.next();
        String r15 = r14.appPackageName;
        if (BaseApplication.c().b().b0(r15) == false) goto L10;
        if (BaseApplication.c().b().U(r15) == false) goto L4;
    L10:
        long r16 = r14.downloadTotalBytes;
        if (r16 > 0) goto L13;
        long r17 = r14.appBytes;
    L14:
        r13 = r13 + r17;
        goto L4
    L13:
        r17 = r16 - r14.downloadCurrentBytes;
        goto L14
    L16:
        return a(r10, r13);
    }

    public static boolean e(long r10) {
        if (Environment.getDataDirectory().getFreeSpace() <= r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f(AppInfo r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.appBytes >= 104857600) goto L8;
    L12:
        return true;
    L8:
        if (r10.getSoftType() != 3) goto L10;
        File r11 = Environment.getRootDirectory();
    L11:
        r11.getFreeSpace();
        goto L12
    L10:
        r11 = Environment.getDataDirectory();
        goto L11
    }

    public static void g(Activity r10) {
        if (r10 != null) goto L5;
        j.a("showCleanUpDialog invoked given null activity reference");
        return;
    L5:
        r10.runOnUiThread(new a(r10));
    }
}
