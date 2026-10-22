package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.common.ContextManager;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class ArgumentList extends Vector {
    public static final String ELEM_NAME = "argumentList";
    private ContextManager.CastContext mCastContext;

    public ArgumentList(ContextManager.CastContext r100) {
        this.mCastContext = r100;
    }

    public Argument getArgument(String r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        Argument r103 = getArgument(r102);
        String r104 = r103.getName();
        if (r104 == null) goto L10;
        if (r104.equals(r100) != true) goto L10;
        return r103;
    L10:
        r102 = r102 + 1;
        goto L3
    L11:
        return null;
    }

    public void set(ArgumentList r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        Argument r103 = r100.getArgument(r102);
        Argument r104 = getArgument(r103.getName());
        if (r104 == null) goto L8;
        r104.setValue(r103.getValue());
    L8:
        r102 = r102 + 1;
        goto L3
    }

    public void setReqArgs(ArgumentList r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        Argument r103 = getArgument(r102);
        if (r103.isInDirection() == false) goto L10;
        Argument r104 = r100.getArgument(r103.getName());
        if (r104 != null) goto L9;
        r103.setValue("");
        goto L10
    L9:
        r103.setValue(r104.getValue());
    L10:
        r102 = r102 + 1;
        goto L3
    }

    public void setResArgs(ArgumentList r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        Argument r103 = getArgument(r102);
        if (r103.isOutDirection() == false) goto L11;
        String r104 = r103.getName();
        Argument r105 = r100.getArgument(r104);
        if (r105 == null) goto L10;
        r103.setValue(r105.getValue());
        goto L11
    L10:
        throw new IllegalArgumentException("Argument \"" + r104 + "\" missing.");
    L11:
        r102 = r102 + 1;
        goto L3
    }

    public Argument getArgument(int r100) {
        return (Argument) get(r100);
    }
}
