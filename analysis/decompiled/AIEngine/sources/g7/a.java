package g7;

import com.stepos.cpuset.c;
import com.tencent.mmkv.MMKV;
import kotlin.b;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final d f9073a = b.b(new com.stepos.cpuset.b(6));

    /* renamed from: b, reason: collision with root package name */
    public static final d f9074b = b.b(new c(5));

    public static MMKV a() {
        return (MMKV) f9073a.getValue();
    }

    public static int b(String modelId) {
        g.f(modelId, "modelId");
        return ((MMKV) f9074b.getValue()).e(0, "ver_".concat(modelId));
    }

    public static void c(String modelId, String path) {
        g.f(modelId, "modelId");
        g.f(path, "path");
        a().l("prev_path_".concat(modelId), path);
    }
}
