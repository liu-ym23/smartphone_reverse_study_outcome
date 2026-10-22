package com.byted.cast.linkcommon.cybergarage.upnp;

import com.byted.cast.linkcommon.cybergarage.xml.Node;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes28.dex */
public class Icon {
    private static final String DEPTH = "depth";
    public static final String ELEM_NAME = "icon";
    private static final String HEIGHT = "height";
    private static final String MIME_TYPE = "mimetype";
    private static final String URL = "url";
    private static final String WIDTH = "width";
    private byte[] bytes;
    private Node iconNode;
    private Object userData;

    public Icon() {
        this(new Node("icon"));
    }

    public byte[] getBytes() {
        if (this.bytes != null) goto L12;
        if (hasURL() == false) goto L12;
        InputStream r100 = Icon.class.getResourceAsStream(getURL());     // Catch: Exception -> L13
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L13
    L7:
        int r102 = r100.read();     // Catch: Exception -> L13
        if (r102 == (-1)) goto L10;
        r101.write(r102);     // Catch: Exception -> L13
        goto L7
    L10:
        r100.close();     // Catch: Exception -> L13
        this.bytes = r101.toByteArray();     // Catch: Exception -> L13
    L12:
        return this.bytes;
    }

    public boolean hasBytes() {
        boolean r100 = true;
        if (this.bytes == null) goto L6;
        return true;
    L6:
        if (hasURL() == false) goto L17;
        InputStream r101 = Icon.class.getResourceAsStream(getURL());
        if (r101 != null) goto L11;
        r100 = false;
    L11:
        if (r101 != null) goto L18;
    L16:
        return r100;
    L18:
        r101.close();     // Catch: IOException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L17:
        return false;
    }

    public int getDepth() {
        return CastIntegerProtector.parseInt(getIconNode().getNodeValue("depth"));
    L4:
        return 0;
    }

    public int getHeight() {
        return CastIntegerProtector.parseInt(getIconNode().getNodeValue("height"));
    L4:
        return 0;
    }

    public String getMimeType() {
        return getIconNode().getNodeValue(MIME_TYPE);
    }

    public String getURL() {
        return getIconNode().getNodeValue("url");
    }

    public int getWidth() {
        return CastIntegerProtector.parseInt(getIconNode().getNodeValue("width"));
    L4:
        return 0;
    }

    public boolean hasMimeType() {
        String r100 = getMimeType();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.length() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean hasURL() {
        String r100 = getURL();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.length() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public Node getIconNode() {
        return this.iconNode;
    }

    public Object getUserData() {
        return this.userData;
    }

    public Icon(Node r100) {
        this.userData = null;
        this.bytes = null;
        this.iconNode = r100;
    }

    public static boolean isIconNode(Node r100) {
        return "icon".equals(r100.getName());
    }

    public boolean isURL(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = getURL();
        if (r101 != null) goto L9;
        return false;
    L9:
        return r101.equals(r100);
    }

    public void setBytes(byte[] r100) {
        this.bytes = r100;
    }

    public void setDepth(String r100) {
        getIconNode().setNode("depth", r100);
    }

    public void setHeight(String r100) {
        getIconNode().setNode("height", r100);
    }

    public void setMimeType(String r100) {
        getIconNode().setNode(MIME_TYPE, r100);
    }

    public void setURL(String r100) {
        getIconNode().setNode("url", r100);
    }

    public void setUserData(Object r100) {
        this.userData = r100;
    }

    public void setWidth(String r100) {
        getIconNode().setNode("width", r100);
    }

    public void setDepth(int r100) {
        setDepth(Integer.toString(r100));     // Catch: Exception -> L4
        return;
    }

    public void setHeight(int r100) {
        setHeight(Integer.toString(r100));     // Catch: Exception -> L4
        return;
    }

    public void setWidth(int r100) {
        setWidth(Integer.toString(r100));     // Catch: Exception -> L4
        return;
    }
}
