package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f66189a = 0;

    static {
    }

    public static HashMap a(IRoom r100) {
        HashMap r101 = new HashMap();
        if (r100 != null) goto L6;
        return r101;
    L6:
        if (r100.getWithLinkMic() == true) goto L8;
    L18:
        return r101;
    L8:
        if (r100.isLiveTypeAudio() == true) goto L17;
        Map<String, Long> r102 = r100.getLinkMap();
        if (r102 == null) goto L14;
        Long r103 = r102.get("8");
        if (r103 == null) goto L14;
        long r104 = r103.longValue();
    L16:
        if (r104 <= 0) goto L18;
    L14:
        r104 = 0;
    L17:
        r101.put("interact_function", "chat_room");
        goto L18
    }

    @JvmStatic
    public static final String b(IRoom r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 == null) goto L12;
        if (r100.isMediaRoom() != true) goto L12;
        return ILiveRoomPlayFragmentConstant.EXTRA_IS_MEDIA;
    L12:
        if (d1.a(r100) == false) goto L14;
        return "is_game";
    L14:
        return "other";
    L5:
        if (r100.isMergeVSRoom() != true) goto L7;
        return "is_vs";
    }
}
