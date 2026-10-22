package kotlinx.serialization.internal;

import kotlinx.serialization.DeserializationStrategy;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3703a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaggedDecoder f3704b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DeserializationStrategy f3705c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy, Object obj, int i8) {
        this.f3703a = i8;
        this.f3704b = taggedDecoder;
        this.f3705c = deserializationStrategy;
        this.d = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f3703a) {
            case 0:
                return this.f3704b.decodeSerializableValue(this.f3705c, this.d);
            default:
                return TaggedDecoder.decodeNullableSerializableElement$lambda$0(this.f3704b, this.f3705c, this.d);
        }
    }
}
