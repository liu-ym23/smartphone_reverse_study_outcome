package com.bytedance.android.livesdk.floatview;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f125258a;

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        com.bytedance.android.livesdk.f.d().f();
    }

    public o(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ttlive_live_dialog);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_dialog_video_float_window_guide, null);
        this.f125258a = r101;
        TextView r102 = (TextView) r101.findViewById(R.id.ttlive_dialog_guide_float_window_action_ok);
        TextView r103 = (TextView) r101.findViewById(R.id.ttlive_dialog_guide_float_window_action_cancel);
        setContentView(r101);
        r103.setOnClickListener(new m(this));
        r102.setOnClickListener(new n(this, r100));
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}
