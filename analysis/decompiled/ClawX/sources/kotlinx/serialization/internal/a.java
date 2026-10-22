package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3698a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KSerializer f3699b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ KSerializer f3700c;

    public /* synthetic */ a(KSerializer kSerializer, KSerializer kSerializer2, int i8) {
        this.f3698a = i8;
        this.f3699b = kSerializer;
        this.f3700c = kSerializer2;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        switch (this.f3698a) {
            case 0:
                return MapEntrySerializer.descriptor$lambda$0(this.f3699b, this.f3700c, (ClassSerialDescriptorBuilder) obj);
            default:
                return PairSerializer.descriptor$lambda$0(this.f3699b, this.f3700c, (ClassSerialDescriptorBuilder) obj);
        }
    }
}
