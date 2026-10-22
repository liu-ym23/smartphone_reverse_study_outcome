package c97;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.exception.JavaPatchParseException;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.n;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class, com.bytedance.reparo.core.h> f22863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f22864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f22865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f22866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f22867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22868f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, com.bytedance.reparo.core.h> f22869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f22870b;

        public a() {
            this.f22869a = new HashMap();
            this.f22870b = new HashSet();
        }
    }

    public final PolarisFileWrapper b() throws JavaPatchParseException {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.f22867e, "deoptimize_methods_l.txt");
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f22867e, "deoptimize_methods_mn.txt");
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.f22867e, "deoptimize_methods_os.txt");
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f22867e, "deoptimize_methods.txt");
        int r104 = Build.VERSION.SDK_INT;
        if (r104 > 22) goto L8;
        if (r100.exists() == false) goto L8;
        System.out.println("use deoptimize_methods_l.txt");
    L19:
        if (w87.b.g(r100) == false) goto L22;
        return r100;
    L22:
        throw new JavaPatchParseException("Failed to parse java patch, " + r100.getAbsolutePath() + " not exist", 108);
    L8:
        if (r104 > 25) goto L13;
        if (r101.exists() == false) goto L13;
        System.out.println("use deoptimize_methods_mn.txt");
        r100 = r101;
    L13:
        if (r104 <= 30) goto L15;
    L17:
        r100 = r103;
        goto L19
    L15:
        if (r102.exists() == false) goto L17;
        System.out.println("use deoptimize_methods_os.txt");
        r100 = r102;
        goto L19
    }

    public d(File r100) {
        this.f22863a = new HashMap();
        this.f22864b = new ArrayList();
        this.f22866d = new ArrayList();
        this.f22868f = false;
        this.f22867e = r100;
    }

    public static Map c(PolarisFileWrapper r100) throws IOException {
        HashMap r101 = new HashMap();
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r100));
        String r103 = r102.readLine();
        String r104 = null;
    L4:
        if (TextUtils.isEmpty(r103) == true) goto L27;
        if (r103.startsWith("#") == false) goto L14;
        String r105 = r103.substring(2);
        if (TextUtils.isEmpty(r105) == false) goto L10;
    L12:
        r104 = r105;
    L26:
        r103 = r102.readLine();
        goto L4
    L10:
        if (r101.containsKey(r105) == true) goto L12;
        r101.put(r105, new HashMap());
        goto L12
    L14:
        if (TextUtils.isEmpty(r104) == true) goto L26;
        String r106 = r103.trim();
        int r107 = r106.indexOf(32);
        String r108 = r106.substring(0, r107);
        String r109 = r106.substring(r107 + 1);
        if (TextUtils.isEmpty(r108) == true) goto L26;
        if (TextUtils.isEmpty(r109) == true) goto L26;
        if ("<init>".equals(r108) == false) goto L23;
        r108 = n.a(r104);
    L23:
        if (((Map) r101.get(r104)).containsKey(r108) == false) goto L25;
        ((Set) ((Map) r101.get(r104)).get(r108)).add(r109);
        goto L26
    L25:
        HashSet r110 = new HashSet();
        r110.add(r109);
        ((Map) r101.get(r104)).put(r108, r110);
        goto L26
    L27:
        r102.close();
        return r101;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100, ClassLoader r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = Class.forName(r100, false, r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r105 = Class.forName(r100, false, r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public final a d(Map<String, Map<String, Set<String>>> r110, boolean r111) throws JavaPatchParseException {
        a r100 = new a();
        Iterator r112 = ((HashMap) r110).entrySet().iterator();
    L4:
        if (r112.hasNext() == false) goto L72;
        Map.Entry r101 = (Map.Entry) r112.next();
        String r102 = n.a((String) r101.getKey());
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f22867e, r102 + Dex2OatHelper.DEX_SUFFIX);
        if (r103.exists() == true) goto L11;
        if (r111 == false) goto L11;
        throw new JavaPatchParseException("parsePatchConfig patch dex file: " + r103.getPath() + " does not exist", 109);
    L11:
        Map r104 = (Map) r101.getValue();
        if (r104 == null) goto L71;
        if (r104.isEmpty() == true) goto L71;
        Class r105 = a(r102, d.class.getClassLoader());     // Catch: Throwable -> L23 PatchException -> L25 NoClassDefFoundError -> L63 ClassNotFoundException -> L65
    L16:
        com.bytedance.reparo.core.h r106 = new com.bytedance.reparo.core.h(r103.getPath());     // Catch: Throwable -> L23 PatchException -> L25
        if (r104.containsKey("<clinit>") == false) goto L73;
        Constructor r107 = WandTrick.e().getClinitMethod(r105);     // Catch: Throwable -> L23 PatchException -> L25
        if (r107 == null) goto L73;
        if (r106.f267369b != null) goto L27;
        r106.f267369b = new ArrayList();     // Catch: Throwable -> L23 PatchException -> L25
    L27:
        ((ArrayList) r106.f267369b).add(r107);     // Catch: Throwable -> L23 PatchException -> L25
    L73:
        x87.a<Method[], NoClassDefFoundError> r108 = e97.g.f(r105);     // Catch: Throwable -> L23 PatchException -> L25 NoClassDefFoundError -> L61
        T r109 = r108.f562914a;     // Catch: Throwable -> L23 PatchException -> L25 NoClassDefFoundError -> L61
        if (r109 == 0) goto L30;
        throw r109;     // Catch: Throwable -> L23 PatchException -> L25 NoClassDefFoundError -> L61
    L30:
        Method[] r113 = r108.f562915b;     // Catch: Throwable -> L23 PatchException -> L25 NoClassDefFoundError -> L61
        int r114 = r113.length;     // Catch: Throwable -> L23 PatchException -> L25
        int r115 = 0;
        int r116 = 0;
    L32:
        if (r116 >= r114) goto L42;
        Method r117 = r113[r116];     // Catch: Throwable -> L23 PatchException -> L25
        String r118 = r117.getName();     // Catch: Throwable -> L23 PatchException -> L25
        if (r104.containsKey(r118) == false) goto L41;
        if (((Set) r104.get(r118)).contains(n.d(r117)) == false) goto L41;
        if (r106.f267370c != null) goto L40;
        r106.f267370c = new ArrayList();     // Catch: Throwable -> L23 PatchException -> L25
    L40:
        ((ArrayList) r106.f267370c).add(r117);     // Catch: Throwable -> L23 PatchException -> L25
    L41:
        r116 = r116 + 1;     // Catch: Throwable -> L23 PatchException -> L25
        goto L32
    L42:
        Constructor<?>[] r119 = r105.getDeclaredConstructors();     // Catch: Throwable -> L23 PatchException -> L25
        int r120 = r119.length;     // Catch: Throwable -> L23 PatchException -> L25
    L43:
        if (r115 >= r120) goto L54;
        Constructor<?> r121 = r119[r115];     // Catch: Throwable -> L23 PatchException -> L25
        String r122 = r121.getName();     // Catch: Throwable -> L23 PatchException -> L25
        if (r104.containsKey(r122) == false) goto L52;
        if (((Set) r104.get(r122)).contains(n.c(r121)) == false) goto L52;
        if (r106.f267369b != null) goto L51;
        r106.f267369b = new ArrayList();     // Catch: Throwable -> L23 PatchException -> L25
    L51:
        ((ArrayList) r106.f267369b).add(r121);     // Catch: Throwable -> L23 PatchException -> L25
    L52:
        r115 = r115 + 1;     // Catch: Throwable -> L23 PatchException -> L25
        goto L43
    L54:
        if (r106.f267370c != null) goto L58;
        if (r106.f267369b != null) goto L58;
        b97.a.b("parsePatchConfig ignore class:" + r105.getName());     // Catch: Throwable -> L23 PatchException -> L25
    L58:
        ((HashMap) r100.f22869a).put(r105, r106);     // Catch: Throwable -> L23 PatchException -> L25
    L61:
        e = move-exception;
        b97.a.c("skip patch class " + r105.getName(), e);     // Catch: Throwable -> L23 PatchException -> L25
    L65:
        e = e;
    L66:
        b97.a.c("skip patch class " + r102, e);     // Catch: Throwable -> L23 PatchException -> L25
    L63:
        e = e;
    L25:
        e = move-exception;
        throw e;
    L23:
        th = move-exception;
        throw new JavaPatchParseException("parsePatchConfig class: " + r102, th, 110);
    L71:
        ((HashSet) r100.f22870b).add(r103.getAbsolutePath());
        goto L4
    L72:
        return r100;
    }
}
