package com.android.contacts.calllog.v2;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CallLogGrouper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¨\u0006\u001a"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogGrouper;", "", "()V", "buildGroupItem", "Lcom/android/contacts/calllog/v2/CallLogItem;", "group", "", "canMerge", "", "head", "candidate", "compareSipAddresses", "number1", "", "number2", "equalNumbers", "items", "isCompatibleType", "firstType", "", "candidateType", "isSameDay", "time1", "", "time2", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogGrouper {
    public static final Companion Companion = null;
    private static final String TAG = "CallLogGrouper";

    /* JADX INFO: compiled from: CallLogGrouper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogGrouper$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final boolean isCompatibleType(int r4, int r5) {
        if (r4 != 3) goto L5;
    L12:
        if (r5 == 3) goto L14;
        return false;
    L14:
        return true;
    L5:
        if (r4 == 4) goto L12;
        if (r5 == 1) goto L14;
        if (r5 == 2) goto L14;
        if (r5 == 7) goto L14;
        return false;
    }

    public CallLogGrouper() {
    }

    public final List<CallLogItem> group(List<CallLogItem> r9) {
        Intrinsics.checkNotNullParameter(r9, "items");
        if (r9.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList();
        List<CallLogItem> r2 = CollectionsKt.mutableListOf(new CallLogItem[]{r9.get(0)});
        int r4 = r9.size();
        int r5 = 1;
    L7:
        if (r5 >= r4) goto L13;
        CallLogItem r6 = r9.get(r5);
        if (canMerge(r2.get(0), r6) == false) goto L11;
        r2.add(r6);
    L12:
        r5 = r5 + 1;
        goto L7
    L11:
        r0.add(buildGroupItem(r2));
        r2 = CollectionsKt.mutableListOf(new CallLogItem[]{r6});
        goto L12
    L13:
        r0.add(buildGroupItem(r2));
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "group: input=" + r9.size() + ", output=" + r0.size());
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    private final boolean canMerge(CallLogItem r7, CallLogItem r8) {
        if (equalNumbers(r7.getNumber(), r8.getNumber()) == true) goto L6;
        return false;
    L6:
        if (isSameDay(r7.getDate(), r8.getDate()) == true) goto L9;
        return false;
    L9:
        if (isCompatibleType(r7.getCallType(), r8.getCallType()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    private final boolean equalNumbers(String r2, String r3) {
        if (PhoneNumberUtils.isUriNumber(r2) == true) goto L20;
        if (PhoneNumberUtils.isUriNumber(r3) == true) goto L20;
        if (TextUtils.isEmpty(r2) == true) goto L18;
        if (TextUtils.isEmpty(r3) == true) goto L18;
        if (Intrinsics.areEqual(r2, r3) == false) goto L16;
        return true;
    L16:
        return PhoneNumberUtils.compare(r2, r3);
    L18:
        return PhoneNumberUtils.compare(r2, r3);
    L20:
        return compareSipAddresses(r2, r3);
    }

    private final boolean compareSipAddresses(String r12, String r13) {
        if (r12 == null) goto L26;
        if (r13 == null) goto L26;
        int r11 = StringsKt.indexOf$default(r12, '@', 0, false, 6, null);
        if (r11 == (-1)) goto L8;
        String r3 = r12.substring(0, r11);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
    L9:
        String r4 = "";
        if (r11 == (-1)) goto L12;
        String r14 = r12.substring(r11);
        Intrinsics.checkNotNullExpressionValue(r14, "substring(...)");
    L13:
        int r15 = StringsKt.indexOf$default(r13, '@', 0, false, 6, null);
        if (r15 == (-1)) goto L16;
        String r5 = r13.substring(0, r15);
        Intrinsics.checkNotNullExpressionValue(r5, "substring(...)");
    L17:
        if (r15 == (-1)) goto L20;
        r4 = r13.substring(r15);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
    L20:
        if (Intrinsics.areEqual(r3, r5) == true) goto L22;
        return false;
    L22:
        if (StringsKt.equals(r14, r4, true) == true) goto L24;
        return false;
    L24:
        return true;
    L16:
        r5 = r13;
        goto L17
    L12:
        r14 = "";
        goto L13
    L8:
        r3 = r12;
    L26:
        return TextUtils.equals(r12, r13);
    }

    private final boolean isSameDay(long r1, long r3) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(r3);
        if (r0.get(1) == r2.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r0.get(6) != r2.get(6)) goto L7;
        return true;
    }

    private final CallLogItem buildGroupItem(List<CallLogItem> r35) {
        CallLogItem r2 = r35.get(0);
        int r18 = r35.size();
        List<CallLogItem> r0 = r35;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        r1.add(Long.valueOf(((CallLogItem) r3.next()).getId()));
        goto L4
    L7:
        return CallLogItem.copy$default(r2, 0, null, null, null, null, 0, 0, 0, 0, 0, null, null, r18, r1, null, 0, 0, null, false, null, null, false, false, false, 0, null, 67096575, null);
    }
}
