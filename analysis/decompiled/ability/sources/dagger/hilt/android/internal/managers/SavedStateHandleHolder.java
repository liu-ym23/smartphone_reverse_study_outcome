package dagger.hilt.android.internal.managers;

import android.os.Bundle;
import android.view.SavedStateHandle;
import android.view.SavedStateHandleSupport;
import android.view.viewmodel.CreationExtras;
import android.view.viewmodel.MutableCreationExtras;
import androidx.annotation.Nullable;
import dagger.hilt.android.internal.ThreadUtil;
import dagger.hilt.internal.Preconditions;

/* loaded from: classes2.dex */
public final class SavedStateHandleHolder {

    @Nullable
    private CreationExtras extras;

    @Nullable
    private SavedStateHandle handle;
    private final boolean isComponentActivity;

    public SavedStateHandleHolder(@Nullable CreationExtras creationExtras) {
        this.isComponentActivity = creationExtras != null;
        this.extras = creationExtras;
    }

    public void clear() {
        this.extras = null;
    }

    public SavedStateHandle getSavedStateHandle() {
        ThreadUtil.ensureMainThread();
        Preconditions.checkState(this.isComponentActivity, "Activity that does not extend ComponentActivity cannot use SavedStateHandle", new Object[0]);
        SavedStateHandle savedStateHandle = this.handle;
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        Preconditions.checkNotNull(this.extras, "The first access to SavedStateHandle should happen between super.onCreate() and super.onDestroy()");
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.extras);
        mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, Bundle.EMPTY);
        this.extras = mutableCreationExtras;
        SavedStateHandle savedStateHandleCreateSavedStateHandle = SavedStateHandleSupport.createSavedStateHandle(mutableCreationExtras);
        this.handle = savedStateHandleCreateSavedStateHandle;
        this.extras = null;
        return savedStateHandleCreateSavedStateHandle;
    }

    public boolean isInvalid() {
        return this.handle == null && this.extras == null;
    }

    public void setExtras(CreationExtras creationExtras) {
        Preconditions.checkState(this.isComponentActivity, "setExtras should only be called for an Activity that extends ComponentActivity", new Object[0]);
        if (this.handle != null) {
            return;
        }
        this.extras = creationExtras;
    }
}
