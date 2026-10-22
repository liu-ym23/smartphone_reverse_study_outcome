package com.stepos.mcp.sdk.base;

import j6.b;
import java.lang.invoke.VarHandle;
import kb.t;
import yc.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AbilityResultKt {
    private static final m EmptyJsonObject;

    static {
        m mVar = new m();
        mVar.f16112c = t.f7405c;
        VarHandle.storeStoreFence();
        EmptyJsonObject = mVar;
    }

    public static final /* synthetic */ <T> T fromJson(String str, Class<T> cls) {
        str.getClass();
        cls.getClass();
        return (T) b.a(str, cls);
    }

    public static final m getEmptyJsonObject() {
        return EmptyJsonObject;
    }

    public static final <T> m toJsonObject(T t10) {
        int i = yc.b.f16101a;
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }
}
