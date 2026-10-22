package Y2;

import android.graphics.Outline;
import android.graphics.Path;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public abstract class a {
    @DoNotInline
    public static void a(@NonNull Outline outline, @NonNull Path path) {
        outline.setPath(path);
    }
}
