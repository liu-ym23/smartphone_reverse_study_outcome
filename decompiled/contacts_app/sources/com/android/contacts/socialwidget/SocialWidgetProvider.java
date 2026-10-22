package com.android.contacts.socialwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.GlobalProxyLancet;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.util.ContactBadgeUtil;
import com.android.contacts.util.HtmlUtils;
import com.android.contacts.util.StreamItemEntry;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SocialWidgetProvider extends AppWidgetProvider {
    private static final int SHORT_SNIPPET_LENGTH = 48;
    private static final String TAG = "SocialWidgetProvider";
    private static SparseArray<ContactLoader> sLoaders;

    public SocialWidgetProvider() {
    }

    static /* synthetic */ void access$000(Context r0, int r1, AppWidgetManager r2, ContactLoader.Result r3) {
        bindRemoteViews(r0, r1, r2, r3);
    }

    static {
        sLoaders = new SparseArray();
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context r6, AppWidgetManager r7, int[] r8) {
        if (ContactsUtils.DEBUG == false) goto L7;
        int r5 = r8.length;
        int r1 = 0;
    L5:
        if (r1 >= r5) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onUpdate called for " + r8[r1]);
        r1 = r1 + 1;
    L7:
        int r9 = r8.length;
        int r2 = 0;
    L8:
        if (r2 >= r9) goto L10;
        loadWidgetData(r6, r7, r8[r2], false);
        r2 = r2 + 1;
        goto L8
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context r6, int[] r7) {
        int r5 = r7.length;
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L11;
        int r1 = r7[r0];
        ContactLoader r2 = sLoaders.get(r1);
        if (r2 == null) goto L10;
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Stopping loader for widget with id=" + r1);
    L9:
        r2.stopLoading();
        sLoaders.delete(r1);
    L10:
        r0 = r0 + 1;
        goto L3
    L11:
        SocialWidgetSettings.getInstance().remove(r6, r7);
    }

    public static void loadWidgetData(final Context r7, final AppWidgetManager r8, final int r9, boolean r10) {
        ContactLoader r0 = sLoaders.get(r9);
        if (r0 == null) goto L7;
        if (r10 == true) goto L7;
        r0.startLoading();
        return;
    L7:
        if (r0 == null) goto L9;
        r0.reset();
    L9:
        RemoteViews r11 = new RemoteViews(r7.getPackageName(), R.layout.social_widget);
        r11.setTextViewText(R.id.name, r7.getString(R.string.common_loading));
        r11.setViewVisibility(R.id.name, 0);
        r11.setViewVisibility(R.id.name_and_snippet, 8);
        r8.updateAppWidget(r9, r11);
        Uri r3 = SocialWidgetSettings.getInstance().getContactUri(r7, r9);
        if (r3 != null) goto L12;
        return;
    L12:
        ContactLoader r12 = new ContactLoader(r7, r3, false, true, false);
        r12.registerListener(0, new AnonymousClass1(r7, r9, r8));
        r12.startLoading();
        sLoaders.append(r9, r12);
    }

    private static void bindRemoteViews(Context r9, int r10, AppWidgetManager r11, ContactLoader.Result r12) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Loaded " + r12.getLookupKey() + " for widget with id=" + r10);
    L5:
        RemoteViews r0 = new RemoteViews(r9.getPackageName(), R.layout.social_widget);
        if (r12.isLoaded() == true) goto L8;
        setDisplayNameAndSnippet(r9, r0, r9.getString(R.string.invalidContactMessage), null, null, null);
        setPhoto(r0, ContactBadgeUtil.loadDefaultAvatarPhoto(r9, false, false));
    L13:
        r11.updateAppWidget(r10, r0);
        return;
    L8:
        byte[] r1 = r12.getPhotoBinaryData();
        if (r1 == null) goto L11;
        Bitmap r2 = BitmapFactory.decodeByteArray(r1, 0, r1.length);
    L12:
        setPhoto(r0, r2);
        Intent r3 = new Intent("android.provider.action.QUICK_CONTACT");
        r3.setFlags(337641472);
        r3.setData(r12.getLookupUri());
        r3.putExtra("android.provider.extra.MODE", 1);
        PendingIntent r7 = PendingIntent.getActivity(r9, 0, r3, 0);
        r0.setOnClickPendingIntent(R.id.border, r7);
        setDisplayNameAndSnippet(r9, r0, r12.getDisplayName(), r12.getPhoneticName(), r12.getStreamItems(), r7);
        goto L13
    L11:
        r2 = ContactBadgeUtil.loadDefaultAvatarPhoto(r9, false, false);
        goto L12
    }

    private static void setPhoto(RemoteViews r1, Bitmap r2) {
        r1.setImageViewBitmap(R.id.image, r2);
    }

    private static void setDisplayNameAndSnippet(Context r5, RemoteViews r6, CharSequence r7, CharSequence r8, List<StreamItemEntry> r9, PendingIntent r10) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        if (TextUtils.isEmpty(r7) == false) goto L6;
        r7 = r5.getString(R.string.missing_name);
    L6:
        if (TextUtils.isEmpty(r8) == true) goto L8;
        r7 = r5.getString(R.string.widget_name_and_phonetic, new Object[]{r7, r8});
    L8:
        r0.append(r7);
        AbsoluteSizeSpan r11 = new AbsoluteSizeSpan(r5.getResources().getDimensionPixelSize(R.dimen.widget_text_size_name));
        StyleSpan r1 = new StyleSpan(1);
        r0.setSpan(r11, 0, r7.length(), 0);
        r0.setSpan(r1, 0, r7.length(), 0);
        if (r9 != null) goto L11;
    L23:
        r6.setTextViewText(R.id.name, r0);
        r6.setViewVisibility(R.id.name, 0);
        r6.setViewVisibility(R.id.name_and_snippet, 8);
        if (r10 == null) goto L29;
        r6.setOnClickPendingIntent(R.id.widget_container, r10);
        return;
    L29:
        return;
    L11:
        if (r9.isEmpty() == true) goto L23;
        StreamItemEntry r12 = r9.get(0);
        CharSequence r13 = HtmlUtils.fromHtml(r5, r12.getText());
        if (r13 != null) goto L17;
        r13 = "";
    L17:
        if (r13.length() > 48) goto L19;
        r0.append("\n");
    L20:
        r0.append(r13);
        r6.setTextViewText(R.id.name_and_snippet, r0);
        r6.setViewVisibility(R.id.name, 8);
        r6.setViewVisibility(R.id.name_and_snippet, 0);
        AccountType r14 = AccountTypeManager.getInstance(r5).getAccountType(r12.getAccountType(), r12.getDataSet());
        if (r14.getViewStreamItemActivity() == null) goto L27;
        Intent r15 = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(ContactsContract.StreamItems.CONTENT_URI, r12.getId()));
        r15.setClassName(r14.resPackageName, r14.getViewStreamItemActivity());
        r6.setOnClickPendingIntent(R.id.name_and_snippet_container, PendingIntent.getActivity(r5, 0, r15, 0));
        return;
    L27:
        return;
    L19:
        r0.append("  ");
        goto L20
    }
}
