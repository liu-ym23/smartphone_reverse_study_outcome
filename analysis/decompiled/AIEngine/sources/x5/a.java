package x5;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.aiengine.R;
import com.stepos.core.common.cloud.AccountTokenProvider$fetch$2$listener$1;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements AccountManagerCallback<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AccountTokenProvider$fetch$2$listener$1 f13741a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f13742b;

    public a(b bVar, AccountTokenProvider$fetch$2$listener$1 accountTokenProvider$fetch$2$listener$1) {
        this.f13742b = bVar;
        this.f13741a = accountTokenProvider$fetch$2$listener$1;
    }

    @Override // android.accounts.AccountManagerCallback
    public final void run(AccountManagerFuture<Bundle> accountManagerFuture) {
        AccountTokenProvider$fetch$2$listener$1 accountTokenProvider$fetch$2$listener$1 = this.f13741a;
        b bVar = this.f13742b;
        Context context = bVar.f13743a;
        String str = null;
        try {
            try {
            } catch (OperationCanceledException unused) {
                String string = context.getString(R.string.get_cancel);
                if (!bVar.f13746d) {
                    accountTokenProvider$fetch$2$listener$1.onError(4, string, null);
                }
            } catch (Exception e10) {
                String string2 = context.getString(R.string.error_is_throwed);
                if (!bVar.f13746d) {
                    accountTokenProvider$fetch$2$listener$1.onError(1, string2, null);
                }
                Log.e("[Cloud]Account.SDK", "[getAuthToken] " + e10.getMessage());
            }
            if (bVar.f13746d) {
                Log.d("[Cloud]Account.SDK", "op canceled.");
                return;
            }
            Bundle result = accountManagerFuture.getResult();
            if (result == null) {
                String string3 = context.getString(R.string.future_result_is_null);
                if (!bVar.f13746d) {
                    accountTokenProvider$fetch$2$listener$1.onError(5, string3, null);
                }
                return;
            }
            if (result.containsKey("authtoken")) {
                String string4 = result.getString("authtoken");
                String string5 = result.getString("authsecret");
                if (!bVar.f13746d) {
                    accountTokenProvider$fetch$2$listener$1.onSuccess(string4, string5);
                }
            } else if (result.containsKey("intent")) {
                Intent intent = (Intent) result.getParcelable("intent");
                if (!bVar.f13746d) {
                    accountTokenProvider$fetch$2$listener$1.onHandleIntent(intent);
                }
            } else if (result.containsKey(BaseConstantsKt.KEY_ERROR_MESSAGE)) {
                try {
                    ArrayList arrayListA = b.a(bVar, result);
                    int iIntValue = ((Integer) arrayListA.get(0)).intValue();
                    String str2 = (String) arrayListA.get(1);
                    String str3 = (String) arrayListA.get(2);
                    if (!TextUtils.isEmpty(str3)) {
                        str = str3;
                    }
                    if (!bVar.f13746d) {
                        accountTokenProvider$fetch$2$listener$1.onError(iIntValue, str2, str);
                    }
                } catch (Exception unused2) {
                }
            } else {
                String string6 = context.getString(R.string.unkown_error);
                if (!bVar.f13746d) {
                    accountTokenProvider$fetch$2$listener$1.onError(11, string6, null);
                }
            }
        } finally {
            b.b(bVar, accountManagerFuture);
        }
    }
}
