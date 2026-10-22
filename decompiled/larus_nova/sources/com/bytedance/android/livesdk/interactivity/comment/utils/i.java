package com.bytedance.android.livesdk.interactivity.comment.utils;

import am2.x;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f136260a = 0;

    static {
    }

    public static void a(com.bytedance.android.livesdk.interactivity.comment.model.a r100, boolean r101, boolean r102) {
        HashMap r103 = new HashMap();
        r103.put("module_name", "comment_expansion");
        if (r102 == false) goto L16;
        String r104 = null;
        if (r100 == null) goto L7;
        Long r105 = Long.valueOf(r100.a());
    L8:
        r103.put("tag_id", String.valueOf(r105));
        if (r100 == null) goto L11;
        r104 = r100.b();
    L11:
        r103.put("tag_text", String.valueOf(r104));
        if (r101 == false) goto L14;
        String r106 = "1";
    L15:
        r103.put("status", r106);
        r103.put("element_name", "interest_tag");
    L17:
        j0.l().sendLog("livesdk_interest_card_click", r103, new Object[]{IRoom.class, new x()});
        return;
    L14:
        r106 = "0";
        goto L15
    L7:
        r105 = null;
        goto L8
    L16:
        r103.put("element_name", "change");
        goto L17
    }

    public static void b(com.bytedance.android.livesdk.interactivity.comment.model.c r100, boolean r101, boolean r102) {
        HashMap r103 = new HashMap();
        r103.put("module_name", "comment_expansion");
        if (r102 == false) goto L17;
        if (r100 == null) goto L6;
        Long r104 = Long.valueOf(r100.b());
    L7:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, String.valueOf(r104));
        if (r100 == null) goto L11;
        String r105 = r100.a();
        if (r105 == null) goto L11;
    L12:
        r103.put("question_text", r105);
        if (r101 == false) goto L15;
        String r106 = "1";
    L16:
        r103.put("status", r106);
        r103.put("element_name", com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
    L18:
        j0.l().sendLog("livesdk_truth_question_click", r103, new Object[]{IRoom.class, new x()});
        return;
    L15:
        r106 = "0";
    L11:
        r105 = "";
        goto L12
    L6:
        r104 = null;
        goto L7
    L17:
        r103.put("element_name", "change");
        goto L18
    }
}
