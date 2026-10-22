package n3;

import android.view.WindowInsets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k1 {
    public static int a(int i) {
        int iStatusBars;
        int i3 = 0;
        for (int i10 = 1; i10 <= 512; i10 <<= 1) {
            if ((i & i10) != 0) {
                if (i10 == 1) {
                    iStatusBars = WindowInsets.Type.statusBars();
                } else if (i10 == 2) {
                    iStatusBars = WindowInsets.Type.navigationBars();
                } else if (i10 == 4) {
                    iStatusBars = WindowInsets.Type.captionBar();
                } else if (i10 == 8) {
                    iStatusBars = WindowInsets.Type.ime();
                } else if (i10 == 16) {
                    iStatusBars = WindowInsets.Type.systemGestures();
                } else if (i10 == 32) {
                    iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                } else if (i10 == 64) {
                    iStatusBars = WindowInsets.Type.tappableElement();
                } else if (i10 == 128) {
                    iStatusBars = WindowInsets.Type.displayCutout();
                }
                i3 |= iStatusBars;
            }
        }
        return i3;
    }
}
