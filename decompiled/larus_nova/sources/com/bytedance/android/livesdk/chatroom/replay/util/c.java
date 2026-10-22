package com.bytedance.android.livesdk.chatroom.replay.util;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<View> f110265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f110266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f110267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f110268d;

    public final void c() {
        this.f110267c = true;
        update();
    }

    private final void update() {
        View r100 = this.f110265a.get();
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f110267c == true) goto L7;
    L11:
        int r101 = 8;
    L12:
        r100.setVisibility(r101);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L17;
        r102.height = this.f110266b;
        return;
    L17:
        return;
    L7:
        if (this.f110268d != 1) goto L9;
    L10:
        r101 = 0;
        goto L12
    L9:
        if (PadConfigUtils.d() == false) goto L11;
        goto L10
    }

    public c() {
        this.f110265a = new WeakReference(null);
        this.f110268d = 1;
    }

    public final void a(View r100) {
        this.f110265a.clear();
        this.f110265a = new WeakReference(r100);
        update();
    }

    public final void b(int r100) {
        this.f110268d = r100;
        update();
    }

    public final void d(int r100) {
        this.f110266b = r100;
        update();
    }
}
