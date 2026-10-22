package com.bytedance.android.livesdk.authorize;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f104216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f104217b;

    public m(Context r100) {
        this.f104216a = null;
        this.f104217b = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        String r102 = this.f104216a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 != true) goto L12;
        String r104 = rm3.c.f538539a;
        rm3.c.g(this.f104217b, this.f104216a, 0, true, 16);
        return;
    L12:
        return;
    L7:
        r103 = false;
        goto L8
    }
}
