package com.bytedance.android.livesdk.interactivity.api.base;

import am2.x;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f132890m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f132891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f132892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f132893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f132894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f132895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f132896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f132897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f132898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f132899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f132900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f132901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f132902l;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static b a() {
            Intrinsics.checkNotNullParameter(q.f133747a, "$this$getInteractivityStat");
            h r100 = i.b(null, 3);
            if (r100 == null) goto L8;
            j<b> r101 = r100.getInteractivityStat();
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getValue();
        L8:
            return null;
        }

        @JvmStatic
        public static void b() {
            Intrinsics.checkNotNullParameter(q.f133747a, "$this$onFollowAnchor");
            h r100 = i.b(null, 3);
            if (r100 == null) goto L10;
            j<b> r101 = r100.getInteractivityStat();
            if (r101 == null) goto L11;
            b r102 = r101.getValue();
            if (r102 == null) goto L12;
            r102.f132901k++;
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void d() {
            Intrinsics.checkNotNullParameter(q.f133747a, "$this$onIntercomEnd");
            h r100 = i.b(null, 3);
            if (r100 == null) goto L10;
            j<b> r101 = r100.getInteractivityStat();
            if (r101 == null) goto L11;
            b r102 = r101.getValue();
            if (r102 == null) goto L12;
            r102.a();
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void e() {
            Intrinsics.checkNotNullParameter(q.f133747a, "$this$onIntercomStart");
            h r100 = i.b(null, 3);
            if (r100 == null) goto L10;
            j<b> r101 = r100.getInteractivityStat();
            if (r101 == null) goto L11;
            b r102 = r101.getValue();
            if (r102 == null) goto L12;
            r102.f132897g = true;
            r102.f132898h = System.currentTimeMillis();
            r102.f132899i = 0;
            r102.f132900j = 0;
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void f() {
            Intrinsics.checkNotNullParameter(q.f133747a, "$this$onUnfollowAnchor");
            h r100 = i.b(null, 3);
            if (r100 == null) goto L10;
            j<b> r101 = r100.getInteractivityStat();
            if (r101 == null) goto L11;
            b r102 = r101.getValue();
            if (r102 == null) goto L12;
            r102.f132902l++;
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void c(boolean r100) {
            Intrinsics.checkNotNullParameter(q.f133747a, "$this$onIntercomCommentShow");
            h r101 = i.b(null, 3);
            if (r101 == null) goto L14;
            j<b> r102 = r101.getInteractivityStat();
            if (r102 == null) goto L15;
            b r103 = r102.getValue();
            if (r103 != null) goto L9;
            return;
        L9:
            if (r103.f132897g == false) goto L17;
            if (r100 == false) goto L12;
            r103.f132900j++;
            return;
        L12:
            r103.f132899i++;
            return;
        L17:
            return;
        L15:
            return;
        }

        public static void g(DataCenter r100) {
            h r101 = i.b(r100, 1);
            if (r101 == null) goto L8;
            m<Integer> r102 = r101.getSendCommentCount();
            if (r102 == null) goto L9;
            r102.setValue(Integer.valueOf(r102.getValue().intValue() + 1));
            return;
        L9:
            return;
        }
    }

    public b() {
    }

    static {
        f132890m = new a();
    }

    public final void a() {
        if (this.f132897g == true) goto L5;
        return;
    L5:
        this.f132897g = false;
        HashMap r100 = new HashMap();
        r100.put("duration", String.valueOf(System.currentTimeMillis() - this.f132898h));
        r100.put("comment_show_cnt", String.valueOf(this.f132899i));
        r100.put("other_comment_show_cnt", String.valueOf(this.f132900j));
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r101 == null) goto L12;
        o r102 = IRoomContextService.a.a(r101, null, 0, 3);
        if (r102 == null) goto L12;
        if (r102.isMediaRoom() != true) goto L12;
        r100.put("is_media_room", "1");
    L12:
        j0.l().sendLog("livesdk_comment_interflow_watch", r100, new Object[]{IRoom.class, x.class});
    }

    @JvmStatic
    public static final void b(DataCenter r100) {
        q r101 = q.f133747a;
        f132890m.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$onSendSubscribeEmojiComment");
        h r102 = i.b(r100, 1);
        if (r102 == null) goto L9;
        j<b> r103 = r102.getInteractivityStat();
        if (r103 == null) goto L9;
        b r104 = r103.getValue();
        if (r104 == null) goto L9;
        r104.f132895e++;
    L9:
        a.g(r100);
    }
}
