package a03;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements yr0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.pkaudience.api.a f1247a;

    @Override // yr0.b
    public final int b() {
        com.bytedance.android.live.pkaudience.api.a r100 = this.f1247a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.b();
    }

    public b(com.bytedance.android.live.pkaudience.api.a r100) {
        this.f1247a = r100;
    }

    @Override // yr0.b
    public final ILinkPlayerInfoBridge getGuestInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        com.bytedance.android.live.pkaudience.api.a r102 = this.f1247a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getGuestInfo(r100, r101);
    }
}
