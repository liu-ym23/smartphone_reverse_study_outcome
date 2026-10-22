package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
interface ModelTypes<T> {
    @NonNull
    @CheckResult
    T load(@Nullable Bitmap r10);

    @NonNull
    @CheckResult
    T load(@Nullable Drawable r10);

    @NonNull
    @CheckResult
    T load(@Nullable Uri r10);

    @NonNull
    @CheckResult
    T load(@Nullable File r10);

    @NonNull
    @CheckResult
    T load(@Nullable @DrawableRes @RawRes Integer r10);

    @NonNull
    @CheckResult
    T load(@Nullable Object r10);

    @NonNull
    @CheckResult
    T load(@Nullable String r10);

    @CheckResult
    @Deprecated
    T load(@Nullable URL r10);

    @NonNull
    @CheckResult
    T load(@Nullable byte[] r10);
}
