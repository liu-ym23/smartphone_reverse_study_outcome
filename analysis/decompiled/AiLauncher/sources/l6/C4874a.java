package l6;

import Y8.j;
import android.hardware.display.BackScreenAnimationInfo;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012¨\u0006\u001a"}, d2 = {"Ll6/a;", "", "<init>", "()V", "Landroid/hardware/display/BackScreenAnimationInfo;", "info", "", "success", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/display/BackScreenAnimationInfo;Z)V", "", "event", "", "params", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/util/Map;)V", "PAGE_NAME", "Ljava/lang/String;", "EVENT_EXPOSE", "PARAM_ANIMATION_ID", "PARAM_ANIMATION_NAME", "PARAM_POSITION", "PARAM_SCENE", "PARAM_IS_SUCCESS", "POSITION_BACK_SCREEN", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: l6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4874a {
    private static final String EVENT_EXPOSE = "animation_expose";
    public static final C4874a INSTANCE = new C4874a();
    private static final String PAGE_NAME = "";
    private static final String PARAM_ANIMATION_ID = "animation_id";
    private static final String PARAM_ANIMATION_NAME = "animation_name";
    private static final String PARAM_IS_SUCCESS = "is_success";
    private static final String PARAM_POSITION = "position";
    private static final String PARAM_SCENE = "scene";
    public static final String POSITION_BACK_SCREEN = "back_screen";

    public final void a(BackScreenAnimationInfo info, boolean success) {
        p.i(info, "info");
        b(EVENT_EXPOSE, kotlin.collections.a.m(j.a(PARAM_ANIMATION_ID, info.getId()), j.a(PARAM_ANIMATION_NAME, info.getName()), j.a("position", POSITION_BACK_SCREEN), j.a("scene", info.getState()), j.a(PARAM_IS_SUCCESS, Integer.valueOf(success ? 1 : 0))));
    }

    public final void b(String event, Map<String, ? extends Object> params) {
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
