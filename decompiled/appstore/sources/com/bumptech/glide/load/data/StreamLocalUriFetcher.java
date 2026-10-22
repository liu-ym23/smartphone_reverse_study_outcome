package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final int ID_CONTACTS_CONTACT = 3;
    private static final int ID_CONTACTS_LOOKUP = 1;
    private static final int ID_CONTACTS_PHOTO = 4;
    private static final int ID_CONTACTS_THUMBNAIL = 2;
    private static final int ID_LOOKUP_BY_PHONE = 5;
    private static final UriMatcher URI_MATCHER = null;

    static {
        UriMatcher r10 = new UriMatcher(-1);
        URI_MATCHER = r10;
        r10.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        r10.addURI("com.android.contacts", "contacts/lookup/*", 1);
        r10.addURI("com.android.contacts", "contacts/#/photo", 2);
        r10.addURI("com.android.contacts", "contacts/#", 3);
        r10.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        r10.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver r10, Uri r11) {
        super(r10, r11);
    }

    private InputStream loadResourceFromUri(Uri r10, ContentResolver r11) throws FileNotFoundException {
        int r12 = URI_MATCHER.match(r10);
        if (r12 != 1) goto L5;
    L12:
        Uri r13 = ContactsContract.Contacts.lookupContact(r11, r10);
        if (r13 == null) goto L17;
        return openContactPhotoInputStream(r11, r13);
    L17:
        throw new FileNotFoundException("Contact cannot be found");
    L5:
        if (r12 == 3) goto L11;
        if (r12 == 5) goto L12;
        return r11.openInputStream(r10);
    L11:
        return openContactPhotoInputStream(r11, r10);
    }

    private InputStream openContactPhotoInputStream(ContentResolver r10, Uri r11) {
        return ContactsContract.Contacts.openContactPhotoInputStream(r10, r11, true);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ void close(InputStream r10) throws IOException {
        close2(r10);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ InputStream loadResource(Uri r10, ContentResolver r11) throws FileNotFoundException {
        return loadResource(r10, r11);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(InputStream r10) throws IOException {
        r10.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public InputStream loadResource(Uri r10, ContentResolver r11) throws FileNotFoundException {
        InputStream r12 = loadResourceFromUri(r10, r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new FileNotFoundException("InputStream is null for " + r10);
    }
}
