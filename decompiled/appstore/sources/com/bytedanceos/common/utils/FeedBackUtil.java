package com.bytedanceos.common.utils;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FeedBackUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f10167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public File f10170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b[] f10171f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedBackUtil f10172a;

        public a(FeedBackUtil r10) {
            this.f10172a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            File r10 = FeedBackUtil.g(this.f10172a);
            if (r10 != null) goto L5;
        L9:
            com.bytedanceos.common.toolbox.j.a("file is null:" + r10);
            return;
        L5:
            if (r10.isDirectory() == false) goto L9;
            FeedBackUtil.h(this.f10172a, r10);
        }
    }

    public class b extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f10173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference f10174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FeedBackUtil f10175c;

        public b(FeedBackUtil r10, ImageView r11) {
            this.f10175c = r10;
            this.f10173a = null;
            this.f10174b = new WeakReference(r11);
        }

        public Bitmap a(Object... r10) {
            Uri r11 = (Uri) r10[0];
            String r12 = (String) r10[1];
            Bitmap r13 = null;
            String r14 = FeedBackUtil.s(r11);     // Catch: IOException -> L7 FileNotFoundException -> L9
            if (r14 != null) goto L11;
            com.bytedanceos.common.toolbox.j.a("file is not exist path:" + r14);     // Catch: IOException -> L7 FileNotFoundException -> L9
            return null;
        L11:
            File r15 = new File(r14);     // Catch: IOException -> L7 FileNotFoundException -> L9
            if (r15.exists() == true) goto L15;
            com.bytedanceos.common.toolbox.j.a("file is not exist file:" + r15);     // Catch: IOException -> L7 FileNotFoundException -> L9
            return null;
        L15:
            FeedBackUtil r16 = this.f10175c;     // Catch: IOException -> L7 FileNotFoundException -> L9
            r13 = r16.k(r15, FeedBackUtil.a(r16), FeedBackUtil.b(this.f10175c));     // Catch: IOException -> L7 FileNotFoundException -> L9
            int r17 = FeedBackUtil.c(this.f10175c, r14);     // Catch: IOException -> L7 FileNotFoundException -> L9
            if (r17 == 0) goto L18;
            r13 = FeedBackUtil.d(this.f10175c, r13, r17);     // Catch: IOException -> L7 FileNotFoundException -> L9
        L18:
            this.f10173a = FeedBackUtil.e(this.f10175c, r12, r15.getName());     // Catch: IOException -> L7 FileNotFoundException -> L9
            publishProgress(new Bitmap[]{r13});     // Catch: IOException -> L7 FileNotFoundException -> L9
            if (this.f10173a.exists() == true) goto L21;
            FeedBackUtil.f(this.f10175c, this.f10173a, r12, r13);     // Catch: IOException -> L7 FileNotFoundException -> L9
        L25:
            return r13;
        L21:
            com.bytedanceos.common.toolbox.j.a("upload file exist:" + this.f10173a);     // Catch: IOException -> L7 FileNotFoundException -> L9
        L9:
            e = move-exception;
            com.bytedanceos.common.toolbox.j.a("uri = " + r11);
            e.printStackTrace();
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L25
        }

        public void b(Bitmap... r10) {
            if (isCancelled() == false) goto L6;
            return;
        L6:
            if (r10[0] != null) goto L9;
            e0.e(R$string.feedback_image_fail);
            return;
        L9:
            WeakReference r11 = this.f10174b;
            if (r11 == null) goto L22;
            ImageView r12 = (ImageView) r11.get();
            if (r12 != null) goto L15;
            com.bytedanceos.common.toolbox.j.a("WeakReference is null:" + this.f10173a);
            return;
        L15:
            r12.setContentDescription(BaseApplication.c().getResources().getString(R$string.feed_back_exist_image));
            if (r10[0] == null) goto L20;
            r12.setImageDrawable(new BitmapDrawable(r10[0]));
            r12.setEnabled(false);
            Object r13 = r12.getTag();
            if ((r13 instanceof ImageButton) == false) goto L23;
            ImageButton r14 = (ImageButton) r13;
            r14.setTag(this.f10173a);
            r14.setVisibility(0);
            return;
        L23:
            return;
        L20:
            r12.setEnabled(true);
            com.bytedanceos.common.toolbox.j.a("Bitmap is null:" + this.f10173a);
            return;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Object[] r10) {
            return a(r10);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            WeakReference r10 = this.f10174b;
            if (r10 == null) goto L8;
            ImageView r11 = (ImageView) r10.get();
            if (r11 == null) goto L9;
            r11.setEnabled(false);
            return;
        L9:
            return;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onProgressUpdate(Object[] r10) {
            b((Bitmap[]) r10);
        }
    }

    public FeedBackUtil(int r10, int r11) {
        this.f10166a = 70;
        this.f10167b = 0.5f;
        this.f10170e = null;
        this.f10171f = new b[4];
        this.f10168c = (int) (r10 * 0.5f);
        this.f10169d = (int) (r11 * 0.5f);
        this.f10170e = p();
    }

    public static /* synthetic */ int a(FeedBackUtil r10) {
        return r10.f10168c;
    }

    public static /* synthetic */ int b(FeedBackUtil r10) {
        return r10.f10169d;
    }

    public static /* synthetic */ int c(FeedBackUtil r10, String r11) {
        return r10.r(r11);
    }

    public static /* synthetic */ Bitmap d(FeedBackUtil r10, Bitmap r11, int r12) {
        return r10.z(r11, r12);
    }

    public static /* synthetic */ File e(FeedBackUtil r10, String r11, String r12) {
        return r10.v(r11, r12);
    }

    public static /* synthetic */ void f(FeedBackUtil r10, File r11, String r12, Bitmap r13) {
        r10.A(r11, r12, r13);
    }

    public static /* synthetic */ File g(FeedBackUtil r10) {
        return r10.p();
    }

    public static /* synthetic */ void h(FeedBackUtil r10, File r11) {
        r10.m(r11);
    }

    public static String s(Uri r10) {
        Cursor r11 = BaseApplication.c().getContentResolver().query(r10, new String[]{"_data"}, null, null, null);     // Catch: Throwable -> L16 Exception -> L18
        if (r11 != null) goto L27;
    L14:
        if (r11 == null) goto L23;
    L15:
        r11.close();
    L23:
        return null;
    L27:
    L12:
        e = e;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L10
        if (r11 == null) goto L23;
    L10:
        Throwable th = th;
    L24:
        if (r11 == null) goto L26;
        r11.close();
    L26:
        throw th;
    L6:
        if (r11.moveToFirst() == false) goto L14;
        String r12 = r11.getString(0);     // Catch: Throwable -> L10 Exception -> L12
        r11.close();
        return r12;
    L18:
        e = e;
        r11 = null;
    L16:
        th = move-exception;
        th = th;
        r11 = null;
        goto L24
    }

    public static int u(int r10, int r11, int r12, int r13) {
        if (r10 != 0) goto L5;
        if (r11 != 0) goto L5;
        return r12;
    L5:
        if (r10 == 0) goto L7;
        if (r11 != 0) goto L10;
        return r10;
    L10:
        double r14 = ((double) r13) / ((double) r12);
        double r15 = r11;
        if ((((double) r10) * r14) > r15) goto L13;
        return r10;
    L13:
        return (int) (r15 / r14);
    L7:
        return (int) (r12 * (((double) r11) / ((double) r13)));
    }

    public static boolean x(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        BitmapFactory.Options r11 = new BitmapFactory.Options();
        r11.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r10, r11);
        int r12 = r11.outWidth;
        int r13 = r11.outHeight;
        if (r12 <= r13) goto L8;
        r12 = r13;
    L8:
        if (r12 > 0) goto L10;
        return false;
    L10:
        return true;
    }

    public final void A(File r10, String r11, Bitmap r12) {
        if (r10 == null) goto L26;
        if (r12 == null) goto L26;
        ByteArrayOutputStream r13 = null;
        ByteArrayOutputStream r14 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        BufferedOutputStream r15 = new BufferedOutputStream(new FileOutputStream(r10), 8192);     // Catch: Throwable -> L17
        r12.compress(Bitmap.CompressFormat.JPEG, this.f10166a, r14);     // Catch: Throwable -> L12
    L10:
        if (r14.toByteArray().length <= 204800) goto L14;
        r12.compress(Bitmap.CompressFormat.JPEG, 10, r14);     // Catch: Throwable -> L12
        goto L10
    L14:
        r14.writeTo(r15);     // Catch: Throwable -> L12
        r14.flush();
        r14.close();
        r15.flush();
        r15.close();
        return;
    L12:
        th = th;
    L13:
        r13 = r14;
    L21:
        if (r13 == null) goto L23;
        r13.flush();
        r13.close();
    L23:
        if (r15 == null) goto L25;
        r15.flush();
        r15.close();
    L25:
        throw th;
    L17:
        th = th;
        r15 = null;
    L19:
        th = th;
        r15 = null;
    L26:
        com.bytedanceos.common.toolbox.j.a("fileName = " + r10);
    }

    public String i(String r10, int r11, StringBuilder r12, String r13) {
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L5
        if (BaseApplication.c().o() == false) goto L7;
        String r15 = "1";
    L8:
        r14.put("source", r15);     // Catch: JSONException -> L5
        r14.put("package", r10);     // Catch: JSONException -> L5
        r14.put("version_code", r11);     // Catch: JSONException -> L5
        r14.put("type", r12.toString());     // Catch: JSONException -> L5
        r14.put("feedback", r13);     // Catch: JSONException -> L5
        r14.put(ServerElements.SECOND_BAR_PIC, w(r10));     // Catch: JSONException -> L5
        return r14.toString();
    L7:
        r15 = "2";
    L5:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public void j() {
        b[] r10 = this.f10171f;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        b r13 = r10[r12];
        if (r13 == null) goto L7;
        r13.cancel(true);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    public Bitmap k(File r10, int r11, int r12) {
        FileInputStream r13 = null;
        FileInputStream r14 = new FileInputStream(r10);     // Catch: Throwable -> L15
        int r15 = r14.available();     // Catch: Throwable -> L13
        byte[] r16 = new byte[r15];     // Catch: Throwable -> L13
        r14.read(r16);     // Catch: Throwable -> L13
        r14.close();
        BitmapFactory.Options r17 = new BitmapFactory.Options();
        r17.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(r16, 0, r15, r17);
        int r18 = r17.outWidth;
        int r19 = r17.outHeight;
        if (r18 > r11) goto L11;
        if (r19 > r12) goto L11;
        return BitmapFactory.decodeByteArray(r16, 0, r15);
    L11:
        int r20 = u(r11, r12, r18, r19);
        int r21 = u(r12, r11, r19, r18);
        r17.inJustDecodeBounds = false;
        r17.inSampleSize = n(r18, r19, r20, r21);
        return BitmapFactory.decodeByteArray(r16, 0, r15, r17);
    L13:
        th = th;
        r13 = r14;
    L16:
        if (r13 == null) goto L18;
        r13.close();
    L18:
        throw th;
    L15:
        th = th;
        goto L16
    }

    public void l() {
        w3.c.b(new a(this));
    }

    public final void m(File r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isFile() == false) goto L8;
        r10.delete();
        return;
    L8:
        File[] r11 = r10.listFiles();
        if (r11 != null) goto L11;
    L20:
        r10.delete();
        return;
    L11:
        if (r11.length == 0) goto L20;
        int r12 = r11.length;
        int r13 = 0;
    L14:
        if (r13 >= r12) goto L19;
        File r14 = r11[r13];
        if (r14.isDirectory() == false) goto L18;
        m(r14);
    L18:
        r14.delete();
        r13 = r13 + 1;
        goto L14
    }

    public final int n(int r10, int r11, int r12, int r13) {
        double r14 = Math.min(((double) r10) / ((double) r12), ((double) r11) / ((double) r13));
        int r15 = 1;
    L3:
        int r16 = r15 * 2;
        if (r16 > r14) goto L6;
        r15 = r16;
        goto L3
    L6:
        return r15;
    }

    public int o(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L13;
        return -1;
    L13:
        JSONObject r11 = new JSONObject(r10).optJSONObject(ServerElements.HEAD);     // Catch: JSONException -> L10
        if (r11 != null) goto L8;
        return -1;
    L8:
        return r11.optInt(ServerElements.CODE);
    L10:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public final File p() {
        File r10 = new File(BaseApplication.c().getExternalFilesDir(null), "/feedback/");
        if (r10.exists() == true) goto L5;
        r10.mkdirs();
    L5:
        return r10;
    }

    public final String q(File r10) {
        FileInputStream r11 = new FileInputStream(r10);     // Catch: Throwable -> L14 IOException -> L16
        byte[] r12 = new byte[r11.available()];     // Catch: Throwable -> L10 IOException -> L12
        r11.read(r12);     // Catch: Throwable -> L10 IOException -> L12
        String r13 = Base64.encodeToString(r12, 0);     // Catch: Throwable -> L10 IOException -> L12
        r11.close();     // Catch: IOException -> L7
    L9:
        return r13;
    L7:
        e = move-exception;
        e.printStackTrace();
    L12:
        IOException e10 = e;
    L18:
        e10.printStackTrace();     // Catch: Throwable -> L10
        if (r11 == null) goto L43;
        r11.close();     // Catch: IOException -> L22
        return "-1";
    L22:
        e = move-exception;
        e.printStackTrace();
        return "-1";
    L43:
        return "-1";
    L10:
        Throwable th = th;
    L26:
        if (r11 != null) goto L38;
    L31:
        throw th;
    L38:
        r11.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L16:
        e = move-exception;
        r11 = null;
        e10 = e;
    L14:
        th = move-exception;
        r11 = null;
        th = th;
        goto L26
    }

    public final int r(String r10) {
        ExifInterface r11 = new ExifInterface(r10);     // Catch: IOException -> L4
    L7:
        if (r11 == null) goto L21;
        int r12 = r11.getAttributeInt("Orientation", 0);
        if (r12 != 3) goto L11;
        return AnimationConstants.DURATION_180;
    L11:
        if (r12 != 6) goto L13;
        return 90;
    L13:
        if (r12 != 8) goto L24;
        return 270;
    L24:
        return 0;
    L21:
        return 0;
    L4:
        e = move-exception;
        e.printStackTrace();
        r11 = null;
        goto L7
    }

    public final String t(String r10) {
        String r11 = r10.toLowerCase();
        if (r11.endsWith(".png") == false) goto L7;
        return "image/png";
    L7:
        if (r11.endsWith(".jpeg") == false) goto L10;
        return "image/jpeg";
    L10:
        return "image/jpg";
    }

    public final File v(String r10, String r11) {
        File r12 = new File(this.f10170e, r10);
        if (r12.exists() == true) goto L5;
        r12.mkdir();
    L5:
        String r13 = r11.toLowerCase();
        if (r13.endsWith(".png") == false) goto L9;
        r11 = r11.substring(0, r13.lastIndexOf(".png")) + ".jpeg";
    L9:
        return new File(r12, r11);
    }

    public JSONArray w(String r10) {
        File[] r11 = new File(this.f10170e, r10).listFiles();
        JSONArray r12 = new JSONArray();
        if (r11 != null) goto L5;
    L11:
        com.bytedanceos.common.toolbox.j.a("no upload Images ");
        return r12;
    L5:
        if (r11.length == 0) goto L11;
        int r13 = r11.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L10;
        File r15 = r11[r14];
        JSONObject r16 = new JSONObject();
        String r17 = r15.getName();
        r16.put("name", r17);
        r16.put("type", t(r17));
        r16.put("size", r15.length());
        r16.put(ServerElements.INFO, q(r15));
        r12.put(r16);
        r14 = r14 + 1;
        goto L8
    L10:
        return r12;
    }

    public void y(int r10, Uri r11, String r12, ImageView r13) {
        if (r11 == null) goto L7;
        if (r13 == null) goto L8;
        this.f10171f[r10] = new b(this, r13);
        this.f10171f[r10].execute(new Object[]{r11, r12});
        return;
    L8:
        return;
    }

    public final Bitmap z(Bitmap r10, int r11) {
        Matrix r12 = new Matrix();
        r12.postRotate(r11);
        return Bitmap.createBitmap(r10, 0, 0, r10.getWidth(), r10.getHeight(), r12, true);
    }
}
