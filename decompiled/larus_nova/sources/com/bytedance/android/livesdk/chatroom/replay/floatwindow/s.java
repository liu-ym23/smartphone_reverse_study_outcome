package com.bytedance.android.livesdk.chatroom.replay.floatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes7.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f108714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f108715b;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f108716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s f108717b;

        public a(s r100) {
            this.f108717b = r100;
            this.f108716a = null;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            String r102 = r101.getAction();
            this.f108716a = r102;
            if (this.f108717b.f108715b != null) goto L6;
            return;
        L6:
            if ("android.intent.action.SCREEN_ON".equals(r102) == false) goto L9;
            this.f108717b.f108715b.onScreenOn();
            return;
        L9:
            if ("android.intent.action.SCREEN_OFF".equals(this.f108716a) == false) goto L12;
            this.f108717b.f108715b.onScreenOff();
            return;
        L12:
            if ("android.intent.action.USER_PRESENT".equals(this.f108716a) == false) goto L17;
            this.f108717b.f108715b.onUserPresent();
            return;
        }
    }

    public interface b {
        void onScreenOff();

        void onScreenOn();

        void onUserPresent();
    }

    public s(Context r100) {
        this.f108714a = new a(this);
    }
}
