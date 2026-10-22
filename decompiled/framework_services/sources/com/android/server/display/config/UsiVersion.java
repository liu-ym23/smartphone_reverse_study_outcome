package com.android.server.display.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class UsiVersion {
    private BigInteger majorVersion;
    private BigInteger minorVersion;

    public UsiVersion() {
    }

    public final BigInteger getMajorVersion() {
        return this.majorVersion;
    }

    boolean hasMajorVersion() {
        if (this.majorVersion != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMajorVersion(BigInteger majorVersion) {
        this.majorVersion = majorVersion;
    }

    public final BigInteger getMinorVersion() {
        return this.minorVersion;
    }

    boolean hasMinorVersion() {
        if (this.minorVersion != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setMinorVersion(BigInteger minorVersion) {
        this.minorVersion = minorVersion;
    }

    static UsiVersion read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        UsiVersion _instance = new UsiVersion();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L17;
        if (type == 3) goto L17;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("majorVersion") == true) goto L11;
        if (_tagName.equals("minorVersion") == true) goto L14;
        XmlParser.skip(_parser);
        goto L3
    L14:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value = new BigInteger(_raw);
        _instance.setMinorVersion(_value);
        goto L3
    L11:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw2);
        _instance.setMajorVersion(_value2);
    L17:
        if (type != 3) goto L20;
        return _instance;
    L20:
        throw new DatatypeConfigurationException("UsiVersion is not closed");
    }
}
