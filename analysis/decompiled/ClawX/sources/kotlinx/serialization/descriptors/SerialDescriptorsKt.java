package kotlinx.serialization.descriptors;

import b5.a0;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.gateway.d;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.ArrayListClassDesc;
import kotlinx.serialization.internal.HashMapClassDesc;
import kotlinx.serialization.internal.HashSetClassDesc;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import p5.l;
import v5.i;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0080\u0004¢\u0006\u0002\u0010\u000b\u001a\u001a\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004\u001a\u001a\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\u0080\u0004\u001aN\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00122\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0087\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0086\u0088\u0004\u001a\u0012\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\u0080\u0004\u001a\u0012\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0087\u0080\u0004\u001a\u0012\u0010\u0019\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0087\u0088\u0004\u001a\u001a\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0080\u0004\u001a\u001a\u0010\u001b\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u001e\u0018\u0001\"\u0006\b\u0001\u0010\u001f\u0018\u0001H\u0087\u0088\u0004\u001a\u0012\u0010 \u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0087\u0080\u0004\u001a\u0012\u0010 \u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0087\u0088\u0004\u001a8\u0010)\u001a\u00020\t\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\b2\u0006\u0010*\u001a\u00020\u00032\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\b\u0002\u0010.\u001a\u00020/H\u0086\u0088\u0004\"\u001f\u0010!\u001a\u00020\u0001*\u00020\u00018FX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u001f\u0010&\u001a\u00020\u0001*\u00020\u00018FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b'\u0010#\u001a\u0004\b(\u0010%¨\u00060"}, d2 = {"buildClassSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "typeParameters", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "PrimitiveSerialDescriptor", ExtensionCallContract.KIND, "Lkotlinx/serialization/descriptors/PrimitiveKind;", "SerialDescriptor", "original", "buildSerialDescriptor", "Lkotlinx/serialization/descriptors/SerialKind;", "builder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDescriptor", "T", "type", "Lkotlin/reflect/KType;", "listSerialDescriptor", "elementDescriptor", "mapSerialDescriptor", "keyDescriptor", "valueDescriptor", "K", "V", "setSerialDescriptor", "nullable", "getNullable$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getNullable", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "nonNullOriginal", "getNonNullOriginal$annotations", "getNonNullOriginal", "element", "elementName", "annotations", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isOptional", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerialDescriptorsKt {
    public static final SerialDescriptor PrimitiveSerialDescriptor(String serialName, PrimitiveKind kind) {
        p.e(serialName, "serialName");
        p.e(kind, "kind");
        if (n.t1(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        return PrimitivesKt.PrimitiveDescriptorSafe(serialName, kind);
    }

    public static final SerialDescriptor SerialDescriptor(String serialName, SerialDescriptor original) {
        p.e(serialName, "serialName");
        p.e(original, "original");
        if (n.t1(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (!serialName.equals(original.getSerialName())) {
            if (original.getKind() instanceof PrimitiveKind) {
                PrimitivesKt.checkNameIsNotAPrimitive(serialName);
            }
            return new WrappedSerialDescriptor(serialName, original);
        }
        throw new IllegalArgumentException(("The name of the wrapped descriptor (" + serialName + ") cannot be the same as the name of the original descriptor (" + original.getSerialName() + ')').toString());
    }

    public static final SerialDescriptor buildClassSerialDescriptor(String serialName, SerialDescriptor[] typeParameters, l builderAction) {
        p.e(serialName, "serialName");
        p.e(typeParameters, "typeParameters");
        p.e(builderAction, "builderAction");
        if (n.t1(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builderAction.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, StructureKind.CLASS.INSTANCE, classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size(), c5.l.j0(typeParameters), classSerialDescriptorBuilder);
    }

    public static /* synthetic */ SerialDescriptor buildClassSerialDescriptor$default(String str, SerialDescriptor[] serialDescriptorArr, l lVar, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            lVar = new d(18);
        }
        return buildClassSerialDescriptor(str, serialDescriptorArr, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 buildClassSerialDescriptor$lambda$0(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        p.e(classSerialDescriptorBuilder, "<this>");
        return a0.f883a;
    }

    @InternalSerializationApi
    public static final SerialDescriptor buildSerialDescriptor(String serialName, SerialKind kind, SerialDescriptor[] typeParameters, l builder) {
        p.e(serialName, "serialName");
        p.e(kind, "kind");
        p.e(typeParameters, "typeParameters");
        p.e(builder, "builder");
        if (n.t1(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (kind.equals(StructureKind.CLASS.INSTANCE)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builder.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, kind, classSerialDescriptorBuilder.getElementNames$kotlinx_serialization_core().size(), c5.l.j0(typeParameters), classSerialDescriptorBuilder);
    }

    public static /* synthetic */ SerialDescriptor buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, l lVar, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            lVar = new d(19);
        }
        return buildSerialDescriptor(str, serialKind, serialDescriptorArr, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 buildSerialDescriptor$lambda$0(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        p.e(classSerialDescriptorBuilder, "<this>");
        return a0.f883a;
    }

    public static final /* synthetic */ <T> void element(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String elementName, List<? extends Annotation> annotations, boolean z) {
        p.e(classSerialDescriptorBuilder, "<this>");
        p.e(elementName, "elementName");
        p.e(annotations, "annotations");
        p.i();
        throw null;
    }

    public static /* synthetic */ void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String elementName, List annotations, boolean z, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            annotations = s.f1092a;
        }
        p.e(classSerialDescriptorBuilder, "<this>");
        p.e(elementName, "elementName");
        p.e(annotations, "annotations");
        p.i();
        throw null;
    }

    public static final SerialDescriptor getNonNullOriginal(SerialDescriptor serialDescriptor) {
        p.e(serialDescriptor, "<this>");
        return serialDescriptor instanceof SerialDescriptorForNullable ? ((SerialDescriptorForNullable) serialDescriptor).getOriginal() : serialDescriptor;
    }

    public static final SerialDescriptor getNullable(SerialDescriptor serialDescriptor) {
        p.e(serialDescriptor, "<this>");
        return serialDescriptor.isNullable() ? serialDescriptor : new SerialDescriptorForNullable(serialDescriptor);
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor listSerialDescriptor(SerialDescriptor elementDescriptor) {
        p.e(elementDescriptor, "elementDescriptor");
        return new ArrayListClassDesc(elementDescriptor);
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor mapSerialDescriptor(SerialDescriptor keyDescriptor, SerialDescriptor valueDescriptor) {
        p.e(keyDescriptor, "keyDescriptor");
        p.e(valueDescriptor, "valueDescriptor");
        return new HashMapClassDesc(keyDescriptor, valueDescriptor);
    }

    public static final /* synthetic */ <T> SerialDescriptor serialDescriptor() {
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor setSerialDescriptor(SerialDescriptor elementDescriptor) {
        p.e(elementDescriptor, "elementDescriptor");
        return new HashSetClassDesc(elementDescriptor);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> SerialDescriptor listSerialDescriptor() {
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <K, V> SerialDescriptor mapSerialDescriptor() {
        p.i();
        throw null;
    }

    public static final SerialDescriptor serialDescriptor(i type) {
        p.e(type, "type");
        return SerializersKt.serializer(type).getDescriptor();
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> SerialDescriptor setSerialDescriptor() {
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public static /* synthetic */ void getNonNullOriginal$annotations(SerialDescriptor serialDescriptor) {
    }

    public static /* synthetic */ void getNullable$annotations(SerialDescriptor serialDescriptor) {
    }
}
