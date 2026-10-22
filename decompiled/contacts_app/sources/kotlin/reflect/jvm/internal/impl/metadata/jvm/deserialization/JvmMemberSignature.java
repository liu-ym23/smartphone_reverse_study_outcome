package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class JvmMemberSignature {

    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class Field extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public final String component1() {
            return getName();
        }

        public final String component2() {
            return getDesc();
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Field) == true) goto L8;
            return false;
        L8:
            Field r6 = (Field) r5;
            if (Intrinsics.areEqual(getName(), r6.getName()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getDesc(), r6.getDesc()) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (getName().hashCode() * 31) + getDesc().hashCode();
        }

        public Field(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "desc");
            super(null);
            this.name = r2;
            this.desc = r3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + ':' + getDesc();
        }
    }

    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class Method extends JvmMemberSignature {
        private final String desc;
        private final String name;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Method) == true) goto L8;
            return false;
        L8:
            Method r6 = (Method) r5;
            if (Intrinsics.areEqual(getName(), r6.getName()) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(getDesc(), r6.getDesc()) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (getName().hashCode() * 31) + getDesc().hashCode();
        }

        public Method(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "desc");
            super(null);
            this.name = r2;
            this.desc = r3;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getDesc() {
            return this.desc;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String getName() {
            return this.name;
        }

        @Override // kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature
        public String asString() {
            return getName() + getDesc();
        }
    }

    public /* synthetic */ JvmMemberSignature(DefaultConstructorMarker r1) {
        this();
    }

    public abstract String asString();

    public abstract String getDesc();

    public abstract String getName();

    private JvmMemberSignature() {
    }

    public final String toString() {
        return asString();
    }
}
