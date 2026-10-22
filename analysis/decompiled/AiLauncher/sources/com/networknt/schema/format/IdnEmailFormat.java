package com.networknt.schema.format;

import com.networknt.org.apache.commons.validator.routines.EmailValidator;
import com.networknt.schema.ExecutionContext;

/* loaded from: classes2.dex */
public class IdnEmailFormat implements Format {
    private final EmailValidator emailValidator;

    public IdnEmailFormat() {
        this(new IPv6AwareEmailValidator(true, true));
    }

    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.idn-email";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "idn-email";
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, String str) {
        return this.emailValidator.isValid(str);
    }

    public IdnEmailFormat(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }
}
