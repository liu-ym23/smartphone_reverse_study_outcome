package com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import ec2.g1;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f140331a = false;

    static {
        if (v.a() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        f140331a = r100;
        return;
    L5:
        if (g1.f472020a.getValue().booleanValue() == false) goto L7;
        r100 = true;
        goto L8
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "addReason");
        if (f140331a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_MESSAGE_HEAT", r100);
    }

    public static void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (f140331a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_MESSAGE_DROP", "消息超时丢弃，超时时间为" + ((System.currentTimeMillis() - r100.p().longValue()) / ((long) 1000)) + 's');
    }

    @JvmStatic
    public static final void c(PSMessageHeatState r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "heatState");
        if (f140331a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_MESSAGE_HEAT", "现在的热度状态为" + r101 + ", heat state is " + r100.name());
    }

    public static void f(List r100, PSMessageAction r101) {
        Iterator r102 = r100.iterator();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r102.hasNext() == false) goto L17;
        f r106 = (f) r102.next();
        if (r106.A != r101) goto L4;
        int r107 = b.f140330a[r106.f133165z.ordinal()];
        if (r107 != 1) goto L10;
        r103 = r103 + 1;
        goto L4
    L10:
        if (r107 != 2) goto L12;
        r104 = r104 + 1;
        goto L4
    L12:
        if (r107 != 3) goto L4;
        r105 = r105 + 1;
        goto L4
    L17:
        ALogger.e("PS_BUFFER_POLL", r101.name() + "消息优先级的数量：高优：" + r103 + "，中优：" + r104 + "，低优：" + r105);
    }

    public static void d(f r100, PSMessagePriority r101, PSMessageAction r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r102, "queueAction");
        if (f140331a == true) goto L5;
        return;
    L5:
        StringBuilder r103 = new StringBuilder("入队一条消息，行为类型:");
        r103.append(r100.A.name());
        r103.append("，优先级:");
        r103.append(r100.f133165z.name());
        r103.append("。队列行为类型为");
        r103.append(r102.name());
        r103.append(", 队列优先级为");
        if (r101 == null) goto L8;
        String r104 = r101.name();
    L9:
        r103.append(r104);
        ALogger.e("PS_BUFFER_PUSH", r103.toString());
        return;
    L8:
        r104 = null;
        goto L9
    }

    public static void a(int r100, int r101, int r102, int r103, int r104) {
        if (f140331a == true) goto L5;
        return;
    L5:
        ALogger.e("PS_CHAT_COUNT", "最近" + r100 + "秒评论累计数量为" + r102 + "，最近" + r101 + "秒内收到的评论数量为" + r103 + "，超过15s的评论数量为" + r104);
    }
}
