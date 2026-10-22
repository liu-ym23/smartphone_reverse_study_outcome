package x;

import android.view.View;
import t.AbstractC1105e;

/* renamed from: x.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1275c extends AbstractC1105e {

    /* renamed from: x.c$a */
    public static class a extends AbstractC1275c {
        @Override // x.AbstractC1275c
        public void b(View view, float f5) {
        }

        public void c(View view, float f5, double d6, double d7) {
            view.setRotation(a(f5) + ((float) Math.toDegrees(Math.atan2(d7, d6))));
        }
    }

    public abstract void b(View view, float f5);
}
