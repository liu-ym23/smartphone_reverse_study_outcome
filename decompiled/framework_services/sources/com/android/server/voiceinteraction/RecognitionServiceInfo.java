package com.android.server.voiceinteraction;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class RecognitionServiceInfo {
    private static final String TAG = "RecognitionServiceInfo";
    private final String mParseError;
    private final boolean mSelectableAsDefault;
    private final ServiceInfo mServiceInfo;

    static List<RecognitionServiceInfo> getAvailableServices(Context context, int user) {
        List<RecognitionServiceInfo> services = new ArrayList();
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentServicesAsUser(new Intent("android.speech.RecognitionService"), 786432, user);
        Iterator<ResolveInfo> r2 = resolveInfos.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        ResolveInfo resolveInfo = r2.next();
        RecognitionServiceInfo service = parseInfo(context.getPackageManager(), resolveInfo.serviceInfo);
        if (TextUtils.isEmpty(service.mParseError) == true) goto L8;
        Log.w(TAG, "Parse error in getAvailableServices: " + service.mParseError);
    L8:
        services.add(service);
        goto L4
    L9:
        return services;
    }

    static RecognitionServiceInfo parseInfo(PackageManager pm, ServiceInfo si) {
        String parseError = "";
        boolean selectableAsDefault = true;
        XmlResourceParser parser = si.loadXmlMetaData(pm, "android.speech");     // Catch: Throwable -> L9
        if (parser != null) goto L14;
        String parseError2 = "No android.speech meta-data for " + si.packageName;     // Catch: Throwable -> L12
        RecognitionServiceInfo r3 = new RecognitionServiceInfo(si, true, parseError2);     // Catch: Throwable -> L12
        if (parser == null) goto L11;
        parser.close();     // Catch: Throwable -> L9 Throwable -> L9 Throwable -> L9
    L11:
        return r3;
    L14:
        Resources res = pm.getResourcesForApplication(si.applicationInfo);     // Catch: Throwable -> L12
        AttributeSet attrs = Xml.asAttributeSet(parser);     // Catch: Throwable -> L12
        int type = 0;
    L16:
        if (type == 1) goto L20;
        if (type == 2) goto L20;
        type = parser.next();     // Catch: Throwable -> L12
    L20:
        String nodeName = parser.getName();     // Catch: Throwable -> L12
        if ("recognition-service".equals(nodeName) == false) goto L26;
        TypedArray values = res.obtainAttributes(attrs, R.styleable.RecognitionService);     // Catch: Throwable -> L12
        selectableAsDefault = values.getBoolean(1, true);     // Catch: Throwable -> L12
        values.recycle();     // Catch: Throwable -> L12
        parser.close();     // Catch: Throwable -> L9 Throwable -> L9 Throwable -> L9
    L36:
        return new RecognitionServiceInfo(si, selectableAsDefault, parseError);
    L26:
        throw new XmlPullParserException("Meta-data does not start with recognition-service tag");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (parser != null) goto L38;
    L33:
        throw th;     // Catch: Throwable -> L9 Throwable -> L9 Throwable -> L9
    L38:
        parser.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 Throwable -> L9 Throwable -> L9
    L9:
        e = move-exception;
        parseError = "Error parsing recognition service meta-data: " + e;
        goto L36
    }

    private RecognitionServiceInfo(ServiceInfo si, boolean selectableAsDefault, String parseError) {
        this.mServiceInfo = si;
        this.mSelectableAsDefault = selectableAsDefault;
        this.mParseError = parseError;
    }

    public String getParseError() {
        return this.mParseError;
    }

    public ServiceInfo getServiceInfo() {
        return this.mServiceInfo;
    }

    public boolean isSelectableAsDefault() {
        return this.mSelectableAsDefault;
    }
}
