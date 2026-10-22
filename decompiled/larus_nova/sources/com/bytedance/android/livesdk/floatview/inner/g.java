package com.bytedance.android.livesdk.floatview.inner;

import android.view.View;
import android.widget.RadioButton;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RadioButton f125182a;

    public g(RadioButton r100) {
        this.f125182a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RadioButton r101 = this.f125182a;
        r101.setChecked(!r101.isChecked());
        if (this.f125182a.isChecked() == false) goto L5;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.b.O2;
        Boolean r103 = Boolean.TRUE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        com.bytedance.android.livesdk.floatview.mob.a.a(true);
        ALogger.d("PartSceneFloatWindow", "check radioButton");
        return;
    L5:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = com.bytedance.android.livesdk.sharedpref.b.O2;
        Boolean r105 = Boolean.FALSE;
        r104.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
        com.bytedance.android.livesdk.floatview.mob.a.a(false);
        ALogger.d("PartSceneFloatWindow", "uncheck radioButton");
    }
}
