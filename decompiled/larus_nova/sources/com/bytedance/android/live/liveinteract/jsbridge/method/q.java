package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.GiftMessageBoardLinkmicResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import w20.u9;
import w20.z1;

/* JADX INFO: loaded from: classes46.dex */
@XBridgeMethod(biz = "webcast", name = "giftMessageBoardLinkmic")
public final class q extends z1<u9, GiftMessageBoardLinkmicResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f74243a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f74243a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f74243a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f74243a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f74243a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public q() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        u9 r101 = (u9) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.d("GiftMessageBoardLinkmicMethod", "receive params: uid=" + r101.g() + ", secUid=" + r101.f() + ", isActive=" + r101.h() + ", isSubscriber=" + r101.i() + ", inRoom=" + r101.d() + ", messageBoardId=" + r101.e() + ", content=" + r101.a() + ", giftId=" + r101.b() + ", giftMoney=" + r101.c());
        Disposable r111 = this.f74243a;
        if (r111 == null) goto L5;
        r111.dispose();
    L5:
        this.f74243a = xs2.b.a().b(jd0.b.class).subscribe(new r(this));
        IMessageBoardInfo r102 = (IMessageBoardInfo) vh7.f.c(IMessageBoardInfo.class);
        String r112 = r101.e();
        long r103 = 0;
        if (r112 == null) goto L8;
        long r104 = CastLongProtector.parseLong(r112);
    L9:
        r102.setId(r104);
        String r113 = r101.a();
        String r105 = "";
        if (r113 != null) goto L12;
        r113 = "";
    L12:
        Intrinsics.checkNotNullParameter(r102, "$this$setMsgBoardContent");
        Intrinsics.checkNotNullParameter(r113, "content");
        r102.setContent(r113);
        String r114 = r101.b();
        if (r114 == null) goto L15;
        r103 = CastLongProtector.parseLong(r114);
    L15:
        r102.setGiftId(r103);
        if ((r102 instanceof MessageBoardInfo) == true) goto L18;
        IMessageBoardInfo r115 = null;
    L19:
        MessageBoardInfo r116 = (MessageBoardInfo) r115;
        if (r116 == null) goto L26;
        Integer r106 = r101.c();
        if (r106 == null) goto L24;
        int r107 = r106.intValue();
    L25:
        r116.setGiftMoney(r107);
        goto L26
    L24:
        r107 = 0;
    L26:
        xs2.b r117 = xs2.b.a();
        String r108 = r101.g();
        if (r108 != null) goto L29;
        r108 = "";
    L29:
        String r109 = r101.f();
        if (r109 == null) goto L33;
        r105 = r109;
    L33:
        Boolean r118 = r101.h();
        if (r118 == null) goto L36;
        boolean r119 = r118.booleanValue();
    L37:
        Boolean r120 = r101.i();
        if (r120 == null) goto L40;
        boolean r121 = r120.booleanValue();
    L41:
        Boolean r122 = r101.d();
        if (r122 == null) goto L44;
        boolean r123 = r122.booleanValue();
    L45:
        r117.post(new jd0.c(r108, r105, r119, r121, r123, r102));
        return;
    L44:
        r123 = false;
        goto L45
    L40:
        r121 = false;
        goto L41
    L36:
        r119 = false;
        goto L37
    L18:
        r115 = r102;
        goto L19
    L8:
        r104 = 0;
        goto L9
    }
}
