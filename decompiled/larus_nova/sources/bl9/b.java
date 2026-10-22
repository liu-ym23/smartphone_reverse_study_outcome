package bl9;

import android.os.Looper;
import cl9.j;
import cl9.k;
import cl9.l;
import com.bytedance.mira.MiraPluginBeforeLoadListener;
import com.bytedance.mira.MiraPluginEventListener;
import com.bytedance.mira.event.PluginEventListener;
import com.bytedance.mira.plugin.PluginManager;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b implements PluginEventListener, MiraPluginBeforeLoadListener, MiraPluginEventListener {
    public b() {
    }

    @Override // com.bytedance.mira.MiraPluginBeforeLoadListener
    public final void onBeforeLoad(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        boolean r101 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        FLogger.f375446a.i("plugin/init", "start to load plugin: " + r100 + ", isMainThread: " + r101);
        Iterator r102 = hl9.a.b(r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = (String) r102.next();
        if (Intrinsics.areEqual(r103, r100) == true) goto L4;
        PluginManager.getInstance().loadPlugin(r103);
        goto L4
    }

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginLoaded(final String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AndroidSchedulers.mainThread().scheduleDirect(new a(r100));
        Map<String, List<Runnable>> r101 = l.f24145a;
        Intrinsics.checkNotNullParameter(r100, "packageName");
        l.f24147c.execute(new k(r100));
    }

    @Override // com.bytedance.mira.MiraPluginEventListener
    public final void onPluginInstallResult(final String r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == false) goto L7;
        Map<String, List<Runnable>> r102 = l.f24145a;
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
        l.f24147c.execute(new j(r100));
        return;
    }

    @Override // com.bytedance.mira.event.PluginEventListener
    public final void onPluginEvent(int r110, String r111, int r112, long r210, Throwable r211, long r212) {
        Intrinsics.checkNotNullParameter(r111, "packageName");
        if (r110 != 31000) goto L6;
        FLogger.f375446a.i("plugin/init", " load success packageName: " + r111 + ", versionCode: " + r112 + ", duration: " + r210 + ", throwable: " + r211 + ", timestamp: " + r212);
    L6:
        if (r110 >= 12000) goto L8;
        return;
    L8:
        if (r110 != 12013) goto L10;
        return;
    L10:
        if (r110 >= 20000) goto L15;
        FLogger.f375446a.e("plugin/init", " load Fail packageName: " + r111 + ", versionCode: " + r112 + ", duration: " + r210 + ", throwable: " + r211 + ", timestamp: " + r212);
        return;
    }
}
