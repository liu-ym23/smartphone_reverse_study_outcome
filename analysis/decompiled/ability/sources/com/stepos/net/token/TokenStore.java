package com.stepos.net.token;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/stepos/net/token/TokenStore;", "", "LC7/r;", "clear", "()V", "", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "access", "getRefresh", "setRefresh", "refresh", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TokenStore {
    void clear();

    String getAccess();

    String getRefresh();

    void setAccess(String str);

    void setRefresh(String str);
}
