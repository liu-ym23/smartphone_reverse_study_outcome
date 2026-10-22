package androidx.window.core;

import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class SpecificationComputer<T> {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class VerificationMode {

        /* renamed from: a, reason: collision with root package name */
        public static final VerificationMode f2680a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ VerificationMode[] f2681b;

        /* JADX INFO: Fake field, exist only in values array */
        VerificationMode EF0;

        static {
            VerificationMode verificationMode = new VerificationMode("STRICT", 0);
            VerificationMode verificationMode2 = new VerificationMode("LOG", 1);
            VerificationMode verificationMode3 = new VerificationMode("QUIET", 2);
            f2680a = verificationMode3;
            f2681b = new VerificationMode[]{verificationMode, verificationMode2, verificationMode3};
        }

        public VerificationMode() {
            throw null;
        }

        public static VerificationMode valueOf(String str) {
            return (VerificationMode) Enum.valueOf(VerificationMode.class, str);
        }

        public static VerificationMode[] values() {
            return (VerificationMode[]) f2681b.clone();
        }
    }

    public static String b(Object value, String message) {
        g.f(value, "value");
        g.f(message, "message");
        return message + " value: " + value;
    }

    public abstract T a();

    public abstract SpecificationComputer<T> c(String str, l<? super T, Boolean> lVar);
}
