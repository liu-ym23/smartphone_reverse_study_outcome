package com.obric.funcall_impl;

import android.graphics.Bitmap;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.capabilitykit.common.Ext;
import com.obric.funcall_api.IIntentActionService;
import com.obric.funcall_api.OnAppActionListener;
import com.obric.funcall_api.bean.AppActionRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.o;
import d.x;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IntentActionServiceImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IntentActionServiceImpl implements IIntentActionService {
    public IntentActionServiceImpl() {
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void init() {
        AppActionHandler.INSTANCE.init();
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void sendAppAction(AppActionRequest r2, m<? super Boolean, ? super String, x> r3) {
        m<? super Boolean, ? super String, x> r1 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        o.e(r2, Ext.KEY_REQUEST);
        AppActionHandler.INSTANCE.sendAppAction(r2, r1);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void cacheScreenshot(Bitmap r2, Map<String, String> r3) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "bitmap");
        o.e(r1, "headers");
        AppActionHandler.INSTANCE.cacheScreenshot(r2, r1);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void sendAppActionForCompensationByHttp(List<AppActionRequest> r2, boolean r3, q<? super Boolean, ? super String, ? super Map<String, String>, x> r4) {
        List<AppActionRequest> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        q<? super Boolean, ? super String, ? super Map<String, String>, x> r5 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        o.e(r1, "requests");
        AppActionHandler.INSTANCE.sendAppActionForCompensationByHttp(r1, r3, r5);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void sendAppActionForAsyncNotifyByHttp(List<AppActionRequest> r2, boolean r3, q<? super Boolean, ? super String, ? super Map<String, String>, x> r4) {
        List<AppActionRequest> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        q<? super Boolean, ? super String, ? super Map<String, String>, x> r5 = (q) ZeusTransformUtils.wrapperContextForParams(r4, q.class, "com.obric.aiagent.plugin");
        o.e(r1, "requests");
        AppActionHandler.INSTANCE.sendAppActionForAsyncNotifyByHttp(r1, r3, r5);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void sendNormalRouterByHttp(String r2, String r3, boolean r4, m<? super Boolean, ? super String, x> r5) {
        m<? super Boolean, ? super String, x> r1 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.aiagent.plugin");
        o.e(r2, DBHelper.BATTERY_COL_SCENE);
        o.e(r3, "passThrough");
        AppActionHandler.INSTANCE.sendNormalRouterByHttp(r2, r3, r4, r1);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void replyAskUserUploadByHttp(String r8, String r9, String r10, Map<?, ?> r11, m<? super Boolean, ? super String, x> r12) {
        Map<?, ?> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        m<? super Boolean, ? super String, x> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.aiagent.plugin");
        AppActionHandler.INSTANCE.replyAskUserUploadByHttp(r8, r9, r10, r5, r6);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void registerAppActionListener(OnAppActionListener r2) {
        OnAppActionListener r1 = (OnAppActionListener) ZeusTransformUtils.wrapperContextForParams(r2, OnAppActionListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        AppActionDispatcher.INSTANCE.registerAppActionListener(r1);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void unRegisterAppActionListener(OnAppActionListener r2) {
        OnAppActionListener r1 = (OnAppActionListener) ZeusTransformUtils.wrapperContextForParams(r2, OnAppActionListener.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        AppActionDispatcher.INSTANCE.unRegisterAppActionListener(r1);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void notifyUserTakeOverByHttp(String r11, String r12, String r13, long r14, Map<String, String> r16, m<? super Boolean, ? super String, x> r17) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r16, Map.class, "com.obric.aiagent.plugin");
        m<? super Boolean, ? super String, x> r9 = (m) ZeusTransformUtils.wrapperContextForParams(r17, m.class, "com.obric.aiagent.plugin");
        o.e(r13, DBHelper.BATTERY_COL_SCENE);
        AppActionHandler.INSTANCE.uploadUserTakeOverByHttp(r11, r12, r13, r14, r8, r9);
    }

    @Override // com.obric.funcall_api.IIntentActionService
    public void notifyUserOperateQueue(String r2, m<? super Boolean, ? super String, x> r3) {
        m<? super Boolean, ? super String, x> r1 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        o.e(r2, "data");
        AppActionHandler.INSTANCE.notifyUserOperateQueue(r2, r1);
    }
}
