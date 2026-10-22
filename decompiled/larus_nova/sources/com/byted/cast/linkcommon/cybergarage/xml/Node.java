package com.byted.cast.linkcommon.cybergarage.xml;

import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.byted.cast.linkcommon.cybergarage.upnp.Service;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes28.dex */
public class Node {
    private String applicationUrl;
    private AttributeList attrList;
    private String name;
    private NodeList nodeList;
    private Node parentNode;
    private Object userData;
    private String value;

    public void print() {
        print(true);
    }

    public String toXMLString() {
        return toXMLString(true);
    }

    public int getNAttributes() {
        return this.attrList.size();
    }

    public int getNNodes() {
        return this.nodeList.size();
    }

    public void removeAllAttributes() {
        this.attrList.clear();
    }

    public void removeAllNodes() {
        this.nodeList.clear();
    }

    public Node() {
        this.parentNode = null;
        this.name = "";
        this.value = "";
        this.attrList = new AttributeList();
        this.nodeList = new NodeList();
        this.userData = null;
        setUserData(null);
        setParentNode(null);
    }

    public Node getRootNode() {
        Node r100 = getParentNode();
        Node r101 = null;
    L3:
        if (r100 == null) goto L5;
        r101 = r100;
        r100 = r100.getParentNode();
        goto L3
    L5:
        return r101;
    }

