package com.stepos.ability.screenops.service;

import D7.A;
import D7.w;
import Y7.e;
import Y7.f;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import s9.C1923c;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ability/screenops/service/RegistrationReceiver;", "Landroid/content/BroadcastReceiver;", AppAgent.CONSTRUCT, "()V", "screenops_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RegistrationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra;
        String stringExtra2;
        k.f(context, "context");
        k.f(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -2136064932) {
                if (action.equals("com.screenops.action.UNREGISTER_RULE") && (stringExtra = intent.getStringExtra("client_package")) != null) {
                    String stringExtra3 = intent.getStringExtra("rules_json");
                    if (stringExtra3 == null || stringExtra3.length() == 0) {
                        ConcurrentHashMap concurrentHashMap = a.f3239a;
                        Collection collectionValues = concurrentHashMap.values();
                        k.e(collectionValues, "<get-values>(...)");
                        Iterator it = collectionValues.iterator();
                        while (it.hasNext()) {
                            ((Set) it.next()).remove(stringExtra);
                        }
                        Set setEntrySet = concurrentHashMap.entrySet();
                        k.e(setEntrySet, "<get-entries>(...)");
                        A.j0(setEntrySet, new androidx.compose.ui.text.d(14));
                        Log.i("RegistrationReceiver", "Unregister all for client=".concat(stringExtra));
                        return;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(stringExtra3);
                        f fVarX = AbstractC1451a.X(0, jSONArray.length());
                        ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
                        e it2 = fVarX.iterator();
                        while (it2.c) {
                            arrayList.add(jSONArray.getJSONObject(it2.nextInt()).getString("ruleName"));
                        }
                        a.c(stringExtra, arrayList);
                        Log.i("RegistrationReceiver", "Unregister rules=" + arrayList + " for client=" + stringExtra);
                        return;
                    } catch (JSONException e) {
                        Log.e("RegistrationReceiver", "Failed to parse rules_json for unregister", e);
                        return;
                    }
                }
                return;
            }
            if (iHashCode == -450023019 && action.equals("com.screenops.action.REGISTER_RULE") && (stringExtra2 = intent.getStringExtra("client_package")) != null) {
                String stringExtra4 = intent.getStringExtra("rules_json");
                if (stringExtra4 == null || stringExtra4.length() == 0) {
                    String stringExtra5 = intent.getStringExtra("rule_name");
                    if (stringExtra5 == null) {
                        return;
                    }
                    a.b(stringExtra2, stringExtra5);
                    Log.i("RegistrationReceiver", "Register (legacy): client=" + stringExtra2 + ", rule=" + stringExtra5);
                } else {
                    try {
                        JSONArray jSONArray2 = new JSONArray(stringExtra4);
                        int length = jSONArray2.length();
                        for (int i = 0; i < length; i++) {
                            String string = jSONArray2.getJSONObject(i).getString("ruleName");
                            ConcurrentHashMap concurrentHashMap2 = a.f3239a;
                            k.c(string);
                            a.b(stringExtra2, string);
                            Log.i("RegistrationReceiver", "Register: client=" + stringExtra2 + ", rule=" + string);
                        }
                    } catch (JSONException e6) {
                        Log.e("RegistrationReceiver", "Failed to parse rules_json for register", e6);
                        return;
                    }
                }
                C1923c c1923c = c.f3241a;
                Context applicationContext = context.getApplicationContext();
                k.e(applicationContext, "getApplicationContext(...)");
                c.b(applicationContext);
            }
        }
    }
}
