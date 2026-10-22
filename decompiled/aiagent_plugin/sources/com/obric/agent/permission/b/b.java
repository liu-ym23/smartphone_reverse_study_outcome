package com.obric.agent.permission.b;

import com.obric.agent.permission.bean.CheckPermissionReq;
import com.obric.agent.permission.bean.Permission;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.agent.permission.bean.UpdatePermissionReq;
import com.obric.capabilitykit.common.DispatchContext;
import java.util.List;

/* JADX INFO: compiled from: IPermissionProtocol.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface b {
    List<Permission> a(CheckPermissionReq r1);

    void a(UpdatePermissionReq r1);

    RequestPermissionResult requestPermissions(RequestPermissionReq r1, DispatchContext r2);
}
