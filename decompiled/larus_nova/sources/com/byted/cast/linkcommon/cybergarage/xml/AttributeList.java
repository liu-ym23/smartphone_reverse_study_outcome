package com.byted.cast.linkcommon.cybergarage.xml;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class AttributeList extends Vector {
    public AttributeList() {
    }

    public Attribute getAttribute(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        Attribute r103 = getAttribute(r102);
        if (r100.compareTo(r103.getName()) == 0) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return r103;
    L11:
        return null;
    }

    public Attribute getAttribute(int r100) {
        return (Attribute) get(r100);
    }
}
