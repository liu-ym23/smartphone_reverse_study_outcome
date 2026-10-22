package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153118a = 0;

    static {
    }

    public static void a(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "subTitle");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L18;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.ec_live_two_rows_text_toast, null);
        View r104 = r103.findViewById(R.id.toast_text);
        if (r104 == null) goto L15;
        TextView r105 = (TextView) r104;
        View r106 = r103.findViewById(R.id.toast_subtext);
        if (r106 == null) goto L13;
        r105.setText(r101);
        ((TextView) r106).setText(r102);
        Toast r107 = new Toast(r100);
        r107.setView(r103);
        r107.setGravity(17, 0, 0);
        r107.setDuration(0);
        r107.show();
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
