package com.bytedance.android.ec.core.utils;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class t1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f45724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f45725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f45726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f45727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ TextView f45728e;

    public t1(List r100, String r101, float r102, TextView r103) {
        this.f45724a = r100;
        this.f45725b = r101;
        this.f45726c = 3.0f;
        this.f45727d = r102;
        this.f45728e = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Unit r101 = (Unit) r100;
        p1.h(p1.f45668d, this.f45724a, this.f45725b, this.f45726c, this.f45727d, this.f45728e);
    }
}
