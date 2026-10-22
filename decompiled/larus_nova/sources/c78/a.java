package c78;

import a68.b;
import com.bytedance.keva.Keva;
import m58.h;
import m58.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f22658b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f22659c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f22660d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f22661e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f22662f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Keva f22663g = null;

    static {
        Keva r100 = Keva.getRepo("sami_asr_env", 0);
        f22663g = r100;
        q r101 = h.f512133d;
        boolean r102 = true;
        if (r101 == null) goto L9;
        b r103 = r101.audioDebugAutoDumpConfig();
        if (r103 == null) goto L9;
        if (r103.f1962a != true) goto L9;
        boolean r104 = true;
    L10:
        f22657a = r104;
        if (r100.getBoolean("key_dora_dump_enable", false) == true) goto L23;
        q r105 = h.f512133d;
        if (r105 == null) goto L19;
        b r106 = r105.audioDebugAutoDumpConfig();
        if (r106 == null) goto L19;
        if (r106.f1963b != true) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L23;
        r102 = false;
    L19:
        r107 = false;
    L23:
        f22658b = r102;
        f22659c = r100.getBoolean("key_is_rtc_dump_enable", false);
        f22660d = r100.getBoolean("key_is_omni_dump_enable", false);
        f22661e = r100.getBoolean("key_is_mmt_audio_dump_enable", false);
        f22662f = r100.getBoolean("key_is_mmt_video_dump_enable", false);
        return;
    L9:
        r104 = false;
        goto L10
    }

    public static String a() {
        return f22663g.getString("asr_ppe_env", "");
    }
}
