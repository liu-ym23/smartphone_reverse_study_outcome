package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.content.Context;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui.LikeEggView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.n;

/* JADX INFO: loaded from: classes9.dex */
public final class LikeEggTopViewManager implements f52.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f139912h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f52.b f139913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f139914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy<LikeEggView> f139915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f139916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f139917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f139918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DataCenter f139919g;

    public static final class a {
    }

    static {
    }

    @Override // f52.d
    public final void onUnload() {
        LikeEggHelper.f140029h.clear();
        Disposable r100 = this.f139914b;
        if (r100 == null) goto L6;
        r100.dispose();
    L6:
        if (this.f139915c.isInitialized() == false) goto L13;
        LikeEggView r101 = (LikeEggView) this.f139916d.getValue();
        r101.f();
        HSImageView r102 = r101.f139987b;
        if (r102 == null) goto L10;
        r102.setController(null);
    L10:
        HSImageView r103 = r101.f139988c;
        if (r103 == null) goto L13;
        r103.setController(null);
    L13:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a("LikeEggTopViewManager onUnload");
    }

    @Override // f52.d
    public final String getId() {
        return this.f139917e;
    }

    @Override // f52.d
    public final void j(f52.b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a("LikeEggTopViewManager onLoad");
        this.f139913a = r100;
        n r101 = r.k();
        if (r101 == null) goto L5;
        r101.d(this.f139919g, new LikeEggTopViewManager$onLoad$1(this));
    L5:
        EasterEggAnimationDialog.f139896i.getClass();
        EasterEggAnimationDialog.f139895h.set(0);
    }

    public LikeEggTopViewManager(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f139918f = r100;
        this.f139919g = r101;
        Lazy<LikeEggView> r102 = LazyKt.lazy(new LikeEggTopViewManager$likeEggViewLazy$1(this));
        this.f139915c = r102;
        this.f139916d = r102;
        this.f139917e = "LikeEggTopViewManager";
    }
}
