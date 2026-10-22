package com.android.server.compat.overrides;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ChangeOverrides {
    private Long changeId;
    private Deferred deferred;
    private Raw raw;
    private Validated validated;

    public static class Deferred {
        private List<OverrideValue> overrideValue;

        public Deferred() {
        }

        public List<OverrideValue> getOverrideValue() {
            if (this.overrideValue != null) goto L6;
            this.overrideValue = new ArrayList();
        L6:
            return this.overrideValue;
        }

        static Deferred read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
            Deferred _instance = new Deferred();
            _parser.getDepth();
        L3:
            int type = _parser.next();
            if (type == 1) goto L14;
            if (type == 3) goto L14;
            if (_parser.getEventType() != 2) goto L3;
            String _tagName = _parser.getName();
            if (_tagName.equals("override-value") == true) goto L11;
            XmlParser.skip(_parser);
            goto L3
        L11:
            OverrideValue _value = OverrideValue.read(_parser);
            _instance.getOverrideValue().add(_value);
        L14:
            if (type != 3) goto L17;
            return _instance;
        L17:
            throw new DatatypeConfigurationException("ChangeOverrides.Deferred is not closed");
        }

        void write(XmlWriter _out, String _name) throws IOException {
            _out.print("<" + _name);
            _out.print(">\n");
            _out.increaseIndent();
            Iterator<OverrideValue> r1 = getOverrideValue().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            OverrideValue value = r1.next();
            value.write(_out, "override-value");
            goto L4
        L6:
            _out.decreaseIndent();
            _out.print("</" + _name + ">\n");
        }
    }

    public static class Raw {
        private List<RawOverrideValue> rawOverrideValue;

        public Raw() {
        }

        public List<RawOverrideValue> getRawOverrideValue() {
            if (this.rawOverrideValue != null) goto L6;
            this.rawOverrideValue = new ArrayList();
        L6:
            return this.rawOverrideValue;
        }

        static Raw read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
            Raw _instance = new Raw();
            _parser.getDepth();
        L3:
            int type = _parser.next();
            if (type == 1) goto L14;
            if (type == 3) goto L14;
            if (_parser.getEventType() != 2) goto L3;
            String _tagName = _parser.getName();
            if (_tagName.equals("raw-override-value") == true) goto L11;
            XmlParser.skip(_parser);
            goto L3
        L11:
            RawOverrideValue _value = RawOverrideValue.read(_parser);
            _instance.getRawOverrideValue().add(_value);
        L14:
            if (type != 3) goto L17;
            return _instance;
        L17:
            throw new DatatypeConfigurationException("ChangeOverrides.Raw is not closed");
        }

        void write(XmlWriter _out, String _name) throws IOException {
            _out.print("<" + _name);
            _out.print(">\n");
            _out.increaseIndent();
            Iterator<RawOverrideValue> r1 = getRawOverrideValue().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            RawOverrideValue value = r1.next();
            value.write(_out, "raw-override-value");
            goto L4
        L6:
            _out.decreaseIndent();
            _out.print("</" + _name + ">\n");
        }
    }

    public static class Validated {
        private List<OverrideValue> overrideValue;

        public Validated() {
        }

        public List<OverrideValue> getOverrideValue() {
            if (this.overrideValue != null) goto L6;
            this.overrideValue = new ArrayList();
        L6:
            return this.overrideValue;
        }

        static Validated read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
            Validated _instance = new Validated();
            _parser.getDepth();
        L3:
            int type = _parser.next();
            if (type == 1) goto L14;
            if (type == 3) goto L14;
            if (_parser.getEventType() != 2) goto L3;
            String _tagName = _parser.getName();
            if (_tagName.equals("override-value") == true) goto L11;
            XmlParser.skip(_parser);
            goto L3
        L11:
            OverrideValue _value = OverrideValue.read(_parser);
            _instance.getOverrideValue().add(_value);
        L14:
            if (type != 3) goto L17;
            return _instance;
        L17:
            throw new DatatypeConfigurationException("ChangeOverrides.Validated is not closed");
        }

        void write(XmlWriter _out, String _name) throws IOException {
            _out.print("<" + _name);
            _out.print(">\n");
            _out.increaseIndent();
            Iterator<OverrideValue> r1 = getOverrideValue().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            OverrideValue value = r1.next();
            value.write(_out, "override-value");
            goto L4
        L6:
            _out.decreaseIndent();
            _out.print("</" + _name + ">\n");
        }
    }

    public ChangeOverrides() {
    }

    public Validated getValidated() {
        return this.validated;
    }

    boolean hasValidated() {
        if (this.validated != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setValidated(Validated validated) {
        this.validated = validated;
    }

    public Deferred getDeferred() {
        return this.deferred;
    }

    boolean hasDeferred() {
        if (this.deferred != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setDeferred(Deferred deferred) {
        this.deferred = deferred;
    }

    public Raw getRaw() {
        return this.raw;
    }

    boolean hasRaw() {
        if (this.raw != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setRaw(Raw raw) {
        this.raw = raw;
    }

    public long getChangeId() {
        if (this.changeId != null) goto L7;
        return 0;
    L7:
        return this.changeId.longValue();
    }

    boolean hasChangeId() {
        if (this.changeId != null) goto L6;
        return false;
    L6:
        return true;
    }

    public void setChangeId(long changeId) {
        this.changeId = Long.valueOf(changeId);
    }

    static ChangeOverrides read(XmlPullParser _parser) throws XmlPullParserException, IOException, DatatypeConfigurationException {
        ChangeOverrides _instance = new ChangeOverrides();
        String _raw = _parser.getAttributeValue(null, "changeId");
        if (_raw == null) goto L5;
        long _value = Long.parseLong(_raw);
        _instance.setChangeId(_value);
    L5:
        _parser.getDepth();
    L6:
        int type = _parser.next();
        if (type == 1) goto L23;
        if (type == 3) goto L23;
        if (_parser.getEventType() != 2) goto L6;
        String _tagName = _parser.getName();
        if (_tagName.equals("validated") == true) goto L14;
        if (_tagName.equals("deferred") == true) goto L17;
        if (_tagName.equals("raw") == true) goto L20;
        XmlParser.skip(_parser);
        goto L6
    L20:
        Raw _value2 = Raw.read(_parser);
        _instance.setRaw(_value2);
        goto L6
    L17:
        Deferred _value3 = Deferred.read(_parser);
        _instance.setDeferred(_value3);
        goto L6
    L14:
        Validated _value4 = Validated.read(_parser);
        _instance.setValidated(_value4);
    L23:
        if (type != 3) goto L26;
        return _instance;
    L26:
        throw new DatatypeConfigurationException("ChangeOverrides is not closed");
    }

    void write(XmlWriter _out, String _name) throws IOException {
        _out.print("<" + _name);
        if (hasChangeId() == false) goto L5;
        _out.print(" changeId=\"");
        _out.print(Long.toString(getChangeId()));
        _out.print("\"");
    L5:
        _out.print(">\n");
        _out.increaseIndent();
        if (hasValidated() == false) goto L9;
        getValidated().write(_out, "validated");
    L9:
        if (hasDeferred() == false) goto L12;
        getDeferred().write(_out, "deferred");
    L12:
        if (hasRaw() == false) goto L14;
        getRaw().write(_out, "raw");
    L14:
        _out.decreaseIndent();
        _out.print("</" + _name + ">\n");
    }
}
