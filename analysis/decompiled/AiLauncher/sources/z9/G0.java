package z9;

import E9.InterfaceC0799d;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w9.InterfaceC5746e;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lz9/G0;", "Lw9/e;", "Lz9/X;", "Lga/c;", "fqName", "<init>", "(Lorg/jetbrains/kotlin/name/FqName;)V", Const.INTENT_KEY_APIKEY, "Lga/c;", "getFqName", "()Lorg/jetbrains/kotlin/name/FqName;", "LE9/d;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassifierDescriptor;", "descriptor", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class G0 implements InterfaceC5746e, InterfaceC6400X {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ga.c fqName;

    public G0(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        this.fqName = fqName;
    }

    /* renamed from: a, reason: from getter */
    public final ga.c getFqName() {
        return this.fqName;
    }

    @Override // z9.InterfaceC6400X
    public InterfaceC0799d getDescriptor() {
        throw new IllegalStateException(("Cannot load descriptor of a type alias: " + this.fqName).toString());
    }
}
