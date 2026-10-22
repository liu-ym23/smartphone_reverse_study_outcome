package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityResultCaller {
    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r100, ActivityResultCallback<O> r101);

    <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> r100, ActivityResultRegistry r101, ActivityResultCallback<O> r102);
}
