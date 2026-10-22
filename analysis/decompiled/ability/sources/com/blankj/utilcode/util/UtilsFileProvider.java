package com.blankj.utilcode.util;

import android.app.Application;
import androidx.core.content.FileProvider;

/* loaded from: classes2.dex */
public class UtilsFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public final boolean onCreate() {
        S0.b.k1((Application) getContext().getApplicationContext());
        return true;
    }
}
