package com.bytedance.dr.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.dr.OaidApi;

/* loaded from: classes.dex */
public final class j implements OaidApi {
    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Nubia";
    }

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) throws RemoteException {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return null;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                OaidApi.a aVar = new OaidApi.a();
                aVar.a = bundleCall.getString("id");
                return aVar;
            }
            String string = bundleCall.getString("message");
            if (!TextUtils.isEmpty(string)) {
                LoggerImpl.global().error(1, string, new Object[0]);
            }
            return null;
        } catch (Exception e) {
            LoggerImpl.global().error(1, "getOaid failed", e, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        return true;
    }
}
