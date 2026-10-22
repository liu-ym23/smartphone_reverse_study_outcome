package com.android.server.display.topology;

import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Display {
    private Children children;
    private String id;
    private Float offset;
    private Position position;
    private Boolean primary;

    public Display() {
    }

    public Position getPosition() {
        return this.position;
    }

    boolean hasPosition() {
        if (this.position != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public float getOffset() {
        if (this.offset != null) goto L7;
        return 0.0f;
    L7:
        return this.offset.floatValue();
    }

    boolean hasOffset() {
        if (this.offset != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setOffset(float offset) {
        this.offset = Float.valueOf(offset);
    }

    public Children getChildren() {
        return this.children;
    }

    boolean hasChildren() {
        if (this.children != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setChildren(Children children) {
        this.children = children;
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

    public boolean getPrimary() {
        if (this.primary != null) goto L7;
        return false;
    L7:
        return this.primary.booleanValue();
    }

    boolean hasPrimary() {
        if (this.primary != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setPrimary(boolean primary) {
        this.primary = Boolean.valueOf(primary);
    }

    static Display read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Display _instance = new Display();
        String _raw = _parser.getAttributeValue(null, "id");
        if (_raw == null) goto L5;
        _instance.setId(_raw);
    L5:
        String _raw2 = _parser.getAttributeValue(null, "primary");
        if (_raw2 == null) goto L8;
        boolean _value = Boolean.parseBoolean(_raw2);
        _instance.setPrimary(_value);
    L8:
        _parser.getDepth();
    L9:
        int type = _parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L26;
        if (_parser.getEventType() != 2) goto L9;
        String _tagName = _parser.getName();
        if (_tagName.equals("position") == true) goto L17;
        if (_tagName.equals("offset") == true) goto L20;
        if (_tagName.equals("children") == true) goto L23;
        XmlParser.skip(_parser);
        goto L9
    L23:
        Children _value2 = Children.read(_parser);
        _instance.setChildren(_value2);
        goto L9
    L20:
        float _value3 = Float.parseFloat(XmlParser.readText(_parser));
        _instance.setOffset(_value3);
        goto L9
    L17:
        Position _value4 = Position.fromString(XmlParser.readText(_parser));
        _instance.setPosition(_value4);
    L26:
        if (type != 3) goto L29;
        return _instance;
    L29:
        throw new DatatypeConfigurationException("Display is not closed");
    }

    void write(XmlWriter _out, String _name) throws IOException {
        _out.print("<" + _name);
        if (hasId() == false) goto L6;
        _out.print(" id=\"");
        _out.print(getId());
        _out.print("\"");
    L6:
        if (hasPrimary() == false) goto L8;
        _out.print(" primary=\"");
        _out.print(Boolean.toString(getPrimary()));
        _out.print("\"");
    L8:
        _out.print(">\n");
        _out.increaseIndent();
        if (hasPosition() == false) goto L12;
        _out.print("<position>");
        _out.print(getPosition().toString());
        _out.print("</position>\n");
    L12:
        if (hasOffset() == false) goto L15;
        _out.print("<offset>");
        _out.print(Float.toString(getOffset()));
        _out.print("</offset>\n");
    L15:
        if (hasChildren() == false) goto L17;
        getChildren().write(_out, "children");
    L17:
        _out.decreaseIndent();
        _out.print("</" + _name + ">\n");
    }
}
