package com.byted.cast.linkcommon.cybergarage.http;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class ParameterList extends Vector {
    public ParameterList() {
    }

    public Parameter at(int r100) {
        return (Parameter) get(r100);
    }

    public Parameter getParameter(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L11;
        Parameter r103 = at(r102);
        if (r100.compareTo(r103.getName()) == 0) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return r103;
    L11:
        return null;
    }

    public String getValue(String r100) {
        Parameter r101 = getParameter(r100);
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getValue();
    }

    public Parameter getParameter(int r100) {
        return (Parameter) get(r100);
    }
}
