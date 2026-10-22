package com.bytedance.android.livesdk.gift.platform.business.effect.utils;

import com.bytedance.android.livesdk.gift.platform.business.effect.player.i;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.ugc.effectmanager.MobConstants;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
public final class VideoGiftLinkMonitor {

    public static final enum Event extends Enum<Event> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Event[] f129549a = null;
        public static final Event consume_effect_message = null;
        public static final Event consume_message = null;
        public static final Event load_resource_success = null;
        public static final Event playcontroller_end = null;
        public static final Event playcontroller_receive = null;
        public static final Event playcontroller_start = null;
        public static final Event receive_message = null;

        static {
            Event r100 = new Event("receive_message", 0);
            receive_message = r100;
            Event r101 = new Event("consume_message", 1);
            consume_message = r101;
            Event r102 = new Event("load_resource_success", 2);
            load_resource_success = r102;
            Event r103 = new Event("consume_effect_message", 3);
            consume_effect_message = r103;
            Event r104 = new Event("playcontroller_receive", 4);
            playcontroller_receive = r104;
            Event r105 = new Event("playcontroller_start", 5);
            playcontroller_start = r105;
            Event r110 = new Event("playcontroller_end", 6);
            playcontroller_end = r110;
            f129549a = new Event[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static Event[] values() {
            return (Event[]) f129549a.clone();
        }

        public static Event valueOf(String r100) {
            return (Event) a.a(Event.class, r100);
        }

        public Event(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static void a(Event r100, long r101, long r102, long r103) {
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L11
        r104.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L11
        r104.put("event", r100.name());     // Catch: Exception -> L11
        i.a().getClass();     // Catch: Exception -> L11
        int r105 = 1;
        if (i.f129462b.get(i.f129463c) == null) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L9;
        r105 = 0;
    L9:
        r104.put("player_state", r105);     // Catch: Exception -> L11
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r101);     // Catch: Exception -> L11
        r104.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r102);     // Catch: Exception -> L11
        r104.put(MobConstants.EFFECT_ID, r103);     // Catch: Exception -> L11
        d0.e(r104);     // Catch: Exception -> L11
        return;
    L5:
        r106 = false;
    }
}
