package cb;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.obric.capabilitykit.ErrorCodeCallback;
import com.obric.capabilitykit.TaskStateChangeCallback;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.obric.capabilitykit.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f6085a = null;

    static {
        f6085a = new p();
    }

    public p() {
    }

    @Override // com.obric.capabilitykit.a
    public PendingIntent a(long r10, Intent r11, FloatingIntentParams r12) {
        kotlin.jvm.internal.q.g(r11, MemorySourceLinkType.INTENT);
        kotlin.jvm.internal.q.g(r12, "params");
        Logger.INSTANCE.w("EmptyCapabilityManager", "getFloatingPendingIntent");
        return null;
    }

    @Override // com.obric.capabilitykit.a
    public void b(long r10) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "finishFloatingActivity");
    }

    @Override // com.obric.capabilitykit.a
    public Boolean c(long r10) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isCardViewVisible");
        return null;
    }

    @Override // com.obric.capabilitykit.a
    public void a(long r10) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "hideIntentResultCard");
    }

    @Override // com.obric.capabilitykit.a
    public void b(ErrorCodeCallback r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerResultCallback");
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "uri");
        kotlin.jvm.internal.q.g(r11, "packageName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "stopUriFileAccess");
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r10, String r11, IUriFileReceiver r12) {
        kotlin.jvm.internal.q.g(r10, "uri");
        kotlin.jvm.internal.q.g(r11, "packageName");
        kotlin.jvm.internal.q.g(r12, "requester");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestUriFileAccess");
    }

    @Override // com.obric.capabilitykit.a
    public void a(ErrorCodeCallback r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterResultCallback");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IMAppAction r10) {
        kotlin.jvm.internal.q.g(r10, "result");
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult r10, long r11, boolean r12, Map r13) {
        kotlin.jvm.internal.q.g(r10, "result");
        Logger.INSTANCE.w("EmptyCapabilityManager", "updateIntentResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult r10, IMAppAction r11) {
        kotlin.jvm.internal.q.g(r10, "intentResult");
        kotlin.jvm.internal.q.g(r11, "oldResult");
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r10, TaskStateInfo r11, TaskStateChangeCallback r12, Long r13) {
        kotlin.jvm.internal.q.g(r10, "id");
        kotlin.jvm.internal.q.g(r11, "stateInfo");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestStateChanged");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterIntent");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r10, String r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "name");
        kotlin.jvm.internal.q.g(r11, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerIntent");
    }

    @Override // com.obric.capabilitykit.a
    public boolean a() {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isKeyguardReallyLocked");
        return true;
    }
}
