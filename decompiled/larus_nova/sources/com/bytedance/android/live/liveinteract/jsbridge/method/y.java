package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class y extends com.bytedance.ies.web.jsbridge2.f<a, Unit> implements com.bytedance.android.live.browser.jsbridge.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.l f74263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Integer> f74264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f74265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageHub f74266d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/jsbridge/method/y$a;", "", "", "", "typeList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setTypeList", "(Ljava/util/List;)V", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("type_list")
        private List<String> typeList;

        public a() {
        }

        public final List<String> a() {
            return this.typeList;
        }
    }

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
        DataCenter r100 = this.f74265c;
        if (r100 == null) goto L7;
        vlc.d r101 = (vlc.d) r100.get("data_message_manager", null);
        if (r101 == null) goto L7;
        r101.removeMessageListener(this.f74263a);
    L7:
        Iterator<Integer> r102 = this.f74264b.iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        Integer r103 = r102.next();
        vlc.l r104 = this.f74263a;
        if (r104 == null) goto L9;
        MessageHub r105 = this.f74266d;
        if (r105 == null) goto L9;
        r105.removeMessageListener(r103.intValue(), r104);
        goto L9
    L15:
        int r106 = com.bytedance.android.live.browser.utils.j.f64310a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r107 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        onClean();
    }

    public y(DataCenter r100, MessageHub r101) {
        this.f74265c = r100;
        this.f74266d = r101;
        this.f74264b = new ArrayList();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r110) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        DataCenter r102 = this.f74265c;
        if (r102 == null) goto L5;
        vlc.d r103 = (vlc.d) r102.get("data_message_manager", null);
    L7:
        if (r103 == null) goto L25;
        vlc.d r104 = (vlc.d) this.f74265c.get("data_message_manager", null);
        List<String> r105 = r101.a();
        if (r105 == null) goto L45;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L45;
        String r107 = (String) r106.next();
        MessageType[] r108 = MessageType.values();
        int r109 = r108.length;
        int r111 = 0;
    L14:
        if (r111 >= r109) goto L12;
        MessageType r112 = r108[r111];
        if (com.bytedance.android.livesdk.message.linker.m.a(r112, r107) == true) goto L18;
        r111 = r111 + 1;
        goto L14
    L18:
        if (this.f74263a != null) goto L20;
        this.f74263a = new z(r110);
    L20:
        if (r104 == null) goto L22;
        r104.addMessageListener(r112.getIntType(), this.f74263a);
    L22:
        int r113 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.c(r110, Integer.valueOf(r112.getIntType()), this.f74263a);
    L45:
        com.bytedance.android.live.browser.utils.j.b(r110, this);
        finishWithSuccess();
        return;
    L25:
        if (this.f74266d == null) goto L45;
        List<String> r114 = r101.a();
        if (r114 == null) goto L45;
        Iterator<T> r115 = r114.iterator();
    L30:
        if (r115.hasNext() == false) goto L45;
        String r116 = (String) r115.next();
        MessageType[] r117 = MessageType.values();
        int r118 = r117.length;
        int r119 = 0;
    L32:
        if (r119 >= r118) goto L30;
        MessageType r120 = r117[r119];
        if (com.bytedance.android.livesdk.message.linker.m.a(r120, r116) == true) goto L35;
        r119 = r119 + 1;
        goto L32
    L35:
        MessageHub r121 = this.f74266d;
        if (this.f74263a != null) goto L38;
        this.f74263a = new a0(r110);
    L38:
        vlc.l r122 = this.f74263a;
        if (r122 == null) goto L43;
        this.f74264b.add(Integer.valueOf(r120.getIntType()));
        if (r121 == null) goto L43;
        r121.addMessageListener(r120.getIntType(), r122);
    L43:
        int r123 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.c(r110, Integer.valueOf(r120.getIntType()), this.f74263a);
        goto L30
    L5:
        r103 = null;
        goto L7
    }
}
