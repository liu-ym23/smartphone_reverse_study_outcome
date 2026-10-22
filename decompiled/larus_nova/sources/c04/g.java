package c04;

import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f21925a = 0;

    static {
    }

    public static boolean a(r14.c r100) {
        JSONObject r101 = AoSettings.a("ao_feed_long_press_config");
        if (r101 == null) goto L5;
        boolean r102 = r101.optBoolean("enable_side_long_press", true);
    L7:
        if (r102 == true) goto L9;
        return false;
    L9:
        if (r100 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L36;
        if (r100 != null) goto L17;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == true) goto L36;
        if (r100 != null) goto L23;
    L25:
        boolean r105 = false;
    L26:
        if (r105 == true) goto L36;
        if (r100 != null) goto L30;
    L32:
        boolean r106 = false;
    L33:
        if (r106 == false) goto L35;
        return false;
    L35:
        return true;
    L30:
        if (r100.Y() != true) goto L32;
        r106 = true;
        goto L33
    L23:
        if (r100.i() != 2) goto L25;
        r105 = true;
        goto L26
    L17:
        if (r100.i() != 68) goto L19;
        r104 = true;
    L36:
        return false;
    L11:
        if (r100.i() != 108) goto L13;
        r103 = true;
        goto L14
    L5:
        r102 = true;
        goto L7
    }
}
