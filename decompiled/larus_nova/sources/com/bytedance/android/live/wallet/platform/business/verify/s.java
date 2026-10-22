package com.bytedance.android.live.wallet.platform.business.verify;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.SingleSubject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class s implements Consumer<Response<com.bytedance.android.live.wallet.model.o>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f102745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f102746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f102747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Activity f102748d;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Response<com.bytedance.android.live.wallet.model.o> r100) throws Exception {
        Response<com.bytedance.android.live.wallet.model.o> r101 = r100;
        if (r101.data != null) goto L5;
        int r102 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "data is null");
        this.f102745a.onError(new Exception("data is null"));
        return;
    L5:
        Iterator r103 = this.f102746b.iterator();
    L7:
        if (r103.hasNext() == false) goto L55;
        String r104 = (String) r103.next();
        Map r105 = this.f102747c;
        Boolean r106 = Boolean.FALSE;
        r105.put(r104, r106);
        if (CJOuterPayManager.KEY_BINDPHONE.equals(r104) == true) goto L11;
        if ("verify".equals(r104) == true) goto L24;
        if ("faceRecognize".equals(r104) == false) goto L7;
        if (r101.data.a() == null) goto L45;
        this.f102747c.put("faceRecognize", r106);
        if (r101.data.a().b() == true) goto L48;
        this.f102747c.put("faceRecognize", Boolean.TRUE);
        goto L7
    L48:
        int r107 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "faceRecognize need verify");
        AlertDialog r108 = new AlertDialog.Builder(this.f102748d).setTitle(R.string.wallet_verify_label).setCancelable(true).setNegativeButton("取消", new r()).setPositiveButton(R.string.wallet_verify_immediately, new q(this)).create();
        r108.setMessage(r101.data.a().a());
        if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L59;
        DialogLancet.handleBlockedDialogShow(r108);
    L53:
        this.f102745a.onSuccess(this.f102747c);
        return;
    L59:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L58
    L52:
        DialogLancet.beforeDialogShow(r108);
        r108.show();
        DialogLancet.afterDialogShow(r108);
        goto L53
    L45:
        int r109 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "faceRecognize data is null");
        this.f102745a.onError(new Exception("faceRecognize data is null"));
        return;
    L24:
        if (r101.data.b() == null) goto L25;
        if (r101.data.b().isVerified == false) goto L29;
        this.f102747c.put("verify", Boolean.TRUE);
        goto L7
    L29:
        if (r101.data.b().c() == false) goto L31;
        int r110 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "verify verifying");
        f2.b(R.string.wallet_realname_verifying, 0);
        this.f102745a.onSuccess(this.f102747c);
        return;
    L31:
        ReadOnlyProperty r111 = dd1.e.f467925b;
        KProperty<?>[] r112 = dd1.e.f467924a;
        if (((Boolean) r111.getValue(null, r112[0])).booleanValue() == false) goto L39;
        Activity r113 = this.f102748d;
        c9.b r114 = new c9.b();
        r114.f112681a = r113;
        r114.f112682b = 2;
        r114.f112685e = s1.B(R.string.wallet_no_finish_douyin_account_verify);
        r114.f112686f = s1.B(R.string.wallet_no_finish_douyin_account_verify_content);
        String r115 = s1.B(R.string.wallet_no_finish_douyin_account_verify_btn_left);
        p r116 = new p();
        r114.f112690j = r115;
        r114.f112691k = r116;
        String r117 = s1.B(R.string.wallet_no_finish_douyin_account_verify_btn_right);
        o r118 = new o(this);
        r114.f112692l = r117;
        r114.f112693m = r118;
        c9 r119 = new c9(r114.f112681a, r114);
        r119.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r119) == false) goto L61;
        DialogLancet.handleBlockedDialogShow(r119);
    L38:
        int r120 = ed1.a.f472185a;
        ed1.a.a("livesdk_real_name_unfinished_remind_toast_show", new HashMap());
        this.f102745a.onSuccess(this.f102747c);
        return;
    L61:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L57
    L37:
        DialogLancet.beforeDialogShow(r119);
        r119.show();
        DialogLancet.afterDialogShow(r119);
        goto L38
    L39:
        int r121 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "verify not verified");
        String r122 = (String) dd1.e.f467927d.getValue(null, r112[2]);
        zz0.h.b(this.f102748d, r122);
        this.f102745a.onSuccess(this.f102747c);
        return;
    L25:
        int r123 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "verify data is null");
        this.f102745a.onError(new Exception("verify data is null"));
        return;
    L11:
        if (r101.data.c() == null) goto L12;
        if (r101.data.c().b() == false) goto L15;
        this.f102747c.put(CJOuterPayManager.KEY_BINDPHONE, Boolean.TRUE);
        goto L7
    L15:
        int r124 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "bindPhone not verified");
        if (r101.data.c().c() == false) goto L18;
        Bundle r125 = new Bundle();
        r125.putInt("account_type", r101.data.c().a());
        ((dr2.c) com.bytedance.android.live.revenue.core.util.e.a(dr2.c.class)).B6(this.f102748d, r125);
    L19:
        this.f102745a.onSuccess(this.f102747c);
        return;
    L18:
        ((dr2.c) com.bytedance.android.live.revenue.core.util.e.a(dr2.c.class)).Sd(this.f102748d);
        goto L19
    L12:
        int r126 = v.f91009a;
        v.e("VERIFY_WITHDRAW_WALLETSERVICE", "bindPhone data is null");
        this.f102745a.onError(new Exception("bindPhone data is null"));
        return;
    L55:
        this.f102745a.onSuccess(this.f102747c);
    }

    public s(SingleSubject r100, List r101, Map r102, Activity r103) {
        this.f102745a = r100;
        this.f102746b = r101;
        this.f102747c = r102;
        this.f102748d = r103;
    }
}
