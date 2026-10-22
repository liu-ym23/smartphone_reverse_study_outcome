package com.stepos.ailauncher.chat.trace;

import L4.AnimationInfo;
import Y8.j;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/trace/c;", "", "<init>", "()V", "LL4/n;", "info", "", "success", "", "position", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LL4/n;ZLjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(LL4/n;Ljava/lang/String;)V", "event", "", "params", "c", "(Ljava/lang/String;Ljava/util/Map;)V", "PAGE_NAME", "Ljava/lang/String;", "EVENT_EXPOSE", "EVENT_CLICK", "PARAM_ANIMATION_ID", "PARAM_ANIMATION_NAME", "PARAM_POSITION", "PARAM_SCENE", "PARAM_IS_SUCCESS", "POSITION_HOME_SCREEN", "POSITION_MARKET", "POSITION_REPAIR", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    private static final String EVENT_CLICK = "animation_click";
    private static final String EVENT_EXPOSE = "animation_expose";
    public static final c INSTANCE = new c();
    private static final String PAGE_NAME = "";
    private static final String PARAM_ANIMATION_ID = "animation_id";
    private static final String PARAM_ANIMATION_NAME = "animation_name";
    private static final String PARAM_IS_SUCCESS = "is_success";
    private static final String PARAM_POSITION = "position";
    private static final String PARAM_SCENE = "scene";
    public static final String POSITION_HOME_SCREEN = "home_screen";
    public static final String POSITION_MARKET = "market";
    public static final String POSITION_REPAIR = "repair_room";

    public final void a(AnimationInfo info, String position) {
        p.i(info, "info");
        p.i(position, "position");
        c(EVENT_CLICK, kotlin.collections.a.m(j.a(PARAM_ANIMATION_ID, info.getId()), j.a(PARAM_ANIMATION_NAME, info.getName()), j.a("position", position), j.a("scene", info.getState())));
    }

    public final void b(AnimationInfo info, boolean success, String position) {
        p.i(info, "info");
        p.i(position, "position");
        c(EVENT_EXPOSE, kotlin.collections.a.m(j.a(PARAM_ANIMATION_ID, info.getId()), j.a(PARAM_ANIMATION_NAME, info.getName()), j.a("position", position), j.a("scene", info.getState()), j.a(PARAM_IS_SUCCESS, Integer.valueOf(success ? 1 : 0))));
    }

    public final void c(String event, Map<String, ? extends Object> params) {
        HashMap map = new HashMap();
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                map.put(key, value.toString());
            }
        }
        C4148a.d("Track", event + " page= " + map, false, 4, null);
        N.a(event, "", map);
    }
}
