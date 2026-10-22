package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import android.view.KeyEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.b f137280a;

    public e(a.b r100) {
        this.f137280a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r102, "event");
        if (66 == r101) goto L5;
        return false;
    L5:
        if (1 != r102.getAction()) goto L12;
        k82.a r103 = this.f137280a.f137270t.f137248a;
        if (r103 == null) goto L9;
        r103.x();
    L9:
        return true;
    L12:
        return false;
    }
}
