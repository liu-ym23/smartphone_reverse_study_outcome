package androidx.emoji2.text;

import a4.j;
import a4.k;
import a4.n;
import a4.v;
import android.content.Context;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import b5.a;
import b5.b;
import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements b {
    @Override // b5.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // b5.b
    public final Object b(Context context) {
        Object objB;
        n nVar = new n();
        nVar.f190a = context.getApplicationContext();
        VarHandle.storeStoreFence();
        v vVar = new v(nVar);
        vVar.f167a = 1;
        if (j.f174k == null) {
            synchronized (j.f173j) {
                try {
                    if (j.f174k == null) {
                        j.f174k = new j(vVar);
                    }
                } finally {
                }
            }
        }
        a aVarC = a.c(context);
        aVarC.getClass();
        synchronized (a.f1902e) {
            try {
                objB = aVarC.f1903a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        q lifecycle = ((x) objB).getLifecycle();
        k kVar = new k();
        kVar.f183c = lifecycle;
        VarHandle.storeStoreFence();
        lifecycle.a(kVar);
        return Boolean.TRUE;
    }
}
