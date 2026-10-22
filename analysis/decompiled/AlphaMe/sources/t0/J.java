package t0;

import Z2.AbstractC0149x;
import Z2.C0118c;
import Z2.C0148w;
import Z2.D0;
import Z2.G0;
import Z2.I0;
import Z2.InterfaceC0131i0;
import Z2.Q;
import Z2.V;
import a2.AbstractC0155a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.room.AbstractC0351g;
import androidx.work.impl.WorkDatabase;
import ch.qos.logback.core.joran.action.Action;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.statsrpk.RpkInfo;
import e3.AbstractC0553a;
import f1.AbstractC0557a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import k0.AbstractC0675c;
import k0.C0676d;
import k0.InterfaceC0674b;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import l0.C0754h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;
import s0.C0844b;

/* loaded from: classes.dex */
public abstract class J {

    /* renamed from: a, reason: collision with root package name */
    public static Method f15336a;

    public static final void A(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        if (databasePath.exists()) {
            s0.t.d().a(AbstractC0907B.f15314a, "Migrating WorkDatabase to the no-backup directory");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(context, "context");
            File databasePath2 = context.getDatabasePath("androidx.work.workdb");
            Intrinsics.checkNotNullExpressionValue(databasePath2, "context.getDatabasePath(WORK_DATABASE_NAME)");
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(C0915a.f15381a.a(context), "androidx.work.workdb");
            String[] strArr = AbstractC0907B.f15315b;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(strArr.length), 16));
            for (String str : strArr) {
                Pair pair = TuplesKt.to(new File(databasePath2.getPath() + str), new File(file.getPath() + str));
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            for (Map.Entry entry : MapsKt__MapsKt.plus(linkedHashMap, TuplesKt.to(databasePath2, file)).entrySet()) {
                File file2 = (File) entry.getKey();
                File file3 = (File) entry.getValue();
                if (file2.exists()) {
                    if (file3.exists()) {
                        s0.t.d().g(AbstractC0907B.f15314a, "Over-writing contents of " + file3);
                    }
                    s0.t.d().a(AbstractC0907B.f15314a, file2.renameTo(file3) ? "Migrated " + file2 + "to " + file3 : "Renaming " + file2 + " to " + file3 + " failed");
                }
            }
        }
    }

    public static void B(View view, EditorInfo editorInfo, InputConnection inputConnection) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static C.f C(XmlResourceParser xmlResourceParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (xmlResourceParser.getName().equals("font-family")) {
            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), B.a.f128b);
            String string = typedArrayObtainAttributes.getString(0);
            String string2 = typedArrayObtainAttributes.getString(4);
            String string3 = typedArrayObtainAttributes.getString(5);
            int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
            int integer = typedArrayObtainAttributes.getInteger(2, 1);
            int integer2 = typedArrayObtainAttributes.getInteger(3, 500);
            String string4 = typedArrayObtainAttributes.getString(6);
            typedArrayObtainAttributes.recycle();
            if (string != null && string2 != null && string3 != null) {
                while (xmlResourceParser.next() != 3) {
                    N(xmlResourceParser);
                }
                return new C.i(new H.d(string, string2, string3, J(resourceId, resources)), integer, integer2, string4);
            }
            ArrayList arrayList = new ArrayList();
            while (xmlResourceParser.next() != 3) {
                if (xmlResourceParser.getEventType() == 2) {
                    if (xmlResourceParser.getName().equals("font")) {
                        TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), B.a.f129c);
                        int i4 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE);
                        boolean z4 = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                        int i5 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                        String string5 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                        int i6 = typedArrayObtainAttributes2.getInt(i5, 0);
                        int i7 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                        int resourceId2 = typedArrayObtainAttributes2.getResourceId(i7, 0);
                        String string6 = typedArrayObtainAttributes2.getString(i7);
                        typedArrayObtainAttributes2.recycle();
                        while (xmlResourceParser.next() != 3) {
                            N(xmlResourceParser);
                        }
                        arrayList.add(new C.h(string6, i4, string5, i6, resourceId2, z4));
                    } else {
                        N(xmlResourceParser);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return new C.g((C.h[]) arrayList.toArray(new C.h[0]));
            }
        } else {
            N(xmlResourceParser);
        }
        return null;
    }

    public static PorterDuff.Mode D(int i4, PorterDuff.Mode mode) {
        if (i4 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i4 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i4 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i4) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static final File E(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        String fileName = Intrinsics.stringPlus(name, ".preferences_pb");
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), Intrinsics.stringPlus("datastore/", fileName));
    }

    public static final Cursor H(androidx.room.A db, androidx.room.E sqLiteQuery) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(sqLiteQuery, "sqLiteQuery");
        return db.query(sqLiteQuery, (CancellationSignal) null);
    }

    public static byte[] I(InputStream inputStream, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            int i6 = inputStream.read(bArr, i5, i4 - i5);
            if (i6 < 0) {
                throw new IllegalStateException(AbstractC0351g.m("Not enough bytes to read: ", i4));
            }
            i5 += i6;
        }
        return bArr;
    }

    public static List J(int i4, Resources resources) throws Resources.NotFoundException {
        if (i4 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i4);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (C.e.a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i5 = 0; i5 < typedArrayObtainTypedArray.length(); i5++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i5, 0);
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
                String[] stringArray2 = resources.getStringArray(i4);
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

    public static byte[] K(FileInputStream fileInputStream, int i4, int i5) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i5];
            byte[] bArr2 = new byte[2048];
            int i6 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i6 < i4) {
                int i7 = fileInputStream.read(bArr2);
                if (i7 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i4 + " bytes");
                }
                inflater.setInput(bArr2, 0, i7);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i5 - iInflate);
                    i6 += i7;
                } catch (DataFormatException e4) {
                    throw new IllegalStateException(e4.getMessage());
                }
            }
            if (i6 == i4) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw new IllegalStateException("Inflater did not finish");
            }
            throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i4 + " actual=" + i6);
        } finally {
            inflater.end();
        }
    }

    public static long L(InputStream inputStream, int i4) throws IOException {
        byte[] bArrI = I(inputStream, i4);
        long j4 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            j4 += (bArrI[i5] & UByte.MAX_VALUE) << (i5 * 8);
        }
        return j4;
    }

    public static Object M(Function2 function2) {
        V vA;
        CoroutineContext coroutineContextA;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        Thread threadCurrentThread = Thread.currentThread();
        ContinuationInterceptor.Companion key = ContinuationInterceptor.INSTANCE;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) emptyCoroutineContext.get(key);
        if (continuationInterceptor == null) {
            vA = G0.a();
            coroutineContextA = AbstractC0149x.a(emptyCoroutineContext, emptyCoroutineContext.plus(vA), true);
            f3.d dVar = Q.f2189a;
            if (coroutineContextA != dVar && coroutineContextA.get(key) == null) {
                coroutineContextA = coroutineContextA.plus(dVar);
            }
        } else {
            if (continuationInterceptor instanceof V) {
            }
            vA = (V) G0.f2166a.get();
            coroutineContextA = AbstractC0149x.a(emptyCoroutineContext, emptyCoroutineContext, true);
            f3.d dVar2 = Q.f2189a;
            if (coroutineContextA != dVar2 && coroutineContextA.get(key) == null) {
                coroutineContextA = coroutineContextA.plus(dVar2);
            }
        }
        C0118c c0118c = new C0118c(coroutineContextA, threadCurrentThread, vA);
        c0118c.Z(1, c0118c, function2);
        V v4 = c0118c.f2209e;
        if (v4 != null) {
            int i4 = V.f2193d;
            v4.m(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jW = v4 != null ? v4.w() : LongCompanionObject.MAX_VALUE;
                if (!(c0118c.G() instanceof InterfaceC0131i0)) {
                    if (v4 != null) {
                        int i5 = V.f2193d;
                        v4.e(false);
                    }
                    Object objG = Z2.I.G(c0118c.G());
                    Z2.r rVar = objG instanceof Z2.r ? (Z2.r) objG : null;
                    if (rVar == null) {
                        return objG;
                    }
                    throw rVar.f2238a;
                }
                LockSupport.parkNanos(c0118c, jW);
            } catch (Throwable th) {
                if (v4 != null) {
                    int i6 = V.f2193d;
                    v4.e(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c0118c.u(interruptedException);
        throw interruptedException;
    }

    public static void N(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i4 = 1;
        while (i4 > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i4++;
            } else if (next == 3) {
                i4--;
            }
        }
    }

    public static final Object O(Continuation continuation, CoroutineContext coroutineContext, Function2 function2) throws Throwable {
        Object objG;
        CoroutineContext context = continuation.get$context();
        CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(Boolean.FALSE, C0148w.f2253a)).booleanValue() ? context.plus(coroutineContext) : AbstractC0149x.a(context, coroutineContext, false);
        Z2.I.j(coroutineContextPlus);
        if (coroutineContextPlus == context) {
            d3.u uVar = new d3.u(continuation, coroutineContextPlus);
            objG = com.stepos.statsrpk.c.O(uVar, uVar, function2);
        } else {
            ContinuationInterceptor.Companion key = ContinuationInterceptor.INSTANCE;
            if (Intrinsics.areEqual(coroutineContextPlus.get(key), context.get(key))) {
                I0 i02 = new I0(continuation, coroutineContextPlus);
                CoroutineContext coroutineContext2 = i02.f2203c;
                Object objB = d3.B.b(coroutineContext2, null);
                try {
                    Object objO = com.stepos.statsrpk.c.O(i02, i02, function2);
                    d3.B.a(coroutineContext2, objB);
                    objG = objO;
                } catch (Throwable th) {
                    d3.B.a(coroutineContext2, objB);
                    throw th;
                }
            } else {
                Z2.N n4 = new Z2.N(continuation, coroutineContextPlus);
                AbstractC0553a.a(function2, n4, n4);
                while (true) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = Z2.N.f2187e;
                    int i4 = atomicIntegerFieldUpdater.get(n4);
                    if (i4 != 0) {
                        if (i4 != 2) {
                            throw new IllegalStateException("Already suspended".toString());
                        }
                        objG = Z2.I.G(n4.G());
                        if (objG instanceof Z2.r) {
                            throw ((Z2.r) objG).f2238a;
                        }
                    } else if (atomicIntegerFieldUpdater.compareAndSet(n4, 0, 1)) {
                        objG = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        break;
                    }
                }
            }
        }
        if (objG == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objG;
    }

    public static void P(Parcel parcel, int i4, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iZ = Z(parcel, i4);
        parcel.writeBundle(bundle);
        b0(parcel, iZ);
    }

    public static void Q(Parcel parcel, int i4, Float f4) {
        if (f4 == null) {
            return;
        }
        c0(parcel, i4, 4);
        parcel.writeFloat(f4.floatValue());
    }

    public static void R(Parcel parcel, int i4, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iZ = Z(parcel, i4);
        parcel.writeStrongBinder(iBinder);
        b0(parcel, iZ);
    }

    public static void S(Parcel parcel, int i4, int[] iArr) {
        if (iArr == null) {
            return;
        }
        int iZ = Z(parcel, i4);
        parcel.writeIntArray(iArr);
        b0(parcel, iZ);
    }

    public static void T(Parcel parcel, int i4, Parcelable parcelable, int i5) {
        if (parcelable == null) {
            return;
        }
        int iZ = Z(parcel, i4);
        parcelable.writeToParcel(parcel, i5);
        b0(parcel, iZ);
    }

    public static void U(Parcel parcel, int i4, String str) {
        if (str == null) {
            return;
        }
        int iZ = Z(parcel, i4);
        parcel.writeString(str);
        b0(parcel, iZ);
    }

    public static void V(Parcel parcel, int i4, Parcelable[] parcelableArr, int i5) {
        if (parcelableArr == null) {
            return;
        }
        int iZ = Z(parcel, i4);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i5);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        b0(parcel, iZ);
    }

    public static void W(Parcel parcel, int i4, List list) {
        if (list == null) {
            return;
        }
        int iZ = Z(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            Parcelable parcelable = (Parcelable) list.get(i5);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        b0(parcel, iZ);
    }

    public static void X(ByteArrayOutputStream byteArrayOutputStream, long j4, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = (byte) ((j4 >> (i5 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void Y(ByteArrayOutputStream byteArrayOutputStream, int i4) throws IOException {
        X(byteArrayOutputStream, i4, 2);
    }

    public static int Z(Parcel parcel, int i4) {
        parcel.writeInt(i4 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static long a(Context context) throws PackageManager.NameNotFoundException {
        try {
            return context.getPackageManager().getPackageInfo(d(context), 0).getLongVersionCode();
        } catch (Exception e4) {
            AbstractC0155a.c("AppUtils", "getAppVersionCode error: " + e4.getMessage());
            return 0L;
        }
    }

    public static boolean a0(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void b(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        T2.d.a("RpkUxipConfig", "parseAppInfo");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + rpkInfo.f12349a;
        T2.d.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        T2.d.a("SharedPreferencesHelper", str2 + " structure complete");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (!TextUtils.isEmpty(jSONObject.getString(Action.KEY_ATTRIBUTE))) {
            String string = jSONObject.getString(Action.KEY_ATTRIBUTE);
            rpkInfo.f12353e = string;
            editorEdit.putString("appKey", string);
        }
        if (!TextUtils.isEmpty(jSONObject.getString("primaryPackageName"))) {
            String string2 = jSONObject.getString("primaryPackageName");
            rpkInfo.f12352d = string2;
            editorEdit.putString("apkPkgName", string2);
        }
        editorEdit.commit();
    }

    public static void b0(Parcel parcel, int i4) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i4 - 4);
        parcel.writeInt(iDataPosition - i4);
        parcel.setDataPosition(iDataPosition);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x069f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x06ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0707 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(v.C0945e r36, t.e r37, java.util.ArrayList r38, int r39) {
        /*
            Method dump skipped, instructions count: 1813
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.J.c(v.e, t.e, java.util.ArrayList, int):void");
    }

    public static void c0(Parcel parcel, int i4, int i5) {
        parcel.writeInt(i4 | (i5 << 16));
    }

    public static String d(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.stepos.pushservice", 0);
            AbstractC0155a.a("AppUtils", "ZYQL_PUSH_PACKAGE_NAME: " + packageInfo);
            if (packageInfo != null) {
                AbstractC0155a.b("AppUtils", "getServicePackageName: com.stepos.pushservice");
                return "com.stepos.pushservice";
            }
        } catch (Exception e4) {
            AbstractC0155a.a("AppUtils", "getServicePackageName error. " + e4);
        }
        AbstractC0155a.b("AppUtils", "getServicePackageName: com.meizu.cloud");
        return "com.meizu.cloud";
    }

    public static void e(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        T2.d.a("RpkUxipConfig", "parseConfig");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + rpkInfo.f12349a;
        T2.d.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        T2.d.a("SharedPreferencesHelper", str2 + " structure complete");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt(Constants.JSON_KEY_VERSION, jSONObject.getInt(Constants.JSON_KEY_VERSION));
        editorEdit.putBoolean("active", jSONObject.getBoolean("active"));
        editorEdit.putString("getTime", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        editorEdit.commit();
        HashMap map = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("events");
        String strP = "";
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
            String string = jSONObject2.getString("name");
            boolean z4 = jSONObject2.getBoolean("active");
            boolean z5 = jSONObject2.getBoolean("realtime");
            boolean z6 = jSONObject2.getBoolean("neartime");
            map.put(string, new O2.a(string, z4, z5, z6));
            int i5 = !z4 ? 0 : (z5 || z6) ? 2 : 1;
            if (!string.contains(AwarenessDataItem.USERID_SPLITTER) && !string.contains(",")) {
                strP = strP + string + AwarenessDataItem.USERID_SPLITTER + i5;
                if (i4 < jSONArray.length() - 1) {
                    strP = AbstractC0351g.p(strP, ",");
                }
            }
        }
        editorEdit.putString("event_filters", strP);
        editorEdit.commit();
    }

    public static boolean f(D.f[] fVarArr, D.f[] fVarArr2) {
        if (fVarArr == null || fVarArr2 == null || fVarArr.length != fVarArr2.length) {
            return false;
        }
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            D.f fVar = fVarArr[i4];
            char c4 = fVar.f362a;
            D.f fVar2 = fVarArr2[i4];
            if (c4 != fVar2.f362a || fVar.f363b.length != fVar2.f363b.length) {
                return false;
            }
        }
        return true;
    }

    public static void j(boolean z4) {
        if (!z4) {
            throw new IllegalArgumentException();
        }
    }

    public static IBinder k() {
        try {
            if (f15336a == null) {
                f15336a = Class.forName("android.os.ServiceManager").getMethod("checkService", String.class);
            }
            return (IBinder) f15336a.invoke(null, "alphame_server");
        } catch (Exception e4) {
            AbstractC0351g.B("", e4, "AlphaMe");
            return null;
        }
    }

    public static void l(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e4) {
                Log.e("CommonUtils", "closeQuietly error " + e4.getMessage());
            }
        }
    }

    public static byte[] m(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static void n(Context context, String str, String str2) throws Throwable {
        if (str.isEmpty() || str2.isEmpty()) {
            return;
        }
        try {
            if (!new File(str2).exists()) {
                new File(str2).mkdirs();
            }
            for (String str3 : context.getAssets().list(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                String str4 = File.separator;
                sb.append(str4);
                sb.append(str3);
                String string = sb.toString();
                String str5 = str2 + str4 + str3;
                if (new File(string).isDirectory()) {
                    n(context, string, str5);
                } else {
                    o(context, string, str5);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x004c -> B:50:0x0072). Please report as a decompilation issue!!! */
    public static void o(Context context, String str, String str2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        if (str.isEmpty() || str2.isEmpty()) {
            return;
        }
        ?? r02 = 0;
        bufferedOutputStream = null;
        bufferedOutputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        r02 = 0;
        r02 = 0;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(context.getAssets().open(str));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str2)));
                    } catch (FileNotFoundException e4) {
                        e = e4;
                    } catch (IOException e5) {
                        e = e5;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedInputStream = null;
            } catch (IOException e7) {
                e = e7;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
            r02 = r02;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i4 = bufferedInputStream.read(bArr);
                r02 = -1;
                if (i4 == -1) {
                    break;
                } else {
                    bufferedOutputStream.write(bArr, 0, i4);
                }
            }
            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (FileNotFoundException e9) {
            e = e9;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            bufferedOutputStream2.close();
            bufferedInputStream.close();
            r02 = bufferedOutputStream2;
        } catch (IOException e10) {
            e = e10;
            bufferedOutputStream3 = bufferedOutputStream;
            e.printStackTrace();
            bufferedOutputStream3.close();
            bufferedInputStream.close();
            r02 = bufferedOutputStream3;
        } catch (Throwable th3) {
            th = th3;
            r02 = bufferedOutputStream;
            try {
                r02.close();
                bufferedInputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            throw th;
        }
    }

    public static float[] p(float[] fArr, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i4, length);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static D.f[] q(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.J.q(java.lang.String):D.f[]");
    }

    public static Path r(String str) {
        Path path = new Path();
        try {
            D.f.b(q(str), path);
            return path;
        } catch (RuntimeException e4) {
            throw new RuntimeException("Error in parsing ".concat(str), e4);
        }
    }

    public static final C0913H s(Context context, C0844b configuration) throws Resources.NotFoundException {
        androidx.room.w wVarQ;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        E0.c workTaskExecutor = new E0.c(configuration.f14171b);
        final Context context2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context.applicationContext");
        C0.o executor = workTaskExecutor.f400a;
        Intrinsics.checkNotNullExpressionValue(executor, "workTaskExecutor.serialTaskExecutor");
        boolean z4 = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(executor, "queryExecutor");
        y1.f clock = configuration.f14172c;
        Intrinsics.checkNotNullParameter(clock, "clock");
        if (z4) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(WorkDatabase.class, "klass");
            wVarQ = new androidx.room.w(context2, WorkDatabase.class, null);
            wVarQ.f4256j = true;
        } else {
            wVarQ = AbstractC0557a.q(context2, WorkDatabase.class, "androidx.work.workdb");
            wVarQ.f4255i = new k0.f() { // from class: t0.z
                @Override // k0.f
                public final k0.g create(k0.e configuration2) {
                    Context context3 = context2;
                    Intrinsics.checkNotNullParameter(context3, "$context");
                    Intrinsics.checkNotNullParameter(configuration2, "configuration");
                    C0676d c0676dD = E3.b.d(context3);
                    c0676dD.f13323b = configuration2.f13328b;
                    AbstractC0675c callback = configuration2.f13329c;
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    c0676dD.f13324c = callback;
                    c0676dD.f13325d = true;
                    c0676dD.f13326e = true;
                    k0.e configuration3 = c0676dD.a();
                    Intrinsics.checkNotNullParameter(configuration3, "configuration");
                    return new C0754h(configuration3.f13327a, configuration3.f13328b, configuration3.f13329c, configuration3.f13330d, configuration3.f13331e);
                }
            };
        }
        Intrinsics.checkNotNullParameter(executor, "executor");
        wVarQ.f4253g = executor;
        C0916b callback = new C0916b(clock);
        Intrinsics.checkNotNullParameter(callback, "callback");
        wVarQ.f4250d.add(callback);
        wVarQ.a(C0923i.f15388a);
        wVarQ.a(new s(context2, 2, 3));
        wVarQ.a(C0924j.f15389a);
        wVarQ.a(C0925k.f15390a);
        wVarQ.a(new s(context2, 5, 6));
        wVarQ.a(C0926l.f15391a);
        wVarQ.a(C0927m.f15392a);
        wVarQ.a(C0928n.f15393a);
        wVarQ.a(new s(context2));
        wVarQ.a(new s(context2, 10, 11));
        wVarQ.a(C0919e.f15384a);
        wVarQ.a(C0920f.f15385a);
        wVarQ.a(C0921g.f15386a);
        wVarQ.a(C0922h.f15387a);
        wVarQ.f4258l = false;
        wVarQ.f4259m = true;
        WorkDatabase workDatabase = (WorkDatabase) wVarQ.b();
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        z0.l trackers = new z0.l(applicationContext, workTaskExecutor);
        r processor = new r(context.getApplicationContext(), configuration, workTaskExecutor, workDatabase);
        C0914I schedulersCreator = C0914I.f15335a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(workTaskExecutor, "workTaskExecutor");
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(schedulersCreator, "schedulersCreator");
        return new C0913H(context.getApplicationContext(), configuration, workTaskExecutor, workDatabase, (List) schedulersCreator.invoke(context, configuration, workTaskExecutor, workDatabase, trackers, processor), processor, trackers);
    }

    public static D.f[] t(D.f[] fVarArr) {
        D.f[] fVarArr2 = new D.f[fVarArr.length];
        for (int i4 = 0; i4 < fVarArr.length; i4++) {
            fVarArr2[i4] = new D.f(fVarArr[i4]);
        }
        return fVarArr2;
    }

    public static final void u(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        Cursor cursorQuery = db.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = cursorQuery;
            while (cursor.moveToNext()) {
                listCreateListBuilder.add(cursor.getString(0));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursorQuery, null);
            for (String triggerName : CollectionsKt.build(listCreateListBuilder)) {
                Intrinsics.checkNotNullExpressionValue(triggerName, "triggerName");
                if (StringsKt.y(triggerName, "room_fts_content_sync_")) {
                    db.execSQL("DROP TRIGGER IF EXISTS " + triggerName);
                }
            }
        } finally {
        }
    }

    public static String v(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ColorStateList w(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (drawable instanceof ColorStateListDrawable) {
            return ((ColorStateListDrawable) drawable).getColorStateList();
        }
        return null;
    }

    public static boolean x(Context context) {
        try {
            String strU = com.stepos.statsrpk.c.u("persist.stepos.usagestats.debug", "");
            if (strU == null) {
                return false;
            }
            if (strU.equals("all")) {
                return true;
            }
            return strU.equals(context.getPackageName());
        } catch (Exception e4) {
            Log.e("CommonUtils", "isDebugMode error " + e4.getMessage());
            return false;
        }
    }

    public static D0 y(Z2.F f4, CoroutineContext.Element element, Function2 function2, int i4) {
        CoroutineContext coroutineContext = element;
        if ((i4 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContextA = AbstractC0149x.a(f4.e(), coroutineContext, true);
        f3.d dVar = Q.f2189a;
        if (coroutineContextA != dVar && coroutineContextA.get(ContinuationInterceptor.INSTANCE) == null) {
            coroutineContextA = coroutineContextA.plus(dVar);
        }
        D0 d02 = new D0(coroutineContextA, true);
        d02.Z(1, d02, function2);
        return d02;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:3:0x0002, B:5:0x0014, B:7:0x001b, B:8:0x0020, B:13:0x0033, B:15:0x0039, B:11:0x0027, B:12:0x0031), top: B:19:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String z(java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "(\\d{1,4}[-|\\/|年|\\.]\\d{1,2}[-|\\/|月|\\.]\\d{1,2}([日|号])?(\\s)*(\\d{1,2}([点|时])?((:)?\\d{1,2}(分)?((:)?\\d{1,2}(秒)?)?)?)?(\\s)*(PM|AM)?)"
            r2 = 10
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1, r2)     // Catch: java.lang.Exception -> L6a
            java.util.regex.Matcher r4 = r1.matcher(r4)     // Catch: java.lang.Exception -> L6a
            boolean r1 = r4.find()     // Catch: java.lang.Exception -> L6a
            if (r1 == 0) goto L31
            int r1 = r4.groupCount()     // Catch: java.lang.Exception -> L6a
            r2 = 1
            if (r1 < r2) goto L31
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L6a
            r1.<init>()     // Catch: java.lang.Exception -> L6a
        L20:
            int r3 = r4.groupCount()     // Catch: java.lang.Exception -> L6a
            if (r2 <= r3) goto L27
            goto L33
        L27:
            java.lang.String r3 = r4.group(r2)     // Catch: java.lang.Exception -> L6a
            r1.add(r3)     // Catch: java.lang.Exception -> L6a
            int r2 = r2 + 1
            goto L20
        L31:
            java.util.List r1 = java.util.Collections.EMPTY_LIST     // Catch: java.lang.Exception -> L6a
        L33:
            int r2 = r1.size()     // Catch: java.lang.Exception -> L6a
            if (r2 <= 0) goto L6a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6a
            r3 = 0
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L6a
            r2.<init>(r1)     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = "\t\t"
            r2.append(r1)     // Catch: java.lang.Exception -> L6a
            int r1 = r4.start()     // Catch: java.lang.Exception -> L6a
            r2.append(r1)     // Catch: java.lang.Exception -> L6a
            java.lang.String r1 = ","
            r2.append(r1)     // Catch: java.lang.Exception -> L6a
            int r4 = r4.end()     // Catch: java.lang.Exception -> L6a
            r2.append(r4)     // Catch: java.lang.Exception -> L6a
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Exception -> L6a
            return r4
        L6a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.J.z(java.lang.String):java.lang.String");
    }

    public abstract void F(D0.g gVar, D0.g gVar2);

    public abstract void G(D0.g gVar, Thread thread);

    public abstract boolean g(D0.h hVar, D0.c cVar, D0.c cVar2);

    public abstract boolean h(D0.h hVar, Object obj, Object obj2);

    public abstract boolean i(D0.h hVar, D0.g gVar, D0.g gVar2);
}
