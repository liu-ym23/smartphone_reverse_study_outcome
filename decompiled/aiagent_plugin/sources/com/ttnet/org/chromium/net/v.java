package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.ApplicationStatus;

/* JADX INFO: compiled from: RegistrationPolicyApplicationStatus.java */
/* JADX INFO: loaded from: classes4.dex */
public class v extends NetworkChangeNotifierAutoDetect.d implements ApplicationStatus.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f38299b;

    public v() {
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.d
    public void a(NetworkChangeNotifierAutoDetect r1) {
        super.a(r1);
        ApplicationStatus.a(this);
        onApplicationStateChange(0);
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.d
    public void c() {
        if (this.f38299b == false) goto L5;
        return;
    L5:
        ApplicationStatus.b(this);
        this.f38299b = true;
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.c
    public void onApplicationStateChange(int r1) {
        if (ApplicationStatus.hasVisibleActivities() == false) goto L5;
        a();
        return;
    L5:
        b();
    }
}
