package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/input/PasswordVisualTransformation;", "Landroidx/compose/ui/text/input/VisualTransformation;", BuyNowCloseMethod.MASK, "", "<init>", "(C)V", "getMask", "()C", "filter", "Landroidx/compose/ui/text/input/TransformedText;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "equals", "", "other", "", "hashCode", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PasswordVisualTransformation implements VisualTransformation {
    public static final int $stable = 0;
    private final char mask;

    public PasswordVisualTransformation() {
        char r100 = 0;
        this(r100, 1, null);
    }

    public final char getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask;
    }

    public PasswordVisualTransformation(char r100) {
        this.mask = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PasswordVisualTransformation) == true) goto L9;
        return false;
    L9:
        if (this.mask == ((PasswordVisualTransformation) r100).mask) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString r100) {
        return new TransformedText(new AnnotatedString(StringsKt.repeat(String.valueOf(this.mask), r100.getText().length()), null, 2, null), OffsetMapping.Companion.getIdentity());
    }

    public /* synthetic */ PasswordVisualTransformation(char r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = Typography.bullet;
    L5:
        this(r100);
    }
}
