package com.android.server.pm;

import android.text.TextUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class ShareTargetInfo {
    private static final String ATTR_HOST = "host";
    private static final String ATTR_MIME_TYPE = "mimeType";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String ATTR_PATH_PATTERN = "pathPattern";
    private static final String ATTR_PATH_PREFIX = "pathPrefix";
    private static final String ATTR_PORT = "port";
    private static final String ATTR_SCHEME = "scheme";
    private static final String ATTR_TARGET_CLASS = "targetClass";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_DATA = "data";
    private static final String TAG_SHARE_TARGET = "share-target";
    final String[] mCategories;
    final String mTargetClass;
    final TargetData[] mTargetData;

    static class TargetData {
        final String mHost;
        final String mMimeType;
        final String mPath;
        final String mPathPattern;
        final String mPathPrefix;
        final String mPort;
        final String mScheme;

        TargetData(String scheme, String host, String port, String path, String pathPattern, String pathPrefix, String mimeType) {
            this.mScheme = scheme;
            this.mHost = host;
            this.mPort = port;
            this.mPath = path;
            this.mPathPattern = pathPattern;
            this.mPathPrefix = pathPrefix;
            this.mMimeType = mimeType;
        }

        public void toStringInner(StringBuilder strBuilder) {
            if (TextUtils.isEmpty(this.mScheme) == true) goto L6;
            strBuilder.append(" scheme=");
            strBuilder.append(this.mScheme);
        L6:
            if (TextUtils.isEmpty(this.mHost) == true) goto L9;
            strBuilder.append(" host=");
            strBuilder.append(this.mHost);
        L9:
            if (TextUtils.isEmpty(this.mPort) == true) goto L12;
            strBuilder.append(" port=");
            strBuilder.append(this.mPort);
        L12:
            if (TextUtils.isEmpty(this.mPath) == true) goto L15;
            strBuilder.append(" path=");
            strBuilder.append(this.mPath);
        L15:
            if (TextUtils.isEmpty(this.mPathPattern) == true) goto L18;
            strBuilder.append(" pathPattern=");
            strBuilder.append(this.mPathPattern);
        L18:
            if (TextUtils.isEmpty(this.mPathPrefix) == true) goto L21;
            strBuilder.append(" pathPrefix=");
            strBuilder.append(this.mPathPrefix);
        L21:
            if (TextUtils.isEmpty(this.mMimeType) == true) goto L24;
            strBuilder.append(" mimeType=");
            strBuilder.append(this.mMimeType);
            return;
        }

        public String toString() {
            StringBuilder strBuilder = new StringBuilder();
            toStringInner(strBuilder);
            return strBuilder.toString();
        }
    }

    ShareTargetInfo(TargetData[] data, String targetClass, String[] categories) {
        this.mTargetData = data;
        this.mTargetClass = targetClass;
        this.mCategories = categories;
    }

    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("targetClass=");
        strBuilder.append(this.mTargetClass);
        int i = 0;
    L4:
        if (i >= this.mTargetData.length) goto L6;
        strBuilder.append(" data={");
        this.mTargetData[i].toStringInner(strBuilder);
        strBuilder.append("}");
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= this.mCategories.length) goto L11;
        strBuilder.append(" category=");
        strBuilder.append(this.mCategories[i2]);
        i2 = i2 + 1;
        goto L8
    L11:
        return strBuilder.toString();
    }

    void saveToXml(TypedXmlSerializer out) throws IOException {
        out.startTag(null, TAG_SHARE_TARGET);
        ShortcutService.writeAttr(out, ATTR_TARGET_CLASS, this.mTargetClass);
        int i = 0;
    L4:
        if (i >= this.mTargetData.length) goto L6;
        out.startTag(null, "data");
        ShortcutService.writeAttr(out, ATTR_SCHEME, this.mTargetData[i].mScheme);
        ShortcutService.writeAttr(out, "host", this.mTargetData[i].mHost);
        ShortcutService.writeAttr(out, ATTR_PORT, this.mTargetData[i].mPort);
        ShortcutService.writeAttr(out, ATTR_PATH, this.mTargetData[i].mPath);
        ShortcutService.writeAttr(out, ATTR_PATH_PATTERN, this.mTargetData[i].mPathPattern);
        ShortcutService.writeAttr(out, ATTR_PATH_PREFIX, this.mTargetData[i].mPathPrefix);
        ShortcutService.writeAttr(out, ATTR_MIME_TYPE, this.mTargetData[i].mMimeType);
        out.endTag(null, "data");
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= this.mCategories.length) goto L10;
        out.startTag(null, TAG_CATEGORY);
        ShortcutService.writeAttr(out, "name", this.mCategories[i2]);
        out.endTag(null, TAG_CATEGORY);
        i2 = i2 + 1;
        goto L8
    L10:
        out.endTag(null, TAG_SHARE_TARGET);
    }

    static ShareTargetInfo loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        String targetClass = ShortcutService.parseStringAttribute(parser, ATTR_TARGET_CLASS);
        ArrayList<TargetData> targetData = new ArrayList();
        ArrayList<String> categories = new ArrayList();
    L3:
        int type = parser.next();
        byte r5 = 1;
        if (type == 1) goto L27;
        if (type == 2) goto L7;
        if (type != 3) goto L3;
        if (parser.getName().equals(TAG_SHARE_TARGET) == false) goto L3;
    L7:
        String r3 = parser.getName();
        switch(r3.hashCode()) {
            case 3076010: goto L14;
            case 50511102: goto L11;
            default: goto L16;
        };
    L16:
        r5 = -1;
    L17:
        switch(r5) {
            case 0: goto L20;
            case 1: goto L19;
            default: goto L3;
        };
    L19:
        categories.add(ShortcutService.parseStringAttribute(parser, "name"));
        goto L3
    L20:
        targetData.add(parseTargetData(parser));
        goto L3
    L11:
        if (r3.equals(TAG_CATEGORY) == false) goto L16;
    L14:
        if (r3.equals("data") == false) goto L16;
        r5 = 0;
    L27:
        if (targetData.isEmpty() == true) goto L34;
        if (targetClass != null) goto L30;
        return null;
    L30:
        if (categories.isEmpty() == false) goto L33;
        return null;
    L33:
        return new ShareTargetInfo((TargetData[]) targetData.toArray(new TargetData[targetData.size()]), targetClass, (String[]) categories.toArray(new String[categories.size()]));
    L34:
        return null;
    }

    private static TargetData parseTargetData(TypedXmlPullParser parser) {
        String scheme = ShortcutService.parseStringAttribute(parser, ATTR_SCHEME);
        String host = ShortcutService.parseStringAttribute(parser, "host");
        String port = ShortcutService.parseStringAttribute(parser, ATTR_PORT);
        String path = ShortcutService.parseStringAttribute(parser, ATTR_PATH);
        String pathPattern = ShortcutService.parseStringAttribute(parser, ATTR_PATH_PATTERN);
        String pathPrefix = ShortcutService.parseStringAttribute(parser, ATTR_PATH_PREFIX);
        String mimeType = ShortcutService.parseStringAttribute(parser, ATTR_MIME_TYPE);
        return new TargetData(scheme, host, port, path, pathPattern, pathPrefix, mimeType);
    }
}
