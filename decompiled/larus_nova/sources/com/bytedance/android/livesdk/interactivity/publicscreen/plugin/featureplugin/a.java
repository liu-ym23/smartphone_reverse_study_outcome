package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f139168a;

    public a(Function1 r100) {
        this.f139168a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object r100) {
        this.f139168a.invoke(r100);
    }
}
