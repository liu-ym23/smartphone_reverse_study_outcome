package com.android.server.display.topology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Children {
    private List<Display> display;

    public Children() {
    }

    public List<Display> getDisplay() {
        if (this.display != null) goto L6;
        this.display = new ArrayList();
    L6:
        return this.display;
    }

    static Children read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Children _instance = new Children();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("display") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        Display _value = Display.read(_parser);
        _instance.getDisplay().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("Children is not closed");
    }

    void write(XmlWriter _out, String _name) throws IOException {
        _out.print("<" + _name);
        _out.print(">\n");
        _out.increaseIndent();
        Iterator<Display> r1 = getDisplay().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Display value = r1.next();
        value.write(_out, "display");
        goto L4
    L6:
        _out.decreaseIndent();
        _out.print("</" + _name + ">\n");
    }
}
