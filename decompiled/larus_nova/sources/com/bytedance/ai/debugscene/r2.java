package com.bytedance.ai.debugscene;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f36488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap<Object, a> f36489b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final IdentityHashMap<q2, a> f36490c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<Integer, a> f36491d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap<String, a> f36492e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q2 f36493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f36494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f36495c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f36496d;

        public a(q2 r100, Object r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            Intrinsics.checkNotNullParameter(r101, "engineObject");
            this.f36493a = r100;
            this.f36494b = r101;
            this.f36495c = r102;
            this.f36496d = null;
        }
    }

    static {
        f36488a = new Object();
        f36489b = new IdentityHashMap();
        f36490c = new IdentityHashMap();
        f36491d = new HashMap();
        f36492e = new HashMap();
    }

    public static void a(a r100, List r101) {
        f36490c.remove(r100.f36493a);
        f36489b.remove(r100.f36494b);
        String r102 = r100.f36495c;
        if (r102 == null) goto L7;
        HashMap<String, a> r103 = f36492e;
        if (r103.get(r102) != r100) goto L7;
        r103.remove(r102);
    L7:
        Integer r104 = r100.f36496d;
        if (r104 == null) goto L12;
        int r105 = r104.intValue();
        f36491d.remove(Integer.valueOf(r105));
        if (r101 == null) goto L12;
        r101.add(Integer.valueOf(r105));
    L12:
        r100.f36496d = null;
    }
}
