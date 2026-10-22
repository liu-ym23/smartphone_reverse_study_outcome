package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements fd2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a f146472a;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.a$a, reason: collision with other inner class name */
    public static final class C2278a implements qh0.d<rh0.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f146473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f146474b;

        @Override // qh0.d
        public final void b(BaseCheckException r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            ALogger.d("ChorusJsbService", "checkPermission onFailed");
            this.f146473a.f146472a.b(false, this.f146474b);
            InteractLinkFullLinkMonitor.e(OperateType.APPLY.ordinal(), 2, r100);
            TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
            TalkRoomBusinessFullLinkMonitor.U(r100);
            com.bytedance.android.live.liveinteract.plantform.utils.x.K(r100);
        }

        @Override // qh0.d
        public final void onResult(rh0.a r100) {
            ALogger.d("ChorusJsbService", "checkPermission onSuccess");
            this.f146473a.f146472a.b(true, this.f146474b);
            InteractLinkFullLinkMonitor.f(OperateType.APPLY.ordinal(), 2);
            TalkRoomBusinessFullLinkMonitor.f71456a.getClass();
            TalkRoomBusinessFullLinkMonitor.V();
            com.bytedance.android.live.liveinteract.plantform.utils.x.L();
        }

        public C2278a(a r100, String r101) {
            this.f146473a = r100;
            this.f146474b = r101;
        }
    }

    public a(com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chorusEventHandler");
        this.f146472a = r100;
    }

    @Override // fd2.d
    public final void c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "source");
        OperateType r102 = OperateType.APPLY;
        ArrayList r103 = new ArrayList();
        r103.add(qh0.g.a(r102, 2));
        r103.add(new qh0.f.g(r100, r102, 2));
        r103.add(new qh0.f.c(r100, r102, 2));
        r103.add(new qh0.f.a(r100));
        r103.add(new qh0.f.C7326f(r100, r102, 2, true));
        r103.add(new qh0.f.e(r100, r102));
        qh0.f.a(r103).a(new C2278a(this, r101));
    }

    @Override // fd2.d
    public void a(int r100, RTChorusOperateType r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "musicId");
        Intrinsics.checkNotNullParameter(r103, "orderUserId");
        Intrinsics.checkNotNullParameter(r101, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r102, "musicId");
        Intrinsics.checkNotNullParameter(r103, "orderUserId");
    }
}
