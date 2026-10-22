package androidx.compose.foundation.text.input.internal.selection;

import C7.r;
import S7.a;
import S7.k;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "state", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "LC7/r;", "contextMenuBuilder", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/contextmenu/ContextMenuState;)LS7/k;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionState_androidKt {
    public static final k contextMenuBuilder(final TextFieldSelectionState textFieldSelectionState, final ContextMenuState contextMenuState) {
        return new k() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt.contextMenuBuilder.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextMenuScope) obj);
                return r.f317a;
            }

            public final void invoke(ContextMenuScope contextMenuScope) {
                final ContextMenuState contextMenuState2 = contextMenuState;
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.Cut;
                boolean zCanCut = textFieldSelectionState.canCut();
                final TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems), null, zCanCut, null, new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1330invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1330invoke() {
                        textFieldSelectionState2.cut();
                        ContextMenuState_androidKt.close(contextMenuState2);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState3 = contextMenuState;
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Copy;
                boolean zCanCopy = textFieldSelectionState.canCopy();
                final TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems2), null, zCanCopy, null, new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1331invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1331invoke() {
                        textFieldSelectionState3.copy(false);
                        ContextMenuState_androidKt.close(contextMenuState3);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState4 = contextMenuState;
                TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Paste;
                boolean zCanPaste = textFieldSelectionState.canPaste();
                final TextFieldSelectionState textFieldSelectionState4 = textFieldSelectionState;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems3), null, zCanPaste, null, new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1332invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1332invoke() {
                        textFieldSelectionState4.paste();
                        ContextMenuState_androidKt.close(contextMenuState4);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState5 = contextMenuState;
                TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.SelectAll;
                boolean zCanSelectAll = textFieldSelectionState.canSelectAll();
                final TextFieldSelectionState textFieldSelectionState5 = textFieldSelectionState;
                ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt.AnonymousClass1(textContextMenuItems4), null, zCanSelectAll, null, new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1333invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1333invoke() {
                        textFieldSelectionState5.selectAll();
                        ContextMenuState_androidKt.close(contextMenuState5);
                    }
                }, 10, null);
            }
        };
    }
}
