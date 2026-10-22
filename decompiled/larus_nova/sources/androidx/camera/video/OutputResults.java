package androidx.camera.video;

import android.net.Uri;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OutputResults {
    public OutputResults() {
    }

    public abstract Uri getOutputUri();

    public static OutputResults of(Uri r100) {
        Preconditions.checkNotNull(r100, "OutputUri cannot be null.");
        return new AutoValue_OutputResults(r100);
    }
}
