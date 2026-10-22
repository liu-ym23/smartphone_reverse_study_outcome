package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Be\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u001e\u0010\u000b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\tH\u0016J\u0006\u0010)\u001a\u00020\tJ\u0006\u0010*\u001a\u00020\tJ\u0017\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u0016¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020!H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R4\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u000b\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/foundation/text/contextmenu/provider/TextContextMenuDataProvider;", "requester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", SendEventContainerMethodParamModel.EventKinds.onShow, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "onHide", "computeContentBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getRequester", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setRequester", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "getOnShow", "()Lkotlin/jvm/functions/Function1;", "setOnShow", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "getOnHide", "setOnHide", "getComputeContentBounds", "setComputeContentBounds", "textToolbarJob", "Lkotlinx/coroutines/Job;", "derivedData", "Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "getDerivedData", "()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", "derivedData$delegate", "Landroidx/compose/runtime/State;", "previousContentBounds", "onAttach", "onDetach", "show", "hide", "position", "Landroidx/compose/ui/geometry/Offset;", "destinationCoordinates", "position-tuRUvjQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "contentBounds", "data", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextContextMenuToolbarHandlerNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, TextContextMenuDataProvider {
    public static final int $stable = 8;
    private Function1<? super LayoutCoordinates, Rect> computeContentBounds;
    private final State derivedData$delegate;
    private Function1<? super Continuation<? super Unit>, ? extends Object> onHide;
    private Function1<? super Continuation<? super Unit>, ? extends Object> onShow;
    private Rect previousContentBounds;
    private ToolbarRequester requester;
    private Job textToolbarJob;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$show$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$show$1", f = "TextContextMenuToolbarHandlerModifier.kt", i = {}, l = {182, 183, 185, 185}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextContextMenuProvider $provider;
        Object L$0;
        int label;
        final /* synthetic */ TextContextMenuToolbarHandlerNode this$0;

        public AnonymousClass1(TextContextMenuToolbarHandlerNode r100, TextContextMenuProvider r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$provider = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$provider, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L17;
            if (r102 == 1) goto L13;
            if (r102 == 2) goto L12;
            if (r102 == 3) goto L11;
            if (r102 != 4) goto L9;
            Throwable r103 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(r100);
        L40:
            throw r103;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r100);
        L32:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
        L26:
            Function1<Continuation<? super Unit>, Object> r104 = this.this$0.getOnHide();
            if (r104 == null) goto L32;
            this.label = 3;
            if (r104.invoke(this) != r101) goto L32;
            return r101;
        L13:
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
        L23:
            TextContextMenuProvider r105 = this.$provider;     // Catch: Throwable -> L15
            TextContextMenuToolbarHandlerNode r106 = this.this$0;     // Catch: Throwable -> L15
            this.label = 2;     // Catch: Throwable -> L15
            if (r105.showTextContextMenu(r106, this) != r101) goto L26;
            return r101;
        L17:
            ResultKt.throwOnFailure(r100);
            Function1<Continuation<? super Unit>, Object> r107 = this.this$0.getOnShow();     // Catch: Throwable -> L15
            if (r107 == null) goto L23;
            this.label = 1;     // Catch: Throwable -> L15
            if (r107.invoke(this) != r101) goto L23;
            return r101;
        L15:
            th = move-exception;
            Function1<Continuation<? super Unit>, Object> r108 = this.this$0.getOnHide();
            if (r108 == null) goto L42;
            this.L$0 = th;
            this.label = 4;
            if (r108.invoke(this) != r101) goto L38;
            return r101;
        L38:
            r103 = th;
            goto L40
        L42:
            throw th;
        }
    }

    public static /* synthetic */ TextContextMenuData a(TextContextMenuToolbarHandlerNode r100) {
        return derivedData_delegate$lambda$0(r100);
    }

    private final TextContextMenuData getDerivedData() {
        return (TextContextMenuData) this.derivedData$delegate.getValue();
    }

    public final void hide() {
        Job r100 = this.textToolbarJob;
        if (r100 != null) goto L5;
        return;
    L5:
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
        this.textToolbarJob = null;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.requester.setToolbarHandlerNode$foundation_release(null);
        super.onDetach();
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public TextContextMenuData data() {
        return getDerivedData();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.requester.setToolbarHandlerNode$foundation_release(this);
    }

    public final void show() {
        if (isAttached() == false) goto L16;
        Job r100 = this.textToolbarJob;
        boolean r101 = false;
        if (r100 != null) goto L7;
    L9:
        if (r101 == true) goto L17;
        TextContextMenuProvider r102 = (TextContextMenuProvider) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, TextContextMenuProviderKt.getLocalTextContextMenuToolbarProvider());
        if (r102 != null) goto L14;
        return;
    L14:
        this.textToolbarJob = BuildersKt.launch$default(getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, r102, null), 1, null);
        return;
    L17:
        return;
    L7:
        if (r100.isActive() != true) goto L9;
        r101 = true;
        goto L9
    }

    public final Function1<LayoutCoordinates, Rect> getComputeContentBounds() {
        return this.computeContentBounds;
    }

    public final Function1<Continuation<? super Unit>, Object> getOnHide() {
        return this.onHide;
    }

    public final Function1<Continuation<? super Unit>, Object> getOnShow() {
        return this.onShow;
    }

    public final ToolbarRequester getRequester() {
        return this.requester;
    }

    private static final TextContextMenuData derivedData_delegate$lambda$0(TextContextMenuToolbarHandlerNode r100) {
        if (r100.isAttached() == false) goto L6;
        return TextContextMenuModifierKt.collectTextContextMenuData(r100);
    L6:
        return TextContextMenuData.Companion.getEmpty();
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    public Rect contentBounds(LayoutCoordinates r100) {
        if (isAttached() == false) goto L5;
        Rect r101 = this.computeContentBounds.invoke(r100);
        if (r101 == null) goto L9;
        this.previousContentBounds = r101;
        return r101;
    L9:
        return this.previousContentBounds;
    L5:
        return this.previousContentBounds;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider
    /* JADX INFO: renamed from: position-tuRUvjQ */
    public long mo1183positiontuRUvjQ(LayoutCoordinates r100) {
        return contentBounds(r100).m4617getTopLeftF1C5BW0();
    }

    public final void setComputeContentBounds(Function1<? super LayoutCoordinates, Rect> r100) {
        this.computeContentBounds = r100;
    }

    public final void setOnHide(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        this.onHide = r100;
    }

    public final void setOnShow(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        this.onShow = r100;
    }

    public final void setRequester(ToolbarRequester r100) {
        this.requester = r100;
    }

    public TextContextMenuToolbarHandlerNode(ToolbarRequester r100, Function1<? super Continuation<? super Unit>, ? extends Object> r101, Function1<? super Continuation<? super Unit>, ? extends Object> r102, Function1<? super LayoutCoordinates, Rect> r103) {
        this.requester = r100;
        this.onShow = r101;
        this.onHide = r102;
        this.computeContentBounds = r103;
        this.derivedData$delegate = SnapshotStateKt.derivedStateOf(new d(this));
        this.previousContentBounds = Rect.Companion.getZero();
    }
}
