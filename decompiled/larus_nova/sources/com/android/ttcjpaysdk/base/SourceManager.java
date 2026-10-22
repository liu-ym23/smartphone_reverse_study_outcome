package com.android.ttcjpaysdk.base;

import android.text.TextUtils;
import java.util.Stack;

/* JADX INFO: loaded from: classes28.dex */
public class SourceManager {
    private static Stack<String> sources;

    public SourceManager() {
    }

    static {
        sources = new Stack();
    }

    public static String getSource() {
        if (sources.size() <= 1) goto L5;
        Stack<String> r100 = sources;
        return r100.get(r100.size() - 2);
    L5:
        return null;
    }

    public static String getTop() {
        if (sources.size() <= 0) goto L5;
        Stack<String> r100 = sources;
        return r100.get(r100.size() - 1);
    L5:
        return null;
    }

    public static boolean isEmpty() {
        return sources.isEmpty();
    }

    private static String peek() {
        if (sources.isEmpty() == false) goto L6;
        return null;
    L6:
        return sources.peek();
    }

    private static String pop() {
        if (sources.isEmpty() == false) goto L6;
        return null;
    L6:
        return sources.pop();
    }

    public static void release() {
        sources.clear();
    }

    public static int size() {
        return sources.size();
    }

    public static String getSource(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < sources.size()) goto L6;
        return null;
    L6:
        return sources.get(r100);
    }

    private static void push(String r100) {
        sources.push(r100);
    }

    private static int search(String r100) {
        return sources.search(r100);
    }

    public static void setSource(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        int r101 = search(r100);
        if (r101 != (-1)) goto L10;
        push(r100);
        return;
    L10:
        if (r101 > 1) goto L12;
        return;
    L12:
        if (r100.equals(peek()) == true) goto L20;
        if (isEmpty() == true) goto L21;
        pop();
        goto L12
    L21:
        return;
    }
}
