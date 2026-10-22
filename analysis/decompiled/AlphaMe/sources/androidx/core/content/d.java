package androidx.core.content;

import android.content.Context;
import androidx.annotation.DoNotInline;
import java.io.File;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static File[] a(Context context) {
        return context.getExternalMediaDirs();
    }
}
