package cn.jzvd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class JZDataSource {
    public static final String URL_KEY_DEFAULT = "URL_KEY_DEFAULT";
    public int currentUrlIndex;
    public HashMap headerMap;
    public boolean looping;
    public Object[] objects;
    public String title;
    public LinkedHashMap urlsMap;

    public JZDataSource(String r10) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap();
        this.looping = false;
        this.urlsMap.put(URL_KEY_DEFAULT, r10);
        this.currentUrlIndex = 0;
    }

    public boolean containsTheUrl(Object r10) {
        if (r10 != null) goto L4;
        return false;
    L4:
        return this.urlsMap.containsValue(r10);
    }

    public Object getCurrentKey() {
        return getKeyFromDataSource(this.currentUrlIndex);
    }

    public Object getCurrentUrl() {
        Object r10 = getValueFromLinkedMap(this.currentUrlIndex);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return "";
    }

    public String getDefaultUrl() {
        return String.valueOf(this.urlsMap.get(URL_KEY_DEFAULT));
    }

    public String getKeyFromDataSource(int r10) {
        Iterator r11 = this.urlsMap.keySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r13 = r11.next();
        if (r12 == r10) goto L8;
        r12 = r12 + 1;
        goto L4
    L8:
        return r13.toString();
    L10:
        return null;
    }

    public Object getValueFromLinkedMap(int r10) {
        Iterator r11 = this.urlsMap.keySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r13 = r11.next();
        if (r12 == r10) goto L8;
        r12 = r12 + 1;
        goto L4
    L8:
        return this.urlsMap.get(r13);
    L10:
        return null;
    }

    public JZDataSource(String r10, String r11) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap();
        this.looping = false;
        this.urlsMap.put(URL_KEY_DEFAULT, r10);
        this.title = r11;
        this.currentUrlIndex = 0;
    }

    public JZDataSource(Object r10) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap();
        this.looping = false;
        this.urlsMap.put(URL_KEY_DEFAULT, r10);
        this.currentUrlIndex = 0;
    }

    public JZDataSource(LinkedHashMap r10) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap();
        this.looping = false;
        this.urlsMap.clear();
        this.urlsMap.putAll(r10);
        this.currentUrlIndex = 0;
    }

    public JZDataSource(LinkedHashMap r10, String r11) {
        this.urlsMap = new LinkedHashMap();
        this.title = "";
        this.headerMap = new HashMap();
        this.looping = false;
        this.urlsMap.clear();
        this.urlsMap.putAll(r10);
        this.title = r11;
        this.currentUrlIndex = 0;
    }
}
