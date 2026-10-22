package com.bytedance.android.live.liveinteract.plantform.permission;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.Metadata;
import qh0.c;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/permission/ILinkPermissionCheckerFactoryService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/liveinteract/plantform/permission/model/OperateType;", "operateType", "", "linkType", "Lqh0/c;", "createDyliteChecker", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkPermissionCheckerFactoryService extends IService {
    c createDyliteChecker(OperateType r100, int r101);
}
