package androidx.compose.ui.text.font;

import H7.c;
import android.content.Context;
import android.content.res.Resources;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import m9.C1718k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/font/ResourceFont;", "Landroid/content/Context;", "context", "Landroid/graphics/Typeface;", "load", "(Landroidx/compose/ui/text/font/ResourceFont;Landroid/content/Context;)Landroid/graphics/Typeface;", "loadAsync", "(Landroidx/compose/ui/text/font/ResourceFont;Landroid/content/Context;LH7/c;)Ljava/lang/Object;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidFontLoader_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Typeface load(ResourceFont resourceFont, Context context) throws Resources.NotFoundException {
        android.graphics.Typeface font = ResourcesCompat.getFont(context, resourceFont.getResId());
        k.c(font);
        return font;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadAsync(final ResourceFont resourceFont, Context context, c<? super android.graphics.Typeface> cVar) throws Resources.NotFoundException {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        ResourcesCompat.getFont(context, resourceFont.getResId(), new ResourcesCompat.FontCallback() { // from class: androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2$1
            @Override // androidx.core.content.res.ResourcesCompat.FontCallback
            /* renamed from: onFontRetrievalFailed */
            public void lambda$callbackFailAsync$1(int reason) {
                c1718k.l(new IllegalStateException("Unable to load font " + resourceFont + " (reason=" + reason + ')'));
            }

            @Override // androidx.core.content.res.ResourcesCompat.FontCallback
            /* renamed from: onFontRetrieved */
            public void lambda$callbackSuccessAsync$0(android.graphics.Typeface typeface) {
                c1718k.resumeWith(typeface);
            }
        }, null);
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }
}
