package com.byted.cast.linkcommon.cybergarage.upnp.xml;

import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ControlResponse;

/* JADX INFO: loaded from: classes28.dex */
public class ActionData extends NodeData {
    private ActionListener actionListener;
    private ControlResponse ctrlRes;

    public ActionData() {
        this.actionListener = null;
        this.ctrlRes = null;
    }

    public ActionListener getActionListener() {
        return this.actionListener;
    }

    public ControlResponse getControlResponse() {
        return this.ctrlRes;
    }

    public void setActionListener(ActionListener r100) {
        this.actionListener = r100;
    }

    public void setControlResponse(ControlResponse r100) {
        this.ctrlRes = r100;
    }
}
