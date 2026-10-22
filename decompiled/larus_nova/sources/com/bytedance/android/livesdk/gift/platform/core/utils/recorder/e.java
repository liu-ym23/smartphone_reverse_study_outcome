package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f132070d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f132071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f132072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f132073c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e$a$a, reason: collision with other inner class name */
        public static final class C2088a extends e {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final C2088a f132074e = null;

            static {
                f132074e = new C2088a();
            }

            public C2088a() {
            }
        }

        public a() {
        }

        @JvmStatic
        public static void a(Object r100, String r101, Object r102, d r110) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
            Intrinsics.checkNotNullParameter(r101, "content");
            if (v.a() == false) goto L5;
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a("GRecorder", "report " + r100 + ':' + r101);
        L5:
            String r103 = r100.toString();
            JSONObject r104 = new JSONObject();     // Catch: Exception -> L32
            r104.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L32
            com.bytedance.android.livesdk.gift.platform.business.effect.player.i.a().getClass();     // Catch: Exception -> L32
            int r105 = 1;
            if (com.bytedance.android.livesdk.gift.platform.business.effect.player.i.f129462b.get(com.bytedance.android.livesdk.gift.platform.business.effect.player.i.f129463c) == null) goto L9;
            boolean r106 = true;
        L10:
            if (r106 == true) goto L13;
            r105 = 0;
        L13:
            r104.put("player_state", r105);     // Catch: Exception -> L32
            r104.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: Exception -> L32
            JSONObject r107 = new JSONObject();     // Catch: Exception -> L32
            r107.put("event", "consume_message_err");     // Catch: Exception -> L32
            r107.put(MusicAppletPage.KEY_MESSAGE_ID, r103);     // Catch: Exception -> L32
            String r108 = "";
            if (r102 == null) goto L18;
            String r109 = r102.toString();     // Catch: Exception -> L32
            if (r109 == null) goto L18;
        L19:
            r107.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r109);     // Catch: Exception -> L32
            r107.put("err_info", r101);     // Catch: Exception -> L32
            if (r110 == null) goto L25;
            String r111 = r110.f132069b;     // Catch: Exception -> L32
            if (r111 == null) goto L25;
            r108 = r111;
        L25:
            r107.put("err_title", r108);     // Catch: Exception -> L32
            if (r110 == null) goto L29;
            Object r112 = r110.f132068a;     // Catch: Exception -> L32
            if (r112 == null) goto L29;
        L30:
            r107.put("err_code", r112);     // Catch: Exception -> L32
            JSONObject r113 = new JSONObject();     // Catch: Exception -> L32
            r113.put("err_info", r101);     // Catch: Exception -> L32
            d0.n(r107, r113, r104);     // Catch: Exception -> L32
            return;
        L29:
            r112 = "-1";
        L18:
            r109 = "";
            goto L19
        L9:
            r106 = false;
        L32:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
        f132070d = new a();
    }

    public e() {
        this.f132072b = new i();
        this.f132073c = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.a();
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.A.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.f130639a[25])).booleanValue() == false) goto L5;
    L8:
        i r100 = new i();
        this.f132072b = r100;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.a r101 = new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.a();
        this.f132073c = r101;
        this.f132071a = new b(new g[]{r100, r101});
        return;
    L5:
        if (v.a() == true) goto L8;
        c r102 = new c();
        this.f132072b = r102;
        c r103 = new c();
        this.f132073c = r103;
        this.f132071a = new b(new g[]{r102, r103});
    }
}
