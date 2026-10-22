package com.android.contacts.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.GlobalProxyLancet;
import com.obric.contacts.Constants;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ExternalAccountType extends BaseAccountType {
    private static final String ATTR_ACCOUNT_ICON = "accountTypeIcon";
    private static final String ATTR_ACCOUNT_LABEL = "accountTypeLabel";
    private static final String ATTR_ACCOUNT_TYPE = "accountType";
    private static final String ATTR_CREATE_CONTACT_ACTIVITY = "createContactActivity";
    private static final String ATTR_DATA_SET = "dataSet";
    private static final String ATTR_EDIT_CONTACT_ACTIVITY = "editContactActivity";
    private static final String ATTR_EXTENSION_PACKAGE_NAMES = "extensionPackageNames";
    private static final String ATTR_INVITE_CONTACT_ACTION_LABEL = "inviteContactActionLabel";
    private static final String ATTR_INVITE_CONTACT_ACTIVITY = "inviteContactActivity";
    private static final String ATTR_VIEW_CONTACT_NOTIFY_SERVICE = "viewContactNotifyService";
    private static final String ATTR_VIEW_GROUP_ACTION_LABEL = "viewGroupActionLabel";
    private static final String ATTR_VIEW_GROUP_ACTIVITY = "viewGroupActivity";
    private static final String ATTR_VIEW_STREAM_ITEM_ACTIVITY = "viewStreamItemActivity";
    private static final String ATTR_VIEW_STREAM_ITEM_PHOTO_ACTIVITY = "viewStreamItemPhotoActivity";
    private static final String METADATA_CONTACTS = "android.provider.CONTACTS_STRUCTURE";
    private static final String TAG = "ExternalAccountType";
    private static final String TAG_CONTACTS_ACCOUNT_TYPE = "ContactsAccountType";
    private static final String TAG_CONTACTS_DATA_KIND = "ContactsDataKind";
    private static final String TAG_CONTACTS_SOURCE_LEGACY = "ContactsSource";
    private static final String TAG_EDIT_SCHEMA = "EditSchema";
    private String mAccountTypeIconAttribute;
    private String mAccountTypeLabelAttribute;
    private String mCreateContactActivityClassName;
    private String mEditContactActivityClassName;
    private List<String> mExtensionPackageNames;
    private boolean mHasContactsMetadata;
    private boolean mHasEditSchema;
    private String mInviteActionLabelAttribute;
    private int mInviteActionLabelResId;
    private String mInviteContactActivity;
    private final boolean mIsExtension;
    private String mViewContactNotifyService;
    private String mViewGroupActivity;
    private String mViewGroupLabelAttribute;
    private int mViewGroupLabelResId;
    private String mViewStreamItemActivity;
    private String mViewStreamItemPhotoActivity;

    @Override // com.android.contacts.model.AccountType
    public boolean isEmbedded() {
        return false;
    }

    public ExternalAccountType(Context r2, String r3, boolean r4) {
        this(r2, r3, r4, null);
    }

    ExternalAccountType(Context r4, String r5, boolean r6, XmlResourceParser r7) {
        this.mIsExtension = r6;
        this.resPackageName = r5;
        this.summaryResPackageName = r5;
        r4.getPackageManager();
        if (r7 == null) goto L37;
    L7:
        boolean r8 = true;
        if (r7 == null) goto L42;
        inflate(r4, r7);     // Catch: AccountType.DefinitionException -> L11 Throwable -> L22
    L11:
        e = e;
    L26:
        StringBuilder r9 = new StringBuilder("Problem reading XML");     // Catch: Throwable -> L22
        if (r8 == false) goto L30;
        if (r7 == null) goto L30;
        r9.append(" in line ");     // Catch: Throwable -> L22
        r9.append(r7.getLineNumber());     // Catch: Throwable -> L22
    L30:
        r9.append(" for external package ");     // Catch: Throwable -> L22
        r9.append(r5);     // Catch: Throwable -> L22
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r9.toString(), e);     // Catch: Throwable -> L22
        if (r7 == null) goto L43;
        r7.close();
        return;
    L43:
        return;
    L42:
    L24:
        e = e;
        r8 = false;
        goto L26
    L15:
        if (this.mHasEditSchema == false) goto L17;
        checkKindExists("vnd.android.cursor.item/name");     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
        checkKindExists("#displayName");     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
        checkKindExists("#phoneticName");     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
        checkKindExists("vnd.android.cursor.item/photo");     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
    L18:
        if (r7 == null) goto L20;
        r7.close();
    L20:
        this.mExtensionPackageNames = new ArrayList();
        this.mInviteActionLabelResId = resolveExternalResId(r4, this.mInviteActionLabelAttribute, this.summaryResPackageName, ATTR_INVITE_CONTACT_ACTION_LABEL);
        this.mViewGroupLabelResId = resolveExternalResId(r4, this.mViewGroupLabelAttribute, this.summaryResPackageName, ATTR_VIEW_GROUP_ACTION_LABEL);
        this.titleRes = resolveExternalResId(r4, this.mAccountTypeLabelAttribute, this.resPackageName, ATTR_ACCOUNT_LABEL);
        this.iconRes = resolveExternalResId(r4, this.mAccountTypeIconAttribute, this.resPackageName, ATTR_ACCOUNT_ICON);
        this.mIsInitialized = true;
        return;
    L17:
        addDataKindStructuredName(r4);     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
        addDataKindDisplayName(r4);     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
        addDataKindPhoneticName(r4);     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
        addDataKindPhoto(r4);     // Catch: Throwable -> L22 AccountType.DefinitionException -> L24
    L22:
        th = move-exception;
        if (r7 == null) goto L36;
        r7.close();
    L36:
        throw th;
    L37:
        r7 = loadContactsXml(r4, r5);     // Catch: Throwable -> L6
    }

    private XmlResourceParser loadContactsXml(Context r4, String r5) throws PackageManager.NameNotFoundException {
        PackageManager r3 = r4.getPackageManager();
        PackageInfo r6 = r3.getPackageInfo(r5, SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF);
        if (r6 == null) goto L10;
        ServiceInfo[] r7 = r6.services;
        int r8 = r7.length;
        int r0 = 0;
    L5:
        if (r0 >= r8) goto L14;
        XmlResourceParser r1 = r7[r0].loadXmlMetaData(r3, METADATA_CONTACTS);
        if (r1 != null) goto L8;
        r0 = r0 + 1;
        goto L5
    L8:
        return r1;
    L14:
        return null;
    L10:
        return null;
    }

    private void checkKindExists(String r2) throws AccountType.DefinitionException {
        if (getKindForMimetype(r2) == null) goto L6;
        return;
    L6:
        throw new AccountType.DefinitionException(r2 + " must be supported");
    }

    @Override // com.android.contacts.model.AccountType
    public boolean isExtension() {
        return this.mIsExtension;
    }

    @Override // com.android.contacts.model.AccountType
    public boolean areContactsWritable() {
        return this.mHasEditSchema;
    }

    public boolean hasContactsMetadata() {
        return this.mHasContactsMetadata;
    }

    @Override // com.android.contacts.model.AccountType
    public String getEditContactActivityClassName() {
        return this.mEditContactActivityClassName;
    }

    @Override // com.android.contacts.model.AccountType
    public String getCreateContactActivityClassName() {
        return this.mCreateContactActivityClassName;
    }

    @Override // com.android.contacts.model.AccountType
    public String getInviteContactActivityClassName() {
        return this.mInviteContactActivity;
    }

    @Override // com.android.contacts.model.AccountType
    protected int getInviteContactActionResId() {
        return this.mInviteActionLabelResId;
    }

    @Override // com.android.contacts.model.AccountType
    public String getViewContactNotifyServiceClassName() {
        return this.mViewContactNotifyService;
    }

    @Override // com.android.contacts.model.AccountType
    public String getViewGroupActivity() {
        return this.mViewGroupActivity;
    }

    @Override // com.android.contacts.model.AccountType
    protected int getViewGroupLabelResId() {
        return this.mViewGroupLabelResId;
    }

    @Override // com.android.contacts.model.AccountType
    public String getViewStreamItemActivity() {
        return this.mViewStreamItemActivity;
    }

    @Override // com.android.contacts.model.AccountType
    public String getViewStreamItemPhotoActivity() {
        return this.mViewStreamItemPhotoActivity;
    }

    @Override // com.android.contacts.model.AccountType
    public List<String> getExtensionPackageNames() {
        return this.mExtensionPackageNames;
    }

    protected void inflate(Context r13, XmlPullParser r14) throws AccountType.DefinitionException {
        AttributeSet r2 = Xml.asAttributeSet(r14);
    L98:
        int r3 = r14.next();     // Catch: IOException -> L92 XmlPullParserException -> L95
        if (r3 == 2) goto L7;
        if (r3 != 1) goto L98;
    L7:
        if (r3 != 2) goto L91;
        String r4 = r14.getName();     // Catch: IOException -> L92 XmlPullParserException -> L95
        if (TAG_CONTACTS_ACCOUNT_TYPE.equals(r4) == false) goto L11;
    L15:
        this.mHasContactsMetadata = true;     // Catch: IOException -> L92 XmlPullParserException -> L95
        int r5 = r14.getAttributeCount();     // Catch: IOException -> L92 XmlPullParserException -> L95
        int r7 = 0;
    L17:
        if (r7 >= r5) goto L65;
        String r9 = r14.getAttributeName(r7);     // Catch: IOException -> L92 XmlPullParserException -> L95
        String r10 = r14.getAttributeValue(r7);     // Catch: IOException -> L92 XmlPullParserException -> L95
        if (Log.isLoggable(TAG, 3) == false) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r9 + "=" + r10);     // Catch: IOException -> L92 XmlPullParserException -> L95
    L22:
        if (ATTR_EDIT_CONTACT_ACTIVITY.equals(r9) == false) goto L25;
        this.mEditContactActivityClassName = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
    L64:
        r7 = r7 + 1;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L17
    L25:
        if (ATTR_CREATE_CONTACT_ACTIVITY.equals(r9) == false) goto L28;
        this.mCreateContactActivityClassName = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L28:
        if (ATTR_INVITE_CONTACT_ACTIVITY.equals(r9) == false) goto L31;
        this.mInviteContactActivity = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L31:
        if (ATTR_INVITE_CONTACT_ACTION_LABEL.equals(r9) == false) goto L34;
        this.mInviteActionLabelAttribute = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L34:
        if (ATTR_VIEW_CONTACT_NOTIFY_SERVICE.equals(r9) == false) goto L37;
        this.mViewContactNotifyService = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L37:
        if (ATTR_VIEW_GROUP_ACTIVITY.equals(r9) == false) goto L40;
        this.mViewGroupActivity = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L40:
        if (ATTR_VIEW_GROUP_ACTION_LABEL.equals(r9) == false) goto L43;
        this.mViewGroupLabelAttribute = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L43:
        if (ATTR_VIEW_STREAM_ITEM_ACTIVITY.equals(r9) == false) goto L46;
        this.mViewStreamItemActivity = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L46:
        if (ATTR_VIEW_STREAM_ITEM_PHOTO_ACTIVITY.equals(r9) == false) goto L49;
        this.mViewStreamItemPhotoActivity = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L49:
        if ("dataSet".equals(r9) == false) goto L52;
        this.dataSet = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L52:
        if (ATTR_EXTENSION_PACKAGE_NAMES.equals(r9) == false) goto L55;
        this.mExtensionPackageNames.add(r10);     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L55:
        if ("accountType".equals(r9) == false) goto L58;
        this.accountType = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L58:
        if (ATTR_ACCOUNT_LABEL.equals(r9) == false) goto L61;
        this.mAccountTypeLabelAttribute = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L61:
        if (ATTR_ACCOUNT_ICON.equals(r9) == false) goto L63;
        this.mAccountTypeIconAttribute = r10;     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L63:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unsupported attribute " + r9);     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L64
    L65:
        int r1 = r14.getDepth();     // Catch: IOException -> L92 XmlPullParserException -> L95
    L66:
        int r6 = r14.next();     // Catch: IOException -> L92 XmlPullParserException -> L95
        if (r6 == 3) goto L69;
    L70:
        if (r6 == 1) goto L131;
        if (r6 != 2) goto L66;
        if (r14.getDepth() != (r1 + 1)) goto L66;
        String r8 = r14.getName();     // Catch: IOException -> L92 XmlPullParserException -> L95
        if (TAG_EDIT_SCHEMA.equals(r8) == true) goto L77;
        if (TAG_CONTACTS_DATA_KIND.equals(r8) == false) goto L66;
        TypedArray r11 = r13.obtainStyledAttributes(r2, Constants.ContactsDataKind);     // Catch: IOException -> L92 XmlPullParserException -> L95
        DataKind r12 = new DataKind();     // Catch: IOException -> L92 XmlPullParserException -> L95
        r12.mimeType = r11.getString(1);     // Catch: IOException -> L92 XmlPullParserException -> L95
        String r15 = r11.getString(2);     // Catch: IOException -> L92 XmlPullParserException -> L95
        if (r15 == null) goto L83;
        r12.actionHeader = new BaseAccountType.SimpleInflater(r15);     // Catch: IOException -> L92 XmlPullParserException -> L95
    L83:
        String r16 = r11.getString(3);     // Catch: IOException -> L92 XmlPullParserException -> L95
        if (r11.getBoolean(4, false) == false) goto L86;
        r12.actionBodySocial = true;     // Catch: IOException -> L92 XmlPullParserException -> L95
    L86:
        if (r16 == null) goto L88;
        r12.actionBody = new BaseAccountType.SimpleInflater(r16);     // Catch: IOException -> L92 XmlPullParserException -> L95
    L88:
        r11.recycle();     // Catch: IOException -> L92 XmlPullParserException -> L95
        addKind(r12);     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L66
    L77:
        this.mHasEditSchema = true;     // Catch: IOException -> L92 XmlPullParserException -> L95
        parseEditSchema(r13, r14, r2);     // Catch: IOException -> L92 XmlPullParserException -> L95
        goto L66
    L131:
        return;
    L69:
        if (r14.getDepth() > r1) goto L70;
        return;
    L11:
        if (TAG_CONTACTS_SOURCE_LEGACY.equals(r4) == true) goto L15;
        throw new IllegalStateException("Top level element must be ContactsAccountType, not " + r4);     // Catch: IOException -> L92 XmlPullParserException -> L95
    L91:
        throw new IllegalStateException("No start tag found");     // Catch: IOException -> L92 XmlPullParserException -> L95
    L92:
        e = move-exception;
        throw new AccountType.DefinitionException("Problem reading XML", e);
    L95:
        e = move-exception;
        throw new AccountType.DefinitionException("Problem reading XML", e);
    }

    static int resolveExternalResId(Context r5, String r6, String r7, String r8) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return -1;
    L5:
        int r0 = 0;
        if (r6.charAt(0) == '@') goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r8 + " must be a resource name beginnig with '@'");
        return -1;
    L9:
        String r9 = r6.substring(1);
        Resources r10 = r5.getPackageManager().getResourcesForApplication(r7);     // Catch: PackageManager.NameNotFoundException -> L17
        if (r10 == null) goto L13;
        r0 = r10.getIdentifier(r9, null, r7);
    L13:
        if (r0 != 0) goto L16;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unable to load " + r6 + " from package " + r7);
        return -1;
    L16:
        return r0;
    L17:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unable to load package " + r7);
        return -1;
    }
}
