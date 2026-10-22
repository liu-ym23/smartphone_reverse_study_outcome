package com.stepos.policy.sdk.util;

import ad.e0;
import ad.h0;
import ad.w;
import ad.y;
import ad.z;
import android.content.Context;
import android.net.Uri;
import ed.j;
import h5.t;
import hc.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import t.c1;
import ub.h;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyHtmlLoader {
    public static final PolicyHtmlLoader INSTANCE = new PolicyHtmlLoader();
    private static final jb.d httpClient$delegate = t.H(PolicyHtmlLoader$httpClient$2.INSTANCE);

    private PolicyHtmlLoader() {
    }

    private final String extractAssetFileName(String str) {
        return o.S(o.S(str, "file:////android_asset/", ""), "file:///android_asset/", "");
    }

    private final w getHttpClient() {
        Object value = httpClient$delegate.getValue();
        value.getClass();
        return (w) value;
    }

    private final String loadFromAssets(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        try {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            inputStreamOpen.getClass();
            String textCompat = policyHtmlLoader.readTextCompat(inputStreamOpen);
            t.o.d(inputStreamOpen, null);
            return textCompat;
        } finally {
        }
    }

    private final String loadFromContentResolver(Context context, Uri uri) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream != null) {
                String textCompat = INSTANCE.readTextCompat(inputStreamOpenInputStream);
                t.o.d(inputStreamOpenInputStream, null);
                return textCompat;
            }
            throw new IllegalArgumentException(("Cannot open " + uri).toString());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                t.o.d(inputStreamOpenInputStream, th);
                throw th2;
            }
        }
    }

    private final String loadFromFile(String str) {
        File file = new File(str);
        StandardCharsets.UTF_8.getClass();
        return h.n(file);
    }

    private final String loadFromHttp(String str) {
        w httpClient = getHttpClient();
        y yVar = new y();
        yVar.o(str);
        z zVarE = yVar.e();
        httpClient.getClass();
        e0 e0VarE = new j(httpClient, zVarE).e();
        try {
            if (!e0VarE.e()) {
                throw new IllegalStateException("HTTP " + e0VarE.f471h + " for " + str);
            }
            h0 h0Var = e0VarE.f473k;
            String strI = h0Var != null ? h0Var.i() : null;
            if (strI == null) {
                strI = "";
            }
            e0VarE.close();
            return strI;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                t.o.d(e0VarE, th);
                throw th2;
            }
        }
    }

    public static final String loadHtml(Context context, String str) {
        context.getClass();
        str.getClass();
        if (o.U(str, "content://", true)) {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            Uri uri = Uri.parse(str);
            uri.getClass();
            return policyHtmlLoader.loadFromContentResolver(context, uri);
        }
        if (!hc.h.X(str, "android_asset", false)) {
            return o.U(str, "file://", true) ? INSTANCE.loadFromFile(hc.h.q0(str, "file://")) : (o.U(str, "http://", true) || o.U(str, "https://", true)) ? INSTANCE.loadFromHttp(str) : INSTANCE.loadFromFile(str);
        }
        PolicyHtmlLoader policyHtmlLoader2 = INSTANCE;
        return policyHtmlLoader2.loadFromAssets(context, policyHtmlLoader2.extractAssetFileName(str));
    }

    private final String readTextCompat(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            String strJ = c1.j(bufferedReader);
            bufferedReader.close();
            return strJ;
        } finally {
        }
    }
}
