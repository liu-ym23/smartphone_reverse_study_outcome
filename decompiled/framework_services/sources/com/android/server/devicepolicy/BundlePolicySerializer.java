package com.android.server.devicepolicy;

import android.app.admin.BundlePolicyValue;
import android.app.admin.PolicyValue;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class BundlePolicySerializer extends PolicySerializer<Bundle> {
    private static final String ATTR_KEY = "key";
    private static final String ATTR_MULTIPLE = "m";
    private static final String ATTR_TYPE_BOOLEAN = "b";
    private static final String ATTR_TYPE_BUNDLE = "B";
    private static final String ATTR_TYPE_BUNDLE_ARRAY = "BA";
    private static final String ATTR_TYPE_INTEGER = "i";
    private static final String ATTR_TYPE_STRING = "s";
    private static final String ATTR_TYPE_STRING_ARRAY = "sa";
    private static final String ATTR_VALUE_TYPE = "type";
    private static final String TAG = "BundlePolicySerializer";
    private static final String TAG_ENTRY = "entry";
    private static final String TAG_VALUE = "value";

    BundlePolicySerializer() {
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ PolicyValue<Bundle> readFromXml(TypedXmlPullParser r1) {
        return readFromXml2(r1);
    }

    @Override // com.android.server.devicepolicy.PolicySerializer
    /* bridge */ /* synthetic */ void saveToXml(TypedXmlSerializer r1, Bundle r2) throws IOException {
        saveToXml2(r1, r2);
    }

    /* JADX INFO: renamed from: saveToXml, reason: avoid collision after fix types in other method */
    void saveToXml2(TypedXmlSerializer serializer, Bundle value) throws IOException {
        value.getClass();
        writeBundle(value, serializer);
    }

    /* JADX INFO: renamed from: readFromXml, reason: avoid collision after fix types in other method */
    BundlePolicyValue readFromXml2(TypedXmlPullParser parser) {
        Bundle bundle = new Bundle();
        ArrayList<String> values = new ArrayList();
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L8
    L5:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L11;
        readBundle(bundle, values, parser);     // Catch: Throwable -> L8
        goto L5
    L11:
        return new BundlePolicyValue(bundle);
    L8:
        e = move-exception;
        Log.e(TAG, "Error parsing Bundle policy.", e);
        return null;
    }

    private static void readBundle(Bundle restrictions, ArrayList<String> values, TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() == 2) goto L5;
        return;
    L5:
        if (parser.getName().equals("entry") == false) goto L45;
        String key = parser.getAttributeValue(null, ATTR_KEY);
        String valType = parser.getAttributeValue(null, "type");
        int count = parser.getAttributeInt(null, ATTR_MULTIPLE, -1);
        if (count == (-1)) goto L18;
        values.clear();
    L9:
        if (count <= 0) goto L16;
        int type = parser.next();
        if (type == 1) goto L16;
        if (type != 2) goto L9;
        if (parser.getName().equals(TAG_VALUE) == false) goto L9;
        values.add(parser.nextText());
        count = count - 1;
    L16:
        String[] valueStrings = new String[values.size()];
        values.toArray(valueStrings);
        restrictions.putStringArray(key, valueStrings);
        return;
    L18:
        if (ATTR_TYPE_BUNDLE.equals(valType) == false) goto L21;
        restrictions.putBundle(key, readBundleEntry(parser, values));
        return;
    L21:
        if (ATTR_TYPE_BUNDLE_ARRAY.equals(valType) == false) goto L27;
        int outerDepth = parser.getDepth();
        ArrayList<Bundle> bundleList = new ArrayList();
    L24:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L26;
        Bundle childBundle = readBundleEntry(parser, values);
        bundleList.add(childBundle);
        goto L24
    L26:
        restrictions.putParcelableArray(key, (Parcelable[]) bundleList.toArray(new Bundle[bundleList.size()]));
        return;
    L27:
        String value = parser.nextText();
        if (ATTR_TYPE_BOOLEAN.equals(valType) == false) goto L31;
        restrictions.putBoolean(key, Boolean.parseBoolean(value));
        return;
    L31:
        if (ATTR_TYPE_INTEGER.equals(valType) == false) goto L33;
        restrictions.putInt(key, Integer.parseInt(value));
        return;
    L33:
        restrictions.putString(key, value);
        return;
    }

    private static Bundle readBundleEntry(TypedXmlPullParser parser, ArrayList<String> values) throws IOException, XmlPullParserException {
        Bundle childBundle = new Bundle();
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L6;
        readBundle(childBundle, values, parser);
        goto L4
    L6:
        return childBundle;
    }

    private static void writeBundle(Bundle restrictions, TypedXmlSerializer serializer) throws IOException {
        Iterator<String> r0 = restrictions.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L43;
        String key = r0.next();
        Object value = restrictions.get(key);
        serializer.startTag(null, "entry");
        serializer.attribute(null, ATTR_KEY, key);
        if ((value instanceof Boolean) == false) goto L9;
        serializer.attribute(null, "type", ATTR_TYPE_BOOLEAN);
        serializer.text(value.toString());
    L42:
        serializer.endTag(null, "entry");
        goto L4
    L9:
        if ((value instanceof Integer) == false) goto L11;
        serializer.attribute(null, "type", ATTR_TYPE_INTEGER);
        serializer.text(value.toString());
        goto L42
    L11:
        String r5 = "";
        if (value != null) goto L14;
    L38:
        serializer.attribute(null, "type", ATTR_TYPE_STRING);
        if (value == null) goto L41;
        r5 = (String) value;
    L41:
        serializer.text(r5);
        goto L42
    L14:
        if ((value instanceof String) == true) goto L38;
        if ((value instanceof Bundle) == false) goto L19;
        serializer.attribute(null, "type", ATTR_TYPE_BUNDLE);
        writeBundle((Bundle) value, serializer);
        goto L42
    L19:
        int r9 = 0;
        if ((value instanceof Parcelable[]) == false) goto L30;
        serializer.attribute(null, "type", ATTR_TYPE_BUNDLE_ARRAY);
        Parcelable[] array = (Parcelable[]) value;
        int r7 = array.length;
    L23:
        if (r9 >= r7) goto L42;
        Parcelable parcelable = array[r9];
        if ((parcelable instanceof Bundle) == false) goto L28;
        serializer.startTag(null, "entry");
        serializer.attribute(null, "type", ATTR_TYPE_BUNDLE);
        writeBundle((Bundle) parcelable, serializer);
        serializer.endTag(null, "entry");
        r9 = r9 + 1;
        goto L23
    L28:
        throw new IllegalArgumentException("bundle-array can only hold Bundles");
    L30:
        serializer.attribute(null, "type", ATTR_TYPE_STRING_ARRAY);
        String[] values = (String[]) value;
        serializer.attributeInt(null, ATTR_MULTIPLE, values.length);
        int r8 = values.length;
    L32:
        if (r9 >= r8) goto L42;
        String choice = values[r9];
        serializer.startTag(null, TAG_VALUE);
        if (choice == null) goto L36;
        String r11 = choice;
    L37:
        serializer.text(r11);
        serializer.endTag(null, TAG_VALUE);
        r9 = r9 + 1;
        goto L32
    L36:
        r11 = "";
        goto L37
    }
}
