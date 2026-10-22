package com.android.contacts.common.model.account;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.model.dataitem.DataKind;
import com.obric.smssdk.utils.SmsMmsDatabaseUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
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
    private static final String[] METADATA_CONTACTS_NAMES = null;
    private static final String SYNC_META_DATA = "android.content.SyncAdapter";
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

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean isEmbedded() {
        return false;
    }

    static {
        METADATA_CONTACTS_NAMES = new String[]{"android.provider.ALTERNATE_CONTACTS_STRUCTURE", "android.provider.CONTACTS_STRUCTURE"};
    }

    public ExternalAccountType(Context r2, String r3, boolean r4) {
        this(r2, r3, r4, null);
    }

    ExternalAccountType(Context r4, String r5, boolean r6, XmlResourceParser r7) {
        this.mIsExtension = r6;
        this.resourcePackageName = r5;
        this.syncAdapterPackageName = r5;
        if (r7 != null) goto L5;
        r7 = loadContactsXml(r4, r5);
    L5:
        boolean r8 = true;
        if (r7 == null) goto L38;
        inflate(r4, r7);     // Catch: AccountType.DefinitionException -> L9 Throwable -> L20
    L9:
        e = e;
    L24:
        StringBuilder r9 = new StringBuilder("Problem reading XML");     // Catch: Throwable -> L20
        if (r8 == false) goto L28;
        if (r7 == null) goto L28;
        r9.append(" in line ");     // Catch: Throwable -> L20
        r9.append(r7.getLineNumber());     // Catch: Throwable -> L20
    L28:
        r9.append(" for external package ");     // Catch: Throwable -> L20
        r9.append(r5);     // Catch: Throwable -> L20
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r9.toString(), e);     // Catch: Throwable -> L20
        if (r7 == null) goto L39;
        r7.close();
        return;
    L39:
        return;
    L38:
    L22:
        e = e;
        r8 = false;
        goto L24
    L13:
        if (this.mHasEditSchema == false) goto L15;
        checkKindExists("vnd.android.cursor.item/name");     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
        checkKindExists("#displayName");     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
        checkKindExists("#phoneticName");     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
        checkKindExists("vnd.android.cursor.item/photo");     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
    L16:
        if (r7 == null) goto L18;
        r7.close();
    L18:
        this.mExtensionPackageNames = new ArrayList();
        this.mInviteActionLabelResId = resolveExternalResId(r4, this.mInviteActionLabelAttribute, this.syncAdapterPackageName, ATTR_INVITE_CONTACT_ACTION_LABEL);
        this.mViewGroupLabelResId = resolveExternalResId(r4, this.mViewGroupLabelAttribute, this.syncAdapterPackageName, ATTR_VIEW_GROUP_ACTION_LABEL);
        this.titleRes = resolveExternalResId(r4, this.mAccountTypeLabelAttribute, this.syncAdapterPackageName, ATTR_ACCOUNT_LABEL);
        this.iconRes = resolveExternalResId(r4, this.mAccountTypeIconAttribute, this.syncAdapterPackageName, ATTR_ACCOUNT_ICON);
        this.mIsInitialized = true;
        return;
    L15:
        addDataKindStructuredName(r4);     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
        addDataKindDisplayName(r4);     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
        addDataKindPhoneticName(r4);     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
        addDataKindPhoto(r4);     // Catch: Throwable -> L20 AccountType.DefinitionException -> L22
    L20:
        th = move-exception;
        if (r7 == null) goto L34;
        r7.close();
    L34:
        throw th;
    }

    public static XmlResourceParser loadContactsXml(Context r7, String r8) {
        PackageManager r9 = r7.getPackageManager();
        List<ResolveInfo> r10 = r9.queryIntentServices(new Intent(SYNC_META_DATA).setPackage(r8), SmsMmsDatabaseUtil.MESSAGE_TYPE_RETRIEVE_CONF);
        if (r10 == null) goto L19;
        Iterator<ResolveInfo> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L27;
        ServiceInfo r0 = r11.next().serviceInfo;
        if (r0 == null) goto L6;
        String[] r1 = METADATA_CONTACTS_NAMES;
        int r2 = r1.length;
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L6;
        String r5 = r1[r4];
        XmlResourceParser r6 = r0.loadXmlMetaData(r9, r5);
        if (r6 != null) goto L15;
        r4 = r4 + 1;
        goto L11
    L15:
        if (Log.isLoggable(TAG, 3) == false) goto L17;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, String.format("Metadata loaded from: %s, %s, %s", new Object[]{r0.packageName, r0.name, r5}));
    L17:
        return r6;
    L27:
        return null;
    L19:
        return null;
    }

    public static boolean hasContactsXml(Context r0, String r1) {
        if (loadContactsXml(r0, r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void checkKindExists(String r2) throws AccountType.DefinitionException {
        if (getKindForMimetype(r2) == null) goto L6;
        return;
    L6:
        throw new AccountType.DefinitionException(r2 + " must be supported");
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean isExtension() {
        return this.mIsExtension;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public boolean areContactsWritable() {
        return this.mHasEditSchema;
    }

    public boolean hasContactsMetadata() {
        return this.mHasContactsMetadata;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public String getEditContactActivityClassName() {
        return this.mEditContactActivityClassName;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public String getCreateContactActivityClassName() {
        return this.mCreateContactActivityClassName;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public String getInviteContactActivityClassName() {
        return this.mInviteContactActivity;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    protected int getInviteContactActionResId() {
        return this.mInviteActionLabelResId;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public String getViewContactNotifyServiceClassName() {
        return this.mViewContactNotifyService;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public String getViewGroupActivity() {
        return this.mViewGroupActivity;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    protected int getViewGroupLabelResId() {
        return this.mViewGroupLabelResId;
    }

    @Override // com.android.contacts.common.model.account.AccountType
    public List<String> getExtensionPackageNames() {
        return this.mExtensionPackageNames;
    }

    protected void inflate(Context r12, XmlPullParser r13) throws AccountType.DefinitionException {
        AttributeSet r2 = Xml.asAttributeSet(r13);
    L90:
        int r3 = r13.next();     // Catch: IOException -> L84 XmlPullParserException -> L87
        if (r3 == 2) goto L7;
        if (r3 != 1) goto L90;
    L7:
        if (r3 != 2) goto L83;
        String r4 = r13.getName();     // Catch: IOException -> L84 XmlPullParserException -> L87
        if (TAG_CONTACTS_ACCOUNT_TYPE.equals(r4) == false) goto L11;
    L15:
        this.mHasContactsMetadata = true;     // Catch: IOException -> L84 XmlPullParserException -> L87
        int r5 = r13.getAttributeCount();     // Catch: IOException -> L84 XmlPullParserException -> L87
        int r6 = 0;
    L17:
        if (r6 >= r5) goto L59;
        String r8 = r13.getAttributeName(r6);     // Catch: IOException -> L84 XmlPullParserException -> L87
        String r9 = r13.getAttributeValue(r6);     // Catch: IOException -> L84 XmlPullParserException -> L87
        if (Log.isLoggable(TAG, 3) == false) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r8 + "=" + r9);     // Catch: IOException -> L84 XmlPullParserException -> L87
    L22:
        if (ATTR_EDIT_CONTACT_ACTIVITY.equals(r8) == false) goto L25;
        this.mEditContactActivityClassName = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
    L58:
        r6 = r6 + 1;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L17
    L25:
        if (ATTR_CREATE_CONTACT_ACTIVITY.equals(r8) == false) goto L28;
        this.mCreateContactActivityClassName = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L28:
        if (ATTR_INVITE_CONTACT_ACTIVITY.equals(r8) == false) goto L31;
        this.mInviteContactActivity = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L31:
        if (ATTR_INVITE_CONTACT_ACTION_LABEL.equals(r8) == false) goto L34;
        this.mInviteActionLabelAttribute = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L34:
        if (ATTR_VIEW_CONTACT_NOTIFY_SERVICE.equals(r8) == false) goto L37;
        this.mViewContactNotifyService = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L37:
        if (ATTR_VIEW_GROUP_ACTIVITY.equals(r8) == false) goto L40;
        this.mViewGroupActivity = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L40:
        if (ATTR_VIEW_GROUP_ACTION_LABEL.equals(r8) == false) goto L43;
        this.mViewGroupLabelAttribute = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L43:
        if ("dataSet".equals(r8) == false) goto L46;
        this.dataSet = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L46:
        if (ATTR_EXTENSION_PACKAGE_NAMES.equals(r8) == false) goto L49;
        this.mExtensionPackageNames.add(r9);     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L49:
        if ("accountType".equals(r8) == false) goto L52;
        this.accountType = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L52:
        if (ATTR_ACCOUNT_LABEL.equals(r8) == false) goto L55;
        this.mAccountTypeLabelAttribute = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L55:
        if (ATTR_ACCOUNT_ICON.equals(r8) == false) goto L57;
        this.mAccountTypeIconAttribute = r9;     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L57:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unsupported attribute " + r8);     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L58
    L59:
        int r1 = r13.getDepth();     // Catch: IOException -> L84 XmlPullParserException -> L87
    L60:
        int r7 = r13.next();     // Catch: IOException -> L84 XmlPullParserException -> L87
        if (r7 == 3) goto L63;
    L64:
        if (r7 == 1) goto L81;
        if (r7 != 2) goto L60;
        if (r13.getDepth() != (r1 + 1)) goto L60;
        String r10 = r13.getName();     // Catch: IOException -> L84 XmlPullParserException -> L87
        if (TAG_EDIT_SCHEMA.equals(r10) == true) goto L71;
        if (TAG_CONTACTS_DATA_KIND.equals(r10) == false) goto L60;
        TypedArray r11 = r12.obtainStyledAttributes(r2, R.styleable.ContactsDataKind);     // Catch: IOException -> L84 XmlPullParserException -> L87
        DataKind r14 = new DataKind();     // Catch: IOException -> L84 XmlPullParserException -> L87
        r14.mimeType = r11.getString(R.styleable.ContactsDataKind_android_mimeType);     // Catch: IOException -> L84 XmlPullParserException -> L87
        String r15 = r11.getString(R.styleable.ContactsDataKind_android_summaryColumn);     // Catch: IOException -> L84 XmlPullParserException -> L87
        if (r15 == null) goto L77;
        r14.actionHeader = new BaseAccountType.SimpleInflater(r15);     // Catch: IOException -> L84 XmlPullParserException -> L87
    L77:
        String r16 = r11.getString(R.styleable.ContactsDataKind_android_detailColumn);     // Catch: IOException -> L84 XmlPullParserException -> L87
        if (r16 == null) goto L80;
        r14.actionBody = new BaseAccountType.SimpleInflater(r16);     // Catch: IOException -> L84 XmlPullParserException -> L87
    L80:
        r11.recycle();     // Catch: IOException -> L84 XmlPullParserException -> L87
        addKind(r14);     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L60
    L71:
        this.mHasEditSchema = true;     // Catch: IOException -> L84 XmlPullParserException -> L87
        parseEditSchema(r12, r13, r2);     // Catch: IOException -> L84 XmlPullParserException -> L87
        goto L60
    L81:
        return;
    L63:
        if (r13.getDepth() > r1) goto L64;
        return;
    L11:
        if (TAG_CONTACTS_SOURCE_LEGACY.equals(r4) == true) goto L15;
        throw new IllegalStateException("Top level element must be ContactsAccountType, not " + r4);     // Catch: IOException -> L84 XmlPullParserException -> L87
    L83:
        throw new IllegalStateException("No start tag found");     // Catch: IOException -> L84 XmlPullParserException -> L87
    L84:
        e = move-exception;
        throw new AccountType.DefinitionException("Problem reading XML", e);
    L87:
        e = move-exception;
        throw new AccountType.DefinitionException("Problem reading XML", e);
    }

    static int resolveExternalResId(Context r4, String r5, String r6, String r7) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return -1;
    L6:
        if (r5.charAt(0) == '@') goto L18;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r7 + " must be a resource name beginnig with '@'");
        return -1;
    L18:
        int r8 = r4.getPackageManager().getResourcesForApplication(r6).getIdentifier(r5.substring(1), null, r6);
        if (r8 != 0) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unable to load " + r5 + " from package " + r6);
        return -1;
    L15:
        return r8;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Unable to load package " + r6);
        return -1;
    }
}
