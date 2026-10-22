package com.android.server.wm;

import android.graphics.Rect;
import android.os.Parcel;
import android.view.FooDisplayResultInfo;
import android.view.IWindow;
import bytedanceos.util.SidebarHelper;

/* JADX INFO: loaded from: classes3.dex */
public class SessionSmtEx extends SessionSmtBase {

    protected final class IWindowSessionSmtExImpl extends SessionSmtBase.IWindowSessionSmtExBase {
        final /* synthetic */ SessionSmtEx this$0;

        protected IWindowSessionSmtExImpl(SessionSmtEx this$0) {
            this.this$0 = this$0;
            super(this$0);
        }

        public void updateNotchState(IWindow window, int notchState) {
            this.this$0.updateNotchState(window, notchState);
        }

        public void reportFooResult(FooDisplayResultInfo fdri) {
            this.this$0.reportFooResult(fdri);
        }

        public void getThumbModeCrop(Rect outCrop) {
            this.this$0.getThumbModeCrop(outCrop);
        }

        public void resetWindowStateFromThumbMode() {
            this.this$0.resetWindowStateFromThumbMode();
        }

        public boolean isInTopDownMode() {
            return this.this$0.isInTopDownMode();
        }

        public boolean isInSideBarMode() {
            return this.this$0.isInSideBarMode();
        }

        public boolean isInThumbMode() {
            return this.this$0.isInThumbMode();
        }

        public boolean requestTouchFocus(IWindow window) {
            return this.this$0.requestTouchFocus(window);
        }
    }

    public SessionSmtEx(Session session) {
        super(session);
    }

    public boolean onTransactSmtEx(int code, Parcel data, Parcel reply, int flags) {
        return false;
    }

    public void reportFooResult(FooDisplayResultInfo fdri) {
    }

    public void updateNotchState(IWindow window, int notchState) {
    }

    public void getThumbModeCrop(Rect outCrop) {
        SidebarHelper.getInstance().getSidebarRect(outCrop);
    }

    public void resetWindowStateFromThumbMode() {
    }

    public boolean isInTopDownMode() {
        return false;
    }

    public boolean isInSideBarMode() {
        Object r0 = this.mSession.mService.getWindowManagerLock();
        monitor-enter(r0);
        boolean r1 = SidebarHelper.getInstance().isSidebarShow();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isInThumbMode() {
        return false;
    }

    public boolean requestTouchFocus(IWindow window) {
        return false;
    }
}
