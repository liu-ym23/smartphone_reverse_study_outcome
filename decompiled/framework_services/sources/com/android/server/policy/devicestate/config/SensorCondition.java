package com.android.server.policy.devicestate.config;

import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class SensorCondition {
    private String name;
    private String type;
    private List<NumericRange> value;

    public SensorCondition() {
    }

    public String getType() {
        return this.type;
    }

    boolean hasType() {
        if (this.type != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    boolean hasName() {
        if (this.name != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NumericRange> getValue() {
        if (this.value != null) goto L6;
        this.value = new ArrayList();
    L6:
        return this.value;
    }

    static SensorCondition read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        SensorCondition _instance = new SensorCondition();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L20;
        if (type == 3) goto L20;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals(DatabaseHelper.SoundModelContract.KEY_TYPE) == true) goto L11;
        if (_tagName.equals("name") == true) goto L14;
        if (_tagName.equals("value") == true) goto L17;
        XmlParser.skip(_parser);
        goto L3
    L17:
        NumericRange _value = NumericRange.read(_parser);
        _instance.getValue().add(_value);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        _instance.setName(_raw);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        _instance.setType(_raw2);
    L20:
        if (type != 3) goto L23;
        return _instance;
    L23:
        throw new DatatypeConfigurationException("SensorCondition is not closed");
    }
}
