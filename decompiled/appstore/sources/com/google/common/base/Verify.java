package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Verify {
    private Verify() {
    }

    public static void verify(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException();
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@NullableDecl T r10) {
        return (T) verifyNotNull(r10, "expected a non-null reference", new Object[0]);
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object... r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, r12));
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@NullableDecl T r10, @NullableDecl String r11, @NullableDecl Object... r12) {
        if (r10 == null) goto L4;
        boolean r13 = true;
    L5:
        verify(r13, r11, r12);
        return r10;
    L4:
        r13 = false;
        goto L5
    }

    public static void verify(boolean r10, @NullableDecl String r11, char r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, int r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, long r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{r12}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, char r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, int r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, long r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Character.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, char r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{r12, Character.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, char r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, int r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, long r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{r12, Integer.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, char r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, int r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, long r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), Long.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{r12, Long.valueOf(r13)}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, char r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Character.valueOf(r12), r13}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, int r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Integer.valueOf(r12), r13}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, long r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{Long.valueOf(r12), r13}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{r12, r13}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14}));
    }

    public static void verify(boolean r10, @NullableDecl String r11, @NullableDecl Object r12, @NullableDecl Object r13, @NullableDecl Object r14, @NullableDecl Object r15) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new VerifyException(Strings.lenientFormat(r11, new Object[]{r12, r13, r14, r15}));
    }
}
