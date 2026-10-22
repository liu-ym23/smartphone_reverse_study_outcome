package kotlin.collections.builders;

import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.common.model.AppInfo;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.g0;
import kotlin.collections.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\f\b\u0000\u0018\u0000 \u0092\u0001*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\f\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001BG\b\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u0013J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0017H\u0002¢\u0006\u0004\b&\u0010\u0011J\u0017\u0010(\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b(\u0010\u0013J\u0017\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\fH\u0002¢\u0006\u0004\b*\u0010\u001eJ\u0017\u0010+\u001a\u00020\f2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0004\b+\u0010%J\u0017\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00028\u0001H\u0002¢\u0006\u0004\b-\u0010%J\u0017\u0010/\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010\u0013J\u0017\u00101\u001a\u00020\u00172\u0006\u00100\u001a\u00020\fH\u0002¢\u0006\u0004\b1\u0010\u0013J\u001f\u00104\u001a\u00020\u001c2\u000e\u00103\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000302H\u0002¢\u0006\u0004\b4\u00105J#\u00108\u001a\u00020\u001c2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000106H\u0002¢\u0006\u0004\b8\u00109J)\u0010<\u001a\u00020\u001c2\u0018\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001060:H\u0002¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u001cH\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u001c2\u0006\u0010#\u001a\u00028\u0000H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u001c2\u0006\u0010,\u001a\u00028\u0001H\u0016¢\u0006\u0004\bD\u0010CJ\u001a\u0010E\u001a\u0004\u0018\u00018\u00012\u0006\u0010#\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bE\u0010FJ!\u0010G\u001a\u0004\u0018\u00018\u00012\u0006\u0010#\u001a\u00028\u00002\u0006\u0010,\u001a\u00028\u0001H\u0016¢\u0006\u0004\bG\u0010HJ%\u0010I\u001a\u00020\u00172\u0014\u0010;\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000102H\u0016¢\u0006\u0004\bI\u0010JJ\u0019\u0010K\u001a\u0004\u0018\u00018\u00012\u0006\u0010#\u001a\u00028\u0000H\u0016¢\u0006\u0004\bK\u0010FJ\u000f\u0010L\u001a\u00020\u0017H\u0016¢\u0006\u0004\bL\u0010\u0011J\u001a\u0010M\u001a\u00020\u001c2\b\u00103\u001a\u0004\u0018\u00010\u0014H\u0096\u0002¢\u0006\u0004\bM\u0010CJ\u000f\u0010N\u001a\u00020\fH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010Q\u001a\u00020PH\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020\u0017H\u0000¢\u0006\u0004\bS\u0010\u0011J\u0017\u0010V\u001a\u00020\f2\u0006\u0010#\u001a\u00028\u0000H\u0000¢\u0006\u0004\bU\u0010%J\u0017\u0010X\u001a\u00020\f2\u0006\u0010#\u001a\u00028\u0000H\u0000¢\u0006\u0004\bW\u0010%J#\u0010Z\u001a\u00020\u001c2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000106H\u0000¢\u0006\u0004\bY\u00109J\u001b\u0010]\u001a\u00020\u001c2\n\u0010[\u001a\u0006\u0012\u0002\b\u00030:H\u0000¢\u0006\u0004\b\\\u0010=J#\u0010_\u001a\u00020\u001c2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000106H\u0000¢\u0006\u0004\b^\u00109J\u0017\u0010b\u001a\u00020\u001c2\u0006\u0010`\u001a\u00028\u0001H\u0000¢\u0006\u0004\ba\u0010CJ\u001b\u0010f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010cH\u0000¢\u0006\u0004\bd\u0010eJ\u001b\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010gH\u0000¢\u0006\u0004\bh\u0010iJ\u001b\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010kH\u0000¢\u0006\u0004\bl\u0010mR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010oR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010oR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010pR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010pR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010qR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010qR\u0016\u0010r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010qR\u0016\u0010s\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010qR$\u0010u\u001a\u00020\f2\u0006\u0010t\u001a\u00020\f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bu\u0010q\u001a\u0004\bv\u0010OR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u001e\u0010{\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R$\u0010~\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR(\u0010\u0080\u0001\u001a\u00020\u001c2\u0006\u0010t\u001a\u00020\u001c8\u0000@BX\u0080\u000e¢\u0006\u000f\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0005\b\u0082\u0001\u0010AR\u0016\u0010\u0084\u0001\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010OR\u001e\u0010\u0088\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0085\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001e\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0089\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u008f\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u008d\u00010\u0085\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u0087\u0001R\u0016\u0010\u0091\u0001\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010O¨\u0006\u0099\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "keysArray", "valuesArray", "", "presenceArray", "hashArray", "", "maxProbeDistance", "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "", "writeReplace", "()Ljava/lang/Object;", "", "registerModification", "n", "ensureExtraCapacity", "extraCapacity", "", "shouldCompact", "(I)Z", "minCapacity", "ensureCapacity", "allocateValuesArray", "()[Ljava/lang/Object;", "key", "hash", "(Ljava/lang/Object;)I", "compact", "newHashSize", "rehash", "i", "putRehash", "findKey", CommonKey.KEY_VALUE, "findValue", SlideCard.KEY_INDEX, "removeKeyAt", "removedHash", "removeHashAt", "", AppInfo.SEARCH_SOURCE_EXTENAL, "contentEquals", "(Ljava/util/Map;)Z", "", "entry", "putEntry", "(Ljava/util/Map$Entry;)Z", "", "from", "putAllEntries", "(Ljava/util/Collection;)Z", "build", "()Ljava/util/Map;", "isEmpty", "()Z", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "(Ljava/util/Map;)V", "remove", "clear", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "checkIsMutable$kotlin_stdlib", "checkIsMutable", "addKey$kotlin_stdlib", "addKey", "removeKey$kotlin_stdlib", "removeKey", "containsEntry$kotlin_stdlib", "containsEntry", "m", "containsAllEntries$kotlin_stdlib", "containsAllEntries", "removeEntry$kotlin_stdlib", "removeEntry", "element", "removeValue$kotlin_stdlib", "removeValue", "Lkotlin/collections/builders/MapBuilder$e;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$e;", "keysIterator", "Lkotlin/collections/builders/MapBuilder$f;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$f;", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$b;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$b;", "entriesIterator", "[Ljava/lang/Object;", "[I", "I", "hashShift", "modCount", "<set-?>", "size", "getSize", "Lkotlin/collections/builders/d;", "keysView", "Lkotlin/collections/builders/d;", "Lkotlin/collections/builders/e;", "valuesView", "Lkotlin/collections/builders/e;", "Lkotlin/collections/builders/c;", "entriesView", "Lkotlin/collections/builders/c;", "isReadOnly", "Z", "isReadOnly$kotlin_stdlib", "getHashSize", "hashSize", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "", "getEntries", "entries", "getCapacity$kotlin_stdlib", PerfConsts.KEY_CURRENT_CAPACITY, "Companion", "a", "b", "c", "d", "e", "f", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,727:1\n1#2:728\n*E\n"})
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {

    @NotNull
    public static final a Companion = null;

    @NotNull
    private static final MapBuilder Empty = null;
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;

    @Nullable
    private kotlin.collections.builders.c entriesView;

    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;

    @NotNull
    private K[] keysArray;

    @Nullable
    private kotlin.collections.builders.d keysView;
    private int length;
    private int maxProbeDistance;
    private int modCount;

    @NotNull
    private int[] presenceArray;
    private int size;

    @Nullable
    private V[] valuesArray;

    @Nullable
    private kotlin.collections.builders.e valuesView;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ int a(a r10, int r11) {
            return r10.c(r11);
        }

        public static final /* synthetic */ int b(a r10, int r11) {
            return r10.d(r11);
        }

        public final int c(int r10) {
            return Integer.highestOneBit(h.d(r10, 1) * 3);
        }

        public final int d(int r10) {
            return Integer.numberOfLeadingZeros(r10) + 1;
        }

        public final MapBuilder e() {
            return MapBuilder.access$getEmpty$cp();
        }

        public a() {
        }
    }

    public static final class b extends d implements Iterator, KMutableIterator {
        public b(MapBuilder r10) {
            q.g(r10, "map");
            super(r10);
        }

        public c h() {
            a();
            if (b() >= MapBuilder.access$getLength$p(d())) goto L7;
            int r10 = b();
            f(r10 + 1);
            g(r10);
            c r11 = new c(d(), c());
            e();
            return r11;
        L7:
            throw new NoSuchElementException();
        }

        public final void i(StringBuilder r10) {
            q.g(r10, "sb");
            if (b() >= MapBuilder.access$getLength$p(d())) goto L15;
            int r11 = b();
            f(r11 + 1);
            g(r11);
            Object r12 = MapBuilder.access$getKeysArray$p(d())[c()];
            if (r12 != d()) goto L7;
            r10.append("(this Map)");
        L8:
            r10.append('=');
            Object[] r13 = MapBuilder.access$getValuesArray$p(d());
            q.d(r13);
            Object r14 = r13[c()];
            if (r14 != d()) goto L11;
            r10.append("(this Map)");
        L12:
            e();
            return;
        L11:
            r10.append(r14);
            goto L12
        L7:
            r10.append(r12);
            goto L8
        L15:
            throw new NoSuchElementException();
        }

        public final int j() {
            if (b() >= MapBuilder.access$getLength$p(d())) goto L14;
            int r10 = b();
            f(r10 + 1);
            g(r10);
            Object r11 = MapBuilder.access$getKeysArray$p(d())[c()];
            int r12 = 0;
            if (r11 == null) goto L7;
            int r13 = r11.hashCode();
        L8:
            Object[] r14 = MapBuilder.access$getValuesArray$p(d());
            q.d(r14);
            Object r15 = r14[c()];
            if (r15 == null) goto L11;
            r12 = r15.hashCode();
        L11:
            int r16 = r13 ^ r12;
            e();
            return r16;
        L7:
            r13 = 0;
            goto L8
        L14:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return h();
        }
    }

    public static final class c implements Map.Entry, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MapBuilder f21080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21081b;

        public c(MapBuilder r10, int r11) {
            q.g(r10, "map");
            this.f21080a = r10;
            this.f21081b = r11;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r10) {
            if ((r10 instanceof Map.Entry) == false) goto L9;
            Map.Entry r11 = (Map.Entry) r10;
            if (q.b(r11.getKey(), getKey()) == false) goto L9;
            if (q.b(r11.getValue(), getValue()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return MapBuilder.access$getKeysArray$p(this.f21080a)[this.f21081b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            Object[] r10 = MapBuilder.access$getValuesArray$p(this.f21080a);
            q.d(r10);
            return r10[this.f21081b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object r10 = getKey();
            int r11 = 0;
            if (r10 == null) goto L5;
            int r12 = r10.hashCode();
        L6:
            Object r13 = getValue();
            if (r13 == null) goto L10;
            r11 = r13.hashCode();
        L10:
            return r12 ^ r11;
        L5:
            r12 = 0;
            goto L6
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r10) {
            this.f21080a.checkIsMutable$kotlin_stdlib();
            Object[] r11 = MapBuilder.access$allocateValuesArray(this.f21080a);
            int r12 = this.f21081b;
            Object r13 = r11[r12];
            r11[r12] = r10;
            return r13;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append(getKey());
            r10.append('=');
            r10.append(getValue());
            return r10.toString();
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MapBuilder f21082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f21084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f21085d;

        public d(MapBuilder r10) {
            q.g(r10, "map");
            this.f21082a = r10;
            this.f21084c = -1;
            this.f21085d = MapBuilder.access$getModCount$p(r10);
            e();
        }

        public final void a() {
            if (MapBuilder.access$getModCount$p(this.f21082a) != this.f21085d) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        public final int b() {
            return this.f21083b;
        }

        public final int c() {
            return this.f21084c;
        }

        public final MapBuilder d() {
            return this.f21082a;
        }

        public final void e() {
        L3:
            if (this.f21083b >= MapBuilder.access$getLength$p(this.f21082a)) goto L7;
            int[] r10 = MapBuilder.access$getPresenceArray$p(this.f21082a);
            int r11 = this.f21083b;
            if (r10[r11] >= 0) goto L10;
            this.f21083b = r11 + 1;
            goto L3
        L10:
            return;
        }

        public final void f(int r10) {
            this.f21083b = r10;
        }

        public final void g(int r10) {
            this.f21084c = r10;
        }

        public final boolean hasNext() {
            if (this.f21083b >= MapBuilder.access$getLength$p(this.f21082a)) goto L5;
            return true;
        L5:
            return false;
        }

        public final void remove() {
            a();
            if (this.f21084c == (-1)) goto L7;
            this.f21082a.checkIsMutable$kotlin_stdlib();
            MapBuilder.access$removeKeyAt(this.f21082a, this.f21084c);
            this.f21084c = -1;
            this.f21085d = MapBuilder.access$getModCount$p(this.f21082a);
            return;
        L7:
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
    }

    public static final class e extends d implements Iterator, KMutableIterator {
        public e(MapBuilder r10) {
            q.g(r10, "map");
            super(r10);
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= MapBuilder.access$getLength$p(d())) goto L7;
            int r10 = b();
            f(r10 + 1);
            g(r10);
            Object r11 = MapBuilder.access$getKeysArray$p(d())[c()];
            e();
            return r11;
        L7:
            throw new NoSuchElementException();
        }
    }

    public static final class f extends d implements Iterator, KMutableIterator {
        public f(MapBuilder r10) {
            q.g(r10, "map");
            super(r10);
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (b() >= MapBuilder.access$getLength$p(d())) goto L7;
            int r10 = b();
            f(r10 + 1);
            g(r10);
            Object[] r11 = MapBuilder.access$getValuesArray$p(d());
            q.d(r11);
            Object r12 = r11[c()];
            e();
            return r12;
        L7:
            throw new NoSuchElementException();
        }
    }

    static {
        Companion = new a(null);
        MapBuilder r10 = new MapBuilder(0);
        r10.isReadOnly = true;
        Empty = r10;
    }

    private MapBuilder(K[] r10, V[] r11, int[] r12, int[] r13, int r14, int r15) {
        this.keysArray = r10;
        this.valuesArray = r11;
        this.presenceArray = r12;
        this.hashArray = r13;
        this.maxProbeDistance = r14;
        this.length = r15;
        this.hashShift = a.b(Companion, getHashSize());
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(MapBuilder r10) {
        return r10.allocateValuesArray();
    }

    public static final /* synthetic */ MapBuilder access$getEmpty$cp() {
        return Empty;
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(MapBuilder r10) {
        return r10.keysArray;
    }

    public static final /* synthetic */ int access$getLength$p(MapBuilder r10) {
        return r10.length;
    }

    public static final /* synthetic */ int access$getModCount$p(MapBuilder r10) {
        return r10.modCount;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(MapBuilder r10) {
        return r10.presenceArray;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(MapBuilder r10) {
        return r10.valuesArray;
    }

    public static final /* synthetic */ void access$removeKeyAt(MapBuilder r10, int r11) {
        r10.removeKeyAt(r11);
    }

    private final V[] allocateValuesArray() {
        V[] r10 = this.valuesArray;
        if (r10 == null) goto L5;
        return r10;
    L5:
        V[] r11 = (V[]) kotlin.collections.builders.b.d(getCapacity$kotlin_stdlib());
        this.valuesArray = r11;
        return r11;
    }

    private final void compact() {
        V[] r10 = this.valuesArray;
        int r11 = 0;
        int r12 = 0;
    L3:
        int r13 = this.length;
        if (r11 >= r13) goto L12;
        if (this.presenceArray[r11] < 0) goto L11;
        K[] r14 = this.keysArray;
        r14[r12] = r14[r11];
        if (r10 == null) goto L10;
        r10[r12] = r10[r11];
    L10:
        r12 = r12 + 1;
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        kotlin.collections.builders.b.g(this.keysArray, r12, r13);
        if (r10 == null) goto L15;
        kotlin.collections.builders.b.g(r10, r12, this.length);
    L15:
        this.length = r12;
    }

    private final boolean contentEquals(Map<?, ?> r10) {
        if (size() == r10.size()) goto L5;
    L7:
        return false;
    L5:
        if (containsAllEntries$kotlin_stdlib(r10.entrySet()) == false) goto L7;
        return true;
    }

    private final void ensureCapacity(int r10) {
        if (r10 < 0) goto L14;
        if (r10 <= getCapacity$kotlin_stdlib()) goto L15;
        int r11 = kotlin.collections.b.Companion.d(getCapacity$kotlin_stdlib(), r10);
        this.keysArray = (K[]) kotlin.collections.builders.b.e(this.keysArray, r11);
        V[] r12 = this.valuesArray;
        if (r12 == null) goto L8;
        V[] r13 = (V[]) kotlin.collections.builders.b.e(r12, r11);
    L9:
        this.valuesArray = r13;
        int[] r14 = Arrays.copyOf(this.presenceArray, r11);
        q.f(r14, "copyOf(...)");
        this.presenceArray = r14;
        int r15 = a.a(Companion, r11);
        if (r15 <= getHashSize()) goto L16;
        rehash(r15);
        return;
    L16:
        return;
    L8:
        r13 = null;
        goto L9
    L15:
        return;
    L14:
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int r10) {
        if (shouldCompact(r10) == false) goto L5;
        rehash(getHashSize());
        return;
    L5:
        ensureCapacity(this.length + r10);
    }

    private final int findKey(K r10) {
        int r11 = hash(r10);
        int r12 = this.maxProbeDistance;
    L3:
        int r13 = this.hashArray[r11];
        if (r13 == 0) goto L5;
        if (r13 <= 0) goto L10;
        int r14 = r13 - 1;
        if (q.b(this.keysArray[r14], r10) == false) goto L10;
        return r14;
    L10:
        r12 = r12 - 1;
        if (r12 < 0) goto L12;
        int r15 = r11 - 1;
        if (r11 == 0) goto L15;
        r11 = r15;
        goto L3
    L15:
        r11 = getHashSize() - 1;
        goto L3
    L12:
        return -1;
    L5:
        return -1;
    }

    private final int findValue(V r10) {
        int r11 = this.length;
    L3:
        r11 = r11 - 1;
        if (r11 < 0) goto L10;
        if (this.presenceArray[r11] < 0) goto L3;
        V[] r12 = this.valuesArray;
        q.d(r12);
        if (q.b(r12[r11], r10) == false) goto L3;
        return r11;
    L10:
        return -1;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K r10) {
        if (r10 == null) goto L4;
        int r11 = r10.hashCode();
    L6:
        return (r11 * MAGIC) >>> this.hashShift;
    L4:
        r11 = 0;
        goto L6
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> r10) {
        boolean r11 = false;
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        ensureExtraCapacity(r10.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        if (putEntry(r12.next()) == false) goto L7;
        r11 = true;
        goto L7
    L11:
        return r11;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> r10) {
        int r11 = addKey$kotlin_stdlib(r10.getKey());
        V[] r12 = allocateValuesArray();
        if (r11 < 0) goto L6;
        r12[r11] = r10.getValue();
        return true;
    L6:
        int r13 = (-r11) - 1;
        V r14 = r12[r13];
        if (q.b(r10.getValue(), r14) == true) goto L10;
        r12[r13] = r10.getValue();
        return true;
    L10:
        return false;
    }

    private final boolean putRehash(int r10) {
        int r11 = hash(this.keysArray[r10]);
        int r12 = this.maxProbeDistance;
    L3:
        int[] r13 = this.hashArray;
        if (r13[r11] == 0) goto L5;
        r12 = r12 - 1;
        if (r12 < 0) goto L9;
        int r14 = r11 - 1;
        if (r11 == 0) goto L13;
        r11 = r14;
        goto L3
    L13:
        r11 = getHashSize() - 1;
        goto L3
    L9:
        return false;
    L5:
        r13[r11] = r10 + 1;
        this.presenceArray[r10] = r11;
        return true;
    }

    private final void registerModification() {
        this.modCount++;
    }

    private final void rehash(int r10) {
        registerModification();
        if (this.length <= size()) goto L5;
        compact();
    L5:
        int r11 = 0;
        if (r10 == getHashSize()) goto L8;
        this.hashArray = new int[r10];
        this.hashShift = a.b(Companion, r10);
    L10:
        if (r11 >= this.length) goto L16;
        int r12 = r11 + 1;
        if (putRehash(r11) == false) goto L15;
        r11 = r12;
        goto L10
    L15:
        throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
    L16:
        return;
    L8:
        m.h(this.hashArray, 0, 0, getHashSize());
        goto L10
    }

    private final void removeHashAt(int r10) {
        int r11 = h.g(this.maxProbeDistance * 2, getHashSize() / 2);
        int r12 = 0;
        int r13 = r10;
    L3:
        int r14 = r10 - 1;
        if (r10 != 0) goto L6;
        r10 = getHashSize() - 1;
    L7:
        r12 = r12 + 1;
        if (r12 > this.maxProbeDistance) goto L9;
        int[] r15 = this.hashArray;
        int r16 = r15[r10];
        if (r16 == 0) goto L13;
        if (r16 >= 0) goto L19;
        r15[r13] = -1;
    L18:
        r13 = r10;
        r12 = 0;
    L22:
        r11 = r11 - 1;
        if (r11 >= 0) goto L3;
        this.hashArray[r13] = -1;
        return;
    L19:
        int r17 = r16 - 1;
        if (((hash(this.keysArray[r17]) - r10) & (getHashSize() - 1)) < r12) goto L22;
        this.hashArray[r13] = r16;
        this.presenceArray[r17] = r13;
        goto L18
    L13:
        r15[r13] = 0;
        return;
    L9:
        this.hashArray[r13] = 0;
        return;
    L6:
        r10 = r14;
        goto L7
    }

    private final void removeKeyAt(int r10) {
        kotlin.collections.builders.b.f(this.keysArray, r10);
        removeHashAt(this.presenceArray[r10]);
        this.presenceArray[r10] = -1;
        this.size = size() - 1;
        registerModification();
    }

    private final boolean shouldCompact(int r10) {
        int r11 = getCapacity$kotlin_stdlib();
        int r12 = this.length;
        int r13 = r11 - r12;
        int r14 = r12 - size();
        if (r13 < r10) goto L5;
    L9:
        return false;
    L5:
        if ((r13 + r14) < r10) goto L9;
        if (r14 < (getCapacity$kotlin_stdlib() / 4)) goto L9;
        return true;
    }

    private final Object writeReplace() {
        if (this.isReadOnly == false) goto L7;
        return new SerializedMap(this);
    L7:
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K r10) {
        checkIsMutable$kotlin_stdlib();
    L3:
        int r11 = hash(r10);
        int r12 = h.g(this.maxProbeDistance * 2, getHashSize() / 2);
        int r13 = 0;
    L4:
        int r14 = this.hashArray[r11];
        if (r14 <= 0) goto L7;
        if (q.b(this.keysArray[r14 - 1], r10) == true) goto L16;
        r13 = r13 + 1;
        if (r13 > r12) goto L19;
        int r15 = r11 - 1;
        if (r11 == 0) goto L22;
        r11 = r15;
        goto L4
    L22:
        r11 = getHashSize() - 1;
        goto L4
    L19:
        rehash(getHashSize() * 2);
        goto L3
    L16:
        return -r14;
    L7:
        if (this.length < getCapacity$kotlin_stdlib()) goto L9;
        ensureExtraCapacity(1);
        goto L3
    L9:
        int r16 = this.length;
        int r17 = r16 + 1;
        this.length = r17;
        this.keysArray[r16] = r10;
        this.presenceArray[r16] = r11;
        this.hashArray[r11] = r17;
        this.size = size() + 1;
        registerModification();
        if (r13 <= this.maxProbeDistance) goto L12;
        this.maxProbeDistance = r13;
    L12:
        return r16;
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        if (size() > 0) goto L7;
        MapBuilder r10 = Empty;
        q.e(r10, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return r10;
    L7:
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        g0 r10 = new bg.c(0, this.length - 1).d();
    L4:
        if (r10.hasNext() == false) goto L8;
        int r11 = r10.nextInt();
        int[] r12 = this.presenceArray;
        int r13 = r12[r11];
        if (r13 < 0) goto L4;
        this.hashArray[r13] = 0;
        r12[r11] = -1;
        goto L4
    L8:
        kotlin.collections.builders.b.g(this.keysArray, 0, this.length);
        V[] r14 = this.valuesArray;
        if (r14 == null) goto L11;
        kotlin.collections.builders.b.g(r14, 0, this.length);
    L11:
        this.size = 0;
        this.length = 0;
        registerModification();
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> r10) {
        q.g(r10, "m");
        Iterator<?> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        if (r12 == null) goto L9;
        if (containsEntry$kotlin_stdlib((Map.Entry) r12) == true) goto L4;
    L9:
        return false;
    L10:
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> r10) {
        q.g(r10, "entry");
        int r11 = findKey(r10.getKey());
        if (r11 >= 0) goto L6;
        return false;
    L6:
        V[] r12 = this.valuesArray;
        q.d(r12);
        return q.b(r12[r11], r10.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object r10) {
        if (findKey(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object r10) {
        if (findValue(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public final b entriesIterator$kotlin_stdlib() {
        return new b(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof Map) == true) goto L6;
    L8:
        return false;
    L6:
        if (contentEquals((Map) r10) == false) goto L8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object r10) {
        int r11 = findKey(r10);
        if (r11 >= 0) goto L6;
        return null;
    L6:
        V[] r12 = this.valuesArray;
        q.d(r12);
        return r12[r11];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.c r10 = this.entriesView;
        if (r10 != null) goto L6;
        kotlin.collections.builders.c r11 = new kotlin.collections.builders.c(this);
        this.entriesView = r11;
        return r11;
    L6:
        return r10;
    }

    @NotNull
    public Set<K> getKeys() {
        kotlin.collections.builders.d r10 = this.keysView;
        if (r10 != null) goto L6;
        kotlin.collections.builders.d r11 = new kotlin.collections.builders.d(this);
        this.keysView = r11;
        return r11;
    L6:
        return r10;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        kotlin.collections.builders.e r10 = this.valuesView;
        if (r10 != null) goto L6;
        kotlin.collections.builders.e r11 = new kotlin.collections.builders.e(this);
        this.valuesView = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.Map
    public int hashCode() {
        b r10 = entriesIterator$kotlin_stdlib();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 + r10.j();
        goto L4
    L6:
        return r11;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final e keysIterator$kotlin_stdlib() {
        return new e(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K r10, V r11) {
        checkIsMutable$kotlin_stdlib();
        int r12 = addKey$kotlin_stdlib(r10);
        V[] r13 = allocateValuesArray();
        if (r12 >= 0) goto L6;
        int r14 = (-r12) - 1;
        V r15 = r13[r14];
        r13[r14] = r11;
        return r15;
    L6:
        r13[r12] = r11;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> r10) {
        q.g(r10, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(r10.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object r10) {
        int r11 = removeKey$kotlin_stdlib(r10);
        if (r11 >= 0) goto L6;
        return null;
    L6:
        V[] r12 = this.valuesArray;
        q.d(r12);
        V r13 = r12[r11];
        kotlin.collections.builders.b.f(r12, r11);
        return r13;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> r10) {
        q.g(r10, "entry");
        checkIsMutable$kotlin_stdlib();
        int r11 = findKey(r10.getKey());
        if (r11 >= 0) goto L5;
        return false;
    L5:
        V[] r12 = this.valuesArray;
        q.d(r12);
        if (q.b(r12[r11], r10.getValue()) == true) goto L8;
        return false;
    L8:
        removeKeyAt(r11);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K r10) {
        checkIsMutable$kotlin_stdlib();
        int r11 = findKey(r10);
        if (r11 >= 0) goto L6;
        return -1;
    L6:
        removeKeyAt(r11);
        return r11;
    }

    public final boolean removeValue$kotlin_stdlib(V r10) {
        checkIsMutable$kotlin_stdlib();
        int r11 = findValue(r10);
        if (r11 >= 0) goto L6;
        return false;
    L6:
        removeKeyAt(r11);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder r10 = new StringBuilder((size() * 3) + 2);
        r10.append("{");
        b r11 = entriesIterator$kotlin_stdlib();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        if (r12 <= 0) goto L7;
        r10.append(", ");
    L7:
        r11.i(r10);
        r12 = r12 + 1;
        goto L4
    L8:
        r10.append("}");
        String r13 = r10.toString();
        q.f(r13, "toString(...)");
        return r13;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final f valuesIterator$kotlin_stdlib() {
        return new f(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int r10) {
        this(kotlin.collections.builders.b.d(r10), null, new int[r10], new int[a.a(Companion, r10)], 2, 0);
    }
}
