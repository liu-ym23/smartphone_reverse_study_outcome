package androidx.emoji2.text;

import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements y0.b {
    @Override // y0.b
    public final Object create(Context context) {
        Object objB;
        m mVar = new m();
        mVar.f621a = context.getApplicationContext();
        v vVar = new v(mVar);
        vVar.f642b = 1;
        if (j.f608k == null) {
            synchronized (j.f607j) {
                try {
                    if (j.f608k == null) {
                        j.f608k = new j(vVar);
                    }
                } finally {
                }
            }
        }
        y0.a aVarC = y0.a.c(context);
        aVarC.getClass();
        synchronized (y0.a.f6307e) {
            try {
                objB = aVarC.f6308a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        final androidx.lifecycle.t tVarD = ((androidx.lifecycle.r) objB).d();
        tVarD.a(new androidx.lifecycle.d(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.d
            public final void c() {
                b.a(Looper.getMainLooper()).postDelayed(new n(), 500L);
                tVarD.e(this);
            }
        });
        return Boolean.TRUE;
    }

    @Override // y0.b
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
