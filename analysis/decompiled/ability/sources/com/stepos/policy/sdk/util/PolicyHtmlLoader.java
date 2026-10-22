package com.stepos.policy.sdk.util;

import D7.N;
import F9.F;
import F9.G;
import F9.M;
import F9.P;
import O7.i;
import android.content.Context;
import android.net.Uri;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.SingleFileBundle;
import j9.m;
import j9.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyHtmlLoader;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "uri", "loadHtml", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "extractAssetFileName", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "loadFromContentResolver", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "assetFileName", "loadFromAssets", SingleFileBundle.KEY_PATH, "loadFromFile", BffConstant.Type.Url, "loadFromHttp", "Ljava/io/InputStream;", "readTextCompat", "(Ljava/io/InputStream;)Ljava/lang/String;", "LF9/F;", "httpClient$delegate", "LC7/f;", "getHttpClient", "()LF9/F;", "httpClient", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyHtmlLoader {
    public static final PolicyHtmlLoader INSTANCE = new PolicyHtmlLoader();

    /* renamed from: httpClient$delegate, reason: from kotlin metadata */
    private static final C7.f httpClient = kotlin.a.a(PolicyHtmlLoader$httpClient$2.INSTANCE);

    private PolicyHtmlLoader() {
    }

    private final String extractAssetFileName(String uri) {
        return t.c0(t.c0(uri, "file:////android_asset/", ""), "file:///android_asset/", "");
    }

    private final F getHttpClient() {
        Object f4884a = httpClient.getF4884a();
        k.e(f4884a, "<get-httpClient>(...)");
        return (F) f4884a;
    }

    private final String loadFromAssets(Context context, String assetFileName) throws IOException {
        InputStream input = context.getAssets().open(assetFileName);
        try {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            k.e(input, "input");
            String textCompat = policyHtmlLoader.readTextCompat(input);
            N.t(input, null);
            return textCompat;
        } finally {
        }
    }

    private final String loadFromContentResolver(Context context, Uri uri) throws FileNotFoundException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream != null) {
                String textCompat = INSTANCE.readTextCompat(inputStreamOpenInputStream);
                N.t(inputStreamOpenInputStream, null);
                return textCompat;
            }
            throw new IllegalArgumentException(("Cannot open " + uri).toString());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                N.t(inputStreamOpenInputStream, th);
                throw th2;
            }
        }
    }

    private final String loadFromFile(String path) {
        File file = new File(path);
        Charset UTF_8 = StandardCharsets.UTF_8;
        k.e(UTF_8, "UTF_8");
        return i.X(file, UTF_8);
    }

    private final String loadFromHttp(String url) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        F httpClient2 = getHttpClient();
        K1.a aVar = new K1.a();
        aVar.s(url);
        G gD = aVar.d();
        httpClient2.getClass();
        M mD = new J9.i(httpClient2, gD).d();
        try {
            if (!mD.c()) {
                throw new IllegalStateException("HTTP " + mD.d + " for " + url);
            }
            P p = mD.g;
            String strG = p != null ? p.g() : null;
            if (strG == null) {
                strG = "";
            }
            mD.close();
            return strG;
        } finally {
        }
    }

    public static final String loadHtml(Context context, String uri) {
        k.f(context, "context");
        k.f(uri, "uri");
        if (t.e0(uri, "content://", true)) {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            Uri uri2 = Uri.parse(uri);
            k.e(uri2, "parse(uri)");
            return policyHtmlLoader.loadFromContentResolver(context, uri2);
        }
        if (!m.h0(uri, "android_asset", false)) {
            return t.e0(uri, "file://", true) ? INSTANCE.loadFromFile(m.H0(uri, "file://", uri)) : (t.e0(uri, "http://", true) || t.e0(uri, "https://", true)) ? INSTANCE.loadFromHttp(uri) : INSTANCE.loadFromFile(uri);
        }
        PolicyHtmlLoader policyHtmlLoader2 = INSTANCE;
        return policyHtmlLoader2.loadFromAssets(context, policyHtmlLoader2.extractAssetFileName(uri));
    }

    private final String readTextCompat(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            String strO1 = S0.b.o1(bufferedReader);
            bufferedReader.close();
            return strO1;
        } finally {
        }
    }
}
