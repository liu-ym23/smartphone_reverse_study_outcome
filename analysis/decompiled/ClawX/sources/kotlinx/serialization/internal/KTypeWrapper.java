package kotlinx.serialization.internal;

import com.stepos.stepclaw.SecurePrefs;
import java.lang.annotation.Annotation;
import java.util.List;
import k4.v;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v5.d;
import v5.i;
import v5.k;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0082\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0096\u0080\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00068VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00020\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/reflect/KType;", "origin", "<init>", "(Lkotlin/reflect/KType;)V", "annotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "isMarkedNullable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "()Z", "equals", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
final class KTypeWrapper implements i {
    private final i origin;

    public KTypeWrapper(i origin) {
        p.e(origin, "origin");
        this.origin = origin;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        i iVar = this.origin;
        KTypeWrapper kTypeWrapper = other instanceof KTypeWrapper ? (KTypeWrapper) other : null;
        if (!p.a(iVar, kTypeWrapper != null ? kTypeWrapper.origin : null)) {
            return false;
        }
        d classifier = getClassifier();
        if (classifier instanceof v5.c) {
            i iVar2 = other instanceof i ? (i) other : null;
            d classifier2 = iVar2 != null ? iVar2.getClassifier() : null;
            if (classifier2 != null && (classifier2 instanceof v5.c)) {
                return v.I((v5.c) classifier).equals(v.I((v5.c) classifier2));
            }
        }
        return false;
    }

    @Override // v5.a
    public List<Annotation> getAnnotations() {
        return this.origin.getAnnotations();
    }

    @Override // v5.i
    public List<k> getArguments() {
        return this.origin.getArguments();
    }

    @Override // v5.i
    public d getClassifier() {
        return this.origin.getClassifier();
    }

    public int hashCode() {
        return this.origin.hashCode();
    }

    @Override // v5.i
    public boolean isMarkedNullable() {
        return this.origin.isMarkedNullable();
    }

    public String toString() {
        return "KTypeWrapper: " + this.origin;
    }
}
