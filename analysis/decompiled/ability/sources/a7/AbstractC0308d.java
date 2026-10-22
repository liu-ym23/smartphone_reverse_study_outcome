package a7;

import F.g;
import c7.C0881a;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.volcengine.tos.TosClientException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: a7.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0308d {
    public static Object a(InputStream inputStream, TypeReference typeReference) {
        try {
            return f.b.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new TosClientException("tos: unable to do deserialization", e);
        }
    }

    public static Object b(String str, TypeReference typeReference) {
        try {
            return f.b.readValue(str, typeReference);
        } catch (IOException e) {
            throw new TosClientException(B7.a.k("tos: unable to do deserialization of ", str), e);
        }
    }

    public static g c(Object obj) {
        try {
            byte[] bArrWriteValueAsBytes = f.b.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsBytes(obj);
            String str = new String(C0881a.c(MessageDigest.getInstance("MD5").digest(bArrWriteValueAsBytes)));
            g gVar = new g(4);
            gVar.b = str;
            gVar.c = bArrWriteValueAsBytes;
            return gVar;
        } catch (JsonProcessingException | NoSuchAlgorithmException e) {
            throw new TosClientException("tos: unable to do serialization", e);
        }
    }
}
