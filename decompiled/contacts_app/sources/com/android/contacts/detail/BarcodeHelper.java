package com.android.contacts.detail;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.android.contacts.ContactLoader;
import com.android.contacts.R;
import com.android.contacts.util.SmtPcUtils;
import com.android.vcard.VCardBuilder;
import com.android.vcard.VCardConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.obric.oui.utils.AnimTokens;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class BarcodeHelper {
    private BarcodeHelper() {
    }

    private static String getVcardStream(Context r10, ContactLoader.Result r11, boolean r12) {
        VCardBuilder r0 = new VCardBuilder(VCardConfig.VCARD_TYPE_V30_JAPANESE);
        ArrayList<Entity> r13 = r11.getEntities();
        if (r13 == null) goto L34;
        if (r13.size() <= 0) goto L34;
        Iterator<Entity> r14 = r13.iterator();
        boolean r2 = false;
    L8:
        if (r14.hasNext() == false) goto L31;
        Entity r3 = r14.next();
        if (r3.getSubValues() == null) goto L8;
        Iterator<Entity.NamedContentValues> r4 = r3.getSubValues().iterator();
    L13:
        if (r4.hasNext() == false) goto L8;
        Entity.NamedContentValues r6 = r4.next();
        if (ContactsContract.Data.CONTENT_URI.equals(r6.uri) == false) goto L13;
        ContentValues r7 = r6.values;
        if (r7 == null) goto L13;
        String r8 = r7.getAsString("mimetype");
        if ("vnd.android.cursor.item/name".equals(r8) == true) goto L20;
        if ("vnd.android.cursor.item/note".equals(r8) == true) goto L24;
        appendData(r0, r7);
        goto L13
    L24:
        if (r12 == true) goto L25;
        appendData(r0, r7);
        goto L13
    L25:
        ContentValues r9 = new ContentValues(r7);
        String r15 = r9.getAsString("data1");
        if (TextUtils.isEmpty(r15) == true) goto L28;
        r9.put("data1", r15.substring(0, Math.min(r15.length(), 40)));
    L28:
        appendData(r0, r9);
        goto L13
    L20:
        if (r2 == true) goto L13;
        appendData(r0, r7);
        r2 = true;
        goto L13
    L31:
        if (r2 == true) goto L34;
        ArrayList r16 = new ArrayList(1);
        ContentValues r17 = new ContentValues();
        r17.put("data1", r10.getString(R.string.missing_name));
        r16.add(r17);
        r0.appendNameProperties(r16);
    L34:
        return r0.toString();
    }

    private static void appendData(VCardBuilder r2, ContentValues r3) {
        String r0 = r3.getAsString("mimetype");
        if (TextUtils.isEmpty(r0) == true) goto L38;
        ArrayList r1 = new ArrayList();
        r1.add(r3);
        if ("vnd.android.cursor.item/name".equals(r0) == false) goto L8;
        r2.appendNameProperties(r1);
        return;
    L8:
        if ("vnd.android.cursor.item/nickname".equals(r0) == false) goto L11;
        r2.appendNickNames(r1);
        return;
    L11:
        if ("vnd.android.cursor.item/phone_v2".equals(r0) == false) goto L14;
        r2.appendPhones(r1, null);
        return;
    L14:
        if ("vnd.android.cursor.item/email_v2".equals(r0) == false) goto L17;
        r2.appendEmails(r1);
        return;
    L17:
        if ("vnd.android.cursor.item/postal-address_v2".equals(r0) == false) goto L20;
        r2.appendPostals(r1);
        return;
    L20:
        if ("vnd.android.cursor.item/organization".equals(r0) == false) goto L23;
        r2.appendOrganizations(r1);
        return;
    L23:
        if ("vnd.android.cursor.item/website".equals(r0) == false) goto L26;
        r2.appendWebsites(r1);
        return;
    L26:
        if ("vnd.android.cursor.item/note".equals(r0) == false) goto L29;
        r2.appendNotes(r1);
        return;
    L29:
        if ("vnd.android.cursor.item/contact_event".equals(r0) == false) goto L32;
        r2.appendEvents(r1);
        return;
    L32:
        if ("vnd.android.cursor.item/im".equals(r0) == false) goto L35;
        r2.appendIms(r1);
        return;
    L35:
        if ("vnd.android.cursor.item/relation".equals(r0) == false) goto L49;
        r2.appendRelation(r1);
        return;
    L49:
        return;
    }

    public static Dialog getBarcodeDialog(Context r8, ContactLoader.Result r9) {
        Bitmap r10 = generateQRCode(getVcardStream(r8, r9, false), r8);     // Catch: WriterException -> L5
    L9:
        if (r10 == null) goto L23;
        Dialog r1 = new Dialog(r8);
        View r3 = LayoutInflater.from(r8).inflate(R.layout.barcode_popupwindow, null);
        r1.requestWindowFeature(1);
        r1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        r1.setContentView(r3);
        r1.setCancelable(true);
        r1.setCanceledOnTouchOutside(true);
        r1.getWindow().getAttributes().setTitle("BarcodeHelper");
        ImageView r2 = (ImageView) r1.findViewById(R.id.barcode_view);
        ImageView r4 = (ImageView) r1.findViewById(R.id.barcode_texture);
        if (r2 == null) goto L16;
        if (r4 == null) goto L16;
        r2.measure(0, 0);
        r4.measure(0, 0);
        if (SmtPcUtils.isPcMode(r8) == false) goto L16;
        r2.setMaxWidth((int) (((double) r4.getMeasuredWidth()) * 1.2d));
        r2.setMaxHeight((int) (((double) r4.getMeasuredHeight()) * 1.2d));
    L16:
        if (r2 == null) goto L19;
        r2.setImageBitmap(r10);
    L19:
        return r1;
    L23:
        return null;
    L5:
        r10 = generateQRCode(getVcardStream(r8, r9, true), r8);     // Catch: Exception -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        r10 = null;
        goto L9
    }

    private static Bitmap generateQRCode(String r7, Context r8) throws WriterException {
        if (TextUtils.isEmpty(r7) == true) goto L10;
        QRCodeWriter r1 = new QRCodeWriter();
        Hashtable r6 = new Hashtable();
        r6.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        r6.put(EncodeHintType.MARGIN, 0);
        if (SmtPcUtils.isPcMode(r8) == false) goto L7;
        BitMatrix r9 = r1.encode(r7, BarcodeFormat.QR_CODE, AnimTokens.OUI_ANIMATION_DURATION_MEDIUM_3, AnimTokens.OUI_ANIMATION_DURATION_MEDIUM_3, r6);
    L9:
        return bitMatrix2Bitmap(r9);
    L7:
        r9 = r1.encode(r7, BarcodeFormat.QR_CODE, 612, 612, r6);
        goto L9
    L10:
        return null;
    }

    private static Bitmap bitMatrix2Bitmap(BitMatrix r8) {
        int r6 = r8.getWidth();
        int r7 = r8.getHeight();
        int[] r1 = new int[r6 * r7];
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L12;
        int r3 = 0;
    L5:
        if (r3 >= r7) goto L11;
        if (r8.get(r2, r3) == false) goto L9;
        int r4 = -16777216;
    L10:
        r1[(r3 * r6) + r2] = r4;
        r3 = r3 + 1;
        goto L5
    L9:
        r4 = 0;
        goto L10
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        Bitmap r9 = Bitmap.createBitmap(r6, r7, Bitmap.Config.ARGB_4444);
        r9.setPixels(r1, 0, r6, 0, 0, r6, r7);
        return r9;
    }
}
