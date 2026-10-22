package com.obric.agent.permission;

import com.obric.agent.permission.bean.CheckPermissionReq;
import com.obric.agent.permission.bean.CheckPermissionResult;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.agent.permission.bean.UpdatePermissionReq;
import com.obric.agent.permission.bean.UpdatePermissionResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IPermissionService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IPermissionService {
    public static final a Companion = null;

    /* JADX INFO: compiled from: IPermissionService.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f15392a = null;

        static {
            f15392a = new a();
        }

        private a() {
        }

        public final IPermissionService a() {
            return (IPermissionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPermissionService.class), IPermissionService.class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = a.f15392a;
    }

    void checkPermissions(CheckPermissionReq r1, ICallback<CheckPermissionResult> r2);

    void requestPermissions(RequestPermissionReq r1, DispatchContext r2, ICallback<RequestPermissionResult> r3);

    void updatePermissions(UpdatePermissionReq r1, ICallback<UpdatePermissionResult> r2);
}
