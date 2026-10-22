package i7;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f3170a;

    /* renamed from: b, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f3171b;

    /* renamed from: c, reason: collision with root package name */
    public static final ASN1ObjectIdentifier f3172c;
    public static final ASN1ObjectIdentifier d;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.101");
        f3170a = aSN1ObjectIdentifier.branch("110").intern();
        f3171b = aSN1ObjectIdentifier.branch("111").intern();
        f3172c = aSN1ObjectIdentifier.branch("112").intern();
        d = aSN1ObjectIdentifier.branch("113").intern();
    }
}
