package com.bytedance.android.live.room.api.screenrotation.entrance.judge;

import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.live.room.api.screenrotation.entrance.b;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import io.reactivex.disposables.CompositeDisposable;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements com.bytedance.android.live.room.api.screenrotation.entrance.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f99127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f99128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f99129c;

    public void d(d r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public void onUnload() {
        this.f99129c.clear();
    }

    public a() {
        this.f99128b = ((IScreenRotateService) k.n(IScreenRotateService.class)).entranceVisibleNotify();
        this.f99129c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public boolean a(IRotateEntrance r100) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        return true;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f99127a = r100;
        d(r100);
    }
}
