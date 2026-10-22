package com.android.server.display.config;

import java.io.IOException;
import java.math.BigInteger;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Density {
    private BigInteger density;
    private BigInteger height;
    private BigInteger width;

    public Density() {
    }

    public final BigInteger getWidth() {
        return this.width;
    }

    boolean hasWidth() {
        if (this.width != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setWidth(BigInteger width) {
        this.width = width;
    }

    public final BigInteger getHeight() {
        return this.height;
    }

    boolean hasHeight() {
        if (this.height != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setHeight(BigInteger height) {
        this.height = height;
    }

    public final BigInteger getDensity() {
        return this.density;
    }

    boolean hasDensity() {
        if (this.density != null) goto L6;
        return false;
    L6:
        return true;
    }

    public final void setDensity(BigInteger density) {
        this.density = density;
    }

    static Density read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Density _instance = new Density();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L20;
        if (type == 3) goto L20;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("width") == true) goto L11;
        if (_tagName.equals("height") == true) goto L14;
        if (_tagName.equals("density") == true) goto L17;
        XmlParser.skip(_parser);
        goto L3
    L17:
        String _raw = XmlParser.readText(_parser);
        BigInteger _value = new BigInteger(_raw);
        _instance.setDensity(_value);
        goto L3
    L14:
        String _raw2 = XmlParser.readText(_parser);
        BigInteger _value2 = new BigInteger(_raw2);
        _instance.setHeight(_value2);
        goto L3
    L11:
        String _raw3 = XmlParser.readText(_parser);
        BigInteger _value3 = new BigInteger(_raw3);
        _instance.setWidth(_value3);
    L20:
        if (type != 3) goto L23;
        return _instance;
    L23:
        throw new DatatypeConfigurationException("Density is not closed");
    }
}
