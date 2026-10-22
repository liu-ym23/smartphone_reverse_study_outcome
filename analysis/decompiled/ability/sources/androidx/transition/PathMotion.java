package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path getPath(float f, float f7, float f9, float f10);

    public PathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
    }
}
