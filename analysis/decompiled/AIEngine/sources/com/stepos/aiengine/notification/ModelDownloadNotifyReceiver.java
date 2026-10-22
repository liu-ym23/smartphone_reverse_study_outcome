package com.stepos.aiengine.notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.OtaModelClient;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.notification.ModelDownloadNotifyOp;
import com.stepos.core.common.notification.NotificationDismissStore;
import com.stepos.core.ota.OtaDispatcher;
import com.stepos.core.ota.process.OtaRuntime;
import h0.e;
import h6.r;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDownloadNotifyReceiver extends BroadcastReceiver {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5908a;

        static {
            int[] iArr = new int[ModelDownloadNotifyOp.values().length];
            try {
                iArr[ModelDownloadNotifyOp.DISMISS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModelDownloadNotifyOp.OPEN_MODEL_MANAGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ModelDownloadNotifyOp.NETWORK_SETTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ModelDownloadNotifyOp.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ModelDownloadNotifyOp.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ModelDownloadNotifyOp.CONTINUE_DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ModelDownloadNotifyOp.CONTINUE_WITH_MOBILE_DATA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ModelDownloadNotifyOp.RETRY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f5908a = iArr;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Object objA;
        g.f(context, "context");
        g.f(intent, "intent");
        if (g.b(intent.getAction(), ModelDownloadNotifier.RECEIVER_ACTION)) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                Log.e("ModelDownloadNotifyReceiver", "onReceive: empty extras");
                return;
            }
            int i10 = extras.getInt(ModelDownloadNotifier.EXTRA_OP, -1);
            int i11 = extras.getInt(ModelDownloadNotifier.EXTRA_NOTIF_ID, -1);
            String string = extras.getString(ModelDownloadNotifier.EXTRA_MODEL_TYPE);
            if (string == null) {
                return;
            }
            StringBuilder sbF = e.f("onReceive: modelType=", string, " op=", i10, " id=");
            sbF.append(i11);
            Log.i("ModelDownloadNotifyReceiver", sbF.toString());
            ModelDownloadNotifyOp modelDownloadNotifyOp = (ModelDownloadNotifyOp) kotlin.collections.a.w0(i10, ModelDownloadNotifyOp.getEntries());
            if (modelDownloadNotifyOp == null) {
                return;
            }
            int[] iArr = a.f5908a;
            int i12 = iArr[modelDownloadNotifyOp.ordinal()];
            if (i12 == 1) {
                NotificationDismissStore.INSTANCE.markDismissed(string);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                if (notificationManager != null) {
                    notificationManager.cancel(i11);
                }
                Toast.makeText(context.getApplicationContext(), R.string.mm_notif_dismissed_toast, 1).show();
                return;
            }
            if (i12 == 2) {
                NotificationManager notificationManager2 = (NotificationManager) context.getSystemService(NotificationManager.class);
                if (notificationManager2 != null) {
                    notificationManager2.cancel(i11);
                }
                Intent intentA = r.a(context, null, 6);
                intentA.addFlags(335544320);
                intentA.putExtra(ModelDownloadNotifier.EXTRA_DISMISS_NOTIF_ID, i11);
                context.startActivity(intentA);
                return;
            }
            if (i12 != 3) {
                int i13 = iArr[modelDownloadNotifyOp.ordinal()];
                if (i13 == 6) {
                    OtaModelClient.f5871a.h(context, string, false, false);
                    return;
                }
                if (i13 == 7) {
                    OtaModelClient.f5871a.h(context, string, false, true);
                    return;
                }
                if (i13 == 8) {
                    OtaModelClient.f5871a.h(context, string, true, false);
                    return;
                }
                try {
                    if (modelDownloadNotifyOp == ModelDownloadNotifyOp.CANCEL) {
                        Context applicationContext = context.getApplicationContext();
                        g.e(applicationContext, "getApplicationContext(...)");
                        new ModelDownloadNotifier(applicationContext).dismissForModel(string);
                    }
                    OtaDispatcher otaDispatcherDispatcher = OtaRuntime.INSTANCE.dispatcher();
                    int i14 = iArr[modelDownloadNotifyOp.ordinal()];
                    objA = i14 != 4 ? i14 != 5 ? n.f10413a : Boolean.valueOf(otaDispatcherDispatcher.cancel(string)) : Boolean.valueOf(OtaDispatcher.DefaultImpls.pause$default(otaDispatcherDispatcher, string, null, 2, null));
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    a0.a.A("route failed: ", thB.getMessage(), "ModelDownloadNotifyReceiver");
                }
            }
        }
    }
}
