package C4;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import kotlin.jvm.internal.k;
import o9.C1785k;
import o9.InterfaceC1786l;

/* loaded from: classes3.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f293a;
    public final /* synthetic */ String b;
    public final /* synthetic */ InterfaceC1786l c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, String str, InterfaceC1786l interfaceC1786l, Handler handler) {
        super(handler);
        this.f293a = context;
        this.b = str;
        this.c = interfaceC1786l;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10, Uri uri) {
        Context context = this.f293a;
        k.c(context);
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("voice_wakeup_permission", 0);
        String str = this.b;
        boolean z11 = sharedPreferences.getBoolean("consent_".concat(str), false);
        Log.i("VoicePermissionStorage", "isGranted userId=" + str + " granted=" + z11);
        Log.i("VoicePermissionStorage", "observeGranted onChange userId=" + str + " granted=" + z11);
        ((C1785k) this.c).a(Boolean.valueOf(z11));
    }
}
