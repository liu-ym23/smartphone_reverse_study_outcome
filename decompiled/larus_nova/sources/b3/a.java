package b3;

import android.content.Context;
import com.bytedance.ai.model.LynxWorkerRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.lynx.tasm.LynxGroup;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Applet f17109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LynxGroup f17110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LynxWorkerRuntime f17111d;

    public a(Context r100, Applet r101, Map<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        Intrinsics.checkNotNullParameter(r101, "applet");
        this.f17108a = r100;
        this.f17109b = r101;
        LynxGroup.a r103 = new LynxGroup.a();
        r103.f381661a = r101.o();
        r103.f381664d = true;
        this.f17110c = new LynxGroup(r103);
        this.f17111d = new LynxWorkerRuntime(this.f17108a, this.f17109b, r102, this.f17110c);
    }
}
