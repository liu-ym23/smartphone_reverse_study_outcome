package com.android.server.wm;

import android.os.IBinder;
import android.view.IDisplayMirrorWindow;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayMirrorWMHook {

    public static class WindowState {
        com.android.server.wm.WindowState mHost;
        private IDisplayMirrorWindow mMirrorClient;

        public WindowState(Object win) {
            this.mHost = null;
            this.mMirrorClient = null;
            this.mHost = (com.android.server.wm.WindowState) win;
        }

        public void release() {
            this.mHost = null;
            this.mMirrorClient = null;
        }

        public void setHost(Object win) {
            this.mHost = (com.android.server.wm.WindowState) win;
            this.mMirrorClient = null;
        }

        public void setMirrorClient(IDisplayMirrorWindow win) {
            this.mMirrorClient = win;
        }

        public IDisplayMirrorWindow getMirrorClient() {
            return this.mMirrorClient;
        }

        public boolean executeCommand(String command, String param) {
            this.mHost.mClient.executeCommand(command, param, null);     // Catch: Exception -> L5
            return true;
        L5:
            e = move-exception;
            e.printStackTrace();
            return false;
        }

        public boolean isClientSame(IBinder token) {
            if (this.mHost.mClient.asBinder() != token) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean equals(Object win) {
            if (this.mHost != win) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return this.mHost.toString();
        }
    }

    public DisplayMirrorWMHook() {
    }
}
