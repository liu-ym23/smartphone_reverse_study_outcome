package com.android.server.input;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.hardware.input.InputManager;
import android.hardware.input.KeyGlyphMap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InputDevice;
import com.android.internal.R;
import com.android.internal.util.XmlUtils;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.pm.Settings;
import com.android.server.slice.SliceClientPermissions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyboardGlyphManager implements InputManager.InputDeviceListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "KeyboardGlyphManager";
    private static final String TAG_FUNCTION_ROW_KEY = "function-row-key";
    private static final String TAG_HARDWARE_DEFINED_SHORTCUT = "hardware-defined-shortcut";
    private static final String TAG_KEYBOARD_GLYPH_MAP = "keyboard-glyph-map";
    private static final String TAG_KEYBOARD_GLYPH_MAPS = "keyboard-glyph-maps";
    private static final String TAG_KEY_GLYPH = "key-glyph";
    private static final String TAG_MODIFIER_GLYPH = "modifier-glyph";
    private final Context mContext;
    private final SparseArray<KeyGlyphMap> mGlyphMapCache;
    private List<KeyGlyphMapData> mGlyphMapDataList;
    private boolean mGlyphMapDataLoaded;
    private final Object mGlyphMapLock;
    private final Handler mHandler;

    private static final class KeyGlyphMapData extends Record {
        private final String packageName;
        private final int productId;
        private final String receiverName;
        private final int resourceId;
        private final int vendorId;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof KeyGlyphMapData) == false) goto L16;
            KeyGlyphMapData r4 = (KeyGlyphMapData) r3;
            if (this.resourceId == r4.resourceId) goto L7;
            return false;
        L7:
            if (this.vendorId == r4.vendorId) goto L9;
            return false;
        L9:
            if (this.productId == r4.productId) goto L11;
            return false;
        L11:
            if (Objects.equals(this.packageName, r4.packageName) == true) goto L13;
            return false;
        L13:
            if (Objects.equals(this.receiverName, r4.receiverName) == false) goto L22;
            return true;
        L22:
            return false;
        L16:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{this.packageName, this.receiverName, Integer.valueOf(this.resourceId), Integer.valueOf(this.vendorId), Integer.valueOf(this.productId)};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetpackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m4576$$Nest$fgetpackageName(KeyGlyphMapData r0) {
            return r0.packageName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetproductId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4577$$Nest$fgetproductId(KeyGlyphMapData r0) {
            return r0.productId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetreceiverName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m4578$$Nest$fgetreceiverName(KeyGlyphMapData r0) {
            return r0.receiverName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetresourceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4579$$Nest$fgetresourceId(KeyGlyphMapData r0) {
            return r0.resourceId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetvendorId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4580$$Nest$fgetvendorId(KeyGlyphMapData r0) {
            return r0.vendorId;
        }

        /* synthetic */ KeyGlyphMapData(String r1, String r2, int r3, int r4, int r5, KeyboardGlyphManagerIA r6) {
            this(r1, r2, r3, r4, r5);
        }

        private KeyGlyphMapData(String packageName, String receiverName, int resourceId, int vendorId, int productId) {
            this.packageName = packageName;
            this.receiverName = receiverName;
            this.resourceId = resourceId;
            this.vendorId = vendorId;
            this.productId = productId;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return KeyboardGlyphManager$KeyGlyphMapData$$ExternalSyntheticRecord0.m(this.resourceId, this.vendorId, this.productId, this.packageName, this.receiverName);
        }

        public String packageName() {
            return this.packageName;
        }

        public int productId() {
            return this.productId;
        }

        public String receiverName() {
            return this.receiverName;
        }

        public int resourceId() {
            return this.resourceId;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), KeyGlyphMapData.class, "packageName;receiverName;resourceId;vendorId;productId");
        }

        public int vendorId() {
            return this.vendorId;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mresetMaps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4575$$Nest$mresetMaps(KeyboardGlyphManager r0) {
        r0.resetMaps();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    KeyboardGlyphManager(Context context, Looper looper) {
        this.mGlyphMapLock = new Object();
        this.mGlyphMapDataLoaded = false;
        this.mGlyphMapDataList = new ArrayList();
        this.mGlyphMapCache = new SparseArray();
        this.mContext = context;
        this.mHandler = new Handler(looper);
    }

    void systemRunning() {
        IntentFilter filter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiver(new AnonymousClass1(this), filter, null, this.mHandler);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        Object r0 = this.mGlyphMapLock;
        monitor-enter(r0);
        this.mGlyphMapCache.remove(deviceId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
    }

    private void resetMaps() {
        Object r0 = this.mGlyphMapLock;
        monitor-enter(r0);
        this.mGlyphMapDataLoaded = false;     // Catch: Throwable -> L8
        this.mGlyphMapDataList.clear();     // Catch: Throwable -> L8
        this.mGlyphMapCache.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private List<KeyGlyphMapData> loadGlyphMapDataList() {
        PackageManager pm = this.mContext.getPackageManager();
        List<KeyGlyphMapData> glyphMaps = new ArrayList();
        Intent intent = new Intent("android.hardware.input.action.QUERY_KEYBOARD_GLYPH_MAPS");
        Iterator r3 = pm.queryBroadcastReceiversAsUser(intent, 786560, 0).iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        ResolveInfo resolveInfo = (ResolveInfo) r3.next();
        if (resolveInfo == null) goto L4;
        if (resolveInfo.activityInfo == null) goto L4;
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        List<KeyGlyphMapData> data = getKeyboardGlyphMapsInPackage(pm, activityInfo);
        if (data == null) goto L4;
        if (data.isEmpty() == true) goto L4;
        glyphMaps.addAll(data);
        goto L4
    L16:
        return glyphMaps;
    }

    private List<KeyGlyphMapData> getKeyboardGlyphMapsInPackage(PackageManager pm, ActivityInfo receiver) {
        Bundle metaData = receiver.metaData;
        if (metaData != null) goto L5;
        return null;
    L5:
        int configResId = metaData.getInt("android.hardware.input.metadata.KEYBOARD_GLYPH_MAPS");
        if (configResId != 0) goto L53;
        Slog.w(TAG, "Missing meta-data 'android.hardware.input.metadata.KEYBOARD_GLYPH_MAPS' on receiver " + receiver.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiver.name);
        return null;
    L53:
        Resources resources = pm.getResourcesForApplication(receiver.applicationInfo);     // Catch: Exception -> L19
        List<KeyGlyphMapData> glyphMaps = new ArrayList();     // Catch: Exception -> L19
        XmlResourceParser parser = resources.getXml(configResId);     // Catch: Exception -> L19
        XmlUtils.beginDocument(parser, TAG_KEYBOARD_GLYPH_MAPS);     // Catch: Throwable -> L36
    L14:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L36
        String element = parser.getName();     // Catch: Throwable -> L36
        if (element == null) goto L17;
        if (TAG_KEYBOARD_GLYPH_MAP.equals(element) == false) goto L14;
        TypedArray a = resources.obtainAttributes(parser, R.styleable.KeyboardGlyphMap);     // Catch: Throwable -> L36
        int glyphMapRes = a.getResourceId(0, 0);     // Catch: Throwable -> L32
        int vendor2 = a.getInt(2, -1);     // Catch: Throwable -> L32
        int product = a.getInt(1, -1);     // Catch: Throwable -> L32
        if (glyphMapRes == 0) goto L35;
        if (vendor2 == (-1)) goto L35;
        if (product == (-1)) goto L35;
        glyphMaps.add(new KeyGlyphMapData(receiver.packageName, receiver.name, glyphMapRes, vendor2, product, null));     // Catch: Throwable -> L32
    L35:
        a.recycle();     // Catch: Throwable -> L36
    L32:
        th = move-exception;
        a.recycle();     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L17:
        parser.close();     // Catch: Exception -> L19
        return glyphMaps;
    L36:
        th = move-exception;
        if (parser == null) goto L66;
        parser.close();     // Catch: Throwable -> L43
    L67:
        throw th;     // Catch: Exception -> L19
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L66:
        throw th;     // Catch: Exception -> L19
    L19:
        ex = e;
    L49:
        Slog.w(TAG, "Could not parse keyboard glyph map resource from receiver " + receiver.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiver.name, ex);
        return null;
    L47:
        ex = e;
        goto L49
    }

    private KeyGlyphMap loadGlyphMap(KeyGlyphMapData data) {
        PackageManager pm = this.mContext.getPackageManager();
        ComponentName componentName = new ComponentName(KeyGlyphMapData.m4576$$Nest$fgetpackageName(data), KeyGlyphMapData.m4578$$Nest$fgetreceiverName(data));     // Catch: PackageManager.NameNotFoundException -> L5
        ActivityInfo receiver = pm.getReceiverInfo(componentName, 786560);     // Catch: PackageManager.NameNotFoundException -> L5
        Resources resources = pm.getResourcesForApplication(receiver.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L5
        return loadGlyphMapFromResource(resources, componentName, KeyGlyphMapData.m4579$$Nest$fgetresourceId(data));
    L5:
        e = move-exception;
        Log.w(TAG, "Package not found: " + e);
        return null;
    }

    private KeyGlyphMap loadGlyphMapFromResource(Resources resources, ComponentName componentName, int glyphMapId) {
        SparseIntArray keyGlyphs = new SparseIntArray();
        SparseIntArray modifierGlyphs = new SparseIntArray();
        List<Integer> functionRowKeys = new ArrayList();
        HashMap<KeyGlyphMap.KeyCombination, Integer> hardwareShortcuts = new HashMap();
        XmlResourceParser parser = resources.getXml(glyphMapId);     // Catch: Throwable -> L13
        XmlUtils.beginDocument(parser, TAG_KEYBOARD_GLYPH_MAP);     // Catch: Throwable -> L13
    L4:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L13
        String element = parser.getName();     // Catch: Throwable -> L13
        if (element == null) goto L78;
        switch(element.hashCode()) {
            case -1899730737: goto L22;
            case -1412777290: goto L19;
            case 1199863: goto L16;
            case 1206620222: goto L11;
            default: goto L24;
        };     // Catch: Throwable -> L13
    L24:
        byte r0 = -1;
    L25:
        switch(r0) {
            case 0: goto L63;
            case 1: goto L51;
            case 2: goto L40;
            case 3: goto L27;
            default: goto L4;
        };     // Catch: Throwable -> L13
    L27:
        TypedArray a = resources.obtainAttributes(parser, R.styleable.HardwareDefinedShortcut);     // Catch: Throwable -> L13
        int keycode = a.getInt(0, 0);     // Catch: Throwable -> L35
        int modifierState = a.getInt(1, 0);     // Catch: Throwable -> L35
        int outKeycode = a.getInt(2, 0);     // Catch: Throwable -> L35
        if (keycode == 0) goto L37;
        if (modifierState == 0) goto L37;
        if (outKeycode == 0) goto L37;
        hardwareShortcuts.put(new KeyGlyphMap.KeyCombination(modifierState, keycode), Integer.valueOf(outKeycode));     // Catch: Throwable -> L35
    L37:
        a.recycle();     // Catch: Throwable -> L13 Throwable -> L13
    L35:
        th = move-exception;
        a.recycle();     // Catch: Throwable -> L13 Throwable -> L13
        throw th;     // Catch: Throwable -> L13 Throwable -> L13
    L40:
        TypedArray a2 = resources.obtainAttributes(parser, R.styleable.FunctionRowKey);     // Catch: Throwable -> L13 Throwable -> L13
        int keycode2 = a2.getInt(0, 0);     // Catch: Throwable -> L46
        if (keycode2 == 0) goto L48;
        functionRowKeys.add(Integer.valueOf(keycode2));     // Catch: Throwable -> L46
    L48:
        a2.recycle();     // Catch: Throwable -> L13 Throwable -> L13
    L46:
        th = move-exception;
        a2.recycle();     // Catch: Throwable -> L13 Throwable -> L13
        throw th;     // Catch: Throwable -> L13 Throwable -> L13
    L51:
        TypedArray a3 = resources.obtainAttributes(parser, R.styleable.ModifierGlyph);     // Catch: Throwable -> L13 Throwable -> L13
        int modifier = a3.getInt(1, 0);     // Catch: Throwable -> L58
        int modifierGlyph = a3.getResourceId(0, 0);     // Catch: Throwable -> L58
        if (modifier == 0) goto L60;
        if (modifierGlyph == 0) goto L60;
        modifierGlyphs.put(modifier, modifierGlyph);     // Catch: Throwable -> L58
    L60:
        a3.recycle();     // Catch: Throwable -> L13 Throwable -> L13
    L58:
        th = move-exception;
        a3.recycle();     // Catch: Throwable -> L13 Throwable -> L13
        throw th;     // Catch: Throwable -> L13 Throwable -> L13
    L63:
        TypedArray a4 = resources.obtainAttributes(parser, R.styleable.KeyGlyph);     // Catch: Throwable -> L13 Throwable -> L13
        int keycode3 = a4.getInt(0, 0);     // Catch: Throwable -> L70
        int keyGlyph = a4.getResourceId(1, 0);     // Catch: Throwable -> L70
        if (keycode3 == 0) goto L72;
        if (keyGlyph == 0) goto L72;
        keyGlyphs.put(keycode3, keyGlyph);     // Catch: Throwable -> L70
    L72:
        a4.recycle();     // Catch: Throwable -> L13 Throwable -> L13
    L70:
        th = move-exception;
        a4.recycle();     // Catch: Throwable -> L13 Throwable -> L13
        throw th;     // Catch: Throwable -> L13 Throwable -> L13
    L11:
        if (element.equals(TAG_KEY_GLYPH) == false) goto L24;
        r0 = 0;
        goto L25
    L16:
        if (element.equals(TAG_FUNCTION_ROW_KEY) == false) goto L24;
        r0 = 2;
        goto L25
    L19:
        if (element.equals(TAG_MODIFIER_GLYPH) == false) goto L24;
        r0 = 1;
        goto L25
    L22:
        if (element.equals(TAG_HARDWARE_DEFINED_SHORTCUT) == false) goto L24;
        r0 = 3;
    L78:
        return new KeyGlyphMap(componentName, keyGlyphs, modifierGlyphs, functionRowKeys.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray(), hardwareShortcuts);
    L13:
        e = move-exception;
        Log.e(TAG, "Unable to parse key glyph map : " + e);
        goto L78
    }

    public KeyGlyphMap getKeyGlyphMap(int deviceId) {
        Object r0 = this.mGlyphMapLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mGlyphMapCache.indexOfKey(deviceId) < 0) goto L11;
        KeyGlyphMap r1 = this.mGlyphMapCache.get(deviceId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        KeyGlyphMap keyGlyphMap = getKeyGlyphMapInternal(deviceId);     // Catch: Throwable -> L9
        this.mGlyphMapCache.put(deviceId, keyGlyphMap);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return keyGlyphMap;
    }

    private KeyGlyphMap getKeyGlyphMapInternal(int deviceId) {
        InputDevice inputDevice = getInputDevice(deviceId);
        if (inputDevice != null) goto L5;
    L23:
        return null;
    L5:
        if (inputDevice.isVirtual() == true) goto L23;
        if (inputDevice.isFullKeyboard() == false) goto L23;
        if (this.mGlyphMapDataLoaded == true) goto L12;
        this.mGlyphMapDataList = loadGlyphMapDataList();
        this.mGlyphMapDataLoaded = true;
    L12:
        Iterator<KeyGlyphMapData> r2 = this.mGlyphMapDataList.iterator();
    L14:
        if (r2.hasNext() == false) goto L22;
        KeyGlyphMapData data = r2.next();
        if (KeyGlyphMapData.m4580$$Nest$fgetvendorId(data) != inputDevice.getVendorId()) goto L14;
        if (KeyGlyphMapData.m4577$$Nest$fgetproductId(data) != inputDevice.getProductId()) goto L14;
        return loadGlyphMap(data);
    L22:
        return null;
    }

    void dump(IndentingPrintWriter ipw) {
        List<KeyGlyphMapData> glyphMapDataList = loadGlyphMapDataList();
        ipw.println("KeyboardGlyphManager: " + glyphMapDataList.size() + " glyph maps");
        ipw.increaseIndent();
        Iterator<KeyGlyphMapData> r1 = glyphMapDataList.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        KeyGlyphMapData data = r1.next();
        ipw.println(data);
        if (DEBUG == false) goto L4;
        KeyGlyphMap map = loadGlyphMap(data);
        if (map == null) goto L4;
        ipw.increaseIndent();
        ipw.println(map);
        ipw.decreaseIndent();
        goto L4
    L11:
        ipw.decreaseIndent();
    }

    private InputDevice getInputDevice(int deviceId) {
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        if (inputManager != null) goto L7;
        return null;
    L7:
        return inputManager.getInputDevice(deviceId);
    }
}
