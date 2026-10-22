package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class OptionAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionsManager f122047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Room f122048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f122049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f122050d;

    public abstract void a(View r100);

    public void d(Function1<? super Map<String, ? extends Object>, Unit> r100) {
    }

    public void c() {
        ((CompositeDisposable) this.f122049c.getValue()).clear();
    }

    public cz.c f() {
        return cz.c.r.f466012c;
    }

    public OptionAction(ActionsManager r100) {
        Intrinsics.checkNotNullParameter(r100, "actionsManager");
        this.f122047a = r100;
        this.f122048b = r100.f121951d;
        this.f122049c = LazyKt.lazy(OptionAction$cd$2.INSTANCE);
    }

    public static /* synthetic */ void e(OptionAction r100) {
        r100.d(OptionAction$onShow$1.INSTANCE);
    }

    public void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        ILoginGuideService.Companion.getClass();
        ILoginGuideService r101 = ILoginGuideService.a.a();
        if (r101 != null) goto L5;
    L7:
        a(r100);
        com.bytedance.android.livesdk.dislike.m r102 = this.f122047a.f121950c;
        if (r102 == null) goto L11;
        r102.dismiss();
        return;
    L11:
        return;
    L5:
        if (r101.intercept(new q61.c(new q61.b.a(f()))) != true) goto L7;
    }
}
