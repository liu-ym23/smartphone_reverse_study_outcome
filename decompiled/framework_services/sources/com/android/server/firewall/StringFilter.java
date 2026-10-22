package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PatternMatcher;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import java.io.IOException;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
abstract class StringFilter implements Filter {
    public static final FilterFactory ACTION = null;
    private static final String ATTR_CONTAINS = "contains";
    private static final String ATTR_EQUALS = "equals";
    private static final String ATTR_IS_NULL = "isNull";
    private static final String ATTR_PATTERN = "pattern";
    private static final String ATTR_REGEX = "regex";
    private static final String ATTR_STARTS_WITH = "startsWith";
    public static final ValueProvider COMPONENT = null;
    public static final ValueProvider COMPONENT_NAME = null;
    public static final ValueProvider COMPONENT_PACKAGE = null;
    public static final ValueProvider DATA = null;
    public static final ValueProvider HOST = null;
    public static final ValueProvider MIME_TYPE = null;
    public static final ValueProvider PATH = null;
    public static final ValueProvider SCHEME = null;
    public static final ValueProvider SSP = null;
    private final ValueProvider mValueProvider;

    private static class ContainsFilter extends StringFilter {
        private final String mFilterValue;

        public ContainsFilter(ValueProvider valueProvider, String attrValue) {
            super(valueProvider, null);
            this.mFilterValue = attrValue;
        }

        @Override // com.android.server.firewall.StringFilter
        public boolean matchesValue(String value) {
            if (value != null) goto L4;
        L6:
            return false;
        L4:
            if (value.contains(this.mFilterValue) == false) goto L6;
            return true;
        }
    }

    private static class EqualsFilter extends StringFilter {
        private final String mFilterValue;

        public EqualsFilter(ValueProvider valueProvider, String attrValue) {
            super(valueProvider, null);
            this.mFilterValue = attrValue;
        }

        @Override // com.android.server.firewall.StringFilter
        public boolean matchesValue(String value) {
            if (value != null) goto L4;
        L6:
            return false;
        L4:
            if (value.equals(this.mFilterValue) == false) goto L6;
            return true;
        }
    }

    private static class IsNullFilter extends StringFilter {
        private final boolean mIsNull;

        public IsNullFilter(ValueProvider valueProvider, String attrValue) {
            super(valueProvider, null);
            this.mIsNull = Boolean.parseBoolean(attrValue);
        }

        public IsNullFilter(ValueProvider valueProvider, boolean isNull) {
            super(valueProvider, null);
            this.mIsNull = isNull;
        }

        @Override // com.android.server.firewall.StringFilter
        public boolean matchesValue(String value) {
            if (value != null) goto L5;
            boolean r2 = true;
        L7:
            if (r2 == this.mIsNull) goto L9;
            return false;
        L9:
            return true;
        L5:
            r2 = false;
            goto L7
        }
    }

    private static class PatternStringFilter extends StringFilter {
        private final PatternMatcher mPattern;

        public PatternStringFilter(ValueProvider valueProvider, String attrValue) {
            super(valueProvider, null);
            this.mPattern = new PatternMatcher(attrValue, 2);
        }

        @Override // com.android.server.firewall.StringFilter
        public boolean matchesValue(String value) {
            if (value != null) goto L4;
        L6:
            return false;
        L4:
            if (this.mPattern.match(value) == false) goto L6;
            return true;
        }
    }

    private static class RegexFilter extends StringFilter {
        private final Pattern mPattern;

        public RegexFilter(ValueProvider valueProvider, String attrValue) {
            super(valueProvider, null);
            this.mPattern = Pattern.compile(attrValue);
        }

        @Override // com.android.server.firewall.StringFilter
        public boolean matchesValue(String value) {
            if (value != null) goto L4;
        L6:
            return false;
        L4:
            if (this.mPattern.matcher(value).matches() == false) goto L6;
            return true;
        }
    }

    private static class StartsWithFilter extends StringFilter {
        private final String mFilterValue;

        public StartsWithFilter(ValueProvider valueProvider, String attrValue) {
            super(valueProvider, null);
            this.mFilterValue = attrValue;
        }

