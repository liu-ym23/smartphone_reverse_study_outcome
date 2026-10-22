package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 1}, l = {351, 158}, m = "invokeSuspend", n = {"suggestedSelection", "$this$withLock_u24default$iv", "newSelection", "newSelection"}, s = {"L$0", "L$1", "J$0", "J$0"})
public final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super TextRange>, Object> {
    final /* synthetic */ long $selection;
    final /* synthetic */ CharSequence $text;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    public PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(CharSequence r100, long r101, PlatformSelectionBehaviorsImpl r102, Continuation<? super PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2> r103) {
        this.$text = r100;
        this.$selection = r101;
        this.this$0 = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 r102 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$text, this.$selection, this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TextClassifier r100, Continuation<? super TextRange> r101) {
        return ((PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(TextClassifier r100, Continuation<? super TextRange> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        long r102 = this.J$0;
        ResultKt.throwOnFailure(r110);
    L31:
        return TextRange.m6986boximpl(r102);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r102 = this.J$0;
        CharSequence r103 = (CharSequence) this.L$3;
        PlatformSelectionBehaviorsImpl r104 = (PlatformSelectionBehaviorsImpl) this.L$2;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) this.L$1;
        TextSelection r106 = (TextSelection) this.L$0;
        ResultKt.throwOnFailure(r110);
        CharSequence r111 = r103;
    L32:
        TextClassification r112 = r106.getTextClassification();     // Catch: Throwable -> L23
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L23
        PlatformSelectionBehaviorsImpl.access$setTextClassificationResult(r104, new TextClassificationResult(r111, r102, r112, null));     // Catch: Throwable -> L23
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r105.unlock(null);
    L23:
        th = move-exception;
        r105.unlock(null);
        throw th;
    L10:
        ResultKt.throwOnFailure(r110);
        TextClassifier r108 = (TextClassifier) this.L$0;
        TextSelection.Request.Builder r109 = new TextSelection.Request.Builder(this.$text, TextRange.m6996getMinimpl(this.$selection), TextRange.m6995getMaximpl(this.$selection)).setDefaultLocales(PlatformSelectionBehaviorsImpl.access$getAndroidLocalList(this.this$0));
        int r113 = Build.VERSION.SDK_INT;
        if (r113 < 31) goto L13;
        r109.setIncludeTextClassification(true);
    L13:
        TextSelection r114 = r108.suggestSelection(r109.build());
        long r115 = TextRangeKt.TextRange(r114.getSelectionStartIndex(), r114.getSelectionEndIndex());
        if (r113 >= 31) goto L16;
    L26:
        PlatformSelectionBehaviorsImpl r116 = this.this$0;
        CharSequence r117 = this.$text;
        this.J$0 = r115;
        this.label = 2;
        if (PlatformSelectionBehaviorsImpl.m1448access$classifyTextM8tDOmk(r116, r117, r115, r108, this) != r100) goto L29;
        return r100;
    L29:
        r102 = r115;
        goto L31
    L16:
        if (r114.getTextClassification() == null) goto L26;
        r105 = PlatformSelectionBehaviorsImpl.access$getMutex$p(this.this$0);
        PlatformSelectionBehaviorsImpl r118 = this.this$0;
        CharSequence r119 = this.$text;
        this.L$0 = r114;
        this.L$1 = r105;
        this.L$2 = r118;
        this.L$3 = r119;
        this.J$0 = r115;
        this.label = 1;
        if (r105.a(null, this) != r100) goto L20;
        return r100;
    L20:
        r104 = r118;
        r111 = r119;
        r106 = r114;
        r102 = r115;
        goto L32
    }
}
