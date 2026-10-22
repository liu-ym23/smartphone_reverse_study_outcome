package d3;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.m0;
import androidx.lifecycle.o0;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import androidx.lifecycle.z;
import java.util.WeakHashMap;
import n3.j;
import n3.k0;
import p.p0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c extends Activity implements x, j {
    private final p0 extraDataMap = new p0(0);
    private final z lifecycleRegistry = new z(this, true);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        getWindow().getDecorView().getClass();
        WeakHashMap weakHashMap = k0.f8724a;
        return superDispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        getWindow().getDecorView().getClass();
        WeakHashMap weakHashMap = k0.f8724a;
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @jb.a
    public <T extends b> T getExtraData(Class<T> cls) {
        cls.getClass();
        if (this.extraDataMap.get(cls) == null) {
            return null;
        }
        od.f.j();
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = o0.f1417c;
        m0.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        z zVar = this.lifecycleRegistry;
        p pVar = p.f1418c;
        zVar.getClass();
        p pVar2 = p.f1420g;
        zVar.e("setCurrentState");
        zVar.g(pVar2);
        super.onSaveInstanceState(bundle);
    }

    @jb.a
    public void putExtraData(b bVar) {
        throw null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean shouldDumpInternalState(java.lang.String[] r3) {
        /*
            r2 = this;
            r2 = 0
            r0 = 1
            if (r3 == 0) goto L40
            int r1 = r3.length
            if (r1 != 0) goto L8
            goto L40
        L8:
            r3 = r3[r2]
            int r1 = r3.hashCode()
            switch(r1) {
                case -645125871: goto L38;
                case 100470631: goto L2f;
                case 472614934: goto L26;
                case 1159329357: goto L1d;
                case 1455016274: goto L12;
                default: goto L11;
            }
        L11:
            goto L40
        L12:
            java.lang.String r1 = "--autofill"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L1b:
            r2 = r0
            goto L40
        L1d:
            java.lang.String r1 = "--contentcapture"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L26:
            java.lang.String r1 = "--list-dumpables"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L2f:
            java.lang.String r1 = "--dump-dumpable"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
            goto L40
        L38:
            java.lang.String r1 = "--translation"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L1b
        L40:
            r2 = r2 ^ r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d3.c.shouldDumpInternalState(java.lang.String[]):boolean");
    }

    @Override // n3.j
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getClass();
        return super.dispatchKeyEvent(keyEvent);
    }
}
