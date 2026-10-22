package com.bytedance.android.shopping.card_list.components;

import android.view.View;
import com.bytedance.android.shopping.card_list.components.c;
import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public class SimpleScene<VIEW_TYPE extends View, STATE extends c, ACTION extends q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VIEW_TYPE f171450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public STATE f171451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ACTION f171452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f171453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f171454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f171455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f171456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f171457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f171458i;

    public SimpleScene() {
        this.f171453d = SimpleScene$onCreate$1.INSTANCE;
        this.f171454e = SimpleScene$onStart$1.INSTANCE;
        this.f171455f = SimpleScene$onResume$1.INSTANCE;
        this.f171456g = SimpleScene$onPause$1.INSTANCE;
        this.f171457h = SimpleScene$onStop$1.INSTANCE;
        this.f171458i = SimpleScene$onDestroy$1.INSTANCE;
    }
}
