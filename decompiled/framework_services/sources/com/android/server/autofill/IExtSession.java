package com.android.server.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Rect;
import android.pico.utils.IExtBase;
import android.service.autofill.FillResponse;
import android.service.autofill.SaveInfo;
import android.util.ArrayMap;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;

/* JADX INFO: loaded from: classes.dex */
public interface IExtSession extends IExtBase {
    boolean isInTestProcess(String r1);

    boolean isPasswdAutofillRequest(ViewState r1, AutofillId r2);

    void showAutofillUi(FillResponse r1, ArrayMap<AutofillId, ViewState> r2, AutofillId r3, AutofillValue r4, ViewState r5, Rect r6, int r7);

    Session.SaveResult showPasswdSaveLocked(FillResponse r1, SaveInfo r2, ArrayMap<AutofillId, ViewState> r3, SaveEventLogger r4, ComponentName r5, String r6, Context r7, boolean r8);
}