    public boolean hasAttributes() {
        if (getNAttributes() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean hasNodes() {
        if (getNNodes() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public String toString() {
        return toString(XML.CHARSET_UTF8, true);
    }

    public String getApplicationUrl() {
        return this.applicationUrl;
    }

    public String getName() {
        return this.name;
    }

    public Node getParentNode() {
        return this.parentNode;
    }

    public Object getUserData() {
        return this.userData;
    }

    public String getValue() {
        return this.value;
    }

    public Node(String r100) {
        this();
        setName(r100);
    }

    public void addAttribute(Attribute r100) {
        this.attrList.add(r100);
    }

    public void addNode(Node r100) {
        r100.setParentNode(this);
        this.nodeList.add(r100);
    }

    public void addValue(String r100) {
        if (this.value != null) goto L6;
        this.value = r100;
        return;
    L6:
        if (r100 == null) goto L9;
        this.value += r100;
        return;
    }

    public Attribute getAttribute(int r100) {
        return this.attrList.getAttribute(r100);
    }

    public int getAttributeIntegerValue(String r100) {
        return CastIntegerProtector.parseInt(getAttributeValue(r100));
    L5:
        return 0;
    }

    public String getAttributeValue(String r100) {
        Attribute r101 = getAttribute(r100);
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getValue();
    }

    public String getIndentLevelString(int r100) {
        return getIndentLevelString(r100, LineContent.FOUR_SPACE);
    }

    public int getIndex(String r100) {
        Iterator r101 = this.nodeList.iterator();
        int r102 = -1;
    L4:
        if (r101.hasNext() == false) goto L7;
        r102 = r102 + 1;
        if (((Node) r101.next()).getName().equals(r100) == false) goto L4;
    L7:
        return r102;
    }

    public Node getNode(int r100) {
        return this.nodeList.getNode(r100);
    }

    public Node getNodeEndsWith(String r100) {
        return this.nodeList.getEndsWith(r100);
    }

    public String getNodeValue(String r100) {
        Node r101 = getNode(r100);
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getValue();
    }

    public boolean isName(String r100) {
        return this.name.equals(r100);
    }

    public void outputAttributes(PrintWriter r100) {
        int r101 = getNAttributes();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        Attribute r103 = getAttribute(r102);
        r100.print(" " + r103.getName() + "=\"" + XML.escapeXMLChars(r103.getValue()) + "\"");
        r102 = r102 + 1;
        goto L3
    L6:
        if (getName().startsWith("dlna:") == false) goto L9;
        r100.print(" xmlns:dlna=\"urn:schemas-dlna-org:device-1-0\"");
        return;
    L9:
        if (getName().equals(RootDescription.ROOT_ELEMENT) == false) goto L12;
        r100.print(" xmlns=\"urn:schemas-upnp-org:device-1-0\"");
        return;
    L12:
        if (getName().equals(Service.SCPD_ROOTNODE) == false) goto L18;
        r100.print(" xmlns=\"urn:schemas-upnp-org:service-1-0\"");
        return;
    }

    public void print(boolean r100) {
        PrintWriter r101 = new PrintWriter(System.out);
        output(r101, 0, r100);
        r101.flush();
    }

    public boolean removeAttribute(String r100) {
        return removeAttribute(getAttribute(r100));
    }

    public boolean removeNode(Node r100) {
        r100.setParentNode(null);
        return this.nodeList.remove(r100);
    }

    public boolean set(Node r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return false;
    L5:
        setName(r100.getName());
        setValue(r100.getValue());
        removeAllAttributes();
        int r102 = r100.getNAttributes();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        addAttribute(new Attribute(r100.getAttribute(r103)));
        r103 = r103 + 1;
        goto L6
    L8:
        removeAllNodes();
        int r104 = r100.getNNodes();
    L9:
        if (r101 >= r104) goto L11;
        Node r105 = r100.getNode(r101);
        Node r106 = new Node();
        r106.set(r105);
        addNode(r106);
        r101 = r101 + 1;
        goto L9
    L11:
        return true;
    }

    public void setApplicationUrl(String r100) {
        this.applicationUrl = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setParentNode(Node r100) {
        this.parentNode = r100;
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public void setValue(int r100) {
        setValue(Integer.toString(r100));
    }

    public String toXMLString(boolean r100) {
        return toString().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
    }

    public Attribute getAttribute(String r100) {
        return this.attrList.getAttribute(r100);
    }

    public Node getNode(String r100) {
        return this.nodeList.getNode(r100);
    }

    public boolean removeAttribute(Attribute r100) {
        return this.attrList.remove(r100);
    }

    public boolean removeNode(String r100) {
        return this.nodeList.remove(getNode(r100));
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public Node(String r100, String r101) {
        this();
        setName(r100, r101);
    }

    public void addAttribute(String r100, String r101) {
        addAttribute(new Attribute(r100, r101));
    }

    public String getIndentLevelString(int r100, String r101) {
        StringBuffer r102 = new StringBuffer(r101.length() * r100);
        int r103 = 0;
    L3:
        if (r103 >= r100) goto L6;
        r102.append(r101);
        r103 = r103 + 1;
        goto L3
    L6:
        return r102.toString();
    }

    public void insertAttributeAt(Attribute r100, int r101) {
        this.attrList.insertElementAt(r100, r101);
    }

    public void insertNode(Node r100, int r101) {
        r100.setParentNode(this);
        this.nodeList.insertElementAt(r100, r101);
    }

    public void setAttribute(String r100, String r101) {
        Attribute r102 = getAttribute(r100);
        if (r102 == null) goto L6;
        r102.setValue(r101);
        return;
    L6:
        addAttribute(new Attribute(r100, r101));
    }

    public void setName(String r100, String r101) {
        this.name = r100 + ":" + r101;
    }

    public void setNameSpace(String r100, String r101) {
        setAttribute("xmlns:" + r100, r101);
    }

    public void setNode(String r100, String r101) {
        Node r102 = getNode(r100);
        if (r102 == null) goto L6;
        r102.setValue(r101);
        return;
    L6:
        Node r103 = new Node(r100);
        r103.setValue(r101);
        addNode(r103);
    }

    public String toString(String r100, boolean r101) {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        PrintWriter r103 = new PrintWriter(r102);
        output(r103, 0, r101);
        r103.flush();
        if (r100 == null) goto L9;
        if (r100.length() <= 0) goto L9;
        return r102.toString(r100);
    L9:
        return r102.toString();
    }

    public void setAttribute(String r100, int r101) {
        setAttribute(r100, Integer.toString(r101));
    }

    public void output(PrintWriter r100, int r110, boolean r111) {
        String r101 = getIndentLevelString(r110);
        String r102 = getName();
        String r103 = getValue();
        if (hasNodes() == false) goto L11;
        if (r111 == false) goto L11;
        r100.print(r101 + "<" + r102);
        outputAttributes(r100);
        r100.println(">");
        int r112 = getNNodes();
        int r104 = 0;
    L7:
        if (r104 >= r112) goto L9;
        getNode(r104).output(r100, r110 + 1, true);
        r104 = r104 + 1;
        goto L7
    L9:
        r100.println(r101 + "</" + r102 + ">");
        return;
    L11:
        r100.print(r101 + "<" + r102);
        outputAttributes(r100);
        if (r103 != null) goto L14;
    L17:
        r100.println("></" + r102 + ">");
        return;
    L14:
        if (r103.length() == 0) goto L17;
        r100.println(">" + XML.escapeXMLChars(r103) + "</" + r102 + ">");
    }
}
