package w2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* renamed from: w2.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5723g extends androidx.core.content.a {
    @ResultIgnorabilityUnspecified
    @Deprecated
    public static Intent n(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (C5722f.a()) {
            return context.registerReceiver(broadcastReceiver, intentFilter, true != C5722f.a() ? 0 : 2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
