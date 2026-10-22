package androidx.collection;

import S7.k;
import androidx.annotation.IntRange;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\nH\u0086\b¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u000b\u0010\u000fJ2\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\rH\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0014\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0014\u0010\u0013J2\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0005\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0017\u0010\fJ2\u0010\u0017\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\rH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0017\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\"\u001a\u00020!2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\u001bH\u0007¢\u0006\u0004\b\"\u0010#J[\u0010\"\u001a\u00020!2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\n2\b\b\u0002\u0010 \u001a\u00020\u001b2\u0014\b\u0004\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\"\u0010%J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\fJ\u001a\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020!H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010.\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0080\b¢\u0006\u0004\b,\u0010-R\u001c\u00100\u001a\u00020/8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b0\u00101\u0012\u0004\b2\u0010\u0003R\u001c\u00104\u001a\u0002038\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b4\u00105\u0012\u0004\b6\u0010\u0003R\u0016\u00107\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0011\u0010;\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b:\u0010\fR\u0011\u0010=\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b<\u0010\f\u0082\u0001\u0001>\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006?"}, d2 = {"Landroidx/collection/IntSet;", "", AppAgent.CONSTRUCT, "()V", "", "any", "()Z", "none", "isEmpty", "isNotEmpty", "", "first", "()I", "Lkotlin/Function1;", "predicate", "(LS7/k;)I", "LC7/r;", "block", "forEachIndex", "(LS7/k;)V", "forEach", "all", "(LS7/k;)Z", "count", "element", "contains", "(I)Z", "", "separator", "prefix", "postfix", "limit", "truncated", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "transform", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/k;)Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", "findElementIndex$collection", "(I)I", "findElementIndex", "", "metadata", "[J", "getMetadata$annotations", "", "elements", "[I", "getElements$annotations", "_capacity", "I", "_size", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableIntSet;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntSet {
    public int _capacity;
    public int _size;
    public int[] elements;
    public long[] metadata;

    public /* synthetic */ IntSet(e eVar) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ String joinToString$default(IntSet intSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i6, Object obj) {
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
        return intSet.joinToString(charSequence, charSequence2, charSequence6, i, charSequence5);
    }

    public final boolean all(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        int[] iArr = this.elements;
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
                    if ((255 & j5) < 128 && !((Boolean) predicate.invoke(Integer.valueOf(iArr[(i << 3) + i10]))).booleanValue()) {
                        return false;
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(int r19) {
        /*
            r18 = this;
            r0 = r18
            int r1 = java.lang.Integer.hashCode(r19)
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
            if (r10 == 0) goto L5f
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            int[] r14 = r0.elements
            r14 = r14[r10]
            r15 = r19
            if (r14 != r15) goto L58
            goto L69
        L58:
            r16 = 1
            long r16 = r8 - r16
            long r8 = r8 & r16
            goto L41
        L5f:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r6 == 0) goto L6d
            r10 = -1
        L69:
            if (r10 < 0) goto L6c
            return r11
        L6c:
            return r4
        L6d:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.contains(int):boolean");
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    /* renamed from: count, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = 1
            if (r15 != r14) goto L4
            return r0
        L4:
            boolean r1 = r15 instanceof androidx.collection.IntSet
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            androidx.collection.IntSet r15 = (androidx.collection.IntSet) r15
            int r1 = r15._size
            int r3 = r14._size
            if (r1 == r3) goto L13
            return r2
        L13:
            int[] r1 = r14.elements
            long[] r14 = r14.metadata
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L59
            r4 = r2
        L1d:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L54
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L37:
            if (r9 >= r7) goto L52
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4e
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r10 = r15.contains(r10)
            if (r10 != 0) goto L4e
            return r2
        L4e:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L37
        L52:
            if (r7 != r8) goto L59
        L54:
            if (r4 == r3) goto L59
            int r4 = r4 + 1
            goto L1d
        L59:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.equals(java.lang.Object):boolean");
    }

    public final int findElementIndex$collection(int element) {
        int iHashCode = Integer.hashCode(element) * ScatterMapKt.MurmurHashC1;
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
                if (this.elements[iNumberOfTrailingZeros] == element) {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int first() {
        /*
            r13 = this;
            int[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            if (r1 < 0) goto L41
            r2 = 0
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
            if (r6 == 0) goto L3c
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L3a
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L36
            int r13 = r3 << 3
            int r13 = r13 + r8
            r13 = r0[r13]
            return r13
        L36:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L3a:
            if (r6 != r7) goto L41
        L3c:
            if (r3 == r1) goto L41
            int r3 = r3 + 1
            goto Lb
        L41:
            java.util.NoSuchElementException r13 = new java.util.NoSuchElementException
            java.lang.String r0 = "The IntSet is empty"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.first():int");
    }

    public final void forEach(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        int[] iArr = this.elements;
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

    public final void forEachIndex(k block) {
        kotlin.jvm.internal.k.f(block, "block");
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

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.elements;
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
                        iHashCode = Integer.hashCode(iArr[(i << 3) + i10]) + iHashCode;
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
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private IntSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = IntSetKt.getEmptyIntArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean any(S7.k r14) {
        /*
            r13 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.k.f(r14, r0)
            int[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L57
            r3 = r2
        L10:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L52
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L2a:
            if (r8 >= r6) goto L50
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L4c
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object r9 = r14.invoke(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L4c
            r13 = 1
            return r13
        L4c:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L2a
        L50:
            if (r6 != r7) goto L57
        L52:
            if (r3 == r1) goto L57
            int r3 = r3 + 1
            goto L10
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.any(S7.k):boolean");
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public final int count(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        int[] iArr = this.elements;
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
                    if ((255 & j5) < 128 && ((Boolean) predicate.invoke(Integer.valueOf(iArr[(i << 3) + i11]))).booleanValue()) {
                        i6++;
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
        kotlin.jvm.internal.k.f(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006f A[PHI: r8
      0x006f: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:6:0x0030, B:18:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r19, java.lang.CharSequence r20, S7.k r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r21
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.k.f(r1, r3)
            java.lang.String r3 = "prefix"
            java.lang.String r4 = "transform"
            r5 = r20
            java.lang.StringBuilder r3 = androidx.appfunctions.metadata.a.u(r5, r3, r2, r4, r5)
            int[] r4 = r0.elements
            long[] r0 = r0.metadata
            int r5 = r0.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L74
            r6 = 0
            r7 = r6
            r8 = r7
        L22:
            r9 = r0[r7]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L6f
            int r11 = r7 - r5
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r6
        L3c:
            if (r13 >= r11) goto L6d
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L69
            int r14 = r7 << 3
            int r14 = r14 + r13
            r14 = r4[r14]
            r15 = -1
            if (r8 != r15) goto L55
            java.lang.String r0 = "..."
            r3.append(r0)
            goto L79
        L55:
            if (r8 == 0) goto L5a
            r3.append(r1)
        L5a:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r14 = r2.invoke(r14)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r3.append(r14)
            int r8 = r8 + 1
        L69:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L3c
        L6d:
            if (r11 != r12) goto L74
        L6f:
            if (r7 == r5) goto L74
            int r7 = r7 + 1
            goto L22
        L74:
            java.lang.String r0 = ""
            r3.append(r0)
        L79:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.joinToString(java.lang.CharSequence, java.lang.CharSequence, S7.k):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad A[PHI: r11
      0x00ad: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:28:0x0066, B:42:0x00ab] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.String joinToString$default(androidx.collection.IntSet r20, java.lang.CharSequence r21, java.lang.CharSequence r22, java.lang.CharSequence r23, int r24, java.lang.CharSequence r25, S7.k r26, int r27, java.lang.Object r28) {
        /*
            r0 = r20
            r1 = r26
            if (r28 != 0) goto Lc0
            r2 = r27 & 1
            if (r2 == 0) goto Ld
            java.lang.String r2 = ", "
            goto Lf
        Ld:
            r2 = r21
        Lf:
            r3 = r27 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L17
            r3 = r4
            goto L19
        L17:
            r3 = r22
        L19:
            r5 = r27 & 4
            if (r5 == 0) goto L1e
            goto L20
        L1e:
            r4 = r23
        L20:
            r5 = r27 & 8
            if (r5 == 0) goto L26
            r5 = -1
            goto L28
        L26:
            r5 = r24
        L28:
            r6 = r27 & 16
            if (r6 == 0) goto L2f
            java.lang.String r6 = "..."
            goto L31
        L2f:
            r6 = r25
        L31:
            java.lang.String r7 = "separator"
            kotlin.jvm.internal.k.f(r2, r7)
            java.lang.String r7 = "prefix"
            kotlin.jvm.internal.k.f(r3, r7)
            java.lang.String r7 = "postfix"
            kotlin.jvm.internal.k.f(r4, r7)
            java.lang.String r7 = "truncated"
            java.lang.String r8 = "transform"
            java.lang.StringBuilder r3 = androidx.appfunctions.metadata.a.u(r6, r7, r1, r8, r3)
            int[] r7 = r0.elements
            long[] r0 = r0.metadata
            int r8 = r0.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto Lb2
            r10 = 0
            r11 = 0
        L55:
            r12 = r0[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto Lad
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L72:
            if (r9 >= r14) goto Laa
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r12 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto La1
            int r16 = r10 << 3
            int r16 = r16 + r9
            r16 = r7[r16]
            if (r11 != r5) goto L8a
            r3.append(r6)
            goto Lb5
        L8a:
            if (r11 == 0) goto L8f
            r3.append(r2)
        L8f:
            r21 = r15
            java.lang.Integer r15 = java.lang.Integer.valueOf(r16)
            java.lang.Object r15 = r1.invoke(r15)
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r3.append(r15)
            int r11 = r11 + 1
            goto La3
        La1:
            r21 = r15
        La3:
            long r12 = r12 >> r21
            int r9 = r9 + 1
            r15 = r21
            goto L72
        Laa:
            r9 = r15
            if (r14 != r9) goto Lb2
        Lad:
            if (r10 == r8) goto Lb2
            int r10 = r10 + 1
            goto L55
        Lb2:
            r3.append(r4)
        Lb5:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        Lc0:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "Super calls with default arguments not supported in this target, function: joinToString"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.joinToString$default(androidx.collection.IntSet, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, S7.k, int, java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int first(S7.k r14) {
        /*
            r13 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.k.f(r14, r0)
            int[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            if (r1 < 0) goto L56
            r2 = 0
            r3 = r2
        L10:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L51
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L2a:
            if (r8 >= r6) goto L4f
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L4b
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
            java.lang.Object r10 = r14.invoke(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L4b
            return r9
        L4b:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L2a
        L4f:
            if (r6 != r7) goto L56
        L51:
            if (r3 == r1) goto L56
            int r3 = r3 + 1
            goto L10
        L56:
            java.util.NoSuchElementException r13 = new java.util.NoSuchElementException
            java.lang.String r14 = "Could not find a match"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.first(S7.k):int");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i, k kVar) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        StringBuilder sbU = a.u(charSequence, "postfix", kVar, "transform", prefix);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((255 & j5) < 128) {
                            int i13 = iArr[(i6 << 3) + i12];
                            if (i10 == i) {
                                sbU.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbU.append(separator);
                            }
                            sbU.append((CharSequence) kVar.invoke(Integer.valueOf(i13)));
                            i10++;
                        }
                        j5 >>= 8;
                    }
                    if (i11 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            sbU.append(charSequence);
        } else {
            sbU.append(charSequence);
        }
        String string = sbU.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        StringBuilder sbW = a.w(postfix, "postfix", truncated, "truncated", prefix);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i6 = 0;
            loop0: while (true) {
                long j5 = jArr[i];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i - length)) >>> 31);
                    for (int i11 = 0; i11 < i10; i11++) {
                        if ((255 & j5) < 128) {
                            int i12 = iArr[(i << 3) + i11];
                            if (i6 == limit) {
                                sbW.append(truncated);
                                break loop0;
                            }
                            if (i6 != 0) {
                                sbW.append(separator);
                            }
                            sbW.append(i12);
                            i6++;
                        }
                        j5 >>= 8;
                    }
                    if (i10 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
            sbW.append(postfix);
        } else {
            sbW.append(postfix);
        }
        String string = sbW.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, k transform) {
        int i;
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        StringBuilder sbU = a.u(truncated, "truncated", transform, "transform", prefix);
        int[] iArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            int i10 = 0;
            loop0: while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i6 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j5 & 255) < 128) {
                            int i14 = iArr[(i6 << 3) + i13];
                            if (i10 == limit) {
                                sbU.append(truncated);
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbU.append(separator);
                            }
                            i = i11;
                            sbU.append((CharSequence) transform.invoke(Integer.valueOf(i14)));
                            i10++;
                        } else {
                            i = i11;
                        }
                        j5 >>= i;
                        i13++;
                        i11 = i;
                    }
                    if (i12 != i11) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
            sbU.append(postfix);
        } else {
            sbU.append(postfix);
        }
        String string = sbU.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[PHI: r9
      0x0075: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x0036, B:18:0x0073] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r20, java.lang.CharSequence r21, java.lang.CharSequence r22, S7.k r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            java.lang.String r5 = "separator"
            kotlin.jvm.internal.k.f(r1, r5)
            java.lang.String r5 = "prefix"
            kotlin.jvm.internal.k.f(r2, r5)
            java.lang.String r5 = "postfix"
            java.lang.String r6 = "transform"
            java.lang.StringBuilder r2 = androidx.appfunctions.metadata.a.u(r3, r5, r4, r6, r2)
            int[] r5 = r0.elements
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L7a
            r8 = 0
            r9 = 0
        L28:
            r10 = r0[r8]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L75
            int r12 = r8 - r6
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L42:
            if (r14 >= r12) goto L73
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L6f
            int r15 = r8 << 3
            int r15 = r15 + r14
            r15 = r5[r15]
            r7 = -1
            if (r9 != r7) goto L5b
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L7d
        L5b:
            if (r9 == 0) goto L60
            r2.append(r1)
        L60:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r15)
            java.lang.Object r7 = r4.invoke(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.append(r7)
            int r9 = r9 + 1
        L6f:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L42
        L73:
            if (r12 != r13) goto L7a
        L75:
            if (r8 == r6) goto L7a
            int r8 = r8 + 1
            goto L28
        L7a:
            r2.append(r3)
        L7d:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, S7.k):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0070 A[PHI: r9
      0x0070: PHI (r9v2 int) = (r9v1 int), (r9v3 int) binds: [B:6:0x0031, B:18:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r20, S7.k r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.k.f(r1, r3)
            java.lang.String r3 = "transform"
            kotlin.jvm.internal.k.f(r2, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = ""
            r3.<init>(r4)
            int[] r5 = r0.elements
            long[] r0 = r0.metadata
            int r6 = r0.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L75
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
            if (r12 == 0) goto L70
            int r12 = r8 - r6
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L3d:
            if (r14 >= r12) goto L6e
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L6a
            int r15 = r8 << 3
            int r15 = r15 + r14
            r15 = r5[r15]
            r7 = -1
            if (r9 != r7) goto L56
            java.lang.String r0 = "..."
            r3.append(r0)
            goto L78
        L56:
            if (r9 == 0) goto L5b
            r3.append(r1)
        L5b:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r15)
            java.lang.Object r7 = r2.invoke(r7)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.append(r7)
            int r9 = r9 + 1
        L6a:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L3d
        L6e:
            if (r12 != r13) goto L75
        L70:
            if (r8 == r6) goto L75
            int r8 = r8 + 1
            goto L23
        L75:
            r3.append(r4)
        L78:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.joinToString(java.lang.CharSequence, S7.k):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006c A[PHI: r8
      0x006c: PHI (r8v2 int) = (r8v1 int), (r8v3 int) binds: [B:6:0x002b, B:18:0x006a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(S7.k r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "transform"
            kotlin.jvm.internal.k.f(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ""
            r2.<init>(r3)
            int[] r4 = r0.elements
            long[] r0 = r0.metadata
            int r5 = r0.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L71
            r6 = 0
            r7 = r6
            r8 = r7
        L1d:
            r9 = r0[r7]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L6c
            int r11 = r7 - r5
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r6
        L37:
            if (r13 >= r11) goto L6a
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L66
            int r14 = r7 << 3
            int r14 = r14 + r13
            r14 = r4[r14]
            r15 = -1
            if (r8 != r15) goto L50
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L74
        L50:
            if (r8 == 0) goto L57
            java.lang.String r15 = ", "
            r2.append(r15)
        L57:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object r14 = r1.invoke(r14)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r2.append(r14)
            int r8 = r8 + 1
        L66:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L37
        L6a:
            if (r11 != r12) goto L71
        L6c:
            if (r7 == r5) goto L71
            int r7 = r7 + 1
            goto L1d
        L71:
            r2.append(r3)
        L74:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "toString(...)"
            kotlin.jvm.internal.k.e(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.joinToString(S7.k):java.lang.String");
    }
}
