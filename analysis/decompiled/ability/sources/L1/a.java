package L1;

import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public K1.a f929a;
    public boolean b;
    public long c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final boolean a() {
        K1.a aVar = this.f929a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = this.c;
        if (j5 == 0 || jElapsedRealtime - j5 >= 5000) {
            this.c = jElapsedRealtime;
            M1.a aVar2 = (M1.a) aVar.f903a;
            aVar2.d();
            float f = aVar2.g;
            M1.a aVar3 = (M1.a) aVar.f903a;
            aVar3.d();
            int i = aVar3.f;
            M1.a aVar4 = (M1.a) aVar.f903a;
            aVar4.getClass();
            PowerManager powerManager = aVar4.c;
            ?? IsPowerSaveMode = powerManager != null ? powerManager.isPowerSaveMode() : -1;
            ((J1.a) aVar.e).getClass();
            boolean z10 = f <= ((float) 37);
            ((J1.a) aVar.e).getClass();
            if (i < 30) {
                z10 = false;
            }
            boolean z11 = IsPowerSaveMode != 1 ? z10 : false;
            String str = "updateCpuSampleEnvironment:" + z11 + ", temp:" + f + ", level:" + i + ", powerSave:" + IsPowerSaveMode;
            boolean z12 = P1.a.f1060a;
            Log.i("watson_assist", str);
            this.b = z11;
        }
        return this.b;
    }
}
