package com.networknt.schema.format;

import com.networknt.org.apache.commons.validator.routines.EmailValidator;

/* loaded from: classes2.dex */
class IPv6AwareEmailValidator extends EmailValidator {
    private static final long serialVersionUID = 1;

    public IPv6AwareEmailValidator(boolean z10, boolean z11) {
        super(z10, z11);
    }

    @Override // com.networknt.org.apache.commons.validator.routines.EmailValidator
    public boolean isValidDomain(String str) {
        if (str.startsWith("[IPv6:")) {
            str = str.replace("IPv6:", "");
        }
        return super.isValidDomain(str);
    }
}
