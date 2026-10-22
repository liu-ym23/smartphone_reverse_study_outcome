package ye;

import com.ss.android.agilelogger.formatter.thread.ThreadFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class a implements ThreadFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26249a;

    public a() {
        this.f26249a = "Thread: ";
    }

    public String a(Thread r10) {
        StringBuffer r11 = new StringBuffer();
        r11.append("Thread: ");
        r11.append(r10.getName());
        return r11.toString();
    }

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public /* bridge */ /* synthetic */ String format(Thread r10) {
        return a(r10);
    }
}
