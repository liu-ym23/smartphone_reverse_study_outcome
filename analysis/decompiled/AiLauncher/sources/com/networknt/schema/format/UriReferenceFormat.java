package com.networknt.schema.format;

import java.net.URI;
import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public class UriReferenceFormat extends AbstractRFC3986Format {
    public static /* synthetic */ boolean a(int i10) {
        return i10 < 127;
    }

    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.uri-reference";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "uri-reference";
    }

    @Override // com.networknt.schema.format.AbstractRFC3986Format
    public boolean validate(URI uri) {
        String rawQuery;
        boolean zAllMatch = uri.toString().codePoints().allMatch(new IntPredicate() { // from class: com.networknt.schema.format.d
            @Override // java.util.function.IntPredicate
            public final boolean test(int i10) {
                return UriReferenceFormat.a(i10);
            }
        });
        if (!zAllMatch || (rawQuery = uri.getRawQuery()) == null) {
            return zAllMatch;
        }
        if (rawQuery.indexOf(91) == -1 && rawQuery.indexOf(93) == -1) {
            return zAllMatch;
        }
        return false;
    }
}
