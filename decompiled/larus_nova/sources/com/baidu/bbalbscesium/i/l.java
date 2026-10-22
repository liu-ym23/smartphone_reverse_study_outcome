package com.baidu.bbalbscesium.i;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes39.dex */
final class l extends k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f30162i = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f30163h;

    /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class f30164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Method f30165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Method f30166c;

        private b() {
            a();
        }

        public /* synthetic */ b(a r100) {
            this();
        }

        public static /* synthetic */ long a(b r100, Object r101) throws i.a {
            return r100.a(r101);
        }

        private long a(Object r100) throws i.a {
            return ((Long) this.f30166c.invoke(r100, new Object[0])).longValue();
        L5:
            throw new i.a("");
        }

        public static /* synthetic */ Object a(b r100) throws Exception {
            return r100.b();
        }

        private void a() {
            this.f30164a = INVOKESTATIC_com_baidu_bbalbscesium_i_l$b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(i.a(h.b()), true, Object.class.getClassLoader());     // Catch: Exception -> L4
            String r100 = i.a(h.h());     // Catch: Exception -> L4
            Class r101 = this.f30164a;     // Catch: Exception -> L4
            Class r102 = Integer.TYPE;     // Catch: Exception -> L4
            this.f30165b = i.a(r101, r100, new Class[]{byte[].class, r102, r102});     // Catch: Exception -> L4
            this.f30166c = i.a(this.f30164a, i.a(h.c()), null);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        public static /* synthetic */ void a(b r100, Object r101, byte[] r102, int r103, int r104) throws i.a {
            r100.a(r101, r102, r103, r104);
        }

        private void a(Object r100, byte[] r101, int r102, int r103) throws i.a {
            this.f30165b.invoke(r100, new Object[]{r101, Integer.valueOf(r102), Integer.valueOf(r103)});     // Catch: Exception -> L4
            return;
        L5:
            throw new i.a("");
        }

        public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            return Class.forName(r100, r101, r102);
        }

        private Object b() throws Exception {
            return this.f30164a.newInstance();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_baidu_bbalbscesium_i_l$b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r105;
        L8:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r106;
        L17:
            th = move-exception;
            if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
    }

    public l(int r100, int r101) {
        this.f30157a = j.f30151d;
        this.f30158b = 4;
        this.f30159c = 32;
        this.f30160d = r100;
        this.f30161e = r101;
        this.f30163h = new b(null);
    }

    @Override // com.baidu.bbalbscesium.i.k
    public com.baidu.bbalbscesium.i.b a(byte[] r100, int r101, int r102) {
        Object r103 = b.a(this.f30163h);     // Catch: Exception -> L4
        b.a(this.f30163h, r103, r100, r101, r102);     // Catch: Exception -> L4
        long r104 = b.a(this.f30163h, r103);     // Catch: Exception -> L4
    L6:
        return com.baidu.bbalbscesium.i.b.a(new long[]{r104});
    L4:
        r104 = BodyPartID.bodyIdMax;
        goto L6
    }
}
