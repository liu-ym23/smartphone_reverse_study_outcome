package ib;

import a8.x;
import ab.d0;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Base64;
import android.util.Size;
import android.util.SizeF;
import android.window.BackEvent;
import b0.s2;
import d2.o;
import d7.n;
import d7.r;
import d7.t;
import f4.a1;
import f8.e0;
import f8.l0;
import f8.t0;
import i1.d1;
import i8.c0;
import i8.r0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import u0.z;
import v9.v;
import v9.x0;
import z7.x1;

/* loaded from: classes.dex */
public abstract class k {
    public static final Method A(Class cls, f8.c cVar) throws NoSuchMethodException, SecurityException {
        q7.k.e(cVar, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            q7.k.d(declaredMethod, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new c7.i("No unbox method found in inline class: " + cls + " (calling " + cVar + ')', 3);
        }
    }

    public static n3.c B(n3.d dVar, SQLiteDatabase sQLiteDatabase) {
        q7.k.e(dVar, "refHolder");
        n3.c cVar = dVar.f6818a;
        if (cVar != null && cVar.f6817f.equals(sQLiteDatabase)) {
            return cVar;
        }
        n3.c cVar2 = new n3.c(sQLiteDatabase);
        dVar.f6818a = cVar2;
        return cVar2;
    }

    public static g7.d C(g7.d dVar) {
        g7.d dVarIntercepted;
        q7.k.e(dVar, "<this>");
        i7.c cVar = dVar instanceof i7.c ? (i7.c) dVar : null;
        return (cVar == null || (dVarIntercepted = cVar.intercepted()) == null) ? dVar : dVarIntercepted;
    }

    public static final boolean D(f8.e eVar) {
        LinkedHashSet linkedHashSet = c8.d.f1993a;
        if (!h9.f.l(eVar)) {
            return false;
        }
        LinkedHashSet linkedHashSet2 = c8.d.f1993a;
        e9.b bVarF = l9.d.f(eVar);
        return r.I0(linkedHashSet2, bVarF != null ? bVarF.f() : null);
    }

    public static MappedByteBuffer E(Context context, Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static final void F(float[] fArr, float[] fArr2, int i2, float[] fArr3) {
        if (i2 == 0) {
            f1.a.a("At least one point must be provided");
        }
        int i10 = 2 >= i2 ? i2 - 1 : 2;
        int i11 = i10 + 1;
        float[][] fArr4 = new float[i11][];
        for (int i12 = 0; i12 < i11; i12++) {
            fArr4[i12] = new float[i2];
        }
        for (int i13 = 0; i13 < i2; i13++) {
            fArr4[0][i13] = 1.0f;
            for (int i14 = 1; i14 < i11; i14++) {
                fArr4[i14][i13] = fArr4[i14 - 1][i13] * fArr[i13];
            }
        }
        float[][] fArr5 = new float[i11][];
        for (int i15 = 0; i15 < i11; i15++) {
            fArr5[i15] = new float[i2];
        }
        float[][] fArr6 = new float[i11][];
        for (int i16 = 0; i16 < i11; i16++) {
            fArr6[i16] = new float[i11];
        }
        int i17 = 0;
        while (i17 < i11) {
            float[] fArr7 = fArr5[i17];
            float[] fArr8 = fArr4[i17];
            q7.k.e(fArr8, "<this>");
            q7.k.e(fArr7, "destination");
            System.arraycopy(fArr8, 0, fArr7, 0, i2);
            for (int i18 = 0; i18 < i17; i18++) {
                float[] fArr9 = fArr5[i18];
                float fT = t(fArr7, fArr9);
                for (int i19 = 0; i19 < i2; i19++) {
                    fArr7[i19] = fArr7[i19] - (fArr9[i19] * fT);
                }
            }
            float fSqrt = (float) Math.sqrt(t(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f10 = 1.0f / fSqrt;
            for (int i20 = 0; i20 < i2; i20++) {
                fArr7[i20] = fArr7[i20] * f10;
            }
            float[] fArr10 = fArr6[i17];
            int i21 = 0;
            while (i21 < i11) {
                fArr10[i21] = i21 < i17 ? 0.0f : t(fArr7, fArr4[i21]);
                i21++;
            }
            i17++;
        }
        for (int i22 = i10; -1 < i22; i22--) {
            float fT2 = t(fArr5[i22], fArr2);
            float[] fArr11 = fArr6[i22];
            int i23 = i22 + 1;
            if (i23 <= i10) {
                int i24 = i10;
                while (true) {
                    fT2 -= fArr11[i24] * fArr3[i24];
                    if (i24 != i23) {
                        i24--;
                    }
                }
            }
            fArr3[i22] = fT2 / fArr11[i22];
        }
    }

    public static final long G(c1.l lVar, boolean z4) {
        long jF = t0.b.f(lVar.f1806c, lVar.f1810g);
        if (z4 || !lVar.b()) {
            return jF;
        }
        return 0L;
    }

    public static void H(x8.m mVar, Annotation annotation) {
        Class clsT = nb.i.t(nb.i.p(annotation));
        x8.k kVarN = mVar.n(l8.d.a(clsT), new k8.a(annotation));
        if (kVarN != null) {
            I(kVarN, annotation, clsT);
        }
    }

    public static void I(x8.k kVar, Annotation annotation, Class cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        q7.k.d(declaredMethods, "annotationType.declaredMethods");
        for (Method method : declaredMethods) {
            try {
                Object objInvoke = method.invoke(annotation, null);
                q7.k.b(objInvoke);
                e9.f fVarE = e9.f.e(method.getName());
                Class<?> enclosingClass = objInvoke.getClass();
                if (enclosingClass.equals(Class.class)) {
                    kVar.k(fVarE, o((Class) objInvoke));
                } else if (k8.d.f5654a.contains(enclosingClass)) {
                    kVar.e(fVarE, objInvoke);
                } else {
                    List list = l8.d.f5857a;
                    if (Enum.class.isAssignableFrom(enclosingClass)) {
                        if (!enclosingClass.isEnum()) {
                            enclosingClass = enclosingClass.getEnclosingClass();
                        }
                        q7.k.d(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
                        kVar.g(fVarE, l8.d.a(enclosingClass), e9.f.e(((Enum) objInvoke).name()));
                    } else if (Annotation.class.isAssignableFrom(enclosingClass)) {
                        Class<?>[] interfaces = enclosingClass.getInterfaces();
                        q7.k.d(interfaces, "clazz.interfaces");
                        Class cls2 = (Class) n.r0(interfaces);
                        q7.k.d(cls2, "annotationClass");
                        x8.k kVarP = kVar.p(l8.d.a(cls2), fVarE);
                        if (kVarP != null) {
                            I(kVarP, (Annotation) objInvoke, cls2);
                        }
                    } else {
                        if (!enclosingClass.isArray()) {
                            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + objInvoke);
                        }
                        x8.l lVarL = kVar.l(fVarE);
                        if (lVarL != null) {
                            Class<?> componentType = enclosingClass.getComponentType();
                            if (componentType.isEnum()) {
                                e9.b bVarA = l8.d.a(componentType);
                                for (Object obj : (Object[]) objInvoke) {
                                    q7.k.c(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                                    lVarL.h(bVarA, e9.f.e(((Enum) obj).name()));
                                }
                            } else if (componentType.equals(Class.class)) {
                                for (Object obj2 : (Object[]) objInvoke) {
                                    q7.k.c(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                    lVarL.j(o((Class) obj2));
                                }
                            } else if (Annotation.class.isAssignableFrom(componentType)) {
                                for (Object obj3 : (Object[]) objInvoke) {
                                    x8.k kVarD = lVarL.d(l8.d.a(componentType));
                                    if (kVarD != null) {
                                        q7.k.c(obj3, "null cannot be cast to non-null type kotlin.Annotation");
                                        I(kVarD, (Annotation) obj3, componentType);
                                    }
                                }
                            } else {
                                for (Object obj4 : (Object[]) objInvoke) {
                                    lVarL.t(obj4);
                                }
                            }
                            lVarL.b();
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        kVar.b();
    }

    public static List J(Resources resources, int i2) throws Resources.NotFoundException {
        if (i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i10 = 0; i10 < typedArrayObtainTypedArray.length(); i10++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i10, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i2);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static final List K(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        e7.c cVarM = a.a.m();
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(columnIndex);
            int i10 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            q7.k.d(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            q7.k.d(string2, "cursor.getString(toColumnIndex)");
            cVarM.add(new h3.c(string, i2, i10, string2));
        }
        return r.i1(a.a.e(cVarM));
    }

    public static final h3.d L(n3.c cVar, String str, boolean z4) throws IOException {
        Cursor cursorN = cVar.n("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorN.getColumnIndex("seqno");
            int columnIndex2 = cursorN.getColumnIndex("cid");
            int columnIndex3 = cursorN.getColumnIndex("name");
            int columnIndex4 = cursorN.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorN.moveToNext()) {
                    if (cursorN.getInt(columnIndex2) >= 0) {
                        int i2 = cursorN.getInt(columnIndex);
                        String string = cursorN.getString(columnIndex3);
                        String str2 = cursorN.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i2);
                        q7.k.d(string, "columnName");
                        treeMap.put(numValueOf, string);
                        treeMap2.put(Integer.valueOf(i2), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                q7.k.d(collectionValues, "columnsMap.values");
                List listM1 = r.m1(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                q7.k.d(collectionValues2, "ordersMap.values");
                h3.d dVar = new h3.d(str, z4, listM1, r.m1(collectionValues2));
                cursorN.close();
                return dVar;
            }
            cursorN.close();
            return null;
        } finally {
        }
    }

    public static final void M(n8.b bVar, n8.a aVar, e0 e0Var, e9.f fVar) {
        q7.k.e(bVar, "<this>");
        q7.k.e(aVar, "from");
        q7.k.e(e0Var, "scopeOwner");
        q7.k.e(fVar, "name");
        ((c0) e0Var).f4758j.b();
        q7.k.d(fVar.b(), "name.asString()");
    }

    public static final void N(Object[] objArr, int i2, int i10) {
        q7.k.e(objArr, "<this>");
        while (i2 < i10) {
            objArr[i2] = null;
            i2++;
        }
    }

    public static final float O(long j2, float f10, d2.c cVar) {
        float fC;
        long jB = d2.n.b(j2);
        if (o.a(jB, 4294967296L)) {
            if (cVar.j() <= 1.05d) {
                return cVar.J(j2);
            }
            fC = d2.n.c(j2) / d2.n.c(cVar.R(f10));
        } else {
            if (!o.a(jB, 8589934592L)) {
                return Float.NaN;
            }
            fC = d2.n.c(j2);
        }
        return fC * f10;
    }

    public static final void P(Spannable spannable, long j2, int i2, int i10) {
        if (j2 != 16) {
            spannable.setSpan(new ForegroundColorSpan(z.o(j2)), i2, i10, 33);
        }
    }

    public static final void Q(Spannable spannable, long j2, d2.c cVar, int i2, int i10) {
        long jB = d2.n.b(j2);
        if (o.a(jB, 4294967296L)) {
            spannable.setSpan(new AbsoluteSizeSpan(s7.a.U(cVar.J(j2)), false), i2, i10, 33);
        } else if (o.a(jB, 8589934592L)) {
            spannable.setSpan(new RelativeSizeSpan(d2.n.c(j2)), i2, i10, 33);
        }
    }

    public static final void R(Spannable spannable, y1.b bVar, int i2, int i10) {
        if (bVar != null) {
            ArrayList arrayList = new ArrayList(t.A0(bVar, 10));
            Iterator it = bVar.f11543f.iterator();
            while (it.hasNext()) {
                arrayList.add(((y1.a) it.next()).f11541a);
            }
            Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
            spannable.setSpan(new LocaleSpan(new LocaleList((Locale[]) Arrays.copyOf(localeArr, localeArr.length))), i2, i10, 33);
        }
    }

    public static Set S(Object obj) {
        Set setSingleton = Collections.singleton(obj);
        q7.k.d(setSingleton, "singleton(...)");
        return setSingleton;
    }

    public static String T(a1 a1Var) throws NoSuchAlgorithmException {
        int iOrdinal = a1Var.ordinal();
        if (iOrdinal == 1) {
            return "HmacSha1";
        }
        if (iOrdinal == 2) {
            return "HmacSha384";
        }
        if (iOrdinal == 3) {
            return "HmacSha256";
        }
        if (iOrdinal == 4) {
            return "HmacSha512";
        }
        if (iOrdinal == 5) {
            return "HmacSha224";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + a1Var);
    }

    public static final Class U(f8.j jVar) {
        if (!(jVar instanceof f8.e) || !h9.h.b(jVar)) {
            return null;
        }
        f8.e eVar = (f8.e) jVar;
        Class clsJ = x1.j(eVar);
        if (clsJ != null) {
            return clsJ;
        }
        throw new c7.i("Class object for the class " + eVar.getName() + " cannot be found (classId=" + l9.d.f((f8.g) jVar) + ')', 3);
    }

    public static final Class V(v vVar) {
        v9.z zVarF;
        q7.k.e(vVar, "<this>");
        Class clsU = U(vVar.E0().c());
        if (clsU == null) {
            return null;
        }
        if (x0.e(vVar) && ((zVarF = h9.h.f(vVar)) == null || x0.e(zVarF) || c8.h.F(zVarF))) {
            return null;
        }
        return clsU;
    }

    public static final long W(long j2) {
        return (Float.floatToRawIntBits((int) (j2 & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (j2 >> 32)) << 32);
    }

    public static Object X(p7.n nVar, Object obj, g7.d dVar) {
        q7.k.e(nVar, "<this>");
        g7.l context = dVar.getContext();
        Object dVar2 = context == g7.m.f3866f ? new h7.d(dVar) : new h7.e(dVar, context);
        q7.z.c(2, nVar);
        return nVar.invoke(obj, dVar2);
    }

    public static final long a(int i2, int i10) {
        return (i10 & 4294967295L) | (i2 << 32);
    }

    public static final d3.b b(BackEvent backEvent) {
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        return new d3.b(backEvent.getSwipeEdge(), backEvent.getProgress(), touchX, touchY, Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L);
    }

    public static final String c(Object[] objArr, int i2, int i10, d7.h hVar) {
        StringBuilder sb2 = new StringBuilder((i10 * 3) + 2);
        sb2.append("[");
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object obj = objArr[i2 + i11];
            if (obj == hVar) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(obj);
            }
        }
        sb2.append("]");
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    public static final void d(a7.a aVar, c1.l lVar) {
        d1.d dVar = (d1.d) aVar.f401c;
        d1.d dVar2 = (d1.d) aVar.f400b;
        boolean zL = l(lVar);
        long j2 = lVar.f1805b;
        long j4 = 0;
        if (zL) {
            d1.a[] aVarArr = dVar2.f2773c;
            n.d0(aVarArr, 0, aVarArr.length);
            dVar2.f2774d = 0;
            d1.a[] aVarArr2 = dVar.f2773c;
            n.d0(aVarArr2, 0, aVarArr2.length);
            dVar.f2774d = 0;
            aVar.f399a = 0L;
        }
        if (!m(lVar)) {
            List list = lVar.f1814k;
            if (list == null) {
                list = d7.z.f2978f;
            }
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                c1.a aVar2 = (c1.a) list.get(i2);
                long j10 = aVar2.f1768a;
                long jG = t0.b.g(aVar2.f1770c, j4);
                dVar2.a(Float.intBitsToFloat((int) (jG >> 32)), j10);
                dVar.a(Float.intBitsToFloat((int) (jG & 4294967295L)), j10);
                i2++;
                j4 = 0;
            }
            long jG2 = t0.b.g(lVar.f1815l, 0L);
            dVar2.a(Float.intBitsToFloat((int) (jG2 >> 32)), j2);
            dVar.a(Float.intBitsToFloat((int) (jG2 & 4294967295L)), j2);
        }
        if (m(lVar) && j2 - aVar.f399a > 40) {
            d1.a[] aVarArr3 = dVar2.f2773c;
            n.d0(aVarArr3, 0, aVarArr3.length);
            dVar2.f2774d = 0;
            d1.a[] aVarArr4 = dVar.f2773c;
            n.d0(aVarArr4, 0, aVarArr4.length);
            dVar.f2774d = 0;
            aVar.f399a = 0L;
        }
        aVar.f399a = j2;
    }

    public static void e(Throwable th, Throwable th2) {
        q7.k.e(th, "<this>");
        q7.k.e(th2, "exception");
        if (th != th2) {
            Integer num = l7.a.f5845a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = k7.a.f5648a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static void f(Appendable appendable, Object obj, p7.k kVar) {
        q7.k.e(appendable, "<this>");
        if (kVar != null) {
            appendable.append((CharSequence) kVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(obj.toString());
        }
    }

    public static final t0.c g(g1.k kVar) {
        g1.k kVarH = kVar.h();
        return kVarH != null ? kVarH.B(kVar, true) : new t0.c(0.0f, 0.0f, (int) (kVar.x() >> 32), (int) (kVar.x() & 4294967295L));
    }

    public static final t0.c h(d1 d1Var) {
        g1.k kVarW = w(d1Var);
        float fX = (int) (kVarW.x() >> 32);
        float fX2 = (int) (kVarW.x() & 4294967295L);
        t0.c cVarB = kVarW.B(d1Var, true);
        float f10 = cVarB.f9656a;
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > fX) {
            f10 = fX;
        }
        float f11 = cVarB.f9657b;
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (f11 > fX2) {
            f11 = fX2;
        }
        float f12 = cVarB.f9658c;
        if (f12 < 0.0f) {
            f12 = 0.0f;
        }
        if (f12 <= fX) {
            fX = f12;
        }
        float f13 = cVarB.f9659d;
        float f14 = f13 >= 0.0f ? f13 : 0.0f;
        if (f14 <= fX2) {
            fX2 = f14;
        }
        if (f10 == fX || f11 == fX2) {
            return t0.c.f9655e;
        }
        long jF = kVarW.f((Float.floatToRawIntBits(f10) << 32) | (Float.floatToRawIntBits(f11) & 4294967295L));
        long jF2 = kVarW.f((Float.floatToRawIntBits(f11) & 4294967295L) | (Float.floatToRawIntBits(fX) << 32));
        long jF3 = kVarW.f((Float.floatToRawIntBits(fX) << 32) | (Float.floatToRawIntBits(fX2) & 4294967295L));
        long jF4 = kVarW.f((Float.floatToRawIntBits(fX2) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jF >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jF2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jF4 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jF3 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jF & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jF2 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jF4 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jF3 & 4294967295L));
        return new t0.c(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    public static e7.j i(e7.j jVar) {
        e7.g gVar = jVar.f3117f;
        gVar.c();
        return gVar.f3107n > 0 ? jVar : e7.j.f3116g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [m0.a, m0.i] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3, types: [b0.a] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Integer] */
    public static final List j(s2 s2Var, Integer num, int i2, Integer num2) {
        int iB;
        k.z zVar;
        if (s2Var.f1368w || s2Var.o() == 0) {
            return d7.z.f2978f;
        }
        ?? iVar = new m0.i(s2Var);
        if (num2 != null) {
            iB = num2.intValue();
        } else {
            iB = s2Var.f1367v;
            if (iB < 0) {
                iB = s2Var.B(i2, s2Var.f1347b);
            }
        }
        if (num == 0) {
            int iK = s2Var.f1354i - s2Var.K(s2Var.q(i2), s2Var.f1347b);
            k.t tVar = s2Var.f1364s;
            num = Integer.valueOf(iK + ((tVar == null || (zVar = (k.z) tVar.b(i2)) == null) ? 0 : zVar.f5557b));
        }
        while (i2 >= 0) {
            iVar.c(s2Var.L(i2), num);
            num = s2Var.b(i2);
            if (iB >= 0) {
                int i10 = iB;
                iB = s2Var.B(iB, s2Var.f1347b);
                i2 = i10;
            } else {
                i2 = iB;
            }
        }
        return iVar.f6121f;
    }

    public static final Bundle k(c7.j... jVarArr) {
        Bundle bundle = new Bundle(jVarArr.length);
        for (c7.j jVar : jVarArr) {
            String str = (String) jVar.f1973f;
            Object obj = jVar.f1974g;
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else if (obj instanceof Object[]) {
                Class<?> componentType = obj.getClass().getComponentType();
                q7.k.b(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(str, (Parcelable[]) obj);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(str, (String[]) obj);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                    }
                    bundle.putSerializable(str, (Serializable) obj);
                }
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IBinder) {
                bundle.putBinder(str, (IBinder) obj);
            } else if (obj instanceof Size) {
                bundle.putSize(str, (Size) obj);
            } else {
                if (!(obj instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str + '\"');
                }
                bundle.putSizeF(str, (SizeF) obj);
            }
        }
        return bundle;
    }

    public static final boolean l(c1.l lVar) {
        return !lVar.f1811h && lVar.f1807d;
    }

    public static final boolean m(c1.l lVar) {
        return lVar.f1811h && !lVar.f1807d;
    }

    public static int n(Context context, String str) {
        int iNoteProxyOpNoThrow;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (strPermissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int iMyUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName)) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    iNoteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(strPermissionToOp, iMyUid, context.getOpPackageName()) : 1;
                    }
                } else {
                    iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, packageName);
                }
                if (iNoteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [c7.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [c7.f, java.lang.Object] */
    public static j9.f o(Class cls) {
        int i2 = 0;
        while (cls.isArray()) {
            i2++;
            cls = cls.getComponentType();
            q7.k.d(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (cls.equals(Void.TYPE)) {
                return new j9.f(e9.b.j(c8.m.f2033d.g()), i2);
            }
            c8.j jVarD = m9.c.b(cls.getName()).d();
            q7.k.d(jVarD, "get(currentClass.name).primitiveType");
            return i2 > 0 ? new j9.f(e9.b.j((e9.c) jVarD.f2019i.getValue()), i2 - 1) : new j9.f(e9.b.j((e9.c) jVarD.f2018h.getValue()), i2);
        }
        e9.b bVarA = l8.d.a(cls);
        String str = e8.d.f3123a;
        e9.b bVar = (e9.b) e8.d.f3130h.get(bVarA.b().i());
        if (bVar != null) {
            bVarA = bVar;
        }
        return new j9.f(bVarA, i2);
    }

    public static final Object p(Object obj, f8.c cVar) {
        v vVarZ;
        Class clsV;
        return (((cVar instanceof l0) && h9.h.d((t0) cVar)) || (vVarZ = z(cVar)) == null || (clsV = V(vVarZ)) == null) ? obj : A(clsV, cVar).invoke(obj, null);
    }

    public static int q(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static g7.d r(g7.d dVar, g7.d dVar2, p7.n nVar) {
        q7.k.e(nVar, "<this>");
        if (nVar instanceof i7.a) {
            return ((i7.a) nVar).create(dVar, dVar2);
        }
        g7.l context = dVar2.getContext();
        return context == g7.m.f3866f ? new h7.b(dVar2, dVar, nVar) : new h7.c(dVar2, context, nVar, dVar);
    }

    public static final a8.h s(a8.h hVar, f8.c cVar, boolean z4) {
        v vVarF;
        v vVarZ;
        q7.k.e(cVar, "descriptor");
        if (!h9.h.a(cVar)) {
            List listX0 = cVar.x0();
            q7.k.d(listX0, "descriptor.valueParameters");
            if (!listX0.isEmpty()) {
                Iterator it = listX0.iterator();
                while (it.hasNext()) {
                    v type = ((r0) it.next()).getType();
                    q7.k.d(type, "it.type");
                    if (h9.h.c(type)) {
                        break;
                    }
                }
                vVarF = cVar.f();
                return vVarF != null ? hVar : hVar;
            }
            vVarF = cVar.f();
            if ((vVarF != null || !h9.h.c(vVarF)) && ((hVar instanceof a8.f) || (vVarZ = z(cVar)) == null || !h9.h.c(vVarZ))) {
            }
        }
        return new x(hVar, cVar, z4);
    }

    public static final float t(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f10 = 0.0f;
        for (int i2 = 0; i2 < length; i2++) {
            f10 += fArr[i2] * fArr2[i2];
        }
        return f10;
    }

    public static String u(com.google.crypto.tink.shaded.protobuf.h hVar) {
        StringBuilder sb2 = new StringBuilder(hVar.size());
        for (int i2 = 0; i2 < hVar.size(); i2++) {
            byte bA = hVar.a(i2);
            if (bA == 34) {
                sb2.append("\\\"");
            } else if (bA == 39) {
                sb2.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bA >>> 6) & 3) + 48));
                            sb2.append((char) (((bA >>> 3) & 7) + 48));
                            sb2.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bA);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static String v(com.google.protobuf.l lVar) {
        StringBuilder sb2 = new StringBuilder(lVar.size());
        for (int i2 = 0; i2 < lVar.size(); i2++) {
            byte bA = lVar.a(i2);
            if (bA == 34) {
                sb2.append("\\\"");
            } else if (bA == 39) {
                sb2.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb2.append('\\');
                            sb2.append((char) (((bA >>> 6) & 3) + 48));
                            sb2.append((char) (((bA >>> 3) & 7) + 48));
                            sb2.append((char) ((bA & 7) + 48));
                            break;
                        } else {
                            sb2.append((char) bA);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static final g1.k w(g1.k kVar) {
        g1.k kVar2;
        g1.k kVarH = kVar.h();
        while (true) {
            g1.k kVar3 = kVarH;
            kVar2 = kVar;
            kVar = kVar3;
            if (kVar == null) {
                break;
            }
            kVarH = kVar.h();
        }
        d1 d1Var = kVar2 instanceof d1 ? (d1) kVar2 : null;
        if (d1Var == null) {
            return kVar2;
        }
        d1 d1Var2 = d1Var.f4439v;
        while (true) {
            d1 d1Var3 = d1Var2;
            d1 d1Var4 = d1Var;
            d1Var = d1Var3;
            if (d1Var == null) {
                return d1Var4;
            }
            d1Var2 = d1Var.f4439v;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static d0 x(String str) {
        q7.k.e(str, "javaName");
        int iHashCode = str.hashCode();
        if (iHashCode != 79201641) {
            if (iHashCode != 79923350) {
                switch (iHashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            return d0.TLS_1_1;
                        }
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            return d0.TLS_1_2;
                        }
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            return d0.TLS_1_3;
                        }
                        break;
                }
            } else if (str.equals("TLSv1")) {
                return d0.TLS_1_0;
            }
        } else if (str.equals("SSLv3")) {
            return d0.SSL_3_0;
        }
        throw new IllegalArgumentException("Unexpected TLS version: ".concat(str));
    }

    public static ab.l y(SSLSession sSLSession) throws IOException {
        Certificate[] peerCertificates;
        List listL = d7.z.f2978f;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        ab.g gVarC = ab.g.f528b.c(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        d0 d0VarX = x(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
        }
        List listL2 = peerCertificates != null ? bb.b.l(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listL;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listL = bb.b.l(Arrays.copyOf(localCertificates, localCertificates.length));
        }
        return new ab.l(d0VarX, gVarC, listL, new a8.c(1, listL2));
    }

    public static final v z(f8.c cVar) {
        i8.v vVarI = cVar.I();
        i8.v vVarY = cVar.y();
        if (vVarI != null) {
            return vVarI.getType();
        }
        if (vVarY != null) {
            if (cVar instanceof f8.i) {
                return vVarY.getType();
            }
            f8.j jVarP = cVar.p();
            f8.e eVar = jVarP instanceof f8.e ? (f8.e) jVarP : null;
            if (eVar != null) {
                return eVar.k();
            }
        }
        return null;
    }
}
