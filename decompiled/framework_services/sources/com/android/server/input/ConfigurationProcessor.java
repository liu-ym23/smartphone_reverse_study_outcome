package com.android.server.input;

import android.text.TextUtils;
import android.util.Slog;
import android.util.Xml;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class ConfigurationProcessor {
    private static final String TAG = "ConfigurationProcessor";

    ConfigurationProcessor() {
    }

    static List<String> processExcludedDeviceNames(InputStream xml) throws Exception {
        List<String> names = new ArrayList();
        TypedXmlPullParser parser = Xml.resolvePullParser(xml);
        XmlUtils.beginDocument(parser, "devices");
    L3:
        XmlUtils.nextElement(parser);
        if ("device".equals(parser.getName()) == false) goto L5;
        String name = parser.getAttributeValue(null, "name");
        if (name == null) goto L3;
        names.add(name);
        goto L3
    L5:
        return names;
    }

    static Map<String, Integer> processInputPortAssociations(InputStream xml) throws Exception {
        Map<String, Integer> associations = new HashMap();
        TypedXmlPullParser parser = Xml.resolvePullParser(xml);
        XmlUtils.beginDocument(parser, "ports");
    L3:
        XmlUtils.nextElement(parser);
        String entryName = parser.getName();
        if ("port".equals(entryName) == false) goto L5;
        String inputPort = parser.getAttributeValue(null, "input");
        String displayPortStr = parser.getAttributeValue(null, "display");
        if (TextUtils.isEmpty(inputPort) == true) goto L16;
        if (TextUtils.isEmpty(displayPortStr) == true) goto L16;
        int displayPort = Integer.parseUnsignedInt(displayPortStr);     // Catch: NumberFormatException -> L13
        associations.put(inputPort, Integer.valueOf(displayPort));     // Catch: NumberFormatException -> L13
    L14:
        Slog.wtf(TAG, "Display port should be an integer");
    L16:
        Slog.wtf(TAG, "Ignoring incomplete entry");
        goto L3
    L5:
        return associations;
    }
}
