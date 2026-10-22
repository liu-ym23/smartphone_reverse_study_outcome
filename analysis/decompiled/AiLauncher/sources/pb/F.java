package pb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlinx.serialization.descriptors.SerialDescriptor;
import nb.AbstractC4959l;
import nb.AbstractC4960m;
import nb.C4955h;
import nb.C4958k;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u001a\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lpb/F;", "Lpb/I0;", "", "name", "", "elementsCount", "<init>", "(Ljava/lang/String;I)V", "index", "Lkotlinx/serialization/descriptors/SerialDescriptor;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "hashCode", "()I", "Lnb/l;", "m", "Lnb/l;", "getKind", "()Lnb/l;", "kind", "", "n", "LY8/h;", "x", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class F extends I0 {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final AbstractC4959l kind;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Y8.h elementDescriptors;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F(final String name, final int i10) {
        super(name, null, i10, 2, null);
        kotlin.jvm.internal.p.i(name, "name");
        this.kind = AbstractC4959l.b.f37292a;
        this.elementDescriptors = C4848b.b(new InterfaceC5063a() { // from class: pb.E
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return F.w(i10, name, this);
            }
        });
    }

    public static final SerialDescriptor[] w(int i10, String str, F f10) {
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            serialDescriptorArr[i11] = C4958k.h(str + '.' + f10.e(i11), AbstractC4960m.d.f37296a, new SerialDescriptor[0], null, 8, null);
        }
        return serialDescriptorArr;
    }

    @Override // pb.I0
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) other;
        return serialDescriptor.getKind() == AbstractC4959l.b.f37292a && kotlin.jvm.internal.p.d(getSerialName(), serialDescriptor.getSerialName()) && kotlin.jvm.internal.p.d(D0.a(this), D0.a(serialDescriptor));
    }

    @Override // pb.I0, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor g(int index) {
        return x()[index];
    }

    @Override // pb.I0, kotlinx.serialization.descriptors.SerialDescriptor
    public AbstractC4959l getKind() {
        return this.kind;
    }

    @Override // pb.I0
    public int hashCode() {
        int iHashCode = getSerialName().hashCode();
        Iterator<String> it = C4955h.b(this).iterator();
        int iHashCode2 = 1;
        while (it.hasNext()) {
            int i10 = iHashCode2 * 31;
            String next = it.next();
            iHashCode2 = i10 + (next != null ? next.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // pb.I0
    public String toString() {
        return Z8.F.A0(C4955h.b(this), ", ", getSerialName() + '(', ")", 0, null, null, 56, null);
    }

    public final SerialDescriptor[] x() {
        return (SerialDescriptor[]) this.elementDescriptors.getValue();
    }
}
