package com.obric.contactsdk;

import android.content.Context;
import com.obric.callandsms.common.Logger;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.contactsdk.loader.CallHistoryEntityUtilKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CallHistoryEntitySupplier implements EntitySupplier, EntitySyncDataSupplier {
    private static final String TAG = "ContactEntitySupplier";
    private final Context mContext;

    public CallHistoryEntitySupplier(Context r1) {
        this.mContext = r1;
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        List<Long> r0 = CallHistoryEntityUtilKt.getAllCallLogIds(this.mContext);
        return new ArrayList(CallHistoryEntityUtilKt.queryCallLogsByIds(this.mContext.getContentResolver(), r0, this.mContext));
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        return CallHistoryEntityUtilKt.queryCallLogSampleEntities(this.mContext);
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r3, int r4) {
        if (r3.isEmpty() == false) goto L7;
        Logger.INSTANCE.i(TAG, "getWholeEntities: idList is empty");
        return Collections.emptyList();
    L7:
        if (r4 == 202) goto L10;
        Logger.INSTANCE.i(TAG, "getWholeEntities: unknown entity type: " + r4);
        return Collections.emptyList();
    L10:
        ArrayList r5 = new ArrayList();
        Iterator<String> r6 = r3.iterator();
    L12:
        if (r6.hasNext() == false) goto L17;
        r5.add(Long.valueOf(Long.parseLong(r6.next())));     // Catch: NumberFormatException -> L18
        goto L12
    L17:
        return new ArrayList(CallHistoryEntityUtilKt.queryCallLogsByIds(this.mContext.getContentResolver(), r5, this.mContext));
    }
}
