package com.android.server.om;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswIdmapManager {
    boolean checkPackageNameIsOverlayMultheme(String r1);

    String getFinalOverlayPath(String r1, String r2, int r3);

    boolean idmapExistsMultheme(IdmapDaemon r1, String r2, String r3, int r4);

    boolean removeIdmapMultheme(IdmapDaemon r1, String r2, String r3, int r4);
}
