package com.android.server.display.config;

import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class SdrHdrRatioPoint {
    private BigDecimal hdrRatio;
    private BigDecimal sdrNits;

    public SdrHdrRatioPoint() {
    }

    public final BigDecimal getSdrNits() {
        return this.sdrNits;
    }

    boolean hasSdrNits() {
        if (this.sdrNits != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setSdrNits(BigDecimal sdrNits) {
        this.sdrNits = sdrNits;
    }

    public final BigDecimal getHdrRatio() {
        return this.hdrRatio;
    }

    boolean hasHdrRatio() {
        if (this.hdrRatio != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setHdrRatio(BigDecimal hdrRatio) {
        this.hdrRatio = hdrRatio;
    }

    static SdrHdrRatioPoint read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        SdrHdrRatioPoint _instance = new SdrHdrRatioPoint();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("sdrNits") == true) goto L11;
        if (_tagName.equals("hdrRatio") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigDecimal _value = new BigDecimal(_raw);
        _instance.setHdrRatio(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigDecimal _value2 = new BigDecimal(_raw2);
        _instance.setSdrNits(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("SdrHdrRatioPoint is not closed");
    }
}
