package ja;

import android.os.Bundle;
import com.obric.android.agilelogger.formatter.message.object.ObjectFormatter;

/* JADX INFO: loaded from: classes3.dex */
public class a implements ObjectFormatter {
    public a() {
    }

    public String a(Bundle r10) {
        return na.b.b(r10);
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r10) {
        return a((Bundle) r10);
    }
}
