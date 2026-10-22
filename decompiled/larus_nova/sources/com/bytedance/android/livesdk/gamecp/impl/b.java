package com.bytedance.android.livesdk.gamecp.impl;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView;
import com.lynx.react.bridge.JavaOnlyMap;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements IGameCPDownloadView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.base.core.service.depend.g f125439a;

    public static final class a implements com.bytedance.android.gamecp.base.core.service.depend.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGameCPDownloadView.Callback f125440a;

        public a(IGameCPDownloadView.Callback r100) {
            this.f125440a = r100;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.g.a
        public final void a(int r100, JavaOnlyMap r101) {
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f125440a.callback(r100, r101);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamecp.impl.b$b, reason: collision with other inner class name */
    public static final class C2013b implements com.bytedance.android.gamecp.base.core.service.depend.g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGameCPDownloadView.Callback f125441a;

        public C2013b(IGameCPDownloadView.Callback r100) {
            this.f125441a = r100;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.g.a
        public final void a(int r100, JavaOnlyMap r101) {
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f125441a.callback(r100, r101);
        }
    }

    public static final class c implements com.bytedance.android.gamecp.base.core.service.depend.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGameCPDownloadView.DownloadStateListener f125442a;

        public c(IGameCPDownloadView.DownloadStateListener r100) {
            this.f125442a = r100;
        }

        @Override // com.bytedance.android.gamecp.base.core.service.depend.g.b
        public void onEvent(HashMap<String, Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f125442a.onEvent(r100);
        }
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void destroy() {
        this.f125439a.destroy();
    }

    public b(com.bytedance.android.gamecp.base.core.service.depend.g r100) {
        Intrinsics.checkNotNullParameter(r100, "downloadView");
        this.f125439a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void setDownloadInfo(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f125439a.setDownloadInfo(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void setDownloadStateListener(IGameCPDownloadView.DownloadStateListener r100) {
        if (r100 != null) goto L5;
        this.f125439a.b(null);
        return;
    L5:
        this.f125439a.b(new c(r100));
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void setDownloadText(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f125439a.setDownloadText(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void setDownloadUIStyle(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f125439a.setDownloadUIStyle(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void useCacheData(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f125439a.useCacheData(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final View createView(Context r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lynxContext");
        return this.f125439a.createView(r100, r101);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void getCurrentDownloadState(HashMap<String, Object> r100, IGameCPDownloadView.Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r101 != null) goto L6;
        this.f125439a.a(r100, null);
        return;
    L6:
        this.f125439a.a(r100, new a(r101));
    }

    @Override // com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView
    public final void performDownloadAction(HashMap<String, Object> r100, IGameCPDownloadView.Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r101 != null) goto L6;
        this.f125439a.d(r100, null);
        return;
    L6:
        this.f125439a.d(r100, new C2013b(r101));
    }
}
