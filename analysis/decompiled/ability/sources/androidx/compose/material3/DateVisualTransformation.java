package androidx.compose.material3;

import Y7.f;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import g1.AbstractC1451a;
import j9.m;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\b\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/DateVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "(Landroidx/compose/material3/internal/DateInputFormat;)V", "dateFormatLength", "", "dateOffsetTranslator", "androidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1", "Landroidx/compose/material3/DateVisualTransformation$dateOffsetTranslator$1;", "firstDelimiterOffset", "secondDelimiterOffset", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DateVisualTransformation implements VisualTransformation {
    private final int dateFormatLength;
    private final DateInputFormat dateInputFormat;
    private final DateVisualTransformation$dateOffsetTranslator$1 dateOffsetTranslator = new OffsetMapping() { // from class: androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1
        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int originalToTransformed(int offset) {
            return offset < this.this$0.firstDelimiterOffset ? offset : offset < this.this$0.secondDelimiterOffset ? offset + 1 : offset <= this.this$0.dateFormatLength ? offset + 2 : this.this$0.dateFormatLength + 2;
        }

        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int transformedToOriginal(int offset) {
            return offset <= this.this$0.firstDelimiterOffset + (-1) ? offset : offset <= this.this$0.secondDelimiterOffset + (-1) ? offset - 1 : offset <= this.this$0.dateFormatLength + 1 ? offset - 2 : this.this$0.dateFormatLength;
        }
    };
    private final int firstDelimiterOffset;
    private final int secondDelimiterOffset;

    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1] */
    public DateVisualTransformation(DateInputFormat dateInputFormat) {
        this.dateInputFormat = dateInputFormat;
        this.firstDelimiterOffset = m.p0(dateInputFormat.getPatternWithDelimiters(), dateInputFormat.getDelimiter(), 0, 6);
        this.secondDelimiterOffset = m.v0(dateInputFormat.getPatternWithDelimiters(), dateInputFormat.getDelimiter(), 0, 6);
        this.dateFormatLength = dateInputFormat.getPatternWithoutDelimiters().length();
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString text) {
        String text2;
        int i = 0;
        if (text.getText().length() > this.dateFormatLength) {
            String text3 = text.getText();
            f range = AbstractC1451a.X(0, this.dateFormatLength);
            k.f(text3, "<this>");
            k.f(range, "range");
            text2 = text3.substring(range.f1569a, range.b + 1);
            k.e(text2, "substring(...)");
        } else {
            text2 = text.getText();
        }
        String string = "";
        int i6 = 0;
        while (i < text2.length()) {
            int i10 = i6 + 1;
            String str = string + text2.charAt(i);
            if (i10 == this.firstDelimiterOffset || i6 + 2 == this.secondDelimiterOffset) {
                StringBuilder sbV = androidx.compose.foundation.b.v(str);
                sbV.append(this.dateInputFormat.getDelimiter());
                string = sbV.toString();
            } else {
                string = str;
            }
            i++;
            i6 = i10;
        }
        return new TransformedText(new AnnotatedString(string, null, null, 6, null), this.dateOffsetTranslator);
    }
}
