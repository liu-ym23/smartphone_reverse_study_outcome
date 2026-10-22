package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u001d\u001eB'\u0012\u001e\u0010\u0004\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0015\u001a\u00020\u00072\u001e\u0010\u0004\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cR(\u0010\u0004\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR/\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "onPreShowContextMenu", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "localCoordinates", "getLocalCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLocalCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "localCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "update", "onGloballyPositioned", "coordinates", "tryShowContextMenu", "localClickOffset", "Landroidx/compose/ui/geometry/Offset;", "tryShowContextMenu-k-4lQ0M", "(J)V", "Companion", "ClickTextContextMenuDataProvider", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TextContextMenuGestureNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, GlobalPositionAwareModifierNode {
    private static final Companion Companion = null;
    private static final String MESSAGE = "Tried to open context menu before the anchor was placed.";
    private final MutableState localCoordinates$delegate;
    private Function1<? super Continuation<? super Unit>, ? extends Object> onPreShowContextMenu;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode$ClickTextContextMenuDataProvider;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "localClickOffset", "Landroidx/compose/ui/geometry/Offset;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "position", "destinationCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "position-tuRUvjQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "contentBounds", "Landroidx/compose/ui/geometry/Rect;", "data", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ClickTextContextMenuDataProvider implements TextContextMenuDataProvider {
        private final long localClickOffset;
        final /* synthetic */ TextContextMenuGestureNode this$0;

        public /* synthetic */ ClickTextContextMenuDataProvider(TextContextMenuGestureNode r100, long r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
        public TextContextMenuData data() {
            return TextContextMenuModifierKt.collectTextContextMenuData(this.this$0);
        }

        @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
        public Rect contentBounds(LayoutCoordinates r100) {
            return RectKt.m4622Recttz77jQw(mo1183positiontuRUvjQ(r100), Size.Companion.m4660getZeroNHjbRc());
        }

        @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
        /* JADX INFO: renamed from: position-tuRUvjQ, reason: not valid java name */
        public long mo1183positiontuRUvjQ(LayoutCoordinates r100) {
            LayoutCoordinates r101 = TextContextMenuGestureNode.access$getLocalCoordinates(this.this$0);
            if (r101 != null) goto L5;
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(TextContextMenuGestureNode.MESSAGE);
            throw new KotlinNothingValueException();
        L5:
            return r100.mo6259localPositionOfR5De75A(r101, this.localClickOffset);
        }

        private ClickTextContextMenuDataProvider(TextContextMenuGestureNode r100, long r101) {
            this.this$0 = r100;
            this.localClickOffset = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuGestureNode$Companion;", "", "<init>", "()V", "MESSAGE", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final LayoutCoordinates getLocalCoordinates() {
        return (LayoutCoordinates) this.localCoordinates$delegate.getValue();
    }

    public TextContextMenuGestureNode(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        this.onPreShowContextMenu = r100;
        this.localCoordinates$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(this)));
    }

    public static final /* synthetic */ LayoutCoordinates access$getLocalCoordinates(TextContextMenuGestureNode r100) {
        return r100.getLocalCoordinates();
    }

    public static final /* synthetic */ Function1 access$getOnPreShowContextMenu$p(TextContextMenuGestureNode r100) {
        return r100.onPreShowContextMenu;
    }

    private final void setLocalCoordinates(LayoutCoordinates r100) {
        this.localCoordinates$delegate.setValue(r100);
    }

    /* JADX INFO: renamed from: tryShowContextMenu-k-4lQ0M, reason: not valid java name */
    private final void m1181tryShowContextMenuk4lQ0M(long r110) {
        TextContextMenuProvider r100 = (TextContextMenuProvider) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextContextMenuProviderKt.getLocalTextContextMenuDropdownProvider());
        if (r100 != null) goto L5;
        return;
    L5:
        ClickTextContextMenuDataProvider r101 = new ClickTextContextMenuDataProvider(this, r110, null);
        BuildersKt.launch$default(getCoroutineScope(), null, null, new TextContextMenuGestureNode$tryShowContextMenu$1(this, r100, r101, null), 3, null);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates r100) {
        setLocalCoordinates(r100);
    }

    public final void update(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        this.onPreShowContextMenu = r100;
    }

    /* JADX INFO: renamed from: access$tryShowContextMenu-k-4lQ0M, reason: not valid java name */
    public static final /* synthetic */ void m1180access$tryShowContextMenuk4lQ0M(TextContextMenuGestureNode r100, long r101) {
        r100.m1181tryShowContextMenuk4lQ0M(r101);
    }
}
