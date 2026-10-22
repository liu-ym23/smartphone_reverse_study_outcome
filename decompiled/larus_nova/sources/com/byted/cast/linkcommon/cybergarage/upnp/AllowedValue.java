package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.linkcommon.cybergarage.xml.Node;

/* JADX INFO: loaded from: classes28.dex */
public class AllowedValue {
    public static final String ELEM_NAME = "allowedValue";
    private Node allowedValueNode;

    public String getValue() {
        return getAllowedValueNode().getValue();
    }

    public Node getAllowedValueNode() {
        return this.allowedValueNode;
    }

    public AllowedValue(String r100) {
        this.allowedValueNode = new Node(ELEM_NAME);
        setValue(r100);
    }

    public static boolean isAllowedValueNode(Node r100) {
        return ELEM_NAME.equals(r100.getName());
    }

    public void setValue(String r100) {
        getAllowedValueNode().setValue(r100);
    }

    public AllowedValue(Node r100) {
        this.allowedValueNode = r100;
    }
}
