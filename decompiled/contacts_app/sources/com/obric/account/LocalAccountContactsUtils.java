package com.obric.account;

import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsUtils;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.vcard.ImportSimContacts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalAccountContactsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/obric/account/LocalAccountContactsUtils;", "", "()V", "getLocalAccountContacts", "Lcom/android/contacts/model/AccountWithDataSet;", ContactSaveService.EXTRA_DATA_SET, "", "isLocalAccount", "", ImportSimContacts.EXTRA_ACCOUNT, ContactSaveService.EXTRA_ACCOUNT_NAME, ContactSaveService.EXTRA_ACCOUNT_TYPE, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalAccountContactsUtils {
    public static final LocalAccountContactsUtils INSTANCE = null;

    static {
        INSTANCE = new LocalAccountContactsUtils();
    }

    private LocalAccountContactsUtils() {
    }

    public static /* synthetic */ AccountWithDataSet getLocalAccountContacts$default(String r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = null;
    L6:
        return getLocalAccountContacts(r0);
    }

    @JvmStatic
    public static final AccountWithDataSet getLocalAccountContacts(String r3) {
        return new AccountWithDataSet("default", ContactsUtils.LOCAL_ACCOUNT_TYPE, r3);
    }

    @JvmStatic
    public static final boolean isLocalAccount(AccountWithDataSet r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = r3.name;
        Intrinsics.checkNotNullExpressionValue(r1, "account.name");
        String r4 = r3.type;
        Intrinsics.checkNotNullExpressionValue(r4, "account.type");
        if (isLocalAccount(r1, r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean isLocalAccount(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, ContactSaveService.EXTRA_ACCOUNT_NAME);
        Intrinsics.checkNotNullParameter(r2, ContactSaveService.EXTRA_ACCOUNT_TYPE);
        if (Intrinsics.areEqual("default", r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(ContactsUtils.LOCAL_ACCOUNT_TYPE, r2) == false) goto L7;
        return true;
    }
}
