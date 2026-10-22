package androidx.activity;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class q {
    public static final void a(View r10, FullyDrawnReporterOwner r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "fullyDrawnReporterOwner");
        r10.setTag(R$id.report_drawn, r11);
    }
}
