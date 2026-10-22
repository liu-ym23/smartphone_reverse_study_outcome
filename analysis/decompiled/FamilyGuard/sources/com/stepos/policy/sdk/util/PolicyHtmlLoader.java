package com.stepos.policy.sdk.util;

import C4.A;
import C4.D;
import C4.F;
import C4.G;
import android.content.Context;
import android.net.Uri;
import f4.C0721a;
import f4.C0722b;
import f4.C0727g;
import j4.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.libpag.BuildConfig;
import r4.C1031n;

/* loaded from: classes.dex */
public final class PolicyHtmlLoader {
    public static final PolicyHtmlLoader INSTANCE = new PolicyHtmlLoader();
    private static final V3.f httpClient$delegate = V3.g.b(PolicyHtmlLoader$httpClient$2.INSTANCE);

    private PolicyHtmlLoader() {
    }

    private final String extractAssetFileName(String str) {
        return C1031n.o(C1031n.o(str, "file:////android_asset/", BuildConfig.FLAVOR, false, 4, null), "file:///android_asset/", BuildConfig.FLAVOR, false, 4, null);
    }

    private final A getHttpClient() {
        Object value = httpClient$delegate.getValue();
        k.f(value, "<get-httpClient>(...)");
        return (A) value;
    }

    private final String loadFromAssets(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        try {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            k.f(inputStreamOpen, "input");
            String textCompat = policyHtmlLoader.readTextCompat(inputStreamOpen);
            C0721a.a(inputStreamOpen, null);
            return textCompat;
        } finally {
        }
    }

    private final String loadFromContentResolver(Context context, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream != null) {
                String textCompat = INSTANCE.readTextCompat(inputStreamOpenInputStream);
                C0721a.a(inputStreamOpenInputStream, null);
                return textCompat;
            }
            throw new IllegalArgumentException(("Cannot open " + uri).toString());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C0721a.a(inputStreamOpenInputStream, th);
                throw th2;
            }
        }
    }

    private final String loadFromFile(String str) {
        File file = new File(str);
        Charset charset = StandardCharsets.UTF_8;
        k.f(charset, "UTF_8");
        return C0722b.a(file, charset);
    }

    private final String loadFromHttp(String str) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        F fExecute = getHttpClient().b(new D.a().i(str).b()).execute();
        try {
            if (fExecute.w()) {
                G gA = fExecute.a();
                String strX = gA != null ? gA.x() : null;
                if (strX == null) {
                    strX = BuildConfig.FLAVOR;
                }
                C0721a.a(fExecute, null);
                return strX;
            }
            throw new IllegalStateException("HTTP " + fExecute.m() + " for " + str);
        } finally {
        }
    }

    public static final String loadHtml(Context context, String str) {
        k.g(context, "context");
        k.g(str, "uri");
        if (C1031n.p(str, "content://", true)) {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            Uri uri = Uri.parse(str);
            k.f(uri, "parse(uri)");
            return policyHtmlLoader.loadFromContentResolver(context, uri);
        }
        if (!C1031n.u(str, "android_asset", false, 2, null)) {
            return C1031n.p(str, "file://", true) ? INSTANCE.loadFromFile(C1031n.d0(str, "file://", null, 2, null)) : (C1031n.p(str, "http://", true) || C1031n.p(str, "https://", true)) ? INSTANCE.loadFromHttp(str) : INSTANCE.loadFromFile(str);
        }
        PolicyHtmlLoader policyHtmlLoader2 = INSTANCE;
        return policyHtmlLoader2.loadFromAssets(context, policyHtmlLoader2.extractAssetFileName(str));
    }

    private final String readTextCompat(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            String strC = C0727g.c(bufferedReader);
            C0721a.a(bufferedReader, null);
            return strC;
        } finally {
        }
    }
}
