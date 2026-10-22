package com.bytedanceos.appstore.buss.utilities;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {
    public static final void a(Context r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        r r12 = r.f8876a;
        String r13 = r10.getString(r11);
        kotlin.jvm.internal.q.f(r13, "getString(...)");
        r12.b(r10, r13);
    }

    public static final void b(Context r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "msg");
        r.f8876a.b(r10, r11);
    }

    public static final void c(View r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Context r12 = r10.getContext();
        kotlin.jvm.internal.q.f(r12, "getContext(...)");
        a(r12, r11);
    }

    public static final void d(View r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "msg");
        Context r12 = r10.getContext();
        kotlin.jvm.internal.q.f(r12, "getContext(...)");
        b(r12, r11);
    }

    public static final void e(Fragment r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "msg");
        Context r12 = r10.getContext();
        if (r12 == null) goto L6;
        b(r12, r11);
        return;
    }
}
