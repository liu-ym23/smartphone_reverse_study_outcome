package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final int ID_CONTACTS_CONTACT = 3;
    private static final int ID_CONTACTS_LOOKUP = 1;
    private static final int ID_CONTACTS_PHOTO = 4;
    private static final int ID_CONTACTS_THUMBNAIL = 2;
    private static final int ID_LOOKUP_BY_PHONE = 5;
    private static final UriMatcher URI_MATCHER = null;

    static {
        UriMatcher r100 = new UriMatcher(-1);
        URI_MATCHER = r100;
        r100.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        r100.addURI("com.android.contacts", "contacts/lookup/*", 1);
        r100.addURI("com.android.contacts", "contacts/#/photo", 2);
        r100.addURI("com.android.contacts", "contacts/#", 3);
        r100.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        r100.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ void close(InputStream r100) throws IOException {
        close2(r100);
    }

    /* JADX INFO: renamed from: close, reason: avoid collision after fix types in other method */
    public void close2(InputStream r100) throws IOException {
        r100.close();
    }

    public StreamLocalUriFetcher(ContentResolver r100, Uri r101) {
        super(r100, r101);
    }

    private InputStream loadResourceFromUri(Uri r100, ContentResolver r101) throws FileNotFoundException {
        int r102 = URI_MATCHER.match(r100);
        if (r102 != 1) goto L5;
    L12:
        Uri r103 = ContactsContract.Contacts.lookupContact(r101, r100);
        if (r103 == null) goto L17;
        return openContactPhotoInputStream(r101, r103);
    L17:
        throw new FileNotFoundException("Contact cannot be found");
    L5:
        if (r102 == 3) goto L11;
        if (r102 == 5) goto L12;
        return ContentResolverWrapper.openInputStream(r101, r100);
    L11:
        return openContactPhotoInputStream(r101, r100);
    }

    private InputStream openContactPhotoInputStream(ContentResolver r100, Uri r101) {
        return ContactsContract.Contacts.openContactPhotoInputStream(r100, r101, true);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public InputStream loadResource(Uri r100, ContentResolver r101) throws FileNotFoundException {
        InputStream r102 = loadResourceFromUri(r100, r101);
        if (r102 == null) goto L6;
        return r102;
    L6:
        throw new FileNotFoundException("InputStream is null for " + r100);
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public /* bridge */ /* synthetic */ InputStream loadResource(Uri r100, ContentResolver r101) throws FileNotFoundException {
        return loadResource(r100, r101);
    }
}
