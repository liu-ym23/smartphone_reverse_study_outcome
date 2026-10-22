package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class a5 extends ContextThemeWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f26857f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f26858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutInflater f26859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ClassLoader f26860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f26861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LayoutInflater.Factory f26862e;

    public class a implements LayoutInflater.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a5 f26863a;

        public a(a5 r100) {
            this.f26863a = r100;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r100, Context r101, AttributeSet r102) {
            return a5.a(this.f26863a, r100, r101, r102);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashSet<String> f26864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public HashMap<String, Constructor<?>> f26865b;

        public b(a5 r100) {
            this.f26864a = new HashSet();
            this.f26865b = new HashMap();
        }
    }

    static {
        f26857f = new String[]{"android.widget", "android.webkit", "android.app"};
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources r100 = this.f26858a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r100) {
        if ("layout_inflater".equals(r100) == false) goto L13;
        if (this.f26859b != null) goto L11;
        LayoutInflater r101 = (LayoutInflater) super.getSystemService(r100);
        if (r101 == null) goto L9;
        this.f26859b = r101.cloneInContext(this);
    L9:
        this.f26859b.setFactory(this.f26862e);
        this.f26859b = this.f26859b.cloneInContext(this);
    L11:
        return this.f26859b;
    L13:
        return super.getSystemService(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_amap_api_mapcore_util_a5_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public a5(Context r100, int r101, ClassLoader r102) {
        super(r100, r101);
        this.f26861d = new b(this);
        this.f26862e = new a(this);
        this.f26858a = b5.a();
        this.f26860c = r102;
    }

    public static View a(a5 r110, String r111, Context r112, AttributeSet r113) {
        if (r110.f26861d.f26864a.contains(r111) == true) goto L52;
        Constructor<?> r100 = r110.f26861d.f26865b.get(r111);
        if (r100 == null) goto L41;
    L34:
        if (r100 == null) goto L51;
        return (View) r100.newInstance(new Object[]{r112, r113});
    L53:
        return null;
    L51:
        return null;
    L41:
    L27:
        Class r101 = null;
    L28:
        boolean r102 = false;
    L29:
        if (r102 == true) goto L44;
        r110.f26861d.f26864a.add(r111);
        return null;
    L44:
        r100 = r101.getConstructor(new Class[]{Context.class, AttributeSet.class});     // Catch: Throwable -> L33
        r110.f26861d.f26865b.put(r111, r100);     // Catch: Throwable -> L33
        goto L34
    L8:
        if (r111.contains("api.navi") == false) goto L10;
        r101 = INVOKEVIRTUAL_com_amap_api_mapcore_util_a5_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r110.f26860c, r111);     // Catch: Throwable -> L27
    L17:
        if (r101 == null) goto L28;
        if (r101 == ViewStub.class) goto L28;
        if (r101.getClassLoader() != r110.f26860c) goto L28;
        r102 = true;
        goto L29
    L10:
        String[] r103 = f26857f;     // Catch: Throwable -> L27
        int r104 = r103.length;     // Catch: Throwable -> L27
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L16;
        String r106 = r103[r105];     // Catch: Throwable -> L27
        r101 = INVOKEVIRTUAL_com_amap_api_mapcore_util_a5_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r110.f26860c, r106 + "." + r111);     // Catch: Throwable -> L15
    L15:
        r105 = r105 + 1;
        goto L11
    L16:
        r101 = null;
        goto L17
    L52:
        return null;
    }
}
