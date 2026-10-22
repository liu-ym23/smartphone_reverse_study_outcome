package Z0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f7096f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static a f7097g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7098a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<BroadcastReceiver, ArrayList<c>> f7099b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<c>> f7100c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f7101d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f7102e;

    /* renamed from: Z0.a$a, reason: collision with other inner class name */
    public class HandlerC0122a extends Handler {
        public HandlerC0122a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f7104a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f7105b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f7104a = intent;
            this.f7105b = arrayList;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f7106a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f7107b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f7108c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f7109d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f7106a = intentFilter;
            this.f7107b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("Receiver{");
            sb2.append(this.f7107b);
            sb2.append(" filter=");
            sb2.append(this.f7106a);
            if (this.f7109d) {
                sb2.append(" DEAD");
            }
            sb2.append("}");
            return sb2.toString();
        }
    }

    public a(Context context) {
        this.f7098a = context;
        this.f7102e = new HandlerC0122a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (f7096f) {
            try {
                if (f7097g == null) {
                    f7097g = new a(context.getApplicationContext());
                }
                aVar = f7097g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f7099b) {
                try {
                    size = this.f7101d.size();
                    if (size <= 0) {
                        return;
                    }
                    bVarArr = new b[size];
                    this.f7101d.toArray(bVarArr);
                    this.f7101d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i10 = 0; i10 < size; i10++) {
                b bVar = bVarArr[i10];
                int size2 = bVar.f7105b.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    c cVar = bVar.f7105b.get(i11);
                    if (!cVar.f7109d) {
                        cVar.f7107b.onReceive(this.f7098a, bVar.f7104a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f7099b) {
            try {
                c cVar = new c(intentFilter, broadcastReceiver);
                ArrayList<c> arrayList = this.f7099b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f7099b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(cVar);
                for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                    String action = intentFilter.getAction(i10);
                    ArrayList<c> arrayList2 = this.f7100c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f7100c.put(action, arrayList2);
                    }
                    arrayList2.add(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        String str;
        synchronized (this.f7099b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f7098a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z10 = (intent.getFlags() & 8) != 0;
                if (z10) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList<c> arrayList = this.f7100c.get(intent.getAction());
                if (arrayList != null) {
                    if (z10) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                    }
                    ArrayList arrayList2 = null;
                    int i10 = 0;
                    while (i10 < arrayList.size()) {
                        c cVar = arrayList.get(i10);
                        if (z10) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f7106a);
                        }
                        if (cVar.f7108c) {
                            if (z10) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            str = action;
                        } else {
                            int iMatch = cVar.f7106a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z10) {
                                    StringBuilder sb2 = new StringBuilder();
                                    str = action;
                                    sb2.append("  Filter matched!  match=0x");
                                    sb2.append(Integer.toHexString(iMatch));
                                    Log.v("LocalBroadcastManager", sb2.toString());
                                } else {
                                    str = action;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(cVar);
                                cVar.f7108c = true;
                            } else {
                                str = action;
                                if (z10) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : QueryAlgorithmBundle.KEY_CATEGORY));
                                }
                            }
                        }
                        i10++;
                        action = str;
                    }
                    if (arrayList2 != null) {
                        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                            ((c) arrayList2.get(i11)).f7108c = false;
                        }
                        this.f7101d.add(new b(intent, arrayList2));
                        if (!this.f7102e.hasMessages(1)) {
                            this.f7102e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f7099b) {
            try {
                ArrayList<c> arrayListRemove = this.f7099b.remove(broadcastReceiver);
                if (arrayListRemove == null) {
                    return;
                }
                for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                    c cVar = arrayListRemove.get(size);
                    cVar.f7109d = true;
                    for (int i10 = 0; i10 < cVar.f7106a.countActions(); i10++) {
                        String action = cVar.f7106a.getAction(i10);
                        ArrayList<c> arrayList = this.f7100c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f7107b == broadcastReceiver) {
                                    cVar2.f7109d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f7100c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
