package com.stepos.ailauncher.taskstore.livenotification;

import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.R$id;
import com.stepos.ailauncher.taskstore.R$layout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "capsule", "", "leftIconRes", "rightIconRes", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroid/os/Bundle;II)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3716d {
    public static final C3716d INSTANCE = new C3716d();

    public final void a(Context context, Bundle capsule, int leftIconRes, int rightIconRes) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(capsule, "capsule");
        String packageName = context.getPackageName();
        int i10 = R$layout.taskstore_live_capsule_remote_icon;
        RemoteViews remoteViews = new RemoteViews(packageName, i10);
        int i11 = R$id.capsule_remote_icon;
        remoteViews.setImageViewResource(i11, leftIconRes);
        Y8.t tVar = Y8.t.f7040a;
        capsule.putParcelable("notification.live.capsule.remote.view.left", remoteViews);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), i10);
        remoteViews2.setImageViewResource(i11, rightIconRes);
        capsule.putParcelable("notification.live.capsule.remote.view.right", remoteViews2);
    }
}
