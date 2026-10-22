package com.media.cache.download;

import com.media.cache.listener.IDownloadTaskListener;
import com.media.cache.model.VideoCacheInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadPoolExecutor;
import u9.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VideoDownloadTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f10433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IDownloadTaskListener f10434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f10435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f10436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p9.a f10437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final VideoCacheInfo f10438f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10439g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f10440h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public File f10441i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10442j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Timer f10443k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f10444l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10445m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f10446n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f10447o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile OPERATE_TYPE f10448p;

    public static final enum OPERATE_TYPE extends Enum<OPERATE_TYPE> {
        private static final /* synthetic */ OPERATE_TYPE[] $VALUES = null;
        public static final OPERATE_TYPE DEFAULT = null;
        public static final OPERATE_TYPE WRITED = null;

        static {
            OPERATE_TYPE r10 = new OPERATE_TYPE("DEFAULT", 0);
            DEFAULT = r10;
            OPERATE_TYPE r11 = new OPERATE_TYPE("WRITED", 1);
            WRITED = r11;
            $VALUES = new OPERATE_TYPE[]{r10, r11};
        }

        private OPERATE_TYPE(String r10, int r11) {
            super(r10, r11);
        }

        public static OPERATE_TYPE valueOf(String r10) {
            return (OPERATE_TYPE) Enum.valueOf(OPERATE_TYPE.class, r10);
        }

        public static OPERATE_TYPE[] values() {
            return (OPERATE_TYPE[]) $VALUES.clone();
        }
    }

    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoDownloadTask f10449a;

        public a(VideoDownloadTask r10) {
            this.f10449a = r10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            VideoDownloadTask r10 = this.f10449a;
            long r11 = r10.f10444l;
            long r12 = r10.f10445m;
            if (r11 > r12) goto L6;
            float r13 = (r12 - r11) * 1.0f;
            r10.f10434b.onTaskSpeedChanged(r13);
            VideoDownloadTask r14 = this.f10449a;
            r14.f10444l = r14.f10445m;
            r14.f10447o = r13;
            return;
        }
    }

    public VideoDownloadTask(p9.a r10, VideoCacheInfo r11, HashMap r12) {
        this.f10435c = false;
        this.f10436d = false;
        this.f10444l = 0;
        this.f10445m = 0;
        this.f10446n = 0.0f;
        this.f10447o = 0.0f;
        this.f10448p = OPERATE_TYPE.DEFAULT;
        this.f10437e = r10;
        this.f10438f = r11;
        this.f10440h = r12;
        this.f10439g = r11.getFinalUrl();
        this.f10442j = d.c(r11.getUrl());
        File r13 = new File(r10.a(), this.f10442j);
        this.f10441i = r13;
        if (r13.exists() == true) goto L5;
        this.f10441i.mkdir();
    L5:
        r11.setSaveDir(this.f10441i.getAbsolutePath());
    }

    public void a() {
        Timer r10 = this.f10443k;
        if (r10 == null) goto L6;
        r10.cancel();
        this.f10443k = null;
        return;
    }

    public void b() {
        IDownloadTaskListener r10 = this.f10434b;
        if (r10 == null) goto L6;
        r10.onTaskPaused();
        a();
        return;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e(long r10, long r11);

    public abstract void f(IDownloadTaskListener r10);

    public void g() {
        if (this.f10443k != null) goto L6;
        this.f10443k = new Timer();
        a r10 = new a(this);
        this.f10443k.schedule(r10, 0, 1000);
        return;
    }

    public abstract void h();
}
