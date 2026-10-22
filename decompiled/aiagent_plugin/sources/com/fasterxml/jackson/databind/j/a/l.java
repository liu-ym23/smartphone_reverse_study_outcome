package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.l.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ReadOnlyClassToSerializerMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a[] f12833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12835c;

    /* JADX INFO: compiled from: ReadOnlyClassToSerializerMap.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.p<Object> f12836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f12837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Class<?> f12838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final com.fasterxml.jackson.databind.k f12839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final boolean f12840e;

        public a(a r1, aa r2, com.fasterxml.jackson.databind.p<Object> r3) {
            this.f12837b = r1;
            this.f12836a = r3;
            this.f12840e = r2.a();
            this.f12838c = r2.b();
            this.f12839d = r2.getType();
        }

        public boolean a(Class<?> r2) {
            if (this.f12838c == r2) goto L5;
        L7:
            return false;
        L5:
            if (this.f12840e == false) goto L7;
            return true;
        }

        public boolean b(Class<?> r2) {
            if (this.f12838c == r2) goto L5;
        L7:
            return false;
        L5:
            if (this.f12840e == true) goto L7;
            return true;
        }

        public boolean a(com.fasterxml.jackson.databind.k r2) {
            if (this.f12840e == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.equals(this.f12839d) == false) goto L7;
            return true;
        }

        public boolean b(com.fasterxml.jackson.databind.k r2) {
            if (this.f12840e == false) goto L5;
        L7:
            return false;
        L5:
            if (r2.equals(this.f12839d) == false) goto L7;
            return true;
        }
    }

    private static final int a(int r1) {
        if (r1 > 64) goto L5;
        int r2 = r1 + r1;
    L6:
        int r0 = 8;
    L7:
        if (r0 >= r2) goto L9;
        r0 = r0 + r0;
        goto L7
    L9:
        return r0;
    L5:
        r2 = r1 + (r1 >> 2);
        goto L6
    }

    public l(Map<aa, com.fasterxml.jackson.databind.p<Object>> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        int r0 = a(r10.size());
        this.f12834b = r0;
        this.f12835c = r0 - 1;
        a[] r1 = new a[r0];
        Iterator r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        aa r3 = (aa) ZeusTransformUtils.preCheckCast(r2.getKey(), aa.class, "com.obric.aiagent.plugin");
        int r4 = r3.hashCode() & this.f12835c;
        r1[r4] = new a(r1[r4], r3, (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(r2.getValue(), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin"));
        goto L4
    L6:
        this.f12833a = r1;
    }

    public static l a(HashMap<aa, com.fasterxml.jackson.databind.p<Object>> r1) {
        return new l(r1);
    }

    public com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.k r3) {
        a[] r0 = this.f12833a;
        int r1 = aa.b(r3);
        a r2 = r0[this.f12835c & r1];
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.a(r3) == true) goto L8;
    L9:
        r2 = r2.f12837b;
        if (r2 == null) goto L15;
        if (r2.a(r3) == false) goto L9;
        return r2.f12836a;
    L15:
        return null;
    L8:
        return r2.f12836a;
    }

    public com.fasterxml.jackson.databind.p<Object> a(Class<?> r3) {
        a[] r0 = this.f12833a;
        int r1 = aa.b(r3);
        a r2 = r0[this.f12835c & r1];
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.a(r3) == true) goto L8;
    L9:
        r2 = r2.f12837b;
        if (r2 == null) goto L15;
        if (r2.a(r3) == false) goto L9;
        return r2.f12836a;
    L15:
        return null;
    L8:
        return r2.f12836a;
    }

    public com.fasterxml.jackson.databind.p<Object> b(com.fasterxml.jackson.databind.k r3) {
        a[] r0 = this.f12833a;
        int r1 = aa.a(r3);
        a r2 = r0[this.f12835c & r1];
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.b(r3) == true) goto L8;
    L9:
        r2 = r2.f12837b;
        if (r2 == null) goto L15;
        if (r2.b(r3) == false) goto L9;
        return r2.f12836a;
    L15:
        return null;
    L8:
        return r2.f12836a;
    }

    public com.fasterxml.jackson.databind.p<Object> b(Class<?> r3) {
        a[] r0 = this.f12833a;
        int r1 = aa.a(r3);
        a r2 = r0[this.f12835c & r1];
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.b(r3) == true) goto L8;
    L9:
        r2 = r2.f12837b;
        if (r2 == null) goto L15;
        if (r2.b(r3) == false) goto L9;
        return r2.f12836a;
    L15:
        return null;
    L8:
        return r2.f12836a;
    }
}
