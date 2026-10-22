package b8c;

import android.os.SystemClock;
import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18242a;

    /* JADX INFO: renamed from: b8c.a$a, reason: collision with other inner class name */
    public static final class C0280a {
    }

    static {
    }

    public a() {
    }

    public abstract void a(View r100);

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - this.f18242a) <= 1000) goto L6;
        a(r100);
        this.f18242a = r101;
        return;
    }
}
