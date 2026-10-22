package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActivityResultLauncher<I> {
    public ActivityResultLauncher() {
    }

    public abstract ActivityResultContract<I, ?> getContract();

    public abstract void launch(I r100, ActivityOptionsCompat r101);

    public abstract void unregister();

    public void launch(I r100) {
        launch(r100, null);
    }
}
