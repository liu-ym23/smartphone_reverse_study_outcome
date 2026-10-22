package z3;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.FailFastAssertionException;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import com.networknt.schema.utils.JsonType;
import java.util.Locale;
import java.util.Optional;

/* loaded from: classes3.dex */
public final class B extends AbstractC2161f {
    public static final InterfaceC0315b h = AbstractC0317d.b(B.class);
    public final String f;
    public final B3.c g;

    public B(u3.j jVar, JsonNode jsonNode, u3.i iVar, G6.c cVar) {
        super(KeywordType.f3029R, jsonNode, jVar, iVar, cVar);
        String str = (String) Optional.ofNullable(jsonNode).filter(new S6.c(18)).map(new reactor.util.retry.a(8)).orElse(null);
        this.f = str;
        try {
            this.g = B3.c.a(str, cVar);
        } catch (RuntimeException e) {
            e.setStackTrace(new StackTraceElement[0]);
            h.i("Failed to compile pattern '{}': {}", this.f, e.getMessage());
            throw e;
        }
    }

    @Override // z3.AbstractC2156a, u3.m
    public final void a(u3.f fVar, JsonNode jsonNode, JsonNode jsonNode2, A3.a aVar) {
        String str = this.f;
        if (com.stepos.ability.task.executor.e.D(jsonNode, ((u3.k) this.d.d).g) != JsonType.STRING) {
            return;
        }
        try {
            if (this.g.matches(jsonNode.asText())) {
                return;
            }
            u3.g gVarJ = j();
            gVarJ.getClass();
            gVarJ.d = aVar;
            gVarJ.b = fVar.f;
            gVarJ.k = (Locale) fVar.f6698a.f177a;
            gVarJ.e = new Object[]{str};
            fVar.a(gVarJ.a());
        } catch (FailFastAssertionException | SchemaException e) {
            throw e;
        } catch (RuntimeException e6) {
            h.error("Failed to apply pattern '{}' at {}: {}", str, aVar, e6.getMessage());
            throw e6;
        }
    }
}
