package com.obric.aiagent.privacy;

import d.x;

/* JADX INFO: compiled from: IPrivacyService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IPrivacyService {
    void clearAgree();

    boolean isAgreed();

    void markAgree();

    void registerAgreeListener(d.h.a.a<x> r1);

    void unregisterAgreeListener(d.h.a.a<x> r1);
}
