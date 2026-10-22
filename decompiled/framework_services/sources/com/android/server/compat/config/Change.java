package com.android.server.compat.config;

import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class Change {
    private String description;
    private Boolean disabled;
    private Integer enableAfterTargetSdk;
    private Integer enableSinceTargetSdk;
    private Long id;
    private Boolean loggingOnly;
    private String name;
    private Boolean overridable;
    private String value;

    public Change() {
    }

    public long getId() {
        if (this.id != null) goto L7;
        return 0;
    L7:
        return this.id.longValue();
    }

    boolean hasId() {
        if (this.id != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setId(long id) {
        this.id = Long.valueOf(id);
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

    public boolean getDisabled() {
        if (this.disabled != null) goto L7;
        return false;
    L7:
        return this.disabled.booleanValue();
    }

    boolean hasDisabled() {
        if (this.disabled != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = Boolean.valueOf(disabled);
    }

    public boolean getLoggingOnly() {
        if (this.loggingOnly != null) goto L7;
        return false;
    L7:
        return this.loggingOnly.booleanValue();
    }

    boolean hasLoggingOnly() {
        if (this.loggingOnly != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setLoggingOnly(boolean loggingOnly) {
        this.loggingOnly = Boolean.valueOf(loggingOnly);
    }

    public int getEnableAfterTargetSdk() {
        if (this.enableAfterTargetSdk != null) goto L7;
        return 0;
    L7:
        return this.enableAfterTargetSdk.intValue();
    }

    boolean hasEnableAfterTargetSdk() {
        if (this.enableAfterTargetSdk != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setEnableAfterTargetSdk(int enableAfterTargetSdk) {
        this.enableAfterTargetSdk = Integer.valueOf(enableAfterTargetSdk);
    }

    public int getEnableSinceTargetSdk() {
        if (this.enableSinceTargetSdk != null) goto L7;
        return 0;
    L7:
        return this.enableSinceTargetSdk.intValue();
    }

    boolean hasEnableSinceTargetSdk() {
        if (this.enableSinceTargetSdk != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setEnableSinceTargetSdk(int enableSinceTargetSdk) {
        this.enableSinceTargetSdk = Integer.valueOf(enableSinceTargetSdk);
    }

    public String getDescription() {
        return this.description;
    }

    boolean hasDescription() {
        if (this.description != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getOverridable() {
        if (this.overridable != null) goto L7;
        return false;
    L7:
        return this.overridable.booleanValue();
    }

    boolean hasOverridable() {
        if (this.overridable != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setOverridable(boolean overridable) {
        this.overridable = Boolean.valueOf(overridable);
    }

    public String getValue() {
        return this.value;
    }

    boolean hasValue() {
        if (this.value != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setValue(String value) {
        this.value = value;
    }

    static Change read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        Change _instance = new Change();
        String _raw = _parser.getAttributeValue(null, "id");
        if (_raw == null) goto L5;
        long _value = Long.parseLong(_raw);
        _instance.setId(_value);
    L5:
        String _raw2 = _parser.getAttributeValue(null, "name");
        if (_raw2 == null) goto L8;
        _instance.setName(_raw2);
    L8:
        String _raw3 = _parser.getAttributeValue(null, ServiceConfigAccessor.PROVIDER_MODE_DISABLED);
        if (_raw3 == null) goto L11;
        boolean _value2 = Boolean.parseBoolean(_raw3);
        _instance.setDisabled(_value2);
    L11:
        String _raw4 = _parser.getAttributeValue(null, "loggingOnly");
        if (_raw4 == null) goto L14;
        boolean _value3 = Boolean.parseBoolean(_raw4);
        _instance.setLoggingOnly(_value3);
    L14:
        String _raw5 = _parser.getAttributeValue(null, "enableAfterTargetSdk");
        if (_raw5 == null) goto L17;
        int _value4 = Integer.parseInt(_raw5);
        _instance.setEnableAfterTargetSdk(_value4);
    L17:
        String _raw6 = _parser.getAttributeValue(null, "enableSinceTargetSdk");
        if (_raw6 == null) goto L20;
        int _value5 = Integer.parseInt(_raw6);
        _instance.setEnableSinceTargetSdk(_value5);
    L20:
        String _raw7 = _parser.getAttributeValue(null, "description");
        if (_raw7 == null) goto L23;
        _instance.setDescription(_raw7);
    L23:
        String _raw8 = _parser.getAttributeValue(null, "overridable");
        if (_raw8 == null) goto L26;
        boolean _value6 = Boolean.parseBoolean(_raw8);
        _instance.setOverridable(_value6);
    L26:
        String _raw9 = XmlParser.readText(_parser);
        if (_raw9 == null) goto L29;
        _instance.setValue(_raw9);
    L29:
        return _instance;
    }
}
