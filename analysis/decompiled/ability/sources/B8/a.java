package B8;

import H8.AbstractC0242c;
import H8.C0245f;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes;

/* loaded from: classes4.dex */
public final class a extends AbstractC0242c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f196a;

    public /* synthetic */ a(int i) {
        this.f196a = i;
    }

    @Override // H8.t
    public final Object a(C0245f c0245f, H8.h hVar) {
        switch (this.f196a) {
            case 0:
                return new ProtoBuf$Annotation(c0245f, hVar);
            case 1:
                return new ProtoBuf$Class(c0245f, hVar);
            case 2:
                return new ProtoBuf$Constructor(c0245f, hVar);
            case 3:
                return new ProtoBuf$Contract(c0245f, hVar);
            case 4:
                return new ProtoBuf$Effect(c0245f, hVar);
            case 5:
                return new ProtoBuf$EnumEntry(c0245f, hVar);
            case 6:
                return new ProtoBuf$Expression(c0245f, hVar);
            case 7:
                return new ProtoBuf$Function(c0245f, hVar);
            case 8:
                return new ProtoBuf$Package(c0245f, hVar);
            case 9:
                return new ProtoBuf$PackageFragment(c0245f, hVar);
            case 10:
                return new ProtoBuf$Property(c0245f, hVar);
            case 11:
                return new ProtoBuf$QualifiedNameTable(c0245f, hVar);
            case 12:
                return new ProtoBuf$StringTable(c0245f);
            case 13:
                return new ProtoBuf$Type(c0245f, hVar);
            case 14:
                return new ProtoBuf$TypeAlias(c0245f, hVar);
            case 15:
                return new ProtoBuf$TypeParameter(c0245f, hVar);
            case 16:
                return new ProtoBuf$TypeTable(c0245f, hVar);
            case 17:
                return new ProtoBuf$ValueParameter(c0245f, hVar);
            case 18:
                return new ProtoBuf$VersionRequirement(c0245f);
            case 19:
                return new ProtoBuf$VersionRequirementTable(c0245f, hVar);
            case 20:
                return new JvmProtoBuf$JvmFieldSignature(c0245f);
            case 21:
                return new JvmProtoBuf$JvmMethodSignature(c0245f);
            case 22:
                return new JvmProtoBuf$JvmPropertySignature(c0245f, hVar);
            default:
                return new JvmProtoBuf$StringTableTypes(c0245f, hVar);
        }
    }
}
