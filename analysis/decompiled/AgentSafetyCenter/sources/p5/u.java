package p5;

import android.database.Cursor;
import android.os.RemoteException;
import androidx.room.x;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.crypto.tink.StreamingAead;
import com.stepos.statsrpk.IRpkStatsInterface;
import ie.o0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.VarHandle;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import k0.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u implements ie.f, t0.k {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9806c;

    /* renamed from: f, reason: collision with root package name */
    public Object f9807f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9808g;

    public u(Object obj) {
        this.f9806c = 9;
        this.f9807f = z.v(Boolean.FALSE);
        this.f9808g = z.v(obj);
        z.v(obj);
    }

    @Override // t0.k
    public Object a(t0.b bVar, Object obj) {
        return ((xb.p) this.f9807f).invoke(bVar, obj);
    }

    @Override // t0.k
    public Object b(Object obj) {
        return ((xb.l) this.f9808g).invoke(obj);
    }

    public void c(com.stepos.statsrpk.a aVar, com.stepos.statsrpk.b bVar) {
        ua.c.a("RpkEmitter", "rpk track: " + aVar + "," + bVar);
        IRpkStatsInterface iRpkStatsInterface = (IRpkStatsInterface) this.f9808g;
        if (iRpkStatsInterface != null) {
            try {
                iRpkStatsInterface.track(aVar, bVar);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
    }

    public ArrayList d(String str) {
        x xVarD = x.d(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        xVarD.h(1, str);
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f9807f;
        workDatabase_Impl.b();
        Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, false);
        try {
            ArrayList arrayList = new ArrayList(cursorD.getCount());
            while (cursorD.moveToNext()) {
                arrayList.add(cursorD.getString(0));
            }
            return arrayList;
        } finally {
            cursorD.close();
            xVarD.e();
        }
    }

    public w4.b e() throws FileNotFoundException {
        File file = (File) this.f9807f;
        if (!file.exists()) {
            throw new FileNotFoundException("file doesn't exist: " + file.getName());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStream inputStreamNewDecryptingStream = ((StreamingAead) this.f9808g).newDecryptingStream(fileInputStream, file.getName().getBytes(StandardCharsets.UTF_8));
        w4.b bVar = new w4.b(fileInputStream.getFD());
        bVar.f15216f = new Object();
        bVar.f15215c = inputStreamNewDecryptingStream;
        VarHandle.storeStoreFence();
        return bVar;
    }

    public w4.c f() throws IOException {
        File file = (File) this.f9807f;
        if (file.exists()) {
            od.f.n(file.getName(), "output file already exists, please use a new file: ");
            return null;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStream outputStreamNewEncryptingStream = ((StreamingAead) this.f9808g).newEncryptingStream(fileOutputStream, file.getName().getBytes(StandardCharsets.UTF_8));
        w4.c cVar = new w4.c(fileOutputStream.getFD());
        cVar.f15217c = outputStreamNewEncryptingStream;
        VarHandle.storeStoreFence();
        return cVar;
    }

    @Override // ie.f
    public void l(ie.c cVar, o0 o0Var) {
        Executor executor = ((ie.m) this.f9808g).f6017c;
        ie.f fVar = (ie.f) this.f9807f;
        a4.l lVar = new a4.l(6);
        lVar.f185f = this;
        lVar.f186g = fVar;
        lVar.f187h = o0Var;
        VarHandle.storeStoreFence();
        executor.execute(lVar);
    }

    @Override // ie.f
    public void t(ie.c cVar, Throwable th) {
        Executor executor = ((ie.m) this.f9808g).f6017c;
        ie.f fVar = (ie.f) this.f9807f;
        a4.l lVar = new a4.l(7);
        lVar.f185f = this;
        lVar.f186g = fVar;
        lVar.f187h = th;
        VarHandle.storeStoreFence();
        executor.execute(lVar);
    }

    public String toString() {
        switch (this.f9806c) {
            case 7:
                return "Bounds{lower=" + ((f3.b) this.f9807f) + " upper=" + ((f3.b) this.f9808g) + "}";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ u(int i, Object obj, Object obj2) {
        this.f9806c = i;
        this.f9807f = obj;
        this.f9808g = obj2;
    }

    public /* synthetic */ u(int i) {
        this.f9806c = i;
    }
}
