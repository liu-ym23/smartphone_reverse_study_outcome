package com.android.server.pm;

import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.am.AssistDataRequester;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class PackageSignatures {
    SigningDetails mSigningDetails;

    PackageSignatures(PackageSignatures orig) {
        if (orig != null) goto L5;
    L7:
        this.mSigningDetails = SigningDetails.UNKNOWN;
        return;
    L5:
        if (orig.mSigningDetails == SigningDetails.UNKNOWN) goto L7;
        this.mSigningDetails = new SigningDetails(orig.mSigningDetails);
    }

    PackageSignatures(SigningDetails signingDetails) {
        this.mSigningDetails = signingDetails;
    }

    PackageSignatures() {
        this.mSigningDetails = SigningDetails.UNKNOWN;
    }

    void writeXml(TypedXmlSerializer serializer, String tagName, ArrayList<Signature> writtenSignatures) throws IOException {
        if (this.mSigningDetails.getSignatures() != null) goto L5;
        return;
    L5:
        serializer.startTag(null, tagName);
        serializer.attributeInt(null, AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, this.mSigningDetails.getSignatures().length);
        serializer.attributeInt(null, "schemeVersion", this.mSigningDetails.getSignatureSchemeVersion());
        writeCertsListXml(serializer, writtenSignatures, this.mSigningDetails.getSignatures(), false);
        if (this.mSigningDetails.getPastSigningCertificates() == null) goto L8;
        serializer.startTag(null, "pastSigs");
        serializer.attributeInt(null, AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, this.mSigningDetails.getPastSigningCertificates().length);
        writeCertsListXml(serializer, writtenSignatures, this.mSigningDetails.getPastSigningCertificates(), true);
        serializer.endTag(null, "pastSigs");
    L8:
        serializer.endTag(null, tagName);
    }

    private void writeCertsListXml(TypedXmlSerializer serializer, ArrayList<Signature> writtenSignatures, Signature[] signatures, boolean isPastSigs) throws IOException {
        int i = 0;
    L4:
        if (i >= signatures.length) goto L20;
        serializer.startTag(null, "cert");
        Signature sig = signatures[i];
        int sigHash = sig.hashCode();
        int numWritten = writtenSignatures.size();
        int j = 0;
    L7:
        if (j >= numWritten) goto L14;
        Signature writtenSig = writtenSignatures.get(j);
        if (writtenSig.hashCode() != sigHash) goto L13;
        if (writtenSig.equals(sig) == false) goto L13;
        serializer.attributeInt(null, AssistDataRequester.KEY_RECEIVER_EXTRA_INDEX, j);
    L13:
        j = j + 1;
    L14:
        if (j < numWritten) goto L16;
        writtenSignatures.add(sig);
        serializer.attributeInt(null, AssistDataRequester.KEY_RECEIVER_EXTRA_INDEX, numWritten);
        sig.writeToXmlAttributeBytesHex(serializer, null, "key");
    L16:
        if (isPastSigs == false) goto L18;
        serializer.attributeInt(null, "flags", sig.getFlags());
    L18:
        serializer.endTag(null, "cert");
        i = i + 1;
        goto L4
    }

    void readXml(TypedXmlPullParser parser, ArrayList<Signature> readSignatures) throws IOException, XmlPullParserException {
        SigningDetails.Builder builder = new SigningDetails.Builder();
        int count = parser.getAttributeInt(null, AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, -1);
        if (count != (-1)) goto L6;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <sigs> has no count at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        return;
    L6:
        int signatureSchemeVersion = parser.getAttributeInt(null, "schemeVersion", 0);
        if (signatureSchemeVersion != 0) goto L9;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <sigs> has no schemeVersion at " + parser.getPositionDescription());
    L9:
        builder.setSignatureSchemeVersion(signatureSchemeVersion);
        ArrayList<Signature> signatureList = new ArrayList();
        int pos = readCertsListXml(parser, readSignatures, signatureList, count, false, builder);
        Signature[] signatures = (Signature[]) signatureList.toArray(new Signature[signatureList.size()]);
        builder.setSignatures(signatures);
        if (pos >= count) goto L17;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <sigs> count does not match number of  <cert> entries" + parser.getPositionDescription());
    L17:
        this.mSigningDetails = builder.build();     // Catch: CertificateException -> L14
        return;
    L15:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <sigs> unable to convert certificate(s) to public key(s).");
        this.mSigningDetails = SigningDetails.UNKNOWN;
    }

    private int readCertsListXml(TypedXmlPullParser parser, ArrayList<Signature> readSignatures, ArrayList<Signature> signatures, int count, boolean isPastSigs, SigningDetails.Builder builder) throws IOException, XmlPullParserException {
        parser = parser;
        readSignatures = readSignatures;
        signatures = signatures;
        int outerDepth = parser.getDepth();
        SigningDetails.Builder builder2 = builder;
        int pos = 0;
    L3:
        int type = parser.next();
        if (type == 1) goto L87;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        String tagName = parser.getName();
        if (tagName.equals("cert") == true) goto L16;
        if (tagName.equals("pastSigs") == false) goto L84;
        if (isPastSigs == true) goto L83;
        int pastSigsCount = parser.getAttributeInt(null, AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, -1);
        if (pastSigsCount != (-1)) goto L88;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <pastSigs> has no count at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L88:
        ArrayList<Signature> pastSignatureList = new ArrayList();     // Catch: NumberFormatException -> L79
        int r8 = 5;
        int pastSigsPos = readCertsListXml(parser, readSignatures, pastSignatureList, pastSigsCount, true, builder2);     // Catch: NumberFormatException -> L76
        Signature[] pastSignatures = (Signature[]) pastSignatureList.toArray(new Signature[pastSignatureList.size()]);     // Catch: NumberFormatException -> L76
        builder2 = builder2.setPastSigningCertificates(pastSignatures);     // Catch: NumberFormatException -> L76
        if (pastSigsPos >= pastSigsCount) goto L3;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <pastSigs> count does not match number of <cert> entries " + parser.getPositionDescription());     // Catch: NumberFormatException -> L76
    L81:
        PackageManagerService.reportSettingsProblem(r8, "Error in package manager settings: <pastSigs> count " + pastSigsCount + " is not a number at " + parser.getPositionDescription());
    L80:
        r8 = 5;
        goto L81
    L83:
        PackageManagerService.reportSettingsProblem(5, "<pastSigs> encountered multiple times under the same <sigs> at " + parser.getPositionDescription());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L84:
        PackageManagerService.reportSettingsProblem(5, "Unknown element under <sigs>: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L16:
        if (pos >= count) goto L61;
        int index = parser.getAttributeInt(null, AssistDataRequester.KEY_RECEIVER_EXTRA_INDEX, -1);
        if (index == (-1)) goto L59;
        boolean signatureParsed = false;
        byte[] key = parser.getAttributeBytesHex(null, "key", null);     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
        if (key != null) goto L38;
        if (index >= 0) goto L24;
    L37:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <cert> index " + index + " is out of bounds at " + parser.getPositionDescription());     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
    L47:
        if (isPastSigs == false) goto L62;
        int flagsValue = parser.getAttributeInt(null, "flags", -1);
        if (flagsValue == (-1)) goto L57;
        if (signatureParsed == true) goto L90;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: signature not available at index " + pos + " to set flags at " + parser.getPositionDescription());     // Catch: NumberFormatException -> L52
        goto L62
    L90:
        signatures.get(signatures.size() - 1).setFlags(flagsValue);     // Catch: NumberFormatException -> L52
    L56:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <cert> flags " + flagsValue + " is not a number at " + parser.getPositionDescription());
        goto L62
    L57:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <cert> has no flags at " + parser.getPositionDescription());
    L62:
        pos = pos + 1;
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L24:
        if (index >= readSignatures.size()) goto L37;
        Signature sig = readSignatures.get(index);     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
        if (sig == null) goto L35;
        if (isPastSigs == false) goto L33;
        signatures.add(new Signature(sig));     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
    L34:
        signatureParsed = true;
        goto L47
    L33:
        signatures.add(sig);     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
        goto L34
    L35:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <cert> index " + index + " is not defined at " + parser.getPositionDescription());     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
        goto L47
    L38:
        Signature sig2 = new Signature(key);     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
    L40:
        if (readSignatures.size() >= index) goto L42;
        readSignatures.add(null);     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
        goto L40
    L42:
        readSignatures.add(sig2);     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
        signatures.add(sig2);     // Catch: IllegalArgumentException -> L29 NumberFormatException -> L31
        signatureParsed = true;
        goto L47
    L29:
        e = move-exception;
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <cert> index " + index + " has an invalid signature at " + parser.getPositionDescription() + ": " + e.getMessage());
    L46:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <cert> index " + index + " is not a number at " + parser.getPositionDescription());
        goto L47
    L59:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: <cert> has no index at " + parser.getPositionDescription());
        goto L62
    L61:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: too many <cert> tags, expected " + count + " at " + parser.getPositionDescription());
        goto L62
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
    L87:
        return pos;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append("PackageSignatures{");
        buf.append(Integer.toHexString(System.identityHashCode(this)));
        buf.append(" version:");
        buf.append(this.mSigningDetails.getSignatureSchemeVersion());
        buf.append(", signatures:[");
        if (this.mSigningDetails.getSignatures() == null) goto L10;
        int i = 0;
    L6:
        if (i >= this.mSigningDetails.getSignatures().length) goto L10;
        if (i <= 0) goto L9;
        buf.append(", ");
    L9:
        buf.append(Integer.toHexString(this.mSigningDetails.getSignatures()[i].hashCode()));
        i = i + 1;
    L10:
        buf.append("]");
        buf.append(", past signatures:[");
        if (this.mSigningDetails.getPastSigningCertificates() == null) goto L18;
        int i2 = 0;
    L14:
        if (i2 >= this.mSigningDetails.getPastSigningCertificates().length) goto L18;
        if (i2 <= 0) goto L17;
        buf.append(", ");
    L17:
        buf.append(Integer.toHexString(this.mSigningDetails.getPastSigningCertificates()[i2].hashCode()));
        buf.append(" flags: ");
        buf.append(Integer.toHexString(this.mSigningDetails.getPastSigningCertificates()[i2].getFlags()));
        i2 = i2 + 1;
    L18:
        buf.append("]}");
        return buf.toString();
    }
}
