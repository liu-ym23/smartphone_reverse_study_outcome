package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    public abstract Path getPath(float r10, float r11, float r12, float r13);

    public PathMotion(@NonNull Context r10, @NonNull AttributeSet r11) {
    }
}
