package com.bytedance.ai.bridge.method.device.calendar;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.calendar.AbsAddPhoneRepeatCalendarMethodIDL;
import f3.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/calendar/AddPhoneRepeatCalendarMethod;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneRepeatCalendarMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneRepeatCalendarMethodIDL$AddPhoneRepeatCalendarParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneRepeatCalendarMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddPhoneRepeatCalendarMethod extends AbsAddPhoneRepeatCalendarMethodIDL {
    public AddPhoneRepeatCalendarMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r210, ParamModel r211, h r212) {
        AbsAddPhoneRepeatCalendarMethodIDL.a r100 = (AbsAddPhoneRepeatCalendarMethodIDL.a) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        f.f35454l.getClass();
        Intrinsics.checkNotNullParameter(r100, "params");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L37
        String r102 = r100.getTitle();     // Catch: Throwable -> L37
        String[] r103 = d.f35452a;     // Catch: Throwable -> L37
        String r104 = StringsKt.trim(r102).toString();     // Catch: Throwable -> L37
        if (r104.length() != 0) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L36;
        long r110 = d.c(r100.getStartTime(), r100.getEndTime(), r100.getAlarmOffset());     // Catch: Throwable -> L37
        String r106 = r100.getRepeatInterval();     // Catch: Throwable -> L37
        if (r106 != null) goto L11;
        r106 = BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH;
    L11:
        RepeatInterval r111 = d.b(r106);     // Catch: Throwable -> L37
        if (r111 == null) goto L34;
        Long r213 = r100.getRepeatEndTime();     // Catch: Throwable -> L37
        if (r213 != null) goto L16;
    L20:
        long r107 = r100.getStartTime();     // Catch: Throwable -> L37
        Boolean r108 = r100.getAllDay();     // Catch: Throwable -> L37
        if (r108 == null) goto L23;
        boolean r112 = r108.booleanValue();     // Catch: Throwable -> L37
    L24:
        String r113 = r100.getDescription();     // Catch: Throwable -> L37
        String r114 = r100.getLocation();     // Catch: Throwable -> L37
        Boolean r109 = r100.getAlarm();     // Catch: Throwable -> L37
        if (r109 == null) goto L27;
        boolean r115 = r109.booleanValue();     // Catch: Throwable -> L37
    L28:
        Long r116 = r100.getAlarmOffset();     // Catch: Throwable -> L37
        if (r116 == null) goto L31;
        long r117 = r116.longValue();     // Catch: Throwable -> L37
    L32:
        Object r118 = Result.m9449constructorimpl(new f(r104, r107, r112, r113, r114, r110, r115, r117, r100.getPath(), r111, r213));     // Catch: Throwable -> L37
    L39:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 != null) goto L42;
        d.a(r210, (f) r118, true, "addPhoneRepeatCalendar", r212, new e());
        return;
    L42:
        String r120 = r119.getMessage();
        if (r120 != null) goto L45;
        r120 = "The calendar event parameter is invalid.";
    L45:
        h.a.a(r212, r120, null, null, 14);
        return;
    L31:
        r117 = 0;
        goto L32
    L27:
        r115 = true;
        goto L28
    L23:
        r112 = false;
        goto L24
    L16:
        if (r213.longValue() >= r100.getStartTime()) goto L20;
        throw new IllegalArgumentException("The repeatEndTime parameter should not be earlier than startTime.");     // Catch: Throwable -> L37
    L34:
        throw new IllegalArgumentException("The repeatInterval parameter should be one of day, week, month, year.");     // Catch: Throwable -> L37
    L36:
        throw new IllegalArgumentException("The title parameter should not be empty.");     // Catch: Throwable -> L37
    L6:
        r105 = false;
    L37:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    }
}
