package com.android.contacts.list;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.CallContactActivity;
import com.android.contacts.ContactsSearchManager;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.util.Constants;
import com.android.contacts.util.IntentUtils;
import obric.api.ContactsContractSmt;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsIntentResolver {
    private static final String TAG = "ContactsIntentResolver";
    private final Activity mContext;

    public ContactsIntentResolver(Activity r1) {
        this.mContext = r1;
    }

    public ContactsRequest resolveIntent(Intent r15) {
        ContactsRequest r0 = new ContactsRequest();
        String r1 = r15.getAction();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Called with action: " + r1);
        if (ContactsContractSmt.get_UI_LIST_DEFAULT().equals(r1) == false) goto L6;
        r0.setActionCode(10);
    L152:
        String r14 = IntentUtils.getStringExtra(r15, ContactsContractSmt.get_UI_TITLE_EXTRA_KEY());
        if (r14 == null) goto L155;
        r0.setActivityTitle(r14);
    L155:
        return r0;
    L6:
        if (ContactsContractSmt.get_UI_LIST_ALL_CONTACTS_ACTION().equals(r1) == false) goto L9;
        r0.setActionCode(15);
        goto L152
    L9:
        if (ContactsContractSmt.get_UI_LIST_CONTACTS_WITH_PHONES_ACTION().equals(r1) == false) goto L12;
        r0.setActionCode(17);
        goto L152
    L12:
        if (ContactsContractSmt.get_UI_LIST_STARRED_ACTION().equals(r1) == false) goto L15;
        r0.setActionCode(30);
        goto L152
    L15:
        if (ContactsContractSmt.get_UI_LIST_FREQUENT_ACTION().equals(r1) == false) goto L18;
        r0.setActionCode(40);
        goto L152
    L18:
        if (ContactsContractSmt.get_UI_LIST_STREQUENT_ACTION().equals(r1) == false) goto L21;
        r0.setActionCode(50);
        goto L152
    L21:
        if (ContactsContractSmt.get_UI_LIST_GROUP_ACTION().equals(r1) == false) goto L24;
        r0.setActionCode(20);
        goto L152
    L24:
        if ("android.intent.action.PICK".equals(r1) == false) goto L50;
        String r16 = r15.resolveType(this.mContext);
        if ("vnd.android.cursor.dir/contact".equals(r16) == false) goto L29;
        r0.setActionCode(60);
        goto L152
    L29:
        if ("vnd.android.cursor.dir/person".equals(r16) == false) goto L32;
        r0.setActionCode(60);
        r0.setLegacyCompatibilityMode(true);
        goto L152
    L32:
        if ("vnd.android.cursor.dir/phone_v2".equals(r16) == false) goto L35;
        r0.setActionCode(90);
        goto L152
    L35:
        if ("vnd.android.cursor.dir/phone".equals(r16) == false) goto L38;
        r0.setActionCode(90);
        r0.setLegacyCompatibilityMode(true);
        goto L152
    L38:
        if ("vnd.android.cursor.dir/postal-address_v2".equals(r16) == false) goto L41;
        r0.setActionCode(100);
        goto L152
    L41:
        if ("vnd.android.cursor.dir/postal-address".equals(r16) == false) goto L44;
        r0.setActionCode(100);
        r0.setLegacyCompatibilityMode(true);
        goto L152
    L44:
        if ("vnd.android.cursor.dir/email_v2".equals(r16) == false) goto L47;
        r0.setActionCode(105);
        goto L152
    L47:
        if ("vnd.android.cursor.dir/calls".equals(r16) == false) goto L152;
        r0.setActionCode(ContactsRequest.ACTION_PICK_CALLLOG_NUM);
        goto L152
    L50:
        if ("com.android.contacts.action.GET_MULTIPLE_PHONES".equals(r1) == false) goto L67;
        String r17 = r15.resolveType(this.mContext);
        if ("vnd.android.cursor.dir/phone_v2".equals(r17) == false) goto L55;
        r0.setActionCode(96);
        goto L152
    L55:
        if ("vnd.android.cursor.dir/phone".equals(r17) == false) goto L58;
        r0.setActionCode(96);
        r0.setLegacyCompatibilityMode(true);
        goto L152
    L58:
        if ("vnd.android.cursor.dir/contact".equals(r17) == false) goto L61;
        r0.setActionCode(61);
        goto L152
    L61:
        if ("vnd.android.cursor.dir/raw_contact".equals(r17) == false) goto L64;
        r0.setActionCode(62);
        goto L152
    L64:
        if ("vnd.android.cursor.dir/calls".equals(r17) == false) goto L152;
        r0.setActionCode(150);
        goto L152
    L67:
        if ("android.intent.action.CREATE_SHORTCUT".equals(r1) == false) goto L76;
        String r18 = r15.getComponent().getClassName();
        if (r18.equals("alias.DialShortcut") == false) goto L72;
        r0.setActionCode(120);
        goto L152
    L72:
        if (r18.equals("alias.MessageShortcut") == false) goto L74;
        r0.setActionCode(130);
        goto L152
    L74:
        r0.setActionCode(110);
        goto L152
    L76:
        if ("android.intent.action.GET_CONTENT".equals(r1) == false) goto L96;
        String r19 = r15.getType();
        if ("vnd.android.cursor.item/contact".equals(r19) == false) goto L81;
        r0.setActionCode(70);
        goto L152
    L81:
        if ("vnd.android.cursor.item/phone_v2".equals(r19) == false) goto L84;
        r0.setActionCode(90);
        goto L152
    L84:
        if ("vnd.android.cursor.item/phone".equals(r19) == false) goto L87;
        r0.setActionCode(90);
        r0.setLegacyCompatibilityMode(true);
        goto L152
    L87:
        if ("vnd.android.cursor.item/postal-address_v2".equals(r19) == false) goto L90;
        r0.setActionCode(100);
        goto L152
    L90:
        if ("vnd.android.cursor.item/postal-address".equals(r19) == false) goto L93;
        r0.setActionCode(100);
        r0.setLegacyCompatibilityMode(true);
        goto L152
    L93:
        if ("vnd.android.cursor.item/person".equals(r19) == false) goto L152;
        r0.setActionCode(70);
        r0.setLegacyCompatibilityMode(true);
        goto L152
    L96:
        if (ContactSelectionActivity.ACTION_GET_PHONE_NUMS.equals(r1) == false) goto L101;
        if ("vnd.android.cursor.item/phone_v2".equals(r15.getType()) == false) goto L152;
        r0.setActionCode(95);
        goto L152
    L101:
        if (ContactSelectionActivity.ACTION_PICK_UNFAVORITE_NUMS.equals(r1) == false) goto L104;
        r0.setActionCode(65);
        goto L152
    L104:
        if (ContactSelectionActivity.ACTION_PICK_EMAILS.equals(r1) == false) goto L107;
        r0.setActionCode(101);
        goto L152
    L107:
        if (ContactSelectionActivity.ACTION_PICK_EMAILS_EXCEPT_SELECTED.equals(r1) == false) goto L110;
        r0.setActionCode(102);
        goto L152
    L110:
        if ("android.intent.action.INSERT_OR_EDIT".equals(r1) == false) goto L113;
        r0.setActionCode(80);
        goto L152
    L113:
        if (ContactSelectionActivity.ACTION_BYTEDANCE_INSERT_OR_EDIT.equals(r1) == false) goto L116;
        r0.setActionCode(117);
        goto L152
    L116:
        if ("android.intent.action.SEARCH".equals(r1) == false) goto L124;
        if ("call".equals(r15.getStringExtra("action_msg")) == false) goto L122;
        String r110 = r15.getStringExtra("query");
        if (TextUtils.isEmpty(r110) == true) goto L152;
        r0.setRedirectIntent(new Intent("android.intent.action.CALL_PRIVILEGED", Uri.fromParts(Constants.SCHEME_TEL, r110, null)));
        goto L152
    L122:
        r0.setQueryString(r15.getStringExtra("query"));
        r0.setSearchMode(true);
        goto L152
    L124:
        if ("android.intent.action.VIEW".equals(r1) == false) goto L133;
        String r111 = r15.resolveType(this.mContext);
        if ("vnd.android.cursor.dir/contact".equals(r111) == false) goto L128;
    L131:
        r0.setActionCode(15);
        goto L152
    L128:
        if ("vnd.android.cursor.dir/person".equals(r111) == true) goto L131;
        r0.setActionCode(140);
        r0.setContactUri(r15.getData());
        r15.setAction("android.intent.action.VIEW");
        r15.setData(null);
        goto L152
    L133:
        if (ContactsContractSmt.get_UI_FILTER_CONTACTS_ACTION().equals(r1) == false) goto L141;
        r0.setActionCode(10);
        Bundle r112 = r15.getExtras();
        if (r112 == null) goto L139;
        r0.setQueryString(r112.getString(ContactsContractSmt.get_UI_FILTER_TEXT_EXTRA_KEY()));
        ContactsRequest r113 = (ContactsRequest) r112.get(ContactsSearchManager.ORIGINAL_REQUEST_KEY);
        if (r113 == null) goto L139;
        r0.copyFrom(r113);
    L139:
        r0.setSearchMode(true);
        goto L152
    L141:
        if ("android.provider.Contacts.SEARCH_SUGGESTION_CLICKED".equals(r1) == false) goto L147;
        Uri r2 = r15.getData();
        if ("call".equals(r15.getStringExtra("action_msg")) == false) goto L145;
        Intent r3 = new Intent(this.mContext, CallContactActivity.class);
        r3.setData(r2);
        r0.setRedirectIntent(r3);
        goto L152
    L145:
        r0.setActionCode(140);
        r0.setContactUri(r2);
        r15.setAction("android.intent.action.VIEW");
        r15.setData(null);
        goto L152
    L147:
        if ("android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED".equals(r1) == false) goto L150;
        r0.setRedirectIntent(new Intent("android.intent.action.CALL_PRIVILEGED", r15.getData()));
        goto L152
    L150:
        if ("android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED".equals(r1) == false) goto L152;
        String r114 = r15.getData().getSchemeSpecificPart();
        Intent r4 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        r4.putExtra("phone", r114);
        r0.setRedirectIntent(r4);
        goto L152
    }
}
