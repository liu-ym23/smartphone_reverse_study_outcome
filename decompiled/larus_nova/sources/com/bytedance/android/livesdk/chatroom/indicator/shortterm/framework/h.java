package com.bytedance.android.livesdk.chatroom.indicator.shortterm.framework;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShortTermStateDynamicShowFramework f106641a;

    public h(ShortTermStateDynamicShowFramework r100) {
        this.f106641a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        y90.a r101 = (y90.a) r100;
        if (r101 == null) goto L8;
        Map<String, Object> r102 = r101.f566957a;
        if (r102 == null) goto L8;
        String r103 = r102.toString();
        if (r103 == null) goto L8;
    L9:
        ALogger.i("ShortTermStateDynamicShowFramework", "features : ".concat(r103));
        Map<String, Object> r104 = r101.f566957a;
        if (r104 == null) goto L21;
        Iterator<Map.Entry<String, Object>> r105 = r104.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L31;
        Map.Entry<String, Object> r106 = r105.next();
        if (r106 == null) goto L13;
        if (TextUtils.isEmpty(r106.getKey()) == true) goto L13;
        if (r106.getValue() == null) goto L13;
        this.f106641a.f106615f.put(r106.getKey(), r106.getValue());
        goto L13
    L31:
        return;
    L21:
        return;
    L8:
        r103 = "";
        goto L9
    }
}
