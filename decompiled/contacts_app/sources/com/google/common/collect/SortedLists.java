package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class SortedLists {

    /* JADX INFO: renamed from: com.google.common.collect.SortedLists$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum KeyAbsentBehavior extends Enum<KeyAbsentBehavior> {
        private static final /* synthetic */ KeyAbsentBehavior[] $VALUES = null;
        public static final KeyAbsentBehavior INVERTED_INSERTION_INDEX = null;
        public static final KeyAbsentBehavior NEXT_HIGHER = null;
        public static final KeyAbsentBehavior NEXT_LOWER = null;

        abstract int resultIndex(int r1);

        private KeyAbsentBehavior(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ KeyAbsentBehavior(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static KeyAbsentBehavior valueOf(String r1) {
            return (KeyAbsentBehavior) Enum.valueOf(KeyAbsentBehavior.class, r1);
        }

        public static KeyAbsentBehavior[] values() {
            return (KeyAbsentBehavior[]) $VALUES.clone();
        }

        static {
            final String r1 = "NEXT_LOWER";
            final int r2 = 0;
            KeyAbsentBehavior r0 = new AnonymousClass1(r1, r2);
            NEXT_LOWER = r0;
            final String r3 = "NEXT_HIGHER";
            final int r4 = 1;
            KeyAbsentBehavior r5 = new AnonymousClass2(r3, r4);
            NEXT_HIGHER = r5;
            final String r6 = "INVERTED_INSERTION_INDEX";
            final int r7 = 2;
            KeyAbsentBehavior r8 = new AnonymousClass3(r6, r7);
            INVERTED_INSERTION_INDEX = r8;
            $VALUES = new KeyAbsentBehavior[]{r0, r5, r8};
        }
    }

    public static abstract enum KeyPresentBehavior extends Enum<KeyPresentBehavior> {
        private static final /* synthetic */ KeyPresentBehavior[] $VALUES = null;
        public static final KeyPresentBehavior ANY_PRESENT = null;
        public static final KeyPresentBehavior FIRST_AFTER = null;
        public static final KeyPresentBehavior FIRST_PRESENT = null;
        public static final KeyPresentBehavior LAST_BEFORE = null;
        public static final KeyPresentBehavior LAST_PRESENT = null;

        abstract <E> int resultIndex(Comparator<? super E> r1, E r2, List<? extends E> r3, int r4);

        private KeyPresentBehavior(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ KeyPresentBehavior(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static KeyPresentBehavior valueOf(String r1) {
            return (KeyPresentBehavior) Enum.valueOf(KeyPresentBehavior.class, r1);
        }

        public static KeyPresentBehavior[] values() {
            return (KeyPresentBehavior[]) $VALUES.clone();
        }

        static {
            final String r1 = "ANY_PRESENT";
            final int r2 = 0;
            KeyPresentBehavior r0 = new AnonymousClass1(r1, r2);
            ANY_PRESENT = r0;
            final String r3 = "LAST_PRESENT";
            final int r4 = 1;
            KeyPresentBehavior r5 = new AnonymousClass2(r3, r4);
            LAST_PRESENT = r5;
            final String r6 = "FIRST_PRESENT";
            final int r7 = 2;
            KeyPresentBehavior r8 = new AnonymousClass3(r6, r7);
            FIRST_PRESENT = r8;
            final String r9 = "FIRST_AFTER";
            final int r10 = 3;
            KeyPresentBehavior r11 = new AnonymousClass4(r9, r10);
            FIRST_AFTER = r11;
            final String r12 = "LAST_BEFORE";
            final int r13 = 4;
            KeyPresentBehavior r14 = new AnonymousClass5(r12, r13);
            LAST_BEFORE = r14;
            $VALUES = new KeyPresentBehavior[]{r0, r5, r8, r11, r14};
        }
    }

    private SortedLists() {
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> r1, E r2, KeyPresentBehavior r3, KeyAbsentBehavior r4) {
        Preconditions.checkNotNull(r2);
        return binarySearch(r1, Preconditions.checkNotNull(r2), Ordering.natural(), r3, r4);
    }

    public static <E, K extends Comparable> int binarySearch(List<E> r6, Function<? super E, K> r7, @Nullable K r8, KeyPresentBehavior r9, KeyAbsentBehavior r10) {
        return binarySearch(r6, r7, r8, Ordering.natural(), r9, r10);
    }

    public static <E, K> int binarySearch(List<E> r0, Function<? super E, K> r1, @Nullable K r2, Comparator<? super K> r3, KeyPresentBehavior r4, KeyAbsentBehavior r5) {
        return binarySearch(Lists.transform(r0, r1), r2, r3, r4, r5);
    }

    public static <E> int binarySearch(List<? extends E> r4, @Nullable E r5, Comparator<? super E> r6, KeyPresentBehavior r7, KeyAbsentBehavior r8) {
        Preconditions.checkNotNull(r6);
        Preconditions.checkNotNull(r4);
        Preconditions.checkNotNull(r7);
        Preconditions.checkNotNull(r8);
        if ((r4 instanceof RandomAccess) == true) goto L5;
        r4 = Lists.newArrayList(r4);
    L5:
        int r0 = r4.size() - 1;
        int r1 = 0;
    L6:
        if (r1 > r0) goto L15;
        int r2 = (r1 + r0) >>> 1;
        int r3 = r6.compare(r5, r4.get(r2));
        if (r3 < 0) goto L9;
        if (r3 <= 0) goto L13;
        r1 = r2 + 1;
        goto L6
    L13:
        return r1 + r7.resultIndex(r6, r5, r4.subList(r1, r0 + 1), r2 - r1);
    L9:
        r0 = r2 - 1;
        goto L6
    L15:
        return r8.resultIndex(r1);
    }
}
