package com.android.server.apphibernation;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppHibernationManagerInternal {
    public abstract boolean isHibernatingForUser(String r1, int r2);

    public abstract boolean isHibernatingGlobally(String r1);

    public abstract boolean isOatArtifactDeletionEnabled();

    public abstract void setHibernatingForUser(String r1, int r2, boolean r3);

    public abstract void setHibernatingGlobally(String r1, boolean r2);

    public AppHibernationManagerInternal() {
    }
}
