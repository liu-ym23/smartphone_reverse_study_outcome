package com.bytedance.android.livesdk.action;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public class ActionHandler {
    public static final String ACTION_CALLBACK = "action_callback";
    private boolean isDebug;
    private List<LiveActionInfo> mCurrentAction;
    private Map<String, LiveActionInfo> mMethodMap;

    public class DefaultActionCallback implements BaseActionMethod.Callback<Object> {
        private String mCallbackString;
        final /* synthetic */ ActionHandler this$0;

        @Override // com.bytedance.android.livesdk.action.BaseActionMethod.Callback
        public void onFail(Throwable r100) {
        }

        @Override // com.bytedance.android.livesdk.action.BaseActionMethod.Callback
        public void onSuccess(Object r100) {
            if (TextUtils.isEmpty(this.mCallbackString) == false) goto L11;
            this.this$0.handleAction(this.mCallbackString);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        public DefaultActionCallback(ActionHandler r100, String r101) {
            this.this$0 = r100;
            this.mCallbackString = r101;
        }
    }

    public void clear() {
        Iterator<LiveActionInfo> r100 = this.mCurrentAction.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getActionMethod().terminate();
        goto L4
    L6:
        this.mCurrentAction.clear();
    }

    public ActionHandler() {
        this.mMethodMap = new ConcurrentHashMap();
        LocalTestManager.a(new Class[]{wy.a.class});
        this.isDebug = false;
        this.mCurrentAction = new ArrayList();
    }

    public static /* synthetic */ List access$000(ActionHandler r100) {
        return r100.mCurrentAction;
    }

    public boolean canHandle(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L16;
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L11;
        return false;
    L11:
        if (this.mMethodMap.get(r101.getHost()) == null) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public void handleAction(String r100) throws Exception {
        handleAction(r100, null);
    }

    public void registerActionMethod(BaseActionMethod r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LiveActionInfo r101 = new LiveActionInfo(r100);
        DebugUtils.i(r101.getActionName() + " register " + r100.toString());
        this.mMethodMap.put(r101.getActionName(), new LiveActionInfo(r100));
    }

    public void unregisterAction(String r100) {
        LiveActionInfo r101 = this.mMethodMap.remove(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getActionMethod() == null) goto L9;
        DebugUtils.i(r101.getActionName() + " unregister");
        r101.getActionMethod().terminate();
        return;
    }

    public void handleAction(String r100, final BaseActionMethod.Callback r101) throws Exception {
        if (r100 != null) goto L9;
        if (this.isDebug == true) goto L7;
        return;
    L7:
        throw new Exception("action can not be null");
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Uri r102 = UriProtector.parse(r100);
        if (r102 != null) goto L18;
        return;
    L18:
        final LiveActionInfo r103 = this.mMethodMap.get(r102.getHost());
        if (r103 == null) goto L21;
        String r104 = UriProtector.getQueryParameter(r102, ACTION_CALLBACK);
        if (r101 == null) goto L28;
    L30:
        this.mCurrentAction.add(r103);
        BaseActionMethod r105 = r103.getActionMethod();
        if (r101 != null) goto L33;
        r105.invokeWithCallback(r100, null);
        this.mCurrentAction.remove(r103);
        return;
    L33:
        r105.invokeWithCallback(r100, new AnonymousClass1(this, r101, r103));
        return;
    L28:
        if (TextUtils.isEmpty(r100) == true) goto L30;
        r101 = new DefaultActionCallback(this, r104);
        goto L30
    L21:
        if (this.isDebug == true) goto L24;
        return;
    L24:
        throw new Exception("can't find action");
    L11:
        if (this.isDebug == true) goto L14;
        return;
    L14:
        throw new Exception("action name can not be null");
    }
}
