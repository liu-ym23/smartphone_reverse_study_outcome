package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStockProgressLayout f150651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Float f150652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f150653c;

    public l(ECStockProgressLayout r100, Float r101, String r102) {
        this.f150651a = r100;
        this.f150652b = r101;
        this.f150653c = r102;
    }

    public final void a() {
        Float r100 = this.f150652b;
        if (r100 == null) goto L8;
        float r101 = 10;
        if (r100.floatValue() > r101) goto L7;
        float r102 = ECStockProgressLayout.a(this.f150651a);
        this.f150651a.getWidth();
        ECStockProgressLayout r103 = this.f150651a;
        ECStockProgressLayout.b(r103, ECStockProgressLayout.a(r103));
    L9:
        TextView r104 = this.f150651a.f150625d;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L12:
        boolean r105 = false;
        if (r102 < r104.getLeft()) goto L18;
        TextView r106 = this.f150651a.f150625d;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L17:
        r106.setVisibility(4);
    L22:
        String r107 = this.f150653c;
        if (r107 != null) goto L25;
        return;
    L25:
        if (r107.length() <= 3) goto L27;
        boolean r108 = true;
    L28:
        Integer r109 = null;
        if (r108 == true) goto L32;
        r107 = null;
    L32:
        if (r107 == null) goto L50;
        TextView r110 = this.f150651a.f150623b;
        if (r110 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L37:
        if ((r110.getPaint().measureText(r107) + (UtilityKotlinExtentionsKt.d(8) * 2)) <= r102) goto L51;
        Integer r111 = Integer.valueOf((int) this.f150651a.f150629h);
        if (r111.intValue() <= 1) goto L41;
        r105 = true;
    L41:
        if (r105 == false) goto L43;
        r109 = r111;
    L43:
        if (r109 == null) goto L52;
        int r112 = r109.intValue();
        int r113 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.f150307a;
        int r114 = ((int) r102) - (UtilityKotlinExtentionsKt.d(8) * 2);
        TextView r115 = this.f150651a.f150623b;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("tvStockProgressDes");
    L47:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.b.a(r112, r114, r107, r115);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L27:
        r108 = false;
        goto L28
    L18:
        TextView r116 = this.f150651a.f150625d;
        if (r116 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("svStockLabel");
    L21:
        r116.setVisibility(0);
        goto L22
    L7:
        float r117 = ECStockProgressLayout.a(this.f150651a);
        r102 = r117 + (((this.f150652b.floatValue() - r101) / 90) * (this.f150651a.getWidth() - r117));
        ECStockProgressLayout.b(this.f150651a, r102);
        goto L9
    L8:
        r102 = 0.0f;
        goto L9
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
