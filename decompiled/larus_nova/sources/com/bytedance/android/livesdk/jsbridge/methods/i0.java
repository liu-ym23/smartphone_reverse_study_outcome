package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.CommentPinResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.IPinService;
import com.bytedance.android.livesdkapi.depend.model.live.CommentPinContent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.h8;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "commentPin")
public final class i0 extends w20.a0<h8, CommentPinResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f142136a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f142136a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f142136a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f142136a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f142136a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public i0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        h8 r102 = (h8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.d("CommentPinMethod", "receive params: uid=" + r102.f() + ", nickName=" + r102.d() + ", msgId=" + r102.c() + ", content=" + r102.a() + ", scene=" + r102.e() + ", contentType=" + r102.b());
        Disposable r103 = this.f142136a;
        if (r103 == null) goto L5;
        r103.dispose();
    L5:
        this.f142136a = xs2.b.a().b(d42.a.class).subscribe(new j0(this));
        String r104 = r102.c();
        if (r104 == null) goto L8;
        CastLongProtector.parseLong(r104);
    L8:
        String r105 = r102.e();
        String r106 = "";
        if (r105 != null) goto L12;
    L17:
        String r107 = "";
    L18:
        String r108 = r102.b();
        if (r108 != null) goto L22;
    L27:
        IPinService r109 = (IPinService) jc1.k.n(IPinService.class);
        CommentPinContent r110 = new CommentPinContent();
        r110.setContent(r102.a());
        String r111 = r102.c();
        if (r111 == null) goto L30;
        long r112 = CastLongProtector.parseLong(r111);
    L31:
        r110.setCommentMsgId(r112);
        r110.setNickName(r102.d());
        String r113 = r102.f();
        if (r113 != null) goto L34;
        r113 = "0";
    L34:
        r110.setCommenterId(r113);
        r110.setScene(r107);
        r110.setContentType(r106);
        Unit r114 = Unit.INSTANCE;
        r109.pinComment(r110);
        return;
    L30:
        r112 = 0;
        goto L31
    L22:
        if (r108.hashCode() != 570709177) goto L27;
        if (r108.equals("gift_word") == false) goto L27;
        r106 = "gift_word";
        goto L27
    L12:
        if (r105.hashCode() != (-1622852519)) goto L17;
        r107 = "gift_msg_board";
        if (r105.equals("gift_msg_board") == false) goto L17;
        goto L17
    }
}
