package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityResultCaller {
    @NonNull
    <I, O> ActivityResultLauncher registerForActivityResult(@NonNull ActivityResultContract r10, @NonNull ActivityResultCallback<O> r11);

    @NonNull
    <I, O> ActivityResultLauncher registerForActivityResult(@NonNull ActivityResultContract r10, @NonNull ActivityResultRegistry r11, @NonNull ActivityResultCallback<O> r12);
}
