package com.volcengine.tos.model.object;

import F9.x;
import a.AbstractC0291a;
import a7.AbstractC0307c;
import androidx.appfunctions.metadata.a;
import com.volcengine.tos.TosClientException;
import java.util.Map;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public class DefaultPreSignedPolicyURLGenerator implements PreSignedPolicyURLGenerator {
    private String bucket;
    private String host;
    private boolean isCustomDomain;
    private String scheme;
    private String signatureQuery;

    private String generateUrl(String pathSegment, Map<String, String> map) {
        String str;
        x xVar = new x(0);
        if (this.isCustomDomain) {
            str = this.host;
        } else {
            AbstractC0307c.b(this.bucket);
            str = this.bucket + "." + this.host;
        }
        if (!AbstractC0291a.y(pathSegment)) {
            pathSegment = "";
        }
        xVar.m(this.scheme);
        xVar.h(str);
        k.f(pathSegment, "pathSegment");
        xVar.l(pathSegment, 0, pathSegment.length(), false, false);
        xVar.f(this.signatureQuery);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                xVar.b(entry.getKey(), entry.getValue());
            }
        }
        return xVar.d().i;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getHost() {
        return this.host;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSignatureQuery() {
        return this.signatureQuery;
    }

    @Override // com.volcengine.tos.model.object.PreSignedPolicyURLGenerator
    public String getSignedURLForGetOrHead(String str, Map<String, String> map) {
        if (AbstractC0291a.x(str)) {
            throw new TosClientException("empty key", null);
        }
        return generateUrl(str, map);
    }

    @Override // com.volcengine.tos.model.object.PreSignedPolicyURLGenerator
    public String getSignedURLForList(Map<String, String> map) {
        return generateUrl(null, map);
    }

    public boolean isCustomDomain() {
        return this.isCustomDomain;
    }

    public DefaultPreSignedPolicyURLGenerator setBucket(String str) {
        this.bucket = str;
        return this;
    }

    public DefaultPreSignedPolicyURLGenerator setCustomDomain(boolean z10) {
        this.isCustomDomain = z10;
        return this;
    }

    public DefaultPreSignedPolicyURLGenerator setHost(String str) {
        this.host = str;
        return this;
    }

    public DefaultPreSignedPolicyURLGenerator setScheme(String str) {
        this.scheme = str;
        return this;
    }

    public DefaultPreSignedPolicyURLGenerator setSignatureQuery(String str) {
        this.signatureQuery = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DefaultPreSignedPolicyURLGenerator{signatureQuery='");
        sb.append(this.signatureQuery);
        sb.append("', host='");
        sb.append(this.host);
        sb.append("', scheme='");
        sb.append(this.scheme);
        sb.append("', bucket='");
        sb.append(this.bucket);
        sb.append("', isCustomDomain=");
        return a.r(sb, this.isCustomDomain, '}');
    }
}
