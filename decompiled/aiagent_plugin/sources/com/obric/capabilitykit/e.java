package com.obric.capabilitykit;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f32077a = null;

    static {
        f32077a = new e();
    }

    private e() {
    }

    @Override // com.obric.capabilitykit.a
    public PendingIntent a(long r1, Intent r3, FloatingIntentParams r4) {
        d.h.b.o.e(r3, MemorySourceLinkType.INTENT);
        d.h.b.o.e(r4, "params");
        Logger.INSTANCE.w("EmptyCapabilityManager", "getFloatingPendingIntent");
        return null;
    }

    @Override // com.obric.capabilitykit.a
    public void a(long r1) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "hideIntentResultCard");
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r1, String r2) {
        d.h.b.o.e(r1, "uri");
        d.h.b.o.e(r2, "packageName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "stopUriFileAccess");
    }

    @Override // com.obric.capabilitykit.a
    public void a(Uri r2, String r3, IUriFileReceiver r4) {
        IUriFileReceiver r1 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r4, IUriFileReceiver.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "uri");
        d.h.b.o.e(r3, "packageName");
        d.h.b.o.e(r1, "requester");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestUriFileAccess");
    }

    @Override // com.obric.capabilitykit.a
    public void a(ErrorCodeCallback r2) {
        d.h.b.o.e(r2, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerResultCallback");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IMAppAction r2) {
        d.h.b.o.e(r2, "result");
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r1, long r2, boolean r4, Map<String, String> r5) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "result");
        Logger.INSTANCE.w("EmptyCapabilityManager", "updateIntentResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(IntentResult<?> r1, IMAppAction r2) {
        d.h.b.o.e(r1, "intentResult");
        d.h.b.o.e(r2, "oldResult");
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r1, TaskStateInfo r2, TaskStateChangeCallback r3, Long r4) {
        d.h.b.o.e(r1, DbHelper.COL_ID);
        d.h.b.o.e(r2, "stateInfo");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestStateChanged");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r1, String r2) {
        d.h.b.o.e(r1, "name");
        d.h.b.o.e(r2, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterIntent");
    }

    @Override // com.obric.capabilitykit.a
    public void a(String r1, String r2, String r3) {
        d.h.b.o.e(r1, "name");
        d.h.b.o.e(r2, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerIntent");
    }

    @Override // com.obric.capabilitykit.a
    public boolean a() {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isKeyguardReallyLocked");
        return true;
    }

    @Override // com.obric.capabilitykit.a
    public void b(long r1) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "finishFloatingActivity");
    }

    @Override // com.obric.capabilitykit.a
    public void b(ErrorCodeCallback r2) {
        d.h.b.o.e(r2, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterResultCallback");
    }

    @Override // com.obric.capabilitykit.a
    public Boolean c(long r1) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isCardViewVisible");
        return null;
    }
}
