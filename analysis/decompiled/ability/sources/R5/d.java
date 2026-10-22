package R5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.i;
import com.zyql.ability.service.IAbilityService;
import h7.C1491a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public Context f1155a;
    public boolean b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public static void b(d dVar, com.uxsense.parse.b bVar) {
        synchronized (dVar.d) {
            dVar.e = bVar;
            if (((IAbilityService) dVar.c) != null) {
                C1491a.a("ServiceConnector", "Already bound.");
                bVar.invoke(Boolean.TRUE);
            } else if (dVar.b) {
                C1491a.a("ServiceConnector", "Already binding.");
            } else {
                dVar.b = true;
                c(1, dVar, bVar);
            }
        }
    }

    public static final void c(int i, d dVar, com.uxsense.parse.b bVar) {
        Intent intent = new Intent("com.zyql.ability.service.ACTION_ABILITY_SERVICE");
        intent.setPackage("com.zyql.ability");
        boolean zBindService = dVar.f1155a.bindService(intent, (com.zyql.ability.sdk.client.c) dVar.f, 1);
        C1491a.a("ServiceConnector", "bindService called. attempt=" + i + " result=" + zBindService);
        if (zBindService) {
            return;
        }
        if (i >= 3) {
            Log.e("ServiceConnector", "Bind service failed after 3 attempts.", null);
            dVar.b = false;
            bVar.invoke(Boolean.FALSE);
        } else {
            C1491a.b("ServiceConnector", "Bind service failed immediately, retrying in 50 ms (attempt " + i + ")");
            new Handler(dVar.f1155a.getMainLooper()).postDelayed(new i(i, dVar, bVar), 50L);
        }
    }

    public void a(HashMap map) {
        this.e = map;
        SharedPreferences.Editor editorEdit = ((V5.a) this.f).f1385a.edit();
        editorEdit.clear();
        for (Map.Entry entry : ((HashMap) this.e).entrySet()) {
            editorEdit.putString((String) entry.getKey(), ((a) entry.getValue()).toString());
        }
        editorEdit.commit();
    }
}
