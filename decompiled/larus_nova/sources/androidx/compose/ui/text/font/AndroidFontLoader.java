package androidx.compose.ui.text.font;

import android.content.Context;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\fR\u0016\u0010\u0002\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontLoader;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "kotlin.jvm.PlatformType", "loadBlocking", "Landroid/graphics/Typeface;", LynxResourceModule.FONT_TYPE, "Landroidx/compose/ui/text/font/Font;", "awaitLoad", "(Landroidx/compose/ui/text/font/Font;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheKey", "", "getCacheKey", "()Ljava/lang/Object;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidFontLoader implements PlatformFontLoader {
    public static final int $stable = 8;
    private final Object cacheKey;
    private final Context context;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader$awaitLoad$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.text.font.AndroidFontLoader", f = "AndroidFontLoader.android.kt", i = {1}, l = {55, 57}, m = "awaitLoad", n = {LynxResourceModule.FONT_TYPE}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AndroidFontLoader this$0;

        public AnonymousClass1(AndroidFontLoader r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.awaitLoad(null, this);
        }
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object getCacheKey() {
        return this.cacheKey;
    }

    public AndroidFontLoader(Context r100) {
        this.context = r100.getApplicationContext();
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public android.graphics.Typeface loadBlocking(Font r100) {
        if ((r100 instanceof AndroidFont) == false) goto L5;
        AndroidFont r101 = (AndroidFont) r100;
        return r101.getTypefaceLoader().loadBlocking(this.context, r101);
    L5:
        Object r102 = null;
        if ((r100 instanceof ResourceFont) == false) goto L29;
        ResourceFont r103 = (ResourceFont) r100;
        int r104 = r103.mo7054getLoadingStrategyPKNRLFQ();
        FontLoadingStrategy.Companion r105 = FontLoadingStrategy.Companion;
        if (FontLoadingStrategy.m7099equalsimpl0(r104, r105.m7104getBlockingPKNRLFQ()) == false) goto L11;
        android.graphics.Typeface r106 = AndroidFontLoader_androidKt.access$load(r103, this.context);
    L33:
        return PlatformTypefaces_androidKt.setFontVariationSettings(r106, r103.getVariationSettings(), this.context);
    L11:
        if (FontLoadingStrategy.m7099equalsimpl0(r104, r105.m7105getOptionalLocalPKNRLFQ()) == false) goto L23;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L14
        Object r108 = Result.m9449constructorimpl(AndroidFontLoader_androidKt.access$load((ResourceFont) r100, this.context));     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r108) == true) goto L20;
        r102 = r108;
    L20:
        r106 = (android.graphics.Typeface) r102;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L23:
        if (FontLoadingStrategy.m7099equalsimpl0(r104, r105.m7103getAsyncPKNRLFQ()) == false) goto L27;
        throw new UnsupportedOperationException("Unsupported Async font load path");
    L27:
        throw new IllegalArgumentException("Unknown loading type " + FontLoadingStrategy.m7101toStringimpl(r103.mo7054getLoadingStrategyPKNRLFQ()));
    L29:
        return null;
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public /* bridge */ /* synthetic */ Object loadBlocking(Font r100) {
        return loadBlocking(r100);
    }

    @Override // androidx.compose.ui.text.font.PlatformFontLoader
    public Object awaitLoad(Font r100, Continuation<? super android.graphics.Typeface> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        r100 = (Font) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L28:
        return PlatformTypefaces_androidKt.setFontVariationSettings((android.graphics.Typeface) r104, ((ResourceFont) r100).getVariationSettings(), this.context);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L21:
        return r104;
    L16:
        ResultKt.throwOnFailure(r104);
        if ((r100 instanceof AndroidFont) == false) goto L23;
        AndroidFont r107 = (AndroidFont) r100;
        AndroidFont.TypefaceLoader r108 = r107.getTypefaceLoader();
        Context r109 = this.context;
        r102.label = 1;
        r104 = r108.awaitLoad(r109, r107, r102);
        if (r104 != r105) goto L21;
        return r105;
    L23:
        if ((r100 instanceof ResourceFont) == false) goto L30;
        Context r110 = this.context;
        r102.L$0 = r100;
        r102.label = 2;
        r104 = AndroidFontLoader_androidKt.access$loadAsync((ResourceFont) r100, r110, r102);
        if (r104 != r105) goto L28;
        return r105;
    L30:
        throw new IllegalArgumentException("Unknown font type: " + r100);
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
