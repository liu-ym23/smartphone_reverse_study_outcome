package com.networknt.schema.keyword;

/* loaded from: classes2.dex */
public class DiscriminatorState {
    private String discriminatingValue;
    private String matchedSchema;
    private String propertyName;
    private String mappedSchema = null;
    private boolean explicitMapping = false;

    private static boolean isImplicitMatch(String str, String str2) {
        int iLastIndexOf;
        if (!str2.startsWith(".") && (iLastIndexOf = str.lastIndexOf(47)) != -1) {
            return str.substring(iLastIndexOf + 1).equals(str2);
        }
        return str.equals(str2);
    }

    public String getDiscriminatingValue() {
        return this.discriminatingValue;
    }

    public String getMappedSchema() {
        return this.mappedSchema;
    }

    public String getMatchedSchema() {
        return this.matchedSchema;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public boolean hasDiscriminatingValue() {
        return this.discriminatingValue != null;
    }

    public boolean hasMatchedSchema() {
        return this.matchedSchema != null;
    }

    public boolean isExplicitMapping() {
        return this.explicitMapping;
    }

    public boolean matches(String str) {
        String mappedSchema = getMappedSchema();
        if (mappedSchema == null) {
            return false;
        }
        if (isExplicitMapping() && str.equals(mappedSchema)) {
            setMatchedSchema(str);
            return true;
        }
        if (isExplicitMapping() || !isImplicitMatch(str, mappedSchema)) {
            return false;
        }
        setMatchedSchema(str);
        return true;
    }

    public void setDiscriminatingValue(String str) {
        this.discriminatingValue = str;
    }

    public void setExplicitMapping(boolean z10) {
        this.explicitMapping = z10;
    }

    public void setMappedSchema(String str) {
        this.mappedSchema = str;
    }

    public void setMatchedSchema(String str) {
        this.matchedSchema = str;
    }

    public void setPropertyName(String str) {
        this.propertyName = str;
    }
}
