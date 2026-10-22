package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import o4.d0;
import p3.a;
import p3.b;
import x2.g;
import x2.h;
import x2.o;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements b {
    @Override // p3.b
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // p3.b
    public final Object b(Context context) {
        Object objB;
        o oVar = new o(new d0(context, 17));
        oVar.f11141b = 1;
        if (g.f11112k == null) {
            synchronized (g.f11111j) {
                try {
                    if (g.f11112k == null) {
                        g.f11112k = new g(oVar);
                    }
                } finally {
                }
            }
        }
        a aVarC = a.c(context);
        aVarC.getClass();
        synchronized (a.f8398e) {
            try {
                objB = aVarC.f8399a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        x xVarA = ((v) objB).a();
        xVarA.a(new h(this, xVarA));
        return Boolean.TRUE;
    }
}
