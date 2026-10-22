package com.stepos.policy.sdk.util;

import La.D;
import La.H;
import android.content.Context;
import android.net.Uri;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import l9.m;
import tb.AbstractC5531D;
import tb.C5528A;
import tb.C5530C;
import tb.z;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicyHtmlLoader;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "uri", "loadHtml", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "extractAssetFileName", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/net/Uri;", "loadFromContentResolver", "(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;", "assetFileName", "loadFromAssets", "path", "loadFromFile", "url", "loadFromHttp", "Ljava/io/InputStream;", "readTextCompat", "(Ljava/io/InputStream;)Ljava/lang/String;", "Ltb/z;", "httpClient$delegate", "LY8/h;", "getHttpClient", "()Ltb/z;", "httpClient", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyHtmlLoader {
    public static final PolicyHtmlLoader INSTANCE = new PolicyHtmlLoader();

    /* renamed from: httpClient$delegate, reason: from kotlin metadata */
    private static final Y8.h httpClient = C4848b.b(PolicyHtmlLoader$httpClient$2.INSTANCE);

    private PolicyHtmlLoader() {
    }

    private final String extractAssetFileName(String uri) {
        return D.T(D.T(uri, "file:////android_asset/", "", false, 4, null), "file:///android_asset/", "", false, 4, null);
    }

    private final z getHttpClient() {
        Object value = httpClient.getValue();
        p.h(value, "<get-httpClient>(...)");
        return (z) value;
    }

    private final String loadFromAssets(Context context, String assetFileName) throws IOException {
        InputStream input = context.getAssets().open(assetFileName);
        try {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            p.h(input, "input");
            String textCompat = policyHtmlLoader.readTextCompat(input);
            l9.b.a(input, null);
            return textCompat;
        } finally {
        }
    }

    private final String loadFromContentResolver(Context context, Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        try {
            if (inputStreamOpenInputStream != null) {
                String textCompat = INSTANCE.readTextCompat(inputStreamOpenInputStream);
                l9.b.a(inputStreamOpenInputStream, null);
                return textCompat;
            }
            throw new IllegalArgumentException(("Cannot open " + uri).toString());
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                l9.b.a(inputStreamOpenInputStream, th);
                throw th2;
            }
        }
    }

    private final String loadFromFile(String path) {
        File file = new File(path);
        Charset UTF_8 = StandardCharsets.UTF_8;
        p.h(UTF_8, "UTF_8");
        return l9.i.n(file, UTF_8);
    }

    private final String loadFromHttp(String url) throws IOException {
        if (PolicySdkNetworkGate.shouldBlock()) {
            throw PolicySdkNetworkGate.blockedIOException();
        }
        C5530C c5530cExecute = getHttpClient().a(new C5528A.a().t(url).b()).execute();
        try {
            if (c5530cExecute.getIsSuccessful()) {
                AbstractC5531D body = c5530cExecute.getBody();
                String strA = body != null ? body.A() : null;
                if (strA == null) {
                    strA = "";
                }
                l9.b.a(c5530cExecute, null);
                return strA;
            }
            throw new IllegalStateException("HTTP " + c5530cExecute.getCode() + " for " + url);
        } finally {
        }
    }

    public static final String loadHtml(Context context, String uri) {
        p.i(context, "context");
        p.i(uri, "uri");
        if (D.V(uri, "content://", true)) {
            PolicyHtmlLoader policyHtmlLoader = INSTANCE;
            Uri uri2 = Uri.parse(uri);
            p.h(uri2, "parse(uri)");
            return policyHtmlLoader.loadFromContentResolver(context, uri2);
        }
        if (!H.g0(uri, "android_asset", false, 2, null)) {
            return D.V(uri, "file://", true) ? INSTANCE.loadFromFile(H.p1(uri, "file://", null, 2, null)) : (D.V(uri, "http://", true) || D.V(uri, "https://", true)) ? INSTANCE.loadFromHttp(uri) : INSTANCE.loadFromFile(uri);
        }
        PolicyHtmlLoader policyHtmlLoader2 = INSTANCE;
        return policyHtmlLoader2.loadFromAssets(context, policyHtmlLoader2.extractAssetFileName(uri));
    }

    private final String readTextCompat(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            String strE = m.e(bufferedReader);
            l9.b.a(bufferedReader, null);
            return strE;
        } finally {
        }
    }
}
