package androidx.emoji2.text;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
class EmojiExclusions {

    public static class EmojiExclusions_Api34 {
        private EmojiExclusions_Api34() {
        }

        public static Set<int[]> getExclusions() {
            return EmojiExclusions_Reflections.getExclusions();
        }
    }

    public static class EmojiExclusions_Reflections {
        private EmojiExclusions_Reflections() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public static Set<int[]> getExclusions() {
            Object r100 = INVOKESTATIC_androidx_emoji2_text_EmojiExclusions$EmojiExclusions_Reflections_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L13
            if (r100 == null) goto L5;
            Set<int[]> r101 = (Set) r100;     // Catch: Throwable -> L13
            Iterator<int[]> r102 = r101.iterator();     // Catch: Throwable -> L13
        L8:
            if (r102.hasNext() == false) goto L19;
            if ((r102.next() instanceof int[]) == true) goto L8;
            return Collections.emptySet();
        L19:
            return r101;
        L5:
            return Collections.emptySet();
        L14:
            return Collections.emptySet();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_emoji2_text_EmojiExclusions$EmojiExclusions_Reflections_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
    }

    private EmojiExclusions() {
    }

    public static Set<int[]> getEmojiExclusions() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return EmojiExclusions_Api34.getExclusions();
    L7:
        return EmojiExclusions_Reflections.getExclusions();
    }
}
