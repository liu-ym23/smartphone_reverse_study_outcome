package androidx.compose.foundation.text.selection;

import android.app.RemoteAction;
import android.content.Context;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope_androidKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b\"\u0010#J \u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001eH\u0096@¢\u0006\u0004\b&\u0010#J(\u0010'\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b)\u0010*J<\u0010-\u001a\u00020%*\u00020.2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e2\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020%00¢\u0006\u0002\b1H\u0000¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b6\u00107J?\u00108\u001a\u0004\u0018\u0001H9\"\u0004\b\u0000\u001092'\u0010:\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H90<\u0012\u0006\u0012\u0004\u0018\u00010,0;¢\u0006\u0002\b1H\u0082@¢\u0006\u0002\u0010=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviorsImpl;", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "selectedTextType", "Landroidx/compose/foundation/text/selection/SelectedTextType;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroid/content/Context;Landroidx/compose/foundation/text/selection/SelectedTextType;Landroidx/compose/ui/text/intl/LocaleList;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "textClassificationSession", "Landroid/view/textclassifier/TextClassifier;", "<set-?>", "Landroidx/compose/foundation/text/selection/TextClassificationResult;", "textClassificationResult", "getTextClassificationResult", "()Landroidx/compose/foundation/text/selection/TextClassificationResult;", "setTextClassificationResult", "(Landroidx/compose/foundation/text/selection/TextClassificationResult;)V", "textClassificationResult$delegate", "Landroidx/compose/runtime/MutableState;", "androidLocalList", "Landroid/os/LocaleList;", "getAndroidLocalList", "()Landroid/os/LocaleList;", "suggestSelectionForLongPressOrDoubleClick", "Landroidx/compose/ui/text/TextRange;", "text", "", "selection", "suggestSelectionForLongPressOrDoubleClick-pYaCw-w", "(Ljava/lang/CharSequence;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onShowContextMenu", "", "onShowContextMenu-Sb-Bc2M", "classifyText", "textClassifier", "classifyText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroid/view/textclassifier/TextClassifier;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AssistantItemKey", "", "addSmartSelectionTextContextMenuItems", "Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation_release", "(Landroidx/compose/foundation/text/contextmenu/builder/TextContextMenuBuilderScope;Ljava/lang/CharSequence;JLkotlin/jvm/functions/Function1;)V", "tryGetTextClassification", "Landroid/view/textclassifier/TextClassification;", "tryGetTextClassification-FDrldGo", "(Ljava/lang/CharSequence;J)Landroid/view/textclassifier/TextClassification;", "requireTextClassificationSession", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformSelectionBehaviorsImpl implements PlatformSelectionBehaviors {
    public static final int $stable = 8;
    private final Object AssistantItemKey;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final LocaleList localeList;
    private final kotlinx.coroutines.sync.a mutex;
    private final SelectedTextType selectedTextType;
    private final MutableState textClassificationResult$delegate;
    private TextClassifier textClassificationSession;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2", f = "PlatformSelectionBehaviors.android.kt", i = {0, 1}, l = {351, 256, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$1", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
            final /* synthetic */ Function2<TextClassifier, Continuation<? super T>, Object> $block;
            final /* synthetic */ TextClassifier $textClassificationSession;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(TextClassifier r100, Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super AnonymousClass1> r102) {
                this.$textClassificationSession = r100;
                this.$block = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new AnonymousClass1(this.$textClassificationSession, this.$block, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
                return invoke(r100, (Continuation) r101);
            }

            public final Object invoke(CoroutineScope r100, Continuation<? super T> r101) {
                return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r102 = this.label;
                if (r102 == 0) goto L8;
                if (r102 != 1) goto L7;
                ResultKt.throwOnFailure(r100);
                return r100;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r100);
                TextClassifier r103 = this.$textClassificationSession;
                if (r103 == null) goto L13;
                Function2<TextClassifier, Continuation<? super T>, Object> r104 = this.$block;
                this.label = 1;
                Object r105 = r104.invoke(r103, this);
                if (r105 != r101) goto L16;
                return r101;
            L16:
                return r105;
            L13:
                return null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(PlatformSelectionBehaviorsImpl r100, Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$block = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$block, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
            return invoke(r100, (Continuation) r101);
        }

        public final Object invoke(CoroutineScope r100, Continuation<? super T> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L16;
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            ResultKt.throwOnFailure(r110);
        L32:
            return r110;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            kotlinx.coroutines.sync.a r102 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L13
        L27:
            TextClassifier r103 = (TextClassifier) r110;     // Catch: Throwable -> L13
            kotlinx.coroutines.sync.a r111 = r102;
        L29:
            r111.unlock(null);
            AnonymousClass1 r112 = new AnonymousClass1(r103, this.$block, null);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            r110 = TimeoutKt.c(200, r112, this);
            if (r110 != r100) goto L32;
            return r100;
        L13:
            Throwable th10 = th;
        L35:
            r102.unlock(null);
            throw th10;
        L15:
            PlatformSelectionBehaviorsImpl r104 = (PlatformSelectionBehaviorsImpl) this.L$1;
            kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r110);
            r111 = r105;
        L37:
            r103 = PlatformSelectionBehaviorsImpl.access$getTextClassificationSession$p(r104);     // Catch: Throwable -> L33
            if (r103 != null) goto L22;
        L23:
            PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1 r106 = new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1(r104, null);     // Catch: Throwable -> L33
            this.L$0 = r111;     // Catch: Throwable -> L33
            this.L$1 = null;     // Catch: Throwable -> L33
            this.label = 2;     // Catch: Throwable -> L33
            Object r107 = TimeoutKt.c(300, r106, this);     // Catch: Throwable -> L33
            if (r107 != r100) goto L26;
            return r100;
        L26:
            r102 = r111;
            r110 = r107;
            goto L27
        L22:
            if (r103.isDestroyed() == false) goto L29;
        L33:
            th = move-exception;
            r102 = r111;
            th10 = th;
            goto L35
        L16:
            ResultKt.throwOnFailure(r110);
            r111 = PlatformSelectionBehaviorsImpl.access$getMutex$p(this.this$0);
            r104 = this.this$0;
            this.L$0 = r111;
            this.L$1 = r104;
            this.label = 1;
            if (r111.a(null, this) != r100) goto L37;
            return r100;
        }
    }

    private final android.os.LocaleList getAndroidLocalList() {
        LocaleList r100 = this.localeList;
        if (r100 == null) goto L7;
        android.os.LocaleList r101 = TextClassifierHelperMethods.INSTANCE.toAndroidLocaleList(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new android.os.LocaleList(new Locale[]{androidx.compose.ui.text.intl.Locale.Companion.getCurrent().getPlatformLocale()});
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TextClassificationResult getTextClassificationResult() {
        return (TextClassificationResult) this.textClassificationResult$delegate.getValue();
    }

    public static final /* synthetic */ android.os.LocaleList access$getAndroidLocalList(PlatformSelectionBehaviorsImpl r100) {
        return r100.getAndroidLocalList();
    }

    public static final /* synthetic */ Context access$getContext$p(PlatformSelectionBehaviorsImpl r100) {
        return r100.context;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getMutex$p(PlatformSelectionBehaviorsImpl r100) {
        return r100.mutex;
    }

    public static final /* synthetic */ SelectedTextType access$getSelectedTextType$p(PlatformSelectionBehaviorsImpl r100) {
        return r100.selectedTextType;
    }

    public static final /* synthetic */ TextClassifier access$getTextClassificationSession$p(PlatformSelectionBehaviorsImpl r100) {
        return r100.textClassificationSession;
    }

    private final void setTextClassificationResult(TextClassificationResult r100) {
        this.textClassificationResult$delegate.setValue(r100);
    }

    public static final /* synthetic */ void access$setTextClassificationResult(PlatformSelectionBehaviorsImpl r100, TextClassificationResult r101) {
        r100.setTextClassificationResult(r101);
    }

    public static final /* synthetic */ void access$setTextClassificationSession$p(PlatformSelectionBehaviorsImpl r100, TextClassifier r101) {
        r100.textClassificationSession = r101;
    }

    private final <T> Object requireTextClassificationSession(Function2<? super TextClassifier, ? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r101) {
        return BuildersKt.withContext(this.coroutineContext, new AnonymousClass2(this, r100, null), r101);
    }

    /* JADX INFO: renamed from: tryGetTextClassification-FDrldGo, reason: not valid java name */
    public final TextClassification m1451tryGetTextClassificationFDrldGo(CharSequence r100, long r101) {
        if (this.mutex.b(null) == true) goto L5;
        return null;
    L5:
        TextClassificationResult r102 = getTextClassificationResult();
        if (r102 == null) goto L10;
        boolean r103 = PlatformSelectionBehaviors_androidKt.m1452access$canReuseh5sm0ck(r102, r100, r101);
        boolean r104 = true;
        if (r103 != true) goto L10;
    L11:
        if (r104 == false) goto L13;
        TextClassification r105 = r102.getTextClassification();
    L14:
        this.mutex.unlock(null);
        return r105;
    L13:
        r105 = null;
    L10:
        r104 = false;
        goto L11
    }

    public static final /* synthetic */ Object access$requireTextClassificationSession(PlatformSelectionBehaviorsImpl r100, Function2 r101, Continuation r102) {
        return r100.requireTextClassificationSession(r101, r102);
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* JADX INFO: renamed from: onShowContextMenu-Sb-Bc2M */
    public Object mo1446onShowContextMenuSbBc2M(CharSequence r100, long r101, Continuation<? super Unit> r110) {
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L13;
        if (TextRange.m6992getCollapsedimpl(r101) == true) goto L13;
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$onShowContextMenu$2(this, r100, r101, null), r110);
    L13:
        return Unit.INSTANCE;
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.text.selection.PlatformSelectionBehaviors
    /* JADX INFO: renamed from: suggestSelectionForLongPressOrDoubleClick-pYaCw-w */
    public Object mo1447suggestSelectionForLongPressOrDoubleClickpYaCww(CharSequence r100, long r101, Continuation<? super TextRange> r110) {
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return null;
    L8:
        if (TextRange.m6992getCollapsedimpl(r101) == false) goto L11;
        return null;
    L11:
        return requireTextClassificationSession(new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(r100, r101, this, null), r110);
    L5:
        r102 = false;
        goto L6
    }

    public PlatformSelectionBehaviorsImpl(CoroutineContext r100, Context r101, SelectedTextType r102, LocaleList r103) {
        this.coroutineContext = r100;
        this.context = r101;
        this.selectedTextType = r102;
        this.localeList = r103;
        this.mutex = kotlinx.coroutines.sync.b.a();
        this.textClassificationResult$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.AssistantItemKey = new Object();
    }

    /* JADX INFO: renamed from: classifyText-M8tDOmk, reason: not valid java name */
    private final Object m1449classifyTextM8tDOmk(CharSequence r210, long r211, TextClassifier r212, Continuation<? super Unit> r213) {
        if ((r213 instanceof PlatformSelectionBehaviorsImpl$classifyText$1) == false) goto L7;
        PlatformSelectionBehaviorsImpl$classifyText$1 r100 = (PlatformSelectionBehaviorsImpl$classifyText$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r106 = r100.J$0;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r100.L$2;
        TextClassification r108 = (TextClassification) r100.L$1;
        CharSequence r109 = (CharSequence) r100.L$0;
        ResultKt.throwOnFailure(r102);
        CharSequence r110 = r109;
        long r111 = r106;
        TextClassification r112 = r108;
    L44:
        setTextClassificationResult(new TextClassificationResult(r110, r111, r112, null));     // Catch: Throwable -> L38
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L38
        r107.unlock(null);
        return Unit.INSTANCE;
    L38:
        th = move-exception;
        r107.unlock(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r114 = r100.J$0;
        kotlinx.coroutines.sync.a r115 = (kotlinx.coroutines.sync.a) r100.L$2;
        TextClassifier r116 = (TextClassifier) r100.L$1;
        CharSequence r117 = (CharSequence) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L46:
        TextClassificationResult r118 = getTextClassificationResult();     // Catch: Throwable -> L41
        if (r118 != null) goto L23;
    L25:
        r105 = false;
    L26:
        if (r105 == false) goto L30;
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L41
        r115.unlock(null);
        return r119;
    L30:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L41
        r115.unlock(null);
        TextClassification r121 = r116.classifyText(new TextClassification.Request.Builder(r117, TextRange.m6996getMinimpl(r114), TextRange.m6995getMaximpl(r114)).setDefaultLocales(getAndroidLocalList()).build());
        kotlinx.coroutines.sync.a r122 = this.mutex;
        r100.L$0 = r117;
        r100.L$1 = r121;
        r100.L$2 = r122;
        r100.J$0 = r114;
        r100.label = 2;
        if (r122.a(null, r100) != r103) goto L34;
        return r103;
    L34:
        r107 = r122;
        r112 = r121;
        r111 = r114;
        r110 = r117;
        goto L44
    L23:
        if (PlatformSelectionBehaviors_androidKt.m1452access$canReuseh5sm0ck(r118, r117, r114) != true) goto L25;
    L41:
        th = move-exception;
        r115.unlock(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r102);
        r115 = this.mutex;
        r100.L$0 = r210;
        r100.L$1 = r212;
        r100.L$2 = r115;
        r100.J$0 = r211;
        r100.label = 1;
        if (r115.a(null, r100) != r103) goto L19;
        return r103;
    L19:
        r117 = r210;
        r116 = r212;
        r114 = r211;
    L7:
        r100 = new PlatformSelectionBehaviorsImpl$classifyText$1(this, r213);
        goto L8
    }

    /* JADX INFO: renamed from: addSmartSelectionTextContextMenuItems-YmzfRxQ$foundation_release, reason: not valid java name */
    public final void m1450addSmartSelectionTextContextMenuItemsYmzfRxQ$foundation_release(TextContextMenuBuilderScope r100, CharSequence r101, long r102, Function1<? super TextContextMenuBuilderScope, Unit> r103) {
        TextClassification r104 = m1451tryGetTextClassificationFDrldGo(r101, r102);
        if (r104 != null) goto L6;
        r103.invoke(r100);
        return;
    L6:
        int r105 = 0;
        if ((!r104.getActions().isEmpty()) == false) goto L10;
        TextContextMenuBuilderScope_androidKt.textClassificationItem(r100, this.AssistantItemKey, r104, 0);
    L12:
        r103.invoke(r100);
        List<RemoteAction> r106 = r104.getActions();
        int r107 = r106.size();
    L13:
        if (r105 >= r107) goto L18;
        RemoteAction r108 = (RemoteAction) ListProtector.get(r106, r105);
        if (r105 <= 0) goto L17;
        TextContextMenuBuilderScope_androidKt.textClassificationItem(r100, this.AssistantItemKey, r104, r105);
    L17:
        r105 = r105 + 1;
        goto L13
    L18:
        return;
    L10:
        if (TextClassifierHelperMethods.INSTANCE.hasLegacyAssistItem$foundation_release(r104) == false) goto L12;
        TextContextMenuBuilderScope_androidKt.textClassificationItem(r100, this.AssistantItemKey, r104, -1);
        goto L12
    }

    /* JADX INFO: renamed from: access$classifyText-M8tDOmk, reason: not valid java name */
    public static final /* synthetic */ Object m1448access$classifyTextM8tDOmk(PlatformSelectionBehaviorsImpl r100, CharSequence r101, long r102, TextClassifier r103, Continuation r104) {
        return r100.m1449classifyTextM8tDOmk(r101, r102, r103, r104);
    }
}
