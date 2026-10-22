package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> excludes;
    private final Set<String> includes;
    private int maxLevel;

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Set<String> getExcludes() {
        return this.excludes;
    }

    public Set<String> getIncludes() {
        return this.includes;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public SimplePropertyPreFilter(String... r100) {
        this(null, r100);
    }

    public void setMaxLevel(int r100) {
        this.maxLevel = r100;
    }

    public SimplePropertyPreFilter(Class<?> r100, String... r101) {
        this.includes = new HashSet();
        this.excludes = new HashSet();
        int r102 = 0;
        this.maxLevel = 0;
        this.clazz = r100;
        int r103 = r101.length;
    L3:
        if (r102 >= r103) goto L8;
        String r104 = r101[r102];
        if (r104 == null) goto L7;
        this.includes.add(r104);
    L7:
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.alibaba.fastjson.serializer.PropertyPreFilter
    public boolean apply(JSONSerializer r100, Object r101, String r102) {
        if (r101 != null) goto L5;
        return true;
    L5:
        Class<?> r103 = this.clazz;
        if (r103 == null) goto L11;
        if (r103.isInstance(r101) == true) goto L11;
        return true;
    L11:
        if (this.excludes.contains(r102) == false) goto L14;
        return false;
    L14:
        if (this.maxLevel <= 0) goto L22;
        SerialContext r104 = r100.context;
        int r105 = 0;
    L16:
        if (r104 == null) goto L22;
        r105 = r105 + 1;
        if (r105 > this.maxLevel) goto L19;
        r104 = r104.parent;
        goto L16
    L19:
        return false;
    L22:
        if (this.includes.size() != 0) goto L24;
        return true;
    L24:
        if (this.includes.contains(r102) == true) goto L31;
        return false;
    L31:
        return true;
    }
}
