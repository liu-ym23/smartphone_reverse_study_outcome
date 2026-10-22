package a64;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Function0<String>> f1952a = null;

    static {
        f1952a = new HashMap();
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("version_code", String.valueOf(AoEnv.e()));
        r100.put("aid", AoEnv.d());
        r100.put("device_platform", "android");
        r100.put("app-id", AoEnv.d());
        r100.put("sdk-version", AoEnv.g());
    }
}
