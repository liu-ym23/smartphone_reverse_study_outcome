package com.android.server.input;

import android.hardware.input.AppLaunchData;
import android.hardware.input.InputGestureData;
import android.os.Environment;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class InputDataStore {
    private static final String ATTR_APP_LAUNCH_DATA_CATEGORY = "category";
    private static final String ATTR_APP_LAUNCH_DATA_CLASS_NAME = "class_name";
    private static final String ATTR_APP_LAUNCH_DATA_PACKAGE_NAME = "package_name";
    private static final String ATTR_APP_LAUNCH_DATA_ROLE = "role";
    private static final String ATTR_KEY_GESTURE_TYPE = "key_gesture_type";
    private static final String ATTR_KEY_TRIGGER_KEYCODE = "keycode";
    private static final String ATTR_KEY_TRIGGER_MODIFIER_STATE = "modifiers";
    private static final String ATTR_TOUCHPAD_TRIGGER_GESTURE_TYPE = "touchpad_gesture_type";
    private static final String INPUT_MANAGER_DIRECTORY = "input";
    private static final String TAG = "InputDataStore";
    private static final String TAG_APP_LAUNCH_DATA = "app_launch_data";
    private static final String TAG_INPUT_GESTURE = "input_gesture";
    private static final String TAG_INPUT_GESTURE_LIST = "input_gesture_list";
    private static final String TAG_KEY_TRIGGER = "key_trigger";
    private static final String TAG_ROOT = "root";
    private static final String TAG_TOUCHPAD_TRIGGER = "touchpad_trigger";
    private final FileInjector mInputGestureFileInjector;

    static class FileInjector {
        private final SparseArray<AtomicFile> mAtomicFileMap;
        private final String mFileName;

        FileInjector(String fileName) {
            this.mAtomicFileMap = new SparseArray();
            this.mFileName = fileName;
        }

        InputStream openRead(int userId) throws FileNotFoundException {
            return getAtomicFileForUserId(userId).openRead();
        }

        FileOutputStream startWrite(int userId) throws IOException {
            return getAtomicFileForUserId(userId).startWrite();
        }

        void finishWrite(int userId, FileOutputStream os, boolean success) {
            if (success == false) goto L4;
            getAtomicFileForUserId(userId).finishWrite(os);
            return;
        L4:
            getAtomicFileForUserId(userId).failWrite(os);
        }

        AtomicFile getAtomicFileForUserId(int userId) {
            if (this.mAtomicFileMap.contains(userId) == true) goto L6;
            this.mAtomicFileMap.put(userId, new AtomicFile(new File(Environment.buildPath(Environment.getDataSystemDeDirectory(userId), new String[]{InputDataStore.INPUT_MANAGER_DIRECTORY}), this.mFileName)));
        L6:
            return this.mAtomicFileMap.get(userId);
        }
    }

    public InputDataStore() {
        this(new FileInjector("input_gestures.xml"));
    }

    public InputDataStore(FileInjector inputGestureFileInjector) {
        this.mInputGestureFileInjector = inputGestureFileInjector;
    }

    public List<InputGestureData> loadInputGestures(int userId) {
        InputStream inputStream = this.mInputGestureFileInjector.openRead(userId);     // Catch: Exception -> L5 IOException -> L7 FileNotFoundException -> L9
        List<InputGestureData> inputGestureDataList = readInputGesturesXml(inputStream, false);     // Catch: Exception -> L5 IOException -> L7 FileNotFoundException -> L9
        inputStream.close();     // Catch: Exception -> L5 IOException -> L7 FileNotFoundException -> L9
        return inputGestureDataList;
    L7:
        exception = move-exception;
        Slog.e(TAG, "Failed to read from " + this.mInputGestureFileInjector.getAtomicFileForUserId(userId), exception);
        return List.of();
    L5:
        exception = move-exception;
        throw new RuntimeException("Failed to read from " + this.mInputGestureFileInjector.getAtomicFileForUserId(userId), exception);
    L16:
        return List.of();
    }

    public void saveInputGestures(int userId, List<InputGestureData> inputGestureDataList) {
        FileOutputStream outputStream = null;
        outputStream = this.mInputGestureFileInjector.startWrite(userId);     // Catch: IOException -> L5
        writeInputGestureXml(outputStream, false, inputGestureDataList);     // Catch: IOException -> L5
        this.mInputGestureFileInjector.finishWrite(userId, outputStream, true);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to write to file " + this.mInputGestureFileInjector.getAtomicFileForUserId(userId), e);
        this.mInputGestureFileInjector.finishWrite(userId, outputStream, false);
    }

    public List<InputGestureData> readInputGesturesXml(InputStream stream, boolean utf8Encoded) throws XmlPullParserException, IOException {
        List<InputGestureData> inputGestureDataList = new ArrayList();
        if (utf8Encoded == false) goto L5;
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setInput(stream, StandardCharsets.UTF_8.name());
    L6:
        int type = parser.next();
        if (type == 1) goto L18;
        if (type != 2) goto L6;
        String tag = parser.getName();
        if (TAG_ROOT.equals(tag) == true) goto L6;
        if (TAG_INPUT_GESTURE_LIST.equals(tag) == false) goto L6;
        inputGestureDataList.addAll(readInputGestureListFromXml(parser));
        goto L6
    L18:
        return inputGestureDataList;
    L5:
        parser = Xml.resolvePullParser(stream);
        goto L6
    }

    public void writeInputGestureXml(OutputStream stream, boolean utf8Encoded, List<InputGestureData> inputGestureDataList) throws IOException {
        if (utf8Encoded == false) goto L4;
        TypedXmlSerializer serializer = Xml.newFastSerializer();
        serializer.setOutput(stream, StandardCharsets.UTF_8.name());
    L5:
        serializer.startDocument(null, true);
        serializer.startTag(null, TAG_ROOT);
        writeInputGestureListToXml(serializer, inputGestureDataList);
        serializer.endTag(null, TAG_ROOT);
        serializer.endDocument();
        return;
    L4:
        serializer = Xml.resolveSerializer(stream);
        goto L5
    }

    private InputGestureData readInputGestureFromXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException, IllegalArgumentException {
        InputGestureData.Builder builder = new InputGestureData.Builder();
        builder.setKeyGestureType(parser.getAttributeInt(null, ATTR_KEY_GESTURE_TYPE));
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L30;
        if (outerDepth > parser.getDepth()) goto L28;
        if (type != 3) goto L13;
        if (parser.getName().equals(TAG_INPUT_GESTURE) == true) goto L30;
    L13:
        if (type != 2) goto L3;
        String tag = parser.getName();
        if (TAG_KEY_TRIGGER.equals(tag) == true) goto L17;
        if (TAG_TOUCHPAD_TRIGGER.equals(tag) == true) goto L20;
        if (TAG_APP_LAUNCH_DATA.equals(tag) == false) goto L3;
        String roleValue = parser.getAttributeValue(null, ATTR_APP_LAUNCH_DATA_ROLE);
        String categoryValue = parser.getAttributeValue(null, ATTR_APP_LAUNCH_DATA_CATEGORY);
        String classNameValue = parser.getAttributeValue(null, ATTR_APP_LAUNCH_DATA_CLASS_NAME);
        String packageNameValue = parser.getAttributeValue(null, ATTR_APP_LAUNCH_DATA_PACKAGE_NAME);
        AppLaunchData appLaunchData = AppLaunchData.createLaunchData(categoryValue, roleValue, packageNameValue, classNameValue);
        if (appLaunchData == null) goto L3;
        builder.setAppLaunchData(appLaunchData);
        goto L3
    L20:
        builder.setTrigger(InputGestureData.createTouchpadTrigger(parser.getAttributeInt(null, ATTR_TOUCHPAD_TRIGGER_GESTURE_TYPE)));
        goto L3
    L17:
        builder.setTrigger(InputGestureData.createKeyTrigger(parser.getAttributeInt(null, ATTR_KEY_TRIGGER_KEYCODE), parser.getAttributeInt(null, ATTR_KEY_TRIGGER_MODIFIER_STATE)));
        goto L3
    L28:
        throw new RuntimeException("Parser has left the initial scope of the tag that was being parsed on line number: " + parser.getLineNumber());
    L30:
        return builder.build();
    }

    private List<InputGestureData> readInputGestureListFromXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        List<InputGestureData> inputGestureDataList = new ArrayList();
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L24;
        if (outerDepth > parser.getDepth()) goto L23;
        if (type != 3) goto L13;
        if (parser.getName().equals(TAG_INPUT_GESTURE_LIST) == true) goto L24;
    L13:
        if (type != 2) goto L3;
        String tag = parser.getName();
        if (TAG_INPUT_GESTURE.equals(tag) == false) goto L3;
        inputGestureDataList.add(readInputGestureFromXml(parser));     // Catch: IllegalArgumentException -> L19
    L19:
        exception = move-exception;
        Slog.w(TAG, "Invalid parameters for input gesture data: ", exception);
        goto L3
    L23:
        throw new RuntimeException("Parser has left the initial scope of the tag that was being parsed on line number: " + parser.getLineNumber());
    L24:
        return inputGestureDataList;
    }

    private void writeInputGestureToXml(TypedXmlSerializer serializer, InputGestureData inputGestureData) throws IOException {
        serializer.startTag(null, TAG_INPUT_GESTURE);
        serializer.attributeInt(null, ATTR_KEY_GESTURE_TYPE, inputGestureData.getAction().keyGestureType());
        InputGestureData.KeyTrigger r2 = inputGestureData.getTrigger();
        if ((r2 instanceof InputGestureData.KeyTrigger) == false) goto L6;
        InputGestureData.KeyTrigger keyTrigger = r2;
        serializer.startTag(null, TAG_KEY_TRIGGER);
        serializer.attributeInt(null, ATTR_KEY_TRIGGER_KEYCODE, keyTrigger.getKeycode());
        serializer.attributeInt(null, ATTR_KEY_TRIGGER_MODIFIER_STATE, keyTrigger.getModifierState());
        serializer.endTag(null, TAG_KEY_TRIGGER);
    L9:
        if (inputGestureData.getAction().appLaunchData() == null) goto L20;
        serializer.startTag(null, TAG_APP_LAUNCH_DATA);
        AppLaunchData.RoleData r4 = inputGestureData.getAction().appLaunchData();
        if ((r4 instanceof AppLaunchData.RoleData) == false) goto L14;
        AppLaunchData.RoleData roleData = r4;
        serializer.attribute(null, ATTR_APP_LAUNCH_DATA_ROLE, roleData.getRole());
    L19:
        serializer.endTag(null, TAG_APP_LAUNCH_DATA);
        goto L20
    L14:
        if ((r4 instanceof AppLaunchData.CategoryData) == false) goto L17;
        AppLaunchData.CategoryData categoryData = (AppLaunchData.CategoryData) r4;
        serializer.attribute(null, ATTR_APP_LAUNCH_DATA_CATEGORY, categoryData.getCategory());
        goto L19
    L17:
        if ((r4 instanceof AppLaunchData.ComponentData) == false) goto L19;
        AppLaunchData.ComponentData componentData = (AppLaunchData.ComponentData) r4;
        serializer.attribute(null, ATTR_APP_LAUNCH_DATA_PACKAGE_NAME, componentData.getPackageName());
        serializer.attribute(null, ATTR_APP_LAUNCH_DATA_CLASS_NAME, componentData.getClassName());
    L20:
        serializer.endTag(null, TAG_INPUT_GESTURE);
        return;
    L6:
        if ((r2 instanceof InputGestureData.TouchpadTrigger) == false) goto L9;
        InputGestureData.TouchpadTrigger touchpadTrigger = (InputGestureData.TouchpadTrigger) r2;
        serializer.startTag(null, TAG_TOUCHPAD_TRIGGER);
        serializer.attributeInt(null, ATTR_TOUCHPAD_TRIGGER_GESTURE_TYPE, touchpadTrigger.getTouchpadGestureType());
        serializer.endTag(null, TAG_TOUCHPAD_TRIGGER);
        goto L9
    }

    private void writeInputGestureListToXml(TypedXmlSerializer serializer, List<InputGestureData> inputGestureDataList) throws IOException {
        serializer.startTag(null, TAG_INPUT_GESTURE_LIST);
        Iterator<InputGestureData> r2 = inputGestureDataList.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        InputGestureData inputGestureData = r2.next();
        writeInputGestureToXml(serializer, inputGestureData);
        goto L4
    L6:
        serializer.endTag(null, TAG_INPUT_GESTURE_LIST);
    }
}
