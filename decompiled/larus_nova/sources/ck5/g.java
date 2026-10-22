package ck5;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.notification.bean.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements Callable<List<Notification>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f24035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f24036b;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Notification> call2() throws Exception {
        Cursor r100 = DBUtil.query(this.f24036b.f24037a, this.f24035a, false, null);
        int r101 = CursorUtil.getColumnIndexOrThrow(r100, "id");     // Catch: Throwable -> L14
        int r102 = CursorUtil.getColumnIndexOrThrow(r100, ILoadStallMonitor.START_TIME);     // Catch: Throwable -> L14
        int r103 = CursorUtil.getColumnIndexOrThrow(r100, "end_time");     // Catch: Throwable -> L14
        int r104 = CursorUtil.getColumnIndexOrThrow(r100, "content");     // Catch: Throwable -> L14
        int r105 = CursorUtil.getColumnIndexOrThrow(r100, "product");     // Catch: Throwable -> L14
        int r106 = CursorUtil.getColumnIndexOrThrow(r100, "close");     // Catch: Throwable -> L14
        ArrayList r107 = new ArrayList(r100.getCount());     // Catch: Throwable -> L14
    L5:
        if (r100.moveToNext() == false) goto L12;
        Notification r108 = new Notification();     // Catch: Throwable -> L14
        r108.setId(r100.getString(r101));     // Catch: Throwable -> L14
        r108.setStart_time(r100.getLong(r102));     // Catch: Throwable -> L14
        r108.setEnd_time(r100.getLong(r103));     // Catch: Throwable -> L14
        String r110 = r100.getString(r104);     // Catch: Throwable -> L14
        this.f24036b.f24039c.getClass();     // Catch: Throwable -> L14
        r108.setContent((Notification.ContentBean) JSON.parseObject(r110, Notification.ContentBean.class));     // Catch: Throwable -> L14
        String r111 = r100.getString(r105);     // Catch: Throwable -> L14
        this.f24036b.f24039c.getClass();     // Catch: Throwable -> L14
        r108.setProducts((List) JSON.parseObject(r111, new a.C0456a().getType(), new Feature[0]));     // Catch: Throwable -> L14
        if (r100.getInt(r106) == 0) goto L9;
        boolean r112 = true;
    L10:
        r108.setClose(r112);     // Catch: Throwable -> L14
        r107.add(r108);     // Catch: Throwable -> L14
        goto L5
    L9:
        r112 = false;
        goto L10
    L12:
        r100.close();
        return r107;
    L14:
        th = move-exception;
        r100.close();
        throw th;
    }

    public final void finalize() {
        this.f24035a.release();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Notification> call() throws Exception {
        return call2();
    }

    public g(h r100, RoomSQLiteQuery r101) {
        this.f24036b = r100;
        this.f24035a = r101;
    }
}
