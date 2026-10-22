package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.linkcommon.cybergarage.xml.Node;

/* JADX INFO: loaded from: classes28.dex */
public class AllowedValueRange {
    public static final String ELEM_NAME = "allowedValueRange";
    private static final String MAXIMUM = "maximum";
    private static final String MINIMUM = "minimum";
    private static final String STEP = "step";
    private Node allowedValueRangeNode;

    public AllowedValueRange() {
        this.allowedValueRangeNode = new Node(ELEM_NAME);
    }

    public String getMaximum() {
        return getAllowedValueRangeNode().getNodeValue(MAXIMUM);
    }

    public String getMinimum() {
        return getAllowedValueRangeNode().getNodeValue(MINIMUM);
    }

    public String getStep() {
        return getAllowedValueRangeNode().getNodeValue("step");
    }

    public Node getAllowedValueRangeNode() {
        return this.allowedValueRangeNode;
    }

    public AllowedValueRange(Node r100) {
        this.allowedValueRangeNode = r100;
    }

    public static boolean isAllowedValueRangeNode(Node r100) {
        return ELEM_NAME.equals(r100.getName());
    }

    public void setMaximum(String r100) {
        getAllowedValueRangeNode().setNode(MAXIMUM, r100);
    }

    public void setMinimum(String r100) {
        getAllowedValueRangeNode().setNode(MINIMUM, r100);
    }

    public void setStep(String r100) {
        getAllowedValueRangeNode().setNode("step", r100);
    }

    public AllowedValueRange(Number r100, Number r101, Number r102) {
        this.allowedValueRangeNode = new Node(ELEM_NAME);
        if (r100 == null) goto L5;
        setMaximum(r100.toString());
    L5:
        if (r101 == null) goto L7;
        setMinimum(r101.toString());
    L7:
        if (r102 == null) goto L10;
        setStep(r102.toString());
        return;
    }
}
