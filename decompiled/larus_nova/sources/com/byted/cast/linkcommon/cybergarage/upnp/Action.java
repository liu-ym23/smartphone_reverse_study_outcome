package com.byted.cast.linkcommon.cybergarage.upnp;

import com.alipay.sdk.m.u.i;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.CommandExecuteStatus;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Utils;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionListener;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ActionResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.control.ControlResponse;
import com.byted.cast.linkcommon.cybergarage.upnp.xml.ActionData;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.byted.cast.linkcommon.cybergarage.util.Mutex;
import com.byted.cast.linkcommon.cybergarage.xml.Node;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class Action {
    public static final String ELEM_NAME = "action";
    private static final String NAME = "name";
    private Node actionNode;
    private CommandExecuteStatus commandExecuteStatus;
    private String localHostAddress;
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private CastMonitor mMonitor;
    private Mutex mutex;
    private String requestHostAddress;
    private Node serviceNode;
    private UPnPStatus upnpStatus;
    private Object userData;

    public ArgumentList getArgumentList() {
        ArgumentList r100 = new ArgumentList(this.mCastContext);
        Node r101 = getActionNode().getNode(ArgumentList.ELEM_NAME);
        if (r101 != null) goto L5;
        return r100;
    L5:
        int r102 = r101.getNNodes();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        Node r104 = r101.getNode(r103);
        if (Argument.isArgumentNode(r104) == false) goto L11;
        r100.add(new Argument(this.mCastContext, getServiceNode(), r104));
    L11:
        r103 = r103 + 1;
        goto L6
    L12:
        return r100;
    }

    public Service getService() {
        return new Service(this.mCastContext, getServiceNode());
    }

    public void lock() {
        this.mutex.lock();
    }

    public void print() {
        System.out.println("Action : " + getName());
        ArgumentList r100 = getArgumentList();
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Argument r103 = r100.getArgument(r102);
        String r104 = r103.getName();
        String r105 = r103.getValue();
        String r106 = r103.getDirection();
        System.out.println(" [" + r102 + "] = " + r106 + ", " + r104 + ", " + r105);
        r102 = r102 + 1;
        goto L3
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Action:");
        r100.append(getName());
        r100.append("{");
        ArgumentList r101 = getArgumentList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Argument r104 = r101.getArgument(r103);
        String r105 = r104.getName();
        String r106 = r104.getValue();
        r100.append(" [" + r103 + "] = " + r104.getDirection() + ", " + r105 + ", " + r106 + i.f25853b);
        r103 = r103 + 1;
        goto L3
    L5:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public void unlock() {
        this.mutex.unlock();
    }

    private void clearOutputAgumentValues() {
        ArgumentList r100 = getArgumentList();
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        Argument r103 = r100.getArgument(r102);
        if (r103.isOutDirection() == false) goto L8;
        r103.setValue("");
    L8:
        r102 = r102 + 1;
        goto L3
    }

    private ActionData getActionData() {
        Node r100 = getActionNode();
        ActionData r101 = (ActionData) r100.getUserData();
        if (r101 != null) goto L6;
        ActionData r102 = new ActionData();
        r100.setUserData(r102);
        r102.setNode(r100);
        return r102;
    L6:
        return r101;
    }

    private ControlResponse getControlResponse() {
        return getActionData().getControlResponse();
    }

    public ActionListener getActionListener() {
        return getActionData().getActionListener();
    }

    public UPnPStatus getControlStatus() {
        return getControlResponse().getUPnPError();
    }

    public ArgumentList getInputArgumentList() {
        ArgumentList r100 = getArgumentList();
        int r101 = r100.size();
        ArgumentList r102 = new ArgumentList(this.mCastContext);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L9;
        Argument r104 = r100.getArgument(r103);
        if (r104.isInDirection() == false) goto L8;
        r102.add(r104);
    L8:
        r103 = r103 + 1;
        goto L3
    L9:
        return r102;
    }

    public String getName() {
        return getActionNode().getNodeValue("name");
    }

    public ArgumentList getOutputArgumentList() {
        ArgumentList r100 = getArgumentList();
        int r101 = r100.size();
        ArgumentList r102 = new ArgumentList(this.mCastContext);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L9;
        Argument r104 = r100.getArgument(r103);
        if (r104.isOutDirection() == false) goto L8;
        r102.add(r104);
    L8:
        r103 = r103 + 1;
        goto L3
    L9:
        return r102;
    }

    public boolean postControlAction() {
        ArgumentList r100 = getArgumentList();
        ArgumentList r101 = getInputArgumentList();
        ActionRequest r102 = new ActionRequest(this.mCastContext);
        r102.setRequest(this, r101);
        boolean r103 = Utils.shouldTrackAction(r102.getActionName());
        if (r103 == false) goto L5;
        this.mMonitor.sendAction(r102.getActionName(), r102.getHeader(), r102.getContentString());
    L5:
        ActionResponse r104 = r102.post();
        if (r103 == false) goto L8;
        this.mMonitor.receiveActionResponse(r104.getStatusLineString(), r104.getHeaderString(), r104.getContentString());
    L8:
        setControlResponse(r104);
        setCommandExecuteStatus(r104.getCommandExecuteStatus());
        setStatus(r104.getStatusCode());
        if (r104.isSuccessful() == true) goto L18;
        return false;
    L18:
        r100.setResArgs(r104.getResponse());     // Catch: Exception -> L15
        return true;
    L15:
        e = move-exception;
        this.mLogger.d("postControlAction", e.getMessage());
        setStatus(402, "Action succesfully delivered but invalid arguments returned.");
        return false;
    }

    private Node getServiceNode() {
        return this.serviceNode;
    }

    public Node getActionNode() {
        return this.actionNode;
    }

    public CommandExecuteStatus getCommandExecuteStatus() {
        return this.commandExecuteStatus;
    }

    public String getRequestHostAddress() {
        return this.requestHostAddress;
    }

    public UPnPStatus getStatus() {
        return this.upnpStatus;
    }

    public Object getUserData() {
        return this.userData;
    }

    public static boolean isActionNode(Node r100) {
        return "action".equals(r100.getName());
    }

    private void setControlResponse(ControlResponse r100) {
        getActionData().setControlResponse(r100);
    }

    public Argument getArgument(String r100) {
        ArgumentList r101 = getArgumentList();
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        Argument r104 = r101.getArgument(r103);
        String r105 = r104.getName();
        if (r105 == null) goto L10;
        if (r100.equals(r105) != true) goto L10;
        return r104;
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return null;
    }

    public int getArgumentIntegerValue(String r100) {
        Argument r101 = getArgument(r100);
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getIntegerValue();
    }

    public String getArgumentValue(String r100) {
        Argument r101 = getArgument(r100);
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getValue();
    }

    public boolean performActionListener(ActionRequest r100) {
        ActionListener r101 = getActionListener();
        if (r101 != null) goto L6;
        return false;
    L6:
        ActionResponse r102 = new ActionResponse(this.mCastContext);
        setStatus(401);
        clearOutputAgumentValues();
        this.requestHostAddress = r100.getRemoteAddress();
        this.localHostAddress = r100.getLocalAddress();
        if (r101.actionControlReceived(this) == false) goto L9;
        r102.setResponse(this);
    L11:
        if (Debug.isOn() != true) goto L13;
        r102.print();
    L13:
        r100.post(r102);
        return true;
    L9:
        UPnPStatus r103 = getStatus();
        r102.setFaultResponse(r103.getCode(), r103.getDescription());
        goto L11
    }

    public void setActionListener(ActionListener r100) {
        getActionData().setActionListener(r100);
    }

    public void setArgumentList(ArgumentList r100) {
        Node r101 = getActionNode().getNode(ArgumentList.ELEM_NAME);
        if (r101 != null) goto L5;
        r101 = new Node(ArgumentList.ELEM_NAME);
        getActionNode().addNode(r101);
    L6:
        Iterator r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Argument r103 = (Argument) r102.next();
        r103.setService(getService());
        r101.addNode(r103.getArgumentNode());
        goto L8
    L10:
        return;
    L5:
        r101.removeAllNodes();
        goto L6
    }

    public void setArgumentValues(ArgumentList r100) {
        getArgumentList().set(r100);
    }

    public void setCommandExecuteStatus(CommandExecuteStatus r100) {
        this.commandExecuteStatus = r100;
    }

    public void setInArgumentValues(ArgumentList r100) {
        getArgumentList().setReqArgs(r100);
    }

    public void setName(String r100) {
        getActionNode().setNode("name", r100);
    }

    public void setOutArgumentValues(ArgumentList r100) {
        getArgumentList().setResArgs(r100);
    }

    public void setService(Service r100) {
        this.serviceNode = r100.getServiceNode();
        Iterator r101 = getArgumentList().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((Argument) r101.next()).setService(r100);
        goto L4
    }

    public void setStatus(int r100) {
        setStatus(r100, UPnPStatus.code2String(r100));
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public Action(ContextManager.CastContext r100, Action r101) {
        this.requestHostAddress = "";
        this.localHostAddress = "";
        this.mutex = new Mutex();
        this.upnpStatus = new UPnPStatus();
        this.commandExecuteStatus = new CommandExecuteStatus();
        this.userData = null;
        this.mCastContext = r100;
        this.mMonitor = ContextManager.getMonitor(r100);
        this.mLogger = ContextManager.getLogger(this.mCastContext);
        this.serviceNode = r101.getServiceNode();
        this.actionNode = r101.getActionNode();
    }

    public boolean postControlAction(String r100, int r101) {
        ArgumentList r102 = getArgumentList();
        ArgumentList r103 = getInputArgumentList();
        ActionRequest r104 = new ActionRequest(this.mCastContext);
        r104.setRequest(this, r103);
        ActionResponse r105 = r104.retryPost(r100, r101);
        setControlResponse(r105);
        setCommandExecuteStatus(r105.getCommandExecuteStatus());
        setStatus(r105.getStatusCode());
        if (r105.isSuccessful() == true) goto L12;
        return false;
    L12:
        r102.setResArgs(r105.getResponse());     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        this.mLogger.d("postControlAction", e.getMessage());
        setStatus(402, "Action succesfully delivered but invalid arguments returned.");
        return false;
    }

    public void setArgumentValue(String r100, String r101) {
        Argument r102 = getArgument(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setValue(r101);
    }

    public void setStatus(int r100, String r101) {
        this.upnpStatus.setCode(r100);
        this.upnpStatus.setDescription(r101);
    }

    public Action(ContextManager.CastContext r100, Node r101) {
        this.requestHostAddress = "";
        this.localHostAddress = "";
        this.mutex = new Mutex();
        this.upnpStatus = new UPnPStatus();
        this.commandExecuteStatus = new CommandExecuteStatus();
        this.userData = null;
        this.mCastContext = r100;
        this.mMonitor = ContextManager.getMonitor(r100);
        this.mLogger = ContextManager.getLogger(this.mCastContext);
        this.serviceNode = r101;
        this.actionNode = new Node("action");
    }

    public void setArgumentValue(String r100, int r101) {
        setArgumentValue(r100, Integer.toString(r101));
    }

    public Action(ContextManager.CastContext r100, Node r101, Node r102) {
        this.requestHostAddress = "";
        this.localHostAddress = "";
        this.mutex = new Mutex();
        this.upnpStatus = new UPnPStatus();
        this.commandExecuteStatus = new CommandExecuteStatus();
        this.userData = null;
        this.mCastContext = r100;
        this.mMonitor = ContextManager.getMonitor(r100);
        this.mLogger = ContextManager.getLogger(this.mCastContext);
        this.serviceNode = r101;
        this.actionNode = r102;
    }
}
