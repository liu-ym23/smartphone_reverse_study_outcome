package b62;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f17827d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f17828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17830c;

    public static final class a {
        public static e a(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            if (r100.f() == false) goto L6;
            return new e(s1.e(0.5f), ColorProtector.parseColor("#BF000000"));
        L6:
            return new e(s1.e(0.5f), ColorProtector.parseColor("#BF000000"));
        }
    }

    static {
    }

    public e(float r100, int r101) {
        this.f17828a = r100;
        this.f17829b = r101;
        this.f17830c = 0;
    }
}
