package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class BlockingZoneThreshold {
    private List<DisplayBrightnessPoint> displayBrightnessPoint;

    public BlockingZoneThreshold() {
    }

    public final List<DisplayBrightnessPoint> getDisplayBrightnessPoint() {
        if (this.displayBrightnessPoint != null) goto L6;
        this.displayBrightnessPoint = new ArrayList();
    L6:
        return this.displayBrightnessPoint;
    }

    static BlockingZoneThreshold read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        BlockingZoneThreshold _instance = new BlockingZoneThreshold();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("displayBrightnessPoint") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        DisplayBrightnessPoint _value = DisplayBrightnessPoint.read(_parser);
        _instance.getDisplayBrightnessPoint().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("BlockingZoneThreshold is not closed");
    }
}
