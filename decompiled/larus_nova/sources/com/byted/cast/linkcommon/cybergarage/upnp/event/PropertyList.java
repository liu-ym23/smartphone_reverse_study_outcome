package com.byted.cast.linkcommon.cybergarage.upnp.event;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class PropertyList extends Vector {
    public static final String ELEM_NAME = "PropertyList";

    public PropertyList() {
    }

    public Property getProperty(int r100) {
        return (Property) get(r100);
    }
}
