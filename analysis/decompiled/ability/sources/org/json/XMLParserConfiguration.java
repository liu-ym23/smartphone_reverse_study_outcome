package org.json;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class XMLParserConfiguration extends ParserConfiguration {
    private String cDataTagName;
    private boolean closeEmptyTag;
    private boolean convertNilAttributeToNull;
    private Set<String> forceList;
    private boolean shouldTrimWhiteSpace;
    private Map<String, XMLXsiTypeConverter<?>> xsiTypeMap;
    public static final XMLParserConfiguration ORIGINAL = new XMLParserConfiguration();
    public static final XMLParserConfiguration KEEP_STRINGS = new XMLParserConfiguration().withKeepStrings(true);

    public XMLParserConfiguration() {
        this.cDataTagName = "content";
        this.convertNilAttributeToNull = false;
        this.xsiTypeMap = Collections.EMPTY_MAP;
        this.forceList = Collections.EMPTY_SET;
        this.shouldTrimWhiteSpace = true;
    }

    public Set<String> getForceList() {
        return this.forceList;
    }

    public Map<String, XMLXsiTypeConverter<?>> getXsiTypeMap() {
        return this.xsiTypeMap;
    }

    public String getcDataTagName() {
        return this.cDataTagName;
    }

    public boolean isCloseEmptyTag() {
        return this.closeEmptyTag;
    }

    public boolean isConvertNilAttributeToNull() {
        return this.convertNilAttributeToNull;
    }

    public boolean shouldTrimWhiteSpace() {
        return this.shouldTrimWhiteSpace;
    }

    public XMLParserConfiguration withCloseEmptyTag(boolean z10) {
        XMLParserConfiguration xMLParserConfigurationClone = clone();
        xMLParserConfigurationClone.closeEmptyTag = z10;
        return xMLParserConfigurationClone;
    }

    public XMLParserConfiguration withConvertNilAttributeToNull(boolean z10) {
        XMLParserConfiguration xMLParserConfigurationClone = clone();
        xMLParserConfigurationClone.convertNilAttributeToNull = z10;
        return xMLParserConfigurationClone;
    }

    public XMLParserConfiguration withForceList(Set<String> set) {
        XMLParserConfiguration xMLParserConfigurationClone = clone();
        xMLParserConfigurationClone.forceList = Collections.unmodifiableSet(new HashSet(set));
        return xMLParserConfigurationClone;
    }

    public XMLParserConfiguration withShouldTrimWhitespace(boolean z10) {
        XMLParserConfiguration xMLParserConfigurationClone = clone();
        xMLParserConfigurationClone.shouldTrimWhiteSpace = z10;
        return xMLParserConfigurationClone;
    }

    public XMLParserConfiguration withXsiTypeMap(Map<String, XMLXsiTypeConverter<?>> map) {
        XMLParserConfiguration xMLParserConfigurationClone = clone();
        xMLParserConfigurationClone.xsiTypeMap = Collections.unmodifiableMap(new HashMap(map));
        return xMLParserConfigurationClone;
    }

    public XMLParserConfiguration withcDataTagName(String str) {
        XMLParserConfiguration xMLParserConfigurationClone = clone();
        xMLParserConfigurationClone.cDataTagName = str;
        return xMLParserConfigurationClone;
    }

    @Override // org.json.ParserConfiguration
    public XMLParserConfiguration withKeepStrings(boolean z10) {
        return (XMLParserConfiguration) super.withKeepStrings(z10);
    }

    @Override // org.json.ParserConfiguration
    public XMLParserConfiguration withMaxNestingDepth(int i) {
        return (XMLParserConfiguration) super.withMaxNestingDepth(i);
    }

    @Override // org.json.ParserConfiguration
    public XMLParserConfiguration clone() {
        XMLParserConfiguration xMLParserConfiguration = new XMLParserConfiguration(this.keepStrings, this.cDataTagName, this.convertNilAttributeToNull, this.xsiTypeMap, this.forceList, this.maxNestingDepth, this.closeEmptyTag);
        xMLParserConfiguration.shouldTrimWhiteSpace = this.shouldTrimWhiteSpace;
        return xMLParserConfiguration;
    }

    @Deprecated
    public XMLParserConfiguration(boolean z10) {
        this(z10, "content", false);
    }

    @Deprecated
    public XMLParserConfiguration(String str) {
        this(false, str, false);
    }

    @Deprecated
    public XMLParserConfiguration(boolean z10, String str) {
        super(z10, 512);
        this.cDataTagName = str;
        this.convertNilAttributeToNull = false;
    }

    @Deprecated
    public XMLParserConfiguration(boolean z10, String str, boolean z11) {
        super(z10, 512);
        this.cDataTagName = str;
        this.convertNilAttributeToNull = z11;
    }

    private XMLParserConfiguration(boolean z10, String str, boolean z11, Map<String, XMLXsiTypeConverter<?>> map, Set<String> set, int i, boolean z12) {
        super(z10, i);
        this.cDataTagName = str;
        this.convertNilAttributeToNull = z11;
        this.xsiTypeMap = Collections.unmodifiableMap(map);
        this.forceList = Collections.unmodifiableSet(set);
        this.closeEmptyTag = z12;
    }
}
