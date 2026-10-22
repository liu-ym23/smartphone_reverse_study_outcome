package com.stepos.alphame.manager;

import java.io.PrintWriter;

/* loaded from: classes.dex */
public class ActionRecord {
    public String action;
    public String[] description;
    public boolean local;
    public byte type;

    public ActionRecord(String str, byte b4, String[] strArr, boolean z4) {
        this.action = str;
        this.type = b4;
        this.description = strArr;
        this.local = z4;
    }

    public void dump(PrintWriter printWriter) {
        if (this.description != null) {
            printWriter.println("\t/**");
            for (String str : this.description) {
                printWriter.println("\t * " + str);
            }
            printWriter.println("\t * /");
        }
        printWriter.println("\t " + this.action);
    }
}
