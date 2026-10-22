package ca;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ca.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0892a extends InheritableThreadLocal {
    @Override // java.lang.InheritableThreadLocal
    public final Object childValue(Object obj) {
        Map map = (Map) obj;
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }
}
