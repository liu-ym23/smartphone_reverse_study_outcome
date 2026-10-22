package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/d;", "", "<init>", "()V", "", "taskId", "title", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "titles", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.alipay.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3239d {
    public static final C3239d INSTANCE = new C3239d();
    private static final ConcurrentHashMap<String, String> titles = new ConcurrentHashMap<>();

    public final String a(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return titles.get(taskId);
    }

    public final void b(String taskId, String title) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        if (taskId.length() == 0) {
            return;
        }
        String strD = N5.j.INSTANCE.d(title);
        if (strD == null) {
            titles.remove(taskId);
        } else {
            titles.put(taskId, strD);
        }
    }
}
