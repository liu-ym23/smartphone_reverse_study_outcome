package com.android.ttcjpaysdk.base;

import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllBindCardPageEvent;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllH5Event;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishAllSingleFragmentActivityEvent;

/* JADX INFO: loaded from: classes28.dex */
public class TTCJPayBaseUtils {
    public TTCJPayBaseUtils() {
    }

    public static void finishAll() {
        EventManager r100 = EventManager.INSTANCE;
        r100.notify(new CJPayFinishAllH5Event());
        r100.notify(new CJPayFinishAllSingleFragmentActivityEvent());
        r100.notify(new CJPayFinishAllBindCardPageEvent());
    }
}
