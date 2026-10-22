package brc;

import android.graphics.Canvas;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f20206a;

    public e(crc.a r100) {
        b(r100);
    }

    @Override // brc.f
    public final void a(Canvas r100) {
        a r101 = this.f20206a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mIDrawer");
    L5:
        r101.a(r100);
    }

    public final void b(crc.a r100) {
        int r101 = d.f20205a;
        int r102 = r100.f465140b;
        if (r102 != 2) goto L5;
        a r103 = new c(r100);
    L9:
        this.f20206a = r103;
        return;
    L5:
        if (r102 == 4) goto L7;
        r103 = new b(r100);
        goto L9
    L7:
        r103 = new h(r100);
        goto L9
    }
}
