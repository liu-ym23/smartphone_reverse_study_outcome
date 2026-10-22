package com.fasterxml.jackson.core.util;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes.dex */
public class Separators implements Serializable {
    public static final String DEFAULT_ARRAY_EMPTY_SEPARATOR = " ";
    public static final String DEFAULT_OBJECT_EMPTY_SEPARATOR = " ";
    public static final String DEFAULT_ROOT_VALUE_SEPARATOR = " ";
    private static final long serialVersionUID = 1;
    private final String arrayEmptySeparator;
    private final char arrayValueSeparator;
    private final Spacing arrayValueSpacing;
    private final String objectEmptySeparator;
    private final char objectEntrySeparator;
    private final Spacing objectEntrySpacing;
    private final char objectFieldValueSeparator;
    private final Spacing objectFieldValueSpacing;
    private final String rootSeparator;

    public enum Spacing {
        NONE("", ""),
        BEFORE(" ", ""),
        AFTER("", " "),
        BOTH(" ", " ");

        private final String spacesAfter;
        private final String spacesBefore;

        Spacing(String str, String str2) {
            this.spacesBefore = str;
            this.spacesAfter = str2;
        }

        public String apply(char c10) {
            return this.spacesBefore + c10 + this.spacesAfter;
        }

        public String spacesAfter() {
            return this.spacesAfter;
        }

        public String spacesBefore() {
            return this.spacesBefore;
        }
    }

    public Separators() {
        this(':', ',', ',');
    }

    public static Separators createDefaultInstance() {
        return new Separators();
    }

    public String getArrayEmptySeparator() {
        return this.arrayEmptySeparator;
    }

    public char getArrayValueSeparator() {
        return this.arrayValueSeparator;
    }

    public Spacing getArrayValueSpacing() {
        return this.arrayValueSpacing;
    }

    public String getObjectEmptySeparator() {
        return this.objectEmptySeparator;
    }

    public char getObjectEntrySeparator() {
        return this.objectEntrySeparator;
    }

    public Spacing getObjectEntrySpacing() {
        return this.objectEntrySpacing;
    }

    public char getObjectFieldValueSeparator() {
        return this.objectFieldValueSeparator;
    }

    public Spacing getObjectFieldValueSpacing() {
        return this.objectFieldValueSpacing;
    }

    public String getRootSeparator() {
        return this.rootSeparator;
    }

    public Separators withArrayEmptySeparator(String str) {
        return Objects.equals(this.arrayEmptySeparator, str) ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, this.objectFieldValueSpacing, this.objectEntrySeparator, this.objectEntrySpacing, this.objectEmptySeparator, this.arrayValueSeparator, this.arrayValueSpacing, str);
    }

    public Separators withArrayValueSeparator(char c10) {
        return this.arrayValueSeparator == c10 ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, this.objectFieldValueSpacing, this.objectEntrySeparator, this.objectEntrySpacing, this.objectEmptySeparator, c10, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    public Separators withArrayValueSpacing(Spacing spacing) {
        return this.arrayValueSpacing == spacing ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, this.objectFieldValueSpacing, this.objectEntrySeparator, this.objectEntrySpacing, this.objectEmptySeparator, this.arrayValueSeparator, spacing, this.arrayEmptySeparator);
    }

    public Separators withObjectEmptySeparator(String str) {
        return Objects.equals(this.objectEmptySeparator, str) ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, this.objectFieldValueSpacing, this.objectEntrySeparator, this.objectEntrySpacing, str, this.arrayValueSeparator, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    public Separators withObjectEntrySeparator(char c10) {
        return this.objectEntrySeparator == c10 ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, this.objectFieldValueSpacing, c10, this.objectEntrySpacing, this.objectEmptySeparator, this.arrayValueSeparator, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    public Separators withObjectEntrySpacing(Spacing spacing) {
        return this.objectEntrySpacing == spacing ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, this.objectFieldValueSpacing, this.objectEntrySeparator, spacing, this.objectEmptySeparator, this.arrayValueSeparator, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    public Separators withObjectFieldValueSeparator(char c10) {
        return this.objectFieldValueSeparator == c10 ? this : new Separators(this.rootSeparator, c10, this.objectFieldValueSpacing, this.objectEntrySeparator, this.objectEntrySpacing, this.objectEmptySeparator, this.arrayValueSeparator, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    public Separators withObjectFieldValueSpacing(Spacing spacing) {
        return this.objectFieldValueSpacing == spacing ? this : new Separators(this.rootSeparator, this.objectFieldValueSeparator, spacing, this.objectEntrySeparator, this.objectEntrySpacing, this.objectEmptySeparator, this.arrayValueSeparator, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    public Separators withRootSeparator(String str) {
        return Objects.equals(this.rootSeparator, str) ? this : new Separators(str, this.objectFieldValueSeparator, this.objectFieldValueSpacing, this.objectEntrySeparator, this.objectEntrySpacing, this.objectEmptySeparator, this.arrayValueSeparator, this.arrayValueSpacing, this.arrayEmptySeparator);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Separators(char c10, char c11, char c12) {
        Spacing spacing = Spacing.BOTH;
        Spacing spacing2 = Spacing.NONE;
        this(" ", c10, spacing, c11, spacing2, " ", c12, spacing2, " ");
    }

    @Deprecated
    public Separators(String str, char c10, Spacing spacing, char c11, Spacing spacing2, char c12, Spacing spacing3) {
        this(str, c10, spacing, c11, spacing2, " ", c12, spacing3, " ");
    }

    public Separators(String str, char c10, Spacing spacing, char c11, Spacing spacing2, String str2, char c12, Spacing spacing3, String str3) {
        this.rootSeparator = str;
        this.objectFieldValueSeparator = c10;
        this.objectFieldValueSpacing = spacing;
        this.objectEntrySeparator = c11;
        this.objectEntrySpacing = spacing2;
        this.objectEmptySeparator = str2;
        this.arrayValueSeparator = c12;
        this.arrayValueSpacing = spacing3;
        this.arrayEmptySeparator = str3;
    }
}
