package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001aS\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a9\u0010\u0010\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a9\u0010\u0015\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\t\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a9\u0010\u0018\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\t\u001a\u00020\u00172\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a5\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010 \u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0001¢\u0006\u0004\b \u0010!\u001a9\u0010$\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\"\u001a\u00028\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%\u001a-\u0010'\u001a\u00020#*\u00020\u000f2\u0006\u0010\"\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b'\u0010(\u001a-\u0010)\u001a\u00020#*\u00020\u00052\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*\u001a-\u0010,\u001a\u00020#*\u00020\u00142\u0006\u0010\"\u001a\u00020+2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-\u001a-\u0010/\u001a\u00020#*\u00020\u00172\u0006\u0010\"\u001a\u00020.2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b/\u00100\u001a-\u00103\u001a\u00020#*\u0002012\u0006\u0010\"\u001a\u0002022\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b3\u00104\u001a.\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\"\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b5\u00106\u001a\u001c\u00107\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\"\u001a\u00020&H\u0086\u0002¢\u0006\u0004\b7\u00108\u001a6\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u00109\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b:\u0010;\u001a\u001c\u0010<\u001a\u00020\u000f*\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\b<\u0010=\u001a\u001f\u0010>\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b>\u0010?\u001a;\u0010C\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000@j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`A¢\u0006\u0004\bC\u0010D\u001a\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005¢\u0006\u0004\bE\u0010F¨\u0006G"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", Const.INTENT_KEY_UMID, "([Ljava/lang/Object;)Ljava/util/List;", "", "", "c", "([I)Ljava/util/List;", "destination", "destinationOffset", "startIndex", "endIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "", "e", "([B[BIII)[B", Const.INTENT_KEY_BACKGROUND_COMMAND, "([I[IIII)[I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "([J[JIII)[J", "", "f", "([F[FIII)[F", "fromIndex", "toIndex", "q", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "o", "([BII)[B", "p", "([FII)[F", "element", "LY8/t;", "v", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "", "r", "([BBII)V", "t", "([IIII)V", "", "u", "([JJII)V", "", "s", "([FFII)V", "", "", "w", "([ZZII)V", "F", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "D", "([BB)[B", "elements", "G", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "([B[B)[B", "H", "([Ljava/lang/Object;)V", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "I", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "J", "([I)[Ljava/lang/Integer;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* renamed from: Z8.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1168p extends C1167o {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Z8/p$a", "LZ8/d;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "isEmpty", "()Z", "element", "f", "(I)Z", "index", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Ljava/lang/Integer;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)I", "k", "c", "()I", ContentDisposition.Parameters.Size, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Z8.p$a */
    public static final class a extends AbstractC1156d<Integer> implements RandomAccess {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f7700b;

        public a(int[] iArr) {
            this.f7700b = iArr;
        }

        @Override // Z8.AbstractC1154b
        /* renamed from: c */
        public int get_size() {
            return this.f7700b.length;
        }

        @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return f(((Number) obj).intValue());
            }
            return false;
        }

        public boolean f(int element) {
            return r.P(this.f7700b, element);
        }

        @Override // Z8.AbstractC1156d, java.util.List
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Integer get(int index) {
            return Integer.valueOf(this.f7700b[index]);
        }

        @Override // Z8.AbstractC1156d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return j(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // Z8.AbstractC1154b, java.util.Collection
        public boolean isEmpty() {
            return this.f7700b.length == 0;
        }

        public int j(int element) {
            return r.m0(this.f7700b, element);
        }

        public int k(int element) {
            return r.z0(this.f7700b, element);
        }

        @Override // Z8.AbstractC1156d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return k(((Number) obj).intValue());
            }
            return -1;
        }
    }

    public static /* synthetic */ void A(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        u(jArr, j10, i10, i11);
    }

    public static /* synthetic */ void B(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        v(objArr, obj, i10, i11);
    }

    public static /* synthetic */ void C(boolean[] zArr, boolean z10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = zArr.length;
        }
        w(zArr, z10, i10, i11);
    }

    public static byte[] D(byte[] bArr, byte b10) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + 1);
        bArrCopyOf[length] = b10;
        kotlin.jvm.internal.p.f(bArrCopyOf);
        return bArrCopyOf;
    }

    public static byte[] E(byte[] bArr, byte[] elements) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, bArrCopyOf, length, length2);
        kotlin.jvm.internal.p.f(bArrCopyOf);
        return bArrCopyOf;
    }

    public static <T> T[] F(T[] tArr, T t10) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t10;
        kotlin.jvm.internal.p.f(tArr2);
        return tArr2;
    }

    public static <T> T[] G(T[] tArr, T[] elements) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, tArr2, length, length2);
        kotlin.jvm.internal.p.f(tArr2);
        return tArr2;
    }

    public static final <T> void H(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static <T> void I(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static Integer[] J(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    public static List<Integer> c(int[] iArr) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        return new a(iArr);
    }

    public static <T> List<T> d(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        List<T> listA = C1170s.a(tArr);
        kotlin.jvm.internal.p.h(listA, "asList(...)");
        return listA;
    }

    public static byte[] e(byte[] bArr, byte[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        System.arraycopy(bArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static final float[] f(float[] fArr, float[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        System.arraycopy(fArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static int[] g(int[] iArr, int[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        System.arraycopy(iArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static long[] h(long[] jArr, long[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        System.arraycopy(jArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static <T> T[] i(T[] tArr, T[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        kotlin.jvm.internal.p.i(destination, "destination");
        System.arraycopy(tArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    public static /* synthetic */ byte[] j(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return e(bArr, bArr2, i10, i11, i12);
    }

    public static /* synthetic */ float[] k(float[] fArr, float[] fArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = fArr.length;
        }
        return f(fArr, fArr2, i10, i11, i12);
    }

    public static /* synthetic */ int[] l(int[] iArr, int[] iArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length;
        }
        return g(iArr, iArr2, i10, i11, i12);
    }

    public static /* synthetic */ long[] m(long[] jArr, long[] jArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length;
        }
        return h(jArr, jArr2, i10, i11, i12);
    }

    public static /* synthetic */ Object[] n(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return i(objArr, objArr2, i10, i11, i12);
    }

    public static byte[] o(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        C1166n.b(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.p.h(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static float[] p(float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        C1166n.b(i11, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i10, i11);
        kotlin.jvm.internal.p.h(fArrCopyOfRange, "copyOfRange(...)");
        return fArrCopyOfRange;
    }

    public static <T> T[] q(T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        C1166n.b(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        kotlin.jvm.internal.p.h(tArr2, "copyOfRange(...)");
        return tArr2;
    }

    public static void r(byte[] bArr, byte b10, int i10, int i11) {
        kotlin.jvm.internal.p.i(bArr, "<this>");
        Arrays.fill(bArr, i10, i11, b10);
    }

    public static final void s(float[] fArr, float f10, int i10, int i11) {
        kotlin.jvm.internal.p.i(fArr, "<this>");
        Arrays.fill(fArr, i10, i11, f10);
    }

    public static final void t(int[] iArr, int i10, int i11, int i12) {
        kotlin.jvm.internal.p.i(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    public static final void u(long[] jArr, long j10, int i10, int i11) {
        kotlin.jvm.internal.p.i(jArr, "<this>");
        Arrays.fill(jArr, i10, i11, j10);
    }

    public static <T> void v(T[] tArr, T t10, int i10, int i11) {
        kotlin.jvm.internal.p.i(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }

    public static final void w(boolean[] zArr, boolean z10, int i10, int i11) {
        kotlin.jvm.internal.p.i(zArr, "<this>");
        Arrays.fill(zArr, i10, i11, z10);
    }

    public static /* synthetic */ void x(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        r(bArr, b10, i10, i11);
    }

    public static /* synthetic */ void y(float[] fArr, float f10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length;
        }
        s(fArr, f10, i10, i11);
    }

    public static /* synthetic */ void z(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        t(iArr, i10, i11, i12);
    }
}