        @Override // com.android.server.firewall.StringFilter
        public boolean matchesValue(String value) {
            if (value != null) goto L4;
        L6:
            return false;
        L4:
            if (value.startsWith(this.mFilterValue) == false) goto L6;
            return true;
        }
    }

    private static abstract class ValueProvider extends FilterFactory {
        public abstract String getValue(ComponentName r1, Intent r2, String r3);

        protected ValueProvider(String tag) {
            super(tag);
        }

        @Override // com.android.server.firewall.FilterFactory
        public Filter newFilter(XmlPullParser parser) throws IOException, XmlPullParserException {
            return StringFilter.readFromXml(this, parser);
        }
    }

    /* synthetic */ StringFilter(ValueProvider r1, StringFilterIA r2) {
        this(r1);
    }

    protected abstract boolean matchesValue(String r1);

    private StringFilter(ValueProvider valueProvider) {
        this.mValueProvider = valueProvider;
    }

    public static StringFilter readFromXml(ValueProvider valueProvider, XmlPullParser parser) throws IOException, XmlPullParserException {
        StringFilter filter = null;
        int i = 0;
    L4:
        if (i >= parser.getAttributeCount()) goto L13;
        StringFilter newFilter = getFilter(valueProvider, parser, i);
        if (newFilter == null) goto L11;
        if (filter != null) goto L10;
        filter = newFilter;
        goto L11
    L10:
        throw new XmlPullParserException("Multiple string filter attributes found");
    L11:
        i = i + 1;
        goto L4
    L13:
        if (filter != null) goto L20;
        StringFilter filter2 = new IsNullFilter(valueProvider, false);
        return filter2;
    L20:
        return filter;
    }

    private static StringFilter getFilter(ValueProvider valueProvider, XmlPullParser parser, int attributeIndex) {
        String attributeName = parser.getAttributeName(attributeIndex);
        switch(attributeName.charAt(0)) {
            case 99: goto L31;
            case 101: goto L26;
            case 105: goto L21;
            case 112: goto L16;
            case 114: goto L11;
            case 115: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L6:
        if (attributeName.equals(ATTR_STARTS_WITH) == true) goto L9;
        return null;
    L9:
        return new StartsWithFilter(valueProvider, parser.getAttributeValue(attributeIndex));
    L11:
        if (attributeName.equals(ATTR_REGEX) == true) goto L14;
        return null;
    L14:
        return new RegexFilter(valueProvider, parser.getAttributeValue(attributeIndex));
    L16:
        if (attributeName.equals(ATTR_PATTERN) == true) goto L19;
        return null;
    L19:
        return new PatternStringFilter(valueProvider, parser.getAttributeValue(attributeIndex));
    L21:
        if (attributeName.equals(ATTR_IS_NULL) == true) goto L24;
        return null;
    L24:
        return new IsNullFilter(valueProvider, parser.getAttributeValue(attributeIndex));
    L26:
        if (attributeName.equals(ATTR_EQUALS) == true) goto L29;
        return null;
    L29:
        return new EqualsFilter(valueProvider, parser.getAttributeValue(attributeIndex));
    L31:
        if (attributeName.equals(ATTR_CONTAINS) == true) goto L34;
        return null;
    L34:
        return new ContainsFilter(valueProvider, parser.getAttributeValue(attributeIndex));
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        String value = this.mValueProvider.getValue(resolvedComponent, intent, resolvedType);
        return matchesValue(value);
    }

    static {
        final String r1 = "component";
        COMPONENT = new AnonymousClass1(r1);
        final String r2 = "component-name";
        COMPONENT_NAME = new AnonymousClass2(r2);
        final String r3 = "component-package";
        COMPONENT_PACKAGE = new AnonymousClass3(r3);
        final String r4 = DomainVerificationPersistence.ATTR_ACTION;
        ACTION = new AnonymousClass4(r4);
        final String r5 = "data";
        DATA = new AnonymousClass5(r5);
        final String r6 = "mime-type";
        MIME_TYPE = new AnonymousClass6(r6);
        final String r7 = "scheme";
        SCHEME = new AnonymousClass7(r7);
        final String r8 = "scheme-specific-part";
        SSP = new AnonymousClass8(r8);
        final String r9 = "host";
        HOST = new AnonymousClass9(r9);
        final String r10 = "path";
        PATH = new AnonymousClass10(r10);
    }
}
