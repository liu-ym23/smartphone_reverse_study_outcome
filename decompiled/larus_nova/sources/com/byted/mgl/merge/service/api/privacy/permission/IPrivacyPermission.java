package com.byted.mgl.merge.service.api.privacy.permission;

import android.app.Activity;
import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public interface IPrivacyPermission {
    void addPermissionResultListener(OnGlobalPermitListener r100);

    boolean hasPermission(Context r100, String r101);

    boolean hasPermissions(Context r100, String[] r101);

    void removePermissionResultListener(OnGlobalPermitListener r100);

    void requestPermissions(Activity r100, String r101, Set<String> r102, AbsPermitListener r103);

    void requestPermissions(Activity r100, String r101, String[] r102, AbsPermitListener r103);
}
