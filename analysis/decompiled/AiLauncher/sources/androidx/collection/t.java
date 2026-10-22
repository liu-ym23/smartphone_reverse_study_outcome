package androidx.collection;

import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import c0.C1481a;
import c0.C1484d;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0018\u0010\b\u001a\u0014\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\tJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ.\u0010\u0012\u001a\u00028\u0002\"\n\b\u0002\u0010\u0010*\u0004\u0018\u00018\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u0002H\u0082\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u001dJ\u0017\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b!\u0010\u001bJ\u001a\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\b$\u0010\u0013J\u0017\u0010&\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00028\u00012\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010'J\u001f\u0010)\u001a\u00028\u00012\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0019H\u0016¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b-\u0010\u0013J'\u0010.\u001a\u00020\u00142\u0016\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000H\u0016¢\u0006\u0004\b.\u0010\tJ!\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b/\u0010\u0013J\u0019\u00100\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u0010#J\u001f\u00100\u001a\u00020\u00192\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00028\u00012\u0006\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010'J!\u00103\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b3\u0010\u0013J'\u00103\u001a\u00020\u00192\u0006\u0010\n\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u00012\u0006\u00105\u001a\u00028\u0001H\u0016¢\u0006\u0004\b3\u00106J\u000f\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u0010\u000fJ\u001a\u00109\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b9\u0010\u001bJ\u000f\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b:\u0010\u000fJ\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010D¨\u0006E"}, d2 = {"Landroidx/collection/t;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "capacity", "<init>", "(I)V", C3081a.FOCUS_MAP_NAME, "(Landroidx/collection/t;)V", "key", "hash", "indexOf", "(Ljava/lang/Object;I)I", "indexOfNull", "()I", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", "getOrDefaultInternal", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "LY8/t;", "clear", "()V", "minimumCapacity", "ensureCapacity", "", "containsKey", "(Ljava/lang/Object;)Z", "indexOfKey", "(Ljava/lang/Object;)I", UxipConstants.f30680s, "__restricted$indexOfValue", "indexOfValue", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "index", "keyAt", "(I)Ljava/lang/Object;", "valueAt", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", ContentDisposition.Parameters.Size, "other", "equals", "hashCode", "", "toString", "()Ljava/lang/String;", "", "hashes", "[I", "", "array", "[Ljava/lang/Object;", "I", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public class t<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public t() {
        this(0, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object key, T defaultValue) {
        int iIndexOfKey = indexOfKey(key);
        return iIndexOfKey >= 0 ? (T) this.array[(iIndexOfKey << 1) + 1] : defaultValue;
    }

    private final int indexOf(K key, int hash) {
        int i10 = this.size;
        if (i10 == 0) {
            return -1;
        }
        int iA = C1481a.a(this.hashes, i10, hash);
        if (iA < 0 || kotlin.jvm.internal.p.d(key, this.array[iA << 1])) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.hashes[i11] == hash) {
            if (kotlin.jvm.internal.p.d(key, this.array[i11 << 1])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.hashes[i12] == hash; i12--) {
            if (kotlin.jvm.internal.p.d(key, this.array[i12 << 1])) {
                return i12;
            }
        }
        return ~i11;
    }

    private final int indexOfNull() {
        int i10 = this.size;
        if (i10 == 0) {
            return -1;
        }
        int iA = C1481a.a(this.hashes, i10, 0);
        if (iA < 0 || this.array[iA << 1] == null) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.hashes[i11] == 0) {
            if (this.array[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.hashes[i12] == 0; i12--) {
            if (this.array[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public final int __restricted$indexOfValue(V value) {
        int i10 = this.size * 2;
        Object[] objArr = this.array;
        if (value == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (kotlin.jvm.internal.p.d(value, objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = C1481a.f15396a;
            this.array = C1481a.f15398c;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K key) {
        return indexOfKey(key) >= 0;
    }

    public boolean containsValue(V value) {
        return __restricted$indexOfValue(value) >= 0;
    }

    public void ensureCapacity(int minimumCapacity) {
        int i10 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < minimumCapacity) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, minimumCapacity);
            kotlin.jvm.internal.p.h(iArrCopyOf, "copyOf(...)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, minimumCapacity * 2);
            kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
            this.array = objArrCopyOf;
        }
        if (this.size != i10) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        try {
            if (other instanceof t) {
                if (getSize() != ((t) other).getSize()) {
                    return false;
                }
                t tVar = (t) other;
                int i10 = this.size;
                for (int i11 = 0; i11 < i10; i11++) {
                    K kKeyAt = keyAt(i11);
                    V vValueAt = valueAt(i11);
                    Object obj = tVar.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj != null || !tVar.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!kotlin.jvm.internal.p.d(vValueAt, obj)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(other instanceof Map) || getSize() != ((Map) other).size()) {
                return false;
            }
            int i12 = this.size;
            for (int i13 = 0; i13 < i12; i13++) {
                K kKeyAt2 = keyAt(i13);
                V vValueAt2 = valueAt(i13);
                Object obj2 = ((Map) other).get(kKeyAt2);
                if (vValueAt2 == null) {
                    if (obj2 != null || !((Map) other).containsKey(kKeyAt2)) {
                        return false;
                    }
                } else if (!kotlin.jvm.internal.p.d(vValueAt2, obj2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public V get(K key) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey >= 0) {
            return (V) this.array[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object key, V defaultValue) {
        int iIndexOfKey = indexOfKey(key);
        return iIndexOfKey >= 0 ? (V) this.array[(iIndexOfKey << 1) + 1] : defaultValue;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i10 = this.size;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public int indexOfKey(K key) {
        return key == null ? indexOfNull() : indexOf(key, key.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int index) {
        boolean z10 = false;
        if (index >= 0 && index < this.size) {
            z10 = true;
        }
        if (!z10) {
            C1484d.a("Expected index to be within 0..size()-1, but was " + index);
        }
        return (K) this.array[index << 1];
    }

    public V put(K key, V value) {
        int i10 = this.size;
        int iHashCode = key != null ? key.hashCode() : 0;
        int iIndexOf = key != null ? indexOf(key, iHashCode) : indexOfNull();
        if (iIndexOf >= 0) {
            int i11 = (iIndexOf << 1) + 1;
            Object[] objArr = this.array;
            V v10 = (V) objArr[i11];
            objArr[i11] = value;
            return v10;
        }
        int i12 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i13);
            kotlin.jvm.internal.p.h(iArrCopyOf, "copyOf(...)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i13 << 1);
            kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
            this.array = objArrCopyOf;
            if (i10 != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i12 < i10) {
            int[] iArr2 = this.hashes;
            int i14 = i12 + 1;
            C1168p.g(iArr2, iArr2, i14, i12, i10);
            Object[] objArr2 = this.array;
            C1168p.i(objArr2, objArr2, i14 << 1, i12 << 1, this.size << 1);
        }
        int i15 = this.size;
        if (i10 == i15) {
            int[] iArr3 = this.hashes;
            if (i12 < iArr3.length) {
                iArr3[i12] = iHashCode;
                Object[] objArr3 = this.array;
                int i16 = i12 << 1;
                objArr3[i16] = key;
                objArr3[i16 + 1] = value;
                this.size = i15 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(t<? extends K, ? extends V> map) {
        kotlin.jvm.internal.p.i(map, "map");
        int i10 = map.size;
        ensureCapacity(this.size + i10);
        if (this.size != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(map.keyAt(i11), map.valueAt(i11));
            }
        } else if (i10 > 0) {
            C1168p.g(map.hashes, this.hashes, 0, 0, i10);
            C1168p.i(map.array, this.array, 0, 0, i10 << 1);
            this.size = i10;
        }
    }

    public V putIfAbsent(K key, V value) {
        V v10 = get(key);
        return v10 == null ? put(key, value) : v10;
    }

    public V remove(K key) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public V removeAt(int index) {
        if (!(index >= 0 && index < this.size)) {
            C1484d.a("Expected index to be within 0..size()-1, but was " + index);
        }
        Object[] objArr = this.array;
        int i10 = index << 1;
        V v10 = (V) objArr[i10 + 1];
        int i11 = this.size;
        if (i11 <= 1) {
            clear();
            return v10;
        }
        int i12 = i11 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (index < i12) {
                int i13 = index + 1;
                C1168p.g(iArr, iArr, index, i13, i11);
                Object[] objArr2 = this.array;
                C1168p.i(objArr2, objArr2, i10, i13 << 1, i11 << 1);
            }
            Object[] objArr3 = this.array;
            int i14 = i12 << 1;
            objArr3[i14] = null;
            objArr3[i14 + 1] = null;
        } else {
            int i15 = i11 > 8 ? i11 + (i11 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i15);
            kotlin.jvm.internal.p.h(iArrCopyOf, "copyOf(...)");
            this.hashes = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.array, i15 << 1);
            kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
            this.array = objArrCopyOf;
            if (i11 != this.size) {
                throw new ConcurrentModificationException();
            }
            if (index > 0) {
                C1168p.g(iArr, this.hashes, 0, 0, index);
                C1168p.i(objArr, this.array, 0, 0, i10);
            }
            if (index < i12) {
                int i16 = index + 1;
                C1168p.g(iArr, this.hashes, index, i16, i11);
                C1168p.i(objArr, this.array, i10, i16 << 1, i11 << 1);
            }
        }
        if (i11 != this.size) {
            throw new ConcurrentModificationException();
        }
        this.size = i12;
        return v10;
    }

    public V replace(K key, V value) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, value);
        }
        return null;
    }

    public V setValueAt(int index, V value) {
        boolean z10 = false;
        if (index >= 0 && index < this.size) {
            z10 = true;
        }
        if (!z10) {
            C1484d.a("Expected index to be within 0..size()-1, but was " + index);
        }
        int i10 = (index << 1) + 1;
        Object[] objArr = this.array;
        V v10 = (V) objArr[i10];
        objArr[i10] = value;
        return v10;
    }

    /* renamed from: size, reason: from getter */
    public int getSize() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.size * 28);
        sb2.append('{');
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            K kKeyAt = keyAt(i11);
            if (kKeyAt != sb2) {
                sb2.append(kKeyAt);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vValueAt = valueAt(i11);
            if (vValueAt != sb2) {
                sb2.append(vValueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return string;
    }

    public V valueAt(int index) {
        boolean z10 = false;
        if (index >= 0 && index < this.size) {
            z10 = true;
        }
        if (!z10) {
            C1484d.a("Expected index to be within 0..size()-1, but was " + index);
        }
        return (V) this.array[(index << 1) + 1];
    }

    public t(int i10) {
        this.hashes = i10 == 0 ? C1481a.f15396a : new int[i10];
        this.array = i10 == 0 ? C1481a.f15398c : new Object[i10 << 1];
    }

    public boolean remove(K key, V value) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0 || !kotlin.jvm.internal.p.d(value, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        int iIndexOfKey = indexOfKey(key);
        if (iIndexOfKey < 0 || !kotlin.jvm.internal.p.d(oldValue, valueAt(iIndexOfKey))) {
            return false;
        }
        setValueAt(iIndexOfKey, newValue);
        return true;
    }

    public /* synthetic */ t(int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public t(t<? extends K, ? extends V> tVar) {
        this(0, 1, null);
        if (tVar != null) {
            putAll(tVar);
        }
    }
}
