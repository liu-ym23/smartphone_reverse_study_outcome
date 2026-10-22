package com.bytedance.android.live.liveinteract.jsbridge.method;

import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.RegisterWrdsResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.h5;
import w20.hd;

/* JADX INFO: loaded from: classes46.dex */
public final class b1 extends h5<hd, RegisterWrdsResultModel> implements com.bytedance.android.live.browser.jsbridge.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a1 f74201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z0 f74202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f74203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MessageHub f74204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<String, Object, Unit> f74205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f74206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Map<String, List<Object>>> f74207h;

    @Override // com.bytedance.android.live.browser.jsbridge.e
    public final void onClean() {
        a1 r100 = this.f74201b;
        if (r100 == null) goto L7;
        MessageHub r101 = this.f74204e;
        if (r101 == null) goto L7;
        r101.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, r100);
    L7:
        Iterator<T> r102 = this.f74203d.iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        String r103 = (String) r102.next();
        MessageHub r104 = this.f74204e;
        z0 r105 = this.f74202c;
        if (r104 == null) goto L9;
        if (r105 == null) goto L9;
        r104.removeMessageListener(r103, r105);
        goto L9
    L14:
        int r106 = com.bytedance.android.live.browser.utils.j.f64310a;
        com.bytedance.android.live.browser.utils.j.a(getCallContext());
        int r107 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.b(getCallContext());
        CallContext r108 = getCallContext();
        if (com.bytedance.android.live.core.setting.r0.f65396a.getValue().booleanValue() == false) goto L28;
        if (r108 == null) goto L29;
        View r109 = r108.f249269d;
        if (r109 == null) goto L30;
        r109.setTag(R.id.listeners_msg_wrds_feed, null);
        return;
    L30:
        return;
    L29:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        onClean();
    }

    public /* synthetic */ b1(MessageHub r100) {
        this(r100, null, "", new LinkedHashMap());
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        hd r100 = (hd) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r101 = r100.a();
        if (r101 == null) goto L55;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L55;
        String r103 = (String) r102.next();
        char r104 = 0;
        if (StringsKt.endsWith$default(r103, "SyncData", false, 2, null) == true) goto L9;
        Intrinsics.checkNotNullParameter(r103, "clazz");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (StringsKt.startsWith$default(r103, MessageType.WEBCAST, false, 2, null) == true) goto L44;
        r103 = MessageType.WEBCAST + r103;
    L44:
        MessageHub r105 = this.f74204e;
        if (r105 == null) goto L50;
        tlc.d r106 = MessageHub.DefaultImpls.getLatestWRDSMessage$default(r105, r103, null, 2, null);
        if (r106 == null) goto L50;
        ALogger.i(this.f74200a, "wrds v2 key: " + r103 + " get dataSync, msgId: " + r106.getMessageId() + ", isFromWrds: " + com.ss.ugc.live.sdk.msg.utils.a.b(r106));
        Schedulers.io().scheduleDirect(new y0(r106, this, r103, r111));
    L50:
        if (this.f74202c != null) goto L52;
        this.f74202c = new z0(this, r111);
    L52:
        if (r105 == null) goto L54;
        ALogger.i(this.f74200a, "register wrds v2 key: " + r103 + " get dataSync, clazz: " + r103);
        z0 r107 = this.f74202c;
        Intrinsics.checkNotNull(r107);
        r105.addMessageListener(r103, r107);
        this.f74203d.add(r103);
    L54:
        int r108 = com.bytedance.android.live.browser.utils.n.f64317a;
        com.bytedance.android.live.browser.utils.n.c(r111, r103, this.f74202c);
        goto L6
    L9:
        Intrinsics.checkNotNullParameter(r103, "clazz");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f74201b != null) goto L12;
        this.f74201b = new a1(this, r103, r111);
    L12:
        a1 r109 = this.f74201b;
        if (r109 == null) goto L6;
        Map<String, List<Object>> r112 = this.f74207h.get(this.f74206g);
        MultiPreviewSyncDataType[] r113 = MultiPreviewSyncDataType.values();
        int r114 = r113.length;
        int r115 = 0;
    L15:
        if (r115 >= r114) goto L6;
        MultiPreviewSyncDataType r116 = r113[r115];
        String r117 = r116.getSyncKey();
        if (Intrinsics.areEqual(r117, r103) == false) goto L40;
        if (r112 == null) goto L23;
        List<Object> r118 = r112.get(r117);
        if (r118 == null) goto L23;
        r118.add(r109);
    L25:
        MessageHub r119 = this.f74204e;
        if (r119 == null) goto L28;
        r119.addWRDSListener(r116, r109, true);
    L28:
        int r120 = com.bytedance.android.live.browser.utils.n.f64317a;
        a1 r121 = this.f74201b;
        if (com.bytedance.android.live.core.setting.r0.f65396a.getValue().booleanValue() == false) goto L40;
        if (r111 == null) goto L40;
        View r122 = r111.f249269d;
        if (r122 == null) goto L40;
        Object r123 = r122.getTag(R.id.listeners_msg_wrds_feed);
        if ((r123 instanceof LinkedHashSet) == true) goto L36;
        r123 = null;
    L36:
        LinkedHashSet r124 = (LinkedHashSet) r123;
        if (r124 != null) goto L39;
        r124 = new LinkedHashSet();
        r122.setTag(R.id.listeners_msg_wrds_feed, r124);
    L39:
        r124.add(new Pair(r116, r121));
    L23:
        if (r112 == null) goto L25;
        Object[] r125 = new Object[1];
        r125[r104] = r109;
        List<Object> r126 = r112.put(r117, CollectionsKt.arrayListOf(r125));
    L40:
        r115 = r115 + 1;
        r104 = 0;
    L55:
        com.bytedance.android.live.browser.utils.j.b(r111, this);
        finishWithSuccess();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b1(MessageHub r100, Function2<? super String, Object, Unit> r101, String r102, Map<String, Map<String, List<Object>>> r103) {
        Intrinsics.checkNotNullParameter(r102, "hybridCardHashCode");
        Intrinsics.checkNotNullParameter(r103, "wrdsDataUpdateListenerMap");
        this.f74204e = r100;
        this.f74205f = r101;
        this.f74206g = r102;
        this.f74207h = r103;
        this.f74200a = "RegisterWrdsFeedMethod";
        this.f74203d = new LinkedHashSet();
    }

    public static final void j(b1 r100, tlc.d r101, String r102, CallContext r103) {
        r100.getClass();
        JSONObject r104 = new JSONObject();
        r104.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.get(), r101));
        r104.put("class_name", r102);
        ALogger.i(r100.f74200a, "sendJsEvent wrds v2 message " + r101 + ", json " + r104);
        r103.b("H5_wrds", r104);
    }
}
