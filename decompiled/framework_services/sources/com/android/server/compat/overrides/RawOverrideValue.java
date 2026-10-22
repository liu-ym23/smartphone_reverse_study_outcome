package com.android.server.compat.overrides;

import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class RawOverrideValue {
    private Boolean enabled;
    private Long maxVersionCode;
    private Long minVersionCode;
    private String packageName;

    public RawOverrideValue() {
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

    public long getMinVersionCode() {
        if (this.minVersionCode != null) goto L7;
        return 0;
    L7:
        return this.minVersionCode.longValue();
    }

    boolean hasMinVersionCode() {
        if (this.minVersionCode != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setMinVersionCode(long minVersionCode) {
        this.minVersionCode = Long.valueOf(minVersionCode);
    }

    public long getMaxVersionCode() {
        if (this.maxVersionCode != null) goto L7;
        return 0;
    L7:
        return this.maxVersionCode.longValue();
    }

    boolean hasMaxVersionCode() {
        if (this.maxVersionCode != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setMaxVersionCode(long maxVersionCode) {
        this.maxVersionCode = Long.valueOf(maxVersionCode);
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

    static RawOverrideValue read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        RawOverrideValue _instance = new RawOverrideValue();
        String _raw = _parser.getAttributeValue(null, "packageName");
        if (_raw == null) goto L5;
        _instance.setPackageName(_raw);
    L5:
        String _raw2 = _parser.getAttributeValue(null, "minVersionCode");
        if (_raw2 == null) goto L8;
        long _value = Long.parseLong(_raw2);
        _instance.setMinVersionCode(_value);
    L8:
        String _raw3 = _parser.getAttributeValue(null, "maxVersionCode");
        if (_raw3 == null) goto L11;
        long _value2 = Long.parseLong(_raw3);
        _instance.setMaxVersionCode(_value2);
    L11:
        String _raw4 = _parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        if (_raw4 == null) goto L14;
        boolean _value3 = Boolean.parseBoolean(_raw4);
        _instance.setEnabled(_value3);
    L14:
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
        if (hasMinVersionCode() == false) goto L9;
        _out.print(" minVersionCode=\"");
        _out.print(Long.toString(getMinVersionCode()));
        _out.print("\"");
    L9:
        if (hasMaxVersionCode() == false) goto L12;
        _out.print(" maxVersionCode=\"");
        _out.print(Long.toString(getMaxVersionCode()));
        _out.print("\"");
    L12:
        if (hasEnabled() == false) goto L14;
        _out.print(" enabled=\"");
        _out.print(Boolean.toString(getEnabled()));
        _out.print("\"");
    L14:
        _out.print(">\n");
        _out.print("</" + _name + ">\n");
    }
}
