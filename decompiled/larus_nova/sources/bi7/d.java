package bi7;

import android.content.ClipData;
import android.text.TextUtils;
import ci7.s;
import com.bytedance.ug.sdk.deeplink.ZlinkApi;
import com.bytedance.ug.sdk.deeplink.interfaces.AbstractClipboardObserver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements ei7.a {
    public d() {
    }

    @Override // ei7.a
    public final void d() {
        c r100 = c.a.f19147a;
        ClipData r101 = ci7.d.b(r100.f19145a);
        List r102 = c.b(r101);
        if (mi7.a.a(r102) == true) goto L13;
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L21;
        String r104 = (String) r103.next();
        s r105 = (s) ((HashMap) r100.f19146b).get("scheme");
        if (r105 == null) goto L7;
        if (r105.a(r104) == false) goto L7;
        ci7.d.a(r100.f19145a, r104, r101);
        goto L7
    L21:
        return;
    }

    @Override // ei7.a
    public final void f() {
        PriorityBlockingQueue<AbstractClipboardObserver> r100 = j.f19156a;
        if (ZlinkApi.INSTANCE.isInited() == false) goto L7;
        mi7.h.a(new i());
        return;
    }

    @Override // ei7.a
    public final s k() {
        c r100 = c.a.f19147a;
        if (r100.f19146b != null) goto L5;
    L8:
        return null;
    L5:
        if (TextUtils.isEmpty("scheme") == true) goto L8;
        return (s) ((HashMap) r100.f19146b).get("scheme");
    }
}
