package com.android.server.display.topology;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class XmlWriter implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int indent;
    private PrintWriter out;
    private StringBuilder outBuffer;
    private boolean startLine;

    static {
    }

    public XmlWriter(PrintWriter printWriter) {
        this.out = printWriter;
        this.outBuffer = new StringBuilder();
        this.indent = 0;
        this.startLine = true;
    }

    private void printIndent() {
        int i = 0;
    L4:
        if (i >= this.indent) goto L6;
        this.outBuffer.append("    ");
        i = i + 1;
        goto L4
    L6:
        this.startLine = false;
    }

    void print(String code) {
        String[] lines = code.split("\n", -1);
        int i = 0;
    L4:
        if (i >= lines.length) goto L15;
        if (this.startLine == true) goto L8;
    L10:
        this.outBuffer.append(lines[i]);
        if ((i + 1) >= lines.length) goto L13;
        this.outBuffer.append("\n");
        this.startLine = true;
    L13:
        i = i + 1;
        goto L4
    L8:
        if (lines[i].isEmpty() == true) goto L10;
        printIndent();
        goto L10
    }

    void increaseIndent() {
        this.indent++;
    }

    void decreaseIndent() {
        this.indent--;
    }

    void printXml() {
        this.out.print(this.outBuffer.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.out == null) goto L6;
        this.out.close();
        return;
    }

    public static void write(XmlWriter _out, DisplayTopologyState displayTopologyState) throws IOException {
        _out.print("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        if (displayTopologyState == null) goto L5;
        displayTopologyState.write(_out, "displayTopologyState");
    L5:
        _out.printXml();
    }
}
