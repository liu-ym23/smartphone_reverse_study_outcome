package p0;

import java.lang.reflect.Type;
import o0.C0888a;

/* renamed from: p0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0918e implements t {
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) f(c0888a, type, obj, null, 0);
    }

    public abstract <T> T f(C0888a c0888a, Type type, Object obj, String str, int i5);
}
