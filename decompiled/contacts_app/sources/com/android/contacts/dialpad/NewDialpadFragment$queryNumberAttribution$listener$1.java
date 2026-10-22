package com.android.contacts.dialpad;

import android.text.Editable;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.numberassistant.NumberInfosManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: NewDialpadFragment.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/android/contacts/dialpad/NewDialpadFragment$queryNumberAttribution$listener$1", "Lcom/android/contacts/numberassistant/NumberInfosManager$NumberInfosListenerAdatper;", "onQueryNumberInfosDone", "", "infos", "Lcom/android/contacts/numberassistant/NumberInfosManager$NumberInfos;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewDialpadFragment$queryNumberAttribution$listener$1 extends NumberInfosManager.NumberInfosListenerAdatper {
    final /* synthetic */ String $cleanNumber;
    final /* synthetic */ NewDialpadFragment this$0;

    public static /* synthetic */ void $r8$lambda$ceCmgUUnnNTL93FNbECyVUzleds(NewDialpadFragment r0, String r1, NumberInfosManager.NumberInfos r2) {
        onQueryNumberInfosDone$lambda$0(r0, r1, r2);
    }

    NewDialpadFragment$queryNumberAttribution$listener$1(NewDialpadFragment r1, String r2) {
        this.this$0 = r1;
        this.$cleanNumber = r2;
    }

    @Override // com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListenerAdatper, com.android.contacts.numberassistant.NumberInfosManager.NumberInfosListener
    public void onQueryNumberInfosDone(final NumberInfosManager.NumberInfos r4) {
        FragmentActivity r0 = NewDialpadFragment.access$getMContext$p(this.this$0);
        if (r0 == null) goto L6;
        final NewDialpadFragment r1 = this.this$0;
        final String r3 = this.$cleanNumber;
        r0.runOnUiThread(new NewDialpadFragment$queryNumberAttribution$listener$1$$ExternalSyntheticLambda0(r1, r3, r4));
        return;
    }

    private static final void onQueryNumberInfosDone$lambda$0(NewDialpadFragment r5, String r6, NumberInfosManager.NumberInfos r7) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r6, "$cleanNumber");
        DigitsEditText r0 = NewDialpadFragment.access$getMDigits$p(r5);
        String r1 = null;
        if (r0 == null) goto L9;
        Editable r2 = r0.getText();
        if (r2 == null) goto L9;
        String r3 = r2.toString();
        if (r3 == null) goto L9;
        String r4 = new Regex("[^0-9]").replace(r3, "");
    L10:
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        if (Intrinsics.areEqual(r4, r6) == true) goto L15;
        return;
    L15:
        if (r7 == null) goto L17;
        String r8 = r7.getLocation();
    L18:
        if (r7 == null) goto L20;
        r1 = r7.getOperator();
    L20:
        String r9 = r8;
        if (TextUtils.isEmpty(r9) == true) goto L26;
        if (TextUtils.isEmpty(r1) == true) goto L26;
        r8 = r8 + ' ' + r1;
    L32:
        String r10 = r8;
        if (TextUtils.isEmpty(r10) == true) goto L35;
    L37:
        TextView r11 = NewDialpadFragment.access$getMDigitsAttribution$p(r5);
        if (r11 == null) goto L42;
        r11.setText(r10);
    L42:
        if (TextUtils.isEmpty(r10) == false) goto L44;
        r6 = "";
    L44:
        NewDialpadFragment.access$setMLastShownAttrNumber$p(r5, r6);
        return;
    L35:
        if (Intrinsics.areEqual(r6, NewDialpadFragment.access$getMLastShownAttrNumber$p(r5)) == false) goto L37;
        return;
    L26:
        if (TextUtils.isEmpty(r9) == false) goto L32;
        if (TextUtils.isEmpty(r1) == true) goto L31;
        r8 = r1;
        goto L32
    L31:
        r8 = "";
        goto L32
    L17:
        r8 = null;
    L9:
        r4 = null;
        goto L10
    }
}
