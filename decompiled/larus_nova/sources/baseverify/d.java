package baseverify;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class d {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_baseverify_d_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public static boolean a(Context r100, Map<String, Object> r101) {
        Context r102 = hs7.a.h().j();     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        if ((r102 instanceof Activity) == false) goto L10;
        r100 = r102;
    L10:
        Method r103 = INVOKESTATIC_baseverify_d_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.dtf.face.verify.DTFaceFacade").getDeclaredMethod("startFace", new Class[]{Context.class, Map.class});     // Catch: Throwable -> L12
        r103.setAccessible(true);     // Catch: Throwable -> L12
        r103.invoke(null, new Object[]{r100, r101});     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        RecordService.getInstance().recordEvent(4, "FacError", new String[]{"status", RecordService.getStackTraceString(th)});
        return false;
    }

    public static boolean b(Context r100, Map<String, Object> r101) {
        RecordService.getInstance().recordEvent(2, "startNFCAuthentication", new String[0]);
        Context r102 = hs7.a.h().j();     // Catch: Exception -> L12
        if (r102 == null) goto L10;
        if ((r102 instanceof Activity) == false) goto L10;
        r100 = r102;
    L10:
        Method r103 = INVOKESTATIC_baseverify_d_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.dtf.face.nfc.verify.DTFNfcFacade").getDeclaredMethod("startNfc", new Class[]{Context.class, Map.class});     // Catch: Exception -> L12
        r103.setAccessible(true);     // Catch: Exception -> L12
        r103.invoke(null, new Object[]{r100, r101});     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        RecordService.getInstance().recordEvent(4, "nfcError", new String[]{"status", RecordService.getStackTraceString(e)});
        return false;
    }

    public static Map<String, Object> a(String r100, String r101, j r102) {
        HashMap r103 = new HashMap();
        String r104 = SgomInfoManager.updateSgomInfo(1321598775, null);
        if (TextUtils.isEmpty(r104) == false) goto L8;
    L5:
        r103.put("zimId", r100);
        r103.put("metaInfo", r101);
        r103.put("zimInitCallback", r102);
        r103.put("callback", new h(r100, System.currentTimeMillis(), r103));
        JSONObject r105 = new JSONObject();
        r105.put2("zimId", r100);
        r105.put2("metaInfo", r101);
        r103.put("data", r105.toJSONString());
        return r103;
    L8:
        JSONObject r106 = JSON.parseObject(r101);     // Catch: Exception -> L7
        r106.put2("zconfigId", r104);     // Catch: Exception -> L7
        r101 = r106.toJSONString();     // Catch: Exception -> L7
        goto L5
    }

    public static Map<String, Object> a(List<String> r100, String r101, APICallback<String> r102) {
        HashMap r103 = new HashMap();
        r103.put(LogUtil.DIR_TAIL, r100);
        r103.put("data", JSON.toJSONString(r100));
        r103.put("logFileName", r101);
        r103.put("logCallback", r102);
        r103.put("callback", new i(r103, r101));
        return r103;
    }
}
