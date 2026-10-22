package bc2;

import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.log.b0;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements vlc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18573a;

    @Override // vlc.c
    public final boolean a() {
        return b.f18574a.getValue().booleanValue();
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actualLogTag");
        this.f18573a = r100;
    }

    @Override // vlc.c
    public final void log(String r100, String r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        LocalTestManager.a(new Class[]{wy.a.class});
        b0 r102 = b0.o();
        String r103 = "LiveMessageTracer_" + this.f18573a;
        r102.getClass();
        g.i(r103, r101);
    }
}
