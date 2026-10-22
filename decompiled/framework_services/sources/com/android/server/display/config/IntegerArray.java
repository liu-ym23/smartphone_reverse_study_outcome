package com.android.server.display.config;

import com.android.server.pm.Settings;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class IntegerArray {
    private List<BigInteger> item;

    public IntegerArray() {
    }

    public List<BigInteger> getItem() {
        if (this.item != null) goto L6;
        this.item = new ArrayList();
    L6:
        return this.item;
    }

    static IntegerArray read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        IntegerArray _instance = new IntegerArray();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals(Settings.TAG_ITEM) == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value = new BigInteger(_raw);
        _instance.getItem().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("IntegerArray is not closed");
    }
}
