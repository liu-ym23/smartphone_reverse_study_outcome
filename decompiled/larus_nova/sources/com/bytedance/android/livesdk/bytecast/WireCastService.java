package com.bytedance.android.livesdk.bytecast;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.Random;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/bytecast/WireCastService;", "Landroid/app/Service;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WireCastService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f104407a;

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    public WireCastService() {
        this.f104407a = 160;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 26) goto L20;
        String r104 = getPackageName();
        NotificationChannel r105 = new NotificationChannel(r104, r104, 0);
        r105.setLightColor(FakePickerAvatarCreator.BLUE);
        r105.setLockscreenVisibility(0);
        Object r106 = getSystemService("notification");
        if (r106 == null) goto L19;
        ((NotificationManager) r106).createNotificationChannel(r105);
        NotificationCompat.Builder r107 = new NotificationCompat.Builder(this, r104).setSmallIcon(R.drawable.ttlive_float_icon).setContentTitle("投屏中");
        PendingIntent r108 = PendingIntent.getActivity(getApplicationContext(), 5, r100, 67108864);     // Catch: Throwable -> L11
        if (r108 == null) goto L12;
        r107.setContentIntent(r108);     // Catch: Throwable -> L11
    L12:
        Notification r109 = r107.setPriority(1).setCategory("service").build();
        if (Build.VERSION.SDK_INT >= 33) goto L15;
    L17:
        startForeground(new Random().nextInt(), r109);
    L27:
        return super.onStartCommand(r100, r101, r102);
    L15:
        if (getApplicationInfo().targetSdkVersion < 33) goto L17;
        startForeground(new Random().nextInt(), r109, this.f104407a);
        goto L27
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
    L20:
        Notification r110 = new Notification.Builder(getApplicationContext()).build();
        if (r103 >= 33) goto L23;
    L25:
        startForeground(new Random().nextInt(), r110);
        goto L27
    L23:
        if (getApplicationInfo().targetSdkVersion < 33) goto L25;
        startForeground(new Random().nextInt(), r110, this.f104407a);
        goto L27
    }
}
