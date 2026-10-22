package com.bytedance.android.livesdk.microom.enhance;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.livesdk.common.MarqueeTextView;

/* JADX INFO: loaded from: classes11.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153896a = 0;

    static {
    }

    public static void a(View r100, int r101) {
        if ((r100 instanceof TextView) == false) goto L6;
        ((TextView) r100).setTextColor(r101);
        return;
    L6:
        if ((r100 instanceof MarqueeTextView) == false) goto L10;
        ((MarqueeTextView) r100).setTextColor(r101);
        return;
    }
}
