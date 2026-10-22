package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import com.bytedance.ai.applet.app.base.ApplicationStorage;
import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.bytedance.keva.Keva;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class x implements ApplicationStorage, w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f34411a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final void clear() {
        this.f34411a.clear();
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final ApplicationStorage.b getInfo() {
        Map<String, ?> r100 = this.f34411a.getAll();
        Intrinsics.checkNotNull(r100);
        Iterator<Map.Entry<String, ?>> r101 = r100.entrySet().iterator();
        long r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L15;
        Map.Entry<String, ?> r103 = r101.next();
        String r104 = r103.getKey();
        Object r105 = r103.getValue();
        Intrinsics.checkNotNull(r104);
        Charset r106 = Charsets.UTF_8;
        r102 = r102 + ((long) r104.getBytes(r106).length);
        if (r105 != null) goto L9;
        String r107 = null;
    L12:
        if (r107 == null) goto L4;
        r102 = r102 + ((long) r107.getBytes(r106).length);
        goto L4
    L9:
        if ((r105 instanceof String) == false) goto L11;
        r107 = (String) r105;
        goto L12
    L11:
        r107 = r105.toString();
        goto L12
    L15:
        return new ApplicationStorage.b(CollectionsKt.toList(r100.keySet()), (int) (r102 / ((long) 1024)));
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final String get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f34411a.getString(r100, null);
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final void remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f34411a.erase(r100);
    }

    public x(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "appId");
        this.f34411a = Keva.getRepo("applet_app_storage_" + r100 + '_' + r101);
    }

    @Override // com.bytedance.ai.applet.app.base.ApplicationStorage
    public final ApplicationStorage.a b(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        if (r111 != null) goto L6;
        remove(r110);
        return ApplicationStorage.a.b.f34158a;
    L6:
        long r100 = r111.getBytes(Charsets.UTF_8).length;
        if (r100 > 1048576) goto L9;
        Map<String, ?> r101 = this.f34411a.getAll();
        Intrinsics.checkNotNull(r101);
        Iterator<Map.Entry<String, ?>> r102 = r101.entrySet().iterator();
        long r103 = 0;
    L12:
        if (r102.hasNext() == false) goto L25;
        Map.Entry<String, ?> r104 = r102.next();
        String r105 = r104.getKey();
        Object r106 = r104.getValue();
        if (Intrinsics.areEqual(r105, r110) == true) goto L12;
        Intrinsics.checkNotNull(r105);
        Charset r107 = Charsets.UTF_8;
        r103 = r103 + ((long) r105.getBytes(r107).length);
        if (r106 != null) goto L19;
        String r108 = null;
    L22:
        if (r108 == null) goto L12;
        r103 = r103 + ((long) r108.getBytes(r107).length);
        goto L12
    L19:
        if ((r106 instanceof String) == false) goto L21;
        r108 = (String) r106;
        goto L22
    L21:
        r108 = r106.toString();
        goto L22
    L25:
        if ((r103 + (((long) r110.getBytes(Charsets.UTF_8).length) + r100)) > BdpOkClient.CACHE_MAX_SIZE) goto L27;
        this.f34411a.storeString(r110, r111);
        return ApplicationStorage.a.b.f34158a;
    L27:
        return new ApplicationStorage.a.C0679a(ApplicationStorage.StorageError.EXCEED_TOTAL_MAX_SIZE);
    L9:
        return new ApplicationStorage.a.C0679a(ApplicationStorage.StorageError.EXCEED_ITEM_MAX_SIZE);
    }
}
