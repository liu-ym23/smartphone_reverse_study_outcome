package com.obric.utils;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.android.contacts.ContactsUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NumberUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/utils/NumberUtils;", "", "()V", "compareSipAddresses", "", "number1", "", "number2", "equalNumbers", "context", "Landroid/content/Context;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NumberUtils {
    public static final NumberUtils INSTANCE = null;

    static {
        INSTANCE = new NumberUtils();
    }

    private NumberUtils() {
    }

    public final boolean equalNumbers(String r2, String r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "number1");
        Intrinsics.checkNotNullParameter(r3, "number2");
        if (PhoneNumberUtils.isUriNumber(r2) == true) goto L22;
        if (PhoneNumberUtils.isUriNumber(r3) == true) goto L22;
        if (r4 == null) goto L9;
        String r1 = ContactsUtils.getCurrentCountryIso(r4);
        Intrinsics.checkNotNullExpressionValue(r1, "getCurrentCountryIso(context)");
    L11:
        if (TextUtils.isEmpty(r2) == true) goto L20;
        if (TextUtils.isEmpty(r3) == true) goto L20;
        boolean r5 = Intrinsics.areEqual(r2, r3);
        if (r5 == false) goto L17;
        return r5;
    L17:
        return PhoneNumberUtils.areSamePhoneNumber(r2, r3, r1);
    L20:
        return PhoneNumberUtils.areSamePhoneNumber(r2, r3, r1);
    L9:
        r1 = ContactsUtils.getUnknownCountryIso();
        Intrinsics.checkNotNullExpressionValue(r1, "getUnknownCountryIso()");
    L22:
        return compareSipAddresses(r2, r3);
    }

    public final boolean compareSipAddresses(String r13, String r14) {
        if (r13 == null) goto L20;
        if (r14 == null) goto L20;
        int r1 = StringsKt.indexOf$default(r13, '@', 0, false, 6, null);
        String r2 = "";
        if (r1 == (-1)) goto L9;
        String r5 = r13.substring(0, r1);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
        String r15 = r13.substring(r1);
        Intrinsics.checkNotNullExpressionValue(r15, "substring(...)");
        String r3 = r15;
        r13 = r5;
    L10:
        int r6 = StringsKt.indexOf$default(r14, '@', 0, false, 6, null);
        if (r6 == (-1)) goto L14;
        String r4 = r14.substring(0, r6);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        String r16 = r14.substring(r6);
        Intrinsics.checkNotNullExpressionValue(r16, "substring(...)");
        r2 = r16;
        r14 = r4;
    L14:
        if (Intrinsics.areEqual(r13, r14) == false) goto L19;
        if (StringsKt.equals(r3, r2, true) == false) goto L19;
        return true;
    L19:
        return false;
    L9:
        r3 = "";
    L20:
        if (r13 != r14) goto L23;
        return true;
    L23:
        return false;
    }
}
