package androidx.appcompat.app;

import androidx.appcompat.view.ActionMode;

/* JADX INFO: loaded from: classes.dex */
public interface AppCompatCallback {
    void onSupportActionModeFinished(ActionMode r100);

    void onSupportActionModeStarted(ActionMode r100);

    ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r100);
}
