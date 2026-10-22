package E;

import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class f {
    @DoNotInline
    public static Icon a(Uri uri) {
        return Icon.createWithAdaptiveBitmapContentUri(uri);
    }
}
