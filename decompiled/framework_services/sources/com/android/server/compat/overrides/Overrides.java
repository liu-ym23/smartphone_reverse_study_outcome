package com.android.server.compat.overrides;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class Overrides {
    private List<ChangeOverrides> changeOverrides;

    public Overrides() {
    }

    public List<ChangeOverrides> getChangeOverrides() {
        if (this.changeOverrides != null) goto L6;
        this.changeOverrides = new ArrayList();
    L6:
        return this.changeOverrides;
    }

    static Overrides read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Overrides _instance = new Overrides();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("change-overrides") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        ChangeOverrides _value = ChangeOverrides.read(_parser);
        _instance.getChangeOverrides().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("Overrides is not closed");
    }

    void write(XmlWriter _out, String _name) throws IOException {
        _out.print("<" + _name);
        _out.print(">\n");
        _out.increaseIndent();
        Iterator<ChangeOverrides> r1 = getChangeOverrides().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ChangeOverrides value = r1.next();
        value.write(_out, "change-overrides");
        goto L4
    L6:
        _out.decreaseIndent();
        _out.print("</" + _name + ">\n");
    }
}
