package x;

import android.view.View;
import t.AbstractC1104d;

/* renamed from: x.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1274b extends AbstractC1104d {

    /* renamed from: x.b$a */
    public static class a extends AbstractC1274b {
        @Override // x.AbstractC1274b
        public void b(View view, float f5) {
        }

        public void c(View view, float f5, double d6, double d7) {
            view.setRotation(a(f5) + ((float) Math.toDegrees(Math.atan2(d7, d6))));
        }
    }

    public abstract void b(View view, float f5);
}
