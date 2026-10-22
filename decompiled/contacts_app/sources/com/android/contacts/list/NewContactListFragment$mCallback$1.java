package com.android.contacts.list;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import bytedanceos.app.voiceassistant.IVoiceAssistantCallback;
import bytedanceos.app.voiceassistant.ParcelableObject;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.obric.aiagent.assistant.utils.ObricModifySysStatusHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewContactListFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\"\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¨\u0006\u001d"}, d2 = {"com/android/contacts/list/NewContactListFragment$mCallback$1", "Lbytedanceos/app/voiceassistant/IVoiceAssistantCallback$Stub;", "onBuffer", "", "buff", "", "onError", "errorcode", "", "type", "isToast", "", "onLocalResult", "result", "Lbytedanceos/app/voiceassistant/ParcelableObject;", "isRefresh", "onPartialResult", "partialResult", "", "onRecordEnd", "onRecordStart", "onResultRecived", "resultStr", "offLine", "onVolumeUpdate", "volume", ObricModifySysStatusHelper.METHOD_SHOW_ENABLE_DIALOG, "context", "Landroid/content/Context;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewContactListFragment$mCallback$1 extends IVoiceAssistantCallback.Stub {
    final /* synthetic */ NewContactListFragment this$0;

    public void onBuffer(byte[] r1) throws RemoteException {
    }

    public void onPartialResult(String r1) throws RemoteException {
    }

    public void onRecordEnd() throws RemoteException {
    }

    public void onRecordStart() throws RemoteException {
    }

    public void onResultRecived(String r1, int r2, boolean r3) throws RemoteException {
    }

    public void onVolumeUpdate(int r1) throws RemoteException {
    }

    NewContactListFragment$mCallback$1(NewContactListFragment r1) {
        this.this$0 = r1;
    }

    public void onLocalResult(ParcelableObject r4, boolean r5) throws RemoteException {
        Intrinsics.checkNotNullParameter(r4, "result");
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NewContactListFragment", "+showResult+++++++  reco:" + NewContactListFragment.access$getMStartedRecongnize$p(this.this$0));
    L6:
        if (this.this$0.getMVoiceInterface() != null) goto L8;
        return;
    L8:
        if (NewContactListFragment.access$getMHasOccupied$p(this.this$0) == false) goto L10;
        return;
    L10:
        if (NewContactListFragment.access$getMStartedRecongnize$p(this.this$0) == true) goto L12;
        if (r5 == true) goto L12;
        return;
    L12:
        List r6 = r4.getContacts();
        NewContactListFragment.ShowResultThread r7 = NewContactListFragment.access$getMShowResultThread$p(this.this$0);
        if (r7 == null) goto L17;
        Handler r0 = this.this$0.getMHandler();
        if (r0 == null) goto L17;
        r0.removeCallbacks(r7);
    L17:
        NewContactListFragment r8 = this.this$0;
        NewContactListFragment r1 = this.this$0;
        Intrinsics.checkNotNullExpressionValue(r6, "mContactlist");
        NewContactListFragment.access$setMShowResultThread$p(r8, new NewContactListFragment.ShowResultThread(r1, r6));
        NewContactListFragment.ShowResultThread r9 = NewContactListFragment.access$getMShowResultThread$p(this.this$0);
        if (r9 == null) goto L26;
        Handler r3 = this.this$0.getMHandler();
        if (r3 == null) goto L27;
        r3.post(r9);
        return;
    L27:
        return;
    }

    public void onError(int r2, int r3, boolean r4) {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("NewContactListFragment", "+recordError+++++++ isToast " + r4);
    L6:
        if (r3 != 1) goto L20;
        NewContactListFragment.ShowResultThread r5 = NewContactListFragment.access$getMShowResultThread$p(this.this$0);
        if (r5 == null) goto L12;
        Handler r0 = this.this$0.getMHandler();
        if (r0 == null) goto L12;
        r0.removeCallbacks(r5);
    L12:
        if (r4 == false) goto L16;
        Handler r1 = this.this$0.getMHandler();
        if (r1 == null) goto L21;
        r1.post(new NewContactListFragment$mCallback$1$onError$2());
        return;
    L21:
        return;
    L16:
        NewContactListFragment.access$setMHasOccupied$p(this.this$0, true);
        Handler r6 = this.this$0.getMHandler();
        if (r6 == null) goto L23;
        final NewContactListFragment r7 = this.this$0;
        r6.post(new NewContactListFragment$mCallback$1$onError$3(r7, this));
        return;
    L23:
        return;
    }

    public final void showDialog(Context r4) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r4, 5);
        r0.setTitle(R.string.record_warning_dialog_title);
        r0.setMessage(R.string.record_warning_dialog_message);
        r0.setPositiveButton(R.string.common_ok, new NewContactListFragment$mCallback$1$showDialog$1());
        final NewContactListFragment r1 = this.this$0;
        r0.setOnDismissListener(new NewContactListFragment$mCallback$1$showDialog$2(r1));
        if (NewContactListFragment.access$getMOccupiedDialog$p(this.this$0) == null) goto L13;
        AlertDialog r5 = NewContactListFragment.access$getMOccupiedDialog$p(this.this$0);
        boolean r2 = false;
        if (r5 != null) goto L7;
    L9:
        if (r2 == false) goto L13;
        AlertDialog r6 = NewContactListFragment.access$getMOccupiedDialog$p(this.this$0);
        if (r6 == null) goto L13;
        r6.dismiss();
        goto L13
    L7:
        if (r5.isShowing() != true) goto L9;
        r2 = true;
    L13:
        NewContactListFragment.access$setMOccupiedDialog$p(this.this$0, r0.show());
    }
}
