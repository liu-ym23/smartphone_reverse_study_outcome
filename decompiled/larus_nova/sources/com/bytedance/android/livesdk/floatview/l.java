package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f125236a = 0;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f125237a = null;

        static {
            f125237a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    static {
    }

    public static Intent a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        return com.bytedance.android.live.core.utils.a.a(r100, r101);
    }

    public static boolean b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        if (rx1.m.a(r100) == true) goto L13;
        x0.d r102 = new x0.d();
        r102.f162243b = r100;
        r102.f162242a = 4;
        r102.f162244c = r102.f162243b.getText(R.string.ttlive_verify_label);
        r102.f162245d = r102.f162243b.getText(R.string.ttlive_float_tip_content);
        a r103 = a.f125237a;
        CharSequence r104 = r102.f162243b.getText(R.string.ttlive_ok);
        x0.c[] r105 = r102.f162248g;
        x0.c r106 = r105[0];
        if (r106 != null) goto L7;
        r106 = new x0.c();
        r105[0] = r106;
    L7:
        r106.f162239a = r104;
        r106.f162240b = r103;
        x0 r107 = new x0(r102.f162243b, r102);
        if (Build.VERSION.SDK_INT < 26) goto L10;
        r107.getWindow().setType(2038);
    L11:
        x0.b.g(r107);
        return false;
    L10:
        r107.getWindow().setType(2002);
        goto L11
    L13:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "packageName");
        if (Intrinsics.areEqual(r100.getPackageName(), r101) == false) goto L27;
        Context r108 = r100;
    L21:
        Intent r109 = a(r100, r101);
        if (r108 == null) goto L26;
        if (r109 == null) goto L26;
        r109.putExtra("key_is_start_main_activity", true);
        r109.putExtra("key_is_move_task_to_front", true);
        r108.startActivity(r109);
        return true;
    L26:
        return false;
    L27:
        r108 = r100.createPackageContext(r101, 3);     // Catch: PackageManager.NameNotFoundException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        r108 = null;
        goto L21
    }
}
