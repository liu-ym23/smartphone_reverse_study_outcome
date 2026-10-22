package com.bytedance.android.service.manager.redbadge;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public interface IRedBadgeService {
    boolean addRedBadgeNumber(Context r100, int r101);

    boolean applyCount(Context r100, int r101);

    int getCurRedBadgeNumber(Context r100);

    boolean isSupportAddRedBadgeNumber(int r100);

    boolean isSupportGetCurRedBadgeNumber();

    boolean isSupportReduceRedBadgeNumber(int r100);

    boolean reduceRedBadgeNumber(Context r100, int r101);

    boolean removeCount(Context r100);
}
