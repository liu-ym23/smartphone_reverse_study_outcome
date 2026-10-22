package b8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends f {

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f1970h = Pattern.compile("(application|audio|font|example|image|message|model|multipart|text|video|x-(?:[0-9A-Za-z!#$%&'*+.^_`|~-]+))/([0-9A-Za-z!#$%&'*+.^_`|~-]+)((?:[ \t]*;[ \t]*[0-9A-Za-z!#$%&'*+.^_`|~-]+=(?:[0-9A-Za-z!#$%&'*+.^_`|~-]+|\"(?:[^\"\\\\]|\\.)*\"))*)");

    /* renamed from: g, reason: collision with root package name */
    public String f1971g;

    @Override // b8.a, w7.s
    public final void b(w7.f fVar, JsonNode jsonNode, JsonNode jsonNode2, c8.a aVar) {
        String str = this.f1971g;
        if (td.h.x(jsonNode, ((w7.o) this.f1954d.f1601d).f15349g) != 3) {
            return;
        }
        c(fVar);
        String strAsText = jsonNode.asText();
        if ("application/json".equals(str)) {
            JsonNode jsonNode3 = this.f1955e.f15331g.get("contentEncoding");
            if ("base64".equals((jsonNode3 == null || !jsonNode3.isTextual()) ? null : jsonNode3.asText())) {
                try {
                    strAsText = new String(Base64.getDecoder().decode(strAsText), StandardCharsets.UTF_8);
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
            try {
                f8.c.f4042a.readTree(strAsText);
                return;
            } catch (JsonProcessingException unused2) {
            }
        } else if (f1970h.matcher(str).matches()) {
            return;
        }
        w7.j jVarJ = j();
        jVarJ.f15293d = aVar;
        jVarJ.f15291b = fVar.f15311f;
        jVarJ.f15319l = (Locale) fVar.f15306a.f7721f;
        jVarJ.f15294e = new Object[]{str};
        fVar.a(jVarJ.a());
    }
}
