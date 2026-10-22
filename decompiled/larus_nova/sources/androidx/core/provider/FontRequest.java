package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        int r101 = 0;
    L4:
        if (r101 >= this.mCertificates.size()) goto L10;
        r100.append(" [");
        List r102 = (List) ListProtector.get(this.mCertificates, r101);
        int r103 = 0;
    L7:
        if (r103 >= r102.size()) goto L9;
        r100.append(" \"");
        r100.append(Base64.encodeToString((byte[]) ListProtector.get(r102, r103), 0));
        r100.append("\"");
        r103 = r103 + 1;
        goto L7
    L9:
        r100.append(" ]");
        r101 = r101 + 1;
        goto L4
    L10:
        r100.append(i.f25855d);
        r100.append("mCertificatesArray: " + this.mCertificatesArray);
        return r100.toString();
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    public String getId() {
        return this.mIdentifier;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    private String createIdentifier(String r100, String r101, String r102) {
        return r100 + "-" + r101 + "-" + r102;
    }

    public FontRequest(String r100, String r101, String r102, int r103) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r100);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r101);
        this.mQuery = (String) Preconditions.checkNotNull(r102);
        this.mCertificates = null;
        if (r103 == 0) goto L5;
        boolean r104 = true;
    L6:
        Preconditions.checkArgument(r104);
        this.mCertificatesArray = r103;
        this.mIdentifier = createIdentifier(r100, r101, r102);
        return;
    L5:
        r104 = false;
        goto L6
    }

    public FontRequest(String r100, String r101, String r102, List<List<byte[]>> r103) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r100);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r101);
        this.mQuery = (String) Preconditions.checkNotNull(r102);
        this.mCertificates = (List) Preconditions.checkNotNull(r103);
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(r100, r101, r102);
    }
}
