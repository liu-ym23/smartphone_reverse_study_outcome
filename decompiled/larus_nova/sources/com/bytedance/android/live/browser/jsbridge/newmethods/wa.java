package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.RegisterWrdsResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class wa extends w20.h5<w20.hd, RegisterWrdsResultModel> implements com.bytedance.android.live.browser.jsbridge.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f63704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public qa f63705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public oa f63706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PublishProcessor<com.ss.ugc.live.sdk.message.wrsc.data.a> f63707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f63708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MultiLinkFrequencyOptConfig f63709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f63710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DataCenter f63711h;

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
        ALogger.i(this.f63704a, "RegisterWrdsMethod onClean");
        this.f63708e.clear();
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.f63711h, 0, 2);
        if (r100 == null) goto L7;
        ylc.e r101 = com.bytedance.android.livesdk.chatroom.utils.n3.g(r100);
        qa r102 = this.f63705b;
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r102, "listener");
        r101.i(r102);
    L7:
        DataCenter r103 = this.f63711h;
        if (r103 == null) goto L12;
        vlc.d r104 = (vlc.d) r103.get("data_message_manager", null);
        if (r104 == null) goto L12;
        ALogger.i(this.f63704a, "removeMessageListener! listener " + this.f63706c);
        r104.removeMessageListener(this.f63706c);
    L12:
        int r105 = com.bytedance.android.live.browser.utils.j.f64310a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r106 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
        CallContext r107 = getCallContext();
        if (com.bytedance.android.live.core.setting.r0.f65396a.getValue().booleanValue() == false) goto L19;
        if (r107 == null) goto L20;
        View r108 = r107.f249269d;
        if (r108 == null) goto L21;
        r108.setTag(R.id.listeners_msg_wrds, null);
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        onClean();
    }

    public wa(DataCenter r100) {
        this.f63711h = r100;
        this.f63704a = "RegisterWrdsMethod";
        this.f63707d = new PublishProcessor();
        this.f63708e = new CompositeDisposable();
        this.f63709f = com.bytedance.android.live.core.setting.v2.f65430a.getValue();
        this.f63710g = String.valueOf(System.currentTimeMillis());
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        w20.hd r112 = (w20.hd) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, this.f63711h, 0, 2);
        if (r100 == null) goto L111;
        List<String> r113 = r112.a();
        if (r113 == null) goto L87;
        Iterator<T> r114 = r113.iterator();
    L9:
        if (r114.hasNext() == false) goto L87;
        String r101 = (String) r114.next();
        Object r102 = null;
        if (StringsKt.endsWith$default(r101, "SyncData", false, 2, null) == true) goto L12;
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        if (this.f63711h != null) goto L71;
        com.bytedance.android.live.core.utils.f2.g();
        Unit r103 = Unit.INSTANCE;
    L71:
        DataCenter r104 = this.f63711h;
        if (r104 == null) goto L9;
        vlc.d r105 = (vlc.d) r104.get("data_message_manager", null);
        if (StringsKt.startsWith$default(r101, MessageType.WEBCAST, false, 2, null) == true) goto L76;
        r101 = MessageType.WEBCAST + r101;
    L76:
        if (r105 == null) goto L81;
        tlc.d r106 = bc2.d.a(r105, r101);
        if (r106 == null) goto L81;
        ALogger.i(this.f63704a, "wrds v2 key: " + r101 + " get dataSync, msgId: " + r106.getMessageId() + ", isFromWrds: " + com.ss.ugc.live.sdk.msg.utils.a.b(r106));
        Schedulers.io().scheduleDirect(new na(r106, this, r101, r111));
    L81:
        if (this.f63706c != null) goto L83;
        this.f63706c = new oa(this, r101, r111);
    L83:
        ALogger.i(this.f63704a, "registerMessage! key: " + r101 + " get dataSync, listener " + this.f63706c + ", im " + r105);
        if (r105 == null) goto L86;
        r105.addMessageListener(r101, this.f63706c);
    L86:
        int r107 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.c(r111, r101, this.f63706c);
        goto L9
    L12:
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        ylc.e r108 = com.bytedance.android.livesdk.chatroom.utils.n3.g(r100);
        Intrinsics.checkNotNullParameter(r101, "key");
        com.ss.ugc.live.sdk.message.wrsc.data.a r109 = r108.e(r101);
        if (r109 == null) goto L16;
        ALogger.i(this.f63704a, "wrds key: " + r101 + " get dataSync, version: " + r109.f458180a + ", bizLogId: " + r109.f458182c);
        Schedulers.io().scheduleDirect(new pa(r109, this, r111));
    L16:
        if (this.f63705b != null) goto L18;
        this.f63705b = new qa(this, r101, r111);
        this.f63708e.add(this.f63707d.onBackpressureLatest().groupBy(ra.f63630a).flatMap(new ua(this)).subscribe(new va(this, r111)));
    L18:
        IKtvService r115 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r115 == null) goto L24;
        Pair<String, Map<String, Map<String, List<Object>>>> r116 = r115.getRoomWrdsListenerData();
        if (r116 == null) goto L24;
        Map<String, Map<String, List<Object>>> r117 = r116.getSecond();
        if (r117 == null) goto L24;
    L25:
        IKtvService r118 = (IKtvService) jc1.k.f(IKtvService.class);
        String r119 = "";
        if (r118 == null) goto L31;
        Pair<String, Map<String, Map<String, List<Object>>>> r120 = r118.getRoomWrdsListenerData();
        if (r120 == null) goto L31;
        String r121 = r120.getFirst();
        if (r121 == null) goto L31;
    L32:
        Map<String, List<Object>> r122 = r117.get(r121);
        if (r122 == null) goto L37;
        List<Object> r123 = r122.get(r101);
        if (r123 == null) goto L37;
        qa r124 = this.f63705b;
        Intrinsics.checkNotNull(r124);
        r123.add(r124);
    L55:
        qa r125 = this.f63705b;
        Intrinsics.checkNotNull(r125);
        r108.a(r101, r125);
        int r126 = com.bytedance.android.live.browser.utils.n.f64317a;
        qa r127 = this.f63705b;
        if (com.bytedance.android.live.core.setting.r0.f65396a.getValue().booleanValue() == false) goto L9;
        if (r111 == null) goto L9;
        View r128 = r111.f249269d;
        if (r128 == null) goto L9;
        Object r129 = r128.getTag(R.id.listeners_msg_wrds);
        if ((r129 instanceof LinkedHashSet) == false) goto L64;
        r102 = r129;
    L64:
        LinkedHashSet r130 = (LinkedHashSet) r102;
        if (r130 != null) goto L67;
        r130 = new LinkedHashSet();
        r128.setTag(R.id.listeners_msg_wrds, r130);
    L67:
        r130.add(r127);
    L37:
        IKtvService r131 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r131 == null) goto L43;
        Pair<String, Map<String, Map<String, List<Object>>>> r132 = r131.getRoomWrdsListenerData();
        if (r132 == null) goto L43;
        Map<String, Map<String, List<Object>>> r133 = r132.getSecond();
        if (r133 == null) goto L43;
    L44:
        IKtvService r134 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r134 == null) goto L52;
        Pair<String, Map<String, Map<String, List<Object>>>> r135 = r134.getRoomWrdsListenerData();
        if (r135 == null) goto L52;
        String r136 = r135.getFirst();
        if (r136 == null) goto L52;
        r119 = r136;
    L52:
        Map<String, List<Object>> r137 = r133.get(r119);
        if (r137 == null) goto L55;
        qa r138 = this.f63705b;
        Intrinsics.checkNotNull(r138);
        List<Object> r139 = r137.put(r101, CollectionsKt.arrayListOf(new Object[]{r138}));
    L43:
        r133 = new LinkedHashMap();
    L31:
        r121 = "";
    L24:
        r117 = new LinkedHashMap();
    L87:
        com.bytedance.android.live.browser.utils.j.b(r111, this);
        RegisterWrdsResultModel r140 = new RegisterWrdsResultModel();
        r140.b(new JsonObject());
        JsonObject r141 = r140.a();
        if (r141 == null) goto L90;
        r141.addProperty("listener_id", this.f63710g);
    L90:
        IInteractService r142 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r142 == null) goto L95;
        ih0.b r143 = r142.dynamicService(this.f63711h);
        if (r143 == null) goto L95;
        r143.oe(this.f63710g, this.f63706c);
    L95:
        finishWithResult(r140);
        return;
    }

    public static final void j(wa r100, com.ss.ugc.live.sdk.message.wrsc.data.a r101, CallContext r102) {
        r100.getClass();
        JSONObject r103 = new JSONObject();
        r103.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), r101.f458184e));
        int r104 = com.bytedance.android.live.browser.jsbridge.d.f63189a;
        r103.put("class_name", com.bytedance.android.live.browser.jsbridge.d.a(r101.f458186g));
        r102.b("H5_wrds", r103);
    }

    public static final void k(wa r100, tlc.d r101, String r102, CallContext r103) {
        r100.getClass();
        JSONObject r104 = new JSONObject();
        r104.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.getLynxWorkaround(), r101));
        r104.put("class_name", com.bytedance.android.live.browser.jsbridge.d.a(r102));
        r103.b("H5_wrds", r104);
    }
}
