package com.stepos.core.common.display;

import a0.a;
import android.content.Context;
import android.util.Xml;
import androidx.datastore.preferences.protobuf.b1;
import gc.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;
import mb.m;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDisplayResolver {
    private static final String DEFAULT_VALUES_DIR = "values";
    public static final ModelDisplayResolver INSTANCE = new ModelDisplayResolver();
    public static final String STRINGS_FILE = "strings.xml";

    private ModelDisplayResolver() {
    }

    private final String readPackTitle(Context context, String str) {
        File filePickStringsFile;
        Object objA;
        if (str == null || q.t0(str) || (filePickStringsFile = pickStringsFile(context, str)) == null) {
            return null;
        }
        try {
            objA = (String) parseStrings(filePickStringsFile).get("title");
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str2 = (String) objA;
        if (str2 == null || q.t0(str2)) {
            return null;
        }
        return str2;
    }

    public final Map<String, String> parseStrings(File file) throws IOException {
        g.f(file, "file");
        HashMap map = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setInput(fileInputStream, null);
            StringBuilder sb2 = new StringBuilder();
            String attributeValue = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType != 2) {
                    if (eventType != 3) {
                        if (eventType == 4 && attributeValue != null) {
                            sb2.append(xmlPullParserNewPullParser.getText());
                        }
                    } else if (g.b(xmlPullParserNewPullParser.getName(), "string") && attributeValue != null) {
                        String string = sb2.toString();
                        g.e(string, "toString(...)");
                        map.put(attributeValue, q.L0(string).toString());
                        attributeValue = null;
                    }
                } else if (g.b(xmlPullParserNewPullParser.getName(), "string")) {
                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "name");
                    sb2.setLength(0);
                }
            }
            n nVar = n.f10413a;
            fileInputStream.close();
            return map;
        } finally {
        }
    }

    public final String pickDisplayName$common_release(String otaId, String str, String str2) {
        g.f(otaId, "otaId");
        String str3 = null;
        if (str != null) {
            if (q.t0(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        if (str2 != null) {
            if (q.t0(str2)) {
                str2 = null;
            }
            str3 = str2;
        }
        return str3 == null ? otaId : str3;
    }

    public final File pickStringsFile(Context context, String displayDir) {
        Object obj;
        g.f(context, "context");
        g.f(displayDir, "displayDir");
        List<String> listPickValuesDirs = pickValuesDirs(context);
        ArrayList arrayList = new ArrayList(m.Z(listPickValuesDirs, 10));
        Iterator<T> it = listPickValuesDirs.iterator();
        while (it.hasNext()) {
            arrayList.add(new File(displayDir, a.j((String) it.next(), "/strings.xml")));
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i10);
            i10++;
            if (((File) obj).isFile()) {
                break;
            }
        }
        return (File) obj;
    }

    public final List<String> pickValuesDirs(Context context) {
        g.f(context, "context");
        Locale locale = context.getResources().getConfiguration().getLocales().get(0);
        if (locale == null) {
            return b1.P(DEFAULT_VALUES_DIR);
        }
        String language = locale.getLanguage();
        g.e(language, "getLanguage(...)");
        Locale ROOT = Locale.ROOT;
        g.e(ROOT, "ROOT");
        String lowerCase = language.toLowerCase(ROOT);
        g.e(lowerCase, "toLowerCase(...)");
        String country = locale.getCountry();
        g.e(country, "getCountry(...)");
        String upperCase = country.toUpperCase(ROOT);
        g.e(upperCase, "toUpperCase(...)");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!q.t0(upperCase)) {
            linkedHashSet.add("values-" + lowerCase + "-r" + upperCase);
        }
        if (lowerCase.equals("zh") && q.t0(upperCase)) {
            linkedHashSet.add("values-zh-rCN");
        }
        linkedHashSet.add("values-".concat(lowerCase));
        linkedHashSet.add(DEFAULT_VALUES_DIR);
        return kotlin.collections.a.O0(linkedHashSet);
    }

    public final String resolveDisplayName(Context context, String otaId, String str) {
        g.f(context, "context");
        g.f(otaId, "otaId");
        return pickDisplayName$common_release(otaId, readPackTitle(context, str), AbilityCatalogNames.INSTANCE.nameForModelId(context, otaId));
    }
}
