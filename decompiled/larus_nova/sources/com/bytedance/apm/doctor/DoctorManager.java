package com.bytedance.apm.doctor;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import f27.d;
import f27.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import xu3.e;

/* JADX INFO: loaded from: classes6.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ApmListener> f190540a;

    public interface ApmListener {
        void onDataEvent(int r100, String r101, JSONObject r102);

        void onEvent(String r100, String r101);
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f190541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f190543c;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = this.f190541a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((ApmListener) r100.next()).onEvent(this.f190542b, this.f190543c);
            goto L4
        }

        @Override // f27.g
        public final AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        public a(List r100, String r101, String r102) {
            this.f190541a = r100;
            this.f190542b = r101;
            this.f190543c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f190544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f190545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f190546c;

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r100 = JSONObjectProtectorUtils.getJSONObject(this.f190544a, "DATA_DOCTOR");     // Catch: Exception -> L8
            r100.put(this.f190545b, System.currentTimeMillis());     // Catch: Exception -> L8
            int r101 = r100.optInt("DATA_ID");     // Catch: Exception -> L8
            Iterator r102 = this.f190546c.iterator();     // Catch: Exception -> L8
        L4:
            if (r102.hasNext() == false) goto L13;
            ((ApmListener) r102.next()).onDataEvent(r101, this.f190545b, this.f190544a);     // Catch: Exception -> L8
        L13:
            return;
        }

        @Override // f27.g
        public final AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        public b(JSONObject r100, String r101, List r102) {
            this.f190544a = r100;
            this.f190545b = r101;
            this.f190546c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DoctorManager f190547a = null;

        static {
            f190547a = new DoctorManager();
        }
    }

    public DoctorManager() {
        this.f190540a = new ArrayList();
    }

    public static DoctorManager getInstance() {
        return c.f190547a;
    }

    public void registerApmListener(ApmListener r100) {
        if (r100 == null) goto L5;
        ((ArrayList) this.f190540a).add(r100);
        return;
    }

    public final void a(String r100, JSONObject r101) {
        if (e.b(this.f190540a) == true) goto L8;
        if (r101 == null) goto L9;
        ArrayList r102 = new ArrayList(this.f190540a);
        Object r103 = d.f475214f;
        d.a.f475222a.h(new b(r101, r100, r102));
        return;
    L9:
        return;
    }

    public final void b(String r100, String r101) {
        if (e.b(this.f190540a) == false) goto L5;
        return;
    L5:
        ArrayList r102 = new ArrayList(this.f190540a);
        Object r103 = d.f475214f;
        d.a.f475222a.h(new a(r102, r100, r101));
    }
}
