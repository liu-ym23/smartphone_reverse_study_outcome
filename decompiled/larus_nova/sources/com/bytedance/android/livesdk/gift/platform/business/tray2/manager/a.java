package com.bytedance.android.livesdk.gift.platform.business.tray2.manager;

import android.os.Message;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a<T> implements f<T>, WeakHandler.IHandler, y02.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f130384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f130385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHandler f130386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f130387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f130388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y02.f<T> f130389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f130390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f130391h;

    public abstract y02.f<T> f();

    public final void k() {
        l(true, "turn true from release");
        this.f130389f.clear();
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.f130384a, "unregisterConsumer ");
        this.f130388e = -1;
        this.f130385b = null;
        this.f130386c.removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public T c() {
        int r100 = com.bytedance.android.livesdk.gift.platform.core.utils.c.f132022a;
        if (this.f130390g == true) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "MsgManager is disabled,pollNextMessage return null " + this.f130391h);
        return null;
    L7:
        return this.f130389f.pollFirst();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final void e() {
        this.f130386c.removeMessages(this.f130387d);
    }

    public final int g() {
        return this.f130389f.size();
    }

    public final void i() {
        if (this.f130390g == true) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "notifyConsumeMessage MsgManager is disabled,reason:" + this.f130391h);
        return;
    L6:
        g r100 = this.f130385b;
        if (r100 == null) goto L10;
        r100.og();
    L10:
        if (this.f130385b != null) goto L13;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a r101 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d;
        String r102 = this.f130384a + ' ' + this + " ERROR!!! messageConsumer is null!!!!";
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d r103 = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.NO_CONSUMER, this.f130384a + " consumer is null");
        r101.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.a(BDLocationException.ERROR_TMAP_CLIENT, r102, "-1", r103);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final y02.g<T> iterator() {
        return this.f130389f.iterator();
    }

    public a() {
        this.f130384a = "BaseMsgManager";
        this.f130386c = new WeakHandler(this);
        this.f130387d = 2;
        this.f130388e = -1;
        this.f130390g = true;
        this.f130391h = "";
        y02.f<T> r100 = f();
        this.f130389f = r100;
        r100.c(this);
    }

    @Override // y02.e
    public final void b() {
        i();
        int r100 = com.bytedance.android.livesdk.gift.platform.core.utils.c.f132022a;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final boolean d(NormalGiftMessage r100) {
        return this.f130389f.d(r100);
    }

    public void h(Message r110) {
        c0 r100 = c0.f130474a;
        Object r101 = null;
        if (r110 == null) goto L5;
        Object r102 = r110.obj;
    L7:
        if ((r102 instanceof Map) == true) goto L9;
        r102 = null;
    L9:
        Map r103 = (Map) r102;
        if (r103 == null) goto L12;
        r101 = r103.get("assetId");
    L12:
        if (r101 == null) goto L18;
        c0.b(false, ((Long) r101).longValue(), "", -114514, "consume_time_out", 0, "", "", MapsKt.emptyMap(), MapsKt.emptyMap(), g02.a.e(), false, false);
        g r104 = this.f130385b;
        if (r104 == null) goto L19;
        r104.Ge(r110);
        return;
    L19:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.what);
    L5:
        int r102 = this.f130387d;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.intValue() != r102) goto L12;
        h(r100);
        return;
    L12:
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void j(g r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.f130384a, "registerConsumer " + r100 + " type " + r101);
        this.f130388e = r101;
        this.f130385b = r100;
    }

    public final void l(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f130390g = r100;
        this.f130391h = r101;
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L12:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "Enable Changed:" + r100 + " reason:" + r101);
        return;
    L8:
        if (v.a() == false) goto L12;
        throw new IllegalArgumentException("change enable state queue must have a reason!");
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.manager.f
    public final void a(long r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
        if (this.f130390g == true) goto L6;
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.f130384a, "notifyConsumeMessageWhenTimeout MsgManager is disabled,reason:" + this.f130391h);
        return;
    L6:
        Message r103 = Message.obtain();
        r103.what = this.f130387d;
        r103.arg1 = this.f130388e;
        r103.obj = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(RemoteMessageConst.MSGID, r101), TuplesKt.to("assetId", Long.valueOf(r102))});
        e();
        this.f130386c.sendMessageDelayed(r103, r100);
    }
}
