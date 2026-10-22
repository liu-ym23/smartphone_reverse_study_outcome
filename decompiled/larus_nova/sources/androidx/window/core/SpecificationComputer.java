package androidx.window.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u000f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0004J/\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\t\u001a\u00020\u00072\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000eH&¨\u0006\u0011"}, d2 = {"Landroidx/window/core/SpecificationComputer;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "compute", "()Ljava/lang/Object;", "createMessage", "", "value", "message", "require", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "VerificationMode", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SpecificationComputer<T> {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/window/core/SpecificationComputer$Companion;", "", "()V", "startSpecification", "Landroidx/window/core/SpecificationComputer;", ExifInterface.GPS_DIRECTION_TRUE, "tag", "", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "logger", "Landroidx/window/core/Logger;", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/SpecificationComputer$VerificationMode;Landroidx/window/core/Logger;)Landroidx/window/core/SpecificationComputer;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final <T> SpecificationComputer<T> startSpecification(T r100, String r101, VerificationMode r102, Logger r103) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "tag");
            Intrinsics.checkNotNullParameter(r102, "verificationMode");
            Intrinsics.checkNotNullParameter(r103, "logger");
            return new ValidSpecification(r100, r101, r102, r103);
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion r100, Object r101, String r102, VerificationMode r103, Logger r104, int r105, Object r106) {
            if ((r105 & 2) == 0) goto L6;
            r103 = BuildConfig.INSTANCE.getVerificationMode();
        L6:
            if ((r105 & 4) == 0) goto L9;
            r104 = AndroidLogger.INSTANCE;
        L9:
            return r100.startSpecification(r101, r102, r103, r104);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/window/core/SpecificationComputer$VerificationMode;", "", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum VerificationMode extends Enum<VerificationMode> {
        private static final /* synthetic */ VerificationMode[] $VALUES = null;
        public static final VerificationMode LOG = null;
        public static final VerificationMode QUIET = null;
        public static final VerificationMode STRICT = null;

        private static final /* synthetic */ VerificationMode[] $values() {
            return new VerificationMode[]{STRICT, LOG, QUIET};
        }

        public static VerificationMode valueOf(String r100) {
            return (VerificationMode) a.a(VerificationMode.class, r100);
        }

        public static VerificationMode[] values() {
            return (VerificationMode[]) $VALUES.clone();
        }

        static {
            STRICT = new VerificationMode("STRICT", 0);
            LOG = new VerificationMode("LOG", 1);
            QUIET = new VerificationMode("QUIET", 2);
            $VALUES = $values();
        }

        private VerificationMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SpecificationComputer() {
    }

    public abstract T compute();

    public abstract SpecificationComputer<T> require(String r100, Function1<? super T, Boolean> r101);

    public final String createMessage(Object r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "message");
        return r101 + " value: " + r100;
    }
}
