package com.byted.cast.linkcommon.cybergarage.upnp.xml;

import com.byted.cast.linkcommon.cybergarage.upnp.event.SubscriberList;
import com.byted.cast.linkcommon.cybergarage.util.ListenerList;
import com.byted.cast.linkcommon.cybergarage.xml.Node;

/* JADX INFO: loaded from: classes28.dex */
public class ServiceData extends NodeData {
    private ListenerList controlActionListenerList;
    private String descriptionURL;
    private Node scpdNode;
    private String sid;
    private SubscriberList subscriberList;
    private long timeout;

    public ServiceData() {
        this.controlActionListenerList = new ListenerList();
        this.scpdNode = null;
        this.subscriberList = new SubscriberList();
        this.descriptionURL = "";
        this.sid = "";
        this.timeout = 0;
    }

    public ListenerList getControlActionListenerList() {
        return this.controlActionListenerList;
    }

    public String getDescriptionURL() {
        return this.descriptionURL;
    }

    public Node getSCPDNode() {
        return this.scpdNode;
    }

    public String getSID() {
        return this.sid;
    }

    public SubscriberList getSubscriberList() {
        return this.subscriberList;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public void setDescriptionURL(String r100) {
        this.descriptionURL = r100;
    }

    public void setSCPDNode(Node r100) {
        this.scpdNode = r100;
    }

    public void setSID(String r100) {
        this.sid = r100;
    }

    public void setTimeout(long r100) {
        this.timeout = r100;
    }
}
