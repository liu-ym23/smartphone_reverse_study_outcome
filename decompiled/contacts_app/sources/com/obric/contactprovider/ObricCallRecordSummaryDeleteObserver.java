package com.obric.contactprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricCallRecordSummaryDeleteObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u001c\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/contactprovider/ObricCallRecordSummaryDeleteObserver;", "", "()V", "recordSummaryChangeListenerLists", "", "Lcom/obric/contactprovider/ObricCallRecordSummaryDeleteObserver$RecordSummaryChangeListener;", "addRecordChangeListener", "", "listener", "deleteRecordInfo", "callCreateTime", "", "phoneNumber", "deleteSummary", "removeRecordChangeListener", "RecordSummaryChangeListener", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObricCallRecordSummaryDeleteObserver {
    public static final ObricCallRecordSummaryDeleteObserver INSTANCE = null;
    private static final List<RecordSummaryChangeListener> recordSummaryChangeListenerLists = null;

    /* JADX INFO: compiled from: ObricCallRecordSummaryDeleteObserver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/obric/contactprovider/ObricCallRecordSummaryDeleteObserver$RecordSummaryChangeListener;", "", "deleteRecord", "", "callCreateTime", "", "phoneNumber", "deleteSummary", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface RecordSummaryChangeListener {
        void deleteRecord(String r1, String r2);

        void deleteSummary(String r1, String r2);
    }

    private ObricCallRecordSummaryDeleteObserver() {
    }

    static {
        INSTANCE = new ObricCallRecordSummaryDeleteObserver();
        recordSummaryChangeListenerLists = new ArrayList();
    }

    @JvmStatic
    public static final void addRecordChangeListener(RecordSummaryChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        recordSummaryChangeListenerLists.add(r1);
    }

    @JvmStatic
    public static final void removeRecordChangeListener(RecordSummaryChangeListener r1) {
        Intrinsics.checkNotNullParameter(r1, "listener");
        recordSummaryChangeListenerLists.remove(r1);
    }

    @JvmStatic
    public static final void deleteRecordInfo(String r2, String r3) {
        Iterator<T> r0 = recordSummaryChangeListenerLists.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((RecordSummaryChangeListener) r0.next()).deleteRecord(r2, r3);
        goto L4
    }

    @JvmStatic
    public static final void deleteSummary(String r2, String r3) {
        Iterator<T> r0 = recordSummaryChangeListenerLists.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((RecordSummaryChangeListener) r0.next()).deleteSummary(r2, r3);
        goto L4
    }
}
