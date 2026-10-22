package com.bytedance.applog.picker;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.bytedance.bdtracker.c0;
import com.bytedance.bdtracker.e0;
import com.bytedance.bdtracker.m3;
import com.bytedance.bdtracker.p3;
import com.bytedance.bdtracker.q3;
import com.bytedance.bdtracker.r;
import com.bytedance.bdtracker.r3;
import com.bytedance.bdtracker.u5;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DomSender extends c0 implements Handler.Callback, p3.b {
    public static final long[] q = {1000};
    public final Handler g;
    public final Handler h;
    public int i;
    public int j;
    public final Context k;
    public final String l;
    public final r3 m;
    public final String n;
    public final String o;
    public final p3 p;

    public static class a {
        public String a;
        public JSONArray b = new JSONArray();
        public int c;
        public int d;
    }

    public DomSender(e0 e0Var, String str) {
        super(e0Var);
        this.g = new Handler(Looper.getMainLooper(), this);
        HandlerThread handlerThread = new HandlerThread("dom_work");
        handlerThread.start();
        this.h = new Handler(handlerThread.getLooper(), this);
        this.m = new r3(this.f);
        this.p = new p3(this.f, this, Looper.myLooper());
        this.k = e0Var.b();
        this.l = e0Var.i.c.b();
        this.n = e0Var.i.n();
        String str2 = (String) this.f.getHeaderValue("resolution", null, String.class);
        if (r.d(str2)) {
            String[] strArrSplit = str2.split("x");
            this.j = Integer.parseInt(strArrSplit[0]);
            this.i = Integer.parseInt(strArrSplit[1]);
        }
        this.o = str;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.p.a();
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public String d() {
        return "d";
    }

    @Override // com.bytedance.bdtracker.c0
    public long[] e() {
        return q;
    }

    @Override // com.bytedance.bdtracker.c0
    public boolean g() {
        return true;
    }

    @Override // com.bytedance.bdtracker.c0
    public long h() {
        return 1000L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        JSONObject jSONObjectOptJSONObject;
        if (message.what == 1) {
            JSONObject jSONObjectA = this.m.a(this.f.k.a, this.l, this.n, this.o, (LinkedList) message.obj);
            if (jSONObjectA != null && (jSONObjectOptJSONObject = jSONObjectA.optJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA)) != null && !jSONObjectOptJSONObject.optBoolean("keep", true)) {
                String strOptString = jSONObjectA.optString("message");
                Message messageObtainMessage = this.g.obtainMessage();
                messageObtainMessage.obj = strOptString;
                this.g.sendMessage(messageObtainMessage);
                setStop(true);
            }
        } else {
            Toast.makeText(this.k, (String) message.obj, 0).show();
        }
        return true;
    }

    @Override // com.bytedance.bdtracker.p3.b
    public void onGetCircleInfoFinish(int i, JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() < 1) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        a aVar = new a();
        aVar.c = this.i;
        aVar.d = this.j;
        aVar.b = jSONArray;
        aVar.a = q3.a(i);
        linkedList.add(aVar);
        JSONObject jSONObjectA = this.m.a(this.f.k.a, this.l, this.n, this.o, linkedList);
        if (jSONObjectA == null || (jSONObjectOptJSONObject = jSONObjectA.optJSONObject(ExceptionManagerStepOS.USER_CONFIG_BUNDLE_DATA)) == null || jSONObjectOptJSONObject.optBoolean("keep", true)) {
            return;
        }
        String strOptString = jSONObjectA.optString("message");
        Message messageObtainMessage = this.g.obtainMessage();
        messageObtainMessage.obj = strOptString;
        this.g.sendMessage(messageObtainMessage);
        setStop(true);
    }

    @Override // com.bytedance.bdtracker.p3.b
    public void onGetCircleInfoFinish(Map<Integer, p3.a> map) {
        a aVar;
        if (map == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        a aVar2 = new a();
        aVar2.d = this.j;
        aVar2.c = this.i;
        linkedList.add(aVar2);
        for (Integer num : map.keySet()) {
            p3.a aVar3 = map.get(num);
            if (aVar3 != null && aVar3.a != null) {
                if (u5.a(this.f.n, num.intValue())) {
                    aVar = (a) linkedList.getFirst();
                } else {
                    aVar = new a();
                    try {
                        DisplayManager displayManager = (DisplayManager) this.k.getSystemService("display");
                        aVar.d = displayManager.getDisplay(num.intValue()).getHeight();
                        aVar.c = displayManager.getDisplay(num.intValue()).getWidth();
                    } catch (Throwable th) {
                        this.f.D.error(Collections.singletonList("DomSender"), "Get display pixels failed", th, new Object[0]);
                    }
                    linkedList.add(aVar);
                }
                m3 m3Var = aVar3.a;
                ArrayList arrayList = new ArrayList(aVar3.b);
                aVar3.b.clear();
                aVar.b = q3.a(m3Var, arrayList);
                aVar.a = q3.a(num.intValue());
            }
        }
        this.h.obtainMessage(1, linkedList).sendToTarget();
    }
}
