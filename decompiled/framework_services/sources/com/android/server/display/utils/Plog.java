package com.android.server.display.utils;

import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Plog {
    private long mId;

    public static class SystemPlog extends Plog {
        private final String mTag;

        public SystemPlog(String tag) {
            this.mTag = tag;
        }

        @Override // com.android.server.display.utils.Plog
        protected void emit(String message) {
            Slog.d(this.mTag, message);
        }
    }

    protected abstract void emit(String r1);

    public Plog() {
    }

    public static Plog createSystemPlog(String tag) {
        return new SystemPlog(tag);
    }

    public Plog start(String title) {
        this.mId = System.currentTimeMillis();
        write(formatTitle(title));
        return this;
    }

    public Plog logPoint(String name, float x, float y) {
        write(formatPoint(name, x, y));
        return this;
    }

    public Plog logCurve(String name, float[] xs, float[] ys) {
        write(formatCurve(name, xs, ys));
        return this;
    }

    private String formatTitle(String title) {
        return "title: " + title;
    }

    private String formatPoint(String name, float x, float y) {
        return "point: " + name + ": (" + x + "," + y + ")";
    }

    private String formatCurve(String name, float[] xs, float[] ys) {
        StringBuilder sb = new StringBuilder();
        sb.append("curve: " + name + ": [");
        if (xs.length > ys.length) goto L5;
        int n = xs.length;
    L6:
        int i = 0;
    L7:
        if (i >= n) goto L9;
        sb.append("(" + xs[i] + "," + ys[i] + "),");
        i = i + 1;
        goto L7
    L9:
        sb.append("]");
        return sb.toString();
    L5:
        n = ys.length;
        goto L6
    }

    private void write(String message) {
        emit("[PLOG " + this.mId + "] " + message);
    }
}
