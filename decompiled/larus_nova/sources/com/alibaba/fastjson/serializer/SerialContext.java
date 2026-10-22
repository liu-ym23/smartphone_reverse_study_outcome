package com.alibaba.fastjson.serializer;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class SerialContext {
    public final int features;
    public final Object fieldName;
    public final Object object;
    public final SerialContext parent;

    public String toString() {
        if (this.parent != null) goto L6;
        return "$";
    L6:
        StringBuilder r100 = new StringBuilder();
        toString(r100);
        return r100.toString();
    }

    public String getPath() {
        return toString();
    }

    public Object getFieldName() {
        return this.fieldName;
    }

    public Object getObject() {
        return this.object;
    }

    public SerialContext getParent() {
        return this.parent;
    }

    public void toString(StringBuilder r110) {
        SerialContext r100 = this.parent;
        if (r100 != null) goto L5;
        r110.append(Typography.dollar);
        return;
    L5:
        r100.toString(r110);
        Object r101 = this.fieldName;
        if (r101 != null) goto L9;
        r110.append(".null");
        return;
    L9:
        if ((r101 instanceof Integer) == false) goto L11;
        r110.append('[');
        r110.append(((Integer) this.fieldName).intValue());
        r110.append(']');
        return;
    L11:
        r110.append('.');
        String r102 = this.fieldName.toString();
        int r103 = 0;
        int r104 = 0;
    L13:
        if (r104 >= r102.length()) goto L24;
        char r105 = r102.charAt(r104);
        if (r105 < '0') goto L17;
        if (r105 > '9') goto L17;
    L22:
        r104 = r104 + 1;
    L17:
        if (r105 < 'A') goto L19;
        if (r105 <= 'Z') goto L22;
    L19:
        if (r105 < 'a') goto L21;
        if (r105 <= 'z') goto L22;
    L21:
        if (r105 > 128) goto L22;
        boolean r106 = true;
    L25:
        if (r106 == true) goto L27;
        r110.append(r102);
        return;
    L27:
        if (r103 >= r102.length()) goto L59;
        char r107 = r102.charAt(r103);
        if (r107 != '\\') goto L31;
        r110.append('\\');
        r110.append('\\');
        r110.append('\\');
    L43:
        r110.append(r107);
    L44:
        r103 = r103 + 1;
        goto L27
    L31:
        if (r107 < '0') goto L33;
        if (r107 > '9') goto L33;
    L38:
        r110.append(r107);
    L33:
        if (r107 < 'A') goto L35;
        if (r107 <= 'Z') goto L38;
    L35:
        if (r107 < 'a') goto L37;
        if (r107 <= 'z') goto L38;
    L37:
        if (r107 > 128) goto L38;
        if (r107 != '\"') goto L42;
        r110.append('\\');
        r110.append('\\');
        r110.append('\\');
        goto L43
    L42:
        r110.append('\\');
        r110.append('\\');
        goto L43
    L59:
        return;
    L24:
        r106 = false;
        goto L25
    }

    public SerialContext(SerialContext r100, Object r101, Object r102, int r103, int r104) {
        this.parent = r100;
        this.object = r101;
        this.fieldName = r102;
        this.features = r103;
    }
}
