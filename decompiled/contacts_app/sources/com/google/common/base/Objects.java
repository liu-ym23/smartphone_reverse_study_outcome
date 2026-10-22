package com.google.common.base;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Objects {

    /* JADX INFO: renamed from: com.google.common.base.Objects$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Deprecated
    public static final class ToStringHelper {
        private final String className;
        private ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private static final class ValueHolder {
            String name;
            ValueHolder next;
            Object value;

            private ValueHolder() {
            }

            /* synthetic */ ValueHolder(AnonymousClass1 r1) {
                this();
            }
        }

        /* synthetic */ ToStringHelper(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        private ToStringHelper(String r3) {
            ValueHolder r0 = new ValueHolder(null);
            this.holderHead = r0;
            this.holderTail = r0;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(r3);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public ToStringHelper add(String r1, @Nullable Object r2) {
            return addHolder(r1, r2);
        }

        public ToStringHelper add(String r1, boolean r2) {
            return addHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, char r2) {
            return addHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, double r2) {
            return addHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, float r2) {
            return addHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, int r2) {
            return addHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper add(String r1, long r2) {
            return addHolder(r1, String.valueOf(r2));
        }

        public ToStringHelper addValue(@Nullable Object r1) {
            return addHolder(r1);
        }

        public ToStringHelper addValue(boolean r1) {
            return addHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(char r1) {
            return addHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(double r1) {
            return addHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(float r1) {
            return addHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(int r1) {
            return addHolder(String.valueOf(r1));
        }

        public ToStringHelper addValue(long r1) {
            return addHolder(String.valueOf(r1));
        }

        public String toString() {
            boolean r0 = this.omitNullValues;
            StringBuilder r1 = new StringBuilder(32).append(this.className).append('{');
            ValueHolder r4 = this.holderHead.next;
            String r2 = "";
        L3:
            if (r4 == null) goto L13;
            if (r0 == true) goto L6;
        L7:
            r1.append(r2);
            if (r4.name == null) goto L10;
            r1.append(r4.name).append('=');
        L10:
            r1.append(r4.value);
            r2 = ", ";
        L11:
            r4 = r4.next;
            goto L3
        L6:
            if (r4.value == null) goto L11;
        L13:
            return r1.append('}').toString();
        }

        private ValueHolder addHolder() {
            ValueHolder r0 = new ValueHolder(null);
            this.holderTail.next = r0;
            this.holderTail = r0;
            return r0;
        }

        private ToStringHelper addHolder(@Nullable Object r2) {
            addHolder().value = r2;
            return this;
        }

        private ToStringHelper addHolder(String r2, @Nullable Object r3) {
            ValueHolder r0 = addHolder();
            r0.value = r3;
            r0.name = (String) Preconditions.checkNotNull(r2);
            return this;
        }
    }

    private Objects() {
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object r0, @Nullable Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static int hashCode(@Nullable Object... r0) {
        return Arrays.hashCode(r0);
    }

    @Deprecated
    public static ToStringHelper toStringHelper(Object r2) {
        return new ToStringHelper(MoreObjects.simpleName(r2.getClass()), null);
    }

    @Deprecated
    public static ToStringHelper toStringHelper(Class<?> r2) {
        return new ToStringHelper(MoreObjects.simpleName(r2), null);
    }

    @Deprecated
    public static ToStringHelper toStringHelper(String r2) {
        return new ToStringHelper(r2, null);
    }

    @Deprecated
    public static <T> T firstNonNull(@Nullable T r0, @Nullable T r1) {
        return (T) MoreObjects.firstNonNull(r0, r1);
    }
}
