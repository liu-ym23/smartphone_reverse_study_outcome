package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f70091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f70092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MusicPanel f70093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DownloadTask f70094d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f70095e;

    public interface a {
        void a(MusicPanel r100, String r101, String r102);

        void b(MusicPanel r100, int r101, String r102);

        void c(MusicPanel r100, int r101);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.socialbase.downloader.model.DownloadTask");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.socialbase.downloader.model.DownloadTask");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.socialbase.downloader.model.DownloadTask");
    }

    public final void e() {
        if (this.f70094d == null) goto L6;
        this.f70095e = true;
        Downloader.getInstance(s1.getContext()).pause(this.f70094d.getDownloadId());
        return;
    }

    public final void f() {
        if (this.f70094d == null) goto L11;
        this.f70095e = false;
        if (this.f70092b == false) goto L7;
        Downloader.getInstance(s1.getContext()).cancel(this.f70094d.getDownloadId());
    L7:
        DownloadTask r100 = this.f70094d;
        if (r100 == null) goto L10;
        r100.subThreadListener(null);
    L10:
        this.f70094d = null;
    L11:
        this.f70092b = false;
    }

    public p(v r100) {
        this.f70092b = false;
        this.f70091a = r100;
    }

    public final String b(KtvMusic r100) throws Exception {
        String r101 = this.f70091a.b(r100);
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L10;
        if (r102.mkdirs() == false) goto L7;
        h.a();
        goto L10
    L7:
        HashMap r103 = new HashMap();
        r103.put(ICEffectKeys.KEY_IS_IC_EFFECT_CACHE_PATH, r101);
        r103.put("music_id", String.valueOf(r100.getId()));
        r103.put("music_name", r100.getTitle());
        throw new IOException("mkdirs return false, dir=" + r102);
    L10:
        return r101 + this.f70091a.a(r100);
    }

    public final boolean c(long r100) {
        MusicPanel r101 = this.f70093c;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (this.f70092b == true) goto L8;
        return false;
    L8:
        if (r101.f153577a.getId() != r100) goto L12;
        return true;
    L12:
        return false;
    }

    public final Boolean d(MusicPanel r100) {
        if (this.f70093c != null) goto L7;
        return Boolean.FALSE;
    L7:
        if (Objects.equals(r100.g(), this.f70093c.g()) == true) goto L9;
    L11:
        boolean r101 = false;
    L13:
        return Boolean.valueOf(r101);
    L9:
        if (r100.f153577a.getId() != this.f70093c.f153577a.getId()) goto L11;
        r101 = true;
        goto L13
    }
}
