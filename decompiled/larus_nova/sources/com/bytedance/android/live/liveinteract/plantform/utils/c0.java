package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AtomicInteger f77465c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<q> f77466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f77467b;

    public static final class a {
        public static c0 a(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            us1.a r101 = vm2.h.f0();
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r102 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
            c0 r103 = null;
            if (r102 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r104 = r102.getValue();
            if (r104 == null) goto L9;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r105 = r104.t();
            if (r105 == null) goto L9;
            Integer r106 = Integer.valueOf(r105.f114798a);
        L17:
            if (r106 != null) goto L19;
        L37:
            return r103;
        L19:
            if (r106.intValue() == 0) goto L37;
            if (r101.getType() != 2) goto L24;
        L25:
            List<String> r107 = r101.a();
            if (r107 == null) goto L37;
            if (r107.contains(String.valueOf(r106.intValue())) != true) goto L37;
            Intrinsics.checkNotNullParameter(r100, "manager");
            r103 = new c0();
            q r108 = r100.a(2);
            if (r108 != null) goto L32;
            ALogger.e("LiveStreamInfoSenderHolder", "IM_ENABLE is null");
        L33:
            q r109 = r100.a(1);
            if (r109 != null) goto L36;
            ALogger.e("LiveStreamInfoSenderHolder", "SEI_ENABLE is null");
            goto L37
        L36:
            r103.a(1, r109);
            goto L37
        L32:
            r103.a(2, r108);
            goto L33
        L24:
            if (r101.getType() != 3) goto L37;
        L9:
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r110 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
            if (r110 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.viewmodel.f r111 = r110.getValue();
            if (r111 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.viewmodel.i r112 = r111.t();
            if (r112 == null) goto L16;
            r106 = Integer.valueOf(r112.f114792a);
        L16:
            r106 = null;
            goto L17
        }

        public static c0 b(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            us1.a r101 = vm2.h.f0();
            if (r101.getType() != 2) goto L5;
        L8:
            Intrinsics.checkNotNullParameter(r100, "manager");
            c0 r102 = new c0();
            q r103 = r100.a(2);
            if (r103 != null) goto L11;
            ALogger.e("LiveStreamInfoSenderHolder", "IM_ENABLE is null");
        L12:
            q r104 = r100.a(1);
            if (r104 != null) goto L15;
            ALogger.e("LiveStreamInfoSenderHolder", "SEI_ENABLE is null");
        L17:
            return r102;
        L15:
            r102.a(1, r104);
            goto L17
        L11:
            r102.a(2, r103);
            goto L12
        L5:
            if (r101.getType() == 3) goto L8;
            return null;
        }
    }

    static {
        f77465c = new AtomicInteger(0);
    }

    public c0() {
        this.f77466a = new ArrayList();
    }

    public final void a(int r100, q r101) {
        Intrinsics.checkNotNullParameter(r101, "sender");
        this.f77466a.add(r101);
        if (r100 != 2) goto L6;
        this.f77467b = true;
        return;
    }
}
