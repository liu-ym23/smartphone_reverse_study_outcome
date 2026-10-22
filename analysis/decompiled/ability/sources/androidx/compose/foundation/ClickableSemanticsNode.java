package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJT\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0014\u001a\u00020\n*\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/ClickableSemanticsNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "", "enabled", "", "onClickLabel", "Landroidx/compose/ui/semantics/Role;", "role", "Lkotlin/Function0;", "LC7/r;", "onClick", "onLongClickLabel", "onLongClick", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;LS7/a;Ljava/lang/String;LS7/a;Lkotlin/jvm/internal/e;)V", "update-UMe6uN4", "(ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;LS7/a;Ljava/lang/String;LS7/a;)V", "update", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Z", "Ljava/lang/String;", "Landroidx/compose/ui/semantics/Role;", "LS7/a;", "getShouldMergeDescendantSemantics", "()Z", "shouldMergeDescendantSemantics", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ClickableSemanticsNode extends Modifier.Node implements SemanticsModifierNode {
    private boolean enabled;
    private S7.a onClick;
    private String onClickLabel;
    private S7.a onLongClick;
    private String onLongClickLabel;
    private Role role;

    public /* synthetic */ ClickableSemanticsNode(boolean z10, String str, Role role, S7.a aVar, String str2, S7.a aVar2, e eVar) {
        this(z10, str, role, aVar, str2, aVar2);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.role;
        if (role != null) {
            k.c(role);
            SemanticsPropertiesKt.m6100setRolekuIjeqM(semanticsPropertyReceiver, role.getValue());
        }
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, this.onClickLabel, new S7.a() { // from class: androidx.compose.foundation.ClickableSemanticsNode.applySemantics.1
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                ClickableSemanticsNode.this.onClick.invoke();
                return Boolean.TRUE;
            }
        });
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.onLongClickLabel, new S7.a() { // from class: androidx.compose.foundation.ClickableSemanticsNode.applySemantics.2
                {
                    super(0);
                }

                @Override // S7.a
                public final Boolean invoke() {
                    S7.a aVar = ClickableSemanticsNode.this.onLongClick;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    return Boolean.TRUE;
                }
            });
        }
        if (this.enabled) {
            return;
        }
        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    /* renamed from: update-UMe6uN4, reason: not valid java name */
    public final void m285updateUMe6uN4(boolean enabled, String onClickLabel, Role role, S7.a onClick, String onLongClickLabel, S7.a onLongClick) {
        this.enabled = enabled;
        this.onClickLabel = onClickLabel;
        this.role = role;
        this.onClick = onClick;
        this.onLongClickLabel = onLongClickLabel;
        this.onLongClick = onLongClick;
    }

    private ClickableSemanticsNode(boolean z10, String str, Role role, S7.a aVar, String str2, S7.a aVar2) {
        this.enabled = z10;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = aVar;
        this.onLongClickLabel = str2;
        this.onLongClick = aVar2;
    }
}
