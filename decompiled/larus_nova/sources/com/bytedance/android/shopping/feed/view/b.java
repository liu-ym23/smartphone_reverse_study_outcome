package com.bytedance.android.shopping.feed.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated(message = "请使用ui-ec-widget中的ECLoadingDialog")
public final class b extends Dialog implements DialogInterface.OnKeyListener {
    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return true;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
        if (r101 != 4) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return true;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, 0);
        setContentView(R.layout.ec_loading_dialog);
        ECStatusView r101 = (ECStatusView) findViewById(R.id.loading_dialog_status_view);
        if (r101 == null) goto L5;
        r101.b(r100, null, null);
    L5:
        if (r101 == null) goto L8;
        r101.c();
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.clearFlags(2);
        setCancelable(false);
        setOnKeyListener(this);
    }
}
