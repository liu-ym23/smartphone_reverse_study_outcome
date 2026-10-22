package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStockProgressLayout f150409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f150410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f150411c;

    public d(ECStockProgressLayout r100, long r101, long r102) {
        this.f150409a = r100;
        this.f150410b = r101;
        this.f150411c = r102;
    }

    public final void a() {
        int r100 = UtilityKotlinExtentionsKt.d(48);
        long r101 = this.f150410b;
        if (r101 == 0) goto L5;
        float r102 = (1 - ((this.f150411c * 1.0f) / r101)) * 100;
    L6:
        float r103 = 10;
        if (r102 > r103) goto L12;
        float r104 = r100;
        float r105 = r104 / this.f150409a.getWidth();
        ProgressBar r106 = this.f150409a.f150388a;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L11:
        r106.setProgress((int) (r105 * 100));
        ECStockProgressLayout.a(this.f150409a, r104);
    L16:
        TextView r107 = this.f150409a.f150391d;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L20:
        if (r104 < r107.getLeft()) goto L25;
        TextView r108 = this.f150409a.f150391d;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L24:
        r108.setVisibility(4);
        return;
    L25:
        TextView r109 = this.f150409a.f150391d;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L28:
        r109.setVisibility(0);
        return;
    L12:
        float r110 = r100;
        r104 = r110 + (((r102 - r103) / 90) * (this.f150409a.getWidth() - r110));
        ProgressBar r111 = this.f150409a.f150388a;
        if (r111 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
    L15:
        r111.setProgress((int) ((r104 / this.f150409a.getWidth()) * 100));
        ECStockProgressLayout.a(this.f150409a, r104);
        goto L16
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
