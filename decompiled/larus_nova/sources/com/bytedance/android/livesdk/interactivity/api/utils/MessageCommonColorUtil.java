package com.bytedance.android.livesdk.interactivity.api.utils;

import com.bytedance.android.live.liveinteract.f;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class MessageCommonColorUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f133766a = 0;

    public MessageCommonColorUtil() {
    }

    public static int a() {
        return f.a(R.color.ttlive_text_message_height_color, MessageCommonColorUtil$getHighLevelColor$1.INSTANCE);
    }

    public static int b() {
        return f.a(R.color.ttlive_text_message_low_color, MessageCommonColorUtil$getLowLevelColor$1.INSTANCE);
    }

    public static int c() {
        return f.a(R.color.ttlive_match_room_message_text_color, MessageCommonColorUtil$getMatchRoomTextColor$1.INSTANCE);
    }

    public static int d() {
        return f.a(R.color.ttlive_text_message_medium_color, MessageCommonColorUtil$getNormalColor$1.INSTANCE);
    }

    public static int e() {
        return f.a(R.color.ttlive_text_message_special_color, MessageCommonColorUtil$getSpecialColor$1.INSTANCE);
    }

    static {
    }
}
