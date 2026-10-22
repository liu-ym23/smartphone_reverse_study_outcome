package kotlinx.serialization;

import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import p5.l;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3690a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SealedClassSerializer f3691b;

    public /* synthetic */ b(SealedClassSerializer sealedClassSerializer, int i8) {
        this.f3690a = i8;
        this.f3691b = sealedClassSerializer;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        int i8 = this.f3690a;
        SealedClassSerializer sealedClassSerializer = this.f3691b;
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
        switch (i8) {
            case 0:
                return SealedClassSerializer.descriptor_delegate$lambda$0$0(sealedClassSerializer, classSerialDescriptorBuilder);
            default:
                return SealedClassSerializer.descriptor_delegate$lambda$0$0$0(sealedClassSerializer, classSerialDescriptorBuilder);
        }
    }
}
