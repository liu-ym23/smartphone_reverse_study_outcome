package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static EnumMap f18200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static EnumMap f18201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static MMKVLogLevel[] f18202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f18203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f18204e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static MMKVHandler f18205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f18206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static MMKVContentChangeNotification f18207h;
    private long nativeHandle;

    public interface LibLoader {
        void loadLibrary(String r10);
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18208a = null;

        static {
            int[] r10 = new int[MMKVLogLevel.values().length];
            f18208a = r10;
            r10[MMKVLogLevel.LevelDebug.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f18208a[MMKVLogLevel.LevelInfo.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f18208a[MMKVLogLevel.LevelWarning.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f18208a[MMKVLogLevel.LevelError.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f18208a[MMKVLogLevel.LevelNone.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        EnumMap r10 = new EnumMap(MMKVRecoverStrategic.class);
        f18200a = r10;
        r10.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        f18200a.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        EnumMap r11 = new EnumMap(MMKVLogLevel.class);
        f18201b = r11;
        MMKVLogLevel r12 = MMKVLogLevel.LevelDebug;
        r11.put(r12, 0);
        EnumMap r13 = f18201b;
        MMKVLogLevel r14 = MMKVLogLevel.LevelInfo;
        r13.put(r14, 1);
        EnumMap r15 = f18201b;
        MMKVLogLevel r16 = MMKVLogLevel.LevelWarning;
        r15.put(r16, 2);
        EnumMap r17 = f18201b;
        MMKVLogLevel r18 = MMKVLogLevel.LevelError;
        r17.put(r18, 3);
        EnumMap r19 = f18201b;
        MMKVLogLevel r20 = MMKVLogLevel.LevelNone;
        r19.put(r20, 4);
        f18202c = new MMKVLogLevel[]{r12, r14, r16, r18, r20};
        f18203d = null;
        f18204e = new HashMap();
        f18206g = false;
    }

    public MMKV(long r10) {
        this.nativeHandle = r10;
    }

    private native boolean containsKey(long r10, String r11);

    private native long count(long r10);

    private static native long createNB(int r10);

    private native boolean decodeBool(long r10, String r11, boolean r12);

    private native byte[] decodeBytes(long r10, String r11);

    private native double decodeDouble(long r10, String r11, double r12);

    private native float decodeFloat(long r10, String r11, float r12);

    private native int decodeInt(long r10, String r11, int r12);

    private native long decodeLong(long r10, String r11, long r12);

    private native String decodeString(long r10, String r11, String r12);

    private native String[] decodeStringSet(long r10, String r11);

    private static native void destroyNB(long r10, int r11);

    private native boolean encodeBool(long r10, String r11, boolean r12);

    private native boolean encodeBytes(long r10, String r11, byte[] r12);

    private native boolean encodeDouble(long r10, String r11, double r12);

    private native boolean encodeFloat(long r10, String r11, float r12);

    private native boolean encodeInt(long r10, String r11, int r12);

    private native boolean encodeLong(long r10, String r11, long r12);

    private native boolean encodeSet(long r10, String r11, String[] r12);

    private native boolean encodeString(long r10, String r11, String r12);

    public static MMKV f() {
        if (f18203d == null) goto L7;
        return new MMKV(getDefaultMMKV(1, null));
    L7:
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native long getDefaultMMKV(int r10, String r11);

    private static native long getMMKVWithAshmemFD(String r10, int r11, int r12, String r13);

    private static native long getMMKVWithID(String r10, int r11, String r12, String r13);

    private static native long getMMKVWithIDAndSize(String r10, int r11, int r12, String r13);

    public static native boolean isFileValid(String r10);

    public static String j(Context r10) {
        return k(r10.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo);
    }

    private static native void jniInitialize(String r10, int r11);

    public static String k(String r10, LibLoader r11, MMKVLogLevel r12) {
        if (r11 == null) goto L5;
        r11.loadLibrary("mmkv");
    L6:
        f18203d = r10;
        jniInitialize(r10, l(r12));
        return r10;
    L5:
        System.loadLibrary("mmkv");
        goto L6
    }

    public static int l(MMKVLogLevel r10) {
        int r11 = a.f18208a[r10.ordinal()];
        if (r11 == 1) goto L15;
        int r12 = 2;
        if (r11 != 2) goto L7;
        return 1;
    L7:
        if (r11 == 3) goto L18;
        r12 = 4;
        if (r11 == 4) goto L19;
        if (r11 == 5) goto L18;
        return 1;
    L19:
        return 3;
    L18:
        return r12;
    L15:
        return 0;
    }

    public static MMKV m(String r10, int r11, int r12, String r13) {
        return new MMKV(getMMKVWithAshmemFD(r10, r11, r12, r13));
    }

    private static void mmkvLogImp(int r10, String r11, int r12, String r13, String r14) {
        MMKVHandler r15 = f18205f;
        if (r15 != null) goto L5;
    L7:
        int r16 = a.f18208a[f18202c[r10].ordinal()];
        if (r16 != 1) goto L10;
        Log.d("MMKV", r14);
        return;
    L10:
        if (r16 != 2) goto L12;
        Log.i("MMKV", r14);
        return;
    L12:
        if (r16 != 3) goto L14;
        Log.w("MMKV", r14);
        return;
    L14:
        if (r16 != 4) goto L25;
        Log.e("MMKV", r14);
        return;
    L25:
        return;
    L5:
        if (f18206g == false) goto L7;
        r15.mmkvLog(f18202c[r10], r11, r12, r13, r14);
    }

    public static MMKV n(Context r10, String r11, int r12, int r13, String r14) {
        if (f18203d == null) goto L32;
        String r15 = MMKVContentProvider.b(r10, Process.myPid());
        if (r15 != null) goto L7;
    L29:
        p(MMKVLogLevel.LevelError, "process name detect fail, try again later");
        return null;
    L7:
        if (r15.length() == 0) goto L29;
        if (r15.contains(":") == false) goto L27;
        Uri r16 = MMKVContentProvider.a(r10);
        if (r16 != null) goto L15;
        p(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
        return null;
    L15:
        MMKVLogLevel r17 = MMKVLogLevel.LevelInfo;
        p(r17, "getting parcelable mmkv in process, Uri = " + r16);
        Bundle r18 = new Bundle();
        r18.putInt("KEY_SIZE", r12);
        r18.putInt("KEY_MODE", r13);
        if (r14 == null) goto L18;
        r18.putString("KEY_CRYPT", r14);
    L18:
        Bundle r19 = r10.getContentResolver().call(r16, "mmkvFromAshmemID", r11, r18);
        if (r19 == null) goto L26;
        r19.setClassLoader(ParcelableMMKV.class.getClassLoader());
        ParcelableMMKV r20 = (ParcelableMMKV) r19.getParcelable("KEY");
        if (r20 == null) goto L26;
        MMKV r21 = r20.toMMKV();
        if (r21 == null) goto L25;
        p(r17, r21.mmapID() + " fd = " + r21.ashmemFD() + ", meta fd = " + r21.ashmemMetaFD());
    L25:
        return r21;
    L26:
        return null;
    L27:
        p(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        return new MMKV(getMMKVWithIDAndSize(r11, r12, r13 | 8, r14));
    L32:
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static void onContentChangedByOuterProcess(String r10) {
        MMKVContentChangeNotification r11 = f18207h;
        if (r11 == null) goto L6;
        r11.onContentChangedByOuterProcess(r10);
        return;
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String r10) {
        MMKVRecoverStrategic r11 = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler r12 = f18205f;
        if (r12 == null) goto L5;
        r11 = r12.onMMKVCRCCheckFail(r10);
    L5:
        p(MMKVLogLevel.LevelInfo, "Recover strategic for " + r10 + " is " + r11);
        Integer r13 = (Integer) f18200a.get(r11);
        if (r13 != null) goto L9;
        return 0;
    L9:
        return r13.intValue();
    }

    private static int onMMKVFileLengthError(String r10) {
        MMKVRecoverStrategic r11 = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler r12 = f18205f;
        if (r12 == null) goto L5;
        r11 = r12.onMMKVFileLengthError(r10);
    L5:
        p(MMKVLogLevel.LevelInfo, "Recover strategic for " + r10 + " is " + r11);
        Integer r13 = (Integer) f18200a.get(r11);
        if (r13 != null) goto L9;
        return 0;
    L9:
        return r13.intValue();
    }

    public static void p(MMKVLogLevel r10, String r11) {
        StackTraceElement[] r12 = Thread.currentThread().getStackTrace();
        StackTraceElement r13 = r12[r12.length - 1];
        Integer r14 = (Integer) f18201b.get(r10);
        if (r14 != null) goto L5;
        int r15 = 0;
    L6:
        mmkvLogImp(r15, r13.getFileName(), r13.getLineNumber(), r13.getMethodName(), r11);
        return;
    L5:
        r15 = r14.intValue();
        goto L6
    }

    public static native int pageSize();

    private native void removeValueForKey(long r10, String r11);

    private static native void setCallbackHandler(boolean r10, boolean r11);

    private static native void setLogLevel(int r10);

    private static native void setWantsContentChangeNotify(boolean r10);

    private native void sync(boolean r10);

    private native long totalSize(long r10);

    private native int valueSize(long r10, String r11, boolean r12);

    private native int writeValueToNB(long r10, String r11, long r12, int r13);

    public boolean a(String r10) {
        return containsKey(this.nativeHandle, r10);
    }

    public native String[] allKeys();

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public boolean b(String r10, boolean r11) {
        return decodeBool(this.nativeHandle, r10, r11);
    }

    public int c(String r10) {
        return decodeInt(this.nativeHandle, r10, 0);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(String r10);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r10) {
        return a(r10);
    }

    public native String cryptKey();

    public Set d(String r10, Set r11) {
        return e(r10, r11, HashSet.class);
    }

    public Set e(String r10, Set r11, Class r12) {
        String[] r13 = decodeStringSet(this.nativeHandle, r10);
        if (r13 != null) goto L9;
        return r11;
    L9:
        Set r14 = (Set) r12.newInstance();     // Catch: Throwable -> L8
        r14.addAll(Arrays.asList(r13));
        return r14;
    L8:
        return r11;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public boolean g(String r10, int r11) {
        return encodeInt(this.nativeHandle, r10, r11);
    }

    @Override // android.content.SharedPreferences
    public Map getAll() {
        throw new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r10, boolean r11) {
        return decodeBool(this.nativeHandle, r10, r11);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r10, float r11) {
        return decodeFloat(this.nativeHandle, r10, r11);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r10, int r11) {
        return decodeInt(this.nativeHandle, r10, r11);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r10, long r11) {
        return decodeLong(this.nativeHandle, r10, r11);
    }

    @Override // android.content.SharedPreferences
    public String getString(String r10, String r11) {
        return decodeString(this.nativeHandle, r10, r11);
    }

    @Override // android.content.SharedPreferences
    public Set getStringSet(String r10, Set r11) {
        return d(r10, r11);
    }

    public boolean h(String r10, Set r11) {
        return encodeSet(this.nativeHandle, r10, (String[]) r11.toArray(new String[0]));
    }

    public boolean i(String r10, boolean r11) {
        return encodeBool(this.nativeHandle, r10, r11);
    }

    public native void lock();

    public native String mmapID();

    public void o(String r10) {
        removeValueForKey(this.nativeHandle, r10);
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String r10, boolean r11) {
        encodeBool(this.nativeHandle, r10, r11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String r10, float r11) {
        encodeFloat(this.nativeHandle, r10, r11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String r10, int r11) {
        encodeInt(this.nativeHandle, r10, r11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String r10, long r11) {
        encodeLong(this.nativeHandle, r10, r11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String r10, String r11) {
        encodeString(this.nativeHandle, r10, r11);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String r10, Set r11) {
        h(r10, r11);
        return this;
    }

    public native boolean reKey(String r10);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String r10) {
        o(r10);
        return this;
    }

    public native void removeValuesForKeys(String[] r10);

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r10) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}
