package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtCompatible
final class SortedLists {

    /* JADX INFO: renamed from: com.google.common.collect.SortedLists$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum KeyAbsentBehavior extends Enum<KeyAbsentBehavior> {
        private static final /* synthetic */ KeyAbsentBehavior[] $VALUES = null;
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX = null;
        public static final KeyAbsentBehavior NEXT_HIGHER = null;
        public static final KeyAbsentBehavior NEXT_LOWER = null;

        static {
            final String r10 = "NEXT_LOWER";
            final int r11 = 0;
            KeyAbsentBehavior r12 = new AnonymousClass1(r10, r11);
            NEXT_LOWER = r12;
            final String r13 = "NEXT_HIGHER";
            final int r14 = 1;
            KeyAbsentBehavior r15 = new AnonymousClass2(r13, r14);
            NEXT_HIGHER = r15;
            final String r16 = "INVERTED_INSERTION_INDEX";
            final int r17 = 2;
            KeyAbsentBehavior r18 = new AnonymousClass3(r16, r17);
            INVERTED_INSERTION_INDEX = r18;
            $VALUES = new KeyAbsentBehavior[]{r12, r15, r18};
        }

        private KeyAbsentBehavior(String r10, int r11) {
            super(r10, r11);
        }

        public static KeyAbsentBehavior valueOf(String r10) {
            return (KeyAbsentBehavior) Enum.valueOf(KeyAbsentBehavior.class, r10);
        }

        public static KeyAbsentBehavior[] values() {
            return (KeyAbsentBehavior[]) $VALUES.clone();
        }

        public abstract int resultIndex(int r10);

        public /* synthetic */ KeyAbsentBehavior(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static abstract enum KeyPresentBehavior extends Enum<KeyPresentBehavior> {
        private static final /* synthetic */ KeyPresentBehavior[] $VALUES = null;
        public static final KeyPresentBehavior ANY_PRESENT = null;
        public static final KeyPresentBehavior FIRST_AFTER = null;
        public static final KeyPresentBehavior FIRST_PRESENT = null;
        public static final KeyPresentBehavior LAST_BEFORE = null;
        public static final KeyPresentBehavior LAST_PRESENT = null;

        static {
            final String r10 = "ANY_PRESENT";
            final int r11 = 0;
            KeyPresentBehavior r12 = new AnonymousClass1(r10, r11);
            ANY_PRESENT = r12;
            final String r13 = "LAST_PRESENT";
            final int r14 = 1;
            KeyPresentBehavior r15 = new AnonymousClass2(r13, r14);
            LAST_PRESENT = r15;
            final String r16 = "FIRST_PRESENT";
            final int r17 = 2;
            KeyPresentBehavior r18 = new AnonymousClass3(r16, r17);
            FIRST_PRESENT = r18;
            final String r19 = "FIRST_AFTER";
            final int r20 = 3;
            KeyPresentBehavior r21 = new AnonymousClass4(r19, r20);
            FIRST_AFTER = r21;
            final String r22 = "LAST_BEFORE";
            final int r110 = 4;
            KeyPresentBehavior r23 = new AnonymousClass5(r22, r110);
            LAST_BEFORE = r23;
            $VALUES = new KeyPresentBehavior[]{r12, r15, r18, r21, r23};
        }

        private KeyPresentBehavior(String r10, int r11) {
            super(r10, r11);
        }

        public static KeyPresentBehavior valueOf(String r10) {
            return (KeyPresentBehavior) Enum.valueOf(KeyPresentBehavior.class, r10);
        }

        public static KeyPresentBehavior[] values() {
            return (KeyPresentBehavior[]) $VALUES.clone();
        }

        public abstract <E> int resultIndex(Comparator<? super E> r10, E r11, List<? extends E> r12, int r13);

        public /* synthetic */ KeyPresentBehavior(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    private SortedLists() {
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> r10, E r11, KeyPresentBehavior r12, KeyAbsentBehavior r13) {
        Preconditions.checkNotNull(r11);
        return binarySearch(r10, r11, Ordering.natural(), r12, r13);
    }

    public static <E, K extends Comparable> int binarySearch(List<E> r10, Function<? super E, K> r11, @NullableDecl K r12, KeyPresentBehavior r13, KeyAbsentBehavior r14) {
        return binarySearch(r10, r11, r12, Ordering.natural(), r13, r14);
    }

    public static <E, K> int binarySearch(List<E> r10, Function<? super E, K> r11, @NullableDecl K r12, Comparator<? super K> r13, KeyPresentBehavior r14, KeyAbsentBehavior r15) {
        return binarySearch(Lists.transform(r10, r11), r12, r13, r14, r15);
    }

    public static <E> int binarySearch(List<? extends E> r10, @NullableDecl E r11, Comparator<? super E> r12, KeyPresentBehavior r13, KeyAbsentBehavior r14) {
        Preconditions.checkNotNull(r12);
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r13);
        Preconditions.checkNotNull(r14);
        if ((r10 instanceof RandomAccess) == true) goto L5;
        r10 = Lists.newArrayList(r10);
    L5:
        int r15 = r10.size() - 1;
        int r16 = 0;
    L6:
        if (r16 > r15) goto L15;
        int r17 = (r16 + r15) >>> 1;
        int r18 = r12.compare(r11, r10.get(r17));
        if (r18 < 0) goto L9;
        if (r18 <= 0) goto L13;
        r16 = r17 + 1;
        goto L6
    L13:
        return r16 + r13.resultIndex(r12, r11, r10.subList(r16, r15 + 1), r17 - r16);
    L9:
        r15 = r17 - 1;
        goto L6
    L15:
        return r14.resultIndex(r16);
    }
}
