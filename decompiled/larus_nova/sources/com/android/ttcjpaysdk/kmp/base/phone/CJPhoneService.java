package com.android.ttcjpaysdk.kmp.base.phone;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/phone/CJPhoneService;", "Lcom/android/ttcjpaysdk/kmp/base/phone/IKmpCJPhoneService;", "<init>", "()V", "makeCall", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJPhoneService implements IKmpCJPhoneService {
    public static final int $stable = 0;
    public static final CJPhoneService INSTANCE = null;

    static {
        INSTANCE = new CJPhoneService();
    }

    private CJPhoneService() {
    }

    @Override // com.android.ttcjpaysdk.kmp.base.phone.IKmpCJPhoneService
    public void makeCall(String r100) {
        Intrinsics.checkNotNullParameter(r100, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        b r101 = c.f528682a;
        IKmpCJPhoneService r102 = (IKmpCJPhoneService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJPhoneService.class));
        if (r102 == null) goto L6;
        r102.makeCall(r100);
        return;
    }
}
