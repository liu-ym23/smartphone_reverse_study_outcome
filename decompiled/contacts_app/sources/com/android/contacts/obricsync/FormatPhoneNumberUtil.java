package com.android.contacts.obricsync;

import android.telephony.PhoneNumberUtils;
import com.android.contacts.RegionConstants;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FormatPhoneNumberUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/contacts/obricsync/FormatPhoneNumberUtil;", "", "()V", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FormatPhoneNumberUtil {
    public static final Companion Companion = null;
    private static final AsYouTypeFormatter mFormatter = null;

    /* JADX INFO: compiled from: FormatPhoneNumberUtil.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/contacts/obricsync/FormatPhoneNumberUtil$Companion;", "", "()V", "mFormatter", "Lcom/google/i18n/phonenumbers/AsYouTypeFormatter;", "kotlin.jvm.PlatformType", "format", "", "s", "", "getFormattedNumber", "lastNonSeparator", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final String format(CharSequence r7) {
            Intrinsics.checkNotNullParameter(r7, "s");
            FormatPhoneNumberUtil.access$getMFormatter$cp().clear();
            int r0 = r7.length();
            String r1 = "";
            int r2 = 0;
            char r3 = 0;
        L3:
            if (r2 >= r0) goto L10;
            char r4 = r7.charAt(r2);
            if (PhoneNumberUtils.isNonSeparator(r4) == false) goto L9;
            if (r3 == 0) goto L8;
            r1 = getFormattedNumber(r3);
        L8:
            r3 = r4;
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            if (r3 != 0) goto L12;
            return r1;
        L12:
            return getFormattedNumber(r3);
        }

        private final String getFormattedNumber(char r1) {
            String r0 = FormatPhoneNumberUtil.access$getMFormatter$cp().inputDigit(r1);
            Intrinsics.checkNotNullExpressionValue(r0, "mFormatter.inputDigit(lastNonSeparator)");
            return r0;
        }
    }

    public FormatPhoneNumberUtil() {
    }

    public static final /* synthetic */ AsYouTypeFormatter access$getMFormatter$cp() {
        return mFormatter;
    }

    static {
        Companion = new Companion(null);
        mFormatter = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(RegionConstants.REGION);
    }
}
