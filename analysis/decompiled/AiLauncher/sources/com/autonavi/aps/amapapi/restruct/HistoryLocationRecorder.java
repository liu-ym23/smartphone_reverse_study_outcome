package com.autonavi.aps.amapapi.restruct;

import S1.a;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1568j1;
import com.amap.location.support.bean.wifi.AmapWifi;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HistoryLocationRecorder {

    /* renamed from: b, reason: collision with root package name */
    private File f18312b;

    /* renamed from: d, reason: collision with root package name */
    private Handler f18314d;

    /* renamed from: e, reason: collision with root package name */
    private String f18315e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18316f;

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<HistoryLocation> f18311a = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private boolean f18313c = false;

    /* renamed from: g, reason: collision with root package name */
    private Runnable f18317g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder.1
        @Override // java.lang.Runnable
        public void run() throws IOException {
            if (HistoryLocationRecorder.this.f18313c) {
                return;
            }
            if (HistoryLocationRecorder.this.f18316f) {
                HistoryLocationRecorder.c(HistoryLocationRecorder.this);
                HistoryLocationRecorder.this.f18316f = false;
            }
            if (HistoryLocationRecorder.this.f18314d != null) {
                HistoryLocationRecorder.this.f18314d.postDelayed(HistoryLocationRecorder.this.f18317g, 60000L);
            }
        }
    };

    public HistoryLocationRecorder(Context context, Handler handler) {
        this.f18315e = null;
        this.f18314d = handler;
        String path = context.getFilesDir().getPath();
        if (this.f18315e == null) {
            this.f18315e = Utils.getPackageNameMD5(context);
        }
        try {
            this.f18312b = new File(path, "hisloc");
        } catch (Throwable th) {
            a.b(th);
        }
        a();
        Handler handler2 = this.f18314d;
        if (handler2 != null) {
            handler2.removeCallbacks(this.f18317g);
            this.f18314d.postDelayed(this.f18317g, 60000L);
        }
    }

    public static void c(HistoryLocationRecorder historyLocationRecorder) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Iterator<HistoryLocation> it = historyLocationRecorder.f18311a.iterator();
        while (it.hasNext()) {
            try {
                sb2.append(C1568j1.g(Encrypt.aesEncrypt(it.next().toJson().getBytes("UTF-8"), historyLocationRecorder.f18315e)) + "\n");
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        String string = sb2.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Utils.writeStringToFile(historyLocationRecorder.f18312b, string, false);
    }

    public void addGpsLocation(HistoryLocation historyLocation) {
        addSysLocation(historyLocation, 1);
    }

    public void addLBSLocation(HistoryLocation historyLocation) {
        if (historyLocation != null && this.f18311a.size() > 0) {
            int i10 = historyLocation.locationType;
            if (i10 != 6 && i10 != 5) {
                if (this.f18311a.contains(historyLocation)) {
                    return;
                }
                if (this.f18311a.size() >= 10) {
                    this.f18311a.removeFirst();
                }
                this.f18311a.add(historyLocation);
                this.f18316f = true;
                return;
            }
            HistoryLocation last = this.f18311a.getLast();
            if (last.longitude == historyLocation.longitude && last.latitude == historyLocation.latitude && last.radius == historyLocation.radius) {
                return;
            }
            if (this.f18311a.size() >= 10) {
                this.f18311a.removeFirst();
            }
            this.f18311a.add(historyLocation);
            this.f18316f = true;
        }
    }

    public void addNetworkLocation(HistoryLocation historyLocation) {
        addSysLocation(historyLocation, 12);
    }

    public void addSysLocation(HistoryLocation historyLocation, int i10) {
        if (historyLocation == null) {
            return;
        }
        Iterator<HistoryLocation> it = this.f18311a.iterator();
        HistoryLocation historyLocation2 = null;
        int i11 = 0;
        HistoryLocation historyLocation3 = null;
        while (it.hasNext()) {
            HistoryLocation next = it.next();
            if (next.locationType == i10) {
                if (historyLocation3 == null) {
                    historyLocation3 = next;
                }
                i11++;
                historyLocation2 = next;
            }
        }
        if (historyLocation2 == null || historyLocation.time - historyLocation2.time >= 20000 || Utils.dist(new double[]{historyLocation.latitude, historyLocation.longitude, historyLocation2.latitude, historyLocation2.longitude}) >= 20.0f) {
            if (i11 >= 5) {
                this.f18311a.remove(historyLocation3);
            }
            if (this.f18311a.size() >= 10) {
                this.f18311a.removeFirst();
            }
            this.f18311a.add(historyLocation);
            this.f18316f = true;
        }
    }

    public void destroy(boolean z10) {
        if (!z10) {
            this.f18317g.run();
        }
        Handler handler = this.f18314d;
        if (handler != null) {
            handler.removeCallbacks(this.f18317g);
        }
        this.f18313c = true;
    }

    public List<HistoryLocation> produceContextContent(ArrayList<Cgi> arrayList, ArrayList<AmapWifi> arrayList2) {
        if (arrayList != null && arrayList.size() > 0 && arrayList2 != null && arrayList2.size() > 0 && (arrayList.size() >= 4 || arrayList2.size() >= 20)) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList3 = new ArrayList();
        Iterator<HistoryLocation> it = this.f18311a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            HistoryLocation next = it.next();
            if (jCurrentTimeMillis - next.time < 21600000000L) {
                arrayList3.add(next);
                i10++;
            }
            if (i10 == 10) {
                break;
            }
        }
        return arrayList3;
    }

    public void synToDisk() {
        Handler handler = this.f18314d;
        if (handler != null) {
            handler.removeCallbacks(this.f18317g);
        }
        this.f18317g.run();
    }

    private void a() {
        LinkedList<HistoryLocation> linkedList = this.f18311a;
        if (linkedList == null || linkedList.size() <= 0) {
            Iterator<String> it = Utils.readLines(this.f18312b).iterator();
            while (it.hasNext()) {
                try {
                    String str = new String(Encrypt.aesDecrypt(C1568j1.b(it.next()), this.f18315e), "UTF-8");
                    HistoryLocation historyLocation = new HistoryLocation();
                    historyLocation.transformLocation(new JSONObject(str));
                    this.f18311a.add(historyLocation);
                } catch (UnsupportedEncodingException e10) {
                    e10.printStackTrace();
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }
}
