package com.obric.oui.orecyclerview.widget;

import android.view.MotionEvent;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f15705c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f15706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15707b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f15705c = new a(null);
    }

    public h(RecyclerView r10) {
        q.g(r10, "recyclerView");
        this.f15706a = r10;
    }

    public final boolean a(MotionEvent r10, boolean r11) {
        q.g(r10, "event");
        if (this.f15707b == true) goto L6;
        return r11;
    L6:
        if (r10.getAction() == 0) goto L8;
        return r11;
    L8:
        RecyclerView r12 = this.f15706a;
        com.obric.oui.orecyclerview.base.a r13 = r12.f15429J;
        com.obric.oui.orecyclerview.base.a r14 = r12.K;
        if (r13 != null) goto L11;
    L16:
        if (r14 == null) goto L24;
        if (r14.c() == 0.0f) goto L24;
        if (Math.abs(r14.c()) >= 100.0f) goto L24;
        return true;
    L24:
        return r11;
    L11:
        if (r13.c() == 0.0f) goto L16;
        if (Math.abs(r13.c()) >= 100.0f) goto L16;
        r11 = true;
        goto L16
    }
}
