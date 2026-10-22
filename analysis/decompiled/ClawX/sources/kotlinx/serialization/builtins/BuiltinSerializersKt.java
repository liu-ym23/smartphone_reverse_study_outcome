package kotlinx.serialization.builtins;

import b5.a0;
import b5.g;
import b5.l;
import b5.m;
import b5.n;
import b5.q;
import b5.s;
import b5.t;
import b5.u;
import b5.v;
import b5.x;
import b5.y;
import b5.z;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.b;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.r;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanArraySerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharArraySerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleArraySerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.InstantSerializer;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.LongArraySerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.NothingSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.ShortArraySerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.UByteArraySerializer;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntArraySerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongArraySerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortArraySerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.internal.UnitSerializer;
import kotlinx.serialization.internal.UuidSerializer;
import v5.c;
import y5.a;
import y5.e;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u001aD\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\t0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0086\u0080\u0004\u001aD\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\u000f0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0086\u0080\u0004\u001a^\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u00110\u0001\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001aH\u0086\u0080\u0004\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u001eH\u0086\u0080\u0004\u001a\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0001H\u0086\u0080\u0004\u001a\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020$H\u0086\u0080\u0004\u001a\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0001H\u0086\u0080\u0004\u001a\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*H\u0086\u0080\u0004\u001a\u0010\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0001H\u0086\u0080\u0004\u001a\u0010\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u000200H\u0086\u0080\u0004\u001a\u0010\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0001H\u0086\u0080\u0004\u001a\u0010\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002050\u0001*\u000206H\u0086\u0080\u0004\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002090\u0001*\u00020:H\u0086\u0080\u0004\u001a\u0010\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u0001H\u0086\u0080\u0004\u001a\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020=0\u0001*\u00020>H\u0086\u0080\u0004¢\u0006\u0002\u0010?\u001a\u0010\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0001H\u0086\u0080\u0004\u001a\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020B0\u0001*\u00020BH\u0086\u0080\u0004¢\u0006\u0002\u0010C\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020D0\u0001*\u00020EH\u0086\u0080\u0004\u001a>\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HH0G0\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\f\b\u0001\u0010H\u0018\u0001*\u0004\u0018\u0001H\u00022\f\u0010I\u001a\b\u0012\u0004\u0012\u0002HH0\u0001H\u0087\u0088\u0004\u001aH\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HH0G0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010H*\u0004\u0018\u0001H\u00022\f\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00020K2\f\u0010I\u001a\b\u0012\u0004\u0012\u0002HH0\u0001H\u0087\u0080\u0004\u001a*\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020M0\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001a*\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020O0\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001aD\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0Q0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020R0\u0001*\u00020SH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020T0\u0001*\u00020UH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020V0\u0001*\u00020WH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020X0\u0001*\u00020YH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020Z0\u0001*\u00020[H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\\0\u0001*\u00020]H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020^0\u0001*\u00020_H\u0087\u0080\u0004\u001a\u0010\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u0001H\u0087\u0080\u0004\"7\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00018FX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006b"}, d2 = {"nullable", "Lkotlinx/serialization/KSerializer;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "PairSerializer", "Lkotlin/Pair;", "K", "V", "keySerializer", "valueSerializer", "MapEntrySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "TripleSerializer", "Lkotlin/Triple;", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "serializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Char$Companion;", "CharArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Byte$Companion;", "ByteArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "UByteArraySerializer", "Lkotlin/UByteArray;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Short$Companion;", "ShortArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "UShortArraySerializer", "Lkotlin/UShortArray;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Int$Companion;", "IntArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "UIntArraySerializer", "Lkotlin/UIntArray;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Long$Companion;", "LongArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ULongArraySerializer", "Lkotlin/ULongArray;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Float$Companion;", "FloatArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Double$Companion;", "DoubleArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Boolean$Companion;", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "BooleanArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/String$Companion;", "ArraySerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "E", "elementSerializer", "kClass", "Lkotlin/reflect/KClass;", "ListSerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "SetSerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "MapSerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/UInt;", "Lkotlin/UInt$Companion;", "Lkotlin/ULong;", "Lkotlin/ULong$Companion;", "Lkotlin/UByte;", "Lkotlin/UByte$Companion;", "Lkotlin/UShort;", "Lkotlin/UShort$Companion;", "Lkotlin/time/Duration;", "Lkotlin/time/Duration$Companion;", "Lkotlin/time/Instant;", "Lkotlin/time/Instant$Companion;", "Lkotlin/uuid/Uuid;", "Lkotlin/uuid/Uuid$Companion;", "NothingSerializer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BuiltinSerializersKt {
    @ExperimentalSerializationApi
    public static final /* synthetic */ <T, E extends T> KSerializer<E[]> ArraySerializer(KSerializer<E> elementSerializer) {
        p.e(elementSerializer, "elementSerializer");
        p.i();
        throw null;
    }

    public static final KSerializer<boolean[]> BooleanArraySerializer() {
        return BooleanArraySerializer.INSTANCE;
    }

    public static final KSerializer<byte[]> ByteArraySerializer() {
        return ByteArraySerializer.INSTANCE;
    }

    public static final KSerializer<char[]> CharArraySerializer() {
        return CharArraySerializer.INSTANCE;
    }

    public static final KSerializer<double[]> DoubleArraySerializer() {
        return DoubleArraySerializer.INSTANCE;
    }

    public static final KSerializer<float[]> FloatArraySerializer() {
        return FloatArraySerializer.INSTANCE;
    }

    public static final KSerializer<int[]> IntArraySerializer() {
        return IntArraySerializer.INSTANCE;
    }

    public static final <T> KSerializer<List<T>> ListSerializer(KSerializer<T> elementSerializer) {
        p.e(elementSerializer, "elementSerializer");
        return new ArrayListSerializer(elementSerializer);
    }

    public static final KSerializer<long[]> LongArraySerializer() {
        return LongArraySerializer.INSTANCE;
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> MapEntrySerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        p.e(keySerializer, "keySerializer");
        p.e(valueSerializer, "valueSerializer");
        return new MapEntrySerializer(keySerializer, valueSerializer);
    }

    public static final <K, V> KSerializer<Map<K, V>> MapSerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        p.e(keySerializer, "keySerializer");
        p.e(valueSerializer, "valueSerializer");
        return new LinkedHashMapSerializer(keySerializer, valueSerializer);
    }

    @ExperimentalSerializationApi
    public static final KSerializer NothingSerializer() {
        return NothingSerializer.INSTANCE;
    }

    public static final <K, V> KSerializer<g> PairSerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        p.e(keySerializer, "keySerializer");
        p.e(valueSerializer, "valueSerializer");
        return new PairSerializer(keySerializer, valueSerializer);
    }

    public static final <T> KSerializer<Set<T>> SetSerializer(KSerializer<T> elementSerializer) {
        p.e(elementSerializer, "elementSerializer");
        return new LinkedHashSetSerializer(elementSerializer);
    }

    public static final KSerializer<short[]> ShortArraySerializer() {
        return ShortArraySerializer.INSTANCE;
    }

    public static final <A, B, C> KSerializer<l> TripleSerializer(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        p.e(aSerializer, "aSerializer");
        p.e(bSerializer, "bSerializer");
        p.e(cSerializer, "cSerializer");
        return new TripleSerializer(aSerializer, bSerializer, cSerializer);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<b5.p> UByteArraySerializer() {
        return UByteArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<s> UIntArraySerializer() {
        return UIntArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<v> ULongArraySerializer() {
        return ULongArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<z> UShortArraySerializer() {
        return UShortArraySerializer.INSTANCE;
    }

    public static final <T> KSerializer<T> getNullable(KSerializer<T> kSerializer) {
        p.e(kSerializer, "<this>");
        return kSerializer.getDescriptor().isNullable() ? kSerializer : new NullableSerializer(kSerializer);
    }

    public static final KSerializer<Character> serializer(f fVar) {
        p.e(fVar, "<this>");
        return CharSerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final <T, E extends T> KSerializer<E[]> ArraySerializer(c kClass, KSerializer<E> elementSerializer) {
        p.e(kClass, "kClass");
        p.e(elementSerializer, "elementSerializer");
        return new ReferenceArraySerializer(kClass, elementSerializer);
    }

    public static final KSerializer<Byte> serializer(kotlin.jvm.internal.c cVar) {
        p.e(cVar, "<this>");
        return ByteSerializer.INSTANCE;
    }

    public static final KSerializer<Short> serializer(b0 b0Var) {
        p.e(b0Var, "<this>");
        return ShortSerializer.INSTANCE;
    }

    public static final KSerializer<Integer> serializer(o oVar) {
        p.e(oVar, "<this>");
        return IntSerializer.INSTANCE;
    }

    public static final KSerializer<Long> serializer(r rVar) {
        p.e(rVar, "<this>");
        return LongSerializer.INSTANCE;
    }

    public static final KSerializer<Float> serializer(k kVar) {
        p.e(kVar, "<this>");
        return FloatSerializer.INSTANCE;
    }

    public static final KSerializer<Double> serializer(j jVar) {
        p.e(jVar, "<this>");
        return DoubleSerializer.INSTANCE;
    }

    public static final KSerializer<Boolean> serializer(b bVar) {
        p.e(bVar, "<this>");
        return BooleanSerializer.INSTANCE;
    }

    public static final KSerializer<a0> serializer(a0 a0Var) {
        p.e(a0Var, "<this>");
        return UnitSerializer.INSTANCE;
    }

    public static final KSerializer<String> serializer(c0 c0Var) {
        p.e(c0Var, "<this>");
        return StringSerializer.INSTANCE;
    }

    public static final KSerializer<b5.r> serializer(q qVar) {
        p.e(qVar, "<this>");
        return UIntSerializer.INSTANCE;
    }

    public static final KSerializer<u> serializer(t tVar) {
        p.e(tVar, "<this>");
        return ULongSerializer.INSTANCE;
    }

    public static final KSerializer<n> serializer(m mVar) {
        p.e(mVar, "<this>");
        return UByteSerializer.INSTANCE;
    }

    public static final KSerializer<y> serializer(x xVar) {
        p.e(xVar, "<this>");
        return UShortSerializer.INSTANCE;
    }

    public static final KSerializer<y5.b> serializer(a aVar) {
        p.e(aVar, "<this>");
        return DurationSerializer.INSTANCE;
    }

    public static final KSerializer<y5.f> serializer(e eVar) {
        p.e(eVar, "<this>");
        return InstantSerializer.INSTANCE;
    }

    public static final KSerializer<z5.b> serializer(z5.a aVar) {
        p.e(aVar, "<this>");
        return UuidSerializer.INSTANCE;
    }

    public static /* synthetic */ void getNullable$annotations(KSerializer kSerializer) {
    }
}
