package androidx.compose.ui.text.style;

import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0086\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextDecoration;", "", BuyNowCloseMethod.MASK, "", "<init>", "(I)V", "getMask", "()I", "plus", "decoration", "contains", "", "other", "toString", "", "equals", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextDecoration {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TextDecoration LineThrough = null;
    private static final TextDecoration None = null;
    private static final TextDecoration Underline = null;
    private final int mask;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\b¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/TextDecoration$Companion;", "", "<init>", "()V", "None", "Landroidx/compose/ui/text/style/TextDecoration;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/text/style/TextDecoration;", "Underline", "getUnderline$annotations", "getUnderline", "LineThrough", "getLineThrough$annotations", "getLineThrough", "combine", "decorations", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getLineThrough$annotations() {
        }

        public static /* synthetic */ void getNone$annotations() {
        }

        public static /* synthetic */ void getUnderline$annotations() {
        }

        public final TextDecoration getLineThrough() {
            return TextDecoration.access$getLineThrough$cp();
        }

        public final TextDecoration getNone() {
            return TextDecoration.access$getNone$cp();
        }

        public final TextDecoration getUnderline() {
            return TextDecoration.access$getUnderline$cp();
        }

        public final TextDecoration combine(List<TextDecoration> r100) {
            int r101 = 0;
            Integer r102 = 0;
            int r103 = r100.size();
        L3:
            if (r101 >= r103) goto L6;
            TextDecoration r104 = (TextDecoration) ListProtector.get(r100, r101);
            r102 = Integer.valueOf(r102.intValue() | r104.getMask());
            r101 = r101 + 1;
            goto L3
        L6:
            return new TextDecoration(r102.intValue());
        }
    }

    static {
        Companion = new Companion(null);
        None = new TextDecoration(0);
        Underline = new TextDecoration(1);
        LineThrough = new TextDecoration(2);
    }

    public String toString() {
        if (this.mask != 0) goto L6;
        return "TextDecoration.None";
    L6:
        ArrayList r100 = new ArrayList();
        if ((this.mask & Underline.mask) == 0) goto L10;
        r100.add("Underline");
    L10:
        if ((this.mask & LineThrough.mask) == 0) goto L13;
        r100.add("LineThrough");
    L13:
        if (r100.size() != 1) goto L17;
        return "TextDecoration." + ((String) ListProtector.get(r100, 0));
    L17:
        return "TextDecoration[" + ListUtilsKt.fastJoinToString$default(r100, ", ", null, null, 0, null, null, 62, null) + ']';
    }

    public static final /* synthetic */ TextDecoration access$getLineThrough$cp() {
        return LineThrough;
    }

    public static final /* synthetic */ TextDecoration access$getNone$cp() {
        return None;
    }

    public static final /* synthetic */ TextDecoration access$getUnderline$cp() {
        return Underline;
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask;
    }

    public TextDecoration(int r100) {
        this.mask = r100;
    }

    public final boolean contains(TextDecoration r100) {
        int r101 = this.mask;
        if ((r100.mask | r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextDecoration) == true) goto L9;
        return false;
    L9:
        if (this.mask == ((TextDecoration) r100).mask) goto L11;
        return false;
    L11:
        return true;
    }

    public final TextDecoration plus(TextDecoration r100) {
        int r101 = this.mask;
        return new TextDecoration(r100.mask | r101);
    }
}
