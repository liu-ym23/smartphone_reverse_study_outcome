package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/internal/DateInputFormat;", "", "patternWithDelimiters", "", "delimiter", "", "<init>", "(Ljava/lang/String;C)V", "getPatternWithDelimiters", "()Ljava/lang/String;", "getDelimiter", "()C", "patternWithoutDelimiters", "getPatternWithoutDelimiters", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DateInputFormat {
    public static final int $stable = 0;
    private final char delimiter;
    private final String patternWithDelimiters;
    private final String patternWithoutDelimiters;

    public static /* synthetic */ DateInputFormat copy$default(DateInputFormat r100, String r101, char r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.patternWithDelimiters;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.delimiter;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.patternWithDelimiters;
    }

    public final char component2() {
        return this.delimiter;
    }

    public final DateInputFormat copy(String r100, char r101) {
        return new DateInputFormat(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DateInputFormat) == true) goto L8;
        return false;
    L8:
        DateInputFormat r101 = (DateInputFormat) r100;
        if (Intrinsics.areEqual(this.patternWithDelimiters, r101.patternWithDelimiters) == true) goto L12;
        return false;
    L12:
        if (this.delimiter == r101.delimiter) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.patternWithDelimiters.hashCode() * 31) + this.delimiter;
    }

    public String toString() {
        return "DateInputFormat(patternWithDelimiters=" + this.patternWithDelimiters + ", delimiter=" + this.delimiter + ')';
    }

    public final char getDelimiter() {
        return this.delimiter;
    }

    public final String getPatternWithDelimiters() {
        return this.patternWithDelimiters;
    }

    public final String getPatternWithoutDelimiters() {
        return this.patternWithoutDelimiters;
    }

    public DateInputFormat(String r100, char r101) {
        this.patternWithDelimiters = r100;
        this.delimiter = r101;
        this.patternWithoutDelimiters = StringsKt.replace$default(r100, String.valueOf(r101), "", false, 4, null);
    }
}
