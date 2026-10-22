package androidx.compose.ui.text.font;

import H4.o;
import S7.k;
import androidx.compose.ui.text.font.AsyncTypefaceCache;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000\u0012\u0004\u0012\u00020\t0\u000b*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "Landroidx/compose/ui/text/font/Font;", "Landroidx/compose/ui/text/font/TypefaceRequest;", "typefaceRequest", "Landroidx/compose/ui/text/font/AsyncTypefaceCache;", "asyncTypefaceCache", "Landroidx/compose/ui/text/font/PlatformFontLoader;", "platformFontLoader", "Lkotlin/Function1;", "", "createDefaultTypeface", "Lkotlin/Pair;", "firstImmediatelyAvailable", "(Ljava/util/List;Landroidx/compose/ui/text/font/TypefaceRequest;Landroidx/compose/ui/text/font/AsyncTypefaceCache;Landroidx/compose/ui/text/font/PlatformFontLoader;LS7/k;)Lkotlin/Pair;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FontListFontFamilyTypefaceAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair<List<Font>, Object> firstImmediatelyAvailable(List<? extends Font> list, TypefaceRequest typefaceRequest, AsyncTypefaceCache asyncTypefaceCache, PlatformFontLoader platformFontLoader, k kVar) {
        Object objInvoke;
        Object objInvoke2;
        Object objA;
        Object objM6384unboximpl;
        int size = list.size();
        ArrayList arrayListQ = null;
        for (int i = 0; i < size; i++) {
            Font font = list.get(i);
            int iMo6367getLoadingStrategyPKNRLFQ = font.getLoadingStrategy();
            FontLoadingStrategy.Companion companion = FontLoadingStrategy.INSTANCE;
            if (FontLoadingStrategy.m6409equalsimpl0(iMo6367getLoadingStrategyPKNRLFQ, companion.m6414getBlockingPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key);
                        if (asyncTypefaceResult == null) {
                            asyncTypefaceResult = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key);
                        }
                        if (asyncTypefaceResult != null) {
                            objInvoke2 = asyncTypefaceResult.m6384unboximpl();
                        } else {
                            try {
                                objInvoke = platformFontLoader.loadBlocking(font);
                            } catch (Exception unused) {
                                objInvoke = kVar.invoke(typefaceRequest);
                            }
                            Object obj = objInvoke;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj, false, 8, null);
                            objInvoke2 = obj;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (objInvoke2 == null) {
                    objInvoke2 = kVar.invoke(typefaceRequest);
                }
                return new Pair<>(arrayListQ, FontSynthesis_androidKt.m6443synthesizeTypefaceFxwP2eA(typefaceRequest.m6468getFontSynthesisGVVA2EU(), objInvoke2, font, typefaceRequest.getFontWeight(), typefaceRequest.m6467getFontStyle_LCdwA()));
            }
            if (FontLoadingStrategy.m6409equalsimpl0(iMo6367getLoadingStrategyPKNRLFQ, companion.m6415getOptionalLocalPKNRLFQ())) {
                synchronized (asyncTypefaceCache.cacheLock) {
                    try {
                        AsyncTypefaceCache.Key key2 = new AsyncTypefaceCache.Key(font, platformFontLoader.getCacheKey());
                        AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.resultCache.get(key2);
                        if (asyncTypefaceResult2 == null) {
                            asyncTypefaceResult2 = (AsyncTypefaceCache.AsyncTypefaceResult) asyncTypefaceCache.permanentCache.get(key2);
                        }
                        if (asyncTypefaceResult2 != null) {
                            objM6384unboximpl = asyncTypefaceResult2.m6384unboximpl();
                        } else {
                            try {
                                objA = platformFontLoader.loadBlocking(font);
                            } catch (Throwable th2) {
                                objA = b.a(th2);
                            }
                            Object obj2 = objA instanceof Result.Failure ? null : objA;
                            AsyncTypefaceCache.put$default(asyncTypefaceCache, font, platformFontLoader, obj2, false, 8, null);
                            objM6384unboximpl = obj2;
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (objM6384unboximpl != null) {
                    return new Pair<>(arrayListQ, FontSynthesis_androidKt.m6443synthesizeTypefaceFxwP2eA(typefaceRequest.m6468getFontSynthesisGVVA2EU(), objM6384unboximpl, font, typefaceRequest.getFontWeight(), typefaceRequest.m6467getFontStyle_LCdwA()));
                }
            } else {
                if (!FontLoadingStrategy.m6409equalsimpl0(iMo6367getLoadingStrategyPKNRLFQ, companion.m6413getAsyncPKNRLFQ())) {
                    throw new IllegalStateException("Unknown font type " + font);
                }
                AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResultM6376get1ASDuI8 = asyncTypefaceCache.m6376get1ASDuI8(font, platformFontLoader);
                if (asyncTypefaceResultM6376get1ASDuI8 != null) {
                    if (!AsyncTypefaceCache.AsyncTypefaceResult.m6382isPermanentFailureimpl(asyncTypefaceResultM6376get1ASDuI8.m6384unboximpl()) && asyncTypefaceResultM6376get1ASDuI8.m6384unboximpl() != null) {
                        return new Pair<>(arrayListQ, FontSynthesis_androidKt.m6443synthesizeTypefaceFxwP2eA(typefaceRequest.m6468getFontSynthesisGVVA2EU(), asyncTypefaceResultM6376get1ASDuI8.m6384unboximpl(), font, typefaceRequest.getFontWeight(), typefaceRequest.m6467getFontStyle_LCdwA()));
                    }
                } else if (arrayListQ == null) {
                    arrayListQ = o.Q(font);
                } else {
                    arrayListQ.add(font);
                }
            }
        }
        return new Pair<>(arrayListQ, kVar.invoke(typefaceRequest));
    }
}
