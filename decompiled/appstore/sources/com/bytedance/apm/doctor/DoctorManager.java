package com.bytedance.apm.doctor;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f6450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6451c;

    public interface ApmListener {
        void onDataEvent(int r10, String r11, JSONObject r12);

        void onEvent(String r10, String r11);
    }

    public class a implements TaskRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f6453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DoctorManager f6455d;

        public a(DoctorManager r10, List r11, String r12, String r13) {
            this.f6455d = r10;
            this.f6452a = r11;
            this.f6453b = r12;
            this.f6454c = r13;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return "doctor";
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = this.f6452a.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((ApmListener) r10.next()).onEvent(this.f6453b, this.f6454c);
            goto L4
        }
    }

    public class b implements TaskRunnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f6456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f6457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f6458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DoctorManager f6459d;

        public b(DoctorManager r10, JSONObject r11, String r12, List r13) {
            this.f6459d = r10;
            this.f6456a = r11;
            this.f6457b = r12;
            this.f6458c = r13;
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return "doctor";
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject r10 = this.f6456a.getJSONObject("DATA_DOCTOR");     // Catch: Exception -> L8
            r10.put(this.f6457b, System.currentTimeMillis());     // Catch: Exception -> L8
            int r11 = r10.optInt("DATA_ID");     // Catch: Exception -> L8
            Iterator r12 = this.f6458c.iterator();     // Catch: Exception -> L8
        L4:
            if (r12.hasNext() == false) goto L13;
            ((ApmListener) r12.next()).onDataEvent(r11, this.f6457b, this.f6456a);     // Catch: Exception -> L8
        L13:
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DoctorManager f6460a = null;

        static {
            f6460a = new DoctorManager(null);
        }

        public static /* synthetic */ DoctorManager a() {
            return f6460a;
        }
    }

    public /* synthetic */ DoctorManager(a r10) {
        this();
    }

    public static DoctorManager getInstance() {
        return c.a();
    }

    public void a(String r10, JSONObject r11) {
        if (ListUtils.b(this.f6450b) == true) goto L8;
        if (r11 == null) goto L9;
        ArrayList r12 = new ArrayList(this.f6450b);
        com.bytedance.monitor.util.thread.a.d().post(new b(this, r11, r10, r12));
        return;
    L9:
        return;
    }

    public void b(String r10, String r11) {
        if (ListUtils.b(this.f6450b) == false) goto L5;
        return;
    L5:
        ArrayList r12 = new ArrayList(this.f6450b);
        com.bytedance.monitor.util.thread.a.d().post(new a(this, r12, r10, r11));
    }

    public void registerApmListener(ApmListener r10) {
        if (r10 == null) goto L5;
        this.f6450b.add(r10);
        return;
    }

    public DoctorManager() {
        this.f6449a = "doctor";
        this.f6450b = new ArrayList();
        this.f6451c = false;
    }
}
