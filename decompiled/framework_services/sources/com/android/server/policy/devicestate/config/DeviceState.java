package com.android.server.policy.devicestate.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceState {
    private Conditions conditions;
    private Flags flags;
    private BigInteger identifier;
    private String name;
    private Properties properties;

    public DeviceState() {
    }

    public BigInteger getIdentifier() {
        return this.identifier;
    }

    boolean hasIdentifier() {
        if (this.identifier != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setIdentifier(BigInteger identifier) {
        this.identifier = identifier;
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

    public Properties getProperties() {
        return this.properties;
    }

    boolean hasProperties() {
        if (this.properties != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Flags getFlags() {
        return this.flags;
    }

    boolean hasFlags() {
        if (this.flags != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Conditions getConditions() {
        return this.conditions;
    }

    boolean hasConditions() {
        if (this.conditions != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    static DeviceState read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        DeviceState _instance = new DeviceState();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L26;
        if (type == 3) goto L26;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("identifier") == true) goto L11;
        if (_tagName.equals("name") == true) goto L14;
        if (_tagName.equals("properties") == true) goto L17;
        if (_tagName.equals("flags") == true) goto L20;
        if (_tagName.equals("conditions") == true) goto L23;
        XmlParser.skip(_parser);
        goto L3
    L23:
        Conditions _value = Conditions.read(_parser);
        _instance.setConditions(_value);
        goto L3
    L20:
        Flags _value2 = Flags.read(_parser);
        _instance.setFlags(_value2);
        goto L3
    L17:
        Properties _value3 = Properties.read(_parser);
        _instance.setProperties(_value3);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        _instance.setName(_raw);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value4 = new BigInteger(_raw2);
        _instance.setIdentifier(_value4);
    L26:
        if (type != 3) goto L29;
        return _instance;
    L29:
        throw new DatatypeConfigurationException("DeviceState is not closed");
    }
}
