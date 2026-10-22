package com.obric.oui.orecyclerview.widget;

import android.util.Log;
import android.view.MotionEvent;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: RecyclerViewExt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v {
    private static final String TAG = "RecyclerViewExt";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f35840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RecyclerView f35841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f35842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f35843d;

    /* JADX INFO: compiled from: RecyclerViewExt.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f35840a = new a(null);
    }

    public v(RecyclerView r2) {
        d.h.b.o.e(r2, "recyclerView");
        this.f35841b = r2;
        this.f35842c = true;
    }

    public final void a(boolean r2) {
        this.f35842c = r2;
        a(d.h.b.o.a("allowClickDuringOverScroll enable=", Boolean.valueOf(r2)));
    }

    public final void b(boolean r2) {
        this.f35843d = r2;
        a(d.h.b.o.a("allowClickDuringOverScrollDebugLog enable=", Boolean.valueOf(r2)));
    }

    public final boolean a(MotionEvent r10, boolean r11) {
        d.h.b.o.e(r10, "event");
        if (this.f35842c == true) goto L7;
        a("allowClickDecision action=" + r10.getActionMasked() + " allow=false result=" + r11);
        return r11;
    L7:
        if (r10.getAction() == 0) goto L9;
        return r11;
    L9:
        com.obric.oui.orecyclerview.base.a r0 = this.f35841b.mHorizontalEdgeEffect;
        com.obric.oui.orecyclerview.base.a r2 = this.f35841b.mVerticalEdgeEffect;
        if (r0 != null) goto L12;
        float r4 = 0.0f;
    L13:
        if (r2 != null) goto L15;
        float r5 = 0.0f;
    L16:
        boolean r7 = true;
        if (r4 != 0.0f) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L29;
        if (r0 != null) goto L24;
    L22:
        boolean r1 = false;
    L26:
        if (r1 == true) goto L29;
        boolean r3 = false;
    L31:
        if (r5 != 0.0f) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L43;
        if (r2 != null) goto L38;
    L36:
        boolean r9 = false;
    L40:
        if (r9 == true) goto L43;
        boolean r12 = false;
    L44:
        if (r3 == true) goto L49;
        if (r12 == true) goto L49;
        if (r11 == true) goto L49;
        r7 = false;
    L49:
        a("allowClickDecision action=" + r10.getActionMasked() + " result=" + r7 + " horizontal=" + r4 + " horizontalActive=" + r3 + " vertical=" + r5 + " verticalActive=" + r12);
        return r7;
    L38:
        if (r2.a() == true) goto L36;
        r9 = true;
    L43:
        r12 = true;
        goto L44
    L33:
        r8 = false;
        goto L34
    L24:
        if (r0.a() == true) goto L22;
        r1 = true;
    L29:
        r3 = true;
        goto L31
    L19:
        r6 = false;
        goto L20
    L15:
        r5 = r2.b();
        goto L16
    L12:
        r4 = r0.b();
        goto L13
    }

    private final void a(String r1) {
        if (this.f35843d == false) goto L6;
        a(TAG, r1);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
