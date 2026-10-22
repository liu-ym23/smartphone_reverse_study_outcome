package androidx.emoji2.text;

import X.j;
import X.k;
import X.x;
import android.content.Context;
import androidx.lifecycle.AbstractC0328z;
import androidx.lifecycle.G;
import androidx.lifecycle.ProcessLifecycleInitializer;
import j.C0622a;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import n0.C0774a;
import n0.b;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements b {
    @Override // n0.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean create(Context context) {
        Object objB;
        x xVar = new x(new C0622a(context));
        xVar.f2051b = 1;
        if (j.f2054k == null) {
            synchronized (j.f2053j) {
                try {
                    if (j.f2054k == null) {
                        j.f2054k = new j(xVar);
                    }
                } finally {
                }
            }
        }
        C0774a c0774aC = C0774a.c(context);
        c0774aC.getClass();
        synchronized (C0774a.f13646e) {
            try {
                objB = c0774aC.f13647a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = c0774aC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        AbstractC0328z lifecycle = ((G) objB).getLifecycle();
        lifecycle.a(new k(this, lifecycle));
        return Boolean.TRUE;
    }

    @Override // n0.b
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
