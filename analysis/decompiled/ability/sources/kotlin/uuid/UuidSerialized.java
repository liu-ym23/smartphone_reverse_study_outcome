package kotlin.uuid;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/uuid/UuidSerialized;", "Ljava/io/Externalizable;", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class UuidSerialized implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public long f5173a;
    public long b;

    private final Object readResolve() {
        long j5 = this.f5173a;
        long j6 = this.b;
        return (j5 == 0 && j6 == 0) ? Uuid.c : new Uuid(j5, j6);
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) {
        k.f(input, "input");
        this.f5173a = input.readLong();
        this.b = input.readLong();
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        k.f(output, "output");
        output.writeLong(this.f5173a);
        output.writeLong(this.b);
    }
}
