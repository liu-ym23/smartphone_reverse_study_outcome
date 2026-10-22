package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6664a = null;

    public static /* synthetic */ class a {
    }

    public static class b {
        public b() {
        }

        public boolean a(Object r10, Object r11) {
            if (r10 == r11) goto L8;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.equals(r11) == false) goto L7;
        L8:
            return true;
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    static {
        f6664a = new b(null);
    }

    public static boolean a(Object r10, Object r11) {
        return f6664a.a(r10, r11);
    }
}
