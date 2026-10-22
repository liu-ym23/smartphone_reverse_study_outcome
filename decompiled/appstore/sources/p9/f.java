package p9;

import android.net.Uri;
import android.text.TextUtils;
import com.media.cache.VideoCacheException;
import com.media.cache.listener.IVideoInfoCallback;
import com.media.cache.listener.IVideoInfoParseCallback;
import com.media.cache.model.VideoCacheInfo;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f23412b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f23413a;

    public f() {
    }

    public static /* synthetic */ void a(f r10, VideoCacheInfo r11, IVideoInfoCallback r12, HashMap r13) {
        r10.f(r11, r12, r13);
    }

    public static f c() {
        if (f23412b != null) goto L16;
        monitor-enter(f.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23412b != null) goto L11;
        f23412b = new f();     // Catch: Throwable -> L9
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L16:
        return f23412b;
    }

    public final void b(VideoCacheInfo r12, IVideoInfoCallback r13, HashMap r14) {
        if (r12 != null) goto L8;
        r13.onBaseVideoInfoFailed(new Throwable("Video info is null."));     // Catch: Exception -> L5
        return;
    L8:
        if (u9.b.g(r12.getUrl()) == true) goto L11;
        r13.onBaseVideoInfoFailed(new Throwable("Can parse the request resource's schema."));     // Catch: Exception -> L5
        return;
    L11:
        String r10 = r12.getUrl();     // Catch: Exception -> L5
        o0.a.a("doParseVideoInfoTask finalUrl=" + r10);     // Catch: Exception -> L5
        if (this.f23413a.i() == false) goto L18;
        r10 = u9.b.b(this.f23413a, r12.getUrl(), r14);     // Catch: Exception -> L5
        if (TextUtils.isEmpty(r10) == false) goto L17;
        r13.onBaseVideoInfoFailed(new Throwable("FinalUrl is null."));     // Catch: Exception -> L5
        return;
    L17:
        r13.onFinalUrl(r10);     // Catch: Exception -> L5
    L18:
        r12.setFinalUrl(r10);     // Catch: Exception -> L5
        String r11 = Uri.parse(r10).getLastPathSegment();     // Catch: Exception -> L5
        o0.a.a("parseVideoInfo  fileName = " + r11);     // Catch: Exception -> L5
        if (r11 == null) goto L41;
        String r15 = r11.toLowerCase();     // Catch: Exception -> L5
        if (r15.endsWith(".m3u8") == false) goto L26;
        h(r12, r13, r14);     // Catch: Exception -> L5
        return;
    L26:
        if (r15.endsWith(".mp4") == false) goto L30;
        o0.a.c("parseVideoInfo MP4_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(3);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L30:
        if (r15.endsWith(".mov") == false) goto L34;
        o0.a.c("parseVideoInfo QUICKTIME_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(5);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L34:
        if (r15.endsWith(".webm") == false) goto L38;
        o0.a.c("parseVideoInfo WEBM_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(4);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L38:
        if (r15.endsWith(".3gp") == false) goto L41;
        o0.a.c("parseVideoInfo GP3_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(6);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L41:
        String r16 = u9.b.c(this.f23413a, r10, r14);     // Catch: Exception -> L5
        o0.a.c("parseVideoInfo mimeType=" + r16);     // Catch: Exception -> L5
        if (r16 == null) goto L62;
        String r17 = r16.toLowerCase();     // Catch: Exception -> L5
        if (r17.contains(s9.a.f24538a) == false) goto L47;
        o0.a.c("parseVideoInfo MP4_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(3);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L47:
        if (e(r17) == false) goto L50;
        h(r12, r13, r14);     // Catch: Exception -> L5
        return;
    L50:
        if (r17.contains(s9.a.f24543f) == false) goto L53;
        o0.a.c("parseVideoInfo QUICKTIME_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(4);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L53:
        if (r17.contains(s9.a.f24544g) == false) goto L56;
        o0.a.c("parseVideoInfo WEBM_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(5);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L56:
        if (r17.contains(s9.a.f24545h) == false) goto L59;
        o0.a.c("parseVideoInfo GP3_TYPE");     // Catch: Exception -> L5
        r12.setVideoType(6);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L59:
        if (r17.contains(s9.a.f24546i) == false) goto L61;
        r12.setVideoType(7);     // Catch: Exception -> L5
        r13.onBaseVideoInfoSuccess(r12);     // Catch: Exception -> L5
        return;
    L61:
        r13.onBaseVideoInfoFailed(new VideoCacheException("MimeType not found"));     // Catch: Exception -> L5
        return;
    L62:
        r13.onBaseVideoInfoFailed(new VideoCacheException("MimeType is null"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r13.onBaseVideoInfoFailed(e);
    }

    public void d(a r10) {
        this.f23413a = r10;
    }

    public final boolean e(String r10) {
        if (r10.contains(s9.a.f24539b) == false) goto L5;
    L12:
        return true;
    L5:
        if (r10.contains(s9.a.f24540c) == true) goto L12;
        if (r10.contains(s9.a.f24541d) == true) goto L12;
        if (r10.contains(s9.a.f24542e) == true) goto L12;
        return false;
    }

    public final /* synthetic */ void f(VideoCacheInfo r10, IVideoInfoCallback r11, HashMap r12) {
        b(r10, r11, r12);
    }

    public void g(VideoCacheInfo r10, IVideoInfoParseCallback r11) {
        File r12 = new File(r10.getSaveDir(), "remote.m3u8");
        if (r12.exists() == true) goto L11;
        r11.onM3U8FileParseFailed(r10, new Throwable("Cannot find remote.m3u8 file."));
        return;
    L11:
        r11.onM3U8FileParseSuccess(r10, q9.d.b(this.f23413a, r10.getUrl(), true, r12));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        r11.onM3U8FileParseFailed(r10, e);
    }

    public final void h(VideoCacheInfo r10, IVideoInfoCallback r11, HashMap r12) {
        q9.a r13 = q9.d.b(this.f23413a, r10.getUrl(), false, null);     // Catch: Exception -> L7
        if (r13.h() == false) goto L10;
        String r14 = u9.d.c(r10.getUrl());     // Catch: Exception -> L7
        File r15 = new File(this.f23413a.a(), r14);     // Catch: Exception -> L7
        if (r15.exists() == true) goto L9;
        r15.mkdir();     // Catch: Exception -> L7
    L9:
        q9.d.a(r15, r13);     // Catch: Exception -> L7
        r10.setSaveDir(r15.getAbsolutePath());     // Catch: Exception -> L7
        r10.setVideoType(1);     // Catch: Exception -> L7
        r11.onM3U8InfoSuccess(r10, r13);     // Catch: Exception -> L7
        return;
    L10:
        r10.setVideoType(2);     // Catch: Exception -> L7
        r11.onLiveM3U8Callback(r10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        r11.onM3U8InfoFailed(e);
    }

    public synchronized void i(final VideoCacheInfo r10, final IVideoInfoCallback r11, final HashMap r12) {
        monitor-enter(this);
        u9.c.b(new e(this, r10, r11, r12));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
