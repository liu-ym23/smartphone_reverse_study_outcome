package i5;

import android.database.Cursor;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import w7.e0;

/* loaded from: classes.dex */
public final class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g3.n f4642b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f4643c;

    public /* synthetic */ a(f fVar, g3.n nVar, int i2) {
        this.f4641a = i2;
        this.f4643c = fVar;
        this.f4642b = nVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Cursor cursorB0;
        switch (this.f4641a) {
            case 0:
                cursorB0 = a.a.b0((OfflineQueueDatabase_Impl) this.f4643c.f4653g, this.f4642b);
                try {
                    return cursorB0.moveToFirst() ? Integer.valueOf(cursorB0.getInt(0)) : 0;
                } finally {
                }
            case 1:
                cursorB0 = a.a.b0((OfflineQueueDatabase_Impl) this.f4643c.f4653g, this.f4642b);
                try {
                    return cursorB0.moveToFirst() ? Long.valueOf(cursorB0.getLong(0)) : 0L;
                } finally {
                }
            case 2:
                cursorB0 = a.a.b0((OfflineQueueDatabase_Impl) this.f4643c.f4653g, this.f4642b);
                try {
                    return cursorB0.moveToFirst() ? new g(cursorB0.getLong(e0.z(cursorB0, "id")), cursorB0.getString(e0.z(cursorB0, "frame_json")), cursorB0.getInt(e0.z(cursorB0, "size_bytes")), cursorB0.getLong(e0.z(cursorB0, "created_at")), cursorB0.getLong(e0.z(cursorB0, "ttl_expires_at")), cursorB0.getString(e0.z(cursorB0, "target_kind"))) : null;
                } finally {
                }
            case 3:
                cursorB0 = a.a.b0((OfflineQueueDatabase_Impl) this.f4643c.f4653g, this.f4642b);
                try {
                    int iZ = e0.z(cursorB0, "id");
                    int iZ2 = e0.z(cursorB0, "frame_json");
                    int iZ3 = e0.z(cursorB0, "size_bytes");
                    int iZ4 = e0.z(cursorB0, "created_at");
                    int iZ5 = e0.z(cursorB0, "ttl_expires_at");
                    int iZ6 = e0.z(cursorB0, "target_kind");
                    ArrayList arrayList = new ArrayList(cursorB0.getCount());
                    while (cursorB0.moveToNext()) {
                        arrayList.add(new g(cursorB0.getLong(iZ), cursorB0.getString(iZ2), cursorB0.getInt(iZ3), cursorB0.getLong(iZ4), cursorB0.getLong(iZ5), cursorB0.getString(iZ6)));
                    }
                    return arrayList;
                } finally {
                }
            default:
                cursorB0 = a.a.b0((OfflineQueueDatabase_Impl) this.f4643c.f4653g, this.f4642b);
                try {
                    int iZ7 = e0.z(cursorB0, "id");
                    int iZ8 = e0.z(cursorB0, "frame_json");
                    int iZ9 = e0.z(cursorB0, "size_bytes");
                    int iZ10 = e0.z(cursorB0, "created_at");
                    int iZ11 = e0.z(cursorB0, "ttl_expires_at");
                    int iZ12 = e0.z(cursorB0, "target_kind");
                    ArrayList arrayList2 = new ArrayList(cursorB0.getCount());
                    while (cursorB0.moveToNext()) {
                        arrayList2.add(new g(cursorB0.getLong(iZ7), cursorB0.getString(iZ8), cursorB0.getInt(iZ9), cursorB0.getLong(iZ10), cursorB0.getLong(iZ11), cursorB0.getString(iZ12)));
                    }
                    return arrayList2;
                } finally {
                }
        }
    }
}
