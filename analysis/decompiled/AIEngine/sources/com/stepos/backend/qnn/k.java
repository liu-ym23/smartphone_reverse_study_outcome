package com.stepos.backend.qnn;

import com.stepos.backend.qnn.QnnImageExtendModel;
import com.stepos.backend.qnn.QnnLLMModel;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6066a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6067b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6068c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6069d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Serializable f6070e;

    public /* synthetic */ k(String str, String str2, String str3, boolean z) {
        this.f6068c = str;
        this.f6069d = str2;
        this.f6070e = str3;
        this.f6067b = z;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f6066a) {
            case 0:
                return Integer.valueOf(QnnImageExtendModel.AnonymousClass2.invokeSuspend$lambda$0((String) this.f6068c, (String) this.f6069d, (String) this.f6070e, this.f6067b));
            default:
                return QnnLLMModel.C02491.invokeSuspend$lambda$10(this.f6067b, (ProducerScope) this.f6068c, (QnnLLMModel) this.f6069d, (Ref$IntRef) this.f6070e);
        }
    }

    public /* synthetic */ k(boolean z, ProducerScope producerScope, QnnLLMModel qnnLLMModel, Ref$IntRef ref$IntRef) {
        this.f6067b = z;
        this.f6068c = producerScope;
        this.f6069d = qnnLLMModel;
        this.f6070e = ref$IntRef;
    }
}
