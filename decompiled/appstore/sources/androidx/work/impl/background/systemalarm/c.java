package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.i;
import androidx.work.impl.model.o;
import androidx.work.impl.model.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5468e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SystemAlarmDispatcher f5471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.work.impl.constraints.b f5472d;

    static {
        f5468e = i.i("ConstraintsCmdHandler");
    }

    public c(Context r10, int r11, SystemAlarmDispatcher r12) {
        this.f5469a = r10;
        this.f5470b = r11;
        this.f5471c = r12;
        this.f5472d = new androidx.work.impl.constraints.b(r12.f().p(), null);
    }

    public void a() {
        List<o> r10 = this.f5471c.f().q().L().getScheduledWork();
        ConstraintProxy.a(this.f5469a, r10);
        this.f5472d.replace(r10);
        ArrayList r11 = new ArrayList(r10.size());
        long r12 = System.currentTimeMillis();
        Iterator<o> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        o r14 = r13.next();
        String r15 = r14.f5670a;
        if (r12 < r14.c()) goto L4;
        if (r14.f() == false) goto L11;
        if (this.f5472d.a(r15) == false) goto L4;
    L11:
        r11.add(r14);
        goto L4
    L12:
        Iterator r16 = r11.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        o r17 = (o) r16.next();
        String r18 = r17.f5670a;
        Intent r19 = b.b(this.f5469a, q.a(r17));
        i.e().a(f5468e, "Creating a delay_met command for workSpec with id (" + r18 + ")");
        this.f5471c.e().getMainThreadExecutor().execute(new SystemAlarmDispatcher.b(this.f5471c, r19, this.f5470b));
        goto L14
    L16:
        this.f5472d.reset();
    }
}
