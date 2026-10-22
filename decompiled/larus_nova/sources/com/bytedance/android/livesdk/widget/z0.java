package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.RecommendFastGiftConfirmView;

/* JADX INFO: loaded from: classes11.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile z0 f162270a;

    public interface a {
        x0.b a(int r100, int r101, DialogInterface.OnClickListener r102);

        x0.b b(CharSequence r100);

        x0.b c(RecommendFastGiftConfirmView r100);

        x0.b d(boolean r100);

        x0.b e(int r100, CharSequence r101, DialogInterface.OnClickListener r102);

        x0 f();

        Context getContext();

        x0.b setContentView(View r100);

        x0.b setCornerRadius(float r100);

        x0.b setOnDismissListener(DialogInterface.OnDismissListener r100);

        x0.b setTitle(int r100);

        x0.b setTitle(CharSequence r100);
    }

    public z0() {
    }

    public static z0 a() {
        if (f162270a != null) goto L15;
        monitor-enter(z0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f162270a != null) goto L9;
        f162270a = new z0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(z0.class);     // Catch: Throwable -> L11
    L15:
        return f162270a;
    }

    public static x0.b b(Context r100) {
        return new x0.b(r100, 0);
    }
}
