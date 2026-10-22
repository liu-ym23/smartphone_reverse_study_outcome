package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightPKProgressLayout;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f71494a = 0;

    static {
        MultiLinkEventModule r100 = MultiLinkEventModule.common;
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        new CompositeDisposable();
    }

    public static void a(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = f.f71487e;
        f.a.a(r100, TeamFightFullLinkMonitor$switchSceneSuccess$1.INSTANCE);
    }

    public static void b(TeamFightPKProgressLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = f.f71487e;
        f.a.a(r100, TeamFightFullLinkMonitor$uiRenderEnd$1.INSTANCE);
    }
}
