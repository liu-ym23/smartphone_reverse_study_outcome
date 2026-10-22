package com.bytedance.android.shopping.anchorv4.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class VolumeBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<WeakReference<h>> f167528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f167529b;

    public static final class a {
    }

    static {
    }

    public VolumeBroadcastReceiver(final Context r100) {
        this.f167528a = new LinkedList();
        this.f167529b = LazyKt.lazy(new VolumeBroadcastReceiver$mAudioManager$2(r100));
    }

    public final void a(Function1<? super WeakReference<h>, Boolean> r100) {
        Iterator<WeakReference<h>> r101 = this.f167528a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (r100.invoke(r101.next()).booleanValue() == false) goto L4;
        r101.remove();
        goto L4
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L18;
        String r102 = r101.getAction();
        if (r102 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r102, "android.media.VOLUME_CHANGED_ACTION") == false) goto L20;
        final int r103 = -1;
        if (r101.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3) goto L21;
        AudioManager r104 = (AudioManager) this.f167529b.getValue();     // Catch: Exception -> L15
        if (r104 == null) goto L12;
        r103 = r104.getStreamVolume(3);     // Catch: Exception -> L15
    L12:
        if (r103 < 0) goto L22;
        a(new VolumeBroadcastReceiver$onReceive$1$1(r103));
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }
}
