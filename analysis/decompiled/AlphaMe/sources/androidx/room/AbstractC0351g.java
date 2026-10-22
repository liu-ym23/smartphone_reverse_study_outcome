package androidx.room;

import android.os.Parcel;
import android.util.Log;
import android.util.SparseArray;
import com.alibaba.fastjson.asm.MethodWriter;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.baidu.platform.comjni.map.basemap.NABaseMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.collections.IntIterator;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* renamed from: androidx.room.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0351g {
    public static /* synthetic */ void A(Object obj) {
        throw new ClassCastException();
    }

    public static void B(String str, Exception exc, String str2) {
        Log.e(str2, str + exc);
    }

    public static void C(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static /* synthetic */ void D(CoroutineContext.Element element) {
        if (element != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ long a(int i4) {
        if (i4 == 1) {
            return 0L;
        }
        if (i4 == 2) {
            return 1L;
        }
        if (i4 == 3) {
            return 2L;
        }
        if (i4 == 4) {
            return 3L;
        }
        if (i4 == 5) {
            return 4L;
        }
        throw null;
    }

    public static char b(int i4, int i5, int i6, JSONLexerBase jSONLexerBase) {
        return jSONLexerBase.charAt(i4 + i5 + i6);
    }

    public static int c(CharSequence charSequence, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return charSequence.length();
    }

    public static int d(String str, int i4, int i5) {
        return (str.hashCode() + i4) * i5;
    }

    public static int e(UInt uInt, int i4) {
        return UInt.m117constructorimpl(uInt.getData() + i4);
    }

    public static int f(IntRange intRange, int i4) {
        return intRange.getEndInclusive().intValue() + i4;
    }

    public static IObjectWrapper g(Parcel parcel) {
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapperAsInterface;
    }

    public static Object h(CharSequence charSequence, int i4, Function1 function1) {
        return function1.invoke(Character.valueOf(charSequence.charAt(i4)));
    }

    public static Object i(byte[] bArr, int i4, Function1 function1) {
        return function1.invoke(UByte.m34boximpl(UByteArray.m98getw2LRezQ(bArr, i4)));
    }

    public static Object j(int[] iArr, int i4, Function1 function1) {
        return function1.invoke(UInt.m111boximpl(UIntArray.m177getpVg5ArA(iArr, i4)));
    }

    public static Object k(long[] jArr, int i4, Function1 function1) {
        return function1.invoke(ULong.m190boximpl(ULongArray.m256getsVKNKU(jArr, i4)));
    }

    public static Object l(short[] sArr, int i4, Function1 function1) {
        return function1.invoke(UShort.m297boximpl(UShortArray.m361getMh2AYeg(sArr, i4)));
    }

    public static String m(String str, int i4) {
        return str + i4;
    }

    public static String n(String str, long j4) {
        return str + j4;
    }

    public static String o(String str, Object obj) {
        return str + obj;
    }

    public static String p(String str, String str2) {
        return str + str2;
    }

    public static String q(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static StringBuilder r(MethodWriter methodWriter, int i4, String str, String str2, String str3) {
        methodWriter.visitMethodInsn(i4, str, str2, str3);
        return new StringBuilder();
    }

    public static ArrayList s(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }

    public static ArrayList t(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    public static Iterator u(Iterable iterable, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(iterable, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return iterable.iterator();
    }

    public static Iterator v(Sequence sequence, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(sequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return sequence.iterator();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    public static IntIterator w(int i4, int i5) {
        return new IntRange(i4, i5).iterator();
    }

    public static void x(int i4, SparseArray sparseArray, int i5, int i6, int i7) {
        sparseArray.append(i5, Integer.valueOf(i4));
        sparseArray.append(i7, Integer.valueOf(i6));
    }

    public static /* synthetic */ void y(Z0.b bVar) {
        if (bVar != null) {
            throw new ClassCastException();
        }
    }

    public static void z(NABaseMap nABaseMap) {
        nABaseMap.f9326d.readLock().unlock();
    }
}
