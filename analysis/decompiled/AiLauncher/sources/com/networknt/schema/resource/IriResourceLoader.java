package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;
import com.networknt.schema.utils.AbsoluteIris;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes2.dex */
public class IriResourceLoader implements ResourceLoader {

    public static class Holder {
        private static final IriResourceLoader INSTANCE = new IriResourceLoader();

        private Holder() {
        }
    }

    public static /* synthetic */ InputStream a(IriResourceLoader iriResourceLoader, URL url) {
        iriResourceLoader.getClass();
        return iriResourceLoader.openConnectionCheckRedirects(url.openConnection());
    }

    public static IriResourceLoader getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.networknt.schema.resource.ResourceLoader
    public InputStreamSource getResource(AbsoluteIri absoluteIri) {
        final URL url = toURL(toURI(absoluteIri));
        return new InputStreamSource() { // from class: com.networknt.schema.resource.c
            @Override // com.networknt.schema.resource.InputStreamSource
            public final InputStream getInputStream() {
                return IriResourceLoader.a(this.f22035a, url);
            }
        };
    }

    public InputStream openConnectionCheckRedirects(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        boolean z10;
        HttpURLConnection httpURLConnection;
        int responseCode;
        int i10 = 0;
        do {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
            }
            inputStream = uRLConnection.getInputStream();
            if (!(uRLConnection instanceof HttpURLConnection) || (responseCode = (httpURLConnection = (HttpURLConnection) uRLConnection).getResponseCode()) < 300 || responseCode > 307 || responseCode == 306 || responseCode == 304) {
                z10 = false;
            } else {
                URL url = httpURLConnection.getURL();
                String headerField = httpURLConnection.getHeaderField("Location");
                URL url2 = headerField != null ? new URL(url, headerField) : null;
                httpURLConnection.disconnect();
                if (url2 == null || (!(url2.getProtocol().equals("http") || url2.getProtocol().equals("https")) || i10 >= 5)) {
                    throw new SecurityException("Maximum number of redirects exceeded");
                }
                uRLConnection = url2.openConnection();
                i10++;
                z10 = true;
            }
        } while (z10);
        return inputStream;
    }

    public URI toURI(AbsoluteIri absoluteIri) {
        return URI.create(AbsoluteIris.toUri(absoluteIri));
    }

    public URL toURL(URI uri) {
        try {
            return uri.toURL();
        } catch (MalformedURLException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
