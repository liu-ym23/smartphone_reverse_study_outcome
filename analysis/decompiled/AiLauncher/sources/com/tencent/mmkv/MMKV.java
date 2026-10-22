package com.tencent.mmkv;

import a8.C1239a;
import a8.InterfaceC1240b;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import dalvik.annotation.optimization.FastNative;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumMap<MMKVRecoverStrategic, Integer> f31704a;

    /* renamed from: b, reason: collision with root package name */
    public static final EnumMap<MMKVLogLevel, Integer> f31705b;

    /* renamed from: c, reason: collision with root package name */
    public static final MMKVLogLevel[] f31706c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<Long> f31707d;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f31708e;

    /* renamed from: f, reason: collision with root package name */
    public static String f31709f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f31710g;

    /* renamed from: h, reason: collision with root package name */
    public static final HashMap<String, Parcelable.Creator<?>> f31711h;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f31712i;
    private volatile long nativeHandle;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31713a;

        static {
            int[] iArr = new int[MMKVLogLevel.values().length];
            f31713a = iArr;
            try {
                iArr[MMKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31713a[MMKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31713a[MMKVLogLevel.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31713a[MMKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31713a[MMKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface b {
        void a(String str);
    }

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        f31704a = enumMap;
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.OnErrorDiscard, (MMKVRecoverStrategic) 0);
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.OnErrorRecover, (MMKVRecoverStrategic) 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>(MMKVLogLevel.class);
        f31705b = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel, (MMKVLogLevel) 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel2, (MMKVLogLevel) 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel3, (MMKVLogLevel) 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel4, (MMKVLogLevel) 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put((EnumMap<MMKVLogLevel, Integer>) mMKVLogLevel5, (MMKVLogLevel) 4);
        f31706c = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        f31707d = new HashSet();
        f31708e = false;
        f31709f = null;
        f31710g = true;
        f31711h = new HashMap<>();
        f31712i = false;
    }

    public MMKV(long j10) {
        this.nativeHandle = j10;
    }

    public static MMKV A(String str) throws RuntimeException {
        return C(str, new C1239a());
    }

    public static MMKV B(String str, int i10, String str2) throws RuntimeException {
        C1239a c1239a = new C1239a();
        c1239a.f8068a = i10;
        c1239a.f8070c = str2;
        return C(str, c1239a);
    }

    public static MMKV C(String str, C1239a c1239a) throws RuntimeException {
        int i10;
        if (f31709f == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        Boolean bool = c1239a.f8073f;
        if (bool != null) {
            i10 = bool.booleanValue() ? 1 : 0;
        } else {
            i10 = -1;
        }
        Integer num = f31704a.get(c1239a.f8076i);
        return a(getMMKVWithID(str, c1239a.f8068a, c1239a.f8070c, c1239a.f8071d, c1239a.f8072e, c1239a.f8069b, i10, c1239a.f8074g, c1239a.f8075h, num != null ? num.intValue() : -1, c1239a.f8077j), str, c1239a.f8068a);
    }

    public static void E(MMKVLogLevel mMKVLogLevel, String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = f31705b.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    public static void F(b bVar) {
        if (f31708e) {
            return;
        }
        if (bVar != null) {
            bVar.a("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        f31708e = true;
    }

    public static MMKV a(long j10, String str, int i10) throws RuntimeException {
        String str2;
        if (j10 == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + str + "] in JNI");
        }
        if (!f31710g) {
            return new MMKV(j10);
        }
        Set<Long> set = f31707d;
        synchronized (set) {
            try {
                if (!set.contains(Long.valueOf(j10))) {
                    if (!checkProcessMode(j10)) {
                        if (i10 == 1) {
                            str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                        } else {
                            str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                        }
                        throw new IllegalArgumentException(str2);
                    }
                    set.add(Long.valueOf(j10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new MMKV(j10);
    }

    private native long actualSize(long j10);

    private native String[] allKeys(long j10, boolean z10);

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, String str3);

    public static native boolean checkExist(String str, String str2);

    private static native boolean checkProcessMode(long j10);

    private static native void close(long j10);

    private native boolean containsKey(long j10, String str);

    private native long count(long j10, boolean z10);

    private static native long createNB(int i10);

    private native boolean decodeBool(long j10, String str, boolean z10);

    private native byte[] decodeBytes(long j10, String str);

    private native double decodeDouble(long j10, String str, double d10);

    private native float decodeFloat(long j10, String str, float f10);

    private native int decodeInt(long j10, String str, int i10);

    private native long decodeLong(long j10, String str, long j11);

    private native String decodeString(long j10, String str, String str2);

    private native String[] decodeStringSet(long j10, String str);

    private static native void destroyNB(long j10, int i10);

    private native void doCheckReSetCryptKey(String str, boolean z10);

    private native boolean doReKey(String str, boolean z10);

    private static native void enableDisableProcessMode(boolean z10);

    private native boolean encodeBool(long j10, String str, boolean z10);

    private native boolean encodeBool_2(long j10, String str, boolean z10, int i10);

    private native boolean encodeBytes(long j10, String str, byte[] bArr);

    private native boolean encodeBytes_2(long j10, String str, byte[] bArr, int i10);

    private native boolean encodeDouble(long j10, String str, double d10);

    private native boolean encodeDouble_2(long j10, String str, double d10, int i10);

    private native boolean encodeFloat(long j10, String str, float f10);

    private native boolean encodeFloat_2(long j10, String str, float f10, int i10);

    private native boolean encodeInt(long j10, String str, int i10);

    private native boolean encodeInt_2(long j10, String str, int i10, int i11);

    private native boolean encodeLong(long j10, String str, long j11);

    private native boolean encodeLong_2(long j10, String str, long j11, int i10);

    private native boolean encodeSet(long j10, String str, String[] strArr);

    private native boolean encodeSet_2(long j10, String str, String[] strArr, int i10);

    private native boolean encodeString(long j10, String str, String str2);

    private native boolean encodeString_2(long j10, String str, String str2, int i10);

    private static native long getDefaultMMKV(int i10, String str, long j10, boolean z10, int i11, int i12, boolean z11, int i13, int i14);

    private static native long getMMKVWithAshmemFD(String str, int i10, int i11, String str2, boolean z10);

    public static native long getMMKVWithID(String str, int i10, String str2, String str3, long j10, boolean z10, int i11, int i12, boolean z11, int i13, int i14);

    private static native boolean getNameSpace(String str);

    private native long importFrom(long j10, long j11);

    public static native boolean isFileValid(String str, String str2);

    private static native void jniInitialize(String str, String str2, int i10, boolean z10, boolean z11, long j10);

    public static MMKV k() throws RuntimeException {
        return l(new C1239a());
    }

    public static MMKV l(C1239a c1239a) throws RuntimeException {
        int i10;
        if (f31709f == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        Boolean bool = c1239a.f8073f;
        if (bool != null) {
            i10 = bool.booleanValue() ? 1 : 0;
        } else {
            i10 = -1;
        }
        Integer num = f31704a.get(c1239a.f8076i);
        return a(getDefaultMMKV(c1239a.f8068a, c1239a.f8070c, c1239a.f8072e, c1239a.f8069b, i10, c1239a.f8074g, c1239a.f8075h, num != null ? num.intValue() : -1, c1239a.f8077j), "DefaultMMKV", c1239a.f8068a);
    }

    public static void m() {
        synchronized (f31707d) {
            f31710g = false;
        }
        enableDisableProcessMode(false);
        Log.i("MMKV", "Disable checkProcessMode()");
    }

    private static void mmkvLogImp(int i10, String str, int i11, String str2, String str3) {
        int i12 = a.f31713a[f31706c[i10].ordinal()];
        if (i12 == 1) {
            Log.d("MMKV", str3);
            return;
        }
        if (i12 == 2) {
            Log.w("MMKV", str3);
        } else if (i12 == 3) {
            Log.e("MMKV", str3);
        } else {
            if (i12 != 5) {
                return;
            }
            Log.i("MMKV", str3);
        }
    }

    public static String n(String str, String str2, b bVar, MMKVLogLevel mMKVLogLevel, boolean z10, boolean z11, long j10) {
        F(bVar);
        jniInitialize(str, str2, x(mMKVLogLevel), z10, z11, j10);
        f31709f = str;
        return str;
    }

    @FastNative
    private native void nativeEnableCompareBeforeSet();

    public static void o() {
        synchronized (f31707d) {
            f31710g = true;
        }
        enableDisableProcessMode(true);
        Log.i("MMKV", "Enable checkProcessMode()");
    }

    private static void onContentChangedByOuterProcess(String str) {
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        E(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f31704a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static void onMMKVContentLoadSuccessfully(String str) {
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
        E(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategic);
        Integer num = f31704a.get(mMKVRecoverStrategic);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    private static native void readNB(long j10, byte[] bArr, int i10);

    public static native boolean removeStorage(String str, String str2);

    private native void removeValueForKey(long j10, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, String str3);

    private static native void setCallbackHandler(boolean z10, boolean z11, long j10);

    private static native void setLogLevel(int i10);

    private static native void setWantsContentChangeNotify(boolean z10);

    private native void sync(boolean z10);

    private native long totalSize(long j10);

    public static String v(Context context) {
        return w(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo, null);
    }

    private native int valueSize(long j10, String str, boolean z10);

    public static native String version();

    public static String w(Context context, String str, b bVar, MMKVLogLevel mMKVLogLevel, InterfaceC1240b interfaceC1240b) {
        boolean z10;
        if (!Process.is64Bit()) {
            throw new UnsupportedArchitectureException("MMKV 2.0+ requires 64-bit App, use 1.3.x instead.");
        }
        String absolutePath = context.getCacheDir().getAbsolutePath();
        long jC = 0;
        if (interfaceC1240b != null) {
            if (interfaceC1240b.b()) {
                f31712i = true;
                jC = interfaceC1240b.c();
            }
            z10 = true;
        } else {
            z10 = false;
        }
        String strN = n(str, absolutePath, bVar, mMKVLogLevel, f31712i, z10, jC);
        if (interfaceC1240b != null && interfaceC1240b.a()) {
            setWantsContentChangeNotify(true);
        }
        if ((context.getApplicationInfo().flags & 2) == 0) {
            m();
            return strN;
        }
        o();
        return strN;
    }

    private native int writeValueToNB(long j10, String str, long j11, int i10);

    public static int x(MMKVLogLevel mMKVLogLevel) {
        int i10 = a.f31713a[mMKVLogLevel.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        int i11 = 2;
        if (i10 != 2) {
            i11 = 3;
            if (i10 != 3) {
                i11 = 4;
                if (i10 != 4) {
                    return 1;
                }
            }
        }
        return i11;
    }

    public static MMKV y(String str, int i10, int i11, String str2) throws RuntimeException {
        return z(str, i10, i11, str2, false);
    }

    public static MMKV z(String str, int i10, int i11, String str2, boolean z10) throws RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i10, i11, str2, z10);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + str + "] in JNI");
    }

    public void D(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean b(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public boolean c(String str, boolean z10) {
        return decodeBool(this.nativeHandle, str, z10);
    }

    public native void checkContentChangedByOuterProcess();

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return b(str);
    }

    public native String cryptKey();

    public byte[] d(String str) {
        return e(str, null);
    }

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    public byte[] e(String str, byte[] bArr) {
        byte[] bArrDecodeBytes = decodeBytes(this.nativeHandle, str);
        return bArrDecodeBytes != null ? bArrDecodeBytes : bArr;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public native boolean enableAutoKeyExpire(int i10);

    public int f(String str, int i10) {
        return decodeInt(this.nativeHandle, str, i10);
    }

    public long g(String str, long j10) {
        return decodeLong(this.nativeHandle, str, j10);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z10) {
        return decodeBool(this.nativeHandle, str, z10);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f10) {
        return decodeFloat(this.nativeHandle, str, f10);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i10) {
        return decodeInt(this.nativeHandle, str, i10);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j10) {
        return decodeLong(this.nativeHandle, str, j10);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return i(str, set);
    }

    public String h(String str, String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    public Set<String> i(String str, Set<String> set) {
        return j(str, set, HashSet.class);
    }

    public native boolean isCompareBeforeSetEnabled();

    @FastNative
    public native boolean isEncryptionEnabled();

    @FastNative
    public native boolean isExpirationEnabled();

    public native boolean isMultiProcess();

    public native boolean isReadOnly();

    public Set<String> j(String str, Set<String> set, Class<? extends Set> cls) throws IllegalAccessException, InstantiationException {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, str);
        if (strArrDecodeStringSet != null) {
            try {
                Set<String> setNewInstance = cls.newInstance();
                setNewInstance.addAll(Arrays.asList(strArrDecodeStringSet));
                return setNewInstance;
            } catch (IllegalAccessException | InstantiationException unused) {
            }
        }
        return set;
    }

    public native void lock();

    public native String mmapID();

    public boolean p(String str, int i10) {
        return encodeInt(this.nativeHandle, str, i10);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z10) {
        encodeBool(this.nativeHandle, str, z10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f10) {
        encodeFloat(this.nativeHandle, str, f10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i10) {
        encodeInt(this.nativeHandle, str, i10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j10) {
        encodeLong(this.nativeHandle, str, j10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        s(str, set);
        return this;
    }

    public boolean q(String str, long j10) {
        return encodeLong(this.nativeHandle, str, j10);
    }

    public boolean r(String str, String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        D(str);
        return this;
    }

    public native void removeValuesForKeys(String[] strArr);

    public boolean s(String str, Set<String> set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public boolean t(String str, boolean z10) {
        return encodeBool(this.nativeHandle, str, z10);
    }

    public native void trim();

    public native boolean tryLock();

    public boolean u(String str, byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }
}
