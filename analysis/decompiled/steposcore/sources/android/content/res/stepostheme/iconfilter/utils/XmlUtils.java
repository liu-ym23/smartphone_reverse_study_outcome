package android.content.res.stepostheme.iconfilter.utils;

import android.util.Log;
import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class XmlUtils {
    private static final String TAG = "XmlUtils";

    public static Map<String, String> parseXmlAttributes(String filePath, String rootTag) throws XmlPullParserException, IOException {
        Map<String, String> result = new HashMap<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return result;
        }
        InputStream is = null;
        try {
            try {
                try {
                    is = new FileInputStream(file);
                    XmlPullParser parser = Xml.newPullParser();
                    parser.setInput(is, "UTF-8");
                    for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                        if (eventType == 2) {
                            String tagName = parser.getName();
                            if (rootTag == null || rootTag.equals(tagName)) {
                                int attrCount = parser.getAttributeCount();
                                for (int i = 0; i < attrCount; i++) {
                                    result.put(parser.getAttributeName(i), parser.getAttributeValue(i));
                                }
                            }
                        }
                    }
                    is.close();
                } catch (IOException e) {
                }
            } catch (IOException | XmlPullParserException e2) {
                Log.w(TAG, "Failed to parse XML: " + e2.getMessage());
                if (is != null) {
                    is.close();
                }
            }
            return result;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                }
            }
            throw th;
        }
    }

    public static String parseXmlAttribute(String filePath, String tagName, String attrName) throws XmlPullParserException, IOException {
        File file = new File(filePath);
        String attributeValue = null;
        if (!file.exists()) {
            return null;
        }
        InputStream is = null;
        try {
            try {
                try {
                    is = new FileInputStream(file);
                    XmlPullParser parser = Xml.newPullParser();
                    parser.setInput(is, "UTF-8");
                    for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                        if (eventType == 2 && tagName.equals(parser.getName())) {
                            attributeValue = parser.getAttributeValue(null, attrName);
                            try {
                                is.close();
                            } catch (IOException e) {
                            }
                            return attributeValue;
                        }
                    }
                    is.close();
                } catch (IOException e2) {
                }
            } catch (IOException | XmlPullParserException e3) {
                Log.w(TAG, "Failed to parse XML attribute: " + e3.getMessage());
                if (is != null) {
                    is.close();
                }
            }
            return attributeValue;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    public static int parseIntAttribute(String filePath, String tagName, String attrName, int defaultValue) throws XmlPullParserException, IOException {
        String value = parseXmlAttribute(filePath, tagName, attrName);
        return StringUtils.parseInt(value, defaultValue);
    }

    public static float parseFloatAttribute(String filePath, String tagName, String attrName, float defaultValue) throws XmlPullParserException, IOException {
        String value = parseXmlAttribute(filePath, tagName, attrName);
        return StringUtils.parseFloat(value, defaultValue);
    }

    public static boolean parseBooleanAttribute(String filePath, String tagName, String attrName, boolean defaultValue) throws XmlPullParserException, IOException {
        String value = parseXmlAttribute(filePath, tagName, attrName);
        return StringUtils.parseBoolean(value, defaultValue);
    }

    public static boolean isValidXmlFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(is, "UTF-8");
            parser.next();
            try {
                is.close();
                return true;
            } catch (IOException e) {
                return true;
            }
        } catch (IOException | XmlPullParserException e2) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }
}
