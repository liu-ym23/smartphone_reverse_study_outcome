package com.google.android.gms.common.api.internal;

import D2.InterfaceC0792d;
import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1662c;
import com.google.android.gms.common.internal.C1670k;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import s2.C5438a;

/* loaded from: classes2.dex */
public final class U implements InterfaceC0792d {

    /* renamed from: a, reason: collision with root package name */
    public final C1640f f19571a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19572b;

    /* renamed from: c, reason: collision with root package name */
    public final C1635b f19573c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19574d;

    /* renamed from: e, reason: collision with root package name */
    public final long f19575e;

    public U(C1640f c1640f, int i10, C1635b c1635b, long j10, long j11, String str, String str2) {
        this.f19571a = c1640f;
        this.f19572b = i10;
        this.f19573c = c1635b;
        this.f19574d = j10;
        this.f19575e = j11;
    }

    public static U b(C1640f c1640f, int i10, C1635b c1635b) {
        boolean methodTimingTelemetryEnabled;
        if (!c1640f.d()) {
            return null;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = C1670k.b().a();
        if (rootTelemetryConfigurationA == null) {
            methodTimingTelemetryEnabled = true;
        } else {
            if (!rootTelemetryConfigurationA.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            methodTimingTelemetryEnabled = rootTelemetryConfigurationA.getMethodTimingTelemetryEnabled();
            J jS = c1640f.s(c1635b);
            if (jS != null) {
                if (!(jS.t() instanceof AbstractC1662c)) {
                    return null;
                }
                AbstractC1662c abstractC1662c = (AbstractC1662c) jS.t();
                if (abstractC1662c.G() && !abstractC1662c.b()) {
                    ConnectionTelemetryConfiguration connectionTelemetryConfigurationC = c(jS, abstractC1662c, i10);
                    if (connectionTelemetryConfigurationC == null) {
                        return null;
                    }
                    jS.E();
                    methodTimingTelemetryEnabled = connectionTelemetryConfigurationC.getMethodTimingTelemetryEnabled();
                }
            }
        }
        return new U(c1640f, i10, c1635b, methodTimingTelemetryEnabled ? System.currentTimeMillis() : 0L, methodTimingTelemetryEnabled ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    public static ConnectionTelemetryConfiguration c(J j10, AbstractC1662c abstractC1662c, int i10) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration connectionTelemetryConfigurationE = abstractC1662c.E();
        if (connectionTelemetryConfigurationE == null || !connectionTelemetryConfigurationE.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = connectionTelemetryConfigurationE.getMethodInvocationMethodKeyAllowlist()) != null ? !C5438a.a(methodInvocationMethodKeyAllowlist, i10) : !((methodInvocationMethodKeyDisallowlist = connectionTelemetryConfigurationE.getMethodInvocationMethodKeyDisallowlist()) == null || !C5438a.a(methodInvocationMethodKeyDisallowlist, i10))) || j10.q() >= connectionTelemetryConfigurationE.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return connectionTelemetryConfigurationE;
    }

    @Override // D2.InterfaceC0792d
    public final void a(D2.i iVar) {
        J jS;
        int version;
        int i10;
        int i11;
        int errorCode;
        long j10;
        long j11;
        if (this.f19571a.d()) {
            RootTelemetryConfiguration rootTelemetryConfigurationA = C1670k.b().a();
            if ((rootTelemetryConfigurationA == null || rootTelemetryConfigurationA.getMethodInvocationTelemetryEnabled()) && (jS = this.f19571a.s(this.f19573c)) != null && (jS.t() instanceof AbstractC1662c)) {
                AbstractC1662c abstractC1662c = (AbstractC1662c) jS.t();
                int i12 = 0;
                boolean methodTimingTelemetryEnabled = this.f19574d > 0;
                int iW = abstractC1662c.w();
                int statusCode = 100;
                if (rootTelemetryConfigurationA != null) {
                    methodTimingTelemetryEnabled &= rootTelemetryConfigurationA.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = rootTelemetryConfigurationA.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = rootTelemetryConfigurationA.getMaxMethodInvocationsInBatch();
                    version = rootTelemetryConfigurationA.getVersion();
                    if (abstractC1662c.G() && !abstractC1662c.b()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationC = c(jS, abstractC1662c, this.f19572b);
                        if (connectionTelemetryConfigurationC == null) {
                            return;
                        }
                        boolean z10 = connectionTelemetryConfigurationC.getMethodTimingTelemetryEnabled() && this.f19574d > 0;
                        maxMethodInvocationsInBatch = connectionTelemetryConfigurationC.getMaxMethodInvocationsLogged();
                        methodTimingTelemetryEnabled = z10;
                    }
                    i11 = batchPeriodMillis;
                    i10 = maxMethodInvocationsInBatch;
                } else {
                    version = 0;
                    i10 = 100;
                    i11 = 5000;
                }
                C1640f c1640f = this.f19571a;
                int iElapsedRealtime = -1;
                if (iVar.l()) {
                    errorCode = 0;
                } else if (iVar.j()) {
                    i12 = statusCode;
                    errorCode = -1;
                } else {
                    Exception excH = iVar.h();
                    if (excH instanceof ApiException) {
                        Status statusA = ((ApiException) excH).a();
                        statusCode = statusA.getStatusCode();
                        ConnectionResult connectionResult = statusA.getConnectionResult();
                        if (connectionResult != null) {
                            errorCode = connectionResult.getErrorCode();
                            i12 = statusCode;
                        }
                        i12 = statusCode;
                        errorCode = -1;
                    } else {
                        i12 = 101;
                        errorCode = -1;
                    }
                }
                if (methodTimingTelemetryEnabled) {
                    long j12 = this.f19574d;
                    long j13 = this.f19575e;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j13);
                    j11 = jCurrentTimeMillis;
                    j10 = j12;
                } else {
                    j10 = 0;
                    j11 = 0;
                }
                c1640f.C(new MethodInvocation(this.f19572b, i12, errorCode, j10, j11, null, null, iW, iElapsedRealtime), version, i11, i10);
            }
        }
    }
}
