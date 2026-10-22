package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class MoreObjects {

    /* JADX INFO: renamed from: com.google.common.base.MoreObjects$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        public static final class ValueHolder {

            @NullableDecl
            String name;

            @NullableDecl
            ValueHolder next;

            @NullableDecl
            Object value;

            private ValueHolder() {
            }

            public /* synthetic */ ValueHolder(AnonymousClass1 r10) {
                this();
            }
        }

        public /* synthetic */ ToStringHelper(String r10, AnonymousClass1 r11) {
            this(r10);
        }

        private ValueHolder addHolder() {
            ValueHolder r10 = new ValueHolder(null);
            this.holderTail.next = r10;
            this.holderTail = r10;
            return r10;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String r10, @NullableDecl Object r11) {
            return addHolder(r10, r11);
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(@NullableDecl Object r10) {
            return addHolder(r10);
        }

        @CanIgnoreReturnValue
        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public String toString() {
            boolean r10 = this.omitNullValues;
            StringBuilder r11 = new StringBuilder(32);
            r11.append(this.className);
            r11.append('{');
            ValueHolder r12 = this.holderHead.next;
            String r13 = "";
        L3:
            if (r12 == null) goto L17;
            Object r14 = r12.value;
            if (r10 == false) goto L7;
            if (r14 != null) goto L7;
        L16:
            r12 = r12.next;
        L7:
            r11.append(r13);
            String r15 = r12.name;
            if (r15 == null) goto L10;
            r11.append(r15);
            r11.append('=');
        L10:
            if (r14 != null) goto L12;
        L14:
            r11.append(r14);
        L15:
            r13 = ", ";
            goto L16
        L12:
            if (r14.getClass().isArray() == false) goto L14;
            String r16 = Arrays.deepToString(new Object[]{r14});
            r11.append(r16, 1, r16.length() - 1);
            goto L15
        L17:
            r11.append('}');
            return r11.toString();
        }

        private ToStringHelper(String r10) {
            ValueHolder r11 = new ValueHolder(null);
            this.holderHead = r11;
            this.holderTail = r11;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(r10);
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String r10, boolean r11) {
            return addHolder(r10, String.valueOf(r11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(boolean r10) {
            return addHolder(String.valueOf(r10));
        }

        private ToStringHelper addHolder(@NullableDecl Object r10) {
            addHolder().value = r10;
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String r10, char r11) {
            return addHolder(r10, String.valueOf(r11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(char r10) {
            return addHolder(String.valueOf(r10));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String r10, double r11) {
            return addHolder(r10, String.valueOf(r11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(double r10) {
            return addHolder(String.valueOf(r10));
        }

        private ToStringHelper addHolder(String r10, @NullableDecl Object r11) {
            ValueHolder r12 = addHolder();
            r12.value = r11;
            r12.name = (String) Preconditions.checkNotNull(r10);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String r10, float r11) {
            return addHolder(r10, String.valueOf(r11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(float r10) {
            return addHolder(String.valueOf(r10));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String r10, int r11) {
            return addHolder(r10, String.valueOf(r11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(int r10) {
            return addHolder(String.valueOf(r10));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String r10, long r11) {
            return addHolder(r10, String.valueOf(r11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(long r10) {
            return addHolder(String.valueOf(r10));
        }
    }

    private MoreObjects() {
    }

    public static <T> T firstNonNull(@NullableDecl T r10, @NullableDecl T r11) {
        if (r10 == null) goto L4;
        return r10;
    L4:
        if (r11 == null) goto L7;
        return r11;
    L7:
        throw new NullPointerException("Both parameters are null");
    }

    public static ToStringHelper toStringHelper(Object r10) {
        return new ToStringHelper(r10.getClass().getSimpleName(), null);
    }

    public static ToStringHelper toStringHelper(Class<?> r10) {
        return new ToStringHelper(r10.getSimpleName(), null);
    }

    public static ToStringHelper toStringHelper(String r10) {
        return new ToStringHelper(r10, null);
    }
}
