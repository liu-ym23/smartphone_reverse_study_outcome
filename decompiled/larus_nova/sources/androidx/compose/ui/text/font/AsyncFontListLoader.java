package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.f2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u0004\u0018\u00010\u0002*\u00020\u0005H\u0080@¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Landroidx/compose/ui/text/font/AsyncFontListLoader;", "Landroidx/compose/runtime/State;", "", "fontList", "", "Landroidx/compose/ui/text/font/Font;", "initialType", "typefaceRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "onCompletion", "Lkotlin/Function1;", "Landroidx/compose/ui/text/font/TypefaceResult$Immutable;", "", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "<init>", "(Ljava/util/List;Ljava/lang/Object;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/font/PlatformFontLoader;)V", "<set-?>", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "cacheable", "", "getCacheable$ui_text", "()Z", "setCacheable$ui_text", "(Z)V", "load", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWithTimeoutOrNull", "loadWithTimeoutOrNull$ui_text", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AsyncFontListLoader implements State<Object> {
    public static final int $stable = 0;
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;
    private final List<Font> fontList;
    private final Function1<TypefaceResult.Immutable, Unit> onCompletion;
    private final PlatformFontLoader platformFontLoader;
    private final TypefaceRequest typefaceRequest;
    private final MutableState value$delegate;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncFontListLoader$load$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.AsyncFontListLoader", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0, 0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD}, m = "load", n = {"$this$fastForEach$iv", LynxResourceModule.FONT_TYPE, "index$iv", "$this$fastForEach$iv", "index$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "I$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AsyncFontListLoader this$0;

        public AnonymousClass1(AsyncFontListLoader r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.load(this);
        }
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    public final boolean getCacheable$ui_text() {
        return this.cacheable;
    }

    public static final /* synthetic */ PlatformFontLoader access$getPlatformFontLoader$p(AsyncFontListLoader r100) {
        return r100.platformFontLoader;
    }

    private void setValue(Object r100) {
        this.value$delegate.setValue(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00f1 -> B:39:0x00f4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00fd -> B:45:0x00ff). Please report as a decompilation issue!!! */
    public final Object load(Continuation<? super Unit> r210) {
        if ((r210 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r100 = (AnonymousClass1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L16;
        int r105 = r100.I$1;
        int r106 = r100.I$0;
        List<Font> r110 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L50
        AsyncFontListLoader r111 = this;
    L39:
        int r112 = r106;
        List<Font> r107 = r110;
    L45:
        r112 = r112 + 1;
    L23:
        if (r112 < r105) goto L54;
        boolean r108 = JobKt.isActive(r100.getContext());
        r111.cacheable = false;
        r111.onCompletion.invoke(new TypefaceResult.Immutable(r111.getValue(), r108));
        return Unit.INSTANCE;
    L54:
        Font r113 = r107.get(r112);     // Catch: Throwable -> L46
        if (FontLoadingStrategy.m7099equalsimpl0(r113.mo7054getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m7103getAsyncPKNRLFQ()) == false) goto L45;
        AsyncTypefaceCache r109 = r111.asyncTypefaceCache;     // Catch: Throwable -> L46
        PlatformFontLoader r114 = r111.platformFontLoader;     // Catch: Throwable -> L46
        AsyncFontListLoader$load$2$typeface$1 r115 = new AsyncFontListLoader$load$2$typeface$1(r111, r113, null);     // Catch: Throwable -> L46
        r100.L$0 = r107;     // Catch: Throwable -> L46
        r100.L$1 = r113;     // Catch: Throwable -> L46
        r100.I$0 = r112;     // Catch: Throwable -> L46
        r100.I$1 = r105;     // Catch: Throwable -> L46
        r100.label = 1;     // Catch: Throwable -> L46
        AsyncFontListLoader r116 = r111;
        Object r117 = r109.runCached(r113, r114, false, r115, r100);     // Catch: Throwable -> L42
        if (r117 != r103) goto L31;
        return r103;
    L31:
        r110 = r107;
        r102 = r117;
        r106 = r112;
        Font r118 = r113;
        r111 = r116;
    L32:
        if (r102 == null) goto L57;
        r111.setValue(FontSynthesis_androidKt.m7133synthesizeTypefaceFxwP2eA(r111.typefaceRequest.m7158getFontSynthesisGVVA2EU(), r102, r118, r111.typefaceRequest.getFontWeight(), r111.typefaceRequest.m7157getFontStyle_LCdwA()));     // Catch: Throwable -> L40
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L40
        boolean r120 = JobKt.isActive(r100.getContext());
        r111.cacheable = false;
        r111.onCompletion.invoke(new TypefaceResult.Immutable(r111.getValue(), r120));
        return r119;
    L40:
        th = th;
    L52:
        boolean r121 = JobKt.isActive(r100.getContext());
        r111.cacheable = false;
        r111.onCompletion.invoke(new TypefaceResult.Immutable(r111.getValue(), r121));
        throw th;
    L57:
        r100.L$0 = r110;     // Catch: Throwable -> L40
        r100.L$1 = null;     // Catch: Throwable -> L40
        r100.I$0 = r106;     // Catch: Throwable -> L40
        r100.I$1 = r105;     // Catch: Throwable -> L40
        r100.label = 2;     // Catch: Throwable -> L40
        if (f2.a(r100) != r103) goto L39;
        return r103;
    L42:
        th = th;
        r111 = r116;
    L46:
        th = th;
        goto L52
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r105 = r100.I$1;
        r106 = r100.I$0;
        Font r122 = (Font) r100.L$1;
        List<Font> r123 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L50
        r111 = this;
        r118 = r122;
        r110 = r123;
        goto L32
    L20:
        ResultKt.throwOnFailure(r102);
        r107 = this.fontList;     // Catch: Throwable -> L50
        r105 = r107.size();     // Catch: Throwable -> L50
        r111 = this;
        r112 = 0;
    L50:
        th = th;
        r111 = this;
    L7:
        r100 = new AnonymousClass1(this, r210);
        goto L8
    }

    public final void setCacheable$ui_text(boolean r100) {
        this.cacheable = r100;
    }

    public final Object loadWithTimeoutOrNull$ui_text(Font r100, Continuation<Object> r101) {
        if ((r101 instanceof AsyncFontListLoader$loadWithTimeoutOrNull$1) == false) goto L7;
        AsyncFontListLoader$loadWithTimeoutOrNull$1 r102 = (AsyncFontListLoader$loadWithTimeoutOrNull$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        Object r107 = null;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (Font) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L21 CancellationException -> L25
    L20:
        r107 = r104;
        return r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        AsyncFontListLoader$loadWithTimeoutOrNull$2 r108 = new AsyncFontListLoader$loadWithTimeoutOrNull$2(this, r100, null);     // Catch: Exception -> L21 CancellationException -> L25
        r102.L$0 = r100;     // Catch: Exception -> L21 CancellationException -> L25
        r102.label = 1;     // Catch: Exception -> L21 CancellationException -> L25
        r104 = TimeoutKt.c(15000, r108, r102);     // Catch: Exception -> L21 CancellationException -> L25
        if (r104 != r105) goto L20;
        return r105;
    L25:
        e = move-exception;
        if (JobKt.isActive(r102.getContext()) == true) goto L34;
        throw e;
    L34:
        return r107;
    L21:
        e = move-exception;
        CoroutineExceptionHandler r109 = (CoroutineExceptionHandler) r102.getContext().get(CoroutineExceptionHandler.Key);
        if (r109 == null) goto L32;
        r109.handleException(r102.getContext(), new IllegalStateException("Unable to load font " + r100, e));
        return r107;
    L32:
        return r107;
    L7:
        r102 = new AsyncFontListLoader$loadWithTimeoutOrNull$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(List<? extends Font> r100, Object r101, TypefaceRequest r102, AsyncTypefaceCache r103, Function1<? super TypefaceResult.Immutable, Unit> r104, PlatformFontLoader r105) {
        this.fontList = r100;
        this.typefaceRequest = r102;
        this.asyncTypefaceCache = r103;
        this.onCompletion = r104;
        this.platformFontLoader = r105;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
        this.cacheable = true;
    }
}
