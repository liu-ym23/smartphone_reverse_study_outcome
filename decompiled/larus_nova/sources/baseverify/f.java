package baseverify;

import android.text.TextUtils;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import ws7.o;

/* JADX INFO: loaded from: classes28.dex */
public class f implements APICallback<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f18503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f18504b;

    @Override // com.dtf.face.network.APICallback
    public void onSuccess(File r100) {
        a(true, "");
        monitor-enter(o.class);
        e r101 = this.f18504b;     // Catch: Throwable -> L12
        CopyOnWriteArrayList<APICallback<String>> r102 = r101.f18484a.remove(r101.f18489f);     // Catch: Throwable -> L12
        monitor-exit(o.class);     // Catch: Throwable -> L12
        if (r102 == null) goto L11;
        Iterator<APICallback<String>> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L18;
        r103.next().onSuccess("SUCCESS");
        goto L9
    L18:
        return;
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public f(e r100, long r101) {
        this.f18504b = r100;
        this.f18503a = r101;
    }

    public void a(boolean r100, String r110) {
        RecordService r101 = RecordService.getInstance();
        String[] r102 = new String[10];
        r102[0] = "status";
        r102[1] = "total";
        r102[2] = "result";
        if (r100 == false) goto L5;
        String r103 = "1";
    L6:
        r102[3] = r103;
        r102[4] = ChameleonOpenTracker.ParamKey.COST;
        r102[5] = String.valueOf(System.currentTimeMillis() - this.f18503a);
        r102[6] = "count";
        r102[7] = String.valueOf(this.f18504b.f18487d.get());
        r102[8] = "errMsg";
        if (TextUtils.isEmpty(r110) == false) goto L9;
        r110 = "NULL";
    L9:
        r102[9] = r110;
        r101.recordEvent(4, "modelDownload", r102);
        this.f18504b.f18487d.set(0);
        this.f18504b.f18485b.clear();
        return;
    L5:
        r103 = "0";
        goto L6
    }

    @Override // com.dtf.face.network.APICallback
    public void onError(String r100, String r101, String r102) {
        a(false, r100);
        monitor-enter(o.class);
        e r103 = this.f18504b;     // Catch: Throwable -> L12
        CopyOnWriteArrayList<APICallback<String>> r104 = r103.f18484a.remove(r103.f18489f);     // Catch: Throwable -> L12
        monitor-exit(o.class);     // Catch: Throwable -> L12
        if (r104 == null) goto L11;
        Iterator<APICallback<String>> r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L18;
        r105.next().onError(r100, r101, r102);
        goto L9
    L18:
        return;
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
