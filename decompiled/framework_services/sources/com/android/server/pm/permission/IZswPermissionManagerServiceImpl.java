package com.android.server.pm.permission;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswPermissionManagerServiceImpl {
    boolean isHSCallingUid(Context r1, int r2);

    boolean isHeartyServicePackage(String r1);
}
