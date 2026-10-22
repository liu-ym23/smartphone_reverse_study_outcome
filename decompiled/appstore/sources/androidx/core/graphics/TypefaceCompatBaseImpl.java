package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class TypefaceCompatBaseImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f2541a;

    public interface StyleExtractor<T> {
        int getWeight(T r10);

        boolean isItalic(T r10);
    }

    public TypefaceCompatBaseImpl() {
        this.f2541a = new ConcurrentHashMap();
    }

    public abstract Typeface a(Context r10, FontResourcesParserCompat.b r11, Resources r12, int r13);

    public abstract Typeface b(Context r10, CancellationSignal r11, FontsContractCompat.b[] r12, int r13);

    public abstract Typeface c(Context r10, Resources r11, int r12, String r13, int r14);
}
