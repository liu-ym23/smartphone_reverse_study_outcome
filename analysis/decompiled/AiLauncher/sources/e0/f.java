package e0;

import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h0.C4118a;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010*\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u0011J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\u0011J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#JE\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002¢\u0006\u0004\b&\u0010'JA\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0002¢\u0006\u0004\b)\u0010*J7\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010+\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-JI\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J=\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u00102\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b3\u00104J5\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u00102\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b5\u00106JA\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u00107\u001a\u00020.H\u0002¢\u0006\u0004\b8\u00109J?\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u00107\u001a\u00020.H\u0002¢\u0006\u0004\b:\u00109J\u001f\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b;\u0010<JA\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b>\u0010?R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010AR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bB\u0010#R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010D¨\u0006E"}, d2 = {"Le0/f;", ExifInterface.LONGITUDE_EAST, "Ld0/e;", "Le0/c;", "", "", Parameters.ROOT, "tail", "", ContentDisposition.Parameters.Size, "rootShift", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;II)V", "element", "add", "(Ljava/lang/Object;)Ld0/e;", "index", "(ILjava/lang/Object;)Ld0/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Ld0/e;", "Lkotlin/Function1;", "", "predicate", "M", "(Lp9/l;)Ld0/e;", "Le0/h;", "k", "()Le0/h;", "", "listIterator", "(I)Ljava/util/ListIterator;", "get", "(I)Ljava/lang/Object;", "set", "z", "()I", "filledTail", "newTail", "u", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)Le0/f;", "shift", "v", "([Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "tailIndex", "m", "([Ljava/lang/Object;ILjava/lang/Object;)Le0/f;", "Le0/e;", "elementCarry", "l", "([Ljava/lang/Object;IILjava/lang/Object;Le0/e;)[Ljava/lang/Object;", "rootSize", "y", "([Ljava/lang/Object;III)Ld0/e;", "t", "([Ljava/lang/Object;II)Ld0/e;", "tailCarry", "n", "([Ljava/lang/Object;IILe0/e;)[Ljava/lang/Object;", "x", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)[Ljava/lang/Object;", "e", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "([Ljava/lang/Object;IILjava/lang/Object;)[Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "[Ljava/lang/Object;", "c", Const.INTENT_KEY_UMID, "I", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f<E> extends c<E> implements d0.e<E> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object[] root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object[] tail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int size;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int rootShift;

    public f(Object[] objArr, Object[] objArr2, int i10, int i11) {
        this.root = objArr;
        this.tail = objArr2;
        this.size = i10;
        this.rootShift = i11;
        if (!(size() > 32)) {
            androidx.compose.runtime.f.a("Trie-based persistent vector should have at least 33 elements, got " + size());
        }
        C4118a.a(size() - n.d(size()) <= C5685n.j(objArr2.length, 32));
    }

    public final Object[] A(Object[] root, int shift, int index, Object e10) {
        int iA = n.a(index, shift);
        Object[] objArrCopyOf = Arrays.copyOf(root, 32);
        p.h(objArrCopyOf, "copyOf(...)");
        if (shift == 0) {
            objArrCopyOf[iA] = e10;
            return objArrCopyOf;
        }
        Object obj = objArrCopyOf[iA];
        p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf[iA] = A((Object[]) obj, shift - 5, index, e10);
        return objArrCopyOf;
    }

    @Override // d0.e
    public d0.e<E> M(InterfaceC5074l<? super E, Boolean> predicate) {
        h<E> hVarBuilder = builder();
        hVarBuilder.U(predicate);
        return hVarBuilder.build();
    }

    @Override // java.util.Collection, java.util.List, d0.e
    public d0.e<E> add(E element) {
        int size = size() - z();
        if (size >= 32) {
            return u(this.root, this.tail, n.c(element));
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[size] = element;
        return new f(this.root, objArrCopyOf, size() + 1, this.rootShift);
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c, reason: from getter */
    public int getSize() {
        return this.size;
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public E get(int index) {
        h0.d.a(index, size());
        return (E) j(index)[index & 31];
    }

    @Override // d0.e
    public d0.e<E> h(int index) {
        h0.d.a(index, size());
        int iZ = z();
        return index >= iZ ? y(this.root, iZ, this.rootShift, index - iZ) : y(x(this.root, this.rootShift, index, new e(this.tail[0])), iZ, this.rootShift, 0);
    }

    public final Object[] j(int index) {
        if (z() <= index) {
            return this.tail;
        }
        Object[] objArr = this.root;
        for (int i10 = this.rootShift; i10 > 0; i10 -= 5) {
            Object[] objArr2 = objArr[n.a(index, i10)];
            p.g(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    @Override // d0.e
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public h<E> builder() {
        return new h<>(this, this.root, this.tail, this.rootShift);
    }

    public final Object[] l(Object[] root, int shift, int index, Object element, e elementCarry) {
        Object[] objArrCopyOf;
        int iA = n.a(index, shift);
        if (shift == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(root, 32);
                p.h(objArrCopyOf, "copyOf(...)");
            }
            C1168p.i(root, objArrCopyOf, iA + 1, iA, 31);
            elementCarry.b(root[31]);
            objArrCopyOf[iA] = element;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(root, 32);
        p.h(objArrCopyOf2, "copyOf(...)");
        int i10 = shift - 5;
        Object obj = root[iA];
        p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = l((Object[]) obj, i10, index, element, elementCarry);
        while (true) {
            iA++;
            if (iA >= 32 || objArrCopyOf2[iA] == null) {
                break;
            }
            Object obj2 = root[iA];
            p.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf2[iA] = l((Object[]) obj2, i10, 0, elementCarry.getValue(), elementCarry);
        }
        return objArrCopyOf2;
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public ListIterator<E> listIterator(int index) {
        h0.d.b(index, size());
        return new i(this.root, this.tail, index, size(), (this.rootShift / 5) + 1);
    }

    public final f<E> m(Object[] root, int tailIndex, Object element) {
        int size = size() - z();
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        p.h(objArrCopyOf, "copyOf(...)");
        if (size < 32) {
            C1168p.i(this.tail, objArrCopyOf, tailIndex + 1, tailIndex, size);
            objArrCopyOf[tailIndex] = element;
            return new f<>(root, objArrCopyOf, size() + 1, this.rootShift);
        }
        Object[] objArr = this.tail;
        Object obj = objArr[31];
        C1168p.i(objArr, objArrCopyOf, tailIndex + 1, tailIndex, size - 1);
        objArrCopyOf[tailIndex] = element;
        return u(root, objArrCopyOf, n.c(obj));
    }

    public final Object[] n(Object[] root, int shift, int index, e tailCarry) {
        Object[] objArrN;
        int iA = n.a(index, shift);
        if (shift == 5) {
            tailCarry.b(root[iA]);
            objArrN = null;
        } else {
            Object obj = root[iA];
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrN = n((Object[]) obj, shift - 5, index, tailCarry);
        }
        if (objArrN == null && iA == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(root, 32);
        p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[iA] = objArrN;
        return objArrCopyOf;
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public d0.e<E> set(int index, E element) {
        h0.d.a(index, size());
        if (z() > index) {
            return new f(A(this.root, this.rootShift, index, element), this.tail, size(), this.rootShift);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[index & 31] = element;
        return new f(this.root, objArrCopyOf, size(), this.rootShift);
    }

    public final d0.e<E> t(Object[] root, int rootSize, int shift) {
        if (shift == 0) {
            if (root.length == 33) {
                root = Arrays.copyOf(root, 32);
                p.h(root, "copyOf(...)");
            }
            return new l(root);
        }
        e eVar = new e(null);
        Object[] objArrN = n(root, shift, rootSize - 1, eVar);
        p.f(objArrN);
        Object value = eVar.getValue();
        p.g(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) value;
        if (objArrN[1] != null) {
            return new f(objArrN, objArr, rootSize, shift);
        }
        Object obj = objArrN[0];
        p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new f((Object[]) obj, objArr, rootSize, shift - 5);
    }

    public final f<E> u(Object[] root, Object[] filledTail, Object[] newTail) {
        int size = size() >> 5;
        int i10 = this.rootShift;
        if (size <= (1 << i10)) {
            return new f<>(v(root, i10, filledTail), newTail, size() + 1, this.rootShift);
        }
        Object[] objArrC = n.c(root);
        int i11 = this.rootShift + 5;
        return new f<>(v(objArrC, i11, filledTail), newTail, size() + 1, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object[] v(java.lang.Object[] r4, int r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            int r0 = r3.size()
            int r0 = r0 + (-1)
            int r0 = e0.n.a(r0, r5)
            r1 = 32
            if (r4 == 0) goto L19
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r2 = "copyOf(...)"
            kotlin.jvm.internal.p.h(r4, r2)
            if (r4 != 0) goto L1b
        L19:
            java.lang.Object[] r4 = new java.lang.Object[r1]
        L1b:
            r1 = 5
            if (r5 != r1) goto L21
            r4[r0] = r6
            return r4
        L21:
            r2 = r4[r0]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r5 = r5 - r1
            java.lang.Object[] r3 = r3.v(r2, r5, r6)
            r4[r0] = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.f.v(java.lang.Object[], int, java.lang.Object[]):java.lang.Object[]");
    }

    public final Object[] x(Object[] root, int shift, int index, e tailCarry) {
        Object[] objArrCopyOf;
        int iA = n.a(index, shift);
        if (shift == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(root, 32);
                p.h(objArrCopyOf, "copyOf(...)");
            }
            C1168p.i(root, objArrCopyOf, iA, iA + 1, 32);
            objArrCopyOf[31] = tailCarry.getValue();
            tailCarry.b(root[iA]);
            return objArrCopyOf;
        }
        int iA2 = root[31] == null ? n.a(z() - 1, shift) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(root, 32);
        p.h(objArrCopyOf2, "copyOf(...)");
        int i10 = shift - 5;
        int i11 = iA + 1;
        if (i11 <= iA2) {
            while (true) {
                Object obj = objArrCopyOf2[iA2];
                p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrCopyOf2[iA2] = x((Object[]) obj, i10, 0, tailCarry);
                if (iA2 == i11) {
                    break;
                }
                iA2--;
            }
        }
        Object obj2 = objArrCopyOf2[iA];
        p.g(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = x((Object[]) obj2, i10, index, tailCarry);
        return objArrCopyOf2;
    }

    public final d0.e<E> y(Object[] root, int rootSize, int shift, int index) {
        int size = size() - rootSize;
        C4118a.a(index < size);
        if (size == 1) {
            return t(root, rootSize, shift);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.tail, 32);
        p.h(objArrCopyOf, "copyOf(...)");
        int i10 = size - 1;
        if (index < i10) {
            C1168p.i(this.tail, objArrCopyOf, index, index + 1, size);
        }
        objArrCopyOf[i10] = null;
        return new f(root, objArrCopyOf, (rootSize + size) - 1, shift);
    }

    public final int z() {
        return n.d(size());
    }

    @Override // java.util.List, d0.e
    public d0.e<E> add(int index, E element) {
        h0.d.b(index, size());
        if (index == size()) {
            return add((f<E>) element);
        }
        int iZ = z();
        if (index >= iZ) {
            return m(this.root, index - iZ, element);
        }
        e eVar = new e(null);
        return m(l(this.root, this.rootShift, index, element, eVar), 0, eVar.getValue());
    }
}
