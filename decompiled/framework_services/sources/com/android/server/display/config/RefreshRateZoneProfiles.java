package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshRateZoneProfiles {
    private List<RefreshRateZone> refreshRateZoneProfile;

    public RefreshRateZoneProfiles() {
    }

    public final List<RefreshRateZone> getRefreshRateZoneProfile() {
        if (this.refreshRateZoneProfile != null) goto L6;
        this.refreshRateZoneProfile = new ArrayList();
    L6:
        return this.refreshRateZoneProfile;
    }

    static RefreshRateZoneProfiles read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        RefreshRateZoneProfiles _instance = new RefreshRateZoneProfiles();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("refreshRateZoneProfile") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        RefreshRateZone _value = RefreshRateZone.read(_parser);
        _instance.getRefreshRateZoneProfile().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("RefreshRateZoneProfiles is not closed");
    }
}
