package com.stepos.alphame.apprequest;

import U1.a;
import android.content.Context;
import android.util.Log;
import b2.C0366a;
import com.stepos.alphame.utils.DeviceInfoKt;
import d2.C0537b;
import d2.c;
import d2.d;
import d2.f;
import d2.g;

/* loaded from: classes.dex */
public class MyPushMsgReceiver extends a {
    private static final String TAG = "AlphamePushMsgReceiver";

    @Override // e2.b
    public void onMessage(Context context, String str, String str2) {
        Log.d(TAG, "push  config is " + str + "     " + str2);
    }

    @Override // e2.b
    public void onNotificationArrived(Context context, C0366a c0366a) {
    }

    @Override // e2.b
    public void onNotificationClicked(Context context, C0366a c0366a) {
    }

    @Override // e2.b
    public void onPushStatus(Context context, C0537b c0537b) {
    }

    @Override // e2.b
    public void onRegisterStatus(Context context, c cVar) {
        Log.d(TAG, "pushId is " + cVar.f12422d);
        Log.d(TAG, "oaid is " + DeviceInfoKt.getOaid());
    }

    @Override // e2.b
    public void onSubAliasStatus(Context context, d dVar) {
    }

    @Override // e2.b
    public void onSubTagsStatus(Context context, f fVar) {
    }

    @Override // e2.b
    public void onUnRegisterStatus(Context context, g gVar) {
    }
}
