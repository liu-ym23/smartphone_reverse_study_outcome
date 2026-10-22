package kotlin.uuid;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class UuidSerialized implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public long f10109a;

    /* renamed from: b, reason: collision with root package name */
    public long f10110b;

    public UuidSerialized(long j10, long j11) {
        this.f10109a = j10;
        this.f10110b = j11;
    }

    private final Object readResolve() {
        long j10 = this.f10109a;
        long j11 = this.f10110b;
        return (j10 == 0 && j11 == 0) ? Uuid.f10106c : new Uuid(j10, j11);
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) {
        g.f(input, "input");
        this.f10109a = input.readLong();
        this.f10110b = input.readLong();
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        g.f(output, "output");
        output.writeLong(this.f10109a);
        output.writeLong(this.f10110b);
    }

    public UuidSerialized() {
        this(0L, 0L);
    }
}
