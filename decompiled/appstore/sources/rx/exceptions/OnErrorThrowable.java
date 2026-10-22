package rx.exceptions;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import og.f;

/* JADX INFO: loaded from: classes4.dex */
public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        private final Object value;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Set f24144a = null;

            static {
                f24144a = a();
            }

            public static Set a() {
                HashSet r10 = new HashSet();
                r10.add(Boolean.class);
                r10.add(Character.class);
                r10.add(Byte.class);
                r10.add(Short.class);
                r10.add(Integer.class);
                r10.add(Long.class);
                r10.add(Float.class);
                r10.add(Double.class);
                return r10;
            }
        }

        public OnNextValue(Object r10) {
            super("OnError while emitting onNext value: " + renderValue(r10));
            if ((r10 instanceof Serializable) == false) goto L11;
        L9:
            this.value = r10;
            return;
        L11:
            r10 = String.valueOf(r10);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            r10 = th.getMessage();
            goto L9
        }

        public static String renderValue(Object r10) {
            if (r10 != null) goto L6;
            return "null";
        L6:
            if (a.f24144a.contains(r10.getClass()) == false) goto L10;
            return r10.toString();
        L10:
            if ((r10 instanceof String) == false) goto L14;
            return (String) r10;
        L14:
            if ((r10 instanceof Enum) == true) goto L16;
            String r11 = f.c().b().b(r10);
            if (r11 == null) goto L21;
            return r11;
        L21:
            return r10.getClass().getName() + ".class";
        L16:
            return ((Enum) r10).name();
        }

        public Object getValue() {
            return this.value;
        }
    }

    private OnErrorThrowable(Throwable r10) {
        super(r10);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable r10, Object r11) {
        if (r10 != null) goto L4;
        r10 = new NullPointerException();
    L4:
        Throwable r12 = a.b(r10);
        if ((r12 instanceof OnNextValue) == true) goto L7;
    L9:
        a.a(r10, new OnNextValue(r11));
        return r10;
    L7:
        if (((OnNextValue) r12).getValue() != r11) goto L9;
        return r10;
    }

    public static OnErrorThrowable from(Throwable r10) {
        if (r10 != null) goto L4;
        r10 = new NullPointerException();
    L4:
        Throwable r11 = a.b(r10);
        if ((r11 instanceof OnNextValue) == false) goto L9;
        return new OnErrorThrowable(r10, ((OnNextValue) r11).getValue());
    L9:
        return new OnErrorThrowable(r10);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    private OnErrorThrowable(Throwable r10, Object r11) {
        super(r10);
        this.hasValue = true;
        if ((r11 instanceof Serializable) == false) goto L11;
    L9:
        this.value = r11;
        return;
    L11:
        r11 = String.valueOf(r11);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r11 = th.getMessage();
        goto L9
    }
}
