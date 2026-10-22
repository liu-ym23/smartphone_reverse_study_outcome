package com.networknt.schema.regex;

import com.networknt.schema.Error;
import com.networknt.schema.InvalidSchemaException;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class AllowRegularExpressionFactory implements RegularExpressionFactory {
    private final Predicate<String> allowed;
    private final RegularExpressionFactory delegate;

    public AllowRegularExpressionFactory(RegularExpressionFactory regularExpressionFactory, Predicate<String> predicate) {
        this.delegate = regularExpressionFactory;
        this.allowed = predicate;
    }

    @Override // com.networknt.schema.regex.RegularExpressionFactory
    public RegularExpression getRegularExpression(String str) {
        if (this.allowed.test(str)) {
            return this.delegate.getRegularExpression(str);
        }
        throw new InvalidSchemaException(Error.builder().message("Regular expression ''{0}'' is not allowed to be used.").arguments(str).build());
    }
}
