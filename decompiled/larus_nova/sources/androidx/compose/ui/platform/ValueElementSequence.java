package androidx.compose.ui.platform;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0002J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/platform/ValueElementSequence;", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "<init>", "()V", SlcElement.KEY_ELEMENTS, "", "iterator", "", "set", "", "name", "", "value", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ValueElementSequence implements Sequence<ValueElement> {
    public static final int $stable = 8;
    private final List<ValueElement> elements;

    @Override // kotlin.sequences.Sequence
    public Iterator<ValueElement> iterator() {
        return this.elements.iterator();
    }

    public ValueElementSequence() {
        this.elements = new ArrayList();
    }

    public final void set(String r100, Object r101) {
        this.elements.add(new ValueElement(r100, r101));
    }
}
