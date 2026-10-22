package z3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.utils.JsonType;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: z3.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2164i extends AbstractC2161f {
    public static final Pattern g = Pattern.compile("(application|audio|font|example|image|message|model|multipart|text|video|x-(?:[0-9A-Za-z!#$%&'*+.^_`|~-]+))/([0-9A-Za-z!#$%&'*+.^_`|~-]+)((?:[ \t]*;[ \t]*[0-9A-Za-z!#$%&'*+.^_`|~-]+=(?:[0-9A-Za-z!#$%&'*+.^_`|~-]+|\"(?:[^\"\\\\]|\\.)*\"))*)");
    public final String f;

    public C2164i(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        super(KeywordType.f3045j, jsonNode, jVar, iVar, cVar);
        this.f = jsonNode.textValue();
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        if (com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g) != JsonType.STRING) {
            return;
        }
        c(fVar);
        String strAsText = jsonNode.asText();
        String str = this.f;
        if ("application/json".equals(str)) {
            JsonNode jsonNode3 = this.e.g.get("contentEncoding");
            if ("base64".equals((jsonNode3 == null || !jsonNode3.isTextual()) ? null : jsonNode3.asText())) {
                try {
                    strAsText = new String(Base64.getDecoder().decode(strAsText), StandardCharsets.UTF_8);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
            try {
                D3.b.f377a.readTree(strAsText);
                return;
            } catch (JsonProcessingException unused2) {
            }
        } else if (g.matcher(str).matches()) {
            return;
        }
        u3.g gVarJ = j();
        gVarJ.getClass();
        gVarJ.d = aVar;
        gVarJ.b = fVar.f;
        gVarJ.k = (Locale) fVar.f6698a.f177a;
        gVarJ.e = new Object[]{str};
        fVar.a(gVarJ.a());
    }
}
