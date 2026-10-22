package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SimplePropertyPreFilter implements PropertyPreFilter {
    private final Class<?> clazz;
    private final Set<String> excludes;
    private final Set<String> includes;
    private int maxLevel;

    public SimplePropertyPreFilter(String... r10) {
        this(null, r10);
    }

    @Override // com.alibaba.fastjson.serializer.PropertyPreFilter
    public boolean apply(JSONSerializer r10, Object r11, String r12) {
        if (r11 != null) goto L5;
        return true;
    L5:
        Class<?> r13 = this.clazz;
        if (r13 == null) goto L11;
        if (r13.isInstance(r11) == true) goto L11;
        return true;
    L11:
        if (this.excludes.contains(r12) == false) goto L14;
        return false;
    L14:
        if (this.maxLevel <= 0) goto L22;
        SerialContext r14 = r10.context;
        int r15 = 0;
    L16:
        if (r14 == null) goto L22;
        r15 = r15 + 1;
        if (r15 > this.maxLevel) goto L19;
        r14 = r14.parent;
        goto L16
    L19:
        return false;
    L22:
        if (this.includes.size() != 0) goto L24;
    L27:
        return true;
    L24:
        if (this.includes.contains(r12) == true) goto L27;
        return false;
    }

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

    public void setMaxLevel(int r10) {
        this.maxLevel = r10;
    }

    public SimplePropertyPreFilter(Class<?> r10, String... r11) {
        this.includes = new HashSet();
        this.excludes = new HashSet();
        int r12 = 0;
        this.maxLevel = 0;
        this.clazz = r10;
        int r13 = r11.length;
    L3:
        if (r12 >= r13) goto L8;
        String r14 = r11[r12];
        if (r14 == null) goto L7;
        this.includes.add(r14);
    L7:
        r12 = r12 + 1;
        goto L3
    }
}
