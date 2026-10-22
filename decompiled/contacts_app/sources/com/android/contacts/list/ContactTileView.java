package com.android.contacts.list;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout;
import com.android.contacts.group.AddNewMembersAdapter;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public class ContactTileView extends QuickContactChildLayout {
    private static final String TAG = "ContactTileView";
    private BlacklistManager mBlacklistManager;
    public ImageView mBlacklistView;
    private OCheckBox mCheckBox;
    private View mCheckBoxFrame;
    private View mHorizontalDivider;
    private QuickContactChildLayout mItem;
    private Listener mListener;
    private Uri mLookupUri;
    private TextView mName;
    private TextView mPhoneLabel;
    private TextView mPhoneNumber;
    private AvatarImageView mPhoto;
    private View mPhotoFrame;
    private ContactPhotoManager mPhotoManager;
    private View mPushState;
    private QuickContactBadge mQuickContact;
    private long mRawContactId;
    private TextView mStatus;

    public interface Listener {
        void onClick(ContactTileView r1);
    }

    protected boolean isDarkTheme() {
        return false;
    }

    protected boolean isDefaultIconHires() {
        return false;
    }

    static /* synthetic */ Listener access$000(ContactTileView r0) {
        return r0.mListener;
    }

    public ContactTileView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mPhotoManager = null;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactChildLayout, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mName = (TextView) findViewById(R.id.contact_tile_name);
        this.mQuickContact = (QuickContactBadge) findViewById(R.id.contact_tile_quick);
        this.mPhoto = (AvatarImageView) findViewById(R.id.photo);
        this.mStatus = (TextView) findViewById(R.id.contact_tile_status);
        this.mPhoneLabel = (TextView) findViewById(R.id.contact_tile_phone_type);
        this.mPhoneNumber = (TextView) findViewById(R.id.contact_tile_phone_number);
        this.mPushState = findViewById(R.id.contact_tile_push_state);
        this.mHorizontalDivider = findViewById(R.id.contact_tile_horizontal_divider);
        this.mCheckBox = (OCheckBox) findViewById(R.id.checkBox);
        this.mCheckBoxFrame = findViewById(R.id.checkBoxFrame);
        this.mPhotoFrame = findViewById(R.id.photo_frame);
        this.mItem = (QuickContactChildLayout) findViewById(R.id.quick_contact_layout);
        this.mBlacklistView = (ImageView) findViewById(R.id.blacklist_photo);
    }

    public void setPhotoManager(ContactPhotoManager r1) {
        this.mPhotoManager = r1;
    }

    public void setBlackListManager(BlacklistManager r1) {
        this.mBlacklistManager = r1;
    }

    public void loadFromContact(ContactTileAdapter.ContactEntry r6) {
        if (r6 == null) goto L35;
        this.mName.setText(r6.name);
        this.mLookupUri = r6.lookupUri;
        this.mRawContactId = r6.rawContactId;
        if (this.mStatus != null) goto L6;
    L9:
        TextView r0 = this.mPhoneLabel;
        if (r0 == null) goto L12;
        r0.setText(r6.phoneLabel);
    L12:
        TextView r1 = this.mPhoneNumber;
        if (r1 == null) goto L15;
        r1.setText(r6.phoneNumber);
    L15:
        setVisibility(0);
        if (this.mPhotoManager == null) goto L25;
        AvatarImageView r2 = this.mPhoto;
        if (r2 == null) goto L22;
        r2.setPhotoID(r6.photoId);
        this.mPhotoManager.loadPhoto(this.mPhoto, r6.photoUri, false, false);
        QuickContactBadge r3 = this.mQuickContact;
        if (r3 == null) goto L26;
        r3.assignContactUri(this.mLookupUri);
    L26:
        View r4 = this.mPushState;
        if (r4 == null) goto L29;
        r4.setContentDescription(r6.name);
    L32:
        BlacklistManager r5 = this.mBlacklistManager;
        if (r5 == null) goto L37;
        r5.loadBlacklist(this.mBlacklistView, r6.contactId);
        return;
    L37:
        return;
    L29:
        QuickContactBadge r7 = this.mQuickContact;
        if (r7 == null) goto L32;
        r7.setContentDescription(r6.name);
        goto L32
    L22:
        QuickContactBadge r8 = this.mQuickContact;
        if (r8 == null) goto L26;
        r8.assignContactUri(this.mLookupUri);
        this.mPhotoManager.loadPhoto(this.mQuickContact, r6.photoUri, isDefaultIconHires(), isDarkTheme());
        goto L26
    L25:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "contactPhotoManager not set");
        goto L26
    L6:
        if (r6.status != null) goto L8;
        this.mStatus.setVisibility(8);
        goto L9
    L8:
        this.mStatus.setText(r6.status);
        this.mStatus.setCompoundDrawablesWithIntrinsicBounds(r6.presenceIcon, null, null, null);
        this.mStatus.setVisibility(0);
        goto L9
    L35:
        setVisibility(4);
    }

    public void loadFromContact(AddNewMembersAdapter.ContactEntry r6) {
        if (r6 == null) goto L32;
        this.mName.setText(r6.name);
        this.mLookupUri = r6.lookupKey;
        this.mRawContactId = r6.rawContactId;
        if (this.mStatus != null) goto L6;
    L9:
        TextView r0 = this.mPhoneLabel;
        if (r0 == null) goto L12;
        r0.setText(r6.phoneLabel);
    L12:
        TextView r1 = this.mPhoneNumber;
        if (r1 == null) goto L15;
        r1.setText(r6.phoneNumber);
    L15:
        setVisibility(0);
        if (this.mPhotoManager != null) goto L18;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "contactPhotoManager not set");
    L26:
        View r2 = this.mPushState;
        if (r2 == null) goto L29;
        r2.setContentDescription(r6.name);
        return;
    L29:
        QuickContactBadge r5 = this.mQuickContact;
        if (r5 == null) goto L35;
        r5.setContentDescription(r6.name);
        return;
    L35:
        return;
    L18:
        if (this.mPhoto == null) goto L22;
        QuickContactBadge r3 = this.mQuickContact;
        if (r3 == null) goto L26;
        r3.assignContactUri(this.mLookupUri);
        goto L26
    L22:
        QuickContactBadge r4 = this.mQuickContact;
        if (r4 == null) goto L26;
        r4.assignContactUri(this.mLookupUri);
        this.mPhotoManager.loadPhoto(this.mQuickContact, r6.photoUri, isDefaultIconHires(), isDarkTheme());
        goto L26
    L6:
        if (r6.status != null) goto L8;
        this.mStatus.setVisibility(8);
        goto L9
    L8:
        this.mStatus.setText(r6.status);
        this.mStatus.setCompoundDrawablesWithIntrinsicBounds(r6.presenceIcon, null, null, null);
        this.mStatus.setVisibility(0);
        goto L9
    L32:
        setVisibility(4);
    }

    public void setListener(Listener r2) {
        this.mListener = r2;
        if (r2 == null) goto L5;
        View.OnClickListener r3 = new AnonymousClass1(this);
    L6:
        View r0 = this.mPushState;
        if (r0 == null) goto L9;
        r0.setOnClickListener(r3);
        return;
    L9:
        setOnClickListener(r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void setHorizontalDividerVisibility(int r1) {
        View r0 = this.mHorizontalDivider;
        if (r0 == null) goto L6;
        r0.setVisibility(r1);
        return;
    }

    public Uri getLookupUri() {
        return this.mLookupUri;
    }

    public OCheckBox getCheckBox() {
        return this.mCheckBox;
    }

    public View getPhotoFrame() {
        return this.mPhotoFrame;
    }

    public View getCheckBoxFrame() {
        return this.mCheckBoxFrame;
    }

    public void setCheckBoxChecked(boolean r1) {
        this.mCheckBox.setChecked(r1);
    }

    public long getRawContactId() {
        return this.mRawContactId;
    }

    public QuickContactChildLayout getQuickContactChildLayout() {
        return this.mItem;
    }
}
