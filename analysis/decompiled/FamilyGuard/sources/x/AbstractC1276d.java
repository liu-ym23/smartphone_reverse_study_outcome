package x;

import android.view.View;
import t.AbstractC1106f;
import t.C1103c;

/* renamed from: x.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1276d extends AbstractC1106f {

    /* renamed from: x.d$a */
    public static class a extends AbstractC1276d {
        @Override // x.AbstractC1276d
        public boolean b(View view, float f5, long j5, C1103c c1103c) {
            return this.f22313h;
        }

        public boolean c(View view, C1103c c1103c, float f5, long j5, double d6, double d7) {
            view.setRotation(a(f5, j5, view, c1103c) + ((float) Math.toDegrees(Math.atan2(d7, d6))));
            return this.f22313h;
        }
    }

    public float a(float f5, long j5, View view, C1103c c1103c) {
        this.f22306a.c(f5, this.f22312g);
        float[] fArr = this.f22312g;
        float f6 = fArr[1];
        if (f6 == 0.0f) {
            this.f22313h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f22315j)) {
            throw null;
        }
        this.f22315j = (float) ((this.f22315j + (((j5 - this.f22314i) * 1.0E-9d) * f6)) % 1.0d);
        throw null;
    }

    public abstract boolean b(View view, float f5, long j5, C1103c c1103c);
}
