package com.android.server.wm;

import android.view.IWindowSessionSmtEx;
import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes3.dex */
public class SessionSmtBase {
    private IWindowSessionSmtEx mIWindowSessionSmtEx;
    protected Session mSession;

    protected abstract class IWindowSessionSmtExBase extends IWindowSessionSmtEx.Stub {
        final /* synthetic */ SessionSmtBase this$0;

        protected IWindowSessionSmtExBase(SessionSmtBase this$0) {
            this.this$0 = this$0;
        }

        public void updateVisibleSurfaceViewArea(int pid, int width, int height, boolean currentVisible) {
            this.this$0.updateVisibleSurfaceViewArea(pid, width, height, currentVisible);
        }

        public void onSurfaceViewVisibilityChanged(int pid, int visibility) {
            this.this$0.onSurfaceViewVisibilityChanged(pid, visibility);
        }
    }

    public SessionSmtBase(Session session) {
        this.mIWindowSessionSmtEx = new SessionSmtEx.IWindowSessionSmtExImpl((SessionSmtEx) this);
        this.mSession = session;
    }

    public void updateVisibleSurfaceViewArea(int pid, int width, int height, boolean currentVisible) {
        SysOptBridge.getFactory().getSmartService().updateFocusSurfaceViewArea(pid, width, height, currentVisible);
    }

    public void onSurfaceViewVisibilityChanged(int pid, int visibility) {
        SysOptBridge.getFactory().getSmartService().onSurfaceViewVisibilityChanged(pid, visibility);
    }

    IWindowSessionSmtEx getISmtEx() {
        return this.mIWindowSessionSmtEx;
    }
}
