package com.bytedance.applet.aibridge.calendar;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.internal.LinkedTreeMap;
import com.larus.platform.api.b5;
import com.larus.platform.service.y;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import fv3.b;
import java.util.ArrayList;
import java.util.Iterator;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/calendar/UpdateReminderInfoMethod;", "Lcom/bytedance/applet/aibridge/calendar/AbsUpdateReminderInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/calendar/AbsUpdateReminderInfoMethodIDL$UpdateReminderInfoParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/calendar/AbsUpdateReminderInfoMethodIDL$UpdateReminderInfoResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateReminderInfoMethod extends AbsUpdateReminderInfoMethodIDL {

    public static final class a {
    }

    static {
    }

    public UpdateReminderInfoMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r110, ParamModel r111, h r112) {
        AbsUpdateReminderInfoMethodIDL.a r113 = (AbsUpdateReminderInfoMethodIDL.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        ArrayList r114 = new ArrayList();
        int r100 = r113.getType();
        if (r100 != UpdateCalendarType.ADD.getType()) goto L10;
        Iterator<T> r115 = r113.getReminderInfo().iterator();
    L6:
        if (r115.hasNext() == false) goto L8;
        RemindInfo r101 = fv3.a.b((LinkedTreeMap) r115.next());
        b5 r102 = y.f365859a.a(fv3.a.a(r101));
        r114.add(b.a(r102, r101.getId()));
        FLogger.f375446a.d("UpdateReminderInfoMethod", "handle: -" + r101.getId() + "-------" + r102.f364873a);
        goto L6
    L8:
        Intrinsics.checkNotNullParameter(AbsUpdateReminderInfoMethodIDL.b.class, "<this>");
        BaseModel r116 = c.a(AbsUpdateReminderInfoMethodIDL.b.class);
        ((AbsUpdateReminderInfoMethodIDL.b) r116).setResultInfo(r114);
        r112.b((ResultModel) r116, "");
        return;
    L10:
        if (r100 != UpdateCalendarType.DELETE.getType()) goto L20;
        Iterator<T> r117 = r113.getReminderInfo().iterator();
    L13:
        if (r117.hasNext() == false) goto L18;
        RemindInfo r103 = fv3.a.b((LinkedTreeMap) r117.next());
        y r104 = y.f365859a;
        String r105 = fv3.a.a(r103).f364861a;
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        r114.add(b.a(r104.remove(r105), r103.getId()));
        goto L13
    L18:
        Intrinsics.checkNotNullParameter(AbsUpdateReminderInfoMethodIDL.b.class, "<this>");
        BaseModel r118 = c.a(AbsUpdateReminderInfoMethodIDL.b.class);
        ((AbsUpdateReminderInfoMethodIDL.b) r118).setResultInfo(r114);
        r112.b((ResultModel) r118, "");
        return;
    L20:
        if (r100 != UpdateCalendarType.UPDATE.getType()) goto L26;
        Iterator<T> r119 = r113.getReminderInfo().iterator();
    L23:
        if (r119.hasNext() == false) goto L25;
        RemindInfo r106 = fv3.a.b((LinkedTreeMap) r119.next());
        y r107 = y.f365859a;
        r107.remove(r106.getId());
        b5 r108 = r107.a(fv3.a.a(r106));
        FLogger.f375446a.d("UpdateReminderInfoMethod", "handle: -" + r106.getId() + "-------" + r108.f364873a);
        r114.add(b.a(r108, r106.getId()));
        goto L23
    L25:
        Intrinsics.checkNotNullParameter(AbsUpdateReminderInfoMethodIDL.b.class, "<this>");
        BaseModel r120 = c.a(AbsUpdateReminderInfoMethodIDL.b.class);
        ((AbsUpdateReminderInfoMethodIDL.b) r120).setResultInfo(r114);
        r112.b((ResultModel) r120, "");
        return;
    L26:
        h.a.a(r112, null, null, null, 15);
    }
}
