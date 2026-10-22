package com.obric.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.contactsdk.loader.ContractKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallContactInfoUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u00072$\u0010\u000e\u001a \u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00100\u000fR*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00070\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/obric/utils/CallContactInfoUtils;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", ContractKt.PARAM_ACTION_DOMAIN_CONTACTS, "", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getContext", "()Landroid/content/Context;", "getContact", "phoneNumber", "callback", "Lkotlin/Function3;", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallContactInfoUtils {
    private final Map<String, Pair<ContactEntity, String>> contacts;
    private final Context context;

    public CallContactInfoUtils(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.contacts = new LinkedHashMap();
    }

    public static final /* synthetic */ Map access$getContacts$p(CallContactInfoUtils r0) {
        return r0.contacts;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Object getContact(final String r6, final Function3<? super ContactEntity, ? super String, Object, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "phoneNumber");
        Intrinsics.checkNotNullParameter(r7, "callback");
        boolean r1 = true;
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        r7.invoke(null, null, null);
        return null;
    L10:
        Pair<ContactEntity, String> r2 = this.contacts.get(r6);
        if (r2 == null) goto L13;
        ContactEntity r4 = r2.getFirst();
    L14:
        if (r4 != null) goto L28;
        if (r2 == null) goto L17;
        String r5 = r2.getSecond();
    L18:
        String r8 = r5;
        if (r8 != null) goto L21;
    L24:
        if (r1 == false) goto L28;
        Context r3 = this.context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context.applicationContext");
        FindContactEntityTask r9 = new FindContactEntityTask(r3, r6, new AnonymousClass1(this, r6, r7));
        r9.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Unit[0]);
        return r9;
    L21:
        if (r8.length() == 0) goto L24;
        r1 = false;
        goto L24
    L17:
        r5 = null;
    L28:
        if (r2 == null) goto L30;
        ContactEntity r10 = r2.getFirst();
    L31:
        if (r2 == null) goto L33;
        String r11 = r2.getSecond();
    L34:
        r7.invoke(r10, r11, null);
        return null;
    L33:
        r11 = null;
        goto L34
    L30:
        r10 = null;
        goto L31
    L13:
        r4 = null;
        goto L14
    L5:
        r0 = false;
        goto L7
    }
}
