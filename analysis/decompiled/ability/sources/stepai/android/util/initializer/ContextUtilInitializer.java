package stepai.android.util.initializer;

import C7.r;
import N9.j;
import Oa.a;
import S0.b;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import androidx.startup.Initializer;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import z2.l;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lstepai/android/util/initializer/ContextUtilInitializer;", "Landroidx/startup/Initializer;", "LC7/r;", AppAgent.CONSTRUCT, "()V", "util_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContextUtilInitializer implements Initializer<r> {
    @Override // androidx.startup.Initializer
    public final r create(Context context) {
        k.f(context, "context");
        j.H("ContextUtilInitializer create", "MpyInitializer");
        Application application = (Application) context;
        l.b = application;
        try {
            if (b.X0().getPackageName().equals(j.t())) {
                File file = new File(application.getDir("webview", 0).getPath(), "webview_data.lock");
                if (file.exists()) {
                    if (new RandomAccessFile(file, "rw").getChannel().tryLock() != null) {
                        file.delete();
                    } else {
                        WebView.setDataDirectorySuffix(application.getPackageName() + '_' + Process.myPid());
                    }
                }
                String str = Build.BRAND;
                if (t.X(str, "HuaWei") || t.X(str, "HONOR")) {
                    File file2 = new File(application.getDir("hws_webview", 0).getPath(), "webview_data.lock");
                    if (file2.exists()) {
                        if (new RandomAccessFile(file2, "rw").getChannel().tryLock() != null) {
                            file2.delete();
                        } else {
                            WebView.setDataDirectorySuffix(application.getPackageName() + '_' + Process.myPid());
                        }
                    }
                }
            } else {
                WebView.setDataDirectorySuffix(j.t());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r.f317a;
    }

    @Override // androidx.startup.Initializer
    public final List dependencies() {
        return a.f1052a;
    }
}
