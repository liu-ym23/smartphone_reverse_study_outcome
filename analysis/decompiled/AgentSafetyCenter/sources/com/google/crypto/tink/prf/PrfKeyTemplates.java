package com.google.crypto.tink.prf;

import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PrfKeyTemplates {
    public static final KeyTemplate HKDF_SHA256 = createHkdfKeyTemplate();
    public static final KeyTemplate HMAC_SHA256_PRF = createHmacTemplate(32, HashType.SHA256);
    public static final KeyTemplate HMAC_SHA512_PRF = createHmacTemplate(64, HashType.SHA512);
    public static final KeyTemplate AES_CMAC_PRF = createAes256CmacTemplate();

    private PrfKeyTemplates() {
    }

    private static KeyTemplate createAes256CmacTemplate() {
        return KeyTemplate.newBuilder().setTypeUrl(new AesCmacPrfKeyManager().getKeyType()).setValue(AesCmacPrfKeyFormat.newBuilder().setKeySize(32).build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate createHkdfKeyTemplate() {
        return KeyTemplate.newBuilder().setValue(HkdfPrfKeyFormat.newBuilder().setKeySize(32).setParams(HkdfPrfParams.newBuilder().setHash(HashType.SHA256)).build().toByteString()).setTypeUrl(HkdfPrfKeyManager.staticKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate createHmacTemplate(int i, HashType hashType) {
        return KeyTemplate.newBuilder().setTypeUrl(new HmacPrfKeyManager().getKeyType()).setValue(HmacPrfKeyFormat.newBuilder().setParams(HmacPrfParams.newBuilder().setHash(hashType).build()).setKeySize(i).build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }
}
