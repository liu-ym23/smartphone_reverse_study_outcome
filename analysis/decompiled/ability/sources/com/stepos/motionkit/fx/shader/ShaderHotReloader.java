package com.stepos.motionkit.fx.shader;

import B7.a;
import O7.i;
import S7.n;
import android.content.Context;
import android.os.FileObserver;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.ErrorLevel;
import com.stepos.motionkit.MotionKit;
import com.stepos.motionkit.MotionKitError;
import j9.AbstractC1607a;
import j9.t;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/motionkit/fx/shader/ShaderHotReloader;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "watchDir", "Lkotlin/Function2;", "", "LC7/r;", "onReload", AppAgent.CONSTRUCT, "(Landroid/content/Context;Ljava/io/File;LS7/n;)V", "start", "()V", "stop", "Landroid/content/Context;", "Ljava/io/File;", "LS7/n;", "Landroid/os/FileObserver;", "observer", "Landroid/os/FileObserver;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShaderHotReloader {
    private final Context context;
    private FileObserver observer;
    private final n onReload;
    private final File watchDir;

    public ShaderHotReloader(Context context, File watchDir, n onReload) {
        k.f(context, "context");
        k.f(watchDir, "watchDir");
        k.f(onReload, "onReload");
        this.context = context;
        this.watchDir = watchDir;
        this.onReload = onReload;
    }

    public final void start() {
        if (!this.watchDir.exists()) {
            MotionKit.INSTANCE.handleError(new MotionKitError(ErrorLevel.WARNING, a.k("Hot reload dir not found: ", this.watchDir.getPath()), null, 4, null));
            return;
        }
        FileObserver fileObserver = new FileObserver(this.watchDir) { // from class: com.stepos.motionkit.fx.shader.ShaderHotReloader.start.1
            @Override // android.os.FileObserver
            public void onEvent(int event, String path) {
                if (path == null) {
                    return;
                }
                if (t.W(path, ".agsl", false) || t.W(path, ".glsl", false)) {
                    try {
                        ShaderHotReloader.this.onReload.invoke(path, i.X(new File(ShaderHotReloader.this.watchDir, path), AbstractC1607a.f4778a));
                    } catch (Exception e) {
                        MotionKit.INSTANCE.handleError(new MotionKitError(ErrorLevel.WARNING, "Hot reload failed for ".concat(path), e));
                    }
                }
            }
        };
        this.observer = fileObserver;
        fileObserver.startWatching();
    }

    public final void stop() {
        FileObserver fileObserver = this.observer;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        this.observer = null;
    }
}
