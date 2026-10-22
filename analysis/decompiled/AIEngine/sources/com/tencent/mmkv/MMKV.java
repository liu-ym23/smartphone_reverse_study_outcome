package com.tencent.mmkv;

import a0.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import dalvik.annotation.optimization.FastNative;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumMap<MMKVRecoverStrategic, Integer> f8132a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumMap<MMKVLogLevel, Integer> f8133b;

    /* renamed from: c, reason: collision with root package name */
    public static final MMKVLogLevel[] f8134c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashSet f8135d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f8136e;

    /* renamed from: f, reason: collision with root package name */
    public static String f8137f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f8138g;
    private final long nativeHandle;

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        f8132a = enumMap;
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.f8144a, (MMKVRecoverStrategic) 0);
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.f8145b, (MMKVRecoverStrategic) 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>(MMKVLogLevel.class);
        f8133b = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.f8139a;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel, (MMKVLogLevel) 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.f8140b;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel2, (MMKVLogLevel) 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.f8141c;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel3, (MMKVLogLevel) 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.f8142d;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel4, (MMKVLogLevel) 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.f8143e;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel5, (MMKVLogLevel) 4);
        f8134c = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        f8135d = new HashSet();
        f8136e = false;
        f8137f = null;
        f8138g = true;
        new HashMap();
    }

    public MMKV(long j10) {
        this.nativeHandle = j10;
    }

    private native long actualSize(long j10);

    private native String[] allKeys(long j10, boolean z);

    public static MMKV b(long j10, int i10, String str) {
        String str2;
        if (j10 == 0) {
            throw new RuntimeException(a.k("Fail to create an MMKV instance [", str, "] in JNI"));
        }
        if (!f8138g) {
            return new MMKV(j10);
        }
        HashSet hashSet = f8135d;
        synchronized (hashSet) {
            try {
                if (!hashSet.contains(Long.valueOf(j10))) {
                    if (!checkProcessMode(j10)) {
                        if (i10 == 1) {
                            str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                        } else {
                            str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                        }
                        throw new IllegalArgumentException(str2);
                    }
                    hashSet.add(Long.valueOf(j10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new MMKV(j10);
    }

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, String str3);

    private static native boolean checkProcessMode(long j10);

    private native boolean containsKey(long j10, String str);

    private native long count(long j10, boolean z);

    private static native long createNB(int i10);

    private native boolean decodeBool(long j10, String str, boolean z);

    private native byte[] decodeBytes(long j10, String str);

    private native double decodeDouble(long j10, String str, double d8);

    private native float decodeFloat(long j10, String str, float f8);

    private native int decodeInt(long j10, String str, int i10);

    private native long decodeLong(long j10, String str, long j11);

    private native String decodeString(long j10, String str, String str2);

    private native String[] decodeStringSet(long j10, String str);

    private static native void destroyNB(long j10, int i10);

    private native boolean encodeBool(long j10, String str, boolean z);

    private native boolean encodeBool_2(long j10, String str, boolean z, int i10);

    private native boolean encodeBytes(long j10, String str, byte[] bArr);

    private native boolean encodeBytes_2(long j10, String str, byte[] bArr, int i10);

    private native boolean encodeDouble(long j10, String str, double d8);

    private native boolean encodeDouble_2(long j10, String str, double d8, int i10);

    private native boolean encodeFloat(long j10, String str, float f8);

    private native boolean encodeFloat_2(long j10, String str, float f8, int i10);

    private native boolean encodeInt(long j10, String str, int i10);

    private native boolean encodeInt_2(long j10, String str, int i10, int i11);

    private native boolean encodeLong(long j10, String str, long j11);

    private native boolean encodeLong_2(long j10, String str, long j11, int i10);

    private native boolean encodeSet(long j10, String str, String[] strArr);

    private native boolean encodeSet_2(long j10, String str, String[] strArr, int i10);

    private native boolean encodeString(long j10, String str, String str2);

    private native boolean encodeString_2(long j10, String str, String str2, int i10);

    private static native long getDefaultMMKV(int i10, String str);

    private static native long getMMKVWithAshmemFD(String str, int i10, int i11, String str2);

    public static native long getMMKVWithID(String str, int i10, String str2, String str3, long j10);

    private static native long getMMKVWithIDAndSize(String str, int i10, int i11, String str2);

    private static native boolean getNameSpace(String str);

    private native boolean isCompareBeforeSetEnabled();

    @FastNative
    private native boolean isEncryptionEnabled();

    @FastNative
    private native boolean isExpirationEnabled();

    public static native boolean isFileValid(String str, String str2);

    private static native void jniInitialize(String str, String str2, int i10, boolean z);

    public static void m(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + "/mmkv";
        if (!Process.is64Bit()) {
            throw new UnsupportedArchitectureException("MMKV 2.0+ requires 64-bit App, use 1.3.x instead.");
        }
        if ((context.getApplicationInfo().flags & 2) == 0) {
            synchronized (f8135d) {
                f8138g = false;
            }
            Log.i("MMKV", "Disable checkProcessMode()");
        } else {
            synchronized (f8135d) {
                f8138g = true;
            }
            Log.i("MMKV", "Enable checkProcessMode()");
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        if (!f8136e) {
            System.loadLibrary("mmkv");
            f8136e = true;
        }
        jniInitialize(str, absolutePath, 1, false);
        f8137f = str;
    }

    private static void mmkvLogImp(int i10, String str, int i11, String str2, String str3) {
        int iOrdinal = f8134c[i10].ordinal();
        if (iOrdinal == 0) {
            Log.d("MMKV", str3);
            return;
        }
        if (iOrdinal == 1) {
            Log.i("MMKV", str3);
        } else if (iOrdinal == 2) {
            Log.w("MMKV", str3);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            Log.e("MMKV", str3);
        }
    }

    public static MMKV n(String str, int i10, int i11, String str2) {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i10, i11, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException(a.k("Fail to create an ashmem MMKV instance [", str, "] in JNI"));
    }

    @FastNative
    private native void nativeEnableCompareBeforeSet();

    public static MMKV o(String str) {
        if (f8137f != null) {
            return b(getMMKVWithID(str, 2, null, null, 0L), 2, str);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        StringBuilder sb2 = new StringBuilder("Recover strategic for ");
        sb2.append(str);
        sb2.append(" is ");
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.f8144a;
        sb2.append(mMKVRecoverStrategic);
        q(sb2.toString());
        Integer num = f8132a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        StringBuilder sb2 = new StringBuilder("Recover strategic for ");
        sb2.append(str);
        sb2.append(" is ");
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.f8144a;
        sb2.append(mMKVRecoverStrategic);
        q(sb2.toString());
        Integer num = f8132a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static void q(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = f8133b.get(MMKVLogLevel.f8140b);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    public static native boolean removeStorage(String str, String str2);

    private native void removeValueForKey(long j10, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, String str3);

    private static native void setCallbackHandler(boolean z, boolean z3);

    private static native void setLogLevel(int i10);

    private static native void setWantsContentChangeNotify(boolean z);

    private native void sync(boolean z);

    private native long totalSize(long j10);

    private native int valueSize(long j10, String str, boolean z);

    public static native String version();

    private native int writeValueToNB(long j10, String str, long j11, int i10);

    public final String[] a() {
        return allKeys(this.nativeHandle, false);
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public final void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public final boolean c(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String str);

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public final boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public native String cryptKey();

    public final boolean d(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    public final int e(int i10, String str) {
        return decodeInt(this.nativeHandle, str, i10);
    }

    public native boolean enableAutoKeyExpire(int i10);

    public final long f(long j10, String str) {
        return decodeLong(this.nativeHandle, str, j10);
    }

    public final String g(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        return decodeBool(this.nativeHandle, str, z);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f8) {
        return decodeFloat(this.nativeHandle, str, f8);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i10) {
        return decodeInt(this.nativeHandle, str, i10);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j10) {
        return decodeLong(this.nativeHandle, str, j10);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (strArrDecodeStringSet != null) {
            try {
                Set<String> set2 = (Set) HashSet.class.newInstance();
                set2.addAll(Arrays.asList(strArrDecodeStringSet));
                return set2;
            } catch (IllegalAccessException | InstantiationException unused) {
            }
        }
        return set;
    }

    public final String h(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public final void i(int i10, String str) {
        encodeInt(this.nativeHandle, str, i10);
    }

    public native boolean isMultiProcess();

    public native boolean isReadOnly();

    public final void j(long j10, String str) {
        encodeLong(this.nativeHandle, str, j10);
    }

    public final void k(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
    }

    public final boolean l(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public native void lock();

    public native String mmapID();

    public final void p(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        encodeBool(this.nativeHandle, str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f8) {
        encodeFloat(this.nativeHandle, str, f8);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i10) {
        encodeInt(this.nativeHandle, str, i10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j10) {
        encodeLong(this.nativeHandle, str, j10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
        return this;
    }

    public final void r() {
        sync(true);
    }

    public native boolean reKey(String str);

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        p(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return this;
    }

    private static void onContentChangedByOuterProcess(String str) {
    }
}
