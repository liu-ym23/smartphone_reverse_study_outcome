package ja;

import android.content.Intent;
import com.obric.android.agilelogger.formatter.message.object.ObjectFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class b implements ObjectFormatter {
    public b() {
    }

    public String a(Intent r10) {
        return na.b.d(r10);
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r10) {
        return a((Intent) r10);
    }
}
