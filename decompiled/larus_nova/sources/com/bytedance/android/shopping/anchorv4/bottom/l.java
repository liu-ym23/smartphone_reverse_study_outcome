package com.bytedance.android.shopping.anchorv4.bottom;

import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.shopping.anchorv4.bottom.widget.CenteredTextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.LynxCardView;
import com.larus.nova.R;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class l implements l1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomTipMeta f165850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CenteredTextWithOneIconElementView f165851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxCardView f165852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f165853d;

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    public l(LinearLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "llTips");
        this.f165853d = r100;
        this.f165851b = (CenteredTextWithOneIconElementView) r100.findViewById(R.id.anchor_v4_bottom_tips_view);
        this.f165852c = (LynxCardView) r100.findViewById(R.id.anchor_v4_bottom_lynx_tip);
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        int r101 = c2.f45564h;
        c2 r102 = c2.a.a(this.f165851b.getContext(), r100, false);
        BottomTipMeta r103 = this.f165850a;
        if (r103 == null) goto L16;
        String r104 = r103.getCountDownTemplate();
        if (r104 != null) goto L7;
        return;
    L7:
        if (StringsKt.contains$default(r104, "%s", false, 2, null) == true) goto L10;
        r104 = null;
    L10:
        if (r104 == null) goto L18;
        String r105 = String.format(r104, Arrays.copyOf(new Object[]{r102.f45571g}, 1));
        if (r105 == null) goto L19;
        this.f165851b.b(r105);
        return;
    L19:
        return;
    L18:
        return;
    }
}
