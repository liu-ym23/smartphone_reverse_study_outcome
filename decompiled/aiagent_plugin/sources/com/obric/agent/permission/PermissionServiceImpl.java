package com.obric.agent.permission;

import com.obric.agent.permission.bean.CheckPermissionReq;
import com.obric.agent.permission.bean.CheckPermissionResult;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.agent.permission.bean.UpdatePermissionReq;
import com.obric.agent.permission.bean.UpdatePermissionResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: PermissionServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionServiceImpl implements IPermissionService {
    private final f permissionProcessor$delegate;

    /* JADX INFO: renamed from: lambda$D-e5iBeM8KHr2-n9bAFjQgjBg4U, reason: not valid java name */
    public static /* synthetic */ b m101lambda$De5iBeM8KHr2n9bAFjQgjBg4U() {
        return permissionProcessor_delegate$lambda$0();
    }

    public static /* synthetic */ x lambda$eqwEdhq1Bvnx6CbFGLL91d3cXrg(ICallback r0, List r1) {
        return checkPermissions$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$gcAUvEkZcM0K9uX4-bqxGzkptis, reason: not valid java name */
    public static /* synthetic */ x m102lambda$gcAUvEkZcM0K9uX4bqxGzkptis(ICallback r0, RequestPermissionResult r1) {
        return requestPermissions$lambda$2(r0, r1);
    }

    public static /* synthetic */ x lambda$sVWV78IS88F81zDTiSpZ6cSg5HM(ICallback r0, UpdatePermissionResult r1) {
        return updatePermissions$lambda$3(r0, r1);
    }

    public PermissionServiceImpl() {
        this.permissionProcessor$delegate = g.a($$Lambda$PermissionServiceImpl$De5iBeM8KHr2n9bAFjQgjBg4U.INSTANCE);
    }

    private final b getPermissionProcessor() {
        return (b) ZeusTransformUtils.preCheckCast(this.permissionProcessor$delegate.b(), b.class, "com.obric.aiagent.plugin");
    }

    private static final b permissionProcessor_delegate$lambda$0() {
        return new b();
    }

    @Override // com.obric.agent.permission.IPermissionService
    public void checkPermissions(CheckPermissionReq r3, ICallback<CheckPermissionResult> r4) {
        final ICallback r5 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r4, ICallback.class, "com.obric.aiagent.plugin");
        o.e(r3, Ext.KEY_REQUEST);
        o.e(r5, "callback");
        getPermissionProcessor().a(r3, new $$Lambda$PermissionServiceImpl$eqwEdhq1Bvnx6CbFGLL91d3cXrg(r5));
    }

    private static final x checkPermissions$lambda$1(ICallback r2, List r3) {
        ICallback r4 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r2, ICallback.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "permissions");
        r4.onSuccess(new CheckPermissionResult(r5));
        return x.f38692a;
    }

    @Override // com.obric.agent.permission.IPermissionService
    public void requestPermissions(RequestPermissionReq r3, DispatchContext r4, ICallback<RequestPermissionResult> r5) {
        final ICallback r6 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r5, ICallback.class, "com.obric.aiagent.plugin");
        o.e(r3, Ext.KEY_REQUEST);
        o.e(r4, "dispatchContext");
        o.e(r6, "callback");
        getPermissionProcessor().requestPermissions(r3, r4, new $$Lambda$PermissionServiceImpl$gcAUvEkZcM0K9uX4bqxGzkptis(r6));
    }

    private static final x requestPermissions$lambda$2(ICallback r2, RequestPermissionResult r3) {
        ICallback r4 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r2, ICallback.class, "com.obric.aiagent.plugin");
        o.e(r3, "result");
        r4.onSuccess(r3);
        return x.f38692a;
    }

    @Override // com.obric.agent.permission.IPermissionService
    public void updatePermissions(UpdatePermissionReq r3, ICallback<UpdatePermissionResult> r4) {
        final ICallback r5 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r4, ICallback.class, "com.obric.aiagent.plugin");
        o.e(r3, Ext.KEY_REQUEST);
        o.e(r5, "callback");
        getPermissionProcessor().a(r3, new $$Lambda$PermissionServiceImpl$sVWV78IS88F81zDTiSpZ6cSg5HM(r5));
    }

    private static final x updatePermissions$lambda$3(ICallback r2, UpdatePermissionResult r3) {
        ICallback r4 = (ICallback) ZeusTransformUtils.wrapperContextForParams(r2, ICallback.class, "com.obric.aiagent.plugin");
        o.e(r3, "result");
        r4.onSuccess(r3);
        return x.f38692a;
    }
}
