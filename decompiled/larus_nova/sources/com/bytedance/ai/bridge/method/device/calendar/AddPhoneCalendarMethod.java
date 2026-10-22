package com.bytedance.ai.bridge.method.device.calendar;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.calendar.AbsAddPhoneCalendarMethodIDL;
import f3.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/calendar/AddPhoneCalendarMethod;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneCalendarMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneCalendarMethodIDL$AddPhoneCalendarParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneCalendarMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddPhoneCalendarMethod extends AbsAddPhoneCalendarMethodIDL {
    public AddPhoneCalendarMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r210, ParamModel r211, h r212) {
        AbsAddPhoneCalendarMethodIDL.a r100 = (AbsAddPhoneCalendarMethodIDL.a) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        f.f35454l.getClass();
        Intrinsics.checkNotNullParameter(r100, "params");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L23
        String r102 = r100.getTitle();     // Catch: Throwable -> L23
        String[] r103 = d.f35452a;     // Catch: Throwable -> L23
        String r104 = StringsKt.trim(r102).toString();     // Catch: Throwable -> L23
        if (r104.length() != 0) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L22;
        long r110 = d.c(r100.getStartTime(), r100.getEndTime(), r100.getAlarmOffset());     // Catch: Throwable -> L23
        long r106 = r100.getStartTime();     // Catch: Throwable -> L23
        Boolean r107 = r100.getAllDay();     // Catch: Throwable -> L23
        if (r107 == null) goto L11;
        boolean r111 = r107.booleanValue();     // Catch: Throwable -> L23
    L12:
        String r112 = r100.getDescription();     // Catch: Throwable -> L23
        String r113 = r100.getLocation();     // Catch: Throwable -> L23
        Boolean r108 = r100.getAlarm();     // Catch: Throwable -> L23
        if (r108 == null) goto L15;
        boolean r114 = r108.booleanValue();     // Catch: Throwable -> L23
    L16:
        Long r109 = r100.getAlarmOffset();     // Catch: Throwable -> L23
        if (r109 == null) goto L19;
        long r115 = r109.longValue();     // Catch: Throwable -> L23
    L20:
        Object r116 = Result.m9449constructorimpl(new f(r104, r106, r111, r112, r113, r110, r114, r115, r100.getPath(), null, null));     // Catch: Throwable -> L23
    L25:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 != null) goto L28;
        d.a(r210, (f) r116, false, "addPhoneCalendar", r212, new a());
        return;
    L28:
        String r118 = r117.getMessage();
        if (r118 != null) goto L31;
        r118 = "The calendar event parameter is invalid.";
    L31:
        h.a.a(r212, r118, null, null, 14);
        return;
    L19:
        r115 = 0;
        goto L20
    L15:
        r114 = true;
        goto L16
    L11:
        r111 = false;
        goto L12
    L22:
        throw new IllegalArgumentException("The title parameter should not be empty.");     // Catch: Throwable -> L23
    L6:
        r105 = false;
    L23:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    }
}
