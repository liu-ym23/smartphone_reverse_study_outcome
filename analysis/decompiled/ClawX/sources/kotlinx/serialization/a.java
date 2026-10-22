package kotlinx.serialization;

import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3688a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KSerializer f3689b;

    public /* synthetic */ a(KSerializer kSerializer, int i8) {
        this.f3688a = i8;
        this.f3689b = kSerializer;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f3688a;
        KSerializer kSerializer = this.f3689b;
        switch (i8) {
            case 0:
                return ContextualSerializer.descriptor$lambda$0((ContextualSerializer) kSerializer, (ClassSerialDescriptorBuilder) obj);
            default:
                return PolymorphicSerializer.descriptor_delegate$lambda$0$0((PolymorphicSerializer) kSerializer, (ClassSerialDescriptorBuilder) obj);
        }
    }
}
