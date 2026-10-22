package t1;

import android.graphics.RectF;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final float f5445a;

    public a(float f3) {
        this.f5445a = f3;
    }

    @Override // t1.d
    public final float a(RectF rectF) {
        return this.f5445a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f5445a == ((a) obj).f5445a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f5445a)});
    }

    public final String toString() {
        return this.f5445a + "px";
    }
}
