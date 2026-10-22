package com.uxsense.search;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/uxsense/search/MatchedField;", "", "fieldName", "", "fieldValue", "matchedPart", "startIndex", "", "endIndex", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getFieldName", "()Ljava/lang/String;", "getFieldValue", "getMatchedPart", "getStartIndex", "()I", "getEndIndex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class MatchedField {
    private final int endIndex;
    private final String fieldName;
    private final String fieldValue;
    private final String matchedPart;
    private final int startIndex;

    public MatchedField(String fieldName, String fieldValue, String matchedPart, int i, int i6) {
        k.f(fieldName, "fieldName");
        k.f(fieldValue, "fieldValue");
        k.f(matchedPart, "matchedPart");
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.matchedPart = matchedPart;
        this.startIndex = i;
        this.endIndex = i6;
    }

    public static /* synthetic */ MatchedField copy$default(MatchedField matchedField, String str, String str2, String str3, int i, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = matchedField.fieldName;
        }
        if ((i10 & 2) != 0) {
            str2 = matchedField.fieldValue;
        }
        if ((i10 & 4) != 0) {
            str3 = matchedField.matchedPart;
        }
        if ((i10 & 8) != 0) {
            i = matchedField.startIndex;
        }
        if ((i10 & 16) != 0) {
            i6 = matchedField.endIndex;
        }
        int i11 = i6;
        String str4 = str3;
        return matchedField.copy(str, str2, str4, i, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFieldName() {
        return this.fieldName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFieldValue() {
        return this.fieldValue;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMatchedPart() {
        return this.matchedPart;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStartIndex() {
        return this.startIndex;
    }

    /* renamed from: component5, reason: from getter */
    public final int getEndIndex() {
        return this.endIndex;
    }

    public final MatchedField copy(String fieldName, String fieldValue, String matchedPart, int startIndex, int endIndex) {
        k.f(fieldName, "fieldName");
        k.f(fieldValue, "fieldValue");
        k.f(matchedPart, "matchedPart");
        return new MatchedField(fieldName, fieldValue, matchedPart, startIndex, endIndex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatchedField)) {
            return false;
        }
        MatchedField matchedField = (MatchedField) other;
        return k.b(this.fieldName, matchedField.fieldName) && k.b(this.fieldValue, matchedField.fieldValue) && k.b(this.matchedPart, matchedField.matchedPart) && this.startIndex == matchedField.startIndex && this.endIndex == matchedField.endIndex;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final String getFieldValue() {
        return this.fieldValue;
    }

    public final String getMatchedPart() {
        return this.matchedPart;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public int hashCode() {
        return Integer.hashCode(this.endIndex) + a.a(this.startIndex, B7.a.c(B7.a.c(this.fieldName.hashCode() * 31, 31, this.fieldValue), 31, this.matchedPart), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MatchedField(fieldName=");
        sb.append(this.fieldName);
        sb.append(", fieldValue=");
        sb.append(this.fieldValue);
        sb.append(", matchedPart=");
        sb.append(this.matchedPart);
        sb.append(", startIndex=");
        sb.append(this.startIndex);
        sb.append(", endIndex=");
        return B7.a.o(sb, this.endIndex, ')');
    }

    public /* synthetic */ MatchedField(String str, String str2, String str3, int i, int i6, int i10, e eVar) {
        this(str, str2, str3, (i10 & 8) != 0 ? -1 : i, (i10 & 16) != 0 ? -1 : i6);
    }
}
