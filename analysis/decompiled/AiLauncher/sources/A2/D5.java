package A2;

import android.os.SystemClock;
import com.google.android.gms.internal.mlkit_vision_common.zziv;

/* loaded from: classes2.dex */
public final class D5 {
    public static void a(s5 s5Var, int i10, int i11, long j10, int i12, int i13, int i14, int i15) {
        s5Var.c(b(i10, i11, j10, i12, i13, i14, i15), zziv.INPUT_IMAGE_CONSTRUCTION);
    }

    public static C5 b(int i10, int i11, long j10, int i12, int i13, int i14, int i15) {
        return new C5(i10, i11, i14, i12, i13, SystemClock.elapsedRealtime() - j10, i15);
    }
}
