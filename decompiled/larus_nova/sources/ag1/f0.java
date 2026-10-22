package ag1;

import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public final class f0 implements com.bytedance.android.live.room.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Long> f3287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f3288b = null;

    public f0() {
    }

    @Override // com.bytedance.android.live.room.s
    public final boolean b() {
        Class r100 = d("com.huawei.system.BuildEx");     // Catch: Exception -> L21
        if (StringsKt.equals("Harmony", r100.getMethod("getOsBrand", new Class[0]).invoke(r100, new Object[0]).toString(), true) == true) goto L6;
        return false;
    L6:
        Class r101 = d("android.os.SystemProperties");     // Catch: Exception -> L21
        Object r102 = r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{"hw_sc.build.platform.version"});     // Catch: Exception -> L21
        if (r102 == null) goto L24;
        String r103 = r102.toString();     // Catch: Exception -> L21
        if (r103 == null) goto L25;
        int r104 = StringsKt.indexOf$default(r103, '.', 0, false, 6, null);     // Catch: Exception -> L21
        if (r104 >= 0) goto L14;
        return false;
    L14:
        if (r104 >= r103.length()) goto L27;
        if (CastIntegerProtector.parseInt(r103.substring(0, r104)) < 4) goto L28;
        return true;
    L28:
        return false;
    L27:
        return false;
    L25:
        return false;
    L24:
        return false;
    L29:
        return false;
    }

    static {
        f3288b = new f0();
        f3287a = new HashSet();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Override // com.bytedance.android.live.room.s
    public final void c(long r100, EndReason r101) {
        if ((r101 instanceof EndReason.PAD_SPLIT_REPEAT) == false) goto L7;
        Set<Long> r102 = f3287a;
        HashSet r103 = (HashSet) r102;
        if (r103.contains(Long.valueOf(r100)) == false) goto L7;
        return;
    L7:
        Set<Long> r104 = f3287a;
        HashSet r105 = (HashSet) r104;
        r105.remove(Long.valueOf(r100));
    }

    @Override // com.bytedance.android.live.room.s
    public final void a(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r102, "enterMethod");
        Intrinsics.checkNotNullParameter(r103, "type");
        Set<Long> r104 = f3287a;
        HashSet r105 = (HashSet) r104;
        r105.add(Long.valueOf(r100));
    }
}
