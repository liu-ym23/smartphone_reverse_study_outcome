package com.alibaba.fastjson.util;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceLoader {
    private static final String PREFIX = "META-INF/services/";
    private static final Set<String> loadedUrls = null;

    public ServiceLoader() {
    }

    static {
        loadedUrls = new HashSet();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_alibaba_fastjson_util_ServiceLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static <T> Set<T> load(Class<T> r100, ClassLoader r101) {
        if (r101 == null) goto L4;
        HashSet r102 = new HashSet();
        String r103 = PREFIX.concat(r100.getName());
        HashSet r104 = new HashSet();
        Enumeration<URL> r105 = r101.getResources(r103);     // Catch: Throwable -> L22
    L8:
        if (r105.hasMoreElements() == false) goto L14;
        URL r106 = r105.nextElement();     // Catch: Throwable -> L22
        Set<String> r107 = loadedUrls;     // Catch: Throwable -> L22
        if (r107.contains(r106.toString()) == true) goto L8;
        load(r106, r104);     // Catch: Throwable -> L22
        r107.add(r106.toString());     // Catch: Throwable -> L22
    L14:
        Iterator r108 = r104.iterator();
    L16:
        if (r108.hasNext() == false) goto L21;
        r102.add(INVOKEVIRTUAL_com_alibaba_fastjson_util_ServiceLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, (String) r108.next()).newInstance());     // Catch: Exception -> L20
        goto L16
    L21:
        return r102;
    L4:
        return Collections.emptySet();
    }

    public static void load(URL r100, Set<String> r101) throws IOException {
        BufferedReader r102 = null;
        InputStream r103 = r100.openStream();     // Catch: Throwable -> L22
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r103, XML.CHARSET_UTF8));     // Catch: Throwable -> L20
    L28:
        String r105 = r104.readLine();     // Catch: Throwable -> L18
        if (r105 == null) goto L7;
        int r106 = r105.indexOf(35);     // Catch: Throwable -> L18
        if (r106 < 0) goto L13;
        r105 = r105.substring(0, r106);     // Catch: Throwable -> L18
    L13:
        String r107 = r105.trim();     // Catch: Throwable -> L18
        if (r107.length() == 0) goto L28;
        r101.add(r107);     // Catch: Throwable -> L18
        goto L28
    L7:
        IOUtils.close(r104);
        IOUtils.close(r103);
        return;
    L18:
        th = th;
        r102 = r104;
    L24:
        IOUtils.close(r102);
        IOUtils.close(r103);
        throw th;
    L20:
        th = th;
    L22:
        th = th;
        r103 = null;
        goto L24
    }
}
