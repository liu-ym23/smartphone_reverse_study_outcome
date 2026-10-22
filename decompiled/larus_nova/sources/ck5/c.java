package ck5;

import androidx.room.EntityInsertionAdapter;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends EntityInsertionAdapter<Notification> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f24034a;

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "INSERT OR REPLACE INTO `Notification` (`id`,`start_time`,`end_time`,`content`,`product`,`close`) VALUES (?,?,?,?,?,?)";
    }

    public c(h r100, NotificationDatabase r101) {
        this.f24034a = r100;
        super(r101);
    }

    @Override // androidx.room.EntityInsertionAdapter
    public final void bind(SupportSQLiteStatement r100, Notification r101) {
        Notification r102 = r101;
        if (r102.getId() != null) goto L5;
        r100.bindNull(1);
    L6:
        r100.bindLong(2, r102.getStart_time());
        r100.bindLong(3, r102.getEnd_time());
        a r103 = this.f24034a.f24039c;
        Notification.ContentBean r104 = r102.getContent();
        r103.getClass();
        String r105 = JSON.toJSONString(r104);
        if (r105 != null) goto L9;
        r100.bindNull(4);
    L10:
        a r106 = this.f24034a.f24039c;
        List<String> r107 = r102.getProducts();
        r106.getClass();
        String r108 = JSON.toJSONString(r107);
        if (r108 != null) goto L13;
        r100.bindNull(5);
    L14:
        r100.bindLong(6, r102.isClose() ? 1 : 0);
        return;
    L13:
        r100.bindString(5, r108);
        goto L14
    L9:
        r100.bindString(4, r105);
        goto L10
    L5:
        r100.bindString(1, r102.getId());
        goto L6
    }
}
