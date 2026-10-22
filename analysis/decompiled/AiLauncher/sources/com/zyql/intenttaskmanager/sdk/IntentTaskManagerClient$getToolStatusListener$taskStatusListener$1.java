package com.zyql.intenttaskmanager.sdk;

import android.os.Bundle;
import com.zyql.intenttaskmanager.ITaskStatusListener;
import g8.InterfaceC4108b;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/zyql/intenttaskmanager/sdk/IntentTaskManagerClient$getToolStatusListener$taskStatusListener$1", "Lcom/zyql/intenttaskmanager/ITaskStatusListener$Stub;", "Landroid/os/Bundle;", "bundle", "LY8/t;", "onTaskProgress", "(Landroid/os/Bundle;)V", "sdk_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IntentTaskManagerClient$getToolStatusListener$taskStatusListener$1 extends ITaskStatusListener.Stub {
    final /* synthetic */ InterfaceC4108b $taskListener;

    public IntentTaskManagerClient$getToolStatusListener$taskStatusListener$1(InterfaceC4108b interfaceC4108b) {
    }

    @Override // com.zyql.intenttaskmanager.ITaskStatusListener
    public void onTaskProgress(Bundle bundle) {
        p.i(bundle, "bundle");
        C4148a.b("IntentTaskManagerSDK", "taskStatusListener onTaskProgress " + bundle);
        String string = bundle.getString("method");
        if (p.d(string, "method_progress")) {
            C4148a.b("IntentTaskManagerSDK", "taskStatusListener toolProgressNotification " + a.f(bundle));
            throw null;
        }
        if (p.d(string, "method_response")) {
            C4148a.b("IntentTaskManagerSDK", "taskStatusListener toolResponse " + a.e(bundle));
            throw null;
        }
    }
}
