package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.linkpanel.util.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public interface a<T extends c, DATA> {
    View a(Context r100, ViewGroup r101);

    T b();

    String c();

    void d(View r100, Function1<? super View, Unit> r101);
}
