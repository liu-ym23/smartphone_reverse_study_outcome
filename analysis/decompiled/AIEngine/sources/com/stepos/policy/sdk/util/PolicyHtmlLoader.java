package com.stepos.policy.sdk.util;

import ad.n;
import ad.t;
import android.content.Context;
import android.net.Uri;
import gc.o;
import gc.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import mb.y;
import okhttp3.Response;
import okhttp3.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyHtmlLoader {
    public static final PolicyHtmlLoader INSTANCE = new PolicyHtmlLoader();
    private static final lb.d httpClient$delegate = kotlin.b.b(PolicyHtmlLoader$httpClient$2.INSTANCE);

    private PolicyHtmlLoader() {
    }

    private final String extractAssetFileName(String str) {
        return o.i0(o.i0(str, "file:////android_asset/", ""), "file:///android_asset/", "");
    }

    private final n getHttpClient() {
        Object value = httpClient$delegate.getValue();
        kotlin.jvm.internal.g.e(value, "<get-httpClient>(...)");
        return (n) value;
    }

    private final String loadFromAssets(Context context, String str) throws IOException {
        InputStream input = context.getAssets().open(str);
        try {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            kotlin.jvm.internal.g.e(input, "input");
            String textCompat = policyHtmlLoader.readTextCompat(input);
            input.close();
            return textCompat;
        } finally {
        }
    }

    private final String loadFromContentResolver(Context context, Uri uri) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream != null) {
                String textCompat = INSTANCE.readTextCompat(inputStreamOpenInputStream);
                y.q(inputStreamOpenInputStream, null);
                return textCompat;
            }
            throw new IllegalArgumentException(("Cannot open " + uri).toString());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                y.q(inputStreamOpenInputStream, th);
                throw th2;
            }
        }
    }

    private final String loadFromFile(String str) {
        File file = new File(str);
        Charset UTF_8 = StandardCharsets.UTF_8;
        kotlin.jvm.internal.g.e(UTF_8, "UTF_8");
        return wb.d.Z(file, UTF_8);
    }

    private final String loadFromHttp(String str) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        n httpClient = getHttpClient();
        h.a aVar = new h.a();
        aVar.e(str);
        Response responseD = httpClient.a(new h(aVar)).d();
        try {
            if (!responseD.r) {
                throw new IllegalStateException("HTTP " + responseD.f10891d + " for " + str);
            }
            t tVar = responseD.f10893j;
            String strC = tVar != null ? tVar.C() : null;
            if (strC == null) {
                strC = "";
            }
            responseD.close();
            return strC;
        } finally {
        }
    }

    public static final String loadHtml(Context context, String uri) {
        kotlin.jvm.internal.g.f(context, "context");
        kotlin.jvm.internal.g.f(uri, "uri");
        if (o.k0(uri, "content://", true)) {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            Uri uri2 = Uri.parse(uri);
            kotlin.jvm.internal.g.e(uri2, "parse(uri)");
            return policyHtmlLoader.loadFromContentResolver(context, uri2);
        }
        if (!q.l0(uri, "android_asset", false)) {
            return o.k0(uri, "file://", true) ? INSTANCE.loadFromFile(q.G0(uri, "file://")) : (o.k0(uri, "http://", true) || o.k0(uri, "https://", true)) ? INSTANCE.loadFromHttp(uri) : INSTANCE.loadFromFile(uri);
        }
        PolicyHtmlLoader policyHtmlLoader2 = INSTANCE;
        return policyHtmlLoader2.loadFromAssets(context, policyHtmlLoader2.extractAssetFileName(uri));
    }

    private final String readTextCompat(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            String strF = jd.b.F(bufferedReader);
            bufferedReader.close();
            return strF;
        } finally {
        }
    }
}
