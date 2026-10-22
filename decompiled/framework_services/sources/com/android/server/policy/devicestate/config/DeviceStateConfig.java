package com.android.server.policy.devicestate.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceStateConfig {
    private List<DeviceState> deviceState;

    public DeviceStateConfig() {
    }

    public List<DeviceState> getDeviceState() {
        if (this.deviceState != null) goto L6;
        this.deviceState = new ArrayList();
    L6:
        return this.deviceState;
    }

    static DeviceStateConfig read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        DeviceStateConfig _instance = new DeviceStateConfig();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("device-state") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        DeviceState _value = DeviceState.read(_parser);
        _instance.getDeviceState().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("DeviceStateConfig is not closed");
    }
}
