package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f0 extends l0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f149580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f149581i;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f0 f149582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f149583b;

        public a(f0 r100, b r101) {
            this.f149582a = r100;
            this.f149583b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveFlashViewModel r101 = this.f149582a.f149510a;
            if (r101 == null) goto L7;
            q r102 = r101.getEventHelper();
            if (r102 == null) goto L7;
            b r103 = this.f149583b;
            r102.c(((com.bytedance.android.livesdk.livecommerce.oldflash.a) r103).f149573b, "button", ((com.bytedance.android.livesdk.livecommerce.oldflash.a) r103).f149569q);
        L7:
            LiveFlashViewModel r104 = this.f149582a.f149510a;
            if (r104 == null) goto L13;
            LiveData r105 = r104.getBarCodeClickObserver();
            if (r105 == null) goto L14;
            r105.setValue(this.f149583b);
            return;
        L14:
            return;
        }
    }

    public f0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f149580h = (TextView) r100.findViewById(R.id.tv_gen_barcode_hint);
        this.f149581i = (TextView) r100.findViewById(R.id.tv_gen_barcode);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.l0, com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        super.T3(r100, r101);
        if ((r100 instanceof com.bytedance.android.livesdk.livecommerce.oldflash.a) == true) goto L5;
        b r102 = null;
    L6:
        com.bytedance.android.livesdk.livecommerce.oldflash.a r103 = (com.bytedance.android.livesdk.livecommerce.oldflash.a) r102;
        if (r103 == null) goto L30;
        LiveFlashViewModel r104 = this.f149510a;
        if (r104 == null) goto L25;
        if (r104.getCanLogShowSku() != true) goto L25;
        LiveFlashViewModel r105 = this.f149510a;
        if (r105 == null) goto L25;
        if (r105.getHasLogShowSku() == true) goto L25;
        LiveFlashViewModel r106 = this.f149510a;
        if (r106 == null) goto L19;
        r106.setHasLogShowSku(true);
    L19:
        LiveFlashViewModel r107 = this.f149510a;
        if (r107 == null) goto L25;
        q r108 = r107.getEventHelper();
        if (r108 == null) goto L25;
        r108.a(r103.f149569q, r103.f149573b);
    L25:
        if (((com.bytedance.android.livesdk.livecommerce.oldflash.a) r100).f149569q == false) goto L27;
        this.f149581i.setText(R.string.ec_live_flash_gen_barcode_manual);
        this.f149580h.setText(R.string.ec_live_flash_gen_barcode_auto_hint);
    L28:
        this.f149581i.setOnClickListener(new a(this, r100));
        return;
    L27:
        this.f149581i.setText(R.string.ec_live_flash_gen_barcode_auto);
        this.f149580h.setText(R.string.ec_live_flash_gen_barcode_manual_hint);
        goto L28
    L30:
        return;
    L5:
        r102 = r100;
        goto L6
    }
}
