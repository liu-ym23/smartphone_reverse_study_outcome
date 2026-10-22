package com.android.ttcjpaysdk.base.h5.event;

import com.android.ttcjpaysdk.base.eventbus.BaseEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/event/CJPayHostAppCallBackEvent;", "Lcom/android/ttcjpaysdk/base/eventbus/BaseEvent;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "getMap", "()Ljava/util/HashMap;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayHostAppCallBackEvent extends BaseEvent {
    private final HashMap<String, String> map;

    public final HashMap<String, String> getMap() {
        return this.map;
    }

    public CJPayHostAppCallBackEvent(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.map = r100;
    }
}
