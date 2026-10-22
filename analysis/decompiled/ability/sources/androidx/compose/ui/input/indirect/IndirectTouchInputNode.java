package androidx.compose.ui.input.indirect;

import S7.k;
import androidx.compose.ui.ExperimentalIndirectTouchTypeApi;
import androidx.compose.ui.Modifier;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@ExperimentalIndirectTouchTypeApi
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fR0\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/input/indirect/IndirectTouchInputNode;", "Landroidx/compose/ui/input/indirect/IndirectTouchInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "", "onEvent", "onPreEvent", AppAgent.CONSTRUCT, "(LS7/k;LS7/k;)V", NotificationCompat.CATEGORY_EVENT, "onIndirectTouchEvent", "(Landroidx/compose/ui/input/indirect/IndirectTouchEvent;)Z", "onPreIndirectTouchEvent", "LS7/k;", "getOnEvent", "()LS7/k;", "setOnEvent", "(LS7/k;)V", "getOnPreEvent", "setOnPreEvent", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class IndirectTouchInputNode extends Modifier.Node implements IndirectTouchInputModifierNode {
    private k onEvent;
    private k onPreEvent;

    public IndirectTouchInputNode(k kVar, k kVar2) {
        this.onEvent = kVar;
        this.onPreEvent = kVar2;
    }

    public final k getOnEvent() {
        return this.onEvent;
    }

    public final k getOnPreEvent() {
        return this.onPreEvent;
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchInputModifierNode
    public boolean onIndirectTouchEvent(IndirectTouchEvent event) {
        k kVar = this.onEvent;
        return kVar != null && ((Boolean) kVar.invoke(event)).booleanValue();
    }

    @Override // androidx.compose.ui.input.indirect.IndirectTouchInputModifierNode
    public boolean onPreIndirectTouchEvent(IndirectTouchEvent event) {
        k kVar = this.onPreEvent;
        return kVar != null && ((Boolean) kVar.invoke(event)).booleanValue();
    }

    public final void setOnEvent(k kVar) {
        this.onEvent = kVar;
    }

    public final void setOnPreEvent(k kVar) {
        this.onPreEvent = kVar;
    }
}
