package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int r10, int r11, @NullableDecl String r12) {
        if (r10 < 0) goto L4;
        if (r11 < 0) goto L9;
        return Strings.lenientFormat("%s (%s) must be less than size (%s)", new Object[]{r12, Integer.valueOf(r10), Integer.valueOf(r11)});
    L9:
        throw new IllegalArgumentException("negative size: " + r11);
    L4:
        return Strings.lenientFormat("%s (%s) must not be negative", new Object[]{r12, Integer.valueOf(r10)});
    }

    private static String badPositionIndex(int r10, int r11, @NullableDecl String r12) {
        if (r10 < 0) goto L4;
        if (r11 < 0) goto L9;
        return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", new Object[]{r12, Integer.valueOf(r10), Integer.valueOf(r11)});
    L9:
        throw new IllegalArgumentException("negative size: " + r11);
    L4:
        return Strings.lenientFormat("%s (%s) must not be negative", new Object[]{r12, Integer.valueOf(r10)});
    }

    private static String badPositionIndexes(int r10, int r11, int r12) {
        if (r10 < 0) goto L13;
        if (r10 > r12) goto L13;
        if (r11 < 0) goto L11;
        if (r11 > r12) goto L11;
        return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", new Object[]{Integer.valueOf(r11), Integer.valueOf(r10)});
    L11:
        return badPositionIndex(r11, r12, "end index");
    L13:
        return badPositionIndex(r10, r12, "start index");
    }

    public static void checkArgument(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int r10, int r11) {
        return checkElementIndex(r10, r11, SlideCard.KEY_INDEX);
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw null;
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int r10, int r11) {
        return checkPositionIndex(r10, r11, SlideCard.KEY_INDEX);
    }

    public static void checkPositionIndexes(int r10, int r11, int r12) {
        if (r10 < 0) goto L7;
        if (r11 < r10) goto L7;
        if (r11 > r12) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(badPositionIndexes(r10, r11, r12));
    }

    public static void checkState(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void checkArgument(boolean r10, @NullableDecl Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r11));
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int r10, int r11, @NullableDecl String r12) {
        if (r10 < 0) goto L6;
        if (r10 >= r11) goto L6;
        return r10;
    L6:
        throw new IndexOutOfBoundsException(badElementIndex(r10, r11, r12));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl Object r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(String.valueOf(r11));
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int r10, int r11, @NullableDecl String r12) {
        if (r10 < 0) goto L6;
        if (r10 > r11) goto L6;
        return r10;
    L6:
        throw new IndexOutOfBoundsException(badPositionIndex(r10, r11, r12));
    }

    public static void checkState(boolean r10, @NullableDecl Object r11) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r11));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, r12));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object... r12) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, r12));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, r12));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, char r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, char r12) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, char r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, int r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, int r12) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, int r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, long r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, long r12) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, long r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{r12}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object r12) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{r12}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{r12}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, char r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Character.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, char r12, char r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, char r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, char r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Integer.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, char r12, int r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, char r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, char r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Long.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, char r12, long r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, char r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, char r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), r13}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, char r12, @NullableDecl Object r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), r13}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, char r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), r13}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, int r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Character.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, int r12, char r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, int r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, int r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, int r12, int r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, int r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, int r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Long.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, int r12, long r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, int r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, int r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), r13}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, int r12, @NullableDecl Object r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), r13}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, int r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), r13}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, long r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Character.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, long r12, char r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, long r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, long r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Integer.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, long r12, int r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, long r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, long r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Long.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, long r12, long r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, long r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, long r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), r13}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, long r12, @NullableDecl Object r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), r13}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, long r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), r13}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{r12, Character.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object r12, char r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{r12, Character.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{r12, Character.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{r12, Integer.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object r12, int r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{r12, Integer.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{r12, Integer.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{r12, Long.valueOf(r13)}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object r12, long r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{r12, Long.valueOf(r13)}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{r12, Long.valueOf(r13)}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{r12, r13}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{r12, r13}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{r12, r13}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14}));
    }

    public static void checkArgument(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14, @NullableDecl Object r15) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14, r15}));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14, @NullableDecl Object r15) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        throw new NullPointerException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14, r15}));
    }

    public static void checkState(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14, @NullableDecl Object r15) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14, r15}));
    }
}
