package com.bumptech.glide.integration.okhttp3;

import H0.g;
import R0.b;
import android.content.Context;
import com.bumptech.glide.integration.okhttp3.a;
import java.io.InputStream;
import v0.ComponentCallbacks2C1180c;
import v0.d;
import v0.h;

@Deprecated
/* loaded from: classes.dex */
public class OkHttpGlideModule implements b {
    @Override // R0.b
    public void a(Context context, d dVar) {
    }

    @Override // R0.b
    public void b(Context context, ComponentCallbacks2C1180c componentCallbacks2C1180c, h hVar) {
        hVar.r(g.class, InputStream.class, new a.C0159a());
    }
}
