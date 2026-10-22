package j1;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: a, reason: collision with root package name */
    public static final r1 f5310a = new r1();

    public final boolean a(MotionEvent motionEvent, int i2) {
        return (Float.floatToRawIntBits(motionEvent.getRawX(i2)) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(motionEvent.getRawY(i2)) & Integer.MAX_VALUE) < 2139095040;
    }
}
