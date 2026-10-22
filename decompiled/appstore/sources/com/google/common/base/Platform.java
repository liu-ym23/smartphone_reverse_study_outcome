package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
final class Platform {
    private static final Logger logger = null;
    private static final PatternCompiler patternCompiler = null;

    /* JADX INFO: renamed from: com.google.common.base.Platform$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }

        @Override // com.google.common.base.PatternCompiler
        public CommonPattern compile(String r10) {
            return new JdkPattern(Pattern.compile(r10));
        }

        @Override // com.google.common.base.PatternCompiler
        public boolean isPcreLike() {
            return true;
        }

        public /* synthetic */ JdkPatternCompiler(AnonymousClass1 r10) {
            this();
        }
    }

    static {
        logger = Logger.getLogger(Platform.class.getName());
        patternCompiler = loadPatternCompiler();
    }

    private Platform() {
    }

    public static CommonPattern compilePattern(String r10) {
        Preconditions.checkNotNull(r10);
        return patternCompiler.compile(r10);
    }

    public static String emptyToNull(@NullableDecl String r10) {
        if (stringIsNullOrEmpty(r10) == false) goto L6;
        return null;
    L6:
        return r10;
    }

    public static String formatCompact4Digits(double r10) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(r10)});
    }

    public static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> r10, String r11) {
        WeakReference<? extends Enum<?>> r12 = Enums.getEnumConstants(r10).get(r11);
        if (r12 != null) goto L6;
        return Optional.absent();
    L6:
        return Optional.of(r10.cast(r12.get()));
    }

    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler(null);
    }

    private static void logPatternCompilerError(ServiceConfigurationError r10) {
        logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", r10);
    }

    public static String nullToEmpty(@NullableDecl String r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        return r10;
    }

    public static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    public static CharMatcher precomputeCharMatcher(CharMatcher r10) {
        return r10.precomputedInternal();
    }

    public static boolean stringIsNullOrEmpty(@NullableDecl String r10) {
        if (r10 != null) goto L4;
    L7:
        return true;
    L4:
        if (r10.isEmpty() == true) goto L7;
        return false;
    }

    public static long systemNanoTime() {
        return System.nanoTime();
    }
}
