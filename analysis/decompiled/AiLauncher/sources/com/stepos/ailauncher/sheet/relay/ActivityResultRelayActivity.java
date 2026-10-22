package com.stepos.ailauncher.sheet.relay;

import M5.b;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import i6.C4171a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\bJ)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/sheet/relay/ActivityResultRelayActivity;", "Landroid/app/Activity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onDestroy", Const.INTENT_KEY_APIKEY, "", b.CREDENTIAL_TOKEN, "Ljava/lang/String;", "", "launched", "Z", "Companion", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ActivityResultRelayActivity extends Activity {
    public static final String EXTRA_TARGET = "relay_target";
    public static final String EXTRA_TOKEN = "relay_token";
    private static final int REQUEST_CODE = 23134;
    private static final String STATE_LAUNCHED = "relay_launched";
    private static final String TAG = "ActivityResultRelay";
    private boolean launched;
    private String token;

    public final void a() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != REQUEST_CODE) {
            return;
        }
        Log.i(TAG, "relay result code=" + resultCode + " data=" + (data != null ? data.getData() : null));
        String str = this.token;
        if (str != null) {
            C4171a.INSTANCE.a(str, resultCode, data);
        }
        this.token = null;
        a();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Object objB;
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        String stringExtra = getIntent().getStringExtra(EXTRA_TOKEN);
        this.token = stringExtra;
        Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_TARGET, Intent.class);
        if (stringExtra == null || intent == null) {
            Log.w(TAG, "missing token/target, abort token=" + stringExtra + " target=" + intent);
            a();
            return;
        }
        if (savedInstanceState != null && savedInstanceState.getBoolean(STATE_LAUNCHED)) {
            this.launched = true;
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            startActivityForResult(intent, REQUEST_CODE);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "startActivityForResult failed target=" + intent.getAction(), thE);
            this.token = null;
            C4171a.INSTANCE.a(stringExtra, 0, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        boolean zBooleanValue = ((Boolean) objB).booleanValue();
        this.launched = zBooleanValue;
        if (zBooleanValue) {
            return;
        }
        a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        if (isChangingConfigurations()) {
            super.onDestroy();
            return;
        }
        String str = this.token;
        if (str != null) {
            C4171a.INSTANCE.a(str, 0, null);
        }
        this.token = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        p.i(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_LAUNCHED, this.launched);
    }
}
