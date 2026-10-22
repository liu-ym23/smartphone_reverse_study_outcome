package com.bytedance.android.gamecp.business.imagechoose;

import android.content.Context;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.bytedance.android.gamecp.common.utils.NetworkUtils;
import com.ss.bduploader.BDImageXInfo;
import com.ss.bduploader.BDImageXUploader;
import com.ss.bduploader.BDImageXUploaderListener;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BDImageXUploader f56100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f56101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f56102c;

    public static final class a implements BDImageXUploaderListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f56103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f56104b;

        public a(s r100, ObservableEmitter r101) {
            this.f56103a = r100;
            this.f56104b = r101;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final int imageXUploadCheckNetState(int r100, int r101) {
            boolean r102 = NetworkUtils.e(this.f56103a.f56102c);
            yr.b.b(4, "Together#ImagePickerProvider", "net state: " + (r102 ? 1 : 0));
            return r102 ? 1 : 0;
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onLog(int r100, int r101, String r102) {
            yr.b.b(4, "Together#ImagePickerProvider", "what = " + r100 + " code = " + r101 + " info = " + r102);
        }

        @Override // com.ss.bduploader.BDImageXUploaderListener
        public final void onNotify(int r100, long r101, BDImageXInfo r102) {
            if (r100 != 0) goto L4;
            ObservableEmitter r103 = this.f56104b;
            List r104 = this.f56103a.f56101b;
            ArrayList r105 = new ArrayList();
            Iterator<T> r106 = r104.iterator();
        L31:
            if (r106.hasNext() == false) goto L35;
            T r107 = r106.next();
            if (((i.b) r107).f56088c == false) goto L31;
            r105.add(r107);
            goto L31
        L35:
            r103.onNext(r105);
            this.f56104b.onComplete();
            return;
        L4:
            if (r100 == 2) goto L28;
            int r108 = -1;
            if (r100 != 6) goto L8;
            if (r102 == null) goto L17;
            r108 = r102.mFileIndex;
        L17:
            i.b r109 = (i.b) CollectionsKt.getOrNull(this.f56103a.f56101b, r108);
            if (r109 == null) goto L20;
            r109.f56088c = true;
        L20:
            i.b r110 = (i.b) CollectionsKt.getOrNull(this.f56103a.f56101b, r108);
            if (r110 == null) goto L44;
            w r111 = r110.f56086a;
            if (r111 == null) goto L45;
            if (r102 == null) goto L26;
            String r112 = r102.mImageTosKey;
        L27:
            r111.f51417g = r112;
            return;
        L26:
            r112 = null;
            goto L27
        L45:
            return;
        L44:
            return;
        L8:
            if (r100 != 7) goto L48;
            if (r102 == null) goto L12;
            r108 = r102.mFileIndex;
        L12:
            i.b r113 = (i.b) CollectionsKt.getOrNull(this.f56103a.f56101b, r108);
            if (r113 == null) goto L42;
            r113.f56088c = false;
            return;
        L42:
            return;
        L48:
            return;
        L28:
            yr.b.b(6, "Together#ImagePickerProvider", "upload error");
            this.f56104b.onError(new Throwable("upload error"));
        }
    }

    public s(BDImageXUploader r100, List r101, Context r102) {
        this.f56100a = r100;
        this.f56101b = r101;
        this.f56102c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<i.b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        BDImageXUploader r101 = this.f56100a;
        int r102 = this.f56101b.size();
        List r103 = this.f56101b;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(((i.b) r105.next()).f56087b.f530618b);
        goto L4
    L6:
        Object[] r106 = r104.toArray(new String[0]);
        if (r106 == null) goto L11;
        r101.setFilePath(r102, (String[]) r106);
        this.f56100a.setListener(new a(this, r100));
        this.f56100a.start();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
