package com.bytedance.android.shopping.collect.custom_view;

import com.bytedance.android.shopping.api.mall.feed.ECMallFeedState;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements com.bytedance.android.shopping.api.mall.feed.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f172212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AndroidYaTaInstance f172213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f172214c;

    @Override // com.bytedance.android.shopping.api.mall.feed.f
    public final void a(ECMallFeedState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        switch(c.f172211a[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L17;
        };
    L5:
        this.f172212a = false;
        return;
    L12:
        this.f172212a = false;
        return;
    L17:
        return;
    L7:
        if (this.f172212a == true) goto L15;
        int r101 = com.bytedance.android.shopping.collect.util.e.f172295e;
        if (com.bytedance.android.shopping.collect.util.e.a.a(this.f172213b) == true) goto L11;
        this.f172214c.invoke();
    L11:
        this.f172212a = true;
        return;
    }

    public d(AndroidYaTaInstance r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "showGULView");
        this.f172213b = r100;
        this.f172214c = r101;
    }
}
