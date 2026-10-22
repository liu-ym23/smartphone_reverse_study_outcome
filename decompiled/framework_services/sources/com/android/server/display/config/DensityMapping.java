package com.android.server.display.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class DensityMapping {
    private List<Density> density;

    public DensityMapping() {
    }

    public List<Density> getDensity() {
        if (this.density != null) goto L6;
        this.density = new ArrayList();
    L6:
        return this.density;
    }

    static DensityMapping read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        DensityMapping _instance = new DensityMapping();
        _parser.getDepth();
    L3:
        int type = _parser.next();
        if (type == 1) goto L14;
        if (type == 3) goto L14;
        if (_parser.getEventType() != 2) goto L3;
        String _tagName = _parser.getName();
        if (_tagName.equals("density") == true) goto L11;
        XmlParser.skip(_parser);
        goto L3
    L11:
        Density _value = Density.read(_parser);
        _instance.getDensity().add(_value);
    L14:
        if (type != 3) goto L17;
        return _instance;
    L17:
        throw new DatatypeConfigurationException("DensityMapping is not closed");
    }
}
