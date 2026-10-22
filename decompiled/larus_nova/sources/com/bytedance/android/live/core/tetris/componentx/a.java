package com.bytedance.android.live.core.tetris.componentx;

import android.content.Context;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    ComponentManagerFactory$config$1.b a();

    String b();

    ComponentManagerFactory$config$1.c c();

    Function1<Runnable, Unit> d();

    h70.b getComponentContext();

    Context getContext();

    ComponentManagerFactory$config$1.a getLogger();
}
