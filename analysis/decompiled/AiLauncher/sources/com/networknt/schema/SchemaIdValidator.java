package com.networknt.schema;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes2.dex */
public interface SchemaIdValidator {
    public static final SchemaIdValidator DEFAULT = new DefaultSchemaIdValidator();

    public static class DefaultSchemaIdValidator implements SchemaIdValidator {
        public boolean hasNoContext(SchemaLocation schemaLocation) {
            return schemaLocation.getAbsoluteIri() == null || schemaLocation.toString().startsWith(Const.STR_MART_WELL);
        }

        public boolean isAbsoluteIri(String str) {
            if (!str.contains(ServerSentEventKt.COLON)) {
                return false;
            }
            try {
                new URI(str);
                return true;
            } catch (URISyntaxException unused) {
                return false;
            }
        }

        public boolean isFragment(String str) {
            return str.startsWith(Const.STR_MART_WELL);
        }

        public boolean startsWithSlash(String str) {
            return str.startsWith("/");
        }

        @Override // com.networknt.schema.SchemaIdValidator
        public boolean validate(String str, boolean z10, SchemaLocation schemaLocation, SchemaLocation schemaLocation2, SchemaContext schemaContext) {
            if (hasNoContext(schemaLocation) && (isFragment(str) || startsWithSlash(str))) {
                return true;
            }
            return schemaLocation2.getAbsoluteIri() != null && isAbsoluteIri(schemaLocation2.getAbsoluteIri().toString());
        }
    }

    boolean validate(String str, boolean z10, SchemaLocation schemaLocation, SchemaLocation schemaLocation2, SchemaContext schemaContext);
}
