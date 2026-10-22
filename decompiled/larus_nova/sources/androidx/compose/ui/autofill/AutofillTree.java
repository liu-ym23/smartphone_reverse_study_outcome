package androidx.compose.ui.autofill;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "\n        Use the new semantics-based Autofill APIs androidx.compose.ui.autofill.ContentType and\n        androidx.compose.ui.autofill.ContentDataType instead.\n        ")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0086\u0002J\u001d\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/autofill/AutofillTree;", "", "<init>", "()V", "children", "", "", "Landroidx/compose/ui/autofill/AutofillNode;", "getChildren", "()Ljava/util/Map;", "plusAssign", "", "autofillNode", "performAutofill", "id", "value", "", "(ILjava/lang/String;)Lkotlin/Unit;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutofillTree {
    public static final int $stable = 8;
    private final Map<Integer, AutofillNode> children;

    public AutofillTree() {
        this.children = new LinkedHashMap();
    }

    public final Map<Integer, AutofillNode> getChildren() {
        return this.children;
    }

    public final void plusAssign(AutofillNode r100) {
        this.children.put(Integer.valueOf(r100.getId()), r100);
    }

    public final Unit performAutofill(int r100, String r101) {
        AutofillNode r102 = this.children.get(Integer.valueOf(r100));
        if (r102 == null) goto L7;
        Function1<String, Unit> r103 = r102.getOnFill();
        if (r103 == null) goto L7;
        r103.invoke(r101);
        return Unit.INSTANCE;
    L7:
        return null;
    }
}
