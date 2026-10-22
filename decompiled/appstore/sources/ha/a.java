package ha;

import com.obric.android.agilelogger.formatter.Formatter;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Formatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Date f20385a;

    public a() {
        this("MM-dd HH:mm:ss");
    }

    public String a(String r10) {
        return r10;
    }

    @Override // com.obric.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Object r10) {
        return a((String) r10);
    }

    public a(String r10) {
        this.f20385a = new Date();
    }
}
