package ca0;

import com.bytedance.android.livesdk.gift.model.w1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class x extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f22921a;

    @Override // ca0.w
    public final void a() {
        w r100 = this.f22921a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public x(w r100) {
        this.f22921a = r100;
    }

    @Override // ca0.w
    public void b(List<? extends w1> r100) {
        Intrinsics.checkNotNullParameter(r100, "giftPages");
        Intrinsics.checkNotNullParameter(r100, "giftPages");
        w r101 = this.f22921a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
