package com.fasterxml.jackson.databind.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ContextAttributes.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: compiled from: ContextAttributes.java */
    public static class a extends j implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected static final a f12224a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected static final Object f12225b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Map<?, ?> f12226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected transient Map<Object, Object> f12227d;

        static {
            f12224a = new a(Collections.emptyMap());
            f12225b = new Object();
        }

        public a(Map<?, ?> r3) {
            this.f12226c = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            this.f12227d = null;
        }

        public a(Map<?, ?> r3, Map<Object, Object> r4) {
            Map<?, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            Map<Object, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            this.f12226c = r5;
            this.f12227d = r6;
        }

        public static j b() {
            return f12224a;
        }

        @Override // com.fasterxml.jackson.databind.a.j
        public Object a(Object r2) {
            Map<Object, Object> r0 = this.f12227d;
            if (r0 == null) goto L12;
            Object r1 = r0.get(r2);
            if (r1 == null) goto L12;
            if (r1 != f12225b) goto L10;
            return null;
        L10:
            return r1;
        L12:
            return this.f12226c.get(r2);
        }

        @Override // com.fasterxml.jackson.databind.a.j
        public j a(Object r2, Object r3) {
            if (r3 == null) goto L4;
        L13:
            Map<Object, Object> r0 = this.f12227d;
            if (r0 == null) goto L16;
            r0.put(r2, r3);
            return this;
        L16:
            return b(r2, r3);
        L4:
            if (this.f12226c.containsKey(r2) == false) goto L6;
            r3 = f12225b;
            goto L13
        L6:
            Map<Object, Object> r4 = this.f12227d;
            if (r4 != null) goto L9;
        L12:
            return this;
        L9:
            if (r4.containsKey(r2) == false) goto L12;
            this.f12227d.remove(r2);
            goto L12
        }

        public j b(Object r2, Object r3) {
            HashMap r0 = new HashMap();
            if (r3 != null) goto L5;
            r3 = f12225b;
        L5:
            r0.put(r2, r3);
            return new a(this.f12226c, r0);
        }
    }

    public abstract j a(Object r1, Object r2);

    public abstract Object a(Object r1);

    public j() {
    }

    public static j a() {
        return a.b();
    }
}
