package x5;

import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.aiengine.R;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13743a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13744b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13745c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13746d;

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r3) {
        /*
            r2 = this;
            android.content.ContentResolver r0 = r3.getContentResolver()
            java.lang.String r1 = "net_env"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r1)
            r2.<init>()
            java.lang.String r1 = "basic"
            android.text.TextUtils.isEmpty(r1)
            android.content.Context r3 = r3.getApplicationContext()
            r2.f13743a = r3
            r2.f13744b = r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.f13745c = r3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "https://i."
            r2.<init>(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L67
            r0.getClass()
            int r3 = r0.hashCode()
            r1 = -1
            switch(r3) {
                case 99349: goto L50;
                case 114214: goto L45;
                case 3556498: goto L3a;
                default: goto L39;
            }
        L39:
            goto L5a
        L3a:
            java.lang.String r3 = "test"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L43
            goto L5a
        L43:
            r1 = 2
            goto L5a
        L45:
            java.lang.String r3 = "stg"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L4e
            goto L5a
        L4e:
            r1 = 1
            goto L5a
        L50:
            java.lang.String r3 = "dev"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L59
            goto L5a
        L59:
            r1 = 0
        L5a:
            switch(r1) {
                case 0: goto L64;
                case 1: goto L61;
                case 2: goto L5e;
                default: goto L5d;
            }
        L5d:
            goto L67
        L5e:
            java.lang.String r3 = "t-stepaos.com"
            goto L69
        L61:
            java.lang.String r3 = "s-stepaos.com"
            goto L69
        L64:
            java.lang.String r3 = "d-stepaos.com"
            goto L69
        L67:
            java.lang.String r3 = "stepaos.com"
        L69:
            java.lang.String r1 = "/uc/oauth/member/getBasicInfo"
            java.lang.String r2 = ai.onnxruntime.a.o(r2, r3, r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r1 = "env: "
            r3.<init>(r1)
            r3.append(r0)
            java.lang.String r0 = ", url: "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "[Cloud]Account.SDK"
            android.util.Log.i(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x5.b.<init>(android.content.Context):void");
    }

    public static ArrayList a(b bVar, Bundle bundle) {
        String str = bVar.f13744b;
        Context context = bVar.f13743a;
        ArrayList arrayList = new ArrayList();
        String string = bundle.getString(BaseConstantsKt.KEY_ERROR_MESSAGE);
        int i10 = bundle.containsKey(BaseConstantsKt.KEY_ERROR_CODE) ? bundle.getInt(BaseConstantsKt.KEY_ERROR_CODE) : -1;
        String string2 = bundle.containsKey("cacheAccountName") ? bundle.getString("cacheAccountName") : null;
        if (i10 >= 0) {
            arrayList.add(Integer.valueOf(i10));
            arrayList.add(string);
        } else if ("params not legal!".equalsIgnoreCase(string)) {
            arrayList.add(7);
            arrayList.add(context.getString(R.string.context_is_null));
        } else if ("get token failed!".equalsIgnoreCase(string)) {
            arrayList.add(2);
            arrayList.add(context.getString(R.string.get_token_failed));
        } else {
            if (("unknown type : " + str).equalsIgnoreCase(string)) {
                arrayList.add(8);
                arrayList.add(String.format(context.getString(R.string.scope_null_token), str));
            } else if (!TextUtils.isEmpty(string) && string.startsWith("uid =") && string.contains("not match package")) {
                arrayList.add(9);
                arrayList.add(context.getString(R.string.uid_not_match));
            } else {
                arrayList.add(3);
                arrayList.add(string);
            }
        }
        if (string2 == null) {
            string2 = "";
        }
        arrayList.add(string2);
        return arrayList;
    }

    public static void b(b bVar, AccountManagerFuture accountManagerFuture) {
        synchronized (bVar.f13745c) {
            bVar.f13745c.remove(accountManagerFuture);
        }
    }

    public final void c() {
        this.f13746d = true;
        try {
            synchronized (this.f13745c) {
                try {
                    ArrayList arrayList = this.f13745c;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        ((AccountManagerFuture) obj).cancel(true);
                    }
                    this.f13745c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e10) {
            Log.e("[Cloud]Account.SDK", "cancel error", e10);
        }
    }
}
