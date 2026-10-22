package com.android.server.supervision;

import android.os.PersistableBundle;
import android.util.IndentingPrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class SupervisionUserData {
    public String supervisionAppPackage;
    public boolean supervisionEnabled;
    public boolean supervisionLockScreenEnabled;
    public PersistableBundle supervisionLockScreenOptions;
    public final int userId;

    public SupervisionUserData(int userId) {
        this.userId = userId;
    }

    void dump(IndentingPrintWriter pw) {
        pw.println();
        pw.println("User " + this.userId + ":");
        pw.increaseIndent();
        pw.println("supervisionEnabled: " + this.supervisionEnabled);
        pw.println("supervisionAppPackage: " + this.supervisionAppPackage);
        pw.println("supervisionLockScreenEnabled: " + this.supervisionLockScreenEnabled);
        pw.println("supervisionLockScreenOptions: " + this.supervisionLockScreenOptions);
        pw.decreaseIndent();
    }
}
