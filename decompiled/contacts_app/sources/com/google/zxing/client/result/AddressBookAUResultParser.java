package com.google.zxing.client.result;

import com.android.vcard.VCardBuilder;
import com.android.vcard.VCardConstants;
import com.google.zxing.Result;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AddressBookAUResultParser extends ResultParser {
    public AddressBookAUResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result r24) {
        String r0 = getMassagedText(r24);
        String[] r2 = null;
        if (r0.contains("MEMORY") == true) goto L5;
    L13:
        return null;
    L5:
        if (r0.contains(VCardBuilder.VCARD_END_OF_LINE) == false) goto L13;
        String r1 = matchSinglePrefixedField("NAME1:", r0, '\r', true);
        String r9 = matchSinglePrefixedField("NAME2:", r0, '\r', true);
        String[] r10 = matchMultipleValuePrefix(VCardConstants.PROPERTY_TEL, 3, r0, true);
        String[] r12 = matchMultipleValuePrefix("MAIL", 3, r0, true);
        String r15 = matchSinglePrefixedField("MEMORY:", r0, '\r', false);
        String r3 = matchSinglePrefixedField("ADD:", r0, '\r', true);
        if (r3 == null) goto L12;
        r2 = new String[]{r3};
    L12:
        return new AddressBookParsedResult(maybeWrap(r1), null, r9, r10, null, r12, null, null, r15, r2, null, null, null, null, null, null);
    }

    private static String[] matchMultipleValuePrefix(String r5, int r6, String r7, boolean r8) {
        int r1 = 1;
        ArrayList r2 = null;
    L3:
        if (r1 > r6) goto L9;
        String r3 = matchSinglePrefixedField(r5 + r1 + ':', r7, '\r', r8);
        if (r3 == null) goto L9;
        if (r2 != null) goto L8;
        r2 = new ArrayList(r6);
    L8:
        r2.add(r3);
        r1 = r1 + 1;
    L9:
        if (r2 != null) goto L12;
        return null;
    L12:
        return (String[]) r2.toArray(new String[r2.size()]);
    }
}
