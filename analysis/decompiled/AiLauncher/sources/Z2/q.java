package Z2;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* loaded from: classes2.dex */
public class q extends p {

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (q.this.f7258e.isEmpty()) {
                return;
            }
            outline.setPath(q.this.f7258e);
        }
    }

    public q(View view) {
        k(view);
    }

    private void k(View view) {
        view.setOutlineProvider(new a());
    }

    @Override // Z2.p
    public void b(View view) {
        view.setClipToOutline(!i());
        if (i()) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // Z2.p
    public boolean i() {
        return this.f7254a;
    }
}
