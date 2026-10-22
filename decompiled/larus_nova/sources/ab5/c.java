package ab5;

import android.content.DialogInterface;
import bb5.g;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f2483a;

    public c(d r100) {
        this.f2483a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        g r102 = this.f2483a.f2492i;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("photoCompressClose");
        r102 = null;
    L5:
        r102.close();
        Iterator r103 = ((ConcurrentHashMap) this.f2483a.f2486c).entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();
        long r105 = ((Number) r104.getKey()).longValue();
        ((Number) r104.getValue()).longValue();
        int r106 = com.ss.android.lark.videosend.compress.d.f444936d;
        com.ss.android.lark.videosend.compress.d.b.f444940a.b(r105);
        goto L7
    L9:
        tt5.a.h(this.f2483a.f2491h, "cancel compress");
    }
}
