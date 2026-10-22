package com.bytedance.android.gamecp.business.comment.edit.upload;

import com.bytedance.android.gamecp.common.utils.NetworkUtils;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploaderListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import yr.c;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements BDImageXUploaderListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentImgUploadCenter.d f52193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f52194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f52195c;

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onLog(int r100, int r101, String r102) {
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final int imageXUploadCheckNetState(int r100, int r101) {
        return NetworkUtils.e(this.f52193a.f52190e) ? 1 : 0;
    }

    public a(CommentImgUploadCenter.d r100, List r101, ArrayList r102) {
        this.f52193a = r100;
        this.f52194b = r101;
        this.f52195c = r102;
    }

    @Override // com.ss.bduploader.BDImageXUploaderListener
    public final void onNotify(int r100, long r101, BDImageXInfo r102) {
        if (r100 == 0) goto L34;
        String r103 = null;
        int r104 = -1;
        if (r100 != 6) goto L6;
        if (r102 == null) goto L28;
        r104 = r102.mFileIndex;
    L28:
        CommentImgUploadCenter.b r105 = (CommentImgUploadCenter.b) CollectionsKt.getOrNull(this.f52194b, r104);
        if (r105 == null) goto L33;
        if (r102 == null) goto L32;
        r103 = r102.mImageTosKey;
    L32:
        r105.f52184c = r103;
    L33:
        CommentImgUploadCenter.a(this.f52193a.f52186a, r105);
        return;
    L6:
        if (r100 != 7) goto L39;
        CommentImgUploadCenter.d r106 = this.f52193a;
        r106.f52189d.element = true;
        if (r102 == null) goto L11;
        r104 = r102.mFileIndex;
    L11:
        CommentImgUploadCenter r107 = r106.f52186a;
        CommentImgUploadCenter.b r108 = (CommentImgUploadCenter.b) CollectionsKt.getOrNull(this.f52194b, r104);
        String r109 = CommentImgUploadCenter.f52177f;
        monitor-enter(r107);
        String r110 = CommentImgUploadCenter.f52177f;     // Catch: Throwable -> L23
        StringBuilder r111 = new StringBuilder("uploadImageFail ");     // Catch: Throwable -> L23
        if (r108 == null) goto L16;
        r103 = r108.f52182a;     // Catch: Throwable -> L23
    L16:
        r111.append(r103);     // Catch: Throwable -> L23
        c.e(r110, r111.toString());     // Catch: Throwable -> L23
        if (r108 != null) goto L20;
        monitor-exit(r107);
        return;
    L20:
        r107.f52178a.remove(r108.f52182a);     // Catch: Throwable -> L23
        monitor-exit(r107);
        return;
    L23:
        th = move-exception;
        throw th;
    L39:
        return;
    L34:
        CommentImgUploadCenter.d r112 = this.f52193a;
        CommentImgUploadCenter r113 = r112.f52186a;
        ArrayList r114 = this.f52195c;
        Function1<? super LinkedHashMap<String, String>, Unit> r115 = r112.f52187b;
        boolean r116 = r112.f52188c;
        String r117 = CommentImgUploadCenter.f52177f;
        r113.c(r114, r115, r116);
    }
}
