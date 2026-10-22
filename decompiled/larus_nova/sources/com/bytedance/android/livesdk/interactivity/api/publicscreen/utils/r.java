package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommonKt;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133649a = 0;

    static {
    }

    @JvmStatic
    public static final PSMessageAction a(IPublicAreaCommon r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = r100.getActionType();
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return PSMessageAction.UNKNOW;
    L17:
        return PSMessageAction.SYSTEM;
    L18:
        return PSMessageAction.BUSINESS;
    L19:
        return PSMessageAction.BASIC;
    L15:
        return PSMessageAction.CHAT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final boolean b(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        int r101 = com.bytedance.android.livesdk.interactivity.service.model.e.f140912a;
        boolean r102 = false;
        if (com.bytedance.android.livesdk.interactivity.service.model.e.a.a().publicScreenMessage == true) goto L6;
    L28:
        return r102;
    L6:
        if ((r100 instanceof com.bytedance.android.livesdk.interactivity.api.n) == false) goto L12;
        IPublicAreaCommon r103 = ((com.bytedance.android.livesdk.interactivity.api.n) r100).a().c();
        if (r103 != null) goto L10;
    L19:
        if (r102 == false) goto L28;
        boolean r104 = TextMessageTracer.f133629a;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L28;
        StringBuilder r105 = new StringBuilder("filter message by server ");
        T r106 = r100.f133141b;
        if (r106 == 0) goto L26;
        Long r107 = Long.valueOf(r106.getMessageId());
    L27:
        r105.append(r107);
        ALogger.i("TextMessageTracer", r105.toString());
        goto L28
    L26:
        r107 = null;
        goto L27
    L10:
        if (IPublicAreaCommonKt.getNeedFilterDisplay(r103) != true) goto L19;
    L18:
        r102 = true;
        goto L19
    L12:
        tlc.d r108 = r100.f133141b;
        if (r108 == null) goto L19;
        IPublicAreaCommon r109 = v3.a(r108);
        if (r109 == null) goto L19;
        if (IPublicAreaCommonKt.getNeedFilterDisplay(r109) != true) goto L19;
        goto L18
    }

    @JvmStatic
    public static final boolean c(tlc.d r100) {
        String r101 = null;
        if ((r100 instanceof com.bytedance.android.live.base.model.message.t) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.live.base.model.message.t r102 = (com.bytedance.android.live.base.model.message.t) r100;
        if (r102 == null) goto L11;
        Map<String, String> r103 = r102.getMessageExtra();
        if (r103 == null) goto L11;
        r101 = r103.get("top_message");
    L11:
        return Intrinsics.areEqual(r101, "1");
    }

    @JvmStatic
    public static final void d(com.bytedance.android.live.base.model.message.t r100, PSMessageAction r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "action");
        if ((r100 instanceof u3) == false) goto L8;
        IPublicAreaCommon r102 = ((u3) r100).getOrInitPublicAreaCommon();
        if (r102 == null) goto L9;
        r102.setActionType(r101.getServerValue());
        return;
    L9:
        return;
    }
}
