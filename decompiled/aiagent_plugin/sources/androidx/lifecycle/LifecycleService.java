package androidx.lifecycle;

import android.content.Intent;
import android.os.IBinder;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: LifecycleService.kt */
/* JADX INFO: loaded from: classes.dex */
public class LifecycleService extends PluginService implements p {
    private final ai dispatcher;

    public LifecycleService() {
        this.dispatcher = new ai((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        this.dispatcher.a();
        super/*android.app.Service*/.onCreate();
    }

    public IBinder onBind(Intent r2) {
        d.h.b.o.e(r2, MemorySourceLinkType.INTENT);
        this.dispatcher.b();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStart(Intent r2, int r3) {
        this.dispatcher.c();
        super/*android.app.Service*/.onStart(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r1, int r2, int r3) {
        return super/*android.app.Service*/.onStartCommand(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        this.dispatcher.d();
        super/*android.app.Service*/.onDestroy();
    }

    @Override // androidx.lifecycle.p
    public i getLifecycle() {
        return this.dispatcher.e();
    }
}
