package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010%B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\b$\u0010'J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0011J\u001a\u0010\u0010\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0012J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0014J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u0002H\u0016R%\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!¨\u0006("}, d2 = {"Lcom/bytedance/android/ec/core/utils/UrlBuilderV2;", "Ljava/io/Serializable;", "", "getHost", "key", "getQuery", "getEncoding", "mEncoding", "", "setEncoding", "url", "setUrl", "getUrl", "name", "", "value", "addOrReplaceParam", "", "", "map", "", "Lorg/json/JSONObject;", "removeParam", "", "queryMap", "build", "Landroid/net/Uri;", "buildUri", "toString", "mMap", "Ljava/util/Map;", "getMMap", "()Ljava/util/Map;", "Ljava/lang/String;", "mHost", "mUrl", "<init>", "(Ljava/lang/String;)V", "uri", "(Landroid/net/Uri;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UrlBuilderV2 implements Serializable {
    private String mEncoding;
    private String mHost;
    private final Map<String, String> mMap;
    private String mUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public UrlBuilderV2() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void a() {
        String r100 = this.mUrl;
        if (r100 == null) goto L22;
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L12
        Iterator<T> r102 = UriProtector.getQueryParameterNames(r101).iterator();     // Catch: Exception -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = (String) r102.next();     // Catch: Exception -> L12
        String r104 = UriProtector.getQueryParameter(r101, r103);     // Catch: Exception -> L12
        if (r104 == null) goto L6;
        this.mMap.put(r103, r104);     // Catch: Exception -> L12
        goto L6
    L10:
        this.mUrl = r101.buildUpon().clearQuery().toString();     // Catch: Exception -> L12
        this.mHost = r101.getHost();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    }

    public final String build() {
        Map<String, String> r100 = this.mMap;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        Map.Entry<String, String> r103 = r102.next();
        r101.add(new i(r103.getKey(), r103.getValue()));
        goto L4
    L7:
        if (r101.isEmpty() == false) goto L12;
        String r104 = this.mUrl;
        if (r104 != null) goto L26;
        return "";
    L26:
        return r104;
    L12:
        String r105 = e2.b(r101, this.mEncoding);
        String r106 = this.mUrl;
        if (r106 != null) goto L15;
        return r105;
    L15:
        if (r106.length() != 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L21;
        return r105;
    L21:
        if (StringsKt.indexOf$default(r106, '?', 0, false, 6, null) < 0) goto L24;
        return this.mUrl + Typography.amp + r105;
    L24:
        return this.mUrl + '?' + r105;
    L17:
        r107 = false;
        goto L18
    }

    public final Uri buildUri() {
        String r100 = this.mUrl;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Uri.Builder r101 = UriProtector.parse(r100).buildUpon();
        Iterator<Map.Entry<String, String>> r102 = this.mMap.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r102.next();
        r101.appendQueryParameter(r103.getKey(), r103.getValue());
        goto L7
    L10:
        return r101.build();
    }

    public String toString() {
        return build();
    }

    public final String getEncoding() {
        return this.mEncoding;
    }

    public final String getHost() {
        return this.mHost;
    }

    public final Map<String, String> getMMap() {
        return this.mMap;
    }

    public final String getUrl() {
        return this.mUrl;
    }

    public final Map<String, String> queryMap() {
        return this.mMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UrlBuilderV2(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this(null, 1, 0 == true ? 1 : 0);
        Iterator<T> r101 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Exception -> L11
    L5:
        if (r101.hasNext() == false) goto L9;
        String r102 = (String) r101.next();     // Catch: Exception -> L11
        String r103 = UriProtector.getQueryParameter(r100, r102);     // Catch: Exception -> L11
        if (r103 == null) goto L5;
        this.mMap.put(r102, r103);     // Catch: Exception -> L11
        goto L5
    L9:
        this.mUrl = r100.buildUpon().clearQuery().toString();     // Catch: Exception -> L11
        this.mHost = r100.getHost();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void addOrReplaceParam(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.mMap.putAll(r100);
    }

    public final String getQuery(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.mMap.get(r100);
    }

    public final void removeParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.mMap.remove(r100);
    }

    public final void setEncoding(String r100) {
        Intrinsics.checkNotNullParameter(r100, "mEncoding");
        this.mEncoding = r100;
    }

    public final void setUrl(String r100) {
        this.mUrl = r100;
        a();
    }

    public UrlBuilderV2(String r100) {
        this.mUrl = r100;
        this.mMap = new ConcurrentHashMap();
        this.mEncoding = "UTF-8";
        a();
    }

    public final void addOrReplaceParam(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        String r102 = this.mMap.get(r100);
        if (r102 == null) goto L5;
        JSONObject r103 = z1.g(r102);
    L6:
        if (r103 == null) goto L12;
        Iterator<String> r104 = r101.keys();
    L9:
        if (r104.hasNext() == false) goto L11;
        String r105 = r104.next();
        r103.put(r105, r101.opt(r105));
        goto L9
    L11:
        r101 = r103;
    L12:
        addOrReplaceParam(r100, r101.toString());
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void addOrReplaceParam(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.mMap.put(r100, r101);
    }

    public final void addOrReplaceParam(String r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.mMap.put(r100, String.valueOf(r101));
    }

    public final void addOrReplaceParam(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.mMap.put(r100, String.valueOf(r101));
    }

    public final void addOrReplaceParam(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.mMap.put(r100, String.valueOf(r101));
    }

    public /* synthetic */ UrlBuilderV2(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
