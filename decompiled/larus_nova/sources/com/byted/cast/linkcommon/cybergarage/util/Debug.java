package com.byted.cast.linkcommon.cybergarage.util;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes28.dex */
public final class Debug {
    public static Debug debug;
    public static boolean enabled;
    private PrintStream out;

    public static final void off() {
        enabled = false;
    }

    public static final void on() {
        enabled = true;
    }

    public synchronized PrintStream getOut() {
        monitor-enter(this);
        PrintStream r100 = this.out;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        debug = new Debug();
        enabled = false;
    }

    public Debug() {
        this.out = System.out;
    }

    public static Debug getDebug() {
        return debug;
    }

    public static boolean isOn() {
        return enabled;
    }

    public static final void message(String r100) {
        if (enabled != true) goto L6;
        debug.getOut().println("CyberGarage message : " + r100);
        return;
    }

    public static final void warning(String r100) {
        debug.getOut().println("CyberGarage warning : " + r100);
    }

    public synchronized void setOut(PrintStream r100) {
        monitor-enter(this);
        this.out = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static final void warning(Exception r100) {
        warning(r100.getMessage());
        r100.printStackTrace(debug.getOut());
    }

    public static final void message(String r100, String r101) {
        if (enabled != true) goto L5;
        debug.getOut().println("CyberGarage message : ");
    L5:
        debug.getOut().println(r100);
        debug.getOut().println(r101);
    }

    public static final void warning(String r100, Exception r101) {
        if (r101.getMessage() != null) goto L5;
        debug.getOut().println("CyberGarage warning : " + r100 + " START");
        r101.printStackTrace(debug.getOut());
        debug.getOut().println("CyberGarage warning : " + r100 + " END");
        return;
    L5:
        debug.getOut().println("CyberGarage warning : " + r100 + " (" + r101.getMessage() + ")");
        r101.printStackTrace(debug.getOut());
    }
}
