package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class q implements Callable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f85782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f85783b;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        LiveSeiUtil r100 = LiveSeiUtil.f71508i;
        String r101 = this.f85783b;
        r100.getClass();
        JSONObject r102 = LiveSeiUtil.c(r101);
        if (((Boolean) this.f85782a.f85784a.f85793i.getValue()).booleanValue() == false) goto L7;
        this.f85782a.f85784a.f85792h = r102;
        return Boolean.TRUE;
    L7:
        return Boolean.valueOf(this.f85782a.f85784a.a(r102));
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Boolean call() {
        return call();
    }

    public q(r r100, String r101) {
        this.f85782a = r100;
        this.f85783b = r101;
    }
}
