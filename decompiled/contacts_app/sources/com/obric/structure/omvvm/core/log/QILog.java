package com.obric.structure.omvvm.core.log;

import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import kotlin.Metadata;

/* JADX INFO: compiled from: QILog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/obric/structure/omvvm/core/log/QILog;", "", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", "message", "e", "i", "isOpen", "", "w", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface QILog {

    /* JADX INFO: compiled from: QILog.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isOpen(QILog r0) {
            return false;
        }
    }

    void d(String r1, String r2);

    void e(String r1, String r2);

    void i(String r1, String r2);

    boolean isOpen();

    void w(String r1, String r2);
}
