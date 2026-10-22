package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.upnp.xml.ArgumentData;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes28.dex */
public class Argument {
    private static final String DIRECTION = "direction";
    public static final String ELEM_NAME = "argument";
    public static final String IN = "in";
    private static final String NAME = "name";
    public static final String OUT = "out";
    private static final String RELATED_STATE_VARIABLE = "relatedStateVariable";
    private Node argumentNode;
    private ContextManager.CastContext mCastContext;
    private Node serviceNode;
    private Object userData;

    public Action getAction() {
        return new Action(this.mCastContext, getServiceNode(), getActionNode());
    }

    public Service getService() {
        return new Service(this.mCastContext, getServiceNode());
    }

    private ArgumentData getArgumentData() {
        Node r100 = getArgumentNode();
        ArgumentData r101 = (ArgumentData) r100.getUserData();
        if (r101 != null) goto L6;
        ArgumentData r102 = new ArgumentData();
        r100.setUserData(r102);
        r102.setNode(r100);
        return r102;
    L6:
        return r101;
    }

    public Node getActionNode() {
        Node r100 = getArgumentNode().getParentNode();
        if (r100 != null) goto L5;
        return null;
    L5:
        Node r101 = r100.getParentNode();
        if (r101 != null) goto L9;
        return null;
    L9:
        if (Action.isActionNode(r101) == true) goto L11;
        return null;
    L11:
        return r101;
    }

    public String getDirection() {
        return getArgumentNode().getNodeValue("direction");
    }

    public int getIntegerValue() {
        return CastIntegerProtector.parseInt(getValue());
    L5:
        return 0;
    }

    public String getName() {
        return getArgumentNode().getNodeValue("name");
    }

    public StateVariable getRelatedStateVariable() {
        Service r100 = getService();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getStateVariable(getRelatedStateVariableName());
    }

    public String getRelatedStateVariableName() {
        return getArgumentNode().getNodeValue(RELATED_STATE_VARIABLE);
    }

    public String getValue() {
        return getArgumentData().getValue();
    }

    public boolean isInDirection() {
        String r100 = getDirection();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.equalsIgnoreCase("in");
    }

    public boolean isOutDirection() {
        return !isInDirection();
    }

    private Node getServiceNode() {
        return this.serviceNode;
    }

    public Node getArgumentNode() {
        return this.argumentNode;
    }

    public Object getUserData() {
        return this.userData;
    }

    public Argument(ContextManager.CastContext r100) {
        this.userData = null;
        this.argumentNode = new Node("argument");
        this.serviceNode = null;
        this.mCastContext = r100;
    }

    public static boolean isArgumentNode(Node r100) {
        return "argument".equals(r100.getName());
    }

    public void setDirection(String r100) {
        getArgumentNode().setNode("direction", r100);
    }

    public void setName(String r100) {
        getArgumentNode().setNode("name", r100);
    }

    public void setRelatedStateVariableName(String r100) {
        getArgumentNode().setNode(RELATED_STATE_VARIABLE, r100);
    }

    public void setService(Service r100) {
        r100.getServiceNode();
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public void setValue(int r100) {
        setValue(Integer.toString(r100));
    }

    public void setValue(String r100) {
        getArgumentData().setValue(r100);
    }

    public Argument(ContextManager.CastContext r100, Node r101) {
        this.userData = null;
        this.argumentNode = new Node("argument");
        this.serviceNode = r101;
        this.mCastContext = r100;
    }

    public Argument(ContextManager.CastContext r100, String r101, String r102) {
        this.userData = null;
        this.mCastContext = r100;
        this.argumentNode = new Node("argument");
        this.serviceNode = null;
        setName(r101);
        setValue(r102);
    }

    public Argument(ContextManager.CastContext r100, Node r101, Node r102) {
        this.userData = null;
        this.serviceNode = r101;
        this.argumentNode = r102;
        this.mCastContext = r100;
    }
}
