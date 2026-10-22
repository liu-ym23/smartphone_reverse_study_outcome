package com.byted.cast.linkcommon.cybergarage.upnp;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class ServiceStateTable extends Vector {
    public static final String ELEM_NAME = "serviceStateTable";

    public ServiceStateTable() {
    }

    public StateVariable getStateVariable(int r100) {
        return (StateVariable) get(r100);
    }
}
