package com.obric.utils;

import androidx.core.app.NotificationCompat;
import com.android.contacts.common.SimContactsConstants;
import com.obric.olog.OLog;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.NameRegex;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: ContactsLogHook.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J9\u0010\u000f\u001a\u00020\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u00042!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\u0012H\u0087\bø\u0001\u0000J\u001c\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001c\u0010\u0016\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0016\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018*\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/utils/ContactsLogHook;", "", "()V", "NAME_REGEX", "", "TAG", "TARGET_CLASS", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", "splitLogIfNeed", "", "originLogBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "w", "splitLog", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsLogHook {
    public static final ContactsLogHook INSTANCE = null;
    public static final String NAME_REGEX = "((^com/android/contacts.*)|(^com/bytedanceos.*)|(^com/obricOld.*)|(^obric.*)|(^(?!com/obric/olog)com/obric/.*))";
    public static final String TAG = "ContactsLog";
    public static final String TARGET_CLASS = "android.util.Log";

    static {
        INSTANCE = new ContactsLogHook();
    }

    public ContactsLogHook() {
    }

    @JvmStatic
    public static final void splitLogIfNeed(String r1, Function1<? super String, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "originLogBlock");
        if (r1 != null) goto L5;
        return;
    L5:
        r2.invoke(r1);
    }

    @JvmStatic
    public static final List<String> splitLog(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
    L4:
        if (r4.length() <= 3800) goto L6;
        String r1 = r4.substring(0, 3800);
        Intrinsics.checkNotNullExpressionValue(r1, "substring(...)");
        r0.add(r1);
        r4 = r4.substring(3800, r4.length());
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        goto L4
    L6:
        r0.add(r4);
        return r0;
    }

    @JvmStatic
    @Proxy(globalProxyClass = true, value = DayFormatter.DEFAULT_FORMAT)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int d(String r1, String r2) {
        if (r2 == null) goto L7;
        OLog.d(TAG, r1 + " - " + r2);
        return 0;
    L7:
        return 0;
    }

    @JvmStatic
    @Proxy(DayFormatter.DEFAULT_FORMAT)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int d(String r3, String r4, Throwable r5) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (r5 == null) goto L7;
        OLog.d(TAG, r3 + " - " + r4, r5);
        return 0;
    L7:
        OLog.d(TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int i(String r1, String r2) {
        if (r2 == null) goto L7;
        OLog.i(TAG, r1 + " - " + r2);
        return 0;
    L7:
        return 0;
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int i(String r3, String r4, Throwable r5) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (r5 == null) goto L7;
        OLog.i(TAG, r3 + " - " + r4, r5);
        return 0;
    L7:
        OLog.i(TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy(BaseSwitches.V)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int v(String r1, String r2) {
        if (r2 == null) goto L7;
        OLog.v(TAG, r1 + " - " + r2);
        return 0;
    L7:
        return 0;
    }

    @JvmStatic
    @Proxy(BaseSwitches.V)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int v(String r3, String r4, Throwable r5) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (r5 == null) goto L7;
        OLog.v(TAG, r3 + " - " + r4, r5);
        return 0;
    L7:
        OLog.v(TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int e(String r1, String r2) {
        if (r2 == null) goto L7;
        OLog.e(TAG, r1 + " - " + r2);
        return 0;
    L7:
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int e(String r3, String r4, Throwable r5) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (r5 == null) goto L7;
        OLog.e(TAG, r3 + " - " + r4, r5);
        return 0;
    L7:
        OLog.e(TAG, r3 + " - " + r4);
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int w(String r1, String r2) {
        if (r2 == null) goto L7;
        OLog.w(TAG, r1 + " - " + r2);
        return 0;
    L7:
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int w(String r3, String r4, Throwable r5) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        if (r5 == null) goto L7;
        OLog.w(TAG, r3 + " - " + r4, r5);
        return 0;
    L7:
        OLog.w(TAG, r3 + " - " + r4);
        return 0;
    }
}
