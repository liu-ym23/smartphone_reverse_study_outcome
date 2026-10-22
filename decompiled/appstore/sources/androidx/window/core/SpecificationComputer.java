package androidx.window.core;

import com.bytedance.apm.constant.CommonKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class SpecificationComputer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5222a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/window/core/SpecificationComputer$VerificationMode;", "", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum VerificationMode extends Enum<VerificationMode> {
        private static final /* synthetic */ VerificationMode[] $VALUES = null;
        public static final VerificationMode LOG = null;
        public static final VerificationMode QUIET = null;
        public static final VerificationMode STRICT = null;

        private static final /* synthetic */ VerificationMode[] $values() {
            return new VerificationMode[]{STRICT, LOG, QUIET};
        }

        static {
            STRICT = new VerificationMode("STRICT", 0);
            LOG = new VerificationMode("LOG", 1);
            QUIET = new VerificationMode("QUIET", 2);
            $VALUES = $values();
        }

        private VerificationMode(String r10, int r11) {
            super(r10, r11);
        }

        public static VerificationMode valueOf(String r10) {
            return (VerificationMode) Enum.valueOf(VerificationMode.class, r10);
        }

        public static VerificationMode[] values() {
            return (VerificationMode[]) $VALUES.clone();
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ SpecificationComputer b(a r10, Object r11, String r12, VerificationMode r13, Logger r14, int r15, Object r16) {
            if ((r15 & 2) == 0) goto L6;
            r13 = c.f5238a.a();
        L6:
            if ((r15 & 4) == 0) goto L9;
            r14 = androidx.window.core.a.f5233a;
        L9:
            return r10.a(r11, r12, r13, r14);
        }

        public final SpecificationComputer a(Object r10, String r11, VerificationMode r12, Logger r13) {
            q.g(r10, "<this>");
            q.g(r11, "tag");
            q.g(r12, "verificationMode");
            q.g(r13, "logger");
            return new e(r10, r11, r12, r13);
        }

        public a() {
        }
    }

    static {
        f5222a = new a(null);
    }

    public SpecificationComputer() {
    }

    public abstract Object a();

    public final String b(Object r10, String r11) {
        q.g(r10, CommonKey.KEY_VALUE);
        q.g(r11, "message");
        return r11 + " value: " + r10;
    }

    public abstract SpecificationComputer c(String r10, Function1 r11);
}
