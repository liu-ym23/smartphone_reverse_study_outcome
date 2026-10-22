package com.stepos.ailauncher.floatcard;

import E4.FloatCardRequest;
import E4.p;
import E4.q;
import android.content.Context;
import com.stepos.ailauncher.floatcard.api.IFloatCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/floatcard/a;", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardProvider;", "<init>", "()V", "Landroid/content/Context;", "context", "LE4/k;", "request", "LE4/q;", "dispatcher", "LE4/p;", "createCard", "(Landroid/content/Context;LE4/k;LE4/q;)LE4/p;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements IFloatCardProvider {
    private final String type = "common_form";

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardProvider
    public p createCard(Context context, FloatCardRequest request, q dispatcher) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(dispatcher, "dispatcher");
        return new com.stepos.agentframework.floatcard.view.p(context, request, dispatcher);
    }

    @Override // com.stepos.ailauncher.floatcard.api.IFloatCardProvider
    public String getType() {
        return this.type;
    }
}
