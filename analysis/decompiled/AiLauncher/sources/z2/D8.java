package z2;

import D2.InterfaceC0793e;
import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.common.internal.C1671l;
import com.google.android.gms.common.internal.C1673n;
import com.google.android.gms.common.internal.InterfaceC1672m;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class D8 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1672m f44635a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f44636b = new AtomicLong(-1);

    public D8(Context context, String str) {
        this.f44635a = C1671l.b(context, C1673n.a().b("mlkit:vision").a());
    }

    public static D8 a(Context context) {
        return new D8(context, "mlkit:vision");
    }

    public final /* synthetic */ void b(long j10, Exception exc) {
        this.f44636b.set(j10);
    }

    public final synchronized void c(int i10, int i11, long j10, long j11) {
        AtomicLong atomicLong = this.f44636b;
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (atomicLong.get() != -1 && jElapsedRealtime - this.f44636b.get() <= TimeUnit.MINUTES.toMillis(30L)) {
            return;
        }
        this.f44635a.a(new TelemetryData(0, Arrays.asList(new MethodInvocation(i10, i11, 0, j10, j11, null, null, 0, -1)))).d(new InterfaceC0793e() { // from class: z2.C8
            @Override // D2.InterfaceC0793e
            public final void onFailure(Exception exc) {
                this.f44624a.b(jElapsedRealtime, exc);
            }
        });
    }
}
