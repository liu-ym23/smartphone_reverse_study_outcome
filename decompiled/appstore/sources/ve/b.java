package ve;

import android.content.Intent;
import com.ss.android.agilelogger.formatter.message.object.ObjectFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class b implements ObjectFormatter {
    public b() {
    }

    public String a(Intent r10) {
        return ze.b.d(r10);
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r10) {
        return a((Intent) r10);
    }
}
