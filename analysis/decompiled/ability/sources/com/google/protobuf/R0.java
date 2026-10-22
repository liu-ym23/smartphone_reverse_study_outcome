package com.google.protobuf;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public class R0 {
    public static volatile R0 b;
    public static final R0 c = new R0();

    /* renamed from: a, reason: collision with root package name */
    public final Map f2868a;

    public R0(R0 r02) {
        if (r02 == c) {
            this.f2868a = Collections.EMPTY_MAP;
        } else {
            this.f2868a = Collections.unmodifiableMap(r02.f2868a);
        }
    }

    public static R0 a() {
        R0 r02;
        R0 r03 = b;
        if (r03 != null) {
            return r03;
        }
        synchronized (R0.class) {
            try {
                r02 = b;
                if (r02 == null) {
                    Class cls = P0.f2864a;
                    R0 r04 = null;
                    if (cls != null) {
                        try {
                            r04 = (R0) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    r02 = r04 != null ? r04 : c;
                    b = r02;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return r02;
    }

    public R0() {
        this.f2868a = Collections.EMPTY_MAP;
    }
}
