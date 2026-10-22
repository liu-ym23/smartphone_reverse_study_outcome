package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import com.bytedance.android.livesdkapi.livereplay.IECLiveReplayParams;
import com.bytedance.android.livesdkapi.livereplay.IECLiveReplayService;
import com.bytedance.android.livesdkapi.livereplay.ILiveRoomInfo;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements yr1.c, com.bytedance.android.scope.o {

    public static final class a implements ILiveRoomInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f118260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f118261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f118262c;

        @Override // com.bytedance.android.livesdkapi.livereplay.ILiveRoomInfo
        public final String authorId() {
            return this.f118261b;
        }

        @Override // com.bytedance.android.livesdkapi.livereplay.ILiveRoomInfo
        public final String roomId() {
            return this.f118260a;
        }

        @Override // com.bytedance.android.livesdkapi.livereplay.ILiveRoomInfo
        public final String secAuthorId() {
            return this.f118262c;
        }

        public a(String r100, String r101, String r102) {
            this.f118260a = r100;
            this.f118261b = r101;
            this.f118262c = r102;
        }
    }

    public d() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // yr1.c
    public final IExternalWidget a(Context r110, String r111, String r112, String r113, String r114, long r115, IECLiveReplayParams r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "roomId");
        Intrinsics.checkNotNullParameter(r112, "authorId");
        Intrinsics.checkNotNullParameter(r113, "secAuthorId");
        Intrinsics.checkNotNullParameter(r114, "replayId");
        Intrinsics.checkNotNullParameter(r116, "params");
        IHostCommerceServiceLive r100 = (IHostCommerceServiceLive) jc1.k.f(IHostCommerceServiceLive.class);
        if (r100 == null) goto L7;
        IECLiveReplayService r101 = r100.getECLiveReplayService();
        if (r101 == null) goto L7;
        return r101.getECProductWidget(r110, new a(r111, r112, r113), r114, r115, r116);
    L7:
        return null;
    }
}
