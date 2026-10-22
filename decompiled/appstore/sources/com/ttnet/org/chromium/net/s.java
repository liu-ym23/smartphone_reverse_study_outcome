package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.ApplicationStatus;

/* JADX INFO: loaded from: classes4.dex */
public class s extends NetworkChangeNotifierAutoDetect.f implements ApplicationStatus.ApplicationStateListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18955b;

    public s() {
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.f
    public void a() {
        if (this.f18955b == false) goto L5;
        return;
    L5:
        ApplicationStatus.e(this);
        this.f18955b = true;
    }

    @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.f
    public void b(NetworkChangeNotifierAutoDetect r10) {
        super.b(r10);
        ApplicationStatus.d(this);
        onApplicationStateChange(0);
    }

    @Override // com.ttnet.org.chromium.base.ApplicationStatus.ApplicationStateListener
    public void onApplicationStateChange(int r10) {
        if (ApplicationStatus.hasVisibleActivities() == false) goto L5;
        c();
        return;
    L5:
        d();
    }
}
