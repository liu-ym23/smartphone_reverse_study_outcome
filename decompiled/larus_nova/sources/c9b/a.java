package c9b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import f06.b;
import f06.c;
import f06.d;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends PthreadAsyncTask<Object, Object, Bitmap> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ContactMobileBean f22911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<TextView> f22912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final WeakReference<ImageView> f22913j;

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] r110) {
        Intrinsics.checkNotNullParameter(r110, "objects");
        ContentResolver r100 = LarkContext.getApplication().getContentResolver();
        Uri r101 = UriProtector.parse(this.f22911h.getAvatarUri());
        String[] r111 = {"data15"};
        c r112 = new c();
        ByteArrayInputStream r113 = null;
        Object[] r114 = {r101, r111, null, null, null};
        b r115 = new b();
        d r102 = r112.b(240004, "android/content/ContentResolver", "query", r100, r114, "android.database.Cursor", r115);
        if (r102.f474982a == false) goto L5;
        r112.a(240004, "android/content/ContentResolver", "query", r100, r114, null, r115, false);
        Cursor r116 = (Cursor) r102.f474983b;
    L6:
        if (r116 == null) goto L20;
    L15:
        th = move-exception;
        r116.close();
        throw th;
    L9:
        if (r116.moveToFirst() == false) goto L13;
        byte[] r103 = r116.getBlob(0);     // Catch: Throwable -> L15
        if (r103 == null) goto L13;
        r113 = new ByteArrayInputStream(r103);     // Catch: Throwable -> L15
    L13:
        r116.close();
        return BitmapFactory.decodeStream(r113);
    L20:
        return null;
    L5:
        r116 = r100.query(r101, r111, null, null, null);
        r112.a(240004, "android/content/ContentResolver", "query", r100, r114, r116, r115, true);
        goto L6
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        super.onPostExecute(r101);
        if (this.f22913j.get() != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L9;
        ImageView r102 = this.f22913j.get();
        if (r102 == null) goto L14;
        r102.setVisibility(0);
        r102.setImageBitmap(r101);
        return;
    L14:
        return;
    L9:
        TextView r103 = this.f22912i.get();
        if (r103 == null) goto L16;
        r103.setVisibility(0);
        r103.setText(this.f22911h.getAvatarName());
        return;
    }

    public a(TextView r100, ImageView r101, ContactMobileBean r102) {
        Intrinsics.checkNotNullParameter(r100, "avatarTv");
        Intrinsics.checkNotNullParameter(r101, "avatarIv");
        Intrinsics.checkNotNullParameter(r102, "bean");
        this.f22911h = r102;
        r100.setVisibility(8);
        r101.setVisibility(8);
        this.f22912i = new WeakReference(r100);
        this.f22913j = new WeakReference(r101);
    }
}
