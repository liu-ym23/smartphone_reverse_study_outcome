package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.control.QueryResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.xml.NodeData;
import com.byted.cast.linkcommon.cybergarage.upnp.xml.StateVariableData;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class StateVariable extends NodeData {
    private static final String DATATYPE = "dataType";
    private static final String DEFAULT_VALUE = "defaultValue";
    public static final String ELEM_NAME = "stateVariable";
    private static final String NAME = "name";
    private static final String SENDEVENTS = "sendEvents";
    private static final String SENDEVENTS_NO = "no";
    private static final String SENDEVENTS_YES = "yes";
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private CastMonitor mMonitor;
    private Node serviceNode;
    private Node stateVariableNode;
    private UPnPStatus upnpStatus;
    private Object userData;

    public AllowedValueList getAllowedValueList() {
        AllowedValueList r100 = new AllowedValueList();
        Node r101 = getStateVariableNode().getNode(AllowedValueList.ELEM_NAME);
        if (r101 != null) goto L6;
        return null;
    L6:
        int r102 = r101.getNNodes();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L13;
        Node r104 = r101.getNode(r103);
        if (AllowedValue.isAllowedValueNode(r104) == false) goto L12;
        r100.add(new AllowedValue(r104));
    L12:
        r103 = r103 + 1;
        goto L7
    L13:
        return r100;
    }

    public boolean postQuerylAction() {
        QueryRequest r100 = new QueryRequest(this.mCastContext);
        r100.setRequest(this);
        if (Debug.isOn() != true) goto L5;
        r100.print();
    L5:
        QueryResponse r101 = r100.post();
        if (Debug.isOn() != true) goto L8;
        r101.print();
    L8:
        setQueryResponse(r101);
        if (r101.isSuccessful() == true) goto L12;
        setValue(r101.getReturnValue());
        return false;
    L12:
        setValue(r101.getReturnValue());
        return true;
    }

    public AllowedValueRange getAllowedValueRange() {
        Node r100 = getStateVariableNode().getNode(AllowedValueRange.ELEM_NAME);
        if (r100 != null) goto L7;
        return null;
    L7:
        return new AllowedValueRange(r100);
    }

    public String getDataType() {
        return getStateVariableNode().getNodeValue(DATATYPE);
    }

    public String getDefaultValue() {
        return getStateVariableNode().getNodeValue(DEFAULT_VALUE);
    }

    public String getName() {
        return getStateVariableNode().getNodeValue("name");
    }

    public QueryListener getQueryListener() {
        return getStateVariableData().getQueryListener();
    }

    public QueryResponse getQueryResponse() {
        return getStateVariableData().getQueryResponse();
    }

    public UPnPStatus getQueryStatus() {
        return getQueryResponse().getUPnPError();
    }

    public Service getService() {
        Node r100 = getServiceNode();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new Service(this.mCastContext, r100);
    }

    public StateVariableData getStateVariableData() {
        Node r100 = getStateVariableNode();
        StateVariableData r101 = (StateVariableData) r100.getUserData();
        if (r101 != null) goto L6;
        StateVariableData r102 = new StateVariableData();
        r100.setUserData(r102);
        r102.setNode(r100);
        return r102;
    L6:
        return r101;
    }

    public String getValue() {
        return getStateVariableData().getValue();
    }

    public boolean hasAllowedValueList() {
        if (getAllowedValueList() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasAllowedValueRange() {
        if (getAllowedValueRange() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSendEvents() {
        String r100 = getStateVariableNode().getAttributeValue(SENDEVENTS);
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.equalsIgnoreCase("yes") != true) goto L8;
        return true;
    L8:
        return false;
    }

    public Node getServiceNode() {
        return this.serviceNode;
    }

    public Node getStateVariableNode() {
        return this.stateVariableNode;
    }

    public UPnPStatus getStatus() {
        return this.upnpStatus;
    }

    public Object getUserData() {
        return this.userData;
    }

    public StateVariable(ContextManager.CastContext r100) {
        this.upnpStatus = new UPnPStatus();
        this.userData = null;
        this.serviceNode = null;
        this.stateVariableNode = new Node(ELEM_NAME);
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(this.mCastContext);
    }

    public static boolean isStateVariableNode(Node r100) {
        return ELEM_NAME.equals(r100.getName());
    }

    private void setQueryResponse(QueryResponse r100) {
        getStateVariableData().setQueryResponse(r100);
    }

    public boolean performQueryListener(QueryRequest r100) {
        QueryListener r101 = getQueryListener();
        if (r101 != null) goto L6;
        return false;
    L6:
        QueryResponse r102 = new QueryResponse(this.mCastContext);
        StateVariable r103 = new StateVariable(this.mCastContext);
        r103.set(this);
        r103.setValue("");
        r103.setStatus(404);
        if (r101.queryControlReceived(r103) != true) goto L9;
        r102.setResponse(r103);
    L10:
        r100.post(r102);
        return true;
    L9:
        UPnPStatus r104 = r103.getStatus();
        r102.setFaultResponse(r104.getCode(), r104.getDescription());
        goto L10
    }

    public void set(StateVariable r100) {
        setName(r100.getName());
        setValue(r100.getValue());
        setDataType(r100.getDataType());
        setSendEvents(r100.isSendEvents());
    }

    public void setAllowedValueList(AllowedValueList r100) {
        getStateVariableNode().removeNode(AllowedValueList.ELEM_NAME);
        getStateVariableNode().removeNode(AllowedValueRange.ELEM_NAME);
        Node r101 = new Node(AllowedValueList.ELEM_NAME);
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.addNode(((AllowedValue) r102.next()).getAllowedValueNode());
        goto L4
    L6:
        getStateVariableNode().addNode(r101);
    }

    public void setAllowedValueRange(AllowedValueRange r100) {
        getStateVariableNode().removeNode(AllowedValueList.ELEM_NAME);
        getStateVariableNode().removeNode(AllowedValueRange.ELEM_NAME);
        getStateVariableNode().addNode(r100.getAllowedValueRangeNode());
    }

    public void setDataType(String r100) {
        getStateVariableNode().setNode(DATATYPE, r100);
    }

    public void setDefaultValue(String r100) {
        getStateVariableNode().setNode(DEFAULT_VALUE, r100);
    }

    public void setName(String r100) {
        getStateVariableNode().setNode("name", r100);
    }

    public void setQueryListener(QueryListener r100) {
        getStateVariableData().setQueryListener(r100);
    }

    public void setSendEvents(boolean r100) {
        Node r101 = getStateVariableNode();
        if (r100 != true) goto L5;
        String r102 = "yes";
    L6:
        r101.setAttribute(SENDEVENTS, r102);
        return;
    L5:
        r102 = "no";
        goto L6
    }

    public void setServiceNode(Node r100) {
        this.serviceNode = r100;
    }

    public void setStatus(int r100) {
        setStatus(r100, UPnPStatus.code2String(r100));
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public void setValue(String r100) {
        String r101 = getStateVariableData().getValue();
        if (r101 != null) goto L5;
    L7:
        getStateVariableData().setValue(r100);
        Service r102 = getService();
        if (r102 != null) goto L11;
        return;
    L11:
        if (isSendEvents() == true) goto L13;
        return;
    L13:
        r102.notify(this);
        this.mMonitor.sendEvent(r100);
        return;
    L5:
        if (r101.equals(r100) != true) goto L7;
    }

    public void setValue(int r100) {
        setValue(Integer.toString(r100));
    }

    public void setValue(long r100) {
        setValue(Long.toString(r100));
    }

    public void setStatus(int r100, String r101) {
        this.upnpStatus.setCode(r100);
        this.upnpStatus.setDescription(r101);
    }

    public StateVariable(ContextManager.CastContext r100, Node r101, Node r102) {
        this.upnpStatus = new UPnPStatus();
        this.userData = null;
        this.serviceNode = r101;
        this.stateVariableNode = r102;
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(this.mCastContext);
    }
}
