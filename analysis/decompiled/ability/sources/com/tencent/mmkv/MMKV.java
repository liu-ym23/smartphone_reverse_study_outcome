package com.tencent.mmkv;

import B7.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dalvik.annotation.optimization.FastNative;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int BACKUP_MODE = 16;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int ExpireInDay = 86400;
    public static final int ExpireInHour = 3600;
    public static final int ExpireInMinute = 60;
    public static final int ExpireInMonth = 2592000;
    public static final int ExpireInYear = 946080000;
    public static final int ExpireNever = 0;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int READ_ONLY_MODE = 32;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static final Set<Long> checkedHandleSet;
    private static MMKVHandler gCallbackHandler;
    private static MMKVContentChangeNotification gContentChangeNotify;
    private static boolean gWantLogReDirecting;
    private static final MMKVLogLevel[] index2LogLevel;
    private static boolean isNativeLibLoaded;
    private static boolean isProcessModeCheckerEnabled;
    private static final EnumMap<MMKVLogLevel, Integer> logLevel2Index;
    private static final HashMap<String, Parcelable.Creator<?>> mCreators;
    private static final EnumMap<MMKVRecoverStrategic, Integer> recoverIndex;
    private static String rootDir;
    private final long nativeHandle;

    /* renamed from: com.tencent.mmkv.MMKV$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mmkv$MMKVLogLevel;

        static {
            int[] iArr = new int[MMKVLogLevel.values().length];
            $SwitchMap$com$tencent$mmkv$MMKVLogLevel = iArr;
            try {
                iArr[MMKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface LibLoader {
        void loadLibrary(String str);
    }

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        recoverIndex = enumMap;
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.OnErrorDiscard, (MMKVRecoverStrategic) 0);
        enumMap.put((EnumMap<MMKVRecoverStrategic, Integer>) MMKVRecoverStrategic.OnErrorRecover, (MMKVRecoverStrategic) 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>(MMKVLogLevel.class);
        logLevel2Index = enumMap2;
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
        index2LogLevel = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        checkedHandleSet = new HashSet();
        isNativeLibLoaded = false;
        rootDir = null;
        isProcessModeCheckerEnabled = true;
        mCreators = new HashMap<>();
        gCallbackHandler = null;
        gWantLogReDirecting = false;
    }

    private MMKV(long j5) {
        this.nativeHandle = j5;
    }

    private native long actualSize(long j5);

    private native String[] allKeys(long j5, boolean z10);

    @NonNull
    public static MMKV backedUpMMKVWithID(String str, int i, @Nullable String str2, String str3) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        int i6 = i | 16;
        return checkProcessMode(getMMKVWithID(str, i6, str2, str3, 0L), str, i6);
    }

    public static native long backupAllToDirectory(String str);

    public static native boolean backupOneToDirectory(String str, String str2, @Nullable String str3);

    public static boolean checkExist(String str) {
        return checkExist(str, null);
    }

    public static native boolean checkExist(String str, @Nullable String str2);

    @NonNull
    public static MMKV checkProcessMode(long j5, String str, int i) throws RuntimeException {
        String str2;
        if (j5 == 0) {
            throw new RuntimeException(a.m("Fail to create an MMKV instance [", str, "] in JNI"));
        }
        if (!isProcessModeCheckerEnabled) {
            return new MMKV(j5);
        }
        Set<Long> set = checkedHandleSet;
        synchronized (set) {
            try {
                if (!set.contains(Long.valueOf(j5))) {
                    if (!checkProcessMode(j5)) {
                        if (i == 1) {
                            str2 = "Opening a multi-process MMKV instance [" + str + "] with SINGLE_PROCESS_MODE!";
                        } else {
                            str2 = ("Opening an MMKV instance [" + str + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                        }
                        throw new IllegalArgumentException(str2);
                    }
                    set.add(Long.valueOf(j5));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return new MMKV(j5);
    }

    private static native boolean checkProcessMode(long j5);

    private native boolean containsKey(long j5, String str);

    private native long count(long j5, boolean z10);

    private static native long createNB(int i);

    @Nullable
    public static NativeBuffer createNativeBuffer(int i) {
        long jCreateNB = createNB(i);
        if (jCreateNB == 0) {
            return null;
        }
        return new NativeBuffer(jCreateNB, i);
    }

    private native boolean decodeBool(long j5, String str, boolean z10);

    @Nullable
    private native byte[] decodeBytes(long j5, String str);

    private native double decodeDouble(long j5, String str, double d);

    private native float decodeFloat(long j5, String str, float f);

    private native int decodeInt(long j5, String str, int i);

    private native long decodeLong(long j5, String str, long j6);

    @Nullable
    private native String decodeString(long j5, String str, @Nullable String str2);

    @Nullable
    private native String[] decodeStringSet(long j5, String str);

    @NonNull
    public static MMKV defaultMMKV() throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static NameSpace defaultNameSpace() throws RuntimeException {
        String str = rootDir;
        if (str != null) {
            return new NameSpace(str);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native void destroyNB(long j5, int i);

    public static void destroyNativeBuffer(@NonNull NativeBuffer nativeBuffer) {
        destroyNB(nativeBuffer.pointer, nativeBuffer.size);
    }

    public static void disableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = false;
        }
        enableDisableProcessMode(false);
        Log.i("MMKV", "Disable checkProcessMode()");
    }

    private static String doInitialize(String str, String str2, LibLoader libLoader, MMKVLogLevel mMKVLogLevel, boolean z10, boolean z11, long j5) {
        tryLoadNativeLib(libLoader);
        jniInitialize(str, str2, logLevel2Int(mMKVLogLevel), z10, z11, j5);
        rootDir = str;
        return str;
    }

    private static native void enableDisableProcessMode(boolean z10);

    public static void enableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = true;
        }
        enableDisableProcessMode(true);
        Log.i("MMKV", "Enable checkProcessMode()");
    }

    private native boolean encodeBool(long j5, String str, boolean z10);

    private native boolean encodeBool_2(long j5, String str, boolean z10, int i);

    private native boolean encodeBytes(long j5, String str, @Nullable byte[] bArr);

    private native boolean encodeBytes_2(long j5, String str, @Nullable byte[] bArr, int i);

    private native boolean encodeDouble(long j5, String str, double d);

    private native boolean encodeDouble_2(long j5, String str, double d, int i);

    private native boolean encodeFloat(long j5, String str, float f);

    private native boolean encodeFloat_2(long j5, String str, float f, int i);

    private native boolean encodeInt(long j5, String str, int i);

    private native boolean encodeInt_2(long j5, String str, int i, int i6);

    private native boolean encodeLong(long j5, String str, long j6);

    private native boolean encodeLong_2(long j5, String str, long j6, int i);

    private native boolean encodeSet(long j5, String str, @Nullable String[] strArr);

    private native boolean encodeSet_2(long j5, String str, @Nullable String[] strArr, int i);

    private native boolean encodeString(long j5, String str, @Nullable String str2);

    private native boolean encodeString_2(long j5, String str, @Nullable String str2, int i);

    private static native long getDefaultMMKV(int i, @Nullable String str);

    private static native long getMMKVWithAshmemFD(String str, int i, int i6, @Nullable String str2);

    public static native long getMMKVWithID(String str, int i, @Nullable String str2, @Nullable String str3, long j5);

    private static native long getMMKVWithIDAndSize(String str, int i, int i6, @Nullable String str2);

    private static native boolean getNameSpace(String str);

    private byte[] getParcelableByte(@NonNull Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static String getRootDir() {
        return rootDir;
    }

    private native long importFrom(long j5, long j6);

    public static String initialize(@NonNull Context context) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo, null);
    }

    private native boolean isCompareBeforeSetEnabled();

    @FastNative
    private native boolean isEncryptionEnabled();

    @FastNative
    private native boolean isExpirationEnabled();

    public static boolean isFileValid(String str) {
        return isFileValid(str, null);
    }

    public static native boolean isFileValid(String str, @Nullable String str2);

    private static native void jniInitialize(String str, String str2, int i, boolean z10, boolean z11, long j5);

    private static int logLevel2Int(@NonNull MMKVLogLevel mMKVLogLevel) {
        int i = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[mMKVLogLevel.ordinal()];
        if (i == 1) {
            return 0;
        }
        int i6 = 2;
        if (i != 2) {
            i6 = 3;
            if (i != 3) {
                i6 = 4;
                if (i != 4) {
                    return 1;
                }
            }
        }
        return i6;
    }

    private static void mmkvLogImp(int i, String str, int i6, String str2, String str3) {
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null && gWantLogReDirecting) {
            mMKVHandler.mmkvLog(index2LogLevel[i], str, i6, str2, str3);
            return;
        }
        int i10 = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[index2LogLevel[i].ordinal()];
        if (i10 == 1) {
            Log.d("MMKV", str3);
            return;
        }
        if (i10 == 2) {
            Log.w("MMKV", str3);
        } else if (i10 == 3) {
            Log.e("MMKV", str3);
        } else {
            if (i10 != 5) {
                return;
            }
            Log.i("MMKV", str3);
        }
    }

    @NonNull
    public static MMKV mmkvWithAshmemFD(String str, int i, int i6, String str2) throws RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(str, i, i6, str2);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException(a.m("Fail to create an ashmem MMKV instance [", str, "] in JNI"));
    }

    @NonNull
    public static MMKV mmkvWithAshmemID(Context context, String str, int i, int i6, @Nullable String str2) throws RuntimeException {
        MMKV mmkv;
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String processNameByPID = MMKVContentProvider.getProcessNameByPID(context, Process.myPid());
        if (processNameByPID == null || processNameByPID.isEmpty()) {
            simpleLog(MMKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (processNameByPID.contains(":")) {
            Uri uriContentUri = MMKVContentProvider.contentUri(context);
            if (uriContentUri == null) {
                simpleLog(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
            simpleLog(mMKVLogLevel, a.j("getting parcelable mmkv in process, Uri = ", uriContentUri));
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_SIZE", i);
            bundle.putInt("KEY_MODE", i6);
            if (str2 != null) {
                bundle.putString("KEY_CRYPT", str2);
            }
            Bundle bundleCall = context.getContentResolver().call(uriContentUri, "mmkvFromAshmemID", str, bundle);
            if (bundleCall != null) {
                bundleCall.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelableMMKV = (ParcelableMMKV) bundleCall.getParcelable("KEY");
                if (parcelableMMKV != null && (mmkv = parcelableMMKV.toMMKV()) != null) {
                    simpleLog(mMKVLogLevel, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    return mmkv;
                }
            }
        }
        simpleLog(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        long mMKVWithIDAndSize = getMMKVWithIDAndSize(str, i, i6 | 8, str2);
        if (mMKVWithIDAndSize != 0) {
            return new MMKV(mMKVWithIDAndSize);
        }
        throw new IllegalStateException(a.m("Fail to create an Ashmem MMKV instance [", str, "]"));
    }

    @NonNull
    public static MMKV mmkvWithID(String str) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, 1, null, null, 0L), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static NameSpace nameSpace(String str) throws RuntimeException {
        tryLoadNativeLib(null);
        if (getNameSpace(str)) {
            return new NameSpace(str);
        }
        throw new RuntimeException(a.m("Fail to get NameSpace[", str, "] in JNI."));
    }

    @FastNative
    private native void nativeEnableCompareBeforeSet();

    private static void onContentChangedByOuterProcess(String str) {
        MMKVContentChangeNotification mMKVContentChangeNotification = gContentChangeNotify;
        if (mMKVContentChangeNotification != null) {
            mMKVContentChangeNotification.onContentChangedByOuterProcess(str);
        }
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategicOnMMKVCRCCheckFail = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategicOnMMKVCRCCheckFail = mMKVHandler.onMMKVCRCCheckFail(str);
        }
        simpleLog(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategicOnMMKVCRCCheckFail);
        Integer num = recoverIndex.get(mMKVRecoverStrategicOnMMKVCRCCheckFail);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String str) {
        MMKVRecoverStrategic mMKVRecoverStrategicOnMMKVFileLengthError = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategicOnMMKVFileLengthError = mMKVHandler.onMMKVFileLengthError(str);
        }
        simpleLog(MMKVLogLevel.LevelInfo, "Recover strategic for " + str + " is " + mMKVRecoverStrategicOnMMKVFileLengthError);
        Integer num = recoverIndex.get(mMKVRecoverStrategicOnMMKVFileLengthError);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static void registerContentChangeNotify(MMKVContentChangeNotification mMKVContentChangeNotification) {
        gContentChangeNotify = mMKVContentChangeNotification;
        setWantsContentChangeNotify(mMKVContentChangeNotification != null);
    }

    public static void registerHandler(MMKVHandler mMKVHandler) {
        gCallbackHandler = mMKVHandler;
        gWantLogReDirecting = mMKVHandler.wantLogRedirecting();
        setCallbackHandler(gWantLogReDirecting, true, gCallbackHandler.getNativeLogHandler());
    }

    public static boolean removeStorage(String str) {
        return removeStorage(str, null);
    }

    public static native boolean removeStorage(String str, @Nullable String str2);

    private native void removeValueForKey(long j5, String str);

    public static native long restoreAllFromDirectory(String str);

    public static native boolean restoreOneMMKVFromDirectory(String str, String str2, @Nullable String str3);

    private static native void setCallbackHandler(boolean z10, boolean z11, long j5);

    private static native void setLogLevel(int i);

    public static void setLogLevel(MMKVLogLevel mMKVLogLevel) {
        setLogLevel(logLevel2Int(mMKVLogLevel));
    }

    private static native void setWantsContentChangeNotify(boolean z10);

    private static void simpleLog(MMKVLogLevel mMKVLogLevel, String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = logLevel2Index.get(mMKVLogLevel);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), str);
    }

    private native void sync(boolean z10);

    private native long totalSize(long j5);

    private static void tryLoadNativeLib(@Nullable LibLoader libLoader) {
        if (isNativeLibLoaded) {
            return;
        }
        if (libLoader != null) {
            libLoader.loadLibrary("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        isNativeLibLoaded = true;
    }

    public static void unregisterContentChangeNotify() {
        gContentChangeNotify = null;
        setWantsContentChangeNotify(false);
    }

    public static void unregisterHandler() {
        gCallbackHandler = null;
        setCallbackHandler(false, false, 0L);
        gWantLogReDirecting = false;
    }

    private native int valueSize(long j5, String str, boolean z10);

    public static native String version();

    private native int writeValueToNB(long j5, String str, long j6, int i);

    public long actualSize() {
        return actualSize(this.nativeHandle);
    }

    @Nullable
    public String[] allKeys() {
        return allKeys(this.nativeHandle, false);
    }

    @Nullable
    public String[] allNonExpireKeys() {
        return allKeys(this.nativeHandle, true);
    }

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public void async() {
        sync(false);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@Nullable String str);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearAllWithKeepingSpace();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return containsKey(str);
    }

    public boolean containsKey(String str) {
        return containsKey(this.nativeHandle, str);
    }

    public long count() {
        return count(this.nativeHandle, false);
    }

    public long countNonExpiredKeys() {
        return count(this.nativeHandle, true);
    }

    @Nullable
    public native String cryptKey();

    public boolean decodeBool(String str) {
        return decodeBool(this.nativeHandle, str, false);
    }

    @Nullable
    public byte[] decodeBytes(String str) {
        return decodeBytes(str, (byte[]) null);
    }

    public double decodeDouble(String str) {
        return decodeDouble(this.nativeHandle, str, 0.0d);
    }

    public float decodeFloat(String str) {
        return decodeFloat(this.nativeHandle, str, 0.0f);
    }

    public int decodeInt(String str) {
        return decodeInt(this.nativeHandle, str, 0);
    }

    public long decodeLong(String str) {
        return decodeLong(this.nativeHandle, str, 0L);
    }

    @Nullable
    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        return (T) decodeParcelable(str, cls, null);
    }

    @Nullable
    public String decodeString(String str) {
        return decodeString(this.nativeHandle, str, null);
    }

    @Nullable
    public Set<String> decodeStringSet(String str) {
        return decodeStringSet(str, (Set<String>) null);
    }

    public native boolean disableAutoKeyExpire();

    public native void disableCompareBeforeSet();

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public native boolean enableAutoKeyExpire(int i);

    public void enableCompareBeforeSet() {
        if (isExpirationEnabled()) {
            Log.e("MMKV", "enableCompareBeforeSet is invalid when Expiration is on");
        }
        if (isEncryptionEnabled()) {
            Log.e("MMKV", "enableCompareBeforeSet is invalid when key encryption is on");
        }
        nativeEnableCompareBeforeSet();
    }

    public boolean encode(String str, boolean z10) {
        return encodeBool(this.nativeHandle, str, z10);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z10) {
        return decodeBool(this.nativeHandle, str, z10);
    }

    public byte[] getBytes(String str, @Nullable byte[] bArr) {
        return decodeBytes(str, bArr);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j5) {
        return decodeLong(this.nativeHandle, str, j5);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return decodeStringSet(str, set);
    }

    public int getValueActualSize(String str) {
        return valueSize(this.nativeHandle, str, true);
    }

    public int getValueSize(String str) {
        return valueSize(this.nativeHandle, str, false);
    }

    public long importFrom(MMKV mmkv) {
        return importFrom(this.nativeHandle, mmkv.nativeHandle);
    }

    public int importFromSharedPreferences(@NonNull SharedPreferences sharedPreferences) {
        MMKV mmkv;
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                if (value instanceof Boolean) {
                    this.encodeBool(this.nativeHandle, key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    this.encodeInt(this.nativeHandle, key, ((Integer) value).intValue());
                } else {
                    if (value instanceof Long) {
                        mmkv = this;
                        mmkv.encodeLong(this.nativeHandle, key, ((Long) value).longValue());
                    } else {
                        mmkv = this;
                        if (value instanceof Float) {
                            mmkv.encodeFloat(mmkv.nativeHandle, key, ((Float) value).floatValue());
                        } else if (value instanceof Double) {
                            mmkv.encodeDouble(mmkv.nativeHandle, key, ((Double) value).doubleValue());
                        } else if (value instanceof String) {
                            mmkv.encodeString(mmkv.nativeHandle, key, (String) value);
                        } else if (value instanceof Set) {
                            mmkv.encode(key, (Set<String>) value);
                        } else {
                            simpleLog(MMKVLogLevel.LevelError, "unknown type: " + value.getClass());
                        }
                    }
                    this = mmkv;
                }
                mmkv = this;
                this = mmkv;
            }
        }
        return all.size();
    }

    public native boolean isMultiProcess();

    public native boolean isReadOnly();

    public native void lock();

    public native String mmapID();

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z10) {
        encodeBool(this.nativeHandle, str, z10);
        return this;
    }

    public SharedPreferences.Editor putBytes(String str, @Nullable byte[] bArr) {
        encode(str, bArr);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        encodeFloat(this.nativeHandle, str, f);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        encodeInt(this.nativeHandle, str, i);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j5) {
        encodeLong(this.nativeHandle, str, j5);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, @Nullable String str2) {
        encodeString(this.nativeHandle, str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        encode(str, set);
        return this;
    }

    public native boolean reKey(@Nullable String str);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        removeValueForKey(str);
        return this;
    }

    public void removeValueForKey(String str) {
        removeValueForKey(this.nativeHandle, str);
    }

    public native void removeValuesForKeys(String[] strArr);

    public void sync() {
        sync(true);
    }

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public int writeValueToNativeBuffer(String str, @NonNull NativeBuffer nativeBuffer) {
        return writeValueToNB(this.nativeHandle, str, nativeBuffer.pointer, nativeBuffer.size);
    }

    public boolean decodeBool(String str, boolean z10) {
        return decodeBool(this.nativeHandle, str, z10);
    }

    @Nullable
    public byte[] decodeBytes(String str, @Nullable byte[] bArr) {
        byte[] bArrDecodeBytes = decodeBytes(this.nativeHandle, str);
        return bArrDecodeBytes != null ? bArrDecodeBytes : bArr;
    }

    public double decodeDouble(String str, double d) {
        return decodeDouble(this.nativeHandle, str, d);
    }

    public float decodeFloat(String str, float f) {
        return decodeFloat(this.nativeHandle, str, f);
    }

    public int decodeInt(String str, int i) {
        return decodeInt(this.nativeHandle, str, i);
    }

    public long decodeLong(String str, long j5) {
        return decodeLong(this.nativeHandle, str, j5);
    }

    @Nullable
    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, @Nullable T t9) {
        byte[] bArrDecodeBytes;
        Parcelable.Creator<?> creator;
        if (cls == null || (bArrDecodeBytes = decodeBytes(this.nativeHandle, str)) == null) {
            return t9;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
        parcelObtain.setDataPosition(0);
        try {
            String string = cls.toString();
            HashMap<String, Parcelable.Creator<?>> map = mCreators;
            synchronized (map) {
                try {
                    creator = map.get(string);
                    if (creator == null && (creator = (Parcelable.Creator) cls.getField("CREATOR").get(null)) != null) {
                        map.put(string, creator);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(parcelObtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + string);
        } catch (Exception e) {
            simpleLog(MMKVLogLevel.LevelError, e.toString());
            return t9;
        } finally {
            parcelObtain.recycle();
        }
    }

    @Nullable
    public String decodeString(String str, @Nullable String str2) {
        return decodeString(this.nativeHandle, str, str2);
    }

    @Nullable
    public Set<String> decodeStringSet(String str, @Nullable Set<String> set) {
        return decodeStringSet(str, set, HashSet.class);
    }

    public boolean encode(String str, boolean z10, int i) {
        return encodeBool_2(this.nativeHandle, str, z10, i);
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z10, int i) {
        encodeBool_2(this.nativeHandle, str, z10, i);
        return this;
    }

    public SharedPreferences.Editor putBytes(String str, @Nullable byte[] bArr, int i) {
        encode(str, bArr, i);
        return this;
    }

    public SharedPreferences.Editor putFloat(String str, float f, int i) {
        encodeFloat_2(this.nativeHandle, str, f, i);
        return this;
    }

    public SharedPreferences.Editor putInt(String str, int i, int i6) {
        encodeInt_2(this.nativeHandle, str, i, i6);
        return this;
    }

    public SharedPreferences.Editor putLong(String str, long j5, int i) {
        encodeLong_2(this.nativeHandle, str, j5, i);
        return this;
    }

    public SharedPreferences.Editor putString(String str, @Nullable String str2, int i) {
        encodeString_2(this.nativeHandle, str, str2, i);
        return this;
    }

    public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set, int i) {
        encode(str, set, i);
        return this;
    }

    @Nullable
    public Set<String> decodeStringSet(String str, @Nullable Set<String> set, Class<? extends Set> cls) throws IllegalAccessException, InstantiationException {
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

    public boolean encode(String str, int i) {
        return encodeInt(this.nativeHandle, str, i);
    }

    public static String initialize(@NonNull Context context, MMKVLogLevel mMKVLogLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, mMKVLogLevel, null);
    }

    public boolean encode(String str, int i, int i6) {
        return encodeInt_2(this.nativeHandle, str, i, i6);
    }

    @NonNull
    public static MMKV defaultMMKV(int i, @Nullable String str) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(i, str), "DefaultMMKV", i);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    @NonNull
    public static MMKV mmkvWithID(String str, int i) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, null, null, 0L), str, i);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String str, long j5) {
        return encodeLong(this.nativeHandle, str, j5);
    }

    public static String initialize(@NonNull Context context, LibLoader libLoader) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", libLoader, MMKVLogLevel.LevelInfo, null);
    }

    public boolean encode(String str, long j5, int i) {
        return encodeLong_2(this.nativeHandle, str, j5, i);
    }

    public boolean encode(String str, float f) {
        return encodeFloat(this.nativeHandle, str, f);
    }

    public boolean encode(String str, float f, int i) {
        return encodeFloat_2(this.nativeHandle, str, f, i);
    }

    public static String initialize(@NonNull Context context, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", libLoader, mMKVLogLevel, null);
    }

    @NonNull
    public static MMKV mmkvWithID(String str, int i, long j5) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, null, null, j5), str, i);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String str, double d) {
        return encodeDouble(this.nativeHandle, str, d);
    }

    public boolean encode(String str, double d, int i) {
        return encodeDouble_2(this.nativeHandle, str, d, i);
    }

    public static String initialize(Context context, String str) {
        return initialize(context, str, null, MMKVLogLevel.LevelInfo, null);
    }

    public boolean encode(String str, @Nullable String str2) {
        return encodeString(this.nativeHandle, str, str2);
    }

    public boolean encode(String str, @Nullable String str2, int i) {
        return encodeString_2(this.nativeHandle, str, str2, i);
    }

    public static String initialize(Context context, String str, MMKVLogLevel mMKVLogLevel) {
        return initialize(context, str, null, mMKVLogLevel, null);
    }

    @NonNull
    public static MMKV mmkvWithID(String str, int i, @Nullable String str2) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, str2, null, 0L), str, i);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String str, @Nullable Set<String> set) {
        return encodeSet(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]));
    }

    public static String initialize(Context context, String str, LibLoader libLoader) {
        return initialize(context, str, libLoader, MMKVLogLevel.LevelInfo, null);
    }

    public boolean encode(String str, @Nullable Set<String> set, int i) {
        return encodeSet_2(this.nativeHandle, str, set == null ? null : (String[]) set.toArray(new String[0]), i);
    }

    public boolean encode(String str, @Nullable byte[] bArr) {
        return encodeBytes(this.nativeHandle, str, bArr);
    }

    public static String initialize(Context context, String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        return initialize(context, str, libLoader, mMKVLogLevel, null);
    }

    public boolean encode(String str, @Nullable byte[] bArr, int i) {
        return encodeBytes_2(this.nativeHandle, str, bArr, i);
    }

    public static String initialize(@NonNull Context context, String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel, MMKVHandler mMKVHandler) {
        boolean z10;
        if (Process.is64Bit()) {
            String absolutePath = context.getCacheDir().getAbsolutePath();
            gCallbackHandler = mMKVHandler;
            long nativeLogHandler = 0;
            if (mMKVHandler != null) {
                z10 = true;
                if (mMKVHandler.wantLogRedirecting()) {
                    gWantLogReDirecting = true;
                    nativeLogHandler = mMKVHandler.getNativeLogHandler();
                }
            } else {
                z10 = false;
            }
            String strDoInitialize = doInitialize(str, absolutePath, libLoader, mMKVLogLevel, gWantLogReDirecting, z10, nativeLogHandler);
            if ((context.getApplicationInfo().flags & 2) == 0) {
                disableProcessModeChecker();
                return strDoInitialize;
            }
            enableProcessModeChecker();
            return strDoInitialize;
        }
        throw new UnsupportedArchitectureException("MMKV 2.0+ requires 64-bit App, use 1.3.x instead.");
    }

    @NonNull
    public static MMKV mmkvWithID(String str, String str2) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, 1, null, str2, 0L), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String str, @Nullable Parcelable parcelable) {
        if (parcelable == null) {
            return encodeBytes(this.nativeHandle, str, null);
        }
        return encodeBytes(this.nativeHandle, str, getParcelableByte(parcelable));
    }

    public boolean encode(String str, @Nullable Parcelable parcelable, int i) {
        if (parcelable == null) {
            return encodeBytes_2(this.nativeHandle, str, null, i);
        }
        return encodeBytes_2(this.nativeHandle, str, getParcelableByte(parcelable), i);
    }

    @NonNull
    public static MMKV mmkvWithID(String str, String str2, long j5) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, 1, null, str2, j5), str, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    @NonNull
    public static MMKV mmkvWithID(String str, int i, @Nullable String str2, String str3, long j5) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, str2, str3, j5), str, i);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    @Deprecated
    public static String initialize(String str) {
        return doInitialize(str, androidx.appfunctions.metadata.a.l(str, "/.tmp"), null, MMKVLogLevel.LevelInfo, false, false, 0L);
    }

    @NonNull
    public static MMKV mmkvWithID(String str, int i, @Nullable String str2, String str3) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(str, i, str2, str3, 0L), str, i);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    @Deprecated
    public static String initialize(String str, MMKVLogLevel mMKVLogLevel) {
        return doInitialize(str, androidx.appfunctions.metadata.a.l(str, "/.tmp"), null, mMKVLogLevel, false, false, 0L);
    }

    @Deprecated
    public static String initialize(String str, LibLoader libLoader) {
        return doInitialize(str, androidx.appfunctions.metadata.a.l(str, "/.tmp"), libLoader, MMKVLogLevel.LevelInfo, false, false, 0L);
    }

    @Deprecated
    public static String initialize(String str, LibLoader libLoader, MMKVLogLevel mMKVLogLevel) {
        return doInitialize(str, androidx.appfunctions.metadata.a.l(str, "/.tmp"), libLoader, mMKVLogLevel, false, false, 0L);
    }
}
