package com.obric.agent.d;

import android.os.Parcelable;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DownloadAppV2Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14414a = null;

    static {
        f14414a = new a();
    }

    private a() {
    }

    public final int a(AppIntentMessage r3) {
        o.e(r3, "data");
        Map<String, String> r2 = r3.getExt();
        if (r2 == null) goto L11;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get("operate_type"), String.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        Integer r5 = d.o.o.d(r4);
        if (r5 != null) goto L10;
        return 0;
    L10:
        return r5.intValue();
    L13:
        return 0;
    L11:
        return 0;
    }

    public final List<AppInfoEntity> b(AppIntentMessage r5) {
        o.e(r5, "data");
        List<AppIntentCardData> r4 = r5.getDataV2();
        if (r4 != null) goto L7;
        r4 = (List) ZeusTransformUtils.preCheckCast(r5.getData(), List.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        r4 = p.b();
    L7:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L23;
        Parcelable r1 = (Parcelable) ZeusTransformUtils.preCheckCast(r8.next(), Parcelable.class, "com.obric.aiagent.plugin");
        AppInfoEntity r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, AppIntentCardData.class) == false) goto L13;
        AppIntentCardData r2 = (AppIntentCardData) ZeusTransformUtils.preCheckCast(r1, AppIntentCardData.class, "com.obric.aiagent.plugin");
    L14:
        if (r2 == null) goto L16;
        AppEntity r9 = r2.getAppEntity();
    L18:
        if (ZeusTransformUtils.instanceOf(r9, AppInfoEntity.class) == false) goto L20;
        r3 = (AppInfoEntity) ZeusTransformUtils.preCheckCast(r9, AppInfoEntity.class, "com.obric.aiagent.plugin");
    L20:
        if (r3 == null) goto L9;
        r7.add(r3);
        goto L9
    L16:
        r9 = null;
        goto L18
    L13:
        r2 = null;
        goto L14
    L23:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    }

    public final int a(int r6, AppInfoEntity r7) {
        o.e(r7, "entity");
        int r5 = r7.getAppStatus();
        boolean r8 = r7.isExactMatch();
        if (r6 == 0) goto L16;
        if (r6 != 1) goto L24;
        if (r5 == 0) goto L24;
        if (r5 == 2) goto L28;
        if (r8 == true) goto L13;
        if (r5 == 4) goto L24;
    L13:
        if (r8 == false) goto L24;
        if (r5 != 3) goto L24;
    L23:
        return 1;
    L28:
        return 2;
    L24:
        return 0;
    L16:
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L26;
        if (r5 != 4) goto L24;
        return 2;
    L26:
        return 2;
    L25:
        return 2;
    L21:
        if (r8 == false) goto L24;
        goto L24
    }

    public final boolean c(AppIntentMessage r6) {
        o.e(r6, "data");
        List<AppInfoEntity> r0 = b(r6);
        if (r0.isEmpty() == false) goto L5;
        return false;
    L5:
        int r5 = a(r6);
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L8;
    L10:
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L26;
        if (f14414a.a(r5, (AppInfoEntity) ZeusTransformUtils.preCheckCast(r8.next(), AppInfoEntity.class, "com.obric.aiagent.plugin")) == 0) goto L16;
        boolean r1 = true;
    L17:
        if (r1 == false) goto L12;
        return true;
    L16:
        r1 = false;
        goto L17
    L26:
        return false;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        return false;
    }
}
