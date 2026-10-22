package com.networknt.org.apache.commons.validator.routines;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class EmailValidator implements Serializable {
    private static final int MAX_USERNAME_LEN = 64;
    private static final String QUOTED_USER = "(\"(\\\\\"|[^\"])*\")";
    private static final String SPECIAL_CHARS = "\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]";
    private static final String VALID_CHARS = "(\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]";
    private static final String WORD = "(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\"))";
    private static final long serialVersionUID = 1705927040799295880L;
    private final boolean allowTld;
    private final DomainValidator domainValidator;
    private static final String EMAIL_REGEX = "^(.+)@(\\S+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String IP_DOMAIN_REGEX = "^\\[(.*)\\]$";
    private static final Pattern IP_DOMAIN_PATTERN = Pattern.compile(IP_DOMAIN_REGEX);
    private static final String USER_REGEX = "^(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\"))(\\.(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"(\\\\\"|[^\"])*\")))*$";
    private static final Pattern USER_PATTERN = Pattern.compile(USER_REGEX);
    private static final EmailValidator EMAIL_VALIDATOR = new EmailValidator(false, false);
    private static final EmailValidator EMAIL_VALIDATOR_WITH_TLD = new EmailValidator(false, true);
    private static final EmailValidator EMAIL_VALIDATOR_WITH_LOCAL = new EmailValidator(true, false);
    private static final EmailValidator EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD = new EmailValidator(true, true);

    public EmailValidator(boolean z10) {
        this(z10, false);
    }

    public static EmailValidator getInstance() {
        return EMAIL_VALIDATOR;
    }

    public boolean isValid(String str) {
        if (str == null || str.endsWith(".")) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(str);
        if (matcher.matches() && isValidUser(matcher.group(1))) {
            return isValidDomain(matcher.group(2));
        }
        return false;
    }

    public boolean isValidDomain(String str) {
        Matcher matcher = IP_DOMAIN_PATTERN.matcher(str);
        return matcher.matches() ? InetAddressValidator.a().b(matcher.group(1)) : this.allowTld ? this.domainValidator.f(str) || (!str.startsWith(".") && this.domainValidator.k(str)) : this.domainValidator.f(str);
    }

    public boolean isValidUser(String str) {
        if (str == null || str.length() > 64) {
            return false;
        }
        return USER_PATTERN.matcher(str).matches();
    }

    public EmailValidator(boolean z10, boolean z11) {
        this.allowTld = z11;
        this.domainValidator = DomainValidator.c(z10);
    }

    public static EmailValidator getInstance(boolean z10) {
        return getInstance(z10, false);
    }

    public static EmailValidator getInstance(boolean z10, boolean z11) {
        if (z10) {
            if (z11) {
                return EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD;
            }
            return EMAIL_VALIDATOR_WITH_LOCAL;
        }
        if (z11) {
            return EMAIL_VALIDATOR_WITH_TLD;
        }
        return EMAIL_VALIDATOR;
    }

    public EmailValidator(boolean z10, boolean z11, DomainValidator domainValidator) {
        this.allowTld = z11;
        if (domainValidator != null) {
            if (domainValidator.d() == z10) {
                this.domainValidator = domainValidator;
                return;
            }
            throw new IllegalArgumentException("DomainValidator must agree with allowLocal setting");
        }
        throw new IllegalArgumentException("DomainValidator cannot be null");
    }
}
