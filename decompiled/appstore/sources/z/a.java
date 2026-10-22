package z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f26250f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f26251g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f26252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f26253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f26254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f26255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f26256e;

    /* JADX INFO: renamed from: z.a$a, reason: collision with other inner class name */
    public class HandlerC0420a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f26257a;

        public HandlerC0420a(a r10, Looper r11) {
            this.f26257a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10.what == 1) goto L5;
            super.handleMessage(r10);
            return;
        L5:
            this.f26257a.a();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f26258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f26259b;

        public b(Intent r10, ArrayList r11) {
            this.f26258a = r10;
            this.f26259b = r11;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IntentFilter f26260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f26261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f26262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f26263d;

        public c(IntentFilter r10, BroadcastReceiver r11) {
            this.f26260a = r10;
            this.f26261b = r11;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder(128);
            r10.append("Receiver{");
            r10.append(this.f26261b);
            r10.append(" filter=");
            r10.append(this.f26260a);
            if (this.f26263d == false) goto L5;
            r10.append(" DEAD");
        L5:
            r10.append("}");
            return r10.toString();
        }
    }

    static {
        f26250f = new Object();
    }

    public a(Context r10) {
        this.f26253b = new HashMap();
        this.f26254c = new HashMap();
        this.f26255d = new ArrayList();
        this.f26252a = r10;
        this.f26256e = new HandlerC0420a(this, r10.getMainLooper());
    }

    public static a b(Context r10) {
        Object r11 = f26250f;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f26251g != null) goto L9;
        f26251g = new a(r10.getApplicationContext());     // Catch: Throwable -> L7
    L9:
        a r12 = f26251g;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    }

    public void a() {
    L2:
        HashMap r10 = this.f26253b;
        monitor-enter(r10);
        int r11 = this.f26255d.size();     // Catch: Throwable -> L8
        if (r11 <= 0) goto L6;
        b[] r12 = new b[r11];     // Catch: Throwable -> L8
        this.f26255d.toArray(r12);     // Catch: Throwable -> L8
        this.f26255d.clear();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        int r13 = 0;
    L13:
        if (r13 >= r11) goto L2;
        b r14 = r12[r13];
        int r15 = r14.f26259b.size();
        int r16 = 0;
    L15:
        if (r16 >= r15) goto L20;
        c r17 = (c) r14.f26259b.get(r16);
        if (r17.f26263d == true) goto L19;
        r17.f26261b.onReceive(this.f26252a, r14.f26258a);
    L19:
        r16 = r16 + 1;
        goto L15
    L20:
        r13 = r13 + 1;
        goto L13
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void c(BroadcastReceiver r10, IntentFilter r11) {
        HashMap r12 = this.f26253b;
        monitor-enter(r12);
        c r13 = new c(r11, r10);     // Catch: Throwable -> L7
        ArrayList r14 = (ArrayList) this.f26253b.get(r10);     // Catch: Throwable -> L7
        if (r14 != null) goto L9;
        r14 = new ArrayList(1);     // Catch: Throwable -> L7
        this.f26253b.put(r10, r14);     // Catch: Throwable -> L7
    L9:
        r14.add(r13);     // Catch: Throwable -> L7
        int r15 = 0;
    L11:
        if (r15 >= r11.countActions()) goto L16;
        String r16 = r11.getAction(r15);     // Catch: Throwable -> L7
        ArrayList r17 = (ArrayList) this.f26254c.get(r16);     // Catch: Throwable -> L7
        if (r17 != null) goto L15;
        r17 = new ArrayList(1);     // Catch: Throwable -> L7
        this.f26254c.put(r16, r17);     // Catch: Throwable -> L7
    L15:
        r17.add(r13);     // Catch: Throwable -> L7
        r15 = r15 + 1;     // Catch: Throwable -> L7
        goto L11
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean d(Intent r22) {
        HashMap r10 = this.f26253b;
        monitor-enter(r10);
        String r11 = r22.getAction();     // Catch: Throwable -> L10
        String r12 = r22.resolveTypeIfNeeded(this.f26252a.getContentResolver());     // Catch: Throwable -> L10
        Uri r13 = r22.getData();     // Catch: Throwable -> L10
        String r14 = r22.getScheme();     // Catch: Throwable -> L10
        Set<String> r15 = r22.getCategories();     // Catch: Throwable -> L10
        if ((r22.getFlags() & 8) == 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == false) goto L12;
        Log.v("LocalBroadcastManager", "Resolving type " + r12 + " scheme " + r14 + " of intent " + r22);     // Catch: Throwable -> L10
    L12:
        ArrayList r17 = (ArrayList) this.f26254c.get(r22.getAction());     // Catch: Throwable -> L10
        if (r17 == null) goto L63;
        if (r16 == false) goto L16;
        Log.v("LocalBroadcastManager", "Action list: " + r17);     // Catch: Throwable -> L10
    L16:
        ArrayList r18 = null;
        int r19 = 0;
    L18:
        if (r19 >= r17.size()) goto L52;
        c r20 = (c) r17.get(r19);     // Catch: Throwable -> L10
        if (r16 == false) goto L23;
        Log.v("LocalBroadcastManager", "Matching against filter " + r20.f26260a);     // Catch: Throwable -> L10
    L23:
        if (r20.f26262c == false) goto L27;
        if (r16 == false) goto L26;
        Log.v("LocalBroadcastManager", "  Filter's target already added");     // Catch: Throwable -> L10
    L26:
        int r110 = r19;
        ArrayList r111 = r17;
        String r112 = r11;
        String r21 = r12;
        ArrayList r113 = r18;
    L50:
        r18 = r113;
    L51:
        r19 = r110 + 1;     // Catch: Throwable -> L10
        r11 = r112;
        r17 = r111;
        r12 = r21;
        goto L18
    L27:
        r110 = r19;
        r112 = r11;
        r113 = r18;
        r111 = r17;
        r21 = r12;
        int r23 = r20.f26260a.match(r11, r12, r14, r13, r15, "LocalBroadcastManager");     // Catch: Throwable -> L10
        if (r23 < 0) goto L35;
        if (r16 == false) goto L31;
        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(r23));     // Catch: Throwable -> L10
    L31:
        if (r113 != null) goto L33;
        r18 = new ArrayList();     // Catch: Throwable -> L10
    L34:
        r18.add(r20);     // Catch: Throwable -> L10
        r20.f26262c = true;     // Catch: Throwable -> L10
        goto L51
    L33:
        r18 = r113;
        goto L34
    L35:
        if (r16 == false) goto L50;
        if (r23 != (-4)) goto L39;
        String r24 = "category";
    L49:
        Log.v("LocalBroadcastManager", "  Filter did not match: " + r24);     // Catch: Throwable -> L10
        goto L50
    L39:
        if (r23 != (-3)) goto L41;
        r24 = "action";
        goto L49
    L41:
        if (r23 != (-2)) goto L43;
        r24 = "data";
        goto L49
    L43:
        if (r23 == (-1)) goto L45;
        r24 = "unknown reason";
        goto L49
    L45:
        r24 = "type";
        goto L49
    L52:
        ArrayList r114 = r18;
        if (r114 == null) goto L63;
        int r25 = 0;
    L56:
        if (r25 >= r114.size()) goto L58;
        ((c) r114.get(r25)).f26262c = false;     // Catch: Throwable -> L10
        r25 = r25 + 1;     // Catch: Throwable -> L10
        goto L56
    L58:
        this.f26255d.add(new b(r22, r114));     // Catch: Throwable -> L10
        if (this.f26256e.hasMessages(1) == true) goto L61;
        this.f26256e.sendEmptyMessage(1);     // Catch: Throwable -> L10
    L61:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return true;
    L63:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return false;
    L7:
        r16 = false;
    L10:
        th = move-exception;
        throw th;
    }
}
