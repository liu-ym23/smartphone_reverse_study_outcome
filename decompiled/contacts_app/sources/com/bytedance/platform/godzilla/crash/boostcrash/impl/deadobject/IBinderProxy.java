package com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject;

import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class IBinderProxy extends MethodProxy {
    private String mService;

    static class QueryLocalInterface extends MethodDelegate {
        private MethodProxy mProxy;

        QueryLocalInterface(MethodProxy r1) {
            this.mProxy = r1;
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object r1, Method r2, Object[] r3) {
            return super.beforeInvoke(r1, r2, r3);
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object afterInvoke(Object r1, Method r2, Object[] r3, Object r4) {
            return ProxyHelper.createProxy(this.mProxy.getTarget(), this.mProxy);
        }
    }

    public IBinderProxy(String r1, MethodProxy r2) {
        this.mService = r1;
        this.mDelegateMethods.put("queryLocalInterface", new QueryLocalInterface(r2));
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        new ServiceManagerHook(this.mService, this).onHook();
    }
}
