package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public final class j implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMusicFeedbackDialog f70170a;

    public j(KtvMusicFeedbackDialog r100) {
        this.f70170a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (((EditText) this.f70170a.X90(R.id.music_name)).isCursorVisible() == true) goto L7;
        ((EditText) this.f70170a.X90(R.id.music_name)).setCursorVisible(true);
        return false;
    L7:
        return false;
    }
}
