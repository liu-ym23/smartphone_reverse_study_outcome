package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.app.AbstractC0241b;
import androidx.core.app.InterfaceC0244e;
import androidx.fragment.app.G;
import d.AbstractC0528b;
import d.C0527a;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class h extends androidx.activity.result.g {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o f2391h;

    public h(G g4) {
        this.f2391h = g4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.result.g
    public final void b(int i4, AbstractC0528b abstractC0528b, Object obj) {
        Bundle bundle;
        o oVar = this.f2391h;
        C0527a c0527aB = abstractC0528b.b(oVar, obj);
        if (c0527aB != null) {
            new Handler(Looper.getMainLooper()).post(new android.support.v4.os.a(this, i4, c0527aB, 1));
            return;
        }
        Intent intentA = abstractC0528b.a(oVar, obj);
        if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
            intentA.setExtrasClassLoader(oVar.getClassLoader());
        }
        if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if (!"androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                oVar.startActivityForResult(intentA, i4, bundle);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                oVar.startIntentSenderForResult(intentSenderRequest.f2412a, i4, intentSenderRequest.f2413b, intentSenderRequest.f2414c, intentSenderRequest.f2415d, 0, bundle);
                return;
            } catch (IntentSender.SendIntentException e4) {
                new Handler(Looper.getMainLooper()).post(new android.support.v4.os.a(this, i4, e4, 2));
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
                throw new IllegalArgumentException(B0.g.r(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
            }
        }
        int size = hashSet.size();
        String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
        if (size > 0) {
            if (size == stringArrayExtra.length) {
                return;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < stringArrayExtra.length; i6++) {
                if (!hashSet.contains(Integer.valueOf(i6))) {
                    strArr[i5] = stringArrayExtra[i6];
                    i5++;
                }
            }
        }
        if (oVar instanceof InterfaceC0244e) {
            ((InterfaceC0244e) oVar).validateRequestPermissionsRequestCode(i4);
        }
        AbstractC0241b.b(oVar, stringArrayExtra, i4);
    }
}
