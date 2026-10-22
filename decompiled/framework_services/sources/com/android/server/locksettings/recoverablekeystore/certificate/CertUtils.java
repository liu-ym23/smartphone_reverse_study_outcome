package com.android.server.locksettings.recoverablekeystore.certificate;

import com.android.server.slice.SliceClientPermissions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathValidator;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes2.dex */
public final class CertUtils {
    private static final String CERT_FORMAT = "X.509";
    private static final String CERT_PATH_ALG = "PKIX";
    private static final String CERT_STORE_ALG = "Collection";
    static final int MUST_EXIST_AT_LEAST_ONE = 2;
    static final int MUST_EXIST_EXACTLY_ONE = 1;
    static final int MUST_EXIST_UNENFORCED = 0;
    private static final String SIGNATURE_ALG = "SHA256withRSA";

    @Retention(RetentionPolicy.SOURCE)
    @interface MustExist {
    }

    private CertUtils() {
    }

    static X509Certificate decodeCert(byte[] certBytes) throws CertParsingException {
        return decodeCert(new ByteArrayInputStream(certBytes));
    }

    static X509Certificate decodeCert(InputStream inStream) throws CertParsingException {
        CertificateFactory certFactory = CertificateFactory.getInstance(CERT_FORMAT);     // Catch: CertificateException -> L8
        return (X509Certificate) certFactory.generateCertificate(inStream);
    L5:
        e = move-exception;
        throw new CertParsingException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static Element getXmlRootNode(byte[] xmlBytes) throws CertParsingException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xmlBytes));     // Catch: Throwable -> L4
        document.getDocumentElement().normalize();     // Catch: Throwable -> L4
        return document.getDocumentElement();
    L4:
        e = move-exception;
        throw new CertParsingException(e);
    }

    static List<String> getXmlNodeContents(int mustExist, Element rootNode, String... nodeTags) throws CertParsingException {
        if (nodeTags.length == 0) goto L39;
        Element parent = rootNode;
        int i = 0;
    L6:
        if (i >= (nodeTags.length - 1)) goto L19;
        String tag = nodeTags[i];
        List<Element> children = getXmlDirectChildren(parent, tag);
        if (children.size() != 0) goto L11;
        if (mustExist == 0) goto L11;
    L18:
        throw new CertParsingException("The XML file must contain exactly one path with the tag " + tag);
    L11:
        if (children.size() > 1) goto L18;
        if (children.size() == 0) goto L15;
        Element parent2 = children.get(0);
        parent = parent2;
        i = i + 1;
        goto L6
    L15:
        return new ArrayList();
    L19:
        int i2 = nodeTags.length;
        List<Element> leafs = getXmlDirectChildren(parent, nodeTags[i2 - 1]);
        if (mustExist != 1) goto L27;
        if (leafs.size() == 1) goto L27;
        throw new CertParsingException("The XML file must contain exactly one node with the path " + String.join(SliceClientPermissions.SliceAuthority.DELIMITER, nodeTags));
    L27:
        if (mustExist == 2) goto L29;
    L33:
        List<String> result = new ArrayList();
        Iterator<Element> r3 = leafs.iterator();
    L35:
        if (r3.hasNext() == false) goto L37;
        Element leaf = r3.next();
        result.add(leaf.getTextContent().replaceAll("\\s", ""));
        goto L35
    L37:
        return result;
    L29:
        if (leafs.size() != 0) goto L33;
        throw new CertParsingException("The XML file must contain at least one node with the path " + String.join(SliceClientPermissions.SliceAuthority.DELIMITER, nodeTags));
    L39:
        throw new CertParsingException("The tag list must not be empty");
    }

    private static List<Element> getXmlDirectChildren(Element parent, String tag) {
        List<Element> children = new ArrayList();
        NodeList childNodes = parent.getChildNodes();
        int i = 0;
    L4:
        if (i >= childNodes.getLength()) goto L12;
        Node node = childNodes.item(i);
        if (node.getNodeType() != 1) goto L10;
        if (node.getNodeName().equals(tag) == false) goto L10;
        children.add((Element) node);
    L10:
        i = i + 1;
        goto L4
    L12:
        return children;
    }

    public static byte[] decodeBase64(String str) throws CertParsingException {
        return Base64.getDecoder().decode(str);
    L4:
        e = move-exception;
        throw new CertParsingException(e);
    }

    static void verifyRsaSha256Signature(PublicKey signerPublicKey, byte[] signature, byte[] signedBytes) throws CertValidationException {
        Signature verifier = Signature.getInstance(SIGNATURE_ALG);     // Catch: NoSuchAlgorithmException -> L11
        verifier.initVerify(signerPublicKey);     // Catch: Throwable -> L8
        verifier.update(signedBytes);     // Catch: Throwable -> L8
        if (verifier.verify(signature) == false) goto L7;
        return;
    L7:
        throw new CertValidationException("The signature is invalid");     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        throw new CertValidationException(e);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static CertPath validateCert(Date validationDate, X509Certificate trustedRoot, List<X509Certificate> intermediateCerts, X509Certificate leafCert) throws CertValidationException {
        PKIXParameters pkixParams = buildPkixParams(validationDate, trustedRoot, intermediateCerts, leafCert);
        CertPath certPath = buildCertPath(pkixParams);
        CertPathValidator certPathValidator = CertPathValidator.getInstance(CERT_PATH_ALG);     // Catch: NoSuchAlgorithmException -> L9
        certPathValidator.validate(certPath, pkixParams);     // Catch: Throwable -> L6
        return certPath;
    L6:
        e = move-exception;
        throw new CertValidationException(e);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void validateCertPath(X509Certificate trustedRoot, CertPath certPath, Date validationDate) throws CertValidationException {
        validateCertPath(validationDate, trustedRoot, certPath);
    }

    static void validateCertPath(Date validationDate, X509Certificate trustedRoot, CertPath certPath) throws CertValidationException {
        if (certPath.getCertificates().isEmpty() == true) goto L11;
        if ((certPath.getCertificates().get(0) instanceof X509Certificate) == false) goto L9;
        List<? extends Certificate> r0 = certPath.getCertificates();
        X509Certificate leafCert = (X509Certificate) r0.get(0);
        validateCert(validationDate, trustedRoot, r0.subList(1, r0.size()), leafCert);
        return;
    L9:
        throw new CertValidationException("The given certificate path does not contain X509 certificates");
    L11:
        throw new CertValidationException("The given certificate path is empty");
    }

    static CertPath buildCertPath(PKIXParameters pkixParams) throws CertValidationException {
        CertPathBuilder certPathBuilder = CertPathBuilder.getInstance(CERT_PATH_ALG);     // Catch: NoSuchAlgorithmException -> L8
        return certPathBuilder.build(pkixParams).getCertPath();
    L5:
        e = move-exception;
        throw new CertValidationException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    static PKIXParameters buildPkixParams(Date validationDate, X509Certificate trustedRoot, List<X509Certificate> intermediateCerts, X509Certificate leafCert) throws CertValidationException {
        Set<TrustAnchor> trustedAnchors = new HashSet();
        trustedAnchors.add(new TrustAnchor(trustedRoot, null));
        List<X509Certificate> certs = new ArrayList(intermediateCerts);
        certs.add(leafCert);
        CertStore certStore = CertStore.getInstance(CERT_STORE_ALG, new CollectionCertStoreParameters(certs));     // Catch: InvalidAlgorithmParameterException -> L11 NoSuchAlgorithmException -> L13
        X509CertSelector certSelector = new X509CertSelector();
        certSelector.setCertificate(leafCert);
        PKIXBuilderParameters pkixParams = new PKIXBuilderParameters(trustedAnchors, certSelector);     // Catch: InvalidAlgorithmParameterException -> L8
        pkixParams.addCertStore(certStore);
        pkixParams.setDate(validationDate);
        pkixParams.setRevocationEnabled(false);
        return pkixParams;
    L8:
        e = move-exception;
        throw new CertValidationException(e);
    L11:
        e = move-exception;
        throw new CertValidationException(e);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
