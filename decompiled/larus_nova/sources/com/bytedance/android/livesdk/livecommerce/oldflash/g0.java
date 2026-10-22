package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g0 extends BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f149590c;

    public g0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f149590c = (TextView) r100.findViewById(R.id.tv_hint);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        if ((r100 instanceof d) == true) goto L5;
        r100 = null;
    L5:
        d r102 = (d) r100;
        if (r102 == null) goto L9;
        this.f149590c.setText(r102.f149575b);
        return;
    }
}
