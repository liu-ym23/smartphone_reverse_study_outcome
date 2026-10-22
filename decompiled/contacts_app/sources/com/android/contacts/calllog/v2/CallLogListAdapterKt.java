package com.android.contacts.calllog.v2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\u0007"}, d2 = {"isGroupFullySelected", "", "item", "Lcom/android/contacts/calllog/v2/CallLogItem;", "selectedIds", "", "", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CallLogListAdapterKt {
    public static final boolean isGroupFullySelected(CallLogItem r5, Set<Long> r6) {
        Intrinsics.checkNotNullParameter(r5, "item");
        Intrinsics.checkNotNullParameter(r6, "selectedIds");
        if ((!r5.getChildIds().isEmpty()) == false) goto L18;
        List<Long> r7 = r5.getChildIds();
        if ((r7 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L8;
        if (r6.contains(Long.valueOf(((Number) r8.next()).longValue())) == true) goto L11;
        boolean r9 = false;
    L15:
        if (r9 == false) goto L18;
        return true;
    L8:
        r9 = true;
        goto L15
    L7:
        if (r7.isEmpty() == false) goto L9;
    L18:
        return false;
    }
}
