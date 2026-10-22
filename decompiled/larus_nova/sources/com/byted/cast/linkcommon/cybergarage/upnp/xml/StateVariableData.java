package com.byted.cast.linkcommon.cybergarage.upnp.xml;

import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryResponse;

/* JADX INFO: loaded from: classes28.dex */
public class StateVariableData extends NodeData {
    private QueryListener queryListener;
    private QueryResponse queryRes;
    private String value;

    public StateVariableData() {
        this.value = "";
        this.queryListener = null;
        this.queryRes = null;
    }

    public QueryListener getQueryListener() {
        return this.queryListener;
    }

    public QueryResponse getQueryResponse() {
        return this.queryRes;
    }

    public String getValue() {
        return this.value;
    }

    public void setQueryListener(QueryListener r100) {
        this.queryListener = r100;
    }

    public void setQueryResponse(QueryResponse r100) {
        this.queryRes = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }
}
