package com.networknt.schema.format;

import com.networknt.org.apache.commons.validator.routines.EmailValidator;

/* loaded from: classes3.dex */
class IPv6AwareEmailValidator extends EmailValidator {
    @Override // com.networknt.org.apache.commons.validator.routines.EmailValidator
    public final boolean b(String str) {
        if (str.startsWith("[IPv6:")) {
            str = str.replace("IPv6:", "");
        }
        return super.b(str);
    }
}
