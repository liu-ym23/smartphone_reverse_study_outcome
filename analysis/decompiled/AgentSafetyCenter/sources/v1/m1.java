package v1;

import android.view.MotionEvent;
import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public static final m1 f14503a = new m1();

    public final boolean a(MotionEvent motionEvent, int i) {
        return (Float.floatToRawIntBits(motionEvent.getRawX(i)) & Reader.READ_DONE) < 2139095040 && (Float.floatToRawIntBits(motionEvent.getRawY(i)) & Reader.READ_DONE) < 2139095040;
    }
}
