package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* JADX INFO: compiled from: KotlinClassFinder.kt */
    public static abstract class Result {

        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class ClassFileContent extends Result {
            private final byte[] content;

            public final byte[] getContent() {
                return this.content;
            }
        }

        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class KotlinClass extends Result {
            private final byte[] byteContent;
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            public KotlinClass(KotlinJvmBinaryClass r2, byte[] r3) {
                Intrinsics.checkNotNullParameter(r2, "kotlinJvmBinaryClass");
                super(null);
                this.kotlinJvmBinaryClass = r2;
                this.byteContent = r3;
            }

            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass r1, byte[] r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 2) == 0) goto L5;
                r2 = null;
            L5:
                this(r1, r2);
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }
        }

        public /* synthetic */ Result(DefaultConstructorMarker r1) {
            this();
        }

        private Result() {
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            if ((this instanceof KotlinClass) == false) goto L5;
            KotlinClass r2 = (KotlinClass) this;
        L6:
            if (r2 != null) goto L8;
            return null;
        L8:
            return r2.getKotlinJvmBinaryClass();
        L5:
            r2 = null;
            goto L6
        }
    }

    Result findKotlinClassOrContent(JavaClass r1);

    Result findKotlinClassOrContent(ClassId r1);
}
