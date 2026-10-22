package com.android.common;

import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.widget.AutoCompleteTextView;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Rfc822Validator implements AutoCompleteTextView.Validator {
    private static final String DOMAIN_REGEXP = "(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61})?[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]\\.)+[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]";
    private static final String EMAIL_ADDRESS_LOCALPART_REGEXP = "((?!\\s)[\\.\\w!#$%&'*+\\-/=?^`{|}~\u0080-\ufffe])+";
    private static final Pattern EMAIL_ADDRESS_PATTERN = null;
    private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef";
    private static final String LABEL_REGEXP = "([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61})?[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]";
    private String mDomain;
    private boolean mRemoveInvalid;

    static {
        EMAIL_ADDRESS_PATTERN = Pattern.compile("((?!\\s)[\\.\\w!#$%&'*+\\-/=?^`{|}~\u0080-\ufffe])+@(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61})?[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]\\.)+[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]");
    }

    public Rfc822Validator(String r2) {
        this.mRemoveInvalid = false;
        this.mDomain = r2;
    }

    @Override // android.widget.AutoCompleteTextView.Validator
    public boolean isValid(CharSequence r3) {
        Rfc822Token[] r2 = Rfc822Tokenizer.tokenize(r3);
        if (r2.length == 1) goto L5;
        return false;
    L5:
        if (EMAIL_ADDRESS_PATTERN.matcher(r2[0].getAddress()).matches() == true) goto L7;
        return false;
    L7:
        return true;
    }

    public void setRemoveInvalid(boolean r1) {
        this.mRemoveInvalid = r1;
    }

    private String removeIllegalCharacters(String r5) {
        StringBuilder r4 = new StringBuilder();
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L37;
        char r2 = r5.charAt(r1);
        if (r2 <= ' ') goto L35;
        if (r2 > '~') goto L35;
        if (r2 == '(') goto L35;
        if (r2 == ')') goto L35;
        if (r2 == '<') goto L35;
        if (r2 == '>') goto L35;
        if (r2 == '@') goto L35;
        if (r2 == ',') goto L35;
        if (r2 == ';') goto L35;
        if (r2 == ':') goto L35;
        if (r2 == '\\') goto L35;
        if (r2 == '\"') goto L35;
        if (r2 == '[') goto L35;
        if (r2 == ']') goto L35;
        r4.append(r2);
    L35:
        r1 = r1 + 1;
        goto L3
    L37:
        return r4.toString();
    }

    @Override // android.widget.AutoCompleteTextView.Validator
    public CharSequence fixText(CharSequence r10) {
        if (TextUtils.getTrimmedLength(r10) != 0) goto L6;
        return "";
    L6:
        Rfc822Token[] r11 = Rfc822Tokenizer.tokenize(r10);
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L8:
        if (r2 >= r11.length) goto L38;
        String r3 = r11[r2].getAddress();
        if (this.mRemoveInvalid == true) goto L12;
    L14:
        int r4 = r3.indexOf(64);
        if (r4 < 0) goto L17;
        String r6 = removeIllegalCharacters(r3.substring(0, r4));
        if (TextUtils.isEmpty(r6) == true) goto L37;
        String r5 = removeIllegalCharacters(r3.substring(r4 + 1));
        if (r5.length() != 0) goto L25;
        boolean r7 = true;
    L26:
        if (r7 == true) goto L28;
    L29:
        Rfc822Token r8 = r11[r2];
        StringBuilder r9 = new StringBuilder().append(r6).append("@");
        if (r7 == false) goto L33;
        r5 = this.mDomain;
    L33:
        r8.setAddress(r9.append(r5).toString());
    L34:
        r0.append(r11[r2].toString());
        if ((r2 + 1) >= r11.length) goto L37;
        r0.append(", ");
        goto L37
    L28:
        if (this.mDomain == null) goto L34;
    L25:
        r7 = false;
    L37:
        r2 = r2 + 1;
        goto L8
    L17:
        if (this.mDomain == null) goto L34;
        r11[r2].setAddress(removeIllegalCharacters(r3) + "@" + this.mDomain);
        goto L34
    L12:
        if (isValid(r3) == true) goto L14;
    L38:
        return r0;
    }
}
