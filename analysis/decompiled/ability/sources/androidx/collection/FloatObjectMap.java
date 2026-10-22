package androidx.collection;

import S7.n;
import androidx.appfunctions.metadata.a;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001c\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00170\u0015H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001aJ'\u0010\u001f\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u0015H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001aJ-\u0010!\u001a\u00020\u00052\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"J-\u0010\u0006\u001a\u00020\u00052\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\"J\r\u0010#\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J-\u0010#\u001a\u00020\u00162\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u001bH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010%J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0086\n¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b(\u0010'J\u0015\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u0000¢\u0006\u0004\b*\u0010+JA\u00103\u001a\u0002022\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020,2\b\b\u0002\u00100\u001a\u00020\u00162\b\b\u0002\u00101\u001a\u00020,H\u0007¢\u0006\u0004\b3\u00104Ja\u00103\u001a\u0002022\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020,2\b\b\u0002\u0010/\u001a\u00020,2\b\b\u0002\u00100\u001a\u00020\u00162\b\b\u0002\u00101\u001a\u00020,2\u001a\b\u0004\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0\u001bH\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u00106J\u000f\u00107\u001a\u00020\u0016H\u0016¢\u0006\u0004\b7\u0010$J\u001a\u00109\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b9\u0010+J\u000f\u0010:\u001a\u000202H\u0016¢\u0006\u0004\b:\u0010;J\u0018\u0010>\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0080\b¢\u0006\u0004\b<\u0010=R\u001c\u0010@\u001a\u00020?8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b@\u0010A\u0012\u0004\bB\u0010\u0004R\u001c\u0010D\u001a\u00020C8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bD\u0010E\u0012\u0004\bF\u0010\u0004R$\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020G8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bH\u0010I\u0012\u0004\bJ\u0010\u0004R\u001c\u0010K\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bK\u0010L\u0012\u0004\bM\u0010\u0004R\u001c\u0010N\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bN\u0010L\u0012\u0004\bO\u0010\u0004R\u0011\u0010Q\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\bP\u0010$R\u0011\u0010S\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\bR\u0010$\u0082\u0001\u0001T\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006U"}, d2 = {"Landroidx/collection/FloatObjectMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", AppAgent.CONSTRUCT, "()V", "", "any", "()Z", "none", "isEmpty", "isNotEmpty", "", "key", "get", "(F)Ljava/lang/Object;", "defaultValue", "getOrDefault", "(FLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(FLS7/a;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "LC7/r;", "block", "forEachIndexed", "(LS7/k;)V", "Lkotlin/Function2;", "forEach", "(LS7/n;)V", "forEachKey", "forEachValue", "predicate", "all", "(LS7/n;)Z", "count", "()I", "(LS7/n;)I", "contains", "(F)Z", "containsKey", "value", "containsValue", "(Ljava/lang/Object;)Z", "", "separator", "prefix", "postfix", "limit", "truncated", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "transform", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/n;)Ljava/lang/String;", "hashCode", "other", "equals", "toString", "()Ljava/lang/String;", "findKeyIndex$collection", "(F)I", "findKeyIndex", "", "metadata", "[J", "getMetadata$annotations", "", "keys", "[F", "getKeys$annotations", "", "values", "[Ljava/lang/Object;", "getValues$annotations", "_capacity", "I", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableFloatObjectMap;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FloatObjectMap<V> {
    public int _capacity;
    public int _size;
    public float[] keys;
    public long[] metadata;
    public Object[] values;

    public /* synthetic */ FloatObjectMap(e eVar) {
        this();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public static /* synthetic */ String joinToString$default(FloatObjectMap floatObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i6 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i6 & 8) != 0) {
            i = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return floatObjectMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean all(n predicate) {
        k.f(predicate, "predicate");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        if (!((Boolean) predicate.invoke(Float.valueOf(fArr[i11]), objArr[i11])).booleanValue()) {
                            return false;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean contains(float key) {
        return containsKey(key);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0065, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0067, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsKey(float r17) {
        /*
            r16 = this;
            r0 = r16
            int r1 = java.lang.Float.hashCode(r17)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = r4
        L16:
            long[] r6 = r0.metadata
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r6 = r6[r7]
            int r12 = 64 - r8
            long r6 = r6 << r12
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L41:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L5e
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            float[] r14 = r0.keys
            r14 = r14[r10]
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L58
            goto L68
        L58:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L41
        L5e:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L6c
            r10 = -1
        L68:
            if (r10 < 0) goto L6b
            return r11
        L6b:
            return r4
        L6c:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.containsKey(float):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsValue(V r14) {
        /*
            r13 = this;
            java.lang.Object[] r0 = r13.values
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L48
            r3 = r2
        Lb:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L43
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L41
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L3d
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            boolean r9 = kotlin.jvm.internal.k.b(r14, r9)
            if (r9 == 0) goto L3d
            r13 = 1
            return r13
        L3d:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L41:
            if (r6 != r7) goto L48
        L43:
            if (r3 == r1) goto L48
            int r3 = r3 + 1
            goto Lb
        L48:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.containsValue(java.lang.Object):boolean");
    }

    public final int count() {
        return get_size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof androidx.collection.FloatObjectMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.FloatObjectMap r1 = (androidx.collection.FloatObjectMap) r1
            int r3 = r1.get_size()
            int r5 = r0.get_size()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            float[] r3 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L78
            r7 = r4
        L27:
            r8 = r0[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L73
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L41:
            if (r12 >= r10) goto L71
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L6d
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r5[r13]
            if (r13 != 0) goto L62
            java.lang.Object r13 = r1.get(r14)
            if (r13 != 0) goto L61
            boolean r13 = r1.containsKey(r14)
            if (r13 != 0) goto L6d
        L61:
            return r4
        L62:
            java.lang.Object r14 = r1.get(r14)
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L6d
            return r4
        L6d:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L41
        L71:
            if (r10 != r11) goto L78
        L73:
            if (r7 == r6) goto L78
            int r7 = r7 + 1
            goto L27
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex$collection(float key) {
        int iHashCode = Float.hashCode(key) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i6 = i & 127;
        int i10 = this._capacity;
        int i11 = (i >>> 7) & i10;
        int i12 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i13 = i11 >> 3;
            int i14 = (i11 & 7) << 3;
            long j5 = ((jArr[i13 + 1] << (64 - i14)) & ((-i14) >> 63)) | (jArr[i13] >>> i14);
            long j6 = (i6 * ScatterMapKt.BitmaskLsb) ^ j5;
            for (long j10 = (~j6) & (j6 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i11) & i10;
                if (this.keys[iNumberOfTrailingZeros] == key) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i12 += 8;
            i11 = (i11 + i12) & i10;
        }
    }

    public final void forEach(n block) {
        k.f(block, "block");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        block.invoke(Float.valueOf(fArr[i11]), objArr[i11]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEachIndexed(S7.k block) {
        k.f(block, "block");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        a.y(i << 3, i10, block);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEachKey(S7.k block) {
        k.f(block, "block");
        float[] fArr = this.keys;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        block.invoke(Float.valueOf(fArr[(i << 3) + i10]));
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEachValue(S7.k block) {
        k.f(block, "block");
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        block.invoke(objArr[(i << 3) + i10]);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V get(float r14) {
        /*
            r13 = this;
            int r0 = java.lang.Float.hashCode(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r4 = r4[r5]
            int r9 = 64 - r6
            long r4 = r4 << r9
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3e:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L5b
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            float[] r11 = r13.keys
            r11 = r11[r10]
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 != 0) goto L55
            goto L65
        L55:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3e
        L5b:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L6e
            r10 = -1
        L65:
            if (r10 < 0) goto L6c
            java.lang.Object[] r13 = r13.values
            r13 = r13[r10]
            return r13
        L6c:
            r13 = 0
            return r13
        L6e:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.get(float):java.lang.Object");
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final V getOrDefault(float r14, V r15) {
        /*
            r13 = this;
            int r0 = java.lang.Float.hashCode(r14)
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r1
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L13:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r4 = r4[r5]
            int r9 = 64 - r6
            long r4 = r4 << r9
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3e:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L5b
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            float[] r11 = r13.keys
            r11 = r11[r10]
            int r11 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r11 != 0) goto L55
            goto L65
        L55:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3e
        L5b:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L6d
            r10 = -1
        L65:
            if (r10 < 0) goto L6c
            java.lang.Object[] r13 = r13.values
            r13 = r13[r10]
            return r13
        L6c:
            return r15
        L6d:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.getOrDefault(float, java.lang.Object):java.lang.Object");
    }

    public final V getOrElse(float key, S7.a defaultValue) {
        k.f(defaultValue, "defaultValue");
        V v10 = get(key);
        return v10 == null ? (V) defaultValue.invoke() : v10;
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        float f = fArr[i11];
                        Object obj = objArr[i11];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Float.hashCode(f);
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e A[PHI: r8
      0x006e: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:10:0x0030, B:22:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r18 = this;
            r0 = r18
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto Lc
            java.lang.String r0 = "{}"
            return r0
        Lc:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "{"
            r1.<init>(r2)
            float[] r2 = r0.keys
            java.lang.Object[] r3 = r0.values
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L73
            r6 = 0
            r7 = r6
            r8 = r7
        L22:
            r9 = r4[r7]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L6e
            int r11 = r7 - r5
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r6
        L3c:
            if (r13 >= r11) goto L6c
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L68
            int r14 = r7 << 3
            int r14 = r14 + r13
            r15 = r2[r14]
            r14 = r3[r14]
            r1.append(r15)
            java.lang.String r15 = "="
            r1.append(r15)
            if (r14 != r0) goto L5a
            java.lang.String r14 = "(this)"
        L5a:
            r1.append(r14)
            int r8 = r8 + 1
            int r14 = r0._size
            if (r8 >= r14) goto L68
            java.lang.String r14 = ", "
            r1.append(r14)
        L68:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L3c
        L6c:
            if (r11 != r12) goto L73
        L6e:
            if (r7 == r5) goto L73
            int r7 = r7 + 1
            goto L22
        L73:
            r0 = 125(0x7d, float:1.75E-43)
            java.lang.String r2 = "toString(...)"
            java.lang.String r0 = androidx.appfunctions.metadata.a.h(r0, r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.toString():java.lang.String");
    }

    private FloatObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = FloatSetKt.getEmptyFloatArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean any(S7.n r15) {
        /*
            r14 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.k.f(r15, r0)
            float[] r0 = r14.keys
            java.lang.Object[] r1 = r14.values
            long[] r14 = r14.metadata
            int r2 = r14.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L5b
            r4 = r3
        L12:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L56
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L2c:
            if (r9 >= r7) goto L54
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L50
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r0[r10]
            r10 = r1[r10]
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r10 = r15.invoke(r11, r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L50
            r14 = 1
            return r14
        L50:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L2c
        L54:
            if (r7 != r8) goto L5b
        L56:
            if (r4 == r2) goto L5b
            int r4 = r4 + 1
            goto L12
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.any(S7.n):boolean");
    }

    public final int count(n predicate) {
        k.f(predicate, "predicate");
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i6 = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j5) < 128) {
                        int i12 = (i << 3) + i11;
                        if (((Boolean) predicate.invoke(Float.valueOf(fArr[i12]), objArr[i12])).booleanValue()) {
                            i6++;
                        }
                    }
                    j5 >>= 8;
                }
                if (i10 != 8) {
                    return i6;
                }
            }
            if (i == length) {
                return i6;
            }
            i++;
        }
    }

    public final String joinToString(CharSequence separator) {
        k.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[PHI: r9
      0x0072: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x0031, B:18:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r20, java.lang.CharSequence r21, S7.n r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.k.f(r1, r3)
            java.lang.String r3 = "prefix"
            java.lang.String r4 = "transform"
            r5 = r21
            java.lang.StringBuilder r3 = androidx.appfunctions.metadata.a.v(r5, r3, r2, r4, r5)
            float[] r4 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L77
            r8 = 0
            r9 = 0
        L23:
            r10 = r0[r8]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L72
            int r12 = r8 - r6
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L3d:
            if (r14 >= r12) goto L70
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L6c
            int r15 = r8 << 3
            int r15 = r15 + r14
            r16 = r4[r15]
            r15 = r5[r15]
            r7 = -1
            if (r9 != r7) goto L58
            java.lang.String r0 = "..."
            r3.append(r0)
            goto L7c
        L58:
            if (r9 == 0) goto L5d
            r3.append(r1)
        L5d:
            java.lang.Float r7 = java.lang.Float.valueOf(r16)
            java.lang.Object r7 = r2.invoke(r7, r15)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.append(r7)
            int r9 = r9 + 1
        L6c:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L3d
        L70:
            if (r12 != r13) goto L77
        L72:
            if (r8 == r6) goto L77
            int r8 = r8 + 1
            goto L23
        L77:
            java.lang.String r0 = ""
            r3.append(r0)
        L7c:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, S7.n):java.lang.String");
    }

    public static /* synthetic */ String joinToString$default(FloatObjectMap floatObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n nVar, int i6, Object obj) {
        long[] jArr;
        long[] jArr2;
        int i10;
        if (obj == null) {
            CharSequence separator = (i6 & 1) != 0 ? ", " : charSequence;
            CharSequence prefix = (i6 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i6 & 4) == 0 ? charSequence3 : "";
            int i11 = (i6 & 8) != 0 ? -1 : i;
            CharSequence charSequence5 = (i6 & 16) != 0 ? "..." : charSequence4;
            k.f(separator, "separator");
            k.f(prefix, "prefix");
            k.f(postfix, "postfix");
            StringBuilder sbV = a.v(charSequence5, "truncated", nVar, "transform", prefix);
            float[] fArr = floatObjectMap.keys;
            Object[] objArr = floatObjectMap.values;
            long[] jArr3 = floatObjectMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i12 = 0;
                int i13 = 0;
                loop0: while (true) {
                    long j5 = jArr3[i12];
                    int i14 = i12;
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i15 = 8;
                        int i16 = 8 - ((~(i14 - length)) >>> 31);
                        int i17 = 0;
                        while (i17 < i16) {
                            if ((j5 & 255) < 128) {
                                int i18 = (i14 << 3) + i17;
                                float f = fArr[i18];
                                i10 = i15;
                                Object obj2 = objArr[i18];
                                if (i13 == i11) {
                                    sbV.append(charSequence5);
                                    break loop0;
                                }
                                if (i13 != 0) {
                                    sbV.append(separator);
                                }
                                jArr2 = jArr3;
                                sbV.append((CharSequence) nVar.invoke(Float.valueOf(f), obj2));
                                i13++;
                            } else {
                                jArr2 = jArr3;
                                i10 = i15;
                            }
                            j5 >>= i10;
                            i17++;
                            i15 = i10;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i16 != i15) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i14 == length) {
                        break;
                    }
                    i12 = i14 + 1;
                    jArr3 = jArr;
                }
                sbV.append(postfix);
            } else {
                sbV.append(postfix);
            }
            String string = sbV.toString();
            k.e(string, "toString(...)");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i, n nVar) {
        long[] jArr;
        long[] jArr2;
        int i6;
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        StringBuilder sbV = a.v(charSequence, "postfix", nVar, "transform", prefix);
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                long j5 = jArr3[i10];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i10 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j5 & 255) < 128) {
                            int i15 = (i10 << 3) + i14;
                            float f = fArr[i15];
                            Object obj = objArr[i15];
                            i6 = i12;
                            if (i11 == i) {
                                sbV.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i11 != 0) {
                                sbV.append(separator);
                            }
                            jArr2 = jArr3;
                            sbV.append((CharSequence) nVar.invoke(Float.valueOf(f), obj));
                            i11++;
                        } else {
                            jArr2 = jArr3;
                            i6 = i12;
                        }
                        j5 >>= i6;
                        i14++;
                        i12 = i6;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i13 != i12) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                jArr3 = jArr;
            }
            sbV.append(charSequence);
        } else {
            sbV.append(charSequence);
        }
        String string = sbV.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        long[] jArr;
        long[] jArr2;
        int i;
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        StringBuilder sbW = a.w(postfix, "postfix", truncated, "truncated", prefix);
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j5 = jArr3[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j5 & 255) < 128) {
                            int i14 = (i6 << 3) + i13;
                            float f = fArr[i14];
                            i = i11;
                            Object obj = objArr[i14];
                            jArr2 = jArr3;
                            if (i10 == limit) {
                                sbW.append(truncated);
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbW.append(separator);
                            }
                            sbW.append(f);
                            sbW.append('=');
                            sbW.append(obj);
                            i10++;
                        } else {
                            jArr2 = jArr3;
                            i = i11;
                        }
                        j5 >>= i;
                        i13++;
                        i11 = i;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i12 != i11) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                jArr3 = jArr;
            }
            sbW.append(postfix);
        } else {
            sbW.append(postfix);
        }
        String string = sbW.toString();
        k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, n transform) {
        long[] jArr;
        long[] jArr2;
        int i;
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        k.f(postfix, "postfix");
        StringBuilder sbV = a.v(truncated, "truncated", transform, "transform", prefix);
        float[] fArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j5 = jArr3[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j5 & 255) < 128) {
                            int i14 = (i6 << 3) + i13;
                            float f = fArr[i14];
                            i = i11;
                            Object obj = objArr[i14];
                            jArr2 = jArr3;
                            if (i10 == limit) {
                                sbV.append(truncated);
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbV.append(separator);
                            }
                            sbV.append((CharSequence) transform.invoke(Float.valueOf(f), obj));
                            i10++;
                        } else {
                            jArr2 = jArr3;
                            i = i11;
                        }
                        j5 >>= i;
                        i13++;
                        i11 = i;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i12 != i11) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                jArr3 = jArr;
            }
            sbV.append(postfix);
        } else {
            sbV.append(postfix);
        }
        String string = sbV.toString();
        k.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0084 A[PHI: r10
      0x0084: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0038, B:20:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r21, java.lang.CharSequence r22, java.lang.CharSequence r23, S7.n r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            java.lang.String r5 = "separator"
            kotlin.jvm.internal.k.f(r1, r5)
            java.lang.String r5 = "prefix"
            kotlin.jvm.internal.k.f(r2, r5)
            java.lang.String r5 = "postfix"
            java.lang.String r6 = "transform"
            java.lang.StringBuilder r2 = androidx.appfunctions.metadata.a.v(r3, r5, r4, r6, r2)
            float[] r5 = r0.keys
            java.lang.Object[] r6 = r0.values
            long[] r0 = r0.metadata
            int r7 = r0.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L89
            r9 = 0
            r10 = 0
        L2a:
            r11 = r0[r9]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L84
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L44:
            if (r15 >= r13) goto L81
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L78
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r5[r16]
            r8 = r6[r16]
            r22 = r14
            r14 = -1
            if (r10 != r14) goto L63
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L8c
        L63:
            if (r10 == 0) goto L68
            r2.append(r1)
        L68:
            java.lang.Float r14 = java.lang.Float.valueOf(r17)
            java.lang.Object r8 = r4.invoke(r14, r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.append(r8)
            int r10 = r10 + 1
            goto L7a
        L78:
            r22 = r14
        L7a:
            long r11 = r11 >> r22
            int r15 = r15 + 1
            r14 = r22
            goto L44
        L81:
            r8 = r14
            if (r13 != r8) goto L89
        L84:
            if (r9 == r7) goto L89
            int r9 = r9 + 1
            goto L2a
        L89:
            r2.append(r3)
        L8c:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, S7.n):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[PHI: r10
      0x007f: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0033, B:20:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r21, S7.n r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.k.f(r1, r3)
            java.lang.String r3 = "transform"
            kotlin.jvm.internal.k.f(r2, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = ""
            r3.<init>(r4)
            float[] r5 = r0.keys
            java.lang.Object[] r6 = r0.values
            long[] r0 = r0.metadata
            int r7 = r0.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L84
            r9 = 0
            r10 = 0
        L25:
            r11 = r0[r9]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L7f
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L3f:
            if (r15 >= r13) goto L7c
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L73
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r5[r16]
            r8 = r6[r16]
            r16 = r14
            r14 = -1
            if (r10 != r14) goto L5e
            java.lang.String r0 = "..."
            r3.append(r0)
            goto L87
        L5e:
            if (r10 == 0) goto L63
            r3.append(r1)
        L63:
            java.lang.Float r14 = java.lang.Float.valueOf(r17)
            java.lang.Object r8 = r2.invoke(r14, r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.append(r8)
            int r10 = r10 + 1
            goto L75
        L73:
            r16 = r14
        L75:
            long r11 = r11 >> r16
            int r15 = r15 + 1
            r14 = r16
            goto L3f
        L7c:
            r8 = r14
            if (r13 != r8) goto L84
        L7f:
            if (r9 == r7) goto L84
            int r9 = r9 + 1
            goto L25
        L84:
            r3.append(r4)
        L87:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.joinToString(java.lang.CharSequence, S7.n):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006f A[PHI: r9
      0x006f: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x002c, B:18:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(S7.n r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = "transform"
            kotlin.jvm.internal.k.f(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ""
            r2.<init>(r3)
            float[] r4 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L74
            r8 = 0
            r9 = 0
        L1e:
            r10 = r0[r8]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L6f
            int r12 = r8 - r6
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L38:
            if (r14 >= r12) goto L6d
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L69
            int r15 = r8 << 3
            int r15 = r15 + r14
            r16 = r4[r15]
            r15 = r5[r15]
            r7 = -1
            if (r9 != r7) goto L53
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L77
        L53:
            if (r9 == 0) goto L5a
            java.lang.String r7 = ", "
            r2.append(r7)
        L5a:
            java.lang.Float r7 = java.lang.Float.valueOf(r16)
            java.lang.Object r7 = r1.invoke(r7, r15)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.append(r7)
            int r9 = r9 + 1
        L69:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L38
        L6d:
            if (r12 != r13) goto L74
        L6f:
            if (r8 == r6) goto L74
            int r8 = r8 + 1
            goto L1e
        L74:
            r2.append(r3)
        L77:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatObjectMap.joinToString(S7.n):java.lang.String");
    }
}
