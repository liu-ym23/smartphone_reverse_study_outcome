package com.android.server.input;

import android.hardware.input.TouchCalibration;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseIntArray;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Set;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class PersistentDataStore {
    private static final int INVALID_VALUE = -1;
    static final String TAG = "InputManager";
    private boolean mDirty;
    private final Injector mInjector;
    private final HashMap<String, InputDeviceState> mInputDevices;
    private final Map<Integer, Integer> mKeyRemapping;
    private boolean mLoaded;

    static class Injector {
        private final AtomicFile mAtomicFile;

        Injector() {
            this.mAtomicFile = new AtomicFile(new File("/data/system/input-manager-state.xml"), "input-state");
        }

        InputStream openRead() throws FileNotFoundException {
            return this.mAtomicFile.openRead();
        }

        FileOutputStream startWrite() throws IOException {
            return this.mAtomicFile.startWrite();
        }

        void finishWrite(FileOutputStream fos, boolean success) {
            if (success == false) goto L4;
            this.mAtomicFile.finishWrite(fos);
            return;
        L4:
            this.mAtomicFile.failWrite(fos);
        }
    }

    private static final class InputDeviceState {
        private static final String[] CALIBRATION_NAME = null;
        private final SparseIntArray mKeyboardBacklightBrightnessMap;
        private final Map<String, String> mKeyboardLayoutMap;
        private Set<String> mSelectedKeyboardLayouts;
        private final TouchCalibration[] mTouchCalibration;

        /* synthetic */ InputDeviceState(PersistentDataStoreIA r1) {
            this();
        }

        private InputDeviceState() {
            this.mTouchCalibration = new TouchCalibration[4];
            this.mKeyboardBacklightBrightnessMap = new SparseIntArray();
            this.mKeyboardLayoutMap = new ArrayMap();
        }

        static {
            CALIBRATION_NAME = new String[]{"x_scale", "x_ymix", "x_offset", "y_xmix", "y_scale", "y_offset"};
        }

        public TouchCalibration getTouchCalibration(int surfaceRotation) {
            return this.mTouchCalibration[surfaceRotation];
        L4:
            ex = move-exception;
            Slog.w(PersistentDataStore.TAG, "Cannot get touch calibration.", ex);
            return null;
        }

        public boolean setTouchCalibration(int surfaceRotation, TouchCalibration calibration) {
        L8:
            ex = move-exception;
            Slog.w(PersistentDataStore.TAG, "Cannot set touch calibration.", ex);
            return false;
        L4:
            if (calibration.equals(this.mTouchCalibration[surfaceRotation]) == true) goto L10;
            this.mTouchCalibration[surfaceRotation] = calibration;     // Catch: ArrayIndexOutOfBoundsException -> L8
            return true;
        L10:
            return false;
        }

        public String getKeyboardLayout(String key) {
            return this.mKeyboardLayoutMap.get(key);
        }

        public boolean setKeyboardLayout(String key, String keyboardLayout) {
            return !Objects.equals(this.mKeyboardLayoutMap.put(key, keyboardLayout), keyboardLayout);
        }

        public boolean setSelectedKeyboardLayouts(Set<String> selectedLayouts) {
            if (Objects.equals(this.mSelectedKeyboardLayouts, selectedLayouts) == false) goto L6;
            return false;
        L6:
            this.mSelectedKeyboardLayouts = new HashSet(selectedLayouts);
            return true;
        }

        public boolean setKeyboardBacklightBrightness(int lightId, int brightness) {
            if (this.mKeyboardBacklightBrightnessMap.get(lightId, -1) != brightness) goto L6;
            return false;
        L6:
            this.mKeyboardBacklightBrightnessMap.put(lightId, brightness);
            return true;
        }

        public OptionalInt getKeyboardBacklightBrightness(int lightId) {
            int brightness = this.mKeyboardBacklightBrightnessMap.get(lightId, -1);
            if (brightness != (-1)) goto L6;
            return OptionalInt.empty();
        L6:
            return OptionalInt.of(brightness);
        }

        public boolean removeUninstalledKeyboardLayouts(Set<String> availableKeyboardLayouts) {
            List<String> removedEntries = new ArrayList();
            Iterator<String> r2 = this.mKeyboardLayoutMap.keySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            String key = r2.next();
            if (availableKeyboardLayouts.contains(this.mKeyboardLayoutMap.get(key)) == true) goto L4;
            removedEntries.add(key);
            goto L4
        L10:
            if (removedEntries.isEmpty() == true) goto L23;
            Iterator<String> r3 = removedEntries.iterator();
        L13:
            if (r3.hasNext() == false) goto L15;
            String key2 = r3.next();
            this.mKeyboardLayoutMap.remove(key2);
            goto L13
        L15:
            return true;
        L23:
            return false;
        }

        public void loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            int outerDepth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L67;
            if (parser.getName().equals("keyed-keyboard-layout") == true) goto L7;
            if (parser.getName().equals("selected-keyboard-layout") == true) goto L18;
            if (parser.getName().equals("light-info") == true) goto L28;
            if (parser.getName().equals("calibration") == false) goto L4;
            String format = parser.getAttributeValue(null, "format");
            String rotation = parser.getAttributeValue(null, "rotation");
            int r = -1;
            if (format == null) goto L66;
            if (format.equals("affine") == false) goto L64;
            if (rotation != null) goto L68;
        L42:
            float[] matrix = TouchCalibration.IDENTITY.getAffineTransform();
            int depth = parser.getDepth();
        L44:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L56;
            String tag = parser.getName().toLowerCase();
            String value = parser.nextText();
            int i = 0;
        L47:
            if (i >= matrix.length) goto L44;
            if (i >= CALIBRATION_NAME.length) goto L44;
            if (tag.equals(CALIBRATION_NAME[i]) == true) goto L52;
            i = i + 1;
            goto L47
        L52:
            matrix[i] = Float.parseFloat(value);
            goto L44
        L56:
            if (r == (-1)) goto L57;
            this.mTouchCalibration[r] = new TouchCalibration(matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[5]);
            goto L4
        L57:
            int r2 = 0;
        L59:
            if (r2 >= this.mTouchCalibration.length) goto L4;
            this.mTouchCalibration[r2] = new TouchCalibration(matrix[0], matrix[1], matrix[2], matrix[3], matrix[4], matrix[5]);
            r2 = r2 + 1;
            goto L59
        L68:
            r = stringToSurfaceRotation(rotation);     // Catch: IllegalArgumentException -> L39
        L41:
            throw new XmlPullParserException("Unsupported rotation for calibration.");
        L64:
            throw new XmlPullParserException("Unsupported format for calibration.");
        L66:
            throw new XmlPullParserException("Missing format attribute on calibration.");
        L28:
            int lightId = parser.getAttributeInt(null, "light-id");
            int lightBrightness = parser.getAttributeInt(null, "light-brightness");
            this.mKeyboardBacklightBrightnessMap.put(lightId, lightBrightness);
            goto L4
        L18:
            String layout = parser.getAttributeValue(null, "layout");
            if (layout == null) goto L25;
            if (this.mSelectedKeyboardLayouts != null) goto L23;
            this.mSelectedKeyboardLayouts = new HashSet();
        L23:
            this.mSelectedKeyboardLayouts.add(layout);
            goto L4
        L25:
            throw new XmlPullParserException("Missing layout attribute on selected-keyboard-layout.");
        L7:
            String key = parser.getAttributeValue(null, "key");
            if (key == null) goto L15;
            String layout2 = parser.getAttributeValue(null, "layout");
            if (layout2 == null) goto L13;
            this.mKeyboardLayoutMap.put(key, layout2);
            goto L4
        L13:
            throw new XmlPullParserException("Missing layout attribute on keyed-keyboard-layout.");
        L15:
            throw new XmlPullParserException("Missing key attribute on keyed-keyboard-layout.");
        }

        public void saveToXml(TypedXmlSerializer serializer) throws IOException {
            Iterator<String> r0 = this.mKeyboardLayoutMap.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            String key = r0.next();
            serializer.startTag(null, "keyed-keyboard-layout");
            serializer.attribute(null, "key", key);
            serializer.attribute(null, "layout", this.mKeyboardLayoutMap.get(key));
            serializer.endTag(null, "keyed-keyboard-layout");
            goto L4
        L7:
            if (this.mSelectedKeyboardLayouts == null) goto L12;
            Iterator<String> r1 = this.mSelectedKeyboardLayouts.iterator();
        L10:
            if (r1.hasNext() == false) goto L12;
            String layout = r1.next();
            serializer.startTag(null, "selected-keyboard-layout");
            serializer.attribute(null, "layout", layout);
            serializer.endTag(null, "selected-keyboard-layout");
        L12:
            int i = 0;
        L14:
            if (i >= this.mKeyboardBacklightBrightnessMap.size()) goto L16;
            serializer.startTag(null, "light-info");
            serializer.attributeInt(null, "light-id", this.mKeyboardBacklightBrightnessMap.keyAt(i));
            serializer.attributeInt(null, "light-brightness", this.mKeyboardBacklightBrightnessMap.valueAt(i));
            serializer.endTag(null, "light-info");
            i = i + 1;
            goto L14
        L16:
            int i2 = 0;
        L18:
            if (i2 >= this.mTouchCalibration.length) goto L30;
            if (this.mTouchCalibration[i2] == null) goto L28;
            String rotation = surfaceRotationToString(i2);
            float[] transform = this.mTouchCalibration[i2].getAffineTransform();
            serializer.startTag(null, "calibration");
            serializer.attribute(null, "format", "affine");
            serializer.attribute(null, "rotation", rotation);
            int j = 0;
        L23:
            if (j >= transform.length) goto L27;
            if (j >= CALIBRATION_NAME.length) goto L27;
            serializer.startTag(null, CALIBRATION_NAME[j]);
            serializer.text(Float.toString(transform[j]));
            serializer.endTag(null, CALIBRATION_NAME[j]);
            j = j + 1;
        L27:
            serializer.endTag(null, "calibration");
        L28:
            i2 = i2 + 1;
            goto L18
        }

        private static String surfaceRotationToString(int surfaceRotation) {
            switch(surfaceRotation) {
                case 0: goto L11;
                case 1: goto L9;
                case 2: goto L7;
                case 3: goto L5;
                default: goto L4;
            };
        L5:
            return "270";
        L7:
            return "180";
        L9:
            return "90";
        L11:
            return "0";
        L4:
            throw new IllegalArgumentException("Unsupported surface rotation value" + surfaceRotation);
        }

        private static int stringToSurfaceRotation(String s) {
            if ("0".equals(s) == false) goto L7;
            return 0;
        L7:
            if ("90".equals(s) == false) goto L11;
            return 1;
        L11:
            if ("180".equals(s) == false) goto L15;
            return 2;
        L15:
            if ("270".equals(s) == false) goto L19;
            return 3;
        L19:
            throw new IllegalArgumentException("Unsupported surface rotation string '" + s + "'");
        }
    }

    public PersistentDataStore() {
        this(new Injector());
    }

    PersistentDataStore(Injector injector) {
        this.mInputDevices = new HashMap();
        this.mKeyRemapping = new HashMap();
        this.mInjector = injector;
    }

    public void saveIfNeeded() {
        if (this.mDirty == false) goto L6;
        save();
        this.mDirty = false;
        return;
    }

    public boolean hasInputDeviceEntry(String inputDeviceDescriptor) {
        if (getInputDeviceState(inputDeviceDescriptor) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public TouchCalibration getTouchCalibration(String inputDeviceDescriptor, int surfaceRotation) {
        InputDeviceState state = getInputDeviceState(inputDeviceDescriptor);
        if (state == null) goto L5;
        TouchCalibration cal = state.getTouchCalibration(surfaceRotation);
        if (cal == null) goto L9;
        return cal;
    L9:
        return TouchCalibration.IDENTITY;
    L5:
        return TouchCalibration.IDENTITY;
    }

    public boolean setTouchCalibration(String inputDeviceDescriptor, int surfaceRotation, TouchCalibration calibration) {
        InputDeviceState state = getOrCreateInputDeviceState(inputDeviceDescriptor);
        if (state.setTouchCalibration(surfaceRotation, calibration) == false) goto L6;
        setDirty();
        return true;
    L6:
        return false;
    }

    public String getKeyboardLayout(String inputDeviceDescriptor, String key) {
        InputDeviceState state = getInputDeviceState(inputDeviceDescriptor);
        if (state != null) goto L7;
        return null;
    L7:
        return state.getKeyboardLayout(key);
    }

    public boolean setKeyboardLayout(String inputDeviceDescriptor, String key, String keyboardLayoutDescriptor) {
        InputDeviceState state = getOrCreateInputDeviceState(inputDeviceDescriptor);
        if (state.setKeyboardLayout(key, keyboardLayoutDescriptor) == false) goto L6;
        setDirty();
        return true;
    L6:
        return false;
    }

    public boolean setSelectedKeyboardLayouts(String inputDeviceDescriptor, Set<String> selectedLayouts) {
        InputDeviceState state = getOrCreateInputDeviceState(inputDeviceDescriptor);
        if (state.setSelectedKeyboardLayouts(selectedLayouts) == false) goto L6;
        setDirty();
        return true;
    L6:
        return false;
    }

    public boolean setKeyboardBacklightBrightness(String inputDeviceDescriptor, int lightId, int brightness) {
        InputDeviceState state = getOrCreateInputDeviceState(inputDeviceDescriptor);
        if (state.setKeyboardBacklightBrightness(lightId, brightness) == false) goto L6;
        setDirty();
        return true;
    L6:
        return false;
    }

    public OptionalInt getKeyboardBacklightBrightness(String inputDeviceDescriptor, int lightId) {
        InputDeviceState state = getInputDeviceState(inputDeviceDescriptor);
        if (state != null) goto L7;
        return OptionalInt.empty();
    L7:
        return state.getKeyboardBacklightBrightness(lightId);
    }

    public boolean remapKey(int fromKey, int toKey) {
        loadIfNeeded();
        if (this.mKeyRemapping.getOrDefault(Integer.valueOf(fromKey), -1).intValue() != toKey) goto L6;
        return false;
    L6:
        this.mKeyRemapping.put(Integer.valueOf(fromKey), Integer.valueOf(toKey));
        setDirty();
        return true;
    }

    public boolean clearMappedKey(int key) {
        loadIfNeeded();
        if (this.mKeyRemapping.containsKey(Integer.valueOf(key)) == false) goto L7;
        this.mKeyRemapping.remove(Integer.valueOf(key));
        setDirty();
        return true;
    L7:
        return true;
    }

    public Map<Integer, Integer> getKeyRemapping() {
        loadIfNeeded();
        return new HashMap(this.mKeyRemapping);
    }

    public boolean removeUninstalledKeyboardLayouts(Set<String> availableKeyboardLayouts) {
        boolean changed = false;
        Iterator<InputDeviceState> r1 = this.mInputDevices.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        InputDeviceState state = r1.next();
        if (state.removeUninstalledKeyboardLayouts(availableKeyboardLayouts) == false) goto L4;
        changed = true;
        goto L4
    L9:
        if (changed == false) goto L12;
        setDirty();
        return true;
    L12:
        return false;
    }

    private InputDeviceState getInputDeviceState(String inputDeviceDescriptor) {
        loadIfNeeded();
        return this.mInputDevices.get(inputDeviceDescriptor);
    }

    private InputDeviceState getOrCreateInputDeviceState(String inputDeviceDescriptor) {
        loadIfNeeded();
        InputDeviceState state = this.mInputDevices.get(inputDeviceDescriptor);
        if (state != null) goto L6;
        InputDeviceState state2 = new InputDeviceState(null);
        this.mInputDevices.put(inputDeviceDescriptor, state2);
        setDirty();
        return state2;
    L6:
        return state;
    }

    private void loadIfNeeded() {
        if (this.mLoaded == true) goto L6;
        load();
        this.mLoaded = true;
        return;
    }

    private void setDirty() {
        this.mDirty = true;
    }

    private void clearState() {
        this.mKeyRemapping.clear();
        this.mInputDevices.clear();
    }

    private void load() {
        clearState();
        InputStream is = this.mInjector.openRead();     // Catch: FileNotFoundException -> L21
        TypedXmlPullParser parser = Xml.resolvePullParser(is);     // Catch: Throwable -> L6 XmlPullParserException -> L8 IOException -> L10
        loadFromXml(parser);     // Catch: Throwable -> L6 XmlPullParserException -> L8 IOException -> L10
        IoUtils.closeQuietly(is);
    L23:
        return;
    L6:
        th = move-exception;
        IoUtils.closeQuietly(is);
        throw th;
    L10:
        ex = move-exception;
        Slog.w(TAG, "Failed to load input manager persistent store data.", ex);     // Catch: Throwable -> L6
        clearState();     // Catch: Throwable -> L6
        IoUtils.closeQuietly(is);
    L8:
        ex = move-exception;
        Slog.w(TAG, "Failed to load input manager persistent store data.", ex);     // Catch: Throwable -> L6
        clearState();     // Catch: Throwable -> L6
        IoUtils.closeQuietly(is);
    }

    private void save() {
        FileOutputStream os = this.mInjector.startWrite();     // Catch: IOException -> L7
        TypedXmlSerializer serializer = Xml.resolveSerializer(os);     // Catch: Throwable -> L9
        saveToXml(serializer);     // Catch: Throwable -> L9
        serializer.flush();     // Catch: Throwable -> L9
    L6:
        this.mInjector.finishWrite(os, true);     // Catch: IOException -> L7
        return;
    L9:
        th = move-exception;
        this.mInjector.finishWrite(os, false);     // Catch: IOException -> L7
        throw th;     // Catch: IOException -> L7
    L7:
        ex = move-exception;
        Slog.w(TAG, "Failed to save input manager persistent store data.", ex);
    }

    private void loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        XmlUtils.beginDocument(parser, "input-manager-state");
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L11;
        if (parser.getName().equals("key-remapping") == true) goto L7;
        if (parser.getName().equals("input-devices") == false) goto L4;
        loadInputDevicesFromXml(parser);
        goto L4
    L7:
        loadKeyRemappingFromXml(parser);
        goto L4
    }

    private void loadInputDevicesFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L16;
        if (parser.getName().equals("input-device") == false) goto L4;
        PersistentDataStoreIA r2 = null;
        String descriptor = parser.getAttributeValue(null, "descriptor");
        if (descriptor == null) goto L15;
        if (this.mInputDevices.containsKey(descriptor) == true) goto L13;
        InputDeviceState state = new InputDeviceState(r2);
        state.loadFromXml(parser);
        this.mInputDevices.put(descriptor, state);
        goto L4
    L13:
        throw new XmlPullParserException("Found duplicate input device.");
    L15:
        throw new XmlPullParserException("Missing descriptor attribute on input-device.");
    }

    private void loadKeyRemappingFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L8;
        if (parser.getName().equals("remap") == false) goto L4;
        int fromKey = parser.getAttributeInt(null, "from-key");
        int toKey = parser.getAttributeInt(null, "to-key");
        this.mKeyRemapping.put(Integer.valueOf(fromKey), Integer.valueOf(toKey));
        goto L4
    }

    private void saveToXml(TypedXmlSerializer serializer) throws IOException {
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        serializer.startTag(null, "input-manager-state");
        serializer.startTag(null, "key-remapping");
        Iterator<Integer> r3 = this.mKeyRemapping.keySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        int fromKey = r3.next().intValue();
        int toKey = this.mKeyRemapping.get(Integer.valueOf(fromKey)).intValue();
        serializer.startTag(null, "remap");
        serializer.attributeInt(null, "from-key", fromKey);
        serializer.attributeInt(null, "to-key", toKey);
        serializer.endTag(null, "remap");
        goto L4
    L6:
        serializer.endTag(null, "key-remapping");
        serializer.startTag(null, "input-devices");
        Iterator<Map.Entry<String, InputDeviceState>> r4 = this.mInputDevices.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        Map.Entry<String, InputDeviceState> entry = r4.next();
        String descriptor = entry.getKey();
        InputDeviceState state = entry.getValue();
        serializer.startTag(null, "input-device");
        serializer.attribute(null, "descriptor", descriptor);
        state.saveToXml(serializer);
        serializer.endTag(null, "input-device");
        goto L8
    L10:
        serializer.endTag(null, "input-devices");
        serializer.endTag(null, "input-manager-state");
        serializer.endDocument();
    }
}
