package com.bytedance.apm.doctor;

import com.bytedance.apm6.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DoctorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<ApmListener> f4570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4571c;

    public interface ApmListener {
        void onDataEvent(int r1, String r2, JSONObject r3);

        void onEvent(String r1, String r2);
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DoctorManager f4580a = null;

        static /* synthetic */ DoctorManager a() {
            return f4580a;
        }

        static {
            f4580a = new DoctorManager(null);
        }
    }

    /* synthetic */ DoctorManager(AnonymousClass1 r1) {
        this();
    }

    private DoctorManager() {
        this.f4569a = "doctor";
        this.f4570b = new ArrayList();
        this.f4571c = false;
    }

    public static DoctorManager getInstance() {
        return a.a();
    }

    public void registerApmListener(ApmListener r3) {
        ApmListener r4 = (ApmListener) ZeusTransformUtils.wrapperContextForParams(r3, ApmListener.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        this.f4570b.add(r4);
        return;
    }

    public void a(final String r4, final String r5) {
        if (f.a(this.f4570b) == false) goto L5;
        return;
    L5:
        final ArrayList r0 = new ArrayList(this.f4570b);
        com.bytedance.monitor.a.b.a.a().a(new AnonymousClass1(this, r0, r4, r5));
    }

    public void a(final String r4, final JSONObject r5) {
        if (f.a(this.f4570b) == true) goto L8;
        if (r5 == null) goto L9;
        final ArrayList r0 = new ArrayList(this.f4570b);
        com.bytedance.monitor.a.b.a.a().a(new AnonymousClass2(this, r5, r4, r0));
        return;
    L9:
        return;
    }
}
