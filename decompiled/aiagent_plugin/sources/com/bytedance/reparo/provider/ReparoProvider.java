package com.bytedance.reparo.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.reparo.a.a;
import com.bytedance.reparo.c.e;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ReparoProvider extends PluginContentProvider {
    private static final String TAG = "FrankieProvider";

    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    public String getType(Uri r1) {
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public ReparoProvider() {
    }

    public void attachInfo(Context r3, ProviderInfo r4) {
        super.attachInfo((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static void notifySubProcess(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Uri r0 = a.a(r4);     // Catch: Exception -> L5
        ZeusProviderTransform.notifyChange(r4.getContentResolver(), r0, null, "com.obric.aiagent.plugin");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.a(TAG, "notifySubProcess failed! ", e);
    }
}
