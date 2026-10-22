package we;

import com.ss.android.agilelogger.formatter.message.throwable.ThrowableFormatter;
import ze.c;

/* JADX INFO: loaded from: classes4.dex */
public class a implements ThrowableFormatter {
    public a() {
    }

    public String a(Throwable r10) {
        return c.a(r10);
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Throwable r10) {
        return a(r10);
    }
}
