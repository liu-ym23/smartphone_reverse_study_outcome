package com.mdisdk.observer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/mdisdk/observer/ObserverFilter;", "", "accept", "", "info", "Lcom/mdisdk/observer/AppDiedFilter;", "Lcom/mdisdk/observer/ForegroundAppFilter;", "Lcom/mdisdk/observer/VisibleWindowFilter;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ObserverFilter {
    boolean accept(Object info);
}
