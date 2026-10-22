package com.obric.autogui.common.api.agent.blacklist;

import d.c.d;
import d.x;

/* JADX INFO: compiled from: IAppBlackListEventHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAppBlackListEventHolder {
    void clearBlackListEvent();

    AppBlackListEvent getBlackListEvent();

    Object lock(d<? super x> r1);

    void setBlackListEvent(AppBlackListEvent r1);

    void unlock();
}
