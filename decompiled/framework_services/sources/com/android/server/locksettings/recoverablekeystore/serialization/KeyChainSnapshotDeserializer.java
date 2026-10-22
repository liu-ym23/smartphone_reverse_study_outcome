package com.android.server.locksettings.recoverablekeystore.serialization;

import android.security.keystore.recovery.KeyChainProtectionParams;
import android.security.keystore.recovery.KeyChainSnapshot;
import android.security.keystore.recovery.KeyDerivationParams;
import android.security.keystore.recovery.WrappedApplicationKey;
import android.util.Base64;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class KeyChainSnapshotDeserializer {
    public static KeyChainSnapshot deserialize(InputStream inputStream) throws KeyChainSnapshotParserException, IOException {
        return deserializeInternal(inputStream);
    L4:
        e = move-exception;
        throw new KeyChainSnapshotParserException("Malformed KeyChainSnapshot XML", e);
    }

    private static KeyChainSnapshot deserializeInternal(InputStream inputStream) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        TypedXmlPullParser parser = Xml.resolvePullParser(inputStream);
        parser.nextTag();
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, "keyChainSnapshot");
        KeyChainSnapshot.Builder builder = new KeyChainSnapshot.Builder();
    L3:
        byte r5 = 3;
        if (parser.next() == 3) goto L57;
        if (parser.getEventType() != 2) goto L3;
        String name = parser.getName();
        switch(name.hashCode()) {
            case -1719931702: goto L36;
            case -1388433662: goto L33;
            case -1370381871: goto L30;
            case -1368437758: goto L27;
            case 481270388: goto L24;
            case 1190285858: goto L21;
            case 1352257591: goto L18;
            case 1596875199: goto L15;
            case 1806980777: goto L12;
            default: goto L38;
        };
    L38:
        r5 = -1;
    L39:
        switch(r5) {
            case 0: goto L55;
            case 1: goto L54;
            case 2: goto L53;
            case 3: goto L52;
            case 4: goto L51;
            case 5: goto L65;
            case 6: goto L3;
            case 7: goto L43;
            case 8: goto L42;
            default: goto L41;
        };
    L65:
        builder.setTrustedHardwareCertPath(readCertPathTag(parser, "thmCertPath"));     // Catch: CertificateException -> L48
    L48:
        e = move-exception;
        throw new KeyChainSnapshotParserException("Could not set trustedHardwareCertPath", e);
    L41:
        throw new KeyChainSnapshotParserException(String.format(Locale.US, "Unexpected tag %s in keyChainSnapshot", new Object[]{name}));
    L42:
        builder.setWrappedApplicationKeys(readWrappedApplicationKeys(parser));
        goto L3
    L43:
        builder.setKeyChainProtectionParams(readKeyChainProtectionParamsList(parser));
        goto L3
    L51:
        builder.setMaxAttempts(readIntTag(parser, "maxAttempts"));
        goto L3
    L52:
        builder.setServerParams(readBlobTag(parser, "serverParams"));
        goto L3
    L53:
        builder.setCounterId(readLongTag(parser, "counterId"));
        goto L3
    L54:
        builder.setEncryptedRecoveryKeyBlob(readBlobTag(parser, "recoveryKeyMaterial"));
        goto L3
    L55:
        builder.setSnapshotVersion(readIntTag(parser, "snapshotVersion"));
        goto L3
    L12:
        if (name.equals("serverParams") == false) goto L38;
    L15:
        if (name.equals("keyChainProtectionParamsList") == false) goto L38;
        r5 = 7;
        goto L39
    L18:
        if (name.equals("counterId") == false) goto L38;
        r5 = 2;
        goto L39
    L21:
        if (name.equals("applicationKeysList") == false) goto L38;
        r5 = 8;
        goto L39
    L24:
        if (name.equals("snapshotVersion") == false) goto L38;
        r5 = 0;
        goto L39
    L27:
        if (name.equals("thmCertPath") == false) goto L38;
        r5 = 5;
        goto L39
    L30:
        if (name.equals("recoveryKeyMaterial") == false) goto L38;
        r5 = 1;
        goto L39
    L33:
        if (name.equals("backendPublicKey") == false) goto L38;
        r5 = 6;
        goto L39
    L36:
        if (name.equals("maxAttempts") == false) goto L38;
        r5 = 4;
        goto L39
    L57:
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, "keyChainSnapshot");
        return builder.build();
    L60:
        e = move-exception;
        throw new KeyChainSnapshotParserException("Failed to build KeyChainSnapshot", e);
    }

    private static List<WrappedApplicationKey> readWrappedApplicationKeys(TypedXmlPullParser parser) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, "applicationKeysList");
        ArrayList<WrappedApplicationKey> keys = new ArrayList();
    L4:
        if (parser.next() == 3) goto L9;
        if (parser.getEventType() != 2) goto L4;
        keys.add(readWrappedApplicationKey(parser));
        goto L4
    L9:
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, "applicationKeysList");
        return keys;
    }

    private static WrappedApplicationKey readWrappedApplicationKey(TypedXmlPullParser parser) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, "applicationKey");
        WrappedApplicationKey.Builder builder = new WrappedApplicationKey.Builder();
    L4:
        if (parser.next() == 3) goto L28;
        if (parser.getEventType() != 2) goto L4;
        String name = parser.getName();
        switch(name.hashCode()) {
            case -1712279890: goto L18;
            case -963209050: goto L15;
            case 92902992: goto L12;
            default: goto L20;
        };
    L20:
        byte r4 = -1;
    L21:
        switch(r4) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            default: goto L23;
        };
    L23:
        throw new KeyChainSnapshotParserException(String.format(Locale.US, "Unexpected tag %s in wrappedApplicationKey", new Object[]{name}));
    L25:
        builder.setEncryptedKeyMaterial(readBlobTag(parser, "keyMaterial"));
        goto L4
    L26:
        builder.setAlias(readStringTag(parser, "alias"));
        goto L4
    L24:
        builder.setMetadata(readBlobTag(parser, "keyMetadata"));
        goto L4
    L12:
        if (name.equals("alias") == false) goto L20;
        r4 = 0;
        goto L21
    L15:
        if (name.equals("keyMaterial") == false) goto L20;
        r4 = 1;
        goto L21
    L18:
        if (name.equals("keyMetadata") == false) goto L20;
        r4 = 2;
        goto L21
    L28:
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, "applicationKey");
        return builder.build();
    L31:
        e = move-exception;
        throw new KeyChainSnapshotParserException("Failed to build WrappedApplicationKey", e);
    }

    private static List<KeyChainProtectionParams> readKeyChainProtectionParamsList(TypedXmlPullParser parser) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, "keyChainProtectionParamsList");
        ArrayList<KeyChainProtectionParams> keyChainProtectionParamsList = new ArrayList();
    L4:
        if (parser.next() == 3) goto L9;
        if (parser.getEventType() != 2) goto L4;
        keyChainProtectionParamsList.add(readKeyChainProtectionParams(parser));
        goto L4
    L9:
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, "keyChainProtectionParamsList");
        return keyChainProtectionParamsList;
    }

    private static KeyChainProtectionParams readKeyChainProtectionParams(TypedXmlPullParser parser) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, "keyChainProtectionParams");
        KeyChainProtectionParams.Builder builder = new KeyChainProtectionParams.Builder();
    L4:
        if (parser.next() == 3) goto L28;
        if (parser.getEventType() != 2) goto L4;
        String name = parser.getName();
        switch(name.hashCode()) {
            case -776797115: goto L18;
            case -696958923: goto L15;
            case 912448924: goto L12;
            default: goto L20;
        };
    L20:
        byte r4 = -1;
    L21:
        switch(r4) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            default: goto L23;
        };
    L23:
        throw new KeyChainSnapshotParserException(String.format(Locale.US, "Unexpected tag %s in keyChainProtectionParams", new Object[]{name}));
    L25:
        builder.setUserSecretType(readIntTag(parser, "userSecretType"));
        goto L4
    L26:
        builder.setLockScreenUiFormat(readIntTag(parser, "lockScreenUiType"));
        goto L4
    L24:
        builder.setKeyDerivationParams(readKeyDerivationParams(parser));
        goto L4
    L12:
        if (name.equals("keyDerivationParams") == false) goto L20;
        r4 = 2;
        goto L21
    L15:
        if (name.equals("userSecretType") == false) goto L20;
        r4 = 1;
        goto L21
    L18:
        if (name.equals("lockScreenUiType") == false) goto L20;
        r4 = 0;
        goto L21
    L28:
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, "keyChainProtectionParams");
        return builder.build();
    L31:
        e = move-exception;
        throw new KeyChainSnapshotParserException("Failed to build KeyChainProtectionParams", e);
    }

    private static KeyDerivationParams readKeyDerivationParams(TypedXmlPullParser parser) throws XmlPullParserException, IOException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, "keyDerivationParams");
        int memoryDifficulty = -1;
        int algorithm = -1;
        byte[] salt = null;
    L4:
        if (parser.next() == 3) goto L28;
        if (parser.getEventType() != 2) goto L4;
        String name = parser.getName();
        switch(name.hashCode()) {
            case -973274212: goto L18;
            case 3522646: goto L15;
            case 225490031: goto L12;
            default: goto L20;
        };
    L20:
        byte r6 = -1;
    L21:
        switch(r6) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            default: goto L23;
        };
    L23:
        throw new KeyChainSnapshotParserException(String.format(Locale.US, "Unexpected tag %s in keyDerivationParams", new Object[]{name}));
    L25:
        algorithm = readIntTag(parser, "algorithm");
        goto L4
    L26:
        memoryDifficulty = readIntTag(parser, "memoryDifficulty");
        goto L4
    L24:
        salt = readBlobTag(parser, "salt");
        goto L4
    L12:
        if (name.equals("algorithm") == false) goto L20;
        r6 = 1;
        goto L21
    L15:
        if (name.equals("salt") == false) goto L20;
        r6 = 2;
        goto L21
    L18:
        if (name.equals("memoryDifficulty") == false) goto L20;
        r6 = 0;
        goto L21
    L28:
        if (salt == null) goto L38;
        switch(algorithm) {
            case 1: goto L34;
            case 2: goto L33;
            default: goto L32;
        };
    L33:
        KeyDerivationParams keyDerivationParams = KeyDerivationParams.createScryptParams(salt, memoryDifficulty);
    L35:
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, "keyDerivationParams");
        return keyDerivationParams;
    L34:
        keyDerivationParams = KeyDerivationParams.createSha256Params(salt);
        goto L35
    L32:
        throw new KeyChainSnapshotParserException("Unknown algorithm in keyDerivationParams");
    L38:
        throw new KeyChainSnapshotParserException("salt was not set in keyDerivationParams");
    }

    private static int readIntTag(TypedXmlPullParser parser, String tagName) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, tagName);
        String text = readText(parser);
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, tagName);
        return Integer.valueOf(text).intValue();
    L5:
        e = move-exception;
        throw new KeyChainSnapshotParserException(String.format(Locale.US, "%s expected int but got '%s'", new Object[]{tagName, text}), e);
    }

    private static long readLongTag(TypedXmlPullParser parser, String tagName) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, tagName);
        String text = readText(parser);
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, tagName);
        return Long.valueOf(text).longValue();
    L5:
        e = move-exception;
        throw new KeyChainSnapshotParserException(String.format(Locale.US, "%s expected long but got '%s'", new Object[]{tagName, text}), e);
    }

    private static String readStringTag(TypedXmlPullParser parser, String tagName) throws IOException, XmlPullParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, tagName);
        String text = readText(parser);
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, tagName);
        return text;
    }

    private static byte[] readBlobTag(TypedXmlPullParser parser, String tagName) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        parser.require(2, KeyChainSnapshotSchema.NAMESPACE, tagName);
        String text = readText(parser);
        parser.require(3, KeyChainSnapshotSchema.NAMESPACE, tagName);
        return Base64.decode(text, 0);
    L5:
        e = move-exception;
        throw new KeyChainSnapshotParserException(String.format(Locale.US, "%s expected base64 encoded bytes but got '%s'", new Object[]{tagName, text}), e);
    }

    private static CertPath readCertPathTag(TypedXmlPullParser parser, String tagName) throws IOException, XmlPullParserException, KeyChainSnapshotParserException {
        byte[] bytes = readBlobTag(parser, tagName);
        return CertificateFactory.getInstance("X.509").generateCertPath(new ByteArrayInputStream(bytes));
    L5:
        e = move-exception;
        throw new KeyChainSnapshotParserException("Could not parse CertPath in tag " + tagName, e);
    }

    private static String readText(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        if (parser.next() != 4) goto L6;
        String result = parser.getText();
        parser.nextTag();
        return result;
    L6:
        return "";
    }

    private KeyChainSnapshotDeserializer() {
    }
}
