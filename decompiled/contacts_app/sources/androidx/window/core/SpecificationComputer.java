package androidx.window.core;

import androidx.exifinterface.media.ExifInterface;
import com.android.contacts.common.SimContactsConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpecificationComputer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u000f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0004J/\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\t\u001a\u00020\u00072\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\b\u000eH&¨\u0006\u0011"}, d2 = {"Landroidx/window/core/SpecificationComputer;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "compute", "()Ljava/lang/Object;", "createMessage", "", "value", "message", "require", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "VerificationMode", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SpecificationComputer<T> {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: SpecificationComputer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/window/core/SpecificationComputer$Companion;", "", "()V", "startSpecification", "Landroidx/window/core/SpecificationComputer;", ExifInterface.GPS_DIRECTION_TRUE, SimContactsConstants.STR_TAG, "", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "logger", "Landroidx/window/core/Logger;", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/SpecificationComputer$VerificationMode;Landroidx/window/core/Logger;)Landroidx/window/core/SpecificationComputer;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion r0, Object r1, String r2, VerificationMode r3, AndroidLogger r4, int r5, Object r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = BuildConfig.INSTANCE.getVerificationMode();
        L6:
            if ((r5 & 4) == 0) goto L9;
            r4 = AndroidLogger.INSTANCE;
        L9:
            return r0.startSpecification(r1, r2, r3, r4);
        }

        public final <T> SpecificationComputer<T> startSpecification(T r1, String r2, VerificationMode r3, Logger r4) {
            Intrinsics.checkNotNullParameter(r1, "<this>");
            Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
            Intrinsics.checkNotNullParameter(r3, "verificationMode");
            Intrinsics.checkNotNullParameter(r4, "logger");
            return new ValidSpecification(r1, r2, r3, r4);
        }
    }

    /* JADX INFO: compiled from: SpecificationComputer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/window/core/SpecificationComputer$VerificationMode;", "", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum VerificationMode extends Enum<VerificationMode> {
        private static final /* synthetic */ VerificationMode[] $VALUES = null;
        public static final VerificationMode LOG = null;
        public static final VerificationMode QUIET = null;
        public static final VerificationMode STRICT = null;

        private static final /* synthetic */ VerificationMode[] $values() {
            return new VerificationMode[]{STRICT, LOG, QUIET};
        }

        public static VerificationMode valueOf(String r1) {
            return (VerificationMode) Enum.valueOf(VerificationMode.class, r1);
        }

        public static VerificationMode[] values() {
            return (VerificationMode[]) $VALUES.clone();
        }

        private VerificationMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            STRICT = new VerificationMode("STRICT", 0);
            LOG = new VerificationMode("LOG", 1);
            QUIET = new VerificationMode("QUIET", 2);
            $VALUES = $values();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public abstract T compute();

    public abstract SpecificationComputer<T> require(String r1, Function1<? super T, Boolean> r2);

    public SpecificationComputer() {
    }

    protected final String createMessage(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "value");
        Intrinsics.checkNotNullParameter(r2, "message");
        return r2 + " value: " + r1;
    }
}
