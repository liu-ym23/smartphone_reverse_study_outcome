package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livehostapi.platform.depend.im.IMEmoji;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f134309a;

    public l(n r100) {
        this.f134309a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List<IMEmoji> r101 = (List) r100;
        if (r101.isEmpty() == false) goto L5;
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b("ChatChannelEmojiManager get empty list");
        n r102 = this.f134309a;
        r102.f134312b = CollectionsKt.emptyList();
        n r103 = this.f134309a;
        r103.f134313c = MapsKt.emptyMap();
        return;
    L5:
        HashMap r104 = new HashMap();
        Iterator<IMEmoji> r105 = r101.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        IMEmoji r106 = r105.next();
        String r107 = r106.getDisplayName();
        if (r107 == null) goto L7;
        r104.put(r107, r106);
        goto L7
    L11:
        n r108 = this.f134309a;
        r108.f134312b = r101;
        r108.f134313c = r104;
        StringBuilder r109 = new StringBuilder("ChatChannelEmojiManager get ");
        List<IMEmoji> r110 = this.f134309a.f134312b;
        if (r110 == null) goto L14;
        Integer r111 = Integer.valueOf(r110.size());
    L15:
        r109.append(r111);
        r109.append(" emoji");
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b(r109.toString());
        return;
    L14:
        r111 = null;
        goto L15
    }
}
