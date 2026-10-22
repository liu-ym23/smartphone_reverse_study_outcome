package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.internal.InterfaceC1642h;

/* renamed from: com.google.android.gms.common.internal.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractDialogInterfaceOnClickListenerC1681w implements DialogInterface.OnClickListener {
    public static AbstractDialogInterfaceOnClickListenerC1681w b(Activity activity, Intent intent, int i10) {
        return new C1679u(intent, activity, i10);
    }

    public static AbstractDialogInterfaceOnClickListenerC1681w c(InterfaceC1642h interfaceC1642h, Intent intent, int i10) {
        return new C1680v(intent, interfaceC1642h, 2);
    }

    public abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e10) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e10);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
