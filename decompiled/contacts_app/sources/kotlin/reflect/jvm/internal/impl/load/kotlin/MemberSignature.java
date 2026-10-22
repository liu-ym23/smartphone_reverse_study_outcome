package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* JADX INFO: compiled from: MemberSignature.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MemberSignature {
    public static final Companion Companion = null;
    private final String signature;

    /* JADX INFO: compiled from: MemberSignature.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MemberSignature fromMethod(NameResolver r2, JvmProtoBuf.JvmMethodSignature r3) {
            Intrinsics.checkNotNullParameter(r2, "nameResolver");
            Intrinsics.checkNotNullParameter(r3, "signature");
            return fromMethodNameAndDesc(r2.getString(r3.getName()), r2.getString(r3.getDesc()));
        }

        @JvmStatic
        public final MemberSignature fromMethodNameAndDesc(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "desc");
            return new MemberSignature(r2 + r3, null);
        }

        @JvmStatic
        public final MemberSignature fromFieldNameAndDesc(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "desc");
            return new MemberSignature(r2 + '#' + r3, null);
        }

        @JvmStatic
        public final MemberSignature fromJvmMemberSignature(JvmMemberSignature r2) {
            Intrinsics.checkNotNullParameter(r2, "signature");
            if ((r2 instanceof JvmMemberSignature.Method) == false) goto L6;
            return fromMethodNameAndDesc(r2.getName(), r2.getDesc());
        L6:
            if ((r2 instanceof JvmMemberSignature.Field) == false) goto L10;
            return fromFieldNameAndDesc(r2.getName(), r2.getDesc());
        L10:
            throw new NoWhenBranchMatchedException();
        }

        @JvmStatic
        public final MemberSignature fromMethodSignatureAndParameterIndex(MemberSignature r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "signature");
            return new MemberSignature(r2.getSignature() + '@' + r3, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ MemberSignature(String r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MemberSignature) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.signature, ((MemberSignature) r4).signature) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.signature.hashCode();
    }

    public String toString() {
        return "MemberSignature(signature=" + this.signature + ')';
    }

    private MemberSignature(String r1) {
        this.signature = r1;
    }

    public final String getSignature() {
        return this.signature;
    }
}
