package com.byted.cast.linkcommon.cybergarage.upnp;

import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class ActionList extends Vector {
    public static final String ELEM_NAME = "actionList";

    public ActionList() {
    }

    public Action getAction(int r100) {
        return (Action) get(r100);
    }
}
