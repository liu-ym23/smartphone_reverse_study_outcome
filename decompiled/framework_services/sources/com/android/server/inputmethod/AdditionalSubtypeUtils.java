package com.android.server.inputmethod;

import android.icu.util.ULocale;
import android.os.Environment;
import android.os.FileUtils;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import android.view.inputmethod.InputMethodSubtype;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class AdditionalSubtypeUtils {
    private static final String ADDITIONAL_SUBTYPES_FILE_NAME = "subtypes.xml";
    private static final String ATTR_ICON = "icon";
    private static final String ATTR_ID = "id";
    private static final String ATTR_IME_SUBTYPE_EXTRA_VALUE = "imeSubtypeExtraValue";
    private static final String ATTR_IME_SUBTYPE_ID = "subtypeId";
    private static final String ATTR_IME_SUBTYPE_LANGUAGE_TAG = "languageTag";
    private static final String ATTR_IME_SUBTYPE_LOCALE = "imeSubtypeLocale";
    private static final String ATTR_IME_SUBTYPE_MODE = "imeSubtypeMode";
    private static final String ATTR_IS_ASCII_CAPABLE = "isAsciiCapable";
    private static final String ATTR_IS_AUXILIARY = "isAuxiliary";
    private static final String ATTR_LABEL = "label";
    private static final String ATTR_LAYOUT_LABEL = "layoutLabel";
    private static final String ATTR_LAYOUT_LABEL_NON_LOCALIZED = "layoutLabelNonLocalized";
    private static final String ATTR_NAME_OVERRIDE = "nameOverride";
    private static final String ATTR_NAME_PK_LANGUAGE_TAG = "pkLanguageTag";
    private static final String ATTR_NAME_PK_LAYOUT_TYPE = "pkLayoutType";
    private static final String INPUT_METHOD_PATH = "inputmethod";
    private static final String NODE_IMI = "imi";
    private static final String NODE_SUBTYPE = "subtype";
    private static final String NODE_SUBTYPES = "subtypes";
    private static final String SYSTEM_PATH = "system";
    private static final String TAG = "AdditionalSubtypeUtils";

    private AdditionalSubtypeUtils() {
    }

    private static File getInputMethodDir(int userId) {
        if (userId != 0) goto L4;
        File systemDir = new File(Environment.getDataDirectory(), "system");
    L6:
        return new File(systemDir, INPUT_METHOD_PATH);
    L4:
        systemDir = Environment.getUserSystemDirectory(userId);
        goto L6
    }

    private static AtomicFile getAdditionalSubtypeFile(File inputMethodDir) {
        File subtypeFile = new File(inputMethodDir, ADDITIONAL_SUBTYPES_FILE_NAME);
        return new AtomicFile(subtypeFile, "input-subtypes");
    }

    static void save(AdditionalSubtypeMap allSubtypes, InputMethodMap methodMap, int userId) {
        File inputMethodDir = getInputMethodDir(userId);
        if (allSubtypes.isEmpty() == false) goto L17;
        if (inputMethodDir.exists() == true) goto L7;
        return;
    L7:
        AtomicFile subtypesFile = getAdditionalSubtypeFile(inputMethodDir);
        if (subtypesFile.exists() == false) goto L11;
        subtypesFile.delete();
    L11:
        if (FileUtils.listFilesOrEmpty(inputMethodDir).length == 0) goto L13;
        return;
    L13:
        if (inputMethodDir.delete() == true) goto L25;
        Slog.e(TAG, "Failed to delete the empty parent directory " + inputMethodDir);
        return;
    L25:
        return;
    L17:
        if (inputMethodDir.exists() == false) goto L19;
    L22:
        saveToFile(allSubtypes, methodMap, getAdditionalSubtypeFile(inputMethodDir));
        return;
    L19:
        if (inputMethodDir.mkdirs() == true) goto L22;
        Slog.e(TAG, "Failed to create a parent directory " + inputMethodDir);
    }

    static void saveToFile(AdditionalSubtypeMap allSubtypes, InputMethodMap methodMap, AtomicFile subtypesFile) {
        InputMethodMap r1 = methodMap;
        if (r1 != null) goto L5;
    L7:
        boolean isSetMethodMap = false;
    L8:
        FileOutputStream fos = null;
        fos = subtypesFile.startWrite();     // Catch: Throwable -> L18 IOException -> L20
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: Throwable -> L18 IOException -> L20
        String r12 = null;
        out.startDocument(null, true);     // Catch: Throwable -> L18 IOException -> L20
        out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L18 IOException -> L20
        out.startTag(null, NODE_SUBTYPES);     // Catch: Throwable -> L18 IOException -> L20
        Iterator<String> r11 = allSubtypes.keySet().iterator();     // Catch: Throwable -> L18 IOException -> L20
    L11:
        if (r11.hasNext() == false) goto L51;
        String imiId = r11.next();     // Catch: Throwable -> L18 IOException -> L20
        if (isSetMethodMap == false) goto L61;
        if (r1.containsKey(imiId) == true) goto L61;
        Slog.w(TAG, "IME uninstalled or not valid.: " + imiId);     // Catch: Throwable -> L18 IOException -> L20
    L61:
        List<InputMethodSubtype> subtypesList = allSubtypes.get(imiId);     // Catch: Throwable -> L26 IOException -> L28
        if (subtypesList == null) goto L25;
        out.startTag(r12, NODE_IMI);     // Catch: Throwable -> L26 IOException -> L28
        out.attribute(r12, ATTR_ID, imiId);     // Catch: Throwable -> L26 IOException -> L28
        Iterator<InputMethodSubtype> r6 = subtypesList.iterator();     // Catch: Throwable -> L26 IOException -> L28
    L32:
        if (r6.hasNext() == false) goto L50;
        InputMethodSubtype subtype = r6.next();     // Catch: Throwable -> L26 IOException -> L28
        out.startTag(r12, NODE_SUBTYPE);     // Catch: Throwable -> L26 IOException -> L28
        if (subtype.hasSubtypeId() == false) goto L37;
        out.attributeInt(null, ATTR_IME_SUBTYPE_ID, subtype.getSubtypeId());     // Catch: Throwable -> L26 IOException -> L28
    L37:
        out.attributeInt(null, ATTR_ICON, subtype.getIconResId());     // Catch: Throwable -> L26 IOException -> L28
        out.attributeInt(null, ATTR_LABEL, subtype.getNameResId());     // Catch: Throwable -> L26 IOException -> L28
        out.attribute(null, ATTR_NAME_OVERRIDE, subtype.getNameOverride().toString());     // Catch: Throwable -> L26 IOException -> L28
        out.attributeInt(null, ATTR_LAYOUT_LABEL, subtype.getLayoutLabelResource());     // Catch: Throwable -> L26 IOException -> L28
        out.attribute(null, ATTR_LAYOUT_LABEL_NON_LOCALIZED, subtype.getLayoutLabelNonLocalized().toString());     // Catch: Throwable -> L26 IOException -> L28
        ULocale pkLanguageTag = subtype.getPhysicalKeyboardHintLanguageTag();     // Catch: Throwable -> L26 IOException -> L28
        if (pkLanguageTag == null) goto L41;
        out.attribute(null, ATTR_NAME_PK_LANGUAGE_TAG, pkLanguageTag.toLanguageTag());     // Catch: Throwable -> L26 IOException -> L28
    L41:
        out.attribute(null, ATTR_NAME_PK_LAYOUT_TYPE, subtype.getPhysicalKeyboardHintLayoutType());     // Catch: Throwable -> L26 IOException -> L28
        out.attribute(null, ATTR_IME_SUBTYPE_LOCALE, subtype.getLocale());     // Catch: Throwable -> L26 IOException -> L28
        out.attribute(null, ATTR_IME_SUBTYPE_LANGUAGE_TAG, subtype.getLanguageTag());     // Catch: Throwable -> L26 IOException -> L28
        out.attribute(null, ATTR_IME_SUBTYPE_MODE, subtype.getMode());     // Catch: Throwable -> L26 IOException -> L28
        out.attribute(null, ATTR_IME_SUBTYPE_EXTRA_VALUE, subtype.getExtraValue());     // Catch: Throwable -> L26 IOException -> L28
        if (subtype.isAuxiliary() == false) goto L44;
        int r7 = 1;
    L45:
        out.attributeInt(null, ATTR_IS_AUXILIARY, r7);     // Catch: Throwable -> L26 IOException -> L28
        if (subtype.isAsciiCapable() == false) goto L48;
        int r8 = 1;
    L49:
        out.attributeInt(null, ATTR_IS_ASCII_CAPABLE, r8);     // Catch: Throwable -> L26 IOException -> L28
        out.endTag(null, NODE_SUBTYPE);     // Catch: Throwable -> L26 IOException -> L28
        r6 = r6;
        r12 = null;
        goto L32
    L48:
        r8 = 0;
        goto L49
    L44:
        r7 = 0;
        goto L45
    L50:
        out.endTag(null, NODE_IMI);     // Catch: Throwable -> L26 IOException -> L28
        r1 = methodMap;
        r12 = null;
        goto L11
    L25:
        Slog.e(TAG, "Null subtype list for IME " + imiId);     // Catch: Throwable -> L26 IOException -> L28
    L28:
        e = e;
    L54:
        Slog.w(TAG, "Error writing subtypes", e);     // Catch: Throwable -> L26
        if (fos != null) goto L56;
    L52:
        IoUtils.closeQuietly(fos);
        return;
    L56:
        subtypesFile.failWrite(fos);     // Catch: Throwable -> L26
    L26:
        th = th;
    L59:
        IoUtils.closeQuietly(fos);
        throw th;
    L51:
        out.endTag(null, NODE_SUBTYPES);     // Catch: Throwable -> L26 IOException -> L28
        out.endDocument();     // Catch: Throwable -> L26 IOException -> L28
        subtypesFile.finishWrite(fos);     // Catch: Throwable -> L26 IOException -> L28
    L20:
        e = e;
    L18:
        th = th;
        goto L59
    L5:
        if (r1.size() <= 0) goto L7;
        isSetMethodMap = true;
        goto L8
    }

    static AdditionalSubtypeMap load(int userId) {
        AtomicFile subtypesFile = getAdditionalSubtypeFile(getInputMethodDir(userId));
        if (subtypesFile.exists() == false) goto L7;
        return loadFromFile(subtypesFile);
    L7:
        return AdditionalSubtypeMap.EMPTY_MAP;
    }

    static AdditionalSubtypeMap loadFromFile(AtomicFile subtypesFile) {
        String r0 = "1";
        String r1 = TAG;
        ArrayMap<String, List<InputMethodSubtype>> allSubtypes = new ArrayMap();
        FileInputStream fis = subtypesFile.openRead();     // Catch: Throwable -> L100
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L79
        int type = parser.next();     // Catch: Throwable -> L79
    L5:
        int r6 = 1;
        int r7 = 2;
        if (type == 2) goto L12;
        if (type == 1) goto L12;
    L10:
        th = move-exception;
        fis = fis;
        Throwable r2 = th;
    L93:
        if (fis == null) goto L140;
        fis.close();     // Catch: Throwable -> L96
        throw r2;     // Catch: Throwable -> L87 Throwable -> L87 Throwable -> L87
    L96:
        th = move-exception;
        r2.addSuppressed(th);     // Catch: Throwable -> L87 Throwable -> L87 Throwable -> L87
        throw r2;     // Catch: Throwable -> L87 Throwable -> L87 Throwable -> L87
    L140:
        throw r2;     // Catch: Throwable -> L87 Throwable -> L87 Throwable -> L87
    L9:
        type = parser.next();     // Catch: Throwable -> L10
    L12:
        String firstNodeName = parser.getName();     // Catch: Throwable -> L79
        if (NODE_SUBTYPES.equals(firstNodeName) == false) goto L92;
        int depth = parser.getDepth();     // Catch: Throwable -> L79
        String currentImiId = null;
        ArrayList<InputMethodSubtype> tempSubtypesArray = null;
    L15:
        int r12 = parser.next();     // Catch: Throwable -> L79
        int type2 = r12;
        if (r12 != 3) goto L22;
        if (parser.getDepth() > depth) goto L22;
    L84:
        if (fis == 0) goto L104;
        fis.close();     // Catch: Throwable -> L87
    L104:
        return AdditionalSubtypeMap.of(allSubtypes);
    L22:
        if (type2 == r6) goto L84;
        if (type2 != r7) goto L24;
        String nodeName = parser.getName();     // Catch: Throwable -> L79
        if (NODE_IMI.equals(nodeName) == false) goto L34;
        currentImiId = parser.getAttributeValue(null, ATTR_ID);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(currentImiId) == false) goto L31;
        Slog.w(r1, "Invalid imi id found in subtypes.xml");     // Catch: Throwable -> L10
        goto L15
    L31:
        ArrayList<InputMethodSubtype> tempSubtypesArray2 = new ArrayList();     // Catch: Throwable -> L10
        allSubtypes.put(currentImiId, tempSubtypesArray2);     // Catch: Throwable -> L10
        r0 = r0;
        fis = fis;
        tempSubtypesArray = tempSubtypesArray2;
    L82:
        allSubtypes = allSubtypes;
        fis = fis;
        firstNodeName = firstNodeName;
        depth = depth;
        r0 = r0;
        r6 = 1;
        r7 = 2;
        goto L15
    L34:
        if (NODE_SUBTYPE.equals(nodeName) == false) goto L81;
        if (TextUtils.isEmpty(currentImiId) == true) goto L122;
        if (tempSubtypesArray == null) goto L122;
        int icon = parser.getAttributeInt(null, ATTR_ICON);     // Catch: Throwable -> L67
        int label = parser.getAttributeInt(null, ATTR_LABEL);     // Catch: Throwable -> L67
        String untranslatableName = parser.getAttributeValue(null, ATTR_NAME_OVERRIDE);     // Catch: Throwable -> L67
        int layoutLabelResource = parser.getAttributeInt(null, ATTR_LAYOUT_LABEL);     // Catch: Throwable -> L67
        String layoutLabelNonLocalized = parser.getAttributeValue(null, ATTR_LAYOUT_LABEL_NON_LOCALIZED);     // Catch: Throwable -> L65
        fis = fis;
        String pkLanguageTag = parser.getAttributeValue(null, ATTR_NAME_PK_LANGUAGE_TAG);     // Catch: Throwable -> L63
        String pkLayoutType = parser.getAttributeValue(null, ATTR_NAME_PK_LAYOUT_TYPE);     // Catch: Throwable -> L63
        String imeSubtypeLocale = parser.getAttributeValue(null, ATTR_IME_SUBTYPE_LOCALE);     // Catch: Throwable -> L63
        String languageTag = parser.getAttributeValue(null, ATTR_IME_SUBTYPE_LANGUAGE_TAG);     // Catch: Throwable -> L63
        String imeSubtypeMode = parser.getAttributeValue(null, ATTR_IME_SUBTYPE_MODE);     // Catch: Throwable -> L63
        String imeSubtypeExtraValue = parser.getAttributeValue(null, ATTR_IME_SUBTYPE_EXTRA_VALUE);     // Catch: Throwable -> L63
        String r23 = r1;
        boolean isAuxiliary = r0.equals(String.valueOf(parser.getAttributeValue(null, ATTR_IS_AUXILIARY)));     // Catch: Throwable -> L51
        String currentImiId2 = currentImiId;
        boolean isAsciiCapable = r0.equals(String.valueOf(parser.getAttributeValue(null, ATTR_IS_ASCII_CAPABLE)));     // Catch: Throwable -> L51
        InputMethodSubtype.InputMethodSubtypeBuilder r13 = new InputMethodSubtype.InputMethodSubtypeBuilder().setSubtypeNameResId(label).setLayoutLabelResource(layoutLabelResource);     // Catch: Throwable -> L51
        if (pkLanguageTag != null) goto L48;
        ULocale r3 = null;
    L49:
        if (pkLayoutType != null) goto L53;
        String pkLanguageTag2 = "";
    L54:
        InputMethodSubtype.InputMethodSubtypeBuilder builder = r13.setPhysicalKeyboardHint(r3, pkLanguageTag2).setSubtypeIconResId(icon).setSubtypeLocale(imeSubtypeLocale).setLanguageTag(languageTag).setSubtypeMode(imeSubtypeMode).setSubtypeExtraValue(imeSubtypeExtraValue).setIsAuxiliary(isAuxiliary).setIsAsciiCapable(isAsciiCapable);     // Catch: Throwable -> L51
        int subtypeId = parser.getAttributeInt(null, ATTR_IME_SUBTYPE_ID, 0);     // Catch: Throwable -> L51
        if (subtypeId == 0) goto L57;
        builder.setSubtypeId(subtypeId);     // Catch: Throwable -> L51
    L57:
        if (untranslatableName == null) goto L59;
        builder.setSubtypeNameOverride(untranslatableName);     // Catch: Throwable -> L51
    L59:
        if (layoutLabelNonLocalized == null) goto L61;
        builder.setLayoutLabelNonLocalized(layoutLabelNonLocalized);     // Catch: Throwable -> L51
    L61:
        tempSubtypesArray.add(builder.build());     // Catch: Throwable -> L51
        r1 = r23;
        currentImiId = currentImiId2;
        goto L82
    L53:
        pkLanguageTag2 = pkLayoutType;
        goto L54
    L48:
        r3 = new ULocale(pkLanguageTag);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        r2 = th;
    L63:
        th = move-exception;
        r2 = th;
    L65:
        th = move-exception;
        fis = fis;
        r2 = th;
    L67:
        th = th;
    L69:
        fis = fis;
        r2 = th;
    L122:
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L77
        r4.append("IME uninstalled or not valid.: ");     // Catch: Throwable -> L77
        currentImiId = currentImiId;
        r4.append(currentImiId);     // Catch: Throwable -> L77
        r1 = r1;
        Slog.w(r1, r4.toString());     // Catch: Throwable -> L75
    L74:
        allSubtypes = allSubtypes;
        fis = fis;
        firstNodeName = firstNodeName;
        depth = depth;
        r0 = r0;
        r6 = 1;
        r7 = 2;
    L77:
        th = move-exception;
        r2 = th;
        goto L93
    L81:
        r0 = r0;
        fis = fis;
        goto L82
    L24:
        r0 = r0;
        allSubtypes = allSubtypes;
        fis = fis;
        type2 = type2;
        firstNodeName = firstNodeName;
        depth = depth;
        goto L74
    L92:
        throw new XmlPullParserException("Xml doesn't start with subtypes");     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        r2 = th;
    L79:
        th = th;
    L87:
        e = e;
    L102:
        Slog.w(TAG, "Error reading subtypes", e);
    L100:
        e = e;
        allSubtypes = allSubtypes;
        goto L102
    }
}
