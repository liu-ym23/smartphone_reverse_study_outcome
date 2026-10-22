package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.subtle.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import m7.f;
import m7.j;
import m7.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JsonKeysetWriter implements KeysetWriter {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final OutputStream outputStream;

    private JsonKeysetWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    private j toJson(Keyset.Key key) {
        j jVar = new j();
        jVar.j("keyData", toJson(key.getKeyData()));
        jVar.l("status", key.getStatus().name());
        jVar.k("keyId", Long.valueOf(toUnsignedLong(key.getKeyId())));
        jVar.l("outputPrefixType", key.getOutputPrefixType().name());
        return jVar;
    }

    private long toUnsignedLong(int i) {
        return i & 4294967295L;
    }

    @Deprecated
    public static KeysetWriter withFile(File file) {
        return withOutputStream(new FileOutputStream(file));
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream) {
        return new JsonKeysetWriter(outputStream);
    }

    @Deprecated
    public static KeysetWriter withPath(String str) {
        return withOutputStream(new FileOutputStream(new File(str)));
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        try {
            try {
                OutputStream outputStream = this.outputStream;
                String string = toJson(keyset).toString();
                Charset charset = UTF_8;
                outputStream.write(string.getBytes(charset));
                this.outputStream.write(System.lineSeparator().getBytes(charset));
            } catch (k e10) {
                throw new IOException(e10);
            }
        } finally {
            this.outputStream.close();
        }
    }

    @Deprecated
    public static KeysetWriter withPath(Path path) {
        return withOutputStream(new FileOutputStream(path.toFile()));
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset encryptedKeyset) throws IOException {
        OutputStream outputStream = this.outputStream;
        String string = toJson(encryptedKeyset).toString();
        Charset charset = UTF_8;
        outputStream.write(string.getBytes(charset));
        this.outputStream.write(System.lineSeparator().getBytes(charset));
        this.outputStream.close();
    }

    private j toJson(Keyset keyset) {
        j jVar = new j();
        jVar.k("primaryKeyId", Long.valueOf(toUnsignedLong(keyset.getPrimaryKeyId())));
        f fVar = new f();
        Iterator<Keyset.Key> it = keyset.getKeyList().iterator();
        while (it.hasNext()) {
            fVar.k(toJson(it.next()));
        }
        jVar.j("key", fVar);
        return jVar;
    }

    private j toJson(KeyData keyData) {
        j jVar = new j();
        jVar.l("typeUrl", keyData.getTypeUrl());
        jVar.l("value", Base64.encode(keyData.getValue().toByteArray()));
        jVar.l("keyMaterialType", keyData.getKeyMaterialType().name());
        return jVar;
    }

    private j toJson(EncryptedKeyset encryptedKeyset) {
        j jVar = new j();
        jVar.l("encryptedKeyset", Base64.encode(encryptedKeyset.getEncryptedKeyset().toByteArray()));
        jVar.j("keysetInfo", toJson(encryptedKeyset.getKeysetInfo()));
        return jVar;
    }

    private j toJson(KeysetInfo keysetInfo) {
        j jVar = new j();
        jVar.k("primaryKeyId", Long.valueOf(toUnsignedLong(keysetInfo.getPrimaryKeyId())));
        f fVar = new f();
        Iterator<KeysetInfo.KeyInfo> it = keysetInfo.getKeyInfoList().iterator();
        while (it.hasNext()) {
            fVar.k(toJson(it.next()));
        }
        jVar.j("keyInfo", fVar);
        return jVar;
    }

    private j toJson(KeysetInfo.KeyInfo keyInfo) {
        j jVar = new j();
        jVar.l("typeUrl", keyInfo.getTypeUrl());
        jVar.l("status", keyInfo.getStatus().name());
        jVar.k("keyId", Long.valueOf(toUnsignedLong(keyInfo.getKeyId())));
        jVar.l("outputPrefixType", keyInfo.getOutputPrefixType().name());
        return jVar;
    }
}
