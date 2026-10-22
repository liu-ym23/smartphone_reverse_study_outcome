package com.bytedance.android.shopping.deepfeed.utlis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class VolumeBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<WeakReference<i>> f173966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f173967b;

    public static final class a {
    }

    static {
    }

    public VolumeBroadcastReceiver(final Context r100) {
        this.f173966a = new LinkedList();
        this.f173967b = LazyKt.lazy(new VolumeBroadcastReceiver$mAudioManager$2(r100));
    }

    public final void a(Function1<? super WeakReference<i>, Boolean> r100) {
        Iterator<WeakReference<i>> r101 = this.f173966a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r100.invoke(r101.next()).booleanValue() == false) goto L4;
        r101.remove();
        goto L4
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L23;
        String r102 = r101.getAction();
        if (r102 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r102, "android.media.VOLUME_CHANGED_ACTION") == false) goto L25;
        final int r103 = -1;
        if (r101.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3) goto L26;
        AudioManager r104 = (AudioManager) this.f173967b.getValue();     // Catch: Exception -> L13
        if (r104 == null) goto L18;
        r103 = r104.getStreamVolume(3);     // Catch: Exception -> L13
    L18:
        if (r103 < 0) goto L27;
        a(new VolumeBroadcastReceiver$onReceive$1$1(r103));
        return;
    L27:
        return;
    L13:
        e = move-exception;
        String r105 = e.getMessage();
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        ECExceptionMonitor.c(r105);
        goto L18
    L26:
        return;
    L25:
        return;
    }
}
