package com.bytedance.android.livesdk.room.util;

import android.content.Context;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController;
import com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewControllerExtend;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.state.IUserState;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements IStartLivePreviewControllerExtend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IStartLivePreviewController> f157841a;

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onCreate() {
        Iterator<T> r100 = this.f157841a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IStartLivePreviewController r101 = (IStartLivePreviewController) r100.next();
        boolean r102 = j.f157836a;
        j.b("onCreate#" + r101.hashCode());
        r101.onCreate();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroy() {
        Iterator<T> r100 = this.f157841a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IStartLivePreviewController r101 = (IStartLivePreviewController) r100.next();
        boolean r102 = j.f157836a;
        j.b("onDestroy#" + r101.hashCode());
        r101.onDestroy();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onDestroyView() {
        Iterator<T> r100 = this.f157841a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IStartLivePreviewController r101 = (IStartLivePreviewController) r100.next();
        boolean r102 = j.f157836a;
        j.b("onDestroyView#" + r101.hashCode());
        r101.onDestroyView();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewControllerExtend
    public final boolean onRecycler() {
        Iterator<IStartLivePreviewController> r100 = this.f157841a.iterator();
    L3:
        boolean r101 = false;
        if (r100.hasNext() == false) goto L15;
        IStartLivePreviewController r102 = r100.next();
        if ((r102 instanceof IStartLivePreviewControllerExtend) == true) goto L8;
        r102 = null;
    L8:
        IStartLivePreviewControllerExtend r103 = (IStartLivePreviewControllerExtend) r102;
        if (r103 == null) goto L13;
        if (r103.onRecycler() != true) goto L13;
        r101 = true;
    L13:
        if (r101 == false) goto L3;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStart() {
        Iterator<T> r100 = this.f157841a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IStartLivePreviewController r101 = (IStartLivePreviewController) r100.next();
        boolean r102 = j.f157836a;
        j.b("onStart#" + r101.hashCode());
        r101.onStart();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onStop() {
        Iterator<T> r100 = this.f157841a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IStartLivePreviewController r101 = (IStartLivePreviewController) r100.next();
        boolean r102 = j.f157836a;
        j.b("onStop#" + r101.hashCode());
        r101.onStop();
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewCreated() {
        Iterator<T> r100 = this.f157841a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        IStartLivePreviewController r101 = (IStartLivePreviewController) r100.next();
        boolean r102 = j.f157836a;
        j.b("onViewCreated#" + r101.hashCode());
        r101.onViewCreated();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(List<? extends IStartLivePreviewController> r100) {
        Intrinsics.checkNotNullParameter(r100, "controllers");
        this.f157841a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onContextAttached(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator<T> r101 = this.f157841a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        IStartLivePreviewController r102 = (IStartLivePreviewController) r101.next();
        boolean r103 = j.f157836a;
        j.b("onContextAttached#" + r102.hashCode());
        r102.onContextAttached(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onUserInfoChanged(IUserState r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.USERSTATE);
        Iterator<T> r101 = this.f157841a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        IStartLivePreviewController r102 = (IStartLivePreviewController) r101.next();
        boolean r103 = j.f157836a;
        j.b("onUserInfoChanged#" + r102.hashCode());
        r102.onUserInfoChanged(r100);
        goto L4
    }

    @Override // com.bytedance.android.livesdkapi.room.controller.IStartLivePreviewController
    public final void onViewHandlerAttached(ILiveRoomViewHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        Iterator<T> r101 = this.f157841a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        IStartLivePreviewController r102 = (IStartLivePreviewController) r101.next();
        boolean r103 = j.f157836a;
        j.b("onViewHandlerAttached#" + r102.hashCode());
        r102.onViewHandlerAttached(r100);
        goto L4
    }
}
