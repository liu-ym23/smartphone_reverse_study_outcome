package com.bytedance.android.live.broadcastgame.opengame.control.report;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedance.android.live.broadcastgame.opengame.network.GameReportApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.retrofit2.mime.MultipartTypedOutput;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public final class ReportPicUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LruCache<String, byte[]> f59913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f59914b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, a> f59915c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f59916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile String f59917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f59918f = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f59919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f59920b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f59919a, r101.f59919a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f59920b, r101.f59920b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f59919a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f59920b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ViolateBlackData(reason=" + this.f59919a + ", gameCategory=" + this.f59920b + ")";
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            Intrinsics.checkNotNullParameter(r101, "gameCategory");
            this.f59919a = r100;
            this.f59920b = r101;
        }
    }

    public static final class b<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f59921a;

        public b(Bitmap r100) {
            this.f59921a = r100;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            ByteArrayOutputStream r101 = new ByteArrayOutputStream();
            this.f59921a.compress(Bitmap.CompressFormat.JPEG, 80, r101);
            byte[] r102 = r101.toByteArray();
            String r103 = DigestUtils.md5Hex(r102);
            LruCache<String, byte[]> r104 = ReportPicUploader.f59913a;
            ReportPicUploader.f59917e = r103;
            String r105 = ReportPicUploader.f59918f;
            ALogger.i(r105, "videoBitmapShotWhenReport before insert cache all md5 = " + ReportPicUploader.a(ReportPicUploader.d()));
            ALogger.i(r105, "videoBitmapShotWhenReport md5 = " + r103);
            ReportPicUploader.d().put(r103, r102);
            ALogger.i(r105, "videoBitmapShotWhenReport after insert cache all md5 =" + ReportPicUploader.a(ReportPicUploader.d()));
            this.f59921a.recycle();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f59922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f59923b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f59924c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f59925d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f59926e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f59927f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f59928g;

        public c(HashMap r100, Map.Entry r101, AtomicInteger r102, String r103, String r104, String r105, String r106) {
            this.f59922a = r100;
            this.f59923b = r101;
            this.f59924c = r102;
            this.f59925d = r103;
            this.f59926e = r104;
            this.f59927f = r105;
            this.f59928g = r106;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f59922a.put(this.f59923b.getKey(), ((o0) r100).oid);
            this.f59924c.getAndDecrement();
            if (this.f59924c.get() != 0) goto L6;
            LruCache<String, byte[]> r101 = ReportPicUploader.f59913a;
            ReportPicUploader.b(this.f59925d, this.f59926e, this.f59927f, this.f59922a, this.f59928g);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f59929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f59930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f59931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f59932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ HashMap f59933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f59934f;

        public d(AtomicInteger r100, String r101, String r102, String r103, HashMap r104, String r105) {
            this.f59929a = r100;
            this.f59930b = r101;
            this.f59931c = r102;
            this.f59932d = r103;
            this.f59933e = r104;
            this.f59934f = r105;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f59929a.getAndDecrement();
            if (this.f59929a.get() != 0) goto L6;
            LruCache<String, byte[]> r102 = ReportPicUploader.f59913a;
            ReportPicUploader.b(this.f59930b, this.f59931c, this.f59932d, this.f59933e, this.f59934f);
            return;
        }
    }

    public ReportPicUploader() {
    }

    public static HashMap d() {
        return (HashMap) f59914b.getValue();
    }

    static {
        f59913a = new LruCache(5);
        f59914b = LazyKt.lazy(ReportPicUploader$uploadMap$2.INSTANCE);
        f59915c = new HashMap();
        f59916d = "";
        f59917e = "";
        f59918f = "Upload";
    }

    public static final String a(Map r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.append((String) ((Map.Entry) r102.next()).getKey());
        r101.append(",");
        goto L4
    L7:
        if (r101.length() <= 0) goto L10;
        r101.deleteCharAt(r101.length() - 1);
    L10:
        return r101.toString();
    }

    public static void c(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        d().remove(f59917e);
        f59917e = "";
        Observable.create(new b(r100)).subscribeOn(Schedulers.io()).subscribe();
    }

    public static void e(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "reportId");
        Intrinsics.checkNotNullParameter(r111, "roomId");
        HashMap r100 = new HashMap();
        r100.putAll(d());
        String r112 = f59916d;
        String r113 = f59917e;
        AtomicInteger r114 = new AtomicInteger(r100.size());
        HashMap r115 = new HashMap();
        Iterator r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r102 = (Map.Entry) r101.next();
        MultipartTypedOutput r103 = new MultipartTypedOutput();
        r103.addPart("data", new TypedByteArray("image/jpeg", (byte[]) r102.getValue(), new String[]{System.currentTimeMillis() + ".jpg"}));
        Lazy r104 = LiveOpenGameClient.f60290d;
        ((GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class)).uploadImg(r103).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r115, r102, r114, r110, r112, r113, r111), new d(r114, r110, r112, r113, r115, r111));
        r101 = r101;
        goto L4
    }

    public static final void b(String r100, String r101, String r102, HashMap r103, String r104) {
        if (r103.isEmpty() == true) goto L26;
        JSONArray r105 = new JSONArray();
        JSONArray r106 = new JSONArray();
        Iterator r107 = r103.entrySet().iterator();
    L7:
        if (r107.hasNext() == false) goto L15;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (Intrinsics.areEqual(r101, (String) r108.getKey()) == true) goto L10;
        if (Intrinsics.areEqual(r102, (String) r108.getKey()) == true) goto L13;
        r105.put(r108.getValue());
        goto L7
    L13:
        r106.put(r108.getValue());
        goto L7
    L10:
        r106.put(r108.getValue());
        r105.put(r108.getValue());
        goto L7
    L15:
        Lazy r109 = LiveOpenGameClient.f60290d;
        ((GameReportApi) LiveOpenGameClient.a.a().a(GameReportApi.class)).submitReportExtraInfoRequest(r100, r105.toString(), r106.toString(), r104).subscribe(com.bytedance.android.live.broadcastgame.opengame.control.report.a.f59950a, com.bytedance.android.live.broadcastgame.opengame.control.report.b.f59951a);
        return;
    }
}
