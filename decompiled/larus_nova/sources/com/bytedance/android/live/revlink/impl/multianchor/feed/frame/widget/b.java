package com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget;

import android.view.View;
import android.widget.FrameLayout;
import b31.d;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.c;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.e;
import com.bytedance.android.live.revlink.impl.multianchor.feed.frame.playui.f;
import com.bytedance.android.live.revlink.impl.multianchor.ui.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f94218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f94219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f94220c;

    public b(FrameLayout r100) {
        this.f94220c = r100;
        this.f94218a = new d();
    }

    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutState");
        Boolean r101 = r100.f94193a;
        if (r101 == null) goto L22;
        r101.booleanValue();
        c r102 = r100.f94198f;
        if (r102 == null) goto L23;
        s r103 = r102.f94192b;
        if (r103 == null) goto L28;
        f r104 = r100.f94196d;
        if (r104 == null) goto L24;
        Integer r105 = r104.f94200b;
        if (r105 == null) goto L25;
        int r106 = r105.intValue();
        b31.e r107 = r100.f94194b;
        if (r107 == null) goto L26;
        int r108 = r107.f17179e;
        int r109 = r107.f17180f;
        this.f94218a.getClass();
        b31.a r110 = d.a(r103, r106, r108, r109);
        if (r110 == null) goto L27;
        View r111 = this.f94219b;
        if (r111 != null) goto L20;
        return;
    L20:
        b31.c.b(r111, r110);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L28:
        return;
    L23:
        return;
    }
}
