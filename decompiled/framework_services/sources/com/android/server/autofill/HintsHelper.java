package com.android.server.autofill;

import android.util.ArraySet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class HintsHelper {
    public static final String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE = "creditCardExpirationDate";
    public static final String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY = "creditCardExpirationDay";
    public static final String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH = "creditCardExpirationMonth";
    public static final String AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR = "creditCardExpirationYear";
    public static final String AUTOFILL_HINT_CREDIT_CARD_NUMBER = "creditCardNumber";
    public static final String AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE = "creditCardSecurityCode";
    public static final String AUTOFILL_HINT_EMAIL_ADDRESS = "emailAddress";
    public static final String AUTOFILL_HINT_NEW_PASSWORD = "newPassword";
    public static final String AUTOFILL_HINT_NEW_USERNAME = "newUsername";
    public static final String AUTOFILL_HINT_PASSWORD = "password";
    public static final String AUTOFILL_HINT_PHONE = "phone";
    public static final String AUTOFILL_HINT_PHONE_COUNTRY_CODE = "phoneCountryCode";
    public static final String AUTOFILL_HINT_PHONE_NATIONAL = "phoneNational";
    public static final String AUTOFILL_HINT_PHONE_NUMBER = "phoneNumber";
    public static final String AUTOFILL_HINT_PHONE_NUMBER_DEVICE = "phoneNumberDevice";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS = "postalAddress";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_APT_NUMBER = "aptNumber";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY = "addressCountry";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_DEPENDENT_LOCALITY = "dependentLocality";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS = "extendedAddress";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE = "extendedPostalCode";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY = "addressLocality";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_REGION = "addressRegion";
    public static final String AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS = "streetAddress";
    public static final String AUTOFILL_HINT_POSTAL_CODE = "postalCode";
    public static final String AUTOFILL_HINT_USERNAME = "username";

    private HintsHelper() {
    }

    public static Set<String> getHintsForSaveType(int saveType) {
        ArraySet<String> hintSet = new ArraySet();
        switch(saveType) {
            case 1: goto L13;
            case 2: goto L11;
            case 4: goto L9;
            case 8: goto L7;
            case 16: goto L5;
            case 32: goto L9;
            case 64: goto L9;
            case 128: goto L9;
            default: goto L4;
        };
    L4:
        return hintSet;
    L5:
        hintSet.add(AUTOFILL_HINT_EMAIL_ADDRESS);
        return hintSet;
    L7:
        hintSet.add(AUTOFILL_HINT_NEW_USERNAME);
        hintSet.add(AUTOFILL_HINT_USERNAME);
        return hintSet;
    L9:
        hintSet.add(AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE);
        hintSet.add(AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DAY);
        hintSet.add(AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_MONTH);
        hintSet.add(AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_YEAR);
        hintSet.add(AUTOFILL_HINT_CREDIT_CARD_NUMBER);
        hintSet.add(AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE);
        return hintSet;
    L11:
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_APT_NUMBER);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_COUNTRY);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_DEPENDENT_LOCALITY);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_ADDRESS);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_EXTENDED_POSTAL_CODE);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_LOCALITY);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_REGION);
        hintSet.add(AUTOFILL_HINT_POSTAL_ADDRESS_STREET_ADDRESS);
        hintSet.add(AUTOFILL_HINT_POSTAL_CODE);
        return hintSet;
    L13:
        hintSet.add(AUTOFILL_HINT_NEW_USERNAME);
        hintSet.add(AUTOFILL_HINT_USERNAME);
        hintSet.add(AUTOFILL_HINT_NEW_PASSWORD);
        hintSet.add(AUTOFILL_HINT_PASSWORD);
        return hintSet;
    }
}
