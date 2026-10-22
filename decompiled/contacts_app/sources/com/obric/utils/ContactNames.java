package com.obric.utils;

import android.content.Context;
import android.os.AsyncTask;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactNames.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u000e0\rR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/obric/utils/ContactNames;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contactNames", "", "", "getContext", "()Landroid/content/Context;", "getName", "phoneNumber", "callback", "Lkotlin/Function2;", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactNames {
    private final Map<String, String> contactNames;
    private final Context context;

    public ContactNames(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.contactNames = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getContactNames$p(ContactNames r0) {
        return r0.contactNames;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getName(final String r6, final Function2<? super String, Object, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "phoneNumber");
        Intrinsics.checkNotNullParameter(r7, "callback");
        boolean r1 = true;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        r7.invoke(r6, null);
        return null;
    L10:
        String r2 = this.contactNames.get(r6);
        if (r2 != null) goto L13;
    L18:
        r1 = false;
    L19:
        if (r1 == false) goto L22;
        r7.invoke(r2, null);
        return null;
    L22:
        Context r3 = this.context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");
        FindContactTask r4 = new FindContactTask(r3, r6, new AnonymousClass1(this, r6, r7));
        r4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Unit[0]);
        return r4;
    L13:
        if (r2.length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 != true) goto L18;
    L15:
        r5 = false;
        goto L16
    L5:
        r0 = false;
        goto L7
    }
}
