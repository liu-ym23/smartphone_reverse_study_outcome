package com.jeffmony.async.http;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Multimap extends LinkedHashMap<String, List<String>> implements Iterable<NameValuePair> {
    public static final StringDecoder QUERY_DECODER = null;
    public static final StringDecoder URL_DECODER = null;

    public interface StringDecoder {
        String decode(String r10);
    }

    public static class a implements StringDecoder {
        public a() {
        }

        @Override // com.jeffmony.async.http.Multimap.StringDecoder
        public String decode(String r10) {
            return Uri.decode(r10);
        }
    }

    public static class b implements StringDecoder {
        public b() {
        }

        @Override // com.jeffmony.async.http.Multimap.StringDecoder
        public String decode(String r10) {
            return URLDecoder.decode(r10);
        }
    }

    static {
        QUERY_DECODER = new a();
        URL_DECODER = new b();
    }

    public Multimap() {
    }

    public static Multimap parse(String r10, String r11, boolean r12, StringDecoder r13) {
        return parse(r10, r11, "=", r12, r13);
    }

    public static Multimap parseCommaDelimited(String r10) {
        return parse(r10, ",", true, null);
    }

    public static Multimap parseQuery(String r10) {
        return parse(r10, "&", false, QUERY_DECODER);
    }

    public static Multimap parseSemicolonDelimited(String r10) {
        return parse(r10, ";", true, null);
    }

    public static Multimap parseUrlEncoded(String r10) {
        return parse(r10, "&", false, URL_DECODER);
    }

    public void add(String r10, String r11) {
        ensure(r10).add(r11);
    }

    public List<String> ensure(String r10) {
        List<String> r11 = get(r10);
        if (r11 != null) goto L6;
        List<String> r12 = newList();
        put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    public String getAllString(String r10, String r11) {
        List<String> r12 = get(r10);
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.size() == 0) goto L21;
        StringBuilder r13 = new StringBuilder();
        Iterator<String> r14 = r12.iterator();
        boolean r15 = true;
    L9:
        if (r14.hasNext() == false) goto L15;
        String r16 = r14.next();
        if (r15 == true) goto L13;
        r13.append(r11);
    L13:
        r13.append(r16);
        r15 = false;
        goto L9
    L15:
        return r13.toString();
    L21:
        return null;
    }

    public String getString(String r10) {
        List<String> r11 = get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.size() != 0) goto L8;
        return null;
    L8:
        return r11.get(0);
    }

    @Override // java.lang.Iterable
    public Iterator<NameValuePair> iterator() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        String r12 = (String) r11.next();
        Iterator r13 = ((List) get(r12)).iterator();
    L7:
        if (r13.hasNext() == false) goto L4;
        r10.add(new com.jeffmony.async.http.b(r12, (String) r13.next()));
        goto L7
    L10:
        return r10.iterator();
    }

    public List<String> newList() {
        return new ArrayList();
    }

    public void put(String r10, String r11) {
        List<String> r12 = newList();
        r12.add(r11);
        put(r10, r12);
    }

    public Map<String, String> toSingleMap() {
        HashMap r10 = new HashMap();
        Iterator<String> r11 = keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();
        r10.put(r12, getString(r12));
        goto L4
    L6:
        return r10;
    }

    public Multimap(List<NameValuePair> r10) {
        Iterator<NameValuePair> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        NameValuePair r12 = r11.next();
        add(r12.getName(), r12.getValue());
        goto L4
    }

    public static Multimap parse(String r10, String r11, String r12, boolean r13, StringDecoder r14) {
        Multimap r15 = new Multimap();
        if (r10 != null) goto L5;
        return r15;
    L5:
        String[] r16 = r10.split(r11);
        int r17 = r16.length;
        int r18 = 0;
    L6:
        if (r18 >= r17) goto L26;
        String[] r19 = r16[r18].split(r12, 2);
        String r20 = r19[0].trim();
        if (TextUtils.isEmpty(r20) == true) goto L25;
        if (r19.length <= 1) goto L13;
        String r21 = r19[1];
    L14:
        if (r21 == null) goto L21;
        if (r13 == false) goto L21;
        if (r21.endsWith("\"") == false) goto L21;
        if (r21.startsWith("\"") == false) goto L21;
        r21 = r21.substring(1, r21.length() - 1);
    L21:
        if (r21 == null) goto L24;
        if (r14 == null) goto L24;
        r20 = r14.decode(r20);
        r21 = r14.decode(r21);
    L24:
        r15.add(r20, r21);
        goto L25
    L13:
        r21 = null;
    L25:
        r18 = r18 + 1;
        goto L6
    L26:
        return r15;
    }

    public Multimap(Multimap r10) {
        putAll(r10);
    }
}
