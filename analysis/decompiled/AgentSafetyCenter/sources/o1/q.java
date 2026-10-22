package o1;

import android.view.MotionEvent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9067a = new a(1000);

    /* renamed from: b, reason: collision with root package name */
    public static final a f9068b;

    /* renamed from: c, reason: collision with root package name */
    public static final StackTraceElement[] f9069c;

    static {
        new a(1007);
        new a(1008);
        f9068b = new a(1002);
        f9069c = new StackTraceElement[0];
    }

    public static final boolean a(s sVar) {
        return !sVar.f9078h && sVar.f9074d;
    }

    public static final boolean b(s sVar) {
        return sVar.f9078h && !sVar.f9074d;
    }

    public static final boolean c(s sVar, long j10, long j11) {
        int i = sVar.i == 1 ? 1 : 0;
        long j12 = sVar.f9073c;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j12 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j12 & 4294967295L));
        float f5 = i;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j11 >> 32)) * f5;
        float f10 = ((int) (j10 >> 32)) + fIntBitsToFloat3;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j11 & 4294967295L)) * f5;
        return (fIntBitsToFloat > f10) | (fIntBitsToFloat < (-fIntBitsToFloat3)) | (fIntBitsToFloat2 < (-fIntBitsToFloat4)) | (fIntBitsToFloat2 > ((int) (j10 & 4294967295L)) + fIntBitsToFloat4);
    }

    public static final long d(s sVar, boolean z10) {
        long jG = c1.b.g(sVar.f9073c, sVar.f9077g);
        if (z10 || !sVar.b()) {
            return jG;
        }
        return 0L;
    }

    public static final void e(j jVar, long j10, xb.l lVar, boolean z10) {
        ma.a aVar = jVar.f9057b;
        MotionEvent motionEvent = aVar != null ? (MotionEvent) ((n6.a) aVar.f8534c).f8777f : null;
        if (motionEvent == null) {
            g5.f.s("The PointerEvent receiver cannot have a null MotionEvent.");
            return;
        }
        int action = motionEvent.getAction();
        if (z10) {
            motionEvent.setAction(3);
        }
        int i = (int) (j10 >> 32);
        int i3 = (int) (j10 & 4294967295L);
        motionEvent.offsetLocation(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i3));
        lVar.invoke(motionEvent);
        motionEvent.offsetLocation(Float.intBitsToFloat(i), Float.intBitsToFloat(i3));
        motionEvent.setAction(action);
    }
}
