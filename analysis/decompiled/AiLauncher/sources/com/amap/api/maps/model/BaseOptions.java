package com.amap.api.maps.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BaseOptions {
    protected Object Field1;
    protected Object Field2;
    protected Map<String, Object> jsonMap = new HashMap();
    private Map<String, Object> lastJsonMap = new HashMap();
    protected String type;

    public void addIfPresent(String str, Object obj) {
        addIfPresent(str, obj, false);
    }

    public Object method1(Object... objArr) {
        return null;
    }

    public Object method2(Object... objArr) {
        return null;
    }

    public String toJson() {
        return toString();
    }

    public void addIfPresent(String str, Object obj, boolean z10) {
        if (obj != null) {
            if (z10 || obj.equals(this.type) || !obj.equals(this.lastJsonMap.get(str))) {
                this.jsonMap.put(str, obj);
                this.lastJsonMap.put(str, obj);
            }
        }
    }
}
