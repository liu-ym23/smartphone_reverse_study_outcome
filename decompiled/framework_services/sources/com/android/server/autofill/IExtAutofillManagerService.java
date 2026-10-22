package com.android.server.autofill;

import android.content.ComponentName;
import android.pico.utils.IExtBase;
import android.view.autofill.AutofillId;
import android.view.autofill.IObricAutofillManagerClient;
import com.android.internal.os.IResultReceiver;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface IExtAutofillManagerService extends IExtBase {
    void addSmsClient(IObricAutofillManagerClient r1, IResultReceiver r2, ComponentName r3);

    void dump(PrintWriter r1);

    void removeSmsClient(int r1);

    void viewEntered(AutofillId r1, int r2);

    void viewExited(AutofillId r1, int r2, boolean r3);
}
