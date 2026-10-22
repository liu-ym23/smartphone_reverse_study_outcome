package com.blankj.utilcode.util;

import android.app.Application;
import androidx.core.content.c;
import p5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class UtilsFileProvider extends c {
    public UtilsFileProvider() {
        super(0);
    }

    @Override // androidx.core.content.c, android.content.ContentProvider
    public final boolean onCreate() {
        f.B((Application) getContext().getApplicationContext());
        return true;
    }
}
