package com.android.server.display.topology;

import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Topology {
    private Display display;
    private String id;
    private Boolean immutable;
    private Integer order;

    public Topology() {
    }

    public Display getDisplay() {
        return this.display;
    }

    boolean hasDisplay() {
        if (this.display != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public String getId() {
        return this.id;
    }

    boolean hasId() {
        if (this.id != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrder() {
        if (this.order != null) goto L7;
        return 0;
    L7:
        return this.order.intValue();
    }

    boolean hasOrder() {
        if (this.order != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setOrder(int order) {
        this.order = Integer.valueOf(order);
    }

    public boolean getImmutable() {
        if (this.immutable != null) goto L7;
        return false;
    L7:
        return this.immutable.booleanValue();
    }

    boolean hasImmutable() {
        if (this.immutable != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setImmutable(boolean immutable) {
        this.immutable = Boolean.valueOf(immutable);
    }

    static Topology read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Topology _instance = new Topology();
        String _raw = _parser.getAttributeValue(null, "id");
        if (_raw == null) goto L5;
        _instance.setId(_raw);
    L5:
        String _raw2 = _parser.getAttributeValue(null, "order");
        if (_raw2 == null) goto L8;
        int _value = Integer.parseInt(_raw2);
        _instance.setOrder(_value);
    L8:
        String _raw3 = _parser.getAttributeValue(null, "immutable");
        if (_raw3 == null) goto L11;
        boolean _value2 = Boolean.parseBoolean(_raw3);
        _instance.setImmutable(_value2);
    L11:
        _parser.getDepth();
    L12:
        int type = _parser.next();
        if (type == 1) goto L23;
        if (type == 3) goto L23;
        if (_parser.getEventType() != 2) goto L12;
        String _tagName = _parser.getName();
        if (_tagName.equals("display") == true) goto L20;
        XmlParser.skip(_parser);
        goto L12
    L20:
        Display _value3 = Display.read(_parser);
        _instance.setDisplay(_value3);
    L23:
        if (type != 3) goto L26;
        return _instance;
    L26:
        throw new DatatypeConfigurationException("Topology is not closed");
    }

    void write(XmlWriter _out, String _name) throws IOException {
        _out.print("<" + _name);
        if (hasId() == false) goto L6;
        _out.print(" id=\"");
        _out.print(getId());
        _out.print("\"");
    L6:
        if (hasOrder() == false) goto L9;
        _out.print(" order=\"");
        _out.print(Integer.toString(getOrder()));
        _out.print("\"");
    L9:
        if (hasImmutable() == false) goto L11;
        _out.print(" immutable=\"");
        _out.print(Boolean.toString(getImmutable()));
        _out.print("\"");
    L11:
        _out.print(">\n");
        _out.increaseIndent();
        if (hasDisplay() == false) goto L14;
        getDisplay().write(_out, "display");
    L14:
        _out.decreaseIndent();
        _out.print("</" + _name + ">\n");
    }
}
