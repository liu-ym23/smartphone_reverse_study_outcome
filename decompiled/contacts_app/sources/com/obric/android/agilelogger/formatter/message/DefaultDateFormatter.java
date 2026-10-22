package com.obric.android.agilelogger.formatter.message;

import com.obric.android.agilelogger.formatter.Formatter;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDateFormatter implements Formatter<String> {
    private Date date;

    /* JADX INFO: renamed from: format, reason: avoid collision after fix types in other method */
    public String format2(String r1) {
        return r1;
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(String r1) {
        return format2(r1);
    }

    public DefaultDateFormatter() {
        this("MM-dd HH:mm:ss");
    }

    public DefaultDateFormatter(String r1) {
        this.date = new Date();
    }
}
