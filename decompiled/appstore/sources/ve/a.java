package ve;

import android.os.Bundle;
import com.ss.android.agilelogger.formatter.message.object.ObjectFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class a implements ObjectFormatter {
    public a() {
    }

    public String a(Bundle r10) {
        return ze.b.b(r10);
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r10) {
        return a((Bundle) r10);
    }
}
