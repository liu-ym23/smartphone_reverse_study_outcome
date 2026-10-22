package androidx.compose.ui.focus;

import C7.r;
import S7.k;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/focus/FocusRestorerNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusRequester;", "fallback", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/focus/FocusRequester;)V", "Landroidx/compose/ui/focus/FocusProperties;", "focusProperties", "LC7/r;", "applyFocusProperties", "(Landroidx/compose/ui/focus/FocusProperties;)V", "onDetach", "()V", "Landroidx/compose/ui/focus/FocusRequester;", "getFallback", "()Landroidx/compose/ui/focus/FocusRequester;", "setFallback", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "pinnedHandle", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "onExit", "LS7/k;", "onEnter", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusRestorerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;
    private FocusRequester fallback;
    private PinnableContainer.PinnedHandle pinnedHandle;
    private final k onExit = new k() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onExit$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusEnterExitScope) obj);
            return r.f317a;
        }

        public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            FocusRequesterModifierNodeKt.saveFocusedChild(this.this$0);
            if (ComposeUiFlags.isNoPinningInFocusRestorationEnabled) {
                return;
            }
            PinnableContainer.PinnedHandle pinnedHandle = this.this$0.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            FocusRestorerNode focusRestorerNode = this.this$0;
            focusRestorerNode.pinnedHandle = FocusRequesterModifierNodeKt.pinFocusedChild(focusRestorerNode);
        }
    };
    private final k onEnter = new k() { // from class: androidx.compose.ui.focus.FocusRestorerNode$onEnter$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusEnterExitScope) obj);
            return r.f317a;
        }

        public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            if (!ComposeUiFlags.isNoPinningInFocusRestorationEnabled) {
                PinnableContainer.PinnedHandle pinnedHandle = this.this$0.pinnedHandle;
                if (pinnedHandle != null) {
                    pinnedHandle.release();
                }
                this.this$0.pinnedHandle = null;
            }
            if (FocusRequesterModifierNodeKt.restoreFocusedChild(this.this$0)) {
                return;
            }
            FocusRequester fallback = this.this$0.getFallback();
            FocusRequester.Companion companion = FocusRequester.INSTANCE;
            if (kotlin.jvm.internal.k.b(fallback, companion.getDefault())) {
                return;
            }
            if (kotlin.jvm.internal.k.b(this.this$0.getFallback(), companion.getCancel())) {
                focusEnterExitScope.cancelFocusChange();
            } else {
                FocusRequester.m3800requestFocus3ESFkO8$default(this.this$0.getFallback(), 0, 1, null);
            }
        }
    };

    public FocusRestorerNode(FocusRequester focusRequester) {
        this.fallback = focusRequester;
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setOnEnter(this.onEnter);
        focusProperties.setOnExit(this.onExit);
    }

    public final FocusRequester getFallback() {
        return this.fallback;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        if (!ComposeUiFlags.isNoPinningInFocusRestorationEnabled) {
            PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            this.pinnedHandle = null;
        }
        super.onDetach();
    }

    public final void setFallback(FocusRequester focusRequester) {
        this.fallback = focusRequester;
    }
}
