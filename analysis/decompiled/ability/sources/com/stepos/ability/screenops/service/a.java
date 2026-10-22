package com.stepos.ability.screenops.service;

import D7.A;
import D7.v;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f3239a = new ConcurrentHashMap();

    public static void a(Context context, String str, int i, String str2, String str3) {
        List<String> listF1;
        k.f(context, "context");
        Set set = (Set) f3239a.get(str);
        if (set == null || (listF1 = v.f1(set)) == null) {
            return;
        }
        for (String str4 : listF1) {
            Intent intent = new Intent("com.screenops.action.SCREEN_OPS_EVENT");
            intent.setPackage(str4);
            intent.putExtra("rule_name", str);
            intent.putExtra("trigger_type", i);
            intent.putExtra("package_name", str2);
            intent.putExtra("activity_name", str3);
            context.sendBroadcastAsUser(intent, Process.myUserHandle());
        }
        int size = listF1.size();
        StringBuilder sbT = androidx.appfunctions.metadata.a.t(i, "Dispatched rule=", str, ", trigger=", " to ");
        sbT.append(size);
        sbT.append(" clients");
        Log.i("CallbackManager", sbT.toString());
    }

    public static void b(String str, String str2) {
        Object objPutIfAbsent;
        ConcurrentHashMap concurrentHashMap = f3239a;
        Object objNewKeySet = concurrentHashMap.get(str2);
        if (objNewKeySet == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(str2, (objNewKeySet = ConcurrentHashMap.newKeySet()))) != null) {
            objNewKeySet = objPutIfAbsent;
        }
        ((Set) objNewKeySet).add(str);
    }

    public static void c(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            ConcurrentHashMap concurrentHashMap = f3239a;
            if (!zHasNext) {
                Set setEntrySet = concurrentHashMap.entrySet();
                k.e(setEntrySet, "<get-entries>(...)");
                A.j0(setEntrySet, new androidx.compose.ui.text.d(13));
                return;
            } else {
                Set set = (Set) concurrentHashMap.get((String) it.next());
                if (set != null) {
                    set.remove(str);
                }
            }
        }
    }
}
