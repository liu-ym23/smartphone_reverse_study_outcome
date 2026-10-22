package com.stepos.agentframework.chatui;

import A.h;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/chatui/i2;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "", DidiCardProvider.KEY_ITEMS, "Lkotlin/Function1;", "", "idOf", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;Lp9/l;)Ljava/util/List;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i2 {
    public static final i2 INSTANCE = new i2();

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> List<T> a(List<? extends T> items, InterfaceC5074l<? super T, String> idOf) {
        kotlin.jvm.internal.p.i(items, "items");
        kotlin.jvm.internal.p.i(idOf, "idOf");
        if (items.size() >= 2) {
            HashSet hashSet = new HashSet(items.size());
            ArrayList arrayList = new ArrayList(items.size());
            Iterator it = items.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                h.b bVar = (Object) it.next();
                String strInvoke = idOf.invoke(bVar);
                if (strInvoke.length() == 0 || hashSet.add(strInvoke)) {
                    arrayList.add(bVar);
                } else {
                    z10 = true;
                }
            }
            if (z10) {
                return arrayList;
            }
        }
        return items;
    }
}
