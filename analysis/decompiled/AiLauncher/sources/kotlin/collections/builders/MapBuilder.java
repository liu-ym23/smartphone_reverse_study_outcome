package kotlin.collections.builders;

import Z8.AbstractC1156d;
import a9.C1242b;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import q9.InterfaceC5162a;
import q9.e;
import v9.C5685n;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0006inoqklBG\b\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010B\t\b\u0016¢\u0006\u0004\b\u000f\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u0011J\u0017\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u0013J\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\fH\u0002¢\u0006\u0004\b$\u0010\u0013J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00192\u0006\u0010*\u001a\u00020 H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0002\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0002\u0010\u0013J\u0017\u0010/\u001a\u00020 2\u0006\u0010.\u001a\u00020\fH\u0002¢\u0006\u0004\b/\u0010\"J\u0017\u00100\u001a\u00020\f2\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0004\b0\u0010)J\u0017\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00028\u0001H\u0002¢\u0006\u0004\b2\u0010)J\u0017\u00104\u001a\u00020\u00192\u0006\u00103\u001a\u00020\fH\u0002¢\u0006\u0004\b4\u0010\u0013J\u0017\u00106\u001a\u00020\u00192\u0006\u00105\u001a\u00020\fH\u0002¢\u0006\u0004\b6\u0010\u0013J\u001f\u00109\u001a\u00020 2\u000e\u00108\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000307H\u0002¢\u0006\u0004\b9\u0010:J#\u0010=\u001a\u00020 2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;H\u0002¢\u0006\u0004\b=\u0010>J)\u0010A\u001a\u00020 2\u0018\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;0?H\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020 H\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020 2\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020 2\u0006\u00101\u001a\u00028\u0001H\u0016¢\u0006\u0004\bI\u0010HJ\u001a\u0010J\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\bJ\u0010KJ!\u0010L\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u0001H\u0016¢\u0006\u0004\bL\u0010MJ%\u0010N\u001a\u00020\u00192\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000107H\u0016¢\u0006\u0004\bN\u0010OJ\u0019\u0010P\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u0000H\u0016¢\u0006\u0004\bP\u0010KJ\u000f\u0010Q\u001a\u00020\u0019H\u0016¢\u0006\u0004\bQ\u0010\u0011J\u001a\u0010R\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u00010\u0014H\u0096\u0002¢\u0006\u0004\bR\u0010HJ\u000f\u0010S\u001a\u00020\fH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u0019H\u0000¢\u0006\u0004\bX\u0010\u0011J\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010'\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001d\u0010)J\u0017\u0010Y\u001a\u00020 2\u0006\u0010'\u001a\u00028\u0000H\u0000¢\u0006\u0004\bY\u0010HJ#\u0010Z\u001a\u00020 2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;H\u0000¢\u0006\u0004\bZ\u0010>J\u001b\u0010\\\u001a\u00020 2\n\u0010[\u001a\u0006\u0012\u0002\b\u00030?H\u0000¢\u0006\u0004\b\\\u0010BJ#\u0010]\u001a\u00020 2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;H\u0000¢\u0006\u0004\b]\u0010>J\u0017\u0010_\u001a\u00020 2\u0006\u0010^\u001a\u00028\u0001H\u0000¢\u0006\u0004\b_\u0010HJ\u001b\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010`H\u0000¢\u0006\u0004\ba\u0010bJ\u001b\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010cH\u0000¢\u0006\u0004\bd\u0010eJ\u001b\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010fH\u0000¢\u0006\u0004\bg\u0010hR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010jR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010mR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010pR\u0016\u0010s\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010pR\u0016\u0010u\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010pR$\u0010w\u001a\u00020\f2\u0006\u00101\u001a\u00020\f8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b.\u0010p\u001a\u0004\bv\u0010TR\u001e\u0010{\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u001e\u0010\u007f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R(\u0010\u0083\u0001\u001a\u0011\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R&\u0010\u0085\u0001\u001a\u00020 2\u0006\u00101\u001a\u00020 8\u0000@BX\u0080\u000e¢\u0006\r\n\u0004\b[\u0010Y\u001a\u0005\b\u0084\u0001\u0010FR\u0016\u0010\u0087\u0001\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010TR\u001d\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0088\u00018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0089\u0001R\u001e\u0010\u008e\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R+\u0010\u0091\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u008f\u00010\u0088\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0090\u0001\u0010\u0089\u0001R\u0016\u0010\u0093\u0001\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010T¨\u0006\u0094\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "keysArray", "valuesArray", "", "presenceArray", "hashArray", "", "maxProbeDistance", "length", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "()V", "initialCapacity", "(I)V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "U", "n", "z", "extraCapacity", "", "b0", "(I)Z", "minCapacity", "y", "q", "()[Ljava/lang/Object;", "key", "O", "(Ljava/lang/Object;)I", "updateHashArray", "u", "(Z)V", "newHashSize", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, ExifInterface.GPS_DIRECTION_TRUE, "D", UxipConstants.f30680s, "F", "index", "X", "removedHash", "Y", "", "other", "x", "(Ljava/util/Map;)Z", "", "entry", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/Map$Entry;)Z", "", "from", "R", "(Ljava/util/Collection;)Z", "s", "()Ljava/util/Map;", "isEmpty", "()Z", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "(Ljava/util/Map;)V", "remove", "clear", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "t", "Z", "w", "m", "v", ExifInterface.LONGITUDE_WEST, "element", "a0", "Lkotlin/collections/builders/MapBuilder$e;", "Q", "()Lkotlin/collections/builders/MapBuilder$e;", "Lkotlin/collections/builders/MapBuilder$f;", "c0", "()Lkotlin/collections/builders/MapBuilder$f;", "Lkotlin/collections/builders/MapBuilder$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lkotlin/collections/builders/MapBuilder$b;", Const.INTENT_KEY_APIKEY, "[Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "c", "[I", Const.INTENT_KEY_UMID, "e", "I", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "hashShift", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "modCount", "L", ContentDisposition.Parameters.Size, "Lkotlin/collections/builders/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lkotlin/collections/builders/b;", "keysView", "Lkotlin/collections/builders/c;", "k", "Lkotlin/collections/builders/c;", "valuesView", "Lkotlin/collections/builders/a;", "l", "Lkotlin/collections/builders/a;", "entriesView", "P", "isReadOnly", "J", "hashSize", "", "()Ljava/util/Set;", "keys", "", "N", "()Ljava/util/Collection;", "values", "", "H", "entries", "G", "capacity", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, q9.e {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: o, reason: collision with root package name */
    public static final MapBuilder f34743o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public K[] keysArray;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public V[] valuesArray;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int[] presenceArray;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int[] hashArray;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int maxProbeDistance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int length;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int hashShift;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int modCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int size;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public kotlin.collections.builders.b<K> keysView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public kotlin.collections.builders.c<V> valuesView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public a<K, V> entriesView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public boolean isReadOnly;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\n\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lkotlin/collections/builders/MapBuilder$a;", "", "<init>", "()V", "", "capacity", "c", "(I)I", "hashSize", Const.INTENT_KEY_UMID, "Lkotlin/collections/builders/MapBuilder;", "", "Empty", "Lkotlin/collections/builders/MapBuilder;", "e", "()Lkotlin/collections/builders/MapBuilder;", "MAGIC", "I", "INITIAL_CAPACITY", "INITIAL_MAX_PROBE_DISTANCE", "TOMBSTONE", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.collections.builders.MapBuilder$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final int c(int capacity) {
            return Integer.highestOneBit(C5685n.f(capacity, 1) * 3);
        }

        public final int d(int hashSize) {
            return Integer.numberOfLeadingZeros(hashSize) + 1;
        }

        public final MapBuilder e() {
            return MapBuilder.f34743o;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0004B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlin/collections/builders/MapBuilder$b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$d;", "", "", "Lkotlin/collections/builders/MapBuilder;", C3081a.FOCUS_MAP_NAME, "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "Lkotlin/collections/builders/MapBuilder$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lkotlin/collections/builders/MapBuilder$c;", "", "l", "()I", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "LY8/t;", "k", "(Ljava/lang/StringBuilder;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, InterfaceC5162a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapBuilder<K, V> map) {
            super(map);
            p.i(map, "map");
        }

        @Override // java.util.Iterator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            a();
            if (getIndex() >= e().length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            g(index + 1);
            i(index);
            c<K, V> cVar = new c<>(e(), getLastIndex());
            f();
            return cVar;
        }

        public final void k(StringBuilder sb2) {
            p.i(sb2, "sb");
            if (getIndex() >= e().length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            g(index + 1);
            i(index);
            Object obj = e().keysArray[getLastIndex()];
            if (obj == e()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = e().valuesArray;
            p.f(objArr);
            Object obj2 = objArr[getLastIndex()];
            if (obj2 == e()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            f();
        }

        public final int l() {
            if (getIndex() >= e().length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            g(index + 1);
            i(index);
            Object obj = e().keysArray[getLastIndex()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = e().valuesArray;
            p.f(objArr);
            Object obj2 = objArr[getLastIndex()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            f();
            return iHashCode2;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00028\u00032\u0006\u0010\r\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0014\u0010!\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Lkotlin/collections/builders/MapBuilder$c;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/collections/builders/MapBuilder;", C3081a.FOCUS_MAP_NAME, "", "index", "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/collections/builders/MapBuilder;", Const.INTENT_KEY_PKGNAME, "I", "c", "expectedModCount", "getKey", "()Ljava/lang/Object;", "key", "getValue", UxipConstants.f30680s, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c<K, V> implements Map.Entry<K, V>, e.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final MapBuilder<K, V> map;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int index;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final int expectedModCount;

        public c(MapBuilder<K, V> map, int i10) {
            p.i(map, "map");
            this.map = map;
            this.index = i10;
            this.expectedModCount = map.modCount;
        }

        private final void a() {
            if (this.map.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object other) {
            if (!(other instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) other;
            return p.d(entry.getKey(), getKey()) && p.d(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            a();
            return (K) this.map.keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            a();
            Object[] objArr = this.map.valuesArray;
            p.f(objArr);
            return (V) objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            a();
            this.map.t();
            Object[] objArrQ = this.map.q();
            int i10 = this.index;
            V v10 = (V) objArrQ[i10];
            objArrQ[i10] = newValue;
            return v10;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000f\u0010\nR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015¨\u0006\u001f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$d;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/collections/builders/MapBuilder;", C3081a.FOCUS_MAP_NAME, "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "LY8/t;", "f", "()V", "", "hasNext", "()Z", "remove", Const.INTENT_KEY_APIKEY, "Lkotlin/collections/builders/MapBuilder;", "e", "()Lkotlin/collections/builders/MapBuilder;", "", Const.INTENT_KEY_PKGNAME, "I", "()I", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)V", "index", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "lastIndex", Const.INTENT_KEY_UMID, "expectedModCount", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class d<K, V> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final MapBuilder<K, V> map;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int index;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int lastIndex;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int expectedModCount;

        public d(MapBuilder<K, V> map) {
            p.i(map, "map");
            this.map = map;
            this.lastIndex = -1;
            this.expectedModCount = map.modCount;
            f();
        }

        public final void a() {
            if (this.map.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        /* renamed from: b, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: c, reason: from getter */
        public final int getLastIndex() {
            return this.lastIndex;
        }

        public final MapBuilder<K, V> e() {
            return this.map;
        }

        public final void f() {
            while (this.index < this.map.length) {
                int[] iArr = this.map.presenceArray;
                int i10 = this.index;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.index = i10 + 1;
                }
            }
        }

        public final void g(int i10) {
            this.index = i10;
        }

        public final boolean hasNext() {
            return this.index < this.map.length;
        }

        public final void i(int i10) {
            this.lastIndex = i10;
        }

        public final void remove() {
            a();
            if (this.lastIndex == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.map.t();
            this.map.X(this.lastIndex);
            this.lastIndex = -1;
            this.expectedModCount = this.map.modCount;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$e;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$d;", "", "Lkotlin/collections/builders/MapBuilder;", C3081a.FOCUS_MAP_NAME, "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, InterfaceC5162a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapBuilder<K, V> map) {
            super(map);
            p.i(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            a();
            if (getIndex() >= e().length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            g(index + 1);
            i(index);
            K k10 = (K) e().keysArray[getLastIndex()];
            f();
            return k10;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\b\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/collections/builders/MapBuilder$f;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$d;", "", "Lkotlin/collections/builders/MapBuilder;", C3081a.FOCUS_MAP_NAME, "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, InterfaceC5162a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapBuilder<K, V> map) {
            super(map);
            p.i(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            a();
            if (getIndex() >= e().length) {
                throw new NoSuchElementException();
            }
            int index = getIndex();
            g(index + 1);
            i(index);
            Object[] objArr = e().valuesArray;
            p.f(objArr);
            V v10 = (V) objArr[getLastIndex()];
            f();
            return v10;
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        f34743o = mapBuilder;
    }

    public MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i10;
        this.length = i11;
        this.hashShift = INSTANCE.d(J());
    }

    private final void U() {
        this.modCount++;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    private final void y(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        if (minCapacity > G()) {
            int iE = AbstractC1156d.INSTANCE.e(G(), minCapacity);
            this.keysArray = (K[]) C1242b.e(this.keysArray, iE);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? (V[]) C1242b.e(vArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.presenceArray, iE);
            p.h(iArrCopyOf, "copyOf(...)");
            this.presenceArray = iArrCopyOf;
            int iC = INSTANCE.c(iE);
            if (iC > J()) {
                V(iC);
            }
        }
    }

    private final void z(int n10) {
        if (b0(n10)) {
            u(true);
        } else {
            y(this.length + n10);
        }
    }

    public final b<K, V> A() {
        return new b<>(this);
    }

    public final int D(K key) {
        int iO = O(key);
        int i10 = this.maxProbeDistance;
        while (true) {
            int i11 = this.hashArray[iO];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (p.d(this.keysArray[i12], key)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iO = iO == 0 ? J() - 1 : iO - 1;
        }
    }

    public final int F(V value) {
        int i10 = this.length;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.presenceArray[i10] >= 0) {
                V[] vArr = this.valuesArray;
                p.f(vArr);
                if (p.d(vArr[i10], value)) {
                    return i10;
                }
            }
        }
    }

    public final int G() {
        return this.keysArray.length;
    }

    public Set<Map.Entry<K, V>> H() {
        a<K, V> aVar = this.entriesView;
        if (aVar != null) {
            return aVar;
        }
        a<K, V> aVar2 = new a<>(this);
        this.entriesView = aVar2;
        return aVar2;
    }

    public final int J() {
        return this.hashArray.length;
    }

    public Set<K> K() {
        kotlin.collections.builders.b<K> bVar = this.keysView;
        if (bVar != null) {
            return bVar;
        }
        kotlin.collections.builders.b<K> bVar2 = new kotlin.collections.builders.b<>(this);
        this.keysView = bVar2;
        return bVar2;
    }

    /* renamed from: L, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public Collection<V> N() {
        kotlin.collections.builders.c<V> cVar = this.valuesView;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c<V> cVar2 = new kotlin.collections.builders.c<>(this);
        this.valuesView = cVar2;
        return cVar2;
    }

    public final int O(K key) {
        return ((key != null ? key.hashCode() : 0) * (-1640531527)) >>> this.hashShift;
    }

    /* renamed from: P, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public final e<K, V> Q() {
        return new e<>(this);
    }

    public final boolean R(Collection<? extends Map.Entry<? extends K, ? extends V>> from) {
        boolean z10 = false;
        if (from.isEmpty()) {
            return false;
        }
        z(from.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = from.iterator();
        while (it.hasNext()) {
            if (S(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean S(Map.Entry<? extends K, ? extends V> entry) {
        int iN = n(entry.getKey());
        V[] vArrQ = q();
        if (iN >= 0) {
            vArrQ[iN] = entry.getValue();
            return true;
        }
        int i10 = (-iN) - 1;
        if (p.d(entry.getValue(), vArrQ[i10])) {
            return false;
        }
        vArrQ[i10] = entry.getValue();
        return true;
    }

    public final boolean T(int i10) {
        int iO = O(this.keysArray[i10]);
        int i11 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[iO] == 0) {
                iArr[iO] = i10 + 1;
                this.presenceArray[i10] = iO;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            iO = iO == 0 ? J() - 1 : iO - 1;
        }
    }

    public final void V(int newHashSize) {
        U();
        int i10 = 0;
        if (this.length > size()) {
            u(false);
        }
        this.hashArray = new int[newHashSize];
        this.hashShift = INSTANCE.d(newHashSize);
        while (i10 < this.length) {
            int i11 = i10 + 1;
            if (!T(i10)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i10 = i11;
        }
    }

    public final boolean W(Map.Entry<? extends K, ? extends V> entry) {
        p.i(entry, "entry");
        t();
        int iD = D(entry.getKey());
        if (iD < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        p.f(vArr);
        if (!p.d(vArr[iD], entry.getValue())) {
            return false;
        }
        X(iD);
        return true;
    }

    public final void X(int index) {
        C1242b.f(this.keysArray, index);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            C1242b.f(vArr, index);
        }
        Y(this.presenceArray[index]);
        this.presenceArray[index] = -1;
        this.size = size() - 1;
        U();
    }

    public final void Y(int removedHash) {
        int iJ = C5685n.j(this.maxProbeDistance * 2, J() / 2);
        int i10 = 0;
        int i11 = removedHash;
        do {
            removedHash = removedHash == 0 ? J() - 1 : removedHash - 1;
            i10++;
            if (i10 > this.maxProbeDistance) {
                this.hashArray[i11] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i12 = iArr[removedHash];
            if (i12 == 0) {
                iArr[i11] = 0;
                return;
            }
            if (i12 < 0) {
                iArr[i11] = -1;
            } else {
                int i13 = i12 - 1;
                if (((O(this.keysArray[i13]) - removedHash) & (J() - 1)) >= i10) {
                    this.hashArray[i11] = i12;
                    this.presenceArray[i13] = i11;
                }
                iJ--;
            }
            i11 = removedHash;
            i10 = 0;
            iJ--;
        } while (iJ >= 0);
        this.hashArray[i11] = -1;
    }

    public final boolean Z(K key) {
        t();
        int iD = D(key);
        if (iD < 0) {
            return false;
        }
        X(iD);
        return true;
    }

    public final boolean a0(V element) {
        t();
        int iF = F(element);
        if (iF < 0) {
            return false;
        }
        X(iF);
        return true;
    }

    public final boolean b0(int extraCapacity) {
        int iG = G();
        int i10 = this.length;
        int i11 = iG - i10;
        int size = i10 - size();
        return i11 < extraCapacity && i11 + size >= extraCapacity && size >= G() / 4;
    }

    public final f<K, V> c0() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        t();
        int i10 = this.length - 1;
        if (i10 >= 0) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i12 = iArr[i11];
                if (i12 >= 0) {
                    this.hashArray[i12] = 0;
                    iArr[i11] = -1;
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        C1242b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            C1242b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return D(key) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return F(value) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return H();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        if (other != this) {
            return (other instanceof Map) && x((Map) other);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object key) {
        int iD = D(key);
        if (iD < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        p.f(vArr);
        return vArr[iD];
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarA = A();
        int iL = 0;
        while (bVarA.hasNext()) {
            iL += bVarA.l();
        }
        return iL;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return K();
    }

    public final int n(K key) {
        t();
        while (true) {
            int iO = O(key);
            int iJ = C5685n.j(this.maxProbeDistance * 2, J() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.hashArray[iO];
                if (i11 <= 0) {
                    if (this.length < G()) {
                        int i12 = this.length;
                        int i13 = i12 + 1;
                        this.length = i13;
                        this.keysArray[i12] = key;
                        this.presenceArray[i12] = iO;
                        this.hashArray[iO] = i13;
                        this.size = size() + 1;
                        U();
                        if (i10 > this.maxProbeDistance) {
                            this.maxProbeDistance = i10;
                        }
                        return i12;
                    }
                    z(1);
                } else {
                    if (p.d(this.keysArray[i11 - 1], key)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > iJ) {
                        V(J() * 2);
                        break;
                    }
                    iO = iO == 0 ? J() - 1 : iO - 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        t();
        int iN = n(key);
        V[] vArrQ = q();
        if (iN >= 0) {
            vArrQ[iN] = value;
            return null;
        }
        int i10 = (-iN) - 1;
        V v10 = vArrQ[i10];
        vArrQ[i10] = value;
        return v10;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        p.i(from, "from");
        t();
        R(from.entrySet());
    }

    public final V[] q() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) C1242b.d(G());
        this.valuesArray = vArr2;
        return vArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object key) {
        t();
        int iD = D(key);
        if (iD < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        p.f(vArr);
        V v10 = vArr[iD];
        X(iD);
        return v10;
    }

    public final Map<K, V> s() {
        t();
        this.isReadOnly = true;
        if (size() > 0) {
            return this;
        }
        MapBuilder mapBuilder = f34743o;
        p.g(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public final void t() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append(Const.STR_MART_JSON_BEGIN);
        b<K, V> bVarA = A();
        int i10 = 0;
        while (bVarA.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            bVarA.k(sb2);
            i10++;
        }
        sb2.append("}");
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }

    public final void u(boolean updateHashArray) {
        int i10;
        V[] vArr = this.valuesArray;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.length;
            if (i11 >= i10) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i13 = iArr[i11];
            if (i13 >= 0) {
                K[] kArr = this.keysArray;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                if (updateHashArray) {
                    iArr[i12] = i13;
                    this.hashArray[i13] = i12 + 1;
                }
                i12++;
            }
            i11++;
        }
        C1242b.g(this.keysArray, i12, i10);
        if (vArr != null) {
            C1242b.g(vArr, i12, this.length);
        }
        this.length = i12;
    }

    public final boolean v(Collection<?> m10) {
        p.i(m10, "m");
        for (Object obj : m10) {
            if (obj != null) {
                try {
                    if (!w((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return N();
    }

    public final boolean w(Map.Entry<? extends K, ? extends V> entry) {
        p.i(entry, "entry");
        int iD = D(entry.getKey());
        if (iD < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        p.f(vArr);
        return p.d(vArr[iD], entry.getValue());
    }

    public final boolean x(Map<?, ?> other) {
        return size() == other.size() && v(other.entrySet());
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i10) {
        this(C1242b.d(i10), null, new int[i10], new int[INSTANCE.c(i10)], 2, 0);
    }
}
