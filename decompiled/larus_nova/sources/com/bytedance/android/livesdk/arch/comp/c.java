package com.bytedance.android.livesdk.arch.comp;

import com.monitor.cloudmessage.consts.CloudControlInf;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f103730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ le1.c f103731b;

    public c(b r100, le1.a r101) {
        this.f103730a = r100;
        this.f103731b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        b r100 = this.f103730a;
        le1.c r101 = this.f103731b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.PLUGIN);
        ((ArrayList) r100.f103723b).remove(r101);
    }
}
