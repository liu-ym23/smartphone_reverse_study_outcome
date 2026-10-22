package com.bytedance.android.live.room.report;

import android.text.TextUtils;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.nl;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.ui1;
import com.bytedance.android.livesdk.config.yj;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.r2;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
    static {
    }

    public static ReportObject a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Map<String, String> r101 = ReportTracer.f100240a;
        ReportTracer.b(ReportTracer.EventName.get_report_object);
        boolean r102 = false;
        if (r2.a(r100.f100255e) == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        ReportObject r104 = ReportObject.DHXT_Link_OR_PK;
    L43:
        ReportTracer.d(ReportTracer.EventName.report_object, r104.name());
        return r104;
    L11:
        if (r100.f100258h == true) goto L13;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L20;
        r104 = ReportObject.DH_Anchor;
        goto L43
    L20:
        ReportObject r106 = r100.f100259i;
        if (r106 == null) goto L24;
        r104 = r106;
        goto L43
    L24:
        if (TextUtils.isEmpty(nl.f120842a.getValue()) == false) goto L26;
    L32:
        boolean r107 = false;
    L33:
        if (r107 == false) goto L36;
        r104 = ReportObject.Comment;
        goto L43
    L36:
        if (TextUtils.equals(UserProfileEvent.SOURCE_ROOM_CHANNEL_LINK, r100.f100254d) == true) goto L38;
    L40:
        if (r102 == false) goto L42;
        r104 = ReportObject.ChannelLink;
        goto L43
    L42:
        r104 = ReportObject.User;
        goto L43
    L38:
        if (TextUtils.isEmpty(yj.f121693a.getValue()) == true) goto L40;
        r102 = true;
        goto L40
    L26:
        if (r100.f100257g == null) goto L32;
        if (TextUtils.equals("personal_profile", r100.f100254d) == false) goto L30;
    L31:
        r107 = true;
        goto L33
    L30:
        if (TextUtils.equals(UserProfileEvent.SOURCE_BARRAGE, r100.f100254d) == false) goto L32;
    L13:
        if (TextUtils.isEmpty(oc.f120892a.getValue()) == true) goto L17;
        if (ui1.f121378a.getValue().booleanValue() == false) goto L17;
        r105 = true;
        goto L18
    L5:
        if (TextUtils.isEmpty(oc.f120892a.getValue()) == true) goto L7;
        r103 = true;
        goto L8
    }
}
