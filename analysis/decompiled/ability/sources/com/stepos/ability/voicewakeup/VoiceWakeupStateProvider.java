package com.stepos.ability.voicewakeup;

import C7.r;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.voicewakeup.service.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ability/voicewakeup/VoiceWakeupStateProvider;", "Landroid/content/ContentProvider;", AppAgent.CONSTRUCT, "()V", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceWakeupStateProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final Bundle call(String method, String str, Bundle bundle) {
        k.f(method, "method");
        final Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("Required value was null.");
        }
        context.enforceCallingOrSelfPermission("com.stepos.ability.permission.CONTROL_VOICE_WAKEUP", "Only platform-signed callers may control voice wakeup");
        if (!method.equals("set_amoo_enabled")) {
            throw new IllegalArgumentException("Unknown method: ".concat(method).toString());
        }
        Object obj = bundle != null ? bundle.get("enabled") : null;
        if (!(obj instanceof Boolean)) {
            throw new IllegalArgumentException("enabled must be a Boolean");
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            Bundle bundle2 = new Bundle();
            l lVar = l.f3333a;
            final boolean zBooleanValue = ((Boolean) obj).booleanValue();
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            l.o(true, new S7.a() { // from class: com.stepos.ability.voicewakeup.service.j
                @Override // S7.a
                public final Object invoke() {
                    Context context2 = context;
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    boolean z10 = zBooleanValue;
                    if (l.p == null) {
                        l.p = new C4.a(context2);
                    }
                    C4.a aVar = l.p;
                    if (aVar != null) {
                        boolean enabled = aVar.setEnabled(z10);
                        ref$BooleanRef2.f4916a = enabled;
                        if (l.n == null) {
                            Log.i("VoiceWakeupController", "amoo state saved before init: enabled=" + z10 + " saved=" + enabled);
                        } else {
                            l lVar2 = l.f3333a;
                            boolean z11 = l.k() && ((E4.e) l.e().c).b();
                            k kVarG = l.g();
                            if (kVarG.f3332a != z11) {
                                l.v(z11);
                            }
                            if (!z11 || !kVarG.f3332a || !l.f3337s) {
                                lVar2.l();
                            }
                            Log.i("VoiceWakeupController", "amoo state: enabled=" + z10 + " saved=" + ref$BooleanRef2.f4916a + " allowed=" + z11 + " running=" + l.f3334j);
                        }
                    }
                    return r.f317a;
                }
            });
            bundle2.putBoolean("success", ref$BooleanRef.f4916a);
            return bundle2;
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        k.f(uri, "uri");
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        k.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        k.f(uri, "uri");
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        k.f(uri, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        k.f(uri, "uri");
        throw new UnsupportedOperationException();
    }
}
