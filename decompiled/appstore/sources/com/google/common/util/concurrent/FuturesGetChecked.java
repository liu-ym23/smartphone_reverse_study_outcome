package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class FuturesGetChecked {
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = null;

    @VisibleForTesting
    public interface GetCheckedTypeValidator {
        void validateClass(Class<? extends Exception> r10);
    }

    @VisibleForTesting
    public static class GetCheckedTypeValidatorHolder {
        static final GetCheckedTypeValidator BEST_VALIDATOR = null;
        static final String CLASS_VALUE_VALIDATOR_NAME = null;

        @IgnoreJRERequirement
        public static final enum ClassValueValidator extends Enum<ClassValueValidator> implements GetCheckedTypeValidator {
            private static final /* synthetic */ ClassValueValidator[] $VALUES = null;
            public static final ClassValueValidator INSTANCE = null;
            private static final ClassValue<Boolean> isValidClass = null;

            static {
                ClassValueValidator r10 = new ClassValueValidator("INSTANCE", 0);
                INSTANCE = r10;
                $VALUES = new ClassValueValidator[]{r10};
                isValidClass = new AnonymousClass1();
            }

            private ClassValueValidator(String r10, int r11) {
                super(r10, r11);
            }

            public static ClassValueValidator valueOf(String r10) {
                return (ClassValueValidator) Enum.valueOf(ClassValueValidator.class, r10);
            }

            public static ClassValueValidator[] values() {
                return (ClassValueValidator[]) $VALUES.clone();
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> r10) {
                isValidClass.get(r10);
            }
        }

        public static final enum WeakSetValidator extends Enum<WeakSetValidator> implements GetCheckedTypeValidator {
            private static final /* synthetic */ WeakSetValidator[] $VALUES = null;
            public static final WeakSetValidator INSTANCE = null;
            private static final Set<WeakReference<Class<? extends Exception>>> validClasses = null;

            static {
                WeakSetValidator r10 = new WeakSetValidator("INSTANCE", 0);
                INSTANCE = r10;
                $VALUES = new WeakSetValidator[]{r10};
                validClasses = new CopyOnWriteArraySet();
            }

            private WeakSetValidator(String r10, int r11) {
                super(r10, r11);
            }

            public static WeakSetValidator valueOf(String r10) {
                return (WeakSetValidator) Enum.valueOf(WeakSetValidator.class, r10);
            }

            public static WeakSetValidator[] values() {
                return (WeakSetValidator[]) $VALUES.clone();
            }

            @Override // com.google.common.util.concurrent.FuturesGetChecked.GetCheckedTypeValidator
            public void validateClass(Class<? extends Exception> r10) {
                Iterator<WeakReference<Class<? extends Exception>>> r11 = validClasses.iterator();
            L4:
                if (r11.hasNext() == false) goto L8;
                if (r10.equals(r11.next().get()) == false) goto L4;
                return;
            L8:
                FuturesGetChecked.checkExceptionClassValidity(r10);
                Set<WeakReference<Class<? extends Exception>>> r12 = validClasses;
                if (r12.size() <= 1000) goto L11;
                r12.clear();
            L11:
                r12.add(new WeakReference(r10));
            }
        }

        static {
            CLASS_VALUE_VALIDATOR_NAME = GetCheckedTypeValidatorHolder.class.getName() + "$ClassValueValidator";
            BEST_VALIDATOR = getBestValidator();
        }

        public GetCheckedTypeValidatorHolder() {
        }

        public static GetCheckedTypeValidator getBestValidator() {
            return (GetCheckedTypeValidator) Class.forName(CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
        L5:
            return FuturesGetChecked.weakSetValidator();
        }
    }

    static {
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new AnonymousClass1()).reverse();
    }

    private FuturesGetChecked() {
    }

    private static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }

    @VisibleForTesting
    public static void checkExceptionClassValidity(Class<? extends Exception> r10) {
        Preconditions.checkArgument(isCheckedException(r10), "Futures.getChecked exception type (%s) must not be a RuntimeException", r10);
        Preconditions.checkArgument(hasConstructorUsableByGetChecked(r10), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", r10);
    }

    @VisibleForTesting
    public static GetCheckedTypeValidator classValueValidator() {
        return GetCheckedTypeValidatorHolder.ClassValueValidator.INSTANCE;
    }

    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> r10, Class<X> r11) throws Exception {
        return (V) getChecked(bestGetCheckedTypeValidator(), r10, r11);
    }

    private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> r10) {
        newWithCause(r10, new Exception());     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }

    @VisibleForTesting
    public static boolean isCheckedException(Class<? extends Exception> r10) {
        return !RuntimeException.class.isAssignableFrom(r10);
    }

    @NullableDecl
    private static <X> X newFromConstructor(Constructor<X> r10, Throwable r11) {
        Class<?>[] r12 = r10.getParameterTypes();
        Object[] r13 = new Object[r12.length];
        int r14 = 0;
    L4:
        if (r14 >= r12.length) goto L16;
        Class<?> r15 = r12[r14];
        if (r15.equals(String.class) == false) goto L9;
        r13[r14] = r11.toString();
    L11:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15.equals(Throwable.class) == false) goto L12;
        r13[r14] = r11;
        goto L11
    L12:
        return null;
    L16:
        return r10.newInstance(r13);
    L15:
        return null;
    }

    private static <X extends Exception> X newWithCause(Class<X> r10, Throwable r11) {
        Iterator r12 = preferringStrings(Arrays.asList(r10.getConstructors())).iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        X r13 = (X) newFromConstructor((Constructor) r12.next(), r11);
        if (r13 == null) goto L4;
        if (r13.getCause() != null) goto L10;
        r13.initCause(r11);
    L10:
        return r13;
    L12:
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + r10 + " in response to chained exception", r11);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> r10) {
        return (List<Constructor<X>>) WITH_STRING_PARAM_FIRST.sortedCopy(r10);
    }

    @VisibleForTesting
    public static GetCheckedTypeValidator weakSetValidator() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable r10, Class<X> r11) throws Exception {
        if ((r10 instanceof Error) == true) goto L11;
        if ((r10 instanceof RuntimeException) == false) goto L9;
        throw new UncheckedExecutionException(r10);
    L9:
        throw newWithCause(r11, r10);
    L11:
        throw new ExecutionError((Error) r10);
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(GetCheckedTypeValidator r10, Future<V> r11, Class<X> r12) throws Exception {
        r10.validateClass(r12);
        return r11.get();
    L8:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw newWithCause(r12, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r12);
        throw new AssertionError();
    }

    @CanIgnoreReturnValue
    public static <V, X extends Exception> V getChecked(Future<V> r10, Class<X> r11, long r12, TimeUnit r13) throws Exception {
        bestGetCheckedTypeValidator().validateClass(r11);
        return r10.get(r12, r13);
    L11:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw newWithCause(r11, e);
    L5:
        e = move-exception;
        wrapAndThrowExceptionOrError(e.getCause(), r11);
        throw new AssertionError();
    L8:
        e = move-exception;
        throw newWithCause(r11, e);
    }
}
