package ay0;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f16672a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f16673b = null;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(f.class, "revenueFoldFixConfig", "getRevenueFoldFixConfig()Lcom/bytedance/android/live/revenue/common/settings/RevenueFoldFixConfig;", 1))};
        f16672a = r100;
        Class<?> r101 = ((JsonAdapter) e.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r102 = vh7.b.f554981a;
        Constructor r103 = r102.get(r101);
        if (r103 != null) goto L12;
        r103 = r101.getConstructor(new Class[0]);
        if (r103 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r104 = r102.putIfAbsent(r101, (Constructor<? extends SerializableObjectJsonAdapterBase>) r103);
        if (r104 == null) goto L12;
        r103 = r104;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r105 = ((SerializableObjectJsonAdapterBase) r103.newInstance(new Object[0])).createInstance();
        if (r105 == null) goto L17;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_fold_fix_config", (e) r105, e.class, false);
        f16673b = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[0]);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.common.settings.RevenueFoldFixConfig");
    }
}
