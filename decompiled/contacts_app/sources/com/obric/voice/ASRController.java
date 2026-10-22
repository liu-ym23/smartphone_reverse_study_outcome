package com.obric.voice;

import android.content.Context;
import com.android.contacts.ContactsApplication;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import com.obric.utils.GlobalUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ASRController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/voice/ASRController;", "", "()V", "canStartASR", "", "checkSettings", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ASRController {
    public static final ASRController INSTANCE = null;

    static {
        INSTANCE = new ASRController();
    }

    private ASRController() {
    }

    public final void checkSettings() {
        ContactsApplication r2 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r2, "getInstance()");
        if (PrivacyUtils.hasBasePermissionAndAgree(r2) == true) goto L8;
        SettingsProviderHelper r3 = SettingsProviderHelper.INSTANCE;
        ContactsApplication r1 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r1, "getInstance()");
        if (r3.getUseMobileDataInt(r1) != (-1)) goto L9;
        SettingsProviderHelper r4 = SettingsProviderHelper.INSTANCE;
        ContactsApplication r5 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r5, "getInstance()");
        r4.setUseMobileData(r5, 0);
        return;
    L9:
        return;
    }

    public final boolean canStartASR() {
        SettingsProviderHelper r3 = SettingsProviderHelper.INSTANCE;
        ContactsApplication r0 = ContactsApplication.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance()");
        if (r3.getUseMobileData(r0, -1) == false) goto L5;
        return true;
    L5:
        IntelligentUtils r4 = IntelligentUtils.INSTANCE;
        Context r1 = ContactsApplication.getInstance().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r1, "getInstance().applicationContext");
        if (r4.isNetworkAvailable(r1) == true) goto L9;
        return true;
    L9:
        if (GlobalUtils.INSTANCE.isMobileNetwork() == true) goto L11;
        return true;
    L11:
        return false;
    }
}
