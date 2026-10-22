package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002Bâ\u0001\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u00128\b\u0002\u0010\u0007\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\b\u0012%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000e\u0012d\b\u0002\u0010\u000f\u001a^\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u00104\u001a\u00020\u0013J\u0006\u00105\u001a\u00020\u0013J\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020\u0013J\u0010\u00108\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u00109\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0005H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J\u0018\u0010;\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0086\n¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010@J'\u0010A\u001a\u00020\u00152\u001a\u0010B\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0\u001d¢\u0006\u0002\u0010DJ \u0010A\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0EJ \u0010A\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0FJ\u001a\u0010A\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010HJ\u001a\u0010A\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010IJ\u001a\u0010A\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000J\u001d\u0010J\u001a\u00020\u00152\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010CH\u0086\nJ*\u0010J\u001a\u00020\u00152\u001a\u0010B\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0\u001dH\u0086\n¢\u0006\u0002\u0010DJ#\u0010J\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0EH\u0086\nJ#\u0010J\u001a\u00020\u00152\u0018\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010C0FH\u0086\nJ\u001d\u0010J\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010HH\u0086\nJ\u001d\u0010J\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010IH\u0086\nJ\u001d\u0010J\u001a\u00020\u00152\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0086\nJ\u0015\u0010L\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010<J\u001b\u0010L\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010MJ \u0010N\u001a\u00020\u00152\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bJ\u0016\u0010P\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010QJ\u001e\u0010P\u001a\u00020\u00152\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001dH\u0086\n¢\u0006\u0002\u0010RJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000EH\u0086\nJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000FH\u0086\nJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000SH\u0086\nJ\u0017\u0010P\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000TH\u0086\nJ\u0006\u0010U\u001a\u00020\u0015J\u0010\u0010V\u001a\u00020\u00152\b\b\u0001\u0010\u0004\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u0005JD\u0010X\u001a\u00020\u001526\u0010Y\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00150\bH\u0086\bø\u0001\u0000J/\u0010Z\u001a\u00020\u00152!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00150\u000eH\u0086\bø\u0001\u0000J/\u0010[\u001a\u00020\u00152!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00150\u000eH\u0086\bø\u0001\u0000J&\u0010\\\u001a\u00020\u00132\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J&\u00104\u001a\u00020\u00132\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J\u0006\u0010/\u001a\u00020\u0005J&\u0010/\u001a\u00020\u00052\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\bH\u0086\bø\u0001\u0000J\u0016\u0010]\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010^J\u0013\u0010_\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010^J\u0013\u0010`\u001a\u00020\u00132\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010^J\b\u0010a\u001a\u00020\u0005H\u0002J\u0011\u0010b\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0005H\u0082\bJ\u0017\u0010d\u001a\u0004\u0018\u00018\u00012\u0006\u0010c\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010eJ\u0011\u0010f\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0005H\u0082\bJ\u0011\u0010g\u001a\u00020\u00152\u0006\u0010c\u001a\u00020\u0005H\u0082\bJ\u0015\u0010h\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010iJ\u0015\u0010j\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010iJ\u0010\u0010k\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\u0005H\u0002J\r\u0010m\u001a\u00020\u0015H\u0000¢\u0006\u0002\bnJ\r\u0010o\u001a\u00020\u0015H\u0000¢\u0006\u0002\bpJ\u0015\u0010q\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u0005H\u0000¢\u0006\u0002\bsJ\u0010\u0010t\u001a\u00020\u00152\u0006\u0010u\u001a\u00020\u0019H\u0002J\u0010\u0010t\u001a\u00020\u00152\u0006\u0010u\u001a\u00020vH\u0002J/\u0010w\u001a\u00020\u00152!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020\u00150\u000eH\u0081\bø\u0001\u0000J\b\u0010x\u001a\u00020\u0005H\u0016J\u0013\u0010y\u001a\u00020\u00132\b\u0010z\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010{\u001a\u00020|H\u0016R>\u0010\u0007\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000Rj\u0010\u000f\u001a^\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u001f\u0012\u0004\b\u001e\u0010\u001bR\"\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001d8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u001f\u0012\u0004\b!\u0010\u001bR\u000e\u0010\"\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010+\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010-R\u001a\u0010/\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010-R\u0011\u00102\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u0010-\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006}"}, d2 = {"Landroidx/collection/SieveCache;", "K", "", "V", "maxSize", "", "initialCapacity", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "createValueFromKey", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "oldValue", "newValue", "", "evicted", "", "<init>", "(IILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "metadata", "", "getMetadata$annotations", "()V", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "values", "getValues$annotations", "nodes", "_capacity", "growthLimit", "_count", "_maxSize", "_size", "head", "tail", "hand", "size", "getSize", "()I", "getMaxSize", "count", "getCount$annotations", "getCount", "capacity", "getCapacity", "any", "none", "isEmpty", "isNotEmpty", "initializeStorage", "initializeMetadata", "initializeGrowth", MonitorConstants.CONNECT_TYPE_GET, "(Ljava/lang/Object;)Ljava/lang/Object;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "", "Lkotlin/sequences/Sequence;", "from", "", "Landroidx/collection/ScatterMap;", "plusAssign", "pair", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "predicate", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "Landroidx/collection/ScatterSet;", "Landroidx/collection/ObjectList;", "evictAll", "resize", "trimToSize", "forEach", "block", "forEachKey", "forEachValue", "all", "contains", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "findEvictionCandidate", "moveNodeToHead", "index", "removeValueAt", "(I)Ljava/lang/Object;", "removeNode", "markNodeVisited", "findKeyIndex", "(Ljava/lang/Object;)I", "findInsertIndex", "findFirstAvailableSlot", "hash1", "adjustStorage", "adjustStorage$collection", "dropDeletes", "dropDeletes$collection", "resizeStorage", "newCapacity", "resizeStorage$collection", "fixupNodes", "mapping", "", "forEachIndexed", "hashCode", "equals", "other", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SieveCache<K, V> {
    private int _capacity;
    private int _count;
    private int _maxSize;
    private int _size;
    private final Function1<K, V> createValueFromKey;
    private int growthLimit;
    private int hand;
    private int head;
    public Object[] keys;
    public long[] metadata;
    private long[] nodes;
    private final Function4<K, V, V, Boolean, Unit> onEntryRemoved;
    private final Function2<K, V, Integer> sizeOf;
    private int tail;
    public Object[] values;

    private static final int _init_$lambda$0(Object r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        return 1;
    }

    public static /* synthetic */ int a(Object r100, Object r101) {
        return _init_$lambda$0(r100, r101);
    }

    public static /* synthetic */ Unit b(Object r100, Object r101, Object r102, boolean r103) {
        return _init_$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ void getCount$annotations() {
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    private final int findEvictionCandidate() {
        long[] r100 = this.nodes;
        int r101 = this.hand;
        int r102 = Integer.MAX_VALUE;
        if (r101 != Integer.MAX_VALUE) goto L7;
        r101 = this.tail;
    L7:
        if (r101 == Integer.MAX_VALUE) goto L14;
        long r103 = r100[r101];
        if (((int) ((r103 >> 62) & 1)) == 0) goto L14;
        int r104 = (int) (SieveCacheKt.NodeLinkMask & (r103 >> 31));
        r100[r101] = r103 & 4611686018427387903L;
        if (r104 != Integer.MAX_VALUE) goto L12;
        r101 = this.tail;
        goto L7
    L12:
        r101 = r104;
    L14:
        int r105 = (int) (SieveCacheKt.NodeLinkMask & (r100[r101] >> 31));
        if (r105 == Integer.MAX_VALUE) goto L17;
        r102 = r105;
    L17:
        this.hand = r102;
        return r101;
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(this._capacity) - getCount();
    }

    public final void adjustStorage$collection() {
        if (this._capacity > 8) goto L5;
    L7:
        resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
        return;
    L5:
        if (Long.compare(ULong.m9623constructorimpl(ULong.m9623constructorimpl(getCount()) * 32) ^ Long.MIN_VALUE, ULong.m9623constructorimpl(ULong.m9623constructorimpl(this._capacity) * 25) ^ Long.MIN_VALUE) > 0) goto L7;
        dropDeletes$collection();
    }

    public final boolean any() {
        if (this._count == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void dropDeletes$collection() {
        long[] r100 = this.metadata;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this._capacity;
        Object[] r102 = this.keys;
        Object[] r103 = this.values;
        long[] r104 = this.nodes;
        long[] r105 = new long[r101];
        ArraysKt.fill(r105, 9223372034707292159L, 0, r101);
        int r110 = (r101 + 7) >> 3;
        int r111 = 0;
    L6:
        if (r111 >= r110) goto L8;
        long r112 = r100[r111] & (-9187201950435737472L);
        r100[r111] = (-72340172838076674L) & ((~r112) + (r112 >>> 7));
        r111 = r111 + 1;
        goto L6
    L8:
        int r113 = ArraysKt.getLastIndex(r100);
        int r114 = r113 - 1;
        r100[r114] = (r100[r114] & 72057594037927935L) | (-72057594037927936L);
        r100[r113] = r100[0];
        int r115 = 0;
    L9:
        if (r115 == r101) goto L40;
        int r116 = r115 >> 3;
        int r117 = (r115 & 7) << 3;
        long r118 = (r100[r116] >> r117) & 255;
        if (r118 == 128) goto L12;
        if (r118 != 254) goto L12;
        Object r119 = r102[r115];
        if (r119 == null) goto L19;
        int r120 = r119.hashCode();
    L20:
        int r121 = r120 * ScatterMapKt.MurmurHashC1;
        int r122 = r121 ^ (r121 << 16);
        int r123 = r122 >>> 7;
        int r106 = findFirstAvailableSlot(r123);
        int r124 = r123 & r101;
        if ((((r106 - r124) & r101) / 8) != (((r115 - r124) & r101) / 8)) goto L27;
        Object[] r210 = r103;
        long[] r211 = r104;
        r100[r116] = (r100[r116] & (~(255 << r117))) | (((long) (r122 & 127)) << r117);
        if (r105[r115] != 9223372034707292159L) goto L25;
        long r107 = r115;
        r105[r115] = r107 | (r107 << 32);
    L25:
        r100[r100.length - 1] = r100[0];
        r115 = r115 + 1;
        r103 = r210;
        r104 = r211;
        goto L9
    L27:
        Object[] r212 = r103;
        long[] r213 = r104;
        int r108 = r106 >> 3;
        long r214 = r100[r108];
        int r109 = (r106 & 7) << 3;
        if (((r214 >> r109) & 255) != 128) goto L34;
        r100[r108] = ((r122 & 127) << r109) | (r214 & (~(255 << r109)));
        r100[r116] = (r100[r116] & (~(255 << r117))) | (128 << r117);
        r102[r106] = r102[r115];
        r102[r115] = null;
        r212[r106] = r212[r115];
        r212[r115] = null;
        r213[r106] = r213[r115];
        r213[r115] = 4611686018427387903L;
        int r125 = (int) ((r105[r115] >> 32) & BodyPartID.bodyIdMax);
        if (r125 == Integer.MAX_VALUE) goto L32;
        r105[r125] = (r105[r125] & (-4294967296L)) | ((long) r106);
        r105[r115] = (r105[r115] & BodyPartID.bodyIdMax) | (-4294967296L);
        char r126 = ' ';
    L33:
        r105[r106] = Integer.MAX_VALUE | (((long) r115) << r126);
    L39:
        r100[r100.length - 1] = r100[0];
        r115 = r115 + 1;
        r103 = r212;
        r104 = r213;
        goto L9
    L32:
        r126 = ' ';
        r105[r115] = (((long) Integer.MAX_VALUE) << 32) | ((long) r106);
        goto L33
    L34:
        r100[r108] = (((long) (r122 & 127)) << r109) | (r214 & (~(255 << r109)));
        Object r127 = r102[r106];
        r102[r106] = r102[r115];
        r102[r115] = r127;
        Object r128 = r212[r106];
        r212[r106] = r212[r115];
        r212[r115] = r128;
        long r129 = r213[r106];
        r213[r106] = r213[r115];
        r213[r115] = r129;
        int r130 = (int) ((r105[r115] >> 32) & BodyPartID.bodyIdMax);
        if (r130 == Integer.MAX_VALUE) goto L37;
        long r131 = r106;
        r105[r130] = (r105[r130] & (-4294967296L)) | r131;
        r105[r115] = (r105[r115] & BodyPartID.bodyIdMax) | (r131 << 32);
    L38:
        r105[r106] = (((long) r130) << 32) | ((long) r115);
        r115 = r115 - 1;
        goto L39
    L37:
        long r132 = r106;
        r105[r115] = r132 | (r132 << 32);
        r130 = r115;
        goto L38
    L19:
        r120 = 0;
    L12:
        r115 = r115 + 1;
        goto L9
    L40:
        initializeGrowth();
        fixupNodes(r105);
    }

    public int hashCode() {
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        int r104 = 0;
        if (r103 < 0) goto L21;
        int r105 = 0;
        int r106 = 0;
    L5:
        long r107 = r102[r105];
        if (((((~r107) << 7) & r107) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r110 = 8 - ((~(r105 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L16;
        if ((255 & r107) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L15;
        int r113 = (r105 << 3) + r111;
        Object r114 = r100[r113];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r115 = r101[r113];
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        r106 = r106 + (r115.hashCode() ^ r114.hashCode());
    L15:
        r107 = r107 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L16:
        if (r110 == 8) goto L17;
        return r106;
    L17:
        if (r105 == r103) goto L19;
        r105 = r105 + 1;
        goto L5
    L19:
        r104 = r106;
    L21:
        return r104;
    }

    public final boolean isEmpty() {
        if (this._count != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._count == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean none() {
        if (this._count != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "SieveCache[maxSize=" + this._maxSize + ", size=" + this._size + ", capacity=" + this._capacity + ", count=" + this._count + ']';
    }

    public final int count() {
        return getSize();
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getCount() {
        return this._count;
    }

    public final int getMaxSize() {
        return this._maxSize;
    }

    public final int getSize() {
        return this._size;
    }

    private final int findFirstAvailableSlot(int r110) {
        int r100 = this._capacity;
        int r111 = r110 & r100;
        int r101 = 0;
    L3:
        long[] r102 = this.metadata;
        int r103 = r111 >> 3;
        int r104 = (r111 & 7) << 3;
        long r105 = ((r102[r103 + 1] << (64 - r104)) & ((-r104) >> 63)) | (r102[r103] >>> r104);
        long r106 = (r105 & ((~r105) << 7)) & (-9187201950435737472L);
        if (r106 != 0) goto L6;
        r101 = r101 + 8;
        r111 = (r111 + r101) & r100;
        goto L3
    L6:
        return (r111 + (Long.numberOfTrailingZeros(r106) >> 3)) & r100;
    }

    private final int findInsertIndex(K r210) {
        if (r210 == null) goto L5;
        int r100 = r210.hashCode();
    L6:
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        int r102 = r101 ^ (r101 << 16);
        int r103 = r102 >>> 7;
        int r104 = r102 & 127;
        int r105 = this._capacity;
        int r106 = r103 & r105;
        int r107 = 0;
    L7:
        long[] r108 = this.metadata;
        int r109 = r106 >> 3;
        int r110 = (r106 & 7) << 3;
        long r111 = ((r108[r109 + 1] << (64 - r110)) & ((-r110) >> 63)) | (r108[r109] >>> r110);
        long r112 = r104;
        int r113 = r104;
        long r114 = r111 ^ (r112 * ScatterMapKt.BitmaskLsb);
        long r115 = ((~r114) & (r114 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r115 == 0) goto L11;
        boolean r116 = true;
    L12:
        if (r116 == false) goto L18;
        int r117 = (r106 + (Long.numberOfTrailingZeros(r115) >> 3)) & r105;
        if (Intrinsics.areEqual(this.keys[r117], r210) == true) goto L15;
        r115 = r115 & (r115 - 1);
        goto L9
    L15:
        return r117;
    L18:
        if (((((~r111) << 6) & r111) & (-9187201950435737472L)) != 0) goto L19;
        r107 = r107 + 8;
        r106 = (r106 + r107) & r105;
        r104 = r113;
        goto L7
    L19:
        int r118 = findFirstAvailableSlot(r103);
        if (this.growthLimit == 0) goto L22;
    L27:
        this._count++;
        int r119 = this.growthLimit;
        long[] r120 = this.metadata;
        int r121 = r118 >> 3;
        long r122 = r120[r121];
        int r123 = (r118 & 7) << 3;
        if (((r122 >> r123) & 255) != 128) goto L30;
        int r124 = 1;
    L31:
        this.growthLimit = r119 - r124;
        int r125 = this._capacity;
        long r126 = ((~(255 << r123)) & r122) | (r112 << r123);
        r120[r121] = r126;
        r120[(((r118 - 7) & r125) + (r125 & 7)) >> 3] = r126;
        return ~r118;
    L30:
        r124 = 0;
        goto L31
    L22:
        if (((this.metadata[r118 >> 3] >> ((r118 & 7) << 3)) & 255) != 254) goto L24;
        boolean r127 = true;
    L25:
        if (r127 == true) goto L27;
        adjustStorage$collection();
        r118 = findFirstAvailableSlot(r103);
        goto L27
    L24:
        r127 = false;
        goto L25
    L11:
        r116 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    private final int findKeyIndex(K r110) {
        if (r110 == null) goto L5;
        int r100 = r110.hashCode();
    L6:
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        int r102 = r101 ^ (r101 << 16);
        int r103 = r102 & 127;
        int r104 = this._capacity;
        int r105 = (r102 >>> 7) & r104;
        int r106 = 0;
    L7:
        long[] r107 = this.metadata;
        int r108 = r105 >> 3;
        int r109 = (r105 & 7) << 3;
        long r111 = ((r107[r108 + 1] << (64 - r109)) & ((-r109) >> 63)) | (r107[r108] >>> r109);
        long r112 = (((long) r103) * ScatterMapKt.BitmaskLsb) ^ r111;
        long r113 = ((~r112) & (r112 - ScatterMapKt.BitmaskLsb)) & (-9187201950435737472L);
    L9:
        if (r113 == 0) goto L11;
        boolean r114 = true;
    L12:
        if (r114 == false) goto L18;
        int r115 = ((Long.numberOfTrailingZeros(r113) >> 3) + r105) & r104;
        if (Intrinsics.areEqual(this.keys[r115], r110) == true) goto L15;
        r113 = r113 & (r113 - 1);
        goto L9
    L15:
        return r115;
    L18:
        if (((r111 & ((~r111) << 6)) & (-9187201950435737472L)) != 0) goto L19;
        r106 = r106 + 8;
        r105 = (r105 + r106) & r104;
        goto L7
    L19:
        return -1;
    L11:
        r114 = false;
        goto L12
    L5:
        r100 = 0;
        goto L6
    }

    private final void fixupNodes(long[] r110) {
        long[] r100 = this.nodes;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        int r103 = Integer.MAX_VALUE;
        if (r102 >= r101) goto L14;
        long r104 = r100[r102];
        int r111 = (int) ((r104 >> 31) & SieveCacheKt.NodeLinkMask);
        int r105 = (int) (SieveCacheKt.NodeLinkMask & r104);
        long r106 = r104 & SieveCacheKt.NodeMetaMask;
        if (r111 != Integer.MAX_VALUE) goto L8;
        int r112 = Integer.MAX_VALUE;
    L9:
        long r107 = (r106 | ((long) r112)) << 31;
        if (r105 == Integer.MAX_VALUE) goto L13;
        r103 = (int) (BodyPartID.bodyIdMax & r110[r105]);
    L13:
        r100[r102] = ((long) r103) | r107;
        r102 = r102 + 1;
        goto L3
    L8:
        r112 = (int) (r110[r111] & BodyPartID.bodyIdMax);
        goto L9
    L14:
        int r108 = this.head;
        if (r108 == Integer.MAX_VALUE) goto L17;
        this.head = (int) (r110[r108] & BodyPartID.bodyIdMax);
    L17:
        int r109 = this.tail;
        if (r109 == Integer.MAX_VALUE) goto L20;
        this.tail = (int) (r110[r109] & BodyPartID.bodyIdMax);
    L20:
        int r113 = this.hand;
        if (r113 == Integer.MAX_VALUE) goto L27;
        this.hand = (int) (r110[r113] & BodyPartID.bodyIdMax);
        return;
    }

    private final void initializeMetadata(int r100) {
        if (r100 != 0) goto L4;
        long[] r101 = ScatterMapKt.EmptyGroup;
    L5:
        this.metadata = r101;
        initializeGrowth();
        return;
    L4:
        long[] r102 = new long[((((r100 + 1) + 7) + 7) & (-8)) >> 3];
        ArraysKt.fill$default(r102, -9187201950435737472L, 0, 0, 6, null);
        int r103 = r100 >> 3;
        long r104 = 255 << ((r100 & 7) << 3);
        r102[r103] = (r102[r103] & (~r104)) | r104;
        r101 = r102;
        goto L5
    }

    private final void initializeStorage(int r100) {
        if (r100 <= 0) goto L4;
        int r101 = Math.max(7, ScatterMapKt.normalizeCapacity(r100));
    L5:
        this._capacity = r101;
        initializeMetadata(r101);
        if (r101 != 0) goto L8;
        Object[] r102 = ContainerHelpersKt.EMPTY_OBJECTS;
    L9:
        this.keys = r102;
        if (r101 != 0) goto L12;
        Object[] r103 = ContainerHelpersKt.EMPTY_OBJECTS;
    L13:
        this.values = r103;
        if (r101 != 0) goto L16;
        long[] r104 = SieveCacheKt.getEmptyNodes();
    L17:
        this.nodes = r104;
        return;
    L16:
        r104 = new long[r101];
        ArraysKt.fill$default(r104, 4611686018427387903L, 0, 0, 6, null);
        goto L17
    L12:
        r103 = new Object[r101];
        goto L13
    L8:
        r102 = new Object[r101];
        goto L9
    L4:
        r101 = 0;
        goto L5
    }

    private final void markNodeVisited(int r100) {
        long[] r101 = this.nodes;
        r101[r100] = (r101[r100] & 4611686018427387903L) | SieveCacheKt.NodeVisitedBit;
    }

    private final void moveNodeToHead(int r110) {
        long[] r100 = this.nodes;
        int r101 = this.head;
        r100[r110] = (((long) r101) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r101 == Integer.MAX_VALUE) goto L5;
        long r102 = r100[r101] & SieveCacheKt.NodeMetaAndNextMask;
        r100[r101] = ((((long) r110) & SieveCacheKt.NodeLinkMask) << 31) | r102;
    L5:
        this.head = r110;
        if (this.tail != Integer.MAX_VALUE) goto L9;
        this.tail = r110;
        return;
    }

    private final void removeNode(int r110) {
        long[] r100 = this.nodes;
        long r101 = r100[r110];
        int r102 = (int) ((r101 >> 31) & SieveCacheKt.NodeLinkMask);
        int r103 = (int) (r101 & SieveCacheKt.NodeLinkMask);
        if (r102 == Integer.MAX_VALUE) goto L5;
        r100[r102] = (r100[r102] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r103) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r103 == Integer.MAX_VALUE) goto L8;
        long r104 = r100[r103] & SieveCacheKt.NodeMetaAndNextMask;
        r100[r103] = ((SieveCacheKt.NodeLinkMask & ((long) r102)) << 31) | r104;
    L10:
        if (this.hand != r110) goto L12;
        this.hand = r102;
    L12:
        r100[r110] = 4611686018427387903L;
        return;
    L8:
        this.tail = r102;
        goto L10
    L5:
        this.head = r103;
        goto L6
    }

    private final V removeValueAt(int r110) {
        this._count--;
        long[] r100 = this.metadata;
        int r101 = this._capacity;
        int r102 = r110 >> 3;
        int r103 = (r110 & 7) << 3;
        long r104 = (r100[r102] & (~(255 << r103))) | (254 << r103);
        r100[r102] = r104;
        r100[(((r110 - 7) & r101) + (r101 & 7)) >> 3] = r104;
        this.keys[r110] = null;
        Object[] r105 = this.values;
        V r106 = (V) r105[r110];
        r105[r110] = null;
        long[] r107 = this.nodes;
        long r108 = r107[r110];
        int r109 = (int) ((r108 >> 31) & SieveCacheKt.NodeLinkMask);
        int r111 = (int) (r108 & SieveCacheKt.NodeLinkMask);
        if (r109 == Integer.MAX_VALUE) goto L5;
        r107[r109] = (r107[r109] & SieveCacheKt.NodeMetaAndPreviousMask) | (((long) r111) & SieveCacheKt.NodeLinkMask);
    L6:
        if (r111 == Integer.MAX_VALUE) goto L8;
        r107[r111] = ((SieveCacheKt.NodeLinkMask & ((long) r109)) << 31) | (r107[r111] & SieveCacheKt.NodeMetaAndNextMask);
    L10:
        if (this.hand != r110) goto L12;
        this.hand = r109;
    L12:
        r107[r110] = 4611686018427387903L;
        return r106;
    L8:
        this.tail = r109;
        goto L10
    L5:
        this.head = r111;
        goto L6
    }

    public final boolean all(Function2<? super K, ? super V, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L21;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        Object r114 = r100[r113];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r106 = r101[r113];
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (r210.invoke(r114, r106).booleanValue() == true) goto L17;
        return false;
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 == 8) goto L19;
        return true;
    L19:
        if (r104 == r103) goto L30;
        r104 = r104 + 1;
        goto L5
    L30:
        return true;
    L21:
        return true;
    }

    public final boolean any(Function2<? super K, ? super V, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L21;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        Object r114 = r100[r113];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r115 = r101[r113];
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (r210.invoke(r114, r115).booleanValue() == false) goto L17;
        return true;
    L17:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 != 8) goto L21;
    L19:
        if (r104 == r103) goto L21;
        r104 = r104 + 1;
    L21:
        return false;
    }

    public final boolean contains(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (findKeyIndex(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsKey(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (findKeyIndex(r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean containsValue(V r110) {
        Intrinsics.checkNotNullParameter(r110, "value");
        Object[] r100 = this.values;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L21;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L18;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        Object r113 = r100[(r103 << 3) + r111];
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (Intrinsics.areEqual(r110, r113) == false) goto L17;
        return true;
    L17:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r105 != 8) goto L21;
    L19:
        if (r103 == r102) goto L21;
        r103 = r103 + 1;
    L21:
        return false;
    }

    public final int count(Function2<? super K, ? super V, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r210, "predicate");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L22;
        int r104 = 0;
        int r105 = 0;
    L5:
        long r106 = r102[r104];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L19;
        int r110 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r110) goto L18;
        if ((255 & r106) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L17;
        int r113 = (r104 << 3) + r111;
        Object r114 = r100[r113];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r107 = r101[r113];
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (r210.invoke(r114, r107).booleanValue() == false) goto L17;
        r105 = r105 + 1;
    L17:
        r106 = r106 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r110 == 8) goto L19;
        return r105;
    L19:
        if (r104 == r103) goto L21;
        r104 = r104 + 1;
        goto L5
    L21:
        int r108 = r105;
    L24:
        return r108;
    L22:
        r108 = 0;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean equals(Object r210) {
        if (r210 != this) goto L6;
        return true;
    L6:
        if ((r210 instanceof SieveCache) == true) goto L8;
        return false;
    L8:
        SieveCache r100 = (SieveCache) r210;
        if (r100.getSize() == getSize()) goto L11;
    L34:
        return false;
    L11:
        if (r100._count != this._count) goto L34;
        Object[] r101 = this.keys;
        Object[] r102 = this.values;
        long[] r103 = this.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L32;
        int r105 = 0;
    L16:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L30;
        int r110 = 8 - ((~(r105 - r104)) >>> 31);
        int r111 = 0;
    L19:
        if (r111 >= r110) goto L29;
        if ((255 & r106) >= 128) goto L23;
        boolean r112 = true;
    L24:
        if (r112 == false) goto L28;
        int r113 = (r105 << 3) + r111;
        Object r114 = r101[r113];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r107 = r102[r113];
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (Intrinsics.areEqual(r107, r100.get(r114)) == true) goto L28;
        return false;
    L28:
        r106 = r106 >> 8;
        r111 = r111 + 1;
        goto L19
    L23:
        r112 = false;
        goto L24
    L29:
        if (r110 == 8) goto L30;
        return true;
    L30:
        if (r105 == r104) goto L42;
        r105 = r105 + 1;
        goto L16
    L42:
        return true;
    L32:
        return true;
    }

    public final void forEach(Function2<? super K, ? super V, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.keys;
        Object[] r101 = this.values;
        long[] r102 = this.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L19;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r111 = 8 - ((~(r104 - r103)) >>> 31);
        int r112 = 0;
    L8:
        if (r112 >= r111) goto L16;
        if ((255 & r105) >= 128) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L15;
        int r114 = (r104 << 3) + r112;
        Object r115 = r100[r114];
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r116 = r101[r114];
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        r110.invoke(r115, r116);
    L15:
        r105 = r105 >> 8;
        r112 = r112 + 1;
        goto L8
    L12:
        r113 = false;
        goto L13
    L16:
        if (r111 == 8) goto L17;
        return;
    L17:
        if (r104 == r103) goto L26;
        r104 = r104 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        long[] r100 = this.metadata;
        int r101 = r100.length - 2;
        if (r101 < 0) goto L20;
        int r102 = 0;
    L5:
        long r103 = r100[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L18;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        r110.invoke(Integer.valueOf((r102 << 3) + r105));
    L15:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L16:
        if (r104 == 8) goto L18;
        return;
    L18:
        if (r102 == r101) goto L26;
        r102 = r102 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachKey(Function1<? super K, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.keys;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L19;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L16;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L15;
        Object r113 = r100[(r103 << 3) + r111];
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        r110.invoke(r113);
    L15:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L16:
        if (r105 == 8) goto L17;
        return;
    L17:
        if (r103 == r102) goto L26;
        r103 = r103 + 1;
        goto L5
    L26:
        return;
    }

    public final void forEachValue(Function1<? super V, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "block");
        Object[] r100 = this.values;
        long[] r101 = this.metadata;
        int r102 = r101.length - 2;
        if (r102 < 0) goto L19;
        int r103 = 0;
    L5:
        long r104 = r101[r103];
        if (((((~r104) << 7) & r104) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r105 = 8 - ((~(r103 - r102)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r105) goto L16;
        if ((255 & r104) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L15;
        Object r113 = r100[(r103 << 3) + r111];
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        r110.invoke(r113);
    L15:
        r104 = r104 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L16:
        if (r105 == 8) goto L17;
        return;
    L17:
        if (r103 == r102) goto L26;
        r103 = r103 + 1;
        goto L5
    L26:
        return;
    }

    public final V get(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r101 = findKeyIndex(r100);
        if (r101 < 0) goto L6;
        long[] r102 = this.nodes;
        r102[r101] = (r102[r101] & 4611686018427387903L) | SieveCacheKt.NodeVisitedBit;
        return (V) this.values[r101];
    L6:
        V r103 = this.createValueFromKey.invoke(r100);
        if (r103 != null) goto L10;
        return null;
    L10:
        put(r100, r103);
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> r110) {
        Intrinsics.checkNotNullParameter(r110, "keys");
        Object[] r100 = r110.elements;
        long[] r111 = r110.metadata;
        int r101 = r111.length - 2;
        if (r101 < 0) goto L19;
        int r102 = 0;
    L5:
        long r103 = r111[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L16;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L15;
        remove(r100[(r102 << 3) + r105]);
    L15:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L16:
        if (r104 == 8) goto L17;
        return;
    L17:
        if (r102 == r101) goto L26;
        r102 = r102 + 1;
        goto L5
    L26:
        return;
    }

    public final void plusAssign(Pair<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "pair");
        put(r100.getFirst(), r100.getSecond());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(SieveCache<K, V> r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Object[] r100 = r110.keys;
        Object[] r101 = r110.values;
        long[] r102 = r110.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r106) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L16;
        int r113 = (r104 << 3) + r111;
        Object r114 = r100[r113];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r115 = r101[r113];
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        put(r114, r115);
    L16:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r106 == 8) goto L21;
        return;
    L21:
        if (r104 == r103) goto L31;
        r104 = r104 + 1;
        goto L5
    L31:
        return;
    }

    public final V remove(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r101 = findKeyIndex(r100);
        if (r101 < 0) goto L9;
        V r102 = removeValueAt(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        this._size -= this.sizeOf.invoke(r100, r102).intValue();
        this.onEntryRemoved.invoke(r100, r102, null, Boolean.FALSE);
        return r102;
    L9:
        return null;
    }

    public final void removeIf(Function2<? super K, ? super V, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r110, "predicate");
        long[] r100 = this.metadata;
        int r101 = r100.length - 2;
        if (r101 < 0) goto L24;
        int r102 = 0;
    L5:
        long r103 = r100[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L21;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L20;
        int r107 = (r102 << 3) + r105;
        Object r111 = this.keys[r107];
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        Object r112 = this.values[r107];
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type V of androidx.collection.SieveCache");
        if (r110.invoke(r111, r112).booleanValue() == false) goto L20;
        V r108 = removeValueAt(r107);
        if (r108 == null) goto L18;
        this._size -= this.sizeOf.invoke((K) r111, r108).intValue();
        this.onEntryRemoved.invoke((K) r111, r108, null, Boolean.FALSE);
        goto L20
    L18:
        return;
    L20:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L21:
        if (r104 == 8) goto L22;
        return;
    L22:
        if (r102 == r101) goto L33;
        r102 = r102 + 1;
        goto L5
    L33:
        return;
    }

    public final void resize(int r100) {
        this._maxSize = r100;
        trimToSize(r100);
    }

    public final void resizeStorage$collection(int r210) {
        long[] r100 = this.metadata;
        Object[] r101 = this.keys;
        Object[] r102 = this.values;
        long[] r103 = this.nodes;
        int r104 = this._capacity;
        int[] r105 = new int[r104];
        initializeStorage(r210);
        long[] r106 = this.metadata;
        Object[] r107 = this.keys;
        Object[] r108 = this.values;
        long[] r110 = this.nodes;
        int r111 = this._capacity;
        int r112 = 0;
    L3:
        if (r112 >= r104) goto L16;
        if (((r100[r112 >> 3] >> ((r112 & 7) << 3)) & 255) >= 128) goto L7;
        boolean r113 = true;
    L8:
        if (r113 == false) goto L14;
        Object r114 = r101[r112];
        if (r114 == null) goto L12;
        int r115 = r114.hashCode();
    L13:
        int r116 = r115 * ScatterMapKt.MurmurHashC1;
        int r117 = r116 ^ (r116 << 16);
        int r118 = findFirstAvailableSlot(r117 >>> 7);
        long r109 = r117 & 127;
        int r119 = r118 >> 3;
        int r211 = (r118 & 7) << 3;
        int[] r212 = r105;
        long r120 = (r109 << r211) | (r106[r119] & (~(255 << r211)));
        r106[r119] = r120;
        r106[(((r118 - 7) & r111) + (r111 & 7)) >> 3] = r120;
        r107[r118] = r114;
        r108[r118] = r102[r112];
        r110[r118] = r103[r112];
        r212[r112] = r118;
    L15:
        r112 = r112 + 1;
        r100 = r100;
        r101 = r101;
        r104 = r104;
        r105 = r212;
        goto L3
    L12:
        r115 = 0;
        goto L13
    L14:
        r212 = r105;
        goto L15
    L7:
        r113 = false;
        goto L8
    L16:
        fixupNodes(r105);
    }

    public final void trimToSize(int r100) {
    L3:
        if (this._size <= r100) goto L14;
        if (getCount() == 0) goto L22;
        int r101 = findEvictionCandidate();
        if (r101 == Integer.MAX_VALUE) goto L9;
        Object r102 = this.keys[r101];
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type K of androidx.collection.SieveCache");
        V r103 = removeValueAt(r101);
        if (r103 == null) goto L3;
        this._size -= this.sizeOf.invoke((K) r102, r103).intValue();
        this.onEntryRemoved.invoke((K) r102, r103, null, Boolean.TRUE);
        goto L3
    L9:
        return;
    L22:
        return;
    }

    private final void fixupNodes(int[] r110) {
        long[] r100 = this.nodes;
        int r101 = r100.length;
        int r102 = 0;
    L3:
        int r103 = Integer.MAX_VALUE;
        if (r102 >= r101) goto L14;
        long r104 = r100[r102];
        int r105 = (int) ((r104 >> 31) & SieveCacheKt.NodeLinkMask);
        int r106 = (int) (SieveCacheKt.NodeLinkMask & r104);
        long r107 = r104 & SieveCacheKt.NodeMetaMask;
        if (r105 != Integer.MAX_VALUE) goto L8;
        int r108 = Integer.MAX_VALUE;
    L9:
        long r109 = (r107 | ((long) r108)) << 31;
        if (r106 == Integer.MAX_VALUE) goto L13;
        r103 = r110[r106];
    L13:
        r100[r102] = r109 | ((long) r103);
        r102 = r102 + 1;
        goto L3
    L8:
        r108 = r110[r105];
        goto L9
    L14:
        int r111 = this.head;
        if (r111 == Integer.MAX_VALUE) goto L17;
        this.head = r110[r111];
    L17:
        int r112 = this.tail;
        if (r112 == Integer.MAX_VALUE) goto L20;
        this.tail = r110[r112];
    L20:
        int r113 = this.hand;
        if (r113 == Integer.MAX_VALUE) goto L27;
        this.hand = r110[r113];
        return;
    }

    public final void minusAssign(Iterable<? extends K> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Iterator<? extends K> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        remove(r101.next());
        goto L4
    }

    public final void plusAssign(ScatterMap<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        putAll(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ScatterMap<K, V> r110) {
        Intrinsics.checkNotNullParameter(r110, "from");
        Object[] r100 = r110.keys;
        Object[] r101 = r110.values;
        long[] r102 = r110.metadata;
        int r103 = r102.length - 2;
        if (r103 < 0) goto L24;
        int r104 = 0;
    L5:
        long r105 = r102[r104];
        if (((((~r105) << 7) & r105) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L21;
        int r106 = 8 - ((~(r104 - r103)) >>> 31);
        int r111 = 0;
    L8:
        if (r111 >= r106) goto L18;
        if ((255 & r105) >= 128) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L16;
        int r113 = (r104 << 3) + r111;
        put(r100[r113], r101[r113]);
    L16:
        r105 = r105 >> 8;
        r111 = r111 + 1;
        goto L8
    L12:
        r112 = false;
        goto L13
    L18:
        if (r106 == 8) goto L21;
        return;
    L21:
        if (r104 == r103) goto L31;
        r104 = r104 + 1;
        goto L5
    L31:
        return;
    }

    public final void minusAssign(Sequence<? extends K> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Iterator<? extends K> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        remove(r101.next());
        goto L4
    }

    public final void plusAssign(SieveCache<K, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        putAll(r100);
    }

    public final void putAll(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Iterator<Map.Entry<K, ? extends V>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<K, ? extends V> r102 = r101.next();
        put(r102.getKey(), r102.getValue());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<K> r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        Object[] r101 = r100.content;
        int r102 = r100._size;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        remove(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public final void plusAssign(Iterable<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        putAll(r100);
    }

    public final void putAll(Iterable<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r102 = r101.next();
        put(r102.component1(), r102.component2());
        goto L4
    }

    public final void minusAssign(K[] r100) {
        Intrinsics.checkNotNullParameter(r100, "keys");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        remove(r100[r102]);
        r102 = r102 + 1;
        goto L3
    }

    public final void plusAssign(Map<K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        putAll(r100);
    }

    public final void putAll(Sequence<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r102 = r101.next();
        put(r102.component1(), r102.component2());
        goto L4
    }

    public final void minusAssign(K r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        remove(r100);
    }

    public final void plusAssign(Sequence<? extends Pair<? extends K, ? extends V>> r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        putAll(r100);
    }

    public final void putAll(Pair<? extends K, ? extends V>[] r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<? extends K, ? extends V> r103 = r100[r102];
        put(r103.component1(), r103.component2());
        r102 = r102 + 1;
        goto L3
    }

    public final void plusAssign(Pair<? extends K, ? extends V>[] r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        putAll(r100);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final V put(K r110, V r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "value");
        int r100 = findInsertIndex(r110);
        if (r100 >= 0) goto L5;
        r100 = ~r100;
    L5:
        Object[] r101 = this.values;
        V r102 = (V) r101[r100];
        r101[r100] = r111;
        this.keys[r100] = r110;
        int r103 = this._size + this.sizeOf.invoke(r110, r111).intValue();
        this._size = r103;
        if (r102 == null) goto L9;
        this._size = r103 - ((Number) this.sizeOf.invoke(r110, r102)).intValue();
        this.onEntryRemoved.invoke(r110, r102, r111, Boolean.FALSE);
        trimToSize(this._maxSize);
        return r102;
    L9:
        trimToSize(this._maxSize);
        long[] r112 = this.nodes;
        int r113 = this.head;
        r112[r100] = (((long) r113) & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (r113 == Integer.MAX_VALUE) goto L12;
        r112[r113] = (r112[r113] & SieveCacheKt.NodeMetaAndNextMask) | ((SieveCacheKt.NodeLinkMask & ((long) r100)) << 31);
    L12:
        this.head = r100;
        if (this.tail != Integer.MAX_VALUE) goto L15;
        this.tail = r100;
    L15:
        return r102;
    }

    public final boolean remove(K r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        int r102 = findKeyIndex(r100);
        if (r102 >= 0) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(this.values[r102], r101) == false) goto L11;
        V r103 = removeValueAt(r102);
        if (r103 != null) goto L9;
        return false;
    L9:
        this._size -= this.sizeOf.invoke(r100, r103).intValue();
        this.onEntryRemoved.invoke(r100, r103, null, Boolean.FALSE);
        return true;
    }

    public final void set(K r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        put(r100, r101);
    }

    private static final Unit _init_$lambda$1(Object r100, Object r101, Object r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SieveCache(int r100, int r101, Function2<? super K, ? super V, Integer> r102, Function1<? super K, ? extends V> r103, Function4<? super K, ? super V, ? super V, ? super Boolean, Unit> r104) {
        Intrinsics.checkNotNullParameter(r102, "sizeOf");
        Intrinsics.checkNotNullParameter(r103, "createValueFromKey");
        Intrinsics.checkNotNullParameter(r104, "onEntryRemoved");
        this.sizeOf = r102;
        this.createValueFromKey = r103;
        this.onEntryRemoved = r104;
        this.metadata = ScatterMapKt.EmptyGroup;
        Object[] r105 = ContainerHelpersKt.EMPTY_OBJECTS;
        this.keys = r105;
        this.values = r105;
        this.nodes = SieveCacheKt.getEmptyNodes();
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
        this.hand = Integer.MAX_VALUE;
        if (r100 <= 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L8;
        RuntimeHelpersKt.throwIllegalArgumentException("maxSize must be > 0");
    L8:
        this._maxSize = r100;
        initializeStorage(ScatterMapKt.unloadedCapacity(r101));
        return;
    L5:
        r106 = false;
        goto L6
    }

    public /* synthetic */ SieveCache(int r100, int r101, Function2 r102, Function1 r110, Function4 r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        int r103 = 6;
    L7:
        if ((r112 & 4) == 0) goto L9;
        r102 = new d();
    L9:
        Function2 r104 = r102;
        if ((r112 & 8) == 0) goto L12;
        r110 = AnonymousClass2.INSTANCE;
    L12:
        Function1 r105 = r110;
        if ((r112 & 16) == 0) goto L15;
        r111 = new e();
    L15:
        this(r100, r103, r104, r105, r111);
        return;
    L5:
        r103 = r101;
        goto L7
    }
}
