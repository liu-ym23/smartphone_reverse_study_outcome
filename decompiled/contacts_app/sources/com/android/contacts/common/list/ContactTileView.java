package com.android.contacts.common.list;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactTileView extends FrameLayout {
    private static final String TAG = "ContactTileView";
    private View mHorizontalDivider;
    protected Listener mListener;
    private Uri mLookupUri;
    private TextView mName;
    private TextView mPhoneLabel;
    private TextView mPhoneNumber;
    private ImageView mPhoto;
    private ContactPhotoManager mPhotoManager;
    private View mPushState;
    private QuickContactBadge mQuickContact;
    private TextView mStatus;

    public interface Listener {
        int getApproximateTileWidth();

        void onCallNumberDirectly(String r1);

        void onContactSelected(Uri r1, Rect r2);
    }

    static {
    }

    protected void configureViewForImage(boolean r1) {
    }

    protected abstract int getApproximateImageSize();

    protected boolean isContactPhotoCircular() {
        return true;
    }

    protected abstract boolean isDarkTheme();

    public ContactTileView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mPhotoManager = null;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mName = (TextView) findViewById(R.id.contact_tile_name);
        this.mQuickContact = (QuickContactBadge) findViewById(R.id.contact_tile_quick);
        this.mPhoto = (ImageView) findViewById(R.id.contact_tile_image);
        this.mStatus = (TextView) findViewById(R.id.contact_tile_status);
        this.mPhoneLabel = (TextView) findViewById(R.id.contact_tile_phone_type);
        this.mPhoneNumber = (TextView) findViewById(R.id.contact_tile_phone_number);
        this.mPushState = findViewById(R.id.contact_tile_push_state);
        this.mHorizontalDivider = findViewById(R.id.contact_tile_horizontal_divider);
        setOnClickListener(createClickListener());
    }

    protected View.OnClickListener createClickListener() {
        return new AnonymousClass1(this);
    }

    public void setPhotoManager(ContactPhotoManager r1) {
        this.mPhotoManager = r1;
    }

    public void loadFromContact(ContactEntry r12) {
        if (r12 == null) goto L38;
        this.mName.setText(getNameForView(r12));
        this.mLookupUri = r12.lookupUri;
        boolean r2 = false;
        if (this.mStatus == null) goto L10;
        if (r12.status != null) goto L8;
        this.mStatus.setVisibility(8);
        goto L10
    L8:
        this.mStatus.setText(r12.status);
        this.mStatus.setCompoundDrawablesWithIntrinsicBounds(r12.presenceIcon, null, null, null);
        this.mStatus.setVisibility(0);
    L10:
        if (this.mPhoneLabel != null) goto L12;
    L15:
        TextView r0 = this.mPhoneNumber;
        if (r0 == null) goto L18;
        r0.setText(r12.phoneNumber);
    L18:
        setVisibility(0);
        if (this.mPhotoManager == null) goto L31;
        ContactPhotoManager.DefaultImageRequest r10 = getDefaultImageRequest(r12.namePrimary, r12.lookupKey);
        if (r12.photoUri != null) goto L23;
        r2 = true;
    L23:
        configureViewForImage(r2);
        ImageView r4 = this.mPhoto;
        if (r4 == null) goto L28;
        this.mPhotoManager.loadPhoto(r4, r12.photoUri, r12.account, getApproximateImageSize(), isDarkTheme(), isContactPhotoCircular(), r10);
        QuickContactBadge r1 = this.mQuickContact;
        if (r1 == null) goto L32;
        r1.assignContactUri(this.mLookupUri);
    L32:
        View r3 = this.mPushState;
        if (r3 == null) goto L35;
        r3.setContentDescription(r12.namePrimary);
        return;
    L35:
        QuickContactBadge r11 = this.mQuickContact;
        if (r11 == null) goto L41;
        r11.setContentDescription(r12.namePrimary);
        return;
    L41:
        return;
    L28:
        QuickContactBadge r5 = this.mQuickContact;
        if (r5 == null) goto L32;
        r5.assignContactUri(this.mLookupUri);
        this.mPhotoManager.loadPhoto(this.mQuickContact, r12.photoUri, r12.account, getApproximateImageSize(), isDarkTheme(), isContactPhotoCircular(), r10);
        goto L32
    L31:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "contactPhotoManager not set");
        goto L32
    L12:
        if (TextUtils.isEmpty(r12.phoneLabel) == false) goto L14;
        this.mPhoneLabel.setVisibility(8);
        goto L15
    L14:
        this.mPhoneLabel.setVisibility(0);
        this.mPhoneLabel.setText(r12.phoneLabel);
        goto L15
    L38:
        setVisibility(4);
    }

    public void setListener(Listener r1) {
        this.mListener = r1;
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

    protected QuickContactBadge getQuickContact() {
        return this.mQuickContact;
    }

    protected View getPhotoView() {
        return this.mPhoto;
    }

    protected String getNameForView(ContactEntry r1) {
        return r1.namePrimary;
    }

    protected ContactPhotoManager.DefaultImageRequest getDefaultImageRequest(String r2, String r3) {
        return new ContactPhotoManager.DefaultImageRequest(r2, r3, isContactPhotoCircular());
    }
}
