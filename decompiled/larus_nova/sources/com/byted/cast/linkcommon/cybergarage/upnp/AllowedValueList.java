package com.byted.cast.linkcommon.cybergarage.upnp;

import java.util.Iterator;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class AllowedValueList extends Vector {
    public static final String ELEM_NAME = "allowedValueList";

    public AllowedValueList() {
    }

    public AllowedValueList(String[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        add(new AllowedValue(r100[r101]));
        r101 = r101 + 1;
        goto L4
    }

    public AllowedValue getAllowedValue(int r100) {
        return (AllowedValue) get(r100);
    }

    public boolean isAllowed(String r100) {
        Iterator r101 = iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (((AllowedValue) r101.next()).getValue().equals(r100) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
