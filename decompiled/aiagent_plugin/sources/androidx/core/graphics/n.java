package androidx.core.graphics;

import android.graphics.Typeface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: TypefaceCompatApi28Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends m {
    public n() {
    }

    @Override // androidx.core.graphics.m
    public Typeface a(Object r5) {
        Object r0 = Array.newInstance(this.f1231a, 1);     // Catch: Throwable -> L4
        Array.set(r0, 0, r5);     // Catch: Throwable -> L4
        return (Typeface) ZeusTransformUtils.preCheckCast(this.g.invoke(null, new Object[]{r0, "sans-serif", -1, -1}), Typeface.class, "com.obric.aiagent.plugin");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.m
    public Method f(Class<?> r4) {
        Method r5 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(r4, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE});
        r5.setAccessible(true);
        return r5;
    }
}
