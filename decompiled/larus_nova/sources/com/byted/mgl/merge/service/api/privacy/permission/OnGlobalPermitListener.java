package com.byted.mgl.merge.service.api.privacy.permission;

/* JADX INFO: loaded from: classes43.dex */
public interface OnGlobalPermitListener {
    void onPermissionNeverAsk(String[] r100, int[] r101, String[] r102);

    void onPermissionResult(String r100, PermitResult.Type r101);
}
