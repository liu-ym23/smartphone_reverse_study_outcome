package com.android.server.graphics.fonts;

import android.graphics.fonts.FontUpdateRequest;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class PersistentSystemFontConfig {
    private static final String ATTR_VALUE = "value";
    private static final String TAG = "PersistentSystemFontConfig";
    private static final String TAG_FAMILY = "family";
    private static final String TAG_LAST_MODIFIED_DATE = "lastModifiedDate";
    private static final String TAG_ROOT = "fontConfig";
    private static final String TAG_UPDATED_FONT_DIR = "updatedFontDir";

    static class Config {
        public final List<FontUpdateRequest.Family> fontFamilies;
        public long lastModifiedMillis;
        public final Set<String> updatedFontDirs;

        Config() {
            this.updatedFontDirs = new ArraySet();
            this.fontFamilies = new ArrayList();
        }
    }

    PersistentSystemFontConfig() {
    }

    public static void loadFromXml(InputStream is, Config out) throws XmlPullParserException, IOException {
        TypedXmlPullParser parser = Xml.resolvePullParser(is);
    L3:
        int type = parser.next();
        byte r3 = 1;
        if (type == 1) goto L35;
        if (type != 2) goto L3;
        int depth = parser.getDepth();
        String tag = parser.getName();
        if (depth == 1) goto L11;
        if (depth != 2) goto L3;
        switch(tag.hashCode()) {
            case -1540845619: goto L25;
            case -1281860764: goto L22;
            case -23402365: goto L19;
            default: goto L27;
        };
    L27:
        r3 = -1;
    L29:
        switch(r3) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L31;
            default: goto L30;
        };
    L31:
        out.fontFamilies.add(FontUpdateRequest.Family.readFromXml(parser));
        goto L3
    L32:
        out.updatedFontDirs.add(getAttribute(parser, ATTR_VALUE));
        goto L3
    L33:
        out.lastModifiedMillis = parseLongAttribute(parser, ATTR_VALUE, 0);
        goto L3
    L30:
        Slog.w(TAG, "Skipping unknown tag: " + tag);
        goto L3
    L19:
        if (tag.equals(TAG_UPDATED_FONT_DIR) == false) goto L27;
    L22:
        if (tag.equals(TAG_FAMILY) == false) goto L27;
        r3 = 2;
        goto L29
    L25:
        if (tag.equals(TAG_LAST_MODIFIED_DATE) == false) goto L27;
        r3 = 0;
        goto L29
    L11:
        if (TAG_ROOT.equals(tag) == true) goto L3;
        Slog.e(TAG, "Invalid root tag: " + tag);
        return;
    }

    public static void writeToXml(OutputStream os, Config config) throws IOException {
        TypedXmlSerializer out = Xml.resolveSerializer(os);
        out.startDocument(null, true);
        out.startTag(null, TAG_ROOT);
        out.startTag(null, TAG_LAST_MODIFIED_DATE);
        out.attribute(null, ATTR_VALUE, Long.toString(config.lastModifiedMillis));
        out.endTag(null, TAG_LAST_MODIFIED_DATE);
        Iterator<String> r3 = config.updatedFontDirs.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        String dir = r3.next();
        out.startTag(null, TAG_UPDATED_FONT_DIR);
        out.attribute(null, ATTR_VALUE, dir);
        out.endTag(null, TAG_UPDATED_FONT_DIR);
        goto L4
    L6:
        List<FontUpdateRequest.Family> fontFamilies = config.fontFamilies;
        int i = 0;
    L8:
        if (i >= fontFamilies.size()) goto L10;
        FontUpdateRequest.Family fontFamily = fontFamilies.get(i);
        out.startTag(null, TAG_FAMILY);
        FontUpdateRequest.Family.writeFamilyToXml(out, fontFamily);
        out.endTag(null, TAG_FAMILY);
        i = i + 1;
        goto L8
    L10:
        out.endTag(null, TAG_ROOT);
        out.endDocument();
    }

    private static long parseLongAttribute(TypedXmlPullParser parser, String attr, long defValue) {
        String value = parser.getAttributeValue(null, attr);
        if (TextUtils.isEmpty(value) == false) goto L9;
        return defValue;
    L9:
        return Long.parseLong(value);
    L8:
        return defValue;
    }

    private static String getAttribute(TypedXmlPullParser parser, String attr) {
        String value = parser.getAttributeValue(null, attr);
        if (value != null) goto L6;
        return "";
    L6:
        return value;
    }
}
