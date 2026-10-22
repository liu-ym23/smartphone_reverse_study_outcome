package com.google.android.material.bottomsheet;

import android.os.Bundle;
import android.view.View;
import com.stepos.core.ota.crypto.CryptoHeaderParser;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends v0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4718a;

    public f(h hVar) {
        this.f4718a = hVar;
    }

    @Override // v0.a
    public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
        super.onInitializeAccessibilityNodeInfo(view, bVar);
        if (!this.f4718a.f4722m) {
            bVar.f13532a.setDismissable(false);
        } else {
            bVar.a(CryptoHeaderParser.MAX_BLOCK_SIZE);
            bVar.f13532a.setDismissable(true);
        }
    }

    @Override // v0.a
    public final boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (i10 == 1048576) {
            h hVar = this.f4718a;
            if (hVar.f4722m) {
                hVar.cancel();
                return true;
            }
        }
        return super.performAccessibilityAction(view, i10, bundle);
    }
}
