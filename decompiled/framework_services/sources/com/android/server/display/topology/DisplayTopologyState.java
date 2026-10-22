package com.android.server.display.topology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayTopologyState {
    private List<Topology> topology;
    private Integer version;

    public DisplayTopologyState() {
    }

    public List<Topology> getTopology() {
        if (this.topology != null) goto L6;
        this.topology = new ArrayList();
    L6:
        return this.topology;
    }

    public int getVersion() {
        if (this.version != null) goto L7;
        return 0;
    L7:
        return this.version.intValue();
    }

    boolean hasVersion() {
        if (this.version != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setVersion(int version) {
        this.version = Integer.valueOf(version);
    }

    static DisplayTopologyState read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        DisplayTopologyState _instance = new DisplayTopologyState();
        String _raw = _parser.getAttributeValue(null, "version");
        if (_raw == null) goto L5;
        int _value = Integer.parseInt(_raw);
        _instance.setVersion(_value);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals("topology") == true) goto L14;
        XmlParser.skip(_parser);
        goto L6
    L14:
        Topology _value2 = Topology.read(_parser);
        _instance.getTopology().add(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("DisplayTopologyState is not closed");
    }

    void write(XmlWriter _out, String _name) throws IOException {
        _out.print("<" + _name);
        if (hasVersion() == false) goto L5;
        _out.print(" version=\"");
        _out.print(Integer.toString(getVersion()));
        _out.print("\"");
    L5:
        _out.print(">\n");
        _out.increaseIndent();
        Iterator<Topology> r1 = getTopology().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Topology value = r1.next();
        value.write(_out, "topology");
        goto L7
    L9:
        _out.decreaseIndent();
        _out.print("</" + _name + ">\n");
    }
}
