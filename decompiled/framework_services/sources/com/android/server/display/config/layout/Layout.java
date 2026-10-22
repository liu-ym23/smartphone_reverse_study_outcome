package com.android.server.display.config.layout;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Layout {
    private List<Display> display;
    private BigInteger state;

    public Layout() {
    }

    public BigInteger getState() {
        return this.state;
    }

    boolean hasState() {
        if (this.state != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setState(BigInteger state) {
        this.state = state;
    }

    public List<Display> getDisplay() {
        if (this.display != null) goto L6;
        this.display = new ArrayList();
    L6:
        return this.display;
    }

    static Layout read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Layout _instance = new Layout();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("state") == true) goto L11;
        if (_tagName.equals("display") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        Display _value = Display.read(_parser);
        _instance.getDisplay().add(_value);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw);
        _instance.setState(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("Layout is not closed");
    }
}
