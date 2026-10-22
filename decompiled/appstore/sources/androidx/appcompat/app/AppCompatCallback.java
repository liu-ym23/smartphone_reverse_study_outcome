package androidx.appcompat.app;

import androidx.annotation.Nullable;
import androidx.appcompat.view.ActionMode;

/* JADX INFO: loaded from: classes.dex */
public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode r10);

    void onSupportActionModeStarted(ActionMode r10);

    @Nullable
    ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r10);
}
