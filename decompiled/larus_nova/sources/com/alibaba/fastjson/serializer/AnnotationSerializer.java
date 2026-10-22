package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class AnnotationSerializer implements ObjectSerializer {
    public static AnnotationSerializer instance;
    private static volatile Class sun_AnnotationType;
    private static volatile boolean sun_AnnotationType_error;
    private static volatile Method sun_AnnotationType_getInstance;
    private static volatile Method sun_AnnotationType_members;

    public AnnotationSerializer() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        instance = new AnnotationSerializer();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_alibaba_fastjson_serializer_AnnotationSerializer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer r100, Object r101, Object r102, Type r103, int r110) throws IOException {
        Class<?>[] r104 = r101.getClass().getInterfaces();
        if (r104.length == 1) goto L5;
        return;
    L5:
        if (r104[0].isAnnotation() == false) goto L75;
        Class<?> r105 = r104[0];
        if (sun_AnnotationType != null) goto L16;
        if (sun_AnnotationType_error == true) goto L16;
        sun_AnnotationType = INVOKESTATIC_com_alibaba_fastjson_serializer_AnnotationSerializer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("sun.reflect.annotation.AnnotationType");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        sun_AnnotationType_error = true;
        throw new JSONException("not support Type Annotation.", th);
    L16:
        if (sun_AnnotationType == null) goto L58;
        if (sun_AnnotationType_getInstance != null) goto L27;
        if (sun_AnnotationType_error == true) goto L27;
        sun_AnnotationType_getInstance = sun_AnnotationType.getMethod("getInstance", new Class[]{Class.class});     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        sun_AnnotationType_error = true;
        throw new JSONException("not support Type Annotation.", th);
    L27:
        if (sun_AnnotationType_members != null) goto L36;
        if (sun_AnnotationType_error == true) goto L36;
        sun_AnnotationType_members = sun_AnnotationType.getMethod("members", new Class[0]);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        sun_AnnotationType_error = true;
        throw new JSONException("not support Type Annotation.", th);
    L36:
        if (sun_AnnotationType_getInstance == null) goto L56;
        if (sun_AnnotationType_error == true) goto L56;
        Object[] r106 = {r105};     // Catch: Throwable -> L52
        Object r107 = null;
        Map r108 = (Map) sun_AnnotationType_members.invoke(sun_AnnotationType_getInstance.invoke(null, r106), new Object[0]);     // Catch: Throwable -> L49
        JSONObject r111 = new JSONObject(r108.size());
        Iterator r109 = r108.entrySet().iterator();
    L43:
        if (r109.hasNext() == false) goto L47;
        Map.Entry r112 = (Map.Entry) r109.next();
        r107 = ((Method) r112.getValue()).invoke(r101, new Object[0]);     // Catch: Throwable -> L60
    L46:
        r111.put2((String) r112.getKey(), JSON.toJSON(r107));
        goto L43
    L47:
        r100.write(r111);
        return;
    L49:
        th = move-exception;
        sun_AnnotationType_error = true;
        throw new JSONException("not support Type Annotation.", th);
    L52:
        th = move-exception;
        sun_AnnotationType_error = true;
        throw new JSONException("not support Type Annotation.", th);
    L56:
        throw new JSONException("not support Type Annotation.");
    L58:
        throw new JSONException("not support Type Annotation.");
    }
}
