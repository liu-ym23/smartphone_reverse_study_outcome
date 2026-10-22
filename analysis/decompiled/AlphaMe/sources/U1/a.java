package U1;

import X.l;
import a2.AbstractC0155a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b2.C0366a;
import c2.AbstractC0392b;
import e2.b;

/* loaded from: classes.dex */
public abstract class a extends BroadcastReceiver implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f1910a = 0;
    private final String tag = getClass().getSimpleName();

    public void onNotificationDeleted(Context context, C0366a c0366a) {
        AbstractC0155a.b(this.tag, "onNotificationDeleted, PushMessage: " + c0366a);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        AbstractC0155a.b(this.tag, "onReceive intent: " + intent);
        AbstractC0392b.f4467a.execute(new l(3, this, context, intent));
    }
}
