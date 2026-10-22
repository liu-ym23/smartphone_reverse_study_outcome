package com.bytedance.android.live.browser.jsbridge.answer;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.registerMessage", owner = "JiangXZ")
public final class h extends a implements com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f62942h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f62943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f62944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f62945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f62946g;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        ALogger.i(this.f62943d, "LiveRegisterMessageMethod release");
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 1);
        if (r100 == null) goto L19;
        Iterator<T> r101 = this.f62946g.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = (String) r101.next();
        emc.a r103 = r100.getStreamMessageManager().getValue();
        if (r103 == null) goto L6;
        r103.removeMessageListener(r102, this.f62945f);
        goto L6
    L10:
        this.f62946g.clear();
        vlc.d r104 = r100.getMessageManager().getValue();
        if (r104 == null) goto L20;
        r104.removeMessageListener(this.f62944e);
        return;
    L20:
        return;
    }

    public h() {
        this.f62943d = "LiveRegisterMessageMethod";
        this.f62946g = new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.String] */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(final IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        a.b r102 = (a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        long r103 = CastLongProtector.parseLong(r102.getRoomId());
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, r103, 1);
        if (r104 != null) goto L5;
        r104 = RoomContext.a.b(null, r102.getUniqueIdPreview());
    L5:
        ALogger.i(this.f62943d, "LiveRegisterMessageMethod get RoomContext roomId: " + r103 + ", roomContext: " + r104);
        if (r104 == null) goto L32;
        List<String> r105 = r102.getNormalMessageMethod();
        if (r105 == null) goto L14;
        Iterator<T> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        final String r107 = (String) r106.next();
        r104.getMessageManager().c(new LiveRegisterMessageMethod$registerNormalMessage$1(this, r107, r100));
    L14:
        List<String> r108 = r102.getStreamMessageMethod();
        if (r108 == null) goto L26;
        Iterator<T> r109 = r108.iterator();
    L18:
        if (r109.hasNext() == false) goto L26;
        final ?? r111 = (String) r109.next();
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = r111;
        if (StringsKt.startsWith$default(r111, MessageType.WEBCAST, false, 2, null) == true) goto L23;
        r112.element = MessageType.WEBCAST + r111;
    L23:
        if (this.f62945f != null) goto L25;
        this.f62945f = new g(this, r112, r100);
    L25:
        r104.getMessageManager().c(new LiveRegisterMessageMethod$registerStreamMessage$2(this, r112, r111, r100));
        r104.getStreamMessageManager().c(new LiveRegisterMessageMethod$registerStreamMessage$3(this, r112));
    L26:
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) ne7.e.b(a.c.class), null, 2, null);
        return;
    }

    public static final void a(h r100, tlc.d r101, String r102, IBDXBridgeContext r103) {
        r100.getClass();
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("sync_data", GsonProtectorUtils.toJson(GsonHelper.get(), r101));
        r104.put("class_name", r102);
        r103.sendEvent("H5_wrds", r104);
    }
}
