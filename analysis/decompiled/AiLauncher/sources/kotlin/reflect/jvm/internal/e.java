package kotlin.reflect.jvm.internal;

import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.O;
import E9.W;
import E9.b0;
import H9.C0832k;
import H9.C0837p;
import K9.C0921b;
import K9.C0925f;
import La.D;
import La.H;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ka.C4828h;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.z;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.km.Attributes;
import kotlin.reflect.jvm.internal.impl.km.ClassKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.u;
import o9.C5013a;
import ra.AbstractC5233f;
import ra.InterfaceC5238k;
import ua.C5601K;
import w9.InterfaceC5744c;
import w9.InterfaceC5745d;
import w9.InterfaceC5748g;
import w9.InterfaceC5752k;
import w9.InterfaceC5756o;
import xa.InterfaceC5869l;
import ya.AbstractC5990d0;
import ya.S;
import z9.C6378A;
import z9.C6379B;
import z9.C6380C;
import z9.C6381D;
import z9.C6382E;
import z9.C6383F;
import z9.C6384G;
import z9.C6385H;
import z9.C6386I;
import z9.C6387J;
import z9.C6388K;
import z9.C6389L;
import z9.C6390M;
import z9.C6391N;
import z9.C6392O;
import z9.C6393P;
import z9.C6394Q;
import z9.C6395S;
import z9.C6396T;
import z9.C6397U;
import z9.C6398V;
import z9.C6399W;
import z9.C6453z;
import z9.InterfaceC6400X;
import z9.N0;
import z9.O0;
import z9.c1;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 D*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u00052\u00020\u0006:\u00026jB\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b$\u0010\"J\u000f\u0010%\u001a\u00020\u001bH\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R'\u00104\u001a\u0012\u0012\u000e\u0012\f0/R\b\u0012\u0004\u0012\u00028\u00000\u00000.8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u0002090\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00107R\u0016\u0010=\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010)R\u0016\u0010?\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010)R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@0\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u00107R\u001e\u0010C\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u00107R\u0016\u0010F\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020H0G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010MR\u0014\u0010R\u001a\u00020 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010MR\u0014\u0010U\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010Y\u001a\u0004\u0018\u00010V8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010_\u001a\u00020\\8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020`8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bd\u0010bR\u0014\u0010i\u001a\u00020f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010h¨\u0006k"}, d2 = {"Lkotlin/reflect/jvm/internal/e;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lw9/d;", "Lz9/X;", "Lz9/N0;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "Lga/b;", "classId", "LJ9/k;", "moduleData", "LE9/b;", "Y", "(Lga/b;LJ9/k;)LE9/b;", "X", "Lga/e;", "name", "", "LE9/O;", "M", "(Lga/e;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "I", "", "index", "J", "(I)LE9/O;", UxipConstants.f30680s, "", "k", "(Ljava/lang/Object;)Z", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "Ljava/lang/Class;", "m", "()Ljava/lang/Class;", "LY8/h;", "Lkotlin/reflect/jvm/internal/e$b;", "e", "LY8/h;", "c0", "()LY8/h;", "data", "Lw9/c;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Collection;", "members", "Lkotlin/reflect/jvm/internal/impl/descriptors/c;", "H", "constructorDescriptors", "t", "simpleName", "n", "qualifiedName", "Lw9/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "constructors", "nestedClasses", "f", "()Ljava/lang/Object;", "objectInstance", "", "Lw9/o;", "getTypeParameters", "()Ljava/util/List;", "typeParameters", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "isCompanion", "q", "isValue", "i0", "isInline", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "LN9/d;", "getKmClass", "()Lkotlin/metadata/KmClass;", "kmClass", "getClassId", "()Lorg/jetbrains/kotlin/name/ClassId;", "Lkotlin/reflect/jvm/internal/impl/km/ClassKind;", "getClassKind$kotlin_reflection", "()Lkotlin/metadata/ClassKind;", "classKind", "Lra/k;", "getMemberScope$kotlin_reflection", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "memberScope", "getStaticScope$kotlin_reflection", "staticScope", "Lkotlin/reflect/jvm/internal/impl/km/Modality;", "getModality", "()Lkotlin/metadata/Modality;", "modality", Const.INTENT_KEY_APIKEY, "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e<T> extends KDeclarationContainerImpl implements InterfaceC5745d<T>, InterfaceC6400X, N0 {

    /* renamed from: g, reason: collision with root package name */
    public static final Set<String> f34910g;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Class<T> jClass;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<e<T>.b> data;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u000b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\"\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u001eR-\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000$0#8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0012\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R%\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0012\u001a\u0004\b-\u0010'R#\u00103\u001a\u0004\u0018\u00018\u00008FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\b/\u0010\f\u0012\u0004\b2\u0010)\u001a\u0004\b0\u00101R!\u00107\u001a\b\u0012\u0004\u0012\u0002040\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0012\u001a\u0004\b6\u0010\u001aR!\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u0012\u001a\u0004\b:\u0010\u001aR)\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000+0\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0012\u001a\u0004\b=\u0010\u001aR%\u0010B\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0012\u001a\u0004\bA\u0010'R%\u0010E\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0012\u001a\u0004\bD\u0010'R%\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0012\u001a\u0004\bG\u0010'R%\u0010K\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0012\u001a\u0004\bJ\u0010'R%\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0012\u001a\u0004\bM\u0010'R%\u0010Q\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0012\u001a\u0004\bP\u0010'R%\u0010T\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0012\u001a\u0004\bS\u0010'R%\u0010W\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030?0#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0012\u001a\u0004\bV\u0010'¨\u0006X"}, d2 = {"Lkotlin/reflect/jvm/internal/e$b;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$b;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/e;)V", "Ljava/lang/Class;", "jClass", "", "C", "(Ljava/lang/Class;)Ljava/lang/String;", "LN9/d;", Const.INTENT_KEY_UMID, "LY8/h;", "getKmClass", "()Lkotlin/metadata/KmClass;", "kmClass", "LE9/b;", "e", "Lkotlin/reflect/jvm/internal/u$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor", "", "", "f", "getAnnotations", "()Ljava/util/List;", "annotations", Const.INTENT_KEY_BACKGROUND_COMMAND, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Ljava/lang/String;", "simpleName", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "U", "qualifiedName", "", "Lw9/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "L", "()Ljava/util/Collection;", "getConstructors$annotations", "()V", "constructors", "Lw9/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, ExifInterface.LATITUDE_SOUTH, "nestedClasses", "k", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "getObjectInstance$annotations", "objectInstance", "Lw9/o;", "l", ExifInterface.LONGITUDE_WEST, "typeParameters", "Lw9/n;", "m", "getSupertypes", "supertypes", "n", "getSealedSubclasses", "sealedSubclasses", "Lkotlin/reflect/jvm/internal/d;", "o", "M", "declaredNonStaticMembers", "p", "N", "declaredStaticMembers", "q", "P", "inheritedNonStaticMembers", "r", "Q", "inheritedStaticMembers", "s", "J", "allNonStaticMembers", "t", "K", "allStaticMembers", "u", "getDeclaredMembers", "declaredMembers", "v", "I", "allMembers", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b extends KDeclarationContainerImpl.b {

        /* renamed from: x, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC5752k<Object>[] f34913x = {kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "annotations", "getAnnotations()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "constructors", "getConstructors()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "supertypes", "getSupertypes()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0)), kotlin.jvm.internal.t.i(new PropertyReference1Impl(b.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0))};

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final Y8.h kmClass;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final u.a descriptor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final u.a annotations;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final u.a simpleName;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final u.a qualifiedName;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public final u.a constructors;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public final u.a nestedClasses;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        public final Y8.h objectInstance;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        public final u.a typeParameters;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        public final u.a supertypes;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        public final u.a sealedSubclasses;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        public final u.a declaredNonStaticMembers;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        public final u.a declaredStaticMembers;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        public final u.a inheritedNonStaticMembers;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        public final u.a inheritedStaticMembers;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        public final u.a allNonStaticMembers;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        public final u.a allStaticMembers;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        public final u.a declaredMembers;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        public final u.a allMembers;

        public b() {
            super();
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            this.kmClass = C4848b.a(lazyThreadSafetyMode, new C6379B(this));
            this.descriptor = u.c(new C6390M(e.this));
            this.annotations = u.c(new C6392O(e.this));
            this.simpleName = u.c(new C6393P(e.this, this));
            this.qualifiedName = u.c(new C6394Q(e.this));
            this.constructors = u.c(new C6395S(e.this));
            this.nestedClasses = u.c(new C6396T(this, e.this));
            this.objectInstance = C4848b.a(lazyThreadSafetyMode, new C6397U(this, e.this));
            this.typeParameters = u.c(new C6398V(this, e.this));
            this.supertypes = u.c(new C6399W(this, e.this));
            this.sealedSubclasses = u.c(new C6380C(e.this, this));
            this.declaredNonStaticMembers = u.c(new C6381D(e.this));
            this.declaredStaticMembers = u.c(new C6382E(e.this));
            this.inheritedNonStaticMembers = u.c(new C6383F(e.this));
            this.inheritedStaticMembers = u.c(new C6384G(e.this));
            this.allNonStaticMembers = u.c(new C6385H(this));
            this.allStaticMembers = u.c(new C6386I(this));
            this.declaredMembers = u.c(new C6387J(this));
            this.allMembers = u.c(new C6388K(this));
        }

        public static final List A(b bVar) {
            return F.S0(bVar.N(), bVar.Q());
        }

        public static final List B(e eVar) {
            Annotation[] annotations = eVar.m().getAnnotations();
            kotlin.jvm.internal.p.h(annotations, "getAnnotations(...)");
            ArrayList arrayList = new ArrayList();
            for (Annotation annotation : annotations) {
                if (!e.f34910g.contains(C5013a.b(C5013a.a(annotation)).getName())) {
                    arrayList.add(annotation);
                }
            }
            return c1.u(arrayList);
        }

        public static final List D(e eVar) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> collectionH = eVar.H();
            ArrayList arrayList = new ArrayList(C1174w.x(collectionH, 10));
            Iterator<T> it = collectionH.iterator();
            while (it.hasNext()) {
                arrayList.add(new f(eVar, (kotlin.reflect.jvm.internal.impl.descriptors.c) it.next()));
            }
            return arrayList;
        }

        public static final List E(b bVar) {
            return F.S0(bVar.M(), bVar.N());
        }

        public static final Collection F(e eVar) {
            return eVar.K(eVar.g0(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        public static final Collection G(e eVar) {
            return eVar.K(eVar.h0(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        public static final InterfaceC0797b H(e eVar) {
            ga.b bVarA0 = eVar.a0();
            J9.k kVarB = eVar.c0().getValue().b();
            InterfaceC0797b interfaceC0797bB = (bVarA0.i() && eVar.m().isAnnotationPresent(Metadata.class)) ? kVarB.a().b(bVarA0) : FindClassInModuleKt.b(kVarB.b(), bVarA0);
            return interfaceC0797bB == null ? eVar.Y(bVarA0, kVarB) : interfaceC0797bB;
        }

        public static final Collection X(e eVar) {
            return eVar.K(eVar.g0(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        public static final Collection Y(e eVar) {
            return eVar.K(eVar.h0(), KDeclarationContainerImpl.MemberBelonginess.INHERITED);
        }

        public static final N9.d Z(b bVar) {
            InterfaceC0797b interfaceC0797bO = bVar.O();
            DeserializedClassDescriptor deserializedClassDescriptor = interfaceC0797bO instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) interfaceC0797bO : null;
            if (deserializedClassDescriptor != null) {
                return O9.f.j(deserializedClassDescriptor.Y0(), deserializedClassDescriptor.X0().g(), false, null, 6, null);
            }
            return null;
        }

        public static final List a0(b bVar, e eVar) {
            N9.d dVarR = bVar.R();
            if (dVarR == null) {
                Class<?>[] declaredClasses = eVar.m().getDeclaredClasses();
                kotlin.jvm.internal.p.h(declaredClasses, "getDeclaredClasses(...)");
                ArrayList arrayList = new ArrayList();
                for (Class<?> cls : declaredClasses) {
                    kotlin.jvm.internal.p.f(cls);
                    InterfaceC5745d interfaceC5745dE = C5013a.e(cls);
                    if (interfaceC5745dE != null) {
                        arrayList.add(interfaceC5745dE);
                    }
                }
                return arrayList;
            }
            ga.b bVarB = O0.b(dVarR.l());
            ClassLoader classLoaderJ = C0925f.j(eVar.m());
            List<String> listM = dVarR.m();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listM.iterator();
            while (it.hasNext()) {
                ga.e eVarJ = ga.e.j((String) it.next());
                kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
                Class clsP = c1.p(classLoaderJ, bVarB.d(eVarJ), 0, 2, null);
                InterfaceC5745d interfaceC5745dE2 = clsP != null ? C5013a.e(clsP) : null;
                if (interfaceC5745dE2 != null) {
                    arrayList2.add(interfaceC5745dE2);
                }
            }
            return arrayList2;
        }

        public static final Object b0(b bVar, e eVar) throws IllegalAccessException, IllegalArgumentException {
            N9.d dVarR = bVar.R();
            if (dVarR == null || !(Attributes.a(dVarR) == ClassKind.OBJECT || Attributes.a(dVarR) == ClassKind.COMPANION_OBJECT)) {
                return null;
            }
            Object obj = ((Attributes.a(dVarR) != ClassKind.COMPANION_OBJECT || F.f0(C9.d.f1773a.b(), O0.b(dVarR.l()).e())) ? eVar.m().getDeclaredField("INSTANCE") : eVar.m().getEnclosingClass().getDeclaredField(O0.c(dVarR.l()))).get(null);
            kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
            return obj;
        }

        public static final String c0(e eVar) {
            if (eVar.m().isAnonymousClass()) {
                return null;
            }
            ga.b bVarA0 = eVar.a0();
            if (bVarA0.i()) {
                return null;
            }
            return bVarA0.a().a();
        }

        public static final List d0(e eVar, b bVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            List listM;
            ClassLoader classLoaderJ = C0925f.j(eVar.m());
            N9.d dVarR = bVar.R();
            if (dVarR != null) {
                List<String> listN = dVarR.n();
                listM = new ArrayList();
                Iterator<T> it = listN.iterator();
                while (it.hasNext()) {
                    InterfaceC5745d<?> interfaceC5745dA = O0.a(classLoaderJ, (String) it.next());
                    if (interfaceC5745dA != null) {
                        listM.add(interfaceC5745dA);
                    }
                }
            } else {
                C0921b c0921b = C0921b.f4159a;
                if (kotlin.jvm.internal.p.d(c0921b.f(eVar.m()), Boolean.TRUE)) {
                    Class<?>[] clsArrC = c0921b.c(eVar.m());
                    if (clsArrC != null) {
                        listM = new ArrayList(clsArrC.length);
                        for (Class<?> cls : clsArrC) {
                            listM.add(C5013a.e(cls));
                        }
                    } else {
                        listM = null;
                    }
                    if (listM == null) {
                        listM = C1173v.m();
                    }
                } else {
                    listM = C1173v.m();
                }
            }
            kotlin.jvm.internal.p.g(listM, "null cannot be cast to non-null type kotlin.collections.List<kotlin.reflect.KClass<out T of kotlin.reflect.jvm.internal.KClassImpl>>");
            return listM;
        }

        public static final String e0(e eVar, b bVar) {
            if (eVar.m().isAnonymousClass()) {
                return null;
            }
            ga.b bVarA0 = eVar.a0();
            if (bVarA0.i()) {
                return bVar.C(eVar.m());
            }
            String strB = bVarA0.h().b();
            kotlin.jvm.internal.p.h(strB, "asString(...)");
            return strB;
        }

        public static final List f0(b bVar, e eVar) {
            Collection<S> collectionE = bVar.O().j().e();
            kotlin.jvm.internal.p.h(collectionE, "getSupertypes(...)");
            ArrayList arrayList = new ArrayList(collectionE.size());
            for (S s10 : collectionE) {
                kotlin.jvm.internal.p.f(s10);
                arrayList.add(new s(s10, new C6389L(s10, bVar, eVar)));
            }
            if (!C9.j.v0(bVar.O())) {
                if (arrayList.isEmpty()) {
                    AbstractC5990d0 abstractC5990d0I = DescriptorUtilsKt.m(bVar.O()).i();
                    kotlin.jvm.internal.p.h(abstractC5990d0I, "getAnyType(...)");
                    arrayList.add(new s(abstractC5990d0I, C6391N.f45311a));
                } else {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind kind = C4828h.e(((s) it.next()).getType()).getKind();
                        kotlin.jvm.internal.p.h(kind, "getKind(...)");
                        if (kind != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE && kind != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS) {
                            break;
                        }
                    }
                    AbstractC5990d0 abstractC5990d0I2 = DescriptorUtilsKt.m(bVar.O()).i();
                    kotlin.jvm.internal.p.h(abstractC5990d0I2, "getAnyType(...)");
                    arrayList.add(new s(abstractC5990d0I2, C6391N.f45311a));
                }
            }
            return Ia.a.c(arrayList);
        }

        public static final Type g0(S s10, b bVar, e eVar) {
            InterfaceC0799d interfaceC0799dD = s10.H0().d();
            if (!(interfaceC0799dD instanceof InterfaceC0797b)) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + interfaceC0799dD);
            }
            Class<?> clsR = c1.r((InterfaceC0797b) interfaceC0799dD);
            if (clsR == null) {
                throw new KotlinReflectionInternalError("Unsupported superclass of " + bVar + ": " + interfaceC0799dD);
            }
            if (kotlin.jvm.internal.p.d(eVar.m().getSuperclass(), clsR)) {
                Type genericSuperclass = eVar.m().getGenericSuperclass();
                kotlin.jvm.internal.p.f(genericSuperclass);
                return genericSuperclass;
            }
            Class<?>[] interfaces = eVar.m().getInterfaces();
            kotlin.jvm.internal.p.h(interfaces, "getInterfaces(...)");
            int iO0 = Z8.r.o0(interfaces, clsR);
            if (iO0 >= 0) {
                Type type = eVar.m().getGenericInterfaces()[iO0];
                kotlin.jvm.internal.p.f(type);
                return type;
            }
            throw new KotlinReflectionInternalError("No superclass of " + bVar + " in Java reflection for " + interfaceC0799dD);
        }

        public static final Type h0() {
            return Object.class;
        }

        public static final List i0(b bVar, e eVar) {
            List<b0> listO = bVar.O().o();
            kotlin.jvm.internal.p.h(listO, "getDeclaredTypeParameters(...)");
            List<b0> list = listO;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            for (b0 b0Var : list) {
                kotlin.jvm.internal.p.f(b0Var);
                arrayList.add(new t(eVar, b0Var));
            }
            return arrayList;
        }

        public static final List y(b bVar) {
            return F.S0(bVar.J(), bVar.K());
        }

        public static final List z(b bVar) {
            return F.S0(bVar.M(), bVar.P());
        }

        public final String C(Class<?> jClass) {
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                kotlin.jvm.internal.p.f(simpleName);
                return H.p1(simpleName, enclosingMethod.getName() + '$', null, 2, null);
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                kotlin.jvm.internal.p.f(simpleName);
                return H.o1(simpleName, '$', null, 2, null);
            }
            kotlin.jvm.internal.p.f(simpleName);
            return H.p1(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
        }

        public final Collection<kotlin.reflect.jvm.internal.d<?>> I() {
            T tB = this.allMembers.b(this, f34913x[16]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.d<?>> J() {
            T tB = this.allNonStaticMembers.b(this, f34913x[13]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.d<?>> K() {
            T tB = this.allStaticMembers.b(this, f34913x[14]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final Collection<InterfaceC5748g<T>> L() {
            T tB = this.constructors.b(this, f34913x[4]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.d<?>> M() {
            T tB = this.declaredNonStaticMembers.b(this, f34913x[9]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.d<?>> N() {
            T tB = this.declaredStaticMembers.b(this, f34913x[10]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final InterfaceC0797b O() {
            T tB = this.descriptor.b(this, f34913x[0]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (InterfaceC0797b) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.d<?>> P() {
            T tB = this.inheritedNonStaticMembers.b(this, f34913x[11]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final Collection<kotlin.reflect.jvm.internal.d<?>> Q() {
            T tB = this.inheritedStaticMembers.b(this, f34913x[12]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final N9.d R() {
            return (N9.d) this.kmClass.getValue();
        }

        public final Collection<InterfaceC5745d<?>> S() {
            T tB = this.nestedClasses.b(this, f34913x[5]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (Collection) tB;
        }

        public final T T() {
            return (T) this.objectInstance.getValue();
        }

        public final String U() {
            return (String) this.qualifiedName.b(this, f34913x[3]);
        }

        public final String V() {
            return (String) this.simpleName.b(this, f34913x[2]);
        }

        public final List<InterfaceC5756o> W() {
            T tB = this.typeParameters.b(this, f34913x[6]);
            kotlin.jvm.internal.p.h(tB, "getValue(...)");
            return (List) tB;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34934a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KotlinClassHeader.Kind.SYNTHETIC_CLASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KotlinClassHeader.Kind.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KotlinClassHeader.Kind.CLASS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f34934a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlin/reflect/jvm/internal/e$d", "Lra/f;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/List;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends AbstractC5233f {
        public d(C0832k c0832k, InterfaceC5869l interfaceC5869l) {
            super(interfaceC5869l, c0832k);
        }

        @Override // ra.AbstractC5233f
        public List<kotlin.reflect.jvm.internal.impl.descriptors.e> i() {
            return C1173v.m();
        }
    }

    static {
        Set<ga.b> setB = B9.a.f1474a.b();
        HashSet hashSet = new HashSet();
        Iterator<T> it = setB.iterator();
        while (it.hasNext()) {
            hashSet.add(((ga.b) it.next()).a().toString());
        }
        f34910g = hashSet;
    }

    public e(Class<T> jClass) {
        kotlin.jvm.internal.p.i(jClass, "jClass");
        this.jClass = jClass;
        this.data = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6453z(this));
    }

    public static final b Z(e eVar) {
        return new b();
    }

    public static final O f0(C5601K deserializeToDescriptor, ProtoBuf$Property proto) {
        kotlin.jvm.internal.p.i(deserializeToDescriptor, "$this$deserializeToDescriptor");
        kotlin.jvm.internal.p.i(proto, "proto");
        return deserializeToDescriptor.x(proto, true);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> H() {
        InterfaceC0797b descriptor = getDescriptor();
        if (descriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE || descriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.OBJECT) {
            return C1173v.m();
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collectionH = descriptor.h();
        kotlin.jvm.internal.p.h(collectionH, "getConstructors(...)");
        return collectionH;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> I(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        InterfaceC5238k interfaceC5238kG0 = g0();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return F.S0(interfaceC5238kG0.c(name, noLookupLocation), h0().c(name, noLookupLocation));
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public O J(int index) {
        Class<?> declaringClass;
        if (kotlin.jvm.internal.p.d(m().getSimpleName(), "DefaultImpls") && (declaringClass = m().getDeclaringClass()) != null && declaringClass.isInterface()) {
            InterfaceC5745d interfaceC5745dE = C5013a.e(declaringClass);
            kotlin.jvm.internal.p.g(interfaceC5745dE, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            return ((e) interfaceC5745dE).J(index);
        }
        InterfaceC0797b descriptor = getDescriptor();
        DeserializedClassDescriptor deserializedClassDescriptor = descriptor instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) descriptor : null;
        if (deserializedClassDescriptor != null) {
            ProtoBuf$Class protoBuf$ClassY0 = deserializedClassDescriptor.Y0();
            GeneratedMessageLite.e<ProtoBuf$Class, List<ProtoBuf$Property>> classLocalVariable = JvmProtoBuf.f35747j;
            kotlin.jvm.internal.p.h(classLocalVariable, "classLocalVariable");
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) ea.f.b(protoBuf$ClassY0, classLocalVariable, index);
            if (protoBuf$Property != null) {
                return (O) c1.h(m(), protoBuf$Property, deserializedClassDescriptor.X0().g(), deserializedClassDescriptor.X0().j(), deserializedClassDescriptor.a1(), C6378A.f45278a);
            }
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<O> M(ga.e name) {
        kotlin.jvm.internal.p.i(name, "name");
        InterfaceC5238k interfaceC5238kG0 = g0();
        NoLookupLocation noLookupLocation = NoLookupLocation.FROM_REFLECTION;
        return F.S0(interfaceC5238kG0.a(name, noLookupLocation), h0().a(name, noLookupLocation));
    }

    public final InterfaceC0797b X(ga.b classId, J9.k moduleData) {
        C0832k c0832k = new C0832k(new C0837p(moduleData.b(), classId.f()), classId.h(), Modality.FINAL, kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS, C1172u.e(moduleData.b().g().h().n()), W.f2444a, false, moduleData.a().u());
        c0832k.E0(new d(c0832k, moduleData.a().u()), Y.e(), null);
        return c0832k;
    }

    public final InterfaceC0797b Y(ga.b classId, J9.k moduleData) {
        KotlinClassHeader kotlinClassHeaderB;
        if (m().isSynthetic()) {
            return X(classId, moduleData);
        }
        J9.f fVarA = J9.f.f3793c.a(m());
        KotlinClassHeader.Kind kindC = (fVarA == null || (kotlinClassHeaderB = fVarA.b()) == null) ? null : kotlinClassHeaderB.c();
        switch (kindC == null ? -1 : c.f34934a[kindC.ordinal()]) {
            case -1:
            case 6:
                throw new KotlinReflectionInternalError("Unresolved class: " + m() + " (kind = " + kindC + ')');
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
            case 2:
            case 3:
            case 4:
                return X(classId, moduleData);
            case 5:
                throw new KotlinReflectionInternalError("Unknown class: " + m() + " (kind = " + kindC + ')');
        }
    }

    public final ga.b a0() {
        return v.f36168a.c(m());
    }

    @Override // w9.InterfaceC5747f
    public Collection<InterfaceC5744c<?>> b() {
        return this.data.getValue().I();
    }

    public final ClassKind b0() {
        ClassKind classKindA;
        N9.d dVarE0 = e0();
        return (dVarE0 == null || (classKindA = Attributes.a(dVarE0)) == null) ? m().isAnnotation() ? ClassKind.ANNOTATION_CLASS : m().isInterface() ? ClassKind.INTERFACE : m().isEnum() ? ClassKind.ENUM_CLASS : m().getSuperclass().isEnum() ? ClassKind.ENUM_ENTRY : ClassKind.CLASS : classKindA;
    }

    public final Y8.h<e<T>.b> c0() {
        return this.data;
    }

    @Override // w9.InterfaceC5745d
    public Collection<InterfaceC5745d<?>> d() {
        return this.data.getValue().S();
    }

    @Override // z9.InterfaceC6400X
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public InterfaceC0797b getDescriptor() {
        return this.data.getValue().O();
    }

    public final N9.d e0() {
        return this.data.getValue().R();
    }

    public boolean equals(Object other) {
        return (other instanceof e) && kotlin.jvm.internal.p.d(C5013a.c(this), C5013a.c((InterfaceC5745d) other));
    }

    @Override // w9.InterfaceC5745d
    public T f() {
        return this.data.getValue().T();
    }

    public final InterfaceC5238k g0() {
        return getDescriptor().n().m();
    }

    @Override // w9.InterfaceC5745d
    public List<InterfaceC5756o> getTypeParameters() {
        return this.data.getValue().W();
    }

    @Override // w9.InterfaceC5745d
    public Collection<InterfaceC5748g<T>> h() {
        return this.data.getValue().L();
    }

    public final InterfaceC5238k h0() {
        InterfaceC5238k interfaceC5238kG0 = getDescriptor().g0();
        kotlin.jvm.internal.p.h(interfaceC5238kG0, "getStaticScope(...)");
        return interfaceC5238kG0;
    }

    @Override // w9.InterfaceC5745d
    public int hashCode() {
        return C5013a.c(this).hashCode();
    }

    public final boolean i0() {
        N9.d dVarE0 = e0();
        return (dVarE0 != null ? dVarE0.j() : null) != null;
    }

    @Override // w9.InterfaceC5745d
    public boolean j() {
        N9.d dVarE0 = e0();
        return (dVarE0 != null ? Attributes.a(dVarE0) : null) == ClassKind.COMPANION_OBJECT;
    }

    @Override // w9.InterfaceC5745d
    public boolean k(Object value) {
        Integer numG = C0925f.g(m());
        if (numG != null) {
            return z.o(value, numG.intValue());
        }
        Class clsK = C0925f.k(m());
        if (clsK == null) {
            clsK = m();
        }
        return clsK.isInstance(value);
    }

    @Override // kotlin.jvm.internal.f
    public Class<T> m() {
        return this.jClass;
    }

    @Override // w9.InterfaceC5745d
    public String n() {
        return this.data.getValue().U();
    }

    @Override // w9.InterfaceC5745d
    public boolean q() {
        N9.d dVarE0 = e0();
        return dVarE0 != null && Attributes.b(dVarE0);
    }

    @Override // w9.InterfaceC5745d
    public String t() {
        return this.data.getValue().V();
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("class ");
        ga.b bVarA0 = a0();
        ga.c cVarF = bVarA0.f();
        if (cVarF.c()) {
            str = "";
        } else {
            str = cVarF.a() + '.';
        }
        sb2.append(str + D.S(bVarA0.g().a(), '.', '$', false, 4, null));
        return sb2.toString();
    }
}
