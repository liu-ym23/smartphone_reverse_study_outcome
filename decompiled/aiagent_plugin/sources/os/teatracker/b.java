package os.teatracker;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppStateChangeReceiver.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Gson f40688a;

    public void onReceive(Context r4, Intent r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (this.f40688a != null) goto L5;
        this.f40688a = new GsonBuilder().create();
    L5:
        if (r5 != null) goto L7;
        return;
    L7:
        if (TeaHandler.d().a() == null) goto L18;
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.f40688a.fromJson(r5.getStringExtra("appstate_params"), a.class), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        if (r3 == null) goto L19;
        r3.a(r5.getStringExtra("appstate_params"));     // Catch: Exception -> L12
        TeaHandler.d().a().a(r3);     // Catch: Exception -> L12
        return;
    L19:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
