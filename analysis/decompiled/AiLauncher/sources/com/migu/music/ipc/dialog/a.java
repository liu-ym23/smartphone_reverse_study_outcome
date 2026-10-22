package com.migu.music.ipc.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.util.Log;
import com.migu.music.ipc.dialog.MusicIpcCheckDialog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static long f21928a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference<WeakReference<MusicIpcCheckDialog>> f21929b = new AtomicReference<>();

    /* renamed from: c, reason: collision with root package name */
    public static WeakReference<Activity> f21930c;

    public static /* synthetic */ void a(DialogInterface dialogInterface) {
        f21929b.set(null);
        f21930c = null;
        f21928a = 0L;
        Log.w("MiguSDKDialogManager", "showDialog: Dialog 已关闭，清理引用");
    }

    public static void b() {
        AtomicReference<WeakReference<MusicIpcCheckDialog>> atomicReference = f21929b;
        WeakReference<MusicIpcCheckDialog> weakReference = atomicReference.get();
        if (weakReference == null) {
            return;
        }
        MusicIpcCheckDialog musicIpcCheckDialog = weakReference.get();
        if (musicIpcCheckDialog == null) {
            atomicReference.set(null);
            return;
        }
        try {
            if (musicIpcCheckDialog.isShowing()) {
                Log.w("MiguSDKDialogManager", "dismissExistingDialog: 关闭旧 Dialog，准备弹新的");
                musicIpcCheckDialog.dismiss();
            }
        } catch (Exception unused) {
        }
        f21929b.set(null);
    }

    public static boolean c(Activity activity) {
        AtomicReference<WeakReference<MusicIpcCheckDialog>> atomicReference = f21929b;
        WeakReference<MusicIpcCheckDialog> weakReference = atomicReference.get();
        if (weakReference == null) {
            return false;
        }
        MusicIpcCheckDialog musicIpcCheckDialog = weakReference.get();
        if (musicIpcCheckDialog == null) {
            atomicReference.set(null);
            f21930c = null;
            return false;
        }
        if (!musicIpcCheckDialog.isShowing()) {
            return false;
        }
        WeakReference<Activity> weakReference2 = f21930c;
        return (weakReference2 != null ? weakReference2.get() : null) == activity;
    }

    public static void d(Activity activity, MusicIpcCheckDialog.DialogType dialogType) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("showDialog: activity=");
        if (activity != null) {
            str = activity.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(activity));
        } else {
            str = "null";
        }
        sb2.append(str);
        sb2.append(", dialogType=");
        sb2.append(dialogType != null ? dialogType.name() : "null");
        Log.w("MiguSDKDialogManager", sb2.toString());
        Log.w("MiguSDKDialogManager", "showDialog: callStack", new Throwable("showDialog call stack"));
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            Log.w("MiguSDKDialogManager", "showDialog: Activity 无效，跳过弹窗");
            return;
        }
        if (SystemClock.elapsedRealtime() - f21928a < 1000) {
            Log.w("MiguSDKDialogManager", "showDialog: 点击过于频繁，忽略本次弹窗");
            return;
        }
        if (dialogType == null) {
            Log.w("MiguSDKDialogManager", "showDialog: DialogType 为空，不弹窗");
            return;
        }
        if (c(activity)) {
            Log.w("MiguSDKDialogManager", "showDialog: 同一 Activity 已有 Dialog 显示中，跳过");
            return;
        }
        b();
        try {
            MusicIpcCheckDialog musicIpcCheckDialog = new MusicIpcCheckDialog(activity);
            f21929b.set(new WeakReference<>(musicIpcCheckDialog));
            f21930c = new WeakReference<>(activity);
            musicIpcCheckDialog.setCancelable(true);
            musicIpcCheckDialog.h(dialogType).i(new DialogInterface.OnDismissListener() { // from class: N3.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    com.migu.music.ipc.dialog.a.a(dialogInterface);
                }
            }).show();
            f21928a = SystemClock.elapsedRealtime();
            Log.w("MiguSDKDialogManager", "showDialog: 弹窗已显示");
        } catch (Exception e10) {
            Log.e("MiguSDKDialogManager", "showDialog: 弹窗显示异常", e10);
            f21929b.set(null);
            f21930c = null;
            f21928a = 0L;
        }
    }
}
