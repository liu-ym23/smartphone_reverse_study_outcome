package androidx.compose.ui.focus;

import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "fallback", "Landroidx/compose/ui/focus/FocusRequester;", "<init>", "(Landroidx/compose/ui/focus/FocusRequester;)V", "getFallback", "()Landroidx/compose/ui/focus/FocusRequester;", "setFallback", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", d.f25928r, "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "onEnter", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "onDetach", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FocusRestorerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;
    private FocusRequester fallback;
    private final Function1<FocusEnterExitScope, Unit> onEnter;
    private final Function1<FocusEnterExitScope, Unit> onExit;
    private PinnableContainer.PinnedHandle pinnedHandle;

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        if (ComposeUiFlags.isNoPinningInFocusRestorationEnabled == true) goto L8;
        PinnableContainer.PinnedHandle r100 = this.pinnedHandle;
        if (r100 == null) goto L7;
        r100.release();
    L7:
        this.pinnedHandle = null;
    L8:
        super.onDetach();
    }

    public final FocusRequester getFallback() {
        return this.fallback;
    }

    public FocusRestorerNode(FocusRequester r100) {
        this.fallback = r100;
        this.onExit = new FocusRestorerNode$onExit$1(this);
        this.onEnter = new FocusRestorerNode$onEnter$1(this);
    }

    public static final /* synthetic */ PinnableContainer.PinnedHandle access$getPinnedHandle$p(FocusRestorerNode r100) {
        return r100.pinnedHandle;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties r100) {
        r100.setOnEnter(this.onEnter);
        r100.setOnExit(this.onExit);
    }

    public final void setFallback(FocusRequester r100) {
        this.fallback = r100;
    }

    public static final /* synthetic */ void access$setPinnedHandle$p(FocusRestorerNode r100, PinnableContainer.PinnedHandle r101) {
        r100.pinnedHandle = r101;
    }
}
