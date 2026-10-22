package androidx.collection;

import S7.n;
import androidx.appfunctions.metadata.a;
import androidx.collection.internal.RuntimeHelpersKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001b\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00160\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001d\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019J'\u0010\u001e\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00160\u0015H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0019J-\u0010 \u001a\u00020\u00042\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b \u0010!J-\u0010\u0005\u001a\u00020\u00042\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010!J\r\u0010\"\u001a\u00020\n¢\u0006\u0004\b\"\u0010#J-\u0010\"\u001a\u00020\n2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\"\u0010$J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0086\n¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b'\u0010&J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\f¢\u0006\u0004\b)\u0010*JA\u00102\u001a\u0002012\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020+2\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020+H\u0007¢\u0006\u0004\b2\u00103Ja\u00102\u001a\u0002012\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020+2\b\b\u0002\u0010/\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020+2\u001a\b\u0004\u00104\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020+0\u001aH\u0087\bø\u0001\u0000¢\u0006\u0004\b2\u00105J\u000f\u00106\u001a\u00020\nH\u0016¢\u0006\u0004\b6\u0010#J\u001a\u00108\u001a\u00020\u00042\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u000201H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0004\b<\u0010=R\u001c\u0010?\u001a\u00020>8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b?\u0010@\u0012\u0004\bA\u0010\u0003R\u001c\u0010C\u001a\u00020B8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bC\u0010D\u0012\u0004\bE\u0010\u0003R\u001c\u0010F\u001a\u00020>8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bF\u0010@\u0012\u0004\bG\u0010\u0003R\u001c\u0010H\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bH\u0010I\u0012\u0004\bJ\u0010\u0003R\u001c\u0010K\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\bK\u0010I\u0012\u0004\bL\u0010\u0003R\u0011\u0010N\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bM\u0010#R\u0011\u0010P\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bO\u0010#\u0082\u0001\u0001Q\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006R"}, d2 = {"Landroidx/collection/IntLongMap;", "", AppAgent.CONSTRUCT, "()V", "", "any", "()Z", "none", "isEmpty", "isNotEmpty", "", "key", "", "get", "(I)J", "defaultValue", "getOrDefault", "(IJ)J", "Lkotlin/Function0;", "getOrElse", "(ILS7/a;)J", "Lkotlin/Function1;", "LC7/r;", "block", "forEachIndexed", "(LS7/k;)V", "Lkotlin/Function2;", "forEach", "(LS7/n;)V", "forEachKey", "forEachValue", "predicate", "all", "(LS7/n;)Z", "count", "()I", "(LS7/n;)I", "contains", "(I)Z", "containsKey", "value", "containsValue", "(J)Z", "", "separator", "prefix", "postfix", "limit", "truncated", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "transform", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/n;)Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "findKeyIndex", "(I)I", "", "metadata", "[J", "getMetadata$annotations", "", "keys", "[I", "getKeys$annotations", "values", "getValues$annotations", "_capacity", "I", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableIntLongMap;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntLongMap {
    public int _capacity;
    public int _size;
    public int[] keys;
    public long[] metadata;
    public long[] values;

    public /* synthetic */ IntLongMap(e eVar) {
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

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
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
        return intLongMap.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean all(n predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j5 = jArr2[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        if (!((Boolean) predicate.invoke(Integer.valueOf(iArr[i11]), Long.valueOf(jArr[i11]))).booleanValue()) {
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

    public final boolean contains(int key) {
        return containsKey(key);
    }

    public final boolean containsKey(int key) {
        return findKeyIndex(key) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsValue(long r14) {
        /*
            r13 = this;
            long[] r0 = r13.values
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L46
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
            if (r6 == 0) goto L41
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L3f
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L3b
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            int r9 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r9 != 0) goto L3b
            r13 = 1
            return r13
        L3b:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L3f:
            if (r6 != r7) goto L46
        L41:
            if (r3 == r1) goto L46
            int r3 = r3 + 1
            goto Lb
        L46:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.containsValue(long):boolean");
    }

    public final int count() {
        return get_size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
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
            boolean r3 = r1 instanceof androidx.collection.IntLongMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.IntLongMap r1 = (androidx.collection.IntLongMap) r1
            int r3 = r1.get_size()
            int r5 = r0.get_size()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            int[] r3 = r0.keys
            long[] r5 = r0.values
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L6d
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
            if (r10 == 0) goto L68
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r4
        L41:
            if (r12 >= r10) goto L66
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L62
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r15 = r5[r13]
            int r13 = r1.findKeyIndex(r14)
            if (r13 < 0) goto L61
            long[] r14 = r1.values
            r13 = r14[r13]
            int r13 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r13 == 0) goto L62
        L61:
            return r4
        L62:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L41
        L66:
            if (r10 != r11) goto L6d
        L68:
            if (r7 == r6) goto L6d
            int r7 = r7 + 1
            goto L27
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex(int key) {
        int iHashCode = Integer.hashCode(key) * ScatterMapKt.MurmurHashC1;
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
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr2[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        block.invoke(Integer.valueOf(iArr[i11]), Long.valueOf(jArr[i11]));
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
        int[] iArr = this.keys;
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
                        block.invoke(Integer.valueOf(iArr[(i << 3) + i10]));
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
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr2[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        block.invoke(Long.valueOf(jArr[(i << 3) + i10]));
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

    public final long get(int key) {
        int iFindKeyIndex = findKeyIndex(key);
        if (iFindKeyIndex < 0) {
            RuntimeHelpersKt.throwNoSuchElementException("Cannot find value for key " + key);
        }
        return this.values[iFindKeyIndex];
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final long getOrDefault(int key, long defaultValue) {
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : defaultValue;
    }

    public final long getOrElse(int key, S7.a defaultValue) {
        k.f(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(key);
        return iFindKeyIndex < 0 ? ((Number) defaultValue.invoke()).longValue() : this.values[iFindKeyIndex];
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j5 = jArr2[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        int i11 = (i << 3) + i10;
                        iHashCode += Integer.hashCode(iArr[i11]) ^ Long.hashCode(jArr[i11]);
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

    public String toString() {
        int i;
        int i6;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                long j5 = jArr2[i10];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8 - ((~(i10 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((255 & j5) < 128) {
                            int i14 = (i10 << 3) + i13;
                            int i15 = iArr[i14];
                            i6 = i10;
                            long j6 = jArr[i14];
                            sb.append(i15);
                            sb.append("=");
                            sb.append(j6);
                            i11++;
                            if (i11 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i6 = i10;
                        }
                        j5 >>= 8;
                        i13++;
                        i10 = i6;
                    }
                    int i16 = i10;
                    if (i12 != 8) {
                        break;
                    }
                    i = i16;
                } else {
                    i = i10;
                }
                if (i == length) {
                    break;
                }
                i10 = i + 1;
            }
        }
        return a.h('}', "toString(...)", sb);
    }

    private IntLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean any(S7.n r15) {
        /*
            r14 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.k.f(r15, r0)
            int[] r0 = r14.keys
            long[] r1 = r14.values
            long[] r14 = r14.metadata
            int r2 = r14.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L5f
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
            if (r7 == 0) goto L5a
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L2c:
            if (r9 >= r7) goto L58
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L54
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r0[r10]
            r12 = r1[r10]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            java.lang.Long r11 = java.lang.Long.valueOf(r12)
            java.lang.Object r10 = r15.invoke(r10, r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L54
            r14 = 1
            return r14
        L54:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L2c
        L58:
            if (r7 != r8) goto L5f
        L5a:
            if (r4 == r2) goto L5f
            int r4 = r4 + 1
            goto L12
        L5f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.any(S7.n):boolean");
    }

    public final int count(n predicate) {
        k.f(predicate, "predicate");
        int[] iArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int i6 = 0;
        while (true) {
            long j5 = jArr2[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j5) < 128) {
                        int i12 = (i << 3) + i11;
                        if (((Boolean) predicate.invoke(Integer.valueOf(iArr[i12]), Long.valueOf(jArr[i12]))).booleanValue()) {
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[PHI: r9
      0x0076: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x0031, B:18:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r4 = r0.keys
            long[] r5 = r0.values
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L7b
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
            if (r12 == 0) goto L76
            int r12 = r8 - r6
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L3d:
            if (r14 >= r12) goto L74
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L70
            int r15 = r8 << 3
            int r15 = r15 + r14
            r16 = r4[r15]
            r17 = r5[r15]
            r15 = -1
            if (r9 != r15) goto L58
            java.lang.String r0 = "..."
            r3.append(r0)
            goto L80
        L58:
            if (r9 == 0) goto L5d
            r3.append(r1)
        L5d:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r16)
            java.lang.Long r7 = java.lang.Long.valueOf(r17)
            java.lang.Object r7 = r2.invoke(r15, r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.append(r7)
            int r9 = r9 + 1
        L70:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L3d
        L74:
            if (r12 != r13) goto L7b
        L76:
            if (r8 == r6) goto L7b
            int r8 = r8 + 1
            goto L23
        L7b:
            java.lang.String r0 = ""
            r3.append(r0)
        L80:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, S7.n):java.lang.String");
    }

    public static /* synthetic */ String joinToString$default(IntLongMap intLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, n nVar, int i6, Object obj) {
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
            int[] iArr = intLongMap.keys;
            long[] jArr3 = intLongMap.values;
            long[] jArr4 = intLongMap.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i12 = 0;
                int i13 = 0;
                loop0: while (true) {
                    long j5 = jArr4[i12];
                    int i14 = i12;
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i15 = 8;
                        int i16 = 8 - ((~(i14 - length)) >>> 31);
                        int i17 = 0;
                        while (i17 < i16) {
                            if ((j5 & 255) < 128) {
                                int i18 = (i14 << 3) + i17;
                                int i19 = iArr[i18];
                                long j6 = jArr3[i18];
                                if (i13 == i11) {
                                    sbV.append(charSequence5);
                                    break loop0;
                                }
                                if (i13 != 0) {
                                    sbV.append(separator);
                                }
                                i10 = i15;
                                jArr2 = jArr4;
                                sbV.append((CharSequence) nVar.invoke(Integer.valueOf(i19), Long.valueOf(j6)));
                                i13++;
                            } else {
                                jArr2 = jArr4;
                                i10 = i15;
                            }
                            j5 >>= i10;
                            i17++;
                            i15 = i10;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        if (i16 != i15) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i14 == length) {
                        break;
                    }
                    i12 = i14 + 1;
                    jArr4 = jArr;
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
        int[] iArr = this.keys;
        long[] jArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                long j5 = jArr4[i10];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i10 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j5 & 255) < 128) {
                            int i15 = (i10 << 3) + i14;
                            int i16 = iArr[i15];
                            long j6 = jArr3[i15];
                            if (i11 == i) {
                                sbV.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i11 != 0) {
                                sbV.append(separator);
                            }
                            i6 = i12;
                            jArr2 = jArr4;
                            sbV.append((CharSequence) nVar.invoke(Integer.valueOf(i16), Long.valueOf(j6)));
                            i11++;
                        } else {
                            jArr2 = jArr4;
                            i6 = i12;
                        }
                        j5 >>= i6;
                        i14++;
                        i12 = i6;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i13 != i12) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                jArr4 = jArr;
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
        int i6;
        k.f(separator, "separator");
        k.f(prefix, "prefix");
        StringBuilder sbW = a.w(postfix, "postfix", truncated, "truncated", prefix);
        int[] iArr = this.keys;
        long[] jArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i10 = 0;
            int i11 = 0;
            loop0: while (true) {
                long j5 = jArr4[i10];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i12 = 8;
                    int i13 = 8 - ((~(i10 - length)) >>> 31);
                    int i14 = 0;
                    while (i14 < i13) {
                        if ((j5 & 255) < 128) {
                            int i15 = (i10 << 3) + i14;
                            int i16 = iArr[i15];
                            i = i12;
                            i6 = i14;
                            long j6 = jArr3[i15];
                            jArr2 = jArr4;
                            if (i11 == limit) {
                                sbW.append(truncated);
                                break loop0;
                            }
                            if (i11 != 0) {
                                sbW.append(separator);
                            }
                            sbW.append(i16);
                            sbW.append('=');
                            sbW.append(j6);
                            i11++;
                        } else {
                            jArr2 = jArr4;
                            i = i12;
                            i6 = i14;
                        }
                        j5 >>= i;
                        i14 = i6 + 1;
                        i12 = i;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i13 != i12) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i10 == length) {
                    break;
                }
                i10++;
                jArr4 = jArr;
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
        CharSequence separator2 = separator;
        k.f(separator2, "separator");
        k.f(prefix, "prefix");
        k.f(postfix, "postfix");
        StringBuilder sbV = a.v(truncated, "truncated", transform, "transform", prefix);
        int[] iArr = this.keys;
        long[] jArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j5 = jArr4[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j5 & 255) < 128) {
                            int i14 = (i6 << 3) + i13;
                            int i15 = iArr[i14];
                            long j6 = jArr3[i14];
                            i = i11;
                            if (i10 == limit) {
                                sbV.append(truncated);
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbV.append(separator2);
                            }
                            jArr2 = jArr4;
                            sbV.append((CharSequence) transform.invoke(Integer.valueOf(i15), Long.valueOf(j6)));
                            i10++;
                        } else {
                            jArr2 = jArr4;
                            i = i11;
                        }
                        j5 >>= i;
                        i13++;
                        separator2 = separator;
                        i11 = i;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i12 != i11) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
                separator2 = separator;
                jArr4 = jArr;
            }
            sbV.append(postfix);
        } else {
            sbV.append(postfix);
        }
        String string = sbV.toString();
        k.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[PHI: r10
      0x0088: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0038, B:20:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r5 = r0.keys
            long[] r6 = r0.values
            long[] r0 = r0.metadata
            int r7 = r0.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L8d
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
            if (r13 == 0) goto L88
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L44:
            if (r15 >= r13) goto L85
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L7c
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r5[r16]
            r18 = r6[r16]
            r8 = -1
            if (r10 != r8) goto L61
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L90
        L61:
            if (r10 == 0) goto L66
            r2.append(r1)
        L66:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)
            r22 = r14
            java.lang.Long r14 = java.lang.Long.valueOf(r18)
            java.lang.Object r8 = r4.invoke(r8, r14)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.append(r8)
            int r10 = r10 + 1
            goto L7e
        L7c:
            r22 = r14
        L7e:
            long r11 = r11 >> r22
            int r15 = r15 + 1
            r14 = r22
            goto L44
        L85:
            r8 = r14
            if (r13 != r8) goto L8d
        L88:
            if (r9 == r7) goto L8d
            int r9 = r9 + 1
            goto L2a
        L8d:
            r2.append(r3)
        L90:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, S7.n):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[PHI: r10
      0x0083: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0033, B:20:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r5 = r0.keys
            long[] r6 = r0.values
            long[] r0 = r0.metadata
            int r7 = r0.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L88
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
            if (r13 == 0) goto L83
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L3f:
            if (r15 >= r13) goto L80
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L77
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r5[r16]
            r18 = r6[r16]
            r8 = -1
            if (r10 != r8) goto L5c
            java.lang.String r0 = "..."
            r3.append(r0)
            goto L8b
        L5c:
            if (r10 == 0) goto L61
            r3.append(r1)
        L61:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r17)
            r16 = r14
            java.lang.Long r14 = java.lang.Long.valueOf(r18)
            java.lang.Object r8 = r2.invoke(r8, r14)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.append(r8)
            int r10 = r10 + 1
            goto L79
        L77:
            r16 = r14
        L79:
            long r11 = r11 >> r16
            int r15 = r15 + 1
            r14 = r16
            goto L3f
        L80:
            r8 = r14
            if (r13 != r8) goto L88
        L83:
            if (r9 == r7) goto L88
            int r9 = r9 + 1
            goto L25
        L88:
            r3.append(r4)
        L8b:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.joinToString(java.lang.CharSequence, S7.n):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0073 A[PHI: r9
      0x0073: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x002c, B:18:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r4 = r0.keys
            long[] r5 = r0.values
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L78
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
            if (r12 == 0) goto L73
            int r12 = r8 - r6
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L38:
            if (r14 >= r12) goto L71
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L6d
            int r15 = r8 << 3
            int r15 = r15 + r14
            r16 = r4[r15]
            r17 = r5[r15]
            r15 = -1
            if (r9 != r15) goto L53
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L7b
        L53:
            if (r9 == 0) goto L5a
            java.lang.String r15 = ", "
            r2.append(r15)
        L5a:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r16)
            java.lang.Long r7 = java.lang.Long.valueOf(r17)
            java.lang.Object r7 = r1.invoke(r15, r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.append(r7)
            int r9 = r9 + 1
        L6d:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L38
        L71:
            if (r12 != r13) goto L78
        L73:
            if (r8 == r6) goto L78
            int r8 = r8 + 1
            goto L1e
        L78:
            r2.append(r3)
        L7b:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntLongMap.joinToString(S7.n):java.lang.String");
    }
}
