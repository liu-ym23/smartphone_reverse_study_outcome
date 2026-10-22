package org.slf4j.helpers;

import org.slf4j.Marker;

/* loaded from: classes5.dex */
public abstract class LegacyAbstractLogger extends AbstractLogger {
    @Override // vc.c
    public boolean g(Marker marker) {
        return isWarnEnabled();
    }

    @Override // vc.c
    public boolean h(Marker marker) {
        return isDebugEnabled();
    }

    @Override // vc.c
    public boolean v(Marker marker) {
        return isTraceEnabled();
    }

    @Override // vc.c
    public boolean w(Marker marker) {
        return isErrorEnabled();
    }

    @Override // vc.c
    public boolean z(Marker marker) {
        return isInfoEnabled();
    }
}
