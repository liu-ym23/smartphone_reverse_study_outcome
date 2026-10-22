package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes9.dex */
public final class u extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u f133653a;

    public static u a() {
        if (f133653a != null) goto L6;
        f133653a = new u();
    L6:
        return f133653a;
    }

    public u() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.m, android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
        return super.onTouchEvent(r100, r101, r102);
    L4:
        th = move-exception;
        ALogger.e("SafeLinkMovementMethod", th.getMessage());
        return false;
    }
}
