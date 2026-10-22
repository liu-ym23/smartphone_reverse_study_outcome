package com.byted.cast.linkcommon.cybergarage.upnp;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class IconList extends Vector {
    public static final String ELEM_NAME = "iconList";

    public IconList() {
    }

    public Icon getIcon(int r100) {
        return (Icon) get(r100);
    }
}
