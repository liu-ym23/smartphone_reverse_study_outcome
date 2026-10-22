package com.android.contacts.detail;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.preference.ContactsPreferences;
import com.android.contacts.util.BlackListQueryHandler;
import com.android.contacts.util.CenteredImageSpan;
import com.android.contacts.util.ContactBadgeUtil;
import com.android.contacts.util.ContactPhotoUtils;
import com.android.contacts.util.HtmlUtils;
import com.android.contacts.util.StreamItemEntry;
import com.android.contacts.util.StreamItemPhotoEntry;
import com.android.contacts.widget.AvatarImageView;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.dialog.base.AbstractDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContactDetailDisplayUtils {
    private static final int PHOTO_FADE_IN_ANIMATION_DURATION_MILLIS = 100;
    private static final String TAG = "ContactDetailDisplayUtils";

    private static class DefaultImageGetter implements Html.ImageGetter {
        private static final String RES_SCHEME = "res";
        private final PackageManager mPackageManager;

        public DefaultImageGetter(PackageManager r1) {
            this.mPackageManager = r1;
        }

        @Override // android.text.Html.ImageGetter
        public Drawable getDrawable(String r9) {
            Uri r3 = Uri.parse(r9);     // Catch: Throwable -> L36
            if (RES_SCHEME.equals(r3.getScheme()) == false) goto L7;
            String r4 = r3.getAuthority();
            Resources r5 = getResourcesForResourceName(r4);
            if (r5 == null) goto L13;
            List<String> r6 = r3.getPathSegments();
            if (r6 != null) goto L19;
        L24:
            if (r6 == null) goto L35;
            int r0 = r5.getIdentifier(r6.get(0), "drawable", r4);
            if (r0 == 0) goto L28;
            return getResourceDrawable(r5, r0);
        L33:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactDetailDisplayUtils.TAG, "Resource not found: " + r9, e);
            goto L35
        L28:
            if (ContactsUtils.DEBUG == false) goto L30;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailDisplayUtils.TAG, "Cannot resolve resource identifier: " + r9);
        L30:
            return null;
        L35:
            return null;
        L19:
            if (r6.size() == 1) goto L24;
            if (ContactsUtils.DEBUG == false) goto L23;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailDisplayUtils.TAG, "Could not parse image source: " + r9);
        L23:
            return null;
        L13:
            if (ContactsUtils.DEBUG == false) goto L15;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailDisplayUtils.TAG, "Could not parse image source: " + r9);
        L15:
            return null;
        L7:
            if (ContactsUtils.DEBUG == false) goto L9;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(ContactDetailDisplayUtils.TAG, "Image source does not correspond to a resource: " + r9);
        L9:
            return null;
        L36:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactDetailDisplayUtils.TAG, "Could not parse image source: " + r9);
            return null;
        }

        private Drawable getResourceDrawable(Resources r2, int r3) throws Resources.NotFoundException {
            Drawable r1 = r2.getDrawable(r3);
            r1.setBounds(0, 0, r1.getIntrinsicWidth(), r1.getIntrinsicHeight());
            return r1;
        }

        private Resources getResourcesForResourceName(String r2) {
            return this.mPackageManager.getResourcesForApplication(r2);
        L4:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(ContactDetailDisplayUtils.TAG, "Could not find package: " + r2);
            return null;
        }
    }

    public static class StreamPhotoTag {
        public final StreamItemEntry streamItem;
        public final StreamItemPhotoEntry streamItemPhoto;

        public StreamPhotoTag(StreamItemEntry r1, StreamItemPhotoEntry r2) {
            this.streamItem = r1;
            this.streamItemPhoto = r2;
        }

        public Uri getStreamItemPhotoUri() {
            Uri.Builder r0 = ContactsContract.StreamItems.CONTENT_URI.buildUpon();
            ContentUris.appendId(r0, this.streamItem.getId());
            r0.appendPath(BlackListQueryHandler.KEY_PHOTO);
            ContentUris.appendId(r0, this.streamItemPhoto.getId());
            return r0.build();
        }
    }

    private ContactDetailDisplayUtils() {
    }

    public static CharSequence getDisplayName(Context r3, ContactLoader.Result r4) {
        String r0 = r4.getDisplayName();
        String r5 = r4.getAltDisplayName();
        ContactsPreferences r1 = new ContactsPreferences(r3);
        if (TextUtils.isEmpty(r0) == true) goto L11;
        if (TextUtils.isEmpty(r5) == true) goto L11;
        if (r1.getDisplayOrder() != 1) goto L12;
        return r0;
    L12:
        return r5;
    L11:
        return r3.getResources().getString(R.string.missing_name);
    }

    public static String getPhoneticName(Context r0, ContactLoader.Result r1) {
        String r2 = r1.getPhoneticName();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        return r2;
    L5:
        return null;
    }

    public static String getAttribution(Context r2, ContactLoader.Result r3) {
        if (r3.isDirectoryEntry() == false) goto L10;
        String r0 = r3.getDirectoryDisplayName();
        String r4 = r3.getDirectoryType();
        if (TextUtils.isEmpty(r0) == false) goto L9;
        r0 = r4;
    L9:
        return r2.getString(R.string.contact_directory_description, new Object[]{r0});
    L10:
        return null;
    }

    public static String getCompany(Context r8, ContactLoader.Result r9) {
        if (r9.getDisplayNameSource() != 30) goto L5;
        boolean r0 = true;
    L6:
        Iterator<Entity> r10 = r9.getEntities().iterator();
    L8:
        if (r10.hasNext() == false) goto L29;
        Iterator<Entity.NamedContentValues> r1 = r10.next().getSubValues().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        ContentValues r5 = r1.next().values;
        if ("vnd.android.cursor.item/organization".equals(r5.getAsString("mimetype")) == false) goto L11;
        String r6 = r5.getAsString("data1");
        String r7 = r5.getAsString("data4");
        if (TextUtils.isEmpty(r6) == false) goto L19;
        if (r0 == false) goto L27;
        r7 = null;
    L27:
        if (TextUtils.isEmpty(r7) == true) goto L11;
        return r7;
    L19:
        if (TextUtils.isEmpty(r7) == false) goto L23;
        if (r0 == false) goto L22;
        r6 = null;
    L22:
        r7 = r6;
        goto L27
    L23:
        if (r0 == true) goto L27;
        r7 = r8.getString(R.string.organization_company_and_title, new Object[]{r6, r7});
        goto L27
    L29:
        return null;
    L5:
        r0 = false;
        goto L6
    }

    public static void setPhoto(Context r4, ContactLoader.Result r5, ImageView r6) {
        if (r5.isLoadingPhoto() == true) goto L5;
        byte[] r0 = r5.getPhotoBinaryData();
        if ((r6 instanceof AvatarImageView) == false) goto L17;
        AvatarImageView r2 = (AvatarImageView) r6;
        if (r0 == null) goto L14;
        boolean r3 = true;
    L15:
        r2.setStrokeEnabled(r3);
        goto L17
    L14:
        r3 = false;
    L17:
        if (r0 == null) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "setPhoto photo != null");
        Bitmap r7 = ContactPhotoUtils.getCorrectlyOrientedImage(r0);
    L20:
        if (r7 == null) goto L23;
        r6.setImageBitmap(NameAvatarController.getCircleBitmap(r7, false));
        return;
    L23:
        return;
    L19:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "setPhoto photo == null");
        r7 = ContactsUtils.creatBitmapFromName(r4, (String) getDisplayName(r4, r5));
        goto L20
    L5:
        if ((r6 instanceof AvatarImageView) == false) goto L7;
        ((AvatarImageView) r6).setStrokeEnabled(false);
    L7:
        r6.setImageBitmap(null);
    }

    public static void getRoundedCornerBitmap(float r7, Bitmap r8) {
        Bitmap r9 = r8.copy(Bitmap.Config.ARGB_8888, true);
        Canvas r0 = new Canvas(r9);
        Paint r2 = new Paint();
        Rect r3 = new Rect(0, 0, r9.getWidth(), r9.getHeight());
        RectF r4 = new RectF(r3);
        r2.setAntiAlias(true);
        r0.drawARGB(0, 0, 0, 0);
        r0.drawRoundRect(r4, r7, r7, r2);
        r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        r0.drawBitmap(r9, r3, r3, r2);
    }

    static void changeBitmap(Bitmap r5, Bitmap r6) {
        Canvas r1 = new Canvas(Bitmap.createBitmap(AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT, Bitmap.Config.ARGB_8888));
        Path r7 = new Path();
        float r2 = AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT;
        float r3 = (r2 - 1.0f) / 2.0f;
        r7.addCircle(r3, r3, Math.min(r2, r2) / 2.0f, Path.Direction.CCW);
        r1.clipPath(r7);
        r1.drawBitmap(r5, new Rect(0, 0, r5.getWidth(), r5.getHeight()), new Rect(0, 0, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT, AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT), null);
    }

    public static void setStarred(ContactLoader.Result r1, OCheckBox r2) {
        if (r1.isDirectoryEntry() == false) goto L5;
    L7:
        r2.setVisibility(8);
        return;
    L5:
        if (r1.isUserProfile() == true) goto L7;
        r2.setVisibility(0);
        r2.setChecked(r1.getStarred());
    }

    public static void setNumberStarred(ContactLoader.Result r0, long r1, OCheckBox r3) {
        if (r0.isDirectoryEntry() == false) goto L5;
    L7:
        r3.setVisibility(8);
        return;
    L5:
        if (r0.isUserProfile() == true) goto L7;
        r3.setVisibility(0);
    }

    public static void setSocialSnippet(Context r9, ContactLoader.Result r10, TextView r11, ImageView r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        Spanned r2 = null;
        if (r10.getStreamItems().isEmpty() == true) goto L10;
        StreamItemEntry r13 = r10.getStreamItems().get(0);
        Spanned r0 = HtmlUtils.fromHtml(r9, r13.getText());
        if (r13.getPhotos().isEmpty() == true) goto L9;
        String r14 = r13.getPhotos().get(0).getPhotoUri();
    L11:
        setDataOrHideIfNone(r2, r11);
        if (r14 == null) goto L14;
        ContactPhotoManager.getInstance(r9).loadPhoto(r12, Uri.parse(r14), true, false, ContactPhotoManager.DEFAULT_BLANK);
        r12.setVisibility(0);
        return;
    L14:
        r12.setVisibility(8);
        return;
    L9:
        r14 = null;
        r2 = r0;
        goto L11
    L10:
        r14 = null;
        goto L11
    }

    public static View createStreamItemView(LayoutInflater r20, Context r21, StreamItemEntry r22, LinearLayout r23, View.OnClickListener r24) {
        boolean r10 = false;
        View r11 = r20.inflate(R.layout.stream_item_container, r23, false);
        ViewGroup r12 = (ViewGroup) r11.findViewById(R.id.stream_item_content);
        ContactPhotoManager r13 = ContactPhotoManager.getInstance(r21);
        List<StreamItemPhotoEntry> r14 = r22.getPhotos();
        int r15 = r14.size();
        int r7 = R.layout.stream_item_row_text;
        if (r15 != 0) goto L5;
        View r0 = r20.inflate(R.layout.stream_item_row_text, r12, false);
        addStreamItemText(r21, r22, r0);
        r12.addView(r0);
    L13:
        if (r23 == null) goto L15;
        r23.addView(r11);
    L15:
        return r11;
    L5:
        int r6 = 0;
    L6:
        if (r6 >= r15) goto L12;
        StreamItemPhotoEntry r4 = r14.get(r6);
        int r2 = r6 + 1;
        if (r2 >= r15) goto L10;
        StreamItemPhotoEntry r16 = r14.get(r2);
        View r5 = r20.inflate(R.layout.stream_item_row_two_images, r12, r10);
        loadPhoto(r13, r22, r4, r5, R.id.stream_item_first_image, r24);
        loadPhoto(r13, r22, r16, r5, R.id.stream_item_second_image, r24);
        r12.addView(r5);
    L11:
        r6 = r6 + 2;
        r7 = R.layout.stream_item_row_text;
        r10 = false;
        goto L6
    L10:
        View r8 = r20.inflate(R.layout.stream_item_row_one_image, r12, r10);
        loadPhoto(r13, r22, r4, r8, R.id.stream_item_first_image, r24);
        r12.addView(r8);
        goto L11
    L12:
        View r1 = r20.inflate(r7, r12, r10);
        r21.getResources().getDimensionPixelSize(R.dimen.detail_update_section_between_items_vertical_padding);
        addStreamItemText(r21, r22, r1);
        r12.addView(r1);
        goto L13
    }

    private static void loadPhoto(ContactPhotoManager r6, StreamItemEntry r7, StreamItemPhotoEntry r8, View r9, int r10, View.OnClickListener r11) {
        View r12 = r9.findViewById(r10);
        View r13 = r12.findViewById(R.id.push_layer);
        ImageView r1 = (ImageView) r12.findViewById(R.id.image);
        if (r11 == null) goto L5;
        r13.setOnClickListener(r11);
        r13.setTag(new StreamPhotoTag(r7, r8));
        r13.setFocusable(true);
        r13.setEnabled(true);
    L6:
        r6.loadPhoto(r1, Uri.parse(r8.getPhotoUri()), true, false, ContactPhotoManager.DEFAULT_BLANK);
        return;
    L5:
        r13.setOnClickListener(null);
        r13.setTag(null);
        r13.setFocusable(false);
        r13.setClickable(false);
        r13.setEnabled(false);
        goto L6
    }

    static View addStreamItemText(Context r6, StreamItemEntry r7, View r8) {
        TextView r0 = (TextView) r8.findViewById(R.id.stream_item_html);
        TextView r1 = (TextView) r8.findViewById(R.id.stream_item_attribution);
        TextView r2 = (TextView) r8.findViewById(R.id.stream_item_comments);
        DefaultImageGetter r3 = new DefaultImageGetter(r6.getPackageManager());
        setDataOrHideIfNone(HtmlUtils.fromHtml(r6, r7.getText(), r3, null), r0);
        setDataOrHideIfNone(ContactBadgeUtil.getSocialDate(r7, r6), r1);
        setDataOrHideIfNone(HtmlUtils.fromHtml(r6, r7.getComments(), r3, null), r2);
        return r8;
    }

    public static void setDisplayName(Context r0, ContactLoader.Result r1, TextView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        setDataOrHideIfNone(getDisplayName(r0, r1), r2);
    }

    public static void setCompanyName(Context r0, ContactLoader.Result r1, TextView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        setDataOrHideIfNone(getCompany(r0, r1), r2);
    }

    public static void setCombinedTextWithDivider(Context r4, TextView r5, CharSequence r6, CharSequence r7) {
        if (r4 == null) goto L16;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6) == false) goto L12;
        if (TextUtils.isEmpty(r7) == false) goto L10;
        r5.setText(null);
        r5.setVisibility(8);
        return;
    L10:
        r5.setText(r7);
        r5.setVisibility(0);
        return;
    L12:
        if (TextUtils.isEmpty(r7) == false) goto L14;
        r5.setText(r6);
        r5.setVisibility(0);
        return;
    L14:
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        r0.append(r6);
        r0.append("   ");
        r0.setSpan(new CenteredImageSpan(r4, R.drawable.line, 1), r0.length() - 1, r0.length(), 0);
        r0.append("  ");
        r0.append(r7);
        r5.setText(r0);
        r5.setVisibility(0);
        return;
    }

    public static String getNote(ArrayList<ContactDetailFragment.DetailViewEntry> r1) {
        if (r1.size() > 0) goto L7;
        return null;
    L7:
        return r1.get(0).data;
    }

    public static void setNote(ArrayList<ContactDetailFragment.DetailViewEntry> r1, TextView r2) {
        if (r1.size() <= 0) goto L5;
        String r3 = r1.get(0).data;
    L6:
        setDataOrHideIfNone(r3, r2);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static void setPhoneticName(Context r0, ContactLoader.Result r1, TextView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        setDataOrHideIfNone(getPhoneticName(r0, r1), r2);
    }

    public static void setAttribution(Context r0, ContactLoader.Result r1, TextView r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        setDataOrHideIfNone(getAttribution(r0, r1), r2);
    }

    private static void setDataOrHideIfNone(CharSequence r1, TextView r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
        r2.setText(r1);
        r2.setVisibility(0);
        return;
    L5:
        r2.setText(null);
        r2.setVisibility(8);
    }

    public static void setAlphaOnViewBackground(View r1, float r2) {
        if (r1 == null) goto L5;
        r1.setBackgroundColor(((int) (r2 * 255.0f)) << 24);
        return;
    }

    public static int getFirstListItemOffset(ListView r1) {
        if (r1 != null) goto L4;
        return Integer.MIN_VALUE;
    L4:
        if (r1.getChildCount() != 0) goto L6;
        return Integer.MIN_VALUE;
    L6:
        if (r1.getFirstVisiblePosition() == 0) goto L9;
        return Integer.MIN_VALUE;
    L9:
        return r1.getChildAt(0).getTop();
    }

    public static void requestToMoveToOffset(ListView r2, int r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getChildCount() != 0) goto L6;
        return;
    L6:
        if (r2.getFirstVisiblePosition() != 0) goto L16;
        if (r3 <= 0) goto L10;
        return;
    L10:
        if (r2.getChildAt(0).getTop() != r3) goto L12;
        return;
    L12:
        r2.setSelectionFromTop(0, r3);
        return;
    }
}
