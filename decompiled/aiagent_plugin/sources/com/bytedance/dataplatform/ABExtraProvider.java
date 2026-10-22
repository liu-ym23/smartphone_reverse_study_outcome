package com.bytedance.dataplatform;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ABExtraProvider extends PluginContentProvider {
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    public String getType(Uri r1) {
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public ABExtraProvider() {
    }

    public boolean onCreate() {
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        ComponentName r1 = new ComponentName(r6.getPackageName(), ABExtraProvider.class.getName());
        Bundle r7 = r6.getPackageManager().getProviderInfo(r1, 128).metaData;     // Catch: Throwable -> L18
        if (r7 == null) goto L34;
        HashMap r2 = new HashMap();     // Catch: Throwable -> L18
        Iterator<String> r3 = r7.keySet().iterator();     // Catch: Throwable -> L18
    L7:
        if (r3.hasNext() == false) goto L16;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if ("____libra____ab____panel".equals(r4) == true) goto L11;
        Object r5 = r7.get(r4);     // Catch: Throwable -> L18
        if (r5 == null) goto L7;
        r2.put(r4, r5.toString());     // Catch: Throwable -> L18
        goto L7
    L11:
        if (r7.getBoolean(r4, false) == false) goto L7;
        e.a((e.a) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bytedance.dataplatform.ExperimentPanelDataManager", "com.obric.aiagent.plugin").getMethod("getInstance", new Class[0]).invoke(null, null), e.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        goto L7
    L16:
        d.a(r2);     // Catch: Throwable -> L18
        return true;
    L34:
        return true;
    L18:
        th = move-exception;
        th.printStackTrace();
        return true;
    }
}
