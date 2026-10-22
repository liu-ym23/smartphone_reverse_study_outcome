package com.android.server.compat.overrides;

import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class OverrideValue {
    private Boolean enabled;
    private String packageName;

    public OverrideValue() {
    }

    public String getPackageName() {
        return this.packageName;
    }

    boolean hasPackageName() {
        if (this.packageName != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean getEnabled() {
        if (this.enabled != null) goto L7;
        return false;
    L7:
        return this.enabled.booleanValue();
    }

    boolean hasEnabled() {
        if (this.enabled != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = Boolean.valueOf(enabled);
    }

    static OverrideValue read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        OverrideValue _instance = new OverrideValue();
        String _raw = _parser.getAttributeValue(null, "packageName");
        if (_raw == null) goto L5;
        _instance.setPackageName(_raw);
    L5:
        String _raw2 = _parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        if (_raw2 == null) goto L8;
        boolean _value = Boolean.parseBoolean(_raw2);
        _instance.setEnabled(_value);
    L8:
        XmlParser.skip(_parser);
        return _instance;
    }

    void write(XmlWriter _out, String _name) throws IOException {
        _out.print("<" + _name);
        if (hasPackageName() == false) goto L6;
        _out.print(" packageName=\"");
        _out.print(getPackageName());
        _out.print("\"");
    L6:
        if (hasEnabled() == false) goto L8;
        _out.print(" enabled=\"");
        _out.print(Boolean.toString(getEnabled()));
        _out.print("\"");
    L8:
        _out.print(">\n");
        _out.print("</" + _name + ">\n");
    }
}
