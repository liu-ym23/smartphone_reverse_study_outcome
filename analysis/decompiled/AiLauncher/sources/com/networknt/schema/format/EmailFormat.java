package com.networknt.schema.format;

import com.networknt.org.apache.commons.validator.routines.EmailValidator;
import com.networknt.schema.ExecutionContext;

/* loaded from: classes2.dex */
public class EmailFormat implements Format {
    private final EmailValidator emailValidator;

    public EmailFormat() {
        this(new IPv6AwareEmailValidator(true, true));
    }

    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.email";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "email";
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, String str) {
        return this.emailValidator.isValid(str);
    }

    public EmailFormat(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }
}
