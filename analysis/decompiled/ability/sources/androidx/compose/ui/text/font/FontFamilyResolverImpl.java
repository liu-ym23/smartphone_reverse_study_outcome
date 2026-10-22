package androidx.compose.ui.text.font;

import C7.r;
import J7.c;
import R3.b;
import S7.k;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.d;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.TypefaceResult;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010&R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroidx/compose/ui/text/font/FontFamilyResolverImpl;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformFontLoader", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "platformResolveInterceptor", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "typefaceRequestCache", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "fontListFontFamilyTypefaceAdapter", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "platformFamilyTypefaceAdapter", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/font/PlatformFontLoader;Landroidx/compose/ui/text/font/PlatformResolveInterceptor;Landroidx/compose/ui/text/font/TypefaceRequestCache;Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;)V", "Landroidx/compose/ui/text/font/TypefaceRequest;", "typefaceRequest", "Landroidx/compose/runtime/State;", "", "resolve", "(Landroidx/compose/ui/text/font/TypefaceRequest;)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "LC7/r;", "preload", "(Landroidx/compose/ui/text/font/FontFamily;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "resolve-DPcqOEQ", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "getPlatformFontLoader$ui_text", "()Landroidx/compose/ui/text/font/PlatformFontLoader;", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "Landroidx/compose/ui/text/font/TypefaceRequestCache;", "Landroidx/compose/ui/text/font/FontListFontFamilyTypefaceAdapter;", "Landroidx/compose/ui/text/font/PlatformFontFamilyTypefaceAdapter;", "Lkotlin/Function1;", "createDefaultTypeface", "LS7/k;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontFamilyResolverImpl implements FontFamily.Resolver {
    public static final int $stable = 8;
    private final k createDefaultTypeface;
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;
    private final PlatformFontLoader platformFontLoader;
    private final PlatformResolveInterceptor platformResolveInterceptor;
    private final TypefaceRequestCache typefaceRequestCache;

    @c(c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", f = "FontFamilyResolver.kt", l = {43}, m = "preload")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FontFamilyResolverImpl.this.preload(null, this);
        }
    }

    public FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter) {
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFontFamilyTypefaceAdapter;
        this.createDefaultTypeface = new a(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createDefaultTypeface$lambda$0(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        return fontFamilyResolverImpl.resolve(TypefaceRequest.m6463copye1PVR60$default(typefaceRequest, null, null, 0, 0, null, 30, null)).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypefaceResult preload$lambda$4(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResultResolve = fontFamilyResolverImpl.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, new d(2), fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve != null) {
            return typefaceResultResolve;
        }
        TypefaceResult typefaceResultResolve2 = fontFamilyResolverImpl.platformFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, new d(3), fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve2 != null) {
            return typefaceResultResolve2;
        }
        throw new IllegalStateException("Could not load font");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r preload$lambda$4$lambda$2(TypefaceResult.Immutable immutable) {
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r preload$lambda$4$lambda$3(TypefaceResult.Immutable immutable) {
        return r.f317a;
    }

    private final State<Object> resolve(TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new b(15, this, typefaceRequest));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TypefaceResult resolve$lambda$5(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest, k kVar) {
        TypefaceResult typefaceResultResolve = fontFamilyResolverImpl.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, kVar, fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve != null) {
            return typefaceResultResolve;
        }
        TypefaceResult typefaceResultResolve2 = fontFamilyResolverImpl.platformFamilyTypefaceAdapter.resolve(typefaceRequest, fontFamilyResolverImpl.platformFontLoader, kVar, fontFamilyResolverImpl.createDefaultTypeface);
        if (typefaceResultResolve2 != null) {
            return typefaceResultResolve2;
        }
        throw new IllegalStateException("Could not load font");
    }

    /* renamed from: getPlatformFontLoader$ui_text, reason: from getter */
    public final PlatformFontLoader getPlatformFontLoader() {
        return this.platformFontLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object preload(androidx.compose.ui.text.font.FontFamily r13, H7.c<? super C7.r> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof androidx.compose.ui.text.font.FontFamilyResolverImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            C7.r r3 = C7.r.f317a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            java.lang.Object r13 = r0.L$0
            androidx.compose.ui.text.font.FontFamily r13 = (androidx.compose.ui.text.font.FontFamily) r13
            kotlin.b.b(r14)
            goto L4c
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            kotlin.b.b(r14)
            boolean r14 = r13 instanceof androidx.compose.ui.text.font.FontListFontFamily
            if (r14 != 0) goto L3d
            return r3
        L3d:
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r14 = r12.fontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.PlatformFontLoader r2 = r12.platformFontLoader
            r0.L$0 = r13
            r0.label = r4
            java.lang.Object r14 = r14.preload(r13, r2, r0)
            if (r14 != r1) goto L4c
            return r1
        L4c:
            r14 = r13
            androidx.compose.ui.text.font.FontListFontFamily r14 = (androidx.compose.ui.text.font.FontListFontFamily) r14
            java.util.List r14 = r14.getFonts()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r14.size()
            r0.<init>(r1)
            r1 = r14
            java.util.Collection r1 = (java.util.Collection) r1
            int r1 = r1.size()
            r2 = 0
        L64:
            if (r2 >= r1) goto L9e
            java.lang.Object r4 = r14.get(r2)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.TypefaceRequest r5 = new androidx.compose.ui.text.font.TypefaceRequest
            androidx.compose.ui.text.font.PlatformResolveInterceptor r6 = r12.platformResolveInterceptor
            androidx.compose.ui.text.font.FontFamily r6 = r6.interceptFontFamily(r13)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r7 = r12.platformResolveInterceptor
            androidx.compose.ui.text.font.FontWeight r8 = r4.getWeight()
            androidx.compose.ui.text.font.FontWeight r7 = r7.interceptFontWeight(r8)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r8 = r12.platformResolveInterceptor
            int r4 = r4.getStyle()
            int r8 = r8.m6447interceptFontStyleT2F_aPo(r4)
            androidx.compose.ui.text.font.FontSynthesis$Companion r4 = androidx.compose.ui.text.font.FontSynthesis.INSTANCE
            int r9 = r4.m6439getAllGVVA2EU()
            androidx.compose.ui.text.font.PlatformFontLoader r4 = r12.platformFontLoader
            java.lang.Object r10 = r4.getCacheKey()
            r11 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.add(r5)
            int r2 = r2 + 1
            goto L64
        L9e:
            androidx.compose.ui.text.font.TypefaceRequestCache r13 = r12.typefaceRequestCache
            androidx.compose.ui.text.font.a r14 = new androidx.compose.ui.text.font.a
            r1 = 1
            r14.<init>(r12, r1)
            r13.preWarmCache(r0, r14)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload(androidx.compose.ui.text.font.FontFamily, H7.c):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    /* renamed from: resolve-DPcqOEQ */
    public State<Object> mo6395resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int fontStyle, int fontSynthesis) {
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.m6447interceptFontStyleT2F_aPo(fontStyle), this.platformResolveInterceptor.m6448interceptFontSynthesisMscr08Y(fontSynthesis), this.platformFontLoader.getCacheKey(), null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i, e eVar) {
        this(platformFontLoader, (i & 2) != 0 ? PlatformResolveInterceptor.INSTANCE.getDefault$ui_text() : platformResolveInterceptor, (i & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache, (i & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, 0 == true ? 1 : 0) : fontListFontFamilyTypefaceAdapter, (i & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }
}
