package com.android.internal.util.jobs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.Xml;
import com.android.internal.util.HexDump;
import com.android.internal.util.XmlPullParserWrapper;
import com.android.internal.util.XmlSerializerWrapper;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.Settings;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import libcore.util.HexEncoding;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class XmlUtils {
    private static final String STRING_ARRAY_SEPARATOR = ":";

    private static class ForcedTypedXmlPullParser extends XmlPullParserWrapper implements TypedXmlPullParser {
        public ForcedTypedXmlPullParser(XmlPullParser wrapped) {
            super(wrapped);
        }

        public byte[] getAttributeBytesHex(int index) throws XmlPullParserException {
            return HexDump.hexStringToByteArray(getAttributeValue(index));
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public byte[] getAttributeBytesBase64(int index) throws XmlPullParserException {
            return Base64.decode(getAttributeValue(index), 2);
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public int getAttributeInt(int index) throws XmlPullParserException {
            return Integer.parseInt(getAttributeValue(index));
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public int getAttributeIntHex(int index) throws XmlPullParserException {
            return Integer.parseInt(getAttributeValue(index), 16);
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public long getAttributeLong(int index) throws XmlPullParserException {
            return Long.parseLong(getAttributeValue(index));
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public long getAttributeLongHex(int index) throws XmlPullParserException {
            return Long.parseLong(getAttributeValue(index), 16);
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public float getAttributeFloat(int index) throws XmlPullParserException {
            return Float.parseFloat(getAttributeValue(index));
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public double getAttributeDouble(int index) throws XmlPullParserException {
            return Double.parseDouble(getAttributeValue(index));
        L4:
            e = move-exception;
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + e);
        }

        public boolean getAttributeBoolean(int index) throws XmlPullParserException {
            String value = getAttributeValue(index);
            if ("true".equalsIgnoreCase(value) == false) goto L7;
            return true;
        L7:
            if ("false".equalsIgnoreCase(value) == false) goto L11;
            return false;
        L11:
            throw new XmlPullParserException("Invalid attribute " + getAttributeName(index) + ": " + value);
        }
    }

    private static class ForcedTypedXmlSerializer extends XmlSerializerWrapper implements TypedXmlSerializer {
        public ForcedTypedXmlSerializer(XmlSerializer wrapped) {
            super(wrapped);
        }

        public XmlSerializer attributeInterned(String namespace, String name, String value) throws IOException {
            return attribute(namespace, name, value);
        }

        public XmlSerializer attributeBytesHex(String namespace, String name, byte[] value) throws IOException {
            return attribute(namespace, name, HexDump.toHexString(value));
        }

        public XmlSerializer attributeBytesBase64(String namespace, String name, byte[] value) throws IOException {
            return attribute(namespace, name, Base64.encodeToString(value, 2));
        }

        public XmlSerializer attributeInt(String namespace, String name, int value) throws IOException {
            return attribute(namespace, name, Integer.toString(value));
        }

        public XmlSerializer attributeIntHex(String namespace, String name, int value) throws IOException {
            return attribute(namespace, name, Integer.toString(value, 16));
        }

        public XmlSerializer attributeLong(String namespace, String name, long value) throws IOException {
            return attribute(namespace, name, Long.toString(value));
        }

        public XmlSerializer attributeLongHex(String namespace, String name, long value) throws IOException {
            return attribute(namespace, name, Long.toString(value, 16));
        }

        public XmlSerializer attributeFloat(String namespace, String name, float value) throws IOException {
            return attribute(namespace, name, Float.toString(value));
        }

        public XmlSerializer attributeDouble(String namespace, String name, double value) throws IOException {
            return attribute(namespace, name, Double.toString(value));
        }

        public XmlSerializer attributeBoolean(String namespace, String name, boolean value) throws IOException {
            return attribute(namespace, name, Boolean.toString(value));
        }
    }

    public interface ReadMapCallback {
        Object readThisUnknownObjectXml(TypedXmlPullParser r1, String r2) throws XmlPullParserException, IOException;
    }

    public interface WriteMapCallback {
        void writeUnknownObject(Object r1, String r2, TypedXmlSerializer r3) throws XmlPullParserException, IOException;
    }

    public XmlUtils() {
    }

    public static TypedXmlSerializer makeTyped(XmlSerializer xml) {
        if ((xml instanceof TypedXmlSerializer) == false) goto L7;
        return (TypedXmlSerializer) xml;
    L7:
        return new ForcedTypedXmlSerializer(xml);
    }

    public static TypedXmlPullParser makeTyped(XmlPullParser xml) {
        if ((xml instanceof TypedXmlPullParser) == false) goto L7;
        return (TypedXmlPullParser) xml;
    L7:
        return new ForcedTypedXmlPullParser(xml);
    }

    public static void skipCurrentTag(XmlPullParser parser) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L10;
        if (type != 3) goto L3;
        if (parser.getDepth() > outerDepth) goto L3;
        return;
    }

    public static final int convertValueToList(CharSequence value, String[] options, int defaultValue) {
        if (TextUtils.isEmpty(value) == true) goto L11;
        int i = 0;
    L6:
        if (i >= options.length) goto L11;
        if (value.equals(options[i]) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return i;
    L11:
        return defaultValue;
    }

    public static final boolean convertValueToBoolean(CharSequence value, boolean defaultValue) {
        if (TextUtils.isEmpty(value) == false) goto L6;
        return defaultValue;
    L6:
        if (value.equals("1") == false) goto L8;
    L11:
        return true;
    L8:
        if (value.equals("true") == true) goto L11;
        if (value.equals("TRUE") == true) goto L11;
        return false;
    }

    public static final int convertValueToInt(CharSequence charSeq, int defaultValue) {
        if (TextUtils.isEmpty(charSeq) == false) goto L5;
        return defaultValue;
    L5:
        String nm = charSeq.toString();
        int sign = 1;
        int index = 0;
        int len = nm.length();
        int base = 10;
        if ('-' != nm.charAt(0)) goto L9;
        sign = -1;
        index = 0 + 1;
    L9:
        if ('0' != nm.charAt(index)) goto L22;
        if (index != (len - 1)) goto L13;
        return 0;
    L13:
        char c = nm.charAt(index + 1);
        if ('x' != c) goto L16;
    L19:
        index = index + 2;
        base = 16;
    L25:
        return Integer.parseInt(nm.substring(index), base) * sign;
    L16:
        if ('X' == c) goto L19;
        index = index + 1;
        base = 8;
        goto L25
    L22:
        if ('#' != nm.charAt(index)) goto L25;
        index = index + 1;
        base = 16;
        goto L25
    }

    public static int convertValueToUnsignedInt(String value, int defaultValue) {
        if (TextUtils.isEmpty(value) == false) goto L6;
        return defaultValue;
    L6:
        return parseUnsignedIntAttribute(value);
    }

    public static int parseUnsignedIntAttribute(CharSequence charSeq) {
        String value = charSeq.toString();
        int index = 0;
        int len = value.length();
        int base = 10;
        if ('0' != value.charAt(0)) goto L17;
        if (0 != (len - 1)) goto L8;
        return 0;
    L8:
        char c = value.charAt(0 + 1);
        if ('x' != c) goto L11;
    L14:
        index = 0 + 2;
        base = 16;
    L20:
        return (int) Long.parseLong(value.substring(index), base);
    L11:
        if ('X' == c) goto L14;
        index = 0 + 1;
        base = 8;
        goto L20
    L17:
        if ('#' != value.charAt(0)) goto L20;
        index = 0 + 1;
        base = 16;
        goto L20
    }

    public static final void writeMapXml(Map val, OutputStream out) throws XmlPullParserException, IOException {
        TypedXmlSerializer serializer = Xml.newFastSerializer();
        serializer.setOutput(out, StandardCharsets.UTF_8.name());
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(val, null, serializer);
        serializer.endDocument();
    }

    public static final void writeListXml(List val, OutputStream out) throws XmlPullParserException, IOException {
        TypedXmlSerializer serializer = Xml.newFastSerializer();
        serializer.setOutput(out, StandardCharsets.UTF_8.name());
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(val, null, serializer);
        serializer.endDocument();
    }

    public static final void writeMapXml(Map val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        writeMapXml(val, name, out, null);
    }

    public static final void writeMapXml(Map val, String name, TypedXmlSerializer out, WriteMapCallback callback) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "map");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        writeMapXml(val, out, callback);
        out.endTag(null, "map");
    }

    public static final void writeMapXml(Map val, TypedXmlSerializer out, WriteMapCallback callback) throws XmlPullParserException, IOException {
        if (val != null) goto L4;
        return;
    L4:
        Set s = val.entrySet();
        Iterator i = s.iterator();
    L6:
        if (i.hasNext() == false) goto L8;
        Map.Entry e = (Map.Entry) i.next();
        writeValueXml(e.getValue(), (String) e.getKey(), out, callback);
        goto L6
    }

    public static final void writeListXml(List val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "list");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        int N = val.size();
        int i = 0;
    L10:
        if (i >= N) goto L12;
        writeValueXml(val.get(i), null, out);
        i = i + 1;
        goto L10
    L12:
        out.endTag(null, "list");
    }

    public static final void writeSetXml(Set val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "set");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        Iterator r2 = val.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        Object v = r2.next();
        writeValueXml(v, null, out);
        goto L11
    L13:
        out.endTag(null, "set");
    }

    public static final void writeByteArrayXml(byte[] val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "byte-array");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        int N = val.length;
        out.attributeInt(null, "num", N);
        out.text(HexEncoding.encodeToString(val).toLowerCase());
        out.endTag(null, "byte-array");
    }

    public static final void writeIntArrayXml(int[] val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "int-array");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        int N = val.length;
        out.attributeInt(null, "num", N);
        int i = 0;
    L10:
        if (i >= N) goto L12;
        out.startTag(null, Settings.TAG_ITEM);
        out.attributeInt(null, "value", val[i]);
        out.endTag(null, Settings.TAG_ITEM);
        i = i + 1;
        goto L10
    L12:
        out.endTag(null, "int-array");
    }

    public static final void writeLongArrayXml(long[] val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "long-array");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        int N = val.length;
        out.attributeInt(null, "num", N);
        int i = 0;
    L10:
        if (i >= N) goto L12;
        out.startTag(null, Settings.TAG_ITEM);
        out.attributeLong(null, "value", val[i]);
        out.endTag(null, Settings.TAG_ITEM);
        i = i + 1;
        goto L10
    L12:
        out.endTag(null, "long-array");
    }

    public static final void writeDoubleArrayXml(double[] val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "double-array");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        int N = val.length;
        out.attributeInt(null, "num", N);
        int i = 0;
    L10:
        if (i >= N) goto L12;
        out.startTag(null, Settings.TAG_ITEM);
        out.attributeDouble(null, "value", val[i]);
        out.endTag(null, Settings.TAG_ITEM);
        i = i + 1;
        goto L10
    L12:
        out.endTag(null, "double-array");
    }

    public static final void writeStringArrayXml(String[] val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "string-array");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        int N = val.length;
        out.attributeInt(null, "num", N);
        int i = 0;
    L10:
        if (i >= N) goto L12;
        out.startTag(null, Settings.TAG_ITEM);
        out.attribute(null, "value", val[i]);
        out.endTag(null, Settings.TAG_ITEM);
        i = i + 1;
        goto L10
    L12:
        out.endTag(null, "string-array");
    }

    public static final void writeBooleanArrayXml(boolean[] val, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        if (val != null) goto L6;
        out.startTag(null, "null");
        out.endTag(null, "null");
        return;
    L6:
        out.startTag(null, "boolean-array");
        if (name == null) goto L9;
        out.attribute(null, "name", name);
    L9:
        int N = val.length;
        out.attributeInt(null, "num", N);
        int i = 0;
    L10:
        if (i >= N) goto L12;
        out.startTag(null, Settings.TAG_ITEM);
        out.attributeBoolean(null, "value", val[i]);
        out.endTag(null, Settings.TAG_ITEM);
        i = i + 1;
        goto L10
    L12:
        out.endTag(null, "boolean-array");
    }

    @Deprecated
    public static final void writeValueXml(Object v, String name, XmlSerializer out) throws XmlPullParserException, IOException {
        writeValueXml(v, name, makeTyped(out));
    }

    public static final void writeValueXml(Object v, String name, TypedXmlSerializer out) throws XmlPullParserException, IOException {
        writeValueXml(v, name, out, null);
    }

    private static final void writeValueXml(Object v, String name, TypedXmlSerializer out, WriteMapCallback callback) throws XmlPullParserException, IOException {
        if (v != null) goto L10;
        out.startTag(null, "null");
        if (name == null) goto L7;
        out.attribute(null, "name", name);
    L7:
        out.endTag(null, "null");
        return;
    L10:
        if ((v instanceof String) == false) goto L17;
        out.startTag(null, "string");
        if (name == null) goto L14;
        out.attribute(null, "name", name);
    L14:
        out.text(v.toString());
        out.endTag(null, "string");
        return;
    L17:
        if ((v instanceof Integer) == false) goto L23;
        out.startTag(null, "int");
        if (name == null) goto L21;
        out.attribute(null, "name", name);
    L21:
        out.attributeInt(null, "value", ((Integer) v).intValue());
        out.endTag(null, "int");
        return;
    L23:
        if ((v instanceof Long) == false) goto L29;
        out.startTag(null, "long");
        if (name == null) goto L27;
        out.attribute(null, "name", name);
    L27:
        out.attributeLong(null, "value", ((Long) v).longValue());
        out.endTag(null, "long");
        return;
    L29:
        if ((v instanceof Float) == false) goto L35;
        out.startTag(null, "float");
        if (name == null) goto L33;
        out.attribute(null, "name", name);
    L33:
        out.attributeFloat(null, "value", ((Float) v).floatValue());
        out.endTag(null, "float");
        return;
    L35:
        if ((v instanceof Double) == false) goto L41;
        out.startTag(null, "double");
        if (name == null) goto L39;
        out.attribute(null, "name", name);
    L39:
        out.attributeDouble(null, "value", ((Double) v).doubleValue());
        out.endTag(null, "double");
        return;
    L41:
        if ((v instanceof Boolean) == false) goto L48;
        out.startTag(null, "boolean");
        if (name == null) goto L45;
        out.attribute(null, "name", name);
    L45:
        out.attributeBoolean(null, "value", ((Boolean) v).booleanValue());
        out.endTag(null, "boolean");
        return;
    L48:
        if ((v instanceof byte[]) == false) goto L52;
        writeByteArrayXml((byte[]) v, name, out);
        return;
    L52:
        if ((v instanceof int[]) == false) goto L56;
        writeIntArrayXml((int[]) v, name, out);
        return;
    L56:
        if ((v instanceof long[]) == false) goto L60;
        writeLongArrayXml((long[]) v, name, out);
        return;
    L60:
        if ((v instanceof double[]) == false) goto L64;
        writeDoubleArrayXml((double[]) v, name, out);
        return;
    L64:
        if ((v instanceof String[]) == false) goto L68;
        writeStringArrayXml((String[]) v, name, out);
        return;
    L68:
        if ((v instanceof boolean[]) == false) goto L72;
        writeBooleanArrayXml((boolean[]) v, name, out);
        return;
    L72:
        if ((v instanceof Map) == false) goto L76;
        writeMapXml((Map) v, name, out);
        return;
    L76:
        if ((v instanceof List) == false) goto L80;
        writeListXml((List) v, name, out);
        return;
    L80:
        if ((v instanceof Set) == false) goto L84;
        writeSetXml((Set) v, name, out);
        return;
    L84:
        if ((v instanceof CharSequence) == false) goto L90;
        out.startTag(null, "string");
        if (name == null) goto L88;
        out.attribute(null, "name", name);
    L88:
        out.text(v.toString());
        out.endTag(null, "string");
        return;
    L90:
        if (callback == null) goto L94;
        callback.writeUnknownObject(v, name, out);
        return;
    L94:
        throw new RuntimeException("writeValueXml: unable to write value " + v);
    }

    public static final HashMap<String, ?> readMapXml(InputStream in) throws XmlPullParserException, IOException {
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setInput(in, StandardCharsets.UTF_8.name());
        return (HashMap) readValueXml(parser, new String[1]);
    }

    public static final ArrayList readListXml(InputStream in) throws XmlPullParserException, IOException {
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setInput(in, StandardCharsets.UTF_8.name());
        return (ArrayList) readValueXml(parser, new String[1]);
    }

    public static final HashSet readSetXml(InputStream in) throws XmlPullParserException, IOException {
        TypedXmlPullParser parser = Xml.newFastPullParser();
        parser.setInput(in, StandardCharsets.UTF_8.name());
        return (HashSet) readValueXml(parser, new String[1]);
    }

    public static final HashMap<String, ?> readThisMapXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        return readThisMapXml(parser, endTag, name, null);
    }

    public static final HashMap<String, ?> readThisMapXml(TypedXmlPullParser parser, String endTag, String[] name, ReadMapCallback callback) throws XmlPullParserException, IOException {
        HashMap<String, ?> r0 = new HashMap();
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L8;
        Object val = readThisValueXml(parser, name, callback, false);
        r0.put(name[0], val);
    L14:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L8:
        if (eventType != 3) goto L14;
        if (parser.getName().equals(endTag) == false) goto L13;
        return r0;
    L13:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    }

    public static final ArrayMap<String, ?> readThisArrayMapXml(TypedXmlPullParser parser, String endTag, String[] name, ReadMapCallback callback) throws XmlPullParserException, IOException {
        ArrayMap<String, ?> r0 = new ArrayMap();
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L8;
        Object val = readThisValueXml(parser, name, callback, true);
        r0.put(name[0], val);
    L14:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L8:
        if (eventType != 3) goto L14;
        if (parser.getName().equals(endTag) == false) goto L13;
        return r0;
    L13:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    }

    public static final ArrayList readThisListXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        return readThisListXml(parser, endTag, name, null, false);
    }

    private static final ArrayList readThisListXml(TypedXmlPullParser parser, String endTag, String[] name, ReadMapCallback callback, boolean arrayMap) throws XmlPullParserException, IOException {
        ArrayList list = new ArrayList();
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L8;
        Object val = readThisValueXml(parser, name, callback, arrayMap);
        list.add(val);
    L14:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L8:
        if (eventType != 3) goto L14;
        if (parser.getName().equals(endTag) == false) goto L13;
        return list;
    L13:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    }

    public static final HashSet readThisSetXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        return readThisSetXml(parser, endTag, name, null, false);
    }

    private static final HashSet readThisSetXml(TypedXmlPullParser parser, String endTag, String[] name, ReadMapCallback callback, boolean arrayMap) throws XmlPullParserException, IOException {
        HashSet set = new HashSet();
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L8;
        Object val = readThisValueXml(parser, name, callback, arrayMap);
        set.add(val);
    L14:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L8:
        if (eventType != 3) goto L14;
        if (parser.getName().equals(endTag) == false) goto L13;
        return set;
    L13:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    }

    public static final byte[] readThisByteArrayXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        int num = parser.getAttributeInt(null, "num");
        byte[] array = new byte[0];
        int eventType = parser.getEventType();
    L4:
        if (eventType != 4) goto L14;
        if (num <= 0) goto L20;
        String values = parser.getText();
        if (values == null) goto L12;
        if (values.length() != (num * 2)) goto L12;
        array = HexEncoding.decode(values);
    L12:
        throw new XmlPullParserException("Invalid value found in byte-array: " + values);
    L20:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L14:
        if (eventType != 3) goto L20;
        if (parser.getName().equals(endTag) == false) goto L19;
        return array;
    L19:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    }

    public static final int[] readThisIntArrayXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        int num = parser.getAttributeInt(null, "num");
        parser.next();
        int[] array = new int[num];
        int i = 0;
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L11;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L9;
        array[i] = parser.getAttributeInt(null, "value");
    L20:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L9:
        throw new XmlPullParserException("Expected item tag at: " + parser.getName());
    L11:
        if (eventType != 3) goto L20;
        if (parser.getName().equals(endTag) == true) goto L14;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L19;
        i = i + 1;
        goto L20
    L19:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    L14:
        return array;
    }

    public static final long[] readThisLongArrayXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        int num = parser.getAttributeInt(null, "num");
        parser.next();
        long[] array = new long[num];
        int i = 0;
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L11;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L9;
        array[i] = parser.getAttributeLong(null, "value");
    L20:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L9:
        throw new XmlPullParserException("Expected item tag at: " + parser.getName());
    L11:
        if (eventType != 3) goto L20;
        if (parser.getName().equals(endTag) == true) goto L14;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L19;
        i = i + 1;
        goto L20
    L19:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    L14:
        return array;
    }

    public static final double[] readThisDoubleArrayXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        int num = parser.getAttributeInt(null, "num");
        parser.next();
        double[] array = new double[num];
        int i = 0;
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L11;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L9;
        array[i] = parser.getAttributeDouble(null, "value");
    L20:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L9:
        throw new XmlPullParserException("Expected item tag at: " + parser.getName());
    L11:
        if (eventType != 3) goto L20;
        if (parser.getName().equals(endTag) == true) goto L14;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L19;
        i = i + 1;
        goto L20
    L19:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    L14:
        return array;
    }

    public static final String[] readThisStringArrayXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        int num = parser.getAttributeInt(null, "num");
        parser.next();
        String[] array = new String[num];
        int i = 0;
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L11;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L9;
        array[i] = parser.getAttributeValue(null, "value");
    L20:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L9:
        throw new XmlPullParserException("Expected item tag at: " + parser.getName());
    L11:
        if (eventType != 3) goto L20;
        if (parser.getName().equals(endTag) == true) goto L14;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L19;
        i = i + 1;
        goto L20
    L19:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    L14:
        return array;
    }

    public static final boolean[] readThisBooleanArrayXml(TypedXmlPullParser parser, String endTag, String[] name) throws XmlPullParserException, IOException {
        int num = parser.getAttributeInt(null, "num");
        parser.next();
        boolean[] array = new boolean[num];
        int i = 0;
        int eventType = parser.getEventType();
    L4:
        if (eventType != 2) goto L11;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L9;
        array[i] = parser.getAttributeBoolean(null, "value");
    L20:
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Document ended before " + endTag + " end tag");
    L9:
        throw new XmlPullParserException("Expected item tag at: " + parser.getName());
    L11:
        if (eventType != 3) goto L20;
        if (parser.getName().equals(endTag) == true) goto L14;
        if (parser.getName().equals(Settings.TAG_ITEM) == false) goto L19;
        i = i + 1;
        goto L20
    L19:
        throw new XmlPullParserException("Expected " + endTag + " end tag at: " + parser.getName());
    L14:
        return array;
    }

    public static final Object readValueXml(TypedXmlPullParser parser, String[] name) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
    L4:
        if (eventType == 2) goto L6;
        if (eventType == 3) goto L19;
        if (eventType == 4) goto L17;
        eventType = parser.next();
        if (eventType != 1) goto L4;
        throw new XmlPullParserException("Unexpected end of document");
    L17:
        throw new XmlPullParserException("Unexpected text: " + parser.getText());
    L19:
        throw new XmlPullParserException("Unexpected end tag at: " + parser.getName());
    L6:
        return readThisValueXml(parser, name, null, false);
    }

    private static final Object readThisValueXml(TypedXmlPullParser parser, String[] name, ReadMapCallback callback, boolean arrayMap) throws XmlPullParserException, IOException {
        String valueName = parser.getAttributeValue(null, "name");
        String tagName = parser.getName();
        if (tagName.equals("null") == false) goto L6;
        Object res = null;
    L28:
        int eventType = parser.next();
        if (eventType == 1) goto L46;
        if (eventType == 3) goto L33;
        if (eventType == 4) goto L44;
        if (eventType != 2) goto L28;
        throw new XmlPullParserException("Unexpected start tag in <" + tagName + ">: " + parser.getName());
    L44:
        throw new XmlPullParserException("Unexpected text in <" + tagName + ">: " + parser.getName());
    L33:
        if (parser.getName().equals(tagName) == false) goto L37;
        name[0] = valueName;
        return res;
    L37:
        throw new XmlPullParserException("Unexpected end tag in <" + tagName + ">: " + parser.getName());
    L46:
        throw new XmlPullParserException("Unexpected end of document in <" + tagName + ">");
    L6:
        if (tagName.equals("string") == false) goto L25;
        StringBuilder value = new StringBuilder();
    L8:
        int eventType2 = parser.next();
        if (eventType2 == 1) goto L24;
        if (eventType2 == 3) goto L12;
        if (eventType2 == 4) goto L18;
        if (eventType2 != 2) goto L8;
        throw new XmlPullParserException("Unexpected start tag in <string>: " + parser.getName());
    L18:
        value.append(parser.getText());
        goto L8
    L12:
        if (parser.getName().equals("string") == false) goto L16;
        name[0] = valueName;
        return value.toString();
    L16:
        throw new XmlPullParserException("Unexpected end tag in <string>: " + parser.getName());
    L24:
        throw new XmlPullParserException("Unexpected end of document in <string>");
    L25:
        Object res2 = readThisPrimitiveValueXml(parser, tagName);
        if (res2 == null) goto L48;
        res = res2;
        goto L28
    L48:
        if (tagName.equals("byte-array") == false) goto L52;
        Object res3 = readThisByteArrayXml(parser, "byte-array", name);
        name[0] = valueName;
        return res3;
    L52:
        if (tagName.equals("int-array") == false) goto L56;
        Object res4 = readThisIntArrayXml(parser, "int-array", name);
        name[0] = valueName;
        return res4;
    L56:
        if (tagName.equals("long-array") == false) goto L60;
        Object res5 = readThisLongArrayXml(parser, "long-array", name);
        name[0] = valueName;
        return res5;
    L60:
        if (tagName.equals("double-array") == false) goto L64;
        Object res6 = readThisDoubleArrayXml(parser, "double-array", name);
        name[0] = valueName;
        return res6;
    L64:
        if (tagName.equals("string-array") == false) goto L68;
        Object res7 = readThisStringArrayXml(parser, "string-array", name);
        name[0] = valueName;
        return res7;
    L68:
        if (tagName.equals("boolean-array") == false) goto L72;
        Object res8 = readThisBooleanArrayXml(parser, "boolean-array", name);
        name[0] = valueName;
        return res8;
    L72:
        if (tagName.equals("map") == false) goto L80;
        parser.next();
        if (arrayMap == false) goto L76;
        Object res9 = readThisArrayMapXml(parser, "map", name, callback);
    L77:
        name[0] = valueName;
        return res9;
    L76:
        res9 = readThisMapXml(parser, "map", name, callback);
        goto L77
    L80:
        if (tagName.equals("list") == false) goto L84;
        parser.next();
        Object res10 = readThisListXml(parser, "list", name, callback, arrayMap);
        name[0] = valueName;
        return res10;
    L84:
        if (tagName.equals("set") == false) goto L87;
        parser.next();
        Object res11 = readThisSetXml(parser, "set", name, callback, arrayMap);
        name[0] = valueName;
        return res11;
    L87:
        if (callback == null) goto L91;
        Object res12 = callback.readThisUnknownObjectXml(parser, tagName);
        name[0] = valueName;
        return res12;
    L91:
        throw new XmlPullParserException("Unknown tag: " + tagName);
    }

    private static final Object readThisPrimitiveValueXml(TypedXmlPullParser parser, String tagName) throws XmlPullParserException, IOException {
        if (tagName.equals("int") == false) goto L7;
        return Integer.valueOf(parser.getAttributeInt(null, "value"));
    L7:
        if (tagName.equals("long") == false) goto L11;
        return Long.valueOf(parser.getAttributeLong(null, "value"));
    L11:
        if (tagName.equals("float") == false) goto L15;
        return Float.valueOf(parser.getAttributeFloat(null, "value"));
    L15:
        if (tagName.equals("double") == false) goto L19;
        return Double.valueOf(parser.getAttributeDouble(null, "value"));
    L19:
        if (tagName.equals("boolean") == true) goto L21;
        return null;
    L21:
        return Boolean.valueOf(parser.getAttributeBoolean(null, "value"));
    }

    public static final void beginDocument(XmlPullParser parser, String firstElementName) throws XmlPullParserException, IOException {
    L2:
        int type = parser.next();
        if (type == 2) goto L7;
        if (type != 1) goto L2;
    L7:
        if (type != 2) goto L14;
        if (parser.getName().equals(firstElementName) == false) goto L12;
        return;
    L12:
        throw new XmlPullParserException("Unexpected start tag: found " + parser.getName() + ", expected " + firstElementName);
    L14:
        throw new XmlPullParserException("No start tag found");
    }

    public static final void nextElement(XmlPullParser parser) throws XmlPullParserException, IOException {
    L2:
        int type = parser.next();
        if (type == 2) goto L7;
        if (type != 1) goto L2;
        return;
    }

    public static boolean nextElementWithin(XmlPullParser parser, int outerDepth) throws IOException, XmlPullParserException {
    L2:
        int type = parser.next();
        if (type == 1) goto L15;
        if (type != 3) goto L10;
        if (parser.getDepth() != outerDepth) goto L10;
        return false;
    L10:
        if (type != 2) goto L2;
        if (parser.getDepth() != (outerDepth + 1)) goto L2;
        return true;
    L15:
        return false;
    }

    public static int readIntAttribute(XmlPullParser in, String name, int defaultValue) {
        if ((in instanceof TypedXmlPullParser) == true) goto L5;
        String value = in.getAttributeValue(null, name);
        if (TextUtils.isEmpty(value) == false) goto L13;
        return defaultValue;
    L13:
        return Integer.parseInt(value);
    L12:
        return defaultValue;
    L5:
        return ((TypedXmlPullParser) in).getAttributeInt(null, name, defaultValue);
    }

    public static int readIntAttribute(XmlPullParser in, String name) throws IOException {
        if ((in instanceof TypedXmlPullParser) == true) goto L17;
        String value = in.getAttributeValue(null, name);
        return Integer.parseInt(value);
    L14:
        throw new ProtocolException("problem parsing " + name + "=" + value + " as int");
    L17:
        return ((TypedXmlPullParser) in).getAttributeInt(null, name);
    L6:
        e = move-exception;
        throw new ProtocolException(e.getMessage());
    }

    public static void writeIntAttribute(XmlSerializer out, String name, int value) throws IOException {
        if ((out instanceof TypedXmlSerializer) == false) goto L6;
        ((TypedXmlSerializer) out).attributeInt(null, name, value);
        return;
    L6:
        out.attribute(null, name, Integer.toString(value));
    }

    public static long readLongAttribute(XmlPullParser in, String name, long defaultValue) {
        if ((in instanceof TypedXmlPullParser) == true) goto L5;
        String value = in.getAttributeValue(null, name);
        if (TextUtils.isEmpty(value) == false) goto L13;
        return defaultValue;
    L13:
        return Long.parseLong(value);
    L12:
        return defaultValue;
    L5:
        return ((TypedXmlPullParser) in).getAttributeLong(null, name, defaultValue);
    }

    public static long readLongAttribute(XmlPullParser in, String name) throws IOException {
        if ((in instanceof TypedXmlPullParser) == true) goto L17;
        String value = in.getAttributeValue(null, name);
        return Long.parseLong(value);
    L14:
        throw new ProtocolException("problem parsing " + name + "=" + value + " as long");
    L17:
        return ((TypedXmlPullParser) in).getAttributeLong(null, name);
    L6:
        e = move-exception;
        throw new ProtocolException(e.getMessage());
    }

    public static void writeLongAttribute(XmlSerializer out, String name, long value) throws IOException {
        if ((out instanceof TypedXmlSerializer) == false) goto L6;
        ((TypedXmlSerializer) out).attributeLong(null, name, value);
        return;
    L6:
        out.attribute(null, name, Long.toString(value));
    }

    public static float readFloatAttribute(XmlPullParser in, String name) throws IOException {
        if ((in instanceof TypedXmlPullParser) == true) goto L17;
        String value = in.getAttributeValue(null, name);
        return Float.parseFloat(value);
    L14:
        throw new ProtocolException("problem parsing " + name + "=" + value + " as long");
    L17:
        return ((TypedXmlPullParser) in).getAttributeFloat(null, name);
    L6:
        e = move-exception;
        throw new ProtocolException(e.getMessage());
    }

    public static void writeFloatAttribute(XmlSerializer out, String name, float value) throws IOException {
        if ((out instanceof TypedXmlSerializer) == false) goto L6;
        ((TypedXmlSerializer) out).attributeFloat(null, name, value);
        return;
    L6:
        out.attribute(null, name, Float.toString(value));
    }

    public static boolean readBooleanAttribute(XmlPullParser in, String name) {
        return readBooleanAttribute(in, name, false);
    }

    public static boolean readBooleanAttribute(XmlPullParser in, String name, boolean defaultValue) {
        if ((in instanceof TypedXmlPullParser) == true) goto L5;
        String value = in.getAttributeValue(null, name);
        if (TextUtils.isEmpty(value) == false) goto L10;
        return defaultValue;
    L10:
        return Boolean.parseBoolean(value);
    L5:
        return ((TypedXmlPullParser) in).getAttributeBoolean(null, name, defaultValue);
    }

    public static void writeBooleanAttribute(XmlSerializer out, String name, boolean value) throws IOException {
        if ((out instanceof TypedXmlSerializer) == false) goto L6;
        ((TypedXmlSerializer) out).attributeBoolean(null, name, value);
        return;
    L6:
        out.attribute(null, name, Boolean.toString(value));
    }

    public static Uri readUriAttribute(XmlPullParser in, String name) {
        String value = in.getAttributeValue(null, name);
        if (value != null) goto L5;
        return null;
    L5:
        return Uri.parse(value);
    }

    public static void writeUriAttribute(XmlSerializer out, String name, Uri value) throws IOException {
        if (value == null) goto L5;
        out.attribute(null, name, value.toString());
        return;
    }

    public static String readStringAttribute(XmlPullParser in, String name) {
        return in.getAttributeValue(null, name);
    }

    public static void writeStringAttribute(XmlSerializer out, String name, CharSequence value) throws IOException {
        if (value == null) goto L5;
        out.attribute(null, name, value.toString());
        return;
    }

    public static byte[] readByteArrayAttribute(XmlPullParser in, String name) {
        if ((in instanceof TypedXmlPullParser) == true) goto L13;
        String value = in.getAttributeValue(null, name);
        if (TextUtils.isEmpty(value) == false) goto L11;
        return null;
    L11:
        return Base64.decode(value, 0);
    L13:
        return ((TypedXmlPullParser) in).getAttributeBytesBase64(null, name);
    L7:
        return null;
    }

    public static void writeByteArrayAttribute(XmlSerializer out, String name, byte[] value) throws IOException {
        if (value != null) goto L4;
        return;
    L4:
        if ((out instanceof TypedXmlSerializer) == false) goto L7;
        ((TypedXmlSerializer) out).attributeBytesBase64(null, name, value);
        return;
    L7:
        out.attribute(null, name, Base64.encodeToString(value, 0));
    }

    public static Bitmap readBitmapAttribute(XmlPullParser in, String name) {
        byte[] value = readByteArrayAttribute(in, name);
        if (value != null) goto L5;
        return null;
    L5:
        return BitmapFactory.decodeByteArray(value, 0, value.length);
    }

    @Deprecated
    public static void writeBitmapAttribute(XmlSerializer out, String name, Bitmap value) throws IOException {
        if (value == null) goto L5;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        value.compress(Bitmap.CompressFormat.PNG, 90, os);
        writeByteArrayAttribute(out, name, os.toByteArray());
        return;
    }
}
