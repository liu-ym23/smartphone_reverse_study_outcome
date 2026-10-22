package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import b3.C0369C;
import j0.InterfaceC0630e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f3930f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3931a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f3932b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3933c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3934d;

    /* renamed from: e, reason: collision with root package name */
    public final d0 f3935e;

    public e0(HashMap initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f3931a = linkedHashMap;
        this.f3932b = new LinkedHashMap();
        this.f3933c = new LinkedHashMap();
        this.f3934d = new LinkedHashMap();
        this.f3935e = new d0(this, 1);
        linkedHashMap.putAll(initialState);
    }

    public static Bundle a(e0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = MapsKt__MapsKt.toMap(this$0.f3932b).entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap = this$0.f3931a;
            int i4 = 0;
            if (zHasNext) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                Bundle bundleA = ((InterfaceC0630e) entry.getValue()).a();
                Intrinsics.checkNotNullParameter(key, "key");
                Class[] clsArr = f3930f;
                while (i4 < 29) {
                    Class cls = clsArr[i4];
                    Intrinsics.checkNotNull(cls);
                    if (cls.isInstance(bundleA)) {
                        Object obj = this$0.f3933c.get(key);
                        U u4 = obj instanceof U ? (U) obj : null;
                        if (u4 != null) {
                            u4.g(bundleA);
                        } else {
                            linkedHashMap.put(key, bundleA);
                        }
                        b3.z zVar = (b3.z) this$0.f3934d.get(key);
                        if (zVar != null) {
                            ((C0369C) zVar).b(bundleA);
                        }
                    } else {
                        i4++;
                    }
                }
                StringBuilder sb = new StringBuilder("Can't put value with type ");
                Intrinsics.checkNotNull(bundleA);
                sb.append(bundleA.getClass());
                sb.append(" into saved state");
                throw new IllegalArgumentException(sb.toString());
            }
            Set<String> setKeySet = linkedHashMap.keySet();
            ArrayList arrayList = new ArrayList(setKeySet.size());
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (String str : setKeySet) {
                arrayList.add(str);
                arrayList2.add(linkedHashMap.get(str));
            }
            Pair[] pairArr = {TuplesKt.to("keys", arrayList), TuplesKt.to("values", arrayList2)};
            Bundle bundle = new Bundle(2);
            while (i4 < 2) {
                Pair pair = pairArr[i4];
                String str2 = (String) pair.component1();
                Object objComponent2 = pair.component2();
                if (objComponent2 == null) {
                    bundle.putString(str2, null);
                } else if (objComponent2 instanceof Boolean) {
                    bundle.putBoolean(str2, ((Boolean) objComponent2).booleanValue());
                } else if (objComponent2 instanceof Byte) {
                    bundle.putByte(str2, ((Number) objComponent2).byteValue());
                } else if (objComponent2 instanceof Character) {
                    bundle.putChar(str2, ((Character) objComponent2).charValue());
                } else if (objComponent2 instanceof Double) {
                    bundle.putDouble(str2, ((Number) objComponent2).doubleValue());
                } else if (objComponent2 instanceof Float) {
                    bundle.putFloat(str2, ((Number) objComponent2).floatValue());
                } else if (objComponent2 instanceof Integer) {
                    bundle.putInt(str2, ((Number) objComponent2).intValue());
                } else if (objComponent2 instanceof Long) {
                    bundle.putLong(str2, ((Number) objComponent2).longValue());
                } else if (objComponent2 instanceof Short) {
                    bundle.putShort(str2, ((Number) objComponent2).shortValue());
                } else if (objComponent2 instanceof Bundle) {
                    bundle.putBundle(str2, (Bundle) objComponent2);
                } else if (objComponent2 instanceof CharSequence) {
                    bundle.putCharSequence(str2, (CharSequence) objComponent2);
                } else if (objComponent2 instanceof Parcelable) {
                    bundle.putParcelable(str2, (Parcelable) objComponent2);
                } else if (objComponent2 instanceof boolean[]) {
                    bundle.putBooleanArray(str2, (boolean[]) objComponent2);
                } else if (objComponent2 instanceof byte[]) {
                    bundle.putByteArray(str2, (byte[]) objComponent2);
                } else if (objComponent2 instanceof char[]) {
                    bundle.putCharArray(str2, (char[]) objComponent2);
                } else if (objComponent2 instanceof double[]) {
                    bundle.putDoubleArray(str2, (double[]) objComponent2);
                } else if (objComponent2 instanceof float[]) {
                    bundle.putFloatArray(str2, (float[]) objComponent2);
                } else if (objComponent2 instanceof int[]) {
                    bundle.putIntArray(str2, (int[]) objComponent2);
                } else if (objComponent2 instanceof long[]) {
                    bundle.putLongArray(str2, (long[]) objComponent2);
                } else if (objComponent2 instanceof short[]) {
                    bundle.putShortArray(str2, (short[]) objComponent2);
                } else if (objComponent2 instanceof Object[]) {
                    Class<?> componentType = objComponent2.getClass().getComponentType();
                    Intrinsics.checkNotNull(componentType);
                    if (Parcelable.class.isAssignableFrom(componentType)) {
                        Intrinsics.checkNotNull(objComponent2, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                        bundle.putParcelableArray(str2, (Parcelable[]) objComponent2);
                    } else if (String.class.isAssignableFrom(componentType)) {
                        Intrinsics.checkNotNull(objComponent2, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                        bundle.putStringArray(str2, (String[]) objComponent2);
                    } else if (CharSequence.class.isAssignableFrom(componentType)) {
                        Intrinsics.checkNotNull(objComponent2, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                        bundle.putCharSequenceArray(str2, (CharSequence[]) objComponent2);
                    } else {
                        if (!Serializable.class.isAssignableFrom(componentType)) {
                            throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        bundle.putSerializable(str2, (Serializable) objComponent2);
                    }
                } else if (objComponent2 instanceof Serializable) {
                    bundle.putSerializable(str2, (Serializable) objComponent2);
                } else if (objComponent2 instanceof IBinder) {
                    bundle.putBinder(str2, (IBinder) objComponent2);
                } else if (objComponent2 instanceof Size) {
                    G.a.a(bundle, str2, (Size) objComponent2);
                } else {
                    if (!(objComponent2 instanceof SizeF)) {
                        throw new IllegalArgumentException("Illegal value type " + objComponent2.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                    }
                    G.a.b(bundle, str2, (SizeF) objComponent2);
                }
                i4++;
            }
            return bundle;
        }
    }

    public e0() {
        this.f3931a = new LinkedHashMap();
        this.f3932b = new LinkedHashMap();
        this.f3933c = new LinkedHashMap();
        this.f3934d = new LinkedHashMap();
        this.f3935e = new d0(this, 0);
    }
}
