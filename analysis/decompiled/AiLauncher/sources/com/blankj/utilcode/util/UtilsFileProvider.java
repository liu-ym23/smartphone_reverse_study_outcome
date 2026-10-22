package com.blankj.utilcode.util;

import android.app.Application;

/* loaded from: classes.dex */
public class UtilsFileProvider extends androidx.core.content.b {
    @Override // androidx.core.content.b, android.content.ContentProvider
    public boolean onCreate() {
        p.b((Application) getContext().getApplicationContext());
        return true;
    }
}
