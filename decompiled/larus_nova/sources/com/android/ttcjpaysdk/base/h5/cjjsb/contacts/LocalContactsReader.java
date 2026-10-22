package com.android.ttcjpaysdk.base.h5.cjjsb.contacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.vesdk.VERecordData;
import f06.b;
import f06.c;
import f06.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/LocalContactsReader;", "", "()V", "TAG", "", "getPositionIndex", "", "sections", "", VERecordData.VIDEOCOUNTS, "([Ljava/lang/String;[I)[I", "indexOrder", "", "letter", "parseIndexLetter", "value", "readContacts", "", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/LocalContact;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ContactBuilder", "SectionResolver", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalContactsReader {
    public static final LocalContactsReader INSTANCE = null;
    private static final String TAG = "LocalContactsReader";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/LocalContactsReader$ContactBuilder;", "", "()V", "indexLetter", "", "getIndexLetter", "()Ljava/lang/String;", "setIndexLetter", "(Ljava/lang/String;)V", "name", "getName", "setName", "phones", "", "getPhones", "()Ljava/util/List;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContactBuilder {
        private String indexLetter;
        private String name;
        private final List<String> phones;

        public ContactBuilder() {
            this.name = "";
            this.indexLetter = "#";
            this.phones = new ArrayList();
        }

        public final String getIndexLetter() {
            return this.indexLetter;
        }

        public final String getName() {
            return this.name;
        }

        public final List<String> getPhones() {
            return this.phones;
        }

        public final void setIndexLetter(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.indexLetter = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/contacts/LocalContactsReader$SectionResolver;", "", EffectConfiguration.KEY_CURSOR, "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", "positionIndex", "", "sectionIndex", "", "sections", "", "", "[Ljava/lang/String;", "getSection", "rowIndex", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SectionResolver {
        private final int[] positionIndex;
        private int sectionIndex;
        private final String[] sections;

        public SectionResolver(Cursor r100) {
            Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_CURSOR);
            Bundle r101 = r100.getExtras();
            String[] r102 = r101.getStringArray("android.provider.extra.ADDRESS_BOOK_INDEX_TITLES");
            this.sections = r102;
            int[] r103 = r101.getIntArray("android.provider.extra.ADDRESS_BOOK_INDEX_COUNTS");
            this.positionIndex = LocalContactsReader.access$getPositionIndex(LocalContactsReader.INSTANCE, r102, r103);
        }

        public final String getSection(int r100) {
            String[] r101 = this.sections;
            if (r101 != null) goto L5;
            return "";
        L5:
            int[] r102 = this.positionIndex;
            if (r102 != null) goto L8;
            return "";
        L8:
            int r103 = r102.length;
            int r104 = this.sectionIndex;
            if (r103 <= (r104 + 1)) goto L14;
            if (r100 < r102[r104 + 1]) goto L14;
            this.sectionIndex = r104 + 1;
        L14:
            if (r101.length > r104) goto L16;
            return "";
        L16:
            return LocalContactsReader.access$parseIndexLetter(LocalContactsReader.INSTANCE, r101[r104]);
        }
    }

    static {
        INSTANCE = new LocalContactsReader();
    }

    private LocalContactsReader() {
    }

    private final int indexOrder(String r100) {
        if (Intrinsics.areEqual(r100, "#") == false) goto L5;
        return Integer.MAX_VALUE;
    L5:
        return 0;
    }

    private final String parseIndexLetter(String r100) {
        Character r101 = StringsKt.firstOrNull(r100);
        if (r101 == null) goto L12;
        char r102 = Character.toUpperCase(r101.charValue());
        boolean r103 = false;
        if ('A' <= r102) goto L7;
    L9:
        if (r103 == true) goto L11;
        return "#";
    L11:
        return String.valueOf(r102);
    L7:
        if (r102 >= '[') goto L9;
        r103 = true;
        goto L9
    L12:
        return "#";
    }

    public final List<LocalContact> readContacts(Context r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        LinkedHashMap r100 = new LinkedHashMap();
        Cursor r101 = com_android_ttcjpaysdk_base_h5_cjjsb_contacts_LocalContactsReader_android_content_ContentResolver_query(r210.getContentResolver(), ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("android.provider.extra.ADDRESS_BOOK_INDEX", "true").build(), new String[]{"contact_id", IGoogleService.ResponseKey.DISPLAY_NAME, "data1"}, null, null, "sort_key ASC");     // Catch: Throwable -> L94
        if (r101 == null) goto L6;
        Cursor r102 = r101;     // Catch: Throwable -> L94
        Cursor r103 = r102;     // Catch: Throwable -> L87
        int r104 = r103.getColumnIndex("contact_id");     // Catch: Throwable -> L87
        int r105 = r103.getColumnIndex(IGoogleService.ResponseKey.DISPLAY_NAME);     // Catch: Throwable -> L87
        int r106 = r103.getColumnIndex("data1");     // Catch: Throwable -> L87
        if (r104 < 0) goto L84;
        if (r105 < 0) goto L84;
        if (r106 < 0) goto L84;
        SectionResolver r107 = new SectionResolver(r103);     // Catch: Throwable -> L87
        int r108 = 0;
    L15:
        boolean r110 = true;
        if (r103.moveToNext() == false) goto L60;
        String r111 = r107.getSection(r108);     // Catch: Throwable -> L87
        r108 = r108 + 1;     // Catch: Throwable -> L87
        String r112 = r103.getString(r104);     // Catch: Throwable -> L87
        if (r112 != null) goto L22;
        r112 = "";
    L22:
        if (r112.length() != 0) goto L24;
        boolean r113 = true;
    L25:
        if (r113 == true) goto L15;
        Object r114 = r100.get(r112);     // Catch: Throwable -> L87
        if (r114 != null) goto L30;
        r114 = new ContactBuilder();     // Catch: Throwable -> L87
        r100.put(r112, r114);     // Catch: Throwable -> L87
    L30:
        ContactBuilder r115 = (ContactBuilder) r114;     // Catch: Throwable -> L87
        if (r115.getName().length() != 0) goto L33;
        boolean r116 = true;
    L34:
        if (r116 == false) goto L40;
        String r117 = r103.getString(r105);     // Catch: Throwable -> L87
        if (r117 != null) goto L38;
        r117 = "";
    L38:
        r115.setName(r117);     // Catch: Throwable -> L87
    L40:
        if (r111.length() <= 0) goto L42;
        boolean r118 = true;
    L43:
        if (r118 == true) goto L45;
    L47:
        String r119 = r103.getString(r106);     // Catch: Throwable -> L87
        if (r119 != null) goto L50;
        String r120 = "";
    L51:
        String r121 = StringsKt.replace$default(r120, " ", "", false, 4, null);     // Catch: Throwable -> L87
        if (r121.length() == 0) goto L55;
        r110 = false;
    L55:
        if (r110 == true) goto L15;
        if (r115.getPhones().contains(r121) == true) goto L15;
        r115.getPhones().add(r121);     // Catch: Throwable -> L87
        goto L15
    L50:
        r120 = r119;
        goto L51
    L45:
        if (Intrinsics.areEqual(r115.getIndexLetter(), "#") == false) goto L47;
        r115.setIndexLetter(r111);     // Catch: Throwable -> L87
        goto L47
    L42:
        r118 = false;
        goto L43
    L33:
        r116 = false;
        goto L34
    L24:
        r113 = false;
        goto L25
    L60:
        Collection r109 = r100.values();     // Catch: Throwable -> L87
        ArrayList r122 = new ArrayList();     // Catch: Throwable -> L87
        Iterator r123 = r109.iterator();     // Catch: Throwable -> L87
    L62:
        if (r123.hasNext() == false) goto L66;
        Object r124 = r123.next();     // Catch: Throwable -> L87
        if (Intrinsics.areEqual(((ContactBuilder) r124).getIndexLetter(), "#") == false) goto L62;
        r122.add(r124);     // Catch: Throwable -> L87
        goto L62
    L66:
        Iterator r125 = r122.iterator();     // Catch: Throwable -> L87
    L68:
        if (r125.hasNext() == false) goto L70;
        ContactBuilder r126 = (ContactBuilder) r125.next();     // Catch: Throwable -> L87
        r126.setIndexLetter(INSTANCE.parseIndexLetter(r126.getName()));     // Catch: Throwable -> L87
        goto L68
    L70:
        Unit r127 = Unit.INSTANCE;     // Catch: Throwable -> L87
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L94
        Collection r128 = r100.values();
        ArrayList r129 = new ArrayList();
        Iterator r130 = r128.iterator();
    L74:
        if (r130.hasNext() == false) goto L78;
        Object r131 = r130.next();
        if ((!((ContactBuilder) r131).getPhones().isEmpty()) == false) goto L74;
        r129.add(r131);
        goto L74
    L78:
        ArrayList r132 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r133 = r129.iterator();
    L80:
        if (r133.hasNext() == false) goto L83;
        ContactBuilder r134 = (ContactBuilder) r133.next();
        r132.add(new LocalContact(r134.getName(), r134.getPhones(), r134.getIndexLetter()));
        goto L80
    L83:
        return CollectionsKt.sortedWith(r132, ComparisonsKt.compareBy(new Function1[]{AnonymousClass4.INSTANCE, AnonymousClass5.INSTANCE}));
    L84:
        List<LocalContact> r135 = CollectionsKt.emptyList();     // Catch: Throwable -> L87
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L94
        return r135;
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L94
        throw th;     // Catch: Throwable -> L94
    L6:
        return CollectionsKt.emptyList();
    L94:
        th = move-exception;
        CJLogger.b(TAG, "readContacts fail: " + th.getMessage());
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ int access$indexOrder(LocalContactsReader r100, String r101) {
        return r100.indexOrder(r101);
    }

    public static final /* synthetic */ String access$parseIndexLetter(LocalContactsReader r100, String r101) {
        return r100.parseIndexLetter(r101);
    }

    private final int[] getPositionIndex(String[] r100, int[] r101) {
        if (r100 == null) goto L9;
        if (r101 == null) goto L12;
        int r102 = Math.min(r100.length, r101.length);
        int[] r103 = new int[r102];
        int r104 = 0;
        int r105 = 0;
    L6:
        if (r104 >= r102) goto L8;
        r103[r104] = r105;
        r105 = r105 + r101[r104];
        r104 = r104 + 1;
        goto L6
    L8:
        return r103;
    L12:
        return null;
    L9:
        return null;
    }

    public static final /* synthetic */ int[] access$getPositionIndex(LocalContactsReader r100, String[] r101, int[] r102) {
        return r100.getPositionIndex(r101, r102);
    }

    private static Cursor com_android_ttcjpaysdk_base_h5_cjjsb_contacts_LocalContactsReader_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
