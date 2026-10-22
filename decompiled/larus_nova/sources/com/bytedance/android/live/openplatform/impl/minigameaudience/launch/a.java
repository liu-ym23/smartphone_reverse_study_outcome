package com.bytedance.android.live.openplatform.impl.minigameaudience.launch;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceLaunchMgContextService f85300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f85301b;

    public a(AudienceLaunchMgContextService r100, Function0 r101) {
        this.f85300a = r100;
        this.f85301b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        int r102 = qo0.a.f534145a;
        qo0.a.c(this.f85300a.f85296a, "login success");
        this.f85301b.invoke();
    }
}
