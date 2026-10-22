package bi7;

import android.content.ClipData;
import android.text.TextUtils;
import ci7.l;
import ci7.s;
import com.bytedance.ug.sdk.deeplink.interfaces.AbstractClipboardObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements Runnable {
    public i() {
    }

    public static void a() {
        long r100 = System.currentTimeMillis();
        ClipData r101 = ci7.d.b(l.a());
        long r102 = System.currentTimeMillis() - r100;
        Map<String, s> r103 = c.a.f19147a.f19146b;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L24;
        Iterator r105 = ((HashMap) r103).entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L24;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (r106 == null) goto L13;
        if (TextUtils.isEmpty((CharSequence) r106.getKey()) == true) goto L13;
        s r107 = (s) r106.getValue();
        if (r107 == null) goto L13;
        if (r107.d(System.currentTimeMillis() - r102, r101) == false) goto L13;
        mi7.e.d(6, "ZlinkClipboardManager", r107.getClass().getCanonicalName() + " processed the clipData", null);
        return;
    L24:
        PriorityBlockingQueue<AbstractClipboardObserver> r108 = j.f19156a;
        if (r108.size() <= 0) goto L57;
        Iterator<AbstractClipboardObserver> r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L35;
        AbstractClipboardObserver r110 = r109.next();
        if (r110 == null) goto L28;
        if (r110.process(r101) == false) goto L28;
    L36:
        if (r110 != null) goto L38;
        mi7.e.d(6, "ZlinkClipboardManager", "There is no suitable observer process the content of clipboard!", null);
        return;
    L38:
        mi7.e.d(6, "ZlinkClipboardManager", "The observer which processed the content of clipboard is " + r110.getTag(), null);
        return;
    L35:
        r110 = null;
        goto L36
    L57:
        return;
    L5:
        if (((HashMap) r103).size() <= 0) goto L8;
        r104 = false;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
