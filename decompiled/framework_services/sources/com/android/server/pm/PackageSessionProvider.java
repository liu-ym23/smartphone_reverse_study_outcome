package com.android.server.pm;

/* JADX INFO: loaded from: classes2.dex */
public interface PackageSessionProvider {
    GentleUpdateHelper getGentleUpdateHelper();

    PackageInstallerSession getSession(int r1);

    PackageSessionVerifier getSessionVerifier();
}
