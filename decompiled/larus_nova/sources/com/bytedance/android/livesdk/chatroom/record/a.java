package com.bytedance.android.livesdk.chatroom.record;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends PthreadAsyncTask<String, Void, String> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f108042j = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f108043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f108044i;

    static {
        f108042j = a.class.getSimpleName();
    }

    public a(WeakHandler r100) {
        this.f108043h = r100;
        this.f108044i = 2;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] r100) {
        String[] r101 = (String[]) r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.length >= 1) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r101[0]) == true) goto L51;
        Bitmap r102 = ThumbnailUtils.createVideoThumbnail(r101[0], 320);
        if (r102 == null) goto L52;
        String r103 = System.currentTimeMillis() + RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT;
        Context r104 = s1.getContext();
        String r105 = u.f108084a;
        if (r104 != null) goto L15;
    L14:
        String r106 = null;
    L19:
        if (r106 == null) goto L23;
        StringBuilder r107 = new StringBuilder();
        r107.append(r106);
        String r108 = File.separator;
        r107.append(r108);
        r107.append(DocCallbackImpl.KEY_THUMBNAIL);
        String r109 = r107.toString();
        if (u.b(r109) == false) goto L23;
        String r110 = r109 + r108 + r103;
    L25:
        if (r110 == null) goto L53;
        u.a(r102, r110);     // Catch: Throwable -> L32 IOException -> L34
    L29:
        if (r102.isRecycled() == true) goto L48;
        r102.recycle();
    L48:
        return r110;
    L34:
        e = move-exception;
        Logger.e(f108042j, e.toString());     // Catch: Throwable -> L32
        if (r102.isRecycled() == true) goto L49;
        r102.recycle();
        return null;
    L49:
        return null;
    L32:
        th = move-exception;
        if (r102.isRecycled() == true) goto L42;
        r102.recycle();
    L42:
        throw th;
    L53:
        return null;
    L23:
        r110 = null;
        goto L25
    L15:
        File r111 = r104.getExternalCacheDir();
        if (r111 == null) goto L14;
        r106 = r111.getAbsolutePath();
        goto L19
    L52:
        return null;
    L51:
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object r100) {
        Handler r101 = this.f108043h;
        int r102 = this.f108044i;
        r101.obtainMessage(r102, (String) r100).sendToTarget();
    }
}
