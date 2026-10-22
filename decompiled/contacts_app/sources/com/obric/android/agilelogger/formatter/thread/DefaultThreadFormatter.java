package com.obric.android.agilelogger.formatter.thread;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultThreadFormatter implements ThreadFormatter {
    private final String THREAD_PREFIX;

    public DefaultThreadFormatter() {
        this.THREAD_PREFIX = "Thread: ";
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Thread r1) {
        return format2(r1);
    }

    /* JADX INFO: renamed from: format, reason: avoid collision after fix types in other method */
    public String format2(Thread r2) {
        StringBuffer r1 = new StringBuffer("Thread: ");
        r1.append(r2.getName());
        return r1.toString();
    }
}
