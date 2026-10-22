package androidx.compose.ui.text;

import androidx.collection.LruCache;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/TextLayoutCache;", "", "", "capacity", AppAgent.CONSTRUCT, "(I)V", "Landroidx/compose/ui/text/TextLayoutInput;", "key", "Landroidx/compose/ui/text/TextLayoutResult;", "get", "(Landroidx/compose/ui/text/TextLayoutInput;)Landroidx/compose/ui/text/TextLayoutResult;", "value", "LC7/r;", "put", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/TextLayoutResult;)V", "Landroidx/collection/LruCache;", "Landroidx/compose/ui/text/CacheTextLayoutInput;", "cache", "Landroidx/collection/LruCache;", "singleSizeCacheInput", "Landroidx/compose/ui/text/CacheTextLayoutInput;", "singleSizeCacheResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextLayoutCache {
    public static final int $stable = 8;
    private final LruCache<CacheTextLayoutInput, TextLayoutResult> cache;
    private CacheTextLayoutInput singleSizeCacheInput;
    private TextLayoutResult singleSizeCacheResult;

    public TextLayoutCache() {
        this(0, 1, null);
    }

    public final TextLayoutResult get(TextLayoutInput key) {
        TextLayoutResult textLayoutResult;
        CacheTextLayoutInput cacheTextLayoutInput = new CacheTextLayoutInput(key);
        LruCache<CacheTextLayoutInput, TextLayoutResult> lruCache = this.cache;
        if (lruCache != null) {
            textLayoutResult = lruCache.get(cacheTextLayoutInput);
        } else {
            if (!k.b(this.singleSizeCacheInput, cacheTextLayoutInput)) {
                return null;
            }
            textLayoutResult = this.singleSizeCacheResult;
        }
        if (textLayoutResult == null || textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts()) {
            return null;
        }
        return textLayoutResult;
    }

    public final void put(TextLayoutInput key, TextLayoutResult value) {
        LruCache<CacheTextLayoutInput, TextLayoutResult> lruCache = this.cache;
        if (lruCache != null) {
            lruCache.put(new CacheTextLayoutInput(key), value);
        } else {
            this.singleSizeCacheInput = new CacheTextLayoutInput(key);
            this.singleSizeCacheResult = value;
        }
    }

    public TextLayoutCache(int i) {
        this.cache = i != 1 ? new LruCache<>(i) : null;
    }

    public /* synthetic */ TextLayoutCache(int i, int i6, e eVar) {
        this((i6 & 1) != 0 ? 8 : i);
    }
}
