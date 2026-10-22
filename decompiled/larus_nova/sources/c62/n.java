package c62;

import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.l f22586b;

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (o.b(r100) != this.f22585a) goto L6;
        this.f22586b.onMessage(r100);
        return;
    }

    public n(long r100, com.bytedance.android.livesdk.interactivity.chatchannel.manager.c r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f22585a = r100;
        this.f22586b = r101;
    }
}
