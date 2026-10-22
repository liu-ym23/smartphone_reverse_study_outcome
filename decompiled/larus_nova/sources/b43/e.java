package b43;

import android.app.Activity;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l33.c f17509a;

    public e(l33.c r100) {
        Intrinsics.checkNotNullParameter(r100, "platformContainerDelegate");
        this.f17509a = r100;
    }

    public final void a(String r100) {
        Activity r101 = this.f17509a.getContainerContext();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r102 = r100;
        int r103 = h43.a.f483774a;
        h43.a.a(this.f17509a.getContainerContext());
        ECLiveHybridUtil.k(r101, r102, false, true, false, null, 204);
    }
}
