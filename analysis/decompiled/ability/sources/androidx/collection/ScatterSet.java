package androidx.collection;

import S7.k;
import androidx.annotation.IntRange;
import androidx.appfunctions.metadata.a;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u0007J\r\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ2\u0010\u000b\u001a\u00028\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u000b\u0010\u000fJ4\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0010\u0010\u000fJ2\u0010\u0014\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0014\u0010\u0015J2\u0010\u0016\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0016\u0010\u0015J2\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0017\u0010\u0018J2\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\rH\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0006\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ2\u0010\u0019\u001a\u00020\u00112\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\rH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\u0019\u0010\u001bJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJY\u0010'\u001a\u00020&2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\u00112\b\b\u0002\u0010$\u001a\u00020\u001f2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f\u0018\u00010\rH\u0007¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0011H\u0016¢\u0006\u0004\b)\u0010\u001aJ\u001a\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b+\u0010\u001eJ\u000f\u0010,\u001a\u00020&H\u0016¢\u0006\u0004\b,\u0010-J\u0018\u00100\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b.\u0010/J\u0013\u00102\u001a\b\u0012\u0004\u0012\u00028\u000001¢\u0006\u0004\b2\u00103R\u001c\u00105\u001a\u0002048\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b5\u00106\u0012\u0004\b7\u0010\u0004R$\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002088\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b9\u0010:\u0012\u0004\b;\u0010\u0004R\u0016\u0010<\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b>\u0010=R\u0011\u0010@\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b?\u0010\u001aR\u0011\u0010B\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\bA\u0010\u001a\u0082\u0001\u0001C\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006D"}, d2 = {"Landroidx/collection/ScatterSet;", ExifInterface.LONGITUDE_EAST, "", AppAgent.CONSTRUCT, "()V", "", "any", "()Z", "none", "isEmpty", "isNotEmpty", "first", "()Ljava/lang/Object;", "Lkotlin/Function1;", "predicate", "(LS7/k;)Ljava/lang/Object;", "firstOrNull", "", "LC7/r;", "block", "forEachIndex", "(LS7/k;)V", "forEach", "all", "(LS7/k;)Z", "count", "()I", "(LS7/k;)I", "element", "contains", "(Ljava/lang/Object;)Z", "", "separator", "prefix", "postfix", "limit", "truncated", "transform", "", "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;LS7/k;)Ljava/lang/String;", "hashCode", "other", "equals", "toString", "()Ljava/lang/String;", "findElementIndex$collection", "(Ljava/lang/Object;)I", "findElementIndex", "", "asSet", "()Ljava/util/Set;", "", "metadata", "[J", "getMetadata$annotations", "", "elements", "[Ljava/lang/Object;", "getElements$annotations", "_capacity", "I", "_size", "getCapacity", "capacity", "getSize", "size", "Landroidx/collection/MutableScatterSet;", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScatterSet<E> {
    public int _capacity;
    public int _size;
    public Object[] elements;
    public long[] metadata;

    public /* synthetic */ ScatterSet(e eVar) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ String joinToString$default(ScatterSet scatterSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, k kVar, int i6, Object obj) {
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
        if ((i6 & 32) != 0) {
            kVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        k kVar2 = kVar;
        return scatterSet.joinToString(charSequence, charSequence2, charSequence3, i, charSequence5, kVar2);
    }

    public final boolean all(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.elements;
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
                    if ((255 & j5) < 128 && !((Boolean) predicate.invoke(objArr[(i << 3) + i10])).booleanValue()) {
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

    public final Set<E> asSet() {
        return new SetWrapper(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006d, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(E r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r1.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r7 = r7[r8]
            int r13 = 64 - r9
            long r7 = r7 << r13
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L47:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L66
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.elements
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.k.b(r15, r1)
            if (r15 == 0) goto L60
            goto L70
        L60:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L47
        L66:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L74
            r11 = -1
        L70:
            if (r11 < 0) goto L73
            return r12
        L73:
            return r2
        L74:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.contains(java.lang.Object):boolean");
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public final int count() {
        return get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
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
            boolean r1 = r15 instanceof androidx.collection.ScatterSet
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            androidx.collection.ScatterSet r15 = (androidx.collection.ScatterSet) r15
            int r1 = r15.get_size()
            int r3 = r14.get_size()
            if (r1 == r3) goto L17
            return r2
        L17:
            java.lang.Object[] r1 = r14.elements
            long[] r14 = r14.metadata
            int r3 = r14.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5d
            r4 = r2
        L21:
            r5 = r14[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L58
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r2
        L3b:
            if (r9 >= r7) goto L56
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L52
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r10 = r15.contains(r10)
            if (r10 != 0) goto L52
            return r2
        L52:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L3b
        L56:
            if (r7 != r8) goto L5d
        L58:
            if (r4 == r3) goto L5d
            int r4 = r4 + 1
            goto L21
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.equals(java.lang.Object):boolean");
    }

    public final int findElementIndex$collection(E element) {
        int i = 0;
        int iHashCode = (element != null ? element.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i6 = iHashCode ^ (iHashCode << 16);
        int i10 = i6 & 127;
        int i11 = this._capacity;
        int i12 = i6 >>> 7;
        while (true) {
            int i13 = i12 & i11;
            long[] jArr = this.metadata;
            int i14 = i13 >> 3;
            int i15 = (i13 & 7) << 3;
            long j5 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j6 = (i10 * ScatterMapKt.BitmaskLsb) ^ j5;
            for (long j10 = (~j6) & (j6 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j10 != 0; j10 &= j10 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j10) >> 3) + i13) & i11;
                if (kotlin.jvm.internal.k.b(this.elements[iNumberOfTrailingZeros], element)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j5 & ((~j5) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i += 8;
            i12 = i13 + i;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final E first() {
        /*
            r13 = this;
            java.lang.Object[] r0 = r13.elements
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
            java.lang.String r13 = "The ScatterSet is empty"
            androidx.collection.internal.RuntimeHelpersKt.throwNoSuchElementExceptionForInline(r13)
            kotlin.KotlinNothingValueException r13 = new kotlin.KotlinNothingValueException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.first():java.lang.Object");
    }

    public final E firstOrNull(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128) {
                        E e = (E) objArr[(i << 3) + i10];
                        if (((Boolean) predicate.invoke(e)).booleanValue()) {
                            return e;
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return null;
                }
            }
            if (i == length) {
                return null;
            }
            i++;
        }
    }

    public final void forEach(k block) {
        kotlin.jvm.internal.k.f(block, "block");
        Object[] objArr = this.elements;
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
    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int iHashCode = (this._capacity * 31) + this._size;
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j5 = jArr[i];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j5) < 128) {
                            Object obj = objArr[(i << 3) + i10];
                            if (!kotlin.jvm.internal.k.b(obj, this)) {
                                iHashCode += obj != null ? obj.hashCode() : 0;
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return iHashCode;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return iHashCode;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new k(this) { // from class: androidx.collection.ScatterSet.toString.1
            final /* synthetic */ ScatterSet<E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((AnonymousClass1) obj);
            }

            @Override // S7.k
            public final CharSequence invoke(E e) {
                return e == this.this$0 ? "(this)" : String.valueOf(e);
            }
        }, 25, null);
    }

    private ScatterSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean any(S7.k r14) {
        /*
            r13 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.k.f(r14, r0)
            java.lang.Object[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L53
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
            if (r6 == 0) goto L4e
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L2a:
            if (r8 >= r6) goto L4c
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L48
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            java.lang.Object r9 = r14.invoke(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L48
            r13 = 1
            return r13
        L48:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L2a
        L4c:
            if (r6 != r7) goto L53
        L4e:
            if (r3 == r1) goto L53
            int r3 = r3 + 1
            goto L10
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.any(S7.k):boolean");
    }

    @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT)
    public final int count(k predicate) {
        kotlin.jvm.internal.k.f(predicate, "predicate");
        Object[] objArr = this.elements;
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
                    if ((255 & j5) < 128 && ((Boolean) predicate.invoke(objArr[(i << 3) + i11])).booleanValue()) {
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
        return joinToString$default(this, separator, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, null, 48, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated) {
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        kotlin.jvm.internal.k.f(postfix, "postfix");
        kotlin.jvm.internal.k.f(truncated, "truncated");
        return joinToString$default(this, separator, prefix, postfix, i, truncated, null, 32, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final E first(S7.k r14) {
        /*
            r13 = this;
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.k.f(r14, r0)
            java.lang.Object[] r0 = r13.elements
            long[] r13 = r13.metadata
            int r1 = r13.length
            int r1 = r1 + (-2)
            if (r1 < 0) goto L52
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
            if (r6 == 0) goto L4d
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L2a:
            if (r8 >= r6) goto L4b
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L47
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            java.lang.Object r10 = r14.invoke(r9)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L47
            return r9
        L47:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L2a
        L4b:
            if (r6 != r7) goto L52
        L4d:
            if (r3 == r1) goto L52
            int r3 = r3 + 1
            goto L10
        L52:
            java.lang.String r13 = "Could not find a match"
            androidx.collection.internal.RuntimeHelpersKt.throwNoSuchElementExceptionForInline(r13)
            kotlin.KotlinNothingValueException r13 = new kotlin.KotlinNothingValueException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterSet.first(S7.k):java.lang.Object");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, k transform) {
        int i;
        kotlin.jvm.internal.k.f(separator, "separator");
        kotlin.jvm.internal.k.f(prefix, "prefix");
        StringBuilder sbW = a.w(postfix, "postfix", truncated, "truncated", prefix);
        Object[] objArr = this.elements;
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
                            Object obj = objArr[(i6 << 3) + i13];
                            i = i11;
                            if (i10 == limit) {
                                sbW.append(truncated);
                                break loop0;
                            }
                            if (i10 != 0) {
                                sbW.append(separator);
                            }
                            if (transform == null) {
                                sbW.append(obj);
                            } else {
                                sbW.append((CharSequence) transform.invoke(obj));
                            }
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
            sbW.append(postfix);
        } else {
            sbW.append(postfix);
        }
        String string = sbW.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }
}
