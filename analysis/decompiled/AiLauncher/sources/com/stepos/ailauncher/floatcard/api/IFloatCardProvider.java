package com.stepos.ailauncher.floatcard.api;

import E4.FloatCardRequest;
import E4.p;
import E4.q;
import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/floatcard/api/IFloatCardProvider;", "", "Landroid/content/Context;", "context", "LE4/k;", "request", "LE4/q;", "dispatcher", "LE4/p;", "createCard", "(Landroid/content/Context;LE4/k;LE4/q;)LE4/p;", "", "getType", "()Ljava/lang/String;", "type", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IFloatCardProvider {
    p createCard(Context context, FloatCardRequest request, q dispatcher);

    String getType();
}
