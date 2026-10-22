package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends d.h {

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ p f680h;

    @Override // d.h
    public final void b(int i, e.b bVar, Cloneable cloneable) {
        Bundle bundleExtra;
        int i3;
        p pVar = this.f680h;
        e.a aVarB = bVar.b(pVar, cloneable);
        if (aVarB != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            h hVar = new h(0);
            hVar.f678g = this;
            hVar.f677f = i;
            hVar.f679h = aVarB;
            VarHandle.storeStoreFence();
            handler.post(hVar);
            return;
        }
        Intent intentA = bVar.a(pVar, cloneable);
        if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
            intentA.setExtrasClassLoader(pVar.getClassLoader());
        }
        if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if (!"androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                pVar.startActivityForResult(intentA, i, bundle);
                return;
            }
            d.j jVar = (d.j) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                i3 = i;
            } catch (IntentSender.SendIntentException e10) {
                e = e10;
                i3 = i;
            }
            try {
                pVar.startIntentSenderForResult(jVar.f2942c, i3, jVar.f2943f, jVar.f2944g, jVar.f2945h, 0, bundle);
                return;
            } catch (IntentSender.SendIntentException e11) {
                e = e11;
                IntentSender.SendIntentException sendIntentException = e;
                Handler handler2 = new Handler(Looper.getMainLooper());
                h hVar2 = new h(1);
                hVar2.f678g = this;
                hVar2.f677f = i3;
                hVar2.f679h = sendIntentException;
                VarHandle.storeStoreFence();
                handler2.post(hVar2);
                return;
            }
        }
        String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        if (stringArrayExtra == null) {
            stringArrayExtra = new String[0];
        }
        HashSet hashSet = new HashSet();
        for (String str : stringArrayExtra) {
            if (TextUtils.isEmpty(str)) {
                g5.f.s(b.n(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                return;
            }
        }
        int size = hashSet.size();
        String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
        if (size > 0) {
            if (size == stringArrayExtra.length) {
                return;
            }
            int i10 = 0;
            for (int i11 = 0; i11 < stringArrayExtra.length; i11++) {
                if (!hashSet.contains(Integer.valueOf(i11))) {
                    strArr[i10] = stringArrayExtra[i11];
                    i10++;
                }
            }
        }
        if (pVar instanceof androidx.fragment.app.j) {
            ((androidx.fragment.app.j) pVar).validateRequestPermissionsRequestCode(i);
        }
        pVar.requestPermissions(stringArrayExtra, i);
    }
}
