package com.bytedance.android.shopping.feed.view;

import android.widget.FrameLayout;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.shopping.feed.utils.InflowRedPacketTimer;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends FrameLayout implements l1.a {

    public static final class a {
    }

    public interface b {
        void a(c2 r100);
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    static {
        com.bytedance.android.shopping.extensions.b.b(68);
        com.bytedance.android.shopping.extensions.b.b(9);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int r100 = p015if.a.f489538a;
        InflowRedPacketTimer r101 = (InflowRedPacketTimer) InflowRedPacketTimer.f175429b.getValue();
        l1 r102 = r101.f175430a;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        r101.f175430a = null;
        s0.e(this);
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
        throw null;
    }

    private final void setCouponCommonStyle(rd3.c r100) {
        throw null;
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        int r101 = c2.f45564h;
        c2.a.a(getContext(), r100, false);
    }
}
